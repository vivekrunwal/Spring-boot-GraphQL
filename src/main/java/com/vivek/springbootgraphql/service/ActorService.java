package com.vivek.springbootgraphql.service;

import com.vivek.springbootgraphql.model.Actor;
import com.vivek.springbootgraphql.repository.ActorRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService implements GraphQLQueryResolver {

    @Autowired
    private ActorRepository repository;

    public List<Actor> getAllActors(){
           return repository.findAll();
    }
}
