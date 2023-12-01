package com.anythink.core.common;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/b.class */
public class b {
    public static final String a = "1";
    private static volatile b c;
    ConcurrentHashMap<String, List<a>> b = new ConcurrentHashMap<>();

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/b$a.class */
    public interface a {
        void a(Object obj);
    }

    private b() {
    }

    public static b a() {
        if (c == null) {
            synchronized (b.class) {
                try {
                    if (c == null) {
                        c = new b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return c;
    }

    public final void a(final String str, final a aVar) {
        synchronized (this) {
            if (TextUtils.isEmpty(str) || aVar == null) {
                return;
            }
            com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    synchronized (b.this) {
                        List<a> list = b.this.b.get(str);
                        ArrayList arrayList = list;
                        if (list == null) {
                            arrayList = new ArrayList();
                            b.this.b.put(str, arrayList);
                        }
                        arrayList.add(aVar);
                    }
                }
            });
        }
    }

    public final void a(final String str, final Object obj) {
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.b.3
                @Override // java.lang.Runnable
                public final void run() {
                    synchronized (b.this) {
                        List<a> list = b.this.b.get(str);
                        if (list == null) {
                            return;
                        }
                        for (a aVar : list) {
                            if (aVar != null) {
                                aVar.a(obj);
                            }
                        }
                    }
                }
            });
        }
    }

    public final void b(final String str, final a aVar) {
        synchronized (this) {
            if (TextUtils.isEmpty(str) || aVar == null) {
                return;
            }
            com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.b.2
                @Override // java.lang.Runnable
                public final void run() {
                    synchronized (b.this) {
                        List<a> list = b.this.b.get(str);
                        if (list != null) {
                            list.remove(aVar);
                        }
                    }
                }
            });
        }
    }
}
