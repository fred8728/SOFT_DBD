import java.sql.Date;

public class Pet {

    private int id;
    private String name;
    private Date dateOfBirth;
    private Species type;
    private Size size;
    private String vet_cvr;

    public Pet(int id, String name, Date dateOfBirth, Species type, Size size, String vet_cvr) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.type = type;
        this.size = size;
        this.vet_cvr = vet_cvr;
    }

    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Species getType() {
        return type;
    }

    public Size getSize() {
        return size;
    }

    public String getVet_cvr() {
        return vet_cvr;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", type=" + type +
                ", size=" + size +
                ", vet_cvr='" + vet_cvr + '\'' +
                '}';
    }
}
