package com.vivek.springbootgraphql.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "ACTOR")
public class Actor {

    @Column(name = "ACTOR_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer actorId;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;

@Column(name = "ADDRESS")
    private String address;
@Column(name = "DOB")
    private Date dob;
@Column(name = "FILM_ID")
    private Integer filmId;


    public Actor(){

    }
    public Actor(String firstName, String lastName, Date dob, String address, Integer filmId) {
        //this.actorId = actorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.address = address;
        this.filmId = filmId;
    }

}
