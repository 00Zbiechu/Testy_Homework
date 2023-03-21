package pl.testy.zadanie.validator;

import pl.testy.zadanie.MessageCollector;

public class ValidationException extends RuntimeException {

	public ValidationException(MessageCollector messageCollector) {
		super(messageCollector.buildMessage());
	}
}
