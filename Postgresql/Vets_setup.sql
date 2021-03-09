
DROP TABLE IF EXISTS petowner;
DROP TABLE IF EXISTS caretaker;
DROP TABLE IF EXISTS dogs;
DROP TABLE IF EXISTS cats;
DROP TABLE IF EXISTS pets;
DROP TABLE IF EXISTS vets;
DROP TABLE IF EXISTS addresses;
DROP TABLE IF EXISTS cities;
DROP TABLE IF EXISTS pets_caretakers;
DROP type IF EXISTS species;
DROP type IF EXISTS SIZE;

create type species as enum('Dog', 'Cat', 'Rabbit', 'Guinea pig', 'Hamster', 'Hedgehog');
create type size as enum('xs', 's', 'm', 'l');

CREATE TABLE cities 
(
    city_id int PRIMARY KEY,
    name varchar(30) NOT NULL
);

CREATE TABLE addresses 
(
    address_id SERIAL PRIMARY KEY,
    street varchar(100) NOT NULL,
    city_id int REFERENCES cities NOT NULL
);

CREATE TABLE vets
(
    vet_cvr char(8) PRIMARY KEY,
    name varchar(100) NOT NULL,
    address_id int REFERENCES addresses NOT NULL
);

CREATE TABLE caretakers
(
    caretaker_id SERIAL PRIMARY KEY,
    name varchar(100) NOT null,
    vet_cvr char(8) references vets not null,
    address_id int references addresses NOT NULL
);

CREATE table pets
(
    pet_id SERIAL PRIMARY KEY,
    name varchar(100) NOT NULL,
    dateofbirth date,
    type species,
    size size,
    vet_cvr char(8) REFERENCES vets NOT NULL
);

CREATE table pets_caretakers
(
    pet_id int REFERENCES pets (pet_id) on delete cascade,
    caretaker_id int REFERENCES caretakers (caretaker_id) on delete cascade,
    PRIMARY KEY (pet_id, caretaker_id)
);



