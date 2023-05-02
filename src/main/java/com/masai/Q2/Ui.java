package com.masai.Q2;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;



import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.*;

public class Ui {
	static EntityManagerFactory emf;
	static {
		emf=Persistence.createEntityManagerFactory("OTT_connect");
	}
	
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter");
	int c=sc.nextInt();
	
	switch(c) {
	case 1:
		saveSubscription(sc);
		break;
	case 2:
		print(sc);
		break;
	case 3:
		findDetailsByDate(sc);
	case 4:
		findByName(sc);
		break;
	case 5:
		updateFilds(sc);
	    break;
	case 6:
		delete(sc);
		break;
	}
}

private static void delete(Scanner sc) {
	EntityManager em= emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	System.out.println("Enter ID");
	int id=sc.nextInt();
	subscription se= em.find(subscription.class, id);
	if(se == null) {
		System.out.println("'Invalid Subscription id'");
	}else{
		et.begin();
		em.remove(se);
		et.commit();
	}
	
	em.close();
	
}
private static void updateFilds(Scanner sc) {
	EntityManager em= emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	System.out.println("Enter ID");
	int id=sc.nextInt();
	subscription se= em.find(subscription.class, id);
	if(se == null) {
		System.out.println("'Invalid Subscription id'");
	}else{
		et.begin();
		se.setPlan_name("Silver24");
		se.setNumber_of_channels(375);
		em.merge(se);
		et.commit();
	}
	em.close();
}

private static void findByName(Scanner sc) {
	EntityManager em= emf.createEntityManager();
	System.out.println("Enater name");
	String name=sc.next();
	Query que=em.createNamedQuery("findByName");
	que.setParameter("name", name);
	List <subscription> re = que.getResultList();
	re.forEach(System.out::println);
	em.close();
}

private static void findDetailsByDate(Scanner sc) {
	EntityManager em= emf.createEntityManager();
	System.out.println("Enter 1st Date");
	Date date=Date.valueOf(sc.next()) ;
	System.out.println("Enter 2nd Date");
	Date date1=Date.valueOf(sc.next()) ;
	
	Query que=em.createNamedQuery("findall");
	que.setParameter("D1", date);
	que.setParameter("D2", date1);
	
	List <subscription> re=que.getResultList();
	re.forEach(System.out::println);
	em.close();
}	

private static void print(Scanner sc) {
	EntityManager em= emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	System.out.println("Enter ID");
	int id=sc.nextInt();
	subscription se= em.find(subscription.class, id);
	if(se == null) {
		System.out.println("'Invalid Subscription id'");
	}else{
		System.out.println(se);
	}
	em.close();
}
private static void saveSubscription(Scanner sc) {
	EntityManager em= emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	System.out.println("Enter 1st Date");
	Date date=Date.valueOf(sc.next()) ;
	System.out.println("Enter 2nd Date");
	Date date1=Date.valueOf(sc.next()) ;
	subscription s=new subscription( "Gold32",  299,  525.00,  date, date1);
	
	et.begin();
	em.persist(s);
	et.commit();
	em.close();
  }
}
