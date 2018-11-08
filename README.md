# spring-boot-rest-api-template
Spring boot REST API project template using jpa (Springboot REST API whch connects MySQL database).

Setup
-----
- Clone and open in Intellij Idea IDE
- Change database connection config in `src/main/resources/application.properties`
- Install maven dependencies using IDE auto import or using the command ``mvn install``
- Run the app using ``mvn spring-boot:run``
- Browse ``http//localhost:8080/api/v1/usuarios``
- Create package for deployment using ``mvn package`` (change properties if required)

Table Structure
---------------
``CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;``

``ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);``
  
``ALTER TABLE `usuarios`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;``
    
API Doc & Sample
----------------
- List all usuarios
    ```
    GET /api/v1/usuarios
    ```
- Create new usuario
    ```
    POST /api/v1/usuarios
    ```

    Body:
    ```
    {
        "name": "Mark Price",
        "email": "mark@devslopes.com",
        "mobile": "0123456789"
    }
    ```
    Content-Type:
    ```
    application/json
    ```
- Get specific usuario
    ```
    GET /api/v1/usuarios/1
    ```
- Update usuario
    ```
    PUT /api/v1/usuarios
    ```
    Body:
    ```
    {
        "id":1,
        "name": "Jeffrey Way",
        "email": "jeffrey@laracasts.com",
        "mobile": "0123456789"
    }
    ```
    
    Content-Type:
    ```
    application/json
    ```
- Delete usuario
    ```
    DELETE /api/v1/usuarios/1
    ```
Note
-----
For getting XML response use ``Accept`` header ``application/xml`` and ``application/json`` for JSON response.