package com.devsuperior.dscatalog.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dscatalog.entities.Category;

//Esta classe representa o controlador REST API
@RestController
@RequestMapping(value = "/categories") //annotation que determina a rota do controlador REST
public class CategoryResource {

	//ResponseEntity encapsula respostas HTTP
	@GetMapping  //Determina o Endpoint do controlador REST
	public ResponseEntity<List<Category>> findAll(){
		List<Category> list = new ArrayList<>();
		list.add(new Category(1L,"Books"));
		list.add(new Category(2L,"Eletronics"));
		list.add(new Category(3L,"Others"));
		return ResponseEntity.ok().body(list);
	}
}
