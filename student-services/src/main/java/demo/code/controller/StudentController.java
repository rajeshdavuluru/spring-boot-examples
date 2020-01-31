package demo.code.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import demo.code.service.StudentService;
import demo.code.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.MediaType;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
@Slf4j
public class StudentController {

	@Autowired
	StudentService studentService;

	@GetMapping("/{studentId}/details")
	@ApiOperation(value = "Student Details by ID", response = Object.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved Student Details"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	public ResponseEntity<Object> getStudentById(@PathVariable int studentId) {
		log.info("StudentController - getStudentById() - Start");
		Student s = studentService.getStudentById(studentId);
		log.info("StudentController - getStudentById() - End");
		return new ResponseEntity<>(s, HttpStatus.OK);
	}
	
	@GetMapping("/{studentname}/detailsByFname")
	@ApiOperation(value = "Student Details by First Name", response = Object.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved Student Details"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	public ResponseEntity<Object> getStudentByFname(@PathVariable String  studentname) {
		log.info("StudentController - getStudentByFname() - Start");
		Student s = studentService.getStudentByFname(studentname);
		log.info("StudentController - getStudentByFname() - End");
		return new ResponseEntity<>(s, HttpStatus.OK);
	}

	@PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Create Student", response = String.class)
	public ResponseEntity<String> createStudent(@RequestBody Student body) {

		String s = studentService.createStudent(body);
		return new ResponseEntity<>(s, HttpStatus.OK);
	}

	@PutMapping(value = "/{studentId}/update", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Update Student", response = String.class)
	public ResponseEntity<String> updateStudent(@PathVariable int studentId, @RequestBody Student body) {

		String s = studentService.updateStudent(studentId, body);
		return new ResponseEntity<>(s, HttpStatus.OK);
	}

	@DeleteMapping(value = "/{studentId}/delete", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Delete Student", response = String.class)
	public ResponseEntity<String> deleteStudent(@PathVariable int studentId) {
		String s = studentService.deleteStudent(studentId);
		return new ResponseEntity<>(s, HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<String> about() {
		return new ResponseEntity<>("Student Services", HttpStatus.OK);

	}

}
