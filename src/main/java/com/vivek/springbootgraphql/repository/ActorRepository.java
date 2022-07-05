package com.vivek.springbootgraphql.repository;

import com.vivek.springbootgraphql.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface ActorRepository extends JpaRepository<Actor,Integer> {

}
