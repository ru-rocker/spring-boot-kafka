# Overview
Simple code implementation by using spring boot 1.5 with Kafka.

# Run Kafka
See the kafka playbook from [here](https://github.com/ru-rocker/confluent-kafka-playbook "Confluent Kafka").
Inside the repository, there is a Vagrant file to be executed.

	# Start node
	vagrant up node1    
	vagrant up node2    
	vagrant up node3    
 
Then execute the playbook to provision kafka into VM.

# Spring Cloud Sleuth
This sample includes spring cloud sleuth for request tracing between producer and consumer.
To enable this, put headers in the binder.

     # for spring sleuth and zipkins.
     spring.cloud.stream.kafka.binder.headers=spanId,spanSampled,spanProcessId,spanParentSpanId,spanTraceId,spanName,spanFlags
     
_Note: if you need another header, just put header name within the binder headers key._
