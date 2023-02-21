package attornatus.com.athor.service.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import attornatus.com.athor.controller.DTO.dtos.EnderecoDTO;
import attornatus.com.athor.model.Endereco;
import attornatus.com.athor.repository.EnderecoRepository;
import attornatus.com.athor.service.Service_Interface;
import attornatus.com.athor.service.auxiliares.EnderecoAuxiliar;

@Service
public class EnderecoService extends EnderecoAuxiliar implements Service_Interface<EnderecoDTO> {

    @Autowired
    private EnderecoRepository enderecoRepository;

    
    public EnderecoService() {

        
    }

    @Override
    public List<EnderecoDTO> obterTodos() {
        List<Endereco> enderecos = enderecoRepository.findAll();

        return  this.converterLista(enderecos);
    }

    @Override
    public EnderecoDTO obterPorId(Long id) {
        Optional<Endereco> EnderecoOp = enderecoRepository.findById(id);

        return this.converterOptional(EnderecoOp, false);
    }

    @Override
    public EnderecoDTO adicionar(EnderecoDTO dto) {
        dto.setId(null);
       


        Endereco endereco = dto.converterParaModel();

        enderecoRepository.save(endereco);

        dto.setId(endereco.getId());

        return dto;
    }

    @Override
    public EnderecoDTO atualizar(EnderecoDTO dto, Long id) {
        Optional<Endereco> EnderecoOp = enderecoRepository.findById(id);

        Endereco endereco = EnderecoOp.get();

        this.verificarEAtualizar(endereco, dto);

        enderecoRepository.save(endereco);


        return  this.converterModelParaDTO(endereco);
    }

    @Override
    public EnderecoDTO deletarPorId(Long id) {
        Optional<Endereco> EnderecoOp = enderecoRepository.findById(id);

        if(!EnderecoOp.isPresent()){
            return null;
        }

        EnderecoDTO enderecoDTO = this.converterOptional(EnderecoOp, true);

        enderecoRepository.deleteById(id);

        return enderecoDTO;
    }

    public List<EnderecoDTO> getConverterLista(List<Endereco> models){
        return this.converterLista(models);
    }

    public EnderecoDTO converterModel(Endereco endereco){
        return this.converterModelParaDTO(endereco);
    }
    
}
