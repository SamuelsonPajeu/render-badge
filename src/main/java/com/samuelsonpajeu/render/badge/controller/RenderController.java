package com.samuelsonpajeu.render.badge.controller;

import com.samuelsonpajeu.render.badge.entities.DeployObject;
import com.samuelsonpajeu.render.badge.service.RenderService;
import com.samuelsonpajeu.render.badge.service.StaticBagdeService;
import com.samuelsonpajeu.render.badge.utils.RenderUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class RenderController {

    private final RenderService renderService;
    private final StaticBagdeService staticBagdeService;

    @GetMapping("/by_name")
    public ResponseEntity getBadgeByApplicationName(@RequestParam String projectName) {
        DeployObject serviceObject = new DeployObject();
        RenderUtils renderUtils = new RenderUtils();

        String status = this.renderService.getStatusByApplicationName(projectName);
        String color;

        System.out.println(status);
        switch (status){
            case "live":
                color = "green";
                break;
            case "build_failed":
                color = "red";
                break;
            default:
                color = "white";
                break;
        }

        serviceObject.setStatus(status);
        serviceObject.setColor(color);

        String data = staticBagdeService.retrieveAPIData(status, color);


        HttpHeaders header = new HttpHeaders();
        header.set("Content-Type","image/svg+xml;charset=utf-8");

        if (renderUtils.isCacheControlSet()){
            header.set("Cache-Control", renderUtils.getCacheControl());
        }

        return ResponseEntity.ok()
                .headers(header)
                .body(data);
    }



}
