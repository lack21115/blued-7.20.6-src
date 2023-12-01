package com.tencent.liteav.videoconsumer.decoder;

import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.opengl.GLES11Ext;
import android.opengl.GLES20;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Surface;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.common.EncodedVideoFrame;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.frame.l;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videobase.videobase.h;
import com.tencent.liteav.videoconsumer.consumer.ServerVideoConsumerConfig;
import com.tencent.liteav.videoconsumer.decoder.VideoDecoderDef;
import com.tencent.liteav.videoconsumer.decoder.ay;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/decoder/r.class */
public final class r implements SurfaceTexture.OnFrameAvailableListener, ay {

    /* renamed from: a  reason: collision with root package name */
    private String f23109a;
    private final com.tencent.liteav.base.util.n b;

    /* renamed from: c  reason: collision with root package name */
    private final IVideoReporter f23110c;
    private final JSONArray d;
    private final String e;
    private volatile com.tencent.liteav.base.util.b f;
    private MediaCodec g;
    private az h;
    private final MediaCodec.BufferInfo i;
    private EncodedVideoFrame j;
    private boolean k;
    private com.tencent.liteav.videobase.b.e l;
    private int m;
    private com.tencent.liteav.videobase.frame.l n;
    private SurfaceTexture o;
    private Surface p;
    private VideoDecoderDef.ConsumerScene q;
    private boolean r;
    private final q s;
    private boolean t;
    private MediaFormat u;
    private com.tencent.liteav.videobase.frame.j v;
    private com.tencent.liteav.videobase.frame.e w;
    private final boolean x;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/decoder/r$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public MediaCodec f23111a;
        public h.c b;

        /* renamed from: c  reason: collision with root package name */
        public String f23112c;
        public Exception d;

