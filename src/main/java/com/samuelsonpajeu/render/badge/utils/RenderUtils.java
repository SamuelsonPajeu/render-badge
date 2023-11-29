package com.samuelsonpajeu.render.badge.utils;


import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class RenderUtils {

    public String getSecret(){
        String sEnv = System.getenv("SECRET");

        if (sEnv == null || sEnv.isEmpty()){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "SECRET was not been set");
        }

        String secret = String.format("Bearer %s", sEnv);

        return secret;
    }

    public boolean isCacheControlSet() {
        String sEnv = System.getenv("CACHE-CONTROL");
        if (sEnv == null || sEnv.isEmpty()){
            return false;
        }
        return true;
    }

    public String getCacheControl() {
        String sEnv = System.getenv("CACHE-CONTROL");
        return sEnv;
    }

}
