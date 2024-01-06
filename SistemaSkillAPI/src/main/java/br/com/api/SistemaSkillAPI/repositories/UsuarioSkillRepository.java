package br.com.api.SistemaSkillAPI.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.api.SistemaSkillAPI.entities.UsuarioSkill;

@Repository
public interface UsuarioSkillRepository extends JpaRepository<UsuarioSkill, Integer> {

	@Query(value = "select * from usuario_skill where usuario_id = :id", nativeQuery = true)
	public List<UsuarioSkill> findByusuario(@Param("id") Integer id);

}
