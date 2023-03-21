package pl.testy.zadanie.exception;

import pl.testy.zadanie.MessageCollector;

public class ValidationException extends RuntimeException {

	public ValidationException(MessageCollector messageCollector) {
		super(messageCollector.buildMessage());
	}
}
