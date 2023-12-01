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
    private com.tencent.liteav.txcvodplayer.renderer.b f36553a;
    private b b;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/txcvodplayer/renderer/SurfaceRenderView$a.class */
    static final class a implements a.b {

        /* renamed from: a  reason: collision with root package name */
        private SurfaceRenderView f36554a;
        private SurfaceHolder b;

        public a(SurfaceRenderView surfaceRenderView, SurfaceHolder surfaceHolder) {
            this.f36554a = surfaceRenderView;
            this.b = surfaceHolder;
        }

        @Override // com.tencent.liteav.txcvodplayer.renderer.a.b
        public final com.tencent.liteav.txcvodplayer.renderer.a a() {
            return this.f36554a;
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
        SurfaceHolder f36555a;
        boolean b;

        /* renamed from: c  reason: collision with root package name */
        int f36556c;
        int d;
        WeakReference<SurfaceRenderView> e;
        Map<a.InterfaceC0935a, Object> f = new ConcurrentHashMap();
        private int g;

        public b(SurfaceRenderView surfaceRenderView) {
            this.e = new WeakReference<>(surfaceRenderView);
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            this.f36555a = surfaceHolder;
            this.b = true;
            this.g = i;
            this.f36556c = i2;
            this.d = i3;
            a aVar = new a(this.e.get(), this.f36555a);
            for (a.InterfaceC0935a interfaceC0935a : this.f.keySet()) {
                interfaceC0935a.a(aVar, i2, i3);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceCreated(SurfaceHolder surfaceHolder) {
            this.f36555a = surfaceHolder;
            this.b = false;
            this.g = 0;
            this.f36556c = 0;
            this.d = 0;
            a aVar = new a(this.e.get(), this.f36555a);
            for (a.InterfaceC0935a interfaceC0935a : this.f.keySet()) {
                interfaceC0935a.a(aVar);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            this.f36555a = null;
            this.b = false;
            this.g = 0;
            this.f36556c = 0;
            this.d = 0;
            a aVar = new a(this.e.get(), this.f36555a);
            for (a.InterfaceC0935a interfaceC0935a : this.f.keySet()) {
                interfaceC0935a.b(aVar);
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
        this.f36553a = new com.tencent.liteav.txcvodplayer.renderer.b(this);
        this.b = new b(this);
        getHolder().addCallback(this.b);
        getHolder().setType(0);
    }

    @Override // com.tencent.liteav.txcvodplayer.renderer.a
    public final void a(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        this.f36553a.a(i, i2);
        getHolder().setFixedSize(i, i2);
        requestLayout();
    }

    @Override // com.tencent.liteav.txcvodplayer.renderer.a
    public final void a(a.InterfaceC0935a interfaceC0935a) {
        a aVar;
        b bVar = this.b;
        bVar.f.put(interfaceC0935a, interfaceC0935a);
        if (bVar.f36555a != null) {
            aVar = new a(bVar.e.get(), bVar.f36555a);
            interfaceC0935a.a(aVar);
        } else {
            aVar = null;
        }
        if (bVar.b) {
            a aVar2 = aVar;
            if (aVar == null) {
                aVar2 = new a(bVar.e.get(), bVar.f36555a);
            }
            interfaceC0935a.a(aVar2, bVar.f36556c, bVar.d);
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
        this.f36553a.b(i, i2);
        requestLayout();
    }

    @Override // com.tencent.liteav.txcvodplayer.renderer.a
    public final void b(a.InterfaceC0935a interfaceC0935a) {
        this.b.f.remove(interfaceC0935a);
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.SurfaceView, android.view.View
    public void onMeasure(int i, int i2) {
        this.f36553a.c(i, i2);
        setMeasuredDimension(this.f36553a.b, this.f36553a.f36563c);
    }

    @Override // com.tencent.liteav.txcvodplayer.renderer.a
    public void setAspectRatio(int i) {
        this.f36553a.d = i;
        requestLayout();
    }

    @Override // com.tencent.liteav.txcvodplayer.renderer.a
    public void setVideoRotation(int i) {
        LiteavLog.e("", "SurfaceView doesn't support rotation (" + i + ")!\n");
    }
}
