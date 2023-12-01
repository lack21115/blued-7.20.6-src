package com.opos.cmn.func.dl.base.exception;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/dl/base/exception/a.class */
public final class a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(int i) {
        switch (i) {
            case 1001:
                return "Http connect error";
            case 1002:
                return "Redirect over 5 times error";
            case 1003:
                return "No network!";
            case 1004:
                return "Write file error";
            case 1005:
                return "MD5 check error!server MD5=%1$s,local file MD5=%2$s";
            case 1006:
                return "No enough space error";
            case 1007:
                return "Download url illegal";
            case 1008:
                return "No read/write storage permisssion";
            case 1009:
                return "Temp file not exist!";
            case 1010:
                return "Lenght check error!server lenght=%1$s,local file lenght=%2$s";
            case 1011:
                return "Bind service overtime";
            case 1012:
                return "Service has been killed";
            case 1013:
                return "Not allow mobile download!";
            case 1014:
                return "Network need login!";
            default:
                return "Unknow error";
        }
    }
}
