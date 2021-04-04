# Postgresql assignment

## Design
```
1. Create ER-diagram covering the domain

SOLUTION: ER-diagram.PNG

2. Pros and cons for different strategies
```

### Pros and cons for table-per-class strategy
#### Pros: 
- Logical inheritance solution - it mirrors the object model in the data model.
- A more clear overview - A table is defined for each class to store only the local attributes of that class.

#### Cons: 
- Polymorphic queries are expensive, requiring a union of 3 data sets (from each of the tables).


### Pros and cons for single-table strategy
#### Pros:
- Faster data search(?)
- Database structure is simpler (just one table)
- Queries are simpler
- Easier to manage and revise
- Removes duplicating fields

#### Cons:
Note: A single table relational database is more akin to a spreadsheet than a NoSQL database
- Table size will grow very fast
- Database structure isn't obvious
- Lots of null-able cells


## Conceptual level implementation
```
1. Create an SQL-script for a PostgreSQL™database that creates the tables accordingly. Bevare that the script should be reentrant.

SOLUTION: Vets_setup.sql 

2. Create an SQL-script with sample data for your tables. You should have at least two vetenarians, 
twenty pets of various kinds including some that are neither cats nor dogs, and ten caretakers some with common pets. 
Also this script should be reentrant.

SOLUTION: Vets_data.sql
```
## External level implementation
```
1. Create views and/or stored procedures to deal with the chosen inheritance strategy. It should be possible to:
• See cats and dogs as separate views
• See all pets as in the single table strategy
- Update cats and dogs with a single SQL call, stored procedure or update on a view with a trigger.

SOLUTION: Vets_view_stored

2. Create a script that creates a designated user for accessing the database and
revokes the rights for that user to access the underlying tables.

SOLUTION: Vets_designatedUser.sql
```
## Interface implementation
```
1. Create a simple program in Java or similar object oriented language that is
able to:
• retrieve a list of pets from the database. The types of instances of Pets
in the list should reflect the actual type:
– Pet
– Cat
– Dog
• insert a new Dog, Cat, and/or Pet in the database.
```
SOLUTION: [Vets](https://github.com/fred8728/SOFT_DBD/tree/master/Postgresql/Vets)
