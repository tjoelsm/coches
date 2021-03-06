/**
 * 
 */
package com.tutorial.coches.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.coches.dto.CochesDto;
import com.tutorial.coches.dto.ResponseDto;
import com.tutorial.coches.service.CochesService;


/**
 * @author tiago
 *
 */
@RestController
@RequestMapping("/mantenimiento")
public class CochesMantenimientoController {

	@Autowired
	private CochesService cochesService;
		
	@DeleteMapping(value="/delelteCoche", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteByMarca(String matricula) {
		Boolean result = cochesService.deleteCocheByClave(matricula);
		return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
	}
	
	@PutMapping(value="/addNewCoche", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addNewCoche(@RequestBody CochesDto coche) {
		ResponseDto result = cochesService.addNewCar(coche);
		return new ResponseEntity<>(result, result.getCod());
	}
}
