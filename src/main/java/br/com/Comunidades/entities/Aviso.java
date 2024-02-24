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
	@Column(name = "avisoId")
	private Integer avisoId;

	@NotNull
	@Column(name = "titulo")
	private String titulo;

	@NotNull
	@Column(name = "aviso")
	private String aviso;

	@NotNull
	@Column(name = "dataHora")
	private LocalDateTime dataHora;

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

	public Aviso(Integer avisoId, @NotNull String titulo, @NotNull String aviso, @NotNull LocalDateTime dataHora,
			List<AvisoMembros> avisoMembros) {
		super();
		this.avisoId = avisoId;
		this.titulo = titulo;
		this.aviso = aviso;
		this.dataHora = dataHora;
		this.avisoMembros = avisoMembros;
	}

	public Aviso() {
		super();
	}

}
