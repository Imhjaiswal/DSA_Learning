public class Student {
    // Attributes
    public int id;
    public int age;
    public String name;
    public int nos;
    private String gf;

    // Default Constructor
    // It sets attribute value to garbage
    // public Student() {
    //     System.out.println("Student is default Constructor");
    // }

    // Parameterized Constructor
    public Student (int id, int age, int nos, String name, String gf) {
        // System.out.println("Parameterized Student Constructor");
        this.id = id;
        this.name = name;
        this.nos = nos;
        this.age = age;
        this.gf = gf;
    }

    // COPY Constructor
    public Student(Student srcObj) {
        System.out.println("Copy Constructor");
        this.id = srcObj.id;
        this.age = srcObj.age;
        this.name = srcObj.name;
        this.nos = srcObj.nos;
        this.gf = srcObj.gf;
    }

    // Behaviour / Methods / Functions
    public void Study() {
        System.out.println(name+" Studying");
    }

    public void Sleep() {
        System.out.println(name+" Sleeping");
    }

    public void Bunk() {
        System.out.println(name+" is bunking");
    }

    // ENCAPSULATION
    private void gfChatting() {
        System.out.println(name+" chatting with gf");
    }

    // GET
    public String getGfName() {
        return this.gf;
    }
    // SET
    public void setAge (int newAge) {
        if (newAge <= 0 && newAge >= 100) {
            this.age = newAge;
        }
        return;
    }
}