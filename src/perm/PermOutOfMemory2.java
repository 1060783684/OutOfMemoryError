package perm;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M -XX:+PrintGCDetails
 *
 * 使用cglib创建动态代理类造成永久代溢出,这是第二种让永久代溢出的方法,适用于jdk1.7以前
 *
 * @author Worry
 */
public class PermOutOfMemory2 {
    public static void main(final String[] args){
        while(true){
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
                        throws Throwable {
                    return methodProxy.invokeSuper(o,args);
                }
            });
            enhancer.create();
            System.out.println("create ok!");
        }
    }

    static class OOMObject{

    }
}
