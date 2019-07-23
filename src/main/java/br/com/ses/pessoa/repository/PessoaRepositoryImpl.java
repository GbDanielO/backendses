package br.com.ses.pessoa.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.ses.pessoa.modelo.Pessoa;
import br.com.ses.utils.Util;

public class PessoaRepositoryImpl implements PessoaRepositoryQueries {

  @PersistenceContext
  private EntityManager entityManager;

  @SuppressWarnings("unchecked")
  @Override
  public List<Pessoa> getPessoas( Pessoa pessoa ) {

    Map<String, Object> mapParams = new HashMap<>();

    StringBuilder sb = new StringBuilder();

    sb.append( " SELECT p FROM Pessoa p LEFT JOIN p.lstTelefone lstT WHERE " );

    if ( pessoa.getNome() != null && !pessoa.getNome().isEmpty() ) {
      sb.append( " UPPER(p.nome) LIKE :nome AND " );
      mapParams.put( "nome", "%" + pessoa.getNome().toUpperCase() + "%" );
    }

    if ( pessoa.getCpf() != null && !pessoa.getCpf().isEmpty() ) {
      sb.append( " p.cpf LIKE :cpf AND " );
      mapParams.put( "cpf", "%" + pessoa.getCpf() + "%" );
    }

    Util.removeAndOuWhereStamentSql( sb );

    Query query = this.entityManager.createQuery( sb.toString() );

    Util.setarParametroWhere( mapParams, query );

    return query.getResultList();
  }

}
