package com.example.myapplication2.gridview;

import java.util.ArrayList;

public class Be_GridViewInfo {
    public String Str_Title,Str_Url;

    public static ArrayList<Be_GridViewInfo> GetTestList()
    {
        ArrayList<Be_GridViewInfo> curList = new ArrayList<>();

        Be_GridViewInfo tempInfo = new Be_GridViewInfo();
        tempInfo.Str_Title ="1111";
        tempInfo.Str_Url = "https://img.expreview.com/news/2020/02/08/image-20200208222646399.png";
        curList.add(tempInfo);

        tempInfo = new Be_GridViewInfo();
        tempInfo.Str_Title ="2222";
        tempInfo.Str_Url = "https://i1.sinaimg.cn/dy/deco/2013/0329/logo/LOGO_1x.png";
        curList.add(tempInfo);

        tempInfo = new Be_GridViewInfo();
        tempInfo.Str_Title ="3333";
        tempInfo.Str_Url = "https://img.expreview.com/news/2020/02/08/image-20200208222646399.png";
        curList.add(tempInfo);

        tempInfo = new Be_GridViewInfo();
        tempInfo.Str_Title ="4444";
        tempInfo.Str_Url = "https://i1.sinaimg.cn/dy/deco/2013/0329/logo/LOGO_1x.png";
        curList.add(tempInfo);

        tempInfo = new Be_GridViewInfo();
        tempInfo.Str_Title ="555";
        tempInfo.Str_Url = "https://img.expreview.com/news/2020/02/08/image-20200208222646399.png";
        curList.add(tempInfo);


        tempInfo.Str_Title ="6666";
        tempInfo.Str_Url = "https://i1.sinaimg.cn/dy/deco/2013/0329/logo/LOGO_1x.png";
        curList.add(tempInfo);

        tempInfo = new Be_GridViewInfo();
        tempInfo.Str_Title ="7777";
        tempInfo.Str_Url = "https://img.expreview.com/news/2020/02/08/image-20200208222646399.png";
        curList.add(tempInfo);

        tempInfo = new Be_GridViewInfo();
        tempInfo.Str_Title ="8888";
        tempInfo.Str_Url = "https://i1.sinaimg.cn/dy/deco/2013/0329/logo/LOGO_1x.png";
        curList.add(tempInfo);

        tempInfo = new Be_GridViewInfo();
        tempInfo.Str_Title ="9999";
        tempInfo.Str_Url = "https://img.expreview.com/news/2020/02/08/image-20200208222646399.png";
        curList.add(tempInfo);

        tempInfo = new Be_GridViewInfo();
        tempInfo.Str_Title ="10";
        tempInfo.Str_Url = "https://i1.sinaimg.cn/dy/deco/2013/0329/logo/LOGO_1x.png";
        curList.add(tempInfo);

        return curList;
    }

}

