package com.qiniu.pili.droid.streaming;

import a.a.a.a.a.a.b;
import a.a.a.a.a.a.c;
import a.a.a.a.a.a.j.d;
import a.a.a.a.a.a.j.f;
import a.a.a.a.a.a.j.g;
import a.a.a.a.a.e.e;
import a.a.a.a.a.e.h;
import android.content.Context;
import android.view.Surface;
import com.qiniu.pili.droid.streaming.StreamingProfile;
import com.qiniu.pili.droid.streaming.av.common.PLFourCC;
import java.nio.ByteBuffer;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/StreamingManager.class */
public final class StreamingManager implements b.InterfaceC0000b, c {

    /* renamed from: a  reason: collision with root package name */
    public boolean f14142a;
    public a.a.a.a.a.a.i.c b;

    /* renamed from: c  reason: collision with root package name */
    public a.a.a.a.a.a.e.a f14143c;
    public b d;
    public StreamingProfile e;
    public a.a.a.a.a.a.e.c f;
    public f g;
    public d h;
    public AVCodecType i;
    public Context j;
    public StreamingStateChangedListener k;
    public StreamingSessionListener l;
    public StreamStatusCallback m;
    public f.a n;
    public boolean o;
    public boolean p;
    public boolean q;
    public volatile boolean r;
    public volatile boolean s;
    public volatile long t;
    public SurfaceTextureCallback2 u;

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/StreamingManager$a.class */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f14144a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00b9 -> B:79:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00bd -> B:91:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00c1 -> B:87:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00c5 -> B:69:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00c9 -> B:65:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00cd -> B:75:0x004c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00d1 -> B:71:0x0058). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x00d5 -> B:81:0x0064). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x00d9 -> B:77:0x0070). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x00dd -> B:89:0x007c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x00e1 -> B:85:0x0088). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x00e5 -> B:67:0x0094). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x00e9 -> B:63:0x00a0). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x00ed -> B:73:0x00ac). Please submit an issue!!! */
        static {
            int[] iArr = new int[b.c.values().length];
            f14144a = iArr;
            try {
                iArr[b.c.READY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f14144a[b.c.PREPARING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f14144a[b.c.CONNECTING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f14144a[b.c.STREAMING.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f14144a[b.c.SHUTDOWN.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f14144a[b.c.IOERROR.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f14144a[b.c.FRAME_QUEUE_EMPTY.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f14144a[b.c.FRAME_QUEUE_FULL.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f14144a[b.c.FRAME_QUEUE_HAS_FEW_ELEMENTS.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f14144a[b.c.FRAME_QUEUE_HAS_MANY_ELEMENTS.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f14144a[b.c.ADJUST_BITRATE.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f14144a[b.c.DISCONNECTED.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                f14144a[b.c.AUDIO_RECORDING_EXCEPTION.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                f14144a[b.c.UNAUTHORIZED_URL.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                f14144a[b.c.INVALID_FORMAT.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
        }
    }

    public StreamingManager(Context context) {
        this(context, AVCodecType.HW_AUDIO_CODEC);
    }

    public StreamingManager(Context context, AVCodecType aVCodecType) {
        this.o = false;
        this.p = false;
        this.q = false;
        e eVar = e.d;
        eVar.c("StreamingManager", "created, AVCodecType = " + aVCodecType);
        e.e.c("StreamingManager", h.h(context));
        StreamingEnv.a();
        this.j = context.getApplicationContext();
        this.i = aVCodecType;
        a.a.a.a.a.d.b.a();
        a.a.a.a.a.d.b.a(aVCodecType);
    }

    public final boolean A() {
        if (this.q) {
            this.q = false;
            return J();
        }
        return false;
    }

    public void B() {
        e.d.d("StreamingManager", "signalAudioRecordingException ");
        a.a.a.a.a.a.i.c cVar = this.b;
        if (cVar != null) {
            cVar.c(0);
            a(b.c.AUDIO_RECORDING_EXCEPTION, null);
        }
    }

    public final void C() {
        e.f.c("StreamingManager", "startAudioEncoding");
        a.a.a.a.a.a.e.c cVar = this.f;
        if (cVar != null) {
            cVar.a(this.b);
        }
    }

    public void D() {
        if (this.h != null) {
            this.s = true;
            this.h.a(this.n);
        }
    }

    public final boolean E() {
        e.f.c("StreamingManager", "startStreamingInternal +");
        boolean a2 = this.b.a(this.d);
        if (!a2) {
            e.f.c("StreamingManager", "startStreamingInternal -");
            return false;
        }
        this.f14142a = true;
        C();
        F();
        e eVar = e.f;
        eVar.c("StreamingManager", "startStreamingInternal -, isOk: " + a2);
        return true;
    }

    public void F() {
        if (m()) {
            return;
        }
        this.r = false;
        e eVar = e.f;
        eVar.c("StreamingManager", "startVideoEncoding mCurrentTransferSessionCfg:" + this.n);
        z();
    }

    public final void G() {
        e.f.c("StreamingManager", "stopAudioEncoding");
        a.a.a.a.a.a.e.c cVar = this.f;
        if (cVar != null) {
            cVar.a();
        }
    }

    public void H() {
        if (this.h != null) {
            this.s = false;
            this.h.b(false);
        }
    }

    public final void I() {
        e.f.c("StreamingManager", "stopStreamingInternal +");
        G();
        a(false);
        H();
        a.a.a.a.a.a.i.c cVar = this.b;
        if (cVar != null) {
            cVar.a();
            this.b.a(false);
        }
        e.f.c("StreamingManager", "stopStreamingInternal -");
    }

    public final boolean J() {
        StreamingSessionListener streamingSessionListener = this.l;
        if (streamingSessionListener == null || !streamingSessionListener.onRestartStreamingHandled(0)) {
            return false;
        }
        e.f.c("StreamingManager", "RestartStreamingHandled");
        return true;
    }

    @Override // a.a.a.a.a.a.c
    public void a() {
        e.f.c("StreamingManager", "onEncoderExitDone");
        if (this.s) {
            return;
        }
        this.r = false;
    }

    public final void a(int i, int i2, int i3, boolean z, int i4) {
        e eVar = e.f;
        eVar.c("StreamingManager", "buildTransferSessionConfig width:" + i + ",height:" + i2 + ",rotation:" + i3 + ",mirror:" + z + ",fmt:" + i4);
        boolean q = q();
        this.n = q ? new f.a(this.b, i, i2, -1, z, i3, i4, null, q) : v() ? new f.a(this.b, i, i2, -1, z, i3, i4, null, q) : new f.a(this.b, i, i2, -1, z, i3, PLFourCC.FOURCC_ABGR, null, null, q);
    }

    @Override // a.a.a.a.a.a.b.InterfaceC0000b
    public void a(b.c cVar, Object obj) {
        StreamingState streamingState;
        StreamingState streamingState2 = StreamingState.UNKNOWN;
        e eVar = e.f;
        eVar.b("StreamingManager", "muxerStatusUpdate muxerState:" + cVar + ",isNeedUpdateProfile:" + this.p);
        switch (a.f14144a[cVar.ordinal()]) {
            case 1:
                StreamingState streamingState3 = StreamingState.READY;
                return;
            case 2:
                this.q = false;
                streamingState = StreamingState.PREPARING;
                break;
            case 3:
                streamingState = StreamingState.CONNECTING;
                break;
            case 4:
                streamingState = StreamingState.STREAMING;
                break;
            case 5:
                streamingState = StreamingState.SHUTDOWN;
                try {
                    this.e.getVideoQualityRank().clear();
                } catch (NullPointerException e) {
                    e eVar2 = e.f;
                    eVar2.d("StreamingManager", "Fail:" + e.getMessage());
                }
                this.p = false;
                if (A()) {
                    return;
                }
                break;
            case 6:
                streamingState = StreamingState.IOERROR;
                this.q = true;
                break;
            case 7:
                streamingState = StreamingState.SENDING_BUFFER_EMPTY;
                break;
            case 8:
                streamingState = StreamingState.SENDING_BUFFER_FULL;
                break;
            case 9:
                streamingState = StreamingState.SENDING_BUFFER_HAS_FEW_ITEMS;
                break;
            case 10:
                streamingState = StreamingState.SENDING_BUFFER_HAS_MANY_ITEMS;
                break;
            case 11:
                b();
                streamingState = streamingState2;
                break;
            case 12:
                this.q = true;
                stopStreaming();
                streamingState = StreamingState.DISCONNECTED;
                break;
            case 13:
                stopStreaming();
                streamingState = StreamingState.AUDIO_RECORDING_FAIL;
                break;
            case 14:
                this.q = true;
                stopStreaming();
                streamingState = StreamingState.UNAUTHORIZED_STREAMING_URL;
                break;
            case 15:
                streamingState = StreamingState.INVALID_STREAMING_URL;
                break;
            default:
                streamingState = streamingState2;
                break;
        }
        StreamingStateChangedListener streamingStateChangedListener = this.k;
        if (streamingStateChangedListener == null || this.p) {
            return;
        }
        streamingStateChangedListener.onStateChanged(streamingState, obj);
    }

    public void a(boolean z) {
        e.f.c("StreamingManager", "stopVideoEncoding");
        if (m()) {
            return;
        }
        this.s = z;
        f fVar = this.g;
        if (fVar != null) {
            fVar.b(true);
        }
    }

    public boolean adjustVideoBitrate(int i) {
        StreamingProfile streamingProfile;
        if (!s()) {
            e.d.e("StreamingManager", "Dynamic bitrate is not supported!");
            return false;
        } else if (this.g == null || (streamingProfile = this.e) == null || streamingProfile.getVideoProfile() == null) {
            e.d.e("StreamingManager", "No start streaming!");
            return false;
        } else if (!this.e.b(i)) {
            e.d.e("StreamingManager", "invalid bitrate!");
            return false;
        } else if (this.e.a()) {
            e.d.e("StreamingManager", "adaptive bitrate is enabled, please disable!");
            return false;
        } else if (this.e.b()) {
            this.g.a(i);
            return true;
        } else {
            e.d.e("StreamingManager", "adjust bitrate is not enabled, pls call setAdjustBitrateEnable first ");
            return false;
        }
    }

    public final void b() {
        StreamingProfile streamingProfile;
        if (!s() || this.g == null || (streamingProfile = this.e) == null || streamingProfile.getVideoProfile() == null || this.e.e()) {
            return;
        }
        this.g.a(this.e.getVideoProfile().reqBitrate);
    }

    public final boolean b(int i, int i2, int i3, boolean z, int i4) {
        if (i3 % 90 != 0) {
            throw new IllegalArgumentException("Fatal Error. rotation is illegal:" + i3);
        } else if (c(i, i2, i3, z, i4)) {
            w();
            a(i, i2, i3, z, i4);
            y();
            return false;
        } else {
            return this.g.f();
        }
    }

    public final boolean c() {
        if (this.f14142a) {
            return m() || this.r;
        }
        return false;
    }

    public final boolean c(int i, int i2, int i3, boolean z, int i4) {
        f.a aVar = this.n;
        return (aVar != null && aVar.b * aVar.f1224c == i * i2 && aVar.e == i3 && aVar.f == i4) ? false : true;
    }

    @Override // a.a.a.a.a.a.c
    public void d() {
        e.f.c("StreamingManager", "onEncoderInitDone");
        this.r = true;
    }

    public void destroy() {
        a.a.a.a.a.d.b.i();
        e.d.c("StreamingManager", "destroy");
    }

    public final StreamingProfile e() {
        StreamingProfile streamingProfile = new StreamingProfile();
        streamingProfile.setEncodingSizeLevel(1).setAudioQuality(20).setSendingBufferProfile(new StreamingProfile.SendingBufferProfile(0.2f, 0.8f, 3.0f, 20000L)).setVideoQuality(10);
        return streamingProfile;
    }

    public b f() {
        return this.d;
    }

    public void frameAvailable(boolean z) {
        if (!o()) {
            throw new IllegalStateException("In wrong Encoding Type. Only HW_SCREEN_VIDEO_WITH_HW_AUDIO_CODEC is supported");
        }
        f fVar = this.g;
        if (fVar == null || !this.f14142a) {
            return;
        }
        fVar.c(z);
    }

    public d g() {
        if (this.h == null) {
            d dVar = new d();
            this.h = dVar;
            dVar.a(this.u);
            this.h.a((c) null);
        }
        return this.h;
    }

    public Surface getInputSurface(int i, int i2) {
        if (o()) {
            if (this.g == null || !this.f14142a) {
                return null;
            }
            a(i, i2, 0, false, PLFourCC.FOURCC_ABGR);
            return this.g.b(this.n);
        }
        throw new IllegalStateException("In wrong Encoding Type. Only HW_SCREEN_VIDEO_WITH_HW_AUDIO_CODEC is supported");
    }

    public boolean h() {
        return this.f14142a;
    }

    public final void i() {
        if (!p() || SharedLibraryNameHelper.a(true)) {
            if (t()) {
                e.f.d("StreamingManager", "no need initializeAudio");
            } else if (p()) {
                this.f = new a.a.a.a.a.a.e.e.b();
            } else {
                this.f = new a.a.a.a.a.a.e.d();
            }
        }
    }

    public void inputAudioFrame(ByteBuffer byteBuffer, int i, long j, boolean z) {
        if (this.f == null || !c()) {
            return;
        }
        this.f.a(byteBuffer, i, j, z);
    }

    public void inputAudioFrame(byte[] bArr, long j, boolean z) {
        if (this.f == null || !c()) {
            return;
        }
        this.f.a(bArr, j / 1000, z);
    }

    public void inputVideoFrame(ByteBuffer byteBuffer, int i, int i2, int i3, int i4, boolean z, int i5, long j) {
        if (this.g == null || !this.f14142a) {
            return;
        }
        this.b.c(true);
        if (b(i2, i3, i4, z, i5)) {
            this.g.a(z);
            this.g.a(byteBuffer, i, j);
            this.t = j;
        }
    }

    public void inputVideoFrame(byte[] bArr, int i, int i2, int i3, boolean z, int i4, long j) {
        inputVideoFrame(ByteBuffer.wrap(bArr), bArr.length, i, i2, i3, z, i4, j);
    }

    public final void j() {
        if (this.e.getEncodingOrientation() == null) {
            this.e.setEncodingOrientation(h.c(this.j) ? StreamingProfile.ENCODING_ORIENTATION.LAND : StreamingProfile.ENCODING_ORIENTATION.PORT);
        }
        this.f14143c = a.a.a.a.a.a.e.a.a(this.e.getAudioProfile());
        b bVar = new b(this.j, this);
        this.d = bVar;
        bVar.a(this.e);
        this.d.a(this.e.getVideoEncodingSize(null));
        this.d.a(this.f14143c);
    }

    public final void k() {
        if (m()) {
            a.a.a.a.a.a.i.b bVar = new a.a.a.a.a.a.i.b();
            this.b = bVar;
            bVar.e().f1195a = true;
            this.b.e().b = false;
        } else if (t()) {
            a.a.a.a.a.a.i.d dVar = new a.a.a.a.a.a.i.d();
            this.b = dVar;
            dVar.e().f1195a = false;
            this.b.e().b = true;
        } else {
            a.a.a.a.a.a.i.a aVar = new a.a.a.a.a.a.i.a();
            this.b = aVar;
            aVar.e().f1195a = true;
            this.b.e().b = true;
        }
        this.b.e().f1196c = System.currentTimeMillis();
        StreamStatusCallback streamStatusCallback = this.m;
        if (streamStatusCallback != null) {
            this.b.a(streamStatusCallback);
        }
    }

    public final void l() {
        if (!q() || SharedLibraryNameHelper.c(true)) {
            if (m()) {
                e.f.d("StreamingManager", "no need initializeVideo");
                return;
            }
            if (u()) {
                this.g = new g();
            } else if (o()) {
                this.g = new a.a.a.a.a.a.j.c();
            } else {
                d dVar = new d();
                this.g = dVar;
                dVar.a(this.u);
            }
            this.g.a(this);
            this.f14142a = this.g.f();
        }
    }

    public boolean m() {
        AVCodecType aVCodecType = this.i;
        return aVCodecType == AVCodecType.HW_AUDIO_CODEC || aVCodecType == AVCodecType.SW_AUDIO_CODEC;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0040, code lost:
        if (com.qiniu.pili.droid.streaming.SharedLibraryNameHelper.c(true) != false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean n() {
        /*
            r2 = this;
            r0 = r2
            boolean r0 = r0.m()
            r8 = r0
            r0 = 0
            r7 = r0
            r0 = 0
            r6 = r0
            r0 = 0
            r5 = r0
            r0 = r8
            if (r0 == 0) goto L28
            r0 = r2
            a.a.a.a.a.a.b r0 = r0.d
            boolean r0 = r0.l()
            if (r0 == 0) goto L24
            r0 = 1
            boolean r0 = com.qiniu.pili.droid.streaming.SharedLibraryNameHelper.a(r0)
            if (r0 == 0) goto L26
        L24:
            r0 = 1
            r5 = r0
        L26:
            r0 = r5
            return r0
        L28:
            r0 = r2
            boolean r0 = r0.t()
            if (r0 == 0) goto L47
            r0 = r2
            a.a.a.a.a.a.b r0 = r0.d
            boolean r0 = r0.k()
            if (r0 == 0) goto L43
            r0 = r7
            r5 = r0
            r0 = 1
            boolean r0 = com.qiniu.pili.droid.streaming.SharedLibraryNameHelper.c(r0)
            if (r0 == 0) goto L45
        L43:
            r0 = 1
            r5 = r0
        L45:
            r0 = r5
            return r0
        L47:
            r0 = r2
            a.a.a.a.a.a.b r0 = r0.d
            boolean r0 = r0.l()
            if (r0 == 0) goto L60
            r0 = 1
            boolean r0 = com.qiniu.pili.droid.streaming.SharedLibraryNameHelper.a(r0)
            if (r0 == 0) goto L5b
            goto L60
        L5b:
            r0 = 0
            r3 = r0
            goto L62
        L60:
            r0 = 1
            r3 = r0
        L62:
            r0 = r2
            a.a.a.a.a.a.b r0 = r0.d
            boolean r0 = r0.k()
            if (r0 == 0) goto L7b
            r0 = 1
            boolean r0 = com.qiniu.pili.droid.streaming.SharedLibraryNameHelper.c(r0)
            if (r0 == 0) goto L76
            goto L7b
        L76:
            r0 = 0
            r4 = r0
            goto L7d
        L7b:
            r0 = 1
            r4 = r0
        L7d:
            r0 = r6
            r5 = r0
            r0 = r3
            if (r0 == 0) goto L8d
            r0 = r6
            r5 = r0
            r0 = r4
            if (r0 == 0) goto L8d
            r0 = 1
            r5 = r0
        L8d:
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiniu.pili.droid.streaming.StreamingManager.n():boolean");
    }

    public final boolean o() {
        AVCodecType aVCodecType = this.i;
        return aVCodecType == AVCodecType.HW_VIDEO_SURFACE_AS_INPUT_WITH_HW_AUDIO_CODEC || aVCodecType == AVCodecType.HW_VIDEO_SURFACE_AS_INPUT_WITH_SW_AUDIO_CODEC;
    }

    public final boolean p() {
        AVCodecType aVCodecType = this.i;
        return aVCodecType == AVCodecType.SW_VIDEO_WITH_SW_AUDIO_CODEC || aVCodecType == AVCodecType.SW_AUDIO_CODEC || aVCodecType == AVCodecType.HW_VIDEO_SURFACE_AS_INPUT_WITH_SW_AUDIO_CODEC;
    }

    public void pause() {
        e.d.c("StreamingManager", "pause +");
        this.o = false;
        stopStreaming();
        this.f14142a = false;
        a.a.a.a.a.k.b.b();
        e.d.c("StreamingManager", "pause -");
    }

    public boolean prepare(StreamingProfile streamingProfile) {
        e eVar = e.d;
        eVar.c("StreamingManager", "prepare, profile = " + streamingProfile);
        if (this.o) {
            return false;
        }
        if (streamingProfile != null) {
            this.e = streamingProfile;
            a.a.a.a.a.d.b.a(streamingProfile);
        } else {
            this.e = e();
        }
        j();
        k();
        l();
        i();
        this.o = true;
        return true;
    }

    public final boolean q() {
        AVCodecType aVCodecType = this.i;
        return aVCodecType == AVCodecType.SW_VIDEO_WITH_HW_AUDIO_CODEC || aVCodecType == AVCodecType.SW_VIDEO_WITH_SW_AUDIO_CODEC || aVCodecType == AVCodecType.SW_VIDEO_CODEC;
    }

    public final boolean r() {
        return SharedLibraryNameHelper.e(true) && n();
    }

    public boolean resume() {
        e.d.c("StreamingManager", "resume +");
        a.a.a.a.a.k.b.a(this.j);
        if (this.f == null) {
            e.f1313c.c("StreamingManager", "try to initializeAudio again");
            i();
        }
        StreamingStateChangedListener streamingStateChangedListener = this.k;
        if (streamingStateChangedListener != null) {
            streamingStateChangedListener.onStateChanged(StreamingState.READY, null);
        }
        e.d.c("StreamingManager", "resume -");
        return true;
    }

    public final boolean s() {
        if (q()) {
            return true;
        }
        return h.a();
    }

    public void sendSEIMessage(String str, int i) {
        sendSEIMessage(str, i, this.t);
    }

    public void sendSEIMessage(String str, int i, long j) {
        a.a.a.a.a.f.b.a().a(i);
        a.a.a.a.a.f.b.a().b(0);
        a.a.a.a.a.f.b.a().a(str);
        a.a.a.a.a.f.b.a().a(j);
    }

    public void setNativeLoggingEnabled(boolean z) {
        e.a(z);
    }

    public final void setStreamStatusCallback(StreamStatusCallback streamStatusCallback) {
        e eVar = e.d;
        StringBuilder sb = new StringBuilder();
        sb.append("setStreamStatusCallback ");
        sb.append(streamStatusCallback != null);
        eVar.c("StreamingManager", sb.toString());
        a.a.a.a.a.a.i.c cVar = this.b;
        if (cVar != null) {
            cVar.a(streamStatusCallback);
        } else {
            this.m = streamStatusCallback;
        }
    }

    public void setStreamingProfile(StreamingProfile streamingProfile) {
        if (streamingProfile == null) {
            throw new IllegalArgumentException("Illegal profile:" + streamingProfile);
        }
        e eVar = e.d;
        eVar.c("StreamingManager", "setStreamingProfile profile =" + streamingProfile);
        this.e = streamingProfile;
        this.d.a(streamingProfile);
        a.a.a.a.a.d.b.a(streamingProfile);
    }

    public final void setStreamingSessionListener(StreamingSessionListener streamingSessionListener) {
        e eVar = e.d;
        StringBuilder sb = new StringBuilder();
        sb.append("setStreamingSessionListener ");
        sb.append(streamingSessionListener != null);
        eVar.c("StreamingManager", sb.toString());
        this.l = streamingSessionListener;
    }

    public final void setStreamingStateListener(StreamingStateChangedListener streamingStateChangedListener) {
        e eVar = e.d;
        StringBuilder sb = new StringBuilder();
        sb.append("setStreamingStateListener ");
        sb.append(streamingStateChangedListener != null);
        eVar.c("StreamingManager", sb.toString());
        this.k = streamingStateChangedListener;
    }

    public final void setSurfaceTextureCallback2(SurfaceTextureCallback2 surfaceTextureCallback2) {
        e eVar = e.d;
        StringBuilder sb = new StringBuilder();
        sb.append("setSurfaceTextureCallback2 ");
        sb.append(surfaceTextureCallback2 != null);
        eVar.c("StreamingManager", sb.toString());
        this.u = surfaceTextureCallback2;
        f fVar = this.g;
        if (fVar != null && (fVar instanceof d)) {
            ((d) fVar).a(surfaceTextureCallback2);
        }
        d dVar = this.h;
        if (dVar != null) {
            dVar.a(surfaceTextureCallback2);
        }
    }

    public boolean startStreaming() {
        a.a.a.a.a.d.b.g();
        if (!a.a.a.a.a.n.b.a().b()) {
            e.d.e("StreamingManager", "Authentication failed!!!");
            StreamingStateChangedListener streamingStateChangedListener = this.k;
            if (streamingStateChangedListener != null) {
                streamingStateChangedListener.onStateChanged(StreamingState.UNAUTHORIZED_PACKAGE, null);
                return false;
            }
            return false;
        } else if (r()) {
            e eVar = e.d;
            eVar.c("StreamingManager", "startStreaming mRecordingEnabled=" + this.f14142a);
            if (this.f14142a || !this.d.i()) {
                return false;
            }
            return E();
        } else {
            return false;
        }
    }

    public boolean stopStreaming() {
        if (r()) {
            e eVar = e.d;
            eVar.c("StreamingManager", "stopStreaming mRecordingEnabled:" + this.f14142a + ",mIsInitialized:" + this.o);
            if (this.f14142a) {
                this.f14142a = false;
                I();
                a.a.a.a.a.d.b.h();
                return true;
            }
            return false;
        }
        return false;
    }

    public final boolean t() {
        AVCodecType aVCodecType = this.i;
        return aVCodecType == AVCodecType.SW_VIDEO_CODEC || aVCodecType == AVCodecType.HW_VIDEO_CODEC;
    }

    public final boolean u() {
        return q() || this.i == AVCodecType.HW_VIDEO_YUV_AS_INPUT_WITH_HW_AUDIO_CODEC;
    }

    public void updateEncodingType(AVCodecType aVCodecType) {
        if (aVCodecType == null) {
            throw new IllegalArgumentException("Illegal encoding type:" + aVCodecType);
        }
        e eVar = e.d;
        eVar.c("StreamingManager", "updateEncodingType newType = " + aVCodecType);
        if (aVCodecType != this.i) {
            this.i = aVCodecType;
            k();
            l();
            return;
        }
        throw new IllegalArgumentException("Ignore the same Encoding Type:" + aVCodecType);
    }

    public final boolean v() {
        return this.i == AVCodecType.HW_VIDEO_YUV_AS_INPUT_WITH_HW_AUDIO_CODEC;
    }

    public final void w() {
        e eVar = e.f;
        eVar.c("StreamingManager", "pauseStreaming thread:" + Thread.currentThread().getId());
        a.a.a.a.a.a.i.c cVar = this.b;
        if (cVar != null) {
            cVar.a(true);
        }
        x();
    }

    public final void x() {
        f fVar = this.g;
        if (fVar != null) {
            fVar.b(false);
        }
    }

    public final void y() {
        e eVar = e.f;
        eVar.c("StreamingManager", "resumeStreaming mCurrentTransferSessionCfg:" + this.n);
        z();
        this.b.a(false);
    }

    public final void z() {
        f fVar = this.g;
        if (fVar != null) {
            fVar.a(this.n);
        }
    }
}
