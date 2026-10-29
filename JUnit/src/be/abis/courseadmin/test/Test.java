package be.abis.courseadmin.test;

import be.abis.courseadmin.enumeration.Gender;
import be.abis.courseadmin.model.*;
import be.abis.courseadmin.repository.CompanyRepository;
import be.abis.courseadmin.repository.MemoryArrayCompanyRepository;

public class Test {

    public static void main(String[] args) {

        MemoryArrayCompanyRepository memoryArrayCompanyRepository = new MemoryArrayCompanyRepository();
        CompanyRepository companyRepository = (CompanyRepository)memoryArrayCompanyRepository;

        memoryArrayCompanyRepository.printInfo();
        System.out.println("");
        companyRepository.addCompany(new Company("Youtube", 10));
        memoryArrayCompanyRepository.printInfo();
        System.out.println("");
        companyRepository.deleteCompany(4);
        memoryArrayCompanyRepository.printInfo();
        System.out.println("");
        Company cToUpdate = companyRepository.findCompany(1);
        cToUpdate.setName("New name");
        companyRepository.updateCompany(cToUpdate);
        memoryArrayCompanyRepository.printInfo();
        System.out.println("");



        Course course1 = new Course("Java",5,500);
        Course course2 = new Course("TDD",2,450);

        //Company comp1 = new Company("Abis");
        //Company comp2 = new Company("IBM");
        Company comp1 = companyRepository.findCompany("Abis");
        Company comp2 = companyRepository.findCompany("IBM");

        Person p1 = new Person("Mary","Jones", Gender.FEMALE, comp1);
        Person p2=new Person("John","Doe", Gender.MALE);
        companyRepository.addCompany(new Company("TTL", 11));
        Person p3 = new Person("Bob","Janssens", Gender.OTHER, companyRepository.findCompany("TTL"));



        System.out.println("\n------------------------ExB4.8 Services abstract----------------------------------");
        CompanySession companySession1 = new CompanySession(course2,"5/10/2022",comp1,p3,comp2);
        CompanySession companySession2 = new CompanySession(course1,"7/11/2022",comp2,p1,comp2,5);
        PublicSession publicSession = new PublicSession(course2,"22/11/2022",comp1,p3);

       Consultancy consultancy = new Consultancy();
        Service[] services = {companySession1,consultancy,companySession2,publicSession};
        for (Service s : services){
            if (s instanceof Session){
                ((Session) s).printInfo();
            }
            System.out.println("The price for the " +s.getClass().getSimpleName() + " is " +s.calculatePrice() +".\n");
        }

        System.out.println("\n------------------------ExB4.11--------------------------------");
        Person person = new Person("Jane", "Doe", Gender.FEMALE);
        Instructor personInstructor = (Instructor) person;
        personInstructor.teachCourse(course1);
        System.out.println("");
        CourseParticipant personCourseParticipant = (CourseParticipant) person;
        personCourseParticipant.attendCourse(course1);
        System.out.println("");

        System.out.println("\n------------------------ExB4.12---------------------------------");
        p1.printInfo();
        p2.printInfo();
        p3.printInfo();
    }
}
