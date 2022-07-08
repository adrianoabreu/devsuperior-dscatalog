package com.devsuperior.dscatalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.dscatalog.entities.User;

@Repository //Com esta anotação, a injeção de independência desta classe passa a ser gerenciada pelo Spring.
public interface UserRepository extends JpaRepository<User, Long>{

}
