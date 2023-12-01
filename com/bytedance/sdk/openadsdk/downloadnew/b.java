package com.bytedance.sdk.openadsdk.downloadnew;

import android.net.http.Headers;
import android.text.TextUtils;
import com.anythink.expressad.foundation.g.f.g.c;
import com.google.common.net.HttpHeaders;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/downloadnew/b.class */
public class b {

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/downloadnew/b$mb.class */
    public static class mb {
        public int b;
        public HttpURLConnection hj;
        public InputStream mb;
        public Map<String, String> ox;

        public mb(InputStream inputStream, Map<String, String> map, int i, HttpURLConnection httpURLConnection) {
            this.mb = inputStream;
            this.ox = map;
            this.b = i;
            this.hj = httpURLConnection;
        }
    }

    public static mb mb(String str, List<HttpHeader> list) throws IOException {
        int responseCode;
        HashMap hashMap = new HashMap();
        if (list != null && !list.isEmpty()) {
            for (HttpHeader httpHeader : list) {
                hashMap.put(httpHeader.getName(), httpHeader.getValue());
            }
        }
        HttpURLConnection mb2 = mb(str, hashMap);
        if (mb2 != null && (responseCode = mb2.getResponseCode()) >= 200 && responseCode < 300) {
            Map<String, String> mb3 = mb(mb2);
            InputStream inputStream = mb2.getInputStream();
            String contentEncoding = mb2.getContentEncoding();
            GZIPInputStream gZIPInputStream = inputStream;
            if (!TextUtils.isEmpty(contentEncoding)) {
                gZIPInputStream = inputStream;
                if (contentEncoding.contains("gzip")) {
                    gZIPInputStream = new GZIPInputStream(inputStream);
                }
            }
            return new mb(gZIPInputStream, mb3, responseCode, mb2);
        }
        return null;
    }

    public static HttpURLConnection mb(String str, Map<String, String> map) {
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2;
        int responseCode;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setInstanceFollowRedirects(false);
                httpURLConnection.setRequestProperty("accept", "*/*");
                httpURLConnection.setRequestProperty(Headers.CONN_DIRECTIVE, c.f7906c);
                if (map != null && !map.isEmpty()) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                httpURLConnection.connect();
                responseCode = httpURLConnection.getResponseCode();
            } catch (Exception e) {
                httpURLConnection2 = httpURLConnection;
                return httpURLConnection2;
            }
        } catch (Exception e2) {
            httpURLConnection = null;
        }
        if (responseCode < 200 || responseCode >= 300) {
            httpURLConnection2 = httpURLConnection;
            if (responseCode >= 300) {
                httpURLConnection2 = httpURLConnection;
                if (responseCode < 400) {
                    return mb(httpURLConnection.getHeaderField(HttpHeaders.LOCATION), map);
                }
            }
            return httpURLConnection2;
        }
        return httpURLConnection;
    }

    public static Map<String, String> mb(HttpURLConnection httpURLConnection) {
        HashMap hashMap = new HashMap();
        int size = httpURLConnection.getHeaderFields().size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return hashMap;
            }
            hashMap.put(httpURLConnection.getHeaderFieldKey(i2), httpURLConnection.getHeaderField(i2));
            i = i2 + 1;
        }
    }
}
