package com.tencent.liteav.videobase.utils;

import android.content.ContentResolver;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.base.TakeSnapshotListener;
import com.tencent.liteav.videobase.frame.PixelFrame;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/utils/k.class */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public TakeSnapshotListener f22971a;
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private com.tencent.liteav.videobase.frame.j f22972c;
    private com.tencent.liteav.videobase.frame.e d;
    private ExecutorService g;
    private boolean e = false;
    private final com.tencent.liteav.videobase.frame.c f = new com.tencent.liteav.videobase.frame.c();
    private int h = 0;
    private int i = 0;

    public k(String str) {
        this.b = "SnapshotTaker_" + str + "_" + hashCode();
    }

    public final void a() {
        LiteavLog.i(this.b, "uninitialize");
        TakeSnapshotListener takeSnapshotListener = this.f22971a;
        if (takeSnapshotListener != null) {
            takeSnapshotListener.onComplete(null);
            this.f22971a = null;
        }
        com.tencent.liteav.videobase.frame.e eVar = this.d;
        if (eVar != null && this.e) {
            eVar.a();
            this.d.b();
            this.d = null;
            this.e = false;
        }
        ExecutorService executorService = this.g;
        if (executorService != null) {
            executorService.shutdown();
            this.g = null;
        }
        com.tencent.liteav.videobase.frame.j jVar = this.f22972c;
        if (jVar != null) {
            jVar.a();
            this.f22972c = null;
        }
        this.f.d();
    }

    public final void a(int i, int i2) {
        if (i == this.h && i2 == this.i) {
            return;
        }
        String str = this.b;
        LiteavLog.i(str, "setSize width=" + i + ", height=" + i2);
        com.tencent.liteav.videobase.frame.j jVar = this.f22972c;
        if (jVar != null) {
            jVar.a();
            this.f22972c = null;
        }
        this.f22972c = new com.tencent.liteav.videobase.frame.j(i, i2);
        this.h = i;
        this.i = i2;
    }

    public final void a(PixelFrame pixelFrame) {
        int i;
        com.tencent.liteav.videobase.frame.e eVar;
        if (this.f22971a == null || pixelFrame == null) {
            return;
        }
        int i2 = this.h;
        if (i2 == 0 || (i = this.i) == 0) {
            LiteavLog.w(this.b, "snapshot when surface height or width is zero!");
        } else if (this.f22972c == null || (eVar = this.d) == null) {
            String str = this.b;
            LiteavLog.w(str, "snapshot:  mGLTexturePool= " + this.d + ", mPixelFrameRender = " + this.d);
        } else {
            com.tencent.liteav.videobase.frame.d a2 = eVar.a(i2, i);
            this.f22972c.a(pixelFrame, GLConstants.GLScaleType.CENTER_CROP, a2);
            this.f.a(a2.a());
            this.f.b();
            int i3 = this.h;
            int i4 = this.i;
            TakeSnapshotListener takeSnapshotListener = this.f22971a;
            if (takeSnapshotListener == null || this.g == null) {
                String str2 = this.b;
                LiteavLog.i(str2, "snapshot listener = " + takeSnapshotListener + ", mExecutorService = " + this.g);
            } else {
                ByteBuffer order = ByteBuffer.allocateDirect(i3 * i4 * 4).order(ByteOrder.nativeOrder());
                order.position(0);
                OpenGlUtils.readPixels(0, 0, i3, i4, order);
                try {
                    this.g.execute(l.a(order, i3, i4, takeSnapshotListener));
                } catch (Exception e) {
                    String str3 = this.b;
                    LiteavLog.w(str3, "mExecutorService execute exception: " + e.toString());
                    takeSnapshotListener.onComplete(null);
                }
            }
            this.f22971a = null;
            OpenGlUtils.bindFramebuffer(36160, 0);
            this.f.c();
            a2.release();
        }
    }

    public final void a(com.tencent.liteav.videobase.frame.e eVar) {
        LiteavLog.i(this.b, ContentResolver.SYNC_EXTRAS_INITIALIZE);
        if (this.d == null) {
            this.d = new com.tencent.liteav.videobase.frame.e();
            this.e = true;
        } else {
            this.d = eVar;
        }
        if (this.g == null) {
            this.g = new ThreadPoolExecutor(0, 1, 5L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        }
        this.f.a();
        if (this.h == 0 || this.i == 0 || this.f22972c != null) {
            return;
        }
        this.f22972c = new com.tencent.liteav.videobase.frame.j(this.h, this.i);
    }
}
