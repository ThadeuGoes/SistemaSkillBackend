package br.com.api.SistemaSkillAPI.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.api.SistemaSkillAPI.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	@Query(value = "select count(*) from usuario", nativeQuery = true)
	public Integer contar();

	@Query(value = "select * from usuario where email = :email", nativeQuery = true)
	public Optional<Usuario> findByEmail(@Param("email") String email);

}
