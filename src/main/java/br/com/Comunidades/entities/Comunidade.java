package br.com.Comunidades.entities;

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
@Table(name = "comunidades")
public class Comunidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "comunidade_id")
	private Integer comunidadeId;

	@NotNull
	@Column(name = "tema")
	private String tema;

	@NotNull
	@Column(name = "lider")
	private String lider;

	@NotNull
	@Column(name = "imagem")
	private String imagem;

	@Column(name = "estado")
	private Boolean estado;

	@OneToMany(mappedBy = "comunidade")
	private List<Membro> membro;

	@OneToMany(mappedBy = "comunidade")
	private List<Regra> regra;

	@OneToMany(mappedBy = "comunidade")
	private List<Reuniao> reuniao;

	@OneToMany(mappedBy = "comunidade")
	private List<AvisoMembros> avisoMembros;

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

	public List<Membro> getMembro() {
		return membro;
	}

	public void setMembro(List<Membro> membro) {
		this.membro = membro;
	}

	public List<Regra> getRegra() {
		return regra;
	}

	public void setRegra(List<Regra> regra) {
		this.regra = regra;
	}

	public List<Reuniao> getReuniao() {
		return reuniao;
	}

	public void setReuniao(List<Reuniao> reuniao) {
		this.reuniao = reuniao;
	}

	public List<AvisoMembros> getAvisoMembros() {
		return avisoMembros;
	}

	public void setAvisoMembros(List<AvisoMembros> avisoMembros) {
		this.avisoMembros = avisoMembros;
	}

	public Comunidade(Integer comunidadeId, @NotNull String tema, @NotNull String lider, @NotNull String imagem,
			Boolean estado, List<Membro> membro, List<Regra> regra, List<Reuniao> reuniao,
			List<AvisoMembros> avisoMembros) {
		super();
		this.comunidadeId = comunidadeId;
		this.tema = tema;
		this.lider = lider;
		this.imagem = imagem;
		this.estado = estado;
		this.membro = membro;
		this.regra = regra;
		this.reuniao = reuniao;
		this.avisoMembros = avisoMembros;
	}

	public Comunidade() {
		super();
	}

}
