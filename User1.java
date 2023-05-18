package project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class User1 {
@Id@Column(length=12)
  private int addhaar_num;
@Column(nullable=true)
private String name;
@Column(nullable=true)
private String location;


public long getaddhaar_num() {
	return addhaar_num;
}

public void setaddhaar_num(int num) {
	this.addhaar_num = num;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getLocation() {
	return location;
}

public void setLocation(String location) {
	this.location = location;
}







}
