package attornatus.com.athor.controller.Auxiliares;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import attornatus.com.athor.controller.Controller_Auxiliar;
import attornatus.com.athor.controller.DTO.dtos.EnderecoDTO;
import attornatus.com.athor.controller.DTO.dtos.UsuarioDTO;
import attornatus.com.athor.controller.Response.EnderecoResponse;
import attornatus.com.athor.controller.Response.UsuarioResponse;
import attornatus.com.athor.controller.Response.VincularEnderecorResponse;

public class UsuarioCrtlAuxiliar extends Controller_Auxiliar<UsuarioDTO, UsuarioResponse> {

    @Override
    protected ResponseEntity<UsuarioResponse> gerarResposta(UsuarioDTO dto, int status) {
        if(dto == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        
        return ResponseEntity.status(status).body(dto.converterParaResponse());
    }

    @Override
    protected List<UsuarioResponse> converterLista(List<UsuarioDTO> dtos) {
        List<UsuarioResponse> responses = new ArrayList<UsuarioResponse>();
    	
    	for(UsuarioDTO dto: dtos) {
    		responses.add(dto.converterParaResponse());
    	}
    	
    	return responses;
    }

    protected ResponseEntity<VincularEnderecorResponse> gerarRespostaVinculacao(Long idUsuario, Long idEndereco,
     String mensagem, Boolean isPrincipal){

        VincularEnderecorResponse response =  new VincularEnderecorResponse(idUsuario, idEndereco, isPrincipal, mensagem);

        if(mensagem.equals("Vinculo realizado")){
            return  ResponseEntity.status(200).body(response);

        }

        return  ResponseEntity.status(400).body(response);

    }

    protected List<EnderecoResponse> converterListaEnderecos(List<EnderecoDTO> dtos) {
        List<EnderecoResponse> responses = new ArrayList<EnderecoResponse>();
    	
    	for(EnderecoDTO dto: dtos) {
    		responses.add(dto.converterParaResponse());
    	}
    	
    	return responses;
    }

    protected ResponseEntity<EnderecoResponse> gerarRespostaEndereco(EnderecoDTO dto, int status) {
        if(dto == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        
        return ResponseEntity.status(status).body(dto.converterParaResponse());
    }

   
    
}
