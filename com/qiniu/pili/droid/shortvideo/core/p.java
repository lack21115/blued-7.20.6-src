package com.qiniu.pili.droid.shortvideo.core;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.view.Surface;
import com.qiniu.pili.droid.shortvideo.PLAudioEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLBuiltinFilter;
import com.qiniu.pili.droid.shortvideo.PLCameraParamSelectListener;
import com.qiniu.pili.droid.shortvideo.PLCameraPreviewListener;
import com.qiniu.pili.droid.shortvideo.PLCameraSetting;
import com.qiniu.pili.droid.shortvideo.PLCaptureFrameListener;
import com.qiniu.pili.droid.shortvideo.PLEffectPlugin;
import com.qiniu.pili.droid.shortvideo.PLFaceBeautySetting;
import com.qiniu.pili.droid.shortvideo.PLFocusListener;
import com.qiniu.pili.droid.shortvideo.PLMicrophoneSetting;
import com.qiniu.pili.droid.shortvideo.PLRecordSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoFilterListener;
import com.qiniu.pili.droid.shortvideo.PLVideoFrame;
import com.qiniu.pili.droid.shortvideo.PLWatermarkSetting;
import com.qiniu.pili.droid.shortvideo.a.a.b;
import com.qiniu.pili.droid.shortvideo.core.b;
import com.qiniu.pili.droid.shortvideo.core.i;
import com.qiniu.pili.droid.shortvideo.encode.SWVideoEncoder;
import com.qiniu.pili.droid.shortvideo.encode.a;
import java.nio.ByteBuffer;
import java.util.List;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/core/p.class */
public class p extends j implements PLVideoFilterListener, b.a, i.a {
    private com.qiniu.pili.droid.shortvideo.gl.texread.d A;
    private com.qiniu.pili.droid.shortvideo.gl.c.k B;
    private com.qiniu.pili.droid.shortvideo.gl.b.b C;
    private com.qiniu.pili.droid.shortvideo.a.a.d D;
    private com.qiniu.pili.droid.shortvideo.process.a.d E;
    private com.qiniu.pili.droid.shortvideo.gl.c.i F;
    private PLVideoFilterListener G;
    private PLFocusListener H;
    private PLCaptureFrameListener I;
    private Object J;
    private PLVideoEncodeSetting K;
    private PLFaceBeautySetting L;
    private PLCameraSetting M;
    private PLEffectPlugin N;
    private volatile boolean O;
    private int Q;
    private long U;
    private volatile boolean X;
    private volatile boolean Y;

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f13902a;
    private volatile boolean b;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f13903c;
    private volatile boolean d;
    private com.qiniu.pili.droid.shortvideo.a.a.b e;
    private com.qiniu.pili.droid.shortvideo.encode.a f;
    private com.qiniu.pili.droid.shortvideo.gl.b.c z;
    private volatile boolean P = true;
    private float R = 1.0f;
    private float S = 1.0f;
    private final Object T = new Object();
    private int V = 0;
    private int W = 0;
    private a.InterfaceC0575a Z = new a.InterfaceC0575a() { // from class: com.qiniu.pili.droid.shortvideo.core.p.1
        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void a(MediaFormat mediaFormat) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.n;
            eVar.c("ShortVideoRecorderCore", "got video format:" + mediaFormat.toString());
            p.this.r.a(mediaFormat);
            p.this.d = true;
            p.this.r();
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void a(Surface surface) {
            synchronized (p.this.T) {
                p.this.z = new com.qiniu.pili.droid.shortvideo.gl.b.c(p.this.J, surface, p.this.K.getVideoEncodingWidth(), p.this.K.getVideoEncodingHeight(), p.this.n.getDisplayMode());
            }
            p.this.z.a(p.this.Q);
            p.this.z.a(p.this.R, p.this.S);
            p.this.z.a();
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void a(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
            if (p.this.l) {
                com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.h;
                eVar.b("ShortVideoRecorderCore", "video encoded frame size:" + bufferInfo.size + " ts:" + bufferInfo.presentationTimeUs);
                p.this.r.a(byteBuffer, bufferInfo);
            }
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void a(boolean z) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.h;
            eVar.c("ShortVideoRecorderCore", "video encoder started: " + z);
            p.this.f13903c = z;
            if (z || p.this.s == null) {
                return;
            }
            p.this.i = false;
            p.this.s.onError(6);
            QosManager.a().a(6);
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void b(boolean z) {
            com.qiniu.pili.droid.shortvideo.f.e.h.c("ShortVideoRecorderCore", "video encoder stopped.");
            if (p.this.z != null) {
                p.this.z.b();
            }
            p.this.f13903c = false;
            p.this.d = false;
            p.this.s();
        }
    };

    public p() {
        com.qiniu.pili.droid.shortvideo.f.e.d.c("ShortVideoRecorderCore", "init");
    }

    private void a(int i, int i2, int i3, long j) {
        int i4 = i;
        if (a()) {
            if (this.F == null) {
                com.qiniu.pili.droid.shortvideo.gl.c.i iVar = new com.qiniu.pili.droid.shortvideo.gl.c.i();
                this.F = iVar;
                iVar.a(this.K.getVideoEncodingWidth(), this.K.getVideoEncodingHeight());
                this.F.b();
            }
            i4 = this.F.a(i);
        }
        if (!this.K.isHWCodecEnabled()) {
            if (this.B == null) {
                com.qiniu.pili.droid.shortvideo.gl.c.k kVar = new com.qiniu.pili.droid.shortvideo.gl.c.k();
                this.B = kVar;
                kVar.a(this.K.getVideoEncodingWidth(), this.K.getVideoEncodingHeight());
                this.B.a(i2, i3, this.n.getDisplayMode());
            }
            int a2 = this.B.a(i4);
            if (this.A == null) {
                this.A = new com.qiniu.pili.droid.shortvideo.gl.texread.d(this.K.getVideoEncodingWidth(), this.K.getVideoEncodingHeight());
            }
            ByteBuffer a3 = this.A.a(a2);
            this.f.a(a3, a3.capacity(), j);
        } else if (this.f.a(j)) {
            long b = j - this.f.b();
            this.z.a(i4, i2, i3, b);
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.h;
            eVar.b("HWVideoEncoder", "input frame texId: " + i4 + " width: " + i2 + " height: " + i3 + " timestampNs:" + b);
        }
        this.U = j;
    }

    private boolean a() {
        if (!this.X || this.Y) {
            return !this.X && this.Y;
        }
        return true;
    }

    private void b(int i, int i2, int i3, long j) {
        com.qiniu.pili.droid.shortvideo.gl.c.l lVar = new com.qiniu.pili.droid.shortvideo.gl.c.l();
        lVar.a(i2, i3);
        lVar.b();
        lVar.a(i);
        PLVideoFrame pLVideoFrame = new PLVideoFrame();
        pLVideoFrame.setWidth(i2);
        pLVideoFrame.setHeight(i3);
        pLVideoFrame.setTimestampMs(j);
        pLVideoFrame.setData(lVar.h());
        pLVideoFrame.setDataFormat(PLVideoFrame.a.ARGB_8888);
        PLCaptureFrameListener pLCaptureFrameListener = this.I;
        if (pLCaptureFrameListener != null) {
            pLCaptureFrameListener.onFrameCaptured(pLVideoFrame);
        }
        lVar.f();
        this.O = false;
        this.P = true;
    }

    public List<Float> A() {
        return this.e.h();
    }

    public void B() {
        if (a(b.a.record_switch_camera)) {
            a((PLCameraSetting.CAMERA_FACING_ID) null);
        }
    }

    public void a(float f) {
        if (a(b.a.record_zoom)) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.d;
            eVar.c("ShortVideoRecorderCore", "setZoom: " + f);
            this.e.a(f);
        }
    }

    @Override // com.qiniu.pili.droid.shortvideo.a.a.b.a
    public void a(int i, int i2, int i3, int i4) {
        if (this.g && !this.b && this.f13902a) {
            this.b = true;
            q();
        }
        this.C.a(i, i2, i3, i4);
    }

    public void a(GLSurfaceView gLSurfaceView, PLCameraSetting pLCameraSetting, PLMicrophoneSetting pLMicrophoneSetting, PLVideoEncodeSetting pLVideoEncodeSetting, PLAudioEncodeSetting pLAudioEncodeSetting, PLFaceBeautySetting pLFaceBeautySetting, PLRecordSetting pLRecordSetting) {
        Context applicationContext = gLSurfaceView.getContext().getApplicationContext();
        this.K = pLVideoEncodeSetting;
        this.L = pLFaceBeautySetting;
        this.M = pLCameraSetting;
        super.a(applicationContext, pLMicrophoneSetting, pLAudioEncodeSetting, pLRecordSetting);
        this.e = new com.qiniu.pili.droid.shortvideo.a.a.b(applicationContext, pLCameraSetting);
        this.C = new com.qiniu.pili.droid.shortvideo.gl.b.b(gLSurfaceView, pLFaceBeautySetting, pLRecordSetting.getDisplayMode());
        this.D = new com.qiniu.pili.droid.shortvideo.a.a.d();
        this.E = new com.qiniu.pili.droid.shortvideo.process.a.d(applicationContext);
        if (pLVideoEncodeSetting.isHWCodecEnabled()) {
            this.f = new com.qiniu.pili.droid.shortvideo.encode.e(pLVideoEncodeSetting);
        } else {
            this.f = new SWVideoEncoder(pLVideoEncodeSetting);
        }
        this.f.a(this.Z);
        this.e.a(this);
        this.e.a(this.H);
        this.C.a(this);
        this.D.a(pLVideoEncodeSetting.getVideoEncodingFps());
    }

    public final void a(PLCameraParamSelectListener pLCameraParamSelectListener) {
        this.e.a(pLCameraParamSelectListener);
    }

    public final void a(PLCameraPreviewListener pLCameraPreviewListener) {
        this.e.a(pLCameraPreviewListener);
    }

    public void a(PLCameraSetting.CAMERA_FACING_ID camera_facing_id) {
        com.qiniu.pili.droid.shortvideo.f.e.d.c("ShortVideoRecorderCore", "switching camera +");
        k();
        this.e.a(camera_facing_id);
        j();
        com.qiniu.pili.droid.shortvideo.f.e.d.c("ShortVideoRecorderCore", "switching camera -");
    }

    public void a(PLCaptureFrameListener pLCaptureFrameListener, boolean z) {
        if (a(b.a.record_capture_frame)) {
            com.qiniu.pili.droid.shortvideo.f.e.d.c("ShortVideoRecorderCore", "captureFrame");
            this.I = pLCaptureFrameListener;
            this.P = z;
            this.O = true;
        }
    }

    public void a(PLEffectPlugin pLEffectPlugin) {
        this.N = pLEffectPlugin;
    }

    public void a(PLFaceBeautySetting pLFaceBeautySetting) {
        if (a(b.a.record_beauty)) {
            this.C.a(pLFaceBeautySetting);
        }
    }

    public void a(PLFocusListener pLFocusListener) {
        if (a(b.a.record_focus)) {
            this.H = pLFocusListener;
            com.qiniu.pili.droid.shortvideo.a.a.b bVar = this.e;
            if (bVar != null) {
                bVar.a(pLFocusListener);
            }
        }
    }

    public final void a(PLVideoFilterListener pLVideoFilterListener, boolean z) {
        if (a(b.a.record_custom_effect)) {
            this.C.a(z);
            this.G = pLVideoFilterListener;
        }
    }

    public void a(PLWatermarkSetting pLWatermarkSetting) {
        if (a(b.a.record_watermark)) {
            com.qiniu.pili.droid.shortvideo.f.e.d.c("ShortVideoRecorderCore", "setWatermark +");
            this.E.a(pLWatermarkSetting);
            com.qiniu.pili.droid.shortvideo.f.e.d.c("ShortVideoRecorderCore", "setWatermark -");
        }
    }

    public boolean a(GLSurfaceView gLSurfaceView, com.qiniu.pili.droid.shortvideo.f.b bVar) {
        if (bVar == null) {
            com.qiniu.pili.droid.shortvideo.f.e.d.e("ShortVideoRecorderCore", "Error on recoverFromDraft, null draft");
            return false;
        }
        this.M = bVar.c();
        this.o = bVar.d();
        this.K = bVar.e();
        this.p = bVar.f();
        this.L = bVar.g();
        this.n = bVar.h();
        a(gLSurfaceView, this.M, this.o, this.K, this.p, this.L, this.n);
        this.r = g();
        this.r.a(this.n.getMaxRecordDuration());
        this.r.a(this);
        return this.r.a(bVar);
    }

    @Override // com.qiniu.pili.droid.shortvideo.core.j
    public boolean a(String str) {
        synchronized (this) {
            if (a(b.a.record_camera_capture)) {
                boolean a2 = super.a(str);
                if (a2) {
                    this.f.a(this.t);
                    this.f.a();
                }
                return a2;
            }
            return false;
        }
    }

    public void b(float f, float f2) {
        if (f <= 0.0f || f2 <= 0.0f) {
            com.qiniu.pili.droid.shortvideo.f.e.d.e("ShortVideoRecorderCore", "setTextureScale failed, params must be greater than 0!");
            return;
        }
        this.C.a(f, f2);
        synchronized (this.T) {
            if (this.z != null) {
                this.z.a(f, f2);
            } else {
                this.R = f;
                this.S = f2;
            }
        }
    }

    public void b(int i) {
        this.C.a(i);
        synchronized (this.T) {
            if (this.z != null) {
                this.z.a(i);
            } else {
                this.Q = i;
            }
        }
    }

    public void b(int i, int i2, int i3, int i4) {
        if (a(b.a.record_focus)) {
            com.qiniu.pili.droid.shortvideo.f.e.d.c("ShortVideoRecorderCore", "manualFocus");
            com.qiniu.pili.droid.shortvideo.a.a.b bVar = this.e;
            if (bVar != null) {
                bVar.a(i, i2, i3, i4);
            }
        }
    }

    public void b(String str, boolean z) {
        if (u.a().a(b.a.record_filter)) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.d;
            eVar.c("ShortVideoRecorderCore", "setFilter: " + str);
            this.E.a(str, z);
        }
    }

