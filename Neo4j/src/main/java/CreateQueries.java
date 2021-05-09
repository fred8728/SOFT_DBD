import org.neo4j.driver.*;

import java.util.HashMap;
import java.util.Map;

import static org.neo4j.driver.Values.parameters;

public class CreateQueries implements AutoCloseable{

    private final Driver driver;

    public CreateQueries(String uri, String username, String password){
        driver = GraphDatabase.driver(uri, AuthTokens.basic(username,password));
    }

    @Override
    public void close() throws Exception {
        driver.close();
    }

    public void createPersonNameOnly( final String name)
    {
        try ( Session session = driver.session() )
        {
            String person = session.writeTransaction( new TransactionWork<String>()
            {
                @Override
                public String execute( Transaction tx )
                {
                    Result result = tx.run( "CREATE (a:Person {name: $name}) RETURN a.name;",
                            parameters( "name", name) );
                    return result.single().get( 0 ).asString();
                }
            } );
            System.out.println("The following person was added successfully: " + person);
        }
    }

    public void createCompany(final String name, final String location, final String description)
    {
        try ( Session session = driver.session() )
        {
            String company = session.writeTransaction( new TransactionWork<String>()
            {
                @Override
                public String execute( Transaction tx )
                {
                    Map<String, Object> params = new HashMap<>();
                    params.put("name", name);
                    params.put("location", location);
                    params.put("description", description);

                    Result result = tx.run( "CREATE (a:Company {name:$name, location:$location, description: $description}) RETURN a.name;",
                            params);
                    return result.single().get( 0 ).asString();
                }
            } );
            System.out.println("The following company was added successfully: " + company);
        }
    }

    public void createPerson(final String name, final int birthyear, final String hobby)
    {
        try ( Session session = driver.session() )
        {
            String person = session.writeTransaction( new TransactionWork<String>()
            {
                @Override
                public String execute( Transaction tx )
                {
                    Map<String, Object> params = new HashMap<>();
                    params.put("name", name);
                    params.put("birthyear", birthyear);
                    params.put("hobby", hobby);

                    Result result = tx.run( "CREATE (a:Person {name: $name, birthyear: $birthyear, hobby: $hobby}) RETURN a.name;",
                            params);
                    return result.single().get( 0 ).asString();
                }
            } );
            System.out.println("The following person was added successfully: " + person);
        }
    }

    public static void main(String[] args) throws Exception {
        try(CreateQueries conn = new CreateQueries("neo4j://localhost:7687", "neo4j", "password" )){

            System.out.println("Method: createPersonByNameOnly() \n");
            conn.createPersonNameOnly("Tinka");
            System.out.println("____________________");
            System.out.println("Method: createCompany() \n");
            conn.createCompany("Dalle valle", "Taastrup", "Restaurant");
            System.out.println("____________________");
            System.out.println("Method: createPerson() \n");
            conn.createPerson("Søren", 1995, "Fodbold");
            System.out.println("____________________");
        }
    }
}
