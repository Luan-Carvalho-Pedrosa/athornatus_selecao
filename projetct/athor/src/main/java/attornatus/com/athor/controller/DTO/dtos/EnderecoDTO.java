package attornatus.com.athor.controller.DTO.dtos;

import attornatus.com.athor.controller.DTO.DTO_Interface;
import attornatus.com.athor.controller.Response.EnderecoResponse;
import attornatus.com.athor.model.Endereco;

public class EnderecoDTO implements DTO_Interface<Endereco, EnderecoResponse> {

    private Long id;
    private String logradouro;
    private String CEP;
    private int numero;
    private String Cidade;

    

    public EnderecoDTO() {
    }

    public EnderecoDTO(String logradouro, String CEP, int numero, String Cidade) {
        this.logradouro = logradouro;
        this.CEP = CEP;
        this.numero = numero;
        this.Cidade = Cidade;
    }

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String cEP) {
        CEP = cEP;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String cidade) {
        Cidade = cidade;
    }

    @Override
    public Endereco converterParaModel() {
        Endereco endereco = new Endereco(this.logradouro, this.CEP, this.numero, this.Cidade);
        return endereco;
    }

    @Override
    public EnderecoResponse converterParaResponse() {
        EnderecoResponse enderecoResponse = new EnderecoResponse(this.id, this.logradouro,
         this.CEP, this.numero, this.Cidade);
        return enderecoResponse;
    }
    
}
