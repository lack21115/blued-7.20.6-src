package com.qiniu.pili.droid.streaming;

import a.a.a.a.a.a.b;
import a.a.a.a.a.a.c;
import a.a.a.a.a.a.j.f;
import a.a.a.a.a.a.j.g;
import a.a.a.a.a.b.c;
import a.a.a.a.a.b.d;
import a.a.a.a.a.e.e;
import a.a.a.a.a.e.h;
import a.a.a.a.a.g.b;
import a.a.a.a.a.i.a;
import android.content.Context;
import android.content.Intent;
import android.hardware.Camera;
import android.opengl.GLSurfaceView;
import android.view.View;
import android.view.ViewGroup;
import com.qiniu.pili.droid.streaming.CameraStreamingSetting;
import com.qiniu.pili.droid.streaming.StreamingProfile;
import com.qiniu.pili.droid.streaming.av.common.PLFourCC;
import com.qiniu.pili.droid.streaming.microphone.AudioMixer;
import com.qiniu.pili.droid.streaming.widget.AspectFrameLayout;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/MediaStreamingManager.class */
public final class MediaStreamingManager implements b.InterfaceC0000b, c, c.j, b.a, a.InterfaceC0010a {
    public volatile boolean A;
    public WeakReference<GLSurfaceView> B;
    public f.a C;
    public boolean D;
    public volatile boolean E;
    public SurfaceTextureCallback2 F;
    public volatile long G;

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f14130a;
    public a.a.a.a.a.a.i.c b;

