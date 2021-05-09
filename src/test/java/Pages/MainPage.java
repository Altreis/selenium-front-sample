package Pages;

import Base.BaseStep;
import Environment.GlobalVariables;
import Xpath.Xpaths;

public class  MainPage {

    private BaseStep baseStep = new BaseStep();
    private GlobalVariables globalVariables = new GlobalVariables();
    private Xpaths xpaths = new Xpaths();

    private String userName;
    private String password;

    private String scp = xpaths.getScp();

    public void openSite(){
        baseStep.geturl();
    }

    public void createUser() throws Exception {
        userName = globalVariables.getUser();
        password = globalVariables.getPassword();
        baseStep.newUser(userName, password);
    }

    public void logIn() throws Exception {
        baseStep.logInUser(userName, password);
    }

    public void addMobile() throws Exception {
        baseStep.addToCart("HTCOne9", "PhoneCategory");
    }

    public void addComputer() throws Exception {
        baseStep.addToCart("MacBookAir", "LaptopCategory");
    }

    public void addScreen() throws Exception {
        baseStep.addToCart("AsusFullHD", "ScreenCategory");
    }

    public void deleteMobile() throws Exception {
        baseStep.deleteFromCart("HTC One M9");
    }

    public void makeOrder() throws Exception {
        baseStep.clickElement("PlaceOrderButton", scp);
        baseStep.fillElement("NameOrder", scp, globalVariables.getName());
        baseStep.fillElement("CountryOrder", scp, globalVariables.getCountry());
        baseStep.fillElement("CityOrder", scp, globalVariables.getCity());
        baseStep.fillElement("CreditCardOrder", scp, globalVariables.getCreditCard());
        baseStep.fillElement("MonthOrder", scp, globalVariables.getMonth());
        baseStep.fillElement("YearOrder", scp, globalVariables.getYear());
        baseStep.clickElement("PurchaseButton", scp);
    }

    public void checkName() throws Exception {
        baseStep.checkName();
    }

    public void checkAmount(String amount) throws Exception {
        baseStep.checkAmount(amount);
    }

}
