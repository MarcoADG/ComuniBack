package br.com.Comunidades.entities;

import java.time.LocalDateTime;

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
@Table(name = "comentarios")
public class Comentario {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "avisoId")
    private Integer avisoId;
	
	@NotNull
    @Column(name = "comentario")
    private String comentario;
	
	@NotNull
    @Column(name = "dataHora")
    private LocalDateTime dataHora;
	
	@ManyToOne
	@JoinColumn (name = "idMembro", referencedColumnName = "membroId")
	private Membro membro;
	
	@ManyToOne
	@JoinColumn (name = "idReuniao", referencedColumnName = "reuniaoId")
	private Reuniao reuniao;

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

	public Membro getMembro() {
		return membro;
	}

	public void setMembro(Membro membro) {
		this.membro = membro;
	}

	public Reuniao getReuniao() {
		return reuniao;
	}

	public void setReuniao(Reuniao reuniao) {
		this.reuniao = reuniao;
	}

	public Comentario(Integer avisoId, @NotNull String comentario, @NotNull LocalDateTime dataHora, Membro membro,
			Reuniao reuniao) {
		super();
		this.avisoId = avisoId;
		this.comentario = comentario;
		this.dataHora = dataHora;
		this.membro = membro;
		this.reuniao = reuniao;
	}

	public Comentario() {
		super();
	}
	
}
