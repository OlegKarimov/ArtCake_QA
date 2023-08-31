//package com.ArtCake.restAssuredTests;
//
//import com.ArtCake.dto.CakeDto;
//import io.restassured.http.ContentType;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import static io.restassured.RestAssured.given;
//import static org.hamcrest.Matchers.containsString;
//import static org.hamcrest.Matchers.equalTo;
//
//public class RADeleteCakeTests extends TestBase{
//    String id;
//
//    @BeforeMethod
//    public void preCondition(){
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
//                .extract().path("message");
//
//        String[] all = message.split(": ");
//        id = all[1];
//    }
//
//    @Test
//    public void deleteContactByIdSuccessTest(){
//        given().header("Authorization", TOKEN)
//                .when().delete("contacts/" + id)
//                .then().assertThat().statusCode(200)
//                .assertThat().body("message",equalTo("Contact was deleted!"));
//    }
//
//
//@Test
//    public void deleteContactByIdWithWorngTockenTest401(){
//    given().header("Authorization", "e2dsdwsdwe2323")
//            .when()
//            .delete("contacts/" + id)
//            .then()
//            .assertThat()
//            .statusCode(401)
//            .assertThat().body("message",containsString("JWT strings must contain exactly 2"));
//}
//
//@Test
//    public void deleteContactByIdWithWrongIdTest400(){
//     given().header("Authorization", TOKEN)
//            .when()
//            .delete("contacts/3232323")
//            .then()
//            .assertThat().statusCode(400)
//             .assertThat().body("message",containsString("not found in your contacts!"));
//}
//}
