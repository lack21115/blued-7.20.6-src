package com.qiniu.pili.droid.shortvideo.transcoder;

import android.graphics.BitmapFactory;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.view.Surface;
import com.baidu.mobads.sdk.internal.bw;
import com.huawei.openalliance.ad.constant.bc;
import com.qiniu.pili.droid.shortvideo.PLAudioEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLComposeItem;
import com.qiniu.pili.droid.shortvideo.PLDisplayMode;
import com.qiniu.pili.droid.shortvideo.PLVideoEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoSaveListener;
import com.qiniu.pili.droid.shortvideo.d.b;
import com.qiniu.pili.droid.shortvideo.encode.a;
import com.qiniu.pili.droid.shortvideo.encode.c;
import com.qiniu.pili.droid.shortvideo.f.e;
import com.qiniu.pili.droid.shortvideo.gl.a.d;
import com.qiniu.pili.droid.shortvideo.gl.a.f;
import com.qiniu.pili.droid.shortvideo.gl.c.g;
import com.qiniu.pili.droid.shortvideo.gl.c.h;
import com.qiniu.pili.droid.shortvideo.gl.c.l;
import com.qiniu.pili.droid.shortvideo.muxer.b;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/transcoder/a.class */
public class a implements Runnable {
    private static final PLVideoSaveListener E = new PLVideoSaveListener() { // from class: com.qiniu.pili.droid.shortvideo.transcoder.a.3
        @Override // com.qiniu.pili.droid.shortvideo.PLVideoSaveListener
        public void onProgressUpdate(float f) {
            e eVar = e.t;
            eVar.c("MultiImageComposer", "onProgressUpdate: " + f);
        }

        @Override // com.qiniu.pili.droid.shortvideo.PLVideoSaveListener
        public void onSaveVideoCanceled() {
            e.t.c("MultiImageComposer", "onSaveVideoCanceled");
        }

        @Override // com.qiniu.pili.droid.shortvideo.PLVideoSaveListener
        public void onSaveVideoFailed(int i) {
            e eVar = e.t;
            eVar.c("MultiImageComposer", "onSaveVideoFailed: " + i);
        }

        @Override // com.qiniu.pili.droid.shortvideo.PLVideoSaveListener
        public void onSaveVideoSuccess(String str) {
            e eVar = e.t;
            eVar.c("MultiImageComposer", "onSaveVideoSuccess: " + str);
        }
    };
    private d A;

    /* renamed from: a  reason: collision with root package name */
    private PLVideoSaveListener f14115a;
    private b b;
    private com.qiniu.pili.droid.shortvideo.encode.e e;
    private c f;
    private MediaFormat g;
    private MediaFormat h;
    private com.qiniu.pili.droid.shortvideo.d.b i;
    private volatile Surface j;
    private LinkedList<PLComposeItem> k;
    private String l;
    private int m;
    private int n;
    private long o;
    private long p;
    private long q;
    private String r;
    private boolean s;
    private volatile boolean t;
    private volatile boolean u;
    private f w;
    private g x;
    private l y;
    private int z;

