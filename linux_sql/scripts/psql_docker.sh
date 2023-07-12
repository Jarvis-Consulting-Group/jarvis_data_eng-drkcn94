#! /bin/bash

# Capture CLI Arguments
cmd=$1
db_username=$2
db_password=$3

# Start Docker
sudo systemctl status docker || systemctl start docker

# Check container status
docker container inspect jrvs-psql
container_status=$?

# User switch case for options create/stop/start
case $cmd in
  create)

  # Check if container is created already
  if [ $container_status -eq 0 ]; then
    echo 'Container already exists'
    exit 1
  fi

  # Check if valid amount of CLI Arguments
  if [ $# -ne 3 ]; then
    echo 'Creating new container requires username and password'
    exit 1
  fi

  # Create the container
  docker volume create pgdata
  # Start the container
  docker run --name jrvs-psql -e POSTGRES_PASSWORD=$PGPASSWORD -d -v pgdata:/var/lib/postgresql/data -p 5432:5432 postgres:9.6-alpine
  # Exit script with exit code from Docker
  exit $?
  ;;

  start|stop)
  # Check instance status; exit 1 if container was never created
  if [ $container_status -ne 0 ]; then
    echo 'Container does not exist'
    exit 1;
  fi

  # Start or stop the container
  docker container $cmd jrvs-psql
  exit $?
  ;;

  # For any invalid commands provided
  *)
  echo 'Illegal command'
  echo 'Commands Available: start|stop|create'
  exit 1
  ;;
esac