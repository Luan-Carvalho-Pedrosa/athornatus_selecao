package attornatus.com.athor.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;

public abstract class Controller_Auxiliar<DTO, Response> {

    abstract protected ResponseEntity<Response> gerarResposta(DTO dto, int status);

    abstract protected List<Response> converterLista(List<DTO> dtos);


    
}
