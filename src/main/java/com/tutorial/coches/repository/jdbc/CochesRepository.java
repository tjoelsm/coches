/**
 * 
 */
package com.tutorial.coches.repository.jdbc;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutorial.coches.repository.entity.CochesEntity;
import com.tutorial.coches.repository.entity.pk.CochesPkEntity;

/**
 * @author tiago
 *
 */
public interface CochesRepository extends JpaRepository<CochesEntity, CochesPkEntity>{

	List<CochesEntity> findAll();
	
	List<CochesEntity> findByMarca(String marca);
	
}
