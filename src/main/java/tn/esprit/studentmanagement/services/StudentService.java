package tn.esprit.studentmanagement.services;

import tn.esprit.studentmanagement.entities.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentService implements IStudentService {
    private List<Student> students = new ArrayList<>();
    
    public List<Student> getAllStudents() { 
        return new ArrayList<>(students); 
    }
    
    public Student getStudentById(Long id) { 
        return students.stream()
                .filter(s -> s.getIdStudent().equals(id))
                .findFirst()
                .orElse(null);
    }
    
    public Student saveStudent(Student student) { 
        students.add(student);
        return student; 
    }
    
    public void deleteStudent(Long id) { 
        students.removeIf(s -> s.getIdStudent().equals(id)); 
    }
    
    public List<Student> findStudentsByLastName(String lastName) {
        return students.stream()
                .filter(student -> student.getLastName() != null && 
                        student.getLastName().equalsIgnoreCase(lastName))
                .toList();
    }

}
