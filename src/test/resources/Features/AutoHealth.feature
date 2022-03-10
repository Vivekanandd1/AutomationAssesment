@ui @HealthCheck @AutomationPractice
Feature: E-commerce Web Application Health Check

Background: Navigation to the URL
  Given User navigated to home page url

@1 @UrlValidation
Scenario: User opened browser and navigate to home page url and validate the home page url with user given url
#And  User navigated to home page url
When  User validated Application url
Then  Compared with given url


@2 @urlLogoVisibilty
Scenario: User opened browser and navigate to home page url and validated Application logo visibility and Height and Width
#And User navigated to home page url
When User validated visibility of Application logo
Then User validated Height and Width of Application logo

@3 @ProductCategory
Scenario: User opened browser and navigate to home page url and validated main product category
#And User navigated to home page url
When user validated main product count
Then user fetched all main product text 

@4 @SearchFunctionality
Scenario: User opened browser and navigate to home page url and validated Search page functionality
#And User navigated to home page url
When user entered text in searchbox "T-shirt"
Then user validated autosuggestion text

@5 @SocialMediaHandle
Scenario: User opened browser and navigate to home page url and validated Social Media handle
#And User navigated to home page url
When User clicked on twitter logo
Then user validated new tab conatains "seleniumfrmwrk"
And user validated account name is "Selenium Framework"




