package br.com.Comunidades.entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "avisos")
public class Aviso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "aviso_id")
	private Integer avisoId;

	@NotNull
	@Column(name = "titulo")
	private String titulo;

	@NotNull
	@Column(name = "aviso")
	private String aviso;

	@NotNull
	@Column(name = "data_hora")
	private LocalDateTime dataHora;

	@Column(name = "estado")
	private Boolean estado;

	@OneToMany(mappedBy = "aviso")
	private List<AvisoMembros> avisoMembros;

	public Integer getAvisoId() {
		return avisoId;
	}

	public void setAvisoId(Integer avisoId) {
		this.avisoId = avisoId;
	}

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

	public List<AvisoMembros> getAvisoMembros() {
		return avisoMembros;
	}

	public void setAvisoMembros(List<AvisoMembros> avisoMembros) {
		this.avisoMembros = avisoMembros;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Aviso(Integer avisoId, @NotNull String titulo, @NotNull String aviso, @NotNull LocalDateTime dataHora,
			Boolean estado, List<AvisoMembros> avisoMembros) {
		super();
		this.avisoId = avisoId;
		this.titulo = titulo;
		this.aviso = aviso;
		this.dataHora = dataHora;
		this.estado = estado;
		this.avisoMembros = avisoMembros;
	}

	public Aviso() {
		super();
		// TODO Auto-generated constructor stub
	}

}
