package demo.code.domain;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;
import org.bson.types.ObjectId;

@Document(collection = "studentCollection")
public class Student {

	// @Id
	// private ObjectId _id;

	// @Indexed(unique = true)
	@Id
	// @Field(value = "Student_No")
	private int studentId;

	// @Field(value = "Emp_Fname")
	private String firstName;

	// @Field(value = "Emp_Lname")
	private String lastName;

	
	public Student(int studentId, String firstName, String lastName){
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	/*
	 * public ObjectId get_id() { return _id; } public void set_id(ObjectId _id)
	 * { this._id = _id; }
	 */
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
