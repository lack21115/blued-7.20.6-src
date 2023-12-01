package com.kuaishou.weapon.p0;

import android.content.Context;
import android.net.Proxy;
import android.os.Build;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/ah.class */
public class ah {
    public static JSONObject a(Context context) {
        int parseInt;
        String str;
        if (Build.VERSION.SDK_INT >= 14) {
            try {
                String property = System.getProperty("http.proxyHost");
                String property2 = System.getProperty("http.proxyPort");
                if (property2 == null) {
                    property2 = "-1";
                }
                parseInt = Integer.parseInt(property2);
                str = property;
            } catch (Throwable th) {
                return null;
            }
        } else {
            String host = Proxy.getHost(context);
            parseInt = Proxy.getPort(context);
            str = host;
        }
        if (TextUtils.isEmpty(str) || parseInt == -1) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("h", str);
        jSONObject.put("p", parseInt);
        return jSONObject;
    }
}
