package attornatus.com.athor.controller.Form.forms;

import attornatus.com.athor.controller.DTO.dtos.UsuarioDTO;
import attornatus.com.athor.controller.Form.Form_Interface;

public class UsuarioForm implements Form_Interface<UsuarioDTO> {

    private String nome;
    private String dataNascimento;

    



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
    public UsuarioDTO converterParaDTO() {

        UsuarioDTO usuarioDTO = new UsuarioDTO(this.nome, this.dataNascimento);

        return usuarioDTO;
    }
    
}
