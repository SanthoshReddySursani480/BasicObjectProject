package DatabasePackage;

import java.sql.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ClassModel.Doctor;
import ClassModel.Patient;

public class PatientDatabase {
	public static Map<Integer,Patient> patientlist = new HashMap<Integer,Patient>();
	
	
	public void addDoctorToDatabase(Patient patient) throws ClassNotFoundException, SQLException {
		
		patientlist.put(patient.getPatientId(), patient);
		updateIntoDatabase(patient);
	}
	
	public void remove(int id) {
		patientlist.remove(id);
	}
	
	public void updatePatientDetails(int id,String name,int age ,String gender,List<String> disease) {
		
		patientlist.get(id).setName(name);
		patientlist.get(id).setAge(age);
		patientlist.get(id).setGender(gender);
		patientlist.get(id).setPatientMedicalHistory(disease);
	}
	
	
	public void updateIntoDatabase(Patient patient) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pd","root","admin@123");
		Statement st = conn.createStatement();
		
	/*	int id = patient.getPatientId();
		String name = patient.getName();
		int age = patient.getAge();
		String gender = patient.getGender();
		String mh = "";
		String sql = "INSERT INTO pdetails(pid,pname,page,pgender,pmedicalhistory)"+"VALUES(1,'name',34,'gender','mh')";
		int result = st.executeUpdate(sql);
		System.out.println(result);*/
		
		ResultSet rset = st.executeQuery("select * from pdetails");
		
		while(rset.next()) {
			System.out.println(rset.getInt(1));
			System.out.println(rset.getInt(2));
			System.out.println(rset.getInt(3));
		}
	}

}
