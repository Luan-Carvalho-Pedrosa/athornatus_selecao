package attornatus.com.athor.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull @NotEmpty 
    private String nome;
    @NotNull @NotEmpty
    private String dataNascimento;

    private Long endereçoPrincipal;

    private Set<Long> enderecos;

    public Usuario() {
    }

    public Usuario(@NotNull @NotEmpty String nome, @NotNull @NotEmpty String dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.enderecos = new HashSet<Long>();
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

	public Long getEndereçoPrincipal() {
		return endereçoPrincipal;
	}

	public void setEndereçoPrincipal(Long endereçoPrincipal) {
		this.endereçoPrincipal = endereçoPrincipal;
	}

	public Set<Long> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Set<Long> enderecos) {
		this.enderecos = enderecos;
	}

	

    

    

    

    

    

    

    


    
}
