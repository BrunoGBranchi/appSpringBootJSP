package br.com.branchi.teste.model.pessoa;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false, of = { "id" })
@Table(name = "pessoa")
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome", length = 100, nullable = false)
	private String nome;
	
	@Column(name = "datanascimento")
	private LocalDate dataNascimento;
	
	@Column(name = "cpf", length = 14, nullable = false)
	private String cpf;
	
	@Column(name = "funcionario", nullable = false, columnDefinition = "BOOLEAN DEFAULT false")
	private boolean funcionario;
	
	@Column(name = "gerente", nullable = false, columnDefinition = "BOOLEAN DEFAULT false")
	private boolean gerente;

	public Pessoa(PessoaDTO pessoaDTO) {
		super();
		this.nome = pessoaDTO.getNome();
		this.dataNascimento = pessoaDTO.getDataNascimento();
		this.cpf = pessoaDTO.getCpf();
		this.funcionario = pessoaDTO.isFuncionario();
		this.gerente = pessoaDTO.isGerente();
	}
	
	public Pessoa(Long id, PessoaDTO pessoaDTO) {
		super();
		this.id = id;
		this.nome = pessoaDTO.getNome();
		this.dataNascimento = pessoaDTO.getDataNascimento();
		this.cpf = pessoaDTO.getCpf();
		this.funcionario = pessoaDTO.isFuncionario();
		this.gerente = pessoaDTO.isGerente();
	}
	
	
	
}
