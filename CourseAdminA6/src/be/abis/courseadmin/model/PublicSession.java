package be.abis.courseadmin.model;

import be.abis.courseadmin.exception.CompanyNotFoundException;
import be.abis.courseadmin.repository.MemoryListCompanyRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PublicSession extends Session {
    private static MemoryListCompanyRepository cr = new MemoryListCompanyRepository();
    private final static Company ABIS;
    List<CourseParticipant> enrolments = new ArrayList<CourseParticipant>();
    // Check with Copilot...
    static {
        try {
             ABIS = cr.findCompany("Abis");
        } catch (CompanyNotFoundException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public PublicSession(Course course, String startDate, Company location, Person instructor) {
        super(course, startDate, location, instructor);
    }

    public double calculatePrice(){
        return 300.0;
    }

    @Override
    public Company getOrganizer() {
        return ABIS;
    }

    public void addEnrolment(CourseParticipant participant) {
        enrolments.add(participant);
    }

    public void addEnrolments(CourseParticipant... participants) {
        for(CourseParticipant cp : participants) {
            addEnrolment(cp);
        }
    }

    public void cancelEnrolment(CourseParticipant participant) {
        enrolments.remove(participant);
    }

    public void printParticipantList() {
        System.out.println("List of participants :");
        for(CourseParticipant p : enrolments) {
            ((Person) p).printInfo();
        }
    }

    public List<CourseParticipant> findAbisParticipants() {
        List<CourseParticipant> lstPersonAbis = new ArrayList<CourseParticipant>();

        for(CourseParticipant p : enrolments) {
            Company currentCompany = ((Person) p).getCompany();
            if(currentCompany != null && currentCompany.getName().equals(ABIS.getName())) {
                lstPersonAbis.add(p);
            }
        }
        return lstPersonAbis;
    }

    public void removeAbisParticipants() {
       Iterator<CourseParticipant> iter = enrolments.iterator();
        while(iter.hasNext()) {
            Person p = (Person)iter.next();
            Company currentCompany = p.getCompany();
            if(currentCompany != null && currentCompany.getName().equals(ABIS.getName())) {
                iter.remove();
            }
        }
    }
}