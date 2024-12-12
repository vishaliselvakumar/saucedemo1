Feature: Login Functionality

Scenario: Testing Login functionality with valid credentials
	Given user is on login page
	When user enters valid username and password
	And Clicks login button
	Then User is logged in and navigated to product page