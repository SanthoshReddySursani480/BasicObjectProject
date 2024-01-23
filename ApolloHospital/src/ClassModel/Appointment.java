package ClassModel;

import java.sql.Time;
import java.util.Date;

public class Appointment {
     
	private int appointmentid;
	private int patientid;
	private int doctorid;
	private String date;
	private Time time;
	private static int idgenerator=0;
	public Appointment(int patientid, int doctorid,String date, Time time) {
		super();
		this.appointmentid = ++idgenerator;
		this.patientid = patientid;
		this.doctorid = doctorid;
		this.date = date;
		this.time = time;
	}
	public Appointment() {
		super();
		this.appointmentid = ++idgenerator;
	}
	public int getAppointmentid() {
		return appointmentid;
	}
	
	public void setAppointmentid(int id) {
		this.appointmentid = id;
	}
	
	public int getPatientid() {
		return patientid;
	}
	public void setPatientid(int patientid) {
		this.patientid = patientid;
	}
	public int getDoctorid() {
		return doctorid;
	}
	public void setDoctorid(int doctorid) {
		this.doctorid = doctorid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}

}