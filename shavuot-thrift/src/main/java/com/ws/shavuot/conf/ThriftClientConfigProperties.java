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
public class ThriftClientConfigProperties {

    /**
     *
     */
    private String host;

    /**
     *
     */
    private int port;

    /**
     *
     */
    private int timeout;

    /**
     *
     */
    private int maxIdle;

    /**
     *
     */
    private int minIdle;

    /**
     *
     */
    private int maxTotal;

}
