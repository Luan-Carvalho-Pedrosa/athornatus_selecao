package attornatus.com.athor.controller.Response;

public class VincularEnderecorResponse {

    private String mensagem;
    private Long idPessoa;
    private Long idEndereco;
    private Boolean isPrincipal;

    public VincularEnderecorResponse(Long idPessoa, Long idEndereco, Boolean isPrincipal, String mensagem) {
        this.idPessoa = idPessoa;
        this.idEndereco = idEndereco;
        this.isPrincipal = isPrincipal;
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public Long getIdPessoa() {
        return idPessoa;
    }

    public Long getIdEndereco() {
        return idEndereco;
    }

    public Boolean getIsPrincipal() {
        return isPrincipal;
    }

    



    
    
}
