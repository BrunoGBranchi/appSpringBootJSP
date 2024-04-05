package br.com.branchi.teste.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.branchi.teste.model.projeto.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Long>{


	@Query(value = "SELECT * FROM projeto p WHERE p.id = ?1", nativeQuery = true)
	Optional<Projeto> buscaPorId(Long id);
		
	@Query(value = "SELECT p FROM Projeto p WHERE LOWER(p.nome) = LOWER(?1)")
	Optional<Projeto> buscaPorNome(String nome);
	
}
