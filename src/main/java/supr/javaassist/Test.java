package supr.javaassist;

import javassist.*;

import java.io.IOException;

/**
 * Created by lujiangtao on 2016/4/11.
 */
public class Test {

    public static void main(String[] args) throws Exception {
        ClassPool pool = ClassPool.getDefault();

        // 创建一个名叫Foo的类
        CtClass cc = pool.makeClass("Foo");

        // 创建一个名叫‘getInteger’的方法
        CtMethod mthd = CtNewMethod.make("public Integer getInteger() { return null; }", cc);
        cc.addMethod(mthd);

        // 创建一个名叫i的属性，它的类型是‘int’
        CtField f = new CtField(CtClass.intType, "i", cc);
        cc.addField(f);

        // 实例化这个类
        Class clazz = cc.toClass();
        Object instance = clazz.newInstance();

        System.out.println(instance.toString());

        cc.writeFile();

    }




}
