package br.com.Comunidades.DTO;

public class RegraResponseDTO {

	private Integer regraId;

	private String regra;

	public Integer getRegraId() {
		return regraId;
	}

	public void setRegraId(Integer regraId) {
		this.regraId = regraId;
	}

	public String getRegra() {
		return regra;
	}

	public void setRegra(String regra) {
		this.regra = regra;
	}

	public RegraResponseDTO(Integer regraId, String regra) {
		super();
		this.regraId = regraId;
		this.regra = regra;
	}

	public RegraResponseDTO() {
		super();
	}

}
