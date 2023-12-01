package com.qiniu.pili.droid.shortvideo.d;

import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Handler;
import android.view.Surface;
import com.qiniu.pili.droid.shortvideo.f.k;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/d/b.class */
public class b extends k {

    /* renamed from: a  reason: collision with root package name */
    protected MediaExtractor f13947a;
    protected MediaCodec b;

    /* renamed from: c  reason: collision with root package name */
    protected a f13948c;
    protected d d;
    protected boolean e;
    private MediaFormat f;
    private Surface g;
    private ByteBuffer[] h;
    private ByteBuffer[] i;
    private c j;
    private e k;
    private InterfaceC0574b l;
    private int m;
    private long n;
    private long o;
    private boolean p;
    private List<Long> q;
    private List<Long> r;
    private List<Integer> s;
    private List<Integer> t;
    private int u;
    private int v;
    private long w = -1;
    private long x = -1;
    private long y = -1;
    private int z = 0;
    private String A = "unknown";
    private String B = "unknown";

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/d/b$a.class */
    public interface a {
        void a(int i);
    }

    /* renamed from: com.qiniu.pili.droid.shortvideo.d.b$b  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/d/b$b.class */
    public interface InterfaceC0574b {
        void a();
    }

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/d/b$c.class */
    public interface c {
        void a(ByteBuffer byteBuffer, int i, long j, long j2, boolean z);
    }

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/d/b$d.class */
    public interface d {
        void a(MediaFormat mediaFormat);
    }

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/d/b$e.class */
    public interface e {
        void a(int i);
    }

    public b(MediaExtractor mediaExtractor, MediaFormat mediaFormat) {
        this.f13947a = mediaExtractor;
        this.f = mediaFormat;
    }

    private void g() {
        int i;
        this.q = new LinkedList();
        this.r = new LinkedList();
        this.s = new LinkedList();
        this.t = new LinkedList();
        b();
        int i2 = 0;
        do {
            long sampleTime = this.f13947a.getSampleTime();
            i = i2;
            if (sampleTime >= this.n) {
                i = i2;
                if (sampleTime <= this.o) {
                    this.q.add(Long.valueOf(sampleTime));
                    int i3 = i2;
                    if ((this.f13947a.getSampleFlags() & 1) > 0) {
                        this.r.add(Long.valueOf(sampleTime));
                        if (this.r.size() > 1) {
                            this.s.add(Integer.valueOf(i2));
                            com.qiniu.pili.droid.shortvideo.f.e.u.c(j(), "the gop frame num is : " + i2);
                        }
                        i3 = 0;
                    }
                    i = i3 + 1;
                }
            }
            i2 = i;
        } while (this.f13947a.advance());
        this.s.add(Integer.valueOf(i));
        com.qiniu.pili.droid.shortvideo.f.e.u.c(j(), "the gop frame num is : " + i);
        Collections.sort(this.q);
        Collections.reverse(this.s);
        Collections.reverse(this.r);
    }

    private void h() {
        try {
            int dequeueInputBuffer = this.b.dequeueInputBuffer(10000L);
            if (dequeueInputBuffer == -1) {
                com.qiniu.pili.droid.shortvideo.f.e.u.b(j(), "dequeueInputBuffer INFO_TRY_AGAIN_LATER");
            } else if (this.u >= this.r.size()) {
                this.b.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
            } else {
                if (this.v == 0) {
                    this.f13947a.seekTo(this.r.get(this.u).longValue(), 2);
                    this.t.add(this.s.get(this.u));
                } else {
                    this.t.add(0);
                }
                this.b.queueInputBuffer(dequeueInputBuffer, 0, this.f13947a.readSampleData(this.h[dequeueInputBuffer], 0), this.q.remove(0).longValue(), 0);
                int i = this.v + 1;
                this.v = i;
                if (i < this.s.get(this.u).intValue()) {
                    this.f13947a.advance();
                    return;
                }
                this.v = 0;
                this.u++;
            }
        } catch (IllegalStateException e2) {
            com.qiniu.pili.droid.shortvideo.f.e.u.e(j(), e2.toString());
        }
    }

