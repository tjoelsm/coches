/**
 * 
 */
package com.tutorial.coches.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorial.coches.dto.CochesDto;
import com.tutorial.coches.repository.entity.CochesEntity;
import com.tutorial.coches.repository.jdbc.CochesRepository;
import com.tutorial.coches.service.CochesService;


/**
 * @author tiago
 *
 */
@Service
public class CochesServiceImpl implements CochesService{

	
	
	@Override
	public List<CochesDto> getAllCochesMock() {
		CochesDto resp = new CochesDto();
		resp.setId(1);
		resp.setMarca("Opel");
		resp.setMatricula("AAAAAA");
		resp.setModelo("CORSA");
		List<CochesDto> output = new ArrayList<>();
		output.add(resp);
		return output;
	}

	@Autowired
	private CochesRepository cochesRepository;
	
	@Override
	public List<CochesDto> getAllCoches() {
		List<CochesEntity> listCars = cochesRepository.findAll();
		List<CochesDto> output = mapEntityToDTO(listCars);
		return output;
	}
	
	@Override
	public List<CochesDto> getCochesByMarca(String marca) {
		List<CochesEntity> listCars = cochesRepository.findByMarca(marca);
		List<CochesDto> output = mapEntityToDTO(listCars);
		return output;
	}

	
	private List<CochesDto> mapEntityToDTO(List<CochesEntity> entrada){
		List<CochesDto> output = new ArrayList<>();
		for(CochesEntity element : entrada) {
			CochesDto resp = new CochesDto();
			resp.setId(element.getPk().getId());
			resp.setMatricula(element.getPk().getMatricula());
			resp.setMarca(element.getMarca());
			resp.setModelo(element.getModelo());
			output.add(resp);
		}
		return output;
	}

}
