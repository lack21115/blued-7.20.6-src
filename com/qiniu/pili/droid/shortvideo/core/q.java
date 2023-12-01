package com.qiniu.pili.droid.shortvideo.core;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.view.Surface;
import com.baidu.mobads.sdk.internal.bw;
import com.huawei.openalliance.ad.constant.bc;
import com.qiniu.pili.droid.shortvideo.PLAudioEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLMixAudioFile;
import com.qiniu.pili.droid.shortvideo.PLSpeedTimeRange;
import com.qiniu.pili.droid.shortvideo.PLVideoEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoFilterListener;
import com.qiniu.pili.droid.shortvideo.PLVideoSaveListener;
import com.qiniu.pili.droid.shortvideo.PLWatermarkSetting;
import com.qiniu.pili.droid.shortvideo.core.QosManager;
import com.qiniu.pili.droid.shortvideo.core.a;
import com.qiniu.pili.droid.shortvideo.core.b;
import com.qiniu.pili.droid.shortvideo.d.b;
import com.qiniu.pili.droid.shortvideo.encode.a;
import com.qiniu.pili.droid.shortvideo.gl.b.a;
import com.qiniu.pili.droid.shortvideo.process.audio.MultiAudioMixer;
import com.qiniu.pili.droid.shortvideo.transcoder.audio.AudioMixer;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/core/q.class */
public class q {
    private volatile boolean A;
    private com.qiniu.pili.droid.shortvideo.muxer.b B;
    private int E;
    private PLVideoEncodeSetting F;
    private com.qiniu.pili.droid.shortvideo.gl.b.a G;
    private volatile boolean H;
    private int I;
    private int J;
    private int K;
    private com.qiniu.pili.droid.shortvideo.transcoder.audio.a L;
    private PLVideoSaveListener M;
    private PLVideoFilterListener N;
    private volatile boolean O;
    private volatile boolean P;
    private long R;
    private long S;
    private long T;
    private volatile boolean U;
    private int V;
    private int W;
    private int X;
    private int Y;
    private int Z;

    /* renamed from: a  reason: collision with root package name */
    private Context f27593a;
    private com.qiniu.pili.droid.shortvideo.core.a ab;
    private ArrayList<PLSpeedTimeRange> ac;
    private volatile int ad;
    private boolean ae;
    private int af;
    private AudioMixer ag;
    private ByteBuffer ah;
    private int ai;
    private boolean aj;
    private boolean al;
    private List<PLMixAudioFile> an;
    private MultiAudioMixer ao;
    private volatile long ap;
    private volatile long aq;

