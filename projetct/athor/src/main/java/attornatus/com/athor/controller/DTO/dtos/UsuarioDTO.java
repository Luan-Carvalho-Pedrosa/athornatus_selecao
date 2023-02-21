package attornatus.com.athor.controller.DTO.dtos;

import attornatus.com.athor.controller.DTO.DTO_Interface;
import attornatus.com.athor.controller.Response.UsuarioResponse;
import attornatus.com.athor.model.Usuario;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


public class UsuarioDTO implements DTO_Interface<Usuario, UsuarioResponse> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String dataNascimento;


    


    public UsuarioDTO() {
    }

    

    public UsuarioDTO(String nome, String dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
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



    public String getDataNascimento() {
        return dataNascimento;
    }



    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }



    @Override
    public Usuario converterParaModel() {
        Usuario usuario = new Usuario(this.nome, this.dataNascimento);
        return usuario;
    }



    @Override
    public UsuarioResponse converterParaResponse() {

        UsuarioResponse usuarioResponse = new UsuarioResponse(this.id, this.nome, this.dataNascimento);
        return usuarioResponse;
    }



    
    
}
