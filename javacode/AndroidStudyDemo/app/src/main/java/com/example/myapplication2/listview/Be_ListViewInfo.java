package com.example.myapplication2.listview;

import java.util.ArrayList;

public class Be_ListViewInfo {

    public String Str_Title,Str_Time,Str_Url;

    public static ArrayList<Be_ListViewInfo> GetTestList()
    {
        ArrayList<Be_ListViewInfo> curList = new ArrayList<>();

        Be_ListViewInfo tempInfo = new Be_ListViewInfo();
        tempInfo.Str_Title ="1111";
        tempInfo.Str_Time = "2011-11-11";
        tempInfo.Str_Url = "https://img.expreview.com/news/2020/02/08/image-20200208222646399.png";
        curList.add(tempInfo);

        tempInfo = new Be_ListViewInfo();
        tempInfo.Str_Title ="2222";
        tempInfo.Str_Time = "2011-12-12";
        tempInfo.Str_Url = "https://i1.sinaimg.cn/dy/deco/2013/0329/logo/LOGO_1x.png";
        curList.add(tempInfo);

        tempInfo = new Be_ListViewInfo();
        tempInfo.Str_Title ="3333";
        tempInfo.Str_Time = "2011-3-3";
        tempInfo.Str_Url = "https://img.expreview.com/news/2020/02/08/image-20200208222646399.png";
        curList.add(tempInfo);

        tempInfo = new Be_ListViewInfo();
        tempInfo.Str_Title ="4444";
        tempInfo.Str_Time = "2011-4-4";
        tempInfo.Str_Url = "https://i1.sinaimg.cn/dy/deco/2013/0329/logo/LOGO_1x.png";
        curList.add(tempInfo);

        tempInfo = new Be_ListViewInfo();
        tempInfo.Str_Title ="555";
        tempInfo.Str_Time = "2011-5-5";
        tempInfo.Str_Url = "https://img.expreview.com/news/2020/02/08/image-20200208222646399.png";
        curList.add(tempInfo);


        tempInfo.Str_Title ="6666";
        tempInfo.Str_Time = "2011-66-666";
        tempInfo.Str_Url = "https://i1.sinaimg.cn/dy/deco/2013/0329/logo/LOGO_1x.png";
        curList.add(tempInfo);

        tempInfo = new Be_ListViewInfo();
        tempInfo.Str_Title ="7777";
        tempInfo.Str_Time = "2011-7-7";
        tempInfo.Str_Url = "https://img.expreview.com/news/2020/02/08/image-20200208222646399.png";
        curList.add(tempInfo);

        tempInfo = new Be_ListViewInfo();
        tempInfo.Str_Title ="8888";
        tempInfo.Str_Time = "2011-8-8";
        tempInfo.Str_Url = "https://i1.sinaimg.cn/dy/deco/2013/0329/logo/LOGO_1x.png";
        curList.add(tempInfo);

        tempInfo = new Be_ListViewInfo();
        tempInfo.Str_Title ="9999";
        tempInfo.Str_Time = "2011-9-9";
        tempInfo.Str_Url = "https://img.expreview.com/news/2020/02/08/image-20200208222646399.png";
        curList.add(tempInfo);

        tempInfo = new Be_ListViewInfo();
        tempInfo.Str_Title ="10";
        tempInfo.Str_Time = "2011-10-10";
        tempInfo.Str_Url = "https://i1.sinaimg.cn/dy/deco/2013/0329/logo/LOGO_1x.png";
        curList.add(tempInfo);

        return curList;
    }

}
