package com.ws.shavuot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Created by wangqiliang on 17/3/23.
 */
@SpringBootApplication
public class WebApplication {

    /**
     * @param args String[]
     */
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }


}

