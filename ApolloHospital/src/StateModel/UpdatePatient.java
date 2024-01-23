package StateModel;

import java.util.List;

import ClassModel.Patient;
import DatabasePackage.PatientDatabase;

public class UpdatePatient {

	  public void updatePatient(int id,String name,int age,String gender,List<String> list) {
		  PatientDatabase base = new PatientDatabase();
		
		  base.updatePatientDetails(id, name, age,gender,list);
			  
	  }
	
	
}
