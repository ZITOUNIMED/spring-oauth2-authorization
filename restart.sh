#!/bin/bash

echo "Restart Microservice:"

docker-compose stop "$1"
docker-compose rm "$1"

./bash.sh "$1"

docker-compose up "$1"

echo "Microcervice restarted."