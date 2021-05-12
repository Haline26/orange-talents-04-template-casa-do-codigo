package br.com.zupacademy.halinecosta.casadocodigo;

public class ValidationErrorOutputDto {

	private String campo;
	private String erro;
	
	public ValidationErrorOutputDto(String campo, String erro) {
		super();
		this.campo = campo;
		this.erro = erro;
	}

	public String getCampo() {
		return campo;
	}
	public String getErro() {
		return erro;
	}
}
