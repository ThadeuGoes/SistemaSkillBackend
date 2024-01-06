package br.com.api.SistemaSkillAPI.dto;

import java.util.List;

public class UsuarioRespostaDTO {

	private Integer id;
	private String email;

	public UsuarioRespostaDTO() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}