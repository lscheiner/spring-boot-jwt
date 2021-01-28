package br.com.scheiner.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;
import lombok.EqualsAndHashCode;

@MappedSuperclass
@Data
@EqualsAndHashCode
public abstract class BaseEntity {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
}
