package supr;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.BasicConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import supr.service.MyService;

/**
 * Created by lujiangtao on 2016/4/11.
 */
public class ClientMainProcessor {

    static {
        BasicConfigurator.configure();
    }

    /**
     * 日志
     */
    private static final Log LOGGER = LogFactory.getLog(ClientMainProcessor.class);

    /**
     * 锁定用
     */
    private static Object WAITOBJECT = new Object();

    public static void main(String[] args) throws Exception {
        ApplicationContext app = new ClassPathXmlApplicationContext(new String[]{"spring-redis-client.xml"});

        // 开始RPC调用
        MyService myService = (MyService)app.getBean("myService");
        LOGGER.info("myService = " + myService.doMyTest("1234", "abcde"));

        // 这里锁定这个应用程序，和DUBBO框架本身的工作原理没有任何关系，只是为了让其不退出
        synchronized (ClientMainProcessor.WAITOBJECT) {
            ClientMainProcessor.WAITOBJECT.wait();
        }
    }
}
