package be.abis.courseadmin.model;

import be.abis.courseadmin.exception.CompanyNotFoundException;
import be.abis.courseadmin.repository.MemoryArrayCompanyRepository;

public class PublicSession extends Session {
    private static MemoryArrayCompanyRepository cr = new MemoryArrayCompanyRepository();
    private final static Company ABIS;
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
}
