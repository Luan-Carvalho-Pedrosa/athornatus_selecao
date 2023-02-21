package attornatus.com.athor.service.auxiliares;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import attornatus.com.athor.controller.DTO.dtos.EnderecoDTO;
import attornatus.com.athor.model.Endereco;
import attornatus.com.athor.service.Service_Auxiliar;

public class EnderecoAuxiliar extends Service_Auxiliar<EnderecoDTO, Endereco> {

    @Override
    protected EnderecoDTO converterModelParaDTO(Endereco model) {
        EnderecoDTO dto = new  EnderecoDTO(model.getLogradouro(), model.getCEP(),
        model.getNumero(), model.getCidade());
        dto.setId(model.getId());

        return dto;
    }

    @Override
    protected List<EnderecoDTO> converterLista(List<Endereco> models) {
        List<EnderecoDTO> DTOs = new ArrayList<EnderecoDTO>();
    	
    	for(Endereco Endereco: models) {
    		EnderecoDTO dto = this.converterModelParaDTO(Endereco);
    		DTOs.add( dto);
    	}
    	
    	return DTOs;
    }

    @Override
    protected EnderecoDTO converterOptional(Optional<Endereco> modelOp, Boolean confere) {
        if(!confere){
            if(!modelOp.isPresent()){
                return null;
            }
            }
    
            Endereco Endereco = modelOp.get();
            EnderecoDTO dto = this.converterModelParaDTO(Endereco);
    
    
            return dto;
            
    }

    /* (non-Javadoc)
     * @see attornatus.com.athor.service.Service_Auxiliar#verificarEAtualizar(java.lang.Object, java.lang.Object)
     */
    @Override
    protected void verificarEAtualizar(Endereco model, EnderecoDTO dto) {

        String LogradouroDTO = dto.getLogradouro();
        if(LogradouroDTO != null ){
            if(LogradouroDTO != ""){
                model.setLogradouro(LogradouroDTO);
            }
        }

        String cepDTO = dto.getCEP();
        if(cepDTO != null ){
            if(cepDTO != ""){
                model.setCEP(cepDTO);
            }
        }

        Integer NumeroDTO = dto.getNumero();
        if(NumeroDTO != null){
        	if(NumeroDTO != 0) {
            model.setNumero(NumeroDTO);
        	}

        }

        String CidadeDTO = dto.getCidade();
        if(CidadeDTO != null ){
            if(CidadeDTO != ""){
                model.setCidade(CidadeDTO);
            }
        }
            
        


        
    }
    
}
