package com.ws.shavuot.conf;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TProcessor;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadedSelectorServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportException;

import java.lang.reflect.Constructor;

/**
 * thrift 服务代理类
 */

@Slf4j
@Data
@AllArgsConstructor
public class ThriftServerProxy {

    /**
     *
     */
    private ThriftServerConfigProperties properties;

    /**
     * thrift 服务实现类
     */
    private Object thriftInterfaceImpl;

    /**
     *
     */
    private static final String flag = "****************************";

    /**
     *
     */
    public void start() {
        new Thread() {
            @Override
            public void run() {
                try {
                    //使用TThreadedSelectorServer

                    TNonblockingServerSocket socket = new TNonblockingServerSocket(properties.getPort());
                    Class processorClass = Class.forName(properties.getThriftInterface() + "$Processor");               // thrift实现类的处理类class
                    Class iFaceClass = Class.forName(properties.getThriftInterface() + "$Iface");                   // thrift接口
                    Constructor constructor = processorClass.getConstructor(iFaceClass);                        // thrift接口实现类的构造方法类
                    TProcessor processor = (TProcessor) constructor.newInstance(getThriftInterfaceImpl());   // thrift实现类的处理类
                    TThreadedSelectorServer.Args arg = new TThreadedSelectorServer.Args(socket)
                            .workerThreads(properties.getWorkerThreadCount()) // thrift服务线程数
                            .selectorThreads(properties.getSelectorThreadCount()) //thrift selector线程数
                            .acceptQueueSizePerThread(properties.getAcceptQueueSizePerThread()) //阻塞队列的大小
                            .acceptPolicy(TThreadedSelectorServer.Args.AcceptPolicy.FAST_ACCEPT); //thrift 响应策略

                    //压缩二进制协议
                    arg.protocolFactory(new TCompactProtocol.Factory());
                    arg.transportFactory(new TFramedTransport.Factory());
                    arg.processorFactory(new TProcessorFactory(processor));

                    log.info(flag + "thrift server start" + flag);

                    log.info("TThreadedSelectorServer starting up ....");
                    TServer server = new TThreadedSelectorServer(arg);
                    server.serve();

                } catch (TTransportException e) {
                    log.error("Server starting error ....");
                    e.printStackTrace();
                } catch (Exception e) {
                    log.error("Server starting error ....");
                    e.printStackTrace();
                }
            }
        }.start();
    }

}
