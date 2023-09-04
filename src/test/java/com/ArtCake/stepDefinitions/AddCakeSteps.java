//package com.ArtCake.stepDefinitions;
//
//
//import com.ArtCakeSelenium.pages.CakePage;
//import com.ArtCakeSelenium.pages.HomePage;
//import com.ArtCakeSelenium.pages.LoginPage;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Then;
//
//
//import java.util.Random;
//
//import static com.ArtCakeSelenium.pages.BasePage.driver;
//
//
//public class AddCakeSteps {
//
//    @And(value="User clicks on Ok")
//    public void click_on_Ok(){
//        new LoginPage(driver).clickOnOk();
//    }
//
//    @And("User clicks on Let the car work link")
//    public void click_on_the_car_work_link(){
//        new HomePage(driver).clickOnLetCarLink();
//    }
//
//    @And("User enters valid data to add car")
//    public void enter_valid_data_to_add_car(){
//        int i = new Random().nextInt(1000)+1000;
//        new CakePage(driver).enterCarData("BMW","M5","2020","Diesel","3","C","899654","100","Buy new my car how over new");
//    }
//
//    @And("User upload Photo")
//    public void upload_Photo(){
//        new CakePage(driver).uploadPhoto("C:/Users/saino/Downloads/1.png");
//    }
//
//    @And("User clicks submit button")
//    public void click_submit_button(){
//        new CakePage(driver).clickOnSubmit();
//    }
//
//    @Then("User veirfy Add car message")
//    public void verify_Add_car_message(){
//        new CakePage(driver).assertAddCar();
//    }
//}
