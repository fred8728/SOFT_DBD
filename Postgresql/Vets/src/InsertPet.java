import java.sql.*;
import java.util.Properties;

public class InsertPet {

    private static String url = "jdbc:postgresql://localhost:5432/soft2021";

    public static void main(String[] args) throws Exception{

        System.out.println("______________");
        System.out.println("Trying to insert pet...");

        Pet pet = new Pet(0,"Kirsten", getTodaysDate(), Species.Rabbit, Size.xs, "23456789");
        insertPet(pet);
        System.out.println("Pet is now inserted successfully");
        System.out.println("___________________");
    }

    private static Date getTodaysDate(){
        long millis=System.currentTimeMillis();
        java.sql.Date date=new java.sql.Date(millis);
        return date;
    }

    private static void insertPet(Pet pet) throws SQLException {
        Properties props = new Properties();
        props.setProperty("user","softdb");
        props.setProperty("password","softdb");
        try (Connection conn = DriverManager.getConnection(url, props)) {
            String sql = "INSERT INTO vets.pets (name, dateofbirth, TYPE, SIZE, vet_cvr) VALUES (?,?,?,?,?);";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, pet.getName());
            statement.setDate(2, pet.getDateOfBirth());
            statement.setObject(3, pet.getType(), Types.OTHER);
            statement.setObject(4, pet.getSize(), Types.OTHER);
            statement.setString(5, pet.getVet_cvr());
            statement.executeUpdate();
        }
    }
}
