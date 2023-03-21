package pl.testy.zadanie.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;


class PersonValidatorTest {

    private PersonValidator personValidator;


    @BeforeEach
    public void initialize(){
        personValidator = new PersonValidator();
    }


    @Test
    public void validateFirstNameTest(){

    }

    public static Stream<Arguments> getValidateFirstNameTestArguments(){

    }




}