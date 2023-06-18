# Introduction
The Linux Clustering Monitoring Agent is a product designed to assist Administration Teams 
with recording hardware specifications of hardware nodes/servers and tracking of resource usage in real-time.
The development of this product would provide Adminstration Teams better understanding of company resource usage 
and if servers are required to be added or removed. The technologies used to develop this product are Bash scripts 
to handle the recording of hardware specifications and resource usage, a PostgreSQL database to persist the 
information recorded, Docker to manage dependencies and deployment of the PostgreSQL Database Software.
Git and Github were used for version control and Intellij IDEA for IDE purposes.

# Quick Start
```

- psql_docker.sh (to start up docker container running psql database software)


- ddl.sql (For creation of tables related to hardware specification and resource usage records)


- host_info.sh (Script to handle insertion of hardware specs record to the host_info table)


- host_usage.sh (Script to handle insertion of resource usage records to host_usage table)

```

# Implementation


## Architecture


## Scripts


## Database Modeling
- `host_info`


# Testing


# Deployment


# Improvements
- Provide better parameter flexibility for the shell scripts
- 2
- 3

