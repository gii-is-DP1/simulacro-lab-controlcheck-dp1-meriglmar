package org.springframework.samples.petclinic.product;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseEntity {

	//Integer id; El id no se pone, ya que si extiende a BaseEntity lo hereda y 
	//no hay que ponerlo en esta entidad
    
    @NotNull
    @Size(min = 3, max = 50)
    String name;
    
    @NotNull
    @Min(0)
    double price;
    
    @ManyToOne
    @NotNull //Esto se pone porque a lo mejor para que se de esta relación
    		//	este atributo "productType" no puede ser nulo.
    @JoinColumn(name = "product_type_id") //Esto es para que cada producto quede asociado al tipo de producto correspondiente. Por tanto este atributo se añade en la tabla de Product
    ProductType productType;
}
