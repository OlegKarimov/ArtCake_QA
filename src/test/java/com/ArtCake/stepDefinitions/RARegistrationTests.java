package com.ArtCake.stepDefinitions;


import com.ArtCake.dto.RegistrationRequestDto;
import com.ArtCake.dto.RegistrationResponseDto;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class RARegistrationTests {
    @BeforeMethod

    public void precondition() {
        RestAssured.baseURI = "http://localhost:8080";

    }

    @Test
    public void registrationSuccessTest() {
        RegistrationRequestDto login = RegistrationRequestDto.builder()
                .fullName("ark Smith")
                .email("arke@mail.com")
                .password("Qwerty123!")
                .town("Berlin")
                .street("Sonnenallee")
                .houseNumber(17)
                .phoneNumber("+4917612930456")
                .build();

        RegistrationResponseDto responseDto = given()
                .contentType(ContentType.JSON)
                .body(login)
                .when()
                .post("api/registration")
                .then()
                .assertThat().statusCode(201)
               .extract().response().as(RegistrationResponseDto.class);
        System.out.println(responseDto.getRole());


    }
    @Test
    public void registrationWithWrongFormatEmailTest(){
        RegistrationRequestDto auth = RegistrationRequestDto.builder()
                .fullName("ark Smith")
                .email("arkemail.com")
                .password("Qwerty123!")
                .town(" Berlin")
                .street("Sonnenallee")
                .houseNumber(17)
                .phoneNumber("+4917612930456")
                .build();

        given()
                .contentType(ContentType.JSON)
                .body(auth)
                .when()
                .post("api/registration")
                .then()
                .assertThat().statusCode(400);


    }
}
