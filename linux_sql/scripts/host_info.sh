#!/bin/bash

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

hostname=$(hostname -f)
lscpu_out=$(lscpu)

cpu_number=$(echo "$lscpu_out" | awk '/CPU\(s\):/{print $2}' | head -n1 | xargs)
cpu_architecture=$(echo "$lscpu_out" | awk '/Architecture:/{print $2}' | xargs)
cpu_model=$(echo "$lscpu_out" | awk '/Model name:/{$1=$2=""; print $0}' | xargs)
cpu_mhz=$(echo "$lscpu_out" | awk '/CPU MHz:/{print $3}' | xargs)
l2_cache=$(echo "$lscpu_out" | awk '/L2 cache:/{print $3}' | sed 's/.$//' | xargs)
timestamp=$(echo "$(vmstat -t)" | awk '{print $18, $19}' | tail -n1 | xargs)
total_mem=$(echo "$(free -m)" | awk '/Mem:/{print $2}' | xargs)

insert_stmt="INSERT INTO host_info(hostname, cpu_number, cpu_architecture, cpu_model, cpu_mhz, l2_cache, timestamp, total_mem) VALUES('$hostname', '$cpu_number', '$cpu_architecture', '$cpu_model', '$cpu_mhz', '$l2_cache', '$timestamp', '$total_mem');"

# Set up env variables for psql cmd
export PGPASSWORD=$psql_password

psql -h "$psql_host" -p "$psql_port" -d "$db_name" -U "$psql_username" -c "$insert_stmt"
exit $?