package StateModel;

import java.sql.Time;
import java.util.Date;

import ClassModel.Appointment;
import DatabasePackage.AppointmentDatabase;

public class BookAppointment {
	
	public void bookAppointment(int patientId,int doctorId,String date,Time time) {
		Appointment appointment = new Appointment(patientId, doctorId, date, time);
		AppointmentDatabase database = new AppointmentDatabase();
		database.addAppointmentToDatabase(appointment);
	}

}
