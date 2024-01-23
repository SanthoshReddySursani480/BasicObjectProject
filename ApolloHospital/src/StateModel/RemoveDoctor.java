package StateModel;

import DatabasePackage.DoctorDatabase;

public class RemoveDoctor {

	         public void removeDoctor(int id){
	        	  DoctorDatabase base = new DoctorDatabase();
	        	  base.remove(id);
	          }
	
	
}
