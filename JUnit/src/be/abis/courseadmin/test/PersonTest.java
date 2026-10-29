package be.abis.courseadmin.test;

import be.abis.courseadmin.enumeration.Gender;
import be.abis.courseadmin.model.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {

    Person p;

    @BeforeEach
    public void setUp() {
        p = new Person("John", "Doe", Gender.MALE);
    }

    @AfterEach
    public void tearDown() {
        p = null;
    }

    @Test
    public void testAddHobbies() {
        System.out.println("testAddHobbies");
        p.addHobby("Tennis");
        assertEquals(1, p.getNbrHobbies());
        p.addHobbies("IT", "Sciences");
        assertEquals(3, p.getNbrHobbies());
    }
}
