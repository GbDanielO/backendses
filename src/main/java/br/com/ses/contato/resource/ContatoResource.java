package br.com.ses.contato.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.ses.contato.negocio.NgcContato;

@RestController
@RequestMapping("/contatos")
@CrossOrigin
public class ContatoResource {

  @Autowired
  private NgcContato ngcContato;

  @DeleteMapping("/telefone/{codigo}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteTelefone( @PathVariable Long codigo ) {
    this.ngcContato.excluirTelefone( codigo );
  }

}
