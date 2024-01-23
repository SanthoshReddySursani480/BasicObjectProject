package ClassModel;

import java.sql.Time;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Doctor {
	private int doctorid;
	private String name;
	private String specification;
	private Map<String,List<Time>> dateandtimeList;
	private static int idGenerator=0;
	
	public Doctor(String name, String specification) {
		super();
		this.doctorid=++idGenerator;
		this.name = name;
		this.specification = specification;
	}
	
	public Doctor() {
		super();
		this.doctorid = ++idGenerator;
	}

	public int getDoctorid() {
		return doctorid;
	}

	@Override
	public String toString() {
		return "doctorid : " + doctorid + ",  name :" + name + ", specification :" + specification + " ";
	}

	public String getName() {
		return name;
	}

	public Map<String, List<Time>> getDateandtimeList() {
		return dateandtimeList;
	}

	public void setDateandtimeList(Map<String, List<Time>> dateandtimeList) {
		this.dateandtimeList = dateandtimeList;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

}
