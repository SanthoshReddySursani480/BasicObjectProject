package UserInputPackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AppoinmentUI implements ActionListener {

	
	     JButton bookAppoinment = new JButton("BOOK APPOINTMENT");
	     JButton updateAppointment = new JButton("UPDATE APPOINTMENT");
	     JButton cancelAppointment = new JButton("CANCEL APPOINTMENT");
	     JButton ViewAppointments = new JButton("SHOW APPOINTMENT");
	     JButton eachDoctor = new JButton("View Doctor Appointment");
	     JButton back = new JButton("BACK");
	     JFrame frame = new JFrame();
	     AppoinmentUI(){
	    	   JLabel label = new JLabel();
		    	label.setText("        APPOINTMENT MANAGEMENT ");
		    	label.setFont(new Font("Tahoma",Font.BOLD,50));
		    	label.setBounds(30,10,900,200);
		    	frame.add(label);

			   
			   JPanel panel1=new JPanel();  
		        panel1.setBounds(40,180,900,50);    
		        panel1.setBackground(Color.gray);  
		        
		        bookAppoinment.addActionListener(this);
		        panel1.add(bookAppoinment);
		        
		        JPanel panel2=new JPanel();  
		        panel2.setBounds(40,280,900,50);   
		        panel2.setBackground(Color.gray);  
		        
		        updateAppointment.addActionListener(this);
		        panel2.add(updateAppointment);
		        
		        JPanel panel3=new JPanel();  
		        panel3.setBounds(40,380,900,50);    
		        panel3.setBackground(Color.gray); 
		        cancelAppointment.addActionListener(this);
		        panel3.add(cancelAppointment);
		        
		        JPanel panel4=new JPanel();  
		        panel4.setBounds(40,480,900,50);    
		        panel4.setBackground(Color.gray);  
		        ViewAppointments.addActionListener(this);
		        panel4.add(ViewAppointments);
		        
		        JPanel panel5=new JPanel();  
		        panel5.setBounds(40,680,900,50);    
		        panel5.setBackground(Color.gray);  
		        back.addActionListener(this);
		        panel5.add(back);
		        
		        JPanel panel6=new JPanel();  
		        panel6.setBounds(40,580,900,50);    
		        panel6.setBackground(Color.gray);  
		        eachDoctor.addActionListener(this);
		        panel6.add(eachDoctor);
		    
		        frame.add(panel1);  
		        frame.add(panel2);
		        frame.add(panel3);
		        frame.add(panel4);
		        frame.add(panel6);
		        frame.add(panel5);
		        
	            frame.setSize(1080,800);    
	            frame.setLayout(null);    
	            frame.setVisible(true);
			
	     }
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == bookAppoinment) {
				new BookAppointmentUI();
			}
			if(e.getSource() == updateAppointment) {
				new UpdateAppointmentUI();
			}
			if(e.getSource() == cancelAppointment) {
				new RemoveAppointmentUI();
			}
			if(e.getSource() == ViewAppointments ) {
				new ShowAppointment();
			}
			if(e.getSource() == eachDoctor) {
				new ShowDoctorAppointmentList();
				
			}
			if(e.getSource() == back) {
				frame.setVisible(false);
			}
		}
	
}
