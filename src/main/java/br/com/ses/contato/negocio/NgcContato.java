package br.com.ses.contato.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ses.contato.repository.ContatoRepository;

@Service
public class NgcContato {

  @Autowired
  private ContatoRepository contatoRepository;

  public void excluirTelefone( Long id ) {
    this.contatoRepository.deleteById( id );
  }
}
