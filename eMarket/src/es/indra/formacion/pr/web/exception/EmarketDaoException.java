package es.indra.formacion.pr.web.exception;

@SuppressWarnings("serial")
public class EmarketDaoException extends EmarketException {
	public EmarketDaoException() { }
	
	public EmarketDaoException(String msg, Throwable e) {
		super(msg, e);
	}
}
