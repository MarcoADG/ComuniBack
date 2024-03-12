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
    @Column(name = "comentario_id")
    private Integer comentarioId;
	
	@NotNull
    @Column(name = "comentario")
    private String comentario;
	
	@NotNull
    @Column(name = "data_hora")
    private LocalDateTime dataHora;
	
	@ManyToOne
	@JoinColumn (name = "id_membro", referencedColumnName = "membro_id")
	private Membro membro;
	
	@ManyToOne
	@JoinColumn (name = "id_reuniao", referencedColumnName = "reuniao_id")
	private Reuniao reuniao;

	public Integer getComentarioId() {
		return comentarioId;
	}

	public void setComentarioId(Integer avisoId) {
		this.comentarioId = avisoId;
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

	public Comentario(Integer comentarioId, @NotNull String comentario, @NotNull LocalDateTime dataHora, Membro membro,
			Reuniao reuniao) {
		super();
		this.comentarioId = comentarioId;
		this.comentario = comentario;
		this.dataHora = dataHora;
		this.membro = membro;
		this.reuniao = reuniao;
	}

	public Comentario() {
		super();
	}
	
}
