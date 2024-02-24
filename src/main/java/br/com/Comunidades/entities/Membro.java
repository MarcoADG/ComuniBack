package br.com.Comunidades.entities;

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
@Table(name = "membros")
public class Membro {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "membroId")
    private Integer membroId;
	
	@NotNull
	@Column(name = "nome")
	private String nome;
	
	@ManyToOne
	@JoinColumn (name = "idUsuario", referencedColumnName = "usuarioId")
	private Usuario usuario;
	
	@ManyToOne
    @JoinColumn(name = "idComunidade", referencedColumnName = "comunidadeId")
    private Comunidade comunidade;
	
	@OneToMany(mappedBy = "membro")
	private List<AvisoMembros> avisoMembros;
	
	@OneToMany(mappedBy = "membro")
	private List<Comentario> comentario;

	public Integer getMembroId() {
		return membroId;
	}

	public void setMembroId(Integer membroId) {
		this.membroId = membroId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Comunidade getComunidade() {
		return comunidade;
	}

	public void setComunidade(Comunidade comunidade) {
		this.comunidade = comunidade;
	}

	public List<AvisoMembros> getAvisoMembros() {
		return avisoMembros;
	}

	public void setAvisoMembros(List<AvisoMembros> avisoMembros) {
		this.avisoMembros = avisoMembros;
	}

	public List<Comentario> getComentario() {
		return comentario;
	}

	public void setComentario(List<Comentario> comentario) {
		this.comentario = comentario;
	}

	public Membro(Integer membroId, @NotNull String nome, Usuario usuario, Comunidade comunidade,
			List<AvisoMembros> avisoMembros, List<Comentario> comentario) {
		super();
		this.membroId = membroId;
		this.nome = nome;
		this.usuario = usuario;
		this.comunidade = comunidade;
		this.avisoMembros = avisoMembros;
		this.comentario = comentario;
	}

	public Membro() {
		super();
	}
	
}
