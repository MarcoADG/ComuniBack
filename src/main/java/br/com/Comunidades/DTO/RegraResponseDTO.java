package br.com.Comunidades.DTO;


public class RegraResponseDTO {

	private String regra;

	public String getRegra() {
		return regra;
	}

	public void setRegra(String regra) {
		this.regra = regra;
	}

	public RegraResponseDTO(String regra) {
		super();
		this.regra = regra;
	}

	public RegraResponseDTO() {
		super();
	}
	
}
