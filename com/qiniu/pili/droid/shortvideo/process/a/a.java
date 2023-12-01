package com.qiniu.pili.droid.shortvideo.process.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.view.Surface;
import androidx.constraintlayout.motion.widget.Key;
import com.baidu.mobads.sdk.internal.bw;
import com.huawei.openalliance.ad.constant.bc;
import com.qiniu.pili.droid.shortvideo.PLComposeItem;
import com.qiniu.pili.droid.shortvideo.PLDisplayMode;
import com.qiniu.pili.droid.shortvideo.PLVideoEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoFrame;
import com.qiniu.pili.droid.shortvideo.PLVideoSaveListener;
import com.qiniu.pili.droid.shortvideo.d.b;
import com.qiniu.pili.droid.shortvideo.encode.a;
import com.qiniu.pili.droid.shortvideo.gl.b.a;
import com.qiniu.pili.droid.shortvideo.gl.c.g;
import com.qiniu.pili.droid.shortvideo.gl.c.h;
import com.qiniu.pili.droid.shortvideo.gl.c.l;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/process/a/a.class */
public class a {
    private volatile long A;
    private volatile long B;

    /* renamed from: c  reason: collision with root package name */
    private String f14048c;
    private PLVideoSaveListener d;
    private PLVideoEncodeSetting e;
    private int f;
    private int g;
    private com.qiniu.pili.droid.shortvideo.encode.e h;
    private com.qiniu.pili.droid.shortvideo.gl.b.a i;
    private com.qiniu.pili.droid.shortvideo.d.b j;
    private com.qiniu.pili.droid.shortvideo.muxer.b k;
    private MediaFormat n;
    private MediaFormat o;
    private volatile Surface p;
    private volatile boolean q;
    private volatile boolean r;
    private long t;
    private LinkedList<PLComposeItem> v;
    private g w;
    private l x;
    private long y;
    private com.qiniu.pili.droid.shortvideo.process.audio.a z;

