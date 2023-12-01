package com.danlan.android.cognition.network;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.danlan.android.cognition.Logger;
import com.danlan.android.cognition.StringFog;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/danlan/android/cognition/network/HttpUtil.class */
public class HttpUtil {
    private static void enableTlsOnOlderOsVersions() {
        if (Build.VERSION.SDK_INT <= 20) {
            HttpsURLConnection.setDefaultSSLSocketFactory(new TLSSocketFactory());
        }
    }

    public static String sendPost(Context context, String str, String str2, JSONObject jSONObject, String str3, Map<String, String> map) {
        HttpURLConnection httpURLConnection;
        Throwable th;
        HttpURLConnection httpURLConnection2;
        try {
            Logger.d(StringFog.decrypt("UkZKR3FMV1UBR0tOQEpKGw==") + str);
            Logger.d(StringFog.decrypt("UkZKR3FMV1UBQlRKGw==") + str2);
            enableTlsOnOlderOsVersions();
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            String str4 = str + str2;
            Logger.d(StringFog.decrypt("UkZKR3FMV1UBVlZPGw==") + str4);
            httpURLConnection2 = (HttpURLConnection) new URL(str4).openConnection();
            try {
                httpURLConnection2.setConnectTimeout(5000);
                httpURLConnection2.setRequestMethod(StringFog.decrypt("cWx3dw=="));
                httpURLConnection2.setRequestProperty(StringFog.decrypt("YkxKV0RNUAx1WlRG"), StringFog.decrypt("QFNUT0hARVVITEoMS1BLTxoDR0tAUVdEVR5xd2cOHA=="));
                httpURLConnection2.setRequestProperty(StringFog.decrypt("YEBHRlFX"), StringFog.decrypt("QFNUT0hARVVITEoMS1BLTw=="));
                if (!TextUtils.isEmpty(str3)) {
                    httpURLConnection2.setRequestProperty(StringFog.decrypt("dFBBUQxiQ0RPVw=="), str3);
                }
                if (map != null && !map.isEmpty()) {
                    for (String str5 : map.keySet()) {
                        httpURLConnection2.setRequestProperty(str5, map.get(str5));
                    }
                }
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setDoInput(true);
                String jSONObject2 = jSONObject.toString();
                OutputStream outputStream = httpURLConnection2.getOutputStream();
                outputStream.write(jSONObject2.getBytes(StandardCharsets.UTF_8));
                outputStream.close();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection2.getInputStream(), StandardCharsets.UTF_8));
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        String sb2 = sb.toString();
                        httpURLConnection2.disconnect();
                        return sb2;
                    }
                    sb.append(readLine.trim());
                }
            } catch (Exception e) {
                e = e;
                Logger.e(e.getMessage());
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                    return null;
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection = httpURLConnection2;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            httpURLConnection2 = null;
        } catch (Throwable th3) {
            httpURLConnection = null;
            th = th3;
        }
    }
}
