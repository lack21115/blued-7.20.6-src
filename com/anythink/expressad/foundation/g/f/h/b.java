package com.anythink.expressad.foundation.g.f.h;

import android.text.TextUtils;
import com.anythink.expressad.foundation.h.o;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/g/f/h/b.class */
public final class b {
    private Map<String, String> e = new LinkedHashMap();
    private Map<String, com.anythink.expressad.foundation.g.f.c.b> f = new LinkedHashMap();
    private static final String d = b.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public static String f5074a = "a";
    public static String b = "d";

    /* renamed from: c  reason: collision with root package name */
    public static String f5075c = "e";

    public b() {
    }

    private b(String str, String str2) {
        this.e.put(str, str2);
    }

    private b(Map<String, String> map) {
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                a(entry.getKey(), entry.getValue());
            }
        }
    }

    private b(String... strArr) {
        int length = strArr.length;
        if (length % 2 != 0) {
            throw new IllegalArgumentException("Supplied arguments must be even");
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            a(strArr[i2], strArr[i2 + 1]);
            i = i2 + 2;
        }
    }

    private void a(String str) {
        this.e.remove(str);
        this.f.remove(str);
    }

    private void a(String str, File file) {
        if (file == null || !file.exists()) {
            throw new FileNotFoundException();
        }
        String name = TextUtils.isEmpty(null) ? file.getName() : null;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f.put(str, new com.anythink.expressad.foundation.g.f.c.b(name, file, name, null));
    }

    private void a(String str, File file, String str2) {
        if (file == null || !file.exists()) {
            throw new FileNotFoundException();
        }
        String str3 = str2;
        if (TextUtils.isEmpty(str2)) {
            str3 = file.getName();
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f.put(str, new com.anythink.expressad.foundation.g.f.c.b(str3, file, str3, null));
    }

    private void a(String str, File file, String str2, String str3) {
        if (file == null || !file.exists()) {
            throw new FileNotFoundException();
        }
        String str4 = str2;
        if (TextUtils.isEmpty(str2)) {
            str4 = file.getName();
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f.put(str, new com.anythink.expressad.foundation.g.f.c.b(str4, file, str4, str3));
    }

    private void a(Map<String, ?> map) {
        if (map != null) {
            for (Map.Entry<String, ?> entry : map.entrySet()) {
                Object value = entry.getValue();
                if (value instanceof String) {
                    a(entry.getKey(), (String) entry.getValue());
                } else if (value instanceof File) {
                    String key = entry.getKey();
                    File file = (File) entry.getValue();
                    if (file == null || !file.exists()) {
                        throw new FileNotFoundException();
                    }
                    String name = TextUtils.isEmpty(null) ? file.getName() : null;
                    if (!TextUtils.isEmpty(key)) {
                        this.f.put(key, new com.anythink.expressad.foundation.g.f.c.b(name, file, name, null));
                    }
                } else {
                    continue;
                }
            }
        }
    }

    private JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : this.e.entrySet()) {
                jSONObject.put(URLEncoder.encode(entry.getKey(), "UTF-8"), URLEncoder.encode(entry.getValue(), "UTF-8"));
            }
            for (Map.Entry<String, com.anythink.expressad.foundation.g.f.c.b> entry2 : this.f.entrySet()) {
                jSONObject.put(URLEncoder.encode(entry2.getKey(), "UTF-8"), URLEncoder.encode("FILE_NAME_" + entry2.getValue().b().getName(), "UTF-8"));
            }
        } catch (UnsupportedEncodingException e) {
            return jSONObject;
        } catch (JSONException e2) {
            o.d(d, e2.getMessage());
        }
        return jSONObject;
    }

    public final String a() {
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : this.e.entrySet()) {
                if (sb.length() > 0) {
                    sb.append('&');
                }
                sb.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                sb.append("=");
                sb.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public final void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || str2 == null) {
            return;
        }
        this.e.put(str, str2);
    }

    public final Map<String, String> b() {
        return this.e;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(28);
        try {
            for (Map.Entry<String, String> entry : this.e.entrySet()) {
                if (sb.length() > 0) {
                    sb.append('&');
                }
                sb.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                sb.append('=');
                sb.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
            }
            for (Map.Entry<String, com.anythink.expressad.foundation.g.f.c.b> entry2 : this.f.entrySet()) {
                if (sb.length() > 0) {
                    sb.append('&');
                }
                sb.append(URLEncoder.encode(entry2.getKey(), "UTF-8"));
                sb.append('=');
                sb.append(URLEncoder.encode("FILE_NAME_" + entry2.getValue().b().getName(), "UTF-8"));
            }
        } catch (UnsupportedEncodingException e) {
            o.d(d, e.getMessage());
        }
        return sb.toString();
    }
}
