package com.qiniu.pili.droid.shortvideo.core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Build;
import android.view.Surface;
import com.qiniu.pili.droid.shortvideo.PLAudioEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLAudioFrameListener;
import com.qiniu.pili.droid.shortvideo.PLMicrophoneSetting;
import com.qiniu.pili.droid.shortvideo.PLScreenRecordStateListener;
import com.qiniu.pili.droid.shortvideo.PLScreenRecorderSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoEncodeSetting;
import com.qiniu.pili.droid.shortvideo.core.QosManager;
import com.qiniu.pili.droid.shortvideo.core.b;
import com.qiniu.pili.droid.shortvideo.encode.a;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/core/g.class */
public final class g implements PLAudioFrameListener {

    /* renamed from: a  reason: collision with root package name */
    private MediaProjectionManager f13860a;
    private com.qiniu.pili.droid.shortvideo.encode.e b;

    /* renamed from: c  reason: collision with root package name */
    private com.qiniu.pili.droid.shortvideo.a.c.a f13861c;
    private long d;
    private com.qiniu.pili.droid.shortvideo.a.b.a f;
    private com.qiniu.pili.droid.shortvideo.encode.c g;
    private com.qiniu.pili.droid.shortvideo.muxer.b i;
    private MediaFormat j;
    private MediaFormat k;
    private volatile boolean l;
    private PLScreenRecorderSetting m;
    private PLScreenRecordStateListener n;
    private PLAudioFrameListener o;
    private volatile boolean p;
    private volatile boolean q;
    private volatile boolean r;
    private volatile boolean s;
    private boolean u;
    private Activity v;
    private int e = -1;
    private int h = -1;
    private AtomicBoolean t = new AtomicBoolean(false);
    private a.InterfaceC0575a w = new a.InterfaceC0575a() { // from class: com.qiniu.pili.droid.shortvideo.core.g.1
        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void a(MediaFormat mediaFormat) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.n;
            eVar.c("ScreenRecorderCore", "got video format:" + mediaFormat.toString());
            g.this.j = mediaFormat;
            g.this.r = true;
            g.this.j();
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void a(Surface surface) {
            g.this.f13861c.a(surface);
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void a(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
            if (!g.this.l || g.this.e < 0 || g.this.t.get()) {
                return;
            }
            com.qiniu.pili.droid.shortvideo.f.e.h.b("ScreenRecorderCore", "video encoded frame size:" + bufferInfo.size + " ts:" + bufferInfo.presentationTimeUs);
            if (g.this.d == 0) {
                g.this.d = bufferInfo.presentationTimeUs;
            }
            bufferInfo.presentationTimeUs -= g.this.d;
            g.this.i.a(g.this.e, byteBuffer, bufferInfo);
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void a(boolean z) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.h;
            eVar.c("ScreenRecorderCore", "video encoder started: " + z);
            g.this.p = z;
            if (z || g.this.n == null) {
                return;
            }
            g.this.c();
            g.this.n.onError(6);
            QosManager.a().a(6);
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void b(boolean z) {
            com.qiniu.pili.droid.shortvideo.f.e.h.c("ScreenRecorderCore", "video encoder stopped.");
            g.this.p = false;
            g.this.r = false;
            g.this.k();
        }
    };
    private a.InterfaceC0575a x = new a.InterfaceC0575a() { // from class: com.qiniu.pili.droid.shortvideo.core.g.2
        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void a(MediaFormat mediaFormat) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.n;
            eVar.c("ScreenRecorderCore", "got audio format:" + mediaFormat.toString());
            g.this.k = mediaFormat;
            g.this.s = true;
            g.this.j();
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void a(Surface surface) {
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void a(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
            if (!g.this.l || g.this.h < 0 || g.this.t.get()) {
                return;
            }
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.h;
            eVar.b("ScreenRecorderCore", "audio encoded frame size:" + bufferInfo.size + " ts:" + bufferInfo.presentationTimeUs);
            g.this.i.a(g.this.h, byteBuffer, bufferInfo);
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void a(boolean z) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.h;
            eVar.c("ScreenRecorderCore", "audio encoder started: " + z);
            g.this.q = z;
            if (z || g.this.n == null) {
                return;
            }
            g.this.c();
            g.this.n.onError(7);
            QosManager.a().a(7);
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void b(boolean z) {
            com.qiniu.pili.droid.shortvideo.f.e.h.c("ScreenRecorderCore", "audio encoder stopped.");
            g.this.q = false;
            g.this.s = false;
            g.this.k();
        }
    };

    public g(Activity activity) {
        com.qiniu.pili.droid.shortvideo.f.e.e.c("ScreenRecorderCore", "init +");
        this.v = activity;
        l.a(activity.getApplicationContext());
        com.qiniu.pili.droid.shortvideo.f.e.e.c("ScreenRecorderCore", "init -");
    }

    private boolean a(String str) {
        if (str == null || !str.endsWith(".mp4")) {
            com.qiniu.pili.droid.shortvideo.f.e.f13985c.e("ScreenRecorderCore", "set mp4 file failed!");
            return false;
        }
        File parentFile = new File(str).getParentFile();
        if (parentFile.exists() || parentFile.mkdir()) {
            return true;
        }
        com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.f13985c;
        eVar.e("ScreenRecorderCore", "failed to mkdir: " + parentFile.getAbsolutePath());
        return false;
    }

    private boolean f() {
        if (Build.VERSION.SDK_INT < 21) {
            PLScreenRecordStateListener pLScreenRecordStateListener = this.n;
            if (pLScreenRecordStateListener != null) {
                pLScreenRecordStateListener.onError(9);
                QosManager.a().a(9);
            }
            com.qiniu.pili.droid.shortvideo.f.e.f13985c.e("ScreenRecorderCore", "failed to requestScreenRecord, Android version < LOLLIPOP !");
            return false;
        }
        if (!this.u || this.v == null) {
            PLScreenRecordStateListener pLScreenRecordStateListener2 = this.n;
            if (pLScreenRecordStateListener2 != null) {
                pLScreenRecordStateListener2.onError(1);
                QosManager.a().a(1);
            }
            com.qiniu.pili.droid.shortvideo.f.e.f13985c.e("ScreenRecorderCore", "please invoke prepare() first!");
        }
        boolean z = false;
        if (this.u) {
            z = false;
            if (this.v != null) {
                z = true;
            }
        }
        return z;
    }

    private void g() {
        com.qiniu.pili.droid.shortvideo.encode.c cVar = this.g;
        if (cVar != null) {
            cVar.a();
        }
        com.qiniu.pili.droid.shortvideo.encode.e eVar = this.b;
        if (eVar != null) {
            eVar.a();
        }
    }

    private void h() {
        if (this.b != null) {
            com.qiniu.pili.droid.shortvideo.f.e.h.c("ScreenRecorderCore", "stop video encoder +");
            this.b.c();
        }
        if (this.g != null) {
            com.qiniu.pili.droid.shortvideo.f.e.h.c("ScreenRecorderCore", "stop audio encoder +");
            this.g.c();
        }
        com.qiniu.pili.droid.shortvideo.f.e.h.c("ScreenRecorderCore", "stop encoder -");
    }

    private void i() {
        if (this.f13861c != null) {
            com.qiniu.pili.droid.shortvideo.f.e.f.c("ScreenRecorderCore", "stop screen record +");
            this.f13861c.a();
        }
        if (this.f != null) {
            com.qiniu.pili.droid.shortvideo.f.e.f.c("ScreenRecorderCore", "stop audio record +");
            this.f.b();
        }
        com.qiniu.pili.droid.shortvideo.f.e.f.c("ScreenRecorderCore", "stop record -");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j() {
        synchronized (this) {
            if (this.p && ((this.g == null || this.q) && !this.l)) {
                this.i.a(this.m.getRecordFile(), this.j, this.k);
                this.e = this.i.b();
                if (this.g != null) {
                    this.h = this.i.c();
                }
                this.l = true;
                if (this.n != null) {
                    this.n.onRecordStarted();
                }
                com.qiniu.pili.droid.shortvideo.f.e.n.c("ScreenRecorderCore", "start muxer success");
                return true;
            }
            com.qiniu.pili.droid.shortvideo.f.e.n.e("ScreenRecorderCore", "start muxer failed");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        synchronized (this) {
            if (!this.p && !this.r && !this.q && !this.s && this.l) {
                this.l = false;
                try {
                    this.i.a();
                    if (this.n != null) {
                        this.n.onRecordStopped();
                    }
                } catch (IllegalStateException e) {
                    if (this.n != null) {
                        this.n.onError(3);
                        QosManager.a().a(3);
                    }
                    this.i = null;
                    e.printStackTrace();
                }
                com.qiniu.pili.droid.shortvideo.f.e.n.c("ScreenRecorderCore", "muxer stop!");
            }
        }
    }

    public void a() {
        com.qiniu.pili.droid.shortvideo.f.e.f13985c.c("ScreenRecorderCore", "requestScreenRecord +");
        if (f()) {
            MediaProjectionManager mediaProjectionManager = (MediaProjectionManager) this.v.getSystemService(Context.MEDIA_PROJECTION_SERVICE);
            this.f13860a = mediaProjectionManager;
            this.v.startActivityForResult(mediaProjectionManager.createScreenCaptureIntent(), 2008);
            com.qiniu.pili.droid.shortvideo.a.b.a aVar = this.f;
            if (aVar == null || aVar.a()) {
                com.qiniu.pili.droid.shortvideo.f.e.f13985c.c("ScreenRecorderCore", "requestScreenRecord -");
                return;
            }
            PLScreenRecordStateListener pLScreenRecordStateListener = this.n;
            if (pLScreenRecordStateListener != null) {
                pLScreenRecordStateListener.onError(5);
                QosManager.a().a(5);
            }
            com.qiniu.pili.droid.shortvideo.f.e.f.e("ScreenRecorderCore", "Error: setup microphone failed");
        }
    }

    public void a(PLAudioFrameListener pLAudioFrameListener) {
        this.o = pLAudioFrameListener;
    }

    public void a(PLScreenRecordStateListener pLScreenRecordStateListener) {
        this.n = pLScreenRecordStateListener;
    }

    public void a(byte[] bArr, long j) {
        if (f() && this.m.isInputAudioEnabled()) {
            onAudioFrameAvailable(bArr, j);
        }
    }

    public boolean a(int i, int i2, Intent intent) {
        com.qiniu.pili.droid.shortvideo.f.e.f13985c.c("ScreenRecorderCore", "onActivityResult +");
        if (f()) {
            if (i != 2008 || intent == null) {
                com.qiniu.pili.droid.shortvideo.f.e.f.e("ScreenRecorderCore", "param error, screen recorder init failed!");
                return false;
            }
            MediaProjection mediaProjection = this.f13860a.getMediaProjection(i2, intent);
            if (mediaProjection == null) {
                com.qiniu.pili.droid.shortvideo.f.e.f.e("ScreenRecorderCore", "something is wrong, screen recorder init failed!");
                return false;
            }
            PLScreenRecorderSetting pLScreenRecorderSetting = this.m;
            if (pLScreenRecorderSetting == null) {
                com.qiniu.pili.droid.shortvideo.f.e.f.e("ScreenRecorderCore", "please invoke prepare interface first!");
                return false;
            }
            this.f13861c = new com.qiniu.pili.droid.shortvideo.a.c.a(pLScreenRecorderSetting.getWidth(), this.m.getHeight(), this.m.getDpi(), mediaProjection);
            PLScreenRecordStateListener pLScreenRecordStateListener = this.n;
            if (pLScreenRecordStateListener != null) {
                pLScreenRecordStateListener.onReady();
            }
            com.qiniu.pili.droid.shortvideo.f.e.f13985c.c("ScreenRecorderCore", "onActivityResult -");
            return true;
        }
        return false;
    }

    public boolean a(PLScreenRecorderSetting pLScreenRecorderSetting, PLMicrophoneSetting pLMicrophoneSetting) {
        com.qiniu.pili.droid.shortvideo.f.e.f13985c.c("ScreenRecorderCore", "prepare +");
        if (pLScreenRecorderSetting == null || !a(pLScreenRecorderSetting.getRecordFile())) {
            com.qiniu.pili.droid.shortvideo.f.e.f13985c.e("ScreenRecorderCore", "Error: something is null!");
            return false;
        }
        this.m = pLScreenRecorderSetting;
        com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.f13985c;
        eVar.c("ScreenRecorderCore", "prepare, screenSetting = " + pLScreenRecorderSetting);
        PLVideoEncodeSetting pLVideoEncodeSetting = new PLVideoEncodeSetting(this.v.getApplicationContext());
        pLVideoEncodeSetting.setEncodingBitrate(pLScreenRecorderSetting.getEncodingBitrate());
        pLVideoEncodeSetting.setPreferredEncodingSize(this.m.getWidth(), this.m.getHeight());
        com.qiniu.pili.droid.shortvideo.encode.e eVar2 = new com.qiniu.pili.droid.shortvideo.encode.e(pLVideoEncodeSetting);
        this.b = eVar2;
        eVar2.a(this.w);
        if (pLMicrophoneSetting != null) {
            PLAudioEncodeSetting pLAudioEncodeSetting = new PLAudioEncodeSetting();
            pLAudioEncodeSetting.setSampleRate(pLMicrophoneSetting.getSampleRate());
            pLAudioEncodeSetting.setChannels(pLMicrophoneSetting.getChannelConfig() == 16 ? 1 : 2);
            com.qiniu.pili.droid.shortvideo.encode.c cVar = new com.qiniu.pili.droid.shortvideo.encode.c(pLAudioEncodeSetting);
            this.g = cVar;
            cVar.a(this.x);
            if (!pLScreenRecorderSetting.isInputAudioEnabled()) {
                pLMicrophoneSetting.setPtsOptimizeEnabled(false);
                com.qiniu.pili.droid.shortvideo.a.b.a aVar = new com.qiniu.pili.droid.shortvideo.a.b.a(pLMicrophoneSetting);
                this.f = aVar;
                aVar.a(this);
            }
        }
        this.u = true;
        com.qiniu.pili.droid.shortvideo.f.e.f13985c.c("ScreenRecorderCore", "prepare -");
        return true;
    }

    public void b() {
        com.qiniu.pili.droid.shortvideo.f.e.f13985c.c("ScreenRecorderCore", "start +");
        if (!u.a().a(b.a.record_screen)) {
            QosManager.a().a(8);
            PLScreenRecordStateListener pLScreenRecordStateListener = this.n;
            if (pLScreenRecordStateListener != null) {
                pLScreenRecordStateListener.onError(8);
            }
        } else if (f()) {
            this.t.set(false);
            this.d = 0L;
            g();
            this.i = new com.qiniu.pili.droid.shortvideo.muxer.b();
            com.qiniu.pili.droid.shortvideo.f.e.f13985c.c("ScreenRecorderCore", "start -");
        }
    }

    public void c() {
        com.qiniu.pili.droid.shortvideo.f.e.f13985c.c("ScreenRecorderCore", "stop +");
        this.t.set(true);
        this.p = false;
        this.q = false;
        this.r = false;
        this.s = false;
        i();
        h();
        com.qiniu.pili.droid.shortvideo.f.e.f13985c.c("ScreenRecorderCore", "stop -");
    }

    public boolean d() {
        return this.l;
    }

    public JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("operation_record_screen", 1);
            jSONObject.put("data_type", QosManager.a.config);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    @Override // com.qiniu.pili.droid.shortvideo.PLAudioFrameListener
    public void onAudioFrameAvailable(byte[] bArr, long j) {
        if (this.q) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.f;
            eVar.b("ScreenRecorderCore", "audio frame captured size:" + bArr.length + " ts:" + j);
            this.g.a(wrap, bArr.length, j / 1000);
        }
    }

    @Override // com.qiniu.pili.droid.shortvideo.PLAudioFrameListener
    public void onAudioRecordFailed(int i) {
        PLAudioFrameListener pLAudioFrameListener = this.o;
        if (pLAudioFrameListener != null) {
            pLAudioFrameListener.onAudioRecordFailed(i);
        }
    }
}
