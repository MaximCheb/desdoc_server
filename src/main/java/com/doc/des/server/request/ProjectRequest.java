package com.doc.des.server.request;

public class ProjectRequest {
	private String login;
	private String password;
	private Long projectId;
	private Long idUser;
	
	public ProjectRequest() {}
	
	
	public ProjectRequest(String login, String password) {
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


    public Long getProjectId() {
        return projectId;
    }


    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }


    public Long getIdUser() {
        return idUser;
    }


    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
	
	
}
