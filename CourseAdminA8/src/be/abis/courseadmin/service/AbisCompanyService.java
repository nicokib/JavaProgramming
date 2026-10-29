package be.abis.courseadmin.service;

import be.abis.courseadmin.model.Company;
import be.abis.courseadmin.repository.FileCompanyRepository;
import be.abis.courseadmin.repository.MemoryListCompanyRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AbisCompanyService implements CompanyService {

    private static FileCompanyRepository companyRepository = new FileCompanyRepository();

    @Override
    public List<Company> sortAllCompaniesByName() {
        List<Company> listCompanies = new ArrayList<>(companyRepository.getCompanies());
        Collections.sort(listCompanies);
        return listCompanies;
    }

    @Override
    public List<Company> sortAllCompaniesByCompanyNumber() {
        List<Company> listCompanies = new ArrayList<>(companyRepository.getCompanies());
        Collections.sort(listCompanies, new Company.CompanyNumberComparator());
        return listCompanies;
    }

}
