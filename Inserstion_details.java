package controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JFileChooser;

import dao.AES;
import dao.Inserstion;
import dto.Mock;
//package dao;
public class Inserstion_details {




	

	public class curd {
		EntityManagerFactory e = Persistence.createEntityManagerFactory("dev");
		EntityManager m = e.createEntityManager();
		EntityTransaction t = m.getTransaction();
		Scanner sc = new Scanner(System.in);
		
		public void add(String name, int aadhar, byte[] selfie, String secret, String address, String rating) {
			Mock i =new Mock();
			i.setName(name);
			i.setAadhar(aadhar);
			i.setAddress(AES.encrypt(address, secret));
			i.setSelfie(selfie);
			i.setMock_rating(rating);
			
			t.begin();
			m.persist(i);
			t.commit();
			
			
		}
		
		public void fetch(long aadhar) throws Exception{
			Mock d = m.find(details.class,aadhar);
			System.out.println(d.getName());
			System.out.println(d.getAddress());
			FileOutputStream f = new FileOutputStream(sc.nextLine());
			f.write(d.getSelfie());
			System.out.println(d.getRating());
		}
		
		public void rename(long aadhar,String newname){
			details d = m.find(details.class,aadhar);
			d.setName(newname);
		}
		
		public void fetchall(){
			Query q = m.createQuery("select a from JEHA9 a");
			java.util.List<details> l = q.getResultList();
			for(details d:l){
				System.out.println(d.getAadhar());
				System.out.println(d.getName());
				System.out.println(d.getRating());
			}
		}
		
		public void delete(long aadhar){
			details d = m.find(details.class,aadhar);
			t.begin();
			m.remove(d);
			t.commit();
		}

	}


	

}
