package info5100;

import java.util.ArrayList;
import java.util.List;

public class Course {
    public static final int COURSE_CAPACITY = 10;

    private String name;
    private int numberOfStudent;
    private List<Student> registeredStudent = new ArrayList<>();

    public Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfStudent() {
        return numberOfStudent;
    }

    public void register(Student student) {
        if(!isFull()){
            registeredStudent.add(student);
            numberOfStudent++;
            System.out.println(" Number of Student : " + numberOfStudent);
        } else {
            System.out.println("Sorry, the course is full!");
        }

    }

    public List<Student> getStudents() {
        return registeredStudent;
    }

    public boolean isFull(){
        if(registeredStudent.size() < COURSE_CAPACITY) {
            return false;
        } else {
            return true;
        }
    }
}
