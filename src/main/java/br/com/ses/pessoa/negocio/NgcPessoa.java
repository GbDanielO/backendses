package br.com.ses.pessoa.negocio;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.ses.pessoa.modelo.Pessoa;
import br.com.ses.pessoa.repository.PessoaRepository;

@Service
public class NgcPessoa {

  @Autowired
  private PessoaRepository pessoaRepository;

  public List<Pessoa> listar() {
    return this.pessoaRepository.findAll();
  }

  public ResponseEntity<Pessoa> buscarPeloCodigo( Long codigo ) {

    Optional<Pessoa> optional = this.pessoaRepository.findById( codigo );

    if ( optional.isPresent() ) {
      return ResponseEntity.ok().body( optional.get() );
    }

    return ResponseEntity.notFound().build();
  }

  public List<Pessoa> getPessoas( Pessoa pessoa ) {
    return this.pessoaRepository.getPessoas( pessoa );
  }

  public Pessoa criar( Pessoa pessoa, HttpServletResponse response ) {

    Pessoa pessoaSalva = this.pessoaRepository.salvar( pessoa );

    URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path( "/{codigo}" )
        .buildAndExpand( pessoaSalva.getId() ).toUri();

    response.setHeader( "Location", uri.toASCIIString() );

    return pessoaSalva;
  }

  public Pessoa atualizar( Long codigo, Pessoa pessoa, HttpServletResponse response ) {

    Optional<Pessoa> optional = this.pessoaRepository.findById( codigo );

    if ( !optional.isPresent() ) {
      throw new EmptyResultDataAccessException( 1 );
    }

    Pessoa pessoaSalva = this.pessoaRepository.salvar( pessoa );

    return pessoaSalva;
  }

  public void delete( Long codigo ) {
    this.pessoaRepository.deleteById( codigo );
  }

  public Optional<br.com.ses.pessoa.modelo.Pessoa> buscarPessoaPeloCodigo( Long codigo ) {
    return this.pessoaRepository.findById( codigo );
  }
}
