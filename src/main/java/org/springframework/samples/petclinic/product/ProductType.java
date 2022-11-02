package org.springframework.samples.petclinic.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product_type")
public class ProductType extends BaseEntity{
    
	//Integer id; El id no se pone, ya que si extiende a BaseEntity lo hereda y 
	//no hay que ponerlo en esta entidad
    
	//Un atributo "name" de tipo cadena obligatorio, y cuya longitud mínima son 3 caracteres y la máxima 50. 
	//Además, el nombre del tipo de producto debe ser único. --> Esto último es con @Column(name = "name", unique = true)
	@NotNull
	@Size(min = 3, max = 50)
	@Column(name = "name", unique = true)
    String name;
	
	
}
