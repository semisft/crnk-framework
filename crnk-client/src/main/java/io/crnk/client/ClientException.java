package io.crnk.client;

import io.crnk.core.engine.document.ErrorData;
import io.crnk.core.exception.CrnkMappableException;

/**
 * General client exception if no custom mapper is found.
 */
public class ClientException extends CrnkMappableException {

	private static final long serialVersionUID = 7455315058615968760L;

	private static final String TITLE = "Response error";

	public ClientException(int code, String message) {
		this(code, message, null);
	}

	public ClientException(int code, String message, Throwable cause) {
		super(code, ErrorData.builder()
				.setTitle(TITLE)
				.setDetail(message)
				.setStatus(String.valueOf(code))
				.build());
		if (cause != null) {
			initCause(cause);
		}
	}
}