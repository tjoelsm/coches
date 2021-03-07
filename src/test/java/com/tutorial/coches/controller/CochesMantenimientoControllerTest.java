/**
 * 
 */
package com.tutorial.coches.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.tutorial.coches.dto.CochesDto;
import com.tutorial.coches.dto.ResponseDto;
import com.tutorial.coches.service.CochesService;

import lombok.extern.slf4j.Slf4j;


/**
 * @author x233821
 *
 */
@Slf4j
@SpringBootTest
class CochesMantenimientoControllerTest {

	@InjectMocks
	CochesMantenimientoController cochesMantenimientoController;
	
	@Mock
	CochesService cochesService;
	
	private List<CochesDto> cochesDto;
	
	  @BeforeEach 
	  public void setUp() {
	  log.info("###### TEST CONTROLLER SetUp #####"); 
	  cochesDto = new ArrayList<CochesDto>();
	  cochesDto = MockDtoCoches();
	  ResponseDto responseResult = new ResponseDto(HttpStatus.ACCEPTED, "", false);
	  Mockito.when(cochesService.deleteCocheByClave("4321ZZZ")).thenReturn(true);
	  Mockito.when(cochesService.deleteCocheByClave("1234ZZZ")).thenReturn(false);
	  Mockito.when(cochesService.addNewCar(Mockito.any(CochesDto.class))).thenReturn(responseResult);	  
	  Mockito.when(cochesService.modifyCar(Mockito.any(CochesDto.class))).thenReturn(responseResult);	  
	  }
	 
	@Test
	void deleteByMarca_OK() {
		log.info("###### Running deleteByMarca #####");
		ResponseEntity<?> responseList = cochesMantenimientoController.deleteByMarca("4321ZZZ");
		assertTrue(responseList.getBody().equals(true));
		log.info("###### Return deleteByMarca #####");
	}
	
	@Test
	void deleteByMarca_KO() {
		log.info("###### Running deleteByMarca #####");
		ResponseEntity<?> responseList = cochesMantenimientoController.deleteByMarca("1234ZZZ");
		assertTrue(responseList.getBody().equals(false));
		log.info("###### Return deleteByMarca #####");
	}
	
	@Test
	void addNewCoche() {
		CochesDto newCar = new CochesDto();
		ResponseEntity<?> responseList = cochesMantenimientoController.addNewCoche(newCar);
		assertTrue(responseList.getStatusCode().equals(HttpStatus.ACCEPTED));
	}
	
	@Test
	void modifyCoche() {
		CochesDto newCar = new CochesDto();
		ResponseEntity<?> responseList = cochesMantenimientoController.modifyCoche(newCar);
		assertTrue(responseList.getStatusCode().equals(HttpStatus.ACCEPTED));
	}
	
	List<CochesDto> MockDtoCoches() {
		CochesDto resp = new CochesDto();
		resp.setId(1);
		resp.setMatricula("AAAAAA");
		resp.setMarca("Opel");
		resp.setModelo("CORSA");
		List<CochesDto> output = new ArrayList<>();
		output.add(resp);
		return output;
	}
}
