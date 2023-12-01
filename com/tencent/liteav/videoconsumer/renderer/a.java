package com.tencent.liteav.videoconsumer.renderer;

import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.videobase.DisplayTarget;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/renderer/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    final InterfaceC0939a f36813a;
    DisplayTarget e;
    Surface b = null;

    /* renamed from: c  reason: collision with root package name */
    SurfaceTexture f36814c = null;
    final com.tencent.liteav.base.util.n d = new com.tencent.liteav.base.util.n();
    private final b f = new b(this, (byte) 0);
    private final com.tencent.liteav.base.util.b g = new com.tencent.liteav.base.util.b(Looper.getMainLooper());

    /* renamed from: com.tencent.liteav.videoconsumer.renderer.a$a  reason: collision with other inner class name */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/renderer/a$a.class */
    public interface InterfaceC0939a {
        void a();

        void a(Surface surface, int i, int i2, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/renderer/a$b.class */
    public final class b implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener {
        private b() {
        }

        /* synthetic */ b(a aVar, byte b) {
            this();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            LiteavLog.i("VideoRenderer.DisplayViewWrapper", "onSurfaceTextureAvailable");
            a aVar = a.this;
            SurfaceTexture surfaceTexture2 = surfaceTexture;
            if (aVar.f36814c != null) {
                if (aVar.e == null) {
                    surfaceTexture2 = surfaceTexture;
                } else {
                    TextureView videoView = aVar.e.getType() == DisplayTarget.a.TXCLOUDVIEW ? aVar.e.getTXCloudVideoView().getVideoView() : aVar.e.getType() == DisplayTarget.a.TEXTUREVIEW ? aVar.e.getTextureView() : null;
                    surfaceTexture2 = surfaceTexture;
                    if (videoView != null) {
                        surfaceTexture2 = surfaceTexture;
                        if (surfaceTexture != aVar.f36814c) {
                            videoView.setSurfaceTexture(aVar.f36814c);
                            surfaceTexture2 = aVar.f36814c;
                            aVar.f36814c = null;
                        }
                    }
                }
            }
            a.a(a.this, surfaceTexture2, i, i2);
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x009b  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00a5 A[RETURN] */
        @Override // android.view.TextureView.SurfaceTextureListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean onSurfaceTextureDestroyed(android.graphics.SurfaceTexture r4) {
            /*
                r3 = this;
                java.lang.String r0 = "VideoRenderer.DisplayViewWrapper"
                java.lang.String r1 = "onSurfaceTextureDestroyed"
                com.tencent.liteav.base.util.LiteavLog.i(r0, r1)
                r0 = r3
                com.tencent.liteav.videoconsumer.renderer.a r0 = com.tencent.liteav.videoconsumer.renderer.a.this
                com.tencent.liteav.videoconsumer.renderer.a$a r0 = r0.f36813a
                if (r0 == 0) goto L1d
                r0 = r3
                com.tencent.liteav.videoconsumer.renderer.a r0 = com.tencent.liteav.videoconsumer.renderer.a.this
                com.tencent.liteav.videoconsumer.renderer.a$a r0 = r0.f36813a
                r0.a()
            L1d:
                r0 = r3
                com.tencent.liteav.videoconsumer.renderer.a r0 = com.tencent.liteav.videoconsumer.renderer.a.this
                r1 = 0
                r0.b = r1
                r0 = r3
                com.tencent.liteav.videoconsumer.renderer.a r0 = com.tencent.liteav.videoconsumer.renderer.a.this
                com.tencent.liteav.base.util.n r0 = r0.d
                r1 = 0
                r0.f36340a = r1
                r0 = r3
                com.tencent.liteav.videoconsumer.renderer.a r0 = com.tencent.liteav.videoconsumer.renderer.a.this
                com.tencent.liteav.base.util.n r0 = r0.d
                r1 = 0
                r0.b = r1
                r0 = r3
                com.tencent.liteav.videoconsumer.renderer.a r0 = com.tencent.liteav.videoconsumer.renderer.a.this
                r6 = r0
                r0 = r6
                com.tencent.liteav.videobase.videobase.DisplayTarget r0 = r0.e
                if (r0 == 0) goto L95
                r0 = r6
                com.tencent.liteav.videobase.videobase.DisplayTarget r0 = r0.e
                com.tencent.liteav.videobase.videobase.DisplayTarget$a r0 = r0.getType()
                com.tencent.liteav.videobase.videobase.DisplayTarget$a r1 = com.tencent.liteav.videobase.videobase.DisplayTarget.a.TEXTUREVIEW
                if (r0 != r1) goto L63
                r0 = r6
                com.tencent.liteav.videobase.videobase.DisplayTarget r0 = r0.e
                android.view.TextureView r0 = r0.getTextureView()
                if (r0 == 0) goto L63
            L5e:
                r0 = 1
                r5 = r0
                goto L8c
            L63:
                r0 = r6
                com.tencent.liteav.videobase.videobase.DisplayTarget r0 = r0.e
                com.tencent.liteav.videobase.videobase.DisplayTarget$a r0 = r0.getType()
                com.tencent.liteav.videobase.videobase.DisplayTarget$a r1 = com.tencent.liteav.videobase.videobase.DisplayTarget.a.TXCLOUDVIEW
                if (r0 != r1) goto L8a
                r0 = r6
                com.tencent.liteav.videobase.videobase.DisplayTarget r0 = r0.e
                com.tencent.rtmp.ui.TXCloudVideoView r0 = r0.getTXCloudVideoView()
                if (r0 == 0) goto L8a
                r0 = r6
                com.tencent.liteav.videobase.videobase.DisplayTarget r0 = r0.e
                com.tencent.rtmp.ui.TXCloudVideoView r0 = r0.getTXCloudVideoView()
                android.view.TextureView r0 = r0.getVideoView()
                if (r0 == 0) goto L8a
                goto L5e
            L8a:
                r0 = 0
                r5 = r0
            L8c:
                r0 = r5
                if (r0 == 0) goto L95
                r0 = 1
                r5 = r0
                goto L97
            L95:
                r0 = 0
                r5 = r0
            L97:
                r0 = r5
                if (r0 == 0) goto La5
                r0 = r3
                com.tencent.liteav.videoconsumer.renderer.a r0 = com.tencent.liteav.videoconsumer.renderer.a.this
                r1 = r4
                r0.f36814c = r1
                r0 = 0
                return r0
            La5:
                r0 = 1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videoconsumer.renderer.a.b.onSurfaceTextureDestroyed(android.graphics.SurfaceTexture):boolean");
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            LiteavLog.i("VideoRenderer.DisplayViewWrapper", "onSurfaceTextureSizeChanged");
            a.a(a.this, surfaceTexture, i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            if (surfaceHolder != null) {
                LiteavLog.i("VideoRenderer.DisplayViewWrapper", "surfaceChanged " + i2 + " " + i3);
                a.this.b = surfaceHolder.getSurface();
                a.this.a(i2, i3);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceCreated(SurfaceHolder surfaceHolder) {
            if (surfaceHolder != null) {
                LiteavLog.i("VideoRenderer.DisplayViewWrapper", "surfaceCreated");
                a.this.a(surfaceHolder.getSurface());
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            LiteavLog.i("VideoRenderer.DisplayViewWrapper", "surfaceDestroyed");
            a.this.b = null;
            com.tencent.liteav.base.util.n nVar = a.this.d;
            a.this.d.f36340a = 0;
            nVar.b = 0;
            if (a.this.f36813a != null) {
                a.this.f36813a.a();
            }
        }
    }

    public a(InterfaceC0939a interfaceC0939a) {
        this.f36813a = interfaceC0939a;
    }

    static /* synthetic */ void a(a aVar, SurfaceTexture surfaceTexture, int i, int i2) {
        aVar.b = new Surface(surfaceTexture);
        aVar.d.f36340a = i;
        aVar.d.b = i2;
        InterfaceC0939a interfaceC0939a = aVar.f36813a;
        if (interfaceC0939a != null) {
            interfaceC0939a.a(aVar.b, aVar.d.f36340a, aVar.d.b, true);
        }
    }

    public final void a(int i, int i2) {
        this.g.post(d.a(this, i, i2));
    }

    public final void a(Surface surface) {
        this.g.post(c.a(this, surface));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(SurfaceView surfaceView) {
        InterfaceC0939a interfaceC0939a;
        DisplayTarget displayTarget = this.e;
        if (displayTarget != null && surfaceView == displayTarget.getSurfaceView() && this.e.getType() == DisplayTarget.a.SURFACEVIEW) {
            LiteavLog.i("VideoRenderer.DisplayViewWrapper", "setDisplayView set same surfaceview!" + this.e);
            return;
        }
        if (a()) {
            if (surfaceView == null && (interfaceC0939a = this.f36813a) != null) {
                interfaceC0939a.a();
            }
            b();
            c();
        }
        if (surfaceView == null) {
            return;
        }
        SurfaceHolder holder = surfaceView.getHolder();
        this.d.b = surfaceView.getHeight();
        this.d.f36340a = surfaceView.getWidth();
        if (holder.getSurface().isValid()) {
            Surface surface = surfaceView.getHolder().getSurface();
            Rect surfaceFrame = surfaceView.getHolder().getSurfaceFrame();
            LiteavLog.i("VideoRenderer.DisplayViewWrapper", "setDisplayView %d %d*%d when construct", Integer.valueOf(surface != null ? surface.hashCode() : 0), Integer.valueOf(surfaceFrame.width()), Integer.valueOf(surfaceFrame.height()));
            this.b = surface;
            InterfaceC0939a interfaceC0939a2 = this.f36813a;
            if (interfaceC0939a2 != null) {
                interfaceC0939a2.a(surface, surfaceFrame.width(), surfaceFrame.height(), false);
            }
        } else {
            LiteavLog.i("VideoRenderer.DisplayViewWrapper", "setDisplayView, SurfaceView not valid");
        }
        surfaceView.getHolder().addCallback(this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(TextureView textureView) {
        InterfaceC0939a interfaceC0939a;
        DisplayTarget displayTarget = this.e;
        if (displayTarget != null && textureView == displayTarget.getTextureView() && this.e.getType() == DisplayTarget.a.TEXTUREVIEW) {
            LiteavLog.i("VideoRenderer.DisplayViewWrapper", "setDisplayView set same textureview!" + this.e);
            return;
        }
        if (a()) {
            if (textureView == null && (interfaceC0939a = this.f36813a) != null) {
                interfaceC0939a.a();
            }
            b();
            c();
        }
        if (textureView == null) {
            return;
        }
        this.d.b = textureView.getHeight();
        this.d.f36340a = textureView.getWidth();
        LiteavLog.d("VideoRenderer.DisplayViewWrapper", "mSurfaceSize.height = " + this.d.b + " mSurfaceSize.width= " + this.d.f36340a);
        if (textureView.isAvailable()) {
            LiteavLog.i("VideoRenderer.DisplayViewWrapper", "setDisplayView TextureView " + textureView + " " + textureView.getWidth() + " " + textureView.getHeight());
            Surface surface = new Surface(textureView.getSurfaceTexture());
            this.b = surface;
            InterfaceC0939a interfaceC0939a2 = this.f36813a;
            if (interfaceC0939a2 != null) {
                interfaceC0939a2.a(surface, textureView.getWidth(), textureView.getHeight(), true);
            }
        } else {
            LiteavLog.i("VideoRenderer.DisplayViewWrapper", "setDisplayView, TextureView not Available");
        }
        textureView.setSurfaceTextureListener(this.f);
    }

    public final void a(DisplayTarget displayTarget) {
        this.g.post(com.tencent.liteav.videoconsumer.renderer.b.a(this, displayTarget));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a() {
        return this.e != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b() {
        DisplayTarget displayTarget = this.e;
        if (displayTarget != null) {
            SurfaceView surfaceView = displayTarget.getSurfaceView();
            TextureView textureView = this.e.getTextureView();
            if (surfaceView != null) {
                surfaceView.getHolder().removeCallback(this.f);
            }
            if (textureView == null || textureView.getSurfaceTextureListener() != this.f) {
                return;
            }
            textureView.setSurfaceTextureListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c() {
        SurfaceTexture surfaceTexture = this.f36814c;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.f36814c = null;
        }
    }
}
