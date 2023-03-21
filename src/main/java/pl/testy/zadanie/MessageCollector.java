package pl.testy.zadanie;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MessageCollector {
	private final List<String> messages;

	public MessageCollector() {
		this.messages = new ArrayList<>();
	}

	public void addError(String message){
		this.messages.add(message);
	}
	public boolean hasErrors(){
		return messages.size() > 0;
	}

	public String buildMessage(){
		return messages.stream().collect(Collectors.joining("\n"));
	}
}
