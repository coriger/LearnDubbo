package supr.service;

import org.springframework.stereotype.Component;

/**
 * Created by lujiangtao on 2016/4/11.
 */
public class MyServiceImpl implements MyService {

    @Override
    public String doMyTest(String field1, String field2) {
        return field1 + field2;
    }
}