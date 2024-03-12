package br.com.Comunidades.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "regras")
public class Regra {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "regra_id")
    private Integer regraId;
	
	@Column(name = "regra")
	private String regra;
	
	@ManyToOne
	@JoinColumn (name = "id_comunidade", referencedColumnName = "comunidade_id")
	private Comunidade comunidade;

	public Integer getRegraId() {
		return regraId;
	}

	public void setRegraId(Integer regraId) {
		this.regraId = regraId;
	}

	public String getRegra() {
		return regra;
	}

	public void setRegra(String regra) {
		this.regra = regra;
	}

	public Comunidade getComunidade() {
		return comunidade;
	}

	public void setComunidade(Comunidade comunidade) {
		this.comunidade = comunidade;
	}

	public Regra(Integer regraId, String regra, Comunidade comunidade) {
		super();
		this.regraId = regraId;
		this.regra = regra;
		this.comunidade = comunidade;
	}

	public Regra() {
		super();
	}

}
