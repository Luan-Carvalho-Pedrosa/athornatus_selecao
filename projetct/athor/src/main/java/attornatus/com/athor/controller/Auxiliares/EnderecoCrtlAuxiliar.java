package attornatus.com.athor.controller.Auxiliares;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import attornatus.com.athor.controller.Controller_Auxiliar;
import attornatus.com.athor.controller.DTO.dtos.EnderecoDTO;
import attornatus.com.athor.controller.Response.EnderecoResponse;

public class EnderecoCrtlAuxiliar extends Controller_Auxiliar<EnderecoDTO, EnderecoResponse> {

    @Override
    protected ResponseEntity<EnderecoResponse> gerarResposta(EnderecoDTO dto, int status) {
        if(dto == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        
        return ResponseEntity.status(status).body(dto.converterParaResponse());
    }
    

    @Override
    protected List<EnderecoResponse> converterLista(List<EnderecoDTO> dtos) {
        List<EnderecoResponse> responses = new ArrayList<EnderecoResponse>();
    	
    	for(EnderecoDTO dto: dtos) {
    		responses.add(dto.converterParaResponse());
    	}
    	
    	return responses;
    }
    
}
