# Render Dashboard Status Badge
 Get the status for you last deploy from Render Dashboard as Bagde tags for README files (See bellow)

![Image](https://render-badge-samuelsonpajeu.onrender.com/by_name?projectName=render-badge-samuelsonpajeu)


## Install
- Make sure you got:
  * [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)

- Prepare your ENVIROMENT:
  
   Set `'SECRET'` ENV as your [Render API Key](https://api-docs.render.com/reference/authentication )


- Install dependencies
 ```bash
 mvn clean install
 ```

- [x] You're ready to run and execute this project


## Usage
- LIVE APPLICATION: https://render-badge-samuelsonpajeu.onrender.com/ (create your own instance by fork this project)
- DOC: https://render-badge-samuelsonpajeu.onrender.com/swagger-ui/index.html
- ENDPOINT: http://localhost:8080/

#### Get badge

<details>
  <summary><code>GET</code> <code><b>/by_name?projectName={string}</b></code> <code>(Search by Render Project name)</code></summary>

##### Parameters

> | name              |  type     | data type      | description                         |
> |-------------------|-----------|----------------|-------------------------------------|
> | `string` |  required | string | Exactly match of Render Project Name |

##### Responses

> | http code     | content-type                      | response                                                            |
> |---------------|-----------------------------------|---------------------------------------------------------------------|
> | `200`         | `image/svg+xml`        |  Image/SVG       |
> | `404`         | `application/json`        |  `Project was not found`      |
> | `401`         | `application/json`        |  `SECRET was not been set`       |


##### Example cURL

> ```javascript
>  curl -X GET "http://localhost:8080/by_name?projectName=http-foxes-api" -H "accept: */*"
> ```

</details>




