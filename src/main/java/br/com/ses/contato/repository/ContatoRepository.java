package br.com.ses.contato.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ses.contato.modelo.Telefone;

public interface ContatoRepository extends JpaRepository<Telefone, Long>, ContatoRepositoryQueries {

}
