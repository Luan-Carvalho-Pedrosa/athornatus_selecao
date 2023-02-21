package attornatus.com.athor.controller.Response;

public class EnderecoResponse {

   
    private Long id;
    private String logradouro;
    private String CEP;
    private int numero;
    private String Cidade;

    public EnderecoResponse(Long id, String logradouro, String CEP, int numero, String Cidade) {
        this.id = id;
        this.logradouro = logradouro;
        this.CEP = CEP;
        this.numero = numero;
        this.Cidade = Cidade;
    }

    public Long getId() {
        return id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getCEP() {
        return CEP;
    }

    public int getNumero() {
        return numero;
    }

    public String getCidade() {
        return Cidade;
    }

    

    
    
}
