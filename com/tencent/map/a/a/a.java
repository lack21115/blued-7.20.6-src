package com.tencent.map.a.a;

import android.content.Context;
import com.tencent.map.b.f;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/a/a/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static f f23502a = f.a();
    private static a b;

    public static a a() {
        a aVar;
        synchronized (a.class) {
            try {
                if (b == null) {
                    b = new a();
                }
                aVar = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    public boolean a(Context context, b bVar) {
        return f23502a.a(context, bVar);
    }

    public boolean a(String str, String str2) {
        return f23502a.a(str, str2);
    }

    public void b() {
        f23502a.b();
    }
}
