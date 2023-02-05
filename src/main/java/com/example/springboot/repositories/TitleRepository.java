package com.example.springboot.repositories;

import com.example.springboot.entities.Department;
import com.example.springboot.entities.Title;
import com.example.springboot.entities.TitleId;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TitleRepository extends CrudRepository<Title, TitleId> {
}
