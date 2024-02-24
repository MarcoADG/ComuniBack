package br.com.Comunidades.DTO;

import br.com.Comunidades.entities.CargoEnum;

public class UsuarioResponseDTO {

	private Integer usuarioId;
	
	private String email;

    private String senha;

    private CargoEnum cargo;

    private String apelido;

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

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public UsuarioResponseDTO(Integer usuarioId, String email, String senha, CargoEnum cargo, String apelido) {
		super();
		this.usuarioId = usuarioId;
		this.email = email;
		this.senha = senha;
		this.cargo = cargo;
		this.apelido = apelido;
	}

	public UsuarioResponseDTO() {
		super();
	}
    
}
