package br.com.ses.pessoa.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.ses.contato.modelo.Telefone;

@Entity
public class Pessoa implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 6169971515892350499L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_pessoa")
  private Long id;

  private String nome;

  private String email;

  private String cpf;

  @Temporal(TemporalType.DATE)
  @Column(name = "dt_nascimento")
  private Date dtNascimento;

  @JsonIgnoreProperties("pessoa")
  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY, mappedBy = "pessoa")
  private List<Telefone> lstTelefones;

  public Long getId() {
    return id;
  }

  public void setId( Long id ) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome( String nome ) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail( String email ) {
    this.email = email;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf( String cpf ) {
    this.cpf = cpf;
  }

  public Date getDtNascimento() {
    return dtNascimento;
  }

  public void setDtNascimento( Date dtNascimento ) {
    this.dtNascimento = dtNascimento;
  }

  public List<Telefone> getLstTelefones() {
    return lstTelefones;
  }

  public void setLstTelefones( List<Telefone> lstTelefone ) {
    this.lstTelefones = lstTelefone;
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
    Pessoa other = (Pessoa) obj;
    if ( id == null ) {
      if ( other.id != null )
        return false;
    } else if ( !id.equals( other.id ) )
      return false;
    return true;
  }

}
