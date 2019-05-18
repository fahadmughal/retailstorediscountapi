# Problem Statement

    On a retail website, the following discounts apply:
    1. If the user is an employee of the store, he gets a 30% discount
    2. If the user is an affiliate of the store, he gets a 10% discount
    3. If the user has been a customer for over 2 years, he gets a 5% discount.
    4. For every $100 on the bill, there would be a $ 5 discount (e.g. for $ 990, you get $ 45
    as a discount).
    5. The percentage based discounts do not apply on groceries.
    6. A user can get only one of the percentage based discounts on a bill.
     
# Setup And Build

    1- Import the project as a maven project.
    2- Clean and build the project through maven.
    3- Run the RetailstoreApplication.java for starting the project. 
    Now Project is up and runing.
# Technologies Used

    1- Spring Boot
    2- Swagger
    3- Lombok

# URL for testing
    http://localhost:8080/swagger-ui.html

# Some Parameter
    Just change the parameteres for different testing scenarios
        
        customer type  = 1 will be treated as Employee
        customer type  = 2 will be treated as Affaliate
        customer type  = 3 will be treated as simple Customer
        
    Product Type = 1 will be treated as Grocery Item type else are non Grocery

# Request for Testing
    
    {
      "customer": {
        "createdAt": "2019-05-18",
        "id": 0,
        "name": "Fahad",
        "type": {
          "id": 1,
          "name": "employee"
        }
      },
      "products": [
        {
          "id": 1,
          "name": "A",
          "price": 20,
          "quantity": 2,
          "type": {
            "id": 1,
            "name": "Grocery"
          }
        },
    {
          "id": 2,
          "name": "B",
          "price": 200,
          "quantity": 2,
          "type": {
            "id": 2,
            "name": "Electronics"
          }
        }
      ]
    }
    
# Focused Area
    Architecture and OOP