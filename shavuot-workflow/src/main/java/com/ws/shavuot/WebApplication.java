package com.ws.shavuot;

import com.ws.shavuot.thrift.workflow.WorkflowService;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.*;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangqiliang on 17/3/23.
 */
@SpringBootApplication
public class WebApplication {
    /**
     * @param args String
     */
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

    /**
     * @return
     */
    @Bean
    public CommandLineRunner init() {
        return new CommandLineRunner() {
            @Override
            public void run(String... x) throws Exception {

                System.out.print("项目启动成功");

            }
        };
    }
}


