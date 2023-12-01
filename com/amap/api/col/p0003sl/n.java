package com.amap.api.col.p0003sl;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.base.ae.gmap.GLMapRender;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IGLSurfaceView;

/* renamed from: com.amap.api.col.3sl.n  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/n.class */
public final class n extends GLSurfaceView implements IGLSurfaceView {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f5399a;
    private IAMapDelegate b;

    /* renamed from: c  reason: collision with root package name */
    private GLMapRender f5400c;

    public n(Context context, boolean z) {
        this(context, z, (byte) 0);
    }

    private n(Context context, boolean z, byte b) {
        super(context, null);
        this.b = null;
        this.f5400c = null;
        this.f5399a = false;
        di.a(this);
        this.b = new l(this, context, z);
    }

    public final IAMapDelegate a() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        dy.a(dx.f4872c, "AMapGLSurfaceView onAttachedToWindow");
        try {
            if (this.f5400c != null) {
                this.f5400c.onAttachedToWindow();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            dw.a(th);
        }
        onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    public final void onDetachedFromWindow() {
        String str = dx.f4872c;
        dy.a(str, "AMapGLSurfaceView onDetachedFromWindow MapsInitializer.isSupportRecycleView() " + MapsInitializer.isSupportRecycleView());
        if (MapsInitializer.isSupportRecycleView()) {
            return;
        }
        onPause();
        try {
            if (this.f5400c != null) {
                this.f5400c.onDetachedFromWindow();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.onDetachedFromWindow();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void onDetachedGLThread() {
        String str = dx.f4872c;
        dy.a(str, "AMapGLSurfaceView onDetachedGLThread MapsInitializer.isSupportRecycleView() " + MapsInitializer.isSupportRecycleView());
        if (MapsInitializer.isSupportRecycleView()) {
            onPause();
            try {
                if (this.f5400c != null) {
                    this.f5400c.onDetachedFromWindow();
                }
            } catch (Throwable th) {
                th.printStackTrace();
                dw.a(th);
            }
            super.onDetachedFromWindow();
        }
    }

    @Override // android.opengl.GLSurfaceView
    public final void onPause() {
        String str = dx.f4872c;
        dy.a(str, "AMapGLSurfaceView onPause mMapRender.mSurfacedestoryed " + this.f5400c.mSurfacedestoryed);
        if (!this.f5400c.mSurfacedestoryed) {
            queueEvent(new Runnable() { // from class: com.amap.api.col.3sl.n.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (n.this.f5400c != null) {
                        try {
                            n.this.f5400c.onSurfaceDestory();
                        } catch (Throwable th) {
                            th.printStackTrace();
                            dw.a(th);
                        }
                    }
                }
            });
            int i = 0;
            while (true) {
                int i2 = i;
                if (this.f5400c.mSurfacedestoryed || i2 >= 50) {
                    break;
                }
                try {
                    Thread.sleep(20L);
                } catch (InterruptedException e) {
                }
                i = i2 + 1;
            }
        }
        super.onPause();
    }

    @Override // android.opengl.GLSurfaceView
    public final void onResume() {
        super.onResume();
        dy.a(dx.f4872c, "AMapGLSurfaceView onPause");
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        try {
            return this.b.onTouchEvent(motionEvent);
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.SurfaceView, android.view.View
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        dy.a(dx.f4872c, "AMapGLSurfaceView onWindowVisibilityChanged visibility ".concat(String.valueOf(i)));
        try {
            if (i == 8 || i == 4) {
                if (this.f5400c != null) {
                    this.f5400c.renderPause();
                    this.f5399a = false;
                }
            } else if (i != 0 || this.f5400c == null) {
            } else {
                this.f5400c.renderResume();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            dw.a(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setEGLConfigChooser(dg dgVar) {
        super.setEGLConfigChooser((GLSurfaceView.EGLConfigChooser) dgVar);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setEGLContextFactory(dh dhVar) {
        super.setEGLContextFactory((GLSurfaceView.EGLContextFactory) dhVar);
    }

    @Override // android.opengl.GLSurfaceView, com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setRenderer(GLSurfaceView.Renderer renderer) {
        this.f5400c = (GLMapRender) renderer;
        super.setRenderer(renderer);
    }
}
