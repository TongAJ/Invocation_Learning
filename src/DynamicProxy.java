import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author AJ
 */
public class DynamicProxy implements InvocationHandler {
    private Subject subject;

    public DynamicProxy(Subject subject){
        this.subject = subject;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before " + method.getName());
        System.out.println("method: " + method);
        method.invoke(subject,args);
        System.out.println("after " + method.getName());
        return null;

    }

}
