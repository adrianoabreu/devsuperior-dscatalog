package com.devsuperior.dscatalog.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devsuperior.dscatalog.dto.ProductDTO;
import com.devsuperior.dscatalog.entities.Product;
import com.devsuperior.dscatalog.services.ProductService;

//Esta classe representa o controlador REST API
@RestController
@RequestMapping(value = "/products") //annotation que determina a rota do controlador REST
public class ProductResource {

	@Autowired
	private ProductService service;
	
	//testar com o endpoint: {{host}}/products?page=0&size=12&sort=name,asc
	//ResponseEntity encapsula respostas HTTP
	@GetMapping  //Determina o Endpoint do controlador REST
	public ResponseEntity<Page<ProductDTO>> findAll(
			@RequestParam(value = "categoryId", defaultValue = "0") Long categoryId,
          	@RequestParam(value = "name", defaultValue = "") String name,
          	Pageable pageable){		
		
		//Parametros: page, size, sort
		Page<ProductDTO> list = service.findAllPaged(categoryId, name.trim(), pageable);		
		return ResponseEntity.ok().body(list);
	}
	
	//testar com o endpoint: {{host}}/products?page=0&linesPerPage=12&direction=ASC,orderBy=name
/*	@GetMapping  //Determina o Endpoint do controlador REST
	public ResponseEntity<Page<ProductDTO>> findAll(
			@RequestParam(value = "categoryId", defaultValue = "0") Long categoryId,
			@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy
			){		
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy); 
		Page<ProductDTO> list = service.findAllPaged(categoryId,name.trim(),pageRequest);		
		return ResponseEntity.ok().body(list);
	}
*/
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ProductDTO> findById(@PathVariable Long id){		
		ProductDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping
	public ResponseEntity<ProductDTO> insert(@Valid @RequestBody ProductDTO dto){		
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ProductDTO> update(@PathVariable Long id, @Valid @RequestBody ProductDTO dto){		
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){		
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
