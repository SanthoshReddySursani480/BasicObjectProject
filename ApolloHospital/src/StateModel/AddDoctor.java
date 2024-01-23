package StateModel;

import ClassModel.Doctor;
import DatabasePackage.DoctorDatabase;

public class AddDoctor {
	
	   public void addDoctor(String name,String specialisation) {
		   if(name!=null){
		      Doctor doctor = new Doctor(name,specialisation);
			  DoctorDatabase base = new DoctorDatabase();
			  base.addDoctorToDatabase(doctor);
		   }
	   }

}
