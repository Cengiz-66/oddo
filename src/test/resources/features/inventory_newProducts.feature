Feature: The user can create a new product
	
	Background:
	
		Given the user is logged in
		And the user navigate to "Inventory" "Products"
		And the user clicks "Create" button

	Scenario: new product creation
		When  the user enters the following information 
			|Name              |Yucel     |
			|Product Type      | Service  |
			|Internal Reference| Tirana   |
			|Sales Price       | 3.00     |
			|Cost              | 15.00    |
		And the user clicks "Save" button
		Then title should contain "Yucel"

	Scenario: new product creation- negative
		When  the user enters the following information 
			|Name              |Yucel     |
			|Product Type      | Service  |
			|Internal Reference| Tirana   |
			|Sales Price       | sales    |
			|Cost              | 15.00    |
		And the user clicks "Save" button
		Then the user should get "The following fields are invalid:" warning message

	Scenario: new product creation- negative
		When  the user enters the following information 
			|Name              |Yucel     |
			|Product Type      | Service  |
			|Internal Reference| Tirana   |
			|Sales Price       | 3.00     |
			|Cost              | cost     |
		And the user clicks "Save" button
		Then the user should get "xxxxxx" warning message

	Scenario Outline: new product click functions
		When the user clicks "<checkBox>" check box
		Then the user should see "<options>"	

	 Examples:
	 	|checkBox        |options  |
	 	|Can be Sold     |Sales    |
	 	|Can be Purchased|Purchase |
	 	|Can be Expensed |Inventory|	

