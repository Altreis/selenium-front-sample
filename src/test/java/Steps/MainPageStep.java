package Steps;

import Pages.MainPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class MainPageStep {

    public MainPage mainPage = new MainPage();

    @Given("^A web browser is at Demozable home page$")
    public void a_web_browser_is_at_Demozable_home_page() throws Throwable {
        mainPage.openSite();
    }

    @Given("^The user registers on the site$")
    public void the_user_registers_on_the_site() throws Throwable {
        mainPage.createUser();
    }

    @Given("^The users does the loggin$")
    public void the_users_does_the_loggin() throws Throwable {
        mainPage.logIn();
    }

    @When("^The users adds a mobile device to the basket$")
    public void the_users_adds_a_mobile_device_to_the_basket() throws Throwable {
        mainPage.addMobile();
    }

    @When("^Adds a laptop to the basket$")
    public void adds_a_laptop_to_the_basket() throws Throwable {
        mainPage.addComputer();
    }

    @When("^Adds a screen to the basket$")
    public void adds_a_screen_to_the_basket() throws Throwable {
        mainPage.addScreen();
    }

    @When("^the mobile devices is deleted from the basket$")
    public void the_mobile_devices_is_deleted_from_the_basket() throws Throwable {
        mainPage.deleteMobile();
    }

    @Then("^The users makes the order$")
    public void the_users_makes_the_order() throws Throwable {
        mainPage.makeOrder();
    }

    @Then("^The name is correct$")
    public void the_name_is_correct() throws Throwable {
        mainPage.checkName();
    }

    @Then("^The price of the order is for \"([^\"]*)\"\\$$")
    public void the_price_of_the_order_is_for_$(String arg1) throws Throwable {
        mainPage.checkAmount(arg1);
    }

}
