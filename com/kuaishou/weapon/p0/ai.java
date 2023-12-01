package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/ai.class */
public class ai {
    private static final String[] b = {"/data/local/", "/data/local/bin/", "/data/local/xbin/", "/sbin/", "/su/bin/", "/system/bin/", "/system/bin/.ext/", "/system/bin/failsafe/", "/system/sd/xbin/", "/system/usr/we-need-root/", "/system/xbin/", "/cache/", "/data/", "/dev/"};

    /* renamed from: a  reason: collision with root package name */
    private Context f23720a;

    public ai(Context context) {
        this.f23720a = context;
    }

    private String[] a(String[] strArr) {
        String str;
        ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
        try {
            str = System.getenv("PATH");
        } catch (Exception e) {
        }
        if (str != null && !"".equals(str)) {
            String[] split = str.split(":");
            int length = split.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                String str2 = split[i2];
                String str3 = str2;
                if (!str2.endsWith(BridgeUtil.SPLIT_MARK)) {
                    str3 = str2 + '/';
                }
                if (!arrayList.contains(str3)) {
                    arrayList.add(str3);
                }
                i = i2 + 1;
            }
            return (String[]) arrayList.toArray(new String[0]);
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static boolean b() {
        try {
            String a2 = bg.a("ro.build.display.id");
            if (TextUtils.isEmpty(a2)) {
                return false;
            }
            if (a2.contains("flyme")) {
                return true;
            }
            return a2.toLowerCase().contains("flyme");
        } catch (Exception e) {
            return false;
        }
    }

    public int a() {
        boolean z;
        try {
            String[] a2 = a(bh.z);
            int length = a2.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    z = false;
                    break;
                } else if (new File(a2[i2], bh.y).exists()) {
                    z = true;
                    break;
                } else {
                    i = i2 + 1;
                }
            }
            return z ? 1 : 0;
        } catch (Exception e) {
            return 0;
        }
    }

    public String a(String str) {
        try {
            return aa.a().b(str).replace("\n", "");
        } catch (Exception e) {
            return "";
        }
    }

    public String c() {
        try {
            if (Build.VERSION.SDK_INT > 29) {
                return null;
            }
            return aa.a().b("su -v").replace("\n", "");
        } catch (Exception e) {
            return null;
        }
    }

    public int d() {
        String a2 = aa.a().a("ro.secure");
        return (a2 == null || !"0".equals(a2)) ? 1 : 0;
    }

    public int e() {
        String a2 = aa.a().a("ro.debuggable");
        return (a2 == null || !"0".equals(a2)) ? 1 : 0;
    }

    public int f() {
        String a2 = aa.a().a("ro.adb.secure");
        return (a2 == null || !"0".equals(a2)) ? 1 : 0;
    }

    public JSONObject g() {
        try {
            JSONObject jSONObject = new JSONObject();
            String a2 = a(" which su ");
            if (TextUtils.isEmpty(a2) || a2.length() <= 2) {
                jSONObject.put("0", 0);
            } else {
                jSONObject.put("0", 1);
                jSONObject.put("0-p", a2);
            }
            String a3 = a(" id ");
            if (!TextUtils.isEmpty(a3)) {
                if (a3.toLowerCase().contains("uid=0")) {
                    jSONObject.put("1", 1);
                } else {
                    jSONObject.put("1", 0);
                }
            }
            String a4 = a(" busybox df ");
            if (!TextUtils.isEmpty(a4) && !a4.contains("not found")) {
                if (a4.length() > 30) {
                    jSONObject.put("2", 1);
                } else {
                    jSONObject.put("2", 0);
                }
            }
            if (jSONObject.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public int h() {
        return new File("/system/app/Superuser.apk").exists() ? 1 : 0;
    }

    public String i() {
        String[] strArr = b;
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return "";
            }
            String str = strArr[i2];
            if (new File(str, "magisk").exists()) {
                return str + "magisk";
            }
            i = i2 + 1;
        }
    }

    public String j() {
        String[] strArr = b;
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return "";
            }
            String str = strArr[i2];
            if (new File(str, bh.y).exists()) {
                return str + bh.y;
            }
            i = i2 + 1;
        }
    }

    public String k() {
        String str;
        StackTraceElement stackTraceElement;
        try {
            throw new Exception("");
        } catch (Exception e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            int length = stackTrace.length;
            int i = 0;
            while (true) {
                int i2 = i;
                str = "";
                if (i2 >= length) {
                    break;
                }
                stackTraceElement = stackTrace[i2];
                if (stackTraceElement.getClassName().equals("com.android.internal.os.ZygoteInit") || stackTraceElement.getMethodName().equals("invoked") || stackTraceElement.getMethodName().equals("main") || stackTraceElement.getMethodName().equals("handleHookedMethod")) {
                    break;
                }
                i = i2 + 1;
            }
            str = stackTraceElement.getClassName();
            return str;
        }
    }
}