    private void i() {
        try {
            int dequeueInputBuffer = this.b.dequeueInputBuffer(10000L);
            if (dequeueInputBuffer == -1) {
                com.qiniu.pili.droid.shortvideo.f.e.u.b(j(), "dequeueInputBuffer INFO_TRY_AGAIN_LATER");
                return;
            }
            int readSampleData = this.f13947a.readSampleData(this.h[dequeueInputBuffer], 0);
            if (readSampleData > 0) {
                this.b.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, this.f13947a.getSampleTime(), 0);
                this.f13947a.advance();
                return;
            }
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.u;
            String j = j();
            eVar.c(j, "read size <= 0 need loop: " + this.e);
            if (!this.e) {
                this.b.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                return;
            }
            b();
            this.b.flush();
        } catch (IllegalStateException e2) {
            com.qiniu.pili.droid.shortvideo.f.e.u.e(j(), e2.toString());
            if (f()) {
                c();
            }
        }
    }

    private boolean k() {
        try {
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            if (m()) {
                return true;
            }
            int dequeueOutputBuffer = this.b.dequeueOutputBuffer(bufferInfo, 10000L);
            if (dequeueOutputBuffer == -1) {
                com.qiniu.pili.droid.shortvideo.f.e.u.b(j(), "dequeueOutputBuffer INFO_TRY_AGAIN_LATER");
                return true;
            } else if (dequeueOutputBuffer == -3) {
                this.i = this.b.getOutputBuffers();
                com.qiniu.pili.droid.shortvideo.f.e.u.c(j(), "processOutputFrame: INFO_OUTPUT_BUFFERS_CHANGED !");
                return true;
            } else if (dequeueOutputBuffer != -2) {
                if (dequeueOutputBuffer < 0) {
                    throw new RuntimeException("unexpected result from decoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
                } else if ((bufferInfo.flags & 2) != 0) {
                    com.qiniu.pili.droid.shortvideo.f.e.i.c(j(), "codec config frame ignore.");
                    return true;
                } else {
                    a(dequeueOutputBuffer, bufferInfo, (ByteBuffer) null);
                    return true;
                }
            } else {
                MediaFormat outputFormat = this.b.getOutputFormat();
                com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.u;
                String j = j();
                eVar.c(j, "decoder output format changed: " + outputFormat);
                if (this.d != null) {
                    this.d.a(outputFormat);
                    return true;
                }
                return true;
            }
        } catch (IllegalStateException e2) {
            com.qiniu.pili.droid.shortvideo.f.e.u.e(j(), e2.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0199 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(int r13, android.media.MediaCodec.BufferInfo r14, java.nio.ByteBuffer r15) {
        /*
            Method dump skipped, instructions count: 813
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiniu.pili.droid.shortvideo.d.b.a(int, android.media.MediaCodec$BufferInfo, java.nio.ByteBuffer):void");
    }

    public void a(Surface surface) {
        this.g = surface;
    }

    public void a(a aVar) {
        this.f13948c = aVar;
    }

    public void a(InterfaceC0574b interfaceC0574b) {
        this.l = interfaceC0574b;
    }

    public void a(c cVar) {
        this.j = cVar;
    }

    public void a(d dVar) {
        this.d = dVar;
    }

    public void a(e eVar) {
        this.k = eVar;
    }

    public void a(String str) {
        this.A = str;
    }

    public void a(boolean z) {
        this.e = z;
    }

    @Override // com.qiniu.pili.droid.shortvideo.f.k
    public boolean a() {
        return a(0L, -1L);
    }

    public boolean a(long j) {
        this.n = j;
        this.o = -1L;
        return super.a();
    }

    public boolean a(long j, long j2) {
        this.n = j;
        this.o = j2;
        return super.a();
    }

    public boolean a(long j, long j2, boolean z) {
        this.n = j;
        this.o = j2;
        this.p = z;
        if (z) {
            g();
        }
        return super.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(MediaCodec.Callback callback, Handler handler) {
        int i;
        com.qiniu.pili.droid.shortvideo.f.e.u.c(j(), "startDecoder +");
        MediaFormat mediaFormat = this.f;
        if (mediaFormat == null) {
            com.qiniu.pili.droid.shortvideo.f.e.u.e(j(), "startDecoder failed: NULL format");
            return false;
        }
        this.B = mediaFormat.getString(MediaFormat.KEY_MIME);
        boolean z = (callback == null || handler == null) ? false : true;
        try {
            MediaCodec createDecoderByType = MediaCodec.createDecoderByType(this.B);
            this.b = createDecoderByType;
            if (z) {
                createDecoderByType.setCallback(callback, handler);
            }
            try {
                this.b.configure(this.f, this.g, null, 0);
                this.b.start();
                if (!z) {
                    this.h = this.b.getInputBuffers();
                    if (this.g == null) {
                        this.i = this.b.getOutputBuffers();
                    }
                }
                com.qiniu.pili.droid.shortvideo.f.e.u.c(j(), "startDecoder success !");
                return true;
            } catch (RuntimeException e2) {
                com.qiniu.pili.droid.shortvideo.f.e.u.d(j(), "startDecoder failed: error message: " + e2.getMessage());
                if (e2.getMessage() == null || !e2.getMessage().contains("0xfffffc03")) {
                    com.qiniu.pili.droid.shortvideo.f.e.u.d(j(), "configure decoder failed! " + e2.getMessage());
                    i = 17;
                } else {
                    com.qiniu.pili.droid.shortvideo.f.e.u.d(j(), "not support multiple media codec!" + e2.getMessage());
                    i = 16;
                }
                if (this.f13948c != null) {
                    this.f13948c.a(i);
                    return false;
                }
                return false;
            }
        } catch (Exception e3) {
            com.qiniu.pili.droid.shortvideo.f.e.u.e(j(), "startDecoder failed: " + e3.getMessage());
            a aVar = this.f13948c;
            if (aVar != null) {
                aVar.a(17);
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        this.f13947a.seekTo(this.n, 0);
    }

    protected boolean d() {
        return a((MediaCodec.Callback) null, (Handler) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.u;
        String j = j();
        eVar.c(j, "stopDecoder + " + this.A);
        try {
            if (this.b != null) {
                this.b.stop();
                this.b.release();
                this.b = null;
            }
        } catch (Exception e2) {
            com.qiniu.pili.droid.shortvideo.f.e eVar2 = com.qiniu.pili.droid.shortvideo.f.e.u;
            String j2 = j();
            eVar2.c(j2, "stop decoder failed : " + e2.getMessage());
        }
        try {
            if (this.f13947a != null) {
                this.f13947a.release();
                this.f13947a = null;
            }
        } catch (Exception e3) {
            com.qiniu.pili.droid.shortvideo.f.e eVar3 = com.qiniu.pili.droid.shortvideo.f.e.u;
            String j3 = j();
            eVar3.c(j3, "release extractor failed : " + e3.getMessage());
        }
        InterfaceC0574b interfaceC0574b = this.l;
        if (interfaceC0574b != null) {
            interfaceC0574b.a();
        }
        com.qiniu.pili.droid.shortvideo.f.e eVar4 = com.qiniu.pili.droid.shortvideo.f.e.u;
        String j4 = j();
        eVar4.c(j4, "stopDecoder - " + this.A);
    }

    protected boolean f() {
        return this.B.contains("audio");
    }

    @Override // com.qiniu.pili.droid.shortvideo.f.k
    public String j() {
        return "RawFrameExtractor";
    }

    @Override // java.lang.Runnable
    public void run() {
        b();
        boolean d2 = d();
        while (!m() && d2) {
            if (this.p) {
                h();
            } else {
                i();
            }
            k();
        }
        e();
    }
}
