# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.1/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.1/maven-plugin/reference/html/#build-image)

### GraphQL
* Query Language for APIs and a runtime forr fulfilling those queries with your existing data
* It provides a complete and understadable description of the data in our API, gives clients the power to ask for exactly what they need and nothing more, makes it easier to evolve APIs over time, and enables powerful developer tools

### GraphQl v/s Rest
* Client controls the response
* No over/Under fetching of data
* Single Endpoint
* Decupled Business Logic


### GraphQl Building Blocks
#### Schema
* Types
* Query
* Mutation
* Subscription

#### Types
* type Actor{
actorId:ID, first_name:String,last_name:String,dateOfBirth:String,address:String,films:[Films]
}
* type Film{
name:String,year:String,Actors[Actor]
}

#### Query
* type Query{
Actor: getActorByName
}
* query($withFilm:Boolean!){
  getActorById(id:6){
  actorId
  firstName
  lastName
  address
  film @include(if:$withFilm){
  name
  filmId
  }
  }
  }

#### Mutation
* type Mutation{
Actor: updateName
}
* mutation($input:AddressInput){
  updateAddressByInputObject(input:$input){
  actorId
  firstName
  lastName
  address
  }
  }
* query($withFilm:Boolean!){
  getActorById(id:6){
  ...actorDetails
  address
  film @include(if:$withFilm){
  name
  filmId
  }
  }
  }

fragment actorDetails on Actor{
actorId
firstName
lastName
}
#### Subscription
* type Subscription{Actor: onActorUpdate}


### Development Philosophy
* Schema First Approach
* Code First Approach

