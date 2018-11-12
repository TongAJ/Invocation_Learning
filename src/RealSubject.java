/**
 * @author  AJ
 */
public class RealSubject implements Subject {
    @Override
    public void rent() {
        System.out.println("i want to rent...");
    }

    @Override
    public void hello(String hello) {
        System.out.println("hello: "+hello);
    }
}
