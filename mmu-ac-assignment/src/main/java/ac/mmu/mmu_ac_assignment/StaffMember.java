package ac.mmu.mmu_ac_assignment;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
@XmlRootElement
public class StaffMember {
private int StaffID;
private String surname;
private String forename;
private String location;
private String phone;
private String email; 

public StaffMember(){
}

public StaffMember(int sID, String sname, String fname, String loc, String phon, String mail){
	StaffID = sID;
	surname = sname;
	forename = fname;
	location = loc;
	email = mail;
	phone = phon;
}

public int getStaffID() {
	return StaffID;
}
@XmlElement
public void setStaffID(int staffID) {
	StaffID = staffID;
}

public String getSurname() {
	return surname;
}
@XmlElement
public void setSurname(String surname) {
	this.surname = surname;
}

public String getForename() {
	return forename;
}
@XmlElement
public void setForename(String forename) {
	this.forename = forename;
}

public String getLocation() {
	return location;
}
@XmlElement
public void setLocation(String location) {
	this.location = location;
}

public String getPhone() {
	return phone;
}
@XmlElement
public void setPhone(String phone) {
	this.phone = phone;
}

public String getEmail() {
	return email;
}
@XmlElement
public void setEmail(String email) {
	this.email = email;
}



}

