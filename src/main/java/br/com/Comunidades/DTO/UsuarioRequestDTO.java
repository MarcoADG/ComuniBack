package br.com.Comunidades.DTO;

import br.com.Comunidades.entities.CargoEnum;

public class UsuarioRequestDTO {

	private String email;

    private String senha;

    private CargoEnum cargo;

    private String apelido;

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

	public UsuarioRequestDTO(String email, String senha, CargoEnum cargo, String apelido) {
		super();
		this.email = email;
		this.senha = senha;
		this.cargo = cargo;
		this.apelido = apelido;
	}

	public UsuarioRequestDTO() {
		super();
	}
    
}
