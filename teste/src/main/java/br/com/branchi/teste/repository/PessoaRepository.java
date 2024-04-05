package br.com.branchi.teste.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.branchi.teste.model.pessoa.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

	@Query(value = "SELECT * FROM pessoa p WHERE p.id = ?1", nativeQuery = true)
	Optional<Pessoa> buscaPorId(Long id);
		
	@Query(value = "SELECT p FROM Pessoa p WHERE LOWER(p.cpf) = LOWER(?1)")
	Optional<Pessoa> buscaPorCpf(String cpf);
	
	@Query(value = "SELECT p FROM Pessoa p WHERE p.gerente = true")
	List<Pessoa> buscaGerentes();
	
	@Query(value = "SELECT p FROM Pessoa p WHERE p.funcionario = true")
	List<Pessoa> buscaFuncionarios();
}
