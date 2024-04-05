package br.com.branchi.teste.model.projeto;

import java.time.LocalDate;
import java.util.List;

import br.com.branchi.teste.model.enums.Risco;
import br.com.branchi.teste.model.enums.Status;
import br.com.branchi.teste.model.pessoa.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjetoDTO {

	private String nome;
	private String descricao;
	private LocalDate dataInicio;
	private LocalDate dataPrevisaoFim;
	private LocalDate dataFim;	
	private Float orcamento;
	private Status status;
	private Risco risco;
	private Pessoa gerente;
	private List<Pessoa> membros;
	
	public ProjetoDTO(Projeto projeto) {
		super();
		this.nome = projeto.getNome();
		this.descricao = projeto.getDescricao();
		this.dataInicio = projeto.getDataInicio();
		this.dataPrevisaoFim = projeto.getDataPrevisaoFim();
		this.dataFim = projeto.getDataFim();
		this.orcamento = projeto.getOrcamento();
		this.status = projeto.getStatus();
		this.risco = projeto.getRisco();
		this.gerente = projeto.getGerente();
		this.membros = projeto.getMembros();
	}
	
	
	
}
