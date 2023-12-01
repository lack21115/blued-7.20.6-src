package com.getui.gtc.dyc;

import android.text.TextUtils;
import com.getui.gtc.base.util.ScheduleQueue;
import com.getui.gtc.dyc.b.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dyc/f.class */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private e f8376a;

    /* renamed from: c  reason: collision with root package name */
    private g f8377c;
    private final List<com.getui.gtc.dyc.b.c> d;
    private final Map<String, Object> e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dyc/f$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static f f8380a = new f();
    }

    private f() {
        this.f8376a = e.a();
        this.f8377c = g.a();
        this.d = new ArrayList();
        this.e = new ConcurrentHashMap();
    }

    public static f a() {
        return a.f8380a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(b bVar, h hVar) {
        return (System.currentTimeMillis() - hVar.c() <= bVar.h() && bVar.g().equals(hVar.a()) && bVar.c().equals(hVar.e())) ? false : true;
    }

    public Map<String, String> a(final b bVar) {
        try {
            final h a2 = this.f8376a.a(bVar.b());
            if (a2 == null || a(bVar, a2)) {
                ScheduleQueue.getInstance().addSchedule(new Runnable() { // from class: com.getui.gtc.dyc.f.1
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (f.this.e) {
                            if (f.this.e.get(bVar.b()) == null) {
                                f.this.e.put(bVar.b(), new Object());
                            }
                        }
                        synchronized (f.this.e.get(bVar.b())) {
                            h a3 = f.this.f8376a.a(bVar.b());
                            if (a3 != null && ((a2 == null || (a3.f() != null && !a3.f().equals(a2.f()))) && bVar.i() != null)) {
                                bVar.i().a(a2 == null ? null : a2.f(), a3.f());
                            }
                            if (a3 == null || f.this.a(bVar, a3)) {
                                if (a3 != null) {
                                    bVar.f(a3.d());
                                }
                                h a4 = f.this.f8377c.a(bVar);
                                if (a4 != null) {
                                    if (TextUtils.isEmpty(a4.d())) {
                                        if (a3 != null) {
                                            a3.a(a4.c());
                                            f.this.f8376a.a(bVar.b(), a3, a3);
                                        }
                                    } else if (a4.f() != null) {
                                        f.this.f8376a.a(bVar.b(), a3, a4);
                                        if (bVar.i() != null) {
                                            bVar.i().a(a3 == null ? null : a3.f(), a4.f());
                                        }
                                        for (com.getui.gtc.dyc.b.c cVar : new ArrayList(f.this.d)) {
                                            cVar.a(a3 == null ? null : a3.f(), a4.f());
                                        }
                                    }
                                }
                            }
                        }
                    }
                });
            }
            if (a2 == null) {
                return null;
            }
            return a2.f();
        } catch (Throwable th) {
            com.getui.gtc.dyc.a.a.a.a(th);
            return null;
        }
    }

    public Map<String, String> a(String str) {
        h a2 = this.f8376a.a(str);
        if (a2 == null) {
            return null;
        }
        return a2.f();
    }

    public void a(com.getui.gtc.dyc.b.c cVar) {
        synchronized (this.d) {
            if (!this.d.contains(cVar)) {
                this.d.add(cVar);
            }
        }
    }

    public void a(String str, Map<String, String> map) {
        h a2 = this.f8376a.a(str);
        Map<String, String> f = a2.f();
        f.clear();
        f.putAll(map);
        this.f8376a.a(str, a2, a2);
    }

    public Map<String, Map<String, String>> c() {
        HashMap<String, h> c2 = this.f8376a.c();
        if (c2 == null || c2.size() <= 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, h> entry : c2.entrySet()) {
            h value = entry.getValue();
            if (value.f() != null) {
                hashMap.put(entry.getKey(), value.f());
            }
        }
        return hashMap;
    }

    public void c(com.getui.gtc.dyc.b.c cVar) {
        synchronized (this.d) {
            this.d.remove(cVar);
        }
    }
}
