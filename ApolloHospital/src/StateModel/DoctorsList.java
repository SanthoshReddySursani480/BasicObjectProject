package StateModel;

import java.util.ArrayList;
import java.util.HashMap;

import ClassModel.Doctor;
import DatabasePackage.DoctorDatabase;

public class DoctorsList {
    
    private HashMap<String,ArrayList<Doctor>> doctorsListSpecific = new HashMap<>();
    
    public ArrayList<Doctor> showList(){
        ArrayList<Doctor> allDoctors = new ArrayList<>();
        for(ArrayList<Doctor> doctors : doctorsListSpecific.values()) {
            allDoctors.addAll(doctors);
        }
        return allDoctors;
    }
    
    public ArrayList<Doctor> dotorsListSpecific(String specialization){
        return doctorsListSpecific.get(specialization);
    }


    public HashMap<String, ArrayList<Doctor>> getDoctorsListSpecific() {
        return doctorsListSpecific;
    }

    public void setDoctorsListSpecific(HashMap<String, ArrayList<Doctor>> doctorsListSpecific) {
        this.doctorsListSpecific = doctorsListSpecific;
    }
    
}
