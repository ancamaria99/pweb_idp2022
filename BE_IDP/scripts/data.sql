-- Add Users
INSERT INTO users (user_id, email, first_name, last_name) VALUES (nextval('users_id_seq'), 'hidan@email.com', 'Hidan', 'Jashin');

-- Add Countries
INSERT INTO countries (country_id, name) VALUES (nextval('countries_id_seq'), 'Romania');
INSERT INTO countries (country_id, name) VALUES (nextval('countries_id_seq'), 'France');
INSERT INTO countries (country_id, name) VALUES (nextval('countries_id_seq'), 'Italy');
INSERT INTO countries (country_id, name) VALUES (nextval('countries_id_seq'), 'Austria');
INSERT INTO countries (country_id, name) VALUES (nextval('countries_id_seq'), 'Switzerland');
INSERT INTO countries (country_id, name) VALUES (nextval('countries_id_seq'), 'Canada');
INSERT INTO countries (country_id, name) VALUES (nextval('countries_id_seq'), 'USA');
INSERT INTO countries (country_id, name) VALUES (nextval('countries_id_seq'), 'Andorra');

-- Add Cities
INSERT INTO cities (city_id, name, country_id) VALUES (nextval('cities_id_seq'), 'Bucharest', 1);
INSERT INTO cities (city_id, name, country_id) VALUES (nextval('cities_id_seq'), 'Constanta', 1);
INSERT INTO cities (city_id, name, country_id) VALUES (nextval('cities_id_seq'), 'Rome', 3);
INSERT INTO cities (city_id, name, country_id) VALUES (nextval('cities_id_seq'), 'Paris', 2);

-- Add Shelters
INSERT INTO shelters (shelter_id, description, name, number_of_booked_slots, phone, total_number_of_slots, city_id, photo_id) VALUES
    (nextval('shelters_id_seq'), 'This is a shelter in Bucharest', 'My First Shelter', 20, '0712345676', 45, 1, null);
INSERT INTO shelters (shelter_id, description, name, number_of_booked_slots, phone, total_number_of_slots, city_id, photo_id) VALUES
    (nextval('shelters_id_seq'), 'This is the second shelter in Bucharest', 'My Second Shelter', 40, '0712345666', 40, 1, null);
INSERT INTO shelters (shelter_id, description, name, number_of_booked_slots, phone, total_number_of_slots, city_id, photo_id) VALUES
    (nextval('shelters_id_seq'), 'This is the second shelter in Constanta', 'My Constanta Shelter', 40, '0712335666', 40, 2, null);
INSERT INTO shelters (shelter_id, description, name, number_of_booked_slots, phone, total_number_of_slots, city_id, photo_id) VALUES
    (nextval('shelters_id_seq'), 'This is a shelter in Rome', 'My Third Shelter', 20, '0712345671', 45, 3, null);
INSERT INTO shelters (shelter_id, description, name, number_of_booked_slots, phone, total_number_of_slots, city_id, photo_id) VALUES
    (nextval('shelters_id_seq'), 'This is the second shelter in Rome', 'My Fourth Shelter', 40, '0712345662', 40, 3, null);
INSERT INTO shelters (shelter_id, description, name, number_of_booked_slots, phone, total_number_of_slots, city_id, photo_id) VALUES
    (nextval('shelters_id_seq'), 'This is a shelter in Paris', 'My Paris Shelter', 20, '0712335671', 45, 4, null);
INSERT INTO shelters (shelter_id, description, name, number_of_booked_slots, phone, total_number_of_slots, city_id, photo_id) VALUES
    (nextval('shelters_id_seq'), 'This is the second shelter in Paris', 'My Paris Shelter 2', 40, '0732345662', 40, 4, null);