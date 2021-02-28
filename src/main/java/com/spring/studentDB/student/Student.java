package com.spring.studentDB.student;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Student {
	@Id
	@SequenceGenerator(
			name = "student_sequence",
			sequenceName = "student_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "student_sequence"
	)

	private Long id;
	private String firstname;
	private String lastname;
	private String email;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;
	@Transient
	private Integer age;

	public Student() { }

	public Student(String firstname, String lastname, String email, LocalDate dob) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.dob = dob;
	}

	public Long getId() {
		return id;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getEmail() {
		return email;
	}

	public LocalDate getDob() {
		return dob;
	}

	public Integer getAge() {
		return Period.between(dob, LocalDate.now()).getYears();
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String toString() {
		return "Student{" +
				"id=" + String.format("%09d", id) +
				"name=" + firstname + " " + lastname +
				"email=" + email +
				"dob=" + dob +
				"}";
	}
}
