package UserInputPackage;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import StateModel.DefaultHospitalMembers;

public class MainDisplay extends JFrame implements ActionListener{

	    JFrame frame;
	    JButton doctor = new JButton("DOCTOR");
	    JButton patient = new JButton("PATIENT");
	    JButton appointment = new JButton("APPOINTMENT");
	    JButton revenue = new JButton("REVENUE");
	    MainDisplay(){
	    	
	    	DefaultHospitalMembers members = new DefaultHospitalMembers();
	    	members.addDefaultMemebers();    	
	    	frame= new JFrame("Panel Example"); 
	    	
	    	JLabel label = new JLabel();
	    	label.setText("                 Apollo Hospital ");
	    	label.setFont(new Font("Tahoma",Font.BOLD,50));
	    	label.setBounds(30,10,800,200);
	    	frame.add(label);
	    	
	    	
	    	
	        JPanel panel=new JPanel();  
	        panel.setBounds(40,180,900,50);    
	        panel.setBackground(Color.gray);  
	       
	        doctor.setBounds(50,100,80,30);    
	        
	        doctor.addActionListener(this);
	        panel.add(doctor); 
	        
	        JPanel panel2=new JPanel();  
	        panel2.setBounds(40,280,900,50);   
	        panel2.setBackground(Color.gray);  
	        
	        
	        
	        patient.setBounds(100,200,80,30);    
	        patient.addActionListener(this);
	        panel2.add(patient); 
	        
	        JPanel panel3=new JPanel();  
	        panel3.setBounds(40,380,900,50);    
	        panel3.setBackground(Color.gray);  

	        appointment.setBounds(100,300,80,30);       
	        appointment.addActionListener(this);
	        panel3.add(appointment); 
	        
	        
	        JPanel panel4=new JPanel();  
	        panel4.setBounds(40,480,900,50);    
	        panel4.setBackground(Color.gray); 
	         
	        revenue.addActionListener(this);
	        panel4.add(revenue);
	        
	        frame.add(panel);
	        frame.add(panel2);
	        frame.add(panel3);
	        frame.add(panel4);
	        frame.setSize(1080,800);    
	        frame.setLayout(null);    
	        frame.setVisible(true);
	    }
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == doctor) {
				new DoctorUI();
			}
			
			if(e.getSource() == patient) {
				new PatientUI();
			}
			
			if(e.getSource() == appointment) {
				new AppoinmentUI();
			}
			
			if(e.getSource() == revenue) {
				Revenue rev = new Revenue();
			}
		}
	
	
	
}
