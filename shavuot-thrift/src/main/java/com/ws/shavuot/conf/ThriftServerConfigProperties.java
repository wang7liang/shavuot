package com.ws.shavuot.conf;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by tianfei on 17/3/28.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThriftServerConfigProperties {

    /**
     * 端口
     */
    private int port;

    /**
     * thrift接口
     */
    private String thriftInterface;

    /**
     * 网络io线程池大小
     */
    private int selectorThreadCount;

    /**
     * 服务线程池大小
     */
    private int workerThreadCount;

    /**
     * 默认
     */
    private int acceptQueueSizePerThread;


}
