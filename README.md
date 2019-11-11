# **Connected Vehicle Solution**

The Connected Vehicle Solution is a reference implementation that provides a foundation for automotive product transformations for connected vehicle services.

**With Connected Vehicle Cloud you can:**

1. Securely offer connected services at a global scale
2. Start simple and expand when the time is right

below is the fleet management services.

## **Requirements**

	1. Web GUI (Single Page Application Framework/Platform).
		 - An overview of all vehicles should be visible on one page (full-screen display), together with their status.
		 - It should be able to filter, to only show vehicles for a specific customer.
		 - It should be able to filter, to only show vehicles that have a specific status.
	2. Random simulation to vehicles status sending.
	3. If database design will consume a lot of time, use data in-memory representation.
	4. Unit Testing.
	5. .NET Core, Java or any language you feel comfortable with.
	6. Complete analysis for the problem.
		 - Full architectural sketch to solution.
		 - Analysis behind the solution design, technologies....
		 - How to run your solution.
	7. Use CI (Travis, Circle, TeamCity...) to verify your code (Static analysis,..) and tests.
	8. Dockerize the whole solution.
	9. Use Microservices architecture.
		- Use any Microservices Chassis Framework.
	10. Use any free tier on any cloud platform like: - AWS, Azure or GCP

## Optional Requirements

	1. Explain if it is possible to be in Serverless architecture and how?

# **Functional services**

**Automotive Customer service**

Contains general customer methods which commonly used by other clients: retrieve customer details and register/update customer data.

| Method | Path           | Description                 | User authenticated | Available from UI |
|--------|----------------|-----------------------------|--------------------|-------------------|
| GET    | /customer/{id} | Get specified customer data |                    |                   |
| GET    | /customer/     | Get all customers data      |                    |                   |
| POST   | /customer/     | Crate/Update customer data  |                    |                   |


**Automotive Vehicles service**

below are actions on vehicle resourses.

| Method | Path               | Description                  | User authenticated           |
|--------|--------------------|------------------------------|------------------------------|
| GET    | /vehicle/          | Get all available vehicles   | Scoial Authentication(gmail) |
| GET    | /vehicle/{id}      | retreive spacific vehicle    | Scoial Authentication(gmail) |
| POST   | /vehicle/{vehicle} | create new vehicle           | Scoial Authentication(gmail) |