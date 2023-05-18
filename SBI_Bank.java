package project;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class SBI_Bank {
@Id@Column(length=10,nullable=true)
private long pan_num;
@Column(length=25,nullable=true)
private String name;	
	@Column(nullable=true)
	private String DOB;
	
	
	@OneToMany
    List<User1>user1s;


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}





	public long getPan_num() {
		return pan_num;
	}


	public void setPan_num(long pan_num) {
		this.pan_num = pan_num;
	}


	public List<User1> getUser1s() {
		return user1s;
	}


	public void setUser1s(List<User1> user1s) {
		this.user1s = user1s;
	}


	public String getDOB() {
		return DOB;
	}


	public void setDOB(String dOB) {
		DOB = dOB;
	}



	
	
}
