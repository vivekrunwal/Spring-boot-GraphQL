package com.vivek.springbootgraphql.model;

import lombok.Data;

import javax.persistence.*;
import javax.print.attribute.standard.DateTimeAtCompleted;
import java.util.Date;

@Entity
@Data
@Table(name = "FILM")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "FILM_ID")
    private Integer filmId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "LAUNCH_YEAR")
    private Date launchYear;

    public Film(String name, Date launchYear) {
        this.name = name;
        this.launchYear = launchYear;
    }

    public Film(){

    }

}
