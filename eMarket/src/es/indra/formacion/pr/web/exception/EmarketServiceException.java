package es.indra.formacion.pr.web.exception;

@SuppressWarnings("serial")
public class EmarketServiceException extends EmarketException {

	public EmarketServiceException() { }

	public EmarketServiceException(String msg, Throwable e) {
		super(msg, e);
	}
}
