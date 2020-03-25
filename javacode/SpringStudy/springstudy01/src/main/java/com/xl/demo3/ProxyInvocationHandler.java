package com.xl.demo3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//基于接口的动态代理
public class ProxyInvocationHandler  implements InvocationHandler {

    private Rent rent;

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    private Object target;
    public void setTarget(Object target) {
        this.target = target;
    }


    public Object getProxy()
    {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),rent.getClass().getInterfaces(),this);
    }

    public Object getTarget()
    {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println(proxy.getClass().getName() + "---" + method.getName());
      //  Object result =  method.invoke(rent  ,args);

        Object result =  method.invoke(target  ,args);
        return result;
    }



    public void seeHouse()
    {
        System.out.println("中介带你看房");
    }

    public void hetong()
    {
        System.out.println("中介带你签合同");
    }

    public void fare()
    {
        System.out.println("中介收费");
    }
}
