package com.doc.concept.server.user.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequest {
	private String login;
	private String password;
	private String name;
	private String surname;
	private String phone;
	private String email;
	private Set<String> role;
	
}
