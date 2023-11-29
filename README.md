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


## Tutorial

How do you use this with your own render projects

* Create a copy of the repository:
  
  ![image](https://github.com/SamuelsonPajeu/render-badge/assets/79151331/a29c326c-2526-4ce9-8246-9eeb88facc1b)

* On [Render](https://dashboard.render.com) create a new Web service:

  ![image](https://github.com/SamuelsonPajeu/render-badge/assets/79151331/3723b228-b3f4-4915-93a8-64366ef2d841)

* Build from a Git and choose the repository that you forked:
  
  ![image](https://github.com/SamuelsonPajeu/render-badge/assets/79151331/bf21f605-0ff6-42cb-83df-09588910778d)

* Set Runtime to Docker:

  ![image](https://github.com/SamuelsonPajeu/render-badge/assets/79151331/7d81a4ba-9fef-48a9-9ff6-2d71b700e369)

* On Environment Variables set `SECRET` as your [Render API Key](https://api-docs.render.com/reference/authentication ):
  
 ![image](https://github.com/SamuelsonPajeu/render-badge/assets/79151331/3503f693-7201-4b79-bfdf-d69dba056e30)

* After the application as been deployed, use the endpoint in your README.md files:
  
  `![Image](https://your-render-application-url/by_name?projectName=project-name-here)`

## Troubleshooting

#### Images not dynamically updating:

Beacause of Github [Anonymized Urls](https://docs.github.com/en/authentication/keeping-your-account-and-data-secure/about-anonymized-urls) the images are cached 


