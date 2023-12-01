package com.alipay.sdk.sys;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alipay.sdk.app.statistic.c;
import com.alipay.sdk.util.n;
import com.android.internal.content.NativeLibraryHelper;
import com.anythink.core.api.ATAdConst;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/sys/a.class */
public class a {
    public static final String a = "\"&";
    public static final String b = "&";
    public static final String c = "bizcontext=\"";
    public static final String d = "bizcontext=";
    public static final String e = "\"";
    public static final String f = "appkey";
    public static final String g = "ty";
    public static final String h = "sv";
    public static final String i = "an";
    public static final String j = "setting";
    public static final String k = "av";
    public static final String l = "sdk_start_time";
    public static final String m = "extInfo";
    public static final String n = "ap_link_token";
    public static final String o = "UTF-8";
    public final String p;
    public final long q;
    public final String r;
    public final c s;
    private String t;
    private String u;
    private Context v;

    /* renamed from: com.alipay.sdk.sys.a$a  reason: collision with other inner class name */
    /* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/sys/a$a.class */
    public static final class C0010a {
        private static final HashMap<UUID, a> a = new HashMap<>();
        private static final HashMap<String, a> b = new HashMap<>();
        private static final String c = "i_uuid_b_c";

        public static a a(Intent intent) {
            if (intent == null) {
                return null;
            }
            Serializable serializableExtra = intent.getSerializableExtra(c);
            if (serializableExtra instanceof UUID) {
                return a.remove((UUID) serializableExtra);
            }
            return null;
        }

        public static a a(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return b.remove(str);
        }

        public static void a(a aVar, Intent intent) {
            if (aVar == null || intent == null) {
                return;
            }
            UUID randomUUID = UUID.randomUUID();
            a.put(randomUUID, aVar);
            intent.putExtra(c, randomUUID);
        }

        public static void a(a aVar, String str) {
            if (aVar == null || TextUtils.isEmpty(str)) {
                return;
            }
            b.put(str, aVar);
        }
    }

    public a(Context context, String str, String str2) {
        this.t = "";
        this.u = "";
        this.v = null;
        boolean isEmpty = TextUtils.isEmpty(str2);
        this.s = new c(context, isEmpty);
        this.p = c(str, this.u);
        this.q = SystemClock.elapsedRealtime();
        this.r = str2;
        if (!isEmpty) {
            com.alipay.sdk.app.statistic.a.b(this, c.b, "eptyp", str2 + "|" + this.p);
        }
        try {
            this.v = context.getApplicationContext();
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            this.t = packageInfo.versionName;
            this.u = packageInfo.packageName;
        } catch (Exception e2) {
            com.alipay.sdk.util.c.a(e2);
        }
        if (isEmpty) {
            return;
        }
        com.alipay.sdk.app.statistic.a.b(this, c.b, c.J, "" + SystemClock.elapsedRealtime());
        com.alipay.sdk.app.statistic.a.a(context, this, str, this.p);
    }

    public static a a() {
        return null;
    }

