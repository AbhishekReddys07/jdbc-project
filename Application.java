package project;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;



public class Application {
	public static void main(String[] args) {
		EntityManagerFactory f=Persistence.createEntityManagerFactory("Project");
		EntityManager m=f.createEntityManager();
		EntityTransaction t=m.getTransaction();
		Scanner sc=new Scanner(System.in);
		System.out.println("1-->to add user values\n2-->to add bank details\n"
				+"3-->to fetch user details base on addhaar\n4-->to fetch bank details\n5-->delete user record over id"
				+ "\n6-->delete bank records over id or mob number ");
		int num=sc.nextInt();
		
		switch (num) {
		case 1:
	
			User1 u=new User1();
			System.out.println("Enter Addhaar number");
			u.setaddhaar_num(sc.nextInt());
			System.out.println("Enter State name");
			String loc=sc.next();
			u.setLocation(loc);
			System.out.println("Enter Name ");
			String name=sc.next();
			u.setName(name);
			List<User1>l=new ArrayList<User1>();
			l.add(u);
			t.begin();
			m.persist(u);
			t.commit();
			break;
			
		case 2:{	
			SBI_Bank bank=new SBI_Bank();
			System.out.println("Enter pan number");
			bank.setPan_num(sc.nextLong());
			System.out.println("Enter name");
			bank.setName(sc.next());
			System.out.println("Enter DOB year");
			bank.setDOB(sc.next());
			t.begin();
			m.persist(bank);
			t.commit();
			System.out.println("Successfully Added");	
			break;
		}

		case 3:{
			System.out.println("enter addhaar number");
			int n=sc.nextInt();
			User1 un=m.find(User1.class, n);
			//un.getAddhaar_num();
			System.out.println("NAME->"+un.getName());
			System.out.println("Addhaar number->"+un.getaddhaar_num());
		    System.out.println("Location->"+un.getLocation());
			break;	
		}
		case 4:{
			System.out.println("enter pan card number");
			Long n=sc.nextLong();
			SBI_Bank s=m.find(SBI_Bank.class, n);
			System.out.println(s.getName());
			System.out.println(s.getDOB());
			break;
		}
		case 5:{	
			System.out.println("TO DELETE->Enter Addhaar number");
			int n=sc.nextInt();
			User1 un=m.find(User1.class, n);
			t.begin();
			m.remove(un);
			t.commit();
			System.out.println("Deleted");
			
	
		break;
		}
		case 6:{
			System.out.println("TO DELETE->Enter Pan Number");
			int n=sc.nextInt();
			SBI_Bank b=m.find(SBI_Bank.class, n);
			t.begin();
			m.remove(b);
			t.commit();
			System.out.println(n+"\tPan number record delete from bank account");
			
			
			break;
			
		}
		
		default:
			System.out.println("Give proper input");
			break;
		}
		
	


		
		
		

	
	System.out.println("Results");
		sc.close();
	}
}
