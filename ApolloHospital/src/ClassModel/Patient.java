package ClassModel;

import java.util.ArrayList;
import java.util.List;

public class Patient {
	
	private int patientId;
	private static int PatientIdGenerator = 0;
	private String name;
	private int age;
	private String gender;
	private List<String> patientMedicalHistory = new ArrayList<>();
	public Patient(String name, int age, String gender, List<String> patientMedicalHistory) {
		super();
		this.patientId = ++PatientIdGenerator;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.patientMedicalHistory = patientMedicalHistory;
	}
	public Patient() {
		super();
		this.patientId = ++PatientIdGenerator;
	}
	public int getPatientId() {
		return patientId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public List<String> getPatientMedicalHistory() {
		return patientMedicalHistory;
	}
	public void setPatientMedicalHistory(List<String> patientMedicalHistory) {
		this.patientMedicalHistory = patientMedicalHistory;
	}
	

}
