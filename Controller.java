package unidirection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Controller {
	
	public static void main(String[] args) {
		EntityManagerFactory e=Persistence.createEntityManagerFactory("dev");
		EntityManager m=e.createEntityManager();
		EntityTransaction t=m.getTransaction();
		
		
		Pan_card p=new Pan_card();
		p.setId(12345);
		p.setName("abhi");
		p.setAddress("bang");
	    p.setPh_no(1234567891l);
	    
	    Person per=new Person();
	    per.setId(1);
	    per.setName("abhi");
	    per.setAddress("bang");
	    per.setDob("14/09/2000");
	    
	    p.setPer(per);
	    t.begin();
	    m.persist(p);
	    m.persist(per);
	    t.commit();
	    
	    System.out.println("details inserted");
	    
	    
	}
}
