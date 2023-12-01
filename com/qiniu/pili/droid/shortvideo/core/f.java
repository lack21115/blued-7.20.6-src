package com.qiniu.pili.droid.shortvideo.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.qiniu.pili.droid.shortvideo.PLAudioEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLImageRotateSetting;
import com.qiniu.pili.droid.shortvideo.PLMicrophoneSetting;
import com.qiniu.pili.droid.shortvideo.PLRecordSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoEncodeSetting;
import com.qiniu.pili.droid.shortvideo.core.QosManager;
import com.qiniu.pili.droid.shortvideo.core.b;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/core/f.class */
public final class f extends e {
    private float B;
    private PLImageRotateSetting C;
    private final Object z = new Object();
    private volatile boolean A = false;

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/core/f$a.class */
    class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int videoEncodingWidth = f.this.f13857c.getVideoEncodingWidth();
            int videoEncodingHeight = f.this.f13857c.getVideoEncodingHeight();
            long videoEncodingFps = 1000000 / f.this.f13857c.getVideoEncodingFps();
            com.qiniu.pili.droid.shortvideo.gl.a.d dVar = new com.qiniu.pili.droid.shortvideo.gl.a.d(null, 1);
            com.qiniu.pili.droid.shortvideo.gl.a.f fVar = new com.qiniu.pili.droid.shortvideo.gl.a.f(dVar, f.this.f13856a, false);
            fVar.b();
            Bitmap a2 = com.qiniu.pili.droid.shortvideo.f.d.a(f.this.m, f.this.C.getBackgroundImageUri(), videoEncodingWidth, videoEncodingHeight);
            Bitmap a3 = com.qiniu.pili.droid.shortvideo.f.d.a(f.this.m, f.this.C.getRotateImageUri(), f.this.C.getRotateImageWidth(), f.this.C.getRotateImageHeight());
            int a4 = com.qiniu.pili.droid.shortvideo.f.d.a(a2);
            com.qiniu.pili.droid.shortvideo.gl.c.g a5 = com.qiniu.pili.droid.shortvideo.f.d.a(videoEncodingWidth, videoEncodingHeight);
            com.qiniu.pili.droid.shortvideo.gl.c.d a6 = f.this.a(a3, videoEncodingWidth, videoEncodingHeight);
            a6.c(f.this.B);
            long j = 0;
            while (f.this.d()) {
                double d = j;
                if (d < (f.this.x * 1000000.0d) / f.this.t) {
                    f.this.B += f.this.w();
                    a6.c(f.this.w());
                    GLES20.glClear(16384);
                    a5.b(a6.a(a4));
                    fVar.a(j);
                    fVar.c();
                    f.this.b.a(j);
                    j = (long) (d + ((1000 * videoEncodingFps) / f.this.t));
                } else {
                    f.this.v();
                }
            }
            a5.f();
            a6.f();
            fVar.d();
            dVar.a();
            a3.recycle();
            a2.recycle();
            f.this.A = false;
        }
    }

    public f() {
        com.qiniu.pili.droid.shortvideo.f.e.d.c("ImageRotateRecorderCore", "init");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.qiniu.pili.droid.shortvideo.gl.c.d a(Bitmap bitmap, int i, int i2) {
        float width = bitmap.getWidth() / i;
        float height = bitmap.getHeight() / i2;
        com.qiniu.pili.droid.shortvideo.gl.c.d dVar = new com.qiniu.pili.droid.shortvideo.gl.c.d(bitmap);
        dVar.a(1.0f);
        dVar.b(0.5f - (width / 2.0f), 0.5f - (height / 2.0f));
        dVar.a(i, i2);
        dVar.b();
        return dVar;
    }

    private void u() {
        synchronized (this.z) {
            this.A = true;
            this.z.notify();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        synchronized (this.z) {
            while (!this.A) {
                try {
                    this.z.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.A = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float w() {
        return 360.0f / ((((float) this.C.getCircleTimeMs()) / 1000.0f) * this.f13857c.getVideoEncodingFps());
    }

    @Override // com.qiniu.pili.droid.shortvideo.core.e
    public String a() {
        return "ImageRotateRecorderCore";
    }

    public void a(Context context, PLImageRotateSetting pLImageRotateSetting, PLMicrophoneSetting pLMicrophoneSetting, PLVideoEncodeSetting pLVideoEncodeSetting, PLAudioEncodeSetting pLAudioEncodeSetting, PLRecordSetting pLRecordSetting) {
        com.qiniu.pili.droid.shortvideo.f.e.d.c("ImageRotateRecorderCore", "prepare +");
        l.a(context);
        super.a(context, pLMicrophoneSetting, pLAudioEncodeSetting, pLRecordSetting);
        this.m = context;
        this.f13857c = pLVideoEncodeSetting;
        this.C = pLImageRotateSetting;
        this.b = new com.qiniu.pili.droid.shortvideo.encode.e(pLVideoEncodeSetting);
        this.b.a(this.f);
        com.qiniu.pili.droid.shortvideo.f.e.d.c("ImageRotateRecorderCore", "prepare -");
    }

    @Override // com.qiniu.pili.droid.shortvideo.core.e, com.qiniu.pili.droid.shortvideo.core.j
    public boolean a(String str) {
        synchronized (this) {
            if (a(b.a.record_image_rotate)) {
                return super.a(str);
            }
            return false;
        }
    }

    @Override // com.qiniu.pili.droid.shortvideo.core.e
    public void b() {
        new Thread(new a()).start();
    }

    @Override // com.qiniu.pili.droid.shortvideo.core.e, com.qiniu.pili.droid.shortvideo.core.j
    public boolean c() {
        boolean c2;
        synchronized (this) {
            com.qiniu.pili.droid.shortvideo.f.e.d.c("ImageRotateRecorderCore", "endSection");
            c2 = super.c();
            if (c2) {
                this.d = false;
                this.b.c();
            }
            u();
        }
        return c2;
    }

    @Override // com.qiniu.pili.droid.shortvideo.core.j
    public JSONObject h() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("operation_record_image_rotate", 1);
            jSONObject.put("data_type", QosManager.a.config);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    @Override // com.qiniu.pili.droid.shortvideo.core.j, com.qiniu.pili.droid.shortvideo.PLAudioFrameListener
    public void onAudioFrameAvailable(byte[] bArr, long j) {
        super.onAudioFrameAvailable(bArr, j);
        u();
    }
}
