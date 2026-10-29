package be.abis.courseadmin.test;

import be.abis.courseadmin.model.Company;
import be.abis.courseadmin.model.Course;
import be.abis.courseadmin.model.Person;

public class Test {
    public static void main(String[] args) {
        Course course1 = new Course("Java", 9, 450.0);
        course1.printInfo();
        //double reducePercent = 25;
        //System.out.println("Total price with " + reducePercent + " percent of reduction = " + course1.calculateTotalPrice(reducePercent));

        Company company1 = new Company("Abis");
        company1.printInfo();

        Person person1 = new Person("Mary", "Jones", company1);
        Person person2 = new Person("John", "Doe");
        person1.printInfo();
        person2.printInfo();

        Person[] persons = {person1, person2};

        //Person[] persons = new Person[3];
        //persons[0] = new Person("Mary", "Jones", company1);
        //persons[1] = new Person("John", "Doe");
        //persons[2] = new Person("Peter", "Parker");
        System.out.println("Number of persons created: " + Person.getCounter());
        for(Person person : persons) {
            person.printInfo();
        }

        person1.attendCourse(course1);
        person1.addHobby("Video games");
        person1.addHobby("Cinema");
        person1.addHobbies("Movies", "IT", "Tennis", "Basket", "Science", "Books", "Music", "Technology", "Biology");


        System.out.println("Hobbies of " + person1.getFirstName() + " " + person1.getLastName() +" : ");
        for(int i = 0; i < person1.getNbrHobbies(); i++) {
            System.out.println("Hobby " + (i + 1) + " : " + person1.getHobby(i));
        }


    }
}
