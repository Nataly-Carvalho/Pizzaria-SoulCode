package com.soulcode.pizzaria.models.DTOS;

import com.soulcode.pizzaria.models.Cliente;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class ClienteDTO {
    private Long id;

    @NotBlank(message = "O nome deve ser preenchido")
    private String nome;

    @NotBlank(message = "O telefone deve ser preenchido")
    private String telefone;

    @NotBlank(message = "O Atributo Usuário é Obrigatório")
    @Email(message = "O atributo login deve ser um email valido")
    private String login;

    @NotBlank(message = "A senha deve ser preenchido")
    private String senha;

    @NotBlank(message = "O Endereço deve ser preenchido")
    private String endereco;

    public ClienteDTO() {}

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.telefone = cliente.getTelefone();
        this.login = cliente.getLogin();
        this.senha = cliente.getSenha();
        this.endereco = cliente.getEndereco();

    }
    public static Cliente converter(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setId(clienteDTO.getId());
        cliente.setNome(clienteDTO.getNome());
        cliente.setTelefone(clienteDTO.getTelefone());
        cliente.setLogin(clienteDTO.getLogin());
        cliente.setSenha(clienteDTO.getSenha());
        cliente.setEndereco(clienteDTO.getEndereco());
        return cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
