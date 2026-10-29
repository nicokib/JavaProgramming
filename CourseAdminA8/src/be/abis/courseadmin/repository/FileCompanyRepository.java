package be.abis.courseadmin.repository;

import be.abis.courseadmin.exception.CompanyAlreadyExistsException;
import be.abis.courseadmin.exception.CompanyNotFoundException;
import be.abis.courseadmin.model.Company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileCompanyRepository implements CompanyRepository {
    private static List<Company> companies = new ArrayList<Company>();

    private static String fileName= "c:\\temp\\javacourses\\companies.txt";

    public FileCompanyRepository() {
        if(companies.isEmpty()) initialReadFile();
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
        writeCompaniesToFile();
    }

    @Override
    public void updateCompany(Company c) throws CompanyNotFoundException {
        Company companyToUpdate = findCompany(c.getCompanyNumber());
        companyToUpdate.setName(c.getName());
        writeCompaniesToFile();
    }

    @Override
    public void deleteCompany(int id) throws CompanyNotFoundException{
        companies.remove(findCompany(id));
        writeCompaniesToFile();
    }

    public void initialReadFile() {
        if(!companies.isEmpty()) companies.clear();
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while((line = br.readLine()) != null) {
                if(!line.isEmpty()) companies.add(new Company(line.trim()));
            }

            System.out.println("Companies readed : " + companies);
        }
        catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeCompaniesToFile() {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(fileName));
            for(Company c : companies) {
                pw.println(c.getName());
            }
            pw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void printInfo() {
        for(Company company : companies){
            if(company == null) break;
            System.out.println(company);
        }
    }
}
