package com.vivek.springbootgraphql.service;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;
import com.vivek.springbootgraphql.model.Actor;
import com.vivek.springbootgraphql.model.AddressInput;
import com.vivek.springbootgraphql.repository.ActorRepository;
//import graphql.kickstart.tools.GraphQLQueryResolver;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import javax.transaction.Transactional;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ActorService implements GraphQLQueryResolver, GraphQLMutationResolver, GraphQLSubscriptionResolver {

    @Autowired
    private ActorRepository repository;

    private ConcurrentHashMap<Integer, FluxSink<Actor>> subscribers = new ConcurrentHashMap<Integer, FluxSink<Actor>>();


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
        if(subscribers.get(id)!=null){
            subscribers.get(id).next(actor);
        }
        return actor;
    }

    @Transactional
    public Actor updateAddressByInputObject(AddressInput input){
        Actor actor = repository.findById(input.getActorId()).get();
        actor.setAddress(input.getAddress());
        repository.save(actor);

        if(subscribers.get(input.getActorId())!=null){
            subscribers.get(input.getActorId()).next(actor);
        }
        return actor;
    }

    public Publisher<Actor> onActorUpdate(Integer actorId){
        return Flux.create(subscriber-> subscribers.put(actorId,subscriber.onDispose(()->subscribers.remove(actorId,subscriber))), FluxSink.OverflowStrategy.LATEST);
    }

}
