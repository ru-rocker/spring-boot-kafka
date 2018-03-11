# Overview
Simple code implementation by using spring boot 1.5 with Kafka.

# Run docker kafka


	docker run --name zookeeper -p 2181:2181 wurstmeister/zookeeper
    docker run --name kafka -p 9092:9092 --link zookeeper -e KAFKA_ZOOKEEPER_CONNECT=zookeeper:2181 wurstmeister/kafka
    
 