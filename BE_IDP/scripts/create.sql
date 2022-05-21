drop table if exists photos cascade;
drop sequence if exists photos_id_seq;
create sequence photos_id_seq start 1 increment 1;
create table photos (
                        photo_id int8 not null,
                        photo oid,
                        primary key (photo_id)
);

drop table if exists users cascade;
drop sequence if exists users_id_seq;
create sequence users_id_seq start 1 increment 1;
create table users (
                       user_id int8 not null,
                       email varchar(255),
                       first_name varchar(255),
                       last_name varchar(255),
                       primary key (user_id),
                       UNIQUE (email)
);

drop table if exists countries cascade;
drop sequence if exists countries_id_seq;
create sequence countries_id_seq start 1 increment 1;
create table countries (
                       country_id int8 not null,
                       name varchar(255),
                       primary key (country_id),
                       UNIQUE (name)
);

alter table if exists cities drop constraint if exists FK_city_country;
drop table if exists cities cascade;
drop sequence if exists cities_id_seq;
create sequence cities_id_seq start 1 increment 1;
create table cities (
                        city_id int8 not null,
                        name varchar(255),
                        country_id int8,
                        primary key (city_id)
);
alter table if exists cities
    add constraint FK_city_country
        foreign key (country_id)
            references countries;

drop table if exists shelters cascade;
drop sequence if exists shelters_id_seq;
create sequence shelters_id_seq start 1 increment 1;
create table shelters (
                       shelter_id int8 not null,
                       description TEXT,
                       name varchar(255),
                       number_of_booked_slots int8,
                       phone varchar(255),
                       total_number_of_slots int8,
                       city_id int8,
                       photo_id int8,
                       primary key (shelter_id)
);