package io.pivotal.pal.tracker;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    public String port;
    public String mem;
    public String cf_instnce;
    public String address;

    public EnvController(@Value("${PORT:NOT_SET}") String port,
                         @Value("${MEMORY_LIMIT:NOT_SET}")  String mem,
                         @Value("${CF_INSTANCE_INDEX:NOT_SET}") String cf_instnce,
                         @Value("${CF_INSTANCE_ADDR:NOT_SET}") String address){
        this.port = port;
        this.mem = mem;
        this.cf_instnce = cf_instnce;
        this.address=address;
    }

    @GetMapping("/env")
    public Map getEnv(){
        Map env = new HashMap();
        env.put("PORT",this.port);
        env.put("MEMORY_LIMIT", this.mem);
        env.put("CF_INSTANCE_INDEX",this.cf_instnce);
        env.put("CF_INSTANCE_ADDR", this.address);

        return  env;
    }

}
