package com.tutorial.coches.service;

import java.util.List;

import com.tutorial.coches.dto.CochesDto;

public interface CochesService {
	
	List<CochesDto> getAllCochesMock();
	
	List<CochesDto> getAllCoches();
	
	List<CochesDto> getCochesByMarca(String marca);


}
