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
    private static volatile w a;
    private final String c = "Waterfall_Final";
    private ConcurrentHashMap<String, a> b = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/w$a.class */
    public final class a {
        String a;
        ConcurrentHashMap<String, C0070a> b = new ConcurrentHashMap<>();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.anythink.core.common.w$a$a  reason: collision with other inner class name */
        /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/w$a$a.class */
        public final class C0070a {
            com.anythink.core.c.d a;
            CopyOnWriteArrayList<ai> b;
            boolean c;

            C0070a() {
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
                    if (this.c) {
                        return;
                    }
                    this.c = true;
                }
            }

            private boolean c() {
                return this.c;
            }
        }

        a() {
        }

        private List<ai> a(String str) {
            C0070a c0070a = this.b.get(str);
            if (c0070a != null) {
                return c0070a.b;
            }
            return null;
        }

        private static /* synthetic */ void a(a aVar, String str, com.anythink.core.c.d dVar, List list) {
            C0070a c0070a = new C0070a();
            c0070a.a = dVar;
            CopyOnWriteArrayList<ai> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            copyOnWriteArrayList.addAll(list);
            c0070a.b = copyOnWriteArrayList;
            aVar.b.put(str, c0070a);
        }

        private static /* synthetic */ void a(a aVar, String str, ai aiVar) {
            C0070a c0070a = aVar.b.get(str);
            if (c0070a != null) {
                c0070a.a(aiVar);
            }
        }

        static /* synthetic */ void a(a aVar, String str, List list) {
            C0070a c0070a = aVar.b.get(str);
            if (c0070a != null) {
                c0070a.a(list);
            }
        }

        private void a(String str, com.anythink.core.c.d dVar, List<ai> list) {
            C0070a c0070a = new C0070a();
            c0070a.a = dVar;
            CopyOnWriteArrayList<ai> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            copyOnWriteArrayList.addAll(list);
            c0070a.b = copyOnWriteArrayList;
            this.b.put(str, c0070a);
        }

        private void a(String str, ai aiVar) {
            C0070a c0070a = this.b.get(str);
            if (c0070a != null) {
                c0070a.a(aiVar);
            }
        }

        private void a(String str, List<ai> list) {
            C0070a c0070a = this.b.get(str);
            if (c0070a != null) {
                c0070a.a(list);
            }
        }

        static /* synthetic */ void b(a aVar, String str) {
            C0070a c0070a = aVar.b.get(str);
            if (c0070a != null) {
                c0070a.b();
            }
        }

        private boolean b(String str) {
            C0070a c0070a = this.b.get(str);
            if (c0070a != null) {
                return c0070a.c;
            }
            return false;
        }

        static /* synthetic */ List c(a aVar, String str) {
            C0070a c0070a = aVar.b.get(str);
            if (c0070a != null) {
                return c0070a.b;
            }
            return null;
        }

        private void c(String str) {
            C0070a c0070a = this.b.get(str);
            if (c0070a != null) {
                c0070a.b();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(String str) {
            synchronized (this) {
                Iterator<Map.Entry<String, C0070a>> it = this.b.entrySet().iterator();
                while (it.hasNext()) {
                    String key = it.next().getKey();
                    if (key != null) {
                        String obj = key.toString();
                        if (this.b.get(obj).c && !TextUtils.equals(str, obj)) {
                            it.remove();
                        }
                    }
                }
            }
        }

        private static /* synthetic */ boolean d(a aVar, String str) {
            C0070a c0070a = aVar.b.get(str);
            if (c0070a != null) {
                return c0070a.c;
            }
            return false;
        }
    }

    private w() {
    }

    public static w a() {
        if (a == null) {
            synchronized (w.class) {
                try {
                    if (a == null) {
                        a = new w();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return a;
    }

    public final List<ai> a(String str) {
        a aVar = this.b.get(str);
        List c = aVar != null ? a.c(aVar, aVar.a) : null;
        if (c != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(c);
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
            a.C0070a c0070a = aVar2.b.get(str2);
            boolean z = c0070a != null ? c0070a.c : false;
            a.C0070a c0070a2 = new a.C0070a();
            c0070a2.a = dVar;
            CopyOnWriteArrayList<ai> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            copyOnWriteArrayList.addAll(list);
            c0070a2.b = copyOnWriteArrayList;
            aVar2.b.put(str2, c0070a2);
            aVar2.a = str2;
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
                a.C0070a c0070a = aVar.b.get(str2);
                if (c0070a != null) {
                    c0070a.a(aiVar);
                }
            }
        }
    }

    public final String b(String str) {
        a aVar = this.b.get(str);
        return aVar != null ? aVar.a : "";
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
