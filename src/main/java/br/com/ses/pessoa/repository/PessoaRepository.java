package br.com.ses.pessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ses.pessoa.modelo.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>, PessoaRepositoryQueries {

}
