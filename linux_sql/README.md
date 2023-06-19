# Introduction
The Linux Clustering Monitoring Agent is a product designed to assist Administration Teams
with recording hardware specifications of hardware nodes/servers and tracking of resource usage in real-time.
The development of this product would provide Adminstration Teams better understanding of company resource usage
and if servers are required to be added or removed. The technologies used to develop this product are Bash scripts
to handle the recording of hardware specifications and resource usage, a PostgreSQL database to persist the
information recorded, Docker to manage dependencies and deployment of the PostgreSQL Database Software.
Git and Github were used for version control and Intellij IDEA for IDE purposes.

# Quick Start

#### psql_docker.sh
- Used to create docker container running psql database software and to run it for first time
```
scripts/psql_docker.sh create [db_username] [db_password]
```
- To start/stop the container after initial creation of container
```
scripts/psql_docker.sh start | stop
```

#### ddl.sql
- Used for the creation of tables related to hardware specification and resource usage records
```
psql -h localhost -U postgres -d host_agent -f sql/ddl.sql
```

#### host_info.sh
- Used for gathering system hardware specifications and storing in host_info table, only required to run once per system
```
scripts/host_info.sh [psql_host] [psql_port] [db_name] [psql_user] [psql_password]
```

#### host_usage.sh
- Used for gathering logs of system resource utilization and storing in host_usage table, will require setting up in crontab afterwards
```
scripts/host_usage.sh [psql_host] [psql_port] [db_name] [psql_user] [psql_password]
```

#### crontab
- A cron job will be required to be added crontab so that host_usage runs at certain intervals of time (1 minute option is provided)
```
* * * * * bash /-location of host_usage.sh file-/ [psql_host] [psql_port] [db_name] [psql_user] [psql_password] &> /tmp/host_usage.log
```

# Implementation
## Architecture
![Design of how monitoring agents would interact with the Database](./.assets/architecture.png)

## Scripts
`psql_docker.sh` was created so that there is a means of creating a database instance that can be interacted with to store records.

`host_info.sh` was created using shell scripting language to provide streamline instructions necessary
for gathering system hardware specifications.

`host_usage.sh` was created using shell scripting language to provide streamline instructions necessary
for gathering system hardware utilization.

`crontab` is used so that the script ``host_usage.sh`` runs automatically based on how often the user needs 
details of resource utilization to be recorded.

## Database Modeling
### host_info
- information related to the system's hardware specifications are inserted in the table once and should only have one
 unique record
- details recorded include system name, cpu specifications, memory amount, and time of when the record was inserted into 
the database

| id                                             | hostname                   | cpu_number       | cpu_architecture   | cpu_model          | cpu_mhz           | l2_cache        | timestamp            | total_mem       |
|------------------------------------------------|----------------------------|------------------|--------------------|--------------------|-------------------|-----------------|----------------------|-----------------|
| SERIAL (Auto Generated, NOT NULL, PRIMARY KEY) | VARCHAR (NOT NULL, UNIQUE) | INT2  (NOT NULL) | VARCHAR (NOT NULL) | VARCHAR (NOT NULL) | FLOAT8 (NOT NULL) | INT4 (NOT NULL) | TIMESTAMP (NOT NULL) | INT4 (NOT NULL) |

### host_usage
- information regarding system resource utilization can be inserted into the table multiple times depending on the needs of
 the user 
- details stored include idle/in-use % of the processor, memory usage, disk space usage and date/time of when the record 
was inserted into the database
- Requires that the system id has already been recorded in `host_info` first

| timestamp | host_id                                          | memory_free     | cpu_idle        | cpu_kernel      | disk_io         | disk_available  | 
|-----------|--------------------------------------------------|-----------------|-----------------|-----------------|-----------------|-----------------|
| NOT NULL  | SERIAL (NOT NULL, Primary key from Host_info id) | INT4 (NOT NULL) | INT2 (NOT NULL) | INT2 (NOT NULL) | INT4 (NOT NULL) | INT4 (NOT NULL) | 

# Testing
- Testing of Bash scripts was done manually by reviewing execution of code with bash -x flag, errors such as typos in commands or wrong number of arguments should be 
caught by the conditional statements. 
- DDL script was tested by checking for errors in execution of commands and checking that records were inserted into the Database.
- crontab command was tested to work by checking if data records were inserted into host_usage table every minute.

# Deployment
- Scripts were designed and testing to be used with Bash and stored on Github for Online Repository Purposes.
- Docker is required to be installed on the host system that will be running the container to manage the PostgreSQL database.
- PostgreSQL CLI is recommended to be installed so that users are able to run queries on the database tables for their data 
gathering purposes.
- A cron job will need to be added to crontab so that host_usage runs every minute (or based on user recording needs).

# Improvements
- Provide better parameter flexibility for the shell scripts
- Possibility to produce a cohesive scripting solution to initialize set up
  (run a script to run psql_docker.sh then ddl.sql script to produce tables, host_info.sh to obtain hardware specs, add the cron job for the user, etc.)
- Leave additional comments/context of the implementation of scripts
- Writing README files with more depth

