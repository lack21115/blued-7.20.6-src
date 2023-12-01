package com.qiniu.pili.droid.shortvideo.core;

import android.content.Context;
import com.qiniu.pili.droid.shortvideo.PLShortVideoTrimmer;
import com.qiniu.pili.droid.shortvideo.PLVideoSaveListener;
import com.qiniu.pili.droid.shortvideo.core.QosManager;
import com.qiniu.pili.droid.shortvideo.core.b;
import com.qiniu.pili.droid.shortvideo.muxer.FFMP4Demuxer;
import com.qiniu.pili.droid.shortvideo.muxer.FFMP4Muxer;
import java.io.File;
import java.nio.ByteBuffer;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/core/r.class */
public class r {

    /* renamed from: a  reason: collision with root package name */
    private Context f13927a;
    private q b;

    /* renamed from: c  reason: collision with root package name */
    private PLShortVideoTrimmer.TRIM_MODE f13928c;
    private volatile boolean d;
    private String e;
    private String f;
    private long g;
    private double h = 1.0d;
    private PLVideoSaveListener i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/core/r$a.class */
    public class a implements Runnable {
        private FFMP4Muxer b;

        /* renamed from: c  reason: collision with root package name */
        private FFMP4Demuxer f13930c;
        private long d;
        private long e;

        public a(FFMP4Muxer fFMP4Muxer, FFMP4Demuxer fFMP4Demuxer, long j, long j2) {
            this.b = fFMP4Muxer;
            this.f13930c = fFMP4Demuxer;
            this.d = j;
            this.e = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int a2 = this.f13930c.a();
            int b = this.f13930c.b();
            if (a2 >= 0) {
                this.f13930c.a(a2, this.d / 1000, 1);
            } else if (b >= 0) {
                this.f13930c.a(b, this.d / 1000, 1);
            }
            while (true) {
                long i = this.f13930c.i();
                if (i != 0) {
                    if (!r.this.d) {
                        int a3 = this.f13930c.a(i);
                        byte[] b2 = this.f13930c.b(i);
                        int c2 = this.f13930c.c(i);
                        boolean z = this.f13930c.d(i) == 1;
                        long e = this.f13930c.e(i);
                        long f = this.f13930c.f(i);
                        int g = (int) this.f13930c.g(i);
                        long a4 = this.f13930c.a(a3, e);
                        int g2 = this.f13930c.g();
                        int h = this.f13930c.h();
                        if (a3 == this.f13930c.b()) {
                            g2 = this.f13930c.e();
                            h = this.f13930c.f();
                        }
                        if (a4 >= this.e && a3 == this.f13930c.a()) {
                            break;
                        }
                        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(c2);
                        allocateDirect.put(b2);
                        allocateDirect.clear();
                        this.b.a(a3, allocateDirect, allocateDirect.capacity(), z, e, f, g, g2, h);
                        if (r.this.i != null && a3 == this.f13930c.a()) {
                            PLVideoSaveListener pLVideoSaveListener = r.this.i;
                            long j = this.d;
                            pLVideoSaveListener.onProgressUpdate((((float) (a4 - j)) * 1.0f) / ((float) (this.e - j)));
                        }
                    } else {
                        com.qiniu.pili.droid.shortvideo.f.e.n.c("ShortVideoTrimmerCore", "trim video canceled");
                        this.f13930c.l();
                        this.b.a();
                        new File(r.this.f).delete();
                        if (r.this.i != null) {
                            r.this.i.onSaveVideoCanceled();
                            return;
                        }
                        return;
                    }
                } else {
                    break;
                }
            }
            if (r.this.i != null) {
                r.this.i.onProgressUpdate(1.0f);
            }
            this.f13930c.l();
            if (this.b.a()) {
                if (r.this.i != null) {
                    r.this.i.onSaveVideoSuccess(r.this.f);
                }
            } else if (r.this.i != null) {
                r.this.i.onSaveVideoFailed(0);
                QosManager.a().a(0);
            }
        }
    }

