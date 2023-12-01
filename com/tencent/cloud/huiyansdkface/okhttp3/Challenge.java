package com.tencent.cloud.huiyansdkface.okhttp3;

import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/Challenge.class */
public final class Challenge {

    /* renamed from: a  reason: collision with root package name */
    private final String f22139a;
    private final Map<String, String> b;

    public Challenge(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("scheme == null");
        }
        if (str2 == null) {
            throw new NullPointerException("realm == null");
        }
        this.f22139a = str;
        this.b = Collections.singletonMap("realm", str2);
    }

    public Challenge(String str, Map<String, String> map) {
        if (str == null) {
            throw new NullPointerException("scheme == null");
        }
        if (map == null) {
            throw new NullPointerException("authParams == null");
        }
        this.f22139a = str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey() == null ? null : entry.getKey().toLowerCase(Locale.US), entry.getValue());
        }
        this.b = Collections.unmodifiableMap(linkedHashMap);
    }

    public Map<String, String> authParams() {
        return this.b;
    }

    public Charset charset() {
        String str = this.b.get("charset");
        if (str != null) {
            try {
                return Charset.forName(str);
            } catch (Exception e) {
            }
        }
        return Util.f;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Challenge) {
            Challenge challenge = (Challenge) obj;
            return challenge.f22139a.equals(this.f22139a) && challenge.b.equals(this.b);
        }
        return false;
    }

    public int hashCode() {
        return ((899 + this.f22139a.hashCode()) * 31) + this.b.hashCode();
    }

    public String realm() {
        return this.b.get("realm");
    }

    public String scheme() {
        return this.f22139a;
    }

    public String toString() {
        return this.f22139a + " authParams=" + this.b;
    }

    public Challenge withCharset(Charset charset) {
        if (charset != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(this.b);
            linkedHashMap.put("charset", charset.name());
            return new Challenge(this.f22139a, linkedHashMap);
        }
        throw new NullPointerException("charset == null");
    }
}
