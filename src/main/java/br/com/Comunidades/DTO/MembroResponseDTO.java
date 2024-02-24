package br.com.Comunidades.DTO;


public class MembroResponseDTO {

	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public MembroResponseDTO(String nome) {
		super();
		this.nome = nome;
	}

	public MembroResponseDTO() {
		super();
	}
	
}
