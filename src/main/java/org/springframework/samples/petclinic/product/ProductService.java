package org.springframework.samples.petclinic.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ProductService {
	
	//Primera forma:
	@Autowired //Para que Spring me meta dentro de este servicio el repositorio
	private ProductRepository productRepository;
	
	//Segunda forma:
//    private ProductRepository productRepository;
//    
//	@Autowired //Para que Spring me meta dentro de este servicio el repositorio
//	public ProductService(ProductRepository productRepository) {
//	    this.productRepository = productRepository;
//	}
	
    public List<Product> getAllProducts(){
        List<Product> products = productRepository.findAll(); //Para este método se usa el findAll del repositorio, ya que lo hemos llamado arriba en la línea 13
        return products;
    }

    public List<Product> getProductsCheaperThan(double price) {
        List<Product> products = productRepository.findByPriceLessThan(price);
        return products;
    }

    public ProductType getProductType(String typeName) {
        ProductType pt = productRepository.findProductTypeByName(typeName);
        return pt;
    }
    
    public List<ProductType> findAllProductTypes() {
    	List<ProductType> pt = productRepository.findAllProductTypes();
    	return pt;
    }

    //Este método se necesita para hacer el formulario de crear producto en el test 9
    @Transactional
    public Product save(Product p){
        return productRepository.save(p);     
    }

    
}
