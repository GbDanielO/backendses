package br.com.ses.contato.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.ses.pessoa.modelo.Pessoa;

@Entity
public class Telefone implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -1732652956855817673L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_telefone")
  private Long id;

  private String ddd;

  private String numero;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_pessoa")
  private Pessoa pessoa;

  public Long getId() {
    return this.id;
  }

  public void setId( Long id ) {
    this.id = id;
  }

  public String getDdd() {
    return this.ddd;
  }

  public void setDdd( String ddd ) {
    this.ddd = ddd;
  }

  public String getNumero() {
    return this.numero;
  }

  public void setNumero( String numero ) {
    this.numero = numero;
  }

  public Pessoa getPessoa() {
    return pessoa;
  }

  public void setPessoa( Pessoa pessoa ) {
    this.pessoa = pessoa;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ( ( id == null ) ? 0 : id.hashCode() );
    return result;
  }

  @Override
  public boolean equals( Object obj ) {
    if ( this == obj )
      return true;
    if ( obj == null )
      return false;
    if ( getClass() != obj.getClass() )
      return false;
    Telefone other = (Telefone) obj;
    if ( id == null ) {
      if ( other.id != null )
        return false;
    } else if ( !id.equals( other.id ) )
      return false;
    return true;
  }

}
