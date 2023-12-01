package com.kwad.sdk.core.network;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.y;
import java.net.HttpURLConnection;
import java.net.URLEncoder;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/network/q.class */
public final class q {
    private static String ahc = "";
    private static String ahd = "";

    public static void b(HttpURLConnection httpURLConnection) {
        httpURLConnection.setRequestProperty("User-Agent", getUserAgent());
        httpURLConnection.setRequestProperty("BrowserUa", wh());
        httpURLConnection.setRequestProperty("SystemUa", wg());
    }

    public static String getDefaultUserAgent() {
        return wg() + "-ksad-android-3.3.40";
    }

    public static String getUserAgent() {
        return ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).getUserAgent();
    }

    public static String wg() {
        if (!TextUtils.isEmpty(ahc)) {
            return ahc;
        }
        String property = System.getProperty("http.agent");
        ahc = property;
        if (TextUtils.isEmpty(property)) {
            return ahc;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int length = ahc.length();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                String stringBuffer2 = stringBuffer.toString();
                ahc = stringBuffer2;
                return stringBuffer2;
            }
            char charAt = ahc.charAt(i2);
            if (charAt <= 31 || charAt >= 127) {
                stringBuffer.append(String.format("\\u%04x", Integer.valueOf(charAt)));
            } else {
                stringBuffer.append(charAt);
            }
            i = i2 + 1;
        }
    }

    public static String wh() {
        String bW;
        if (TextUtils.isEmpty(ahd)) {
            Context context = ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext();
            if (context == null) {
                return "";
            }
            try {
                bW = y.bW(context);
                ahd = bW;
            } catch (Exception e) {
            }
            if (TextUtils.isEmpty(bW)) {
                ahd = Build.VERSION.SDK_INT >= 17 ? WebSettings.getDefaultUserAgent(context) : System.getProperty("http.agent");
                String encode = URLEncoder.encode(ahd, "UTF-8");
                ahd = encode;
                y.ab(context, encode);
                return ahd;
            }
            return ahd;
        }
        return ahd;
    }
}