    public r(Context context, String str, String str2) {
        com.qiniu.pili.droid.shortvideo.f.e.p.c("ShortVideoTrimmerCore", "init +");
        Context applicationContext = context.getApplicationContext();
        l.a(applicationContext);
        this.f13927a = applicationContext;
        this.e = str;
        this.f = l.a(applicationContext, str2);
        this.g = com.qiniu.pili.droid.shortvideo.f.g.a((Object) str);
        com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.n;
        eVar.c("ShortVideoTrimmerCore", "src video duration in Ms: " + this.g);
        com.qiniu.pili.droid.shortvideo.f.e.p.c("ShortVideoTrimmerCore", "init -");
    }

    private void a(long j, long j2) {
        FFMP4Muxer fFMP4Muxer = new FFMP4Muxer();
        FFMP4Demuxer fFMP4Demuxer = new FFMP4Demuxer();
        if (!fFMP4Demuxer.a(this.e)) {
            if (this.i != null) {
                com.qiniu.pili.droid.shortvideo.f.e.p.e("ShortVideoTrimmerCore", "demuxer open file failed !");
                this.i.onSaveVideoFailed(0);
                QosManager.a().a(0);
            }
        } else if (fFMP4Muxer.a(this.f, fFMP4Demuxer)) {
            new Thread(new a(fFMP4Muxer, fFMP4Demuxer, j, j2)).start();
        } else {
            fFMP4Demuxer.l();
            if (this.i != null) {
                com.qiniu.pili.droid.shortvideo.f.e.p.e("ShortVideoTrimmerCore", "muxer start failed !");
                this.i.onSaveVideoFailed(0);
                QosManager.a().a(0);
            }
        }
    }

    private void b(long j, long j2) {
        q qVar = new q(this.f13927a, this.e, this.f);
        this.b = qVar;
        qVar.a(j, j2);
        this.b.a(this.h);
        this.b.a(this.i);
    }

    public void a() {
        synchronized (this) {
            if (this.f13928c == PLShortVideoTrimmer.TRIM_MODE.FAST) {
                this.d = true;
            } else if (this.b != null) {
                this.b.a();
            }
        }
    }

    public void a(double d) {
        if (!com.qiniu.pili.droid.shortvideo.f.j.a(d)) {
            com.qiniu.pili.droid.shortvideo.f.e.p.d("ShortVideoTrimmerCore", "only support multiple of 2 !!!");
            return;
        }
        com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.p;
        eVar.c("ShortVideoTrimmerCore", "set speed to: " + d);
        this.h = d;
    }

    public void a(long j, long j2, PLShortVideoTrimmer.TRIM_MODE trim_mode, PLVideoSaveListener pLVideoSaveListener) {
        synchronized (this) {
            if (u.a().a(b.a.trim_video, pLVideoSaveListener)) {
                if (this.e == null) {
                    com.qiniu.pili.droid.shortvideo.f.e.p.e("ShortVideoTrimmerCore", "src file path is null, return now.");
                    return;
                }
                this.i = pLVideoSaveListener;
                if (j <= 0 && j2 >= this.g && this.h == 1.0d) {
                    com.qiniu.pili.droid.shortvideo.f.e.p.e("ShortVideoTrimmerCore", "trim range is the whole file, return the original file.");
                    if (this.i != null) {
                        this.i.onSaveVideoSuccess(this.e);
                    }
                    return;
                }
                long j3 = j * 1000;
                long j4 = j2 * 1000;
                this.f13928c = trim_mode;
                com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.p;
                eVar.c("ShortVideoTrimmerCore", "except trim from time Us: " + j3 + " - " + j4 + " mode: " + trim_mode);
                if (trim_mode == PLShortVideoTrimmer.TRIM_MODE.FAST) {
                    a(j3, j4);
                } else {
                    b(j3, j4);
                }
            }
        }
    }

    public void b() {
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("operation_trim_video", 1);
            jSONObject.put("data_type", QosManager.a.config);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }
}
