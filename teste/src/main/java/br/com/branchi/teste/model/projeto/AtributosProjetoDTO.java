package br.com.branchi.teste.model.projeto;

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
public class AtributosProjetoDTO {
	
	List<Status> statusList;
	List<Risco> riscosList;
	List<Pessoa> membrosList;
	List<Pessoa> gerentesList;

}
