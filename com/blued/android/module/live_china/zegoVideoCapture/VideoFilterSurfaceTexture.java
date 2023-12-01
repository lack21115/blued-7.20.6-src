package com.blued.android.module.live_china.zegoVideoCapture;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES11Ext;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.view.Surface;
import com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor;
import com.blued.android.module.external_sense_library.display.STGLRender;
import com.blued.android.module.external_sense_library.glutils.GlUtil;
import com.blued.android.module.live_china.zegoVideoCapture.ve_gl.EglBase;
import com.blued.android.module.live_china.zegoVideoCapture.ve_gl.EglBase14;
import com.uc.crashsdk.export.LogType;
import com.zego.zegoavkit2.videofilter.ZegoVideoFilter;
import java.nio.ByteBuffer;
import java.util.concurrent.CountDownLatch;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/zegoVideoCapture/VideoFilterSurfaceTexture.class */
public class VideoFilterSurfaceTexture extends ZegoVideoFilter implements SurfaceTexture.OnFrameAvailableListener {
    private ISenseTimeProcessor b;
    private ByteBuffer r;

    /* renamed from: a  reason: collision with root package name */
    private ZegoVideoFilter.Client f15490a = null;

    /* renamed from: c  reason: collision with root package name */
    private HandlerThread f15491c = null;
    private volatile Handler d = null;
    private EglBase e = null;
    private EglBase f = null;
    private int g = 0;
    private int h = 0;
    private int i = 0;
    private int j = 0;
    private SurfaceTexture k = null;
    private int l = 0;
    private int m = 0;
    private Surface n = null;
    private boolean o = false;
    private boolean p = false;
    private STGLRender q = null;
    private boolean s = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public VideoFilterSurfaceTexture(Context context, ISenseTimeProcessor iSenseTimeProcessor) {
        this.b = iSenseTimeProcessor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.s) {
            return;
        }
        this.k.release();
        this.k = null;
        this.q.destroyFrameBuffers();
        this.e.f();
        int i = this.l;
        if (i != 0) {
            GLES20.glDeleteTextures(1, new int[]{i}, 0);
            this.l = 0;
        }
        this.e.e();
        this.e = null;
        if (this.f.c()) {
            this.f.f();
            int i2 = this.m;
            if (i2 != 0) {
                GLES20.glDeleteTextures(1, new int[]{i2}, 0);
                this.m = 0;
            }
        }
        this.f.e();
        this.f = null;
        Surface surface = this.n;
        if (surface != null) {
            surface.release();
            this.n = null;
        }
    }

    private void a(int i, int i2) {
        if (this.s) {
            return;
        }
        this.i = i;
        this.j = i2;
        this.g = i;
        this.h = i2;
        GLES20.glViewport(0, 0, i, i2);
        this.q.calculateZegoVertexBuffer(this.i, this.j, this.g, this.h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.s) {
            return;
        }
        this.p = true;
        if (this.f.c()) {
            this.f.f();
            int i3 = this.m;
            if (i3 != 0) {
                GLES20.glDeleteTextures(1, new int[]{i3}, 0);
                this.m = 0;
                this.k.detachFromGLContext();
            }
            this.f.h();
            this.f.d();
            this.f.g();
        }
        Surface surface = this.n;
        if (surface != null) {
            surface.release();
            this.n = null;
        }
        if (Build.VERSION.SDK_INT >= 15) {
            surfaceTexture.setDefaultBufferSize(i, i2);
        }
        Surface surface2 = new Surface(surfaceTexture);
        this.n = surface2;
        this.i = i;
        this.j = i2;
        this.f.a(surface2);
        this.f.f();
        this.q.destroyFrameBuffers();
        this.q.destroyResizeFrameBuffers();
        this.q.adjustZegoTextureBuffer(0, false, true);
        a(i, i2);
        this.q.init(this.g, this.h);
        this.f.g();
        this.p = false;
    }

    @Override // com.zego.zegoavkit2.videofilter.ZegoVideoFilter
    public void allocateAndStart(ZegoVideoFilter.Client client) {
        STGLRender sTGLRender = this.q;
        if (sTGLRender != null) {
            sTGLRender.destroyFrameBuffers();
        }
        this.q = new STGLRender(false);
        this.f15490a = client;
        HandlerThread handlerThread = new HandlerThread("video-filter");
        this.f15491c = handlerThread;
        handlerThread.start();
        this.d = new Handler(this.f15491c.getLooper());
        this.g = 0;
        this.h = 0;
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.d.post(new Runnable() { // from class: com.blued.android.module.live_china.zegoVideoCapture.VideoFilterSurfaceTexture.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    VideoFilterSurfaceTexture.this.e = EglBase.a(null, EglBase.f);
                    VideoFilterSurfaceTexture.this.e.a();
                    VideoFilterSurfaceTexture.this.e.f();
                    VideoFilterSurfaceTexture.this.s = false;
                    VideoFilterSurfaceTexture.this.l = GlUtil.a((int) GLES11Ext.GL_TEXTURE_EXTERNAL_OES);
                    VideoFilterSurfaceTexture.this.k = new SurfaceTexture(VideoFilterSurfaceTexture.this.l);
                    VideoFilterSurfaceTexture.this.k.setOnFrameAvailableListener(VideoFilterSurfaceTexture.this);
                    VideoFilterSurfaceTexture.this.k.detachFromGLContext();
                    VideoFilterSurfaceTexture.this.q.adjustZegoTextureBuffer(0, false, true);
                    VideoFilterSurfaceTexture videoFilterSurfaceTexture = VideoFilterSurfaceTexture.this;
                    videoFilterSurfaceTexture.f = EglBase.a(videoFilterSurfaceTexture.e.b(), EglBase.h);
                    VideoFilterSurfaceTexture.this.o = EglBase14.i();
                    Log.i("==record", "onSurfaceCreated");
                    VideoFilterSurfaceTexture.this.b.onSurfaceCreated();
                    countDownLatch.countDown();
                } catch (RuntimeException e) {
                    VideoFilterSurfaceTexture.this.e.d();
                    VideoFilterSurfaceTexture.this.s = true;
                }
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.p = false;
    }

    @Override // com.zego.zegoavkit2.videofilter.ZegoVideoFilter
    public int dequeueInputBuffer(final int i, final int i2, int i3) {
        if (!this.s && i3 == i * 4) {
            if (this.g == i && this.h == i2) {
                return 0;
            }
            if (this.f15490a.dequeueInputBuffer(i, i2, i3) < 0) {
                return -1;
            }
            this.g = i;
            this.h = i2;
            final SurfaceTexture surfaceTexture = this.f15490a.getSurfaceTexture();
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            this.d.post(new Runnable() { // from class: com.blued.android.module.live_china.zegoVideoCapture.VideoFilterSurfaceTexture.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoFilterSurfaceTexture.this.a(surfaceTexture, i, i2);
                    VideoFilterSurfaceTexture.this.b.adjustViewPort(i, i2);
                    countDownLatch.countDown();
                }
            });
            try {
                countDownLatch.await();
                return 0;
            } catch (InterruptedException e) {
                e.printStackTrace();
                return 0;
            }
        }
        return -1;
    }

    @Override // com.zego.zegoavkit2.videofilter.ZegoVideoFilter
    public ByteBuffer getInputBuffer(int i) {
        return null;
    }

    @Override // com.zego.zegoavkit2.videofilter.ZegoVideoFilter
    public SurfaceTexture getSurfaceTexture() {
        return this.k;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        if (this.s || this.p) {
            return;
        }
        this.f.f();
        if (this.m == 0) {
            int a2 = GlUtil.a((int) GLES11Ext.GL_TEXTURE_EXTERNAL_OES);
            this.m = a2;
            surfaceTexture.attachToGLContext(a2);
        }
        SurfaceTexture surfaceTexture2 = this.k;
        if (surfaceTexture2 == null || this.p) {
            return;
        }
        surfaceTexture2.updateTexImage();
        long timestamp = surfaceTexture.getTimestamp();
        if (this.r == null) {
            this.r = ByteBuffer.allocate(this.h * this.g * 4);
        }
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(LogType.UNEXP_RESTART);
        this.r.rewind();
        int preProcess = this.q.preProcess(this.m, this.r);
        this.b.handlePreviewFrame(this.r.array(), this.i, this.j, 0);
        int drawFrame = this.b.drawFrame(preProcess, this.i, this.j, false);
        if (drawFrame > 0) {
            GLES20.glViewport(0, 0, this.i, this.j);
            this.q.onDrawFrame(drawFrame);
            if (this.o) {
                ((EglBase14) this.f).a(timestamp);
            } else {
                this.f.h();
            }
            this.f.g();
        }
    }

    @Override // com.zego.zegoavkit2.videofilter.ZegoVideoFilter
    public void onProcessCallback(int i, int i2, int i3, long j) {
    }

    @Override // com.zego.zegoavkit2.videofilter.ZegoVideoFilter
    public void queueInputBuffer(int i, int i2, int i3, int i4, long j) {
    }

    @Override // com.zego.zegoavkit2.videofilter.ZegoVideoFilter
    public void stopAndDeAllocate() {
        this.p = true;
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.d.post(new Runnable() { // from class: com.blued.android.module.live_china.zegoVideoCapture.VideoFilterSurfaceTexture.2
            @Override // java.lang.Runnable
            public void run() {
                VideoFilterSurfaceTexture.this.b.onSurfaceDestroyed();
                VideoFilterSurfaceTexture.this.a();
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.d = null;
        this.f15491c.quit();
        this.f15491c = null;
        this.f15490a.destroy();
        this.f15490a = null;
    }

    @Override // com.zego.zegoavkit2.videofilter.ZegoVideoFilter
    public int supportBufferType() {
        return 8;
    }
}
