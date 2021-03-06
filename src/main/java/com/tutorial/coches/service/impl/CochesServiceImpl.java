/**
 * 
 */
package com.tutorial.coches.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.tutorial.coches.dto.CochesDto;
import com.tutorial.coches.dto.ResponseDto;
import com.tutorial.coches.repository.entity.CochesEntity;
import com.tutorial.coches.repository.entity.pk.CochesPkEntity;
import com.tutorial.coches.repository.jdbc.CochesRepository;
import com.tutorial.coches.service.CochesService;
import com.tutorial.coches.utils.Commons;
import com.tutorial.coches.utils.Constants;

import lombok.extern.slf4j.Slf4j;


/**
 * @author tiago
 *
 */
@Service
@Slf4j
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
		List<CochesEntity> listCars = new ArrayList<>();
		listCars.addAll(cochesRepository.findByMarca(marca));	
		List<CochesDto> output = new ArrayList<>();
		if (!listCars.isEmpty()) {
			output = mapEntityToDTO(listCars);	
		}		
		return output;
	}

	@Override
	public Boolean deleteCocheByClave(String matricula) {
		log.info("#### Se va a borrar el coche: {} ####", matricula);
		CochesEntity cocheEnTable = cochesRepository.findByPk_Matricula(matricula);
		Integer result = 0;
		if (cocheEnTable != null) {
			result = cochesRepository.deleteByPk_Matricula(matricula);
			/*
			 * CochesPkEntity coche = new CochesPkEntity();
			 * coche.setId(cocheEnTable.getPk().getId());
			 * coche.setMatricula(cocheEnTable.getPk().getMatricula());
			 * cochesRepository.deleteById(coche);
			 */
		}
		log.info("#### Se ha borrado coche: {} ####", matricula);
		return (result>0)?true:false;
	}

	@Override
	public ResponseDto addNewCar(CochesDto coche) {
		ResponseDto resultNewCoche = new ResponseDto(HttpStatus.ACCEPTED, Constants.SUCCESO, false);
		if (coche == null) {
			resultNewCoche = Commons.setResponse(HttpStatus.INTERNAL_SERVER_ERROR, Constants.ERROR_GENERICO, true);
		} else if (null==coche.getMarca() || coche.getMarca().isEmpty()) {
			resultNewCoche = Commons.setResponse(HttpStatus.NOT_FOUND, Constants.ERROR_MARCA, true);
		}else if (null==coche.getModelo() || coche.getModelo().isEmpty()) {
			resultNewCoche = Commons.setResponse(HttpStatus.NOT_FOUND, Constants.ERROR_MODELO, true);
		}else if (null==coche.getMatricula() || coche.getMatricula().isEmpty()) {
			resultNewCoche = Commons.setResponse(HttpStatus.NOT_FOUND, Constants.ERROR_MATRICULA, true);
		}
		if (resultNewCoche.getError()) {
			return resultNewCoche;
		} else {
			try {
				cochesRepository.saveAll(mapDtoToEntity(coche));
				return resultNewCoche;
			} catch(Exception e) {
				return Commons.setResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), true);
			}			
		}		
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
	
	private List<CochesEntity> mapDtoToEntity(List<CochesDto> entrada){
		List<CochesEntity> output = new ArrayList<>();
		for(CochesDto element : entrada) {
			CochesEntity resp = new CochesEntity();
			CochesPkEntity pk = new CochesPkEntity();
			pk.setMatricula(element.getMatricula());
			resp.setPk(pk);
			resp.setMarca(element.getMarca());
			resp.setModelo(element.getModelo());
			output.add(resp);
		}
		return output;
	}
	private List<CochesEntity> mapDtoToEntity(CochesDto entrada){
		List<CochesEntity> output = new ArrayList<>();
			CochesEntity resp = new CochesEntity();
			CochesPkEntity pk = new CochesPkEntity();
			pk.setMatricula(entrada.getMatricula());
			resp.setPk(pk);
			resp.setMarca(entrada.getMarca());
			resp.setModelo(entrada.getModelo());
			output.add(resp);
			return output;
	}
}
