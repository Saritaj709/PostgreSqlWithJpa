package com.employee.model;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ConfigurationProperties(prefix="ResponseDTO")
public class ResponseDTO {
	
	  private String message;
	  private int status;
	 

	/*
	 * public ResponseDTO() { super(); }
	 * 
	 * public String getMessage() { return message; }
	 * 
	 * public void setMessage(String message) { this.message = message; }
	 * 
	 * public int getStatus() { return status; }
	 * 
	 * public void setStatus(int status) { this.status = status; }
	 */
}