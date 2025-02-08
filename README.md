Task Management API

 A simple REST API for managing tasks

Technologies Used-

Java 21

Spring Boot 3.4.2(spring initializr)

H2 Database (In-Memory)

Maven

IntelliJ IDEA

Features-

Create a Task

Request Body:

curl -X POST http://localhost:8080/tasks \
     -H "Content-Type: application/json" \
     -d '{
           "title": "Complete Internship Assignment",
           "description": "Solve the given problem and submit the code",
           "status": "PENDING"
         }'
         
Response Body:

{"id":1,"title":"Complete Internship Assignment","description":"Solve the given problem and submit the code","status":"PENDING","createdAt":"2025-02-09T00:29:43.209988"}%



Get All Tasks

Request Body:

curl -X GET http://localhost:8080/tasks

Response Body:

[{"id":1,"title":"Complete Internship Assignment","description":"Solve the given problem and submit the code","status":"PENDING","createdAt":"2025-02-09T00:29:43.209988"}]%



Update a Task

Request Body:

curl -X PUT http://localhost:8080/tasks/1 \
     -H "Content-Type: application/json" \
     -d '{ "status": "COMPLETED" }'
     
Response Body:

{"id":1,"title":"Complete Internship Assignment","description":"Solve the given problem and submit the code","status":"COMPLETED","createdAt":"2025-02-09T00:29:43.209988"}%



Delete a Task

Request Body:

curl -X DELETE http://localhost:8080/tasks/1

Response Body:

Request Body:

curl -X DELETE http://localhost:8080/tasks/1

Response Body:{"timestamp":"2025-02-08T19:03:28.363+00:00","status":404,"error":"Not Found","path":"/tasks/1"}% 