    /* renamed from: a  reason: collision with root package name */
    private boolean f14047a = false;
    private final Object b = new Object();
    private int l = 0;
    private int m = 0;
    private volatile int s = -1;
    private long u = 0;
    private a.InterfaceC0575a C = new a.InterfaceC0575a() { // from class: com.qiniu.pili.droid.shortvideo.process.a.a.2
        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void a(MediaFormat mediaFormat) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.t;
            eVar.c("MultiItemComposer", "video encode output format retrieved: " + mediaFormat);
            a.this.n = mediaFormat;
            a.this.d();
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void a(Surface surface) {
            com.qiniu.pili.droid.shortvideo.f.e.t.c("MultiItemComposer", "encode surface created");
            a.this.p = surface;
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void a(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.t;
            eVar.b("MultiItemComposer", "muxer write video: " + bufferInfo.presentationTimeUs);
            if (a.this.k != null) {
                a.this.k.a(byteBuffer, bufferInfo);
                a.this.A = bufferInfo.presentationTimeUs > a.this.A ? bufferInfo.presentationTimeUs : a.this.A;
                a.this.h();
            }
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void a(boolean z) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.t;
            eVar.c("MultiItemComposer", "video encode started result: " + z);
            if (!z) {
                a.this.a(6);
            } else if (a.this.g()) {
                a.this.i();
            } else if (a.this.i == null) {
                a.this.a(0, 0, 0, 0, (List<Long>) null);
            }
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void b(boolean z) {
            com.qiniu.pili.droid.shortvideo.f.e.t.c("MultiItemComposer", "video encode stopped");
            a.this.e();
        }
    };
    private a.InterfaceC0575a D = new a.InterfaceC0575a() { // from class: com.qiniu.pili.droid.shortvideo.process.a.a.3
        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void a(MediaFormat mediaFormat) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.t;
            eVar.c("MultiItemComposer", "audio encode output format retrieved: " + mediaFormat);
            a.this.o = mediaFormat;
            a.this.d();
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void a(Surface surface) {
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void a(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.t;
            eVar.b("MultiItemComposer", "muxer write audio: " + bufferInfo.presentationTimeUs);
            if (a.this.k != null) {
                a.this.k.b(byteBuffer, bufferInfo);
                a.this.B = bufferInfo.presentationTimeUs > a.this.B ? bufferInfo.presentationTimeUs : a.this.B;
                a.this.h();
            }
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void a(boolean z) {
            if (z) {
                return;
            }
            a.this.a(7);
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void b(boolean z) {
            com.qiniu.pili.droid.shortvideo.f.e.t.c("MultiItemComposer", "audio encode stopped");
            a.this.e();
        }
    };
    private a.b E = new a.b() { // from class: com.qiniu.pili.droid.shortvideo.process.a.a.4

        /* renamed from: a  reason: collision with root package name */
        volatile h f14052a;
        volatile b b;

        @Override // com.qiniu.pili.droid.shortvideo.gl.b.a.b
        public int a(int i, int i2, int i3, long j, float[] fArr) {
            long j2 = a.this.t;
            PLComposeItem pLComposeItem = (PLComposeItem) a.this.v.getFirst();
            long durationMs = (pLComposeItem.getDurationMs() * 1000) - ((j / 1000) - j2);
            if (durationMs < pLComposeItem.getTransitionTimeMs() * 1000) {
                if (this.f14052a == null) {
                    this.b = a.this.a(i2, i3);
                    this.f14052a = a.this.a(pLComposeItem.getTransitionTimeMs(), i2, i3, this.b.b(), this.b.c());
                    a.this.i.a(a.this.f, a.this.g);
                }
                a.this.b();
                int a2 = this.b.a();
                int i4 = a2;
                if (a2 > 0) {
                    i4 = a.this.x.a(this.b.a());
                }
                i = this.f14052a.a(i, i4, durationMs * 1000);
            }
            synchronized (a.this.b) {
                a.this.f14047a = true;
                a.this.b.notify();
            }
            a.this.h.a(j);
            return i;
        }

        @Override // com.qiniu.pili.droid.shortvideo.gl.b.a.b
        public void a() {
            if (this.f14052a != null) {
                this.f14052a.f();
                this.f14052a = null;
            }
            if (this.b != null) {
                com.qiniu.pili.droid.shortvideo.c.a.b.a(this.b.a());
                this.b = null;
            }
        }

        @Override // com.qiniu.pili.droid.shortvideo.gl.b.a.b
        public void a(int i, int i2) {
        }

        @Override // com.qiniu.pili.droid.shortvideo.gl.b.a.b
        public void a(Object obj, Surface surface) {
            if (a.this.g()) {
                a.this.j.a(new C0579a());
                a.this.j.a(surface);
                a.this.j.a();
            }
        }

        @Override // com.qiniu.pili.droid.shortvideo.gl.b.a.b
        public void b() {
        }
    };
    private final PLVideoSaveListener F = new PLVideoSaveListener() { // from class: com.qiniu.pili.droid.shortvideo.process.a.a.7
        @Override // com.qiniu.pili.droid.shortvideo.PLVideoSaveListener
        public void onProgressUpdate(float f) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.t;
            eVar.c("MultiItemComposer", "onProgressUpdate: " + f);
        }

        @Override // com.qiniu.pili.droid.shortvideo.PLVideoSaveListener
        public void onSaveVideoCanceled() {
            com.qiniu.pili.droid.shortvideo.f.e.t.c("MultiItemComposer", "onSaveVideoCanceled");
        }

        @Override // com.qiniu.pili.droid.shortvideo.PLVideoSaveListener
        public void onSaveVideoFailed(int i) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.t;
            eVar.c("MultiItemComposer", "onSaveVideoFailed: " + i);
        }

        @Override // com.qiniu.pili.droid.shortvideo.PLVideoSaveListener
        public void onSaveVideoSuccess(String str) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.t;
            eVar.c("MultiItemComposer", "onSaveVideoSuccess: " + str);
        }
    };

    /* renamed from: com.qiniu.pili.droid.shortvideo.process.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/process/a/a$a.class */
    class C0579a implements b.c {
        private long b;

        private C0579a() {
        }

        @Override // com.qiniu.pili.droid.shortvideo.d.b.c
        public void a(ByteBuffer byteBuffer, int i, long j, long j2, boolean z) {
            if (z) {
                a.this.t += this.b + (1000000 / a.this.e.getVideoEncodingFps());
                a.this.c();
                return;
            }
            this.b = j;
            synchronized (a.this.b) {
                while (!a.this.f14047a) {
                    try {
                        a.this.b.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                a.this.f14047a = false;
            }
            if (a.this.q) {
                com.qiniu.pili.droid.shortvideo.f.e.t.c("MultiItemComposer", "cancel marked, stop video things now.");
                a.this.j.c();
                a.this.i.b();
                a.this.h.c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/process/a/a$b.class */
    public class b {
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private int f14059c;
        private int d;

        public b(int i, int i2, int i3) {
            this.b = i;
            this.f14059c = i2;
            this.d = i3;
        }

        public int a() {
            return this.b;
        }

        public int b() {
            return this.f14059c;
        }

        public int c() {
            return this.d;
        }
    }

    private int a(com.qiniu.pili.droid.shortvideo.f.f fVar) {
        MediaFormat e = fVar.e();
        if (e.containsKey("rotation-degrees")) {
            return e.getInteger("rotation-degrees");
        }
        if (e.containsKey(Key.ROTATION)) {
            return e.getInteger(Key.ROTATION);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public h a(long j, int i, int i2, int i3, int i4) {
        h hVar = new h(j);
        hVar.a(this.e.getVideoEncodingWidth(), this.e.getVideoEncodingHeight());
        hVar.a(i, i2, i3, i4, PLDisplayMode.FIT);
        return hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b a(int i, int i2) {
        return this.v.size() <= 1 ? new b(0, i, i2) : a(this.v.get(1));
    }

    private b a(PLComposeItem pLComposeItem) {
        if (pLComposeItem == null) {
            return null;
        }
        return pLComposeItem.getItemType() == PLComposeItem.ItemType.VIDEO ? b(pLComposeItem) : c(pLComposeItem);
    }

    private List<Long> a(com.qiniu.pili.droid.shortvideo.f.f fVar, long j) {
        List<Long> p = fVar.p();
        ArrayList arrayList = p;
        if (j > 0) {
            arrayList = new ArrayList(p.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= p.size()) {
                    break;
                }
                arrayList.add(Long.valueOf(p.get(i2).longValue() + j));
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.t;
        eVar.c("MultiItemComposer", "exceptionalStop + " + i);
        this.s = i;
        a();
        e();
        com.qiniu.pili.droid.shortvideo.f.e eVar2 = com.qiniu.pili.droid.shortvideo.f.e.t;
        eVar2.c("MultiItemComposer", "exceptionalStop - " + i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3, int i4, List<Long> list) {
        com.qiniu.pili.droid.shortvideo.gl.b.a aVar = new com.qiniu.pili.droid.shortvideo.gl.b.a(this.p, i, i2, i3, this.e.getVideoEncodingWidth(), this.e.getVideoEncodingHeight(), list);
        this.i = aVar;
        aVar.a(this.E);
        this.i.a(new a.InterfaceC0578a() { // from class: com.qiniu.pili.droid.shortvideo.process.a.a.1
            @Override // com.qiniu.pili.droid.shortvideo.gl.b.a.InterfaceC0578a
            public void a() {
                if (a.this.g()) {
                    return;
                }
                a.this.i();
            }
        });
        this.i.b(i4);
        this.i.a(PLDisplayMode.FIT);
        this.i.a();
    }

    private boolean a(String str) {
        if (str == null) {
            com.qiniu.pili.droid.shortvideo.f.e.t.e("MultiItemComposer", "dest video path is wrong!");
            return false;
        }
        File parentFile = new File(str).getParentFile();
        if (parentFile.exists() || parentFile.mkdir()) {
            return true;
        }
        com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.t;
        eVar.e("MultiItemComposer", "failed to mkdir: " + parentFile.getAbsolutePath());
        return false;
    }

    private boolean a(List<PLComposeItem> list, String str, PLVideoEncodeSetting pLVideoEncodeSetting, PLVideoSaveListener pLVideoSaveListener) {
        PLVideoSaveListener pLVideoSaveListener2 = pLVideoSaveListener;
        if (pLVideoSaveListener == null) {
            pLVideoSaveListener2 = this.F;
        }
        if (list == null || list.isEmpty() || str == null || pLVideoEncodeSetting == null) {
            com.qiniu.pili.droid.shortvideo.f.e.t.e("MultiItemComposer", "compose: invalid params !");
            pLVideoSaveListener2.onSaveVideoFailed(10);
            return false;
        } else if (!a(str)) {
            com.qiniu.pili.droid.shortvideo.f.e.t.e("MultiItemComposer", "compose: destVideoPath is wrong!");
            return false;
        } else if (list.size() == 1) {
            com.qiniu.pili.droid.shortvideo.f.e.t.d("MultiItemComposer", "compose: only one src videos, ignore !");
            pLVideoSaveListener2.onSaveVideoFailed(10);
            return false;
        } else {
            for (PLComposeItem pLComposeItem : list) {
                if (pLComposeItem.getFilePath().equals(str)) {
                    com.qiniu.pili.droid.shortvideo.f.e.t.e("MultiItemComposer", "compose failed, the dest video path must be different with src videos !");
                    pLVideoSaveListener2.onSaveVideoFailed(10);
                    return false;
                }
            }
            return true;
        }
    }

    private int b(com.qiniu.pili.droid.shortvideo.f.f fVar) {
        MediaFormat e = fVar.e();
        if (e.containsKey("rotation-degrees") || e.containsKey(Key.ROTATION)) {
            return 0;
        }
        return fVar.m();
    }

    private g b(int i, int i2) {
        g gVar = new g();
        gVar.a(i, i2);
        gVar.b();
        return gVar;
    }

    private b b(PLComposeItem pLComposeItem) {
        com.qiniu.pili.droid.shortvideo.f.f fVar = new com.qiniu.pili.droid.shortvideo.f.f(pLComposeItem.getFilePath());
        PLVideoFrame a2 = fVar.a(0L, true);
        fVar.a();
        return new b(com.qiniu.pili.droid.shortvideo.f.d.a(a2.toBitmap()), a2.getWidth(), a2.getHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.x == null) {
            this.x = c(this.f, this.g);
        }
        if (this.w == null) {
            this.w = b(this.f, this.g);
        }
    }

    private void b(int i, int i2, int i3, int i4, List<Long> list) {
        a.b bVar = this.E;
        if (bVar != null) {
            bVar.a();
        }
        this.i.b(i4);
        this.i.a(i, i2, i3, list);
    }

    private void b(String str) {
        com.qiniu.pili.droid.shortvideo.f.f fVar = new com.qiniu.pili.droid.shortvideo.f.f(str, true, false);
        this.j = new com.qiniu.pili.droid.shortvideo.d.b(fVar.c(), fVar.e());
        int a2 = a(fVar);
        int b2 = b(fVar);
        List<Long> a3 = a(fVar, this.t);
        if (this.i == null) {
            a(fVar.h(), fVar.i(), a2, b2, a3);
        } else {
            b(fVar.h(), fVar.i(), a2, b2, a3);
        }
    }

    private l c(int i, int i2) {
        l lVar = new l();
        lVar.a(i, i2);
        lVar.b();
        return lVar;
    }

    private b c(PLComposeItem pLComposeItem) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(pLComposeItem.getFilePath(), options);
        return new b(com.qiniu.pili.droid.shortvideo.c.a.b.a(pLComposeItem.getFilePath(), this.f, this.g), options.outWidth, options.outHeight);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.v.poll();
        if (this.v.isEmpty()) {
            this.h.c();
        } else {
            i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        synchronized (this) {
            com.qiniu.pili.droid.shortvideo.f.e.t.c("MultiItemComposer", "startMuxer +");
            this.l++;
            if (this.z.d() && this.l < 2) {
                com.qiniu.pili.droid.shortvideo.f.e.t.c("MultiItemComposer", "not ready to start muxer.");
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return;
            }
            com.qiniu.pili.droid.shortvideo.muxer.b bVar = new com.qiniu.pili.droid.shortvideo.muxer.b();
            this.k = bVar;
            if (bVar.a(this.f14048c, this.n, this.o, 0)) {
                com.qiniu.pili.droid.shortvideo.f.e.t.c("MultiItemComposer", "start muxer success!");
                notify();
            } else {
                com.qiniu.pili.droid.shortvideo.f.e.t.e("MultiItemComposer", "start muxer failed!");
                a();
            }
            com.qiniu.pili.droid.shortvideo.f.e.t.c("MultiItemComposer", "startMuxer -");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(PLComposeItem pLComposeItem) {
        b a2 = a(pLComposeItem);
        b a3 = a(a2.b(), a2.c());
        h a4 = a(pLComposeItem.getTransitionTimeMs(), a2.b(), a2.c(), a3.b(), a3.c());
        b();
        long durationMs = pLComposeItem.getDurationMs() * 1000;
        long j = 0;
        while (j <= durationMs && !this.q) {
            int a5 = this.x.a(a4.a(a2.a(), a3.a(), (durationMs - j) * 1000));
            synchronized (com.qiniu.pili.droid.shortvideo.f.d.f13982a) {
                GLES20.glClear(16384);
                this.w.b(a5);
            }
            this.i.a(this.t * 1000);
            this.h.a(this.t * 1000);
            long j2 = this.y;
            j += j2;
            this.t += j2;
        }
        com.qiniu.pili.droid.shortvideo.c.a.b.a(a2.a());
        com.qiniu.pili.droid.shortvideo.c.a.b.a(a3.a());
        a4.f();
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        synchronized (this) {
            com.qiniu.pili.droid.shortvideo.f.e.t.c("MultiItemComposer", "stopMuxer +");
            boolean z = true;
            this.m++;
            if (this.z.d() && this.m < 2) {
                com.qiniu.pili.droid.shortvideo.f.e.t.c("MultiItemComposer", "not ready to stop muxer.");
                return;
            }
            if (this.k == null || !this.k.a()) {
                z = false;
            }
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.t;
            StringBuilder sb = new StringBuilder();
            sb.append("stop muxer ");
            sb.append(z ? bw.o : bc.b.S);
            eVar.c("MultiItemComposer", sb.toString());
            this.z.c();
            this.k = null;
            this.h = null;
            this.v = null;
            this.n = null;
            this.o = null;
            this.j = null;
            this.p = null;
            this.i = null;
            this.l = 0;
            this.m = 0;
            this.t = 0L;
            this.u = 0L;
            this.r = false;
            this.A = 0L;
            this.B = 0L;
            if (this.w != null) {
                this.w.f();
                this.w = null;
            }
            if (this.x != null) {
                this.x.f();
                this.x = null;
            }
            this.E.a();
            if (this.q) {
                this.q = false;
                new File(this.f14048c).delete();
                if (f()) {
                    int i = this.s;
                    this.s = -1;
                    this.d.onSaveVideoFailed(i);
                } else {
                    this.d.onSaveVideoCanceled();
                }
            } else if (z) {
                this.d.onProgressUpdate(1.0f);
                this.d.onSaveVideoSuccess(this.f14048c);
            } else {
                new File(this.f14048c).delete();
                this.d.onSaveVideoFailed(3);
            }
            com.qiniu.pili.droid.shortvideo.f.e.t.c("MultiItemComposer", "stopMuxer -");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(PLComposeItem pLComposeItem) {
        int i;
        b a2 = a(pLComposeItem);
        b a3 = a(a2.b(), a2.c());
        h a4 = a(pLComposeItem.getTransitionTimeMs(), a2.b(), a2.c(), a3.b(), a3.c());
        b();
        com.qiniu.pili.droid.shortvideo.b.a aVar = new com.qiniu.pili.droid.shortvideo.b.a();
        File file = new File(pLComposeItem.getFilePath());
        if (file.exists()) {
            try {
                if (aVar.a(new FileInputStream(file), 0) == 0) {
                    long j = 0;
                    long durationMs = pLComposeItem.getDurationMs() * 1000;
                    aVar.a();
                    long a5 = aVar.a(aVar.d()) * 1000;
                    Bitmap createBitmap = Bitmap.createBitmap(aVar.e());
                    int a6 = com.qiniu.pili.droid.shortvideo.f.d.a(createBitmap);
                    while (true) {
                        i = a6;
                        if (j > durationMs || this.q) {
                            break;
                        }
                        long j2 = a5;
                        int i2 = i;
                        if (j >= a5) {
                            aVar.a();
                            j2 = a5 + (aVar.a(aVar.d()) * 1000);
                            createBitmap = Bitmap.createBitmap(aVar.e());
                            com.qiniu.pili.droid.shortvideo.c.a.b.a(i);
                            i2 = com.qiniu.pili.droid.shortvideo.f.d.a(createBitmap);
                            createBitmap.recycle();
                        }
                        int a7 = this.x.a(a4.a(i2, a3.a(), (durationMs - j) * 1000));
                        synchronized (com.qiniu.pili.droid.shortvideo.f.d.f13982a) {
                            GLES20.glClear(16384);
                            this.w.b(a7);
                        }
                        this.i.a(this.t * 1000);
                        this.h.a(this.t * 1000);
                        long j3 = this.y;
                        j += j3;
                        this.t += j3;
                        a5 = j2;
                        a6 = i2;
                    }
                    com.qiniu.pili.droid.shortvideo.c.a.b.a(i);
                    com.qiniu.pili.droid.shortvideo.c.a.b.a(a2.a());
                    com.qiniu.pili.droid.shortvideo.c.a.b.a(a3.a());
                    createBitmap.recycle();
                    a4.f();
                    c();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean f() {
        return this.s >= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        return this.v.getFirst().getItemType() == PLComposeItem.ItemType.VIDEO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        synchronized (this) {
            this.d.onProgressUpdate(((float) (this.B + this.A)) / ((float) this.u));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        final PLComposeItem first = this.v.getFirst();
        if (first.getItemType() == PLComposeItem.ItemType.VIDEO) {
            b(first.getFilePath());
        } else if (first.getItemType() == PLComposeItem.ItemType.IMAGE) {
            this.i.a(new Runnable() { // from class: com.qiniu.pili.droid.shortvideo.process.a.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.d(first);
                }
            });
        } else if (first.getItemType() == PLComposeItem.ItemType.GIF) {
            this.i.a(new Runnable() { // from class: com.qiniu.pili.droid.shortvideo.process.a.a.6
                @Override // java.lang.Runnable
                public void run() {
                    a.this.e(first);
                }
            });
        }
    }

    public void a() {
        synchronized (this) {
            if (this.r) {
                this.q = true;
                this.z.b();
                com.qiniu.pili.droid.shortvideo.f.e.t.c("MultiItemComposer", "cancel compose");
            } else {
                com.qiniu.pili.droid.shortvideo.f.e.t.d("MultiItemComposer", "cancel compose failed");
            }
        }
    }

    public boolean a(List<PLComposeItem> list, String str, PLVideoEncodeSetting pLVideoEncodeSetting, String str2, float f, float f2, PLVideoSaveListener pLVideoSaveListener) {
        synchronized (this) {
            com.qiniu.pili.droid.shortvideo.f.e.t.c("MultiItemComposer", "compose +");
            if (this.r) {
                com.qiniu.pili.droid.shortvideo.f.e.t.e("MultiItemComposer", "compose already started");
                return false;
            } else if (a(list, str, pLVideoEncodeSetting, pLVideoSaveListener)) {
                for (PLComposeItem pLComposeItem : list) {
                    this.u += pLComposeItem.getDurationMs() * 1000;
                }
                this.v = new LinkedList<>(list);
                this.f14048c = str;
                PLVideoSaveListener pLVideoSaveListener2 = pLVideoSaveListener;
                if (pLVideoSaveListener == null) {
                    pLVideoSaveListener2 = this.F;
                }
                this.d = pLVideoSaveListener2;
                this.e = pLVideoEncodeSetting;
                this.f = pLVideoEncodeSetting.getVideoEncodingWidth();
                this.g = this.e.getVideoEncodingHeight();
                this.y = 1000000 / pLVideoEncodeSetting.getVideoEncodingFps();
                com.qiniu.pili.droid.shortvideo.encode.e eVar = new com.qiniu.pili.droid.shortvideo.encode.e(pLVideoEncodeSetting);
                this.h = eVar;
                eVar.a(this.C);
                this.h.a();
                com.qiniu.pili.droid.shortvideo.process.audio.a aVar = new com.qiniu.pili.droid.shortvideo.process.audio.a(list);
                this.z = aVar;
                aVar.a(this.D);
                this.z.a(str2);
                this.z.a(f, f2);
                if (this.z.a()) {
                    this.u *= 2;
                }
                this.r = true;
                com.qiniu.pili.droid.shortvideo.f.e.t.c("MultiItemComposer", "compose -");
                return true;
            } else {
                return false;
            }
        }
    }
}
