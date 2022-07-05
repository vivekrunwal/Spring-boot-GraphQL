package com.vivek.springbootgraphql.service;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.vivek.springbootgraphql.model.Actor;
import com.vivek.springbootgraphql.model.AddressInput;
import com.vivek.springbootgraphql.repository.ActorRepository;
//import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class ActorService implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private ActorRepository repository;

    public List<Actor> getAllActors(){
           return repository.findAll();
    }
    public Actor getActorById(Integer id){
        return repository.findById(id).get();
    }
    @Transactional
    public Actor updateAddress(Integer id, String address){
        Actor actor = repository.findById(id).get();
        actor.setAddress(address);
        repository.save(actor);
        return actor;
    }

    @Transactional
    public Actor updateAddressByInputObject(AddressInput input){
        Actor actor = repository.findById(input.getActorId()).get();
        actor.setAddress(input.getAddress());
        repository.save(actor);
        return actor;
    }
}
