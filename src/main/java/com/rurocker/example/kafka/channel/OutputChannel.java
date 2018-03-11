package com.rurocker.example.kafka.channel;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Output channel to helloChannel topic.
 * @author ricky
 *
 */
public interface OutputChannel {

	@Output("counterChannel")
	MessageChannel counter();
}
