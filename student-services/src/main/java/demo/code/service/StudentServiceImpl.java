package demo.code.service;

import demo.code.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import demo.code.domain.Student;
import org.springframework.stereotype.Service;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	public Student getStudentById(int studentId) {
		return studentRepository.findByStudentId(studentId);
	}

	@HystrixCommand(fallbackMethod ="hystrixDefaultData")
	public Student getStudentByFname(String firstName) {
		return studentRepository.findByFirstName(firstName);
	}

	public String createStudent(Student body) {
		studentRepository.save(body);

		return "Successfully Created";
	}

	public String updateStudent(int studentId, Student body) {
		studentRepository.save(body);
		return "Successfully Updated";
	}

	public String deleteStudent(int studentId) {
		studentRepository.deleteByStudentId(studentId);
		return "Successfully Deleted";
	}
	
	
	public Student hystrixDefaultData(String fname){
		return new Student(1003, "Rajesh", "Davuluru");
	}
}
