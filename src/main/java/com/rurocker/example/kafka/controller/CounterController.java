package com.rurocker.example.kafka.controller;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rurocker.example.kafka.dto.CounterDto;
import com.rurocker.example.kafka.event.CounterSourceBean;

/**
 * Controller for counter.
 * 
 * @author ricky
 *
 */
@RestController
public class CounterController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private AtomicInteger atomicInteger = new AtomicInteger();

	@Autowired
	private CounterSourceBean counterSourceBean;

	@GetMapping(path = "/counter")
	public CounterDto getCounter(@RequestParam("message") String message,
			@RequestParam(name = "counterHeader", required = false) String counterHeader) throws IOException {
		int counter = atomicInteger.incrementAndGet();
		logger.info("Get Counter request with message {}, counter {} and header {}", message, counter, counterHeader);
		CounterDto dto = new CounterDto();
		dto.setMessage(message);
		dto.setCounter(counter);

		if (counterHeader == null) {
			counterSourceBean.sendCounterMessage(dto);

		} else {
			counterSourceBean.sendCounterMessageWithHeader(dto, counterHeader);
		}

		return dto;
	}
}
