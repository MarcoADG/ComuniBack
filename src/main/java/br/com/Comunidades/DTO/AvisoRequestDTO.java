package br.com.Comunidades.DTO;

import java.time.LocalDateTime;

public class AvisoRequestDTO {

    private String titulo;

    private String aviso;

    private LocalDateTime dataHora;
    
    private Boolean estado;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAviso() {
		return aviso;
	}

	public void setAviso(String aviso) {
		this.aviso = aviso;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public AvisoRequestDTO(String titulo, String aviso, LocalDateTime dataHora, Boolean estado) {
		super();
		this.titulo = titulo;
		this.aviso = aviso;
		this.dataHora = dataHora;
		this.estado = estado;
	}

	public AvisoRequestDTO() {
		super();
	} 
    
}
