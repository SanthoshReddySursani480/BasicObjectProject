package UserInputPackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ClassModel.Appointment;
import ClassModel.Patient;
import DatabasePackage.AppointmentDatabase;
import DatabasePackage.DoctorDatabase;
import DatabasePackage.PatientDatabase;
import StateModel.CancelAppointment;
import StateModel.UpdateAppointment;

public class RemoveAppointmentUI implements ActionListener {

	JTextField patientId = new JTextField(20);
	JTextField doctorSpecialisation = new JTextField(15);
	JTextField doctorName = new JTextField(15);
	JTextField year = new JTextField(4);
	JTextField month = new JTextField(2);
	JTextField day = new JTextField(2);
	JTextField hour = new JTextField(2);
	JTextField minutes = new JTextField(2);
	JButton save1 = new JButton("SAVE");
	int appointmentid;
	
	JButton submit = new JButton("CANCEL");
	
	JFrame frame = new JFrame();
	
	int tempid;
	int tempdocid;
	int tempyear,tempmonth,tempday,temphour,tempminutes;
	List<Time> time = new ArrayList<Time>();
	
	     RemoveAppointmentUI(){
	    	 JLabel label = new JLabel();
		    	label.setText("           Cancel APPOINTMENT ");
		    	label.setFont(new Font("Tahoma",Font.BOLD,50));
		    	label.setBounds(30,10,900,200);
		    	frame.add(label);

		    	
			   JPanel panel1=new JPanel();  
		        panel1.setBounds(40,180,900,50);    
		        panel1.setBackground(Color.white);  
		        
		        JLabel label1 = new JLabel();
		        label1.setText("ENTER APPOINTMENT ID : ");       
		        save1.addActionListener(this);
		        panel1.add(label1);
		        panel1.add(patientId);
		        panel1.add(save1);
		        
		        
		        JPanel panel2=new JPanel();  
		        panel2.setBounds(40,280,900,50);   
		        panel2.setBackground(Color.white);  
		        
		        DoctorDatabase base = new DoctorDatabase();
		        
		        String[] s = new String[base.doctorlist.size()];
		        for(int i=0;i<s.length;i++) {
		        	s[i] = String.valueOf(base.doctorlist.get(i+1).getDoctorid());
		        }
		        
		    
		        panel2.add(doctorName);
		        panel2.add(doctorSpecialisation);
		     
		        
		        JPanel panel3=new JPanel();  
		        panel3.setBounds(40,380,900,50);    
		        panel3.setBackground(Color.white);  
		        
		        JLabel label3 = new JLabel();
		        label3.setText("Date : YYYY MM DD ");
		      
		        panel3.add(label3);
		        panel3.add(year);
		        panel3.add(month);
		        panel3.add(day);
		   
		        
		        
		        JPanel panel4=new JPanel();  
		        panel4.setBounds(40,480,900,50);    
		        panel4.setBackground(Color.white); 
		        
		        JLabel label4 = new JLabel();
		        label4.setText("Time : Hours Minutes");
		        
		        
		        panel4.add(label4);
		        panel4.add(hour);
		        panel4.add(minutes);
		      
		        
		        JPanel panel5=new JPanel();  
		        panel5.setBounds(40,580,900,50);    
		        panel5.setBackground(Color.gray); 
		        submit.addActionListener(this);
		        panel5.add(submit);
		        
		        frame.add(panel1);  
		        frame.add(panel2);
		        frame.add(panel3);
		        frame.add(panel4);
		        frame.add(panel5);
	        frame.setSize(1080,800);    
	        frame.setLayout(null);    
	        frame.setVisible(true);
	     }

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == save1) {
				AppointmentDatabase database = new AppointmentDatabase();
				appointmentid = Integer.valueOf(patientId.getText());
				if(checkIfIdExsists(appointmentid)) {
					
					doctorName.setText("DOCTORID :"+String.valueOf(database.returnAppointmentList().get(appointmentid).getDoctorid()));
					doctorSpecialisation.setText("PATIENT ID : "+String.valueOf(database.returnAppointmentList().get(appointmentid).getPatientid()));
					year.setText(String.valueOf(database.returnAppointmentList().get(appointmentid).getDate().substring(0,4)));
					month.setText(String.valueOf(database.returnAppointmentList().get(appointmentid).getDate().substring(5,7)));
					day.setText(String.valueOf(database.returnAppointmentList().get(appointmentid).getDate().substring(8)));
					hour.setText(String.valueOf(database.returnAppointmentList().get(appointmentid).getTime().getHours()));
					minutes.setText(String.valueOf(database.returnAppointmentList().get(appointmentid).getTime().getMinutes()));
				}
				else {
					JOptionPane.showMessageDialog(frame, "Appointment with id "+appointmentid+" doesnot Exist");
				}
				
			}
			
			if(e.getSource() == submit) {
				CancelAppointment cancel = new CancelAppointment();
				cancel.cancelAppointment(appointmentid);
				frame.setVisible(false);
			}
			
		}
		
		public boolean checkIfIdExsists(int id) {
			
			AppointmentDatabase base = new AppointmentDatabase();
			for(Entry<Integer, Appointment> entry : base.returnAppointmentList().entrySet()) {
				if(entry.getKey() == id) {
					return true;
				}
			}
			return false;
		}
	

}
