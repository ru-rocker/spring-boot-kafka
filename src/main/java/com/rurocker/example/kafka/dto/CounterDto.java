package com.rurocker.example.kafka.dto;

/**
 * DTO for say hello;
 * 
 * @author ricky
 *
 */
public class CounterDto {

	private Integer counter;
	private String message;

	public Integer getCounter() {
		return counter;
	}

	public void setCounter(Integer counter) {
		this.counter = counter;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
