package testing;

import testing.generated.valuedomains.Active;
import testing.generated.valuedomains.Courses;
import testing.generated.valuedomains.Student;

public class Test {

    // + " \" \": "
    public String getStudentToString (Student student, Courses course, Active active){
        return "{ \n" + " \"student\": { \n" + " \"name\": " + student.name() + ",\n"  + " \"age\": " + student.age() + "\n },\n"
                + " \"courses\": [\n { \n" + " \"id\": " + course.id() + ",\n" + " \"name\": " + course.name() + ", \n" + " \"ects\": " + course.ects() + "\n }\n ], \n"
                + " \"active\": " + active.value() + "\n }";

    }
    public static void main(String[] args) {

        Student student1 = Student.create().name("Simone").age(25);
        Student student2 = Student.create().name("Frederik").age(23);
        Student student3 = Student.create().name("Emil").age(23);

        Courses course1 = Courses.create().id(1).name("Diskret matematik og algoritmer").ects(10);
        Courses course2 = Courses.create().id(2).name("Database").ects(10);
        Courses course3 = Courses.create().id(3).name("Udforskning og formidling").ects(10);

        Active activeTrue = Active.create(true);
        Active activeFalse = Active.create(false);

        Test test = new Test();
        System.out.println(test.getStudentToString(student1, course1, activeFalse));
    }
}
