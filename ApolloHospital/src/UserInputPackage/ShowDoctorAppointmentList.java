package UserInputPackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ClassModel.Appointment;
import DatabasePackage.AppointmentDatabase;
import DatabasePackage.DoctorDatabase;

public class ShowDoctorAppointmentList implements ActionListener {
	         
	
	   
		
            JButton save1 = new JButton("SAVE");
	        JButton submit = new JButton("submit");
	        JComboBox selectDoctor;
	        JTextField doctorID = new JTextField(20);
	        JFrame frame = new JFrame();
	        int docID;
	      ShowDoctorAppointmentList(){
	    	  
	    	  AppointmentDatabase database = new AppointmentDatabase();
	  		Map<Integer,Appointment> listofappointment = new HashMap<Integer,Appointment>();
	  		listofappointment = database.returnAppointmentList();
	  	
	  		 JLabel label = new JLabel();
		    	label.setText("       SEE DOCTOR APPOINTMENT ");
		    	label.setFont(new Font("Tahoma",Font.BOLD,50));
		    	label.setBounds(30,10,900,200);
		    	frame.add(label);

		    	
			   JPanel panel1=new JPanel();  
		        panel1.setBounds(40,180,900,50);    
		        panel1.setBackground(Color.white); 
	  		
		        JLabel label1 = new JLabel();
		        label1.setText("SELECT DOCTOR ID : ");       
		        save1.addActionListener(this);
		        panel1.add(label1);
		        panel1.add(save1);
		        save1.addActionListener(this);
		        

	        DoctorDatabase base = new DoctorDatabase();
	        
	        String[] s = new String[base.doctorlist.size()];
	        for(int i=0;i<s.length;i++) {
	        	s[i] = String.valueOf(base.doctorlist.get(i+1).getDoctorid());
	        }
	        
	        selectDoctor = new JComboBox(s);
	        
             selectDoctor.addActionListener(this);
	        panel1.add(selectDoctor);
	        panel1.add(doctorID);
	        panel1.add(save1);
	        
	        

			   JPanel panel2=new JPanel();  
		        panel2.setBounds(40,280,900,50);    
		        panel2.setBackground(Color.gray); 
		        submit.addActionListener(this);
		        panel2.add(submit);
	        frame.add(label);
	        frame.add(panel1);
	        frame.add(panel2);
	        frame.setSize(1080,800);    
	           frame.setLayout(null);    
	           frame.setVisible(true);
	  		
	      }
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == selectDoctor) {
				docID = Integer.valueOf((String)selectDoctor.getItemAt(selectDoctor.getSelectedIndex()));
				doctorID.setText(String.valueOf(docID));
			}
			if(e.getSource() == save1) {
			
			}
			if(e.getSource() == submit) {
				if(doctorID.getText() == null){
					JOptionPane.showMessageDialog(frame, "NO DOCTOR AVAILABLE");
				}
				else {
					ViewDoctorAppointment app = new ViewDoctorAppointment(docID);
					frame.setVisible(false);
				}
			}
		}
		
		
}
