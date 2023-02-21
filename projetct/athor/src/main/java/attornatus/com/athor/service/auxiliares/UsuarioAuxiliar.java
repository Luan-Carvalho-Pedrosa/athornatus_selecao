package attornatus.com.athor.service.auxiliares;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import attornatus.com.athor.controller.DTO.dtos.UsuarioDTO;
import attornatus.com.athor.model.Usuario;
import attornatus.com.athor.service.Service_Auxiliar;

public class UsuarioAuxiliar extends Service_Auxiliar<UsuarioDTO, Usuario> {

    @Override
    protected UsuarioDTO converterModelParaDTO(Usuario model) {
        UsuarioDTO dto = new  UsuarioDTO(model.getNome(), model.getDataNascimento());
        dto.setId(model.getId());

        return dto;
    }

    @Override
    protected List<UsuarioDTO> converterLista(List<Usuario> models) {
        List<UsuarioDTO> DTOs = new ArrayList<UsuarioDTO>();
    	
    	for(Usuario usuario: models) {
    		UsuarioDTO dto = this.converterModelParaDTO(usuario);
    		DTOs.add( dto);
    	}
    	
    	return DTOs;
    }

    @Override
    protected UsuarioDTO converterOptional(Optional<Usuario> modelOp, Boolean confere) {
        if(!confere){
            if(!modelOp.isPresent()){
                return null;
            }
            }
    
            Usuario usuario = modelOp.get();
            UsuarioDTO dto = this.converterModelParaDTO(usuario);
    
    
            return dto;
            }

    @Override
    protected void verificarEAtualizar(Usuario model, UsuarioDTO dto) {

        String nomeDTO = dto.getNome();
        if(nomeDTO != null ){
            if(nomeDTO != ""){
                model.setNome(nomeDTO);
            }
        }

        String dataNascimentoDTO = dto.getDataNascimento();
        if(dataNascimentoDTO != null){
        	if(dataNascimentoDTO != "") {
            model.setDataNascimento(dataNascimentoDTO);
        	}

        }


        
    }
    
    
    protected Usuario converterOptionalParaModel(Optional<Usuario> optional) {
    	if(!optional.isPresent()) {
    		return null;
    		
    	}
		return optional.get();
    	
    }
    
    
}
