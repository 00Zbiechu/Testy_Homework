package pl.testy.zadanie.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.testy.zadanie.MessageCollector;
import pl.testy.zadanie.exception.ValidationException;
import pl.testy.zadanie.model.PersonDTO;

import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class PersonValidatorTest {

    private PersonValidator personValidator;
    private MessageCollector messageCollector;


    @BeforeEach
    public void initialize(){
        personValidator = new PersonValidator();
        messageCollector = new MessageCollector();
    }


    private static String getShortString(){
        return "A";
    }

    private static String getLongString(){
        byte[] array = new byte[1000]; // length is bounded by 1000, long length String
        new Random().nextBytes(array);
        return new String(array, StandardCharsets.UTF_8);
    }

    @Test
    @DisplayName("Validation personDTO with Error should return exception with message")
    public void validateTest1(){
        //given
        PersonDTO personDTO = new PersonDTO(1L,"TEST","TEST",null);

        //when
        Throwable exception = assertThrows(ValidationException.class,
                () -> personValidator.validate(personDTO,messageCollector,true));

        //then
        assertEquals("PersonDTO.age is null",exception.getMessage());


    }



    @ParameterizedTest(name = "Validate personDTO = {0} should has Errors = {1}")
    @MethodSource("getValidateTestArguments")
    public void validateTest2(PersonDTO personDTO, boolean hasErrors) {

        //when
        personValidator.validate(personDTO, messageCollector, false);

        //then
        Assertions.assertEquals(hasErrors,messageCollector.hasErrors());


    }



    public static Stream<Arguments> getValidateTestArguments(){
        return Stream.of(
                Arguments.of(new PersonDTO(),true), //null personDTO - has Error

                Arguments.of(new PersonDTO(1L,getShortString(),"Test",19),true),//too short name - has Error
                Arguments.of(new PersonDTO(1L,"Test",getShortString(),19),true), //too short lastName - has Error

                Arguments.of(new PersonDTO(1L,getLongString(),"Test",19),true),//too long name - has Error
                Arguments.of(new PersonDTO(1L,"Test",getLongString(),19),true), //too long lastName - has Error

                Arguments.of(new PersonDTO(1L,"Test","Test",12),true), //too young - has Error

                Arguments.of(new PersonDTO(1L,"Test","Test",19),false) //OK - without Errors
        );
    }






}