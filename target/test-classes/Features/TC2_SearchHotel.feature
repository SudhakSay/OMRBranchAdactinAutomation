@SearchHotel
Feature: Verifying Adactin Search Hotel Page Details

  @Enterallfields
  Scenario Outline: Verifying Adactin Search Hotel By Entering All Fields
    Given User is on the adactin hotel login page
    When User should perform login "<username>","<password>"
    Then User should verify Welcome Page after login "Hello SudhakSay!"
    And User Should Perform The Search Hotel  "<location>","<hotels>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childrenPerRoom>"
    Then User Should Verify the select hotel title "Select Hotel" in select hotel page after perform Search Hotel

    Examples: 
      | username  | password   | location | hotels      | roomType | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom |
      | SudhakSay | theriyathu | Sydney   | Hotel Creek | Standard |         2 | 21/08/2022  | 24/08/2022   |             2 |               1 |

  Scenario Outline: Verifying Adactin Search Hotel By Entering Mandatory Fields
    Given User is on the adactin hotel login page
    When User should perform login "<username>","<password>"
    Then User should verify Welcome Page after login "Hello SudhakSay!"
    And User Should Perform The Search Hotel with Mandatory Fields "<location>","<noOfRooms>","<checkInDate>","<checkOutDate>" and "<adultsPerRoom>"
    Then User Should Verify the select hotel title "Select Hotel" in select hotel page after perform Search Hotel

    Examples: 
      | username  | password   | location | noOfRooms | checkInDate | checkOutDate | adultsPerRoom |
      | SudhakSay | theriyathu | Sydney   |         2 | 21/08/2022  | 24/08/2022   |             2 |

  Scenario Outline: Verifying Adactin Search Hotel By Entering Invalid CheckinDate and CheckOutDate Fields
    Given User is on the adactin hotel login page
    When User should perform login "<username>","<password>"
    Then User should verify Welcome Page after login "Hello SudhakSay!"
    And User Should Perform The Search Hotel  "<location>","<hotels>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childrenPerRoom>"
    Then User Should verify the date error message "Check-In Date shall be before than Check-Out Date" and "Check-Out Date shall be after than Check-In Date" in search hotel page after perform Search Hotel With Invalid Date

    Examples: 
      | username  | password   | location | hotels      | roomType | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom |
      | SudhakSay | theriyathu | Sydney   | Hotel Creek | Standard |         2 | 19/08/2025  | 20/08/2012   |             2 |               1 |

  Scenario Outline: Verifying Adactin Search Hotel Without Enter Values at Any Fields
    Given User is on the adactin hotel login page
    When User should perform login "<username>","<password>"
    Then User should verify Welcome Page after login "Hello SudhakSay!"
    And User Should search the hotel without enter values at any fields
    Then User should verify location error message "Please Select a Location" in search hotel page after perform Search Hotel without Enter any Fields

    Examples: 
      | username  | password   |
      | SudhakSay | theriyathu |
