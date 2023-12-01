package com.opos.exoplayer.core.a;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/a/d.class */
public interface d {

    /* renamed from: a  reason: collision with root package name */
    public static final ByteBuffer f25014a = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/a/d$a.class */
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
