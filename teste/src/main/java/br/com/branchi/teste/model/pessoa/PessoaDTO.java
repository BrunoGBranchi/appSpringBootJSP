package br.com.branchi.teste.model.pessoa;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDTO {

	private String nome;
	private LocalDate dataNascimento;
	private String cpf;
	private String cargo;
	private boolean funcionario;
	private boolean gerente;
	
	public PessoaDTO(Pessoa pessoa) {
		super();
		this.nome = pessoa.getNome();
		this.dataNascimento = pessoa.getDataNascimento();
		this.cpf = pessoa.getCpf();
		this.cargo = pessoa.getCargo();
		this.funcionario = pessoa.isFuncionario();
		this.gerente = pessoa.isGerente();
	}
}
