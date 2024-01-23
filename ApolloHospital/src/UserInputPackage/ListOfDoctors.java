package UserInputPackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ClassModel.Doctor;
import DatabasePackage.DoctorDatabase;

public class ListOfDoctors extends JFrame {
	
	JFrame frame = new JFrame();
	
	
	
	ListOfDoctors(){
	
		DoctorDatabase base = new DoctorDatabase();
	    Map<Integer,Doctor> listofdoctor = new HashMap<Integer,Doctor>();
	    listofdoctor = base.doctorlist;	
	   
	     int size =0;
	     String[][] data1 = new String[listofdoctor.size()][3];
	     for (Map.Entry<Integer,Doctor> entry : listofdoctor.entrySet())  {

	          
	            data1[size][0] = String.valueOf(entry.getKey());
	            data1[size][1] = entry.getValue().getName();
	            data1[size][2] = entry.getValue().getSpecification();
	            size++;
	    }
	   
	 /*   for(int i=0;i<data1.length;i++) {
	    	for(int j=0;j<3;j++) {
	    		System.out.print(data1[i][j]);
	    	}
	    	System.out.println();
	    }*/
	    
	    
	   JFrame  f=new JFrame();    
	    String data[][]=data1;
	    String column[]={"Doctor ID","Doctor Name","Doctor Specialisation"};     
	    JTable jt=new JTable(data,column);    
	    jt.setBounds(30,40,200,300); 
	    jt.setEnabled(false);
	    JScrollPane sp=new JScrollPane(jt);    
	    f.add(sp);  
	    f.setSize(1080,900);    
	    f.setVisible(true);

	}

}
