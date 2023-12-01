package com.bytedance.pangle.f.a;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/f/a/a.class */
final class a {

    /* renamed from: a  reason: collision with root package name */
    int f21396a;
    b b;

    /* renamed from: c  reason: collision with root package name */
    int[] f21397c;
    private boolean i;
    private f k;
    private boolean j = false;
    private final c l = new c();
    int d = 0;
    int e = 1;
    int f = 2;
    int g = 3;
    int h = 4;

    public a() {
        c();
    }

    private void c() {
        this.f21397c = null;
        this.f21396a = -1;
    }

    private int e(int i) {
        if (this.f21396a == 2) {
            int i2 = i * 5;
            if (i2 < this.f21397c.length) {
                return i2;
            }
            throw new IndexOutOfBoundsException("Invalid attribute index (" + i + ").");
        }
        throw new IndexOutOfBoundsException("Current event is not START_TAG.");
    }

    public final String a(int i) {
        int i2 = this.f21397c[e(i) + 1];
        return i2 == -1 ? "" : this.k.a(i2);
    }

    public final void a() {
        if (this.j) {
            this.j = false;
            b bVar = this.b;
            if (bVar.f21399a != null) {
                try {
                    bVar.f21399a.close();
                } catch (IOException e) {
                }
                bVar.a((InputStream) null);
            }
            this.k = null;
            this.b = null;
            c cVar = this.l;
            cVar.b = 0;
            cVar.f21401c = 0;
            c();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:111:0x03f6, code lost:
        throw new java.io.IOException("Invalid chunk type (" + r6 + ").");
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01e0, code lost:
        throw new java.io.IOException("Invalid resource ids size (" + r0 + ").");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int b() {
        /*
            Method dump skipped, instructions count: 1053
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.f.a.a.b():int");
    }

    public final int b(int i) {
        return this.f21397c[e(i) + 3];
    }

    public final int c(int i) {
        return this.f21397c[e(i) + 4];
    }

    public final String d(int i) {
        int e = e(i);
        int[] iArr = this.f21397c;
        if (iArr[e + 3] == 3) {
            return this.k.a(iArr[e + 2]);
        }
        return "";
    }
}
