package com.tutorial.coches.service;

import java.util.List;

import com.tutorial.coches.dto.CochesDto;
import com.tutorial.coches.dto.ResponseDto;

public interface CochesService {
	
	List<CochesDto> getAllCochesMock();
	
	List<CochesDto> getAllCoches();
	
	List<CochesDto> getCochesByMarca(String marca);

	Boolean deleteCocheByClave(String matricula);
	
	ResponseDto addNewCar(CochesDto coche);

}
