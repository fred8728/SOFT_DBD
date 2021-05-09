import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.Transaction;
import org.neo4j.driver.TransactionWork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.neo4j.driver.Values.parameters;

public class DeleteQueries implements AutoCloseable
{
    private final Driver driver;

    public DeleteQueries(String uri, String username, String password )
    {
        driver = GraphDatabase.driver( uri, AuthTokens.basic( username, password ) );
    }

    @Override
    public void close() throws Exception
    {
        driver.close();
    }

    public void deletePersonById(final int id)
    {
        try ( Session session = driver.session() )
        {
            Result res = session.run("MATCH (n) WHERE id(n) =$id DETACH DELETE n", parameters("id", id));
        }
        System.out.println("Person with given id: " + id + " is successfully deleted");
    }

    public static void main(String[] args) throws Exception {
        try(DeleteQueries conn = new DeleteQueries("neo4j://localhost:7687", "neo4j", "password" )){

            System.out.println("Method: deletePersonById() \n");
            conn.deletePersonById(10);
            conn.deletePersonById(11);
            System.out.println("____________________");

        }
    }
}