    @Override // com.qiniu.pili.droid.shortvideo.core.j
    public void b(boolean z) {
        super.b(z);
        this.e.b();
    }

    public void c(int i) {
        if (a(b.a.record_exposure)) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.d;
            eVar.c("ShortVideoRecorderCore", "setExposureCompensation: " + i);
            this.e.a(i);
        }
    }

    @Override // com.qiniu.pili.droid.shortvideo.core.j
    public boolean c() {
        boolean c2;
        synchronized (this) {
            c2 = super.c();
            if (c2) {
                this.f13903c = false;
                this.f.c();
                this.U = 0L;
                this.V = 0;
                this.W = 0;
            }
        }
        return c2;
    }

    @Override // com.qiniu.pili.droid.shortvideo.core.j
    public boolean c(String str) {
        if (a(b.a.draftbox)) {
            return this.r.a(str, this.M, this.o, this.K, this.p, this.L, this.n);
        }
        return false;
    }

    @Override // com.qiniu.pili.droid.shortvideo.core.j
    protected boolean d() {
        return this.f13903c && this.j;
    }

    public void e(boolean z) {
        if (a(b.a.record_mirror)) {
            this.X = z;
            com.qiniu.pili.droid.shortvideo.gl.b.b bVar = this.C;
            if (bVar == null) {
                com.qiniu.pili.droid.shortvideo.f.e.d.e("ShortVideoRecorderCore", "setMirrorForPreview failed : you must prepare first");
                return;
            }
            bVar.b(z);
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.d;
            eVar.c("ShortVideoRecorderCore", "setMirrorForPreview : " + z);
        }
    }

    @Override // com.qiniu.pili.droid.shortvideo.core.j
    protected boolean e() {
        return this.d && this.k;
    }

    public void f(boolean z) {
        if (a(b.a.record_mirror)) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.d;
            eVar.c("ShortVideoRecorderCore", "setMirrorForEncode : " + z);
            this.Y = z;
        }
    }

    @Override // com.qiniu.pili.droid.shortvideo.core.j
    protected boolean f() {
        return (this.d || this.k) ? false : true;
    }

    @Override // com.qiniu.pili.droid.shortvideo.core.j
    protected i g() {
        return new i(this.m, this.n, this.p, this.K);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    @Override // com.qiniu.pili.droid.shortvideo.core.j
    public JSONObject h() {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    @Override // com.qiniu.pili.droid.shortvideo.core.j
    public void j() {
        super.j();
        this.C.a();
    }

    @Override // com.qiniu.pili.droid.shortvideo.core.j
    public void k() {
        super.k();
        this.b = false;
        this.d = false;
        com.qiniu.pili.droid.shortvideo.gl.b.c cVar = this.z;
        if (cVar != null) {
            cVar.c();
        }
        this.C.b();
        this.e.a();
    }

    @Override // com.qiniu.pili.droid.shortvideo.core.j
    protected boolean l() {
        return this.b && this.h;
    }

    @Override // com.qiniu.pili.droid.shortvideo.PLVideoFilterListener
    public int onDrawFrame(int i, int i2, int i3, long j, float[] fArr) {
        int a2;
        if (this.O && !this.P) {
            b(i, i2, i3, j);
        }
        PLEffectPlugin pLEffectPlugin = this.N;
        if (pLEffectPlugin != null) {
            i = pLEffectPlugin.onDrawFrame(i, i2, i3, j, fArr);
        }
        synchronized (com.qiniu.pili.droid.shortvideo.f.d.f13982a) {
            int i4 = i;
            if (this.G != null) {
                int onDrawFrame = this.G.onDrawFrame(i, i2, i3, j, fArr);
                i4 = i;
                if (onDrawFrame > 0) {
                    i4 = onDrawFrame;
                }
            }
            if (!this.E.i()) {
                this.E.a(i2, i3);
            }
            a2 = this.E.a(i4);
            GLES20.glFinish();
        }
        if (this.O && this.P) {
            b(a2, i2, i3, j);
        }
        if (this.f13903c && this.j && !this.D.a()) {
            long j2 = (long) (j / this.t);
            com.qiniu.pili.droid.shortvideo.f.e.d.a("ShortVideoRecorderCore", "video frame captured texId:" + a2 + " width:" + i2 + " height:" + i3 + " ts:" + j2);
            if (this.K.IsConstFrameRateEnabled()) {
                int videoEncodingFps = this.K.getVideoEncodingFps();
                long j3 = (j2 - this.U) / 1000000;
                if (this.t > 1.0d) {
                    if (((float) j3) < 1000.0f / (videoEncodingFps * 1.3f)) {
                        com.qiniu.pili.droid.shortvideo.f.e.d.a("ShortVideoRecorderCore", "Abandoned frame for timestamp:" + j2 + ", LastTimeStamp: " + this.U + "; delta" + j3 + "; count:" + this.V);
                        this.V = this.V + 1;
                        return a2;
                    }
                } else if (this.t < 1.0d && this.W != 0) {
                    com.qiniu.pili.droid.shortvideo.f.e.d.a("ShortVideoRecorderCore", "Init Delta value:" + j3);
                    while (((float) j3) > 1000.0f / (videoEncodingFps * 0.7f)) {
                        j3 /= 2;
                    }
                    long j4 = j3 * 1000000;
                    long j5 = this.U + j4;
                    com.qiniu.pili.droid.shortvideo.f.e.d.a("ShortVideoRecorderCore", "Final Delta value:" + j3 + "; Target timestamp:" + j5 + "; End:" + j2);
                    long j6 = j5;
                    while (j6 < j2) {
                        j6 += j4;
                        com.qiniu.pili.droid.shortvideo.f.e.d.a("ShortVideoRecorderCore", "Inserted frame timestamp: " + j6);
                        a(a2, i2, i3, j6);
                    }
                }
                this.W++;
            }
            com.qiniu.pili.droid.shortvideo.f.e.f.a("ShortVideoRecorderCore", "video frame captured texId:" + a2 + " width:" + i2 + " height:" + i3 + " ts:" + j2);
            a(a2, i2, i3, j2);
        }
        return a2;
    }

    @Override // com.qiniu.pili.droid.shortvideo.PLVideoFilterListener
    public void onSurfaceChanged(int i, int i2) {
        this.e.a(i, i2);
        PLEffectPlugin pLEffectPlugin = this.N;
        if (pLEffectPlugin != null) {
            pLEffectPlugin.onSurfaceChanged(i, i2);
        }
        PLVideoFilterListener pLVideoFilterListener = this.G;
        if (pLVideoFilterListener != null) {
            pLVideoFilterListener.onSurfaceChanged(i, i2);
        }
    }

    public void onSurfaceCreated() {
        if (this.e.a(this.C.c())) {
            this.J = com.qiniu.pili.droid.shortvideo.gl.a.d.b();
        } else if (this.s != null) {
            this.s.onError(4);
            QosManager.a().a(4);
        }
        PLEffectPlugin pLEffectPlugin = this.N;
        if (pLEffectPlugin != null) {
            pLEffectPlugin.onSurfaceCreated();
        }
        PLVideoFilterListener pLVideoFilterListener = this.G;
        if (pLVideoFilterListener != null) {
            pLVideoFilterListener.onSurfaceCreated();
        }
        this.f13902a = true;
    }

    @Override // com.qiniu.pili.droid.shortvideo.PLVideoFilterListener
    public void onSurfaceDestroy() {
        this.E.j();
        PLEffectPlugin pLEffectPlugin = this.N;
        if (pLEffectPlugin != null) {
            pLEffectPlugin.onSurfaceDestroy();
        }
        PLVideoFilterListener pLVideoFilterListener = this.G;
        if (pLVideoFilterListener != null) {
            pLVideoFilterListener.onSurfaceDestroy();
        }
        this.f13902a = false;
        com.qiniu.pili.droid.shortvideo.gl.texread.d dVar = this.A;
        if (dVar != null) {
            dVar.a();
            this.A = null;
        }
        com.qiniu.pili.droid.shortvideo.gl.c.k kVar = this.B;
        if (kVar != null) {
            kVar.f();
            this.B = null;
        }
        com.qiniu.pili.droid.shortvideo.gl.c.i iVar = this.F;
        if (iVar != null) {
            iVar.f();
            this.F = null;
        }
    }

    public PLBuiltinFilter[] u() {
        return this.E.a();
    }

    public boolean v() {
        if (a(b.a.record_flash)) {
            com.qiniu.pili.droid.shortvideo.f.e.d.c("ShortVideoRecorderCore", "turnLightOn");
            return this.e.c();
        }
        return false;
    }

    public boolean w() {
        if (a(b.a.record_flash)) {
            com.qiniu.pili.droid.shortvideo.f.e.d.c("ShortVideoRecorderCore", "turnLightOff");
            return this.e.d();
        }
        return false;
    }

    public boolean x() {
        return this.e.e();
    }

    public int y() {
        return this.e.f();
    }

    public int z() {
        return this.e.g();
    }
}
