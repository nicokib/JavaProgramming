package be.abis.courseadmin.repository;

import be.abis.courseadmin.exception.CompanyNotFoundException;
import be.abis.courseadmin.model.Company;

import java.util.ArrayList;
import java.util.List;

public class MemoryListCompanyRepository implements CompanyRepository {

    private static List<Company> companies = new ArrayList<Company>();

    public MemoryListCompanyRepository() {
        if(companies.isEmpty()){
            addCompanies(new Company("ING", 1),
                    new Company("Abis", 2),
                    new Company("Tech Solutions", 3),
                    new Company("Microsoft", 4),
                    new Company("IBM", 5));
        }
    }

    public MemoryListCompanyRepository(Company... companies) {
        addCompanies(companies);
    }

    public void addCompanies(Company... companies) {
        for (Company company : companies) {
            addCompany(company);
        }
    }

    public static List<Company> getCompanies() {
        return companies;
    }

    @Override
    public Company findCompany(int id) throws CompanyNotFoundException {
        for (Company company : companies) {
            if (company == null) break;
            if (company.getCompanyNumber() == id) return company;
        }
        throw new CompanyNotFoundException("Company with the id " + id + " not found...");
    }

    @Override
    public Company findCompany(String name) throws CompanyNotFoundException {
        for (Company company : companies) {
            if (company == null) break;
            if (company.getName().toUpperCase().equals(name.toUpperCase())) return company;
        }
        throw new CompanyNotFoundException("Company with the name " + name + " not found...");
    }

    @Override
    public void addCompany(Company c) {
        companies.add(c);
    }

    @Override
    public void updateCompany(Company c) throws CompanyNotFoundException {
        Company companyToUpdate = findCompany(c.getCompanyNumber());
        companyToUpdate.setName(c.getName());
    }

    @Override
    public void deleteCompany(int id) throws CompanyNotFoundException{
        companies.remove(findCompany(id));
    }

    public void printInfo() {
        for(Company company : companies){
            if(company == null) break;
            System.out.println(company);
        }
    }
}