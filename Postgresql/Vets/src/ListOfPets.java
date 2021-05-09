import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class ListOfPets {

    private static String url = "jdbc:postgresql://localhost:5432/soft2021";
    public static void main(String[] args) throws Exception{
        System.out.println("List of Pets");

        for( Pet p: getAllPets()){
            System.out.println(p.toString());
        }
    }

    private static ArrayList<Pet> getAllPets() throws SQLException {
        ArrayList<Pet> pets = new ArrayList<>();
        Properties props = new Properties();
        props.setProperty("user","softdb");
        props.setProperty("password","softdb");
        try (Connection conn = DriverManager.getConnection(url, props)) {
            String sql = "SELECT pet_id, name, dateofbirth, type, size, vet_cvr FROM vets.pets;";
            PreparedStatement statement = conn.prepareStatement(sql);
            try(ResultSet result = statement.executeQuery()) {
                while (result.next()) {
                    Pet p = new Pet(result.getInt(1),result.getString(2),result.getDate(3),Species.valueOf(result.getString(4)),Size.valueOf(result.getString(5)),result.getString(6)) ;
                    pets.add(p);
                }
            }
        }
        return pets;
    }
}
