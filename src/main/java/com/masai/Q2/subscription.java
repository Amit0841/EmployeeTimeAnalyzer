package com.masai.Q2;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "findall", query = "select e from subscription e where start_date between :D1 and :D2 ")
})

@NamedNativeQuery(name = "findByName" ,query = "select e from subscription e where e.plan_name like :name",resultClass = subscription.class)
public class subscription {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String plan_name ;
	@Column(nullable = false)
	int number_of_channels; 
	@Column(nullable = false)
	double monthly_charges ;
	@Column(nullable = false)
	Date start_date ;
	@Column(nullable = false)
	Date end_date ;
	public subscription() {
		super();
		// TODO Auto-generated constructor stub
	}
	public subscription(String plan_name, int number_of_channels, double monthly_charges, Date date,
			Date date2) {
		super();
		this.plan_name = plan_name;
		this.number_of_channels = number_of_channels;
		this.monthly_charges = monthly_charges;
		this.start_date = date;
		this.end_date = date2;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlan_name() {
		return plan_name;
	}
	public void setPlan_name(String plan_name) {
		this.plan_name = plan_name;
	}
	public int getNumber_of_channels() {
		return number_of_channels;
	}
	public void setNumber_of_channels(int number_of_channels) {
		this.number_of_channels = number_of_channels;
	}
	public double getMonthly_charges() {
		return monthly_charges;
	}
	public void setMonthly_charges(double monthly_charges) {
		this.monthly_charges = monthly_charges;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	@Override
	public String toString() {
		return "subscription [id=" + id + ", plan_name=" + plan_name + ", number_of_channels=" + number_of_channels
				+ ", monthly_charges=" + monthly_charges + ", start_date=" + start_date + ", end_date=" + end_date
				+ "]";
	}
	
}
