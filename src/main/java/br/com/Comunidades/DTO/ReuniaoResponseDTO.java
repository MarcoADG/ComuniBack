package br.com.Comunidades.DTO;

import java.time.LocalDateTime;

public class ReuniaoResponseDTO {
	
	private Integer reuniaoId;

    private LocalDateTime dataHora;

    private String tema;

    private String imagem;

    private String responsavel;

    private String descricao;

    private String material;

    private String gravacao;

    private String resumo;

    private Boolean estado;

	public Integer getReuniaoId() {
		return reuniaoId;
	}

	public void setReuniaoId(Integer reuniaoId) {
		this.reuniaoId = reuniaoId;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getGravacao() {
		return gravacao;
	}

	public void setGravacao(String gravacao) {
		this.gravacao = gravacao;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public ReuniaoResponseDTO(Integer reuniaoId, LocalDateTime dataHora, String tema, String imagem, String responsavel,
			String descricao, String material, String gravacao, String resumo, Boolean estado) {
		super();
		this.reuniaoId = reuniaoId;
		this.dataHora = dataHora;
		this.tema = tema;
		this.imagem = imagem;
		this.responsavel = responsavel;
		this.descricao = descricao;
		this.material = material;
		this.gravacao = gravacao;
		this.resumo = resumo;
		this.estado = estado;
	}

	public ReuniaoResponseDTO() {
		super();
	}
    
}
