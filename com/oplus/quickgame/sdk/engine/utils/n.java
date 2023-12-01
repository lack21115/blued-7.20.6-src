package com.oplus.quickgame.sdk.engine.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.umeng.analytics.pro.bh;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/quickgame/sdk/engine/utils/n.class */
public class n {
    public static int a() {
        return 1010;
    }

    private static int a(Context context) {
        Object obj;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(c.a("Y29tLmhleXRhcC54Z2FtZQ=="), 128);
            if (applicationInfo == null || (obj = applicationInfo.metaData.get(bh.aj)) == null || !(obj instanceof Integer)) {
                return -1;
            }
            return ((Integer) obj).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    private static boolean a(Context context, String str) {
        try {
            return context.getPackageManager().getApplicationInfo(c.a("Y29tLmhleXRhcC54Z2FtZQ=="), 128).packageName.equals(str);
        } catch (Exception e) {
            return false;
        }
    }

    private static int b(Context context) {
        Object obj;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(c.a("Y29tLmhleXRhcC54Z2FtZQ=="), 128);
            if (applicationInfo == null || (obj = applicationInfo.metaData.get("biz_version")) == null || !(obj instanceof Integer)) {
                return -1;
            }
            return ((Integer) obj).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static String c(Context context) {
        String str;
        String str2;
        try {
            String a2 = c.a("Y29tLmhleXRhcC54Z2FtZQ==");
            String str3 = context.getPackageManager().getPackageInfo(a2, 0).versionName;
            String str4 = str3;
            if (str3.contains(BridgeUtil.UNDERLINE_STR)) {
                str4 = str3.substring(0, str3.indexOf(BridgeUtil.UNDERLINE_STR));
            }
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(a2, 128);
            StringBuilder sb = new StringBuilder();
            sb.append(str4);
            if (applicationInfo.metaData.get(bh.aj) == null) {
                str = "";
            } else {
                str = BridgeUtil.UNDERLINE_STR + applicationInfo.metaData.get(bh.aj);
            }
            sb.append(str);
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb2);
            if (applicationInfo.metaData.get("versionCommit") == null) {
                str2 = "";
            } else {
                str2 = BridgeUtil.UNDERLINE_STR + applicationInfo.metaData.get("versionCommit");
            }
            sb3.append(str2);
            return sb3.toString();
        } catch (PackageManager.NameNotFoundException e) {
            return "";
        }
    }

    public static int d(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(c.a("Y29tLmhleXRhcC54Z2FtZQ=="), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return -1;
        }
    }

    private static int e(Context context) {
        Object obj;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(c.a("Y29tLmhleXRhcC54Z2FtZQ=="), 128);
            if (applicationInfo == null || (obj = applicationInfo.metaData.get("platformVersion")) == null || !(obj instanceof Integer)) {
                return -1;
            }
            return ((Integer) obj).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static String f(Context context) {
        String str = "-1";
        if (g(context)) {
            int e = e(context);
            int a2 = a(context);
            int b = b(context);
            str = "-1";
            if (-1 != e) {
                str = "-1";
                if (-1 != a2) {
                    if (-1 == b) {
                        return "-1";
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(a2);
                    sb.append(BridgeUtil.SPLIT_MARK);
                    sb.append(e);
                    sb.append(BridgeUtil.SPLIT_MARK);
                    sb.append(b);
                    try {
                        return URLEncoder.encode(sb.toString(), "UTF-8");
                    } catch (UnsupportedEncodingException e2) {
                        str = sb.toString();
                    }
                }
            }
        }
        return str;
    }

    public static boolean g(Context context) {
        return a(context, c.a("Y29tLmhleXRhcC54Z2FtZQ=="));
    }
}
