# Beauty Salon App in Spring Boot

## Business Requirements

1. Clients should be able to book appointments for various beauty services.
2. Beauty professionals (stylists, make-up artists) should be able to view their schedules.
3. The system should support inventory management for beauty products.
4. The system should allow clients to rate and review beauty services.
5. Beauty professionals should have profiles with their expertise and certifications.
6. The system should generate reports on customer feedback.
7. Maintain a client database with contact information, appointment history, and preferences.
8. Develop a marketing strategy to attract new clients and retain existing ones.
9. Provide ongoing training for staff to stay updated on the latest beauty trends, techniques, and products.
10. Ensure a clean, comfortable, and aesthetically pleasing salon environment

## Main features – MVP

1. Appointments management
	+ <font color="#49cc90">**POST**</font> request: add new appointment
	+ <font color="#61affe">**GET**</font> request: get all appointments no parameter
	+ <font color="red">**DELETE**</font> request: delete appointment by id parameter (appointment id)
2. Basic inventory management for beauty products
	+ <font color="#49cc90">**POST**</font> request: add new product
	+ <font color="#61affe">**GET**</font>  request: get all products
	+ <font color="#61affe">**GET**</font>  request: get all products by name parameter (product name)
	+ <font color="red">**DELETE**</font> request: delete product by id parameter (product id)
3. Rate and review beauty services
	+ <font color="#49cc90">**POST**</font> request: add new review
	+ <font color="#61affe">**GET**</font>  request: get all reviews
	+ <font color="red">**DELETE**</font> request: delete review by id parameter (review id)
4. Clients management
	+ <font color="#49cc90">**POST**</font> request: add new client
	+ <font color="#61affe">**GET**</font>  request: get all clients
	+ <font color="#61affe">**GET**</font>  request: get client by id parameter (client id)
	+ <font color="red">**DELETE**</font> request: delete client by id parameter (client id)
5. Beauty professionals management
	+ <font color="#49cc90">**POST**</font> request: add new beauty professional
	+ <font color="#61affe">**GET**</font>  request: get all beauty professionals
	+ <font color="#61affe">**GET**</font>  request: get beauty professional by id parameter (beauty-professional id)
	+ <font color="red">**DELETE**</font> request: delete beauty professional by id parameter (beauty-proessional id)

## Diagrams
![ER Diagram](ER_Diagram.jpg)
![DC_Diagram](DC_Diagram.jpg)
