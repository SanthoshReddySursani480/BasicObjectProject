package UserInputPackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ClassModel.Doctor;
import DatabasePackage.DoctorDatabase;
import StateModel.UpdateDoctor;

public class UpdateDoctorUI implements ActionListener {

	    JButton save1 = new JButton("SAVE");
	    JButton save2 = new JButton("SAVE");
	    JButton save3 = new JButton("SAVE");
	    JButton submit= new JButton("ADD");
	    JFrame frame = new JFrame();
	    JTextField doctorid = new JTextField(30);
	    JTextField doctorname = new JTextField(30);
	    String[] s = {"Primary Care","Allergists","Dermatologists","Opthamologists","Gynecologists","Cardiologits","Endocrinologists","Gastroenterologists","Nephrologists","Urologists","Pulmonologits","Ptolaryngologists","Neurologists","Pyschiatrists","Oncologists","Radiologists","Othopedic Surgeon"};
	    JComboBox specialiasation = new JComboBox(s);
	
	    int id;
	    String name;
	    String spec;
	
	  UpdateDoctorUI(){
		   JLabel label = new JLabel();
	    	label.setText("                 UPDATE DOCTOR ");
	    	label.setFont(new Font("Tahoma",Font.BOLD,50));
	    	label.setBounds(30,10,900,200);
	    	frame.add(label);

	    	
		   
		   JPanel panel1=new JPanel();  
	        panel1.setBounds(40,180,900,50);    
	        panel1.setBackground(Color.white);  
	        
	        JLabel label1 = new JLabel();
	        label1.setText("ENTER DOCTOR ID");
	        
	        panel1.add(label1);
	        panel1.add(doctorid);
	        save1.addActionListener(this);
	        panel1.add(save1);
	        
	        
	       
	        JPanel panel2=new JPanel();  
	        panel2.setBounds(40,280,900,50);   
	        panel2.setBackground(Color.white);  
	        
	      
	        JLabel label2 = new JLabel();
	        label2.setText("UPDATE DOCTOR NAME ");
	        
	        panel2.add(label2);
	        panel2.add(doctorname);
	        save2.addActionListener(this);
	        panel2.add(save2);
	        
	        
	       
	       
	        JPanel panel3=new JPanel();  
	        panel3.setBounds(40,380,900,50);    
	        panel3.setBackground(Color.white);  
	        
	        JLabel label3 = new JLabel();
	        label3.setText("Change Specialisation");
	        
	        panel3.add(label3);
	        specialiasation.addActionListener(this);
	        panel3.add(specialiasation);
	        save3.addActionListener(this);
	        panel3.add(save3);
	        
	        
	        
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
			if(base.doctorlist.containsKey(id)){
			name = base.doctorlist.get(id).getName();
			spec = base.doctorlist.get(id).getSpecification();
			doctorname.setText(name);
			specialiasation.setToolTipText(spec);
			}
			else {
				JOptionPane.showMessageDialog(frame,"Invalid DoctorId");
			}
		}
		if(e.getSource() == save2) {
			name = doctorname.getText();
		}
		if(e.getSource() == save3) {
			spec = (String) specialiasation.getItemAt(specialiasation.getSelectedIndex());
		}
		if(e.getSource() == submit) {
			UpdateDoctor update = new UpdateDoctor();
			update.updateDoctor(id, name, spec);
			frame.setVisible(false);
		
		}
		
	}
}
