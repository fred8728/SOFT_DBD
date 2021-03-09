
-- Cities
INSERT INTO cities (city_id, name) 
VALUES 
(2670, 'Greve'), 
(2635, 'Ishøj'), 
(1107, 'København k'),
(7600, 'Struer'),
(7430, 'Ikast'),
(7500, 'Holstebro');

-- Addresses
INSERT INTO addresses (street, city_id) 
VALUES 
('Mosede landevej 12', 2670), 
('Grønnegade 3', 1107),
('Ishøj Stationsvej 44', 2635),
('Sandværksvej 4', 7600),
('Cecilievej 1', 7430),
('Kalenin 66', 7500);

-- Minimum 2 vets

INSERT INTO vets (vet_cvr, name, address_id)
VALUES
('12345678', 'Bo Hansen', 1),
('23456789', 'Marianne Nielsen', 1),
('34567812', 'Thomas Nilsson', 2),
('45678912', 'Frederikke Thomsen', 2);

-- 20 pets of different kind
INSERT INTO pets (name, dateofbirth, TYPE, SIZE, vet_cvr)
VALUES
('Bella', '2020-05-28', 'Dog', 'l', '12345678'),
('Carla', '2018-04-17', 'Dog', 'm', '12345678'),
('Spot', '2016-12-22', 'Dog', 'l', '12345678'),
('Chico', '2016-12-18', 'Cat', 'm', '12345678'),
('Andrea', '2015-10-23', 'Cat', 'm', '12345678'),
('Fido', '2010-08-02', 'Cat', 'm', '12345678'),
('Molly', '2020-07-01', 'Rabbit', 's', '23456789'),
('Hector', '2021-07-22', 'Hamster', 'xs', '23456789'),
('Tiga', '2021-06-09', 'Cat', 'm', '23456789'),
('Timo', '2020-01-07', 'Dog', 'l', '23456789'),
('Mulle', '2020-03-22', 'Dog', 'm', '23456789'),
('Victor', '2018-02-28', 'Dog', 'm', '23456789'),
('Thor', '2021-05-28', 'Hedgehog', 'xs', '34567812'),
('Birte', '2021-04-12', 'Hedgehog', 'xs', '34567812'),
('Sami', '2016-12-23', 'Cat', 'm', '34567812'),
('Lola', '2011-02-09', 'Cat', 'm', '34567812'),
('Pippi', '2014-11-03', 'Dog', 'l', '34567812'),
('Pitte', '2015-03-11', 'Dog', 'l', '34567812'),
('Teiz', '2015-07-11', 'Dog', 'm', '45678912'),
('Dagmar', '2020-07-12', 'Dog', 'm', '45678912'),
('Ole', '2019-05-03', 'Dog', 'm', '45678912'),
('Peter', '2019-11-02', 'Guinea pig', 'xs', '45678912'),
('Carla', '2019-12-13', 'Cat', 'm', '45678912'),
('Oscar', '2013-10-22', 'Cat', 'm', '45678912'),
('Bella', '2020-10-12', 'Rabbit', 's', '45678912');

-- 10 caretakers where some have common pets
INSERT INTO caretakers (name, vet_cvr, address_id)
VALUES
('Malene Fjer', '12345678', 1),
('Caroline Simson', '12345678', 1),
('Andrea Hansen', '12345678', 1),
('Brian Thomsen', '23456789', 1),
('Martin Fred', '23456789', 1),
('Frederikke Jensen', '23456789', 1),
('Lone Espersen', '34567812', 2),
('Kaj Hansen', '34567812', 2),
('Tim Andersen', '34567812', 2),
('Cecilie Thomsen', '45678912', 2),
('Malene Nielsen', '45678912', 2),
('Malene Andersen', '45678912', 2);

-- Relations between caretakers and pets
INSERT INTO pets_caretakers (pet_id, caretaker_id)
VALUES
(1,1),
(1,2),
(2,2),
(2,3),
(3,2),
(3,1),
(4,3),
(4,1),
(5,3),
(5,1),
(6,3),
(6,2),
(6,1),
(7,4),
(7,5),
(7,6),
(8,4),
(9,5),
(9,4),
(10,5),
(11,6),
(11,4),
(12,6),
(12,5),
(13,7),
(13,8),
(13,9),
(14,8),
(15,9),
(14,7),
(15,8),
(16,8),
(17,7),
(16,7),
(18,8),
(18,7),
(17,9),
(18,9),
(19,11),
(19,12),
(20,12),
(19,10),
(20,11),
(21,12),
(21,10),
(22,11),
(22,10),
(23,11),
(23,10),
(23,12),
(24,11),
(24,12),
(25,10),
(25,11);