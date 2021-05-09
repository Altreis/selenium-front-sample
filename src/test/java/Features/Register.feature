Feature: Testing Demozable webpage
@register
  Scenario: User registers on the website and select some devices to purchase
    Given A web browser is at Demozable home page
      And The user registers on the site
      And The users does the loggin
    When The users adds a mobile device to the basket
      And Adds a laptop to the basket
      And Adds a screen to the basket
      And the mobile devices is deleted from the basket
    Then The users makes the order
      And The name is correct
      And The price of the order is for "930"$
