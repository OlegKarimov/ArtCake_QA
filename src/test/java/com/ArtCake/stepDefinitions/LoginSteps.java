package com.ArtCake.stepDefinitions;

import com.ArtCakeSelenium.pages.HomePage;
import com.ArtCakeSelenium.pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static com.ArtCakeSelenium.pages.BasePage.driver;

public class LoginSteps {

    @And("User clicks on Log in Link")
    public void click_on_Login_Link(){
        new HomePage(driver).clickOnLoginLink();
    }
    @And("User enters valid data")
    public void enter_valid_data(){
        new LoginPage(driver).enterData("mail@mail.com","1234567Qwe$");
    }
    @And("User clicks on Yalla button")
    public void click_on_Yalla_Button(){
        new LoginPage(driver).clickOnYallaButton();
    }
    @Then("User veirfy Log in message")
    public void verify_login_message(){
        new LoginPage(driver).isLoginMessageDisplayed();
    }
    @And("User enters valid email and wrong password")
    public void enter_valid_email_and_wrong_password(DataTable table){
        new LoginPage(driver).enterWrongData(table);
    }
    @Then("User veirfies error")
    public void verify_error(){
        new LoginPage(driver).getError();
    }
}
