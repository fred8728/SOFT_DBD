import org.neo4j.driver.*;

import java.util.HashMap;
import java.util.Map;

public class CreateRelationQueries implements AutoCloseable {
    private final Driver driver;

    public CreateRelationQueries(String uri, String username, String password){
        driver = GraphDatabase.driver(uri, AuthTokens.basic(username,password));
    }

    @Override
    public void close() throws Exception {
        driver.close();
    }

    public void createWorkInCompanyRelation( final String person, final String company)
    {
        try ( Session session = driver.session() )
        {
            String workInRelation = session.writeTransaction( new TransactionWork<String>()
            {
                @Override
                public String execute( Transaction tx )
                {
                    Map<String, Object> params = new HashMap<>();
                    params.put("person", person);
                    params.put("company", company);

                    Result result = tx.run("MATCH (n1:Person), (n2:Company) " +
                            "WHERE n1.name = $person AND n2.name = $company " +
                            "CREATE (n1)-[r: work_in ]->(n2)" +
                            "RETURN type(r);", params);
                    return result.single().get( 0 ).asString();
                }
            } );
            System.out.println(workInRelation);
        }
    }


    //Can not be used - it creates a directional relationship
    //It is not possible to create bidirectional relationship from here - dont know why
    public void createFamilyRelation( final String person1, final String person2)
    {
        try ( Session session = driver.session() )
        {
            String familyRelation = session.writeTransaction( new TransactionWork<String>()
            {
                @Override
                public String execute( Transaction tx )
                {
                    Map<String, Object> params = new HashMap<>();
                    params.put("person1", person1);
                    params.put("person2", person2);

                    Result result = tx.run("MATCH (n1:Person), (n2:Person) " +
                            "WHERE n1.name = $person1 AND n2.name = $person2 " +
                            "CREATE (n1)-[r: is_family ]->(n2)" +
                            "RETURN type(r);", params);
                    return result.single().get( 0 ).asString();
                }
            } );
            System.out.println(familyRelation);
        }
    }

    public static void main(String[] args) throws Exception {
        try(CreateRelationQueries conn = new CreateRelationQueries("neo4j://localhost:7687", "neo4j", "password")){
            System.out.println("Method: createWorkInCompanyRelation() \n");
            conn.createWorkInCompanyRelation("Søren", "Nilfisk");
            System.out.println("____________________");
        }
    }
}
