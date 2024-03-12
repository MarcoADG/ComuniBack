package br.com.Comunidades.entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "reunioes")
public class Reuniao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reuniao_id")
	private Integer reuniaoId;

	@NotNull
	@Column(name = "data_hora")
	private LocalDateTime dataHora;

	@NotNull
	@Column(name = "tema")
	private String tema;

	@NotNull
	@Column(name = "imagem")
	private String imagem;

	@NotNull
	@Column(name = "responsavel")
	private String responsavel;

	@NotNull
	@Column(name = "descricao")
	private String descricao;

	@Column(name = "material")
	private String material;

	@Column(name = "gravacao")
	private String gravacao;

	@Column(name = "resumo")
	private String resumo;

	@Column(name = "estado")
	private Boolean estado;

	@ManyToOne
	@JoinColumn(name = "id_comunidade", referencedColumnName = "comunidade_id")
	private Comunidade comunidade;

	@OneToMany(mappedBy = "reuniao")
	private List<Comentario> comentario;

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

	public Comunidade getComunidade() {
		return comunidade;
	}

	public void setComunidade(Comunidade comunidade) {
		this.comunidade = comunidade;
	}

	public List<Comentario> getComentario() {
		return comentario;
	}

	public void setComentario(List<Comentario> comentario) {
		this.comentario = comentario;
	}

	public Reuniao(Integer reuniaoId, @NotNull LocalDateTime dataHora, @NotNull String tema, @NotNull String imagem,
			@NotNull String responsavel, @NotNull String descricao, String material, String gravacao, String resumo,
			Boolean estado, Comunidade comunidade, List<Comentario> comentario) {
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
		this.comunidade = comunidade;
		this.comentario = comentario;
	}

	public Reuniao() {
		super();
	}
}