    /* renamed from: c  reason: collision with root package name */
    private int f14116c = 0;
    private int d = 0;
    private volatile int v = -1;
    private PLDisplayMode B = PLDisplayMode.FIT;
    private a.InterfaceC0575a C = new a.InterfaceC0575a() { // from class: com.qiniu.pili.droid.shortvideo.transcoder.a.1
        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void a(MediaFormat mediaFormat) {
            e eVar = e.t;
            eVar.c("MultiImageComposer", "got video format:" + mediaFormat);
            a.this.h = mediaFormat;
            a.this.d();
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void a(Surface surface) {
            a.this.j = surface;
            new Thread(a.this).start();
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void a(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
            if (a.this.b == null) {
                e eVar = e.t;
                eVar.b("MultiImageComposer", "video frame not write  " + bufferInfo.presentationTimeUs);
                return;
            }
            e eVar2 = e.t;
            eVar2.b("MultiImageComposer", "write video " + bufferInfo.presentationTimeUs);
            a.this.b.a(byteBuffer, bufferInfo);
            a.this.f14115a.onProgressUpdate((((float) bufferInfo.presentationTimeUs) * 1.0f) / ((float) a.this.q));
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void a(boolean z) {
            e eVar = e.t;
            eVar.c("MultiImageComposer", "video encode started result: " + z);
            if (z) {
                return;
            }
            a.this.a(6);
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void b(boolean z) {
            e.t.c("MultiImageComposer", "video encode stopped");
            a.this.h = null;
            a.this.c();
        }
    };
    private a.InterfaceC0575a D = new a.InterfaceC0575a() { // from class: com.qiniu.pili.droid.shortvideo.transcoder.a.2
        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void a(MediaFormat mediaFormat) {
            e eVar = e.t;
            eVar.c("MultiImageComposer", "got audio format:" + mediaFormat);
            a.this.g = mediaFormat;
            a.this.d();
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void a(Surface surface) {
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void a(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
            if (a.this.b == null) {
                e eVar = e.t;
                eVar.b("MultiImageComposer", "audio frame not write  " + bufferInfo.presentationTimeUs);
                return;
            }
            e eVar2 = e.t;
            eVar2.b("MultiImageComposer", "write audio: " + bufferInfo.presentationTimeUs);
            a.this.b.b(byteBuffer, bufferInfo);
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void a(boolean z) {
            e eVar = e.t;
            eVar.c("MultiImageComposer", "audio encode started: " + z);
            if (!z) {
                a.this.a(7);
                return;
            }
            com.qiniu.pili.droid.shortvideo.f.f fVar = new com.qiniu.pili.droid.shortvideo.f.f(a.this.r, false, true);
            a.this.i = new com.qiniu.pili.droid.shortvideo.d.b(fVar.d(), fVar.f());
            a.this.i.a(new C0582a());
            a.this.i.a(a.this.s);
            a.this.i.a();
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void b(boolean z) {
            e.t.c("MultiImageComposer", "audio encode stopped.");
            a.this.g = null;
            a.this.c();
        }
    };

    /* renamed from: com.qiniu.pili.droid.shortvideo.transcoder.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/transcoder/a$a.class */
    class C0582a implements b.c {
        private C0582a() {
        }

        @Override // com.qiniu.pili.droid.shortvideo.d.b.c
        public void a(ByteBuffer byteBuffer, int i, long j, long j2, boolean z) {
            if (!z && j2 < a.this.q && !a.this.u) {
                a.this.f.a(byteBuffer, i, j2);
                return;
            }
            a.this.i.c();
            a.this.f.c();
        }
    }

    private g a(int i, int i2) {
        g gVar = new g();
        gVar.a(i, i2);
        gVar.b();
        return gVar;
    }

    private h a(long j, int i, int i2, int i3, int i4) {
        h hVar = new h(j);
        hVar.a(this.m, this.n);
        hVar.a(i, i2, i3, i4, this.B);
        return hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        e eVar = e.t;
        eVar.c("MultiImageComposer", "exceptionalStop + " + i);
        this.v = i;
        a();
        c();
        e eVar2 = e.t;
        eVar2.c("MultiImageComposer", "exceptionalStop - " + i);
    }

    private void a(PLComposeItem pLComposeItem, int i, int i2, int i3, int i4) {
        e.t.c("MultiImageComposer", "compose once +");
        int a2 = com.qiniu.pili.droid.shortvideo.c.a.b.a(pLComposeItem.getFilePath(), this.m, this.n);
        if (a2 == 0) {
            e.t.e("MultiImageComposer", "compose once error, the texture id is 0!");
            return;
        }
        h a3 = a(pLComposeItem.getTransitionTimeMs(), i, i2, i3, i4);
        long durationMs = pLComposeItem.getDurationMs();
        long j = 0;
        while (j <= durationMs * 1000 && !this.u) {
            boolean z = j == 0;
            long j2 = this.p * 1000;
            int a4 = this.y.a(a3.a(this.z, a2, j2, z));
            GLES20.glClear(16384);
            this.x.b(a4);
            this.w.a(j2);
            this.w.c();
            this.e.a(j2);
            long j3 = this.o;
            j += j3;
            this.p += j3;
        }
        com.qiniu.pili.droid.shortvideo.c.a.b.a(this.z);
        this.z = a2;
        a3.f();
        e.t.c("MultiImageComposer", "compose once -");
    }

    private boolean a(String str) {
        if (str == null) {
            e.t.e("MultiImageComposer", "dst video path is wrong!");
            return false;
        }
        File parentFile = new File(str).getParentFile();
        if (parentFile.exists() || parentFile.mkdir()) {
            return true;
        }
        e eVar = e.t;
        eVar.e("MultiImageComposer", "failed to mkdir: " + parentFile.getAbsolutePath());
        return false;
    }

    private boolean a(List<PLComposeItem> list, String str, PLVideoEncodeSetting pLVideoEncodeSetting, PLVideoSaveListener pLVideoSaveListener) {
        PLVideoSaveListener pLVideoSaveListener2 = pLVideoSaveListener;
        if (pLVideoSaveListener == null) {
            pLVideoSaveListener2 = E;
        }
        if (list == null || list.isEmpty() || str == null || pLVideoEncodeSetting == null) {
            e.t.e("MultiImageComposer", "compose: invalid params !");
            pLVideoSaveListener2.onSaveVideoFailed(10);
            return false;
        } else if (!a(str)) {
            e.t.e("MultiImageComposer", "compose: dstVideoPath is wrong!");
            return false;
        } else {
            for (PLComposeItem pLComposeItem : list) {
                if (pLComposeItem.getFilePath().equals(str)) {
                    e.t.e("MultiImageComposer", "compose failed, the dst video path must be different with src path !");
                    pLVideoSaveListener2.onSaveVideoFailed(10);
                    return false;
                }
            }
            return true;
        }
    }

    private l b(int i, int i2) {
        l lVar = new l();
        lVar.a(i, i2);
        lVar.b();
        return lVar;
    }

    private boolean b() {
        return this.v >= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        synchronized (this) {
            e.t.c("MultiImageComposer", "stopMuxer +");
            boolean z = true;
            int i = this.d + 1;
            this.d = i;
            if (this.f != null && i < 2) {
                e.t.c("MultiImageComposer", "not ready to stop muxer.");
                return;
            }
            if (this.b == null || !this.b.a()) {
                z = false;
            }
            e eVar = e.t;
            StringBuilder sb = new StringBuilder();
            sb.append("stop muxer ");
            sb.append(z ? bw.o : bc.b.S);
            eVar.c("MultiImageComposer", sb.toString());
            this.b = null;
            this.e = null;
            this.f = null;
            this.k = null;
            this.h = null;
            this.g = null;
            this.i = null;
            this.j = null;
            this.w = null;
            this.y = null;
            this.x = null;
            this.A = null;
            this.f14116c = 0;
            this.d = 0;
            this.q = 0L;
            this.p = 0L;
            this.z = 0;
            this.t = false;
            if (this.u) {
                this.u = false;
                new File(this.l).delete();
                if (b()) {
                    int i2 = this.v;
                    this.v = -1;
                    this.f14115a.onSaveVideoFailed(i2);
                } else {
                    this.f14115a.onSaveVideoCanceled();
                }
            } else if (z) {
                this.f14115a.onProgressUpdate(1.0f);
                this.f14115a.onSaveVideoSuccess(this.l);
            } else {
                new File(this.l).delete();
                this.f14115a.onSaveVideoFailed(3);
            }
            e.t.c("MultiImageComposer", "stopMuxer -");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        synchronized (this) {
            e.t.c("MultiImageComposer", "startMuxer +");
            if (this.u) {
                e.t.c("MultiImageComposer", "composer is already canceled");
                return;
            }
            int i = this.f14116c + 1;
            this.f14116c = i;
            if (this.f != null && i < 2) {
                e.t.c("MultiImageComposer", "not ready to start muxer.");
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return;
            }
            com.qiniu.pili.droid.shortvideo.muxer.b bVar = new com.qiniu.pili.droid.shortvideo.muxer.b();
            this.b = bVar;
            if (bVar.a(this.l, this.h, this.g, 0)) {
                e.t.c("MultiImageComposer", "start muxer success!");
                notify();
            } else {
                e.t.e("MultiImageComposer", "start muxer failed!");
                a();
            }
            e.t.c("MultiImageComposer", "startMuxer -");
        }
    }

    public void a() {
        synchronized (this) {
            if (this.t) {
                e.t.c("MultiImageComposer", "cancel compose");
                this.u = true;
            } else {
                e.t.d("MultiImageComposer", "cancel compose failed");
            }
        }
    }

    public boolean a(List<PLComposeItem> list, String str, boolean z, String str2, PLDisplayMode pLDisplayMode, PLVideoEncodeSetting pLVideoEncodeSetting, PLVideoSaveListener pLVideoSaveListener) {
        synchronized (this) {
            e.t.c("MultiImageComposer", "compose +");
            if (this.t) {
                e.t.e("MultiImageComposer", "compose already started");
                return false;
            } else if (a(list, str2, pLVideoEncodeSetting, pLVideoSaveListener)) {
                for (PLComposeItem pLComposeItem : list) {
                    this.q += pLComposeItem.getDurationMs() * 1000;
                }
                this.k = new LinkedList<>(list);
                this.l = str2;
                this.f14115a = pLVideoSaveListener == null ? E : pLVideoSaveListener;
                this.m = pLVideoEncodeSetting.getVideoEncodingWidth();
                this.n = pLVideoEncodeSetting.getVideoEncodingHeight();
                this.o = 1000000 / pLVideoEncodeSetting.getVideoEncodingFps();
                this.B = pLDisplayMode;
                this.r = str;
                this.s = z;
                com.qiniu.pili.droid.shortvideo.f.f fVar = new com.qiniu.pili.droid.shortvideo.f.f(str, false, true);
                if (fVar.f() != null) {
                    MediaFormat f = fVar.f();
                    PLAudioEncodeSetting pLAudioEncodeSetting = new PLAudioEncodeSetting();
                    pLAudioEncodeSetting.setChannels(fVar.n());
                    pLAudioEncodeSetting.setSampleRate(fVar.o());
                    c cVar = new c(pLAudioEncodeSetting);
                    this.f = cVar;
                    cVar.a(this.D);
                    this.f.a();
                    e.t.c("MultiImageComposer", "found audio format: " + f);
                }
                com.qiniu.pili.droid.shortvideo.encode.e eVar = new com.qiniu.pili.droid.shortvideo.encode.e(pLVideoEncodeSetting);
                this.e = eVar;
                eVar.a(this.C);
                this.e.a();
                this.t = true;
                e.t.c("MultiImageComposer", "compose -");
                return true;
            } else {
                return false;
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        e.t.c("MultiImageComposer", "run +");
        d dVar = new d(null, 1);
        this.A = dVar;
        int i = 0;
        f fVar = new f(dVar, this.j, false);
        this.w = fVar;
        fVar.b();
        this.x = a(this.m, this.n);
        this.y = b(this.m, this.n);
        Iterator<PLComposeItem> it = this.k.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            PLComposeItem next = it.next();
            if (this.u) {
                break;
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(next.getFilePath(), options);
            int i3 = i;
            if (i == 0) {
                i3 = options.outWidth;
            }
            int i4 = i2;
            if (i2 == 0) {
                i4 = options.outHeight;
            }
            int i5 = options.outWidth;
            i2 = options.outHeight;
            a(next, i3, i4, i5, i2);
            i = i5;
        }
        this.w.d();
        this.y.f();
        this.x.f();
        this.A.a();
        this.e.c();
        e.t.c("MultiImageComposer", "run -");
    }
}
