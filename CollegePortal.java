abstract class Person {
    String name;
    String id;

 
    Person(String name, String id) {
        this.name = name;
        this.id = id;
    }


    abstract String getRole();


    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}


interface Login {
    boolean login(String username, String password);
}


class Student extends Person implements Login {
    private String username;
    private String password;

    Student(String name, String id, String username, String password) {
        super(name, id);
        this.username = username;
        this.password = password;
    }

    @Override
    String getRole() {
        return "Student";
    }

    @Override
    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
}


class Faculty extends Person implements Login {
    private String username;
    private String password;

    Faculty(String name, String id, String username, String password) {
        super(name, id);
        this.username = username;
        this.password = password;
    }

    @Override
    String getRole() {
        return "Faculty";
    }

    @Override
    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
}


public class CollegePortal {
    public static void main(String[] args) {

        Person student = new Student("Alice", "S101", "alice123", "pass123");
        Person faculty = new Faculty("Dr. Smith", "F202", "smith001", "admin202");

        Person[] people = {student, faculty};

        for (Person p : people) {
            p.displayInfo();
            System.out.println("Role: " + p.getRole());

            Login loginUser = (Login) p;
            System.out.println("Login Attempt: " +
                    (loginUser.login("alice123", "pass123") ? "Successful" : "Failed"));
            System.out.println();
        }
    }
}
