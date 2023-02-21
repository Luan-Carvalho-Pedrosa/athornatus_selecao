package attornatus.com.athor.controller.Form.forms;

import attornatus.com.athor.controller.DTO.dtos.EnderecoDTO;
import attornatus.com.athor.controller.Form.Form_Interface;

public class EnderecoForm implements Form_Interface<EnderecoDTO> {

    private String logradouro;
    private String cep;
    private int numero;
    private String cidade;

    
    public String getLogradouro() {
        return logradouro;
    }




    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }




    public String getCEP() {
        return cep;
    }




    public void setCEP(String cEP) {
        this.cep = cEP;
    }




    public int getNumero() {
        return numero;
    }




    public void setNumero(int numero) {
        this.numero = numero;
    }




    public String getCidade() {
        return cidade;
    }




    public void setCidade(String cidade) {
        this.cidade = cidade;
    }



    @Override
    public EnderecoDTO converterParaDTO() {
        EnderecoDTO enderecoDTO = new EnderecoDTO(this.logradouro, this.cep, this.numero, this.cidade);
        return enderecoDTO;
    }
    
}
