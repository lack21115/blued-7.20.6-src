package com.heytap.nearx.a.a;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/nearx/a/a/e.class */
public abstract class e<E> {

    /* renamed from: c  reason: collision with root package name */
    public static final e<Boolean> f22261c = new e<Boolean>(com.heytap.nearx.a.a.a.VARINT, Boolean.class) { // from class: com.heytap.nearx.a.a.e.1
        @Override // com.heytap.nearx.a.a.e
        public int a(Boolean bool) {
            return 1;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
        @Override // com.heytap.nearx.a.a.e
        public void a(g gVar, Boolean bool) throws IOException {
            throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public Boolean a(f fVar) throws IOException {
            int f2 = fVar.f();
            if (f2 == 0) {
                return Boolean.FALSE;
            }
            if (f2 == 1) {
                return Boolean.TRUE;
            }
            throw new IOException(String.format("Invalid boolean value 0x%02x", Integer.valueOf(f2)));
        }
    };
    public static final e<Integer> d = new e<Integer>(com.heytap.nearx.a.a.a.VARINT, Integer.class) { // from class: com.heytap.nearx.a.a.e.7
        @Override // com.heytap.nearx.a.a.e
        public int a(Integer num) {
            return g.b(num.intValue());
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(g gVar, Integer num) throws IOException {
            gVar.f(num.intValue());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public Integer a(f fVar) throws IOException {
            return Integer.valueOf(fVar.f());
        }
    };
    public static final e<Integer> e = new e<Integer>(com.heytap.nearx.a.a.a.VARINT, Integer.class) { // from class: com.heytap.nearx.a.a.e.8
        @Override // com.heytap.nearx.a.a.e
        public int a(Integer num) {
            return g.c(num.intValue());
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(g gVar, Integer num) throws IOException {
            gVar.g(num.intValue());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public Integer a(f fVar) throws IOException {
            return Integer.valueOf(fVar.f());
        }
    };
    public static final e<Integer> f = new e<Integer>(com.heytap.nearx.a.a.a.VARINT, Integer.class) { // from class: com.heytap.nearx.a.a.e.9
        @Override // com.heytap.nearx.a.a.e
        public int a(Integer num) {
            return g.c(g.d(num.intValue()));
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(g gVar, Integer num) throws IOException {
            gVar.g(g.d(num.intValue()));
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public Integer a(f fVar) throws IOException {
            return Integer.valueOf(g.e(fVar.f()));
        }
    };
    public static final e<Integer> g;
    public static final e<Integer> h;
    public static final e<Long> i;
    public static final e<Long> j;
    public static final e<Long> k;
    public static final e<Long> l;
    public static final e<Long> m;
    public static final e<Float> n;
    public static final e<Double> o;
    public static final e<String> p;
    public static final e<ByteString> q;

    /* renamed from: a  reason: collision with root package name */
    final Class<?> f22262a;
    e<List<E>> b;
    private final com.heytap.nearx.a.a.a r;

    /* loaded from: source-7994992-dex2jar.jar:com/heytap/nearx/a/a/e$a.class */
    public static final class a extends IllegalArgumentException {

        /* renamed from: a  reason: collision with root package name */
        public final int f22263a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i, Class<?> cls) {
            super("Unknown enum tag " + i + " for " + cls.getCanonicalName());
            this.f22263a = i;
        }
    }

    static {
        e<Integer> eVar = new e<Integer>(com.heytap.nearx.a.a.a.FIXED32, Integer.class) { // from class: com.heytap.nearx.a.a.e.10
            @Override // com.heytap.nearx.a.a.e
            public int a(Integer num) {
                return 4;
            }

            @Override // com.heytap.nearx.a.a.e
            public void a(g gVar, Integer num) throws IOException {
                gVar.h(num.intValue());
            }

            @Override // com.heytap.nearx.a.a.e
            /* renamed from: b */
            public Integer a(f fVar) throws IOException {
                return Integer.valueOf(fVar.h());
            }
        };
        g = eVar;
        h = eVar;
        i = new e<Long>(com.heytap.nearx.a.a.a.VARINT, Long.class) { // from class: com.heytap.nearx.a.a.e.11
            @Override // com.heytap.nearx.a.a.e
            public int a(Long l2) {
                return g.a(l2.longValue());
            }

            @Override // com.heytap.nearx.a.a.e
            public void a(g gVar, Long l2) throws IOException {
                gVar.d(l2.longValue());
            }

            @Override // com.heytap.nearx.a.a.e
            /* renamed from: b */
            public Long a(f fVar) throws IOException {
                return Long.valueOf(fVar.g());
            }
        };
        j = new e<Long>(com.heytap.nearx.a.a.a.VARINT, Long.class) { // from class: com.heytap.nearx.a.a.e.12
            @Override // com.heytap.nearx.a.a.e
            public int a(Long l2) {
                return g.a(l2.longValue());
            }

            @Override // com.heytap.nearx.a.a.e
            public void a(g gVar, Long l2) throws IOException {
                gVar.d(l2.longValue());
            }

            @Override // com.heytap.nearx.a.a.e
            /* renamed from: b */
            public Long a(f fVar) throws IOException {
                return Long.valueOf(fVar.g());
            }
        };
        k = new e<Long>(com.heytap.nearx.a.a.a.VARINT, Long.class) { // from class: com.heytap.nearx.a.a.e.13
            @Override // com.heytap.nearx.a.a.e
            public int a(Long l2) {
                return g.a(g.b(l2.longValue()));
            }

            @Override // com.heytap.nearx.a.a.e
            public void a(g gVar, Long l2) throws IOException {
                gVar.d(g.b(l2.longValue()));
            }

            @Override // com.heytap.nearx.a.a.e
            /* renamed from: b */
            public Long a(f fVar) throws IOException {
                return Long.valueOf(g.c(fVar.g()));
            }
        };
        e<Long> eVar2 = new e<Long>(com.heytap.nearx.a.a.a.FIXED64, Long.class) { // from class: com.heytap.nearx.a.a.e.14
            @Override // com.heytap.nearx.a.a.e
            public int a(Long l2) {
                return 8;
            }

            @Override // com.heytap.nearx.a.a.e
            public void a(g gVar, Long l2) throws IOException {
                gVar.e(l2.longValue());
            }

            @Override // com.heytap.nearx.a.a.e
            /* renamed from: b */
            public Long a(f fVar) throws IOException {
                return Long.valueOf(fVar.i());
            }
        };
        l = eVar2;
        m = eVar2;
        n = new e<Float>(com.heytap.nearx.a.a.a.FIXED32, Float.class) { // from class: com.heytap.nearx.a.a.e.2
            @Override // com.heytap.nearx.a.a.e
            public int a(Float f2) {
                return 4;
            }

            @Override // com.heytap.nearx.a.a.e
            public void a(g gVar, Float f2) throws IOException {
                gVar.h(Float.floatToIntBits(f2.floatValue()));
            }

            @Override // com.heytap.nearx.a.a.e
            /* renamed from: b */
            public Float a(f fVar) throws IOException {
                return Float.valueOf(Float.intBitsToFloat(fVar.h()));
            }
        };
        o = new e<Double>(com.heytap.nearx.a.a.a.FIXED64, Double.class) { // from class: com.heytap.nearx.a.a.e.3
            @Override // com.heytap.nearx.a.a.e
            public int a(Double d2) {
                return 8;
            }

            @Override // com.heytap.nearx.a.a.e
            public void a(g gVar, Double d2) throws IOException {
                gVar.e(Double.doubleToLongBits(d2.doubleValue()));
            }

            @Override // com.heytap.nearx.a.a.e
            /* renamed from: b */
            public Double a(f fVar) throws IOException {
                return Double.valueOf(Double.longBitsToDouble(fVar.i()));
            }
        };
        p = new e<String>(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, String.class) { // from class: com.heytap.nearx.a.a.e.4
            @Override // com.heytap.nearx.a.a.e
            public int a(String str) {
                return g.a(str);
            }

            @Override // com.heytap.nearx.a.a.e
            public void a(g gVar, String str) throws IOException {
                gVar.b(str);
            }

            @Override // com.heytap.nearx.a.a.e
            /* renamed from: b */
            public String a(f fVar) throws IOException {
                return fVar.e();
            }
        };
        q = new e<ByteString>(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, ByteString.class) { // from class: com.heytap.nearx.a.a.e.5
            @Override // com.heytap.nearx.a.a.e
            public int a(ByteString byteString) {
                return byteString.size();
            }

            @Override // com.heytap.nearx.a.a.e
            public void a(g gVar, ByteString byteString) throws IOException {
                gVar.a(byteString);
            }

            @Override // com.heytap.nearx.a.a.e
            /* renamed from: b */
            public ByteString a(f fVar) throws IOException {
                return fVar.d();
            }
        };
    }

    public e(com.heytap.nearx.a.a.a aVar, Class<?> cls) {
        this.r = aVar;
        this.f22262a = cls;
    }

    public static <E extends i> h<E> a(Class<E> cls) {
        return new h<>(cls);
    }

    private e<List<E>> b() {
        return new e<List<E>>(this.r, List.class) { // from class: com.heytap.nearx.a.a.e.6
            @Override // com.heytap.nearx.a.a.e
            public /* bridge */ /* synthetic */ int a(int i2, Object obj) {
                return a(i2, (List) ((List) obj));
            }

            public int a(int i2, List<E> list) {
                int size = list.size();
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i3 >= size) {
                        return i5;
                    }
                    int a2 = e.this.a(i2, (int) list.get(i3));
                    i3++;
                    i4 = i5 + a2;
                }
            }

            @Override // com.heytap.nearx.a.a.e
            public /* bridge */ /* synthetic */ int a(Object obj) {
                return a((List) ((List) obj));
            }

            public int a(List<E> list) {
                throw new UnsupportedOperationException("Repeated values can only be sized with a tag.");
            }

            @Override // com.heytap.nearx.a.a.e
            public /* bridge */ /* synthetic */ void a(g gVar, int i2, Object obj) throws IOException {
                a(gVar, i2, (List) ((List) obj));
            }

            public void a(g gVar, int i2, List<E> list) throws IOException {
                int size = list.size();
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= size) {
                        return;
                    }
                    e.this.a(gVar, i2, list.get(i4));
                    i3 = i4 + 1;
                }
            }

            @Override // com.heytap.nearx.a.a.e
            public /* bridge */ /* synthetic */ void a(g gVar, Object obj) throws IOException {
                a(gVar, (List) ((List) obj));
            }

            public void a(g gVar, List<E> list) {
                throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
            }

            @Override // com.heytap.nearx.a.a.e
            /* renamed from: b */
            public List<E> a(f fVar) throws IOException {
                return Collections.singletonList(e.this.a(fVar));
            }
        };
    }

    public static <M> e<M> b(Class<M> cls) {
        try {
            return (e) cls.getField("ADAPTER").get(null);
        } catch (IllegalAccessException | NoSuchFieldException e2) {
            throw new IllegalArgumentException("failed to access " + cls.getName() + "#ADAPTER", e2);
        }
    }

    public int a(int i2, E e2) {
        int a2 = a((e<E>) e2);
        int i3 = a2;
        if (this.r == com.heytap.nearx.a.a.a.LENGTH_DELIMITED) {
            i3 = a2 + g.c(a2);
        }
        return i3 + g.a(i2);
    }

    public abstract int a(E e2);

    public final e<List<E>> a() {
        e<List<E>> eVar = this.b;
        if (eVar != null) {
            return eVar;
        }
        e<List<E>> b = b();
        this.b = b;
        return b;
    }

    public abstract E a(f fVar) throws IOException;

    public final E a(InputStream inputStream) throws IOException {
        d.a(inputStream, "stream == null");
        return a(Okio.buffer(Okio.source(inputStream)));
    }

    public final E a(BufferedSource bufferedSource) throws IOException {
        d.a(bufferedSource, "source == null");
        return a(new f(bufferedSource));
    }

    public final E a(byte[] bArr) throws IOException {
        d.a(bArr, "bytes == null");
        return a((BufferedSource) new Buffer().write(bArr));
    }

    public void a(g gVar, int i2, E e2) throws IOException {
        gVar.a(i2, this.r);
        if (this.r == com.heytap.nearx.a.a.a.LENGTH_DELIMITED) {
            gVar.g(a((e<E>) e2));
        }
        a(gVar, (g) e2);
    }

    public abstract void a(g gVar, E e2) throws IOException;

    public final void a(BufferedSink bufferedSink, E e2) throws IOException {
        d.a(e2, "value == null");
        d.a(bufferedSink, "sink == null");
        a(new g(bufferedSink), (g) e2);
    }

    public final byte[] b(E e2) {
        d.a(e2, "value == null");
        Buffer buffer = new Buffer();
        try {
            a((BufferedSink) buffer, (Buffer) e2);
            return buffer.readByteArray();
        } catch (IOException e3) {
            throw new AssertionError(e3);
        }
    }

    public String c(E e2) {
        return e2.toString();
    }
}
