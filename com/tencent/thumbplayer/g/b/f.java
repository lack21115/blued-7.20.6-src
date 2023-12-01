package com.tencent.thumbplayer.g.b;

import android.accounts.AccountManager;
import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.util.Log;
import android.view.Surface;
import com.autonavi.base.amap.mapcore.tools.GLMapStaticValue;
import com.tencent.thumbplayer.g.f.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/g/b/f.class */
public abstract class f implements c {
    private static final Map<Surface, f> i = new ConcurrentHashMap();
    private com.tencent.thumbplayer.g.e.a.a B;
    public boolean b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f25638c;
    public boolean d;
    public final e e;
    protected Surface f;
    protected final com.tencent.thumbplayer.g.b.b g;
    protected final String h;
    private final a.EnumC0854a k;
    private final MediaCodec p;
    private boolean q;
    private MediaCodecInfo.CodecCapabilities s;
    private long t;
    private com.tencent.thumbplayer.g.a.a u;
    private boolean v;
    private boolean x;

    /* renamed from: a  reason: collision with root package name */
    public b f25637a = b.Started;
    private final String j = "ReuseCodecWrapper[" + hashCode() + "]";
    private final HashSet<Integer> l = new HashSet<>();
    private final ArrayList<Long> m = new ArrayList<>();
    private final Set<SurfaceTexture> n = new LinkedHashSet();
    private final int[] o = new int[2];
    private a r = a.Uninitialized;
    private a.b w = a.b.KEEP_CODEC_RESULT_NO;
    private boolean y = false;
    private boolean z = false;
    private int A = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.thumbplayer.g.b.f$2  reason: invalid class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/g/b/f$2.class */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f25640a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0036 -> B:21:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003a -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003e -> B:25:0x002a). Please submit an issue!!! */
        static {
            int[] iArr = new int[a.b.values().length];
            f25640a = iArr;
            try {
                iArr[a.b.KEEP_CODEC_RESULT_NO.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f25640a[a.b.KEEP_CODEC_RESULT_YES_WITH_RECONFIGURATION.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f25640a[a.b.KEEP_CODEC_RESULT_YES_WITHOUT_RECONFIGURATION.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f25640a[a.b.KEEP_CODEC_RESULT_YES_WITH_FLUSH.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/g/b/f$a.class */
    public enum a {
        Uninitialized,
        Configured,
        Error,
        Flushed,
        Running,
        EndOfStream,
        Released
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/g/b/f$b.class */
    public enum b {
        Started,
        DequeueIn,
        QueueIn,
        DequeueOut,
        ReleaseOut
    }

    public f(MediaCodec mediaCodec, e eVar) {
        this.p = mediaCodec;
        this.e = eVar;
        this.g = new com.tencent.thumbplayer.g.b.b(eVar.g, eVar.h, eVar.i);
        String a2 = com.tencent.thumbplayer.g.h.c.a(this.p);
        this.h = a2;
        this.k = com.tencent.thumbplayer.g.f.a.a(a2);
        if (Build.VERSION.SDK_INT >= 18) {
            boolean z = Build.VERSION.SDK_INT != 29 || eVar.d == 0;
            com.tencent.thumbplayer.g.h.b.b(this.j, "canCallGetCodecInfo:".concat(String.valueOf(z)));
            if (z) {
                this.s = this.p.getCodecInfo().getCapabilitiesForType(eVar.j);
            }
        }
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.s;
        this.f25638c = codecCapabilities != null && com.tencent.thumbplayer.g.h.c.a(codecCapabilities);
        MediaCodecInfo.CodecCapabilities codecCapabilities2 = this.s;
        boolean z2 = false;
        if (codecCapabilities2 != null) {
            z2 = false;
            if (com.tencent.thumbplayer.g.h.c.b(codecCapabilities2)) {
                z2 = true;
            }
        }
        this.d = z2;
    }

    public static c a(MediaCodec mediaCodec, String str, e eVar) {
        return com.tencent.thumbplayer.g.h.c.a(str) ? new g(mediaCodec, eVar) : new com.tencent.thumbplayer.g.b.a(mediaCodec, eVar);
    }

    private void a(int i2) {
        if (i2 < 40000) {
            String str = this.j;
            com.tencent.thumbplayer.g.h.b.e(str, this + "    releaseCodecWhenError, errorCode:" + i2);
            g();
        }
    }

    private void a(int i2, int i3) {
        if (this.z || !b(i2, i3)) {
            return;
        }
        this.z = true;
        StringBuilder sb = new StringBuilder();
        sb.append(this);
        sb.append(", trackDecodeApi state:");
        sb.append(this.r);
        sb.append("  surfaceState:");
        Surface surface = this.f;
        sb.append(surface != null ? Boolean.valueOf(surface.isValid()) : null);
        String sb2 = sb.toString();
        if (i2 == 0) {
            a(40002, sb2, (Throwable) null);
        } else if (i2 == 1) {
            a(60002, sb2, (Throwable) null);
        }
    }

    private void a(int i2, String str, Throwable th) {
        a(i2, str, th, false, this.f);
    }

    private void a(int i2, String str, Throwable th, boolean z, Surface surface) {
        this.y = true;
        String str2 = str + " handleCoreAPIException exception:" + (th == null ? "" : th.getLocalizedMessage());
        int i3 = i2;
        if (z) {
            int d = d(surface);
            i3 = i2;
            if (d != 0) {
                i3 = d;
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(AccountManager.KEY_ERROR_CODE, i3);
            jSONObject.put("exceptionMsg", str2);
            if (this.u != null) {
                this.u.onReuseCodecAPIException(jSONObject.toString(), th);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        com.tencent.thumbplayer.g.h.b.b(this.j, "hasReused:" + this.v + "    errorCode:" + i3 + ", " + str2, th);
        a(i3);
    }

    private void a(Surface surface, boolean z, boolean z2) {
        if (this.f == surface) {
            com.tencent.thumbplayer.g.h.b.d(this.j, this + ", innerSetOutputSurface error surface:" + surface + " is same, stack:" + Log.getStackTraceString(new Throwable()));
            return;
        }
        String str = null;
        if (com.tencent.thumbplayer.g.h.b.a()) {
            str = this + " configure, call innerSetOutputSurface surface:" + surface + "  decodeState:" + this.f25637a + " callByInner:" + z;
            com.tencent.thumbplayer.g.h.b.b(this.j, str);
        }
        try {
            b(surface);
            this.p.setOutputSurface(surface);
            if (z2) {
                return;
            }
            p();
        } catch (Throwable th) {
            a(!(th instanceof IllegalStateException) ? th instanceof IllegalArgumentException ? 30001 : 0 : 30000, str, th, true, surface);
            throw th;
        }
    }

    private final void b(int i2, int i3, int i4, long j, int i5) {
        int i6 = AnonymousClass2.f25640a[this.w.ordinal()];
        if (i6 == 1) {
            com.tencent.thumbplayer.g.h.b.d(this.j, "queueInputBufferForAdaptation error for KEEP_CODEC_RESULT_NO");
        } else if (i6 == 2) {
            c(i2, i3, i4, j, i5);
        } else if (i6 != 3) {
        } else {
            this.p.queueInputBuffer(i2, i3, i4, j, i5);
        }
    }

    private void b(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i2) {
        String str = null;
        String str2 = null;
        try {
            if (com.tencent.thumbplayer.g.h.b.a()) {
                StringBuilder sb = new StringBuilder();
                sb.append(this);
                sb.append(", realConfigure mediaFormat:");
                sb.append(mediaFormat);
                sb.append(" surface:");
                sb.append(surface);
                sb.append(" crypto:");
                sb.append(mediaCrypto);
                sb.append(" flags:");
                sb.append(i2);
                sb.append(" state:");
                sb.append(this.r);
                sb.append(" mHasConfigureCalled：");
                sb.append(this.x);
                str = sb.toString();
                com.tencent.thumbplayer.g.h.b.b(this.j, str);
            }
            String str3 = str;
            this.p.configure(mediaFormat, surface, mediaCrypto, i2);
            String str4 = str;
            b(surface);
            str2 = str;
            this.r = a.Configured;
        } catch (Throwable th) {
            a(!(th instanceof IllegalStateException) ? th instanceof MediaCodec.CryptoException ? 10001 : 0 : 10000, str2, th, true, surface);
            throw th;
        }
    }

    private void b(Surface surface) {
        if (com.tencent.thumbplayer.g.h.b.a()) {
            String str = this.j;
            com.tencent.thumbplayer.g.h.b.c(str, this + ", oldSurface:" + this.f + " CodecWrapperSetSurface surface:" + surface);
        }
        this.f = surface;
    }

    private boolean b(int i2, int i3) {
        if (i3 != -1) {
            this.o[i2] = 0;
            return false;
        }
        int[] iArr = this.o;
        iArr[i2] = iArr[i2] + 1;
        return iArr[i2] > 100;
    }

    private final void c(int i2, int i3, int i4, long j, int i5) {
        this.p.queueInputBuffer(i2, i3, i4, j, i5);
    }

    private void c(Surface surface) {
        a(surface, true, false);
    }

    private int d(Surface surface) {
        return surface == null ? GLMapStaticValue.AM_CALLBACK_INDOOR_NETWORK_ERR : !surface.isValid() ? 10004 : 0;
    }

    private boolean n() {
        return Thread.currentThread().getId() != this.t;
    }

    private void o() {
        if (this.B != null) {
            return;
        }
        com.tencent.thumbplayer.g.e.a.a aVar = new com.tencent.thumbplayer.g.e.a.a(1, 1);
        this.B = aVar;
        a(aVar.d(), true, true);
    }

    private void p() {
        if (com.tencent.thumbplayer.g.h.b.a()) {
            String str = this.j;
            com.tencent.thumbplayer.g.h.b.b(str, this + "unBindingBackupSurface");
        }
        com.tencent.thumbplayer.g.e.a.a aVar = this.B;
        if (aVar != null) {
            aVar.b();
        }
        this.B = null;
    }

    private void q() {
        this.z = false;
        this.A = 0;
    }

    private void r() {
        int[] iArr = this.o;
        iArr[0] = 0;
        iArr[1] = 0;
    }

    @Override // com.tencent.thumbplayer.g.b.c
    public int a(long j) {
        if (n()) {
            com.tencent.thumbplayer.g.h.b.d(this.j, "ignore call method dequeueInputBuffer for isNotMyThread");
            return -1;
        }
        String str = null;
        int i2 = 0;
        String str2 = null;
        try {
            int dequeueInputBuffer = this.p.dequeueInputBuffer(j);
            if (com.tencent.thumbplayer.g.h.b.a()) {
                StringBuilder sb = new StringBuilder();
                sb.append(this);
                sb.append(", dequeueInputBuffer state:");
                sb.append(this.r);
                sb.append(" decodeState:");
                sb.append(this.f25637a);
                sb.append(" , result=");
                sb.append(dequeueInputBuffer);
                str = sb.toString();
                com.tencent.thumbplayer.g.h.b.a(this.j, str);
            }
            String str3 = str;
            this.f25637a = b.DequeueIn;
            String str4 = str;
            this.r = a.Running;
            str2 = str;
            a(0, dequeueInputBuffer);
            return dequeueInputBuffer;
        } catch (Throwable th) {
            if (th instanceof IllegalStateException) {
                i2 = 40000;
            } else if (th instanceof IllegalArgumentException) {
                i2 = 40001;
            }
            a(i2, str2, th);
            throw th;
        }
    }

    @Override // com.tencent.thumbplayer.g.b.c
    public int a(MediaCodec.BufferInfo bufferInfo, long j) {
        if (n()) {
            com.tencent.thumbplayer.g.h.b.d(this.j, "ignore call method dequeueOutputBuffer for isNotMyThread");
            return -1;
        }
        String str = null;
        try {
            int dequeueOutputBuffer = this.p.dequeueOutputBuffer(bufferInfo, j);
            String str2 = null;
            if (com.tencent.thumbplayer.g.h.b.a()) {
                StringBuilder sb = new StringBuilder();
                sb.append(this);
                sb.append(", dequeueOutputBuffer outIndex:");
                sb.append(dequeueOutputBuffer);
                String sb2 = sb.toString();
                str2 = sb2;
                if (this instanceof g) {
                    com.tencent.thumbplayer.g.h.b.a(this.j, sb2);
                    str2 = sb2;
                }
            }
            this.l.add(Integer.valueOf(dequeueOutputBuffer));
            String str3 = str2;
            this.f25637a = b.DequeueOut;
            str = str2;
            a(1, dequeueOutputBuffer);
            return dequeueOutputBuffer;
        } catch (Throwable th) {
            int i2 = 0;
            if (Build.VERSION.SDK_INT >= 21 && (th instanceof MediaCodec.CodecException)) {
                i2 = 60001;
            } else if (th instanceof IllegalStateException) {
                i2 = 60000;
            }
            a(i2, str, th);
            throw th;
        }
    }

    @Override // com.tencent.thumbplayer.g.b.c
    public MediaCodec a() {
        return this.p;
    }

    public abstract a.b a(e eVar);

    @Override // com.tencent.thumbplayer.g.b.c
    public void a(int i2, int i3, int i4, long j, int i5) {
        if (n()) {
            com.tencent.thumbplayer.g.h.b.d(this.j, "ignore call method queueInputBuffer for isNotMyThread");
            return;
        }
        String str = null;
        if (com.tencent.thumbplayer.g.h.b.a()) {
            str = this + ", queueInputBuffer index:" + i2 + " offset:" + i3 + " size:" + i4 + " presentationTimeUs:" + j + " flags:" + i5 + " state:" + this.r + " decodeState:" + this.f25637a;
            com.tencent.thumbplayer.g.h.b.a(this.j, str);
        }
        try {
            if (this.v) {
                b(i2, i3, i4, j, i5);
            } else {
                this.p.queueInputBuffer(i2, i3, i4, j, i5);
            }
            this.f25637a = b.QueueIn;
        } catch (Throwable th) {
            int i6 = 0;
            if (Build.VERSION.SDK_INT >= 21 && (th instanceof MediaCodec.CodecException)) {
                i6 = 50001;
            } else if (th instanceof IllegalStateException) {
                i6 = 50000;
            } else if (th instanceof MediaCodec.CryptoException) {
                i6 = 50002;
            }
            a(i6, str, th);
            throw th;
        }
    }

    @Override // com.tencent.thumbplayer.g.b.c
    public void a(int i2, boolean z) {
        if (n()) {
            com.tencent.thumbplayer.g.h.b.d(this.j, "ignore call method releaseOutputBuffer for isNotMyThread");
            return;
        }
        String str = null;
        if (com.tencent.thumbplayer.g.h.b.a()) {
            str = this + ", releaseOutputBuffer render:" + z;
            com.tencent.thumbplayer.g.h.b.a(this.j, str);
        }
        try {
            this.l.remove(Integer.valueOf(i2));
            this.p.releaseOutputBuffer(i2, z);
        } catch (Throwable th) {
            if (this.r != a.Flushed) {
                com.tencent.thumbplayer.g.h.b.a(this.j, this + ", releaseOutputBuffer failed, ignore e:", th);
            }
            int i3 = 0;
            if (Build.VERSION.SDK_INT >= 21 && (th instanceof MediaCodec.CodecException)) {
                i3 = 70002;
            } else if (th instanceof IllegalStateException) {
                i3 = 70001;
            }
            a(i3, str, th);
        }
        this.f25637a = b.ReleaseOut;
    }

    @Override // com.tencent.thumbplayer.g.b.c
    public void a(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i2) {
        if (n()) {
            com.tencent.thumbplayer.g.h.b.d(this.j, "ignore call method configure for isNotMyThread");
            return;
        }
        this.x = true;
        this.q = false;
        if (this.r == a.Uninitialized) {
            b(mediaFormat, surface, mediaCrypto, i2);
        } else if (surface != null) {
            r();
            c(surface);
        }
    }

    @Override // com.tencent.thumbplayer.g.b.c
    public void a(Surface surface) {
        a(surface, false, false);
    }

    @Override // com.tencent.thumbplayer.g.b.c
    public void a(com.tencent.thumbplayer.g.a.a aVar) {
        this.u = aVar;
    }

    @Override // com.tencent.thumbplayer.g.b.c
    public a.b b(e eVar) {
        a.b a2 = a(eVar);
        this.w = a2;
        return a2;
    }

    @Override // com.tencent.thumbplayer.g.b.c
    public void b() {
        long id = Thread.currentThread().getId();
        if (this.m.contains(Long.valueOf(id))) {
            return;
        }
        this.t = id;
        this.m.add(Long.valueOf(id));
        if (this.m.size() > 100) {
            this.m.remove(0);
        }
    }

    @Override // com.tencent.thumbplayer.g.b.c
    public void c() {
        q();
        if (com.tencent.thumbplayer.g.a.c()) {
            if (this.r == a.Running) {
                try {
                    e();
                } catch (IllegalStateException e) {
                    com.tencent.thumbplayer.g.h.b.b(this.j, "flush failed in prepareToReUse", e);
                }
            }
        } else if (this.r != a.Flushed) {
            e();
        }
        this.v = true;
    }

    @Override // com.tencent.thumbplayer.g.b.c
    public void d() {
        if (this.r != a.Configured) {
            com.tencent.thumbplayer.g.h.b.b(this.j, "start ignore:" + this.r);
            return;
        }
        String str = null;
        String str2 = null;
        try {
            if (com.tencent.thumbplayer.g.h.b.a()) {
                StringBuilder sb = new StringBuilder();
                sb.append(this);
                sb.append(", start state:");
                sb.append(this.r);
                str = sb.toString();
                com.tencent.thumbplayer.g.h.b.b(this.j, str);
            }
            String str3 = str;
            if (this.r == a.Configured) {
                String str4 = str;
                this.p.start();
                str2 = str;
                this.r = a.Running;
            }
        } catch (Throwable th) {
            int i2 = 0;
            if (Build.VERSION.SDK_INT >= 21 && (th instanceof MediaCodec.CodecException)) {
                i2 = 20001;
            } else if (th instanceof IllegalStateException) {
                i2 = 20000;
            }
            a(i2, str2, th);
            throw th;
        }
    }

    @Override // com.tencent.thumbplayer.g.b.c
    public void e() {
        if (n()) {
            com.tencent.thumbplayer.g.h.b.d(this.j, "call method flush for isNotMyThread...");
        }
        String str = null;
        String str2 = null;
        try {
            if (com.tencent.thumbplayer.g.h.b.a()) {
                StringBuilder sb = new StringBuilder();
                sb.append(this);
                sb.append(", flush state:");
                sb.append(this.r);
                str = sb.toString();
                com.tencent.thumbplayer.g.h.b.b(this.j, str);
            }
            String str3 = str;
            this.p.flush();
            str2 = str;
            this.r = a.Flushed;
        } catch (Throwable th) {
            int i2 = 0;
            if (Build.VERSION.SDK_INT >= 21 && (th instanceof MediaCodec.CodecException)) {
                i2 = 90001;
            } else if (th instanceof IllegalStateException) {
                i2 = 90000;
            }
            a(i2, str2, th);
            throw th;
        }
    }

    @Override // com.tencent.thumbplayer.g.b.c
    public void f() {
        if (com.tencent.thumbplayer.g.h.b.a()) {
            String str = this.j;
            com.tencent.thumbplayer.g.h.b.b(str, this + ", stop");
        }
        if (j()) {
            return;
        }
        if (com.tencent.thumbplayer.g.h.b.a()) {
            String str2 = this.j;
            com.tencent.thumbplayer.g.h.b.b(str2, this + ", codec real stop");
        }
        try {
            this.p.stop();
            this.r = a.Uninitialized;
        } catch (IllegalStateException e) {
            this.r = a.Uninitialized;
            com.tencent.thumbplayer.g.h.b.b(this.j, "stop failed", e);
            throw e;
        }
    }

    @Override // com.tencent.thumbplayer.g.b.c
    public void g() {
        if (com.tencent.thumbplayer.g.h.b.a()) {
            String str = this.j;
            com.tencent.thumbplayer.g.h.b.b(str, this + " call release mHoldBufferOutIndex:" + this.l + " mReleaseCalled:" + this.q + " stack:" + Log.getStackTraceString(new Throwable()));
        }
        this.q = true;
        this.x = false;
        if (j()) {
            try {
                e();
            } catch (IllegalStateException e) {
                com.tencent.thumbplayer.g.h.b.b(this.j, "flush failed for not in the Executing state.", e);
            }
            o();
            com.tencent.thumbplayer.g.a.a().b(this);
            return;
        }
        if (com.tencent.thumbplayer.g.h.b.a()) {
            String str2 = this.j;
            com.tencent.thumbplayer.g.h.b.d(str2, "Don't not keep the codec, release it ..., mErrorHappened:" + this.y);
        }
        com.tencent.thumbplayer.g.a.a().a(this);
        i();
        this.r = a.Released;
    }

    public final com.tencent.thumbplayer.g.a.a h() {
        return this.u;
    }

    public final void i() {
        if (com.tencent.thumbplayer.g.h.b.a()) {
            String str = this.j;
            com.tencent.thumbplayer.g.h.b.b(str, this + ", recycle isRecycled:" + this.b + "  mSurfaceMap.size:" + i.size() + "...... stack:" + Log.getStackTraceString(new Throwable()));
        }
        if (this.b) {
            com.tencent.thumbplayer.g.h.b.d(this.j, "ignore recycle for has isRecycled is true.");
            return;
        }
        this.x = false;
        this.b = true;
        com.tencent.thumbplayer.g.h.d.a(new Runnable() { // from class: com.tencent.thumbplayer.g.b.f.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    f.this.p.stop();
                    f.this.p.release();
                } catch (Throwable th) {
                    com.tencent.thumbplayer.g.h.b.a(f.this.j, "recycle codec ignore error,", th);
                }
                if (f.this.u != null) {
                    f.this.u.onRealRelease();
                }
            }
        });
        this.r = a.Uninitialized;
    }

    public boolean j() {
        return com.tencent.thumbplayer.g.a.c() ? !this.y && com.tencent.thumbplayer.g.a.a().e() && com.tencent.thumbplayer.g.a.a().f() : !this.y && com.tencent.thumbplayer.g.a.a().e();
    }

    public void k() {
        this.A++;
    }

    public boolean l() {
        return this.A >= 3;
    }

    public String m() {
        return this.h;
    }

    public String toString() {
        return super.toString() + " mReleaseCalled:" + this.q + " isRecycled:" + this.b;
    }
}
