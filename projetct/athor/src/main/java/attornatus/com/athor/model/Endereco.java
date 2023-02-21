package attornatus.com.athor.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull @NotEmpty 
    private String logradouro;
    @NotNull @NotEmpty 
    private String CEP;
    @NotNull 
    private int numero;
    @NotNull @NotEmpty 
    private String Cidade;

    public Endereco() {
    }

    public Endereco(@NotNull @NotEmpty String logradouro, @NotNull @NotEmpty String CEP, @NotNull  int numero,
            @NotNull @NotEmpty String Cidade) {
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

    

    

    
    
}
