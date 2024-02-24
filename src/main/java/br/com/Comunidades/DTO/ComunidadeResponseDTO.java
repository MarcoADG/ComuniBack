package br.com.Comunidades.DTO;


public class ComunidadeResponseDTO {
	
	private Integer comunidadeId;

	private String tema;

	private String lider;

	private String imagem;

	private Boolean estado;

	public Integer getComunidadeId() {
		return comunidadeId;
	}

	public void setComunidadeId(Integer comunidadeId) {
		this.comunidadeId = comunidadeId;
	}

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

	public ComunidadeResponseDTO(Integer comunidadeId, String tema, String lider, String imagem, Boolean estado) {
		super();
		this.comunidadeId = comunidadeId;
		this.tema = tema;
		this.lider = lider;
		this.imagem = imagem;
		this.estado = estado;
	}

	public ComunidadeResponseDTO() {
		super();
	}
	
}
