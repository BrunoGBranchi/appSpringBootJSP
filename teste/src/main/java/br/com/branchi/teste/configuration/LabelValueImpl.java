package br.com.branchi.teste.configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LabelValueImpl implements LabelValue {
	
	private String label;
	private String value;
	
	public LabelValueImpl(String label, Number value) {
		super();
		this.label = label;
		this.value = String.valueOf(value);
	}
	
	public LabelValueImpl(Integer label, Integer value) {
		super();
		this.label = label.toString();
		this.value = String.valueOf(value);
	}
	
}
