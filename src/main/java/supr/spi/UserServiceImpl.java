package supr.spi;

/**
 * Created by lujiangtao on 2016/4/11.
 */
public class UserServiceImpl implements UserService{

    @Override
    public void add(int x, int y) {
        System.out.println(x+y);
    }
}
