package be.abis.courseadmin.test;

import be.abis.courseadmin.model.Course;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CourseTest {
    Course c;

    @BeforeEach
    public void setUp() throws Exception {
        c = new Course("Java",5,500);
    }

    @AfterEach
    public void tearDown() throws Exception {
        c = null;
    }

    @Test
    public void testCalculateTotalPrice() {
        System.out.println("testCalculateTotalPrice");
        assertEquals(2500.0, c.calculateTotalPrice());
    }

    @Test
    public void testToString() {
        System.out.println("testToString");
        assertTrue(c.toString().startsWith("Java"));
    }
}
