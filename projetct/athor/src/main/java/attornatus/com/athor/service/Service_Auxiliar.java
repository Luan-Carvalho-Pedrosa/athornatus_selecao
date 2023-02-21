package attornatus.com.athor.service;

import java.util.List;
import java.util.Optional;

public abstract class Service_Auxiliar<DTO, Model> {

abstract protected DTO converterModelParaDTO(Model model);

abstract protected List<DTO> converterLista(List<Model> models );

abstract protected DTO converterOptional(Optional<Model> modelOp, Boolean confere);

abstract protected void verificarEAtualizar(Model model, DTO dto);




    
}
