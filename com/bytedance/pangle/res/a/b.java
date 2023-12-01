package com.bytedance.pangle.res.a;

import java.io.IOException;
import java.util.HashMap;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/res/a/b.class */
public final class b {

    /* renamed from: c  reason: collision with root package name */
    g f21474c;
    private final h i;
    private final byte[] j;
    private int[] l;
    private boolean n;
    private int o;
    private int[] p;
    private int q;

    /* renamed from: a  reason: collision with root package name */
    HashMap<Integer, Integer> f21473a = new HashMap<>();
    boolean b = false;
    private boolean k = false;
    private final a m = new a();
    int d = 0;
    int e = 1;
    int f = 2;
    int g = 3;
    int h = 4;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/res/a/b$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        int[] f21475a = new int[32];
        int b;

        /* renamed from: c  reason: collision with root package name */
        int f21476c;

        public final void a() {
            b();
            int i = this.b;
            int[] iArr = this.f21475a;
            iArr[i] = 0;
            iArr[i + 1] = 0;
            this.b = i + 2;
            this.f21476c++;
        }

        final void b() {
            int[] iArr = this.f21475a;
            int length = iArr.length;
            int i = this.b;
            int i2 = length - i;
            if (i2 > 2) {
                return;
            }
            int[] iArr2 = new int[(iArr.length + i2) * 2];
            System.arraycopy((Object) iArr, 0, (Object) iArr2, 0, i);
            this.f21475a = iArr2;
        }
    }

    public b(byte[] bArr, h hVar) {
        this.i = hVar;
        this.j = bArr;
        c();
    }

    private void c() {
        this.o = -1;
        this.p = null;
        this.q = -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:121:0x04e9, code lost:
        throw new java.io.IOException("Invalid chunk type (" + r9 + ").");
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0205, code lost:
        throw new java.io.IOException("Invalid resource ids size (" + r0 + ").");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void d() {
        /*
            Method dump skipped, instructions count: 1258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.res.a.b.d():void");
    }

    public final void a() {
        if (this.k) {
            this.k = false;
            this.f21474c = null;
            this.l = null;
            a aVar = this.m;
            aVar.b = 0;
            aVar.f21476c = 0;
            c();
        }
    }

    public final int b() {
        if (this.f21474c != null) {
            try {
                d();
                return this.o;
            } catch (IOException e) {
                a();
                throw e;
            }
        }
        throw new RuntimeException("Parser is not opened.");
    }
}
