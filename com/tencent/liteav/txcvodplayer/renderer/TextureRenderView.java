package com.tencent.liteav.txcvodplayer.renderer;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.txcplayer.ITXVCubePlayer;
import com.tencent.liteav.txcvodplayer.renderer.a;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/txcvodplayer/renderer/TextureRenderView.class */
public class TextureRenderView extends TextureView implements com.tencent.liteav.txcvodplayer.renderer.a {

    /* renamed from: a  reason: collision with root package name */
    private com.tencent.liteav.txcvodplayer.renderer.b f22866a;
    private b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/txcvodplayer/renderer/TextureRenderView$a.class */
    public static final class a implements a.b {

        /* renamed from: a  reason: collision with root package name */
        private TextureRenderView f22867a;
        private SurfaceTexture b;

        /* renamed from: c  reason: collision with root package name */
        private com.tencent.liteav.txcplayer.c f22868c;
        private Surface d;

        public a(TextureRenderView textureRenderView, SurfaceTexture surfaceTexture, com.tencent.liteav.txcplayer.c cVar) {
            this.f22867a = textureRenderView;
            this.b = surfaceTexture;
            this.f22868c = cVar;
        }

        @Override // com.tencent.liteav.txcvodplayer.renderer.a.b
        public final com.tencent.liteav.txcvodplayer.renderer.a a() {
            return this.f22867a;
        }

