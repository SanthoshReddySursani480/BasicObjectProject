package UserInputPackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ClassModel.Doctor;
import DatabasePackage.DoctorDatabase;
import StateModel.RemoveDoctor;

public class RemoveDoctorUI implements ActionListener{
	 JButton save1 = new JButton("SAVE");
	  JTextField doctorid = new JTextField(30);
	  JTextField doctorname = new JTextField(30);
	  JTextField specilisation = new JTextField(30);
	    JButton submit= new JButton("REMOVE");
	    JFrame frame = new JFrame();
	    int id;
	    String name;
	    String spec;
	      RemoveDoctorUI(){
		  JLabel label = new JLabel();
	    	label.setText("                 REMOVE  DOCTOR ");
	    	label.setFont(new Font("Tahoma",Font.BOLD,50));
	    	label.setBounds(30,10,900,200);
	    	frame.add(label);

	    	
		   
		   JPanel panel1=new JPanel();  
	        panel1.setBounds(40,180,900,50);    
	        panel1.setBackground(Color.white);  
	        
	        JLabel label1 = new JLabel();
	        label1.setText("ENTER DOCTOR ID ");
	        
	        panel1.add(label1);
	        panel1.add(doctorid);
	        save1.addActionListener(this);
	        panel1.add(save1);
	        
	        
	        JPanel panel2=new JPanel();  
	        panel2.setBounds(40,280,900,50);   
	        panel2.setBackground(Color.white);  
	        
	        JLabel label2 = new JLabel();
	        label2.setText("DOCTOR NAME ");
	        
	        panel2.add(label2);
	        panel2.add(doctorname);
	      
	        
	        JPanel panel3=new JPanel();  
	        panel3.setBounds(40,380,900,50);    
	        panel3.setBackground(Color.white);  
	        
	        JLabel label3 = new JLabel();
	        label3.setText("SPECIALISATION ");
	        
	        panel3.add(label3);
	        panel3.add(specilisation);
	        
	        
	        JPanel panel4=new JPanel();  
	        panel4.setBounds(40,480,900,50);    
	        panel4.setBackground(Color.gray);  
	        submit.addActionListener(this);
	         panel4.add(submit);

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
			if(e.getSource() == save1) {
				 id = Integer.valueOf(doctorid.getText());
				DoctorDatabase base = new DoctorDatabase();
				base.getDoctorDetails();
				if(base.doctorlist.containsKey(id)) {
				base.getDoctorDetails();
				 name = base.doctorlist.get(id).getName();
				 spec = base.doctorlist.get(id).getSpecification();
				 doctorname.setText(name);
				 specilisation.setText(spec);
				}
				else {
					JOptionPane.showMessageDialog(frame,"Doctor with id "+id+" doesnot EXIST");
				}
			}
			if(e.getSource() == submit) {
				RemoveDoctor remove = new RemoveDoctor();
				remove.removeDoctor(id);
				frame.setVisible(false);
			}
		}

}
