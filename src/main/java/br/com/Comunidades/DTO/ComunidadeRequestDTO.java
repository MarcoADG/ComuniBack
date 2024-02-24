package br.com.Comunidades.DTO;

public class ComunidadeRequestDTO {

	private String tema;

	private String lider;

	private String imagem;

	private Boolean estado;

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getLider() {
		return lider;
	}

	public void setLider(String lider) {
		this.lider = lider;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public ComunidadeRequestDTO(String tema, String lider, String imagem, Boolean estado) {
		super();
		this.tema = tema;
		this.lider = lider;
		this.imagem = imagem;
		this.estado = estado;
	}

	public ComunidadeRequestDTO() {
		super();
	}
	
}
