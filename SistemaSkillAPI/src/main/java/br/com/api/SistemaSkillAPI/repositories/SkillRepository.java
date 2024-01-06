package br.com.api.SistemaSkillAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.api.SistemaSkillAPI.entities.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer> {

	@Query(value = "select count(*) from skill ", nativeQuery = true)
	public Integer contar();

}
