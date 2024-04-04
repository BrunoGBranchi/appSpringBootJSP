package br.com.branchi.teste.model.enums;

import br.com.branchi.teste.configuration.LabelValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Risco implements LabelValue {

	BAIXO("Baixo risco"), MEDIO("Médio risco"), ALTO("Alto risco");
	
	private String label;

	@Override
	public String getValue() {
		return this.toString();
	}
	
}
