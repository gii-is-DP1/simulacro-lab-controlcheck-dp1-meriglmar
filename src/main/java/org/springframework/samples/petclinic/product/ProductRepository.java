package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{
    
//	Se debe anotar el método findAllProductTypes, del repositorio de productos, para que ejecute 
//	una consulta que permitan obtener todos los tipos de productos existentes.

	@Query("SELECT pt FROM ProductType pt")
    List<ProductType> findAllProductTypes();

//  Crear una consulta personalizada que pueda invocarse a través del repositorio de productos que 
//	obtenga un tipo de producto por nombre. Exponerlo a través del servicio de gestión de productos 
//	mediante el método “getProductType(String name)”.
	
	@Query("SELECT pt FROM ProductType pt WHERE pt.name=?1") //Este 1 hace referencia al name, que es el nombre dado
	ProductType findProductTypeByName(String name);
	
//	Crear una consulta personalizada anotando el método “findByPriceLessThan” en el repositorio, de 
//	manera que tome como parámetro un coste (parámetro de tipo double) y que devuelva todos los 
//	productos más baratos que la cantidad indicada. Extender el servicio de gestión de productos para que 
//	incluya a un método llamado “getProductsCheaperThan” que invoque al repositorio.
	
	@Query("SELECT p FROM Product p WHERE p.price<?1") //Este 1 hace referencia al coste, que es el coste/precio dado
	List<Product> findByPriceLessThan(double price);
	
	List<Product> findAll();
    Optional<Product> findById(int id);
    Product findByName(String name);
    Product save(Product p);
}
