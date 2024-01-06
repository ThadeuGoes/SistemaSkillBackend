package br.com.api.SistemaSkillAPI.controllers;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.SistemaSkillAPI.config.JWTUtil;
import br.com.api.SistemaSkillAPI.dto.LoginDTO;
import br.com.api.SistemaSkillAPI.dto.LoginRespostaDTO;
import br.com.api.SistemaSkillAPI.entities.Usuario;
import br.com.api.SistemaSkillAPI.entities.UsuarioSkill;
import br.com.api.SistemaSkillAPI.repositories.UsuarioRepository;
import br.com.api.SistemaSkillAPI.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	@Autowired
	private JWTUtil jwtUtil;
	@Autowired
	private AuthenticationManager authManager;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	UsuarioRepository usuarioRepository;

	@GetMapping("/listaSkill/{id}")
	public List<UsuarioSkill> listaSkill(@PathVariable Integer id) {
		System.out.println("algo");
		System.out.println(id);
		return usuarioService.listaSkill(id);
	}

	@SuppressWarnings("unused")
	@PostMapping("/cadastro")
	public Usuario cadastro(@RequestBody LoginDTO usuario) {

		Usuario usuarioResumido = new Usuario();
		usuarioResumido.setEmail(usuario.getEmail());

		String encodedPass = passwordEncoder.encode(usuario.getPassword());
		usuarioResumido.setPassword(encodedPass);
		usuarioRepository.save(usuarioResumido);

		return usuarioRepository.save(usuarioResumido);
	}

	@PostMapping("/login")
	public LoginRespostaDTO login(@RequestBody LoginDTO body) {

//		try {
		UsernamePasswordAuthenticationToken authInputToken = new UsernamePasswordAuthenticationToken(body.getEmail(),
				body.getPassword());
		authManager.authenticate(authInputToken);

		Usuario usuario = usuarioService.findByEmail(body.getEmail());
		Usuario usuarioResumido = new Usuario();
		usuarioResumido.setEmail(usuario.getEmail());
		usuarioResumido.setId(usuario.getId());
		String token = jwtUtil.generateTokenWithUsuarioData(usuarioResumido);

		token = "Bearer " + token;

		LoginRespostaDTO usuLog = new LoginRespostaDTO();
		usuLog.setId(usuario.getId());
		usuLog.setLogin(usuario.getEmail());
		usuLog.setToken(Collections.singletonMap("jwtToken", token));

		return usuLog;
//		} catch (AuthenticationException authExc) {
//			throw new RuntimeException("Credenciais Invalidas");
//		}
	}
}
