/**
 * 
 */
package com.tutorial.coches.service.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import com.tutorial.coches.dto.CochesDto;
import com.tutorial.coches.dto.ResponseDto;
import com.tutorial.coches.repository.entity.CochesEntity;
import com.tutorial.coches.repository.entity.pk.CochesPkEntity;
import com.tutorial.coches.repository.jdbc.CochesRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * @author tiago
 *
 */
@Slf4j
@SpringBootTest
public class CochesServiceImplTest {

	@InjectMocks
	CochesServiceImpl cochesService;
	
	@Mock
	CochesRepository cochesRepository;
	
	private List<CochesEntity> cochesDto;
	
	@BeforeEach 
	  public void setUp() {
		log.info("###### TEST CONTROLLER SetUp #####"); 
		ResponseDto responseResult = new ResponseDto(HttpStatus.ACCEPTED, "", false);
		cochesDto = new ArrayList<CochesEntity>();
		cochesDto = MockDtoCoches();
		Mockito.when(cochesRepository.findAll()).thenReturn(cochesDto);
	  }
	
	@Test
	void getAllCoches() {
		log.info("###### Running getAllCoches #####");
		List<CochesDto> result = cochesService.getAllCoches();
		assertNotNull(result);
	}
	
	List<CochesEntity> MockDtoCoches() {
		CochesEntity resp = new CochesEntity();
		CochesPkEntity respPk = new CochesPkEntity();
		respPk.setId(1);
		respPk.setMatricula("AAAAAA");
		resp.setPk(respPk);
		resp.setMarca("Opel");
		resp.setModelo("CORSA");
		List<CochesEntity> output = new ArrayList<>();
		output.add(resp);
		return output;
	}
}
