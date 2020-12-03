package online.stringtek.jvm.advanced.ch2;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * VM Args: -XX:PermSize=10m -XX:MaxPermSize=10m JDK7
 * VM Args: -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m JDK8+
 * */
public class JavaMethodAreaOOM {
    public static void main(String[] args) {
        while(true){
            Enhancer enhancer=new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(o,objects);
                }
            });
            enhancer.create();
        }
    }
    static class OOMObject{

    }
}
