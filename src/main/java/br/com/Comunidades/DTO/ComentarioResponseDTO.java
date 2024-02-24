package br.com.Comunidades.DTO;

import java.time.LocalDateTime;

public class ComentarioResponseDTO {

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

	public ComentarioResponseDTO(String comentario, LocalDateTime dataHora) {
		super();
		this.comentario = comentario;
		this.dataHora = dataHora;
	}

	public ComentarioResponseDTO() {
		super();
	}
    
}
