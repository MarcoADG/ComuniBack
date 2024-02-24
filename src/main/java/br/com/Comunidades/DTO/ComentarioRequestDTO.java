package br.com.Comunidades.DTO;

import java.time.LocalDateTime;

public class ComentarioRequestDTO {
	
	private Integer avisoId;

	private String comentario;

    private LocalDateTime dataHora;

	public Integer getAvisoId() {
		return avisoId;
	}

	public void setAvisoId(Integer avisoId) {
		this.avisoId = avisoId;
	}

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

	public ComentarioRequestDTO(Integer avisoId, String comentario, LocalDateTime dataHora) {
		super();
		this.avisoId = avisoId;
		this.comentario = comentario;
		this.dataHora = dataHora;
	}

	public ComentarioRequestDTO() {
		super();
	}
    
}
