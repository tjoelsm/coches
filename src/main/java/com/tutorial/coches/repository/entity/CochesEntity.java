package com.tutorial.coches.repository.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.tutorial.coches.repository.entity.pk.CochesPkEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Data
@EqualsAndHashCode
@Entity
@Table(name="coche")
public class CochesEntity {
	
	@EmbeddedId
	private CochesPkEntity pk;
	
	private String marca;
	
	private String modelo;

}
