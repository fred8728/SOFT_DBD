
-- Look up all pets
CREATE VIEW allPets AS SELECT * FROM vets.pets;

SELECT * FROM allpets;

-- Look up all cats and dogs
CREATE VIEW dogs AS SELECT * FROM vets.pets WHERE TYPE ='Dog';
CREATE VIEW cats AS SELECT * FROM vets.pets WHERE TYPE ='Cat';

SELECT * FROM cats;

-- Update vet of pet
CREATE PROCEDURE updateVet(cvr char(8), id int)
AS $$
BEGIN
	UPDATE vets.pets 
	SET vet_cvr = cvr
	WHERE pet_id = id;
END;
$$ LANGUAGE plpgsql;

-- Call procedure
-- CALL updateVet('23456789', 1); 