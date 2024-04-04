package br.com.branchi.teste.model.projeto;

import java.time.LocalDate;
import java.util.List;

import br.com.branchi.teste.model.enums.Risco;
import br.com.branchi.teste.model.enums.Status;
import br.com.branchi.teste.model.pessoa.Pessoa;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
@Table(name = "projeto")
public class Projeto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome", length = 100, nullable = false)
	private String nome;
	
	@Column(name = "descricao", length = 5000)
	private String descricao;
	
	@Column(name = "data_inicio")
	private LocalDate dataInicio;
	
	@Column(name = "data_previsao_fim")
	private LocalDate dataPrevisaoFim;
	
	@Column(name = "data_fim")
	private LocalDate dataFim;	
	
	@Column(name = "float")
	private Float orcamento;
	
	@Enumerated(EnumType.STRING)
	@Column(name="status", length = 45)
	private Status status;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "risco", length = 45)
	private Risco risco;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idgerente", foreignKey = @ForeignKey(name = "fk_gerente"))
	private Pessoa gerente;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
	    name = "membros",
	    joinColumns = @JoinColumn(name = "idprojeto", referencedColumnName = "idprojeto"),
	    inverseJoinColumns = @JoinColumn(name = "idpessoa", referencedColumnName = "idpessoa"),
	    foreignKey = @ForeignKey(name = "fk_membros_projeto"),
	    inverseForeignKey = @ForeignKey(name = "fk_membros_pessoa")
	)
	private List<Pessoa> membros;
	
}
