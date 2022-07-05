package com.vivek.springbootgraphql.service;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.vivek.springbootgraphql.model.Actor;
import com.vivek.springbootgraphql.model.Film;
import com.vivek.springbootgraphql.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class FilmResolver  implements GraphQLResolver<Actor> {


    @Autowired
    private FilmRepository filmRepository;

    @Transactional
    public Film getFilm(Actor actor){
        return filmRepository.findById(actor.getFilmId()).get();
    }
}
