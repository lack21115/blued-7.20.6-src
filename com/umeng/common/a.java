package com.umeng.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.pro.at;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.utils.UMUtils;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/common/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f40824a;
    private static final String b = "umeng+";

    /* renamed from: c  reason: collision with root package name */
    private static final String f40825c = "ek__id";
    private static final String d = "ek_key";
    private static String e = "";
    private static final String f = at.b().b(at.n);
    private static String g = "";
    private static a h;

    private a() {
    }

    public static a a() {
        if (h == null) {
            synchronized (a.class) {
                try {
                    if (h == null) {
                        h = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return h;
    }

    private String c(String str) {
        String str2 = "";
        try {
            String substring = str.substring(1, 9);
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= substring.length()) {
                    String sb2 = sb.toString();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(sb2);
                    sb3.append(new StringBuilder(sb2).reverse().toString());
                    str2 = sb2;
                    return sb3.toString();
                }
                char charAt = substring.charAt(i2);
                if (!Character.isDigit(charAt)) {
                    sb.append(charAt);
                } else if (Integer.parseInt(Character.toString(charAt)) == 0) {
                    sb.append(0);
                } else {
                    sb.append(10 - Integer.parseInt(Character.toString(charAt)));
                }
                i = i2 + 1;
            }
        } catch (Throwable th) {
            return str2;
        }
    }

    public String a(String str) {
        try {
            return TextUtils.isEmpty(f40824a) ? str : Base64.encodeToString(DataHelper.encrypt(str.getBytes(), f40824a.getBytes()), 0);
        } catch (Exception e2) {
            return null;
        }
    }

    public void a(Context context) {
        try {
            if (TextUtils.isEmpty(f40824a)) {
                String multiProcessSP = UMUtils.getMultiProcessSP(context, f40825c);
                if (!TextUtils.isEmpty(multiProcessSP)) {
                    e = c(multiProcessSP);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>> primaryKey: " + e);
                }
                SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f, 0);
                if (sharedPreferences != null) {
                    g = sharedPreferences.getString(f40825c, null);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程备份秘钥：主进程key: " + g);
                }
                f40824a = c(UMUtils.genId());
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>> 正式秘钥：key: " + f40824a);
            }
        } catch (Throwable th) {
        }
    }

    public String b(String str) {
        String str2 = null;
        try {
            if (!TextUtils.isEmpty(f40824a)) {
                str = new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), f40824a.getBytes()));
            }
            return str;
        } catch (Exception e2) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败!");
            if (!TextUtils.isEmpty(e)) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，换老秘钥重试");
                try {
                    str2 = new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), e.getBytes()));
                } catch (Exception e3) {
                    str2 = null;
                }
                try {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，换老秘钥重试成功。");
                    return str2;
                } catch (Exception e4) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，换老秘钥重试失败。换子进程备份key重试。");
                    try {
                        String str3 = new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), g.getBytes()));
                        try {
                            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，子进程备份key重试成功。");
                            return str3;
                        } catch (Throwable th) {
                            str2 = str3;
                            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，子进程备份key重试失败。");
                            return str2;
                        }
                    } catch (Throwable th2) {
                    }
                }
            }
            return str2;
        }
    }
}
