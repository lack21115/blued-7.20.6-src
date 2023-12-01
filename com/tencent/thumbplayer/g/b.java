package com.tencent.thumbplayer.g;

import android.media.Image;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Surface;
import com.tencent.thumbplayer.g.b.c;
import com.tencent.thumbplayer.g.h.d;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/g/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public boolean f25625a;
    public boolean b;

    /* renamed from: c  reason: collision with root package name */
    private c f25626c;
    private com.tencent.thumbplayer.g.a.a d;
    private boolean g;
    private final String h;
    private EnumC0853b i;
    private boolean f = true;
    private final com.tencent.thumbplayer.g.g.a e = new com.tencent.thumbplayer.g.g.a(b());

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/g/b$a.class */
    public static abstract class a {
        public abstract void onError(b bVar, MediaCodec.CodecException codecException);

        public abstract void onInputBufferAvailable(b bVar, int i);

        public abstract void onOutputBufferAvailable(b bVar, int i, MediaCodec.BufferInfo bufferInfo);

        public abstract void onOutputFormatChanged(b bVar, MediaFormat mediaFormat);
    }

    /* renamed from: com.tencent.thumbplayer.g.b$b  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/g/b$b.class */
    public enum EnumC0853b {
        CreateByName,
        CreateByType
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/g/b$c.class */
    public static final class c extends MediaCodec.Callback {

        /* renamed from: a  reason: collision with root package name */
        private final b f25633a;
        private final a b;

        public c(b bVar, a aVar) {
            this.f25633a = bVar;
            this.b = aVar;
        }

        @Override // android.media.MediaCodec.Callback
        public final void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
            a aVar = this.b;
            if (aVar != null) {
                aVar.onError(this.f25633a, codecException);
            }
        }

        @Override // android.media.MediaCodec.Callback
        public final void onInputBufferAvailable(MediaCodec mediaCodec, int i) {
            a aVar = this.b;
            if (aVar != null) {
                aVar.onInputBufferAvailable(this.f25633a, i);
            }
        }

        @Override // android.media.MediaCodec.Callback
        public final void onOutputBufferAvailable(MediaCodec mediaCodec, int i, MediaCodec.BufferInfo bufferInfo) {
            a aVar = this.b;
            if (aVar != null) {
                aVar.onOutputBufferAvailable(this.f25633a, i, bufferInfo);
            }
        }

        @Override // android.media.MediaCodec.Callback
        public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
            a aVar = this.b;
            if (aVar != null) {
                aVar.onOutputFormatChanged(this.f25633a, mediaFormat);
            }
        }
    }

    private b(String str, EnumC0853b enumC0853b) {
        this.h = str;
        this.i = enumC0853b;
    }

    public static b a(String str) {
        return new b(str, EnumC0853b.CreateByName);
    }

    private void b(Surface surface) {
        this.f25625a = com.tencent.thumbplayer.g.a.a().a(this, surface);
        this.e.a();
        this.e.b();
        this.e.a(this.f25625a);
    }

    private void m() {
        this.e.b(this.b);
        d.b(new Runnable() { // from class: com.tencent.thumbplayer.g.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.f25626c != null) {
                    b.this.f25626c.a(b.this.d);
                }
                if (b.this.d != null) {
                    b.this.d.onCreate(Boolean.valueOf(b.this.b));
                }
            }
        });
    }

    private void n() {
        this.e.c();
    }

    private void o() {
        this.e.d();
        d.b(new Runnable() { // from class: com.tencent.thumbplayer.g.b.2
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.d != null) {
                    b.this.d.onStarted(Boolean.valueOf(b.this.b), b.this.e.e());
                }
            }
        });
    }

    public final int a(long j) {
        c cVar = this.f25626c;
        if (cVar != null) {
            return cVar.a(j);
        }
        return -1000;
    }

    public final int a(MediaCodec.BufferInfo bufferInfo, long j) {
        c cVar = this.f25626c;
        if (cVar != null) {
            return cVar.a(bufferInfo, j);
        }
        return -1000;
    }

    public final EnumC0853b a() {
        return this.i;
    }

    public final ByteBuffer a(int i) {
        MediaCodec a2;
        c cVar = this.f25626c;
        if (cVar == null || (a2 = cVar.a()) == null) {
            return null;
        }
        return a2.getOutputBuffer(i);
    }

    public final void a(int i, int i2, int i3, long j, int i4) {
        c cVar = this.f25626c;
        if (cVar != null) {
            cVar.a(i, i2, i3, j, i4);
        }
    }

    public final void a(int i, int i2, MediaCodec.CryptoInfo cryptoInfo, long j, int i3) {
        MediaCodec a2;
        c cVar = this.f25626c;
        if (cVar == null || (a2 = cVar.a()) == null) {
            return;
        }
        a2.queueSecureInputBuffer(i, i2, cryptoInfo, j, i3);
    }

    public final void a(int i, boolean z) {
        c cVar = this.f25626c;
        if (cVar != null) {
            cVar.a(i, z);
        }
    }

    public final void a(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i) {
        if (!this.g) {
            this.g = true;
            b(surface);
            try {
                this.f25626c = com.tencent.thumbplayer.g.a.a().a(mediaFormat, surface, mediaCrypto, i, this);
            } catch (IOException e) {
                com.tencent.thumbplayer.g.h.b.b("TMediaCodec", "createCodec mediaFormat:".concat(String.valueOf(mediaFormat)), e);
            }
            m();
            return;
        }
        com.tencent.thumbplayer.g.h.b.d("TMediaCodec", "configure ignored, mediaFormat:" + mediaFormat + " surface:" + surface + " crypto:" + mediaCrypto + " flags:" + i + " stack:" + Log.getStackTraceString(new Throwable()));
    }

    public final void a(Bundle bundle) {
        MediaCodec a2;
        c cVar = this.f25626c;
        if (cVar == null || (a2 = cVar.a()) == null) {
            return;
        }
        a2.setParameters(bundle);
    }

    public final void a(Surface surface) {
        c cVar = this.f25626c;
        if (cVar != null) {
            cVar.a(surface);
        }
    }

    public final void a(com.tencent.thumbplayer.g.a.a aVar) {
        this.d = aVar;
    }

    public final void a(a aVar, Handler handler) {
        MediaCodec a2;
        if (Build.VERSION.SDK_INT < 23) {
            com.tencent.thumbplayer.g.h.b.d("TMediaCodec", "ignore method setCallback for API lower than 23");
            return;
        }
        c cVar = this.f25626c;
        if (cVar == null || (a2 = cVar.a()) == null) {
            return;
        }
        a2.setCallback(new c(this, aVar), handler);
    }

    public final void a(boolean z) {
        this.f = z;
    }

    public final Image b(int i) {
        c cVar = this.f25626c;
        if (cVar != null) {
            return cVar.a().getOutputImage(i);
        }
        return null;
    }

    public final boolean b() {
        return com.tencent.thumbplayer.g.h.c.a(this.h);
    }

    public final com.tencent.thumbplayer.g.a.a c() {
        return this.d;
    }

    public final ByteBuffer c(int i) {
        c cVar = this.f25626c;
        if (cVar != null) {
            return cVar.a().getInputBuffer(i);
        }
        return null;
    }

    public final void d(int i) {
        MediaCodec a2;
        c cVar = this.f25626c;
        if (cVar == null || (a2 = cVar.a()) == null) {
            return;
        }
        a2.setVideoScalingMode(i);
    }

    public final boolean d() {
        return this.f;
    }

    public final void e() {
        if (com.tencent.thumbplayer.g.h.b.a()) {
            com.tencent.thumbplayer.g.h.b.b("TMediaCodec", "start codecWrapper:" + this.f25626c);
        }
        n();
        c cVar = this.f25626c;
        if (cVar != null) {
            cVar.d();
        }
        o();
    }

    public final void f() {
        c cVar = this.f25626c;
        if (cVar != null) {
            cVar.f();
        }
    }

    public final void g() {
        c cVar = this.f25626c;
        if (cVar != null) {
            cVar.g();
        }
    }

    public final void h() {
        c cVar = this.f25626c;
        if (cVar != null) {
            cVar.e();
        }
    }

    public final MediaFormat i() {
        MediaCodec a2;
        c cVar = this.f25626c;
        if (cVar == null || (a2 = cVar.a()) == null) {
            return null;
        }
        return a2.getOutputFormat();
    }

    public final ByteBuffer[] j() {
        MediaCodec a2;
        c cVar = this.f25626c;
        if (cVar == null || (a2 = cVar.a()) == null) {
            return null;
        }
        return a2.getInputBuffers();
    }

    public final ByteBuffer[] k() {
        MediaCodec a2;
        c cVar = this.f25626c;
        if (cVar == null || (a2 = cVar.a()) == null) {
            return null;
        }
        return a2.getOutputBuffers();
    }

    public final String l() {
        return this.h;
    }
}
