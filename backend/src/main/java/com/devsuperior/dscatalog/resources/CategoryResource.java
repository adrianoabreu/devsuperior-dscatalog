package com.devsuperior.dscatalog.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dscatalog.dto.CategoryDTO;
import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.services.CategoryService;

//Esta classe representa o controlador REST API
@RestController
@RequestMapping(value = "/categories") //annotation que determina a rota do controlador REST
public class CategoryResource {

	@Autowired
	private CategoryService service;
	
	//ResponseEntity encapsula respostas HTTP
	@GetMapping  //Determina o Endpoint do controlador REST
	public ResponseEntity<List<CategoryDTO>> findAll(){
		// Lista Mockada para teste
		//List<Category> list = new ArrayList<>();
		//list.add(new Category(1L,"Books"));
		//list.add(new Category(2L,"Eletronics"));
		//list.add(new Category(3L,"Others"));
		
		List<CategoryDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CategoryDTO> findById(@PathVariable Long id){		
		CategoryDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
}
