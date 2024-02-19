package dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Schema {
	@Id
	int Aadhar;
	String name;
	String Address;
	byte[] selfie;
	String mock_rating;
	public int getAadhar() {
		return Aadhar;
	}
	public void setAadhar(int aadhar) {
		Aadhar = aadhar;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public byte[] getSelfie() {
		return selfie;
	}
	public void setSelfie(byte[] selfie) {
		this.selfie = selfie;
	}
	public String getMock_rating() {
		return mock_rating;
	}
	public void setMock_rating(String mock_rating) {
		this.mock_rating = mock_rating;
	}
	
	
	

}
