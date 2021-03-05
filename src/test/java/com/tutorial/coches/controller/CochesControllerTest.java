/**
 * 
 */
package com.tutorial.coches.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

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
import com.tutorial.coches.service.CochesService;

import lombok.extern.slf4j.Slf4j;


/**
 * @author x233821
 *
 */
@Slf4j
@SpringBootTest
class CochesControllerTest {

	@InjectMocks
	CochesController cochesController;
	
	@Mock
	CochesService cochesService;
	
	private List<CochesDto> cochesDto;
	
	  @BeforeEach 
	  public void setUp() {
	  log.info("###### TEST CONTROLLER SetUp #####"); 
	  cochesDto = new ArrayList<CochesDto>();
	  cochesDto = MockDtoCoches();
      Mockito.when(cochesService.getAllCoches()).thenReturn(cochesDto);
	  Mockito.when(cochesService.getAllCochesMock()).thenReturn(cochesDto);
	  Mockito.when(cochesService.getCochesByMarca("Opel")).thenReturn(cochesDto);
	  Mockito.when(cochesService.deleteCocheByClave("4321ZZZ")).thenReturn(true);
	  Mockito.when(cochesService.deleteCocheByClave("1234ZZZ")).thenReturn(false);
	  }
	 
	
	@Test
	void getAllMock() {
		log.info("###### Running getAllMockTest #####");
		try {
		ResponseEntity<?> responseList = cochesController.getAllMock();
		assertNotNull(responseList);
		} catch (Throwable e) {
			fail();
		}
		log.info("###### Return getAllMockTest #####");
	}
	
	@Test
	void getAll() {
		log.info("###### Running getAllTest #####");
		ResponseEntity<?> responseList = cochesController.getAll();
		assertNotNull(responseList);
		log.info("###### Return getAllTest #####");
	}
	
	@Test
	void getAllByMarca_TestOk() {
		log.info("###### Running getAllTest #####");
		ResponseEntity<?> responseList = cochesController.getAllByMarca("Opel");
		assertNotNull(responseList);
		assertEquals(responseList.getStatusCode(), HttpStatus.OK);
		log.info("###### Return getAllTest #####");
	}
	
	@Test
	void getAllByMarca_TestKo() {
		log.info("###### Running getAllTest #####");
		ResponseEntity<?> responseList = cochesController.getAllByMarca("Ford");
		assertNotNull(responseList);
		assertThat(responseList.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
		log.info("###### Return getAllTest #####");
	}
	
	@Test
	void deleteByMarca_OK() {
		log.info("###### Running deleteByMarca #####");
		ResponseEntity<?> responseList = cochesController.deleteByMarca("4321ZZZ");
		assertTrue(responseList.getBody().equals(true));
		log.info("###### Return deleteByMarca #####");
	}
	
	@Test
	void deleteByMarca_KO() {
		log.info("###### Running deleteByMarca #####");
		ResponseEntity<?> responseList = cochesController.deleteByMarca("1234ZZZ");
		assertTrue(responseList.getBody().equals(false));
		log.info("###### Return deleteByMarca #####");
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
