package br.com.Comunidades.DTO;

public class MembroResponseDTO {

	private Integer membroId;

	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getMembroId() {
		return membroId;
	}

	public void setMembroId(Integer membroId) {
		this.membroId = membroId;
	}

	public MembroResponseDTO(Integer membroId, String nome) {
		super();
		this.membroId = membroId;
		this.nome = nome;
	}

	public MembroResponseDTO() {
		super();
	}

}
