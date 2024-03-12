package br.com.Comunidades.DTO;

import java.time.LocalDateTime;

public class ComentarioResponseDTO {

	private Integer comentarioId;

	private String comentario;

	private LocalDateTime dataHora;

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public Integer getComentarioId() {
		return comentarioId;
	}

	public void setComentarioId(Integer comentarioId) {
		this.comentarioId = comentarioId;
	}

	public ComentarioResponseDTO(Integer comentarioId, String comentario, LocalDateTime dataHora) {
		super();
		this.comentarioId = comentarioId;
		this.comentario = comentario;
		this.dataHora = dataHora;
	}

	public ComentarioResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
