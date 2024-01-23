package StateModel;

import ClassModel.Doctor;
import DatabasePackage.DoctorDatabase;

public class UpdateDoctor {

	    public void updateDoctor(int id,String name,String specialisation) {
	    	DoctorDatabase base = new DoctorDatabase();	
	    	base.updateDoctorDetails(id, name, specialisation);
	    }
}
