package com.rurocker.example.kafka.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rurocker.example.kafka.channel.InputChannel;
import com.rurocker.example.kafka.dto.CounterDto;

/**
 * Bean for retrieve message from kafka.
 * 
 * @author ricky
 *
 */
@Component
@EnableBinding(InputChannel.class)
public class CounterSubscribeBean {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ObjectMapper objectMapper;

	/**
	 * Stream Listener.
	 * @param counterDto
	 * @param counterHeader
	 * @throws JsonProcessingException
	 */
	@StreamListener("counterSinkChannel")
	public void retrieveCounter(CounterDto counterDto,
			@Header(name = "counterHeader", required = false) String counterHeader) throws JsonProcessingException {
		String json = objectMapper.writeValueAsString(counterDto);
		String output = String.format("Print counter dto %s with header %s", json, counterHeader);
		logger.info(output);
	}
}