    /* renamed from: c  reason: collision with root package name */
    public a.a.a.a.a.a.e.a f14131c;
    public a.a.a.a.a.a.b d;
    public CameraStreamingSetting e;
    public MicrophoneStreamingSetting f;
    public StreamingProfile g;
    public a.a.a.a.a.a.e.c h;
    public f i;
    public a.a.a.a.a.b.c j;
    public a.a.a.a.a.g.b k;
    public AVCodecType l;
    public a.a.a.a.a.i.a m;
    public a.a.a.a.a.a.j.h.a n;
    public AudioMixer o;
    public Context p;
    public StreamingStateChangedListener q;
    public StreamingSessionListener r;
    public StreamingPreviewCallback s;
    public StreamStatusCallback t;
    public AudioSourceCallback u;
    public a.a.a.a.a.h.a v;
    public d w;
    public boolean x;
    public boolean y;
    public boolean z;

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/MediaStreamingManager$a.class */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f14132a;

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
            f14132a = iArr;
            try {
                iArr[b.c.READY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f14132a[b.c.PREPARING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f14132a[b.c.CONNECTING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f14132a[b.c.STREAMING.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f14132a[b.c.SHUTDOWN.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f14132a[b.c.IOERROR.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f14132a[b.c.FRAME_QUEUE_EMPTY.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f14132a[b.c.FRAME_QUEUE_FULL.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f14132a[b.c.FRAME_QUEUE_HAS_FEW_ELEMENTS.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f14132a[b.c.FRAME_QUEUE_HAS_MANY_ELEMENTS.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f14132a[b.c.ADJUST_BITRATE.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f14132a[b.c.DISCONNECTED.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                f14132a[b.c.AUDIO_RECORDING_EXCEPTION.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                f14132a[b.c.UNAUTHORIZED_URL.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                f14132a[b.c.INVALID_FORMAT.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
        }
    }

    public MediaStreamingManager(Context context) {
        this.x = false;
        this.y = false;
        this.z = false;
        this.A = false;
        this.D = false;
        e.d.c("MediaStreamingManager", "created, AVCodecType = HW_AUDIO_CODEC");
        a(context);
    }

    public MediaStreamingManager(Context context, GLSurfaceView gLSurfaceView) {
        this(context, (AspectFrameLayout) null, gLSurfaceView);
    }

    public MediaStreamingManager(Context context, GLSurfaceView gLSurfaceView, AVCodecType aVCodecType) {
        this(context, null, gLSurfaceView, aVCodecType);
    }

    public MediaStreamingManager(Context context, AVCodecType aVCodecType) {
        this.x = false;
        this.y = false;
        this.z = false;
        this.A = false;
        this.D = false;
        e eVar = e.d;
        eVar.c("MediaStreamingManager", "created, AVCodecType = " + aVCodecType);
        a(context);
        this.l = aVCodecType;
        a.a.a.a.a.d.b.a(aVCodecType);
        if (!q()) {
            throw new IllegalStateException("Wrong Encoding Type. Ony SW_AUDIO_CODEC and SW_AUDIO_CODEC are accept in this ctor");
        }
    }

    public MediaStreamingManager(Context context, AspectFrameLayout aspectFrameLayout, GLSurfaceView gLSurfaceView) {
        this(context, aspectFrameLayout, gLSurfaceView, AVCodecType.HW_VIDEO_WITH_HW_AUDIO_CODEC);
    }

    public MediaStreamingManager(Context context, AspectFrameLayout aspectFrameLayout, GLSurfaceView gLSurfaceView, AVCodecType aVCodecType) {
        this.x = false;
        this.y = false;
        this.z = false;
        this.A = false;
        this.D = false;
        e eVar = e.d;
        eVar.c("MediaStreamingManager", "created, AVCodecType = " + aVCodecType);
        a(context);
        if (gLSurfaceView == null) {
            throw new IllegalStateException("Error, Illegal AspectFrameLayout Or GLSurfaceView! Cannot be null!");
        }
        this.B = new WeakReference<>(gLSurfaceView);
        this.j = new a.a.a.a.a.b.c(context, aspectFrameLayout, gLSurfaceView, this);
        this.l = aVCodecType;
        a.a.a.a.a.d.b.a(aVCodecType);
    }

    public static boolean isSupportPreviewAppearance() {
        return a.a.a.a.a.a.h.f.a();
    }

    public final boolean A() {
        return this.e.f();
    }

    public final void B() {
        e eVar = e.f;
        eVar.c("MediaStreamingManager", "pauseStreaming thread:" + Thread.currentThread().getId());
        a.a.a.a.a.b.c cVar = this.j;
        if (cVar != null) {
            cVar.b(true);
        }
        a.a.a.a.a.a.i.c cVar2 = this.b;
        if (cVar2 != null) {
            cVar2.a(true);
        }
        f fVar = this.i;
        if (fVar != null) {
            fVar.b(false);
        }
    }

    public final void C() {
        e.f.c("MediaStreamingManager", "resumeStreaming");
        if (this.i != null) {
            D();
        }
        a.a.a.a.a.b.c cVar = this.j;
        if (cVar != null) {
            cVar.b(false);
        }
        this.b.a(false);
    }

    public final void D() {
        this.i.a(this.C);
        this.i.a(this.w.a());
        this.i.a(this.s);
    }

    public final void E() {
        a.a.a.a.a.a.i.c cVar = this.b;
        if (cVar == null || cVar.e() == null) {
            return;
        }
        if (!a.a.a.a.a.k.b.a()) {
            a.a.a.a.a.k.b.a(this.p);
        }
        this.b.e().v = 0L;
        this.b.e().w = 0L;
        this.b.e().t = 0L;
        this.b.e().u = 0L;
        this.b.e().y = 0L;
        this.b.e().x = 0L;
        Intent intent = new Intent("pldroid-qos-filter");
        intent.putExtra("pldroid-qos-msg-type", 163);
        intent.putExtra("videoEncoderType", this.d.m());
        intent.putExtra("audioEncoderType", this.d.n());
        intent.putExtra("videoFps", this.b.e().b ? this.d.r() : 0);
        int i = 0;
        if (this.b.e().f1195a) {
            i = this.d.j().b() / 1000;
        }
        intent.putExtra("audioFps", i);
        intent.putExtra("gopTime", this.b.n());
        a.a.a.a.a.j.a.a().a(intent);
    }

    public final boolean F() {
        if (this.z) {
            this.z = false;
            return O();
        } else if (this.D) {
            this.D = false;
            return N();
        } else {
            return false;
        }
    }

    public final void G() {
        a.a.a.a.a.g.b bVar = this.k;
        if (bVar != null) {
            bVar.a(this.p);
        }
        a.a.a.a.a.a.e.c cVar = this.h;
        if (cVar != null) {
            cVar.a(this.b);
        }
    }

    public final void H() {
        e.d.c("MediaStreamingManager", "startPictureStreaming +");
        this.n.a(this.g.getPictureStreamingFps());
        this.n.e();
        e.d.c("MediaStreamingManager", "startPictureStreaming -");
    }

    public final boolean I() {
        a.a.a.a.a.a.e.c cVar;
        CameraStreamingSetting cameraStreamingSetting;
        StreamingProfile streamingProfile = this.g;
        if (streamingProfile != null && (cameraStreamingSetting = this.e) != null) {
            StreamingProfile.VideoEncodingSize videoEncodingSize = streamingProfile.getVideoEncodingSize(cameraStreamingSetting.getPrvSizeRatio());
            if (this.e.getCameraPreviewWidth() < videoEncodingSize.width && this.e.getCameraPreviewHeight() < videoEncodingSize.height) {
                e eVar = e.f;
                eVar.d("MediaStreamingManager", "Warning: camera preview resolution " + this.e.getCameraPreviewWidth() + " x " + this.e.getCameraPreviewHeight() + " < publish streaming size " + videoEncodingSize.width + " x " + videoEncodingSize.height);
            }
        }
        boolean a2 = this.b.a(this.d);
        e eVar2 = e.f;
        eVar2.c("MediaStreamingManager", "isOK:" + a2);
        if (a2) {
            StreamStatusCallback streamStatusCallback = this.t;
            if (streamStatusCallback != null) {
                this.b.a(streamStatusCallback);
            }
            this.f14130a = true;
            if (q()) {
                G();
                E();
                return true;
            }
            if (A() && (cVar = this.h) != null) {
                cVar.a(this.b);
            }
            J();
            E();
            return true;
        }
        return false;
    }

    public final void J() {
        if (q()) {
            return;
        }
        this.E = false;
        h();
        if (this.i != null) {
            D();
        }
        a.a.a.a.a.i.a aVar = this.m;
        if (aVar != null) {
            aVar.a();
        }
        if (this.j.b()) {
            this.j.a(true);
        } else if (this.A && this.n != null) {
            H();
            G();
        }
        this.A = false;
    }

    public final void K() {
        stopPlayback();
        if (this.k != null && !this.f.c()) {
            this.k.b(this.p);
        }
        a.a.a.a.a.a.e.c cVar = this.h;
        if (cVar != null) {
            cVar.a();
        }
    }

    public final void L() {
        K();
        M();
        a.a.a.a.a.a.i.c cVar = this.b;
        if (cVar != null) {
            cVar.a();
            this.b.a(false);
        }
    }

    public final void M() {
        if (q()) {
            return;
        }
        this.j.a(false);
        if (isPictureStreaming()) {
            a(false);
        }
        a.a.a.a.a.i.a aVar = this.m;
        if (aVar != null) {
            aVar.b();
        }
        f fVar = this.i;
        if (fVar != null) {
            fVar.b(true);
        }
    }

    public final boolean N() {
        this.h = null;
        StreamingSessionListener streamingSessionListener = this.r;
        if (streamingSessionListener != null && streamingSessionListener.onRecordAudioFailedHandled(0)) {
            e.f.c("MediaStreamingManager", "RecordAudioFailedHandled");
            return true;
        } else if (this.h == null) {
            m();
            return false;
        } else {
            return false;
        }
    }

    public final boolean O() {
        StreamingSessionListener streamingSessionListener = this.r;
        if (streamingSessionListener == null || !streamingSessionListener.onRestartStreamingHandled(0)) {
            return false;
        }
        e.f.c("MediaStreamingManager", "RestartStreamingHandled");
        return true;
    }

    public final void P() {
        e.f.c("MediaStreamingManager", "tryResumeStreaming");
        if (!this.f14130a) {
            e.f.d("MediaStreamingManager", "not recording, no need try resuming stream.");
            return;
        }
        if (!this.j.b()) {
            e.f.d("MediaStreamingManager", "preview is not ready yet.");
        }
        C();
    }

    @Override // a.a.a.a.a.a.c
    public void a() {
        e.f.c("MediaStreamingManager", "onEncoderExitDone");
        this.E = false;
    }

    @Override // a.a.a.a.a.b.c.j
    public void a(int i) {
        e eVar = e.f;
        eVar.c("MediaStreamingManager", "openCameraDeviceFailed " + i);
        StreamingStateChangedListener streamingStateChangedListener = this.q;
        if (streamingStateChangedListener != null) {
            streamingStateChangedListener.onStateChanged(StreamingState.OPEN_CAMERA_FAIL, Integer.valueOf(i));
        }
    }

    public final void a(int i, int i2, int i3, boolean z, int i4) {
        f.a aVar;
        int i5 = a.a.a.a.a.b.b.a().b().facing;
        e eVar = e.f;
        eVar.c("MediaStreamingManager", "buildTransferSessionConfig width:" + i + ",height:" + i2 + ",rotation:" + i3 + ",mirror:" + z + ",fmt:" + i4);
        if (v()) {
            aVar = new f.a(this.b, i, i2, i5, z, i3, i4, this.j.b() ? this.j.j().f1253c : null, this.j.i(), this.d.k());
            aVar.a(this.j.a());
        } else {
            aVar = new f.a(this.b, i, i2, i5, z, i3, i4, this.j.i(), this.d.k());
        }
        aVar.n = this.g.getYuvFilterMode().ordinal();
        this.C = aVar;
        a.a.a.a.a.a.j.h.a aVar2 = this.n;
        if (aVar2 == null || !(aVar2 instanceof a.a.a.a.a.a.j.h.c)) {
            return;
        }
        ((a.a.a.a.a.a.j.h.c) aVar2).a(aVar);
    }

    @Override // a.a.a.a.a.b.c.j
    public void a(int i, long j, boolean z) {
        if (this.i != null) {
            if (!this.d.k()) {
                this.b.c(true);
            }
            if ((z() || v()) && !this.e.f()) {
                this.i.a(i, j, z);
                this.G = j;
            }
        }
    }

    @Override // a.a.a.a.a.a.b.InterfaceC0000b
    public void a(b.c cVar, Object obj) {
        StreamingState streamingState;
        StreamingState streamingState2 = StreamingState.UNKNOWN;
        e eVar = e.f;
        eVar.c("MediaStreamingManager", "onStateChanged:" + cVar + ",mNeedUpdateProfile:" + this.y);
        switch (a.f14132a[cVar.ordinal()]) {
            case 1:
                StreamingState streamingState3 = StreamingState.READY;
                return;
            case 2:
                this.z = false;
                streamingState = StreamingState.PREPARING;
                break;
            case 3:
                streamingState = StreamingState.CONNECTING;
                break;
            case 4:
                a.a.a.a.a.f.e.a().b(true);
                streamingState = StreamingState.STREAMING;
                break;
            case 5:
                streamingState = StreamingState.SHUTDOWN;
                try {
                    this.g.getVideoQualityRank().clear();
                } catch (NullPointerException e) {
                    e eVar2 = e.f;
                    eVar2.d("MediaStreamingManager", "Fail:" + e.getMessage());
                }
                this.y = false;
                if (!F()) {
                    a.a.a.a.a.f.e.a().b(false);
                    break;
                } else {
                    return;
                }
            case 6:
                streamingState = StreamingState.IOERROR;
                this.z = true;
                break;
            case 7:
                streamingState = StreamingState.SENDING_BUFFER_EMPTY;
                break;
            case 8:
                streamingState = StreamingState.SENDING_BUFFER_FULL;
                try {
                    this.g.getVideoQualityRank().clear();
                    e.f.c("MediaStreamingManager", "signal many items after rank clear!");
                    a(StreamingState.SENDING_BUFFER_HAS_MANY_ITEMS);
                    return;
                } catch (NullPointerException e2) {
                    e eVar3 = e.f;
                    eVar3.d("MediaStreamingManager", "Fail:" + e2.getMessage());
                    break;
                }
            case 9:
                a(StreamingState.SENDING_BUFFER_HAS_FEW_ITEMS);
                return;
            case 10:
                a(StreamingState.SENDING_BUFFER_HAS_MANY_ITEMS);
                return;
            case 11:
                g();
                return;
            case 12:
                this.z = true;
                this.A = isPictureStreaming();
                stopStreaming();
                streamingState = StreamingState.DISCONNECTED;
                break;
            case 13:
                stopStreaming();
                streamingState = StreamingState.AUDIO_RECORDING_FAIL;
                this.D = true;
                break;
            case 14:
                this.z = true;
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
        StreamingStateChangedListener streamingStateChangedListener = this.q;
        if (streamingStateChangedListener == null || this.y) {
            return;
        }
        streamingStateChangedListener.onStateChanged(streamingState, obj);
    }

    public final void a(Context context) {
        e.e.c("MediaStreamingManager", h.h(context));
        StreamingEnv.a();
        this.p = context.getApplicationContext();
        this.j = null;
        this.l = AVCodecType.HW_AUDIO_CODEC;
        a.a.a.a.a.d.b.a();
    }

    @Override // a.a.a.a.a.b.c.j
    public void a(Camera.Size size) {
        e.f.c("MediaStreamingManager", "notifyPrvSizeChanged");
        a.a.a.a.a.a.b bVar = this.d;
        if (bVar == null) {
            e.f.e("MediaStreamingManager", "mEncodingConfig is null");
        } else if (size != null) {
            bVar.a(new StreamingProfile.VideoEncodingSize(-1, size.width, size.height));
        } else {
            bVar.a(this.e.getPrvSizeRatio());
            this.d.a((StreamingProfile.VideoEncodingSize) null);
        }
    }

    public final void a(StreamingState streamingState) {
        if (this.z) {
            e.f.e("MediaStreamingManager", "had been disconnected!");
            return;
        }
        StreamingStateChangedListener streamingStateChangedListener = this.q;
        if (streamingStateChangedListener != null) {
            streamingStateChangedListener.onStateChanged(streamingState, null);
        }
    }

    public final void a(WatermarkSetting watermarkSetting, PreviewAppearance previewAppearance) {
        if (this.j != null) {
            boolean v = v();
            a.a.a.a.a.f.e.a().c(previewAppearance != null).d(this.e.e()).a(this.l).a(this.e.f());
            this.m = new a.a.a.a.a.i.a(this.p, this.e, v, this);
            this.j.a(this.e, watermarkSetting, previewAppearance, v, this.s);
            this.j.a(this.m);
            p();
        }
    }

    @Override // a.a.a.a.a.g.b.a
    public void a(ByteBuffer byteBuffer, int i, long j, boolean z) {
        if (this.b != null && this.f14130a) {
            this.b.c(false);
        }
        AudioMixer audioMixer = this.o;
        if (audioMixer != null && audioMixer.isRunning()) {
            this.o.a(byteBuffer, byteBuffer, i);
        }
        AudioSourceCallback audioSourceCallback = this.u;
        if (audioSourceCallback != null) {
            audioSourceCallback.onAudioSourceAvailable(byteBuffer, i, j * 1000, z);
        }
        if (this.v != null && this.f14130a) {
            this.v.a(byteBuffer.array(), byteBuffer.arrayOffset(), i);
        }
        if (this.f.c() || this.h == null || !r()) {
            return;
        }
        this.h.a(byteBuffer, i, j, z);
    }

    public final void a(boolean z) {
        e.d.c("MediaStreamingManager", "stopPictureStreaming +");
        this.n.b(z);
        e.d.c("MediaStreamingManager", "stopPictureStreaming -");
    }

    @Override // a.a.a.a.a.b.c.j
    public void a(byte[] bArr, int i, int i2, int i3, int i4, long j, boolean z) {
        StreamingPreviewCallback streamingPreviewCallback = this.s;
        if (streamingPreviewCallback != null) {
            streamingPreviewCallback.onPreviewFrame(bArr, i, i2, i3, i4, j);
        }
        if (this.i != null) {
            if (z) {
                this.b.c(true);
            }
            if (!z || this.e.f()) {
                return;
            }
            this.i.a(bArr, j);
            this.G = j;
        }
    }

    @Override // a.a.a.a.a.i.a.InterfaceC0010a
    public void a(byte[] bArr, int i, int i2, int i3, long j, boolean z) {
        StreamingPreviewCallback streamingPreviewCallback = this.s;
        if (streamingPreviewCallback != null) {
            streamingPreviewCallback.onPreviewFrame(bArr, i, i2, this.j.h(), i3, j);
        }
        if (z) {
            this.b.c(true);
        }
        if (!z || this.e.f()) {
            return;
        }
        this.i.a(bArr, j);
        this.G = j;
    }

    public void addOverlay(View view) {
        addOverlay(view, null);
    }

    public void addOverlay(View view, ViewGroup viewGroup) {
        if (view == null) {
            e.g.d("MediaStreamingManager", "view is null, cannot add");
            return;
        }
        f fVar = this.i;
        if (fVar == null || !(fVar instanceof a.a.a.a.a.a.j.d)) {
            return;
        }
        ((a.a.a.a.a.a.j.d) fVar).a(view, viewGroup);
    }

    public boolean adjustVideoBitrate(int i) {
        StreamingProfile streamingProfile;
        if (!u()) {
            e.d.e("MediaStreamingManager", "Dynamic bitrate is not supported!");
            return false;
        } else if (this.i == null || (streamingProfile = this.g) == null || streamingProfile.getVideoProfile() == null) {
            e.d.e("MediaStreamingManager", "No start streaming!");
            return false;
        } else if (!this.g.b(i)) {
            e.d.e("MediaStreamingManager", "invalid bitrate!");
            return false;
        } else if (this.g.a()) {
            e.d.e("MediaStreamingManager", "adaptive bitrate is enabled, please disable!");
            return false;
        } else if (this.g.b()) {
            this.i.a(i);
            return true;
        } else {
            e.d.e("MediaStreamingManager", "adjust bitrate is not enabled, pls call setAdjustBitrateEnable first ");
            return false;
        }
    }

    @Override // a.a.a.a.a.b.c.j
    public void b() {
        e.f.c("MediaStreamingManager", "doPauseStreaming");
        B();
    }

    @Override // a.a.a.a.a.g.b.a
    public void b(int i) {
        a.a.a.a.a.a.i.c cVar = this.b;
        if (cVar != null) {
            cVar.c(0);
            a(b.c.AUDIO_RECORDING_EXCEPTION, (Object) null);
        }
    }

    public final boolean b(int i, int i2, int i3, boolean z, int i4) {
        if (i3 % 90 != 0) {
            throw new IllegalArgumentException("Fatal Error. rotation is illegal:" + i3);
        } else if (c(i, i2, i3, z, i4)) {
            B();
            a(i, i2, i3, z, i4);
            C();
            return false;
        } else {
            return this.i.f();
        }
    }

    @Override // a.a.a.a.a.b.c.j
    public void c() {
        e.f.c("MediaStreamingManager", "doResumeStreaming");
        if (this.f14130a) {
            h();
            P();
            return;
        }
        StreamingStateChangedListener streamingStateChangedListener = this.q;
        if (streamingStateChangedListener != null) {
            streamingStateChangedListener.onStateChanged(StreamingState.READY, Integer.valueOf(this.e.getReqCameraId()));
        }
    }

    @Override // a.a.a.a.a.g.b.a
    public void c(boolean z) {
        synchronized (this) {
            e eVar = e.f;
            eVar.c("MediaStreamingManager", "notifyFirstAudioFrame: " + z);
            if (this.x) {
                a.a.a.a.a.b.c cVar = this.j;
                if (cVar != null) {
                    cVar.c(!z);
                }
                a.a.a.a.a.i.a aVar = this.m;
                if (aVar != null) {
                    aVar.a(!z);
                }
            }
        }
    }

    public final boolean c(int i, int i2, int i3, boolean z, int i4) {
        f.a aVar = this.C;
        return (aVar != null && aVar.b * aVar.f1224c == i * i2 && aVar.e == i3 && aVar.f == i4) ? false : true;
    }

    public void captureFrame(int i, int i2, FrameCapturedCallback frameCapturedCallback) {
        e eVar = e.d;
        eVar.c("MediaStreamingManager", "captureFrame " + i + "x" + i2);
        if (frameCapturedCallback == null) {
            throw new IllegalArgumentException("callback is null");
        }
        a.a.a.a.a.b.c cVar = this.j;
        if (cVar == null || !cVar.b()) {
            String str = this.j == null ? "camera manager is null" : "camera is not ready";
            e eVar2 = e.d;
            eVar2.e("MediaStreamingManager", "ERROR. capture failed since:" + str);
            frameCapturedCallback.onFrameCaptured(null);
        } else {
            this.j.a(this.d.k(), i, i2, frameCapturedCallback);
        }
        a.a.a.a.a.d.b.m();
    }

    @Override // a.a.a.a.a.a.c
    public void d() {
        e.f.c("MediaStreamingManager", "onEncoderInitDone");
        this.E = true;
    }

    public void destroy() {
        e.d.c("MediaStreamingManager", "destroy +");
        a.a.a.a.a.b.c cVar = this.j;
        if (cVar != null) {
            cVar.l();
        }
        a.a.a.a.a.i.a aVar = this.m;
        if (aVar != null) {
            aVar.d();
        }
        AudioMixer audioMixer = this.o;
        if (audioMixer != null) {
            audioMixer.a();
        }
        this.p = null;
        this.n = null;
        a.a.a.a.a.d.b.f();
        e.d.c("MediaStreamingManager", "destroy -");
    }

    public void doSingleTapUp(int i, int i2) {
        if (this.j != null) {
            e eVar = e.d;
            eVar.c("MediaStreamingManager", "onSingleTapUp x:" + i + ",y:" + i2);
            this.j.a(i, i2);
        }
    }

    @Override // a.a.a.a.a.b.c.j
    public void e() {
        e.f.c("MediaStreamingManager", "notifyFirstEncodingFrame");
        if (!x() && !this.e.f()) {
            G();
            return;
        }
        a.a.a.a.a.b.c cVar = this.j;
        if (cVar != null) {
            cVar.c(true);
        }
        a.a.a.a.a.i.a aVar = this.m;
        if (aVar != null) {
            aVar.a(true);
        }
        e.f.c("MediaStreamingManager", x() ? "pure video streaming" : "capture camera frame only");
    }

    @Override // a.a.a.a.a.b.c.j
    public void f() {
        e.f.c("MediaStreamingManager", "noNV21PrvFormat");
        if (this.q != null) {
            stopStreaming();
            this.q.onStateChanged(StreamingState.NO_NV21_PREVIEW_FORMAT, null);
        }
    }

    public final void g() {
        StreamingProfile streamingProfile;
        if (!u() || this.i == null || (streamingProfile = this.g) == null || streamingProfile.getVideoProfile() == null) {
            return;
        }
        int i = this.g.getVideoProfile().reqBitrate;
        int videoMinBitrate = this.g.getVideoMinBitrate();
        int videoMaxBitrate = this.g.getVideoMaxBitrate();
        if (videoMinBitrate <= 0 || videoMaxBitrate <= 0) {
            videoMinBitrate = i;
            if (this.g.e()) {
                return;
            }
        } else if (i >= videoMinBitrate) {
            videoMinBitrate = i;
            if (i > videoMaxBitrate) {
                videoMinBitrate = videoMaxBitrate;
            }
        }
        this.i.a(videoMinBitrate);
    }

    public AudioMixer getAudioMixer() {
        if (this.f != null) {
            if (this.o == null) {
                this.o = new AudioMixer();
                int reqSampleRate = this.f.getReqSampleRate();
                int i = this.f.getChannelConfig() == 16 ? 1 : 2;
                this.o.a(reqSampleRate, i, 16, i * 2048);
            }
            return this.o;
        }
        return null;
    }

    public int getMaxExposureCompensation() {
        e.d.c("MediaStreamingManager", "getMaxExposureCompensation");
        a.a.a.a.a.b.c cVar = this.j;
        if (cVar == null) {
            e.d.d("MediaStreamingManager", "Pure Audio Streaming can't get exposure compensation");
            return 0;
        }
        return cVar.g();
    }

    public int getMaxZoom() {
        a.a.a.a.a.b.c cVar = this.j;
        if (cVar != null) {
            return cVar.o();
        }
        return 0;
    }

    public int getMinExposureCompensation() {
        e.d.c("MediaStreamingManager", "getMinExposureCompensation");
        a.a.a.a.a.b.c cVar = this.j;
        if (cVar == null) {
            e.d.d("MediaStreamingManager", "Pure Audio Streaming can't get exposure compensation");
            return 0;
        }
        return cVar.f();
    }

    public int getZoom() {
        a.a.a.a.a.b.c cVar = this.j;
        if (cVar != null) {
            return cVar.p();
        }
        return 0;
    }

    public final void h() {
        if (q()) {
            return;
        }
        int cameraPreviewWidth = this.e.getCameraPreviewWidth();
        int cameraPreviewHeight = this.e.getCameraPreviewHeight();
        if (this.e.d()) {
            cameraPreviewWidth = this.e.c();
            cameraPreviewHeight = this.e.b();
        }
        int i = PLFourCC.FOURCC_NV21;
        if (v()) {
            i = PLFourCC.FOURCC_ABGR;
        }
        a(cameraPreviewWidth, cameraPreviewHeight, this.j.h(), w(), i);
    }

    public final boolean i() {
        if (this.d.s() == b.c.CONNECTING || this.d.s() == b.c.PREPARING || this.d.s() == b.c.READY) {
            return false;
        }
        a.a.a.a.a.a.j.h.a aVar = this.n;
        return aVar == null || !aVar.c();
    }

    public void inputAudioFrame(ByteBuffer byteBuffer, int i, long j, boolean z) {
        if (!this.f.c()) {
            e.d.d("MediaStreamingManager", "inputAudioFrame must be called in CaptureAudioFrameOnly");
        } else if (this.h == null || !r()) {
        } else {
            this.h.a(byteBuffer, i, j / 1000, z);
        }
    }

    public void inputAudioFrame(byte[] bArr, long j, boolean z) {
        if (!this.f.c()) {
            e.d.d("MediaStreamingManager", "inputAudioFrame must be called in CaptureAudioFrameOnly");
        } else if (this.h == null || !r()) {
        } else {
            this.h.a(bArr, j / 1000, z);
        }
    }

    public void inputVideoFrame(ByteBuffer byteBuffer, int i, int i2, int i3, int i4, boolean z, int i5, long j) {
        if (!this.e.f()) {
            e.d.d("MediaStreamingManager", "inputVideoFrame must be called in CaptureCameraFrameOnly");
        } else if (this.i != null && this.f14130a && b(i2, i3, i4, z, i5)) {
            setEncodingMirror(z);
            this.i.a(byteBuffer, i, j);
        }
    }

    public void inputVideoFrame(byte[] bArr, int i, int i2, int i3, boolean z, int i4, long j) {
        if (this.e.f()) {
            inputVideoFrame(ByteBuffer.wrap(bArr), bArr.length, i, i2, i3, z, i4, j);
        } else {
            e.d.d("MediaStreamingManager", "inputVideoFrame must be called in CaptureCameraFrameOnly");
        }
    }

    public boolean isPictureStreaming() {
        a.a.a.a.a.a.j.h.a aVar = this.n;
        return aVar != null && aVar.c();
    }

    public boolean isZoomSupported() {
        a.a.a.a.a.b.c cVar = this.j;
        return cVar != null && cVar.n();
    }

    public final CameraStreamingSetting j() {
        CameraStreamingSetting cameraStreamingSetting = new CameraStreamingSetting();
        cameraStreamingSetting.setContinuousFocusModeEnabled(true).setCameraId(0).setCameraPrvSizeRatio(a.a.a.a.a.e.d.f1311c).setCameraPrvSizeLevel(a.a.a.a.a.e.d.d);
        return cameraStreamingSetting;
    }

    public final MicrophoneStreamingSetting k() {
        MicrophoneStreamingSetting microphoneStreamingSetting = new MicrophoneStreamingSetting();
        microphoneStreamingSetting.setBluetoothSCOEnabled(false);
        return microphoneStreamingSetting;
    }

    public final StreamingProfile l() {
        StreamingProfile streamingProfile = new StreamingProfile();
        streamingProfile.setEncodingSizeLevel(1).setAudioQuality(20).setSendingBufferProfile(new StreamingProfile.SendingBufferProfile(0.2f, 0.8f, 3.0f, 20000L)).setVideoQuality(10);
        return streamingProfile;
    }

    public final void m() {
        if (!this.d.l() || SharedLibraryNameHelper.a(true)) {
            if (x()) {
                e.f.d("MediaStreamingManager", "no need initializeAudio");
            } else if (this.d.l()) {
                this.h = new a.a.a.a.a.a.e.e.b();
            } else {
                this.h = new a.a.a.a.a.a.e.d();
            }
        }
    }

    public void mute(boolean z) {
        e eVar = e.d;
        eVar.c("MediaStreamingManager", "mute " + z);
        a.a.a.a.a.g.b bVar = this.k;
        if (bVar != null) {
            bVar.a(z);
        } else {
            e.d.d("MediaStreamingManager", "mute failed, mAudioManager == NULL !");
        }
        AudioMixer audioMixer = this.o;
        if (audioMixer != null) {
            audioMixer.a(z);
        }
        a.a.a.a.a.d.b.a(z);
    }

    public final void n() {
        if (this.g.getEncodingOrientation() == null) {
            this.g.setEncodingOrientation(h.c(this.p) ? StreamingProfile.ENCODING_ORIENTATION.LAND : StreamingProfile.ENCODING_ORIENTATION.PORT);
        }
        if (this.e.getPrvSizeLevel() == null) {
            this.e.setCameraPrvSizeLevel(a.a.a.a.a.e.d.d);
        }
        StreamingProfile.AudioProfile audioProfile = this.g.getAudioProfile();
        MicrophoneStreamingSetting microphoneStreamingSetting = this.f;
        if (microphoneStreamingSetting != null && microphoneStreamingSetting.getChannelConfig() == 12) {
            audioProfile.channelNumber = 2;
        }
        this.f14131c = a.a.a.a.a.a.e.a.a(audioProfile);
        a.a.a.a.a.a.b bVar = new a.a.a.a.a.a.b(this.p, this);
        this.d = bVar;
        bVar.a(this.e.getPrvSizeRatio());
        this.d.a(this.g);
        this.d.a(this.f14131c);
        this.d.a(this.l);
    }

    public void notifyActivityOrientationChanged() {
        e.d.c("MediaStreamingManager", "notifyActivityOrientationChanged");
        a.a.a.a.a.b.c cVar = this.j;
        if (cVar != null) {
            cVar.m();
        }
        a.a.a.a.a.i.a aVar = this.m;
        if (aVar != null) {
            aVar.e();
        }
    }

    public final void o() {
        if (q()) {
            a.a.a.a.a.a.i.b bVar = new a.a.a.a.a.a.i.b();
            this.b = bVar;
            bVar.e().f1195a = true;
            this.b.e().b = false;
        } else if (x()) {
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
        StreamStatusCallback streamStatusCallback = this.t;
        if (streamStatusCallback != null) {
            this.b.a(streamStatusCallback);
        }
        this.b.a(this.p);
        this.b.b(q());
    }

    @Override // a.a.a.a.a.b.c.j
    public int onPreviewFpsSelected(List<int[]> list) {
        StreamingSessionListener streamingSessionListener = this.r;
        if (streamingSessionListener != null) {
            return streamingSessionListener.onPreviewFpsSelected(list);
        }
        return -1;
    }

    @Override // a.a.a.a.a.b.c.j
    public Camera.Size onPreviewSizeSelected(List<Camera.Size> list) {
        StreamingSessionListener streamingSessionListener = this.r;
        if (streamingSessionListener != null) {
            Camera.Size onPreviewSizeSelected = streamingSessionListener.onPreviewSizeSelected(list);
            if (onPreviewSizeSelected != null) {
                e eVar = e.d;
                eVar.c("MediaStreamingManager", "onPreviewSizeSelected: " + onPreviewSizeSelected.width + "x" + onPreviewSizeSelected.height);
            }
            return onPreviewSizeSelected;
        }
        return null;
    }

    @Override // a.a.a.a.a.b.c.j
    public void onStateChanged(StreamingState streamingState, Object obj) {
        e eVar = e.f;
        eVar.c("MediaStreamingManager", "onStateChanged: " + streamingState);
        StreamingStateChangedListener streamingStateChangedListener = this.q;
        if (streamingStateChangedListener != null) {
            streamingStateChangedListener.onStateChanged(streamingState, obj);
        }
    }

    public final void p() {
        if (!this.d.k() || SharedLibraryNameHelper.c(true)) {
            if (q()) {
                e.f.d("MediaStreamingManager", "no need initializeVideo");
                return;
            }
            if (y()) {
                if (z()) {
                    this.i = new a.a.a.a.a.a.j.b();
                } else {
                    this.i = new g();
                }
            } else if (!v()) {
                throw new IllegalArgumentException("Shouldn't invoking here");
            } else {
                a.a.a.a.a.a.j.d dVar = new a.a.a.a.a.a.j.d();
                this.i = dVar;
                dVar.a(this.B);
                ((a.a.a.a.a.a.j.d) this.i).a(this.F);
            }
            this.f14130a = this.i.f();
            this.i.a(this);
            a.a.a.a.a.a.j.a.a().a(this.g.d());
        }
    }

    public void pause() {
        e.d.c("MediaStreamingManager", "pause +");
        a.a.a.a.a.a.i.c cVar = this.b;
        if (cVar != null) {
            cVar.k();
        }
        synchronized (this) {
            this.x = false;
            stopStreaming();
            this.f14130a = false;
            if (this.j != null) {
                this.j.k();
                a.a.a.a.a.d.b.l();
            }
        }
        e.d.c("MediaStreamingManager", "pause -");
    }

    public boolean prepare(CameraStreamingSetting cameraStreamingSetting, MicrophoneStreamingSetting microphoneStreamingSetting, StreamingProfile streamingProfile) {
        return prepare(cameraStreamingSetting, microphoneStreamingSetting, null, streamingProfile, null);
    }

    public boolean prepare(CameraStreamingSetting cameraStreamingSetting, MicrophoneStreamingSetting microphoneStreamingSetting, WatermarkSetting watermarkSetting, StreamingProfile streamingProfile) {
        return prepare(cameraStreamingSetting, microphoneStreamingSetting, watermarkSetting, streamingProfile, null);
    }

    public boolean prepare(CameraStreamingSetting cameraStreamingSetting, MicrophoneStreamingSetting microphoneStreamingSetting, WatermarkSetting watermarkSetting, StreamingProfile streamingProfile, PreviewAppearance previewAppearance) {
        e.d.c("MediaStreamingManager", "prepare, camSetting = " + cameraStreamingSetting + ", microphoneSetting = " + microphoneStreamingSetting + ", wmSetting = " + watermarkSetting + ", profile = " + streamingProfile + ", previewAppearance = " + previewAppearance);
        StreamingEnv.a();
        if (this.x) {
            return false;
        }
        if (cameraStreamingSetting != null) {
            this.e = cameraStreamingSetting;
            a.a.a.a.a.d.b.b();
            a.a.a.a.a.d.b.a(cameraStreamingSetting.getVideoFilterType());
        } else {
            this.e = j();
        }
        if (streamingProfile != null) {
            this.g = streamingProfile;
            a.a.a.a.a.d.b.a(streamingProfile);
        } else {
            this.g = l();
        }
        if (microphoneStreamingSetting != null) {
            this.f = microphoneStreamingSetting;
            a.a.a.a.a.d.b.c();
        } else {
            this.f = k();
        }
        if (watermarkSetting != null) {
            a.a.a.a.a.d.b.a(watermarkSetting);
        }
        n();
        o();
        if (!isSupportPreviewAppearance()) {
            previewAppearance = null;
        }
        a(watermarkSetting, previewAppearance);
        this.k = new a.a.a.a.a.g.b(this.f, this);
        m();
        this.x = true;
        d dVar = new d();
        this.w = dVar;
        dVar.a(this.e.isFrontCameraMirror());
        this.w.b(v());
        this.w.a(this.e.getCameraFacingId());
        return true;
    }

    public boolean prepare(CameraStreamingSetting cameraStreamingSetting, StreamingProfile streamingProfile) {
        return prepare(cameraStreamingSetting, null, streamingProfile);
    }

    public boolean prepare(StreamingProfile streamingProfile) {
        return prepare(null, streamingProfile);
    }

    public final boolean q() {
        AVCodecType aVCodecType = this.l;
        return aVCodecType == AVCodecType.HW_AUDIO_CODEC || aVCodecType == AVCodecType.SW_AUDIO_CODEC;
    }

    public final boolean r() {
        if (this.f14130a) {
            if (q()) {
                return true;
            }
            a.a.a.a.a.b.c cVar = this.j;
            return (cVar != null && cVar.c()) || this.E;
        }
        return false;
    }

    public void refreshOverlay(View view, boolean z) {
        f fVar = this.i;
        if (fVar == null || !(fVar instanceof a.a.a.a.a.a.j.d)) {
            return;
        }
        ((a.a.a.a.a.a.j.d) fVar).a(view, z);
    }

    public void removeAllOverlays() {
        f fVar = this.i;
        if (fVar == null || !(fVar instanceof a.a.a.a.a.a.j.d)) {
            return;
        }
        ((a.a.a.a.a.a.j.d) fVar).a();
    }

    public void removeOverlay(View view) {
        if (view == null) {
            e.g.d("MediaStreamingManager", "view is null, cannot remove");
            return;
        }
        f fVar = this.i;
        if (fVar == null || !(fVar instanceof a.a.a.a.a.a.j.d)) {
            return;
        }
        ((a.a.a.a.a.a.j.d) fVar).a(view);
    }

    public boolean resume() {
        synchronized (this) {
            e.d.c("MediaStreamingManager", "resume +");
            a.a.a.a.a.k.b.a(this.p);
            a.a.a.a.a.a.i.c cVar = this.b;
            if (cVar != null) {
                cVar.l();
            }
            if (this.h == null) {
                e.f.c("MediaStreamingManager", "try to initialize Audio again");
                m();
            }
            this.x = true;
            if (q()) {
                StreamingStateChangedListener streamingStateChangedListener = this.q;
                if (streamingStateChangedListener != null) {
                    streamingStateChangedListener.onStateChanged(StreamingState.READY, null);
                }
                return true;
            }
            boolean a2 = this.j.a(this.d);
            a.a.a.a.a.d.b.k();
            e.d.c("MediaStreamingManager", "resume -");
            return a2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0040, code lost:
        if (com.qiniu.pili.droid.streaming.SharedLibraryNameHelper.c(true) != false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean s() {
        /*
            r2 = this;
            r0 = r2
            boolean r0 = r0.q()
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
            boolean r0 = r0.x()
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
        throw new UnsupportedOperationException("Method not decompiled: com.qiniu.pili.droid.streaming.MediaStreamingManager.s():boolean");
    }

    public void sendSEIMessage(String str, int i) {
        sendSEIMessage(str, i, this.G);
    }

    public void sendSEIMessage(String str, int i, long j) {
        a.a.a.a.a.f.b.a().a(i);
        a.a.a.a.a.f.b.a().b(0);
        a.a.a.a.a.f.b.a().a(str);
        a.a.a.a.a.f.b.a().a(j);
    }

    public final void setAudioSourceCallback(AudioSourceCallback audioSourceCallback) {
        e eVar = e.d;
        StringBuilder sb = new StringBuilder();
        sb.append("setAudioSourceCallback ");
        sb.append(audioSourceCallback != null);
        eVar.c("MediaStreamingManager", sb.toString());
        this.u = audioSourceCallback;
    }

    public void setAutoRefreshOverlay(boolean z) {
        f fVar = this.i;
        if (fVar == null || !(fVar instanceof a.a.a.a.a.a.j.d)) {
            return;
        }
        ((a.a.a.a.a.a.j.d) fVar).d(z);
    }

    public boolean setEncodingMirror(boolean z) {
        e eVar = e.d;
        eVar.c("MediaStreamingManager", "setEncodingMirror " + z);
        f fVar = this.i;
        if (fVar != null) {
            fVar.a(this.w.d(z));
            return true;
        }
        e.d.e("MediaStreamingManager", "setEncodingMirror failed, not allowed in pure audio streaming mode !");
        return false;
    }

    public void setExposureCompensation(int i) {
        e.d.c("MediaStreamingManager", "setExposureCompensation");
        a.a.a.a.a.b.c cVar = this.j;
        if (cVar == null) {
            e.d.d("MediaStreamingManager", "Pure Audio Streaming can't set exposure compensation");
        } else {
            cVar.a(i);
        }
    }

    public void setFocusAreaIndicator(ViewGroup viewGroup, View view) {
        a.a.a.a.a.b.c cVar = this.j;
        if (cVar != null) {
            cVar.a(viewGroup, view);
        }
    }

    public void setNativeLoggingEnabled(boolean z) {
        e.a(z);
    }

    public void setPictureStreamingFilePath(String str) {
        this.g.setPictureStreamingFilePath(str);
        if (isPictureStreaming()) {
            this.n.a(str);
        }
    }

    public void setPictureStreamingResourceId(int i) {
        this.g.setPictureStreamingResourceId(i);
        if (isPictureStreaming()) {
            this.n.a(i);
        }
    }

    public boolean setPreviewMirror(boolean z) {
        e eVar = e.d;
        eVar.c("MediaStreamingManager", "setPreviewMirror " + z);
        a.a.a.a.a.b.c cVar = this.j;
        if (cVar != null) {
            return cVar.e(z);
        }
        e.d.e("MediaStreamingManager", "setPreviewMirror failed, not allowed in pure audio streaming mode !");
        return false;
    }

    public final void setStreamStatusCallback(StreamStatusCallback streamStatusCallback) {
        e eVar = e.d;
        StringBuilder sb = new StringBuilder();
        sb.append("setStreamStatusCallback ");
        sb.append(streamStatusCallback != null);
        eVar.c("MediaStreamingManager", sb.toString());
        if (this.t != streamStatusCallback) {
            this.t = streamStatusCallback;
            a.a.a.a.a.a.i.c cVar = this.b;
            if (cVar != null) {
                cVar.a(streamStatusCallback);
            }
        }
    }

    public final void setStreamingPreviewCallback(StreamingPreviewCallback streamingPreviewCallback) {
        setStreamingPreviewCallback(streamingPreviewCallback, false);
    }

    public final void setStreamingPreviewCallback(StreamingPreviewCallback streamingPreviewCallback, boolean z) {
        e eVar = e.d;
        StringBuilder sb = new StringBuilder();
        sb.append("setStreamingPreviewCallback ");
        sb.append(streamingPreviewCallback != null);
        eVar.c("MediaStreamingManager", sb.toString());
        a.a.a.a.a.b.c cVar = this.j;
        if (cVar != null) {
            cVar.a(streamingPreviewCallback, z);
        }
        this.s = streamingPreviewCallback;
    }

    public void setStreamingProfile(StreamingProfile streamingProfile) {
        e.d.c("MediaStreamingManager", "setStreamingProfile");
        if (streamingProfile != null) {
            this.g = streamingProfile;
            this.d.a(streamingProfile);
            a.a.a.a.a.d.b.a(streamingProfile);
            return;
        }
        throw new IllegalArgumentException("Illegal profile:" + streamingProfile);
    }

    public final void setStreamingSessionListener(StreamingSessionListener streamingSessionListener) {
        e eVar = e.d;
        StringBuilder sb = new StringBuilder();
        sb.append("setStreamingSessionListener ");
        sb.append(streamingSessionListener != null);
        eVar.c("MediaStreamingManager", sb.toString());
        this.r = streamingSessionListener;
    }

    public final void setStreamingStateListener(StreamingStateChangedListener streamingStateChangedListener) {
        e eVar = e.d;
        StringBuilder sb = new StringBuilder();
        sb.append("setStreamingStateListener ");
        sb.append(streamingStateChangedListener != null);
        eVar.c("MediaStreamingManager", sb.toString());
        this.q = streamingStateChangedListener;
    }

    public final void setSurfaceTextureCallback(SurfaceTextureCallback surfaceTextureCallback) {
        e eVar = e.d;
        StringBuilder sb = new StringBuilder();
        sb.append("setSurfaceTextureCallback ");
        sb.append(surfaceTextureCallback != null);
        eVar.c("MediaStreamingManager", sb.toString());
        a.a.a.a.a.b.c cVar = this.j;
        if (cVar != null) {
            cVar.a(surfaceTextureCallback);
        } else {
            e.d.e("MediaStreamingManager", "setSurfaceTextureCallback failed, mCameraManager is null !");
        }
    }

    public final void setSurfaceTextureCallback2(SurfaceTextureCallback2 surfaceTextureCallback2) {
        e eVar = e.d;
        StringBuilder sb = new StringBuilder();
        sb.append("setSurfaceTextureCallback2 ");
        sb.append(surfaceTextureCallback2 != null);
        eVar.c("MediaStreamingManager", sb.toString());
        this.F = surfaceTextureCallback2;
        f fVar = this.i;
        if (fVar == null || !(fVar instanceof a.a.a.a.a.a.j.d)) {
            return;
        }
        ((a.a.a.a.a.a.j.d) fVar).a(surfaceTextureCallback2);
    }

    public void setTextureRotation(int i) {
        this.j.b(i);
    }

    public final void setVideoFilterType(CameraStreamingSetting.VIDEO_FILTER_TYPE video_filter_type) {
        e eVar = e.d;
        eVar.c("MediaStreamingManager", "setVideoFilterType " + video_filter_type);
        if (video_filter_type != null) {
            CameraStreamingSetting cameraStreamingSetting = this.e;
            if (cameraStreamingSetting != null) {
                cameraStreamingSetting.setVideoFilter(video_filter_type);
            }
            a.a.a.a.a.i.a aVar = this.m;
            if (aVar != null) {
                aVar.a(video_filter_type);
            }
            a.a.a.a.a.d.b.a(video_filter_type);
        }
    }

    public void setZoomValue(int i) {
        if (this.j != null) {
            e eVar = e.d;
            eVar.c("MediaStreamingManager", "setZoomValue " + i);
            this.j.c(i);
        }
    }

    public void startMicrophoneRecording() {
        a.a.a.a.a.g.b bVar;
        boolean c2 = this.f.c();
        e eVar = e.d;
        eVar.c("MediaStreamingManager", "startMicrophoneRecording isCaptureAudioFrameOnly = " + c2);
        if (!c2 || (bVar = this.k) == null) {
            return;
        }
        bVar.a(this.p);
    }

    public boolean startPlayback() {
        stopPlayback();
        a.a.a.a.a.h.a aVar = new a.a.a.a.a.h.a();
        this.v = aVar;
        boolean a2 = aVar.a(this.f.getReqSampleRate(), this.f.getChannelConfigOut(), this.k.a());
        if (a2) {
            this.v.b();
        } else {
            e.d.e("MediaStreamingManager", "ERROR. init playback failed");
        }
        a.a.a.a.a.d.b.o();
        return a2;
    }

    public boolean startStreaming() {
        a.a.a.a.a.b.c cVar;
        synchronized (this) {
            if (!a.a.a.a.a.n.b.a().b()) {
                e.d.e("MediaStreamingManager", "Authentication failed!!!");
                StreamingStateChangedListener streamingStateChangedListener = this.q;
                if (streamingStateChangedListener != null) {
                    streamingStateChangedListener.onStateChanged(StreamingState.UNAUTHORIZED_PACKAGE, null);
                }
                return false;
            } else if (!t()) {
                e.d.e("MediaStreamingManager", "streaming core is not available!!!");
                return false;
            } else {
                e eVar = e.d;
                StringBuilder sb = new StringBuilder();
                sb.append("startStreaming  mIsInitialized ");
                sb.append(this.x);
                sb.append(" mRecordingEnabled=");
                sb.append(this.f14130a);
                sb.append(",mIsPreviewReady=");
                a.a.a.a.a.b.c cVar2 = this.j;
                sb.append(cVar2 != null && cVar2.b());
                sb.append(",mDisconnectedWhilePictureStreaming=");
                sb.append(this.A);
                sb.append(",mIsOnlyAudioStreaming=");
                sb.append(this.j == null);
                eVar.c("MediaStreamingManager", sb.toString());
                if (this.x && !this.f14130a && this.d.i() && ((cVar = this.j) == null || cVar.b() || this.A)) {
                    a.a.a.a.a.d.b.d();
                    return I();
                }
                return false;
            }
        }
    }

    public void stopMicrophoneRecording() {
        a.a.a.a.a.g.b bVar;
        boolean c2 = this.f.c();
        e eVar = e.d;
        eVar.c("MediaStreamingManager", "stopMicrophoneRecording isCaptureAudioFrameOnly = " + c2);
        if (!c2 || (bVar = this.k) == null) {
            return;
        }
        bVar.b(this.p);
    }

    public void stopPlayback() {
        a.a.a.a.a.h.a aVar = this.v;
        if (aVar != null) {
            aVar.a();
            this.v = null;
        }
    }

    public boolean stopStreaming() {
        if (!t()) {
            e.d.d("MediaStreamingManager", "stopStreaming ignore, already stopped");
            return false;
        }
        a.a.a.a.a.b.c cVar = this.j;
        boolean z = cVar != null && cVar.c();
        e eVar = e.d;
        eVar.c("MediaStreamingManager", "stopStreaming mRecordingEnabled:" + this.f14130a + ",isCamSwitching=" + z + ",mIsInitialized:" + this.x);
        if (isPictureStreaming()) {
            this.A = true;
        }
        if (this.f14130a) {
            if (!q() && z && this.x) {
                return false;
            }
            this.f14130a = false;
            L();
            a.a.a.a.a.d.b.e();
            return true;
        }
        return false;
    }

    public boolean switchCamera() {
        CameraStreamingSetting.CAMERA_FACING_ID camera_facing_id;
        if (this.j == null) {
            e.d.e("MediaStreamingManager", "switchCamera failed, not allowed in pure audio streaming mode !");
            return false;
        }
        if (this.e.getReqCameraId() == 0) {
            camera_facing_id = CameraStreamingSetting.CAMERA_FACING_ID.CAMERA_FACING_FRONT;
        } else if (this.e.getReqCameraId() != 1) {
            e.d.d("MediaStreamingManager", "switchCamera failed, no more camera device can do switch !");
            return false;
        } else {
            camera_facing_id = CameraStreamingSetting.CAMERA_FACING_ID.CAMERA_FACING_BACK;
        }
        e eVar = e.d;
        eVar.c("MediaStreamingManager", "switchCamera reqCamId = " + camera_facing_id);
        return switchCamera(camera_facing_id);
    }

    public boolean switchCamera(CameraStreamingSetting.CAMERA_FACING_ID camera_facing_id) {
        if (this.j == null) {
            e.d.e("MediaStreamingManager", "switchCamera failed, not allowed in pure audio streaming mode !");
            return false;
        } else if (!i()) {
            e eVar = e.d;
            eVar.d("MediaStreamingManager", "switchCamera failed, muxer state:" + this.d.s());
            return false;
        } else {
            e eVar2 = e.d;
            eVar2.c("MediaStreamingManager", "switchCamera facingId = " + camera_facing_id + "mRecordingEnabled:" + this.f14130a);
            if (this.f14130a) {
                this.j.b(true);
            }
            if (this.j.a(this.d, camera_facing_id)) {
                this.w.a(camera_facing_id);
                this.w.c(true);
                a.a.a.a.a.i.a aVar = this.m;
                if (aVar != null) {
                    aVar.c();
                }
                a.a.a.a.a.d.b.j();
                return true;
            }
            return false;
        }
    }

    public final boolean t() {
        return SharedLibraryNameHelper.e(true) && s();
    }

    public boolean togglePictureStreaming() {
        synchronized (this) {
            String pictureStreamingFilePath = this.g.getPictureStreamingFilePath();
            int pictureStreamingResourceId = this.g.getPictureStreamingResourceId();
            if (pictureStreamingFilePath == null && pictureStreamingResourceId < 0) {
                e.d.d("MediaStreamingManager", "toggle picture streaming failed cause no file set.");
                return false;
            } else if (q()) {
                e.d.d("MediaStreamingManager", "toggle picture streaming failed cause this is a audio only stream");
                return false;
            } else if (!t() || !this.x) {
                e.d.d("MediaStreamingManager", "toggle picture streaming failed cause in invalid state");
                return false;
            } else if (!this.f14130a && v()) {
                e.d.d("MediaStreamingManager", "toggle picture streaming failed cause no recording enabled in TextureMovieVideoType.");
                return false;
            } else {
                if (this.n == null) {
                    if (v()) {
                        this.n = new a.a.a.a.a.a.j.h.b(this.p, this.j, this.d, (a.a.a.a.a.a.j.d) this.i);
                    } else {
                        if (!this.f14130a) {
                            h();
                        }
                        a.a.a.a.a.a.j.h.c cVar = new a.a.a.a.a.a.j.h.c(this.p, this.j, this.d, (g) this.i, this.C, this.s);
                        this.n = cVar;
                        cVar.a(this.f14130a);
                    }
                    if (pictureStreamingFilePath != null) {
                        this.n.a(pictureStreamingFilePath);
                    } else {
                        this.n.a(pictureStreamingResourceId);
                    }
                }
                if (this.n.c()) {
                    a(true);
                } else {
                    H();
                }
                return true;
            }
        }
    }

    public boolean turnLightOff() {
        e.d.c("MediaStreamingManager", "turnLightOff");
        a.a.a.a.a.b.c cVar = this.j;
        if (cVar == null) {
            e.d.d("MediaStreamingManager", "Pure Audio Streaming can't support torch");
            return false;
        }
        return cVar.d();
    }

    public boolean turnLightOn() {
        e.d.c("MediaStreamingManager", "turnLightOn");
        a.a.a.a.a.b.c cVar = this.j;
        if (cVar == null) {
            e.d.d("MediaStreamingManager", "Pure Audio Streaming can't support torch");
            return false;
        }
        return cVar.e();
    }

    public final boolean u() {
        if (this.d.k()) {
            return true;
        }
        return h.a();
    }

    public void updateEncodingType(AVCodecType aVCodecType) {
        e eVar = e.d;
        eVar.c("MediaStreamingManager", "updateEncodingType newType = " + aVCodecType);
        if (aVCodecType == null) {
            e eVar2 = e.d;
            eVar2.d("MediaStreamingManager", "Illegal encoding type:" + aVCodecType);
        } else if (aVCodecType == this.l) {
            e eVar3 = e.d;
            eVar3.d("MediaStreamingManager", "Error.Ignore the same Encoding Type:" + aVCodecType);
        } else {
            this.l = aVCodecType;
            a.a.a.a.a.f.e.a().a(this.l);
            o();
            p();
            a.a.a.a.a.b.c cVar = this.j;
            if (cVar != null) {
                cVar.d(v());
            }
            a.a.a.a.a.a.b bVar = this.d;
            if (bVar != null) {
                bVar.a(this.l);
            }
        }
    }

    public final void updateFaceBeautySetting(CameraStreamingSetting.FaceBeautySetting faceBeautySetting) {
        e eVar = e.d;
        eVar.c("MediaStreamingManager", "updateFaceBeautySetting " + faceBeautySetting);
        a.a.a.a.a.i.a aVar = this.m;
        if (aVar != null) {
            aVar.a(faceBeautySetting);
        }
    }

    public void updateMicrophoneSetting(MicrophoneStreamingSetting microphoneStreamingSetting) {
        this.f = microphoneStreamingSetting;
        this.k = new a.a.a.a.a.g.b(microphoneStreamingSetting, this);
        a.a.a.a.a.d.b.c();
    }

    public final void updateWatermarkSetting(WatermarkSetting watermarkSetting) {
        e eVar = e.d;
        eVar.c("MediaStreamingManager", "updateWatermarkSetting " + watermarkSetting);
        a.a.a.a.a.b.c cVar = this.j;
        if (cVar != null) {
            cVar.a(watermarkSetting);
        }
        f fVar = this.i;
        if (fVar != null) {
            fVar.a(watermarkSetting);
        }
        a.a.a.a.a.d.b.a(watermarkSetting);
    }

    public final boolean v() {
        AVCodecType aVCodecType = this.l;
        return aVCodecType == AVCodecType.HW_VIDEO_WITH_HW_AUDIO_CODEC || aVCodecType == AVCodecType.HW_VIDEO_CODEC || aVCodecType == AVCodecType.HW_VIDEO_SURFACE_AS_INPUT_WITH_HW_AUDIO_CODEC || aVCodecType == AVCodecType.HW_VIDEO_SURFACE_AS_INPUT_WITH_SW_AUDIO_CODEC;
    }

    public final boolean w() {
        return a.a.a.a.a.b.b.a().c() && this.e.isFrontCameraMirror();
    }

    public final boolean x() {
        AVCodecType aVCodecType = this.l;
        return aVCodecType == AVCodecType.SW_VIDEO_CODEC || aVCodecType == AVCodecType.HW_VIDEO_CODEC;
    }

    public final boolean y() {
        return this.d.k() || this.l == AVCodecType.HW_VIDEO_YUV_AS_INPUT_WITH_HW_AUDIO_CODEC;
    }

    public final boolean z() {
        return false;
    }
}
