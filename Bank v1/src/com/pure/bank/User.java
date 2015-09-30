package com.pure.bank;

import java.util.ArrayList;

public class User extends Asset {
	private static final ArrayList<Creation> creations;
	private static final ArrayList<FirstnameChange> firstnameChanges;
	private static final ArrayList<LastnameChange> lastnameChanges;
	private static final ArrayList<Deactivation> deactivations;
	private static final ArrayList<Reactivation> reactivations;
	private boolean activated = true;
	private String firstname;
	private String lastname;
	
	static {
		creations = new ArrayList<Creation>();
		firstnameChanges = new ArrayList<FirstnameChange>();
		lastnameChanges = new ArrayList<LastnameChange>();
		deactivations = new ArrayList<Deactivation>();
		reactivations = new ArrayList<Reactivation>();
	}
	
	public Creation[] getCreations() {
		return creations.toArray(new Creation[creations.size()]); }
	public FirstnameChange[] getFirstnameChanges() {
		return firstnameChanges.toArray(new FirstnameChange[firstnameChanges.size()]); }
	public LastnameChange[] getLastnameChanges() {
		return lastnameChanges.toArray(new LastnameChange[lastnameChanges.size()]); }
	public Deactivation[] getDeactivations() {
		return deactivations.toArray(new Deactivation[deactivations.size()]); }
	public Reactivation[] getReactivations() {
		return reactivations.toArray(new Reactivation[reactivations.size()]);
	}
	
	public boolean getStatus() { return activated; }
	public String getFirstname() { return firstname; }
	public String getLastname() { return lastname; }
	
	public User(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	public void setFirstname(String newName) {
		firstname = newName;
		firstnameChanges.add(new FirstnameChange(this));
	}
	
	public void setLastname(String newName) {
		lastname = newName;	
		lastnameChanges.add(new LastnameChange(this));
	}
	
	public final static class Creation extends Record<User> {
		public final String firstname;
		public final String lastname;
		
		public Creation(User user) {
			super(user);
			this.firstname = user.getFirstname();
			this.lastname = user.getLastname();
		}
	}
	
	public final static class FirstnameChange extends Record<User> {
		public final String newName;
		public FirstnameChange(User user) {
			super(user); newName = user.getFirstname();
		}
	}
	
	public final static class LastnameChange extends Record<User> {
		public final String newName;
		public LastnameChange(User user) {
			super(user); newName = user.getLastname();
		}
	}
	
	public final static class Deactivation extends Record<User> {
		public Deactivation(User user) { super(user); } }
	public final static class Reactivation extends Record<User> {
		public Reactivation(User user) { super(user); }
	}
}