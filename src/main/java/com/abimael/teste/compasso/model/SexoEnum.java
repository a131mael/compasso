package com.abimael.teste.compasso.model;

	public enum SexoEnum {

	MASCULINO("Masculino"), 
	FEMININO("Feminino"),
	NAO_INFORMADO("Não Informado");
	
	private String sexo;
	
	SexoEnum(String sexo){
		this.sexo = sexo;
	}
	
	public String getSexo() {
		return sexo;
	}
}
