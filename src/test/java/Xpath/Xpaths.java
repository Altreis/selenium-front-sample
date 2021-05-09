package Xpath;

import java.util.HashMap;
import java.util.Map;

public class Xpaths {
    private static final  String MP = "MP";
    private static final  String PP = "PP";
    private static final  String SCP = "SCP";

    //MP list
    private Map<String, String> mainPage = new HashMap<String, String>() {{
        put("HomeButton", "/html/body/nav/div/div/ul/li[1]/a");
        put("Cart", "//*[@id=\"navbarExample\"]/ul/li[4]/a");

        put("SignUpButton", "//*[@id=\"signin2\"]");
        put("SignUpUsername", "//*[@id=\"sign-username\"]");
        put("SignUpPassword","//*[@id=\"sign-password\"]");
        put("SignUpAccept","//*[@id=\"signInModal\"]/div/div/div[3]/button[2]");

        put("LogInButton","//*[@id=\"login2\"]");
        put("LogInUsername","//*[@id=\"loginusername\"]");
        put("LogInPassword","//*[@id=\"loginpassword\"]");
        put("LogInpAccept","//*[@id=\"logInModal\"]/div/div/div[3]/button[2]");

        put("PhoneCategory","/html/body/div[5]/div/div[1]/div/a[2]");
        put("LaptopCategory","/html/body/div[5]/div/div[1]/div/a[3]");
        put("ScreenCategory","/html/body/div[5]/div/div[1]/div/a[4]");

        put("HTCOne9","//*[@id=\"tbodyid\"]/div[7]/div/div/h4/a");
        put("MacBookAir","//*[@id=\"tbodyid\"]/div[3]/div/div/h4/a");
        put("AsusFullHD","//*[@id=\"tbodyid\"]/div[2]/div/div/h4/a");
    }};


    //PP list
    private Map<String, String> productPage = new HashMap<String, String>() {{
        put("AddToCart", "//*[@id=\"tbodyid\"]/div[2]/div/a");
    }};

    //SCP list
    private Map<String, String> shooppingCartPage = new HashMap<String, String>() {{
        put("DeleteButton","//*[contains(text(),'---')]/parent::*/td[4]/a");
        put("PurchaseButton","//*[@id=\"orderModal\"]/div/div/div[3]/button[2]");
        put("PlaceOrderButton","//*[@id=\"page-wrapper\"]/div/div[2]/button");

        put("NameOrder","/html/body/div[3]/div/div/div[2]/form/div[1]/input");
        put("CountryOrder","/html/body/div[3]/div/div/div[2]/form/div[2]/input");
        put("CityOrder","/html/body/div[3]/div/div/div[2]/form/div[3]/input");
        put("CreditCardOrder","/html/body/div[3]/div/div/div[2]/form/div[4]/input");
        put("MonthOrder","/html/body/div[3]/div/div/div[2]/form/div[5]/input");
        put("YearOrder","/html/body/div[3]/div/div/div[2]/form/div[6]/input");

        put("AmountText","//*[text()[contains(.,'Amount: --- USD')]]");
        put("Name","//*[text()[contains(.,'Name: ---')]]");
    }};

    public String getShoppingCartPage(String key) throws Exception {
        if (shooppingCartPage.containsKey(key)) return shooppingCartPage.get(key);
        else throw  new Exception("The key '" + key + "' doesn't exists on the Shopping Cart Page Xpaths list.");
    }

    public void setAmountText(String value) throws Exception {
        shooppingCartPage.put("AmountText",shooppingCartPage.get("AmountText").replace("---" , value));
    }

    public void setDeleteButton(String value) throws Exception {
        shooppingCartPage.put("DeleteButton",shooppingCartPage.get("DeleteButton").replace("---" , value));
    }

    public void setNameText(String value) throws Exception {
        shooppingCartPage.put("Name",shooppingCartPage.get("Name").replace("---" , value));
    }

    public String getMainPage(String key) throws Exception {
        if (mainPage.containsKey(key)) return mainPage.get(key);
        else throw  new Exception("The key '" + key + "' doesn't exists on the Main Page Xpaths list.");
    }

    public String getProductPage(String key) throws Exception {
        if (productPage.containsKey(key)) return productPage.get(key);
        else throw  new Exception("The key '" + key + "' doesn't exists on the Product Page Xpaths list.");
    }

    public static String getMp() {
        return MP;
    }

    public static String getPp() {
        return PP;
    }

    public static String getScp() {
        return SCP;
    }

}
