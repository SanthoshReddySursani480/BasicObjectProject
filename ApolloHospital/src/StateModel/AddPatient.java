package StateModel;

import java.sql.SQLException;
import java.util.List;

import ClassModel.Patient;
import DatabasePackage.PatientDatabase;

public class AddPatient {
	
	public void addPatient(String name,int age,String gender,List<String> disease) throws ClassNotFoundException, SQLException{
		if(name!=null) {
		Patient patient  = new Patient(name,age,gender,disease);
		PatientDatabase base = new PatientDatabase();
		base.addDoctorToDatabase(patient);
		}
	}

}
