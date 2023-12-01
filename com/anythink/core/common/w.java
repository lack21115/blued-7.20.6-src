package com.anythink.core.common;

import android.text.TextUtils;
import com.anythink.core.common.e.ai;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/w.class */
public class w {

    /* renamed from: a  reason: collision with root package name */
    private static volatile w f6933a;

    /* renamed from: c  reason: collision with root package name */
    private final String f6934c = "Waterfall_Final";
    private ConcurrentHashMap<String, a> b = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/w$a.class */
    public final class a {

        /* renamed from: a  reason: collision with root package name */
        String f6935a;
        ConcurrentHashMap<String, C0110a> b = new ConcurrentHashMap<>();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.anythink.core.common.w$a$a  reason: collision with other inner class name */
        /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/w$a$a.class */
        public final class C0110a {

            /* renamed from: a  reason: collision with root package name */
            com.anythink.core.c.d f6937a;
            CopyOnWriteArrayList<ai> b;

            /* renamed from: c  reason: collision with root package name */
            boolean f6938c;

            C0110a() {
            }

            private List<ai> a() {
                return this.b;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void a(ai aiVar) {
                synchronized (this) {
                    com.anythink.core.common.k.g.a((List<ai>) this.b, aiVar, true);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void a(List<ai> list) {
                synchronized (this) {
                    if (this.b != null && this.b.size() > 0) {
                        this.b.removeAll(list);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void b() {
                synchronized (this) {
                    if (this.f6938c) {
                        return;
                    }
                    this.f6938c = true;
                }
            }

            private boolean c() {
                return this.f6938c;
            }
        }

        a() {
        }

        private List<ai> a(String str) {
            C0110a c0110a = this.b.get(str);
            if (c0110a != null) {
                return c0110a.b;
            }
            return null;
        }

        private static /* synthetic */ void a(a aVar, String str, com.anythink.core.c.d dVar, List list) {
            C0110a c0110a = new C0110a();
            c0110a.f6937a = dVar;
            CopyOnWriteArrayList<ai> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            copyOnWriteArrayList.addAll(list);
            c0110a.b = copyOnWriteArrayList;
            aVar.b.put(str, c0110a);
        }

        private static /* synthetic */ void a(a aVar, String str, ai aiVar) {
            C0110a c0110a = aVar.b.get(str);
            if (c0110a != null) {
                c0110a.a(aiVar);
            }
        }

        static /* synthetic */ void a(a aVar, String str, List list) {
            C0110a c0110a = aVar.b.get(str);
            if (c0110a != null) {
                c0110a.a(list);
            }
        }

        private void a(String str, com.anythink.core.c.d dVar, List<ai> list) {
            C0110a c0110a = new C0110a();
            c0110a.f6937a = dVar;
            CopyOnWriteArrayList<ai> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            copyOnWriteArrayList.addAll(list);
            c0110a.b = copyOnWriteArrayList;
            this.b.put(str, c0110a);
        }

        private void a(String str, ai aiVar) {
            C0110a c0110a = this.b.get(str);
            if (c0110a != null) {
                c0110a.a(aiVar);
            }
        }

        private void a(String str, List<ai> list) {
            C0110a c0110a = this.b.get(str);
            if (c0110a != null) {
                c0110a.a(list);
            }
        }

        static /* synthetic */ void b(a aVar, String str) {
            C0110a c0110a = aVar.b.get(str);
            if (c0110a != null) {
                c0110a.b();
            }
        }

        private boolean b(String str) {
            C0110a c0110a = this.b.get(str);
            if (c0110a != null) {
                return c0110a.f6938c;
            }
            return false;
        }

        static /* synthetic */ List c(a aVar, String str) {
            C0110a c0110a = aVar.b.get(str);
            if (c0110a != null) {
                return c0110a.b;
            }
            return null;
        }

        private void c(String str) {
            C0110a c0110a = this.b.get(str);
            if (c0110a != null) {
                c0110a.b();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(String str) {
            synchronized (this) {
                Iterator<Map.Entry<String, C0110a>> it = this.b.entrySet().iterator();
                while (it.hasNext()) {
                    String key = it.next().getKey();
                    if (key != null) {
                        String obj = key.toString();
                        if (this.b.get(obj).f6938c && !TextUtils.equals(str, obj)) {
                            it.remove();
                        }
                    }
                }
            }
        }

        private static /* synthetic */ boolean d(a aVar, String str) {
            C0110a c0110a = aVar.b.get(str);
            if (c0110a != null) {
                return c0110a.f6938c;
            }
            return false;
        }
    }

    private w() {
    }

    public static w a() {
        if (f6933a == null) {
            synchronized (w.class) {
                try {
                    if (f6933a == null) {
                        f6933a = new w();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f6933a;
    }

    public final List<ai> a(String str) {
        a aVar = this.b.get(str);
        List c2 = aVar != null ? a.c(aVar, aVar.f6935a) : null;
        if (c2 != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(c2);
            return arrayList;
        }
        com.anythink.core.c.d a2 = com.anythink.core.c.e.a(com.anythink.core.common.b.n.a().g()).a(str);
        if (a2 != null) {
            return a2.F();
        }
        return null;
    }

    public final void a(String str, String str2) {
        synchronized (this) {
            a aVar = this.b.get(str);
            if (aVar == null) {
                return;
            }
            a.b(aVar, str2);
        }
    }

    public final void a(String str, String str2, com.anythink.core.c.d dVar, List<ai> list) {
        synchronized (this) {
            a aVar = this.b.get(str);
            a aVar2 = aVar;
            if (aVar == null) {
                aVar2 = new a();
            }
            a.C0110a c0110a = aVar2.b.get(str2);
            boolean z = c0110a != null ? c0110a.f6938c : false;
            a.C0110a c0110a2 = new a.C0110a();
            c0110a2.f6937a = dVar;
            CopyOnWriteArrayList<ai> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            copyOnWriteArrayList.addAll(list);
            c0110a2.b = copyOnWriteArrayList;
            aVar2.b.put(str2, c0110a2);
            aVar2.f6935a = str2;
            this.b.put(str, aVar2);
            aVar2.d(str2);
            if (z) {
                a.b(aVar2, str2);
            }
        }
    }

    public final void a(String str, String str2, ai aiVar) {
        synchronized (this) {
            a aVar = this.b.get(str);
            if (aVar == null) {
                return;
            }
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(aiVar);
            a.a(aVar, str2, arrayList);
        }
    }

    public final void a(String str, String str2, List<ai> list) {
        synchronized (this) {
            a aVar = this.b.get(str);
            if (aVar == null) {
                return;
            }
            for (ai aiVar : list) {
                a.C0110a c0110a = aVar.b.get(str2);
                if (c0110a != null) {
                    c0110a.a(aiVar);
                }
            }
        }
    }

    public final String b(String str) {
        a aVar = this.b.get(str);
        return aVar != null ? aVar.f6935a : "";
    }

    public final List<ai> b(String str, String str2) {
        a aVar = this.b.get(str);
        if (aVar != null) {
            return a.c(aVar, str2);
        }
        return null;
    }

    public final void b(String str, String str2, List<ai> list) {
        synchronized (this) {
            a aVar = this.b.get(str);
            if (aVar == null) {
                return;
            }
            a.a(aVar, str2, list);
            a(str, str2, list);
        }
    }
}
