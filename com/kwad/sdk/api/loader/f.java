package com.kwad.sdk.api.loader;

import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import com.huawei.openalliance.ad.utils.ay;
import com.kwad.sdk.api.core.RequestParamsUtils;
import com.kwad.sdk.api.core.TLSConnectionUtils;
import com.kwad.sdk.api.loader.a;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/loader/f.class */
class f {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final v Zx;
    private int Zy;
    private String Zz;
    private final String mUrl;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/loader/f$a.class */
    public interface a {
        void a(a.b bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(v vVar) {
        this.Zx = vVar;
        String tx = vVar.tx();
        this.mUrl = tx;
        this.Zz = tx;
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x00a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0097 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(java.io.InputStream r5) {
        /*
            Method dump skipped, instructions count: 181
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.api.loader.f.a(java.io.InputStream):java.lang.String");
    }

    private static void a(HttpURLConnection httpURLConnection, Map<String, String> map) {
        if (map == null || httpURLConnection == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    private static HttpURLConnection bb(String str) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        TLSConnectionUtils.wrapHttpURLConnection(httpURLConnection);
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(30000);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(true);
        return httpURLConnection;
    }

    private String c(Map<String, String> map) {
        String ao = g.ao(this.Zx.getContext());
        String str = ao;
        if (TextUtils.isEmpty(ao)) {
            str = this.Zx.ty().getSDKVersion();
        }
        int sDKVersionCode = this.Zx.ty().getSDKVersionCode();
        JSONObject appInfo = this.Zx.ty().getAppInfo();
        JSONObject deviceInfo = this.Zx.ty().getDeviceInfo();
        JSONObject networkInfo = this.Zx.ty().getNetworkInfo();
        JSONObject jSONObject = new JSONObject();
        l.putValue(jSONObject, "sdkApiVersion", "3.3.40");
        l.putValue(jSONObject, "sdkApiVersionCode", 3034000);
        l.putValue(jSONObject, "sdkVersion", str);
        l.putValue(jSONObject, "SDKVersionCode", sDKVersionCode);
        l.putValue(jSONObject, "sdkType", 1);
        l.putValue(jSONObject, "appInfo", appInfo);
        l.putValue(jSONObject, "deviceInfo", deviceInfo);
        l.putValue(jSONObject, "networkInfo", networkInfo);
        l.putValue(jSONObject, "sdkAbi", w.tz());
        String jSONObject2 = jSONObject.toString();
        this.Zx.ty().addHp(map);
        JSONObject jSONObject3 = new JSONObject();
        l.putValue(jSONObject3, "version", "3.3.40");
        l.putValue(jSONObject3, "appId", appInfo.optString("appId"));
        l.putValue(jSONObject3, "message", this.Zx.ty().getRM(jSONObject2));
        this.Zx.ty().sR(this.mUrl, map, jSONObject3.toString());
        return jSONObject3.toString();
    }

    private static Map<String, String> to() {
        HashMap hashMap = new HashMap();
        hashMap.put(HttpHeaders.ACCEPT_LANGUAGE, ay.Code);
        hashMap.put("Connection", "keep-alive");
        hashMap.put("Charset", "UTF-8");
        hashMap.put("Content-Type", "application/json; charset=UTF-8");
        hashMap.put("User-Agent", RequestParamsUtils.getUserAgent());
        return hashMap;
    }

    public final void a(a aVar) {
        HttpURLConnection httpURLConnection = null;
        HttpURLConnection httpURLConnection2 = null;
        try {
            Map<String, String> map = to();
            String c2 = c(map);
            HttpURLConnection bb = bb(this.Zz);
            a(bb, map);
            bb.connect();
            new DataOutputStream(bb.getOutputStream()).write(c2.getBytes());
            int responseCode = bb.getResponseCode();
            if (responseCode == 200) {
                String a2 = a(bb.getInputStream());
                a.b bVar = new a.b();
                JSONObject jSONObject = new JSONObject(a2);
                String optString = jSONObject.optString("data");
                if (!TextUtils.isEmpty(optString) && !com.igexin.push.core.b.l.equals(optString)) {
                    jSONObject.put("data", new JSONObject(this.Zx.ty().getRD(optString)));
                }
                bVar.parseJson(jSONObject);
                aVar.a(bVar);
            } else if (responseCode / 100 != 3) {
                StringBuilder sb = new StringBuilder("response code = ");
                sb.append(responseCode);
                throw new RuntimeException(sb.toString());
            } else if (this.Zy < 21) {
                this.Zz = bb.getHeaderField(HttpHeaders.LOCATION);
                this.Zy++;
                a(aVar);
            }
            if (bb != null) {
                try {
                    bb.disconnect();
                } catch (Exception e) {
                }
            }
        } catch (Exception e2) {
            if (0 != 0) {
                try {
                    httpURLConnection.disconnect();
                } catch (Exception e3) {
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    httpURLConnection2.disconnect();
                } catch (Exception e4) {
                }
            }
            throw th;
        }
    }
}
