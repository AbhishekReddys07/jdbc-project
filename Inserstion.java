package dao;

import java.io.FileInputStream;
import java.util.Scanner;

import controller.Inserstion_details;
import dto.Mock;

public class Inserstion {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		boolean flag = true;
		while (flag) {
			System.out.println(
					"1.Add\n2.fetch upon aadhar\n3.Remove upon aadhar\n4.fetch all execpt selfie & Address\n5.Delete All\n6.Exit");
			switch (sc.nextInt()) {
			case 1: {
				Inserstion_details I = new Inserstion_details();
				System.out.println("enter the Aadhar number");
				int Aadhar = sc.nextInt();
				System.out.println("enter the name ");
				String name = sc.next();
				System.out.println(" enter Address");
				String Address = sc.next();
				Scanner sc2 = new Scanner(System.in);
				System.out.println("enter selfie path");
				FileInputStream f = new FileInputStream(sc2.nextLine());
				byte[] selfie = new byte[f.available()];
				System.out.println("enter mock rating");
				String rating = sc.next();
				System.out.println("enter secret key");
				String secret=sc.next();
				I.add(name, Aadhar,selfie,secret, Address, rating);
				
			}break;
			case 2: {
//				System.out.println("enter the id");
//				int id = sc.nextInt();
//				System.out.println("enter the new name");
//				String newName = sc.next();
//				s.update(id, newName);
				
			}break;
			case 3: {
		
			}break;
			case 4: {
				
			}break;
			case 5: {
			
			}break;
				
				
			case 6: {
				flag = false;
				System.out.println("byee byeee");
			}break;
			default: {
				System.out.println("enter valid option");
			}
				break;
			}
		}
	}
}
