package edu.northeastern.Joyce;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
     * The deadline of this assignment is 09/25/2020 23:59 PST.
     * Please feel free to contact Yafei and Yaqi for any questions.
     */
    class Employee {
        String name;
        int age;
        Gender gender;
        double salary;// salary per month

        // Constructor. Please set all the data in constructor.
        public Employee(String name, int age, Gender gender, double salary) {
            //write your code here
            this.name = name;
            this.age = age;
            this.gender = gender;
            this.salary = salary;

        }

        // Getter for `name`. Return the current `name` data
        public String getName() {
            //write your code here
            return name;
        }


    // Setter for `name`. Set `name` data
        public void setName(String name) {
            //write your code here
            this.name = name;
        }

        public void raiseSalary(double byPercent) {
            salary += salary /100 * byPercent;
        }

    }

    enum Gender {
        MALE,
        FEMALE;
    }

        public class Assignment2part1 {
        /**
         * Write a method to calculate the Social Security Tax of an employee and print it.
         * If the salary is less than or equal to 8900, the Social Security Tax is 6.2% of the salary.
         * If the salary is more than 8900, the Social Security Tax is 6.2% of 106,800.
         */
        public double socialSecurityTax(Employee employee) {
            double socialSecurityTax;

            if(employee.salary <= 8900){
                socialSecurityTax = employee.salary * 0.062;
            }else{
                //I think the question here means when an employee gets salary more than 8900,
                //will pay ANNUAL social security tax 6.2% of 106800, that is 6.2% of 8900 monthly
                //If it is calculated as described in the question,
                //when an employee get salary of 8900, he/she needs to pay tax 8900 * 6.2% = 551.8
                //when an employee get salary of 8901, he/she needs to pay tax 106800 * 6.2% = 6621.6
                //It's not fair
                socialSecurityTax = 106800/12 * 0.062;
            }
            return socialSecurityTax;
        }

        /**
         * Write a method to calculate an employee's contribution for insurance coverage and print it.
         * Amount of deduction is computed as follows:
         * If the employee is under 35, rate is 3% of salary; if the employee is between 35 and 50(inclusive), rate is 4% of salary;
         * If the employee is between 50 and 60(exclusive), rate is 5% of salary; If the employee is above 60, rate is 6% of salary.
         */
        public double insuranceCoverage(Employee employee) {

            double deduction;

            if(employee.age < 35) {
                deduction = employee.salary * 0.03;
            } else if(employee.age <= 50 ){
                deduction = employee.salary * 0.04;
            } else if(employee.age < 60){
                deduction = employee.salary * 0.05;
            } else {
                deduction = employee.salary * 0.06;
            }

            System.out.println(employee.getName() + deduction);
            return deduction;
        }

        /**
         * Write a method to sort three employees' salary from low to high, and then print their name in order.
         * For example, Alice's salary is 1000, John's salary is 500, Jenny's salary is 1200, you should print:
         * John Alice Jenny
         */
        public void sortSalary(Employee e1, Employee e2, Employee e3) {
            //write your code here
            List<Employee> employees = new ArrayList<>();
            employees.add(e1);
            employees.add(e2);
            employees.add(e3);
            employees.sort(new Comparator<Employee>() {
                @Override
                public int compare(Employee o1, Employee o2) {
                    return Double.compare(o1.salary, o2.salary);
                }
            });
            for(Employee employee: employees){
                System.out.println(employee.name);
            }

        }

        /**
         * Write a method to raise an employee's salary to three times of his/her original salary.
         * Eg: original salary was 1000/month. After using this method, the salary is 3000/month.
         * Do not change the input of this method.
         * Try to add a new method in Employee class: public void raiseSalary(double byPercent)
         */
        public void tripleSalary(Employee employee) {

            employee.raiseSalary(200.0);

            }


        //Extra credit

        /**
         * I have written some code below. What I want is to swap two Employee objects.
         * One is Jenny and one is John. But after running it, I got the result below:
         * Before: a=Jenny
         * Before: b=John
         * After: a=Jenny
         * After: b=John
         * There is no change after swap()! Do you know the reason why my swap failed?
         * Write your understanding of the reason and explain it.
         */
    /*
     write your understanding here.
     Java is always passing by value not by reference
     The value a within main is not changed in the function swap with the Employee temp as the object reference is passed by value.
     If it were passed by reference, then the a in main would return "John" after the call to swap.
    */
        public static void main(String[] args) {
            Employee a = new Employee("Jenny", 20, Gender.FEMALE, 2000);
            Employee b = new Employee("John", 30, Gender.MALE, 2500);
            System.out.println("Before: a=" + a.getName());
            System.out.println("Before: b=" + b.getName());
//            swap(a, b);
            Employee temp = a;
            a = b;
            b = temp;
            System.out.println("After: a=" + a.getName());
            System.out.println("After: b=" + b.getName());

            //test case
            //raiseSalary
            a.raiseSalary(200);
            System.out.println(a.salary);
            //sortSalary
            Employee c = new Employee("Joyce", 30, Gender.MALE, 8901);
            Assignment2part1 assignment = new Assignment2part1();
            assignment.sortSalary(a,c,b);
            double social = assignment.socialSecurityTax(c);
            //insuranceCoverage
            assignment.insuranceCoverage(c);

        }

//        public static void swap(Employee x, Employee y) {
//            Employee temp = x;
//            x = y;
//            y = temp;
//        }
    }

