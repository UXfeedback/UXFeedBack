package com.example.ux_feedback;

import java.sql.Date;

public class ESM_Datatype {

	private int ID_USER;
	private String DATA;
	private String POSITION;
	private String AKTIVITY;
	//private Boolean CHECK;
	//private Date DATE;
	
	
	public ESM_Datatype(int ID, String Data, String Position) {
		this.ID_USER = ID;
		this.DATA = Data;
		this.POSITION = Position;
	}
	
	public ESM_Datatype(int ID, String Data) {
		this.ID_USER = ID;
		this.DATA = Data;
	}
	
	public ESM_Datatype(String Aktivity, int ID) {
		this.ID_USER = ID;
		this.AKTIVITY = Aktivity;
	} 
	
	public void setID(int ID) {
		this.ID_USER = ID;
	}
	
	public int getID() {
		return this.ID_USER;
	}
	
	public void setData(String Data) {
		this.DATA = Data;
	}
	
	public String getData() {
		return this.DATA;
	}
	
	public void setPosition(String Position) {
		this.POSITION = Position;
	}
	
	public String getPosition() {
		return this.POSITION;
	}
	
	public void setAktivity(String Aktivity) {
		this.AKTIVITY = Aktivity;
	}
	
	public String getAktivity() {
		return this.AKTIVITY;
	}
	
	//public void setCheck(Boolean Check) {
	//	this.CHECK = Check;
	//}
	//
	//public Boolean getCheck() {
	//	return this.CHECK;
	//}
	
	//public void setDate(Date Date) {
	//	this.DATE = Date;
	//}
	//
	//public Date getDate() {
	//	return this.DATE;
	//}

}
