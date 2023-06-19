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

# Implementation
Implementation of the project began with understanding the necessary technologies/languages required to implement the monitoring agent. 
Design and 


## Architecture
![test picture](/.assets/Architecture/)

## Scripts
`psql_docker.sh` was created first so that there is a means of creating a database instance that can be interacted with to store records.

`ddl.sql` was created so that there is a means of automated the necessary instructions to create the tables to store the records.

`host_info.sh` and `host_usage.sh` were created last using shell scripting language to provide streamline instructions necessary
for gathering system hardware specifications and resource utilization.

## Database Modeling
- `host_info`


# Testing


# Deployment
all scripts were designed and testing to be used with Bash
Docker needs to be installed

# Improvements
- Provide better parameter flexibility for the shell scripts
- Possibility to produce a cohesive scripting solution to initialize set up
  (run a script to run psql_docker.sh then ddl.sql script to produce tables, host_info.sh to obtain hardware specs, etc.)
- 3

