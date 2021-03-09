CREATE USER fskn;
CREATE ROLE intern;

-- Grant privileges to a role
-- Grant connect to database 
GRANT CONNECT ON DATABASE soft2021 TO intern;

-- Grant usage on schema
GRANT USAGE ON SCHEMA vets TO intern;

-- Grant select to tables 
GRANT SELECT
ON ALL TABLES
IN SCHEMA vets
TO intern;

-- Grant a role to users
GRANT intern TO fskn;

-- EXTRA -  revoke privilege from role
REVOKE CREATE TABLE FROM manager;

--EXTRA remove role
DROP ROLE manager;

SELECT * FROM vets.pets;










