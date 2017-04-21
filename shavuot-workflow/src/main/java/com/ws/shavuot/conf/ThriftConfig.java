package com.ws.shavuot.conf;

import com.wealoha.thrift.PoolConfig;
import com.wealoha.thrift.ServiceInfo;
import com.wealoha.thrift.ThriftClientFactory;
import com.wealoha.thrift.ThriftClientPool;
import com.ws.shavuot.thrift.WorkflowServiceImpl;
import com.ws.shavuot.thrift.workflow.WorkflowService;
import org.apache.thrift.TServiceClient;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TTransport;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

/**
 * thrift server config
 * Created by tianfei on 17/3/28.
 */
@Configuration
public class ThriftConfig {

    ///////////////////Server////////////////

    /**
     * @return ThriftServerConfigProperties
     */
    @Bean
    @ConfigurationProperties(prefix = "thrift.server")
    public ThriftServerConfigProperties thriftServerConfigProperties() {
        return new ThriftServerConfigProperties();
    }

    /**
     * @return WorkflowService
     */
    @Bean
    public WorkflowService.Iface workflowService() {
        return new WorkflowServiceImpl();
    }

    /**
     * @param thriftServerConfigProperties ThriftServerConfigProperties
     * @return ThriftServerProxy ThriftServerProxy
     */
    @Bean(name = "thriftServerProxy")
    public ThriftServerProxy thriftServerProxy(ThriftServerConfigProperties thriftServerConfigProperties) {
        ThriftServerProxy proxy = new ThriftServerProxy(thriftServerConfigProperties, workflowService());
        proxy.start();
        return proxy;
    }


    ///////////////////Client1////////////////

    /**
     * @return ThriftClientConfigProperties
     */
    @Bean(name = "client1Properties")
    @ConfigurationProperties(prefix = "thrift.client1")
    public ThriftClientConfigProperties thriftClientConfigProperties1() {
        return new ThriftClientConfigProperties();
    }


    /**
     * @param thriftClientConfigProperties ThriftClientConfigProperties
     * @return ThriftClientPool
     */
    @Bean(name = "thriftClient1Pool")
    public ThriftClientPool<WorkflowService.Client> getThriftClientPool(
            @Qualifier("client1Properties") ThriftClientConfigProperties thriftClientConfigProperties) {
        PoolConfig poolConfig = new PoolConfig();
        poolConfig.setTimeout(thriftClientConfigProperties.getTimeout());
        poolConfig.setMaxIdle(thriftClientConfigProperties.getMaxIdle());
        poolConfig.setMaxTotal(thriftClientConfigProperties.getMaxTotal());
        poolConfig.setMinIdle(thriftClientConfigProperties.getMinIdle());

        ServiceInfo serviceInfo = new ServiceInfo(thriftClientConfigProperties.getHost(), thriftClientConfigProperties.getPort());

        ThriftClientPool<WorkflowService.Client> pool =
                new ThriftClientPool<>(
                        Collections.singletonList(serviceInfo),
                        new ThriftClientFactory() {

                            @Override
                            public TServiceClient createClient(TTransport transport) {
                                return new WorkflowService.Client(new TCompactProtocol(new TFramedTransport(transport)));
                            }

                        },
                        poolConfig);
        return pool;
    }


}
