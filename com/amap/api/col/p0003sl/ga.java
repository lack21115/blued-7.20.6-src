package com.amap.api.col.p0003sl;

import java.util.HashMap;

/* renamed from: com.amap.api.col.3sl.ga  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ga.class */
public class ga {
    private static volatile ga a;
    private HashMap<String, gb> b = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.col.3sl.ga$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ga$a.class */
    public static final class a {
        private boolean a = true;
        private long b = 86400;
        private int c = 10;
        private double d = 0.0d;

        public final void a(double d) {
            this.d = d;
        }

        public final void a(int i) {
            this.c = i;
        }

        public final void a(long j) {
            this.b = j;
        }

        public final void a(boolean z) {
            this.a = z;
        }

        public final boolean a() {
            return this.a;
        }

        public final long b() {
            return this.b;
        }

        public final int c() {
            return this.c;
        }

        public final double d() {
            return this.d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.col.3sl.ga$b */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ga$b.class */
    public static final class b {
        String a;
        Object b;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            String str = this.a;
            return str == null ? bVar.a == null && this.b == bVar.b : str.equals(bVar.a) && this.b == bVar.b;
        }

        public final int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = str == null ? 0 : str.hashCode();
            Object obj = this.b;
            if (obj != null) {
                i = obj.hashCode();
            }
            return ((hashCode + 31) * 31) + i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.col.3sl.ga$c */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ga$c.class */
    public static final class c {
        Object a;
        boolean b;

        public c(Object obj, boolean z) {
            this.a = obj;
            this.b = z;
        }
    }

    public static ga a() {
        if (a == null) {
            synchronized (ga.class) {
                try {
                    if (a == null) {
                        a = new ga();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return a;
    }

    public final c a(b bVar) {
        c a2;
        if (bVar == null) {
            return null;
        }
        for (gb gbVar : this.b.values()) {
            if (gbVar != null && (a2 = gbVar.a(bVar)) != null) {
                return a2;
            }
        }
        return null;
    }

    public final gb a(String str) {
        gb gbVar;
        synchronized (this) {
            gbVar = this.b.get(str);
        }
        return gbVar;
    }

    public final void a(a aVar) {
        if (aVar == null) {
            return;
        }
        for (gb gbVar : this.b.values()) {
            if (gbVar != null) {
                gbVar.a(aVar);
            }
        }
    }

    public final void a(b bVar, Object obj) {
        for (gb gbVar : this.b.values()) {
            if (gbVar != null) {
                gbVar.a(bVar, obj);
            }
        }
    }

    public final void a(String str, a aVar) {
        gb gbVar;
        if (str == null || aVar == null || (gbVar = this.b.get(str)) == null) {
            return;
        }
        gbVar.a(aVar);
    }

    public final void a(String str, gb gbVar) {
        synchronized (this) {
            this.b.put(str, gbVar);
        }
    }

    public final boolean b(b bVar) {
        if (bVar == null) {
            return false;
        }
        for (gb gbVar : this.b.values()) {
            if (gbVar != null && gbVar.b(bVar)) {
                return true;
            }
        }
        return false;
    }
}
