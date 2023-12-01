package com.tencent.thumbplayer.a;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.thumbplayer.core.common.TPGeneralError;
import com.tencent.thumbplayer.core.common.TPSystemInfo;
import com.tencent.thumbplayer.utils.TPLogUtil;
import com.tencent.thumbplayer.utils.o;
import java.io.FileDescriptor;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/a/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static b f39125a;
    private HandlerThread b;

    /* renamed from: c  reason: collision with root package name */
    private c f39126c;
    private MediaMetadataRetriever d = null;
    private int e = 0;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/a/b$a.class */
    public interface a {
        void a(int i, int i2);

        void a(int i, long j, int i2, int i3, Bitmap bitmap, long j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.thumbplayer.a.b$b  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/a/b$b.class */
    public static class C1009b {

        /* renamed from: a  reason: collision with root package name */
        protected a f39127a;
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private String f39128c;
        private FileDescriptor d;
        private AssetFileDescriptor e;
        private long f;
        private int g;
        private int h;

        private C1009b() {
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/a/b$c.class */
    class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                TPLogUtil.i("TPSysPlayerImageCapture", "eventHandler EV_CAP_IMAGE");
                b.this.a((C1009b) message.obj);
            } else if (i != 2) {
                TPLogUtil.i("TPSysPlayerImageCapture", "eventHandler unknow msg");
            } else {
                TPLogUtil.i("TPSysPlayerImageCapture", "eventHandler EV_STOP_CAP_IMAGE");
                if (b.this.d != null) {
                    b.this.d.release();
                    b.this.d = null;
                }
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/a/b$d.class */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public String f39130a;
        public FileDescriptor b;

        /* renamed from: c  reason: collision with root package name */
        public AssetFileDescriptor f39131c;
        public long d;
        public int e;
        public int f;
    }

    private b() {
        this.b = null;
        this.f39126c = null;
        try {
            this.b = o.a().b();
            this.f39126c = new c(this.b.getLooper());
        } catch (Throwable th) {
            TPLogUtil.e("TPSysPlayerImageCapture", th);
            this.f39126c = new c(Looper.getMainLooper());
        }
    }

    public static b a() {
        b bVar;
        synchronized (b.class) {
            try {
                if (f39125a == null) {
                    f39125a = new b();
                }
                bVar = f39125a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(C1009b c1009b) {
        MediaMetadataRetriever mediaMetadataRetriever;
        try {
            try {
            } catch (Exception e) {
                TPLogUtil.e("TPSysPlayerImageCapture", e);
                TPLogUtil.e("TPSysPlayerImageCapture", "doRealCaptureImage, Exception: " + e.toString());
                c1009b.f39127a.a(c1009b.b, TPGeneralError.FAILED);
                mediaMetadataRetriever = this.d;
                if (mediaMetadataRetriever == null) {
                    return;
                }
            }
            if (Build.VERSION.SDK_INT < 14) {
                throw new Exception("os version not support");
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (this.d != null) {
                this.d.release();
                this.d = null;
            }
            this.d = new MediaMetadataRetriever();
            if (Build.VERSION.SDK_INT >= 14) {
                if (c1009b.d != null) {
                    this.d.setDataSource(c1009b.d);
                } else if (c1009b.e != null) {
                    this.d.setDataSource(c1009b.e.getFileDescriptor(), c1009b.e.getStartOffset(), c1009b.e.getLength());
                } else {
                    this.d.setDataSource(c1009b.f39128c, new HashMap());
                }
            }
            Bitmap frameAtTime = this.d.getFrameAtTime(c1009b.f * 1000, 2);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (frameAtTime != null) {
                c1009b.f39127a.a(c1009b.b, c1009b.f, c1009b.g, c1009b.h, frameAtTime, currentTimeMillis2 - currentTimeMillis);
            } else {
                c1009b.f39127a.a(c1009b.b, TPGeneralError.FAILED);
            }
            mediaMetadataRetriever = this.d;
            if (mediaMetadataRetriever == null) {
                return;
            }
            mediaMetadataRetriever.release();
            this.d = null;
        } catch (Throwable th) {
            MediaMetadataRetriever mediaMetadataRetriever2 = this.d;
            if (mediaMetadataRetriever2 != null) {
                mediaMetadataRetriever2.release();
                this.d = null;
            }
            throw th;
        }
    }

    public int a(d dVar, a aVar) {
        TPLogUtil.i("TPSysPlayerImageCapture", "captureImageWithPosition, position: " + dVar.d + ", width: " + dVar.e + ", height: " + dVar.f);
        this.e = this.e + 1;
        if (!TextUtils.isEmpty(TPSystemInfo.getDeviceName()) && TPSystemInfo.getDeviceName().equals("Lenovo+K900")) {
            TPLogUtil.i("TPSysPlayerImageCapture", "captureImageWithPosition, Lenovo+K900 no incompatible");
            return -1;
        }
        C1009b c1009b = new C1009b();
        c1009b.b = this.e;
        c1009b.d = dVar.b;
        c1009b.e = dVar.f39131c;
        c1009b.f39128c = dVar.f39130a;
        c1009b.f = dVar.d;
        c1009b.g = dVar.e;
        c1009b.h = dVar.f;
        c1009b.f39127a = aVar;
        Message message = new Message();
        message.what = 1;
        message.obj = c1009b;
        if (!this.f39126c.sendMessage(message)) {
            TPLogUtil.i("TPSysPlayerImageCapture", "captureImageWithPosition, send msg failed ");
        }
        return this.e;
    }
}
