Feature: User Registration Action
Background:
Given User is on Home Page
@tag4 @Regression @tag5
Scenario: Successfull Web user registration
When User clicks on registration button
Then User Navigates to Registration page
When User Enters First Name, Last Name
And user enters EMail address and Password
And user click on Next
Then User will be navigated to Identify your sce account page