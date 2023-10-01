
@ui @HealthCheck @AutomationPractice
Feature: E-commerce Web Application Health Check

Background: Navigation to the URL
  Given User navigated to home page url

@1 @UrlValidation
Scenario: User opened browser and navigate to home page url and validate the home page url with user given url
#And  User navigated to home page url
Then User should be redirected to "http://www.automationpractice.pl/index.php?"


@2 @urlLogoVisibilty
Scenario: User opened browser and navigate to home page url and validated Application logo visibility and Height and Width
#And User navigated to home page url
When User validated visibility of Application logo
Then User validated Height is 99 and Width is 350 of Application logo

@3 @ProductCategory
Scenario Outline: User opened browser and navigate to home page url and validated main product categories and count
#And User navigated to home page url
When user validated main product count
Then user validated main product category should be "<ProductCategory>"
Examples:
| ProductCategory |
| WOMEN           |
| DRESSES         |
| T-SHIRTS        |

@4 @SearchFunctionality
Scenario: User opened browser and navigate to home page url and validated Search page functionality
#And User navigated to home page url
When user entered text in searchbox "Faded"
Then autosuggestion text should contains "Faded"

@5 @SocialMediaHandle
Scenario: User opened browser and navigate to home page url and validated Social Media handle
#And User navigated to home page url
When User clicked on twitter logo
Then user validated new tab conatains "prestashop"
And user validated account name is "PrestaShop"

@6 @Shopping 
Scenario: User opend a browser and naviagated to homepage and purchased a item 
When User clicked on item
Then User proceeded to checkout



