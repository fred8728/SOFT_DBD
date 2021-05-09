import org.neo4j.driver.*;

import java.util.HashMap;
import java.util.Map;

public class UpdateQueries implements AutoCloseable {

    private final Driver driver;

    public UpdateQueries(String uri, String username, String password) {
        driver = GraphDatabase.driver(uri, AuthTokens.basic(username, password));
    }

    @Override
    public void close() throws Exception {
        driver.close();
    }

    public void updateCompanyDescription( final String company, final String description)
    {
        try ( Session session = driver.session() )
        {
            String update = session.writeTransaction( new TransactionWork<String>()
            {
                @Override
                public String execute( Transaction tx )
                {
                    Map<String, Object> params = new HashMap<>();

                    params.put("company", company);
                    params.put("description", description);

                    Result result = tx.run("MATCH (n1:Company)" +
                            "where n1.name = $company "  +
                            "SET n1.description = $description RETURN n1.name;", params);
                    return result.single().get(0).asString();
                }
            } );
            System.out.println("The company description is updated successfully");
            System.out.println("Updated company: " + update);
        }
    }

    public static void main(String[] args) throws Exception {
        try(UpdateQueries conn = new UpdateQueries("neo4j://localhost:7687", "neo4j", "password" )){

            System.out.println("Method: updateCompanyDescription() \n");
            conn.updateCompanyDescription("Dalle valle", "De har en stor billig buffet");
            System.out.println("____________________");
        }
    }
}
