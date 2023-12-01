package com.anythink.core.common.c;

import com.anythink.core.common.e.o;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/c/g.class */
public class g extends com.anythink.core.common.c.a<o> {
    private static final String b = g.class.getName();

    /* renamed from: c  reason: collision with root package name */
    private static g f6581c;
    private int d;

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/c/g$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final String f6582a = "request_info";
        public static final String b = "id";

        /* renamed from: c  reason: collision with root package name */
        public static final String f6583c = "req_type";
        public static final String d = "req_url";
        public static final String e = "req_head";
        public static final String f = "req_content";
        public static final String g = "time";
        public static final String h = "extra";
        public static final String i = "CREATE TABLE IF NOT EXISTS request_info(id TEXT, req_type INTEGER, req_url TEXT, req_head TEXT, req_content TEXT, time INTEGER, extra TEXT )";
    }

    private g(b bVar) {
        super(bVar);
        this.d = 1000;
    }

    public static g a(b bVar) {
        if (f6581c == null) {
            synchronized (g.class) {
                try {
                    if (f6581c == null) {
                        f6581c = new g(bVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f6581c;
    }

    private void d() {
        synchronized (this) {
            try {
                if (b() == null) {
                    return;
                }
                b().delete(a.f6582a, null, null);
            } catch (Exception e) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003b, code lost:
        if (r13 != null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003e, code lost:
        r13.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0064, code lost:
        if (r13 == null) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long a(com.anythink.core.common.e.o r10) {
        /*
            Method dump skipped, instructions count: 250
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.c.g.a(com.anythink.core.common.e.o):long");
    }

    public final int b(o oVar) {
        synchronized (this) {
            if (b() == null || oVar == null) {
                return -1;
            }
            try {
                return b().delete(a.f6582a, "id=?", new String[]{oVar.f6671a});
            } catch (Throwable th) {
                return -1;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00ef, code lost:
        if (r11 == null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00fb, code lost:
        if (r11 == null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00fe, code lost:
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0117, code lost:
        if (r11 == null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0124, code lost:
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.anythink.core.common.e.o> c() {
        /*
            Method dump skipped, instructions count: 318
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.c.g.c():java.util.List");
    }
}
