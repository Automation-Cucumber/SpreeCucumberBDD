Feature: Spree Shopping Application Test

Background: User is Logged In
Given User navigates to Spree Url in the browser.
When  User clicks Login in the HomePage.
Then  Login Page is opened.
And   User enter emailid/password details and press submit.
Then  User able to login 

Scenario: Verify that shopping items are present in Shop by Categories
When User clicks Home
Then Shop by Categories gets displayed
|Bags|
|Mugs|
|Clothing|

#Scenario: Verify that the name of the item selected in Shop by Brands matches with list of item getting populated.
#When User clicks items in Shop By Brands
#|Ruby|
#|Apache|
#|Spree|
#|Rails|
#Then List of items which user clicked get displayed under the header which has the same item name.
#|Ruby|
#|Apache|
#|Spree|
#|Rails|
#And Each item has the name that user clicked.

#Scenario: Verify that if Price Range is selected for any of items in Shop By Brands then list of items with 
#the same name is displayed.
#When User clicks items in Shop By Brands
#|Ruby|
#|Apache|
#|Spree|
#|Rails|
#Then List of items which have the name same as user selected gets displayed.

 