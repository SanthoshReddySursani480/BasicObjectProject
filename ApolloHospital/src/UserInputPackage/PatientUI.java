package UserInputPackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PatientUI implements ActionListener {

	JButton addPatient = new JButton("ADD PATIENT");
	JButton updatePatient = new JButton("UPDATE PATIENT");
	JButton medicalHistory = new JButton("MEDICAL HISTORY");
	
	JButton back = new JButton("BACK");
	JFrame frame = new JFrame();
	PatientUI(){
		   JLabel label = new JLabel();
	    	label.setText("             PATIENT MANAGEMENT ");
	    	label.setFont(new Font("Tahoma",Font.BOLD,50));
	    	label.setBounds(30,10,900,200);
	    	frame.add(label);

		   
		   JPanel panel1=new JPanel();  
	        panel1.setBounds(40,180,900,50);    
	        panel1.setBackground(Color.gray);  
	        
	        addPatient.setBounds(10,0,80,30); 
	        addPatient.addActionListener(this);
	        panel1.add(addPatient);
	        
	        JPanel panel2=new JPanel();  
	        panel2.setBounds(40,280,900,50);   
	        panel2.setBackground(Color.gray);  
	        
	        updatePatient.addActionListener(this);
	        panel2.add(updatePatient);
	        
	        JPanel panel3=new JPanel();  
	        panel3.setBounds(40,380,900,50);    
	        panel3.setBackground(Color.gray); 
	        medicalHistory.addActionListener(this);
	        panel3.add(medicalHistory);
	        
	        

	       
	        
	        JPanel panel5=new JPanel();  
	        panel5.setBounds(40,580,900,50);    
	        panel5.setBackground(Color.gray);  
	        back.addActionListener(this);
	        panel5.add(back);
	        
	        frame.add(panel1);  
	        frame.add(panel2);
	        frame.add(panel3);
	  
	        frame.add(panel5);
           frame.setSize(1080,800);    
           frame.setLayout(null);    
           frame.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addPatient) {	
			new AddPatientUI();
		}
		
		if(e.getSource() == updatePatient) {
			new UpdatePatientUI();
		}
		if(e.getSource() == medicalHistory) {
			new PatientMedicalHistoryUI();
		}
		if(e.getSource() == back) {
			frame.setVisible(false);
		}
	}
	
	

}
