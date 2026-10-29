package be.abis.courseadmin.test;

import be.abis.courseadmin.enumeration.Gender;
import be.abis.courseadmin.exception.*;
import be.abis.courseadmin.model.*;
import be.abis.courseadmin.repository.CompanyRepository;
import be.abis.courseadmin.repository.FileCompanyRepository;
import be.abis.courseadmin.repository.MemoryListCompanyRepository;
import be.abis.courseadmin.service.AbisCompanyService;
import be.abis.courseadmin.utils.DateUtils;

import java.text.DecimalFormat;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        DecimalFormat df = new DecimalFormat("#.00");

        FileCompanyRepository fileCompanyRepository = new FileCompanyRepository();
        CompanyRepository companyRepository = (CompanyRepository)fileCompanyRepository;

       /* fileCompanyRepository.printInfo();
        System.out.println("");
        try {
            companyRepository.addCompany(new Company("Youtube"));
        } catch (CompanyAlreadyExistsException e) {
            throw new RuntimeException(e);
        }
        fileCompanyRepository.printInfo();
        System.out.println("");
        try
        {
            companyRepository.deleteCompany(4);
        }
        catch (CompanyNotFoundException e) {
            System.out.println("Deletion impossible : " + e.getMessage());
        }

        fileCompanyRepository.printInfo();
        System.out.println("");
        try {
            Company cToUpdate = companyRepository.findCompany(1);
            cToUpdate.setName("New name");
            companyRepository.updateCompany(cToUpdate);
            fileCompanyRepository.printInfo();
            System.out.println("");
        }
        catch (CompanyNotFoundException e) {
            System.out.println(e.getMessage());
        }
*/


        Course course1 = new Course("Java",5,500);
        Course course2 = new Course("TDD",2,450);

        //Company comp1 = new Company("Abis");
        //Company comp2 = new Company("IBM");
        Company comp1, comp2;
        try
        {
            comp1 = companyRepository.findCompany("Abis");
            comp2 = companyRepository.findCompany("IBM");
        }
        catch (CompanyNotFoundException e) {
            throw new RuntimeException(e);
        }

        Person p1 = new Person("Mary","Jones", Gender.FEMALE, comp1);
        Person p2=new Person("John","Doe", Gender.MALE);
        try
        {
            companyRepository.addCompany(new Company("TTL"));
        } catch (CompanyAlreadyExistsException e) {
            System.out.println(e);
        }
        try
        {
            companyRepository.addCompany(new Company("Abis"));
        } catch (CompanyAlreadyExistsException e) {
            System.out.println(e);
        }

        Person p3;
        try
        {
            p3 = new Person("Bob","Janssens", Gender.OTHER, companyRepository.findCompany("TTL"));
        } catch (CompanyNotFoundException e) {
            throw new RuntimeException(e);
        }



        System.out.println("\n------------------------ExA4.8 Services abstract----------------------------------");
        CompanySession companySession1 = new CompanySession(course2, DateUtils.parse("5/10/2022"),comp1,p3,comp2, 1);
        CompanySession companySession2 = new CompanySession(course1,DateUtils.parse("7/11/2022"),comp2,p1,comp2,5);
        PublicSession publicSession = new PublicSession(course2,DateUtils.parse("22/11/2022"),comp1,p3);

        Consultancy consultancy = new Consultancy();
        Service[] services = {companySession1,consultancy,companySession2,publicSession};
        for (Service s : services){
            if (s instanceof Session){
                ((Session) s).printInfo();
            }
            System.out.println("The price for the " +s.getClass().getSimpleName() + " is " + df.format(s.calculatePrice()) +".\n");
        }

        System.out.println("\n------------------------ExA4.11--------------------------------");
        Person person = new Person("Jane", "Doe", Gender.FEMALE);
        Instructor personInstructor = (Instructor) person;
        personInstructor.teachCourse(course1);
        System.out.println("");
        CourseParticipant personCourseParticipant = (CourseParticipant) person;
        personCourseParticipant.attendCourse(course1);
        System.out.println("");

        System.out.println("\n------------------------ExA4.12---------------------------------");
        p1.printInfo();
        p2.printInfo();
        p3.printInfo();

        System.out.println("\n------------------------ExA5.2---------------------------------");
        try {
            CompanySession companySession3 = new CompanySession(course1, DateUtils.parse("25/11/2026"), comp1, p1, comp2, 15);
            double priceSession = companySession3.calculatePrice();
            if(priceSession > 50000) {
                throw new PriceTooHighException("The price of the session is too high : " + priceSession);
            }
        } catch (PriceTooHighException e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("I am entry in the finally clause");
        }

        System.out.println("\n------------------------ExA5.3---------------------------------");
        int nbrParticipants;
        try {
            nbrParticipants = 4;
            double priceRequest = comp2.requestPriceOfferForCompanySession(course1, nbrParticipants);
            System.out.println("Price of the request for company "+ comp2.getName() +" for "+ nbrParticipants +" particpants : " + priceRequest);
        }
        catch (PriceException e) {
            System.out.println(e.getMessage());
        }

        try {
            nbrParticipants = 25;
            double priceRequest = comp2.requestPriceOfferForCompanySession(course1, nbrParticipants);
            System.out.println("Price of the request for company "+ comp2.getName() +" for "+ nbrParticipants +" particpants : " + priceRequest);
        }
        catch (PriceException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n------------------------ExA5.4---------------------------------");
        Person instructor1;
        try {
            instructor1 = new Person("Jane", "Doe", Gender.FEMALE, companyRepository.findCompany("Abis"));
        } catch (CompanyNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            nbrParticipants = 1;
            double priceRequest = comp2.requestPriceOfferForCompanySession(course1, nbrParticipants);
            if(instructor1.getCompany() == null) {
                throw new NullPointerException("Instructor's company is null");
            }
            else {
                if (priceRequest < instructor1.getCompany().getMinPrice()) {
                    throw new PriceTooLessException("The price of the session ("+ priceRequest +") is too low... Minunum is " + instructor1.getCompany().getMinPrice());
                }
            }
            System.out.println("Price of the request for company "+ comp2.getName() +" for "+ nbrParticipants +" particpants : " + priceRequest);
        }
        catch (PriceException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n------------------------ExA6.1---------------------------------");
        Person p4 = new Person("Mary","Doe", Gender.FEMALE, comp1);
        p4.addHobbies("Tennis", "Cinema", "IT", "Tennis", "Biology");
        System.out.println("Hobbies of " + p4.getFirstName() + " " + p4.getLastName() + " : " + p4.getHobbies());

        System.out.println("\n------------------------ExA6.3/4---------------------------------");
        PublicSession publicSession1 = new PublicSession(course1,DateUtils.parse("27/01/2026"), comp1, instructor1);
        publicSession1.addEnrolments(p1,p2,p3,p4);
        publicSession1.printParticipantList();
        publicSession1.cancelEnrolment(p3);
        publicSession1.printParticipantList();
        publicSession1.addEnrolment(p3);
        publicSession1.printParticipantList();

        System.out.println("\n------------------------ExA6.5---------------------------------");
        List<CourseParticipant> courseParticipantList = publicSession1.findAbisParticipants();
        System.out.println("List of Abis participants:");
        for(CourseParticipant p : courseParticipantList) {
            ((Person)p).printInfo();
        }

        System.out.println("\n------------------------ExA6.6---------------------------------");
        publicSession1.removeAbisParticipants();
        publicSession1.printParticipantList();

        System.out.println("\n------------------------ExA6.8/9---------------------------------");
        AbisCompanyService abisCompanyService = new AbisCompanyService();
        System.out.println("");
        System.out.println("No Sort");
        fileCompanyRepository.printInfo();
        System.out.println("");
        System.out.println("Sort by name");
        List<Company> companiesSortedByName =abisCompanyService.sortAllCompaniesByName();
        printInfoCompaniesList(companiesSortedByName);
        System.out.println("");
        System.out.println("Sort by CompanyNumber");
        List<Company> companiesSortedByCompanyNumber = abisCompanyService.sortAllCompaniesByCompanyNumber();
        printInfoCompaniesList(companiesSortedByCompanyNumber);
        System.out.println("");

        System.out.println("\n------------------------ExA8.1---------------------------------");
        try {
            companyRepository.addCompany(new Company("Youtube"));
        } catch (CompanyAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void printInfoCompaniesList(List<Company> companies) {
        for(Company company : companies){
            if(company == null) break;
            System.out.println(company);
        }
    }
}
