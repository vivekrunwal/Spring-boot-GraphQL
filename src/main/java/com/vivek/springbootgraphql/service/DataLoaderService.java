package com.vivek.springbootgraphql.service;

import com.vivek.springbootgraphql.model.Actor;
import com.vivek.springbootgraphql.model.Film;
import com.vivek.springbootgraphql.repository.ActorRepository;
import com.vivek.springbootgraphql.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class DataLoaderService {

    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private FilmRepository filmRepository;


    @PostConstruct
    public void loadData(){
        String [] actors = {"ShahRukh Khan","Salman Khan","Aamir Khan","Amitabh Bacchan"};
        Map<String,String> films = new HashMap<String, String>(){
            {
                put("ShahRukh Khan","Kuch Kuch Hota Hai");
                put("Salman Khan","Dabang");
                put("Aamir Khan","Dangal");
                put("Amitabh Bacchan","Sholey");
            }
        };
        for (String actorName :actors){
            String [] names = actorName.split(" ");

            Date dateOfBirth = DataLoaderService.between(new Date(1960,01,01),new Date(1980,01,01));
            Date dateOfLaunch = DataLoaderService.between(new Date(1990,01,01),new Date(2000,01,01));
            Film film = new Film(films.get(actorName),dateOfLaunch);
            filmRepository.save(film);
            Actor actor = new Actor(names[0],names[1],dateOfBirth,"Mumbai India",film.getFilmId());
            actorRepository.save(actor);

        }


    }

    public static Date between(Date startInclusive, Date endExclusive) {
        long startMillis = startInclusive.getTime();
        long endMillis = endExclusive.getTime();
        long randomMillisSinceEpoch = ThreadLocalRandom
                .current()
                .nextLong(startMillis, endMillis);

        return new Date(randomMillisSinceEpoch);

    }
}
