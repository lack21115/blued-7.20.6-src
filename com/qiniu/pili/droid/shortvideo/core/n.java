package com.qiniu.pili.droid.shortvideo.core;

import android.content.Context;
import android.graphics.Rect;
import android.opengl.GLSurfaceView;
import com.qiniu.pili.droid.shortvideo.PLAudioEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLAudioMixMode;
import com.qiniu.pili.droid.shortvideo.PLCameraSetting;
import com.qiniu.pili.droid.shortvideo.PLDisplayMode;
import com.qiniu.pili.droid.shortvideo.PLFaceBeautySetting;
import com.qiniu.pili.droid.shortvideo.PLMediaFile;
import com.qiniu.pili.droid.shortvideo.PLMicrophoneSetting;
import com.qiniu.pili.droid.shortvideo.PLRecordSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoMixSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoSaveListener;
import com.qiniu.pili.droid.shortvideo.core.b;
import java.util.Stack;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/core/n.class */
public class n extends p {
    private String E;

    /* renamed from: a  reason: collision with root package name */
    private Context f27584a;
    private PLVideoMixSetting b;

    /* renamed from: c  reason: collision with root package name */
    private PLVideoEncodeSetting f27585c;
    private PLCameraSetting d;
    private com.qiniu.pili.droid.shortvideo.e.b e;
    private com.qiniu.pili.droid.shortvideo.process.a.f f;
    private PLVideoSaveListener z;
    private boolean A = true;
    private boolean B = false;
    private boolean C = true;
    private Stack<Integer> D = new Stack<>();
    private PLAudioMixMode F = PLAudioMixMode.SPEAKERPHONE_MODE;
    private float G = 1.0f;
    private float H = 1.0f;
    private PLVideoSaveListener I = new PLVideoSaveListener() { // from class: com.qiniu.pili.droid.shortvideo.core.n.1
        @Override // com.qiniu.pili.droid.shortvideo.PLVideoSaveListener
        public void onProgressUpdate(float f) {
            n.this.z.onProgressUpdate(f * 0.0f);
        }

        @Override // com.qiniu.pili.droid.shortvideo.PLVideoSaveListener
        public void onSaveVideoCanceled() {
            n.this.z.onSaveVideoCanceled();
        }

        @Override // com.qiniu.pili.droid.shortvideo.PLVideoSaveListener
        public void onSaveVideoFailed(int i) {
            n.this.z.onSaveVideoFailed(i);
        }

        @Override // com.qiniu.pili.droid.shortvideo.PLVideoSaveListener
        public void onSaveVideoSuccess(String str) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.d;
            eVar.c("ShortVideoMixRecorderCore", "onSaveVideoSuccess : concat save success , the camera video path is " + str);
            n.this.d(str);
        }
    };
    private PLVideoSaveListener J = new PLVideoSaveListener() { // from class: com.qiniu.pili.droid.shortvideo.core.n.2
        @Override // com.qiniu.pili.droid.shortvideo.PLVideoSaveListener
        public void onProgressUpdate(float f) {
            n.this.z.onProgressUpdate((f * 1.0f) + 0.0f);
        }

        @Override // com.qiniu.pili.droid.shortvideo.PLVideoSaveListener
        public void onSaveVideoCanceled() {
            n.this.z.onSaveVideoCanceled();
        }

        @Override // com.qiniu.pili.droid.shortvideo.PLVideoSaveListener
        public void onSaveVideoFailed(int i) {
            n.this.z.onSaveVideoFailed(i);
        }

        @Override // com.qiniu.pili.droid.shortvideo.PLVideoSaveListener
        public void onSaveVideoSuccess(String str) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.d;
            eVar.c("ShortVideoMixRecorderCore", "onSaveVideoSuccess : mix save success , the camera video path is " + str);
            n.this.z.onSaveVideoSuccess(str);
        }
    };

    public n(Context context) {
        this.f27584a = context;
    }

    private void C() {
        if (this.B) {
            this.e.a(0.0f);
            b((String) null);
        } else {
            this.e.a(1.0f);
            PLMediaFile pLMediaFile = new PLMediaFile(this.b.getSampleVideoPath());
            if (pLMediaFile.hasAudio()) {
                a(this.b.getSampleVideoPath(), true);
            }
            pLMediaFile.release();
        }
        a(this.A);
    }

    private boolean D() {
        return (this.B || this.A || this.F != PLAudioMixMode.EARPHONE_MODE) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        com.qiniu.pili.droid.shortvideo.f.e.d.c("ShortVideoMixRecorderCore", "mixVideo +");
        if (this.f == null) {
            this.f = new com.qiniu.pili.droid.shortvideo.process.a.f(this.f27584a, this.b, this.f27585c, str, this.E);
        }
        com.qiniu.pili.droid.shortvideo.transcoder.audio.a aVar = null;
        if (D()) {
            aVar = new com.qiniu.pili.droid.shortvideo.transcoder.audio.a();
            aVar.a(this.b.getSampleVideoPath());
            aVar.a(new com.qiniu.pili.droid.shortvideo.transcoder.audio.c(this.G, this.H));
        }
        this.f.a(aVar);
        this.f.a(this.J);
        com.qiniu.pili.droid.shortvideo.f.e.d.c("ShortVideoMixRecorderCore", "mixVideo -");
    }

    public PLAudioMixMode a() {
        return this.F;
    }

    public void a(float f, float f2) {
        this.G = f;
        this.H = f2;
    }

    public void a(GLSurfaceView gLSurfaceView, GLSurfaceView gLSurfaceView2, PLVideoMixSetting pLVideoMixSetting, PLCameraSetting pLCameraSetting, PLMicrophoneSetting pLMicrophoneSetting, PLVideoEncodeSetting pLVideoEncodeSetting, PLAudioEncodeSetting pLAudioEncodeSetting, PLFaceBeautySetting pLFaceBeautySetting, PLRecordSetting pLRecordSetting) {
        this.d = pLCameraSetting;
        this.b = pLVideoMixSetting;
        this.f27585c = pLVideoEncodeSetting;
        this.E = pLRecordSetting.getVideoFilepath();
        PLVideoEncodeSetting fromSetting = PLVideoEncodeSetting.fromSetting(pLVideoEncodeSetting);
        Rect cameraVideoRect = this.b.getCameraVideoRect();
        fromSetting.setPreferredEncodingSize(cameraVideoRect.width(), cameraVideoRect.height());
        if (cameraVideoRect.width() != fromSetting.getVideoEncodingWidth() || cameraVideoRect.height() != fromSetting.getVideoEncodingHeight()) {
            double calcCameraPreviewSizeRatio = PLCameraSetting.calcCameraPreviewSizeRatio(this.d.getCameraPreviewSizeRatio());
            int videoEncodingWidth = fromSetting.getVideoEncodingWidth();
            int videoEncodingHeight = fromSetting.getVideoEncodingHeight();
            if (pLRecordSetting.getDisplayMode() == PLDisplayMode.FIT) {
                videoEncodingHeight = (int) (videoEncodingWidth * calcCameraPreviewSizeRatio);
            }
            fromSetting.setPreferredEncodingSize(videoEncodingWidth, videoEncodingHeight);
        }
        PLRecordSetting fromSetting2 = PLRecordSetting.fromSetting(pLRecordSetting);
        fromSetting2.setVideoFilepath(pLVideoMixSetting.getCameraRecodingCachePath());
        super.a(gLSurfaceView, pLCameraSetting, pLMicrophoneSetting, fromSetting, pLAudioEncodeSetting, pLFaceBeautySetting, fromSetting2);
        com.qiniu.pili.droid.shortvideo.e.b bVar = new com.qiniu.pili.droid.shortvideo.e.b(gLSurfaceView2);
        this.e = bVar;
        bVar.a(this.b.getSampleVideoPath());
        this.e.b(false);
        this.e.a(this.b.getSampleDisplayMode());
        this.e.a(0.0f);
        this.e.a();
        C();
    }

    public void a(PLAudioMixMode pLAudioMixMode) {
        com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.d;
        eVar.c("ShortVideoMixRecorderCore", "setAudioMixMode : " + pLAudioMixMode);
        this.F = pLAudioMixMode;
    }

    @Override // com.qiniu.pili.droid.shortvideo.core.p, com.qiniu.pili.droid.shortvideo.core.j
    public boolean a(String str) {
        synchronized (this) {
            if (a(b.a.record_video_mix)) {
                this.e.c();
                this.D.push(Integer.valueOf(this.e.i()));
                return super.a(str);
            }
            return false;
        }
    }

    public void b() {
        com.qiniu.pili.droid.shortvideo.f.e.d.c("ShortVideoMixRecorderCore", "cancel +");
        com.qiniu.pili.droid.shortvideo.process.a.f fVar = this.f;
        if (fVar != null) {
            fVar.a();
        } else {
            o();
        }
        com.qiniu.pili.droid.shortvideo.f.e.d.c("ShortVideoMixRecorderCore", "cancel -");
    }

    public void b(PLVideoSaveListener pLVideoSaveListener) {
        com.qiniu.pili.droid.shortvideo.f.e.d.c("ShortVideoMixRecorderCore", "save +");
        this.z = pLVideoSaveListener;
        super.a(this.I);
        com.qiniu.pili.droid.shortvideo.f.e.d.c("ShortVideoMixRecorderCore", "save -");
    }

    public void c(boolean z) {
        com.qiniu.pili.droid.shortvideo.f.e.d.c("ShortVideoMixRecorderCore", "muteMicrophone");
        this.A = z;
        C();
    }

    public void d(boolean z) {
        com.qiniu.pili.droid.shortvideo.f.e.d.c("ShortVideoMixRecorderCore", "muteSampleVideo");
        this.B = z;
        C();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    @Override // com.qiniu.pili.droid.shortvideo.core.p, com.qiniu.pili.droid.shortvideo.core.j
    public JSONObject h() {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    @Override // com.qiniu.pili.droid.shortvideo.core.j
    public boolean m() {
        this.e.b(this.D.pop().intValue());
        return super.m();
    }

    @Override // com.qiniu.pili.droid.shortvideo.core.p, com.qiniu.pili.droid.shortvideo.PLVideoFilterListener
    public void onSurfaceCreated() {
        super.onSurfaceCreated();
        if (this.C) {
            if (!this.B) {
                this.e.a(1.0f);
            }
            this.e.b(1);
            this.C = false;
        }
        this.e.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiniu.pili.droid.shortvideo.core.j
    public void s() {
        synchronized (this) {
            super.s();
            this.e.b();
        }
    }
}
