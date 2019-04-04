package com.employee.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class HelloWorldResponse
{
    @JsonProperty("hello")
    private final String name;
    public HelloWorldResponse(final String name) {
    	this.name=name;
    }
}
