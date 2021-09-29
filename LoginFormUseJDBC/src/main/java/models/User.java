package models;

public class User {
	private String username;
	private String password;
	private int role;
	public User() {
		super();
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public int getRole() {
		return role;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setRole(int role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Username:"+getUsername()+"|Password:"+getPassword()+"|Role:"+getRole();
	}
}
