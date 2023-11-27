package com.samuelsonpajeu.render.badge.service;

import com.samuelsonpajeu.render.badge.utils.RenderUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class RenderService {

    String servicesUrl = "https://api.render.com/v1/services?name=%s&limit=1";
    String deployUrl = "https://api.render.com/v1/services/%s/deploys?limit=1";
    RenderUtils renderUtils = new RenderUtils();

    private List<Object> retrieveAPIData(String url, String param) {
        RestTemplate restTemplate = new RestTemplate();

        String uri = String.format(url, param);

        HttpHeaders headers = new HttpHeaders();
        headers.set("accept", "application/json");
        headers.set("accept", "application/json");
        headers.set("authorization", this.renderUtils.getSecret());

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<List> response = restTemplate.exchange(uri,HttpMethod.GET, requestEntity, List.class);

        List<Object> responseBody = response.getBody();

        return responseBody;
    }

    private List<Object> retrieveService(String name) {
        return this.retrieveAPIData(this.servicesUrl, name);
    }

    private List<Object> retrieveDeploy(String id){
        return this.retrieveAPIData(this.deployUrl, id);
    }

    private String getServiceId (List<Object> service) {
        Map<String, Object> firstService = (Map<String, Object>) service.get(0);

        Map<String, Object> serviceData = (Map<String, Object>) firstService.get("service");

        String serviceId = serviceData.get("id").toString();

        return serviceId;
    }

    private String getDeployStatus (List<Object> deploys) {
        Map<String, Object> lastDeploy = (Map<String, Object>) deploys.get(0);

        Map<String, Object> deployData = (Map<String, Object>) lastDeploy.get("deploy");

        String lastDeployStatus = deployData.get("status").toString();

        return lastDeployStatus;

    }

    public String getStatusByApplicationName(String projectName) {
        List<Object> listService = this.retrieveService(projectName);

        String serviceId;

        if (listService.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Project %s was not found", projectName));
        }

        serviceId = this.getServiceId(listService);


        return this.getStatusByApplicationId(serviceId);
    }

    public String getStatusByApplicationId (String serviceId) {
        List<Object> deploysData;
        String deployStatus;

        deploysData = this.retrieveDeploy(serviceId);

        deployStatus = this.getDeployStatus(deploysData);

        return deployStatus;
    }










}
