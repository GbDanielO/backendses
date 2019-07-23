package br.com.ses.exceptionHandler;

public class EntidadeNaoEncontradaException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 7076482572781093440L;

    public EntidadeNaoEncontradaException() {
    }

    public EntidadeNaoEncontradaException( String message ) {
        super( message );
    }

}
