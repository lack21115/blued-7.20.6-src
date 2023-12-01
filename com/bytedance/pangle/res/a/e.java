package com.bytedance.pangle.res.a;

import java.io.InputStream;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/res/a/e.class */
public final class e extends j {

    /* renamed from: a  reason: collision with root package name */
    private long f21479a;

    public e(InputStream inputStream) {
        super(inputStream);
    }

    public final int a() {
        long b = b();
        if (b <= 2147483647L) {
            return (int) b;
        }
        throw new ArithmeticException("The byte count " + b + " is too large to be converted to an int");
    }

    @Override // com.bytedance.pangle.res.a.j
    protected final void a(int i) {
        synchronized (this) {
            if (i != -1) {
                this.f21479a += i;
            }
        }
    }

    public final long b() {
        long j;
        synchronized (this) {
            j = this.f21479a;
        }
        return j;
    }

    @Override // com.bytedance.pangle.res.a.j, java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j) {
        long skip;
        synchronized (this) {
            skip = super.skip(j);
            this.f21479a += skip;
        }
        return skip;
    }
}
