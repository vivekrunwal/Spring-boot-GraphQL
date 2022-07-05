package com.vivek.springbootgraphql.repository;

import com.vivek.springbootgraphql.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;

@Service
public interface FilmRepository extends JpaRepository<Film, Integer> {

}
