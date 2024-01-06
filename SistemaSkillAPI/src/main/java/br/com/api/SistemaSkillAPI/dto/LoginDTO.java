package br.com.api.SistemaSkillAPI.dto;

public class LoginDTO {

	private String login;
	private String password;
	
	public LoginDTO() {
		super();
	}

	public LoginDTO(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	public String getEmail() {
		return login;
	}

	public void setEmail(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}