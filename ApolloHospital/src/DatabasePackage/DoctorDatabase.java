package DatabasePackage;


import ClassModel.Appointment;

import ClassModel.Doctor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

 public class DoctorDatabase {
	public static Map<Integer,Doctor> doctorlist = new HashMap<Integer,Doctor>();
	public static Map<Integer,Map<String,List<Time>>> doctorsTime = new HashMap<Integer,Map<String,List<Time>>>();
			public void getDoctorDetails() {
	
	}
			
	public void addDoctorToDatabase(Doctor doctor) {
		doctorlist.put(doctor.getDoctorid(), doctor);
		//updateIntoDatabase(doctor);
	}
	
	public void remove(int id) {
		doctorlist.remove(id);
		
	}
	public void addDoctorTimeToDatabase(int id,String date,Time time) {
		List<Time> docTime = new ArrayList<Time>();
		System.out.println(date);
		System.out.println(time);
		if(doctorlist.get(id).getDateandtimeList()!=null || doctorlist.get(id).getDateandtimeList().get(date)!= null) {
		 docTime = doctorlist.get(id).getDateandtimeList().get(date);
		 docTime.add(time);
			Map<String,List<Time>> docMap = new HashMap<>();
			docMap.put(date, docTime);
			 doctorlist.get(id).setDateandtimeList(docMap);
			doctorsTime.get(id).put(date,docTime);
		}
		else {
			docTime.add(time);
			Map<String,List<Time>> docMap = new HashMap<>();
			docMap.put(date, docTime);
			 doctorlist.get(id).setDateandtimeList(docMap);
			doctorsTime.get(id).put(date,docTime);
		}
		
	}
	public void updateDoctorDetails(int id ,String name,String specialisation) {
		doctorlist.get(id).setName(name);
		doctorlist.get(id).setSpecification(specialisation);
	}
	
	public void updateIntoDatabase(Doctor doctor) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");			
		}
		catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		Connection connection = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		try {
			
			//doctor_id int,doctor_name varchar(30),specialisation varchar(30)
			
			int id = doctor.getDoctorid();
			String name = doctor.getName();
			String specialisation = doctor.getSpecification();
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/doctorDatabase","root","admin@123");
			stmt = connection.createStatement();
			String sql = "insert into doctorDetails( doctor_id,doctor_name,specialisation)"+"values(id,name,specialisation)";
			stmt.executeUpdate(sql);

		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	
		
	}
	
	
}
