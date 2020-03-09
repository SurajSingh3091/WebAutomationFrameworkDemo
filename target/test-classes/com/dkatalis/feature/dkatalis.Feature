Feature: End to End checkout flow for purchasing “Pillow” usingCredit Card as payment method 

@PositiveScenario 
Scenario: Positive flow 
	Given User is on home page 
	When  User clicks on buy now button and then clicks on CheckOut 
	And User checks for amount and click continue button 
	And User selects Payment mode as credit card and enters card details 
		|CreditCardNumber|ExpiryDate|Cvv|
		|4811111111111114|02/20|123|
	Then User clicks on Paynow button and enters otp "112233"
	
	
@NegativeScenario 
Scenario: Positive flow 
	Given User is on home page 
	When  User clicks on buy now button and then clicks on CheckOut 
	And User checks for amount and click continue button 
	And User selects Payment mode as credit card and enters card details 
		|CreditCardNumber|ExpiryDate|Cvv|
		|4811111111111114|02/20|123|
	Then User clicks on Paynow button and enters otp "*****"