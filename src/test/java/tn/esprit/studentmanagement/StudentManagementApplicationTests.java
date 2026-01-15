package tn.esprit.studentmanagement;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import tn.esprit.studentmanagement.entities.Student;
import tn.esprit.studentmanagement.services.StudentService;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentManagementApplicationTests {

    private StudentService studentService;

    @BeforeEach
    void setUp() {
        studentService = new StudentService();
    }

    @Test
    void testFindStudentsByLastName() {
        // Arrange - Create and save test students
        Student student1 = new Student();
        student1.setIdStudent(1L);
        student1.setFirstName("John");
        student1.setLastName("Smith");
        student1.setEmail("john.smith@example.com");
        student1.setPhone("123456789");
        student1.setDateOfBirth(LocalDate.of(2000, 5, 15));
        student1.setAddress("123 Main St");
        studentService.saveStudent(student1);

        Student student2 = new Student();
        student2.setIdStudent(2L);
        student2.setFirstName("Jane");
        student2.setLastName("Smith");
        student2.setEmail("jane.smith@example.com");
        student2.setPhone("987654321");
        student2.setDateOfBirth(LocalDate.of(2001, 8, 20));
        student2.setAddress("456 Oak St");
        studentService.saveStudent(student2);

        Student student3 = new Student();
        student3.setIdStudent(3L);
        student3.setFirstName("Bob");
        student3.setLastName("Johnson");
        student3.setEmail("bob.johnson@example.com");
        student3.setPhone("555555555");
        student3.setDateOfBirth(LocalDate.of(1999, 12, 10));
        student3.setAddress("789 Pine St");
        studentService.saveStudent(student3);

        // Act - Call the function to find students by last name
        List<Student> smithStudents = studentService.findStudentsByLastName("Smith");

        // Assert - Verify the results
        assertNotNull(smithStudents, "Result should not be null");
        assertEquals(2, smithStudents.size(), "Should find 2 students with last name Smith");
        assertTrue(smithStudents.stream().allMatch(s -> s.getLastName().equalsIgnoreCase("Smith")), 
                   "All results should have last name Smith");
    }

}
