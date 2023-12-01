package com.qiniu.android.dns.http;

import android.text.TextUtils;
import com.qiniu.android.dns.Domain;
import com.qiniu.android.dns.IResolver;
import com.qiniu.android.dns.NetworkInfo;
import com.qiniu.android.dns.Record;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/dns/http/GoogleHttpsDns.class */
public class GoogleHttpsDns implements IResolver {
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0059, code lost:
        if (r5 != null) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String getStringResponse(java.net.HttpURLConnection r5) throws java.io.IOException {
        /*
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r1 = r0
            r1.<init>()
            r11 = r0
            r0 = 0
            r9 = r0
            r0 = 0
            r7 = r0
            r0 = r7
            r8 = r0
            r0 = r5
            java.io.InputStream r0 = r0.getInputStream()     // Catch: java.lang.Throwable -> L1c java.io.IOException -> L87
            r10 = r0
            r0 = r10
            r5 = r0
        L19:
            goto L2d
        L1c:
            r5 = move-exception
            goto L7d
        L20:
            r0 = r7
            r8 = r0
            r0 = r9
            r7 = r0
            r0 = r5
            java.io.InputStream r0 = r0.getErrorStream()     // Catch: java.lang.Throwable -> L1c java.io.IOException -> L5f
            r5 = r0
            goto L19
        L2d:
            r0 = r5
            r8 = r0
            r0 = r5
            r7 = r0
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]     // Catch: java.lang.Throwable -> L1c java.io.IOException -> L5f
            r9 = r0
        L38:
            r0 = r5
            r8 = r0
            r0 = r5
            r7 = r0
            r0 = r5
            r1 = r9
            int r0 = r0.read(r1)     // Catch: java.lang.Throwable -> L1c java.io.IOException -> L5f
            r6 = r0
            r0 = r6
            r1 = -1
            if (r0 == r1) goto L58
            r0 = r5
            r8 = r0
            r0 = r5
            r7 = r0
            r0 = r11
            r1 = r9
            r2 = 0
            r3 = r6
            r0.write(r1, r2, r3)     // Catch: java.lang.Throwable -> L1c java.io.IOException -> L5f
            goto L38
        L58:
            r0 = r5
            if (r0 == 0) goto L70
            goto L6c
        L5f:
            r5 = move-exception
            r0 = r7
            r8 = r0
            r0 = r5
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L1c
            r0 = r7
            if (r0 == 0) goto L70
            r0 = r7
            r5 = r0
        L6c:
            r0 = r5
            r0.close()
        L70:
            java.lang.String r0 = new java.lang.String
            r1 = r0
            r2 = r11
            byte[] r2 = r2.toByteArray()
            r1.<init>(r2)
            return r0
        L7d:
            r0 = r8
            if (r0 == 0) goto L85
            r0 = r8
            r0.close()
        L85:
            r0 = r5
            throw r0
        L87:
            r8 = move-exception
            goto L20
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiniu.android.dns.http.GoogleHttpsDns.getStringResponse(java.net.HttpURLConnection):java.lang.String");
    }

    @Override // com.qiniu.android.dns.IResolver
    public Record[] resolve(Domain domain, NetworkInfo networkInfo) throws IOException {
        JSONArray jSONArray;
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://dns.google.com/resolve?name=" + domain.domain).openConnection();
        httpURLConnection.setConnectTimeout(3000);
        httpURLConnection.setReadTimeout(10000);
        if (httpURLConnection.getResponseCode() != 200) {
            return null;
        }
        String stringResponse = getStringResponse(httpURLConnection);
        if (TextUtils.isEmpty(stringResponse)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            jSONArray = new JSONObject(stringResponse).getJSONArray("Answer");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (jSONArray == null) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= jSONArray.length()) {
                break;
            }
            JSONObject jSONObject = jSONArray.getJSONObject(i2);
            if (jSONObject.getInt("type") == 1) {
                String string = jSONObject.getString("data");
                if (TextUtils.isEmpty(string)) {
                    continue;
                } else {
                    try {
                        arrayList.add(new Record(string, 1, jSONObject.getInt("TTL"), System.currentTimeMillis() / 1000));
                    } catch (Exception e2) {
                        return null;
                    }
                }
            }
            i = i2 + 1;
        }
        if (arrayList.size() > 0) {
            return (Record[]) arrayList.toArray(new Record[arrayList.size()]);
        }
        return null;
    }
}
