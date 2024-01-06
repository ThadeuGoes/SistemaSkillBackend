package br.com.api.SistemaSkillAPI.dto;

import java.util.List;

import br.com.api.SistemaSkillAPI.entities.UsuarioSkill;

public class SkillRespostaDTO {

	private Integer id;
	private String nome;
	private String imagem;
	private String descricao;

	public SkillRespostaDTO() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}