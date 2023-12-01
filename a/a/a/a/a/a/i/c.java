package a.a.a.a.a.a.i;

import a.a.a.a.a.a.b;
import a.a.a.a.a.e.h;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.huawei.openalliance.ad.constant.bc;
import com.qiniu.pili.droid.streaming.StreamStatusCallback;
import com.qiniu.pili.droid.streaming.StreamingProfile;
import com.qiniu.pili.droid.streaming.av.common.PLAVFrame;
import com.qiniu.pili.droid.streaming.av.common.PLBufferInfo;
import com.qiniu.pili.droid.streaming.core.PLDroidStreamingCore;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/i/c.class */
public abstract class c {
    public d A;
    public StreamStatusCallback B;
    public boolean C;
    public boolean D;
    public ByteBuffer E;
    public int F;
    public BlockingDeque<g> G;
    public ArrayList<a.a.a.a.a.a.f.a> H;
    public a.a.a.a.a.a.f.a I;
    public volatile b J;
    public boolean K;
    public long L;
    public e M;
    public Context N;
    public boolean O;
    public Thread P;
    public f Q;
    public volatile boolean R;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public int f1241c;
    public int d;
    public int e;
    public byte[] f;
    public PLDroidStreamingCore g;
    public final Object h;
    public volatile boolean i;
    public boolean j;
    public volatile boolean k;
    public volatile boolean l;
    public volatile boolean m;
    public final Object n;
    public boolean o;
    public byte[] p;
    public byte[] q;
    public final int r;
    public final Object s;
    public volatile boolean t;
    public volatile boolean u;
    public int v;
    public long[] w;
    public long[] x;
    public a.a.a.a.a.a.b y;
    public d z;

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/i/c$a.class */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f1242a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x002f -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x002b -> B:15:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[EnumC0001c.values().length];
            f1242a = iArr;
            try {
                iArr[EnumC0001c.HLS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1242a[EnumC0001c.MPEG4.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f1242a[EnumC0001c.RTMP.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/i/c$b.class */
    public class b {
        public int A;
        public long B;

        /* renamed from: a  reason: collision with root package name */
        public boolean f1243a;
        public boolean b;

        /* renamed from: c  reason: collision with root package name */
        public long f1244c;
        public long d;
        public long e;
        public long f;
        public long g;
        public long h;
        public long i;
        public long j;
        public long k;
        public long l;
        public long m;
        public long n;
        public long o;
        public int p;
        public int q;
        public int r;
        public int s;
        public long t;
        public long u;
        public long v;
        public long w;
        public long x;
        public long y;
        public int z;

        public b(c cVar) {
        }
    }

    /* renamed from: a.a.a.a.a.a.i.c$c  reason: collision with other inner class name */
    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/i/c$c.class */
    public enum EnumC0001c {
        MPEG4,
        HLS,
        RTMP,
        INVALID
    }

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/i/c$d.class */
    public interface d {
        void a(PLAVFrame pLAVFrame, int i);
    }

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/i/c$e.class */
    public static class e extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<c> f1247a;

        public e(Looper looper, c cVar) {
            super(looper);
            this.f1247a = new WeakReference<>(cVar);
        }

        public void a() {
            getLooper().quit();
            this.f1247a.clear();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            c cVar = this.f1247a.get();
            if (cVar == null) {
                a.a.a.a.a.e.e.f.d("Muxer", "MuxerHandler.handleMessage: muxer is null");
            } else if (message.what != 0) {
            } else {
                int intervalMs = cVar.d().f().getStreamStatusConfig().getIntervalMs();
                cVar.g(intervalMs);
                StreamingProfile.StreamStatus streamStatus = cVar.d().f().getStreamStatus();
                if (cVar.B != null) {
                    cVar.B.notifyStreamStatusChanged(streamStatus);
                }
                b bVar = cVar.J;
                if (bVar.b && System.currentTimeMillis() - bVar.f1244c >= a.a.a.a.a.j.a.a().b()) {
                    bVar.d = System.currentTimeMillis();
                    Intent intent = new Intent("pldroid-qos-filter");
                    intent.putExtra("pldroid-qos-msg-type", 161);
                    intent.putExtra("beginAt", bVar.f1244c);
                    intent.putExtra("endAt", bVar.d);
                    intent.putExtra("audioFps", streamStatus.audioFps);
                    intent.putExtra("videoFps", streamStatus.videoFps);
                    intent.putExtra("audioBitrate", streamStatus.audioBitrate);
                    intent.putExtra("videoBitrate", streamStatus.videoBitrate);
                    intent.putExtra("audioSourceFps", bVar.p);
                    intent.putExtra("videoSourceFps", bVar.q);
                    intent.putExtra("dropAudioFrameNum", bVar.k);
                    intent.putExtra("dropVideoFrameNum", bVar.l);
                    intent.putExtra("video_buffer_dropped_frames", bVar.m);
                    intent.putExtra("sentAudioFps", bVar.r);
                    intent.putExtra("sentVideoFps", bVar.s);
                    a.a.a.a.a.j.a.a().a(intent);
                    bVar.f1244c = System.currentTimeMillis();
                }
                cVar.o();
                sendMessageDelayed(obtainMessage(0), intervalMs);
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/i/c$f.class */
    public class f extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public volatile boolean f1248a;

        /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/i/c$f$a.class */
        public class a implements PLDroidStreamingCore.b {
            public a() {
            }

            @Override // com.qiniu.pili.droid.streaming.core.PLDroidStreamingCore.b
            public void a(int i, String str) {
                c.this.l = true;
                c.this.a(i, i);
            }
        }

        public f() {
        }

        public void a() {
            this.f1248a = true;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            a.a.a.a.a.e.e eVar = a.a.a.a.a.e.e.f;
            eVar.c("Muxer", "starting muxing thread: " + getId());
            if (!a.a.a.a.a.k.b.a()) {
                a.a.a.a.a.k.b.a(c.this.N);
            }
            c.this.l = false;
            boolean p = c.this.p();
            synchronized (c.this.h) {
                if (this.f1248a) {
                    a.a.a.a.a.e.e.f.d("Muxer", "muxing thread got interrupted, return anyway.");
                    return;
                }
                c.this.k = p;
                if (c.this.k) {
                    a.a.a.a.a.e.e.f.e("Muxer", "Init streaming core failed.");
                    c.this.h.notify();
                    return;
                }
                c.this.i = true;
                c.this.h.notify();
                HandlerThread handlerThread = new HandlerThread("MuxerHt");
                handlerThread.start();
                c.this.M = new e(handlerThread.getLooper(), c.this);
                c.this.L = System.currentTimeMillis();
                c.this.d().a(b.c.READY, null);
                c.this.g.setOnErrorListener(new a());
                c.this.b();
                if (!c.this.l) {
                    c.this.a(0, 0);
                }
                c.this.q();
                c.this.m();
                c.this.d().a(b.c.SHUTDOWN, null);
                a.a.a.a.a.e.e.f.c("Muxer", "end muxing thread");
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/i/c$g.class */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        public PLBufferInfo f1250a;
        public int b;

        /* renamed from: c  reason: collision with root package name */
        public int f1251c;
        public PLAVFrame d;
        public long e;
        public String f;

        public g(int i, int i2, PLAVFrame pLAVFrame, PLBufferInfo pLBufferInfo) {
            this(i, i2, pLAVFrame, pLBufferInfo, null);
        }

        public g(int i, int i2, PLAVFrame pLAVFrame, PLBufferInfo pLBufferInfo, String str) {
            this.b = i;
            this.f1251c = i2;
            this.d = pLAVFrame;
            this.e = System.currentTimeMillis();
            PLBufferInfo pLBufferInfo2 = new PLBufferInfo();
            this.f1250a = pLBufferInfo2;
            this.f = str;
            if (pLBufferInfo != null) {
                pLBufferInfo2.set(pLBufferInfo.offset, pLBufferInfo.size, pLBufferInfo.presentationTimeUs, pLBufferInfo.dtsUs, pLBufferInfo.flags);
                this.f1250a.isNeedAddHeader = pLBufferInfo.isNeedAddHeader;
            }
        }
    }

    static {
        h.b(300, 800);
    }

    public c() {
        this.b = 4;
        this.f1241c = 1;
        this.h = new Object();
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = new Object();
        this.s = new Object();
        this.t = false;
        this.u = false;
        this.v = 0;
        this.C = false;
        this.D = false;
        this.F = 0;
        this.G = new LinkedBlockingDeque();
        this.J = new b(this);
        this.K = false;
        this.O = false;
        this.g = new PLDroidStreamingCore();
        this.r = 2;
    }

    public c(int i) {
        this.b = 4;
        this.f1241c = 1;
        this.h = new Object();
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = new Object();
        this.s = new Object();
        this.t = false;
        this.u = false;
        this.v = 0;
        this.C = false;
        this.D = false;
        this.F = 0;
        this.G = new LinkedBlockingDeque();
        this.J = new b(this);
        this.K = false;
        this.O = false;
        this.r = i;
        this.g = new PLDroidStreamingCore();
    }

    public static boolean c() {
        return false;
    }

    public int a(g gVar) {
        PLDroidStreamingCore pLDroidStreamingCore = this.g;
        ByteBuffer byteBuffer = gVar.d.mBuffer;
        PLBufferInfo pLBufferInfo = gVar.f1250a;
        int sendFrame = pLDroidStreamingCore.sendFrame(byteBuffer, pLBufferInfo.size, pLBufferInfo.presentationTimeUs / 1000, pLBufferInfo.dtsUs / 1000, false, false);
        if (sendFrame == 0) {
            this.J.n++;
            this.J.t++;
        }
        return sendFrame;
    }

    public long a(long j, int i, boolean z) {
        long[] jArr = this.w;
        if (jArr[i] == 0) {
            if (j != 0) {
                jArr[i] = j;
                a.a.a.a.a.e.e eVar = a.a.a.a.a.e.e.f;
                eVar.b("Muxer", "Set mFirstPts[" + i + "] " + this.w);
                return 0L;
            }
            return 0L;
        }
        return b(j - jArr[i], i, z);
    }

    public void a() {
        a.a.a.a.a.e.e.f.c("Muxer", "forceStop");
        if (f()) {
            if (this.C) {
                a.a.a.a.a.e.e.f.c("Muxer", "streaming paused");
                return;
            }
            this.m = true;
            e(new g(-1, 0, null, null));
            return;
        }
        a.a.a.a.a.e.e eVar = a.a.a.a.a.e.e.f;
        eVar.c("Muxer", "forceStop return immediately:mReady=" + this.i);
    }

    public void a(int i) {
        synchronized (this.s) {
            a.a.a.a.a.e.e eVar = a.a.a.a.a.e.e.f;
            eVar.c("Muxer", "addTrack trackIndex:" + i);
            if (i == 0) {
                this.t = true;
            } else if (i != 1) {
                throw new IllegalArgumentException("Unsupported Track:" + i);
            } else {
                this.u = true;
            }
            f(i);
        }
    }

    public final void a(int i, int i2) {
        Intent intent = new Intent("pldroid-qos-filter");
        intent.putExtra("pldroid-qos-msg-type", 164);
        intent.putExtra("beginAt", this.L);
        intent.putExtra("endAt", System.currentTimeMillis());
        intent.putExtra("gopTime", n());
        intent.putExtra("videoSendFrames", (int) this.J.u);
        intent.putExtra("videoDroppedFrames", (int) this.J.w);
        intent.putExtra("audioSendFrames", (int) this.J.t);
        intent.putExtra("audioDroppedFrames", (int) this.J.v);
        intent.putExtra("totalSendBytes", this.J.y + this.J.x);
        intent.putExtra("errorCode", i);
        intent.putExtra("errorOSCode", i2);
        a.a.a.a.a.j.a.a().a(intent);
    }

    public void a(int i, int i2, PLAVFrame pLAVFrame, PLBufferInfo pLBufferInfo) {
        if (h.c(pLBufferInfo)) {
            a.a.a.a.a.e.e eVar = a.a.a.a.a.e.e.f;
            eVar.b("Muxer", "SIGNAL END OF TRACK trackIndex:" + i + ",mStreamingPaused:" + this.C);
            if (this.C) {
                return;
            }
            c(i);
        }
    }

    public void a(int i, PLAVFrame pLAVFrame, int i2) {
        if (i == 0) {
            d dVar = this.z;
            if (dVar != null) {
                dVar.a(pLAVFrame, i2);
            }
        } else if (i != 1) {
            throw new IllegalArgumentException("can't support track:" + i);
        } else {
            d dVar2 = this.A;
            if (dVar2 != null) {
                dVar2.a(pLAVFrame, i2);
            }
        }
    }

    public final void a(b.c cVar, Object obj) {
        cVar.ordinal();
        q();
        d().a(cVar, obj);
    }

    public void a(d dVar) {
        this.A = dVar;
    }

    public void a(Context context) {
        this.N = context;
    }

    public void a(StreamStatusCallback streamStatusCallback) {
        this.B = streamStatusCallback;
    }

    public void a(PLBufferInfo pLBufferInfo, PLAVFrame pLAVFrame, int i, int i2) {
        synchronized (this.n) {
            if (!this.o) {
                a.a.a.a.a.e.e.f.a("Muxer", "releaseOutputBufer encodedData.clear()!");
                pLAVFrame.mBuffer.clear();
                if (h.a(pLBufferInfo)) {
                    a.a.a.a.a.e.e eVar = a.a.a.a.a.e.e.f;
                    eVar.c("Muxer", "mMuxerInputKeyFrameQueue.add encodedData:" + pLAVFrame.mBuffer);
                    this.I.a(pLAVFrame);
                } else {
                    synchronized (this.H) {
                        this.H.get(i2).a(pLAVFrame);
                    }
                }
            }
        }
    }

    public final void a(PLDroidStreamingCore.AVOptions aVOptions) {
        Context context = this.N;
        if (context == null || aVOptions == null) {
            return;
        }
        String[] g2 = h.g(context);
        if (g2 != null && g2.length == 2) {
            aVOptions.appName = g2[0];
            aVOptions.appVersion = g2[1];
        }
        String b2 = a.a.a.a.a.k.c.a.b(this.N);
        aVOptions.networkType = b2;
        boolean equals = b2.equals("WIFI");
        aVOptions.isWifiNetwork = equals;
        if (equals) {
            String[] f2 = a.a.a.a.a.k.c.a.f(this.N);
            if (f2 == null || f2.length < 2) {
                aVOptions.enableWifiPermission = false;
                return;
            } else if (!h.d(f2[1])) {
                aVOptions.enableWifiPermission = false;
                return;
            } else {
                aVOptions.signalDB = Integer.parseInt(f2[1]);
                aVOptions.enableWifiPermission = true;
                return;
            }
        }
        String[] g3 = a.a.a.a.a.k.c.a.g(this.N);
        if (g3 == null || g3.length < 2) {
            aVOptions.enablePhonePermission = false;
            return;
        }
        aVOptions.ispName = g3[0];
        if (!h.d(g3[1])) {
            aVOptions.enablePhonePermission = false;
            return;
        }
        aVOptions.signalDB = Integer.parseInt(g3[1]);
        aVOptions.enablePhonePermission = true;
    }

    public void a(String str) {
        synchronized (this) {
            synchronized (this.h) {
                if (this.R) {
                    this.R = false;
                    a.a.a.a.a.e.e.f.d("Muxer", "start muxing thread marked interrupt, unnecessary to go on");
                } else if (this.j) {
                    a.a.a.a.a.e.e.f.d("Muxer", "Muxing thread running when start requested");
                } else {
                    this.j = true;
                    this.k = false;
                    f fVar = new f();
                    this.Q = fVar;
                    fVar.setName(str);
                    this.Q.start();
                    this.P = Thread.currentThread();
                    a.a.a.a.a.e.e eVar = a.a.a.a.a.e.e.f;
                    eVar.c("Muxer", "the thread to launch muxing thread is: " + this.P.getId());
                    while (!this.i && !this.k) {
                        try {
                            this.h.wait();
                        } catch (InterruptedException e2) {
                            a.a.a.a.a.e.e eVar2 = a.a.a.a.a.e.e.f;
                            eVar2.d("Muxer", "interrupt from user, stop waiting muxing thread: " + this.Q.getId());
                            this.k = true;
                            this.j = false;
                        }
                    }
                }
            }
        }
    }

    public void a(ByteBuffer byteBuffer, PLBufferInfo pLBufferInfo) {
        a.a.a.a.a.e.e.f.c("Muxer", "AACMetaData");
        int i = pLBufferInfo.size;
        byte[] bArr = new byte[i];
        this.q = bArr;
        byteBuffer.get(bArr, pLBufferInfo.offset, i);
        byteBuffer.position(pLBufferInfo.offset);
        byteBuffer.put(this.q, 0, pLBufferInfo.size);
        byteBuffer.position(pLBufferInfo.offset);
    }

    public void a(boolean z) {
        this.C = z;
        if (z) {
            this.D = true;
        }
    }

    public void a(byte[] bArr, int i) {
        bArr[0] = -1;
        bArr[1] = -7;
        int i2 = this.b;
        int i3 = this.f1241c;
        bArr[2] = (byte) ((i2 << 2) + 64 + (i3 >> 2));
        bArr[3] = (byte) (((i3 & 3) << 6) + (i >> 11));
        bArr[4] = (byte) ((i & 2047) >> 3);
        bArr[5] = (byte) (((i & 7) << 5) + 31);
        bArr[6] = -4;
    }

    public boolean a(a.a.a.a.a.a.b bVar) {
        a.a.a.a.a.e.e.f.c("Muxer", bc.b.Code);
        return b(bVar);
    }

    public final long b(long j, int i, boolean z) {
        long[] jArr = this.x;
        if (jArr[i] >= j) {
            jArr[i] = jArr[i] + 9643;
            return jArr[i];
        }
        if (z) {
            jArr[i] = j;
        }
        return j;
    }

    public abstract void b();

    public void b(int i) {
        a.a.a.a.a.e.e eVar = a.a.a.a.a.e.e.f;
        eVar.c("Muxer", "onEncoderReleased trackIndex=" + i);
        synchronized (this.n) {
            this.o = true;
        }
    }

    public void b(d dVar) {
        this.z = dVar;
    }

    public void b(ByteBuffer byteBuffer, PLBufferInfo pLBufferInfo) {
        if (!h.d(pLBufferInfo)) {
            a.a.a.a.a.e.e.f.c("Muxer", "no need to add adts header");
            return;
        }
        int i = pLBufferInfo.size;
        this.d = i;
        int i2 = i + 7;
        this.e = i2;
        a(this.f, i2);
        byteBuffer.get(this.f, 7, this.d);
        byteBuffer.position(pLBufferInfo.offset);
        byteBuffer.limit(pLBufferInfo.offset + this.e);
        try {
            byteBuffer.put(this.f, 0, this.e);
            byteBuffer.position(pLBufferInfo.offset);
            pLBufferInfo.size = this.e;
        } catch (BufferOverflowException e2) {
            a.a.a.a.a.e.e.f.d("Muxer", "BufferOverFlow adding ADTS header");
            byteBuffer.put(this.f, 0, this.e);
        }
    }

    public void b(boolean z) {
        this.O = z;
    }

    public boolean b(a.a.a.a.a.a.b bVar) {
        this.y = bVar;
        synchronized (this.s) {
            this.u = false;
            this.t = false;
        }
        this.v = 0;
        this.x = new long[2];
        int i = 0;
        while (true) {
            int i2 = i;
            long[] jArr = this.x;
            if (i2 >= jArr.length) {
                break;
            }
            jArr[i2] = 0;
            i = i2 + 1;
        }
        this.w = new long[2];
        int i3 = 0;
        while (true) {
            int i4 = i3;
            long[] jArr2 = this.w;
            if (i4 >= jArr2.length) {
                a.a.a.a.a.e.e.f.c("Muxer", "Created muxer for output: " + this.y.g());
                return true;
            }
            jArr2[i4] = 0;
            i3 = i4 + 1;
        }
    }

    public int c(g gVar) {
        if (gVar.b == 0 && i()) {
            b(gVar.d.mBuffer, gVar.f1250a);
        }
        gVar.d.mBuffer.position(gVar.f1250a.offset);
        ByteBuffer byteBuffer = gVar.d.mBuffer;
        PLBufferInfo pLBufferInfo = gVar.f1250a;
        byteBuffer.limit(pLBufferInfo.offset + pLBufferInfo.size);
        gVar.f = null;
        if (gVar.b == 1) {
            if (a.a.a.a.a.f.b.a().c() || a.a.a.a.a.f.b.a().b(gVar.f1250a.presentationTimeUs)) {
                gVar.f = a.a.a.a.a.f.b.a().b();
                a.a.a.a.a.f.b.a().d();
            }
            a.a.a.a.a.f.b.a().e();
        }
        PLBufferInfo pLBufferInfo2 = gVar.f1250a;
        pLBufferInfo2.presentationTimeUs = a(pLBufferInfo2.presentationTimeUs, gVar.b, true ^ h.b(pLBufferInfo2));
        PLBufferInfo pLBufferInfo3 = gVar.f1250a;
        if (pLBufferInfo3.presentationTimeUs < 0) {
            a(pLBufferInfo3, gVar.d, gVar.f1251c, gVar.b);
            a.a.a.a.a.e.e eVar = a.a.a.a.a.e.e.f;
            eVar.d("Muxer", "Warming bufferInfo.presentationTimeUs:" + gVar.f1250a.presentationTimeUs);
            if (this.C || !g()) {
                return 0;
            }
            a.a.a.a.a.e.e.f.c("Muxer", "Shutting down on last frame");
            return -1;
        }
        return 0;
    }

    public void c(int i) {
        int i2 = this.v + 1;
        this.v = i2;
        if (i2 > 2) {
            this.v = 2;
        }
    }

    public void c(ByteBuffer byteBuffer, PLBufferInfo pLBufferInfo) {
        a.a.a.a.a.e.e eVar = a.a.a.a.a.e.e.f;
        eVar.c("Muxer", "H264MetaData mH264MetaSize:" + pLBufferInfo.size);
        int i = pLBufferInfo.size;
        if (i <= 0) {
            a.a.a.a.a.e.e.f.e("Muxer", "error buffer size");
            return;
        }
        this.F = i;
        byte[] bArr = new byte[i];
        this.p = bArr;
        byteBuffer.get(bArr, pLBufferInfo.offset, i);
        byteBuffer.position(pLBufferInfo.offset);
        byteBuffer.put(this.p, 0, pLBufferInfo.size);
        byteBuffer.position(pLBufferInfo.offset);
    }

    public void c(boolean z) {
        if (z) {
            this.J.j++;
            return;
        }
        this.J.i++;
    }

    public int d(g gVar) {
        int sendFrame;
        if (!d().t()) {
            d().a(b.c.STREAMING, null);
        }
        if (!h.a(gVar.f1250a)) {
            PLDroidStreamingCore pLDroidStreamingCore = this.g;
            ByteBuffer byteBuffer = gVar.d.mBuffer;
            PLBufferInfo pLBufferInfo = gVar.f1250a;
            sendFrame = pLDroidStreamingCore.sendFrame(byteBuffer, pLBufferInfo.size, pLBufferInfo.presentationTimeUs / 1000, pLBufferInfo.dtsUs / 1000, true, h.a(pLBufferInfo), gVar.f);
        } else if (h.d(gVar.f1250a)) {
            d(gVar.d.mBuffer, gVar.f1250a);
            PLDroidStreamingCore pLDroidStreamingCore2 = this.g;
            ByteBuffer byteBuffer2 = this.E;
            PLBufferInfo pLBufferInfo2 = gVar.f1250a;
            sendFrame = pLDroidStreamingCore2.sendFrame(byteBuffer2, this.F + pLBufferInfo2.size, pLBufferInfo2.presentationTimeUs / 1000, pLBufferInfo2.dtsUs / 1000, true, true, gVar.f);
        } else {
            PLDroidStreamingCore pLDroidStreamingCore3 = this.g;
            ByteBuffer byteBuffer3 = gVar.d.mBuffer;
            PLBufferInfo pLBufferInfo3 = gVar.f1250a;
            sendFrame = pLDroidStreamingCore3.sendFrame(byteBuffer3, pLBufferInfo3.size, pLBufferInfo3.presentationTimeUs / 1000, pLBufferInfo3.dtsUs / 1000, true, true, gVar.f);
        }
        if (sendFrame == 0) {
            this.J.o++;
            this.J.u++;
        }
        return sendFrame;
    }

    public a.a.a.a.a.a.b d() {
        return this.y;
    }

    public void d(ByteBuffer byteBuffer, PLBufferInfo pLBufferInfo) {
        if (this.E == null && h.d(pLBufferInfo)) {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(byteBuffer.capacity());
            this.E = allocateDirect;
            allocateDirect.clear();
            ByteBuffer byteBuffer2 = this.E;
            byte[] bArr = this.p;
            byteBuffer2.put(bArr, 0, bArr.length);
        }
        ByteBuffer byteBuffer3 = this.E;
        if (byteBuffer3 != null) {
            byteBuffer3.position(this.F);
            this.E.put(byteBuffer);
        }
    }

    public boolean d(int i) {
        if (h()) {
            if (i == PLDroidStreamingCore.ERROR_CODE_TIME_OUT) {
                d().a(b.c.TIMEOUT, null);
                return false;
            } else if (i != PLDroidStreamingCore.ERROR_CODE_DISCONNECTED && !c()) {
                if (i == PLDroidStreamingCore.ERROR_CODE_UNAUTHORIZED_URL) {
                    d().a(b.c.UNAUTHORIZED_URL, null);
                    return false;
                }
                return true;
            } else {
                a.a.a.a.a.e.e eVar = a.a.a.a.a.e.e.f;
                eVar.d("Muxer", "ERROR_CODE_DISCONNECTED remote ip:" + this.g.getRemoteIP() + ",path:" + this.g.getPath());
                d().a(b.c.DISCONNECTED, null);
                return false;
            }
        }
        return true;
    }

    public b e() {
        return this.J;
    }

    public void e(int i) {
        this.J.z += i;
        this.J.A++;
    }

    public void e(g gVar) {
        this.G.add(gVar);
        f(gVar);
    }

    public final void f(int i) {
    }

    public final void f(g gVar) {
        if (gVar.f1250a != null) {
            this.J.B += gVar.f1250a.size;
        }
    }

    public boolean f() {
        boolean z;
        synchronized (this.h) {
            z = this.i;
        }
        return z;
    }

    public final void g(int i) {
        StreamingProfile.StreamStatus streamStatus = d().f().getStreamStatus();
        int i2 = i / 1000;
        long j = i2;
        streamStatus.audioFps = (int) (this.J.e / j);
        streamStatus.videoFps = (int) (this.J.f / j);
        streamStatus.totalAVBitrate = (int) (((this.J.g + this.J.h) * 8) / j);
        streamStatus.audioBitrate = (int) ((this.J.g * 8) / j);
        streamStatus.videoBitrate = (int) ((this.J.h * 8) / j);
        streamStatus.totalAVBitrateProduce = (int) ((this.J.B * 8) / j);
        this.J.p = ((int) this.J.i) / i2;
        this.J.q = ((int) this.J.j) / i2;
        this.J.r = ((int) this.J.n) / i2;
        this.J.s = ((int) this.J.o) / i2;
        if (this.J.A > 0) {
            streamStatus.meanTcpSendTimeInMilliseconds = this.J.z / this.J.A;
        }
        this.J.A = 0;
        this.J.z = 0;
    }

    public final void g(g gVar) {
        if (gVar.f1250a != null) {
            int i = gVar.b;
            if (i == 0) {
                this.J.e++;
                this.J.g += gVar.f1250a.size;
                this.J.x += gVar.f1250a.size;
            } else if (i == 1) {
                this.J.f++;
                this.J.h += gVar.f1250a.size;
                this.J.y += gVar.f1250a.size;
            }
            if (this.K) {
                return;
            }
            this.K = true;
            e eVar = this.M;
            if (eVar != null) {
                eVar.sendMessage(eVar.obtainMessage(0));
            }
        }
    }

    public boolean g() {
        return this.v == this.r;
    }

    public boolean h() {
        synchronized (this.s) {
            boolean z = false;
            if (this.r == 1) {
                if (!this.t) {
                    if (this.u) {
                    }
                    return z;
                }
                z = true;
                return z;
            } else if (this.r != 2) {
                throw new IllegalStateException("Unsupported mExpectedNumTracks:" + this.r);
            } else {
                boolean z2 = false;
                if (this.t) {
                    z2 = false;
                    if (this.u) {
                        z2 = true;
                    }
                }
                return z2;
            }
        }
    }

    public boolean i() {
        int i = a.f1242a[this.y.h().ordinal()];
        return i == 1 || i == 2;
    }

    public g j() {
        try {
            g take = this.G.take();
            g(take);
            return take;
        } catch (InterruptedException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void k() {
        synchronized (this.h) {
            a.a.a.a.a.e.e eVar = a.a.a.a.a.e.e.f;
            eVar.d("Muxer", "try interrupt muxing thread mRunning: " + this.j + " mReady: " + this.i + " mIsIOError: " + this.k);
            if (!this.j) {
                a.a.a.a.a.e.e.f.d("Muxer", "muxing thread not started yet, then mark it unnecessary to start");
                this.R = true;
            } else if (this.i || this.k || this.Q == null || this.P == null) {
                a.a.a.a.a.e.e.f.d("Muxer", "unable to interrupt under current situation");
            } else {
                a.a.a.a.a.e.e eVar2 = a.a.a.a.a.e.e.f;
                eVar2.d("Muxer", "interrupt muxing thread: " + this.P.getId());
                this.Q.a();
                this.P.interrupt();
            }
        }
    }

    public void l() {
        synchronized (this.h) {
            this.R = false;
        }
    }

    public void m() {
        if (this.g.isInitialized()) {
            a.a.a.a.a.e.e.f.e("Muxer", "Shutting down");
            synchronized (this.n) {
                boolean z = this.o && EnumC0001c.RTMP == d().h();
                a.a.a.a.a.e.e eVar = a.a.a.a.a.e.e.f;
                eVar.e("Muxer", "released:" + z + ",mStreamingPaused=" + this.C);
                this.g.shutDown(z);
            }
        }
        this.E = null;
    }

    public long n() {
        StreamingProfile f2 = d().f();
        if (f2 == null || this.O || f2.getVideoProfile() == null || f2.getVideoProfile().reqFps == 0) {
            return 0L;
        }
        return (f2.getVideoProfile().maxKeyFrameInterval * 1000) / f2.getVideoProfile().reqFps;
    }

    public final void o() {
        this.J.e = 0L;
        this.J.f = 0L;
        this.J.g = 0L;
        this.J.h = 0L;
        this.J.i = 0L;
        this.J.j = 0L;
        this.J.k = 0L;
        this.J.l = 0L;
        this.J.m = 0L;
        this.J.n = 0L;
        this.J.o = 0L;
        this.J.B = 0L;
    }

    public final boolean p() {
        try {
            PLDroidStreamingCore.c cVar = this instanceof a.a.a.a.a.a.i.a ? PLDroidStreamingCore.c.VIDEO_AUDIO : this instanceof a.a.a.a.a.a.i.b ? PLDroidStreamingCore.c.AUDIO : PLDroidStreamingCore.c.VIDEO;
            PLDroidStreamingCore.AVOptions o = d().o();
            o.type = cVar.ordinal();
            o.gopTimeMS = n();
            a(o);
            d().f().setRtmpOptions("flashVer", a.a.a.a.a.e.d.b);
            o.rtmpOptions = d().f().getRtmpOptions();
            o.quicEnable = d().f().f();
            this.g.initCore(o);
            return false;
        } catch (a.a.a.a.a.f.d e2) {
            a.a.a.a.a.e.e eVar = a.a.a.a.a.e.e.f;
            eVar.e("Muxer", "PLMuxer.prepare():" + e2.getMessage());
            a(b.c.UNAUTHORIZED_URL, Integer.valueOf(PLDroidStreamingCore.ERROR_CODE_UNAUTHORIZED_URL));
            int i = PLDroidStreamingCore.ERROR_CODE_UNAUTHORIZED_URL;
            a(i, i);
            return true;
        } catch (IOException e3) {
            a.a.a.a.a.e.e eVar2 = a.a.a.a.a.e.e.f;
            eVar2.e("Muxer", "PLMuxer.prepare():" + e3.getMessage());
            a(b.c.IOERROR, Integer.valueOf(PLDroidStreamingCore.ERROR_CODE_TIME_OUT));
            int i2 = PLDroidStreamingCore.ERROR_CODE_TIME_OUT;
            a(i2, i2);
            return true;
        }
    }

    public final void q() {
        synchronized (this.h) {
            this.i = false;
            this.h.notify();
            this.j = false;
        }
        this.m = false;
        this.G.clear();
        this.p = null;
        this.q = null;
        synchronized (this.s) {
            this.t = false;
            this.u = false;
        }
        e eVar = this.M;
        if (eVar != null) {
            eVar.removeCallbacksAndMessages(null);
            this.M.a();
            this.M = null;
        }
        this.K = false;
        o();
    }
}
