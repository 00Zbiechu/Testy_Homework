package pl.testy.zadanie.validator;


import pl.testy.zadanie.MessageCollector;
import pl.testy.zadanie.model.PersonDTO;

public class PersonValidator {

	public void validate(PersonDTO personDTO, MessageCollector messageCollector, boolean throwIfError){
		validateFirstName(personDTO, messageCollector);
		validateLastName(personDTO, messageCollector);
		validateAge(personDTO, messageCollector);

		if(throwIfError && messageCollector.hasErrors()){
			throw new ValidationException(messageCollector);
		}
	}

	private void validateFirstName(PersonDTO personDTO, MessageCollector messageCollector) {
		if(personDTO.getFirstName().length() > 100){
			messageCollector.addError("PersonDTO.firstName field value too long");
		}

		if(personDTO.getFirstName().length() < 2){
			messageCollector.addError("PersonDTO.firstName field value too short");
		}
	}

	private void validateLastName(PersonDTO personDTO, MessageCollector messageCollector) {
		if(personDTO.getFirstName().length() > 200){
			messageCollector.addError("PersonDTO.lastName field value too long");
		}

		if(personDTO.getFirstName().length() < 2){
			messageCollector.addError("PersonDTO.lastName field value too short");
		}
	}

	private void validateAge(PersonDTO personDTO, MessageCollector messageCollector) {
		if(personDTO.getAge() < 18){
			messageCollector.addError("PersonDTO.age field value must be greater or equal 18");
		}
	}
}
