package UserInputPackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DatabasePackage.PatientDatabase;
import StateModel.AddPatient;

public class AddPatientUI implements ActionListener {
	
	JButton save1 = new JButton("SAVE");
	JButton save2 = new JButton("SAVE");
	JButton save3 = new JButton("SAVE");
	JButton save4 = new JButton("SAVE");
	JButton submit = new JButton("ADD");
	JButton back = new JButton("BACK");
	
	JTextField name = new JTextField(30);
	JTextField age = new JTextField(30);
	String[] s = {"MALE","FEMALE"};
	JComboBox gender = new JComboBox(s);
	JTextField disease = new JTextField(30);
	
	String tempname;
	int tempage;
	String tempgender;
	List<String> diseaseList = new ArrayList<>();
	
	JFrame frame = new JFrame();
	AddPatientUI(){
		JLabel label = new JLabel();
    	label.setText("                 ADD PATIENT ");
    	label.setFont(new Font("Tahoma",Font.BOLD,50));
    	label.setBounds(30,10,900,200);
    	frame.add(label);

		
		
		    JPanel panel1=new JPanel();  
	        panel1.setBounds(40,180,900,50);    
	        panel1.setBackground(Color.white);  
	        
	        JLabel label1 = new JLabel();
	        label1.setText("PATIENT NAME");
	        
	        panel1.add(label1);
	        panel1.add(name);
	        save1.addActionListener(this);
	        panel1.add(save1);
	        
	        
	        JPanel panel2=new JPanel();  
	        panel2.setBounds(40,280,900,50);   
	        panel2.setBackground(Color.white);  
	        
	        JLabel label2 = new JLabel();
	        label2.setText("PATIENT AGE");
	        
	        panel2.add(label2);
	        panel2.add(age);
	        save2.addActionListener(this);
	        panel2.add(save2);
	        
	        
	        
	        JPanel panel3=new JPanel();  
	        panel3.setBounds(40,380,900,50);    
	        panel3.setBackground(Color.white);  
	        
	        JLabel label3 = new JLabel();
	        label3.setText("Patient GENDER");
	        
	        panel3.add(label3);
	        gender.addActionListener(this);
	        panel3.add(gender);
	        save3.addActionListener(this);
	        panel3.add(save3);
	        
	        
	        JPanel panel4=new JPanel();  
	        panel4.setBounds(40,480,900,50);    
	        panel4.setBackground(Color.white); 
	        
	        JLabel label4 = new JLabel();
	        label4.setText("PATIENT CONDITION");
	        
	        panel4.add(label4);
	        panel4.add(disease);
	        save4.addActionListener(this);
	        panel4.add(save4);
	        
	        JPanel panel5=new JPanel();  
	        panel5.setBounds(40,580,900,50);    
	        panel5.setBackground(Color.gray); 
	        submit.addActionListener(this);
	        panel5.add(submit);
	        
	        JPanel panel6=new JPanel();  
	        panel6.setBounds(40,680,900,50);    
	        panel6.setBackground(Color.gray); 
	        back.addActionListener(this);
	        panel6.add(back);

	   	    frame.add(panel1);  
	        frame.add(panel2);
	        frame.add(panel3);
	        frame.add(panel4);
	        frame.add(panel5);
	      frame.add(panel6);
            frame.setSize(1080,800);    
            frame.setLayout(null);    
            frame.setVisible(true);
     
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	
		
		if(e.getSource() == save1) {
			tempname = name.getText();
		}
		if(e.getSource() == save2) {
			    if(isDigit(age.getText())) {
			    	tempage = Integer.valueOf(age.getText());
			    }
			    else {
			    	JOptionPane.showMessageDialog(frame,"Enter Age Properly");
			    }
				
		}
		if(e.getSource() == save3) {
			tempgender = (String) gender.getItemAt(gender.getSelectedIndex());
		}
		if(e.getSource() == save4) {
			diseaseList.add(disease.getText());
		}
		if(e.getSource() == submit) {
			
			tempname = name.getText();
			tempage = Integer.valueOf(age.getText());
			
			AddPatient add = new AddPatient();
	        try {
				add.addPatient(tempname, tempage, tempgender, diseaseList);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			frame.setVisible(false);
			new PatientUI();

		}
		if(e.getSource() == back) {
			frame.setVisible(false);
		}
	}
	
	public boolean isDigit(String num) {
		for(int i=0;i<num.length();i++) {
			if(!(num.charAt(i)>='0' && num.charAt(i)<='9')) {
				return false;
			}
		}
		return true;
		
	}
	
	

}
