package be.abis.courseadmin.service;

import be.abis.courseadmin.model.Company;
import be.abis.courseadmin.repository.MemoryListCompanyRepository;

public class AbisCompanyService implements CompanyService {

    private static MemoryListCompanyRepository companyRepository = new MemoryListCompanyRepository();

    @Override
    public void sortAllCompaniesByName() {
        companyRepository.getCompanies().sort(null);
    }

    @Override
    public void sortAllCompaniesByCompanyNumber() {
        companyRepository.getCompanies().sort(new Company.CompanyNumberComparator());
    }

}
