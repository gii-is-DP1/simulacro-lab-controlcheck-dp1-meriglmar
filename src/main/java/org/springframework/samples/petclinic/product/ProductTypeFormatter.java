package org.springframework.samples.petclinic.product;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class ProductTypeFormatter implements Formatter<ProductType>{

	//En la clase Formatter hace falta inyectar el servicio, con en el servicio
	//hace falta inyectar el repositorio
	@Autowired
	private ProductService productService;
	
	//Aquí se pide que se muestre el nombre de un tipo de producto que se pase, 
	//se hace con getName directamente
    @Override
    public String print(ProductType object, Locale locale) {
        String nombre = object.getName();
        return nombre;
    }

    //Aquí se pide obtener un tipo de producto dado su nombre buscándolo en la BD --> Cuando dice buscándolo en la base de datos, es que el servicio llama al repositorio y este hace consultas en la BD
    //Hay que ayudarse de lo ya hecho para el Test 6, se llama getProductType 
    //pasandole text que es el nombre, se comprueba si este es nulo, si lo es 
    //se muestra el parse exception y si no lo es se devuelve el productType.
    //Esta es una forma de hacerlo
    @Override
    public ProductType parse(String text, Locale locale) throws ParseException {
        ProductType p = this.productService.getProductType(text); //El getProductType, a su vez llamaba al método del repositorio findProductTypeByName para buscar un productType por nombre
        if (p == null) {
        	throw new ParseException("Product type not found: " + text, 0);
        } else {
        	return p;
        }
    }
    
}
