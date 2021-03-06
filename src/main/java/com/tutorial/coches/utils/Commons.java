package com.tutorial.coches.utils;

import org.springframework.http.HttpStatus;

import com.tutorial.coches.dto.ResponseDto;

public class Commons {
	
	public static ResponseDto setResponse(HttpStatus cod, String mensaje, Boolean error) {
		return new ResponseDto(cod, mensaje, error);		
	}

	public Commons() {
		super();
	}

}
