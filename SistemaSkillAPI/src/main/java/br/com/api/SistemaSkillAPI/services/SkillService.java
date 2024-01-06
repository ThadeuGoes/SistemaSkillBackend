package br.com.api.SistemaSkillAPI.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.api.SistemaSkillAPI.dto.SkillRequisicaoDTO;
import br.com.api.SistemaSkillAPI.dto.SkillRespostaDTO;
import br.com.api.SistemaSkillAPI.entities.Skill;
import br.com.api.SistemaSkillAPI.entities.UsuarioSkill;
import br.com.api.SistemaSkillAPI.repositories.SkillRepository;
import br.com.api.SistemaSkillAPI.repositories.UsuarioRepository;
import br.com.api.SistemaSkillAPI.repositories.UsuarioSkillRepository;

@Service
public class SkillService {

	@Autowired
	SkillRepository skillRepository;
	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	UsuarioSkillRepository usuarioSkillRepository;

	public Skill parseDeSkillRequisicao(SkillRequisicaoDTO objeto) {
		Skill skillNovo = new Skill();

		skillNovo.setNome(objeto.getNome());
		skillNovo.setImagem(objeto.getImagem());
		skillNovo.setDescricao(objeto.getDescricao());

		return skillNovo;
	}

	public SkillRespostaDTO parseDeSkillResposta(Skill objeto) {
		SkillRespostaDTO skillNovo = new SkillRespostaDTO();

		skillNovo.setNome(objeto.getNome());
		skillNovo.setImagem(objeto.getImagem());
		skillNovo.setDescricao(objeto.getDescricao());
		skillNovo.setId(objeto.getId());

		return skillNovo;
	}

	public Integer getCount() {
		return skillRepository.contar();
	}

	public void salvar(SkillRequisicaoDTO objeto) {
		Skill skillNovo = parseDeSkillRequisicao(objeto);
		skillRepository.save(skillNovo);
	}

	public SkillRespostaDTO acharId(Integer id) {
		if (skillRepository.findById(id).get() == null) {

			throw new EntityNotFoundException("Esse produto não existe");
		} else {
			SkillRespostaDTO produtoResposta = parseDeSkillResposta(skillRepository.findById(id).get());
			return produtoResposta;
		}
	}

	public List<SkillRespostaDTO> listar() {
		List<SkillRespostaDTO> skillsResposta = new ArrayList<>();
		List<Skill> skills = skillRepository.findAll();
		for (Skill skill : skills) {
			skillsResposta.add(parseDeSkillResposta(skill));
		}
		return skillsResposta;
	}

	public void deletar(Integer id) {
		usuarioSkillRepository.deleteById(id);
	}

	@Transactional
	public void associar(Integer idSkill, Integer idUsuario, String nivel) {
		UsuarioSkill usuSkill = new UsuarioSkill();

		usuSkill.setNivel(nivel);
		usuSkill.setUsuarios(usuarioRepository.findById(idUsuario).get());
		usuSkill.setSkills(skillRepository.findById(idSkill).get());

		usuarioSkillRepository.save(usuSkill);
	}

	public UsuarioSkill atualizar(Integer id, String nivel) {
		UsuarioSkill skill = new UsuarioSkill();
		skill = usuarioSkillRepository.findById(id).get();
		skill.setNivel(nivel);

		return usuarioSkillRepository.save(skill);
	}

}