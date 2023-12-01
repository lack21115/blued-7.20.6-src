package com.blued.android.core.net.http;

import android.text.TextUtils;
import com.alipay.sdk.sys.a;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.utils.Log;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/net/http/RequestParams.class */
public class RequestParams {
    private static String h = "UTF-8";
    protected ConcurrentHashMap<String, String> a;
    protected String b;
    protected String c;
    protected String d;
    protected String e;
    protected Map<String, String> f;
    protected byte[] g;

    public RequestParams() {
        c();
    }

    public static String a(String str, RequestParams requestParams) {
        String str2;
        String str3 = str;
        if (requestParams != null) {
            String b = requestParams.b();
            if (str.indexOf("?") == -1) {
                str2 = str + "?" + b;
            } else {
                str2 = str + a.b + b;
            }
            str3 = str2;
            if (HttpManager.c()) {
                Log.a("HttpManager", "real url:" + str2);
                str3 = str2;
            }
        }
        return str3;
    }

    private void c() {
        this.a = new ConcurrentHashMap<>();
    }

    public String a() {
        return this.d;
    }

    public void a(String str) {
        if (str == null) {
            this.e = "";
        } else {
            this.e = str;
        }
    }

    public void a(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.a.put(str, str2);
    }

    public String b() {
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        try {
            for (Map.Entry<String, String> entry : this.a.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key)) {
                    if (i > 0) {
                        stringBuffer.append(a.b);
                    }
                    stringBuffer.append(URLEncoder.encode(key, h));
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(value)) {
                        stringBuffer.append("=");
                        stringBuffer.append(URLEncoder.encode(value, h));
                    }
                    i++;
                }
            }
        } catch (UnsupportedEncodingException e) {
        }
        return stringBuffer.toString();
    }

    public void b(String str, String str2) {
        this.c = str;
        this.b = str2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : this.a.entrySet()) {
            if (sb.length() > 0) {
                sb.append(a.b);
            }
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
        }
        if (!TextUtils.isEmpty(this.c)) {
            if (sb.length() > 0) {
                sb.append(a.b);
            }
            sb.append("uploadFile=" + this.c);
        }
        if (!TextUtils.isEmpty(this.d)) {
            if (sb.length() > 0) {
                sb.append(a.b);
            }
            sb.append("downloadFile=" + this.d);
        }
        return sb.toString();
    }
}
