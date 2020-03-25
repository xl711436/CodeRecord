package com.xl.demo01;

public class ProxySample {

    private Host host;

    public ProxySample() {
    }

    public ProxySample(Host host) {
        this.host = host;
    }


    public void rent()
    {
        seeHouse();
        host.rent();
        hetong();
        fare();
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
