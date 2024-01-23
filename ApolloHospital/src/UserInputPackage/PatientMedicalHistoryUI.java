package UserInputPackage;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import ClassModel.Doctor;
import ClassModel.Patient;
import DatabasePackage.PatientDatabase;

public class PatientMedicalHistoryUI {
	
	PatientMedicalHistoryUI(){
		
		PatientDatabase base = new PatientDatabase();
		Map<Integer,Patient> listofpatient = new HashMap<Integer,Patient>();
		listofpatient = base.patientlist;
		int size =0;
		String[][] data1 = new String[listofpatient.size()][3];
		for (Entry<Integer, Patient> entry : listofpatient.entrySet())  {

              data1[size][0] = String.valueOf(entry.getKey()); 
              data1[size][1] = entry.getValue().getName();
              String safe = "";
              for(int i=0;i<entry.getValue().getPatientMedicalHistory().size();i++) {
            	  safe+=entry.getValue().getPatientMedicalHistory().get(i)+" ";
              }
            	  
              data1[size][2] = safe;
              size++;
    }
		
		
		    JFrame  f=new JFrame();    
		    String data[][]=data1;
		    String column[]={"Patient ID","Patient Name","Patient Medical History"};     
		    JTable jt=new JTable(data,column);    
		    jt.setBounds(30,40,200,300); 
		    jt.setEnabled(false);
		    JScrollPane sp=new JScrollPane(jt);    
		    f.add(sp);  
		    f.setSize(1080,900);   
		    f.setVisible(true);
		
	}

}
