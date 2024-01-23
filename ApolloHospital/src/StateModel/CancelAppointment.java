package StateModel;

import DatabasePackage.AppointmentDatabase;

public class CancelAppointment {
	
	public static void cancelAppointment(int id) {
		AppointmentDatabase base = new AppointmentDatabase();
		base.removeAppointment(id);
	}

}
