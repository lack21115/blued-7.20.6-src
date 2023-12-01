package com.anythink.expressad.exoplayer.d;

import com.anythink.expressad.exoplayer.d.i;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/d/j.class */
public interface j<T extends i> {

    /* renamed from: a  reason: collision with root package name */
    public static final int f7258a = 2;
    public static final int b = 3;

    /* renamed from: c  reason: collision with root package name */
    public static final int f7259c = 1;
    public static final int d = 1;
    public static final int e = 2;
    public static final int f = 3;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/d/j$a.class */
    public static final class a implements d {

        /* renamed from: a  reason: collision with root package name */
        private final byte[] f7260a;
        private final String b;

        public a(byte[] bArr, String str) {
            this.f7260a = bArr;
            this.b = str;
        }

        @Override // com.anythink.expressad.exoplayer.d.j.d
        public final byte[] a() {
            return this.f7260a;
        }

        @Override // com.anythink.expressad.exoplayer.d.j.d
        public final String b() {
            return this.b;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/d/j$b.class */
    public static final class b implements e {

        /* renamed from: a  reason: collision with root package name */
        private final int f7261a;
        private final byte[] b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(int i, byte[] bArr) {
            this.f7261a = i;
            this.b = bArr;
        }

        @Override // com.anythink.expressad.exoplayer.d.j.e
        public final int a() {
            return this.f7261a;
        }

        @Override // com.anythink.expressad.exoplayer.d.j.e
        public final byte[] b() {
            return this.b;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/d/j$c.class */
    public static final class c implements h {

        /* renamed from: a  reason: collision with root package name */
        private final byte[] f7262a;
        private final String b;

        public c(byte[] bArr, String str) {
            this.f7262a = bArr;
            this.b = str;
        }

        @Override // com.anythink.expressad.exoplayer.d.j.h
        public final byte[] a() {
            return this.f7262a;
        }

        @Override // com.anythink.expressad.exoplayer.d.j.h
        public final String b() {
            return this.b;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/d/j$d.class */
    public interface d {
        byte[] a();

        String b();
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/d/j$e.class */
    public interface e {
        int a();

        byte[] b();
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/d/j$f.class */
    public interface f<T extends i> {
        void a(byte[] bArr, int i);
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/d/j$g.class */
    public interface g<T extends i> {
        void a();
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/d/j$h.class */
    public interface h {
        byte[] a();

        String b();
    }

    d a(byte[] bArr, byte[] bArr2, String str, int i, HashMap<String, String> hashMap);

    String a(String str);

    void a(f<? super T> fVar);

    void a(g<? super T> gVar);

    void a(String str, String str2);

    void a(String str, byte[] bArr);

    void a(byte[] bArr);

    byte[] a();

    byte[] a(byte[] bArr, byte[] bArr2);

    h b();

    void b(byte[] bArr);

    void b(byte[] bArr, byte[] bArr2);

    byte[] b(String str);

    Map<String, String> c(byte[] bArr);

    void c();

    T d(byte[] bArr);
}
