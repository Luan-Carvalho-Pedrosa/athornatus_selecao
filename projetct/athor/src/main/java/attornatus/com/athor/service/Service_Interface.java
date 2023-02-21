package attornatus.com.athor.service;

import java.util.List;

public interface Service_Interface<DTO> {

    public List<DTO> obterTodos();

    public DTO obterPorId(Long id);

    public DTO adicionar(DTO dto);

    public DTO atualizar(DTO dto, Long id);

    public DTO deletarPorId(Long id);


    
}
