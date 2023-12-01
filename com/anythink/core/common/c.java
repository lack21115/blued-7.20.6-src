package com.anythink.core.common;

import android.text.TextUtils;
import com.anythink.core.api.AdError;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.e.ai;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static String f6565a = c.class.getSimpleName();
    private static volatile c f;
    ConcurrentHashMap<String, Long> b = new ConcurrentHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    ConcurrentHashMap<String, Long> f6566c = new ConcurrentHashMap<>();
    Map<String, a> d = new ConcurrentHashMap(5);
    Map<String, Map<String, Long>> e;

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/c$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        String f6568a;
        long b;
    }

    private c() {
    }

    public static c a() {
        if (f == null) {
            synchronized (c.class) {
                try {
                    if (f == null) {
                        f = new c();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f;
    }

    private void b(String str, long j) {
        this.f6566c.put(str, Long.valueOf(j));
    }

    public final void a(String str) {
        this.e = new ConcurrentHashMap(3);
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                try {
                    String next = keys.next();
                    JSONObject optJSONObject = jSONObject.optJSONObject(next);
                    HashMap hashMap = new HashMap(3);
                    Iterator<String> keys2 = optJSONObject.keys();
                    while (keys2.hasNext()) {
                        try {
                            String next2 = keys2.next();
                            hashMap.put(next2, Long.valueOf(optJSONObject.getLong(next2)));
                        } catch (Throwable th) {
                        }
                    }
                    this.e.put(next, hashMap);
                } catch (Throwable th2) {
                }
            }
        } catch (Throwable th3) {
        }
    }

    public final void a(String str, long j) {
        this.b.put(str, Long.valueOf(j));
    }

    public final void a(String str, long j, AdError adError) {
        if (TextUtils.equals(adError.getCode(), ErrorCode.noADError)) {
            a aVar = this.d.get(str);
            a aVar2 = aVar;
            if (aVar == null) {
                aVar2 = new a();
            }
            aVar2.f6568a = adError.getPlatformCode();
            aVar2.b = j;
            this.d.put(str, aVar2);
        }
    }

    public final boolean a(int i, com.anythink.core.c.d dVar, ai aiVar) {
        int i2;
        Long l;
        if (this.e == null) {
            return false;
        }
        List<Integer> b = dVar.b();
        if (b.size() == 0) {
            return false;
        }
        a aVar = this.d.get(aiVar.t());
        if (aVar == null) {
            return false;
        }
        switch (i) {
            case 1:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                i2 = 3;
                break;
            case 2:
            default:
                i2 = 1;
                break;
            case 8:
                i2 = 2;
                break;
        }
        if (b.contains(Integer.valueOf(i2))) {
            Map<String, Long> map = this.e.get(String.valueOf(aiVar.c()));
            return (map == null || (l = map.get(aVar.f6568a)) == null || aVar.b + l.longValue() < System.currentTimeMillis()) ? false : true;
        }
        StringBuilder sb = new StringBuilder("The current load mode is: ");
        sb.append(i2);
        sb.append(", no need to filter");
        return false;
    }

    public final boolean a(ai aiVar) {
        long j = 0;
        if (aiVar.H() == 0) {
            return false;
        }
        if (this.b.get(aiVar.t()) != null) {
            j = this.b.get(aiVar.t()).longValue();
        }
        return j + aiVar.H() >= System.currentTimeMillis();
    }

    public final boolean b(ai aiVar) {
        if (aiVar.l() == 7) {
            return false;
        }
        long j = 0;
        if (aiVar.I() == 0) {
            return false;
        }
        if (this.f6566c.get(aiVar.t()) != null) {
            j = this.f6566c.get(aiVar.t()).longValue();
        }
        return j + aiVar.I() >= System.currentTimeMillis();
    }
}
