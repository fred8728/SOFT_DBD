import java.sql.*;
import java.util.Properties;

public class ListOfPets {

    public static void main(String[] args) throws Exception{
        System.out.println("List of Pets");
        System.out.println("______________");
        ListOfPets connector = new ListOfPets();
        connector.getAllPets();
    }

    public void getAllPets() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/soft2021";
        Properties props = new Properties();
        props.setProperty("user","softdb");
        props.setProperty("password","softdb");
        try (Connection conn = DriverManager.getConnection(url, props)) {
            String sql = "SELECT pet_id, name, dateofbirth, type, size, vet_cvr FROM vets.pets;";
            PreparedStatement statement = conn.prepareStatement(sql);
            try(ResultSet result = statement.executeQuery()) {
                while (result.next()) {
                    System.out.println("Id: "+result.getInt(1)+"\nName: "+result.getString(2) + "\nDateOfBirth: " + result.getDate(3) + "\nType: " + result.getString(4) + "\nSize: " + result.getString(5) + "\nVet_cvr: " +  result.getString(6) + "\n \n") ;
                }
            }
        }
    }
}
