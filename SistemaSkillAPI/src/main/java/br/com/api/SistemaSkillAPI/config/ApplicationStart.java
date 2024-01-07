package br.com.api.SistemaSkillAPI.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.api.SistemaSkillAPI.controllers.UsuarioController;
import br.com.api.SistemaSkillAPI.dto.LoginDTO;
import br.com.api.SistemaSkillAPI.dto.SkillRequisicaoDTO;
import br.com.api.SistemaSkillAPI.repositories.SkillRepository;
import br.com.api.SistemaSkillAPI.services.SkillService;
import br.com.api.SistemaSkillAPI.services.UsuarioService;

@Component
public class ApplicationStart {

	@Autowired
	private SkillRepository skillRepository;
	@Autowired
	private SkillService skillService;
	@Autowired
	private UsuarioController usuarioController;

	@PostConstruct
	public void carregarDadosIniciais() {
		if (skillRepository.count() == 0) {
			SkillRequisicaoDTO novoSkill = new SkillRequisicaoDTO();
			
			novoSkill.setNome("Java");
			novoSkill.setImagem("https://cdn.icon-icons.com/icons2/2415/PNG/512/java_original_wordmark_logo_icon_146459.png");
			novoSkill.setDescricao("Reconhecida por versatilidade em backend ");
			skillService.salvar(novoSkill);
			
			novoSkill.setNome("CSS");
			novoSkill.setImagem("https://i.imgur.com/tx62vrb.png");
			novoSkill.setDescricao("Estilização de programas e web");
			skillService.salvar(novoSkill);
			
			novoSkill.setNome("Python");
			novoSkill.setImagem("https://upload.wikimedia.org/wikipedia/commons/thumb/c/c3/Python-logo-notext.svg/800px-Python-logo-notext.svg.png");
			novoSkill.setDescricao("Machine Learning, Big Data e Automação");
			skillService.salvar(novoSkill);
			
			novoSkill.setNome("C#");
			novoSkill.setImagem("https://growiz.com.br/wp-content/uploads/2020/08/kisspng-c-programming-language-logo-microsoft-visual-stud-atlas-portfolio-5b899192d7c600.1628571115357423548838.png");
			novoSkill.setDescricao("Tipagem forte e alto desempenho");
			skillService.salvar(novoSkill);
			
			novoSkill.setNome("HTML");
			novoSkill.setImagem("https://i.imgur.com/LdoaMos.png");
			novoSkill.setDescricao("Linguagem de marcação muito utilizada em web");
			skillService.salvar(novoSkill);
			
			novoSkill.setNome("PHP");
			novoSkill.setImagem("https://upload.wikimedia.org/wikipedia/commons/thumb/2/27/PHP-logo.svg/2560px-PHP-logo.svg.png");
			novoSkill.setDescricao("Criação de sites dinâmicos e extensões para apps");
			skillService.salvar(novoSkill);
			
			novoSkill.setNome("MySQL");
			novoSkill.setImagem("https://i.imgur.com/HsA8Qxr.png");
			novoSkill.setDescricao("Criação e gerência de bancos de dados");
			skillService.salvar(novoSkill);
			
			LoginDTO log = new LoginDTO();
			
			log.setEmail("th@gmail.com");
			log.setPassword("1234");

			usuarioController.cadastro(log);
		}
	}

}
