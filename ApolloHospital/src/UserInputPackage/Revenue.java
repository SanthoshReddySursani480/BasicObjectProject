package UserInputPackage;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import ClassModel.Appointment;
import DatabasePackage.AppointmentDatabase;
import DatabasePackage.DoctorDatabase;
import DatabasePackage.PatientDatabase;

public class Revenue {
	
	      Revenue(){
	    	AppointmentDatabase database = new AppointmentDatabase();
			Map<Integer,Appointment> listofappointment = new HashMap<Integer,Appointment>();
			listofappointment = database.returnAppointmentList();
			int size =0;
			int total = 0;
		     String[][] data1 = new String[listofappointment.size()+1][6];
		     for (Entry<Integer, Appointment> entry : listofappointment.entrySet())  {
		    	 
		            data1[size][0] = String.valueOf(entry.getKey());
		             DoctorDatabase base1 = new DoctorDatabase();     
		             data1[size][1] = String.valueOf(entry.getValue().getDoctorid())+" "+String.valueOf(base1.doctorlist.get(entry.getValue().getDoctorid()).getName());
		             PatientDatabase base2 = new PatientDatabase();
		             data1[size][2] = String.valueOf(entry.getValue().getPatientid())+" "+String.valueOf(base2.patientlist.get(entry.getValue().getPatientid()).getName());
		             data1[size][3] = String.valueOf(entry.getValue().getDate().substring(0,4))+"/"+String.valueOf(entry.getValue().getDate().substring(5,7))+"/"+String.valueOf(entry.getValue().getDate().substring(8));
		             data1[size][4] = String.valueOf(entry.getValue().getTime());
		             data1[size][5] = "700";
		             total+= Integer.valueOf(data1[size][5]);
                     size++;
		    }	
		     data1[size][5] = String.valueOf(total);
		       
			    JFrame  f=new JFrame();    
			    String data[][]=data1;
			    String column[]={"APPOINTMENT ID","Doctor ID","PATIENT ID","DATE","TIME","Appointment Fee"};     
			    JTable jt=new JTable(data,column);    
			    jt.setBounds(30,40,200,300); 
			    jt.setEnabled(false);
			    JScrollPane sp=new JScrollPane(jt);    
			    f.add(sp);  
			    f.setSize(1080,900);    
			    f.setVisible(true);
	    	
	    }

}
