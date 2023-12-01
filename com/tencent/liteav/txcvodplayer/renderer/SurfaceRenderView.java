package com.tencent.liteav.txcvodplayer.renderer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
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

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/txcvodplayer/renderer/SurfaceRenderView.class */
public class SurfaceRenderView extends SurfaceView implements com.tencent.liteav.txcvodplayer.renderer.a {

    /* renamed from: a  reason: collision with root package name */
    private com.tencent.liteav.txcvodplayer.renderer.b f22862a;
    private b b;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/txcvodplayer/renderer/SurfaceRenderView$a.class */
    static final class a implements a.b {

        /* renamed from: a  reason: collision with root package name */
        private SurfaceRenderView f22863a;
        private SurfaceHolder b;

        public a(SurfaceRenderView surfaceRenderView, SurfaceHolder surfaceHolder) {
            this.f22863a = surfaceRenderView;
            this.b = surfaceHolder;
        }

        @Override // com.tencent.liteav.txcvodplayer.renderer.a.b
        public final com.tencent.liteav.txcvodplayer.renderer.a a() {
            return this.f22863a;
        }

        @Override // com.tencent.liteav.txcvodplayer.renderer.a.b
        public final void a(ITXVCubePlayer iTXVCubePlayer) {
            if (iTXVCubePlayer != null) {
                if (LiteavSystemInfo.getSystemOSVersionInt() >= 16 && (iTXVCubePlayer instanceof com.tencent.liteav.txcplayer.b)) {
                    ((com.tencent.liteav.txcplayer.b) iTXVCubePlayer).setSurfaceTexture(null);
                }
                iTXVCubePlayer.setDisplay(this.b);
            }
        }

        @Override // com.tencent.liteav.txcvodplayer.renderer.a.b
        public final Surface b() {
            SurfaceHolder surfaceHolder = this.b;
            if (surfaceHolder == null) {
                return null;
            }
            return surfaceHolder.getSurface();
        }

        @Override // com.tencent.liteav.txcvodplayer.renderer.a.b
        public final Surface c() {
            return b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/txcvodplayer/renderer/SurfaceRenderView$b.class */
    public static final class b implements SurfaceHolder.Callback {

        /* renamed from: a  reason: collision with root package name */
        SurfaceHolder f22864a;
        boolean b;

        /* renamed from: c  reason: collision with root package name */
        int f22865c;
        int d;
        WeakReference<SurfaceRenderView> e;
        Map<a.InterfaceC0765a, Object> f = new ConcurrentHashMap();
        private int g;

        public b(SurfaceRenderView surfaceRenderView) {
            this.e = new WeakReference<>(surfaceRenderView);
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            this.f22864a = surfaceHolder;
            this.b = true;
            this.g = i;
            this.f22865c = i2;
            this.d = i3;
            a aVar = new a(this.e.get(), this.f22864a);
            for (a.InterfaceC0765a interfaceC0765a : this.f.keySet()) {
                interfaceC0765a.a(aVar, i2, i3);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceCreated(SurfaceHolder surfaceHolder) {
            this.f22864a = surfaceHolder;
            this.b = false;
            this.g = 0;
            this.f22865c = 0;
            this.d = 0;
            a aVar = new a(this.e.get(), this.f22864a);
            for (a.InterfaceC0765a interfaceC0765a : this.f.keySet()) {
                interfaceC0765a.a(aVar);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            this.f22864a = null;
            this.b = false;
            this.g = 0;
            this.f22865c = 0;
            this.d = 0;
            a aVar = new a(this.e.get(), this.f22864a);
            for (a.InterfaceC0765a interfaceC0765a : this.f.keySet()) {
                interfaceC0765a.b(aVar);
            }
        }
    }

    public SurfaceRenderView(Context context) {
        super(context);
        b();
    }

    public SurfaceRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public SurfaceRenderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b();
    }

    private void b() {
        this.f22862a = new com.tencent.liteav.txcvodplayer.renderer.b(this);
        this.b = new b(this);
        getHolder().addCallback(this.b);
        getHolder().setType(0);
    }

    @Override // com.tencent.liteav.txcvodplayer.renderer.a
    public final void a(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        this.f22862a.a(i, i2);
        getHolder().setFixedSize(i, i2);
        requestLayout();
    }

    @Override // com.tencent.liteav.txcvodplayer.renderer.a
    public final void a(a.InterfaceC0765a interfaceC0765a) {
        a aVar;
        b bVar = this.b;
        bVar.f.put(interfaceC0765a, interfaceC0765a);
        if (bVar.f22864a != null) {
            aVar = new a(bVar.e.get(), bVar.f22864a);
            interfaceC0765a.a(aVar);
        } else {
            aVar = null;
        }
        if (bVar.b) {
            a aVar2 = aVar;
            if (aVar == null) {
                aVar2 = new a(bVar.e.get(), bVar.f22864a);
            }
            interfaceC0765a.a(aVar2, bVar.f22865c, bVar.d);
        }
    }

    @Override // com.tencent.liteav.txcvodplayer.renderer.a
    public final boolean a() {
        return true;
    }

    @Override // com.tencent.liteav.txcvodplayer.renderer.a
    public final void b(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        this.f22862a.b(i, i2);
        requestLayout();
    }

    @Override // com.tencent.liteav.txcvodplayer.renderer.a
    public final void b(a.InterfaceC0765a interfaceC0765a) {
        this.b.f.remove(interfaceC0765a);
    }

    @Override // com.tencent.liteav.txcvodplayer.renderer.a
    public View getView() {
        return this;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(SurfaceRenderView.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 14) {
            accessibilityNodeInfo.setClassName(SurfaceRenderView.class.getName());
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onMeasure(int i, int i2) {
        this.f22862a.c(i, i2);
        setMeasuredDimension(this.f22862a.b, this.f22862a.f22872c);
    }

    @Override // com.tencent.liteav.txcvodplayer.renderer.a
    public void setAspectRatio(int i) {
        this.f22862a.d = i;
        requestLayout();
    }

    @Override // com.tencent.liteav.txcvodplayer.renderer.a
    public void setVideoRotation(int i) {
        LiteavLog.e("", "SurfaceView doesn't support rotation (" + i + ")!\n");
    }
}
