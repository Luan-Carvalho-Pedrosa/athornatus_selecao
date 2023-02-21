package attornatus.com.athor.service.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import attornatus.com.athor.controller.DTO.dtos.EnderecoDTO;
import attornatus.com.athor.controller.DTO.dtos.UsuarioDTO;
import attornatus.com.athor.model.Usuario;
import attornatus.com.athor.repository.UsuarioRepository;
import attornatus.com.athor.service.Service_Interface;
import attornatus.com.athor.service.auxiliares.EnderecoAuxiliar;
import attornatus.com.athor.service.auxiliares.UsuarioAuxiliar;
 
@Service
public class UsuarioService extends UsuarioAuxiliar implements Service_Interface<UsuarioDTO>     {


    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EnderecoService enderecoService;


    public UsuarioService() {
        
    }

    @Override
    public List<UsuarioDTO> obterTodos() {

        List<Usuario> usuarios = usuarioRepository.findAll();

        return  this.converterLista(usuarios);
        
    }

    @Override
    public UsuarioDTO obterPorId(Long id) {
        Optional<Usuario> usuarioOp = usuarioRepository.findById(id);

        return this.converterOptional(usuarioOp, false);
    }

    @Override
    public UsuarioDTO adicionar(UsuarioDTO dto) {
        dto.setId(null);


        Usuario usuario = dto.converterParaModel();

        usuarioRepository.save(usuario);

        dto.setId(usuario.getId());

        return dto;
    }

    @Override
    public UsuarioDTO atualizar(UsuarioDTO dto, Long id) {
        Optional<Usuario> usuarioOp = usuarioRepository.findById(id);

        Usuario usuario = usuarioOp.get();

        this.verificarEAtualizar(usuario, dto);

        usuarioRepository.save(usuario);


        return  this.converterModelParaDTO(usuario);
    }

    @Override
    public UsuarioDTO deletarPorId(Long id) {
        Optional<Usuario> usuarioOp = usuarioRepository.findById(id);

        if(!usuarioOp.isPresent()){
            return null;
        }

        UsuarioDTO usuarioDTO = this.converterOptional(usuarioOp, true);

        usuarioRepository.deleteById(id);

        return usuarioDTO;
    }

    public String vincularEndereco(Long idPessoa, Long idEndereco,  Boolean isPrincipal){

    	Usuario usuario = this.converterOptionalParaModel(this.usuarioRepository.findById(idPessoa));
        if(usuario != null){
            EnderecoDTO enderecoDTO = enderecoService.obterPorId(idEndereco);
            System.out.println(enderecoDTO.getLogradouro());

            if(enderecoDTO != null){
                usuario.getEnderecos().add(enderecoDTO.getId());
                if(isPrincipal){
                    usuario.setEndereçoPrincipal(enderecoDTO.getId());
                }        
                usuarioRepository.save(usuario);
                return "Vinculo realizado";
            }

            else{
                return "endereço inexistente";
            }
        }
       

        return "usuario inexistente";

    }

    public List<EnderecoDTO> listarEnderecos(Long id){
    	Usuario usuario = this.converterOptionalParaModel(this.usuarioRepository.findById(id));
        if(usuario != null){
        	List<EnderecoDTO> enderecos = new ArrayList<EnderecoDTO>();
        	for(Long ids: usuario.getEnderecos()) {
        		enderecos.add(this.enderecoService.obterPorId(ids));
        	}
        	return enderecos;
        }

        return null;

    }

    public EnderecoDTO pegarEnderecoPrincipal(Long id){
    	Usuario usuario = this.converterOptionalParaModel(this.usuarioRepository.findById(id));

        if(usuario != null){
        	Long idEndereco =  usuario.getEndereçoPrincipal();
        	if(idEndereco != null) {
            return this.enderecoService.obterPorId(idEndereco);
        	}
        }

        return null;


    }
    
}
