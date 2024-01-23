package DatabasePackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import ClassModel.Appointment;

public class AppointmentDatabase {
   
	static Map<Integer,Appointment> appointmentlist = new HashMap<Integer,Appointment>();
	
	public void  addAppointmentToDatabase(Appointment appointment){
		
		 appointmentlist.put(appointment.getAppointmentid(), appointment);
		// updateIntoDatabase( appointment);
	 }
	
	public void removeAppointment(int id) {
		appointmentlist.remove(id);
	}
	
	
	public  Map<Integer,Appointment> returnAppointmentList(){
	return	appointmentlist;
	}
	
	
	public void updateAppointmentDetails(int id,int doctorid,String date,Time time) {
		appointmentlist.get(id).setDoctorid(doctorid);
		appointmentlist.get(id).setDate(date);
		appointmentlist.get(id).setTime(time);
	}
	
	
	public void updateIntoDatabase(Appointment appointment) {
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
			
			
			
			int app_id = appointment.getAppointmentid();
			int patient_id = appointment.getPatientid();
			int doctor_id = appointment.getDoctorid();
			String date = appointment.getDate();
			String time = String.valueOf(appointment.getTime());
			
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/appointmentdatabase","root","admin@123");
			
			stmt = connection.createStatement();
			String sql = "insert into appointmentTable(appointment_id,patient_id,doctor_id,date,time)"+"values(app_id,patient_id,doctor_id,date,time)";
			stmt.executeUpdate(sql);

		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	
		
	}
	
	
}
