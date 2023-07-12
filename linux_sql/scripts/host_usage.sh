#!/bin/bash

# Capture CLI Arguments
psql_host=$1
psql_port=$2
db_name=$3
psql_username=$4
psql_password=$5

# Check the number of arguments provided
if [ "$#" -ne 5 ]; then
  echo "Illegal number of parameters"
  exit 1
fi

# Save hardware stats in MB and current hardware hostname to variables
vmstat_mb=$(vmstat --unit M)
hostname=$(hostname -f)

# Get hardware specs and save them to variables
memory_free=$(echo "$vmstat_mb" | awk '{print $4}' | tail -n1 | xargs)
cpu_idle=$(echo "$vmstat_mb" | awk '{print $15}' | tail -n1 | xargs)
cpu_kernel=$(echo "$vmstat_mb" | awk '{print $14}' | tail -n1 | xargs)
disk_io=$(echo "$(vmstat -d)" | awk '{print $10}' | tail -n1 | xargs)
disk_available=$(echo "$(df -BM /)" | awk '{print $4}' | sed 's/.$//' | tail -n1 | xargs)

# Get timestamp
timestamp=$(vmstat -t | awk '{print $18, $19}' | tail -n1 | xargs)

# Set up env variables for psql cmd
export PGPASSWORD=$psql_password

# Subquery to find matching id in host_info table
host_id=$(psql -h "$psql_host" -p "$psql_port" -d "$db_name" -U "$psql_username" -t -c "SELECT id FROM host_info WHERE hostname='$hostname'")

# SQL command to insert server usage data to the host_usage table
insert_stmt="INSERT INTO host_usage(timestamp, host_id, memory_free, cpu_idle, cpu_kernel, disk_io, disk_available) VALUES('$timestamp', '$host_id', '$memory_free', '$cpu_idle', '$cpu_kernel', '$disk_io', '$disk_available');"

# Insert data into the database table host_usage
psql -h "$psql_host" -p "$psql_port" -d "$db_name" -U "$psql_username" -c "$insert_stmt"
exit $?