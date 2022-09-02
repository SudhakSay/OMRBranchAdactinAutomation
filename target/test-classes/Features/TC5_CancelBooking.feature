@CancelBooking
Feature: Verifying Adactin Cancel Booking Hotel Page Details

  @CancelId
  Scenario Outline: Verifying Adactin Cancelling Booking OrderID
    Given User is on the adactin hotel login page
    When User should perform login "<username>","<password>"
    Then User should verify Welcome Page after login "Hello SudhakSay!"
    And User Should Perform The Search Hotel  "<location>","<hotels>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childrenPerRoom>"
    Then User Should Verify the select hotel title "Select Hotel" in select hotel page after perform Search Hotel
    And User should perform Select Hotel Page by Select Hotel from Available options
    Then User should Verify Booking Hotel Page Title "Book A Hotel" after Perform Select Hotel Page
    And User should Enter All Fields "<firstName>","<lastName>","<address>"
      | cardNo           | cardType | expiryMonth | expiryYear | ccvNo |
      | 1234567890123456 | AMEX     | February    |       2022 |  4321 |
      | 0987654321654321 | VISA     | July        |       2022 |  1234 |
      | 6543211234567890 | MAST     | August      |       2022 |  0987 |
      | 1234561234567890 | AMEX     | September   |       2022 |  7890 |
    Then User Verify Booking Conformation Title "Booking Confirmation" in Booking Conformation Page after perform Book Hotel
    And User should navigates to Booked Itinerary Page and perform Cancel Booking OrderId
    And User should Verify Cancel Message after Cancel "The booking has been cancelled."

    Examples: 
      | username  | password   | location | hotels      | roomType | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom | firstName | lastName | address                |
      | SudhakSay | theriyathu | Sydney   | Hotel Creek | Standard |         2 | 21/08/2022  | 24/08/2022   |             2 |               1 | Kadhir    | Avan     | AshokNager, Chennai-03 |

  Scenario Outline: Verifying Adactin Cancelling Existing OrderID
    Given User is on the adactin hotel login page
    When User should perform login "<username>","<password>"
    Then User should verify Welcome Page after login "Hello SudhakSay!"
    And User should navigates to Booked Itinerary Page and Cancel Existing OrderId "<orderId>"
    And User should Verify Booking Cancel Message "The booking has been cancelled."

    Examples: 
      | username  | password   | orderId    |
      | SudhakSay | theriyathu | 7TVD3XGH71 |
