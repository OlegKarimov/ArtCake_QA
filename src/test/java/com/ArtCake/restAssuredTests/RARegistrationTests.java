package com.ArtCake.restAssuredTests;

import com.ArtCake.dto.RegistrationRequestDto;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.Date;

import static io.restassured.RestAssured.given;

public class RARegistrationTests extends TestBase{

    @Test
    public void registrationSuccessTest() {
        String uniqueEmail = "user" + new Date().getTime() + "@example.com"; // Генерируем уникальный email с помощью временной метки

        RegistrationRequestDto registrationRequest = RegistrationRequestDto.builder()
                .firstName("Lorry")
                .lastName("Jackson")
                .email(uniqueEmail)
                .password("Qwerty123!")
                .town("Berlin")
                .zipCode("22331")
                .street("Sonnenallee")
                .houseNumber(17)
                .phoneNumber("+4917612930456")
                .build();

        given()
                .contentType(ContentType.JSON)
                .body(registrationRequest)
                .when()
                .post("/api/registration")
                .then()
                .assertThat().statusCode(201)
                .extract().response().prettyPrint();
    }
    @Test
    public void registrationWithWrongFormatEmailTest(){
        RegistrationRequestDto auth = RegistrationRequestDto.builder()
                .firstName("Lor")
                .lastName("Jackson")
                .email("arkemail.com")
                .password("Qwerty123!")
                .town(" Berlin")
                .zipCode("22331")
                .street("Sonnenallee")
                .houseNumber(17)
                .phoneNumber("+4917612930456")
                .build();

        given()
                .contentType(ContentType.JSON)
                .body(auth)
                .when()
                .post("/api/registration")
                .then()
                .assertThat().statusCode(400)
                .extract().response().prettyPrint();
    }
}