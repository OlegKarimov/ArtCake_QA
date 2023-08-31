//package com.ArtCake.restAssuredTests;
//
//import com.ArtCake.dto.CakeDto;
//import com.ArtCake.dto.GetAllCakesDto;
//import org.testng.annotations.Test;
//
//import java.util.List;
//
//import static io.restassured.RestAssured.given;
//
//public class RAGetAllCakesTests extends TestBase{
//    @Test
//    public void getAllContactsSuccessTests(){
//        GetAllCakesDto contactsDto = given().header("Authorization", TOKEN)
//                .when()
//                .get("contacts")
//                .then().assertThat().statusCode(200)
//                .extract().response().as(GetAllCakesDto.class);
//
//        List<CakeDto> list = contactsDto.getContacts();
//        for (CakeDto contact: list) {
//            System.out.println(contact.getId());
//            System.out.println(contact.getLastName());
//            System.out.println("Size of list: "+list.size());
//        }
//
//    }
//}
