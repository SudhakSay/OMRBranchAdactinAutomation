@SelectHotel
Feature: Verifying Adactin Select Hotel Page Details

  Scenario Outline: Verifying Adactin Select Hotel page By Select Hotel from Available Options
    Given User is on the adactin hotel login page
    When User should perform login "<username>","<password>"
    Then User should verify Welcome Page after login "Hello SudhakSay!"
    And User Should Perform The Search Hotel  "<location>","<hotels>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childrenPerRoom>"
    Then User Should Verify the select hotel title "Select Hotel" in select hotel page after perform Search Hotel
    And User should perform Select Hotel Page by Select Hotel from Available options
    Then User should Verify Booking Hotel Page Title "Book A Hotel" after Perform Select Hotel Page

    Examples: 
      | username  | password   | location | hotels      | roomType | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom |
      | SudhakSay | theriyathu | Sydney   | Hotel Creek | Standard |         2 | 21/08/2022  | 24/08/2022   |             2 |               1 |

  Scenario Outline: Verifying Adactin Select Hotel Page without Select any Hotels
    Given User is on the adactin hotel login page
    When User should perform login "<username>","<password>"
    Then User should verify Welcome Page after login "Hello SudhakSay!"
    And User Should Perform The Search Hotel  "<location>","<hotels>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childrenPerRoom>"
    Then User Should Verify the select hotel title "Select Hotel" in select hotel page after perform Search Hotel
    And User should perform Select Hotel Page without Select Any Hotel
    Then User should Verify the error message "Please Select a Hotel" in Select Hotel page after perform Select Hotel without Select any Hotels

    Examples: 
      | username  | password   | location | hotels      | roomType | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom |
      | SudhakSay | theriyathu | Sydney   | Hotel Creek | Standard |         2 | 21/08/2022  | 24/08/2022   |             2 |               1 |
