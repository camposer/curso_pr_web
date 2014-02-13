package es.indra.formacion.pr.web.exception;

@SuppressWarnings("serial")
public abstract class EmarketException extends Exception {
	public EmarketException() {}
	
	public EmarketException(String msg, Throwable e) {
		super(msg, e);
	}
}
