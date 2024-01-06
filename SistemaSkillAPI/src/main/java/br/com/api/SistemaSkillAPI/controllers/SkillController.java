package br.com.api.SistemaSkillAPI.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.SistemaSkillAPI.dto.SkillRequisicaoDTO;
import br.com.api.SistemaSkillAPI.dto.SkillRespostaDTO;
import br.com.api.SistemaSkillAPI.entities.UsuarioSkill;
import br.com.api.SistemaSkillAPI.services.SkillService;

@RestController
@RequestMapping("/skill")
public class SkillController {

	@Autowired
	SkillService skillService;

	@PostMapping("/salvar")
	public void salvar(@RequestBody SkillRequisicaoDTO objetoProduto) {
		skillService.salvar(objetoProduto);
	}

	@PostMapping("/associar")
	public void associar(@RequestParam Integer idSkill, @RequestParam Integer idUsuario, @RequestParam String nivel) {
		skillService.associar(idSkill, idUsuario, nivel);
	}

	@GetMapping("/{id}")
	public SkillRespostaDTO acharId(@PathVariable Integer id) {
		return skillService.acharId(id);
	}

	@GetMapping("/listar")
	public List<SkillRespostaDTO> listar() {
		return skillService.listar();
	}

	@DeleteMapping("/deletar/{id}")
	public void deletar(@PathVariable Integer id) {
		skillService.deletar(id);
	}

	@PatchMapping("/atualizar/{id}")
	public UsuarioSkill atualizar(@PathVariable Integer id, @RequestParam String nivel) {
		System.out.println("controler");
		return skillService.atualizar(id, nivel);
	}

}
