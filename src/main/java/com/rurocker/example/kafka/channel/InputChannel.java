package com.rurocker.example.kafka.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * Subscriber channel (sink).
 * @author ricky
 *
 */
public interface InputChannel {

	@Input("counterSinkChannel")
	SubscribableChannel counter();
}
