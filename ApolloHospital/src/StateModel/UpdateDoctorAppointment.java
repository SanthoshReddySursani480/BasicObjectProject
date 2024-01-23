package StateModel;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ClassModel.Doctor;
import DatabasePackage.DoctorDatabase;

public class UpdateDoctorAppointment {
	       public void updateDoctorappointment(int id,String date,Time time){
	    	   DoctorDatabase base = new DoctorDatabase(); 
	    	   base.addDoctorTimeToDatabase(id, date, time);
	       }
}
