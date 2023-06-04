@Test
Feature: Coding Test
  Scenario Outline: User should be able to search for SecurePay and attempt to sign up for POLi
    Given The user navigate to google page
    Then The user search for SecurePay
    And The user click and navigates to SecurePay
    And Navigate to Standard Pricing page
    Then Verify if the user is on Standard Pricing page
    When The User clicks on Learn more button under POLi
    Then Verify if POLi is opened & loaded in a new window
    When The user click on Sign up now button
    And User selects POLi signup for an Australian online business
    Then The User fill details about the company with <ABN> and <state> and <industry> and <shopping cart> and <company website>
    And User click on the second section
    And Fills payment details with <account name> and <BSB>
    Then Verify account details are populated correctly with <bank name> and <BSB>

    Examples:
    | ABN         | state     | industry  | shopping cart | company website   | account name  | BSB     | bank name   |
    | 51824753556 | Victoria  | Travel    | Shopify       | www.google.com.au | Test test     | 013664  | ANZ         |

