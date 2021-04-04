
# Assignment 1 - Postgresql
## [Assignment PDF ](https://github.com/fred8728/SOFT_DBD/blob/master/Postgresql/PostgresSQL_assignment1.pdf)


## Design
* [ER-diagram](https://github.com/fred8728/SOFT_DBD/blob/master/Postgresql/ER-diagram.PNG)

### Pros and cons for different strategies

### Table-per-class strategy
```
# Pros: 
- Logical inheritance solution - it mirrors the object model in the data model.
- A more clear overview - A table is defined for each class to store only the local attributes of that class.

# Cons: 
- Polymorphic queries are expensive, requiring a union of 3 data sets (from each of the tables).
```

### Single-table strategy
```
#Pros:
- Faster data search(?)
- Database structure is simpler (just one table)
- Queries are simpler
- Easier to manage and revise
- Removes duplicating fields

# Cons:
Note: A single table relational database is more akin to a spreadsheet than a NoSQL database
- Table size will grow very fast
- Database structure isn't obvious
- Lots of null-able cells
```

## Conceptual level implementation

* [Setup](https://github.com/fred8728/SOFT_DBD/blob/master/Postgresql/Vets_setup.sql)
* [Data for database](https://github.com/fred8728/SOFT_DBD/blob/master/Postgresql/Vets_data.sql)

## External level implementation

* [View and stored procedures](https://github.com/fred8728/SOFT_DBD/blob/master/Postgresql/Vets_view_stored.sql)
* [Designated user](https://github.com/fred8728/SOFT_DBD/blob/master/Postgresql/Vets_designatedUser.sql) 

## Interface implementation

Solution: [Vets implementation in Java](https://github.com/fred8728/SOFT_DBD/tree/master/Postgresql/Vets)
