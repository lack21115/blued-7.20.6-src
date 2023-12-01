package com.bytedance.bdtracker;

import android.app.Application;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.bytedance.applog.IExtraParams;
import com.bytedance.applog.Level;
import com.bytedance.applog.UriConfig;
import com.bytedance.applog.util.SensitiveUtils;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.umeng.analytics.pro.bh;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/r1.class */
public final class r1 {

    /* renamed from: c  reason: collision with root package name */
    public static final a[] f7688c = {new a("aid", "aid", String.class), new a("google_aid", "google_aid", String.class), new a(bh.P, bh.P, String.class), new a("mcc_mnc", "mcc_mnc", String.class), new a("sim_region", "sim_region", String.class), new a("device_id", "device_id", String.class), new a("bd_did", "bd_did", String.class), new a("install_id", "iid", String.class), new a("clientudid", "clientudid", String.class), new a("app_name", "app_name", String.class), new a("app_version", NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, String.class), new a("version_code", "version_code", Integer.class), new a("manifest_version_code", "manifest_version_code", Integer.class), new a("update_version_code", "update_version_code", Integer.class), new a("sdk_version_code", "sdk_version_code", Integer.class)};

    /* renamed from: a  reason: collision with root package name */
    public volatile IExtraParams f7689a;
    public final c b;

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/r1$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f7690a;
        public final String b;

        /* renamed from: c  reason: collision with root package name */
        public final Class f7691c;

        public a(String str, String str2, Class cls) {
            this.f7690a = str;
            this.b = str2;
            this.f7691c = cls;
        }
    }

    public r1(c cVar) {
        this.b = cVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T a(JSONObject jSONObject, String str, T t, Class<T> cls) {
        if (jSONObject == null) {
            c cVar = this.b;
            T t2 = null;
            if (cVar.o != null) {
                t2 = cVar.o.a(str, (String) t, (Class<String>) cls);
            }
            return t2;
        }
        Object opt = jSONObject.opt(str);
        T t3 = null;
        if (opt != null) {
            t3 = null;
            if (cls != null) {
                try {
                    t3 = cls.cast(opt);
                } catch (Throwable th) {
                    z2.c("U SHALL NOT PASS!", th);
                    t3 = null;
                }
            }
        }
        return t3 == null ? t : t3;
    }

    public String a(JSONObject jSONObject, String str, boolean z, Level level) {
        if (this.b.m != null && !TextUtils.isEmpty(str)) {
            Uri parse = Uri.parse(str);
            Set<String> queryParameterNames = parse.getQueryParameterNames();
            Uri.Builder buildUpon = parse.buildUpon();
            HashMap hashMap = new HashMap();
            a(jSONObject, z, hashMap, level);
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (!queryParameterNames.contains(key) && !TextUtils.isEmpty(value)) {
                    buildUpon.appendQueryParameter(key, entry.getValue());
                }
            }
            return buildUpon.build().toString();
        }
        return str;
    }

    public void a(JSONObject jSONObject, boolean z, Map<String, String> map, Level level) {
        Application application = this.b.m;
        if (application == null || map == null || level == null) {
            return;
        }
        map.put("_rticket", String.valueOf(System.currentTimeMillis()));
        map.put("device_platform", "android");
        if (z) {
            map.put("ssmix", "a");
        }
        if (TextUtils.isEmpty(a3.f7583a)) {
            DisplayMetrics displayMetrics = application.getResources().getDisplayMetrics();
            int i = displayMetrics == null ? 0 : displayMetrics.widthPixels;
            DisplayMetrics displayMetrics2 = application.getResources().getDisplayMetrics();
            int i2 = displayMetrics2 == null ? 0 : displayMetrics2.heightPixels;
            if (i > 0 && i2 > 0) {
                a3.f7583a = i + "*" + i2;
            }
        }
        String str = a3.f7583a;
        if (!TextUtils.isEmpty(str)) {
            map.put("resolution", str);
        }
        if (a3.b == -1) {
            a3.b = application.getApplicationContext().getResources().getDisplayMetrics().densityDpi;
        }
        int i3 = a3.b;
        if (i3 > 0) {
            map.put("dpi", String.valueOf(i3));
        }
        map.put(bh.ai, Build.MODEL);
        map.put(bh.F, Build.BRAND);
        map.put("language", application.getResources().getConfiguration().locale.getLanguage());
        map.put("os_api", String.valueOf(Build.VERSION.SDK_INT));
        String str2 = Build.VERSION.RELEASE;
        String str3 = str2;
        if (str2 != null) {
            str3 = str2;
            if (str2.length() > 10) {
                str3 = str2.substring(0, 10);
            }
        }
        map.put("os_version", str3);
        String c2 = s2.c(application);
        int i4 = 0;
        if (!TextUtils.isEmpty(c2)) {
            map.put("ac", c2);
            i4 = 0;
        }
        while (true) {
            a[] aVarArr = f7688c;
            if (i4 >= aVarArr.length) {
                break;
            }
            a aVar = aVarArr[i4];
            Object a2 = a(jSONObject, aVar.f7690a, (String) null, aVar.f7691c);
            if (a2 != null) {
                map.put(aVar.b, a2.toString());
            }
            i4++;
        }
        String str4 = (String) a(jSONObject, "tweaked_channel", "", String.class);
        String str5 = str4;
        if (TextUtils.isEmpty(str4)) {
            str5 = (String) a(jSONObject, "channel", "", String.class);
        }
        if (!TextUtils.isEmpty(str5)) {
            map.put("channel", str5);
        }
        String str6 = (String) a(jSONObject, "cdid", (String) null, String.class);
        if (!TextUtils.isEmpty(str6)) {
            map.put("cdid", str6);
        }
        SensitiveUtils.appendSensitiveParams(this, jSONObject, map, u2.a(application), level);
        if (level == Level.L0) {
            String str7 = (String) a(jSONObject, "openudid", (String) null, String.class);
            if (!TextUtils.isEmpty(str7)) {
                map.put("openudid", str7);
            }
        }
        this.b.getAppContext();
        try {
            HashMap<String, String> extraParams = this.f7689a == null ? null : this.f7689a.getExtraParams(level);
            if (extraParams == null || extraParams.isEmpty()) {
                return;
            }
            for (Map.Entry<String, String> entry : extraParams.entrySet()) {
                if (entry != null) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value) && !map.containsKey(key)) {
                        map.put(key, value);
                    }
                }
            }
        } catch (Exception e) {
            z2.c("U SHALL NOT PASS!", e);
        }
    }

    public String[] a(v vVar, JSONObject jSONObject, boolean z, int i) {
        String[] sendUris;
        UriConfig c2 = vVar.c();
        if (z) {
            sendUris = c2.getRealUris();
        } else {
            if (i != 0) {
                if (i != 1) {
                    sendUris = new String[0];
                } else if (!TextUtils.isEmpty(c2.getBusinessUri())) {
                    sendUris = new String[]{c2.getBusinessUri()};
                }
            }
            sendUris = c2.getSendUris();
        }
        int length = sendUris.length;
        String[] strArr = new String[length];
        boolean z2 = this.b.A;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return strArr;
            }
            strArr[i3] = sendUris[i3];
            if (z2) {
                strArr[i3] = com.bytedance.bdtracker.a.a(new StringBuilder(), strArr[i3], "?tt_data=a");
            }
            strArr[i3] = a(jSONObject, strArr[i3], true, Level.L1);
            strArr[i3] = q1.a(strArr[i3], p2.f7681c);
            i2 = i3 + 1;
        }
    }
}
