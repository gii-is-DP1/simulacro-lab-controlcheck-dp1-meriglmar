package org.springframework.samples.petclinic.product;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {
    
	@Autowired
	private ProductService productService;
	
	private static final  String VIEWS_PRODUCT_CREATE_OR_UPDATE_FORM = "products/createOrUpdateProductForm";
	
	// Crear un formulario para crear un nuevo producto. Este formulario debe permitir especificar el nombre, 
	// el precio, y el tipo de producto asociado.
	@GetMapping("/create")
	public String initCreationForm(ModelMap modelMap) {
		modelMap.addAttribute("product", new Product());
		modelMap.addAttribute("productType", productService.findAllProductTypes());
		return VIEWS_PRODUCT_CREATE_OR_UPDATE_FORM;
	}
	
//	Se propone crear un método de controlador en la clase anterior que responda a peticiones tipo post en 
//	la url y se encargue de validar los datos del nuevo producto, mostrar los errores encontrados si 
//	existieran a través del formulario, y si no existen errores, almacenar el producto a través del servicio de 
//	gestión de productos. Tras grabar el producto, en caso de éxito, se mostrará la página de inicio de la 
//	aplicación (welcome), sin usar redirección. Por tanto, deberá implementar el método “save” del servicio 
//	de gestión de productos
	
	@PostMapping("/create")
	public String processCreationForm(@Valid Product product, BindingResult result, ModelMap modelMap) {
		String view = "welcome";
		if (result.hasErrors()) {
			modelMap.addAttribute("product", product);
			modelMap.addAttribute("productType", productService.findAllProductTypes());
			return VIEWS_PRODUCT_CREATE_OR_UPDATE_FORM;
		} else {
			//creating card
			productService.save(product);
			modelMap.addAttribute("message", "Product succesfully saved!");
		}
		
		return view;
	}
	
}