    private String a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(str2);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= split.length) {
                return null;
            }
            if (!TextUtils.isEmpty(split[i3]) && split[i3].startsWith(str3)) {
                return split[i3];
            }
            i2 = i3 + 1;
        }
    }

    private String a(String str, String str2, String str3, boolean z) throws JSONException, UnsupportedEncodingException {
        JSONObject jSONObject;
        String substring = str.substring(str2.length());
        boolean z2 = false;
        String substring2 = substring.substring(0, substring.length() - str3.length());
        if (substring2.length() >= 2 && substring2.startsWith("\"") && substring2.endsWith("\"")) {
            jSONObject = new JSONObject(substring2.substring(1, substring2.length() - 1));
            z2 = true;
        } else {
            jSONObject = new JSONObject(substring2);
        }
        if (!jSONObject.has(f)) {
            jSONObject.put(f, com.alipay.sdk.cons.a.f);
        }
        if (!jSONObject.has(g)) {
            jSONObject.put(g, "and_lite");
        }
        if (!jSONObject.has(h)) {
            jSONObject.put(h, "h.a.3.7.4");
        }
        if (!jSONObject.has(i) && (!this.u.contains(j) || !n.b(this.v))) {
            jSONObject.put(i, this.u);
        }
        if (!jSONObject.has(k)) {
            jSONObject.put(k, this.t);
        }
        if (!jSONObject.has(l)) {
            jSONObject.put(l, System.currentTimeMillis());
        }
        if (!jSONObject.has(m)) {
            jSONObject.put(m, c());
        }
        String jSONObject2 = jSONObject.toString();
        String str4 = jSONObject2;
        if (z2) {
            str4 = "\"" + jSONObject2 + "\"";
        }
        return str2 + str4 + str3;
    }

    public static HashMap<String, String> a(a aVar) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (aVar != null) {
            hashMap.put("sdk_ver", "15.7.4");
            hashMap.put(ATAdConst.KEY.APP_NAME, aVar.u);
            hashMap.put("token", aVar.p);
            hashMap.put("call_type", aVar.r);
            hashMap.put("ts_api_invoke", String.valueOf(aVar.q));
        }
        return hashMap;
    }

    private String b(String str, String str2) throws JSONException, UnsupportedEncodingException {
        String a2 = a("", "");
        return str + a2 + str2;
    }

    private boolean b(String str) {
        return !str.contains(a);
    }

    private String c(String str) {
        try {
            String a2 = a(str, b, d);
            if (TextUtils.isEmpty(a2)) {
                return str + b + b(d, "");
            }
            int indexOf = str.indexOf(a2);
            String substring = str.substring(0, indexOf);
            String substring2 = str.substring(indexOf + a2.length());
            return substring + a(a2, d, "", true) + substring2;
        } catch (Throwable th) {
            return str;
        }
    }

    private static String c(String str, String str2) {
        try {
            Locale locale = Locale.getDefault();
            String str3 = str;
            if (str == null) {
                str3 = "";
            }
            String str4 = str2;
            if (str2 == null) {
                str4 = "";
            }
            return String.format("EP%s%s_%s", "1", n.f(String.format(locale, "%s%s%d%s", str3, str4, Long.valueOf(System.currentTimeMillis()), UUID.randomUUID().toString())), Long.valueOf(System.currentTimeMillis()));
        } catch (Throwable th) {
            return NativeLibraryHelper.CLEAR_ABI_OVERRIDE;
        }
    }

    private JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(n, this.p);
            return jSONObject;
        } catch (Throwable th) {
            return jSONObject;
        }
    }

    private String d(String str) {
        try {
            String a2 = a(str, a, c);
            if (TextUtils.isEmpty(a2)) {
                return str + b + b(c, "\"");
            }
            String str2 = a2;
            if (!a2.endsWith("\"")) {
                str2 = a2 + "\"";
            }
            int indexOf = str.indexOf(str2);
            return str.substring(0, indexOf) + a(str2, c, "\"", false) + str.substring(indexOf + str2.length());
        } catch (Throwable th) {
            return str;
        }
    }

    public String a(String str) {
        if (!TextUtils.isEmpty(str) && !str.startsWith("new_external_info==")) {
            return b(str) ? c(str) : d(str);
        }
        return str;
    }

    public String a(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(f, com.alipay.sdk.cons.a.f);
            jSONObject.put(g, "and_lite");
            jSONObject.put(h, "h.a.3.7.4");
            if (!this.u.contains(j) || !n.b(this.v)) {
                jSONObject.put(i, this.u);
            }
            jSONObject.put(k, this.t);
            jSONObject.put(l, System.currentTimeMillis());
            jSONObject.put(m, c());
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put(str, str2);
            }
            return jSONObject.toString();
        } catch (Throwable th) {
            com.alipay.sdk.util.c.a(th);
            return "";
        }
    }

    public Context b() {
        return this.v;
    }
}
