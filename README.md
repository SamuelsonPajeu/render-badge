# Render Dashboard Status Badge
Retrieve the status of your latest deployment from the Render Dashboard as badge tags for README files

![Image](https://render-badge-samuelsonpajeu.onrender.com/by_name?projectName=render-badge-samuelsonpajeu)

![image](https://github.com/SamuelsonPajeu/render-badge/assets/79151331/544cf095-99b6-46c7-86f0-0ee2f22b7116)


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

**How to Use This with Your Own Render Projects**

1. **Create a copy of the repository:**

 ![image](https://github.com/SamuelsonPajeu/render-badge/assets/79151331/a29c326c-2526-4ce9-8246-9eeb88facc1b)

2. **On Render: [https://dashboard.render.com](https://dashboard.render.com), create a new Web service:**

  ![image](https://github.com/SamuelsonPajeu/render-badge/assets/79151331/3723b228-b3f4-4915-93a8-64366ef2d841)


3. **Build from Git and choose the repository that you forked:**

![image](https://github.com/SamuelsonPajeu/render-badge/assets/79151331/bf21f605-0ff6-42cb-83df-09588910778d)

4. **Set Runtime to Docker:**

![image](https://github.com/SamuelsonPajeu/render-badge/assets/79151331/7d81a4ba-9fef-48a9-9ff6-2d71b700e369)

5. **On Environment Variables, set `SECRET` as your [Render API Key](https://api-docs.render.com/reference/authentication) :**

![image](https://github.com/SamuelsonPajeu/render-badge/assets/79151331/3503f693-7201-4b79-bfdf-d69dba056e30)

6. **After the application has been deployed, use the endpoint in your README.md files:**

`![Image](https://your-render-application-url/by_name?projectName=project-name-here)`

**Troubleshooting**

**Images Not Dynamically Updating on Github:**

Please see GitHub Anonymized Urls: [https://docs.github.com/en/authentication/keeping-your-account-and-data-secure/about-anonymized-urls](https://docs.github.com/en/authentication/keeping-your-account-and-data-secure/about-anonymized-urls) for more information.

**Fix:** On Environment Variables, set `CACHE-CONTROL` as `no-cache` or a desired Cache-Control Rule: [https://developer.mozilla.org/pt-BR/docs/Web/HTTP/Headers/Cache-Control](https://developer.mozilla.org/pt-BR/docs/Web/HTTP/Headers/Cache-Control).

**Note:** If you're using a free instance, the image won't be loaded instantaneously if idle, as per Render.com's spinning-down-on-idle policy: [https://render.com/docs/free#spinning-down-on-idle](https://render.com/docs/free#spinning-down-on-idle). In this case, you can remove the `CACHE-CONTROL` property (or set it to `public` and configure `max-age`) to have the image stored locally and displayed while the service is down (but it won't be updated automatically).

**Updating Manually:**

You can force an update by copying the image URL and running the following command in the shell:

```bash
CURL -X PURGE {URL}
```

Example:

![image](https://github.com/SamuelsonPajeu/render-badge/assets/79151331/50094ec6-92b5-427b-b1b7-929ab56ddde5)

```bash
CURL -X PURGE https://camo.githubusercontent.com/218b7ceec59948ec62ff0b08b4e5a60808ed927d6bb1079b156f0f95b796362b/68747470733a2f2f72656e6465722d62616467652d73616d75656c736f6e70616a65752e6f6e72656e6465722e636f6d2f62795f6e616d653f70726f6a6563744e616d653d72656e6465722d62616467652d73616d75656c736f6e70616a6575
```

Reload the page, and a new request should be made to update the badge.



