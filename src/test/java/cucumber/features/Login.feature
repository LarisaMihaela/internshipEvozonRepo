Feature: Application Login

Scenario Outline: Login with valid and invalid credentials

Given User is on HomePage
When User goes to account and Clicks Login
Then User introduces email <username> and password <password>
And User is redirected to Account Information Page.

Examples:
|username				|password		|
|helloworld20@yahoo.com	|helloworld2015	|
|test123@yahoo.com		|21313			|
 
