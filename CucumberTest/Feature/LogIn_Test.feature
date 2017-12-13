Feature: Login Action
Background:
Given User is on Home Page
 @tag1 @tag3 @tag4
Scenario: Successful Login Web user with Valid Credentials
#	Given User is on Home Page
	When User enters "UserName" and "Password" for "Test_ID_001"
	Then User Navigated to Overview Page
#	When User click on Logout from Sce portal
#	Then User is logged out of sce portal 
#	Then Browser is closed
 @tag2 @tag3 
Scenario: Successful Login MyAccount user with Valid Credentials
#	Given User is on Home Page
	When User enters "UserName" and "Password" for "Test_ID_002"
	Then User Navigated to My Account Page
#	When User click on Logout from Sce portal
#	Then User is logged out of sce portal 
#	Then Browser is closed
@tag2
Scenario: Un successful User login with Invalid Credentials
#	Given User is on Home Page
	When User enters "UserName" and "Password" for "Test_ID_003"
	Then Error message displayed
#	When User click on Logout from Sce portal
#	Then User is logged out of sce portal 
#	Then Browser is closed
	
 @tag2
Scenario: Successful Login Third Party user with completed Verification with Valid Credentials
#	Given User is on Home Page
	When User enters "UserName" and "Password" for "Test_ID_004"
	Then User Navigated to Third Party Page
#	When User click on Logout from Sce portal
#	Then User is logged out of sce portal 
#	Then Browser is closed

   @tag2
Scenario: Successful Login Third Party user without completed Verification with Valid Credentials
#	Given User is on Home Page
	When User enters "UserName" and "Password" for "Test_ID_005"
	Then User Navigated to Third Party Page	
#	When User click on Logout from Sce portal
#	Then User is logged out of sce portal 
#	Then Browser is closed
	
 @tag2
Scenario: Successful Login EA sub User with Valid Credentials
#	Given User is on Home Page
	When User enters "UserName" and "Password" for "Test_ID_006"
	Then User Navigated to Third Party Page	
#	When User click on Logout from Sce portal
#	Then User is logged out of sce portal 
#	Then Browser is closed
	
@tag2
Scenario: Successful Login ELMS with completed Verification user with Valid Credentials
#	Given User is on Home Page
	When User enters "UserName" and "Password" for "Test_ID_007"
	Then User Navigated to Third Party Page	
#	When User click on Logout from Sce portal
#	Then User is logged out of sce portal 
#	Then Browser is closed

@tag2
Scenario: Successful Login MHP with completed Verification user with Valid Credentials
#	Given User is on Home Page
	When User enters "UserName" and "Password" for "Test_ID_008"
	Then User Navigated to Third Party Page	
#	When User click on Logout from Sce portal
#	Then User is logged out of sce portal 
#	Then Browser is closed
