package com.doc.concept.server.user.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjectRequest {
	private String login;
	private String password;
	private Long projectId;
	private Long idUser;
	
	public ProjectRequest(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

}
