package be.abis.courseadmin.repository;

import be.abis.courseadmin.exception.CompanyNotFoundException;
import be.abis.courseadmin.model.Company;

public class MemoryArrayCompanyRepository implements CompanyRepository {

    static private Company[] companies = new Company[100];
    private static int nbrCompanies = 0;

    public MemoryArrayCompanyRepository() {
        if(nbrCompanies == 0){
            addCompanies(new Company("ING", 1),
                    new Company("Abis", 2),
                    new Company("Tech Solutions", 3),
                    new Company("Microsoft", 4),
                    new Company("IBM", 5));
        }
    }

    public MemoryArrayCompanyRepository(Company... companies) {
        addCompanies(companies);
    }

    public void addCompanies(Company... companies) {
        for (Company company : companies) {
            addCompany(company);
        }
    }

    public int getNbrCompanies() {
        return nbrCompanies;
    }

    public void setNbrCompanies(int nbrCompanies) {
        this.nbrCompanies = nbrCompanies;
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
        if (nbrCompanies < companies.length) companies[nbrCompanies++] = c;
        else
            System.out.println("Impossible to add the company " + c.getName() + ". Maximum " + companies.length + " elements !");
    }

    @Override
    public void updateCompany(Company c) {
        int indextoUpdate = getIndexCompany(c.getCompanyNumber());
        if (indextoUpdate == -1) return;
        companies[indextoUpdate] = c;
    }

    @Override
    public void deleteCompany(int id) {
        int indexToDelete = getIndexCompany(id);
        for(int i = indexToDelete; i < nbrCompanies; i++){
            companies[i] = companies[i+1];
        }
        nbrCompanies--;
        companies[nbrCompanies] = null;
    }

    private int getIndexCompany(int id) {
        for (int i = 0; i < companies.length; i++) {
            if (companies[i] == null) break;
            if (companies[i].getCompanyNumber() == id) return i;
        }
        return -1;
    }

    public void printInfo() {
        for(Company company : companies){
            if(company == null) break;
            System.out.println(company);
        }
    }
}