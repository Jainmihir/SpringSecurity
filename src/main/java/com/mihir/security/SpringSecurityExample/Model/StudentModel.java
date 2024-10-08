package com.mihir.security.SpringSecurityExample.Model;



public class StudentModel {
	
	private int id;
	private String studentName;
	private int marks;
	
	
	
	@Override
	public String toString() {
		return "StudentModel [id=" + id + ", studentName=" + studentName + ", marks=" + marks + "]";
	}
	public int getId() {
		return id;
	}
	public StudentModel(int id, String studentName, int marks) {
		this.id = id;
		this.studentName = studentName;
		this.marks = marks;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
}
