package com.qiniu.pili.droid.shortvideo.core;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.view.Surface;
import com.qiniu.pili.droid.shortvideo.PLAudioEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLExternalRecordStateListener;
import com.qiniu.pili.droid.shortvideo.PLRecordSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoEncodeSetting;
import com.qiniu.pili.droid.shortvideo.core.QosManager;
import com.qiniu.pili.droid.shortvideo.core.b;
import com.qiniu.pili.droid.shortvideo.encode.SWVideoEncoder;
import com.qiniu.pili.droid.shortvideo.encode.a;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/core/d.class */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private SWVideoEncoder f13852a;
    private long b;

    /* renamed from: c  reason: collision with root package name */
    private com.qiniu.pili.droid.shortvideo.encode.c f13853c;
    private long d;
    private com.qiniu.pili.droid.shortvideo.muxer.b e;
    private MediaFormat f;
    private MediaFormat g;
    private volatile boolean h;
    private PLRecordSetting i;
    private PLExternalRecordStateListener j;
    private volatile boolean k;
    private volatile boolean l;
    private volatile boolean m;
    private volatile boolean n;
    private boolean p;
    private Context q;
    private AtomicBoolean o = new AtomicBoolean(false);
    private a.InterfaceC0575a r = new a.InterfaceC0575a() { // from class: com.qiniu.pili.droid.shortvideo.core.d.1
        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void a(MediaFormat mediaFormat) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.h;
            eVar.b("ExternalMediaRecorderCore", "got video format:" + mediaFormat.toString());
            d.this.f = mediaFormat;
            d.this.m = true;
            d.this.h();
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void a(Surface surface) {
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void a(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
            if (!d.this.h || d.this.e.b() < 0 || d.this.o.get()) {
                return;
            }
            com.qiniu.pili.droid.shortvideo.f.e.h.b("ExternalMediaRecorderCore", "video encoded frame size:" + bufferInfo.size + " ts:" + bufferInfo.presentationTimeUs);
            if (d.this.b == 0) {
                d.this.b = bufferInfo.presentationTimeUs;
            }
            bufferInfo.presentationTimeUs -= d.this.b;
            d.this.e.a(byteBuffer, bufferInfo);
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void a(boolean z) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.h;
            eVar.c("ExternalMediaRecorderCore", "video encoder started: " + z);
            d.this.k = z;
            if (z || d.this.j == null) {
                return;
            }
            d.this.b();
            d.this.j.onError(6);
            QosManager.a().a(6);
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void b(boolean z) {
            com.qiniu.pili.droid.shortvideo.f.e.h.c("ExternalMediaRecorderCore", "video encoder stopped.");
            d.this.k = false;
            d.this.m = false;
            d.this.i();
        }
    };
    private a.InterfaceC0575a s = new a.InterfaceC0575a() { // from class: com.qiniu.pili.droid.shortvideo.core.d.2
        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void a(MediaFormat mediaFormat) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.n;
            eVar.c("ExternalMediaRecorderCore", "got audio format:" + mediaFormat.toString());
            d.this.g = mediaFormat;
            d.this.n = true;
            d.this.h();
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void a(Surface surface) {
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void a(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
            if (!d.this.h || d.this.e.c() < 0 || d.this.o.get()) {
                return;
            }
            com.qiniu.pili.droid.shortvideo.f.e.h.b("ExternalMediaRecorderCore", "audio encoded frame size:" + bufferInfo.size + " ts:" + bufferInfo.presentationTimeUs);
            if (d.this.d == 0) {
                d.this.d = bufferInfo.presentationTimeUs;
            }
            bufferInfo.presentationTimeUs -= d.this.d;
            d.this.e.b(byteBuffer, bufferInfo);
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void a(boolean z) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.h;
            eVar.c("ExternalMediaRecorderCore", "audio encoder started: " + z);
            d.this.l = z;
            if (z || d.this.j == null) {
                return;
            }
            d.this.b();
            d.this.j.onError(7);
            QosManager.a().a(7);
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void b(boolean z) {
            com.qiniu.pili.droid.shortvideo.f.e.h.c("ExternalMediaRecorderCore", "audio encoder stopped.");
            d.this.l = false;
            d.this.n = false;
            d.this.i();
        }
    };

    public d(Context context) {
        com.qiniu.pili.droid.shortvideo.f.e.d.c("ExternalMediaRecorderCore", "init +");
        this.q = context;
        l.a(context);
        com.qiniu.pili.droid.shortvideo.f.e.d.c("ExternalMediaRecorderCore", "init -");
    }

    private boolean a(b.a aVar) {
        if (u.a().a(aVar)) {
            return true;
        }
        PLExternalRecordStateListener pLExternalRecordStateListener = this.j;
        if (pLExternalRecordStateListener != null) {
            pLExternalRecordStateListener.onError(8);
        }
        QosManager.a().a(8);
        return false;
    }

    private boolean a(String str) {
        if (str == null) {
            com.qiniu.pili.droid.shortvideo.f.e.d.e("ExternalMediaRecorderCore", "set file failed!");
            return false;
        }
        File parentFile = new File(str).getParentFile();
        if (parentFile.exists() || parentFile.mkdir()) {
            return true;
        }
        com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.d;
        eVar.e("ExternalMediaRecorderCore", "failed to mkdir: " + parentFile.getAbsolutePath());
        return false;
    }

    private boolean e() {
        if (!this.p || this.q == null) {
            PLExternalRecordStateListener pLExternalRecordStateListener = this.j;
            if (pLExternalRecordStateListener != null) {
                pLExternalRecordStateListener.onError(1);
                QosManager.a().a(1);
            }
            com.qiniu.pili.droid.shortvideo.f.e.d.e("ExternalMediaRecorderCore", "please invoke prepare() first!");
        }
        return this.p && this.q != null;
    }

    private void f() {
        if (this.f13853c != null) {
            com.qiniu.pili.droid.shortvideo.f.e.h.c("ExternalMediaRecorderCore", "start audio encoder +");
            this.f13853c.a();
        }
        if (this.f13852a != null) {
            com.qiniu.pili.droid.shortvideo.f.e.h.c("ExternalMediaRecorderCore", "start video encoder +");
            this.f13852a.a();
        }
        com.qiniu.pili.droid.shortvideo.f.e.h.c("ExternalMediaRecorderCore", "start encoder -");
    }

    private void g() {
        if (this.f13853c != null) {
            com.qiniu.pili.droid.shortvideo.f.e.h.c("ExternalMediaRecorderCore", "stop audio encoder +");
            this.f13853c.c();
        }
        if (this.f13852a != null) {
            com.qiniu.pili.droid.shortvideo.f.e.h.c("ExternalMediaRecorderCore", "stop video encoder +");
            this.f13852a.c();
        }
        com.qiniu.pili.droid.shortvideo.f.e.h.c("ExternalMediaRecorderCore", "stop encoder -");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        synchronized (this) {
            if (!this.m || !this.n || this.h) {
                com.qiniu.pili.droid.shortvideo.f.e.h.d("ExternalMediaRecorderCore", "not ready to start muxer.");
                return false;
            }
            try {
                this.e.a(this.i.getVideoFilepath(), this.f, this.g);
                if (this.j != null) {
                    this.j.onRecordStarted();
                }
                this.h = true;
                com.qiniu.pili.droid.shortvideo.f.e.h.b("ExternalMediaRecorderCore", "start muxer success.");
                return true;
            } catch (IllegalStateException e) {
                com.qiniu.pili.droid.shortvideo.f.e.h.e("ExternalMediaRecorderCore", "start muxer failed");
                if (this.j != null) {
                    this.j.onError(18);
                    QosManager.a().a(18);
                }
                e.printStackTrace();
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        synchronized (this) {
            if (!this.k && !this.m && !this.l && !this.n && this.h) {
                this.h = false;
                try {
                    this.e.a();
                    if (this.j != null) {
                        this.j.onRecordStopped();
                    }
                } catch (IllegalStateException e) {
                    if (this.j != null) {
                        this.j.onError(3);
                        QosManager.a().a(3);
                    }
                    this.e = null;
                    e.printStackTrace();
                }
                this.o.set(true);
                this.d = 0L;
                this.b = 0L;
                com.qiniu.pili.droid.shortvideo.f.e.n.c("ExternalMediaRecorderCore", "muxer stop!");
            }
        }
    }

    public void a() {
        com.qiniu.pili.droid.shortvideo.f.e.d.c("ExternalMediaRecorderCore", "start +");
        if (a(b.a.record_external_media) && e()) {
            this.o.set(false);
            f();
            this.e = new com.qiniu.pili.droid.shortvideo.muxer.b();
            com.qiniu.pili.droid.shortvideo.f.e.d.c("ExternalMediaRecorderCore", "start -");
        }
    }

    public void a(PLExternalRecordStateListener pLExternalRecordStateListener) {
        this.j = pLExternalRecordStateListener;
    }

    public void a(byte[] bArr, int i, int i2, int i3, long j) {
        if (e() && this.k) {
            int i4 = ((i * i2) * 3) / 2;
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.h;
            eVar.b("ExternalMediaRecorderCore", "input video frame size:" + i4 + " ts:" + j);
            this.f13852a.a(wrap, i4, j);
        }
    }

    public void a(byte[] bArr, int i, long j) {
        if (e() && this.l) {
            this.f13853c.a(ByteBuffer.wrap(bArr), i, j / 1000);
        }
    }

    public boolean a(PLVideoEncodeSetting pLVideoEncodeSetting, PLAudioEncodeSetting pLAudioEncodeSetting, PLRecordSetting pLRecordSetting) {
        com.qiniu.pili.droid.shortvideo.f.e.d.c("ExternalMediaRecorderCore", "prepare +");
        if (pLVideoEncodeSetting == null || pLAudioEncodeSetting == null || pLRecordSetting == null) {
            com.qiniu.pili.droid.shortvideo.f.e.d.e("ExternalMediaRecorderCore", "prepare error : videoEncodeSetting, audioEncodeSetting or recordSetting can not be null !");
            return false;
        } else if (!a(pLRecordSetting.getVideoFilepath())) {
            com.qiniu.pili.droid.shortvideo.f.e.d.e("ExternalMediaRecorderCore", "Error: set output file path failed!");
            return false;
        } else {
            this.i = pLRecordSetting;
            SWVideoEncoder sWVideoEncoder = new SWVideoEncoder(pLVideoEncodeSetting);
            this.f13852a = sWVideoEncoder;
            if (sWVideoEncoder == null) {
                com.qiniu.pili.droid.shortvideo.f.e.d.e("ExternalMediaRecorderCore", "Building video encoder failed!!!!");
                return false;
            }
            sWVideoEncoder.a(this.r);
            com.qiniu.pili.droid.shortvideo.encode.c cVar = new com.qiniu.pili.droid.shortvideo.encode.c(pLAudioEncodeSetting);
            this.f13853c = cVar;
            if (cVar == null) {
                com.qiniu.pili.droid.shortvideo.f.e.d.e("ExternalMediaRecorderCore", "Building audio encoder failed!!!!");
                return false;
            }
            cVar.a(this.s);
            this.p = true;
            PLExternalRecordStateListener pLExternalRecordStateListener = this.j;
            if (pLExternalRecordStateListener != null) {
                pLExternalRecordStateListener.onReady();
            }
            com.qiniu.pili.droid.shortvideo.f.e.d.c("ExternalMediaRecorderCore", "prepare -");
            return true;
        }
    }

    public void b() {
        com.qiniu.pili.droid.shortvideo.f.e.d.c("ExternalMediaRecorderCore", "stop +");
        g();
        com.qiniu.pili.droid.shortvideo.f.e.d.c("ExternalMediaRecorderCore", "stop -");
    }

    public boolean c() {
        return this.h;
    }

    public JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("operation_record_external_media", 1);
            jSONObject.put("data_type", QosManager.a.config);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }
}
