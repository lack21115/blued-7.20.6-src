package com.qiniu.pili.droid.shortvideo.core;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.view.Surface;
import android.view.View;
import com.qiniu.pili.droid.shortvideo.PLAudioEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLMicrophoneSetting;
import com.qiniu.pili.droid.shortvideo.PLRecordSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoEncodeSetting;
import com.qiniu.pili.droid.shortvideo.core.QosManager;
import com.qiniu.pili.droid.shortvideo.core.b;
import com.qiniu.pili.droid.shortvideo.encode.SWVideoEncoder;
import java.nio.ByteBuffer;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/core/t.class */
public final class t extends e {
    private final Object A = new Object();
    private volatile boolean B = false;
    private View z;

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/core/t$a.class */
    class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SurfaceTexture surfaceTexture;
            Surface surface;
            com.qiniu.pili.droid.shortvideo.a.a.d dVar = new com.qiniu.pili.droid.shortvideo.a.a.d();
            dVar.a(t.this.f27545c.getVideoEncodingFps());
            int videoEncodingWidth = t.this.f27545c.getVideoEncodingWidth();
            int videoEncodingHeight = t.this.f27545c.getVideoEncodingHeight();
            com.qiniu.pili.droid.shortvideo.gl.texread.d dVar2 = null;
            if (t.this.f27545c.isHWCodecEnabled()) {
                surfaceTexture = null;
                surface = null;
            } else {
                surfaceTexture = new SurfaceTexture(0);
                surface = new Surface(surfaceTexture);
                t.this.f27544a = surface;
            }
            com.qiniu.pili.droid.shortvideo.gl.a.d dVar3 = new com.qiniu.pili.droid.shortvideo.gl.a.d(null, 1);
            com.qiniu.pili.droid.shortvideo.gl.a.f fVar = new com.qiniu.pili.droid.shortvideo.gl.a.f(dVar3, t.this.f27544a, false);
            fVar.b();
            final com.qiniu.pili.droid.shortvideo.gl.b.d dVar4 = new com.qiniu.pili.droid.shortvideo.gl.b.d();
            dVar4.a(t.this.z, videoEncodingWidth, videoEncodingHeight);
            com.qiniu.pili.droid.shortvideo.gl.c.g a2 = com.qiniu.pili.droid.shortvideo.f.d.a(videoEncodingWidth, videoEncodingHeight);
            while (t.this.d) {
                t.this.z.post(new Runnable() { // from class: com.qiniu.pili.droid.shortvideo.core.t.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        dVar4.b();
                        t.this.v();
                    }
                });
                t.this.w();
                dVar4.a();
                long d = dVar4.d();
                int e = dVar4.e();
                if (!dVar.a()) {
                    if (t.this.f27545c.isHWCodecEnabled()) {
                        GLES20.glClear(16384);
                        a2.b(e);
                        if (t.this.b.a(d)) {
                            fVar.a(d - t.this.b.b());
                            fVar.c();
                        }
                    } else {
                        com.qiniu.pili.droid.shortvideo.gl.texread.d dVar5 = dVar2;
                        if (dVar2 == null) {
                            dVar5 = new com.qiniu.pili.droid.shortvideo.gl.texread.d(t.this.f27545c.getVideoEncodingWidth(), t.this.f27545c.getVideoEncodingHeight());
                        }
                        ByteBuffer a3 = dVar5.a(e);
                        t.this.b.a(a3, a3.capacity(), d);
                        dVar2 = dVar5;
                    }
                }
            }
            fVar.d();
            a2.f();
            dVar3.a();
            dVar4.c();
            if (!t.this.f27545c.isHWCodecEnabled()) {
                surfaceTexture.release();
                surface.release();
                if (dVar2 != null) {
                    dVar2.a();
                }
            }
            t.this.B = false;
        }
    }

    public t() {
        com.qiniu.pili.droid.shortvideo.f.e.d.c("ViewRecorderCore", "init");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        synchronized (this.A) {
            this.B = true;
            this.A.notify();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        synchronized (this.A) {
            while (!this.B) {
                try {
                    this.A.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.B = false;
        }
    }

    @Override // com.qiniu.pili.droid.shortvideo.core.e
    protected String a() {
        return "ViewRecorderCore";
    }

    public void a(View view, PLMicrophoneSetting pLMicrophoneSetting, PLVideoEncodeSetting pLVideoEncodeSetting, PLAudioEncodeSetting pLAudioEncodeSetting, PLRecordSetting pLRecordSetting) {
        com.qiniu.pili.droid.shortvideo.f.e.d.c("ViewRecorderCore", "prepare +");
        Context applicationContext = view.getContext().getApplicationContext();
        l.a(applicationContext);
        super.a(applicationContext, pLMicrophoneSetting, pLAudioEncodeSetting, pLRecordSetting);
        this.z = view;
        this.f27545c = pLVideoEncodeSetting;
        if (this.f27545c.isHWCodecEnabled()) {
            this.b = new com.qiniu.pili.droid.shortvideo.encode.e(pLVideoEncodeSetting);
        } else {
            this.b = new SWVideoEncoder(pLVideoEncodeSetting);
        }
        this.b.a(this.f);
        com.qiniu.pili.droid.shortvideo.f.e.d.c("ViewRecorderCore", "prepare -");
    }

    @Override // com.qiniu.pili.droid.shortvideo.core.e, com.qiniu.pili.droid.shortvideo.core.j
    public boolean a(String str) {
        synchronized (this) {
            if (a(b.a.record_view)) {
                return super.a(str);
            }
            return false;
        }
    }

    @Override // com.qiniu.pili.droid.shortvideo.core.e
    protected void b() {
        new Thread(new a()).start();
    }

    @Override // com.qiniu.pili.droid.shortvideo.core.j
    public JSONObject h() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("operation_record_view", 1);
            jSONObject.put("data_type", QosManager.a.config);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public long u() {
        long d;
        synchronized (this) {
            d = this.r.d();
        }
        return d;
    }
}
