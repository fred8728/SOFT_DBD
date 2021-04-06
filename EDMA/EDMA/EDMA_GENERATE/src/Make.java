import org.abstractica.edma.generator.EdmaGenerator;

public class Make {
    public static void main(String[] args) {
        String projectDirectory = "C:\\Users\\fskn\\Documents\\Softwareudvikling\\1 semester\\Database\\Github_repo\\EDMA\\EDMA";
        EdmaGenerator generator = new EdmaGenerator("EDMA", projectDirectory + "/edmasrc", projectDirectory+"/src", "testing");
        generator.make();
    }
}
