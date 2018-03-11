package com.rurocker.example.kafka.channel;

import org.springframework.messaging.SubscribableChannel;

/**
 * Subscriber channel (sink).
 * @author ricky
 *
 */
public interface InputChannel {

	SubscribableChannel counter();
}
