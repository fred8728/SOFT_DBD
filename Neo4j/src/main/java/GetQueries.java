import org.neo4j.driver.*;

import java.util.ArrayList;

import static org.neo4j.driver.Values.parameters;

public class GetQueries implements AutoCloseable {

    private final Driver driver;

    public GetQueries(String uri, String username, String password) {
        driver = GraphDatabase.driver(uri, AuthTokens.basic(username, password));
    }

    @Override
    public void close() throws Exception {
        driver.close();
    }

    public void getPersonById( final int id)
    {
        try ( Session session = driver.session() )
        {
            String person = session.readTransaction( new TransactionWork<String>()
            {
                @Override
                public String execute( Transaction tx )
                {
                    Result result = tx.run("MATCH (n) WHERE id(n) = $id return n.name;", parameters("id", id));
                    return result.single().get(0).asString();
                }
            } );
            System.out.println("Name of person with given id is: " + person );
        }
    }

    public void getAllPeople()
    {
        try ( Session session = driver.session() )
        {
            ArrayList <String> people = session.readTransaction( new TransactionWork<ArrayList>()
            {
                @Override
                public ArrayList execute( Transaction tx )
                {
                    ArrayList<String> list = new ArrayList<>();
                    tx.run( "MATCH (n) return n;").list().forEach(person -> {
                        String p = "Name:" + person.get("n").get("name").toString()
                                + " Birthyear: " +  person.get("n").get("birthyear").toString()
                                + " Hobby: " + person.get("n").get("hobby").toString();
                        list.add(p);
                    });
                    return list;
                }
            } );
            for (String p : people){
                System.out.println(p.toString());
            }
        }
    }

    public void getListOfPeopleWithSpecificName( final String name )
    {
        try ( Session session = driver.session() )
        {
            ArrayList<String> people = session.readTransaction(new TransactionWork<ArrayList>()
            {
                @Override
                public ArrayList execute( Transaction tx )
                {
                    ArrayList list = new ArrayList();
                    tx.run("MATCH (n) WHERE n.name = $name RETURN n, n.name",
                            parameters("name", name)).list().forEach(person -> {
                        String p = "Name:" + person.get("n").get("name").toString()
                                + " Birthyear: " +  person.get("n").get("birthyear").toString()
                                + " Hobby: " + person.get("n").get("hobby").toString();
                        list.add(p);

                    });
                    return list;
                }
            });
            for (String p: people){
                System.out.println(p.toString());
            }
        }
    }

    public static void main(String[] args) throws Exception {
        try(GetQueries conn = new GetQueries("neo4j://localhost:7687", "neo4j", "password" )){

            System.out.println("Method: getPersonById() \n");
            conn.getPersonById(1);
            System.out.println("____________________");
            System.out.println("Method: getAllPeople() \n");
            conn.getAllPeople();
            System.out.println("____________________");
            System.out.println("Method: getListOfPeopleWithSpecificName() \n");
            conn.getListOfPeopleWithSpecificName("Mille");
            System.out.println("____________________");
        }
    }
}
