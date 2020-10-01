package info5100;

public class Test {
    public static void main(String[] args){
        Student student1 = new Student("Joyce", "137");
        Student student2 = new Student("Bill", "148");
        Student student3 = new Student("Ada", "333");
        Student student4 = new Student("Cindy", "457");
        Student student5 = new Student("Debby", "598");
        Student student6 = new Student("Emma", "699");
        Student student7 = new Student("Fiona", "708");
        Student student8 = new Student("Gill", "800");
        Student student9 = new Student("Amy", "901");
        Student student10 = new Student("Ann", "105");
        student10.setId("999");
        student10.setName("Gilbert");
        Student student11 = new Student("Vivi", "113");

        Course cs101 = new Course("CS101");
        cs101.register(student1);
        cs101.register(student2);
        cs101.register(student3);
        cs101.register(student4);
        cs101.register(student5);
        cs101.register(student6);
        cs101.register(student7);
        cs101.register(student8);
        cs101.register(student9);
        cs101.register(student10);
        cs101.register(student11);

        System.out.println("Course " + cs101.getName() + " has " + cs101.getNumberOfStudent() + " students registered.");

        cs101.getStudents().forEach(student -> System.out.println(student.getId() + ": " + student.getName()));

        Professor professor = new Professor.Builder("Ashley", "Alexander")
                .setId("1357")
                .build();
    }
}
