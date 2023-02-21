package attornatus.com.athor.controller.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import attornatus.com.athor.controller.Controller_Interface;
import attornatus.com.athor.controller.Auxiliares.UsuarioCrtlAuxiliar;
import attornatus.com.athor.controller.DTO.dtos.EnderecoDTO;
import attornatus.com.athor.controller.DTO.dtos.UsuarioDTO;
import attornatus.com.athor.controller.Form.forms.UsuarioForm;
import attornatus.com.athor.controller.Form.forms.VincularEnderecoForm;
import attornatus.com.athor.controller.Response.EnderecoResponse;
import attornatus.com.athor.controller.Response.UsuarioResponse;
import attornatus.com.athor.controller.Response.VincularEnderecorResponse;
import attornatus.com.athor.service.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController extends UsuarioCrtlAuxiliar implements Controller_Interface<UsuarioDTO, UsuarioResponse, UsuarioForm> {


    
    @Autowired
    private UsuarioService usuarioService;

    @Override
    @GetMapping
    public List<UsuarioResponse> listar() {
        List<UsuarioDTO> Usuarios = this.usuarioService.obterTodos();

        return this.converterLista(Usuarios);
        }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> selecionarPorId(@PathVariable Long id) {
        UsuarioDTO UsuarioDTO = usuarioService.obterPorId(id);

        return this.gerarResposta(UsuarioDTO, 200);
    }

    @Override
    @PostMapping
    public ResponseEntity<UsuarioResponse> cadastrar(@RequestBody UsuarioForm form) {
        UsuarioDTO UsuarioDTO = this.usuarioService.adicionar(form.converterParaDTO());

        return this.gerarResposta(UsuarioDTO, 200);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponse> atualizar(@RequestBody UsuarioForm form,@PathVariable Long id) {
         UsuarioDTO UsuarioDTO = this.usuarioService.atualizar(form.converterParaDTO(), id);

        return this.gerarResposta(UsuarioDTO, 200);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<UsuarioResponse> deletarPorId(@PathVariable Long id) {
        UsuarioDTO UsuarioDTO = this.usuarioService.deletarPorId(id);

        return this.gerarResposta(UsuarioDTO, 200);
    }

    @PutMapping("/vincularEndereco/{idPessoa}/{idEndereco}")
    public ResponseEntity<VincularEnderecorResponse> vincularEndereco(@RequestBody VincularEnderecoForm form,
    @PathVariable Long idPessoa, @PathVariable Long idEndereco){

        String mensagem = this.usuarioService.vincularEndereco(idPessoa, idEndereco, form.getPrincipal());

        return this.gerarRespostaVinculacao(idPessoa, idEndereco, mensagem, form.getPrincipal());
    }

    @GetMapping("/listarEnderecos/{id}")
    public List<EnderecoResponse> listarEnderecos(@PathVariable Long id){

        return this.converterListaEnderecos(this.usuarioService.listarEnderecos(id));

    }

    @GetMapping("/enderecoPrincipal/{id}")
    public ResponseEntity<EnderecoResponse> pegarEnderecoPrincipal(@PathVariable Long id){
        EnderecoDTO dto = usuarioService.pegarEnderecoPrincipal(id);
        return this.gerarRespostaEndereco(dto, 200);

    }
    
}
