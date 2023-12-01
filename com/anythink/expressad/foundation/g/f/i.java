package com.anythink.expressad.foundation.g.f;

import com.anythink.expressad.foundation.h.o;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.GZIPInputStream;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/g/f/i.class */
public abstract class i<T> implements Comparable<i<T>> {

    /* renamed from: c  reason: collision with root package name */
    private static final String f5076c = i.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    protected ConcurrentHashMap<String, String> f5077a;
    protected e<T> b;
    private final int d;
    private final String e;
    private Integer f;
    private j g;
    private boolean h;
    private l i;
    private Object j;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/g/f/i$a.class */
    public interface a {

        /* renamed from: a  reason: collision with root package name */
        public static final int f5078a = 0;
        public static final int b = 1;

        /* renamed from: c  reason: collision with root package name */
        public static final int f5079c = 2;
        public static final int d = 3;
        public static final int e = 4;
        public static final int f = 5;
        public static final int g = 6;
        public static final int h = 7;
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/g/f/i$b.class */
    public final class b {

        /* renamed from: a  reason: collision with root package name */
        public static final int f5080a = 1;
        public static final int b = 2;

        /* renamed from: c  reason: collision with root package name */
        public static final int f5081c = 3;
        public static final int d = 4;

        private b() {
        }
    }

    public i(int i, String str, e<T> eVar) {
        this.f5077a = new ConcurrentHashMap<>();
        this.b = null;
        this.h = false;
        this.e = str;
        this.d = i;
        this.b = eVar;
        this.i = new com.anythink.expressad.foundation.g.f.b();
    }

    public i(String str) {
        this.f5077a = new ConcurrentHashMap<>();
        this.b = null;
        this.h = false;
        this.e = str;
        this.d = 0;
        this.i = new com.anythink.expressad.foundation.g.f.b();
    }

    private int a(i<T> iVar) {
        int j = j();
        int j2 = iVar.j();
        return j == j2 ? this.f.intValue() - iVar.f.intValue() : j2 - j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static com.anythink.expressad.foundation.g.f.a.a a(com.anythink.expressad.foundation.g.f.a.a aVar) {
        return aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private i<?> a(Object obj) {
        this.j = obj;
        return this;
    }

    private void a(String str) {
        this.f5077a.remove(str);
    }

    private static byte[] a(com.anythink.expressad.foundation.g.f.f.b bVar) {
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream = null;
        try {
            InputStream c2 = bVar.c();
            GZIPInputStream gZIPInputStream = c2;
            inputStream = c2;
            try {
                if (com.anythink.expressad.foundation.g.f.g.e.b(bVar.b())) {
                    gZIPInputStream = c2;
                    if (!(c2 instanceof GZIPInputStream)) {
                        gZIPInputStream = new GZIPInputStream(c2);
                    }
                }
                if (gZIPInputStream != null) {
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = gZIPInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream2.write(bArr, 0, read);
                        }
                        byte[] byteArray = byteArrayOutputStream2.toByteArray();
                        if (gZIPInputStream != null) {
                            try {
                                gZIPInputStream.close();
                            } catch (IOException e) {
                                o.d(f5076c, e.getMessage());
                                return byteArray;
                            }
                        }
                        byteArrayOutputStream2.close();
                        return byteArray;
                    } catch (Throwable th) {
                        inputStream = gZIPInputStream;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        th = th;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e2) {
                                o.d(f5076c, e2.getMessage());
                                throw th;
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        throw th;
                    }
                }
                throw new com.anythink.expressad.foundation.g.f.a.a(7, null);
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
        }
    }

    private int p() {
        Integer num = this.f;
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("getSequence called before setSequence");
    }

    private static void q() {
    }

    private static void r() {
    }

    public final int a() {
        return this.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final i<?> a(int i) {
        this.f = Integer.valueOf(i);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final i<?> a(j jVar) {
        this.g = jVar;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final i<?> a(l lVar) {
        this.i = lVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract k<T> a(com.anythink.expressad.foundation.g.f.f.c cVar);

    public final void a(long j, long j2) {
        e<T> eVar = this.b;
        if (eVar != null) {
            eVar.a(j, j2);
        }
    }

    public final void a(e<T> eVar) {
        this.b = eVar;
    }

    public final void a(k<T> kVar) {
        e<T> eVar = this.b;
        if (eVar != null) {
            eVar.a(kVar);
        }
    }

    public void a(OutputStream outputStream) {
    }

    public final void a(String str, String str2) {
        this.f5077a.remove(str);
        this.f5077a.put(str, str2);
    }

    public final void a(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            a(entry.getKey(), entry.getValue());
        }
    }

    public byte[] a(com.anythink.expressad.foundation.g.f.f.b bVar, c cVar) {
        return bVar.c() != null ? a(bVar) : new byte[0];
    }

    public final Object b() {
        return this.j;
    }

    public final void b(com.anythink.expressad.foundation.g.f.a.a aVar) {
        e<T> eVar = this.b;
        if (eVar != null) {
            eVar.a(aVar);
        }
    }

    public final void c() {
        j jVar = this.g;
        if (jVar != null) {
            jVar.b(this);
        }
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Object obj) {
        i iVar = (i) obj;
        int j = j();
        int j2 = iVar.j();
        return j == j2 ? this.f.intValue() - iVar.f.intValue() : j2 - j;
    }

    public final String d() {
        return this.e;
    }

    public final void e() {
        this.h = true;
    }

    public final boolean f() {
        return this.h;
    }

    public final Map<String, String> g() {
        return this.f5077a;
    }

    public byte[] h() {
        return null;
    }

    public void i() {
        a("Connection", "close");
        a("Charset", "UTF-8");
    }

    public int j() {
        return 2;
    }

    public final int k() {
        return this.i.b();
    }

    public final l l() {
        return this.i;
    }

    public final void m() {
        e<T> eVar = this.b;
        if (eVar != null) {
            eVar.c();
        }
    }

    public final void n() {
        e<T> eVar = this.b;
        if (eVar != null) {
            eVar.b();
        }
    }

    public final void o() {
        e<T> eVar = this.b;
        if (eVar != null) {
            eVar.a();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.h ? "[X] " : "[ ] ");
        sb.append(this.e);
        sb.append(" ");
        sb.append(j());
        sb.append(" ");
        sb.append(this.f);
        return sb.toString();
    }
}
