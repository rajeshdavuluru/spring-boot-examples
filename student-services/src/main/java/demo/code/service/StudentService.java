package demo.code.service;

import org.springframework.stereotype.Component;
import demo.code.domain.Student;

public interface StudentService {
	Student getStudentById(int studentId);

	Student getStudentByFname(String firstName);

	String createStudent(Student body);

	String updateStudent(int studentId, Student body);

	String deleteStudent(int studentId);
}
