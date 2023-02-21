package attornatus.com.athor.controller.Controllers;

import java.util.List;

import javax.sound.midi.ControllerEventListener;

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
import attornatus.com.athor.controller.Auxiliares.EnderecoCrtlAuxiliar;
import attornatus.com.athor.controller.DTO.dtos.EnderecoDTO;
import attornatus.com.athor.controller.Form.forms.EnderecoForm;
import attornatus.com.athor.controller.Form.forms.VincularEnderecoForm;
import attornatus.com.athor.controller.Response.EnderecoResponse;
import attornatus.com.athor.controller.Response.VincularEnderecorResponse;
import attornatus.com.athor.service.services.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController extends EnderecoCrtlAuxiliar implements Controller_Interface<EnderecoDTO, EnderecoResponse, EnderecoForm> {

    @Autowired
    private EnderecoService EnderecoService;

    
    @Override
    @GetMapping
    public List<EnderecoResponse> listar() {
        List<EnderecoDTO> Enderecos = this.EnderecoService.obterTodos();

        return this.converterLista(Enderecos);
        
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<EnderecoResponse> selecionarPorId(@PathVariable Long id) {
        EnderecoDTO EnderecoDTO = EnderecoService.obterPorId(id);

        return this.gerarResposta(EnderecoDTO, 200);    }

    @Override
    @PostMapping
    public ResponseEntity<EnderecoResponse> cadastrar(@RequestBody EnderecoForm form) {
        EnderecoDTO EnderecoDTO = this.EnderecoService.adicionar(form.converterParaDTO());

        return this.gerarResposta(EnderecoDTO, 200);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<EnderecoResponse> atualizar( @RequestBody EnderecoForm form, @PathVariable Long id) {
        EnderecoDTO EnderecoDTO = this.EnderecoService.atualizar(form.converterParaDTO(), id);

        return this.gerarResposta(EnderecoDTO, 200);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<EnderecoResponse> deletarPorId(@PathVariable Long id) {
        EnderecoDTO EnderecoDTO = this.EnderecoService.deletarPorId(id);

        return this.gerarResposta(EnderecoDTO, 200);
    }


    
}
