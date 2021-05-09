package Environment;


public class GlobalVariables {
    private static final String USER = "RandSage";
    private static final String PASSWORD = "RandSagePWD";
    private static final String NAME = "Sage";
    private static final String COUNTRY = "Spain";
    private static final String CITY = "Sant Cugat";
    private static final String CREDIT_CARD = "123456789";
    private static final String MONTH = "06";
    private static final String YEAR = "2022";


    public String getName() {
        return NAME;
    }

    public String getCountry() {
        return COUNTRY;
    }

    public String getCity() {
        return CITY;
    }

    public String getCreditCard() {
        return CREDIT_CARD;
    }

    public String getMonth() {
        return MONTH;
    }

    public String getYear() {
        return YEAR;
    }


    public String getUser() {
        return USER + String.valueOf(System.currentTimeMillis());
    }

    public String getPassword() {
        return PASSWORD + String.valueOf(System.currentTimeMillis());
    }

}
