Feature: Testing Add to Cart Functionality

Background: User is logged in

    Given User is on logged page

    When User enter credentials and clicks login button

    Then user is logged in
@tag1
Scenario: Add a product to cart 

    Given User is on logged  in and on product page

    When user enters clicks on add to cart button of a product

    Then product is added to cart

    And clicks the cart button

    Then product is displayed on cart
@tag2
Scenario: Add multiple product to cart 

	Given User is on logged  in and on product page

    When user enters clicks on add to cart button of a multiple product

    Then product is added to cart and count is displayed
