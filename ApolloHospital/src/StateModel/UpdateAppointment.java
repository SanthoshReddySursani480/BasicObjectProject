package StateModel;

import java.sql.Time;
import java.util.Date;

import DatabasePackage.AppointmentDatabase;

public class UpdateAppointment {

	    public void updateAppointment(int id,int doctorid,String date,Time time ) {
	    	AppointmentDatabase database = new AppointmentDatabase();
	    	database.updateAppointmentDetails(id, doctorid,date, time);    	
	    }
}
