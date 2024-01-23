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

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ClassModel.Patient;
import DatabasePackage.DoctorDatabase;
import DatabasePackage.PatientDatabase;
import StateModel.BookAppointment;
import StateModel.UpdateDoctorAppointment;

public class BookAppointmentUI implements ActionListener{

	
	JTextField patientId = new JTextField(20);
	JComboBox selectDoctor;
	JTextField doctorSpecialisation = new JTextField(15);
	JTextField doctorName = new JTextField(15);
	JTextField year = new JTextField(4);
	JTextField month = new JTextField(2);
	JTextField day = new JTextField(2);
	JTextField hour = new JTextField(2);
	JTextField minutes = new JTextField(2);
	JButton save1 = new JButton("SAVE");
	JButton save2 = new JButton("SAVE");
	JButton save3 = new JButton("SAVE");
	JButton save4 = new JButton("SAVE");
	JButton submit = new JButton("SUBMIT");
	JFrame frame = new JFrame();
	int tempid;
	int tempdocid;
	String tempdate;
	String tempyear,tempmonth,tempday;
	int temphour,tempminutes;
	List<Time> time = new ArrayList<Time>();
	
	 BookAppointmentUI(){
		 JLabel label = new JLabel();
	    	label.setText("           BOOK APPOINTMENT ");
	    	label.setFont(new Font("Tahoma",Font.BOLD,50));
	    	label.setBounds(30,10,900,200);
	    	frame.add(label);

	    	
		   JPanel panel1=new JPanel();  
	        panel1.setBounds(40,180,900,50);    
	        panel1.setBackground(Color.white);  
	        
	        JLabel label1 = new JLabel();
	        label1.setText("ENTER PATIENT ID : ");       
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
	        
	        selectDoctor = new JComboBox(s);
	        
	        JLabel label2 = new JLabel();
	        label2.setText("SELECT DOCTOR");
	        selectDoctor.addActionListener(this);
	        save2.addActionListener(this);
	        
	        panel2.add(label2);
	        panel2.add(selectDoctor);
	        panel2.add(doctorName);
	        panel2.add(doctorSpecialisation);
	        panel2.add(save2);
	        
	        JPanel panel3=new JPanel();  
	        panel3.setBounds(40,380,900,50);    
	        panel3.setBackground(Color.white);  
	        
	        JLabel label3 = new JLabel();
	        label3.setText("Date : YYYY MM DD ");
	        save3.addActionListener(this);
	        panel3.add(label3);
	        panel3.add(year);
	        panel3.add(month);
	        panel3.add(day);
	        panel3.add(save3);
	        
	        
	        JPanel panel4=new JPanel();  
	        panel4.setBounds(40,480,900,50);    
	        panel4.setBackground(Color.white); 
	        
	        JLabel label4 = new JLabel();
	        label4.setText("Time : Hours Minutes");
	        save4.addActionListener(this);
	        
	        panel4.add(label4);
	        panel4.add(hour);
	        panel4.add(minutes);
	        panel4.add(save4);
	        
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
			tempid = Integer.valueOf(patientId.getText());
			   if(!checkIfIdExsists(tempid)) {
				   JOptionPane.showMessageDialog(frame, "Patient with id "+tempid+" not present");
			   }
		}
		
		if(e.getSource() == selectDoctor) {
			tempdocid = Integer.valueOf((String) selectDoctor.getItemAt(selectDoctor.getSelectedIndex()));
			DoctorDatabase base = new DoctorDatabase();
			doctorName.setText(base.doctorlist.get(tempdocid).getName());    
			doctorSpecialisation.setText(base.doctorlist.get(tempdocid).getSpecification());
		}
		
		if(e.getSource() == save2) {
			tempdocid = Integer.valueOf((String) selectDoctor.getItemAt(selectDoctor.getSelectedIndex()));
			DoctorDatabase base = new DoctorDatabase();
			doctorName.setText(base.doctorlist.get(tempdocid).getName());    
			doctorSpecialisation.setText(base.doctorlist.get(tempdocid).getSpecification());
			new ViewDoctorAppointment(tempdocid);
		}
		
		if(e.getSource() == save3) {
			tempyear = (year.getText());
			tempmonth =(month.getText());
			tempday = (day.getText());
			tempdate = tempyear+"/"+tempmonth+"/"+tempday;
			
			if(Integer.valueOf(tempmonth)>12 || Integer.valueOf(tempday)>31) {
				JOptionPane.showMessageDialog(frame, "Please Enter Correct Date And Time ");
			}
			
		}
		
		if(e.getSource() == save4) {
			temphour = Integer.valueOf(hour.getText());
			tempminutes = Integer.valueOf(minutes.getText());	
			
			if(Integer.valueOf(temphour)>24 || Integer.valueOf(tempminutes)>59) {
				JOptionPane.showMessageDialog(frame, "Please Enter Correct Date And Time ");
			}
			
		}
		
		if(e.getSource() == submit) {
			    
			if(tempyear== null || tempmonth == null || tempday == null || String.valueOf(temphour) == null || String.valueOf(tempminutes) == null){
				JOptionPane.showMessageDialog(frame,"Enter proper details Or SAVE DEtails");
			}
			else {
			    if(checkIfIdExsists(tempid)) {	
				BookAppointment book = new BookAppointment();
			    String date = String.valueOf(tempyear)+"/"+String.valueOf(tempmonth)+"/"+String.valueOf(tempday);
				Time time = new Time(temphour,tempminutes,0);
				book.bookAppointment(tempid, tempdocid,date,time);
				frame.setVisible(false);
			    }
			    else {
			    	JOptionPane.showMessageDialog(frame,"Patient with "+tempid+"Doesnot Exits");
			    }
			}
			  
		}
	}
	
	public boolean checkIfIdExsists(int id) {
		
		PatientDatabase base = new PatientDatabase();
		for(Map.Entry<Integer,Patient> entry : base.patientlist.entrySet()) {
			if(entry.getKey() == id) {
				return true;
			}
		}
		return false;
	}
	
	
}
