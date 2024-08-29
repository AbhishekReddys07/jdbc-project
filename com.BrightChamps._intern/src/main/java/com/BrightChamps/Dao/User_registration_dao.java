package com.BrightChamps.Dao;

import java.security.AlgorithmConstraints;

import javax.crypto.SecretKey;

import com.BrightChamps.RegistrationTable.RegistartionTable;
import com.BrightChamps.Utils.AESUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class User_registration_dao {

	public void saveToDatabase(String username, String email, String password) {
		EntityManagerFactory emf = null;
	    EntityManager em = null;
	    EntityTransaction transaction = null;

	    // Example key (in practice, store and retrieve this securely)
	    SecretKey key = null;
	    try {
	        key = AESUtils.generateKey();
	    } catch (Exception e) {
	        e.printStackTrace();
	        return;
	    }

	    try {
	        emf = Persistence.createEntityManagerFactory("d");
	        em = emf.createEntityManager();
	        transaction = em.getTransaction();

	        // Encrypt the password before saving
	        String encryptedPassword = AESUtils.encrypt(password, key);

	        // Create an instance of RegistartionTable
	        RegistartionTable table = new RegistartionTable();
	        table.setEmail(email);
	        table.setName(username);
	        table.setPassword(encryptedPassword);

	        // Begin transaction
	        transaction.begin();

	        // Persist the entity
	        em.persist(table);

	        // Commit the transaction
	        transaction.commit();

	        System.out.println("Data saved successfully!");
	    } catch (Exception e) {
	        if (transaction != null && transaction.isActive()) {
	            // Rollback the transaction if something goes wrong
	            transaction.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        if (em != null) {
	            em.close();
	        }
	        if (emf != null) {
	            emf.close();
	        }
	    }
	}

	public String checkUserCredentials(String email, String password) {
	    EntityManagerFactory emf = null;
	    EntityManager em = null;

	    SecretKey key = null;
	    try {
	        emf = Persistence.createEntityManagerFactory("d");
	        em = emf.createEntityManager();

	        // Fetch the user's encrypted password from the database
	        String query = "SELECT u FROM RegistartionTable u WHERE u.email = :email";
	        TypedQuery<RegistartionTable> typedQuery = em.createQuery(query, RegistartionTable.class);
	        typedQuery.setParameter("email", email);

	        // Execute the query and get a single result
	        RegistartionTable result = typedQuery.getResultStream().findFirst().orElse(null);

	        if (result != null) {
	            // Get the encrypted password from the result
	            String encryptedPassword = result.getPassword();

	            // Retrieve the key from environment variables
	            key = AESUtils.getKeyFromEnv();

	            // Decrypt the password using the key
	            String decryptedPassword = AESUtils.decrypt(encryptedPassword, key);

	            // Compare the decrypted password with the input password
	            if (decryptedPassword.equals(password)) {
	                System.out.println("Data present for email: " + email);
	                return email;
	            } else {
	                System.out.println("Incorrect password for the provided email.");
	            }
	        } else {
	            System.out.println("No data found for the provided email.");
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (em != null) {
	            em.close();
	        }
	        if (emf != null) {
	            emf.close();
	        }
	    }
	    return null;
	}

}
