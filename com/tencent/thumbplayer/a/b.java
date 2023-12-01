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
    private static b f25434a;
    private HandlerThread b;

    /* renamed from: c  reason: collision with root package name */
    private c f25435c;
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
    public static class C0839b {

        /* renamed from: a  reason: collision with root package name */
        protected a f25436a;
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private String f25437c;
        private FileDescriptor d;
        private AssetFileDescriptor e;
        private long f;
        private int g;
        private int h;

        private C0839b() {
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
                b.this.a((C0839b) message.obj);
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
        public String f25439a;
        public FileDescriptor b;

        /* renamed from: c  reason: collision with root package name */
        public AssetFileDescriptor f25440c;
        public long d;
        public int e;
        public int f;
    }

    private b() {
        this.b = null;
        this.f25435c = null;
        try {
            this.b = o.a().b();
            this.f25435c = new c(this.b.getLooper());
        } catch (Throwable th) {
            TPLogUtil.e("TPSysPlayerImageCapture", th);
            this.f25435c = new c(Looper.getMainLooper());
        }
    }

    public static b a() {
        b bVar;
        synchronized (b.class) {
            try {
                if (f25434a == null) {
                    f25434a = new b();
                }
                bVar = f25434a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(C0839b c0839b) {
        MediaMetadataRetriever mediaMetadataRetriever;
        try {
            try {
            } catch (Exception e) {
                TPLogUtil.e("TPSysPlayerImageCapture", e);
                TPLogUtil.e("TPSysPlayerImageCapture", "doRealCaptureImage, Exception: " + e.toString());
                c0839b.f25436a.a(c0839b.b, TPGeneralError.FAILED);
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
                if (c0839b.d != null) {
                    this.d.setDataSource(c0839b.d);
                } else if (c0839b.e != null) {
                    this.d.setDataSource(c0839b.e.getFileDescriptor(), c0839b.e.getStartOffset(), c0839b.e.getLength());
                } else {
                    this.d.setDataSource(c0839b.f25437c, new HashMap());
                }
            }
            Bitmap frameAtTime = this.d.getFrameAtTime(c0839b.f * 1000, 2);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (frameAtTime != null) {
                c0839b.f25436a.a(c0839b.b, c0839b.f, c0839b.g, c0839b.h, frameAtTime, currentTimeMillis2 - currentTimeMillis);
            } else {
                c0839b.f25436a.a(c0839b.b, TPGeneralError.FAILED);
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
        C0839b c0839b = new C0839b();
        c0839b.b = this.e;
        c0839b.d = dVar.b;
        c0839b.e = dVar.f25440c;
        c0839b.f25437c = dVar.f25439a;
        c0839b.f = dVar.d;
        c0839b.g = dVar.e;
        c0839b.h = dVar.f;
        c0839b.f25436a = aVar;
        Message message = new Message();
        message.what = 1;
        message.obj = c0839b;
        if (!this.f25435c.sendMessage(message)) {
            TPLogUtil.i("TPSysPlayerImageCapture", "captureImageWithPosition, send msg failed ");
        }
        return this.e;
    }
}
