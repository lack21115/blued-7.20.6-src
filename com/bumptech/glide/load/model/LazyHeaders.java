package com.bumptech.glide.load.model;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/model/LazyHeaders.class */
public final class LazyHeaders implements Headers {

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, List<LazyHeaderFactory>> f7272c;
    private volatile Map<String, String> d;

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/model/LazyHeaders$Builder.class */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private static final String f7273a = b();
        private static final Map<String, List<LazyHeaderFactory>> b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f7274c = true;
        private Map<String, List<LazyHeaderFactory>> d = b;
        private boolean e = true;

        static {
            HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(f7273a)) {
                hashMap.put("User-Agent", Collections.singletonList(new StringHeaderFactory(f7273a)));
            }
            b = Collections.unmodifiableMap(hashMap);
        }

        static String b() {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            int length = property.length();
            StringBuilder sb = new StringBuilder(property.length());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return sb.toString();
                }
                char charAt = property.charAt(i2);
                if ((charAt > 31 || charAt == '\t') && charAt < 127) {
                    sb.append(charAt);
                } else {
                    sb.append('?');
                }
                i = i2 + 1;
            }
        }

        public LazyHeaders a() {
            this.f7274c = true;
            return new LazyHeaders(this.d);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/model/LazyHeaders$StringHeaderFactory.class */
    static final class StringHeaderFactory implements LazyHeaderFactory {

        /* renamed from: a  reason: collision with root package name */
        private final String f7275a;

        StringHeaderFactory(String str) {
            this.f7275a = str;
        }

        @Override // com.bumptech.glide.load.model.LazyHeaderFactory
        public String a() {
            return this.f7275a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof StringHeaderFactory) {
                return this.f7275a.equals(((StringHeaderFactory) obj).f7275a);
            }
            return false;
        }

        public int hashCode() {
            return this.f7275a.hashCode();
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.f7275a + "'}";
        }
    }

    LazyHeaders(Map<String, List<LazyHeaderFactory>> map) {
        this.f7272c = Collections.unmodifiableMap(map);
    }

    private String a(List<LazyHeaderFactory> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return sb.toString();
            }
            String a2 = list.get(i2).a();
            if (!TextUtils.isEmpty(a2)) {
                sb.append(a2);
                if (i2 != list.size() - 1) {
                    sb.append(',');
                }
            }
            i = i2 + 1;
        }
    }

    private Map<String, String> b() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, List<LazyHeaderFactory>> entry : this.f7272c.entrySet()) {
            String a2 = a(entry.getValue());
            if (!TextUtils.isEmpty(a2)) {
                hashMap.put(entry.getKey(), a2);
            }
        }
        return hashMap;
    }

    @Override // com.bumptech.glide.load.model.Headers
    public Map<String, String> a() {
        if (this.d == null) {
            synchronized (this) {
                if (this.d == null) {
                    this.d = Collections.unmodifiableMap(b());
                }
            }
        }
        return this.d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof LazyHeaders) {
            return this.f7272c.equals(((LazyHeaders) obj).f7272c);
        }
        return false;
    }

    public int hashCode() {
        return this.f7272c.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.f7272c + '}';
    }
}
