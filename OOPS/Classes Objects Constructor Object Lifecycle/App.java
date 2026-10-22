public class App {
    public static void main(String[] args) throws Exception {
        // Default Constructor
        // Student A = new Student();
        // System.out.println(A.name);
        // A.name = "Harsh";
        // A.id = 28;
        // A.nos = 7;
        // A.age = 24;
        // A.gf = "abc";

        // System.out.println("A : "+A);

        // System.out.println(A.name);
        // System.out.println(A.id);
        // System.out.println(A.age);
        // System.out.println(A.nos);

        // A.Bunk();
        // A.Study();
        // A.Sleep();

        // Parameterized Constructor
        // Student A = new Student(28, 25, 7, "Harsh","abc");
        // System.out.println("A : "+A);

        // System.out.println(A.name);
        // System.out.println(A.id);
        // System.out.println(A.age);
        // System.out.println(A.nos);

        // A.Bunk();
        // A.Study();
        // A.Sleep();


        // COPY Constructor
        Student A = new Student(28, 25, 7, "Harsh","abc");
        Student B = new Student(A);

        System.out.println(B.name);
        System.out.println(B.id);
        System.out.println(B.age);
        System.out.println(B.nos);
        // System.out.println(B.gf); // This won't work because of Encapsulation
        System.out.println(B.getGfName());

        B.setAge(24);
        System.out.println(B.age);

        B.Bunk();
        B.Study();
        B.Sleep();
    }   
}