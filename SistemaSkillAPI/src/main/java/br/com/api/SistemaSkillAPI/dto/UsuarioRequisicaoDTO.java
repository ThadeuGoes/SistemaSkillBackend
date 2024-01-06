package br.com.api.SistemaSkillAPI.dto;

import java.util.List;

import br.com.api.SistemaSkillAPI.entities.UsuarioSkill;

public class UsuarioRequisicaoDTO {

	private String email;
	private String password;

	public UsuarioRequisicaoDTO() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}