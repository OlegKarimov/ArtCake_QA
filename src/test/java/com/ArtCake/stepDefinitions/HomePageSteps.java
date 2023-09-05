//package com.ArtCake.stepDefinitions;
//
//import com.ArtCakeSelenium.pages.HomePage;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//import static com.ArtCakeSelenium.pages.BasePage.driver;
//
//public class HomePageSteps {
//    @Given("User launches browser")
//    public void launch_browser(){
//        new HomePage(driver).launchBrowser();
//    }
//    @When("User opens ilCarro Home Page")
//    public void open_ilCarro_HomePage(){
//        new HomePage(driver).openUrl();
//    }
//    @Then("User verify Home Page title")
//    public void verify_HomePage_title(){
//        new HomePage(driver).isHomePageTitlePresent();
//    }
//    @And("User quits browser")
//    public void quit_browser(){
//        new HomePage(driver).quit();
//    }
//}
