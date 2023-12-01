package com.qiniu.pili.droid.shortvideo.process.a;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.view.Surface;
import com.baidu.mobads.sdk.internal.bw;
import com.huawei.openalliance.ad.constant.bc;
import com.qiniu.pili.droid.shortvideo.PLAudioEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoRange;
import com.qiniu.pili.droid.shortvideo.PLVideoSaveListener;
import com.qiniu.pili.droid.shortvideo.d.b;
import com.qiniu.pili.droid.shortvideo.encode.a;
import com.qiniu.pili.droid.shortvideo.f.g;
import com.qiniu.pili.droid.shortvideo.f.h;
import com.qiniu.pili.droid.shortvideo.gl.b.a;
import com.qiniu.pili.droid.shortvideo.transcoder.audio.AudioTransformer;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/process/a/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f27748a = h.a().c();
    private long A;
    private long B;
    private AudioTransformer D;
    private ByteBuffer E;
    private LinkedList<PLVideoRange> G;
    private LinkedList<PLVideoRange> H;
    private LinkedList<String> d;
    private LinkedList<String> e;
    private String f;
    private PLVideoSaveListener g;
    private PLVideoEncodeSetting h;
    private com.qiniu.pili.droid.shortvideo.encode.e i;
    private com.qiniu.pili.droid.shortvideo.gl.b.a j;
    private com.qiniu.pili.droid.shortvideo.d.b k;
    private com.qiniu.pili.droid.shortvideo.encode.c l;
    private com.qiniu.pili.droid.shortvideo.d.b m;
    private com.qiniu.pili.droid.shortvideo.muxer.b n;
    private MediaFormat q;
    private MediaFormat r;
    private volatile Surface s;
    private int t;
    private int u;
    private long v;
    private int w;
    private volatile boolean x;
    private volatile boolean y;
    private boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    private final Object f27749c = new Object();
    private int o = 0;
    private int p = 0;
    private volatile int z = -1;
    private long C = 0;
    private long F = 0;
    private final PLVideoSaveListener I = new PLVideoSaveListener() { // from class: com.qiniu.pili.droid.shortvideo.process.a.b.3
        @Override // com.qiniu.pili.droid.shortvideo.PLVideoSaveListener
        public void onProgressUpdate(float f) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.t;
            eVar.c("MultiVideoComposer", "onProgressUpdate: " + f);
        }

        @Override // com.qiniu.pili.droid.shortvideo.PLVideoSaveListener
        public void onSaveVideoCanceled() {
            com.qiniu.pili.droid.shortvideo.f.e.t.c("MultiVideoComposer", "onSaveVideoCanceled");
        }

        @Override // com.qiniu.pili.droid.shortvideo.PLVideoSaveListener
        public void onSaveVideoFailed(int i) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.t;
            eVar.c("MultiVideoComposer", "onSaveVideoFailed: " + i);
        }

        @Override // com.qiniu.pili.droid.shortvideo.PLVideoSaveListener
        public void onSaveVideoSuccess(String str) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.t;
            eVar.c("MultiVideoComposer", "onSaveVideoSuccess: " + str);
        }
    };
    private a.InterfaceC0745a J = new a.InterfaceC0745a() { // from class: com.qiniu.pili.droid.shortvideo.process.a.b.4
        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0745a
        public void a(MediaFormat mediaFormat) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.t;
            eVar.c("MultiVideoComposer", "video encode output format retrieved: " + mediaFormat);
            b.this.q = mediaFormat;
            b.this.b();
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0745a
        public void a(Surface surface) {
            com.qiniu.pili.droid.shortvideo.f.e.t.c("MultiVideoComposer", "encode surface created");
            b.this.s = surface;
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0745a
        public void a(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
            com.qiniu.pili.droid.shortvideo.f.e.t.b("MultiVideoComposer", "muxer write video: " + bufferInfo.presentationTimeUs);
            if (b.this.n != null) {
                b.this.n.a(byteBuffer, bufferInfo);
                float f = 1.0f;
                float f2 = (((float) bufferInfo.presentationTimeUs) * 1.0f) / ((float) b.this.C);
                PLVideoSaveListener pLVideoSaveListener = b.this.g;
                if (f2 <= 1.0f) {
                    f = f2;
                }
                pLVideoSaveListener.onProgressUpdate(f);
            }
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0745a
        public void a(boolean z) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.t;
            eVar.c("MultiVideoComposer", "video encode started result: " + z);
            if (!z) {
                b.this.a(6);
                return;
            }
            b bVar = b.this;
            bVar.a((String) bVar.d.poll());
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0745a
        public void b(boolean z) {
            com.qiniu.pili.droid.shortvideo.f.e.t.c("MultiVideoComposer", "video encode stopped");
            b.this.c();
        }
    };
    private a.InterfaceC0745a K = new a.InterfaceC0745a() { // from class: com.qiniu.pili.droid.shortvideo.process.a.b.5
        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0745a
        public void a(MediaFormat mediaFormat) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.t;
            eVar.c("MultiVideoComposer", "audio encode output format retrieved: " + mediaFormat);
            b.this.r = mediaFormat;
            b.this.b();
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0745a
        public void a(Surface surface) {
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0745a
        public void a(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.t;
            eVar.b("MultiVideoComposer", "muxer write audio: " + bufferInfo.presentationTimeUs);
            if (b.this.n != null) {
                b.this.n.b(byteBuffer, bufferInfo);
            }
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0745a
        public void a(boolean z) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.t;
            eVar.c("MultiVideoComposer", "audio encode started result: " + z);
            if (!z) {
                b.this.a(7);
                return;
            }
            b bVar = b.this;
            bVar.b((String) bVar.e.poll());
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0745a
        public void b(boolean z) {
            com.qiniu.pili.droid.shortvideo.f.e.t.c("MultiVideoComposer", "audio encode stopped");
            b.this.c();
        }
    };
    private a.b L = new a.b() { // from class: com.qiniu.pili.droid.shortvideo.process.a.b.6
        @Override // com.qiniu.pili.droid.shortvideo.gl.b.a.b
        public int a(int i, int i2, int i3, long j, float[] fArr) {
            b.this.e();
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.t;
            eVar.b("MultiVideoComposer", "offscreen surface onDrawFrame: " + j);
            b.this.i.a(j);
            return i;
        }

        @Override // com.qiniu.pili.droid.shortvideo.gl.b.a.b
        public void a() {
        }

        @Override // com.qiniu.pili.droid.shortvideo.gl.b.a.b
        public void a(int i, int i2) {
        }

        @Override // com.qiniu.pili.droid.shortvideo.gl.b.a.b
        public void a(Object obj, Surface surface) {
            b.this.k.a(new C0750b());
            b.this.k.a(surface);
            b bVar = b.this;
            if (!bVar.a(bVar.G)) {
                b.this.k.a();
                return;
            }
            PLVideoRange pLVideoRange = (PLVideoRange) b.this.G.getFirst();
            b.this.k.a(pLVideoRange.getStartTime() * 1000, pLVideoRange.getEndTime() * 1000);
        }

        @Override // com.qiniu.pili.droid.shortvideo.gl.b.a.b
        public void b() {
            b.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/process/a/b$a.class */
    public class a implements b.c {
        private long b;

        private a() {
        }

        @Override // com.qiniu.pili.droid.shortvideo.d.b.c
        public void a(ByteBuffer byteBuffer, int i, long j, long j2, boolean z) {
            if (b.this.D == null) {
                com.qiniu.pili.droid.shortvideo.f.e.t.d("mResampler has not been init !");
            } else if (z) {
                b.this.B += this.b + b.this.v;
                b.this.D.destroy(b.this.F);
                if (b.this.e.isEmpty()) {
                    com.qiniu.pili.droid.shortvideo.f.e.t.c("MultiVideoComposer", "audio tracks concate done, stop audio encoder now.");
                    b.this.l.c();
                    return;
                }
                b bVar = b.this;
                bVar.b((String) bVar.e.poll());
            } else {
                if (b.this.E == null) {
                    b.this.E = ByteBuffer.allocateDirect(byteBuffer.capacity() * 4);
                    com.qiniu.pili.droid.shortvideo.f.e.t.c("MultiVideoComposer", "init mResampledFramesBuffer with size: " + b.this.E.capacity());
                }
                b.this.E.position(b.this.E.position() + b.this.D.resample(b.this.F, byteBuffer, byteBuffer.position(), i, b.this.E, b.this.E.position(), 0));
                while (b.this.E.position() >= b.this.w) {
                    int position = b.this.E.position();
                    int i2 = b.this.w;
                    b.this.E.flip();
                    b.this.l.a(b.this.E, b.this.w, b.this.B + this.b);
                    b.this.E.clear();
                    b.this.E.put(b.this.E.array(), b.this.E.arrayOffset() + b.this.w, position - i2);
                    this.b += b.this.v;
                }
                if (b.this.x) {
                    com.qiniu.pili.droid.shortvideo.f.e.t.c("MultiVideoComposer", "cancel marked, stop audio things now.");
                    b.this.m.c();
                    b.this.D.destroy(b.this.F);
                    b.this.l.c();
                }
            }
        }
    }

    /* renamed from: com.qiniu.pili.droid.shortvideo.process.a.b$b  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/process/a/b$b.class */
    class C0750b implements b.c {
        private long b;

        /* renamed from: c  reason: collision with root package name */
        private long f27758c;

        private C0750b() {
        }

        @Override // com.qiniu.pili.droid.shortvideo.d.b.c
        public void a(ByteBuffer byteBuffer, int i, long j, long j2, boolean z) {
            if (z) {
                b.this.A += (this.b - this.f27758c) + (1000000 / b.this.h.getVideoEncodingFps());
                this.f27758c = 0L;
                b bVar = b.this;
                if (bVar.a(bVar.G)) {
                    b.this.G.poll();
                }
                if (b.this.d.isEmpty()) {
                    com.qiniu.pili.droid.shortvideo.f.e.t.c("MultiVideoComposer", "video tracks concate done, stop video encoder now.");
                    b.this.i.c();
                    return;
                }
                b bVar2 = b.this;
                bVar2.a((String) bVar2.d.poll());
                return;
            }
            this.b = j;
            b bVar3 = b.this;
            if (bVar3.a(bVar3.G) && this.f27758c == 0) {
                this.f27758c = j;
            }
            synchronized (b.this.f27749c) {
                while (!b.this.b) {
                    try {
                        b.this.f27749c.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                b.this.b = false;
            }
            if (b.this.x) {
                com.qiniu.pili.droid.shortvideo.f.e.t.c("MultiVideoComposer", "cancel marked, stop video things now.");
                b.this.k.c();
                b.this.j.b();
                b.this.i.c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.t;
        eVar.c("MultiVideoComposer", "exceptionalStop + " + i);
        this.z = i;
        a();
        c();
        com.qiniu.pili.droid.shortvideo.f.e eVar2 = com.qiniu.pili.droid.shortvideo.f.e.t;
        eVar2.c("MultiVideoComposer", "exceptionalStop - " + i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01c9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 494
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiniu.pili.droid.shortvideo.process.a.b.a(java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(LinkedList<PLVideoRange> linkedList) {
        if (linkedList == null || linkedList.isEmpty()) {
            return false;
        }
        return linkedList.getFirst().isValidRange();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        synchronized (this) {
            com.qiniu.pili.droid.shortvideo.f.e.t.c("MultiVideoComposer", "startMuxer +");
            int i = this.o + 1;
            this.o = i;
            if (this.l != null && i < 2) {
                com.qiniu.pili.droid.shortvideo.f.e.t.c("MultiVideoComposer", "not ready to start muxer.");
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return;
            }
            com.qiniu.pili.droid.shortvideo.muxer.b bVar = new com.qiniu.pili.droid.shortvideo.muxer.b();
            this.n = bVar;
            if (bVar.a(this.f, this.q, this.r, 0)) {
                com.qiniu.pili.droid.shortvideo.f.e.t.c("MultiVideoComposer", "start muxer success!");
                notify();
            } else {
                com.qiniu.pili.droid.shortvideo.f.e.t.e("MultiVideoComposer", "start muxer failed!");
                a();
            }
            com.qiniu.pili.droid.shortvideo.f.e.t.c("MultiVideoComposer", "startMuxer -");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.t;
        eVar.c("MultiVideoComposer", "compose audio + " + str);
        final com.qiniu.pili.droid.shortvideo.f.f fVar = new com.qiniu.pili.droid.shortvideo.f.f(str, false, true);
        if (fVar.f() != null) {
            com.qiniu.pili.droid.shortvideo.d.b bVar = new com.qiniu.pili.droid.shortvideo.d.b(fVar.d(), fVar.f());
            this.m = bVar;
            bVar.a(new a());
            this.m.a(new b.d() { // from class: com.qiniu.pili.droid.shortvideo.process.a.b.1
                @Override // com.qiniu.pili.droid.shortvideo.d.b.d
                public void a(MediaFormat mediaFormat) {
                    com.qiniu.pili.droid.shortvideo.f.e eVar2 = com.qiniu.pili.droid.shortvideo.f.e.t;
                    eVar2.c("MultiVideoComposer", "got audio decoder format: " + mediaFormat);
                    b.this.D = new AudioTransformer();
                    b bVar2 = b.this;
                    bVar2.F = bVar2.D.init(mediaFormat.getInteger(MediaFormat.KEY_SAMPLE_RATE), mediaFormat.getInteger(MediaFormat.KEY_CHANNEL_COUNT), 16, b.this.t, b.this.u, 16);
                }
            });
            if (a(this.H)) {
                PLVideoRange poll = this.H.poll();
                this.m.a(poll.getStartTime() * 1000, poll.getEndTime() * 1000);
            } else {
                this.m.a();
            }
        } else {
            new Thread(new Runnable() { // from class: com.qiniu.pili.droid.shortvideo.process.a.b.2
                @Override // java.lang.Runnable
                public void run() {
                    long j;
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(b.this.w);
                    long g = fVar.g();
                    long j2 = 0;
                    while (true) {
                        j = j2;
                        if (j >= g * 1000) {
                            break;
                        }
                        b.this.l.a(allocateDirect, allocateDirect.remaining(), b.this.B + j);
                        allocateDirect.clear();
                        j2 = j + b.this.v;
                    }
                    b.this.B += j;
                    if (b.this.e.isEmpty()) {
                        b.this.l.c();
                        return;
                    }
                    b bVar2 = b.this;
                    bVar2.b((String) bVar2.e.poll());
                }
            }).start();
        }
        com.qiniu.pili.droid.shortvideo.f.e.t.c("MultiVideoComposer", "compose audio -");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        synchronized (this) {
            com.qiniu.pili.droid.shortvideo.f.e.t.c("MultiVideoComposer", "stopMuxer +");
            boolean z = true;
            int i = this.p + 1;
            this.p = i;
            if (this.l != null && i < 2) {
                com.qiniu.pili.droid.shortvideo.f.e.t.c("MultiVideoComposer", "not ready to stop muxer.");
                return;
            }
            if (this.n == null || !this.n.a()) {
                z = false;
            }
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.t;
            StringBuilder sb = new StringBuilder();
            sb.append("stop muxer ");
            sb.append(z ? bw.o : bc.b.S);
            eVar.c("MultiVideoComposer", sb.toString());
            this.n = null;
            this.i = null;
            this.l = null;
            this.d = null;
            this.e = null;
            this.G = null;
            this.H = null;
            this.q = null;
            this.r = null;
            this.k = null;
            this.m = null;
            this.s = null;
            this.j = null;
            this.D = null;
            this.E = null;
            this.F = 0L;
            this.o = 0;
            this.p = 0;
            this.A = 0L;
            this.B = 0L;
            this.C = 0L;
            this.y = false;
            if (this.x) {
                this.x = false;
                new File(this.f).delete();
                if (d()) {
                    int i2 = this.z;
                    this.z = -1;
                    this.g.onSaveVideoFailed(i2);
                } else {
                    this.g.onSaveVideoCanceled();
                }
            } else if (z) {
                this.g.onProgressUpdate(1.0f);
                this.g.onSaveVideoSuccess(this.f);
            } else {
                new File(this.f).delete();
                this.g.onSaveVideoFailed(3);
            }
            com.qiniu.pili.droid.shortvideo.f.e.t.c("MultiVideoComposer", "stopMuxer -");
        }
    }

    private boolean c(String str) {
        if (str == null) {
            com.qiniu.pili.droid.shortvideo.f.e.t.e("MultiVideoComposer", "dest video path is wrong!");
            return false;
        }
        File parentFile = new File(str).getParentFile();
        if (parentFile.exists() || parentFile.mkdir()) {
            return true;
        }
        com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.t;
        eVar.e("MultiVideoComposer", "failed to mkdir: " + parentFile.getAbsolutePath());
        return false;
    }

    private boolean c(List<String> list, String str, PLVideoEncodeSetting pLVideoEncodeSetting, PLVideoSaveListener pLVideoSaveListener) {
        PLVideoSaveListener pLVideoSaveListener2 = pLVideoSaveListener;
        if (pLVideoSaveListener == null) {
            pLVideoSaveListener2 = this.I;
        }
        if (list == null || list.isEmpty() || str == null || pLVideoEncodeSetting == null) {
            com.qiniu.pili.droid.shortvideo.f.e.t.e("MultiVideoComposer", "compose: invalid params !");
            pLVideoSaveListener2.onSaveVideoFailed(10);
            return false;
        } else if (!c(str)) {
            com.qiniu.pili.droid.shortvideo.f.e.t.e("MultiVideoComposer", "compose: destVideoPath is wrong!");
            return false;
        } else if (list.size() == 1) {
            com.qiniu.pili.droid.shortvideo.f.e.t.d("MultiVideoComposer", "compose: only one src videos, ignore !");
            pLVideoSaveListener2.onSaveVideoSuccess(list.get(0));
            return false;
        } else {
            for (String str2 : list) {
                if (str2.equals(str)) {
                    com.qiniu.pili.droid.shortvideo.f.e.t.e("MultiVideoComposer", "compose failed, the dest video path must be different with src videos !");
                    pLVideoSaveListener2.onSaveVideoFailed(10);
                    return false;
                }
            }
            return true;
        }
    }

    private boolean d() {
        return this.z >= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        synchronized (this.f27749c) {
            this.b = true;
            this.f27749c.notify();
        }
    }

    public void a() {
        synchronized (this) {
            if (this.y) {
                this.x = true;
                com.qiniu.pili.droid.shortvideo.f.e.t.c("MultiVideoComposer", "cancel compose");
            } else {
                com.qiniu.pili.droid.shortvideo.f.e.t.d("MultiVideoComposer", "cancel compose failed");
            }
        }
    }

    public boolean a(List<String> list, String str, PLVideoEncodeSetting pLVideoEncodeSetting, PLVideoSaveListener pLVideoSaveListener) {
        MediaFormat mediaFormat;
        synchronized (this) {
            com.qiniu.pili.droid.shortvideo.f.e.t.c("MultiVideoComposer", "compose +");
            if (this.y) {
                com.qiniu.pili.droid.shortvideo.f.e.t.e("MultiVideoComposer", "compose already started");
                return false;
            } else if (c(list, str, pLVideoEncodeSetting, pLVideoSaveListener)) {
                if (this.G == null || this.G.isEmpty()) {
                    for (String str2 : list) {
                        this.C += g.a((Object) str2);
                    }
                } else {
                    Iterator<PLVideoRange> it = this.G.iterator();
                    while (it.hasNext()) {
                        PLVideoRange next = it.next();
                        this.C += next.isValidRange() ? next.getRangeTime() : g.a((Object) next.getVideoPath());
                    }
                }
                this.C *= 1000;
                this.d = new LinkedList<>(list);
                this.e = new LinkedList<>(list);
                this.f = str;
                PLVideoSaveListener pLVideoSaveListener2 = pLVideoSaveListener;
                if (pLVideoSaveListener == null) {
                    pLVideoSaveListener2 = this.I;
                }
                this.g = pLVideoSaveListener2;
                this.h = pLVideoEncodeSetting;
                int i = 0;
                while (true) {
                    int i2 = i;
                    mediaFormat = null;
                    if (i2 >= list.size()) {
                        break;
                    }
                    com.qiniu.pili.droid.shortvideo.f.f fVar = new com.qiniu.pili.droid.shortvideo.f.f(list.get(i2), false, true);
                    if (fVar.f() != null) {
                        mediaFormat = fVar.f();
                        this.t = fVar.o();
                        this.u = fVar.n();
                        com.qiniu.pili.droid.shortvideo.f.e.t.c("MultiVideoComposer", "found output audio format: " + mediaFormat + " in file: " + list.get(i2));
                        break;
                    }
                    i = i2 + 1;
                }
                com.qiniu.pili.droid.shortvideo.encode.e eVar = new com.qiniu.pili.droid.shortvideo.encode.e(pLVideoEncodeSetting);
                this.i = eVar;
                eVar.a(this.J);
                this.i.a();
                if (mediaFormat != null && f27748a) {
                    this.w = 2048 * this.u;
                    this.v = (long) ((1024 * 1000000.0d) / this.t);
                    com.qiniu.pili.droid.shortvideo.f.e.t.c("MultiVideoComposer", "output audio frame size in bytes: " + this.w + " interval in Us: " + this.v);
                    PLAudioEncodeSetting pLAudioEncodeSetting = new PLAudioEncodeSetting();
                    pLAudioEncodeSetting.setChannels(this.u);
                    pLAudioEncodeSetting.setSampleRate(this.t);
                    com.qiniu.pili.droid.shortvideo.encode.c cVar = new com.qiniu.pili.droid.shortvideo.encode.c(pLAudioEncodeSetting);
                    this.l = cVar;
                    cVar.a(this.K);
                    this.l.a();
                }
                this.y = true;
                com.qiniu.pili.droid.shortvideo.f.e.t.c("MultiVideoComposer", "compose -");
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean b(List<PLVideoRange> list, String str, PLVideoEncodeSetting pLVideoEncodeSetting, PLVideoSaveListener pLVideoSaveListener) {
        boolean a2;
        synchronized (this) {
            this.G = new LinkedList<>(list);
            this.H = new LinkedList<>(list);
            LinkedList linkedList = new LinkedList();
            for (PLVideoRange pLVideoRange : list) {
                linkedList.add(pLVideoRange.getVideoPath());
            }
            a2 = a(linkedList, str, pLVideoEncodeSetting, pLVideoSaveListener);
        }
        return a2;
    }
}