        private a() {
            this.f23111a = null;
            this.b = null;
            this.f23112c = null;
            this.d = null;
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    public r(MediaFormat mediaFormat, boolean z, JSONArray jSONArray, IVideoReporter iVideoReporter) {
        this(new com.tencent.liteav.base.util.n(mediaFormat.getInteger("width"), mediaFormat.getInteger("height")), mediaFormat.getString(MediaFormat.KEY_MIME), z, jSONArray, iVideoReporter);
        this.u = mediaFormat;
    }

    private r(com.tencent.liteav.base.util.n nVar, String str, boolean z, JSONArray jSONArray, IVideoReporter iVideoReporter) {
        this.f23109a = "HardwareVideoDecoder";
        this.g = null;
        this.i = new MediaCodec.BufferInfo();
        this.j = null;
        this.k = true;
        this.m = -1;
        this.q = VideoDecoderDef.ConsumerScene.UNKNOWN;
        this.r = false;
        this.s = new q();
        this.t = false;
        this.b = new com.tencent.liteav.base.util.n(nVar);
        this.e = str;
        this.f23110c = iVideoReporter;
        this.d = jSONArray;
        this.x = z;
        String str2 = this.f23109a + "_" + hashCode();
        this.f23109a = str2;
        LiteavLog.i(str2, "create decoder isLowLatencyEnabled:" + this.x + ", format: " + this.u + " , params: " + jSONArray);
    }

    public r(com.tencent.liteav.base.util.n nVar, boolean z, boolean z2, JSONArray jSONArray, IVideoReporter iVideoReporter) {
        this(nVar, z ? "video/hevc" : "video/avc", z2, jSONArray, iVideoReporter);
    }

    private PixelFrame a(PixelFrame pixelFrame) {
        int width = pixelFrame.getWidth();
        int height = pixelFrame.getHeight();
        com.tencent.liteav.videobase.frame.j jVar = this.v;
        if (jVar != null) {
            com.tencent.liteav.base.util.n nVar = new com.tencent.liteav.base.util.n(jVar.f22952a, jVar.b);
            if (nVar.f22649a != width || nVar.b != height) {
                this.v.a();
                this.v = null;
            }
        }
        if (this.v == null) {
            this.v = new com.tencent.liteav.videobase.frame.j(width, height);
        }
        if (this.w == null) {
            this.w = new com.tencent.liteav.videobase.frame.e();
        }
        OpenGlUtils.glViewport(0, 0, width, height);
        com.tencent.liteav.videobase.frame.d a2 = this.w.a(width, height);
        this.v.a(pixelFrame, GLConstants.GLScaleType.CENTER_CROP, a2);
        PixelFrame a3 = a2.a(this.l.d());
        GLES20.glFinish();
        a2.release();
        pixelFrame.release();
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:126:0x03d9  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0502 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0181 A[Catch: Exception -> 0x0400, TRY_ENTER, TRY_LEAVE, TryCatch #3 {Exception -> 0x0400, blocks: (B:6:0x0011, B:12:0x001f, B:17:0x003f, B:20:0x0052, B:23:0x00e0, B:25:0x00fa, B:27:0x010b, B:29:0x0115, B:30:0x011c, B:32:0x0135, B:40:0x0148, B:42:0x0150, B:44:0x0158, B:47:0x0166, B:49:0x0174, B:54:0x0181, B:127:0x03da, B:135:0x03ed, B:55:0x018e, B:58:0x01a2, B:60:0x01aa, B:62:0x01b2, B:64:0x01bd, B:66:0x01c4, B:69:0x01d1, B:73:0x0209, B:114:0x0316, B:117:0x032f, B:119:0x0341, B:110:0x0302, B:78:0x022d, B:121:0x0373, B:123:0x03a6, B:124:0x03b2, B:125:0x03cc, B:84:0x0250, B:86:0x0261, B:88:0x0268, B:100:0x02bc, B:102:0x02c3, B:103:0x02d5, B:108:0x02f6, B:129:0x03dc, B:131:0x03e4, B:133:0x03ea, B:34:0x0137, B:35:0x013d), top: B:195:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x018e A[Catch: Exception -> 0x0400, TRY_ENTER, TRY_LEAVE, TryCatch #3 {Exception -> 0x0400, blocks: (B:6:0x0011, B:12:0x001f, B:17:0x003f, B:20:0x0052, B:23:0x00e0, B:25:0x00fa, B:27:0x010b, B:29:0x0115, B:30:0x011c, B:32:0x0135, B:40:0x0148, B:42:0x0150, B:44:0x0158, B:47:0x0166, B:49:0x0174, B:54:0x0181, B:127:0x03da, B:135:0x03ed, B:55:0x018e, B:58:0x01a2, B:60:0x01aa, B:62:0x01b2, B:64:0x01bd, B:66:0x01c4, B:69:0x01d1, B:73:0x0209, B:114:0x0316, B:117:0x032f, B:119:0x0341, B:110:0x0302, B:78:0x022d, B:121:0x0373, B:123:0x03a6, B:124:0x03b2, B:125:0x03cc, B:84:0x0250, B:86:0x0261, B:88:0x0268, B:100:0x02bc, B:102:0x02c3, B:103:0x02d5, B:108:0x02f6, B:129:0x03dc, B:131:0x03e4, B:133:0x03ea, B:34:0x0137, B:35:0x013d), top: B:195:0x0011 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a() {
        /*
            Method dump skipped, instructions count: 1283
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videoconsumer.decoder.r.a():void");
    }

    private void a(MediaCodec mediaCodec) {
        try {
            if (mediaCodec != null) {
                try {
                    try {
                        LiteavLog.i(this.f23109a, "mediaCodec stop");
                        mediaCodec.stop();
                        LiteavLog.i(this.f23109a, "mediaCodec release");
                        mediaCodec.release();
                    } catch (Exception e) {
                        String str = this.f23109a;
                        LiteavLog.e(str, "Stop MediaCodec failed." + e.getMessage());
                        LiteavLog.i(this.f23109a, "mediaCodec release");
                        mediaCodec.release();
                    }
                } catch (Throwable th) {
                    try {
                        LiteavLog.i(this.f23109a, "mediaCodec release");
                        mediaCodec.release();
                    } catch (Exception e2) {
                        LiteavLog.e(this.f23109a, "release MediaCodec failed.", e2);
                    }
                    throw th;
                }
            }
        } catch (Exception e3) {
            LiteavLog.e(this.f23109a, "release MediaCodec failed.", e3);
        }
    }

    private static void a(EncodedVideoFrame encodedVideoFrame) {
        if (encodedVideoFrame == null) {
            return;
        }
        encodedVideoFrame.release();
    }

    private void a(h.c cVar, String str, Object... objArr) {
        this.f23110c.notifyWarning(cVar, str, objArr);
        az azVar = this.h;
        if (azVar != null) {
            azVar.onDecodeFailed();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(r rVar, SurfaceTexture surfaceTexture) {
        SurfaceTexture surfaceTexture2 = rVar.o;
        if (surfaceTexture2 == null || surfaceTexture != surfaceTexture2) {
            LiteavLog.i(rVar.f23109a, "mSurfaceTexture= " + rVar.o + " ,surfaceTexture= " + surfaceTexture);
            return;
        }
        rVar.d();
        l.b bVar = null;
        try {
            bVar = rVar.n.a();
        } catch (InterruptedException e) {
            LiteavLog.w(rVar.f23109a, "textureholderpool obtain interrupted.");
        }
        bVar.a(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, rVar.m, rVar.b.f22649a, rVar.b.b);
        PixelFrame a2 = bVar.a(rVar.l.d());
        if (a2.getMatrix() == null) {
            a2.setMatrix(new float[16]);
        }
        try {
            surfaceTexture.updateTexImage();
            surfaceTexture.getTransformMatrix(a2.getMatrix());
        } catch (Exception e2) {
            LiteavLog.w(rVar.f23109a, "updateTexImage exception: ".concat(String.valueOf(e2)));
        }
        rVar.k = true;
        long millis = TimeUnit.NANOSECONDS.toMillis(surfaceTexture.getTimestamp());
        long j = millis;
        if (millis == 0) {
            j = TimeUnit.MICROSECONDS.toMillis(rVar.i.presentationTimeUs);
        }
        PixelFrame pixelFrame = a2;
        if (LiteavSystemInfo.getSystemOSVersionInt() <= 22) {
            pixelFrame = rVar.a(a2);
        }
        pixelFrame.setTimestamp(j);
        rVar.h.onDecodeFrame(pixelFrame, j);
        bVar.release();
        pixelFrame.release();
        if (rVar.t) {
            rVar.b();
            rVar.t = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(r rVar, ServerVideoConsumerConfig serverVideoConsumerConfig) {
        if (serverVideoConsumerConfig == null) {
            return;
        }
        rVar.r = serverVideoConsumerConfig.enableVui;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(r rVar, Object obj, az azVar) {
        LiteavLog.i(rVar.f23109a, "Start internal");
        if (rVar.l != null) {
            LiteavLog.w(rVar.f23109a, "Decoder already started.");
            return;
        }
        rVar.h = azVar;
        if (rVar.a(obj)) {
            a aVar = new a((byte) 0);
            boolean a2 = rVar.a(aVar, rVar.x);
            if (a2 || rVar.a(aVar, false)) {
                rVar.g = aVar.f23111a;
                az azVar2 = rVar.h;
                if (azVar2 != null) {
                    azVar2.onDecodeLatencyChanged(rVar.x && a2);
                }
                rVar.f23110c.notifyEvent(h.b.EVT_VIDEO_DECODE_START_SUCCESS, "Start decoder success", new Object[0]);
                return;
            }
            h.c cVar = aVar.b;
            rVar.a(cVar, "decoder config fail, message:" + aVar.f23112c + " exception:" + aVar.d.getMessage(), new Object[0]);
        }
    }

    private void a(Runnable runnable) {
        com.tencent.liteav.base.util.b bVar = this.f;
        if (bVar != null) {
            if (bVar.getLooper() == Looper.myLooper()) {
                runnable.run();
            } else {
                bVar.post(runnable);
            }
        }
    }

    private boolean a(a aVar, boolean z) {
        String str;
        MediaFormat mediaFormat = this.u;
        MediaFormat mediaFormat2 = mediaFormat;
        if (mediaFormat == null) {
            mediaFormat2 = MediaFormat.createVideoFormat(this.e, this.b.f22649a, this.b.b);
        }
        if (z) {
            if (LiteavSystemInfo.getSystemOSVersionInt() >= 30) {
                mediaFormat2.setInteger("low-latency", 1);
            }
            if (LiteavSystemInfo.getSystemOSVersionInt() >= 26 && LiteavSystemInfo.getHardware().toLowerCase().contains("qcom")) {
                mediaFormat2.setInteger("vendor.qti-ext-dec-low-latency.enable", 1);
                mediaFormat2.setInteger("vendor.qti-ext-dec-picture-order.enable", 1);
            } else if (LiteavSystemInfo.getSystemOSVersionInt() >= 29 && LiteavSystemInfo.getHardware().toLowerCase().contains("kirin")) {
                mediaFormat2.setInteger("vendor.hisi-ext-low-latency-video-dec.video-scene-for-low-latency-req", 1);
                mediaFormat2.setInteger("vendor.hisi-ext-low-latency-video-dec.video-scene-for-low-latency-rdy", -1);
            } else if (LiteavSystemInfo.getSystemOSVersionInt() >= 26 && LiteavSystemInfo.getHardware().toLowerCase().contains("exynos")) {
                mediaFormat2.setInteger("vendor.rtc-ext-dec-low-latency.enable", 1);
            }
        }
        JSONArray jSONArray = this.d;
        if (jSONArray != null) {
            int i = 0;
            while (true) {
                try {
                    int i2 = i;
                    if (i2 >= jSONArray.length()) {
                        break;
                    }
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    mediaFormat2.setInteger(jSONObject.optString("key"), jSONObject.optInt("value"));
                    i = i2 + 1;
                } catch (JSONException e) {
                    LiteavLog.e("HardwareVideoDecoder", "set MediaCodec device related params failed.", e);
                }
            }
        }
        LiteavLog.i(this.f23109a, "mediaFormat:".concat(String.valueOf(mediaFormat2)));
        try {
            aVar.f23111a = MediaCodec.createDecoderByType(mediaFormat2.getString(MediaFormat.KEY_MIME));
            aVar.f23111a.configure(mediaFormat2, this.p, null, 0);
            aVar.f23111a.setVideoScalingMode(1);
            aVar.f23111a.start();
            LiteavLog.i(this.f23109a, "Start MediaCodec success.");
            return true;
        } catch (Exception e2) {
            LiteavLog.e(this.f23109a, "Start MediaCodec failed.", e2);
            a(aVar.f23111a);
            aVar.f23111a = null;
            h.c cVar = h.c.WARNING_VIDEO_DECODE_START_FAILED;
            if (e2 instanceof IllegalArgumentException) {
                cVar = h.c.WARNING_VIDEO_DECODE_START_FAILED_ILLEGAL_ARGUMENT;
                str = "VideoDecode: illegal argument, Start decoder failed";
            } else if (e2 instanceof IllegalStateException) {
                cVar = h.c.WARNING_VIDEO_DECODE_START_FAILED_ILLEGAL_STATE;
                str = "VideoDecode: illegal state, Start decoder failed";
            } else {
                str = "VideoDecode: Start decoder failed";
            }
            aVar.b = cVar;
            aVar.f23112c = str;
            aVar.d = e2;
            return false;
        }
    }

    private boolean a(Object obj) {
        com.tencent.liteav.videobase.b.e eVar = new com.tencent.liteav.videobase.b.e();
        this.l = eVar;
        try {
            eVar.a(obj, null, 128, 128);
            this.l.a();
            this.m = OpenGlUtils.generateTextureOES();
            this.n = new com.tencent.liteav.videobase.frame.l();
            try {
                this.o = new SurfaceTexture(this.m);
                this.p = new Surface(this.o);
                this.o.setOnFrameAvailableListener(this);
                LiteavLog.i(this.f23109a, "initialize gl components");
                return true;
            } catch (Surface.OutOfResourcesException e) {
                LiteavLog.e(this.f23109a, "create SurfaceTexture failed.", e);
                h.c cVar = h.c.WARNING_VIDEO_DECODE_START_FAILED_INSUFFICIENT_RESOURCE;
                a(cVar, "VideoDecode: insufficient resource, Start decoder failed:" + e.getMessage(), new Object[0]);
                return false;
            }
        } catch (com.tencent.liteav.videobase.b.g e2) {
            LiteavLog.e(this.f23109a, "create EGLCore failed.", e2);
            h.c cVar2 = h.c.WARNING_VIDEO_DECODE_EGL_CORE_CREATE_FAILED;
            a(cVar2, "VideoDecode: create EGLCore failed errorCode:" + e2.mErrorCode, new Object[0]);
            return false;
        }
    }

    private void b() {
        az azVar = this.h;
        if (azVar != null) {
            azVar.onAbandonDecodingFramesCompleted();
        }
    }

    private void c() {
        EncodedVideoFrame encodedVideoFrame;
        synchronized (this) {
            encodedVideoFrame = this.j;
            this.j = null;
        }
        a(encodedVideoFrame);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c(r rVar) {
        rVar.c();
        MediaCodec mediaCodec = rVar.g;
        if (mediaCodec != null) {
            mediaCodec.flush();
        }
        if (rVar.k) {
            rVar.b();
        } else {
            rVar.t = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void d(r rVar) {
        LiteavLog.i(rVar.f23109a, "Stop internal");
        MediaCodec mediaCodec = rVar.g;
        if (mediaCodec != null) {
            rVar.a(mediaCodec);
            rVar.g = null;
        }
        rVar.c();
        LiteavLog.i(rVar.f23109a, "uninitialize gl components");
        if (rVar.d()) {
            com.tencent.liteav.videobase.frame.l lVar = rVar.n;
            if (lVar != null) {
                lVar.b();
            }
            Surface surface = rVar.p;
            if (surface != null) {
                surface.release();
                rVar.p = null;
            }
            SurfaceTexture surfaceTexture = rVar.o;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                rVar.o = null;
            }
            com.tencent.liteav.videobase.frame.e eVar = rVar.w;
            if (eVar != null) {
                eVar.b();
                rVar.w = null;
            }
            com.tencent.liteav.videobase.frame.j jVar = rVar.v;
            if (jVar != null) {
                jVar.a();
                rVar.v = null;
            }
            OpenGlUtils.deleteTexture(rVar.m);
            rVar.m = -1;
            com.tencent.liteav.videobase.b.e.a(rVar.l);
            rVar.l = null;
        }
        rVar.k = true;
    }

    private boolean d() {
        try {
            if (this.l != null) {
                this.l.a();
                return true;
            }
            return true;
        } catch (com.tencent.liteav.videobase.b.g e) {
            LiteavLog.e(this.f23109a, "makeCurrent failed.", e);
            return false;
        }
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.ay
    public final void abandonDecodingFrames() {
        LiteavLog.i(this.f23109a, "flush");
        a(w.a(this));
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.ay
    public final boolean decode(EncodedVideoFrame encodedVideoFrame) {
        synchronized (this) {
            if (this.j != null || encodedVideoFrame == null) {
                a(u.a(this));
                return false;
            }
            this.j = encodedVideoFrame;
            a(v.a(this));
            return true;
        }
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.ay
    public final ay.a getDecoderType() {
        return ay.a.HARDWARE;
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.ay
    public final void initialize() {
        HandlerThread handlerThread = new HandlerThread("HardwareVideoDecoder_" + hashCode());
        handlerThread.start();
        this.f = new com.tencent.liteav.base.util.b(handlerThread.getLooper());
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        a(z.a(this, surfaceTexture));
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.ay
    public final void setScene(VideoDecoderDef.ConsumerScene consumerScene) {
        a(s.a(this, consumerScene));
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.ay
    public final void setServerConfig(ServerVideoConsumerConfig serverVideoConsumerConfig) {
        a(y.a(this, serverVideoConsumerConfig));
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.ay
    public final void start(Object obj, az azVar) {
        a(t.a(this, obj, azVar));
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.ay
    public final void stop() {
        a(x.a(this));
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.ay
    public final void uninitialize() {
        if (this.f != null) {
            LiteavLog.i(this.f23109a, "uninitialize quitLooper");
            this.f.a();
        }
    }
}
