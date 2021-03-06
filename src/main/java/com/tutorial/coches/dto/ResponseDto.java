/**
 * 
 */
package com.tutorial.coches.dto;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author tiago
 *
 */
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {
	
	private HttpStatus cod;
	private String mensaje;
	private Boolean error;

}
