import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {

    public static void main(String[] args) {
        // 声明一个接口
        Subject realSubject = new RealSubject();
        // 声明一个自定义InvocationHandler，将接口注入
        InvocationHandler handler = new DynamicProxy(realSubject);
        // 创建一个动态代理，并且与自定义handler进行关联
        Subject subject = (Subject) Proxy.newProxyInstance(handler.getClass().getClassLoader(), realSubject.getClass().getInterfaces(), handler);
        // 获取代理的名字：com.sun.proxy.$Proxy0
        System.out.println(subject.getClass().getName());
        /**
         * 1.使用代理来执行rent方法，因为和自定义handler绑定了
         * 2.调用handler的invoke方法
         *  2.1 打印before rent
         *      System.out.println("before rent");
         *  2.2 打印方法名称
         *      System.out.println("method: "+method);
         *  2.3 通过反射，执行方法
         *      method.invoke(subject,args);
         *  2.4 打印after rent
         *      System.out.println("after rent");
         */
        subject.rent();
        subject.hello("AJ");
    }
}