    /* renamed from: ar  reason: collision with root package name */
    private int f27594ar;
    private int as;
    private int at;
    private int au;
    private com.qiniu.pili.droid.shortvideo.gl.c.d av;
    private PLWatermarkSetting aw;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f27595c;
    private Object i;
    private MediaExtractor j;
    private MediaExtractor k;
    private MediaExtractor l;
    private MediaFormat m;
    private MediaFormat n;
    private MediaFormat o;
    private MediaFormat p;
    private com.qiniu.pili.droid.shortvideo.d.b r;
    private com.qiniu.pili.droid.shortvideo.d.b s;
    private com.qiniu.pili.droid.shortvideo.d.b t;
    private Thread u;
    private MediaFormat v;
    private MediaFormat w;
    private com.qiniu.pili.droid.shortvideo.encode.e x;
    private com.qiniu.pili.droid.shortvideo.encode.c y;
    private boolean d = false;
    private boolean e = false;
    private boolean f = false;
    private final Object g = new Object();
    private final Object h = new Object();
    private Object q = new Object();
    private Object z = new Object();
    private int C = 0;
    private int D = 0;
    private volatile int Q = -1;
    private double aa = 1.0d;
    private Object ak = new Object();
    private Object am = new Object();
    private JSONObject ax = new JSONObject();
    private a.InterfaceC0745a ay = new a.InterfaceC0745a() { // from class: com.qiniu.pili.droid.shortvideo.core.q.7
        private long b;

        /* renamed from: c  reason: collision with root package name */
        private long f27607c;

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0745a
        public void a(MediaFormat mediaFormat) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.s;
            eVar.c("ShortVideoTranscoderCore", "video encode format: " + mediaFormat);
            q.this.v = mediaFormat;
            q.this.f();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v124, types: [java.util.List] */
        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0745a
        public void a(Surface surface) {
            int i;
            int i2;
            LinkedList linkedList = new LinkedList();
            do {
                long sampleTime = q.this.j.getSampleTime();
                q.this.j.getSampleTrackIndex();
                boolean z = true;
                if (!q.this.ae ? sampleTime < q.this.R : sampleTime < q.this.R || sampleTime > q.this.S) {
                    z = false;
                }
                if (z) {
                    linkedList.add(Long.valueOf(sampleTime));
                    com.qiniu.pili.droid.shortvideo.f.e.s.b("ShortVideoTranscoderCore", "cache video timestamp: " + sampleTime);
                }
            } while (q.this.j.advance());
            Collections.sort(linkedList);
            LinkedList linkedList2 = linkedList;
            if (q.this.ae) {
                linkedList2 = q.this.c(linkedList);
            }
            if (q.this.m.containsKey("rotation-degrees")) {
                i = q.this.m.getInteger("rotation-degrees");
            } else {
                i = 0;
                if (q.this.m.containsKey("rotation")) {
                    i = q.this.m.getInteger("rotation");
                }
            }
            q qVar = q.this;
            qVar.G = new com.qiniu.pili.droid.shortvideo.gl.b.a(surface, qVar.m.getInteger("width"), q.this.m.getInteger("height"), i, q.this.F.getVideoEncodingWidth(), q.this.F.getVideoEncodingHeight(), linkedList2);
            q.this.G.a(q.this.i);
            q.this.G.a(q.this.aa);
            q.this.G.a(q.this.U);
            q.this.G.c(q.this.Z);
            if (q.this.E > 0 && com.qiniu.pili.droid.shortvideo.f.g.f(q.this.b) > q.this.E) {
                q.this.G.a(q.this.E);
            }
            if (q.this.at > 0 && q.this.au > 0) {
                q.this.G.a(q.this.f27594ar, q.this.as, q.this.at, q.this.au);
            }
            if (q.this.V != 0) {
                q.this.G.a(q.this.V, q.this.W, q.this.aA);
                com.qiniu.pili.droid.shortvideo.gl.b.a aVar = q.this.G;
                if (q.this.h()) {
                    q qVar2 = q.this;
                    i2 = qVar2.c(qVar2.X);
                } else {
                    i2 = q.this.X;
                }
                aVar.b(i2);
            } else {
                q.this.G.a(q.this.aA);
                int d = com.qiniu.pili.droid.shortvideo.f.g.d(q.this.b) - i;
                com.qiniu.pili.droid.shortvideo.gl.b.a aVar2 = q.this.G;
                int i3 = d;
                if (q.this.h()) {
                    i3 = q.this.c(d);
                }
                aVar2.b(i3);
            }
            q.this.G.a();
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0745a
        public void a(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
            double d;
            com.qiniu.pili.droid.shortvideo.f.e.s.b("ShortVideoTranscoderCore", "encoded video frame count: " + q.L(q.this) + " info.presentationTimeUs " + bufferInfo.presentationTimeUs);
            if (q.this.B != null) {
                if (q.this.ac != null) {
                    Iterator it = q.this.ac.iterator();
                    while (true) {
                        d = 1.0d;
                        if (!it.hasNext()) {
                            break;
                        }
                        PLSpeedTimeRange pLSpeedTimeRange = (PLSpeedTimeRange) it.next();
                        if (pLSpeedTimeRange.isIncludeTimeUs(bufferInfo.presentationTimeUs)) {
                            d = pLSpeedTimeRange.getSpeed();
                            break;
                        }
                    }
                    long j = bufferInfo.presentationTimeUs;
                    bufferInfo.presentationTimeUs = this.b + ((long) ((bufferInfo.presentationTimeUs - this.f27607c) / d));
                    this.b = bufferInfo.presentationTimeUs;
                    this.f27607c = j;
                }
                q.this.B.a(byteBuffer, bufferInfo);
                if (q.this.ae) {
                    return;
                }
                if (q.this.s == null && q.this.l == null && !q.this.l()) {
                    q.this.M.onProgressUpdate((((float) bufferInfo.presentationTimeUs) * 1.0f) / ((float) q.this.T));
                    return;
                }
                q.this.ap = bufferInfo.presentationTimeUs;
                q.this.m();
            }
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0745a
        public void a(boolean z) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.s;
            eVar.c("ShortVideoTranscoderCore", "video encode started result: " + z);
            if (z) {
                return;
            }
            if (q.this.F.getBitrateMode() != PLVideoEncodeSetting.BitrateMode.CONSTANT_QUALITY_PRIORITY || !q.this.m.containsKey(MediaFormat.KEY_PROFILE) || q.this.m.getInteger(MediaFormat.KEY_PROFILE) != 8) {
                q.this.a(6, true);
                return;
            }
            com.qiniu.pili.droid.shortvideo.f.e.s.d("ShortVideoTranscoderCore", "no support CONSTANT_QUALITY_PRIORITY , change it to QUALITY_PRIORITY and restart again!");
            q.this.F.setProfileMode(com.qiniu.pili.droid.shortvideo.f.g.a(q.this.m.getInteger(MediaFormat.KEY_PROFILE)));
            q.this.F.setEncodingBitrateMode(PLVideoEncodeSetting.BitrateMode.QUALITY_PRIORITY);
            q qVar = q.this;
            qVar.x = new com.qiniu.pili.droid.shortvideo.encode.e(qVar.F);
            q.this.x.a(q.this.ay);
            q.this.x.a(q.this.aa);
            q.this.x.a();
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0745a
        public void b(boolean z) {
            if (z) {
                com.qiniu.pili.droid.shortvideo.f.e.s.e("ShortVideoTranscoderCore", "video encoder exceptional stopped !");
                q.this.a(19, true);
                return;
            }
            com.qiniu.pili.droid.shortvideo.f.e.s.c("ShortVideoTranscoderCore", "video encode stopped");
            if (q.this.G != null) {
                q.this.G.b();
            }
            q.this.j.release();
            q.this.g();
        }
    };
    private a.InterfaceC0745a az = new a.InterfaceC0745a() { // from class: com.qiniu.pili.droid.shortvideo.core.q.8
        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0745a
        public void a(MediaFormat mediaFormat) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.s;
            eVar.c("ShortVideoTranscoderCore", "audio encode format: " + mediaFormat);
            q.this.w = mediaFormat;
            q.this.f();
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0745a
        public void a(Surface surface) {
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0745a
        public void a(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.s;
            eVar.b("ShortVideoTranscoderCore", "encoded audio frame: " + bufferInfo.presentationTimeUs);
            if (q.this.B != null) {
                q.this.B.b(byteBuffer, bufferInfo);
                if (q.this.ae) {
                    return;
                }
                q.this.aq = bufferInfo.presentationTimeUs;
                q.this.m();
            }
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0745a
        public void a(boolean z) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.s;
            eVar.c("ShortVideoTranscoderCore", "audio encode started result: " + z);
            if (!z) {
                q.this.a(7, true);
                return;
            }
            synchronized (q.this.z) {
                q.this.A = true;
                if (!q.this.l()) {
                    q.this.ab = new com.qiniu.pili.droid.shortvideo.core.a();
                    q.this.ab.a(q.this.aa);
                    if (q.this.ac != null) {
                        q.this.ab.a(true);
                    }
                    q.this.ab.a(new a.InterfaceC0743a() { // from class: com.qiniu.pili.droid.shortvideo.core.q.8.1
                        @Override // com.qiniu.pili.droid.shortvideo.core.a.InterfaceC0743a
                        public void a(ByteBuffer byteBuffer, int i, long j) {
                            q.this.y.a(byteBuffer, i, j);
                        }
                    });
                }
                q.this.z.notify();
            }
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0745a
        public void b(boolean z) {
            com.qiniu.pili.droid.shortvideo.f.e.s.c("ShortVideoTranscoderCore", "audio encode stopped");
            if (q.this.k != null) {
                q.this.k.release();
            }
            if (q.this.l != null) {
                q.this.l.release();
            }
            if (q.this.ag != null) {
                q.this.ag.a();
            }
            q.this.g();
        }
    };
    private a.b aA = new a.b() { // from class: com.qiniu.pili.droid.shortvideo.core.q.9
        private void c() {
            synchronized (q.this.h) {
                while (!q.this.f) {
                    try {
                        q.this.h.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                q.this.f = false;
                if (q.this.ad > 0) {
                    q.this.G.d(q.this.ad);
                    q.this.ad = 0;
                }
            }
        }

        private void d() {
            synchronized (q.this.g) {
                q.this.d = true;
                q.this.g.notify();
            }
        }

        @Override // com.qiniu.pili.droid.shortvideo.gl.b.a.b
        public int a(int i, int i2, int i3, long j, float[] fArr) {
            if (q.this.ae) {
                c();
            }
            d();
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.s;
            eVar.b("ShortVideoTranscoderCore", "rendered video frame count: " + q.ae(q.this) + " timestampNs " + j);
            if (!q.this.j()) {
                q.this.x.a(j);
            }
            int i4 = i;
            if (q.this.N != null) {
                int onDrawFrame = q.this.N.onDrawFrame(i, i2, i3, j, fArr);
                i4 = i;
                if (onDrawFrame > 0) {
                    i4 = onDrawFrame;
                }
            }
            int i5 = i4;
            if (q.this.aw != null) {
                if (q.this.av == null) {
                    q qVar = q.this;
                    qVar.av = qVar.a(qVar.aw, i2, i3);
                }
                i5 = q.this.av.a(i4);
            }
            return i5;
        }

        @Override // com.qiniu.pili.droid.shortvideo.gl.b.a.b
        public void a() {
            if (q.this.N != null) {
                q.this.N.onSurfaceDestroy();
            }
            if (q.this.av != null) {
                q.this.av.f();
                q.this.av = null;
            }
        }

        @Override // com.qiniu.pili.droid.shortvideo.gl.b.a.b
        public void a(int i, int i2) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.s;
            eVar.c("ShortVideoTranscoderCore", "surface changed width: " + i + " height: " + i2);
            if (q.this.N != null) {
                q.this.N.onSurfaceChanged(i, i2);
            }
        }

        @Override // com.qiniu.pili.droid.shortvideo.gl.b.a.b
        public void a(Object obj, Surface surface) {
            if (q.this.e()) {
                q qVar = q.this;
                qVar.r = new com.qiniu.pili.droid.shortvideo.d.a(qVar.j, q.this.m);
            } else {
                q qVar2 = q.this;
                qVar2.r = new com.qiniu.pili.droid.shortvideo.d.b(qVar2.j, q.this.m);
            }
            q.this.r.a(surface);
            q.this.r.a(q.this.aB);
            q.this.r.a(q.this.aC);
            if (q.this.ae) {
                q.this.r.a(q.this.aD);
            }
            q.this.r.a(q.this.R, q.this.S, q.this.ae);
            if (q.this.N != null) {
                q.this.N.onSurfaceCreated();
            }
        }

        @Override // com.qiniu.pili.droid.shortvideo.gl.b.a.b
        public void b() {
            d();
        }
    };
    private b.c aB = new b.c() { // from class: com.qiniu.pili.droid.shortvideo.core.q.10
        @Override // com.qiniu.pili.droid.shortvideo.d.b.c
        public void a(ByteBuffer byteBuffer, int i, long j, long j2, boolean z) {
            if (z) {
                com.qiniu.pili.droid.shortvideo.f.e.s.c("ShortVideoTranscoderCore", "received eos frame, mark video encoder to stop.");
                q.this.x.c();
            } else {
                com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.s;
                eVar.b("ShortVideoTranscoderCore", "extracted video frame count: " + q.ah(q.this) + " timestampUs " + j);
                synchronized (q.this.g) {
                    while (!q.this.d) {
                        try {
                            q.this.g.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    q.this.d = false;
                }
                if (q.this.ae) {
                    q.this.M.onProgressUpdate((((float) j) * 1.0f) / ((float) q.this.T));
                }
            }
            if (q.this.ae && q.this.k()) {
                com.qiniu.pili.droid.shortvideo.f.e.s.e("ShortVideoTranscoderCore", "low memory to reverse, process has been canceled !");
                q.this.M.onSaveVideoFailed(15);
                q.this.a();
            }
            if (q.this.O) {
                com.qiniu.pili.droid.shortvideo.f.e.s.c("ShortVideoTranscoderCore", "received cancel, mark video encoder to stop.");
                q.this.i();
            }
        }
    };
    private b.a aC = new b.a() { // from class: com.qiniu.pili.droid.shortvideo.core.q.11
        @Override // com.qiniu.pili.droid.shortvideo.d.b.a
        public void a(int i) {
            if (i == 16) {
                com.qiniu.pili.droid.shortvideo.f.e.s.d("ShortVideoTranscoderCore", "not support multiple media codec!");
                q.this.P = true;
                q.this.a();
                q.this.i();
            } else if (i != 20) {
                q.this.a(i, true);
            } else {
                com.qiniu.pili.droid.shortvideo.f.e.s.d("ShortVideoTranscoderCore", "decode exception!");
                q.this.a(i, false);
            }
        }
    };
    private b.e aD = new b.e() { // from class: com.qiniu.pili.droid.shortvideo.core.q.2
        @Override // com.qiniu.pili.droid.shortvideo.d.b.e
        public void a(int i) {
            synchronized (q.this.h) {
                q.this.ad = i;
                q.this.f = true;
                q.this.h.notify();
            }
        }
    };
    private final PLVideoSaveListener aE = new PLVideoSaveListener() { // from class: com.qiniu.pili.droid.shortvideo.core.q.3
        @Override // com.qiniu.pili.droid.shortvideo.PLVideoSaveListener
        public void onProgressUpdate(float f) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.s;
            eVar.c("ShortVideoTranscoderCore", "onProgressUpdate: " + f);
        }

        @Override // com.qiniu.pili.droid.shortvideo.PLVideoSaveListener
        public void onSaveVideoCanceled() {
            com.qiniu.pili.droid.shortvideo.f.e.s.c("ShortVideoTranscoderCore", "onSaveVideoCanceled");
        }

        @Override // com.qiniu.pili.droid.shortvideo.PLVideoSaveListener
        public void onSaveVideoFailed(int i) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.s;
            eVar.c("ShortVideoTranscoderCore", "onSaveVideoFailed: " + i);
        }

        @Override // com.qiniu.pili.droid.shortvideo.PLVideoSaveListener
        public void onSaveVideoSuccess(String str) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.s;
            eVar.c("ShortVideoTranscoderCore", "onSaveVideoSuccess: " + str);
        }
    };

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/core/q$a.class */
    class a implements b.c {
        private boolean b;

        /* renamed from: c  reason: collision with root package name */
        private int f27612c;

        private a() {
            this.b = false;
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x003b A[Catch: all -> 0x0060, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x000a, B:7:0x0018, B:9:0x0023, B:14:0x003b, B:17:0x005d, B:15:0x0047), top: B:27:0x000a }] */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0047 A[Catch: all -> 0x0060, TRY_ENTER, TryCatch #0 {, blocks: (B:4:0x000a, B:7:0x0018, B:9:0x0023, B:14:0x003b, B:17:0x005d, B:15:0x0047), top: B:27:0x000a }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private boolean a() {
            /*
                r4 = this;
                r0 = r4
                com.qiniu.pili.droid.shortvideo.core.q r0 = com.qiniu.pili.droid.shortvideo.core.q.this
                java.lang.Object r0 = com.qiniu.pili.droid.shortvideo.core.q.ap(r0)
                r6 = r0
                r0 = r6
                monitor-enter(r0)
                r0 = r4
                com.qiniu.pili.droid.shortvideo.core.q r0 = com.qiniu.pili.droid.shortvideo.core.q.this     // Catch: java.lang.Throwable -> L60
                com.qiniu.pili.droid.shortvideo.encode.c r0 = com.qiniu.pili.droid.shortvideo.core.q.l(r0)     // Catch: java.lang.Throwable -> L60
                boolean r0 = r0.l()     // Catch: java.lang.Throwable -> L60
                if (r0 == 0) goto L35
            L17:
                r0 = r4
                com.qiniu.pili.droid.shortvideo.core.q r0 = com.qiniu.pili.droid.shortvideo.core.q.this     // Catch: java.lang.Throwable -> L60
                boolean r0 = com.qiniu.pili.droid.shortvideo.core.q.at(r0)     // Catch: java.lang.Throwable -> L60
                r5 = r0
                r0 = r5
                if (r0 != 0) goto L30
                r0 = r4
                com.qiniu.pili.droid.shortvideo.core.q r0 = com.qiniu.pili.droid.shortvideo.core.q.this     // Catch: java.lang.Throwable -> L60 java.lang.InterruptedException -> L65
                java.lang.Object r0 = com.qiniu.pili.droid.shortvideo.core.q.ap(r0)     // Catch: java.lang.Throwable -> L60 java.lang.InterruptedException -> L65
                r0.wait()     // Catch: java.lang.Throwable -> L60 java.lang.InterruptedException -> L65
                goto L17
            L30:
                r0 = 1
                r5 = r0
                goto L37
            L35:
                r0 = 0
                r5 = r0
            L37:
                r0 = r5
                if (r0 == 0) goto L47
                r0 = r4
                com.qiniu.pili.droid.shortvideo.core.q r0 = com.qiniu.pili.droid.shortvideo.core.q.this     // Catch: java.lang.Throwable -> L60
                r1 = 0
                boolean r0 = com.qiniu.pili.droid.shortvideo.core.q.d(r0, r1)     // Catch: java.lang.Throwable -> L60
                goto L5c
            L47:
                r0 = r4
                com.qiniu.pili.droid.shortvideo.core.q r0 = com.qiniu.pili.droid.shortvideo.core.q.this     // Catch: java.lang.Throwable -> L60
                com.qiniu.pili.droid.shortvideo.d.b r0 = com.qiniu.pili.droid.shortvideo.core.q.ao(r0)     // Catch: java.lang.Throwable -> L60
                boolean r0 = r0.c()     // Catch: java.lang.Throwable -> L60
                com.qiniu.pili.droid.shortvideo.f.e r0 = com.qiniu.pili.droid.shortvideo.f.e.s     // Catch: java.lang.Throwable -> L60
                java.lang.String r1 = "ShortVideoTranscoderCore"
                java.lang.String r2 = "src audio eof, so stop music audio too."
                r0.c(r1, r2)     // Catch: java.lang.Throwable -> L60
            L5c:
                r0 = r6
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L60
                r0 = r5
                return r0
            L60:
                r7 = move-exception
                r0 = r6
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L60
                r0 = r7
                throw r0
            L65:
                r7 = move-exception
                goto L35
            */
            throw new UnsupportedOperationException("Method not decompiled: com.qiniu.pili.droid.shortvideo.core.q.a.a():boolean");
        }

        private boolean a(ByteBuffer byteBuffer, int i) {
            if (this.b || a()) {
                while (q.this.ag.a(q.this.ah, q.this.ai)) {
                    b();
                    if (!a()) {
                        return false;
                    }
                }
                q.this.ag.b(byteBuffer, i);
                this.b = true;
                return true;
            }
            return false;
        }

        private void b() {
            synchronized (q.this.am) {
                q.this.al = true;
                q.this.am.notify();
            }
        }

        @Override // com.qiniu.pili.droid.shortvideo.d.b.c
        public void a(ByteBuffer byteBuffer, int i, long j, long j2, boolean z) {
            if (this.f27612c == 0) {
                q qVar = q.this;
                this.f27612c = qVar.b(qVar.o);
            }
            int a2 = q.this.a(byteBuffer, i, this.f27612c);
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.s;
            eVar.b("ShortVideoTranscoderCore", "music audio frame size: " + a2 + " ts: " + j + " eof: " + z);
            q.this.u = Thread.currentThread();
            if (!z) {
                a(byteBuffer, a2);
                return;
            }
            com.qiniu.pili.droid.shortvideo.f.e.s.c("ShortVideoTranscoderCore", "music audio eof, keep producing silent frames for mixing until src audio end.");
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(byteBuffer.capacity());
            do {
            } while (a(allocateDirect, allocateDirect.capacity()));
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/core/q$b.class */
    class b implements b.c {
        private int b;

        private b() {
        }

        private void a() {
            synchronized (q.this.ak) {
                q.this.aj = true;
                q.this.ak.notify();
            }
        }

        private void b() {
            synchronized (q.this.am) {
                while (!q.this.al) {
                    try {
                        q.this.am.wait();
                    } catch (InterruptedException e) {
                        return;
                    }
                }
                q.this.al = false;
            }
        }

        @Override // com.qiniu.pili.droid.shortvideo.d.b.c
        public void a(ByteBuffer byteBuffer, int i, long j, long j2, boolean z) {
            if (this.b == 0) {
                q qVar = q.this;
                this.b = qVar.b(qVar.n);
            }
            int a2 = q.this.a(byteBuffer, i, this.b);
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.s;
            eVar.b("ShortVideoTranscoderCore", "src audio frame size: " + a2 + " ts: " + j + " eof: " + z);
            synchronized (q.this.ak) {
                if (!z) {
                    if (!q.this.O) {
                        q.this.ah = byteBuffer;
                        q.this.ai = a2;
                        a();
                        b();
                        if (q.this.ac != null) {
                            q.this.a(j2);
                        }
                        q.this.ab.c(byteBuffer, a2, j);
                        return;
                    }
                }
                com.qiniu.pili.droid.shortvideo.f.e eVar2 = com.qiniu.pili.droid.shortvideo.f.e.s;
                StringBuilder sb = new StringBuilder();
                sb.append("received ");
                sb.append(z ? com.umeng.analytics.pro.d.aB : com.anythink.expressad.d.a.b.dO);
                sb.append(", mark audio encoder to stop.");
                eVar2.c("ShortVideoTranscoderCore", sb.toString());
                q.this.s.c();
                q.this.y.c();
                if (q.this.u != null) {
                    q.this.u.interrupt();
                }
            }
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/core/q$c.class */
    class c implements b.c {
        private int b;

        private c() {
        }

        @Override // com.qiniu.pili.droid.shortvideo.d.b.c
        public void a(ByteBuffer byteBuffer, int i, long j, long j2, boolean z) {
            if (this.b == 0) {
                this.b = q.this.b(q.this.n != null ? q.this.n : q.this.o);
            }
            int a2 = q.this.a(byteBuffer, i, this.b);
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.s;
            eVar.b("ShortVideoTranscoderCore", "audio frame size: " + a2 + " ts: " + j2 + " eof: " + z);
            if (!z && !q.this.O && (q.this.t == null || j2 < q.this.T)) {
                if (q.this.ac != null) {
                    q.this.a(j2);
                }
                q.this.ab.c(byteBuffer, a2, j2);
                return;
            }
            String str = z ? com.umeng.analytics.pro.d.aB : q.this.O ? com.anythink.expressad.d.a.b.dO : "music exceed video duration";
            com.qiniu.pili.droid.shortvideo.f.e eVar2 = com.qiniu.pili.droid.shortvideo.f.e.s;
            eVar2.c("ShortVideoTranscoderCore", "received " + str + ", mark audio encoder to stop.");
            if (q.this.s != null) {
                q.this.s.c();
            }
            if (q.this.t != null) {
                q.this.t.c();
            }
            q.this.y.c();
        }
    }

    public q(Context context, String str, String str2) {
        com.qiniu.pili.droid.shortvideo.f.e.s.c("ShortVideoTranscoderCore", "init +");
        Context applicationContext = context.getApplicationContext();
        this.f27593a = applicationContext;
        l.a(applicationContext);
        QosManager.a().a(QosManager.KeyPoint.transcode_init);
        this.b = str;
        this.f27595c = l.a(this.f27593a, str2);
        this.R = 0L;
        long a2 = com.qiniu.pili.droid.shortvideo.f.g.a((Object) this.b) * 1000;
        this.S = a2;
        this.T = a2;
        this.af = com.qiniu.pili.droid.shortvideo.f.g.b(this.b) * com.qiniu.pili.droid.shortvideo.f.g.c(this.b) * 4;
        com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.s;
        eVar.c("ShortVideoTranscoderCore", "transcode from: " + str + " to " + str2);
        com.qiniu.pili.droid.shortvideo.f.e.s.c("ShortVideoTranscoderCore", "init -");
    }

    static /* synthetic */ int L(q qVar) {
        int i = qVar.K + 1;
        qVar.K = i;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(ByteBuffer byteBuffer, int i, int i2) {
        if (i2 == -1 || i >= i2 || byteBuffer.capacity() < i2) {
            return i;
        }
        byteBuffer.position(0);
        byteBuffer.limit(i2);
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.qiniu.pili.droid.shortvideo.gl.c.d a(PLWatermarkSetting pLWatermarkSetting, int i, int i2) {
        Bitmap bitmap = pLWatermarkSetting.getBitmap();
        Bitmap bitmap2 = bitmap;
        if (bitmap == null) {
            bitmap2 = BitmapFactory.decodeResource(this.f27593a.getResources(), pLWatermarkSetting.getResourceId());
        }
        com.qiniu.pili.droid.shortvideo.gl.c.d dVar = new com.qiniu.pili.droid.shortvideo.gl.c.d(bitmap2);
        dVar.a(pLWatermarkSetting.getAlpha() / 255.0f);
        dVar.b(pLWatermarkSetting.getX(), pLWatermarkSetting.getY());
        if (pLWatermarkSetting.getWidth() > 0.0f && pLWatermarkSetting.getHeight() > 0.0f) {
            dVar.a(pLWatermarkSetting.getWidth(), pLWatermarkSetting.getHeight());
        }
        dVar.a(i, i2);
        dVar.b();
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3) {
        b(i, i2, i3);
        if (this.F == null) {
            PLVideoEncodeSetting pLVideoEncodeSetting = new PLVideoEncodeSetting(this.f27593a);
            this.F = pLVideoEncodeSetting;
            pLVideoEncodeSetting.setEncodingBitrate(i3);
            if (this.m.containsKey(MediaFormat.KEY_FRAME_RATE)) {
                int integer = this.m.getInteger(MediaFormat.KEY_FRAME_RATE);
                int i4 = this.E;
                boolean z = i4 > 0 && integer > i4;
                PLVideoEncodeSetting pLVideoEncodeSetting2 = this.F;
                if (z) {
                    integer = this.E;
                }
                pLVideoEncodeSetting2.setEncodingFps(integer);
            }
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.s;
            eVar.c("ShortVideoTranscoderCore", "config video encoder: " + this.F.getVideoEncodingFps() + " fps");
            if (this.m.containsKey(MediaFormat.KEY_I_FRAME_INTERVAL)) {
                PLVideoEncodeSetting pLVideoEncodeSetting3 = this.F;
                pLVideoEncodeSetting3.setIFrameInterval(pLVideoEncodeSetting3.getVideoEncodingFps() * this.m.getInteger(MediaFormat.KEY_I_FRAME_INTERVAL));
            }
            com.qiniu.pili.droid.shortvideo.f.e eVar2 = com.qiniu.pili.droid.shortvideo.f.e.s;
            eVar2.c("ShortVideoTranscoderCore", "config video encoder: I Interval:" + this.F.getIFrameInterval());
        }
        int d = this.V != 0 ? this.X : com.qiniu.pili.droid.shortvideo.f.g.d(this.b);
        int i5 = d;
        if (h()) {
            i5 = c(d);
        }
        PLVideoEncodeSetting pLVideoEncodeSetting4 = this.F;
        int i6 = (i5 == 0 || i5 == 180) ? i : i2;
        if (i5 == 0 || i5 == 180) {
            i = i2;
        }
        pLVideoEncodeSetting4.setPreferredEncodingSize(i6, i);
        if (this.m.containsKey(MediaFormat.KEY_PROFILE) && this.m.getInteger(MediaFormat.KEY_PROFILE) == 8) {
            this.F.setProfileMode(PLVideoEncodeSetting.ProfileMode.BASELINE);
            this.F.setEncodingBitrateMode(PLVideoEncodeSetting.BitrateMode.CONSTANT_QUALITY_PRIORITY);
            com.qiniu.pili.droid.shortvideo.f.e.s.c("ShortVideoTranscoderCore", "source video's profile is high, change it to baseline and set bitrate mode to CONSTANT_QUALITY_PRIORITY !");
        }
        com.qiniu.pili.droid.shortvideo.encode.e eVar3 = new com.qiniu.pili.droid.shortvideo.encode.e(this.F);
        this.x = eVar3;
        eVar3.a(this.ay);
        this.x.a(this.aa);
        this.x.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z) {
        com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.s;
        eVar.e("ShortVideoTranscoderCore", "exceptionalStop + " + i);
        this.Q = i;
        a();
        if (z) {
            g();
        }
        com.qiniu.pili.droid.shortvideo.f.e eVar2 = com.qiniu.pili.droid.shortvideo.f.e.s;
        eVar2.e("ShortVideoTranscoderCore", "exceptionalStop - " + i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        double d;
        Iterator<PLSpeedTimeRange> it = this.ac.iterator();
        while (true) {
            if (!it.hasNext()) {
                d = 1.0d;
                break;
            }
            PLSpeedTimeRange next = it.next();
            if (next.isIncludeTimeUs(j)) {
                d = next.getSpeed();
                break;
            }
        }
        if (this.ab.a() != d) {
            this.ab.b();
            this.ab.a(d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MediaFormat mediaFormat) {
        int integer = mediaFormat.getInteger(MediaFormat.KEY_SAMPLE_RATE);
        int integer2 = mediaFormat.getInteger(MediaFormat.KEY_CHANNEL_COUNT);
        int integer3 = mediaFormat.containsKey(MediaFormat.KEY_BIT_RATE) ? mediaFormat.getInteger(MediaFormat.KEY_BIT_RATE) : 44100;
        PLAudioEncodeSetting pLAudioEncodeSetting = new PLAudioEncodeSetting();
        pLAudioEncodeSetting.setSampleRate(integer);
        pLAudioEncodeSetting.setChannels(integer2);
        pLAudioEncodeSetting.setBitrate(integer3);
        com.qiniu.pili.droid.shortvideo.encode.c cVar = new com.qiniu.pili.droid.shortvideo.encode.c(pLAudioEncodeSetting);
        this.y = cVar;
        cVar.a(this.az);
        this.y.a();
        synchronized (this.z) {
            while (!this.A) {
                try {
                    this.z.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final MediaFormat mediaFormat, b.c cVar) {
        long a2 = this.L.e().a();
        long b2 = this.L.e().b();
        if (e()) {
            this.t = new com.qiniu.pili.droid.shortvideo.d.a(this.l, mediaFormat);
        } else {
            this.t = new com.qiniu.pili.droid.shortvideo.d.b(this.l, mediaFormat);
        }
        this.t.a(cVar);
        this.t.a(new b.d() { // from class: com.qiniu.pili.droid.shortvideo.core.q.6
            @Override // com.qiniu.pili.droid.shortvideo.d.b.d
            public void a(MediaFormat mediaFormat2) {
                if (mediaFormat2 != null && !mediaFormat2.containsKey(MediaFormat.KEY_BIT_RATE) && mediaFormat.containsKey(MediaFormat.KEY_BIT_RATE)) {
                    mediaFormat2.setInteger(MediaFormat.KEY_BIT_RATE, mediaFormat.getInteger(MediaFormat.KEY_BIT_RATE));
                }
                com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.s;
                eVar.c("ShortVideoTranscoderCore", "got music audio decoder format: " + mediaFormat2);
                if (q.this.s == null) {
                    q.this.a(mediaFormat2);
                    return;
                }
                synchronized (q.this.q) {
                    while (q.this.p == null) {
                        try {
                            q.this.q.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                q.this.ag = new AudioMixer();
                q.this.ag.a(q.this.p.getInteger(MediaFormat.KEY_SAMPLE_RATE), q.this.p.getInteger(MediaFormat.KEY_CHANNEL_COUNT), mediaFormat2.getInteger(MediaFormat.KEY_SAMPLE_RATE), mediaFormat2.getInteger(MediaFormat.KEY_CHANNEL_COUNT));
                q.this.ag.a(q.this.L.f().a(), q.this.L.f().b());
            }
        });
        this.t.a(this.L.b());
        this.t.a(a2 * 1000, b2 * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final MediaFormat mediaFormat, b.c cVar, final MediaFormat mediaFormat2) {
        if (e()) {
            this.s = new com.qiniu.pili.droid.shortvideo.d.a(this.k, mediaFormat);
        } else {
            this.s = new com.qiniu.pili.droid.shortvideo.d.b(this.k, mediaFormat);
        }
        this.s.a(cVar);
        this.s.a(new b.d() { // from class: com.qiniu.pili.droid.shortvideo.core.q.5
            @Override // com.qiniu.pili.droid.shortvideo.d.b.d
            public void a(MediaFormat mediaFormat3) {
                if (mediaFormat3 != null && !mediaFormat3.containsKey(MediaFormat.KEY_BIT_RATE) && mediaFormat.containsKey(MediaFormat.KEY_BIT_RATE)) {
                    mediaFormat3.setInteger(MediaFormat.KEY_BIT_RATE, mediaFormat.getInteger(MediaFormat.KEY_BIT_RATE));
                }
                com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.s;
                eVar.c("ShortVideoTranscoderCore", "got src audio decoder format: " + mediaFormat3);
                synchronized (q.this.q) {
                    q.this.p = mediaFormat3;
                    q.this.q.notify();
                }
                q.this.a(mediaFormat3);
                MediaFormat mediaFormat4 = mediaFormat2;
                if (mediaFormat4 != null) {
                    q qVar = q.this;
                    qVar.a(mediaFormat4, new a());
                }
            }
        });
        this.s.a(this.R, this.S);
    }

    private boolean a(String str) {
        String[] strArr = com.qiniu.pili.droid.shortvideo.core.c.b;
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            if (strArr[i2].equals(str)) {
                return true;
            }
            i = i2 + 1;
        }
    }

    static /* synthetic */ int ae(q qVar) {
        int i = qVar.J + 1;
        qVar.J = i;
        return i;
    }

    static /* synthetic */ int ah(q qVar) {
        int i = qVar.I + 1;
        qVar.I = i;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(MediaFormat mediaFormat) {
        if (mediaFormat != null && mediaFormat.containsKey(MediaFormat.KEY_MIME) && mediaFormat.getString(MediaFormat.KEY_MIME).equals("audio/mp4a-latm") && mediaFormat.containsKey(MediaFormat.KEY_CHANNEL_COUNT)) {
            return mediaFormat.getInteger(MediaFormat.KEY_CHANNEL_COUNT) * 2 * 1024;
        }
        return -1;
    }

    private void b(int i, int i2, int i3) {
        MediaMetadataRetriever mediaMetadataRetriever;
        if (this.m == null) {
            return;
        }
        try {
            this.ax.put("transcode_time", System.currentTimeMillis());
            this.ax.put("original_video_size", this.m.getInteger("width") + " X " + this.m.getInteger("height"));
            String valueOf = this.m.containsKey(MediaFormat.KEY_BIT_RATE) ? String.valueOf(this.m.getInteger(MediaFormat.KEY_BIT_RATE)) : null;
            if (valueOf == null) {
                mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.b);
                valueOf = mediaMetadataRetriever.extractMetadata(20);
            } else {
                mediaMetadataRetriever = null;
            }
            String str = valueOf;
            if (valueOf == null) {
                str = com.igexin.push.core.b.l;
            }
            this.ax.put("original_bitrate", str);
            String str2 = null;
            if (this.m.containsKey(MediaFormat.KEY_DURATION)) {
                str2 = String.valueOf(this.m.getLong(MediaFormat.KEY_DURATION) / 1000);
            }
            String str3 = str2;
            if (str2 == null) {
                MediaMetadataRetriever mediaMetadataRetriever2 = mediaMetadataRetriever;
                if (mediaMetadataRetriever == null) {
                    mediaMetadataRetriever2 = new MediaMetadataRetriever();
                    mediaMetadataRetriever2.setDataSource(this.b);
                }
                str3 = mediaMetadataRetriever2.extractMetadata(9);
            }
            this.ax.put("duration", str3 == null ? com.igexin.push.core.b.l : str3);
            this.ax.put("dst_video_size", i + " X " + i2);
            this.ax.put("dst_bitrate", i3 + "");
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c(int i) {
        return com.qiniu.pili.droid.shortvideo.f.j.b(i + this.Y);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<Long> c(List<Long> list) {
        LinkedList linkedList = new LinkedList();
        long longValue = list.get(list.size() - 1).longValue();
        Collections.reverse(list);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return linkedList;
            }
            linkedList.add(Long.valueOf(longValue - list.get(i2).longValue()));
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setInteger(MediaFormat.KEY_SAMPLE_RATE, 44100);
        mediaFormat.setInteger(MediaFormat.KEY_CHANNEL_COUNT, 1);
        a(mediaFormat);
        MultiAudioMixer multiAudioMixer = new MultiAudioMixer();
        this.ao = multiAudioMixer;
        multiAudioMixer.a(this.an, new MultiAudioMixer.a() { // from class: com.qiniu.pili.droid.shortvideo.core.q.4
            @Override // com.qiniu.pili.droid.shortvideo.process.audio.MultiAudioMixer.a
            public void a() {
                q.this.y.c();
            }

            @Override // com.qiniu.pili.droid.shortvideo.process.audio.MultiAudioMixer.a
            public void a(int i) {
                com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.q;
                eVar.d("multi audio mix failed error : " + i);
                q.this.y.c();
            }

            @Override // com.qiniu.pili.droid.shortvideo.process.audio.MultiAudioMixer.a
            public void a(byte[] bArr, long j) {
                q.this.y.a(ByteBuffer.wrap(bArr), bArr.length, j);
            }
        });
    }

    private void d() {
        long j = this.S - this.R;
        this.T = j;
        ArrayList<PLSpeedTimeRange> arrayList = this.ac;
        if (arrayList != null) {
            Iterator<PLSpeedTimeRange> it = arrayList.iterator();
            while (it.hasNext()) {
                PLSpeedTimeRange next = it.next();
                this.T = (this.T - (next.getRangeTimeMs() * 1000)) + ((long) ((next.getRangeTimeMs() * 1000) / next.getSpeed()));
            }
        } else {
            this.T = (long) (j / this.aa);
        }
        com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.s;
        eVar.c("ShortVideoTranscoderCore", "mDurationUs is updated to : " + this.T);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        return (Build.VERSION.SDK_INT < 23 || this.ae || a(com.qiniu.pili.droid.shortvideo.f.j.b())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        synchronized (this) {
            com.qiniu.pili.droid.shortvideo.f.e.s.c("ShortVideoTranscoderCore", "startMuxer +");
            if (this.O) {
                com.qiniu.pili.droid.shortvideo.f.e.s.c("ShortVideoTranscoderCore", "transcode is already canceled");
                return;
            }
            int i = this.C + 1;
            this.C = i;
            if (this.y != null && i < 2) {
                com.qiniu.pili.droid.shortvideo.f.e.s.c("ShortVideoTranscoderCore", "not ready to start muxer.");
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return;
            }
            com.qiniu.pili.droid.shortvideo.muxer.b bVar = new com.qiniu.pili.droid.shortvideo.muxer.b();
            this.B = bVar;
            if (bVar.a(this.f27595c, this.v, this.w, 0)) {
                com.qiniu.pili.droid.shortvideo.f.e.s.c("ShortVideoTranscoderCore", "start muxer success!");
                notify();
            } else {
                com.qiniu.pili.droid.shortvideo.f.e.s.e("ShortVideoTranscoderCore", "start muxer failed!");
                a();
            }
            com.qiniu.pili.droid.shortvideo.f.e.s.c("ShortVideoTranscoderCore", "startMuxer -");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        synchronized (this) {
            com.qiniu.pili.droid.shortvideo.f.e.s.c("ShortVideoTranscoderCore", "stopMuxer +");
            boolean z = true;
            int i = this.D + 1;
            this.D = i;
            if (this.y != null && i < 2) {
                com.qiniu.pili.droid.shortvideo.f.e.s.c("ShortVideoTranscoderCore", "not ready to stop muxer.");
                return;
            }
            if (this.B == null || !this.B.a()) {
                z = false;
            }
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.s;
            StringBuilder sb = new StringBuilder();
            sb.append("stop muxer ");
            sb.append(z ? bw.o : bc.b.S);
            eVar.c("ShortVideoTranscoderCore", sb.toString());
            this.B = null;
            this.x = null;
            this.y = null;
            this.ao = null;
            this.j = null;
            this.k = null;
            this.l = null;
            this.r = null;
            this.s = null;
            this.t = null;
            this.G = null;
            this.ag = null;
            this.ah = null;
            this.ab = null;
            this.v = null;
            this.w = null;
            this.m = null;
            this.n = null;
            this.o = null;
            this.p = null;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            this.C = 0;
            this.D = 0;
            this.ap = 0L;
            this.aq = 0L;
            this.ae = false;
            this.H = false;
            this.A = false;
            if (this.O) {
                this.O = false;
                new File(this.f27595c).delete();
                if (!this.P && !j()) {
                    this.M.onSaveVideoCanceled();
                } else if (j()) {
                    int i2 = this.Q;
                    this.Q = -1;
                    this.M.onSaveVideoFailed(i2);
                    QosManager.a().a(i2);
                }
            } else {
                this.M.onProgressUpdate(1.0f);
                if (z) {
                    this.M.onSaveVideoSuccess(this.f27595c);
                    try {
                        this.ax.put("transcode_time", System.currentTimeMillis() - this.ax.getLong("transcode_time"));
                        this.ax.put("data_type", QosManager.a.transcode);
                        QosManager.a().a(this.ax);
                    } catch (Exception e) {
                    }
                } else {
                    this.M.onSaveVideoFailed(3);
                    QosManager.a().a(3);
                }
            }
            if (this.P) {
                this.P = false;
                this.M.onSaveVideoFailed(16);
                QosManager.a().a(16);
            }
            com.qiniu.pili.droid.shortvideo.f.e.s.c("ShortVideoTranscoderCore", "stopMuxer -");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        int abs = Math.abs(this.Y);
        return abs == 90 || abs == 180 || abs == 270;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        com.qiniu.pili.droid.shortvideo.f.e.s.c("ShortVideoTranscoderCore", "stopVideoStuff");
        if (this.ae) {
            this.G.c();
        }
        this.r.c();
        this.x.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j() {
        return this.Q >= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k() {
        ActivityManager activityManager = (ActivityManager) this.f27593a.getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        long j = this.af * 10;
        boolean z = (memoryInfo.availMem - memoryInfo.threshold) - j <= 0;
        com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.s;
        StringBuilder sb = new StringBuilder();
        sb.append("availMem: ");
        long j2 = memoryInfo.availMem;
        long j3 = 1048576;
        sb.append(j2 / j3);
        sb.append("M, threshold: ");
        sb.append(memoryInfo.threshold / j3);
        sb.append("M, leftMem: ");
        sb.append((memoryInfo.availMem - memoryInfo.threshold) / j3);
        sb.append("M, safeMem: ");
        sb.append(j / j3);
        sb.append("M, oneFrame: ");
        sb.append(this.af / 1048576);
        eVar.b("ShortVideoTranscoderCore", sb.toString());
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l() {
        List<PLMixAudioFile> list = this.an;
        return list != null && list.size() >= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        synchronized (this) {
            this.M.onProgressUpdate(((float) (this.aq + this.ap)) / ((float) (this.T * 2)));
        }
    }

    public void a() {
        synchronized (this) {
            if (this.H) {
                com.qiniu.pili.droid.shortvideo.f.e.s.c("ShortVideoTranscoderCore", "cancelTranscode");
                this.O = true;
                if (this.ao != null) {
                    this.ao.a();
                }
                notify();
            } else {
                com.qiniu.pili.droid.shortvideo.f.e.s.d("ShortVideoTranscoderCore", "cancelTranscode failed");
            }
        }
    }

    public void a(double d) {
        this.ac = null;
        this.aa = d;
        d();
    }

    public void a(int i) {
        this.Z = i;
    }

    public void a(int i, int i2, int i3, int i4) {
        if (u.a().a(b.a.transcode_clip_video)) {
            this.f27594ar = i;
            this.as = i2;
            this.at = i3;
            this.au = i4;
        }
    }

    public void a(int i, int i2, int i3, PLVideoFilterListener pLVideoFilterListener, boolean z) {
        this.V = i;
        this.W = i2;
        this.X = i3;
        a(pLVideoFilterListener, z);
    }

    public void a(long j, long j2) {
        this.R = j;
        this.S = j2;
        d();
        com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.s;
        eVar.c("ShortVideoTranscoderCore", "set range to: " + j + "-" + j2 + " duration: " + this.T);
    }

    public void a(PLVideoEncodeSetting pLVideoEncodeSetting) {
        this.F = pLVideoEncodeSetting;
    }

    public void a(PLVideoFilterListener pLVideoFilterListener, boolean z) {
        this.N = pLVideoFilterListener;
        this.U = z;
    }

    public void a(PLWatermarkSetting pLWatermarkSetting) {
        this.aw = pLWatermarkSetting;
    }

    public void a(com.qiniu.pili.droid.shortvideo.transcoder.audio.a aVar) {
        this.L = aVar;
    }

    public void a(Object obj) {
        this.i = obj;
    }

    public void a(String str, long j, long j2, boolean z) {
        com.qiniu.pili.droid.shortvideo.transcoder.audio.a aVar = new com.qiniu.pili.droid.shortvideo.transcoder.audio.a();
        aVar.a(str);
        aVar.a(z);
        aVar.a((int) com.qiniu.pili.droid.shortvideo.f.g.a((Object) str));
        aVar.a(new com.qiniu.pili.droid.shortvideo.transcoder.audio.d(j, j2));
        a(aVar);
    }

    public void a(List<PLSpeedTimeRange> list) {
        this.ac = new ArrayList<>(list);
        this.aa = 1.0d;
        d();
        com.qiniu.pili.droid.shortvideo.f.e.s.c("ShortVideoTranscoderCore", "setSpeedTimeRanges : reset mSpeed to 1.0 ");
    }

    public void a(boolean z) {
        com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.s;
        eVar.c("ShortVideoTranscoderCore", "setMuteEnabled: " + z);
        this.e = z;
    }

    public boolean a(int i, int i2, int i3, int i4, PLVideoSaveListener pLVideoSaveListener) {
        if (u.a().a(b.a.transcode_rotate, pLVideoSaveListener)) {
            this.Y = i4;
            return a(i, i2, i3, pLVideoSaveListener);
        }
        return false;
    }

    public boolean a(int i, int i2, int i3, int i4, boolean z, PLVideoSaveListener pLVideoSaveListener) {
        if (u.a().a(b.a.reverse_video, pLVideoSaveListener)) {
            this.Y = i4;
            return a(i, i2, i3, z, pLVideoSaveListener);
        }
        return false;
    }

    public boolean a(int i, int i2, final int i3, PLVideoSaveListener pLVideoSaveListener) {
        synchronized (this) {
            com.qiniu.pili.droid.shortvideo.f.e.s.c("ShortVideoTranscoderCore", "transcode +");
            PLVideoSaveListener pLVideoSaveListener2 = pLVideoSaveListener;
            if (pLVideoSaveListener == null) {
                pLVideoSaveListener2 = this.aE;
            }
            this.M = pLVideoSaveListener2;
            if (u.a().a(b.a.transcode_video, this.M)) {
                if (this.b.equals(this.f27595c)) {
                    com.qiniu.pili.droid.shortvideo.f.e.s.e("ShortVideoTranscoderCore", "the dst video path must be different with src video path, please check the constructor's param!");
                    this.M.onSaveVideoFailed(14);
                    return false;
                } else if (this.H) {
                    com.qiniu.pili.droid.shortvideo.f.e.s.e("ShortVideoTranscoderCore", "transcode already started +");
                    return false;
                } else {
                    this.H = true;
                    final int b2 = com.qiniu.pili.droid.shortvideo.f.g.b(i);
                    final int b3 = com.qiniu.pili.droid.shortvideo.f.g.b(i2);
                    com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.s;
                    eVar.c("ShortVideoTranscoderCore", "dst bitrate: " + i3 + " dst width: " + b2 + " dst height: " + b3 + " rotate by: " + this.Y);
                    MediaExtractor mediaExtractor = new MediaExtractor();
                    this.j = mediaExtractor;
                    try {
                        mediaExtractor.setDataSource(this.b);
                        final int a2 = com.qiniu.pili.droid.shortvideo.f.g.a(this.j, "video/");
                        if (a2 >= 0) {
                            new Thread(new Runnable() { // from class: com.qiniu.pili.droid.shortvideo.core.q.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    MediaFormat mediaFormat;
                                    MediaFormat mediaFormat2;
                                    MediaFormat mediaFormat3;
                                    q.this.j.selectTrack(a2);
                                    q qVar = q.this;
                                    qVar.m = qVar.j.getTrackFormat(a2);
                                    com.qiniu.pili.droid.shortvideo.f.e.s.c("ShortVideoTranscoderCore", "extracted src video format: " + q.this.m);
                                    q.this.j.seekTo(q.this.R, 0);
                                    q.this.j.seekTo(q.this.R, 0);
                                    if (q.this.ae) {
                                        mediaFormat = null;
                                        mediaFormat2 = null;
                                    } else if (q.this.l()) {
                                        q.this.c();
                                        q.this.a(b2, b3, i3);
                                        return;
                                    } else {
                                        if (q.this.e) {
                                            mediaFormat3 = null;
                                        } else {
                                            q qVar2 = q.this;
                                            qVar2.k = com.qiniu.pili.droid.shortvideo.f.g.a(qVar2.b);
                                            q qVar3 = q.this;
                                            MediaFormat a3 = com.qiniu.pili.droid.shortvideo.f.g.a(qVar3.k);
                                            qVar3.n = a3;
                                            mediaFormat3 = a3;
                                            if (a3 != null) {
                                                com.qiniu.pili.droid.shortvideo.f.e.s.c("ShortVideoTranscoderCore", "extracted src audio format: " + a3);
                                                mediaFormat3 = a3;
                                            }
                                        }
                                        if (q.this.L != null) {
                                            if (q.this.L.d()) {
                                                q qVar4 = q.this;
                                                qVar4.l = com.qiniu.pili.droid.shortvideo.f.g.a(qVar4.L.c());
                                            } else {
                                                q qVar5 = q.this;
                                                qVar5.l = com.qiniu.pili.droid.shortvideo.f.g.a(qVar5.L.a());
                                            }
                                            q qVar6 = q.this;
                                            MediaFormat a4 = com.qiniu.pili.droid.shortvideo.f.g.a(qVar6.l);
                                            qVar6.o = a4;
                                            mediaFormat = mediaFormat3;
                                            mediaFormat2 = a4;
                                            if (a4 != null) {
                                                com.qiniu.pili.droid.shortvideo.f.e.s.c("ShortVideoTranscoderCore", "extracted music format: " + a4);
                                                mediaFormat = mediaFormat3;
                                                mediaFormat2 = a4;
                                            }
                                        } else {
                                            mediaFormat2 = null;
                                            mediaFormat = mediaFormat3;
                                        }
                                    }
                                    if (mediaFormat != null && mediaFormat2 != null) {
                                        q qVar7 = q.this;
                                        qVar7.a(mediaFormat, new b(), mediaFormat2);
                                        com.qiniu.pili.droid.shortvideo.f.e.s.c("ShortVideoTranscoderCore", "start extracting src audio and music audio frames to mix");
                                    } else if (mediaFormat != null) {
                                        q qVar8 = q.this;
                                        qVar8.a(mediaFormat, new c(), (MediaFormat) null);
                                        com.qiniu.pili.droid.shortvideo.f.e.s.c("ShortVideoTranscoderCore", "start extracting src audio frames to reencode");
                                    } else if (mediaFormat2 != null) {
                                        q qVar9 = q.this;
                                        qVar9.a(mediaFormat2, new c());
                                        com.qiniu.pili.droid.shortvideo.f.e.s.c("ShortVideoTranscoderCore", "start extracting music audio frames to reencode");
                                    } else {
                                        com.qiniu.pili.droid.shortvideo.f.e.s.c("ShortVideoTranscoderCore", "dst file will have no audio");
                                    }
                                    q.this.a(b2, b3, i3);
                                    com.qiniu.pili.droid.shortvideo.f.e.s.c("ShortVideoTranscoderCore", "transcode -");
                                }
                            }).start();
                            return true;
                        }
                        com.qiniu.pili.droid.shortvideo.f.e.s.e("ShortVideoTranscoderCore", "cannot find video in file!");
                        this.M.onSaveVideoFailed(13);
                        return false;
                    } catch (IOException e) {
                        com.qiniu.pili.droid.shortvideo.f.e eVar2 = com.qiniu.pili.droid.shortvideo.f.e.s;
                        eVar2.e("ShortVideoTranscoderCore", "file video setDataSource failed: " + e.getMessage());
                        return false;
                    }
                }
            }
            return false;
        }
    }

    public boolean a(int i, int i2, int i3, boolean z, PLVideoSaveListener pLVideoSaveListener) {
        if (u.a().a(b.a.reverse_video, pLVideoSaveListener)) {
            this.ae = z;
            return a(i, i2, i3, pLVideoSaveListener);
        }
        return false;
    }

    public boolean a(PLVideoSaveListener pLVideoSaveListener) {
        int i = this.Z;
        int b2 = (i == 0 || i == 180) ? com.qiniu.pili.droid.shortvideo.f.g.b(this.b) : com.qiniu.pili.droid.shortvideo.f.g.c(this.b);
        int i2 = this.Z;
        return a(b2, (i2 == 0 || i2 == 180) ? com.qiniu.pili.droid.shortvideo.f.g.c(this.b) : com.qiniu.pili.droid.shortvideo.f.g.b(this.b), com.qiniu.pili.droid.shortvideo.f.g.e(this.b), pLVideoSaveListener);
    }

    public JSONObject b() {
        int i = this.at == 0 ? 0 : 1;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("operation_transcode_clip_video", i);
            jSONObject.put("operation_transcode_video", 1);
            jSONObject.put("data_type", QosManager.a.config);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public void b(int i) {
        if (i > 0) {
            this.E = i;
        }
    }

    public void b(List<PLMixAudioFile> list) {
        this.an = list;
    }
}