        @Override // com.tencent.liteav.txcvodplayer.renderer.a.b
        public final void a(ITXVCubePlayer iTXVCubePlayer) {
            if (iTXVCubePlayer == null) {
                return;
            }
            if (LiteavSystemInfo.getSystemOSVersionInt() < 16 || !(iTXVCubePlayer instanceof com.tencent.liteav.txcplayer.b)) {
                Surface b = b();
                this.d = b;
                iTXVCubePlayer.setSurface(b);
                return;
            }
            com.tencent.liteav.txcplayer.b bVar = (com.tencent.liteav.txcplayer.b) iTXVCubePlayer;
            this.f22867a.b.e = false;
            if (this.f22867a.getSurfaceTexture() != null) {
                this.b = this.f22867a.getSurfaceTexture();
            }
            try {
                SurfaceTexture surfaceTexture = bVar.getSurfaceTexture();
                if (surfaceTexture != null) {
                    bVar.setSurfaceTextureHost(this.f22867a.b);
                    if (this.f22867a.getSurfaceTexture() != surfaceTexture) {
                        this.f22867a.setSurfaceTexture(surfaceTexture);
                    }
                    this.f22867a.b.f22869a = surfaceTexture;
                } else {
                    if (this.d != null) {
                        iTXVCubePlayer.setSurface(this.d);
                    }
                    bVar.setSurfaceTexture(this.b);
                    bVar.setSurfaceTextureHost(this.f22867a.b);
                }
                this.d = iTXVCubePlayer.getSurface();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.tencent.liteav.txcvodplayer.renderer.a.b
        public final Surface b() {
            if (this.b == null) {
                return null;
            }
            if (this.d == null) {
                this.d = new Surface(this.b);
            }
            return this.d;
        }

        @Override // com.tencent.liteav.txcvodplayer.renderer.a.b
        public final Surface c() {
            return this.d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/txcvodplayer/renderer/TextureRenderView$b.class */
    public static final class b implements TextureView.SurfaceTextureListener, com.tencent.liteav.txcplayer.c {

        /* renamed from: a  reason: collision with root package name */
        SurfaceTexture f22869a;
        boolean b;

        /* renamed from: c  reason: collision with root package name */
        int f22870c;
        int d;
        WeakReference<TextureRenderView> h;
        boolean e = true;
        boolean f = false;
        boolean g = false;
        Map<a.InterfaceC0765a, Object> i = new ConcurrentHashMap();

        public b(TextureRenderView textureRenderView) {
            this.h = new WeakReference<>(textureRenderView);
        }

        @Override // com.tencent.liteav.txcplayer.c
        public final void a(SurfaceTexture surfaceTexture) {
            if (surfaceTexture == null) {
                LiteavLog.i("TextureRenderView", "releaseSurfaceTexture: null");
            } else if (this.g) {
                if (surfaceTexture != this.f22869a) {
                    LiteavLog.i("TextureRenderView", "releaseSurfaceTexture: didDetachFromWindow(): release different SurfaceTexture");
                    surfaceTexture.release();
                } else if (this.e) {
                    LiteavLog.i("TextureRenderView", "releaseSurfaceTexture: didDetachFromWindow(): already released by TextureView");
                } else {
                    LiteavLog.i("TextureRenderView", "releaseSurfaceTexture: didDetachFromWindow(): release detached SurfaceTexture");
                    surfaceTexture.release();
                }
            } else if (this.f) {
                if (surfaceTexture != this.f22869a) {
                    LiteavLog.i("TextureRenderView", "releaseSurfaceTexture: willDetachFromWindow(): release different SurfaceTexture");
                    surfaceTexture.release();
                } else if (this.e) {
                    LiteavLog.i("TextureRenderView", "releaseSurfaceTexture: willDetachFromWindow(): will released by TextureView");
                } else {
                    LiteavLog.i("TextureRenderView", "releaseSurfaceTexture: willDetachFromWindow(): re-attach SurfaceTexture to TextureView");
                    this.e = true;
                }
            } else if (surfaceTexture != this.f22869a) {
                LiteavLog.i("TextureRenderView", "releaseSurfaceTexture: alive: release different SurfaceTexture");
                surfaceTexture.release();
            } else if (this.e) {
                LiteavLog.i("TextureRenderView", "releaseSurfaceTexture: alive: will released by TextureView");
            } else {
                LiteavLog.i("TextureRenderView", "releaseSurfaceTexture: alive: re-attach SurfaceTexture to TextureView");
                this.e = true;
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            this.f22869a = surfaceTexture;
            this.b = false;
            this.f22870c = 0;
            this.d = 0;
            a aVar = new a(this.h.get(), surfaceTexture, this);
            for (a.InterfaceC0765a interfaceC0765a : this.i.keySet()) {
                interfaceC0765a.a(aVar);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.f22869a = surfaceTexture;
            this.b = false;
            this.f22870c = 0;
            this.d = 0;
            a aVar = new a(this.h.get(), surfaceTexture, this);
            for (a.InterfaceC0765a interfaceC0765a : this.i.keySet()) {
                interfaceC0765a.b(aVar);
            }
            LiteavLog.i("TextureRenderView", "onSurfaceTextureDestroyed: destroy: " + this.e);
            return this.e;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            this.f22869a = surfaceTexture;
            this.b = true;
            this.f22870c = i;
            this.d = i2;
            a aVar = new a(this.h.get(), surfaceTexture, this);
            for (a.InterfaceC0765a interfaceC0765a : this.i.keySet()) {
                interfaceC0765a.a(aVar, i, i2);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    public TextureRenderView(Context context) {
        super(context);
        b();
    }

    public TextureRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public TextureRenderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b();
    }

    private void b() {
        this.f22866a = new com.tencent.liteav.txcvodplayer.renderer.b(this);
        b bVar = new b(this);
        this.b = bVar;
        setSurfaceTextureListener(bVar);
    }

    @Override // com.tencent.liteav.txcvodplayer.renderer.a
    public final void a(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        this.f22866a.a(i, i2);
        requestLayout();
    }

    @Override // com.tencent.liteav.txcvodplayer.renderer.a
    public final void a(a.InterfaceC0765a interfaceC0765a) {
        a aVar;
        b bVar = this.b;
        bVar.i.put(interfaceC0765a, interfaceC0765a);
        if (bVar.f22869a != null) {
            aVar = new a(bVar.h.get(), bVar.f22869a, bVar);
            interfaceC0765a.a(aVar);
        } else {
            aVar = null;
        }
        if (bVar.b) {
            a aVar2 = aVar;
            if (aVar == null) {
                aVar2 = new a(bVar.h.get(), bVar.f22869a, bVar);
            }
            interfaceC0765a.a(aVar2, bVar.f22870c, bVar.d);
        }
    }

    @Override // com.tencent.liteav.txcvodplayer.renderer.a
    public final boolean a() {
        return false;
    }

    @Override // com.tencent.liteav.txcvodplayer.renderer.a
    public final void b(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        this.f22866a.b(i, i2);
        requestLayout();
    }

    @Override // com.tencent.liteav.txcvodplayer.renderer.a
    public final void b(a.InterfaceC0765a interfaceC0765a) {
        this.b.i.remove(interfaceC0765a);
    }

    public a.b getSurfaceHolder() {
        return new a(this, this.b.f22869a, this.b);
    }

    @Override // com.tencent.liteav.txcvodplayer.renderer.a
    public View getView() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.TextureView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        b bVar = this.b;
        LiteavLog.i("TextureRenderView", "onAttachFromWindow()");
        bVar.f = false;
        bVar.g = false;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        try {
            b bVar = this.b;
            LiteavLog.i("TextureRenderView", "willDetachFromWindow()");
            bVar.f = true;
            super.onDetachedFromWindow();
            b bVar2 = this.b;
            LiteavLog.i("TextureRenderView", "didDetachFromWindow()");
            bVar2.g = true;
        } catch (Exception e) {
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(TextureRenderView.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(TextureRenderView.class.getName());
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.f22866a.c(i, i2);
        setMeasuredDimension(this.f22866a.b, this.f22866a.f22872c);
    }

    @Override // com.tencent.liteav.txcvodplayer.renderer.a
    public void setAspectRatio(int i) {
        this.f22866a.d = i;
        requestLayout();
    }

    @Override // com.tencent.liteav.txcvodplayer.renderer.a
    public void setVideoRotation(int i) {
        this.f22866a.f22871a = i;
        setRotation(i);
    }
}
