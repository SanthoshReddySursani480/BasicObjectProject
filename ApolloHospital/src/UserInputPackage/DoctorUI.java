package UserInputPackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DoctorUI implements ActionListener {
       
	   JButton addDoctor = new JButton("ADD DOCTOR");
	   JButton updateDoctor = new JButton("UPDATE DOCTOR");
	   JButton ListOfDoctors = new JButton("LIST OF DOCTORS");
	   JButton removeDoctor = new JButton("REMOVE DOCTOR");
	   JButton back = new JButton("BACK");
	   JFrame frame = new JFrame();
	   
	   DoctorUI(){
		  
		   JLabel label = new JLabel();
	    	label.setText("             DOCTOR MANAGEMENT ");
	    	label.setFont(new Font("Tahoma",Font.BOLD,50));
	    	label.setBounds(30,10,900,200);
	    	frame.add(label);

		   
		   JPanel panel1=new JPanel();  
	        panel1.setBounds(40,180,900,50);    
	        panel1.setBackground(Color.gray);  
	        
	        addDoctor.setBounds(10,0,80,30); 
	        addDoctor.addActionListener(this);
	        panel1.add(addDoctor);
	        
	        JPanel panel2=new JPanel();  
	        panel2.setBounds(40,280,900,50);   
	        panel2.setBackground(Color.gray);  
	        
	        updateDoctor.addActionListener(this);
	        panel2.add(updateDoctor);
	        
	        JPanel panel3=new JPanel();  
	        panel3.setBounds(40,380,900,50);    
	        panel3.setBackground(Color.gray);  
	        ListOfDoctors.addActionListener(this);
	        panel3.add(ListOfDoctors);
	        
	        

	        JPanel panel4=new JPanel();  
	        panel4.setBounds(40,480,900,50);    
	        panel4.setBackground(Color.gray);  
	        removeDoctor.addActionListener(this);
	        panel4.add(removeDoctor);
	        
	        JPanel panel5=new JPanel();  
	        panel5.setBounds(40,580,900,50);    
	        panel5.setBackground(Color.gray);  
	        back.addActionListener(this);
	        panel5.add(back);
	        
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
		if(e.getSource() == addDoctor) {
		
			new AddDoctorUI();
		}
		if(e.getSource() == updateDoctor) {
			new UpdateDoctorUI();
		}
		if(e.getSource() == ListOfDoctors) {
			new ListOfDoctors();
		}
		if(e.getSource() == removeDoctor) {
			new RemoveDoctorUI();
		}
		if(e.getSource() == back) {
			frame.setVisible(false);
		}
	}
}
