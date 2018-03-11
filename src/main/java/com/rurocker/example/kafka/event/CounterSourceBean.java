package com.rurocker.example.kafka.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rurocker.example.kafka.channel.OutputChannel;
import com.rurocker.example.kafka.dto.CounterDto;

/**
 * Source bean to send message to kafka.
 * 
 * @author ricky
 *
 */
@EnableBinding(OutputChannel.class)
@Component
public class CounterSourceBean {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private OutputChannel outputChannel;

	public boolean sendCounterMessage(CounterDto counterDto) throws JsonProcessingException {
		String json = objectMapper.writeValueAsString(counterDto);
		logger.info("Send counter {}", json);
		return outputChannel.counter().send(MessageBuilder.withPayload(counterDto).build());
	}

	public boolean sendCounterMessageWithHeader(CounterDto counterDto, String counterHeader) throws JsonProcessingException {
		String json = objectMapper.writeValueAsString(counterDto);
		logger.info("Send counter {}", json);
		return outputChannel.counter()
				.send(MessageBuilder.withPayload(counterDto).setHeader("counterHeader", counterHeader).build());
	}
}
