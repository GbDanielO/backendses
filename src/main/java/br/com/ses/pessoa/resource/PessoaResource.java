package br.com.ses.pessoa.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.ses.pessoa.modelo.Pessoa;
import br.com.ses.pessoa.negocio.NgcPessoa;

@RestController()
@RequestMapping("/pessoas")
@CrossOrigin
public class PessoaResource {

  @Autowired
  private NgcPessoa ngcPessoa;

  @GetMapping
  public List<Pessoa> listar() {
    return this.ngcPessoa.listar();
  }

  @GetMapping("/{codigo}")
  public ResponseEntity<Pessoa> buscarPeloCodigo( @PathVariable Long codigo ) {
    return this.ngcPessoa.buscarPeloCodigo( codigo );
  }

  @PostMapping("/filter")
  @ResponseStatus(HttpStatus.OK)
  public List<Pessoa> getPessoas( @Valid @RequestBody Pessoa pessoa ) {
    return this.ngcPessoa.getPessoas( pessoa );
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Pessoa criar( @Valid @RequestBody Pessoa pessoa, HttpServletResponse response ) {
    return this.ngcPessoa.criar( pessoa, response );
  }

  @PutMapping("/{codigo}")
  @ResponseStatus(HttpStatus.OK)
  public Pessoa atualizar( @PathVariable Long codigo, @Valid @RequestBody Pessoa pessoa,
      HttpServletResponse response ) {
    return this.ngcPessoa.atualizar( codigo, pessoa, response );
  }

  @DeleteMapping("/{codigo}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete( @PathVariable Long codigo ) {
    this.ngcPessoa.delete( codigo );
  }

}
