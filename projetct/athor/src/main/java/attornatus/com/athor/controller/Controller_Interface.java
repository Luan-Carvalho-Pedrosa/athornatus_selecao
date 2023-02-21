package attornatus.com.athor.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface Controller_Interface<DTO, Response, Form> {

    public List<Response> listar();

    public ResponseEntity<Response> selecionarPorId(Long id);

    public ResponseEntity<Response> cadastrar(Form form);

    public ResponseEntity<Response> atualizar(Form form, Long id);

    public ResponseEntity<Response> deletarPorId(Long id);





    
}
