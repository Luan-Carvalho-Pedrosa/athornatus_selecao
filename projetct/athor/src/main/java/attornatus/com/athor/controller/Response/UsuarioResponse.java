package attornatus.com.athor.controller.Response;

public class UsuarioResponse {

    private Long id;
    private String nome;
    private String dataNascimento;

    public UsuarioResponse(Long id, String nome, String dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }



    

    
    
}
