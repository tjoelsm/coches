package com.tutorial.coches.repository.entity.pk;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Transient;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Data
@EqualsAndHashCode
public class CochesPkEntity implements Serializable{

	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 4419260102547193191L;
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String matricula;
	
}
