package pl.testy.zadanie.controller;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpUriRequest;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ExampleControllerTest {

    @Test
    @DisplayName("getName method should return httpStatus = 200")
    public void getNameStatusTest() throws IOException {

        //given
        HttpUriRequest request = new HttpGet("http://localhost:8080/api/test");


        //when
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );

        // Then
        assertEquals(HttpStatus.SC_OK,httpResponse.getCode());

    }

}