package br.com.api.SistemaSkillAPI.dto;

import java.util.Map;

public class LoginRespostaDTO {
	
	private String login;
	private Integer id;
	private Map<String, Object> token;
	
	public LoginRespostaDTO() {
		super();
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Map<String, Object> getToken() {
		return token;
	}

	public void setToken(Map<String, Object> token) {
		this.token = token;
	}
	
	
}
