package com.anythink.expressad.exoplayer.j;

import android.text.TextUtils;
import com.anythink.expressad.exoplayer.j.h;
import com.anythink.expressad.exoplayer.k.af;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.XMLConstants;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/j/s.class */
public interface s extends h {

    /* renamed from: c  reason: collision with root package name */
    public static final com.anythink.expressad.exoplayer.k.u<String> f7602c = new com.anythink.expressad.exoplayer.k.u<String>() { // from class: com.anythink.expressad.exoplayer.j.s.1
        /* renamed from: a  reason: avoid collision after fix types in other method */
        private static boolean a2(String str) {
            String d2 = af.d(str);
            if (TextUtils.isEmpty(d2)) {
                return false;
            }
            return ((d2.contains("text") && !d2.contains("text/vtt")) || d2.contains(com.baidu.mobads.sdk.internal.a.f) || d2.contains(XMLConstants.XML_NS_PREFIX)) ? false : true;
        }

        @Override // com.anythink.expressad.exoplayer.k.u
        public final /* synthetic */ boolean a(String str) {
            String d2 = af.d(str);
            if (TextUtils.isEmpty(d2)) {
                return false;
            }
            return ((d2.contains("text") && !d2.contains("text/vtt")) || d2.contains(com.baidu.mobads.sdk.internal.a.f) || d2.contains(XMLConstants.XML_NS_PREFIX)) ? false : true;
        }
    };

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/j/s$a.class */
    public static abstract class a implements b {

        /* renamed from: a  reason: collision with root package name */
        private final f f7603a = new f();

        protected abstract s a(f fVar);

        @Override // com.anythink.expressad.exoplayer.j.s.b
        @Deprecated
        public final void a(String str) {
            this.f7603a.a(str);
        }

        @Override // com.anythink.expressad.exoplayer.j.s.b
        @Deprecated
        public final void a(String str, String str2) {
            this.f7603a.a(str, str2);
        }

        @Override // com.anythink.expressad.exoplayer.j.s.b, com.anythink.expressad.exoplayer.j.h.a
        /* renamed from: b */
        public final s a() {
            return a(this.f7603a);
        }

        @Override // com.anythink.expressad.exoplayer.j.s.b
        public final f c() {
            return this.f7603a;
        }

        @Override // com.anythink.expressad.exoplayer.j.s.b
        @Deprecated
        public final void d() {
            this.f7603a.a();
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/j/s$b.class */
    public interface b extends h.a {

        /* renamed from: com.anythink.expressad.exoplayer.j.s$b$-CC  reason: invalid class name */
        /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/j/s$b$-CC.class */
        public final /* synthetic */ class CC {
        }

        @Override // com.anythink.expressad.exoplayer.j.h.a
        /* synthetic */ h a();

        @Deprecated
        void a(String str);

        @Deprecated
        void a(String str, String str2);

        s b();

        f c();

        @Deprecated
        void d();
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/j/s$c.class */
    public static class c extends IOException {

        /* renamed from: a  reason: collision with root package name */
        public static final int f7604a = 1;
        public static final int b = 2;

        /* renamed from: c  reason: collision with root package name */
        public static final int f7605c = 3;
        public final int d;
        public final k e;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/j/s$c$a.class */
        public @interface a {
        }

        private c(k kVar, int i) {
            this.e = kVar;
            this.d = i;
        }

        public c(IOException iOException, k kVar, int i) {
            super(iOException);
            this.e = kVar;
            this.d = i;
        }

        public c(String str, k kVar) {
            super(str);
            this.e = kVar;
            this.d = 1;
        }

        public c(String str, IOException iOException, k kVar) {
            super(str, iOException);
            this.e = kVar;
            this.d = 1;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/j/s$d.class */
    public static final class d extends c {
        public final String f;

        public d(String str, k kVar) {
            super("Invalid content type: ".concat(String.valueOf(str)), kVar);
            this.f = str;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/j/s$e.class */
    public static final class e extends c {
        public final int f;
        public final Map<String, List<String>> g;

        public e(int i, Map<String, List<String>> map, k kVar) {
            super("Response code: ".concat(String.valueOf(i)), kVar);
            this.f = i;
            this.g = map;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/j/s$f.class */
    public static final class f {

        /* renamed from: a  reason: collision with root package name */
        private final Map<String, String> f7606a = new HashMap();
        private Map<String, String> b;

        private void a(Map<String, String> map) {
            synchronized (this) {
                this.b = null;
                this.f7606a.putAll(map);
            }
        }

        private void b(Map<String, String> map) {
            synchronized (this) {
                this.b = null;
                this.f7606a.clear();
                this.f7606a.putAll(map);
            }
        }

        public final void a() {
            synchronized (this) {
                this.b = null;
                this.f7606a.clear();
            }
        }

        public final void a(String str) {
            synchronized (this) {
                this.b = null;
                this.f7606a.remove(str);
            }
        }

        public final void a(String str, String str2) {
            synchronized (this) {
                this.b = null;
                this.f7606a.put(str, str2);
            }
        }

        public final Map<String, String> b() {
            Map<String, String> map;
            synchronized (this) {
                if (this.b == null) {
                    this.b = Collections.unmodifiableMap(new HashMap(this.f7606a));
                }
                map = this.b;
            }
            return map;
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    int a(byte[] bArr, int i, int i2);

    @Override // com.anythink.expressad.exoplayer.j.h
    long a(k kVar);

    void a(String str);

    void a(String str, String str2);

    @Override // com.anythink.expressad.exoplayer.j.h
    void b();

    Map<String, List<String>> c();

    void d();
}
