package UserInputPackage;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ClassModel.Doctor;
import DatabasePackage.DoctorDatabase;
import StateModel.AddDoctor;
import DatabasePackage.DoctorDatabase;

public class AddDoctorUI implements ActionListener {
	    
	    JButton save1 = new JButton("SAVE");
	    JButton save2 = new JButton("SAVE");
	    JButton submit= new JButton("ADD");
	    JButton back = new JButton("BACK");
	    JFrame frame = new JFrame();
	    JTextField doctorname = new JTextField(30);
	    String[] s = {"Primary Care","Allergists","Dermatologists","Opthamologists","Gynecologists","Cardiologits","Endocrinologists"
	    		,"Gastroenterologists","Nephrologists","Urologists","Pulmonologits","Ptolaryngologists","Neurologists","Pyschiatrists","Oncologists","Radiologists","Othopedic Surgeon"};
	    JComboBox specialiasation = new JComboBox(s);
	    String name="",spec = "";
	  
	    AddDoctorUI(){
	    	   JLabel label = new JLabel();
		    	label.setText("                 ADD DOCTOR ");
		    	label.setFont(new Font("Tahoma",Font.BOLD,50));
		    	label.setBounds(30,10,900,200);
		    	frame.add(label);

			   
			   JPanel panel1=new JPanel();  
		        panel1.setBounds(40,180,900,50);    
		        panel1.setBackground(Color.white);  
		        
		        JLabel label1 = new JLabel();
		        label1.setText("ENTER NAME: ");
		        
		        
		        panel1.add(label1);
		        panel1.add(doctorname);
		        save1.addActionListener(this);
		        panel1.add(save1);
		        
		        JPanel panel2=new JPanel();  
		        panel2.setBounds(40,280,900,50);   
		        panel2.setBackground(Color.white);  
		        
		        JLabel labe12 = new JLabel();
		        labe12.setText("Choose Specialisation");
		        
		       
		        panel2.add(labe12);
		        specialiasation.addActionListener(this);
		        panel2.add(specialiasation);
		        save2.addActionListener(this);
		        panel2.add(save2);
		        
		        JPanel panel3=new JPanel();  
		        panel3.setBounds(40,380,900,50);    
		        panel3.setBackground(Color.gray);  
		        submit.addActionListener(this);
		         panel3.add(submit);
		        
		         JPanel panel4=new JPanel();  
			        panel4.setBounds(40,480,900,50);    
			        panel4.setBackground(Color.gray);  
			        back.addActionListener(this);
			         panel4.add(back);
		        

		   	    frame.add(panel1);  
		        frame.add(panel2);
		        frame.add(panel3);
		        frame.add(panel4);
	            frame.setSize(1080,800);    
	            frame.setLayout(null);    
	            frame.setVisible(true);
			 
	    }
	    
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == save1) {
				name = doctorname.getText();
			}
			if(e.getSource() == save2) {
				spec = (String) specialiasation.getItemAt(specialiasation.getSelectedIndex());
				
			}
			if(e.getSource() == back) {
				frame.setVisible(false);
				new DoctorUI();
			}
			if(e.getSource() == submit) {
				 AddDoctor addDoctor = new AddDoctor();
				 addDoctor.addDoctor(name, spec);
				  frame.setVisible(false);
				
			}
			
		}

}
