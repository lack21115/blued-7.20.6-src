package com.qiniu.pili.droid.shortvideo.core;

import java.nio.ByteBuffer;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/core/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f13847a;
    private ByteBuffer b;

    /* renamed from: c  reason: collision with root package name */
    private long f13848c = 0;
    private int d = 0;
    private double e = 1.0d;
    private InterfaceC0573a f;
    private long g;
    private boolean h;

    /* renamed from: com.qiniu.pili.droid.shortvideo.core.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/core/a$a.class */
    public interface InterfaceC0573a {
        void a(ByteBuffer byteBuffer, int i, long j);
    }

    public double a() {
        return this.e;
    }

    public void a(double d) {
        this.e = d;
    }

    public void a(InterfaceC0573a interfaceC0573a) {
        this.f = interfaceC0573a;
    }

    public void a(ByteBuffer byteBuffer, int i, long j) {
        byteBuffer.limit(byteBuffer.position() + i);
        double d = this.e;
        if (d >= 1.0d) {
            long j2 = j - this.g;
            int i2 = this.d;
            this.d = i2 + 1;
            if (i2 % d == 0.0d && this.f != null) {
                long j3 = this.f13847a;
                long j4 = j3 == 0 ? (long) (j2 / d) : j3 + j2;
                this.f.a(byteBuffer, i, j4);
                this.f13847a = j4;
            }
        } else {
            if (this.b == null) {
                this.b = ByteBuffer.allocateDirect(byteBuffer.capacity());
            }
            long j5 = this.f13848c;
            if (j5 > 0 && j > j5) {
                int i3 = (int) (1.0d / this.e);
                this.b.flip();
                int limit = this.b.limit();
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= i3) {
                        break;
                    }
                    if (this.f != null) {
                        long j6 = this.f13848c;
                        long j7 = this.f13847a;
                        if (j7 != 0) {
                            j6 = j7 + (j - j6);
                        }
                        InterfaceC0573a interfaceC0573a = this.f;
                        ByteBuffer byteBuffer2 = this.b;
                        interfaceC0573a.a(byteBuffer2, byteBuffer2.remaining(), j6);
                        this.f13847a = j6;
                    }
                    this.b.position(0);
                    this.b.limit(limit);
                    i4 = i5 + 1;
                }
            }
            this.f13848c = j;
            this.b.clear();
            this.b.put(byteBuffer);
        }
        this.g = j;
    }

    public void a(boolean z) {
        this.h = z;
    }

    public void b() {
        this.b = null;
        this.f13848c = 0L;
        this.d = 0;
    }

    public void b(ByteBuffer byteBuffer, int i, long j) {
        InterfaceC0573a interfaceC0573a;
        byteBuffer.limit(byteBuffer.position() + i);
        double d = this.e;
        if (d >= 1.0d) {
            int i2 = this.d;
            this.d = i2 + 1;
            if (i2 % d != 0.0d || (interfaceC0573a = this.f) == null) {
                return;
            }
            interfaceC0573a.a(byteBuffer, i, (long) (j / d));
            return;
        }
        if (this.b == null) {
            this.b = ByteBuffer.allocateDirect(byteBuffer.capacity());
        }
        long j2 = this.f13848c;
        if (j2 > 0 && j > j2) {
            int i3 = (int) (1.0d / this.e);
            long j3 = (j - j2) / i3;
            this.b.flip();
            int limit = this.b.limit();
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= i3) {
                    break;
                }
                InterfaceC0573a interfaceC0573a2 = this.f;
                if (interfaceC0573a2 != null) {
                    ByteBuffer byteBuffer2 = this.b;
                    interfaceC0573a2.a(byteBuffer2, byteBuffer2.remaining(), (long) ((this.f13848c + (i5 * j3)) / this.e));
                }
                this.b.position(0);
                this.b.limit(limit);
                i4 = i5 + 1;
            }
        }
        this.f13848c = j;
        this.b.clear();
        this.b.put(byteBuffer);
    }

    public void c(ByteBuffer byteBuffer, int i, long j) {
        if (this.h) {
            a(byteBuffer, i, j);
        } else {
            b(byteBuffer, i, j);
        }
    }
}
