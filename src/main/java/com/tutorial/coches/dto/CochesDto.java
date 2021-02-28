/**
 * 
 */
package com.tutorial.coches.dto;

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
public class CochesDto {
	
	private Integer id;	
	private String matricula;	
    private String marca;
	private String modelo;
}
