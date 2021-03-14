/**
 * 
 */
package com.tutorial.coches.repository.jdbc;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tutorial.coches.repository.entity.CochesEntity;
import com.tutorial.coches.repository.entity.pk.CochesPkEntity;

/**
 * @author tiago
 *
 */
@Repository
public interface CochesRepository extends JpaRepository<CochesEntity, CochesPkEntity>{

	List<CochesEntity> findAll();
	
	List<CochesEntity> findByMarca(String marca);
	
	CochesEntity findByPk_Matricula(String matricula);
	
	@Modifying
	@Transactional
	Integer deleteByPk_Matricula(String matricula);
	
	
		
}
