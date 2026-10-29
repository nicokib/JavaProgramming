package be.abis.courseadmin.repository;

import be.abis.courseadmin.exception.CompanyAlreadyExistsException;
import be.abis.courseadmin.exception.CompanyNotFoundException;
import be.abis.courseadmin.model.Company;

import java.util.ArrayList;
import java.util.List;

public class MemoryListCompanyRepository implements CompanyRepository {

    public static List<Company> companies = new ArrayList<Company>();

    public MemoryListCompanyRepository() {
        if(companies.isEmpty()){
            addCompanies(new Company("ING"),
                    new Company("Abis"),
                    new Company("Tech Solutions"),
                    new Company("Microsoft"),
                    new Company("IBM"));
        }
    }

    public MemoryListCompanyRepository(Company... companies) {
        addCompanies(companies);
    }

    public void addCompanies(Company... companies) {
        for (Company company : companies) {
            try {
                addCompany(company);
            } catch (CompanyAlreadyExistsException e) {
                throw new RuntimeException(e);
            }
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
    public void addCompany(Company c) throws CompanyAlreadyExistsException {
        if(companies.contains(c)) throw new CompanyAlreadyExistsException("Company " + c.getName() + " already exists...");
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