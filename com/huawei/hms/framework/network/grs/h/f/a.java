package com.huawei.hms.framework.network.grs.h.f;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.IoUtils;
import com.huawei.hms.framework.common.Logger;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/framework/network/grs/h/f/a.class */
public class a {
    public static HttpsURLConnection a(String str, Context context, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        URLConnection openConnection = new URL(str).openConnection();
        if (!(openConnection instanceof HttpsURLConnection)) {
            Logger.w("URLConnectionHelper", "urlConnection is not an instance of HttpsURLConnection");
            return null;
        }
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) openConnection;
        try {
            httpsURLConnection.setSSLSocketFactory(com.huawei.hms.framework.network.grs.h.g.a.a(context));
            httpsURLConnection.setHostnameVerifier(com.huawei.hms.framework.network.grs.h.g.a.a());
        } catch (IllegalArgumentException e) {
            Logger.w("URLConnectionHelper", "init https ssl socket failed.");
        }
        httpsURLConnection.setConnectTimeout(10000);
        httpsURLConnection.setReadTimeout(10000);
        httpsURLConnection.setDoOutput(true);
        httpsURLConnection.setUseCaches(false);
        String b = com.huawei.hms.framework.network.grs.h.a.b(context, "NetworkKit-grs", str2);
        Logger.d("URLConnectionHelper", "request to grs server with a User-Agent header is: " + b);
        httpsURLConnection.setRequestProperty("User-Agent", b);
        return httpsURLConnection;
    }

    public static void a(HttpsURLConnection httpsURLConnection, String str) {
        Object obj;
        if (str == null) {
            obj = "sendHttpBody: The Body Data is Null";
        } else if (httpsURLConnection != null) {
            OutputStream outputStream = null;
            try {
                OutputStream outputStream2 = httpsURLConnection.getOutputStream();
                outputStream2.write(str.getBytes("UTF-8"));
                outputStream = outputStream2;
                outputStream2.flush();
                IoUtils.closeSecure(outputStream2);
                return;
            } catch (Throwable th) {
                IoUtils.closeSecure(outputStream);
                throw th;
            }
        } else {
            obj = "sendHttpBody: HttpsURLConnection is Null";
        }
        Logger.i("URLConnectionHelper", obj);
    }
}
