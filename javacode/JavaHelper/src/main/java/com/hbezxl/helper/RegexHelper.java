package com.hbezxl.helper;

import java.util.regex.Pattern;

public class RegexHelper {


    public static boolean IsMobileNumber(String I_MobileNumber) {
        boolean R_Result = false;
        R_Result = Pattern.matches("(86)?0?1\\d{10}", I_MobileNumber);
        return R_Result;
    }


    /*
    xxxxxx yyyy MM dd 375 0     十八位
xxxxxx    yy MM dd   75 0     十五位
地区： [1-9]\d{5}
年的前两位： (18|19|20)            1800-2099
年的后两位： \d{2}
月份： ((0[1-9])|(10|11|12))
天数： (([0-2][1-9])|10|20|30|31)          闰年不能禁止29+
三位顺序码： \d{3}
两位顺序码： \d{2}
校验码： [0-9Xx]
     */
    public static boolean IsIDCard(String I_IDCardNumber) {
        boolean R_Result = false;
        R_Result = Pattern.matches("(^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{2}$)", I_IDCardNumber);
        return R_Result;
    }

    public static boolean IsEmail(String I_Email) {
        boolean R_Result = false;
        R_Result = Pattern.matches("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$", I_Email);
        return R_Result;
    }

    public static boolean IsUrl(String I_Url) {
        boolean R_Result = false;
        R_Result = Pattern.matches("^([hH][tT]{2}[pP]://|[hH][tT]{2}[pP][sS]://|[fF][tT][pP]://)(([A-Za-z0-9-~]+).)+([A-Za-z0-9-~\\/])+(\\?{0,1}(([A-Za-z0-9-~]+\\={0,1})([A-Za-z0-9-~]*)\\&{0,1})*)$", I_Url);
        return R_Result;
    }

    public static boolean IsIp(String I_Ip) {
        boolean R_Result = false;
        R_Result = Pattern.matches("^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$"
               , I_Ip);
        return R_Result;
    }
}
