package com.example.ejemplo.api.repositories;

import java.util.List;

import com.example.ejemplo.api.models.models;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.PathVariable;




public interface repository extends CrudRepository<models,Long> {
    @Query(value = "select * from users where apellido like %:variable", nativeQuery = true)
    public List<models> obtenerApellido(@PathVariable String variable);

}
