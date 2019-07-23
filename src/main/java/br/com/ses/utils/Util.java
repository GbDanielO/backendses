package br.com.ses.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.persistence.Query;
import javax.persistence.TemporalType;

public class Util {

  public static void setarParametroWhere( final Map<String, Object> mapWhere, final Query query ) {
    if ( mapWhere != null && !mapWhere.isEmpty() ) {
      final Set<String> lstParametros = mapWhere.keySet();

      if ( lstParametros != null && !lstParametros.isEmpty() ) {
        for ( final String parametro : lstParametros ) {
          final Object valorKey = mapWhere.get( parametro );

          if ( valorKey.getClass().equals( Date.class ) ) {
            query.setParameter( parametro, (Date) valorKey, TemporalType.DATE );
          } else {
            query.setParameter( parametro, valorKey );
          }
        }
      }
    }
  }

  public final static void removeAndOuWhereStamentSql( final StringBuilder stamentSql ) {
    // Remover o "WHERE" ou "AND".
    boolean endsWith = stamentSql.toString().trim().endsWith( "WHERE" );
    if ( endsWith ) {
      removeLastToken( stamentSql, "WHERE" );
    } else {
      endsWith = stamentSql.toString().trim().endsWith( "AND" );
      if ( endsWith ) {
        removeLastToken( stamentSql, "AND" );
      }
    }
  }

  public static void removeLastToken( final StringBuilder statement, final String token ) {

    final int posBegin = statement.lastIndexOf( token );

    if ( posBegin != -1 ) {
      final int posEnd = statement.length();

      statement.delete( posBegin, posEnd );
    }
  }

  public static String getDataFormatada( final Date date, final String mascara ) {
    if ( date != null ) {
      final SimpleDateFormat dateFormat = new SimpleDateFormat( mascara, new Locale( "pt", "BR" ) );

      return dateFormat.format( date );
    }
    return "";
  }

}
