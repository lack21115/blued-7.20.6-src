package com.qiniu.pili.droid.shortvideo.muxer;

import android.media.MediaCodec;
import android.media.MediaFormat;
import com.qiniu.pili.droid.shortvideo.f.e;
import java.nio.ByteBuffer;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/muxer/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private c f27732a = new FFMP4Muxer();

    public void a(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        synchronized (this) {
            this.f27732a.a(i, byteBuffer, bufferInfo);
        }
    }

    public void a(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        a(b(), byteBuffer, bufferInfo);
    }

    public boolean a() {
        boolean a2;
        synchronized (this) {
            a2 = this.f27732a.a();
        }
        return a2;
    }

    public boolean a(String str, MediaFormat mediaFormat, MediaFormat mediaFormat2) {
        boolean a2;
        synchronized (this) {
            a2 = a(str, mediaFormat, mediaFormat2, 0);
        }
        return a2;
    }

    public boolean a(String str, MediaFormat mediaFormat, MediaFormat mediaFormat2, int i) {
        synchronized (this) {
            boolean a2 = this.f27732a.a(str, mediaFormat, mediaFormat2, i);
            if (a2) {
                return a2;
            }
            e.n.d("MP4Muxer", "MP4Muxer start failed, will switch to System Muxer");
            this.f27732a.a();
            a aVar = new a();
            this.f27732a = aVar;
            return aVar.a(str, mediaFormat, mediaFormat2, i);
        }
    }

    public int b() {
        return this.f27732a.b();
    }

    public void b(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        a(c(), byteBuffer, bufferInfo);
    }

    public int c() {
        return this.f27732a.c();
    }
}
