package br.com.api.SistemaSkillAPI.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.SistemaSkillAPI.dto.UsuarioRequisicaoDTO;
import br.com.api.SistemaSkillAPI.dto.UsuarioRespostaDTO;
import br.com.api.SistemaSkillAPI.entities.Usuario;
import br.com.api.SistemaSkillAPI.entities.UsuarioSkill;
import br.com.api.SistemaSkillAPI.repositories.UsuarioRepository;
import br.com.api.SistemaSkillAPI.repositories.UsuarioSkillRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	SkillService skillService;
	@Autowired
	UsuarioSkillRepository usuarioSkillRepository;

	public Usuario parseDeUsuarioRequisicao(UsuarioRequisicaoDTO obj) {
		Usuario usuarioNova = new Usuario();

		usuarioNova.setEmail(obj.getEmail());
		usuarioNova.setPassword(obj.getPassword());

		return usuarioNova;
	}

	public UsuarioRespostaDTO parseDeUsuarioResposta(Usuario obj) {
		UsuarioRespostaDTO usuarioNova = new UsuarioRespostaDTO();
		usuarioNova.setEmail(obj.getEmail());
		return usuarioNova;
	}

	public Usuario findByEmail(String email) {
		return usuarioRepository.findByEmail(email).get();
	}

	public Integer getCount() {
		return usuarioRepository.contar();
	}

	public UsuarioRespostaDTO acharId(Integer id) {
		UsuarioRespostaDTO UsuarioResposta = parseDeUsuarioResposta(usuarioRepository.findById(id).get());
		return UsuarioResposta;
	}

	public List<UsuarioRespostaDTO> listar() {
		List<UsuarioRespostaDTO> usuarioResposta = new ArrayList<>();
		List<Usuario> usuarios = usuarioRepository.findAll();

		for (Usuario usuario : usuarios) {
			usuarioResposta.add(parseDeUsuarioResposta(usuario));
		}
		return usuarioResposta;
	}

	public List<UsuarioSkill> listaSkill(Integer id) {

//		List<UsuarioSkill> list = usuarioSkillRepository.findByusuario(id).map(List::of)
//				.orElseGet(Collections::emptyList);

		return usuarioSkillRepository.findByusuario(id);
	}

}