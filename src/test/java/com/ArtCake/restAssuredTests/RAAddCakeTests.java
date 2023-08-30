//package com.ArtCake.restAssuredTests;
//
//import com.ArtCake.dto.CakeDto;
//import io.restassured.http.ContentType;
//import org.testng.annotations.Test;
//import static io.restassured.RestAssured.given;
//
//public class RAAddCakeTests extends TestBase{
//
//    @Test
//    public void addNewContactSuccessTest(){
//        CakeDto contactDto = CakeDto.builder().name("Lara")
//                .lastName("Carlson")
//                .email("carlson42323@gmail.com")
//                .phone("0123456789")
//                .address("Berlin 123")
//                .description("My friend")
//                .build();
//
//        String message = given().contentType(ContentType.JSON)
//                .header("Authorization", TOKEN)
//                .body(contactDto)
//                .when()
//                .post("contacts")
//                .then()
//                .assertThat().statusCode(200)
//                .extract().path("message");
//
//        System.out.println(message);
//    }
//}
//
// cb8618c5-ce8a-4b16-bb91-6ef5b02dbe4f