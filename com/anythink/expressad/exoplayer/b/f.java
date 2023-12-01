package com.anythink.expressad.exoplayer.b;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/b/f.class */
public interface f {

    /* renamed from: a  reason: collision with root package name */
    public static final ByteBuffer f7181a = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/b/f$a.class */
    public static final class a extends Exception {
        public a(int i, int i2, int i3) {
            super("Unhandled format: " + i + " Hz, " + i2 + " channels in encoding " + i3);
        }
    }

    void a(ByteBuffer byteBuffer);

    boolean a();

    boolean a(int i, int i2, int i3);

    int b();

    int c();

    int d();

    void e();

    ByteBuffer f();

    boolean g();

    void h();

    void i();
}
