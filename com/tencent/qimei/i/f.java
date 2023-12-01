package com.tencent.qimei.i;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/i/f.class */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, f> f24647a = new ConcurrentHashMap();
    public SharedPreferences b;

    /* renamed from: c  reason: collision with root package name */
    public final String f24648c;
    public Context d;

    public f(String str) {
        this.f24648c = str;
    }

    public static f a(String str) {
        f fVar;
        synchronized (f.class) {
            try {
                f fVar2 = f24647a.get(str);
                fVar = fVar2;
                if (fVar2 == null) {
                    fVar = new f(str);
                    f24647a.put(str, fVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return fVar;
    }

    public void a(String str, long j) {
        SharedPreferences sharedPreferences = this.b;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().putLong(str, j).apply();
    }

    public void a(String str, String str2) {
        SharedPreferences sharedPreferences = this.b;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().putString(str, str2).apply();
    }

    public long b(String str) {
        SharedPreferences sharedPreferences = this.b;
        if (sharedPreferences == null) {
            return 0L;
        }
        return sharedPreferences.getLong(str, 0L);
    }

    public String c(String str) {
        String string;
        SharedPreferences sharedPreferences = this.b;
        return (sharedPreferences == null || (string = sharedPreferences.getString(str, "")) == null) ? "" : string;
    }
}
