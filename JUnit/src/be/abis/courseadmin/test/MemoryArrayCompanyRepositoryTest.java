package be.abis.courseadmin.test;

import be.abis.courseadmin.repository.MemoryArrayCompanyRepository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MemoryArrayCompanyRepositoryTest {
    MemoryArrayCompanyRepository cr;

    @BeforeEach
    public void setUp() throws Exception {
        cr = new MemoryArrayCompanyRepository();
    }

    @AfterEach
    public void tearDown() throws Exception {
        cr = null;
    }

    @Test
    public void testArraySize() {
        System.out.println("testArraySize");
        assertEquals(5, cr.getNbrCompanies());
    }

    @Test
    public void testFindsMethod() {
        System.out.println("testFindsMethod");
        assertNotNull(cr.findCompany("ABIS"));
        assertNull(cr.findCompany("ABAS"));
        assertNotNull(cr.findCompany(1));
        assertNull(cr.findCompany(10));
    }
}
