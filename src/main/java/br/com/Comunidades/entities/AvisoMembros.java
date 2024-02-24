package br.com.Comunidades.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "avisos_membros")
public class AvisoMembros {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "avisosMembroId")
    private Integer avisosMembroId;
	
	@NotNull
	@Column(name = "estado")
	private Boolean estado;
	
	@ManyToOne
	@JoinColumn (name = "idMembro", referencedColumnName = "membroId")
	private Membro membro;
	
	@ManyToOne
	@JoinColumn (name = "idComunidade", referencedColumnName = "comunidadeId")
	private Comunidade comunidade;
	
	@ManyToOne
	@JoinColumn (name = "idAviso", referencedColumnName = "avisoId")
	private Aviso aviso;

	public Integer getAvisosMembroId() {
		return avisosMembroId;
	}

	public void setAvisosMembroId(Integer avisosMembroId) {
		this.avisosMembroId = avisosMembroId;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Membro getMembro() {
		return membro;
	}

	public void setMembro(Membro membro) {
		this.membro = membro;
	}

	public Comunidade getComunidade() {
		return comunidade;
	}

	public void setComunidade(Comunidade comunidade) {
		this.comunidade = comunidade;
	}

	public Aviso getAviso() {
		return aviso;
	}

	public void setAviso(Aviso aviso) {
		this.aviso = aviso;
	}

	public AvisoMembros(Integer avisosMembroId, @NotNull Boolean estado, Membro membro, Comunidade comunidade,
			Aviso aviso) {
		super();
		this.avisosMembroId = avisosMembroId;
		this.estado = estado;
		this.membro = membro;
		this.comunidade = comunidade;
		this.aviso = aviso;
	}

	public AvisoMembros() {
		super();
	}	
	
}
