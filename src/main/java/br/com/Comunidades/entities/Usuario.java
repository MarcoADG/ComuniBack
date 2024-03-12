package br.com.Comunidades.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Integer usuarioId;
	
	@NotNull
	@Column(name = "email")
	private String email;
	
	@NotNull
	@Column(name = "senha")
    private String senha;

	@NotNull
	@Enumerated(EnumType.STRING)
    @Column(name = "cargo")
    private CargoEnum cargo;

	@NotNull
    @Column(name = "apelido")
    private String apelido;
	
	@OneToMany(mappedBy = "usuario")
    private List<Membro> membro;

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public CargoEnum getCargo() {
		return cargo;
	}

	public void setCargo(CargoEnum cargo) {
		this.cargo = cargo;
	}
	
	public void addRole(String role) {
	    this.cargo = CargoEnum.valueOf(role.toUpperCase());
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public List<Membro> getMembro() {
		return membro;
	}

	public void setMembro(List<Membro> membro) {
		this.membro = membro;
	}

	public Usuario(Integer usuarioId, @NotNull String email, @NotNull String senha, @NotNull CargoEnum cargo,
			@NotNull String apelido, List<Membro> membro) {
		super();
		this.usuarioId = usuarioId;
		this.email = email;
		this.senha = senha;
		this.cargo = cargo;
		this.apelido = apelido;
		this.membro = membro;
	}

	public Usuario() {
		super();
	}
	
}
