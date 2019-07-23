package br.com.ses.pessoa.repository;

import java.util.List;

import br.com.ses.pessoa.modelo.Pessoa;

public interface PessoaRepositoryQueries {

  public List<Pessoa> getPessoas( Pessoa pessoa );

}
