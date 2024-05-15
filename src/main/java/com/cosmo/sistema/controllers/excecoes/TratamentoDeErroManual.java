package com.cosmo.sistema.controllers.excecoes;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cosmo.sistema.servicos.excecoes.RecursoNaoEncontrado;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice //estamos dizendo que ele irá capturar as possíveis  exceções que ocorrerem
public class TratamentoDeErroManual {
	
	//vamos dizer que é nesse método em que ocorrerá o tratamento
	@ExceptionHandler(RecursoNaoEncontrado.class)
	public ResponseEntity<ErroPadrao> recursoNaoEncontrado(RecursoNaoEncontrado e, HttpServletRequest request){
		String error = "Recurso não encontrato";
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErroPadrao ep = new ErroPadrao(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(ep);
		
		
	}
	
}
