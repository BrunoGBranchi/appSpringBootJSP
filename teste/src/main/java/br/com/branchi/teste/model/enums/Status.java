package br.com.branchi.teste.model.enums;

import br.com.branchi.teste.configuration.LabelValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Status implements LabelValue {

	EM_ANALISE("Em análise"), ANALISE_REALIZADA("Análise realizada"), ANALISE_APROVADA("Análise aprovada"),
	INICIADO("Iniciado"), PLANEJADO("Planejado"), EM_ANDAMENTO("Em andamento"), ENCERRADO("Encerrado");

	private String label;

	@Override
	public String getValue() {
		return this.toString();
	}

}
