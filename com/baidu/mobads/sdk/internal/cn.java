package com.baidu.mobads.sdk.internal;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/cn.class */
public class cn {

    /* renamed from: a  reason: collision with root package name */
    private static volatile cn f9387a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f9388c;

    private cn() {
    }

    public static cn a() {
        if (f9387a == null) {
            synchronized (cn.class) {
                try {
                    if (f9387a == null) {
                        f9387a = new cn();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f9387a;
    }

    private Boolean a(String str, String str2) {
        boolean z = false;
        if (str != null && str.trim().toLowerCase(Locale.getDefault()).indexOf(str2) == 0) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    public Boolean a(String str) {
        return a(str, "http:");
    }

    public String a(String str, HashMap<String, String> hashMap) {
        StringBuilder sb = new StringBuilder(str);
        if (hashMap == null || hashMap.isEmpty()) {
            return sb.toString();
        }
        sb.append("?");
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            try {
                sb.append(entry.getKey());
                sb.append("=");
                sb.append(entry.getValue());
                sb.append("&");
            } catch (Exception e) {
                bq.a().c(e);
            }
        }
        String sb2 = sb.toString();
        return sb2.substring(0, sb2.length() - 1);
    }

    public HttpURLConnection a(URL url) {
        return url.getProtocol().toLowerCase().equals("https") ? (HttpsURLConnection) url.openConnection() : (HttpURLConnection) url.openConnection();
    }

    public void a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            try {
                httpURLConnection.getInputStream().close();
            } catch (Throwable th) {
            }
            try {
                httpURLConnection.getOutputStream().close();
            } catch (Throwable th2) {
            }
            try {
                httpURLConnection.disconnect();
            } catch (Throwable th3) {
            }
        }
    }

    public void a(boolean z) {
        this.f9388c = z;
    }

    public Boolean b(String str) {
        return a(str, "https:");
    }

    public void b(boolean z) {
        this.b = z;
    }

    public boolean b() {
        return this.f9388c;
    }

    public String c(String str) {
        String str2 = str;
        if (this.b) {
            str2 = str;
            if (a(str).booleanValue()) {
                str2 = str.replaceFirst("(?i)http", "https");
            }
        }
        return str2;
    }

    public Boolean d(String str) {
        return Boolean.valueOf(a(str, "sms:").booleanValue() || a(str, "smsto:").booleanValue() || a(str, "mms:").booleanValue());
    }

    public String e(String str) {
        try {
            String path = new URI(str).getPath();
            return path.substring(path.lastIndexOf(47) + 1, path.length());
        } catch (URISyntaxException e) {
            return "";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001b, code lost:
        if (b(r4).booleanValue() != false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String f(java.lang.String r4) {
        /*
            r3 = this;
            r0 = r4
            if (r0 != 0) goto L6
            r0 = 0
            return r0
        L6:
            r0 = r3
            r1 = r4
            java.lang.Boolean r0 = r0.a(r1)
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L1e
            r0 = r4
            r5 = r0
            r0 = r3
            r1 = r4
            java.lang.Boolean r0 = r0.b(r1)
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L27
        L1e:
            r0 = r4
            java.lang.String r1 = "\\?"
            java.lang.String[] r0 = r0.split(r1)
            r1 = 0
            r0 = r0[r1]
            r5 = r0
        L27:
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.cn.f(java.lang.String):java.lang.String");
    }

    public String g(String str) {
        if (str == null) {
            return null;
        }
        String[] split = (a(str).booleanValue() || b(str).booleanValue()) ? str.split("\\?") : null;
        String str2 = null;
        if (split != null) {
            str2 = null;
            if (split.length >= 2) {
                str2 = split[1];
            }
        }
        return str2;
    }

    public void h(String str) {
        new am(str).b();
    }
}
