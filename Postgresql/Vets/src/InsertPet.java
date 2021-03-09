import java.sql.*;
import java.util.Properties;

public class InsertPet {

    public static void main(String[] args) throws Exception{
        System.out.println("Add new dog");
        System.out.println("______________");
        InsertPet connector = new InsertPet();
        long millis=System.currentTimeMillis();
        java.sql.Date date=new java.sql.Date(millis);
        connector.insertPet("Emil", date, Species.Cat, Size.m, "12345678");
    }

    enum Species {
    Dog, Cat, Rabbit, Hamster, Hedgehog
    }

    enum Size {
        xs, s, m, l
    }
    public void insertPet(String name, Date dateOfBirth, Species type, Size size, String vet_cvr) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/soft2021";
        Properties props = new Properties();
        props.setProperty("user","softdb");
        props.setProperty("password","softdb");
        try (Connection conn = DriverManager.getConnection(url, props)) {
            String sql = "INSERT INTO vets.pets (name, dateofbirth, TYPE, SIZE, vet_cvr) VALUES (?,?,?,?,?);";

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, name);
            statement.setDate(2, dateOfBirth);
            statement.setObject(3, type.name(), Types.OTHER);
            statement.setObject(4, size.name(), Types.OTHER);
            statement.setString(5, vet_cvr);
            statement.executeUpdate();
        }
    }
}
