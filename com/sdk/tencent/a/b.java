package com.sdk.tencent.a;

import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/a/b.class */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static long f14316c = 60000;
    public static final ConcurrentHashMap<String, Boolean> d;

    /* renamed from: a  reason: collision with root package name */
    public final com.sdk.tencent.b.c<String, String> f14317a;
    public int b;

    /* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/a/b$a.class */
    public class a extends com.sdk.tencent.b.c<String, String> {
        public a(b bVar, int i) {
            super(i);
        }
    }

    static {
        ConcurrentHashMap<String, Boolean> concurrentHashMap = new ConcurrentHashMap<>(10);
        d = concurrentHashMap;
        concurrentHashMap.put("GET", Boolean.TRUE);
        new ConcurrentHashMap(10);
    }

    public b(int i, long j) {
        this.b = 102400;
        this.b = i;
        f14316c = j;
        this.f14317a = new a(this, i);
    }

    public static long a() {
        return f14316c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String a(String str) {
        Object obj;
        if (str != null) {
            com.sdk.tencent.b.c<String, String> cVar = this.f14317a;
            synchronized (cVar) {
                if (cVar.d.containsKey(str)) {
                    obj = cVar.f14329a.get(str);
                    if (obj != null) {
                    }
                } else {
                    synchronized (cVar) {
                        Object remove = cVar.f14329a.remove(str);
                        cVar.d.a(str);
                        if (remove != null) {
                            cVar.b -= cVar.a(str, remove);
                        }
                    }
                }
                obj = null;
            }
            return (String) obj;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(String str, String str2, long j) {
        if (str == null || str2 == null || j < 1) {
            return;
        }
        com.sdk.tencent.b.c<String, String> cVar = this.f14317a;
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (cVar) {
            cVar.b += cVar.a(str, str2);
            Object put = cVar.f14329a.put(str, str2);
            cVar.d.put(str, Long.valueOf(currentTimeMillis + j));
            if (put != null) {
                cVar.b -= cVar.a(str, put);
            }
        }
        cVar.a(cVar.f14330c);
    }

    public boolean b(String str) {
        Boolean bool;
        if (TextUtils.isEmpty(str) || (bool = d.get(str.toUpperCase())) == null) {
            return false;
        }
        return bool.booleanValue();
    }
}
