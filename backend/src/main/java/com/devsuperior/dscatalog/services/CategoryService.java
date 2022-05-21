package com.devsuperior.dscatalog.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dscatalog.dto.CategoryDTO;
import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.repositories.CategoryRepository;

@Service //Com esta anotação, a injeção de independência desta classe passa a ser gerenciada pelo Spring.
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	@Transactional(readOnly = true)
	public List<CategoryDTO> findAll(){
		List<Category> list = repository.findAll();

// Solução com expressão lambda
		return list.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());

// Solução alternativa		
//		List<CategoryDTO> listDto = new ArrayList<>();
//		for (Category cat : list) {
//			listDto.add(new CategoryDTO(cat));
//		}
//		return listDto;		
	}
}
