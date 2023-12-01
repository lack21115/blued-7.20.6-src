package com.zx.a.I8b7;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.oplus.quickgame.sdk.hall.Constant;
import com.umeng.analytics.pro.bh;
import com.umeng.commonsdk.framework.UMModuleRegister;
import com.xiaomi.mipush.sdk.Constants;
import com.youzan.androidsdk.tool.AppSigning;
import com.zx.a.I8b7.u1;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/t2.class */
public class t2 {
    public static String A;
    public static String B;

    /* renamed from: a  reason: collision with root package name */
    public static Context f28510a;
    public static String b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f28511c = "";
    public static String d = "";
    public static String e;
    public static String f = "";
    public static String g = "";
    public static String h;
    public static String i;
    public static String j;
    public static int k = 0;
    public static String l = "ANDROID-V3";
    public static boolean m;
    public static SecretKey s;
    public static IvParameterSpec t;
    public static String u;
    public static String v;
    public static String w;
    public static String x;
    public static String y;
    public static String z;
    public static HashMap<String, String> n = new HashMap<>();
    public static int o = 1;
    public static int p = 1;
    public static int q = -1;
    public static long r = 0;
    public static JSONObject C = new JSONObject();
    public static volatile boolean D = false;
    public static final Set<String> E = Collections.newSetFromMap(new ConcurrentHashMap());
    public static final Set<String> F = Collections.newSetFromMap(new ConcurrentHashMap());
    public static Bundle G = null;

    public static String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(bh.al, i);
            jSONObject.put("ext", j);
        } catch (JSONException e2) {
            z1.a(e2);
        }
        return jSONObject.toString();
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        return split.length == 2 ? split[0] : "";
    }

    public static void a(Context context) throws Exception {
        Context applicationContext = context.getApplicationContext();
        f28510a = applicationContext;
        g = applicationContext.getPackageName();
        i1.c(f28510a);
        f = i1.a(f28510a);
        StringBuilder a2 = m2.a("initAppId: ");
        a2.append(f);
        z1.a(a2.toString());
        b(f28510a);
        if (TextUtils.isEmpty(h)) {
            b();
        } else {
            String a3 = k.a(d3.b() + Build.MODEL, AppSigning.SHA256);
            String[] split = h.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            if (split.length < 2) {
                StringBuilder a4 = m2.a("ZXID 检测到老版本LID:");
                a4.append(h);
                m.a(a4.toString());
                h += Constants.ACCEPT_TIME_SEPARATOR_SERVER + a3;
                u1 u1Var = u1.a.f28517a;
                b3 b3Var = u1Var.f28516a;
                String str = h;
                b3Var.getClass();
                if (!TextUtils.equals(str, h)) {
                    h = str;
                    u1Var.f28516a.a(0, str, true);
                }
                StringBuilder a5 = m2.a("ZXID 兼容老版本LID后重新生成LID:");
                a5.append(h);
                m.a(a5.toString());
            } else if (TextUtils.equals(a3, split[1])) {
                m.a("ZXID LID校验通过!");
            } else {
                b3 b3Var2 = u1.a.f28517a.f28516a;
                if (b3Var2.b == null) {
                    b3Var2.b = b3Var2.d();
                }
                try {
                    b3Var2.b.delete("zx_table", "key in(0,1,3,4,6,11,12,15,21,22,23,24,25,26,19,13,14)", null);
                    h = "";
                    i = "";
                    j = "";
                    k = 0;
                    l = "ANDROID-V3";
                    m = false;
                    u = "";
                    v = "";
                    w = "";
                    A = "";
                    o = 1;
                    x = "";
                    z1.a("ZXID清理数据成功");
                } catch (Exception e2) {
                    StringBuilder a6 = m2.a("清理本地数据error:");
                    a6.append(e2.getMessage());
                    z1.b(a6.toString());
                }
                b();
                m.a("ZXID LID校验不通过");
            }
        }
        n = d3.h();
        a0.i();
    }

    public static void b() {
        String str = UUID.randomUUID().toString().replaceAll(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "") + Constants.ACCEPT_TIME_SEPARATOR_SERVER + k.a(d3.b() + Build.MODEL, AppSigning.SHA256);
        u1 u1Var = u1.a.f28517a;
        u1Var.f28516a.getClass();
        if (!TextUtils.equals(str, h)) {
            h = str;
            u1Var.f28516a.a(0, str, true);
        }
        m.a("ZXID 生成LID:" + str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:233:0x059e, code lost:
        if (r9 != null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:272:0x060c, code lost:
        if (r0 == 19) goto L47;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void b(android.content.Context r9) {
        /*
            Method dump skipped, instructions count: 1554
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zx.a.I8b7.t2.b(android.content.Context):void");
    }

    public static void c() {
        try {
            if (z == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject(z);
            JSONArray optJSONArray = jSONObject.optJSONArray(UMModuleRegister.INNER);
            JSONArray optJSONArray2 = jSONObject.optJSONArray(Constant.Param.KEY_RPK_EXTERNAL);
            if (optJSONArray != null) {
                Set<String> set = E;
                set.clear();
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= optJSONArray.length()) {
                        break;
                    }
                    set.add(optJSONArray.getString(i3));
                    i2 = i3 + 1;
                }
            }
            if (optJSONArray2 == null) {
                return;
            }
            Set<String> set2 = F;
            set2.clear();
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= optJSONArray2.length()) {
                    return;
                }
                set2.add(optJSONArray2.getString(i5));
                i4 = i5 + 1;
            }
        } catch (JSONException e2) {
            z1.a(e2);
        }
    }
}
