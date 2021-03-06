/**
 * 
 */
package com.tutorial.coches.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.coches.dto.CochesDto;
import com.tutorial.coches.service.CochesService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Example;
import io.swagger.annotations.ExampleProperty;


/**
 * @author tiago
 *
 */
@RestController
@RequestMapping("/consulta")
public class CochesController {

	@Autowired
	private CochesService cochesService;
	
	/**
	 * @return
	 */
	@GetMapping(value="/getAllCochesMock", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<CochesDto>> getAllMock() {
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
	@ApiOperation(value = "Operacion que devuelve los coches segun la marca", 
			response = CochesDto.class,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {
	   @ApiResponse(
	       code = 200,
	       message = "Se ha encontrado cohces de la marca",
	    		   examples = @Example(value = @ExampleProperty(mediaType = "application/json", value = "{\r\n" + 
           				"  \"body\": {\r\n" + 
           				"    \"id\": 1,\r\n" + 
           				"    \"matricula\": \"1234AAA\",\r\n" + 
           				"    \"marca\": \"Opel\",\r\n" + 
           				"    \"modelo\": \"Corsa\"\r\n" + 
           				"  },\r\n" +
           				"}"))
			   ),
		@ApiResponse(
            code = 404,
            message = "No se encuentran resultados para la marca",
            		examples = @Example(value = @ExampleProperty(mediaType = "application/json", value = "{\r\n" + 
            				"  \"body\": {},\r\n" +  
            				"}"))
           )
    })
	@GetMapping(value="/getCocheByMarca", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> getAllByMarca(String marca) {
		List<CochesDto> responseList = cochesService.getCochesByMarca(marca);
		if (responseList.isEmpty()) {
			return new ResponseEntity<>(responseList, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(responseList, HttpStatus.OK);
		}
	}
}
