import com.xl.config.XlConfig;
import com.xl.demo02.UserServiceProxy;
import com.xl.demo04.UserServcieImpl;
import com.xl.demo04.UserService;
import com.xl.demo3.*;
import com.xl.pojo.*;
import com.xl.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //默认构造函数，属性注入
        Hello hello = (Hello) context.getBean("hello");
        System.out.println(hello.toString());

        //构造函数注入
        //单例模式，
        Hello hello1 = (Hello) context.getBean("hello1");
        Hello hello2 = (Hello) context.getBean("hello1");
        System.out.println(hello1 ==hello2);
        System.out.println(hello1.toString());

        //原型模式，每次禅师新实例
        Hello helloprototype1 = (Hello) context.getBean("hello-prototype");
        Hello helloprototype2 = (Hello) context.getBean("hello-prototype");
        System.out.println(helloprototype1 ==helloprototype2);

        UserServiceImpl userService= (UserServiceImpl) context.getBean("UserServiceImpl");

        System.out.println(userService.getUserDao().GetData());

        Student student =(Student) context.getBean("student");

        System.out.println(student.toString());


    }

    @Test
    public void Auto()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        People people = (People) context.getBean("people");
        people.getCat().shout();
        people.getDog().shout();

        People people1 = (People) context.getBean("people");
        people1.getCat().shout();
        people1.getDog().shout();

        PeopleAuto people2 = (PeopleAuto) context.getBean("peopleAuto");
        people2.getCat().shout();
        people2.getDog().shout();

        User user = (User)context.getBean("user");

        System.out.println(user.name + user.getAge());
    }

    @Test
    public void Config()
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(XlConfig.class);

        //通过方法来获取对象
        User user = (User)context.getBean("getUser1");
        System.out.println(user.name);
    }

    @Test
    public void Aop()
    {
        /*
        Host host = new Host();
        host.rent();
        */

/*
        Host host = new Host();
        ProxySample proxy = new ProxySample(host);
        proxy.rent();
 */

        com.xl.demo02.UserServiceImpl userService = new com.xl.demo02.UserServiceImpl();
        UserServiceProxy proxy = new UserServiceProxy();
        proxy.setUserService(userService);
        proxy.add();


    }

    @Test
    public void DymicProxy()
    {

        Host host = new Host();

        ProxyInvocationHandler proxyInvocationHandler = new ProxyInvocationHandler();
        proxyInvocationHandler.setRent(host);


        Object tempObj = proxyInvocationHandler.getProxy();
       Rent proxy = (Rent)tempObj ;
       proxy.rent();
        proxy.back();


        Host1 host1 = new Host1();
        proxyInvocationHandler.setTarget(host1);
        Object tempTarget = proxyInvocationHandler.getTarget();


        System.out.println("tempTarget    " + tempTarget.getClass().getName());

        System.out.println(tempTarget instanceof  Rent);
        System.out.println(tempTarget instanceof  Host1);
        Rent proxy1 = (Rent)tempTarget ;
        proxy1.rent();

    }


    @Test
    public void DymicAopCommon()
    {

        ProxyInvocationHandler proxyInvocationHandler = new ProxyInvocationHandler();

        Host1 host1 = new Host1();
        proxyInvocationHandler.setTarget(host1);
        Object tempTarget = proxyInvocationHandler.getTarget();

        System.out.println("tempTarget    " + tempTarget.getClass().getName());

        System.out.println(tempTarget instanceof  Rent1);
        System.out.println(tempTarget instanceof  Host1);
        Rent1 proxy1 = (Rent1)tempTarget ;
        proxy1.rent();

    }

    @Test
    public void DymicAopSpring()
    {

        //三种方式 实现面aop 添加自定义的逻辑
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        com.xl.demo04.UserService userServcie = (UserService)context.getBean("userService");
        userServcie.add();
    }

}
