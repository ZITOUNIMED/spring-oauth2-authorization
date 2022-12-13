#!/bin/bash

echo "Start Build Docker images:"

function build_discovery_service(){
	cd discovery-service
	mvn clean install
	docker rmi discovery-service
	docker build -t discovery-service .
	cd ..
}

function build_gateway_service(){
	cd gateway-service
	mvn clean install
	docker rmi gateway-service
	docker build -t gateway-service .
	cd ..
}

function build_authorization_server(){
	cd authorization-server
	mvn clean install
	docker rmi authorization-server
	docker build -t authorization-server .
	cd ..
}

function build_resource_server(){
	cd resource-server
	mvn clean install
	docker rmi resource-server
	docker build -t resource-server .
	cd ..
}

function build_client_server(){
	cd client-server
	mvn clean install
	docker rmi client-server
	docker build -t client-server .
	cd ..
}

function build_message_service(){
	cd message-service
	mvn clean install
	docker rmi message-service
	docker build -t message-service .
	cd ..
}

for arg in "$@"
do
	if [ "$arg" == 'all' ]; then
		build_discovery_service
		build_gateway_service
		build_authorization_server
		build_resource_server
		build_client_server
		build_message_service
	else 
		if [ "$arg" == 'discovery-service' ]; then
		build_discovery_service
		fi
		if [ "$arg" == 'gateway-service' ]; then
			build_gateway_service
		fi
		if [ "$arg" == 'authorization-server' ]; then
			build_authorization_server
		fi
		if [ "$arg" == 'resource-server' ]; then
			build_resource_server
		fi
		if [ "$arg" == 'client-server' ]; then
			build_client_server
		fi
		if [ "$arg" == 'message-service' ]; then
			build_message_service
		fi
	fi
	
done

echo "Build Docker Images Finished."