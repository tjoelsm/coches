/**
 * 
 */
package com.tutorial.coches.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.coches.dto.CochesDto;
import com.tutorial.coches.service.CochesService;

/**
 * @author tiago
 *
 */
@RestController
public class CochesControler {

	@Autowired
	private CochesService cochesService;
	
	/**
	 * @return
	 */
	@GetMapping(value="/getAllCochesMock", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> getAllMock() {
		List<CochesDto> responseList = cochesService.getAllCochesMock();
		return new ResponseEntity<>(responseList, HttpStatus.OK);
	}
	
	/**
	 * @return
	 */
	@GetMapping(value="/", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> getAll() {
		List<CochesDto> responseList = cochesService.getAllCoches();
		return new ResponseEntity<>(responseList, HttpStatus.OK);
	}
	
	/**
	 * @param marca
	 * @return
	 * call ejemple: http://localhost:8080/getCocheByMarca?marca=Opel
	 */
	@GetMapping(value="/getCocheByMarca", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> getAllMock(String marca) {
		List<CochesDto> responseList = cochesService.getCochesByMarca(marca);
		return new ResponseEntity<>(responseList, HttpStatus.OK);
	}
}
