package supr.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Created by lujiangtao on 2016/4/11.
 */
public class Test {

    public static void main(String[] args){
        ServiceLoader<UserService> userService = ServiceLoader.load(UserService.class);
        // 这样写的原因是，您可以一次指定这个接口的多个具体实现
        Iterator<UserService> iinterface= userService.iterator();
        if (iinterface.hasNext()) {
            UserService interfaceItem = iinterface.next();
            interfaceItem.add(1,2);
        }
    }

}
