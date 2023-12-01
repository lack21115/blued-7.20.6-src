package com.qiniu.pili.droid.shortvideo.process.a;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.view.Surface;
import com.baidu.mobads.sdk.internal.bw;
import com.huawei.openalliance.ad.constant.bc;
import com.qiniu.pili.droid.shortvideo.PLAudioEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLMixAudioFile;
import com.qiniu.pili.droid.shortvideo.PLVideoEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoMixItem;
import com.qiniu.pili.droid.shortvideo.PLVideoSaveListener;
import com.qiniu.pili.droid.shortvideo.d.b;
import com.qiniu.pili.droid.shortvideo.encode.a;
import com.qiniu.pili.droid.shortvideo.gl.c.g;
import com.qiniu.pili.droid.shortvideo.process.audio.MultiAudioMixer;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/process/a/c.class */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public static String f14071a = "MultiVideoMixer";
    private PLVideoEncodeSetting b;

    /* renamed from: c  reason: collision with root package name */
    private LinkedList<PLVideoMixItem> f14072c;
    private LinkedList<e> d;
    private com.qiniu.pili.droid.shortvideo.gl.a.f e;
    private g f;
    private com.qiniu.pili.droid.shortvideo.gl.a.d g;
    private volatile Surface h;
    private com.qiniu.pili.droid.shortvideo.encode.e i;
    private PLVideoSaveListener j;
    private com.qiniu.pili.droid.shortvideo.muxer.b k;
    private String l;
    private MediaFormat m;
    private MediaFormat n;
    private long o;
    private volatile long p;
    private int q;
    private CountDownLatch r;
    private volatile boolean s;
    private volatile boolean t;
    private volatile boolean u;
    private List<PLMixAudioFile> w;
    private MultiAudioMixer x;
    private com.qiniu.pili.droid.shortvideo.encode.c y;
    private volatile int v = -1;
    private int z = 0;
    private int A = 0;
    private a.InterfaceC0575a B = new a.InterfaceC0575a() { // from class: com.qiniu.pili.droid.shortvideo.process.a.c.2
        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void a(MediaFormat mediaFormat) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.x;
            String str = c.f14071a;
            eVar.c(str, "audio encode format: " + mediaFormat);
            c.this.m = mediaFormat;
            c.this.j();
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void a(Surface surface) {
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void a(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.x;
            String str = c.f14071a;
            eVar.b(str, "encoded audio frame: " + bufferInfo.presentationTimeUs);
            if (c.this.k != null) {
                c.this.k.b(byteBuffer, bufferInfo);
            }
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void a(boolean z) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.x;
            String str = c.f14071a;
            eVar.c(str, "audio encode started result: " + z);
            if (z) {
                c.this.i();
            } else {
                c.this.a(7);
            }
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void b(boolean z) {
            com.qiniu.pili.droid.shortvideo.f.e.x.c(c.f14071a, "audio encode stopped");
            c.this.k();
        }
    };
    private a.InterfaceC0575a C = new a.InterfaceC0575a() { // from class: com.qiniu.pili.droid.shortvideo.process.a.c.3
        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void a(MediaFormat mediaFormat) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.x;
            String str = c.f14071a;
            eVar.c(str, "got video format:" + mediaFormat);
            c.this.n = mediaFormat;
            c.this.j();
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void a(Surface surface) {
            c.this.h = surface;
            new Thread(c.this).start();
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void a(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
            if (c.this.k != null) {
                com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.x;
                String str = c.f14071a;
                eVar.b(str, "video encoded frame size:" + bufferInfo.size + " ts:" + bufferInfo.presentationTimeUs);
                c.this.k.a(byteBuffer, bufferInfo);
                c.this.j.onProgressUpdate((((float) bufferInfo.presentationTimeUs) * 1.0f) / ((float) (c.this.o * 1000)));
            }
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void a(boolean z) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.x;
            String str = c.f14071a;
            eVar.c(str, "video encode started result: " + z);
            if (z) {
                return;
            }
            c.this.a(6);
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void b(boolean z) {
            com.qiniu.pili.droid.shortvideo.f.e.x.c(c.f14071a, "video encode stopped");
            c.this.n = null;
            c.this.k();
        }
    };
    private final PLVideoSaveListener D = new PLVideoSaveListener() { // from class: com.qiniu.pili.droid.shortvideo.process.a.c.4
        @Override // com.qiniu.pili.droid.shortvideo.PLVideoSaveListener
        public void onProgressUpdate(float f) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.x;
            String str = c.f14071a;
            eVar.c(str, "onProgressUpdate: " + f);
        }

        @Override // com.qiniu.pili.droid.shortvideo.PLVideoSaveListener
        public void onSaveVideoCanceled() {
            com.qiniu.pili.droid.shortvideo.f.e.x.c(c.f14071a, "onSaveVideoCanceled");
        }

        @Override // com.qiniu.pili.droid.shortvideo.PLVideoSaveListener
        public void onSaveVideoFailed(int i) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.x;
            String str = c.f14071a;
            eVar.c(str, "onSaveVideoFailed: " + i);
        }

        @Override // com.qiniu.pili.droid.shortvideo.PLVideoSaveListener
        public void onSaveVideoSuccess(String str) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.x;
            String str2 = c.f14071a;
            eVar.c(str2, "onSaveVideoSuccess: " + str);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/process/a/c$a.class */
    public class a implements b.c {
        private volatile long b;

        /* renamed from: c  reason: collision with root package name */
        private long f14078c;
        private String d;

        public a(String str, long j) {
            this.d = str;
            this.f14078c = j;
        }

        @Override // com.qiniu.pili.droid.shortvideo.d.b.c
        public void a(ByteBuffer byteBuffer, int i, long j, long j2, boolean z) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.x;
            String str = c.f14071a;
            eVar.b(str, "video decode frame, elapseTimestampUs : " + j2 + " curMixDurationUs : " + c.this.p + " path : " + this.d);
            c.this.r.countDown();
            this.b = z ? Long.MAX_VALUE : (this.f14078c * 1000) + j2;
            while (b() && !c.this.s) {
            }
            while (!a() && !c.this.s) {
            }
        }

        public boolean a() {
            return c.this.p > this.b;
        }

        public boolean b() {
            return c.this.p < this.f14078c * 1000;
        }
    }

    private PLMixAudioFile a(PLVideoMixItem pLVideoMixItem) {
        com.qiniu.pili.droid.shortvideo.f.f fVar = new com.qiniu.pili.droid.shortvideo.f.f(pLVideoMixItem.getVideoPath());
        if (fVar.f() == null) {
            fVar.a();
            return null;
        }
        PLMixAudioFile pLMixAudioFile = new PLMixAudioFile(pLVideoMixItem.getVideoPath(), false);
        pLMixAudioFile.setLooping(pLVideoMixItem.isLooping());
        pLMixAudioFile.setOffsetInVideo(pLVideoMixItem.getStartTimeMs() * 1000);
        pLMixAudioFile.setVolume(pLVideoMixItem.getVolume());
        if (pLVideoMixItem.isLooping()) {
            pLMixAudioFile.setDurationInVideo(this.o * 1000);
        }
        return pLMixAudioFile;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.x;
        String str = f14071a;
        eVar.e(str, "exceptionalStop + " + i);
        a();
        k();
        com.qiniu.pili.droid.shortvideo.f.e eVar2 = com.qiniu.pili.droid.shortvideo.f.e.x;
        String str2 = f14071a;
        eVar2.e(str2, "exceptionalStop - " + i);
    }

    private boolean a(String str) {
        if (str == null) {
            com.qiniu.pili.droid.shortvideo.f.e.x.e(f14071a, "dest video path is wrong!");
            return false;
        }
        File parentFile = new File(str).getParentFile();
        if (parentFile.exists() || parentFile.mkdir()) {
            return true;
        }
        com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.x;
        String str2 = f14071a;
        eVar.e(str2, "failed to mkdir: " + parentFile.getAbsolutePath());
        return false;
    }

    private boolean a(List<PLVideoMixItem> list, String str, PLVideoEncodeSetting pLVideoEncodeSetting, PLVideoSaveListener pLVideoSaveListener) {
        PLVideoSaveListener pLVideoSaveListener2 = pLVideoSaveListener;
        if (pLVideoSaveListener == null) {
            pLVideoSaveListener2 = this.D;
        }
        if (list == null || list.isEmpty() || list.size() <= 1 || str == null || pLVideoEncodeSetting == null) {
            com.qiniu.pili.droid.shortvideo.f.e.x.e(f14071a, "mix: invalid params !");
            pLVideoSaveListener2.onSaveVideoFailed(10);
            return false;
        } else if (!a(str)) {
            com.qiniu.pili.droid.shortvideo.f.e.x.e(f14071a, "mix: destVideoPath is wrong!");
            pLVideoSaveListener2.onSaveVideoFailed(10);
            return false;
        } else {
            for (PLVideoMixItem pLVideoMixItem : list) {
                if (pLVideoMixItem == null) {
                    com.qiniu.pili.droid.shortvideo.f.e.x.e(f14071a, "mix failed, item is null !");
                    pLVideoSaveListener2.onSaveVideoFailed(10);
                    return false;
                } else if (pLVideoMixItem.getVideoPath().equals(str)) {
                    com.qiniu.pili.droid.shortvideo.f.e.x.e(f14071a, "mix failed, the dest video path must be different with src videos !");
                    pLVideoSaveListener2.onSaveVideoFailed(10);
                    return false;
                }
            }
            return true;
        }
    }

    private void b() {
        com.qiniu.pili.droid.shortvideo.gl.a.d dVar = new com.qiniu.pili.droid.shortvideo.gl.a.d(null, 1);
        this.g = dVar;
        com.qiniu.pili.droid.shortvideo.gl.a.f fVar = new com.qiniu.pili.droid.shortvideo.gl.a.f(dVar, this.h, false);
        this.e = fVar;
        fVar.b();
        this.f = com.qiniu.pili.droid.shortvideo.f.d.b(this.b.getVideoEncodingWidth(), this.b.getVideoEncodingHeight());
        this.q = com.qiniu.pili.droid.shortvideo.f.d.a((ByteBuffer) null, this.b.getVideoEncodingWidth(), this.b.getVideoEncodingHeight(), 6408);
    }

    private void c() {
        this.r = new CountDownLatch(this.f14072c.size());
        this.d = new LinkedList<>();
        Iterator<PLVideoMixItem> it = this.f14072c.iterator();
        while (it.hasNext()) {
            PLVideoMixItem next = it.next();
            e eVar = new e(next, this.b.getVideoEncodingWidth(), this.b.getVideoEncodingHeight());
            eVar.a(new a(next.getVideoPath(), next.getStartTimeMs()));
            this.d.add(eVar);
            eVar.a();
        }
    }

    private void d() {
        try {
            this.r.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void e() {
        long videoEncodingFps = 1000000 / this.b.getVideoEncodingFps();
        while (this.p <= this.o * 1000 && !this.t) {
            Iterator<e> it = this.d.iterator();
            boolean z = true;
            while (it.hasNext()) {
                e next = it.next();
                a aVar = (a) next.b();
                while (!aVar.b() && aVar.a()) {
                }
                if (z) {
                    this.q = next.a(this.q, true);
                    z = false;
                } else {
                    this.q = next.a(this.q, false);
                }
            }
            this.f.b(this.q);
            this.e.a(this.p * 1000);
            this.e.c();
            this.i.a(this.p * 1000);
            com.qiniu.pili.droid.shortvideo.f.e.x.b(f14071a, "mixVideoFrame, mix timestamp is : " + this.p);
            this.p = this.p + videoEncodingFps;
        }
        this.s = true;
    }

    private void f() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.d.size()) {
                return;
            }
            this.d.get(i2).d();
            i = i2 + 1;
        }
    }

    private void g() {
        this.e.d();
        this.f.f();
        this.g.a();
    }

    private void h() {
        MediaFormat mediaFormat = new MediaFormat();
        int i = 44100;
        mediaFormat.setInteger(MediaFormat.KEY_SAMPLE_RATE, 44100);
        mediaFormat.setInteger(MediaFormat.KEY_CHANNEL_COUNT, 1);
        int integer = mediaFormat.getInteger(MediaFormat.KEY_SAMPLE_RATE);
        int integer2 = mediaFormat.getInteger(MediaFormat.KEY_CHANNEL_COUNT);
        if (mediaFormat.containsKey(MediaFormat.KEY_BIT_RATE)) {
            i = mediaFormat.getInteger(MediaFormat.KEY_BIT_RATE);
        }
        PLAudioEncodeSetting pLAudioEncodeSetting = new PLAudioEncodeSetting();
        pLAudioEncodeSetting.setSampleRate(integer);
        pLAudioEncodeSetting.setChannels(integer2);
        pLAudioEncodeSetting.setBitrate(i);
        com.qiniu.pili.droid.shortvideo.encode.c cVar = new com.qiniu.pili.droid.shortvideo.encode.c(pLAudioEncodeSetting);
        this.y = cVar;
        cVar.a(this.B);
        this.y.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        MultiAudioMixer multiAudioMixer = new MultiAudioMixer();
        this.x = multiAudioMixer;
        multiAudioMixer.a(this.o);
        this.x.a(this.w, new MultiAudioMixer.a() { // from class: com.qiniu.pili.droid.shortvideo.process.a.c.1
            @Override // com.qiniu.pili.droid.shortvideo.process.audio.MultiAudioMixer.a
            public void a() {
                c.this.y.c();
            }

            @Override // com.qiniu.pili.droid.shortvideo.process.audio.MultiAudioMixer.a
            public void a(int i) {
                com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.x;
                eVar.d("multi audio mix failed error : " + i);
                c.this.y.c();
            }

            @Override // com.qiniu.pili.droid.shortvideo.process.audio.MultiAudioMixer.a
            public void a(byte[] bArr, long j) {
                c.this.y.a(ByteBuffer.wrap(bArr), bArr.length, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        synchronized (this) {
            com.qiniu.pili.droid.shortvideo.f.e.x.c(f14071a, "startMuxer +");
            int i = this.z + 1;
            this.z = i;
            if (this.y != null && i < 2) {
                com.qiniu.pili.droid.shortvideo.f.e.x.c(f14071a, "not ready to start muxer.");
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return;
            }
            com.qiniu.pili.droid.shortvideo.muxer.b bVar = new com.qiniu.pili.droid.shortvideo.muxer.b();
            this.k = bVar;
            if (bVar.a(this.l, this.n, this.m, 0)) {
                com.qiniu.pili.droid.shortvideo.f.e.x.c(f14071a, "start muxer success!");
                notify();
            } else {
                com.qiniu.pili.droid.shortvideo.f.e.x.e(f14071a, "start muxer failed!");
                a();
            }
            com.qiniu.pili.droid.shortvideo.f.e.x.c(f14071a, "startMuxer -");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        synchronized (this) {
            com.qiniu.pili.droid.shortvideo.f.e.x.c(f14071a, "stopMuxer +");
            boolean z = true;
            int i = this.A + 1;
            this.A = i;
            if (this.y != null && i < 2) {
                com.qiniu.pili.droid.shortvideo.f.e.x.c(f14071a, "not ready to stop muxer.");
                return;
            }
            if (this.k == null || !this.k.a()) {
                z = false;
            }
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.x;
            String str = f14071a;
            StringBuilder sb = new StringBuilder();
            sb.append("stop muxer ");
            sb.append(z ? bw.o : bc.b.S);
            eVar.c(str, sb.toString());
            this.k = null;
            this.i = null;
            this.y = null;
            if (this.f14072c != null) {
                this.f14072c.clear();
                this.f14072c = null;
            }
            if (this.w != null) {
                this.w.clear();
                this.w = null;
            }
            if (this.d != null) {
                this.d.clear();
                this.d = null;
            }
            this.n = null;
            this.m = null;
            this.h = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.p = 0L;
            this.u = false;
            this.s = false;
            this.A = 0;
            this.z = 0;
            if (this.t) {
                this.t = false;
                new File(this.l).delete();
                if (l()) {
                    int i2 = this.v;
                    this.v = -1;
                    this.j.onSaveVideoFailed(i2);
                } else {
                    this.j.onSaveVideoCanceled();
                }
            } else if (z) {
                this.j.onProgressUpdate(1.0f);
                this.j.onSaveVideoSuccess(this.l);
            } else {
                new File(this.l).delete();
                this.j.onSaveVideoFailed(3);
            }
            com.qiniu.pili.droid.shortvideo.f.e.x.c(f14071a, "stopMuxer -");
        }
    }

    private boolean l() {
        return this.v >= 0;
    }

    public void a() {
        synchronized (this) {
            if (this.u) {
                com.qiniu.pili.droid.shortvideo.f.e.x.c(f14071a, "cancel mix");
                this.t = true;
                if (this.x != null) {
                    this.x.a();
                }
            } else {
                com.qiniu.pili.droid.shortvideo.f.e.x.d(f14071a, "cancel mix failed");
            }
        }
    }

    public boolean a(List<PLVideoMixItem> list, String str, long j, PLVideoEncodeSetting pLVideoEncodeSetting, PLVideoSaveListener pLVideoSaveListener) {
        synchronized (this) {
            com.qiniu.pili.droid.shortvideo.f.e.x.c(f14071a, "mixItems +");
            if (a(list, str, pLVideoEncodeSetting, pLVideoSaveListener)) {
                PLVideoSaveListener pLVideoSaveListener2 = pLVideoSaveListener;
                if (pLVideoSaveListener == null) {
                    pLVideoSaveListener2 = this.D;
                }
                this.j = pLVideoSaveListener2;
                if (this.u) {
                    com.qiniu.pili.droid.shortvideo.f.e.s.e(f14071a, "mix already started +");
                    this.j.onSaveVideoFailed(1);
                    return false;
                }
                this.b = pLVideoEncodeSetting;
                this.f14072c = new LinkedList<>(list);
                this.w = new LinkedList();
                this.l = str;
                this.o = j;
                for (PLVideoMixItem pLVideoMixItem : list) {
                    PLMixAudioFile a2 = a(pLVideoMixItem);
                    if (a2 != null) {
                        this.w.add(a2);
                    }
                }
                com.qiniu.pili.droid.shortvideo.encode.e eVar = new com.qiniu.pili.droid.shortvideo.encode.e(pLVideoEncodeSetting);
                this.i = eVar;
                eVar.a(this.C);
                this.i.a();
                this.u = true;
                com.qiniu.pili.droid.shortvideo.f.e.x.c(f14071a, "mixItems +");
                return true;
            }
            return false;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        h();
        b();
        c();
        d();
        e();
        f();
        g();
        this.i.c();
    }
}
