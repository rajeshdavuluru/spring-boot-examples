package demo.code.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import demo.code.domain.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, Integer> {

	Student findByStudentId(int studentId);

	Student findByFirstName(String firstName);

	void deleteByStudentId(int studentId);
}
