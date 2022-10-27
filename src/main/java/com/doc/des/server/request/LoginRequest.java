package com.doc.des.server.request;

public class LoginRequest {
	private String login;
	private String password;
	
	public LoginRequest() {}
	
	
	public LoginRequest(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getLogin(){
		return this.login;
	}
	
	
}
