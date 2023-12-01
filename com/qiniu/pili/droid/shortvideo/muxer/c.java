package com.qiniu.pili.droid.shortvideo.muxer;

import android.media.MediaCodec;
import android.media.MediaFormat;
import java.nio.ByteBuffer;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/muxer/c.class */
public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    protected String f27733a;
    protected int b = -1;

    /* renamed from: c  reason: collision with root package name */
    protected int f27734c = -1;
    protected long d = -1;
    protected long e = -1;

    public abstract void a(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo);

    public abstract boolean a();

    public abstract boolean a(String str, MediaFormat mediaFormat, MediaFormat mediaFormat2, int i);

    public int b() {
        return this.b;
    }

    public int c() {
        return this.f27734c;
    }
}
