package be.abis.courseadmin.model;

import be.abis.courseadmin.repository.MemoryArrayCompanyRepository;

public class PublicSession extends Session {
    private static MemoryArrayCompanyRepository cr = new MemoryArrayCompanyRepository();
    private static Company ABIS = cr.findCompany("Abis");

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
