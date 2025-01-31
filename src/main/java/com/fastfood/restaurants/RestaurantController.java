package com.fastfood.restaurants;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.ui.Model;


@Controller
public class RestaurantController {
	
	@Autowired
    ProductRepository prepo;
	
	
	

	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/addProduct")
	//@ResponseBody
	public String addProduct() {
		System.out.print("false");
		return "addProduct";
	}
	
	@PostMapping("/createProduct")
	public String createProduct(@ModelAttribute Product p, productFile f ,@RequestParam("fileimg") MultipartFile file){
	
		
		try {
		f.save(file);
		p.setFilename(file.getOriginalFilename());
		p.setContenType(file.getContentType());
	    p.setFile(p.getFilename());
		
		}
		
		catch(Exception e) {
			  e.printStackTrace();
		}
	    System.out.print(p.getFile());
		prepo.save(p);
	
		
	
		
		return "redirect:/home";
	}
	
	@GetMapping("/productlist")
	public String getProductInfo(Model m ,Product p) {
		List<Product> list=prepo.findAll();
	
		System.out.print("ALLHAA ");
	
		m.addAttribute("product", list);
		return "list";
	}
	
	@GetMapping("/productBycategory")
	public String getProductByID(@RequestParam("category") String category,Model m ,Product p) {
		List<Product> selectProduct=prepo.findByCategory(category);
		
		//System.out.print(selectProduct);
		System.out.print(category);
	    m.addAttribute("product", selectProduct);
		
	    return "NewFile";
		
	}
	@GetMapping("/delete/{id}")
	public String deleteByid(@PathVariable("id") int id ){
		      prepo.deleteById(id);
		      System.out.print("delete"+id);
		      return "redirect:/list";
	}
	
}
