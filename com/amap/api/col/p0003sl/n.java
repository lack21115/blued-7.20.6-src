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
    protected boolean a;
    private IAMapDelegate b;
    private GLMapRender c;

    public n(Context context, boolean z) {
        this(context, z, (byte) 0);
    }

    private n(Context context, boolean z, byte b) {
        super(context, null);
        this.b = null;
        this.c = null;
        this.a = false;
        di.a(this);
        this.b = new l(this, context, z);
    }

    public final IAMapDelegate a() {
        return this.b;
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        dy.a(dx.c, "AMapGLSurfaceView onAttachedToWindow");
        try {
            if (this.c != null) {
                this.c.onAttachedToWindow();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            dw.a(th);
        }
        onResume();
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    protected final void onDetachedFromWindow() {
        String str = dx.c;
        dy.a(str, "AMapGLSurfaceView onDetachedFromWindow MapsInitializer.isSupportRecycleView() " + MapsInitializer.isSupportRecycleView());
        if (MapsInitializer.isSupportRecycleView()) {
            return;
        }
        onPause();
        try {
            if (this.c != null) {
                this.c.onDetachedFromWindow();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.onDetachedFromWindow();
    }

    public final void onDetachedGLThread() {
        String str = dx.c;
        dy.a(str, "AMapGLSurfaceView onDetachedGLThread MapsInitializer.isSupportRecycleView() " + MapsInitializer.isSupportRecycleView());
        if (MapsInitializer.isSupportRecycleView()) {
            onPause();
            try {
                if (this.c != null) {
                    this.c.onDetachedFromWindow();
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
        String str = dx.c;
        dy.a(str, "AMapGLSurfaceView onPause mMapRender.mSurfacedestoryed " + this.c.mSurfacedestoryed);
        if (!this.c.mSurfacedestoryed) {
            queueEvent(new Runnable() { // from class: com.amap.api.col.3sl.n.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (n.this.c != null) {
                        try {
                            n.this.c.onSurfaceDestory();
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
                if (this.c.mSurfacedestoryed || i2 >= 50) {
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
        dy.a(dx.c, "AMapGLSurfaceView onPause");
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

    @Override // android.view.SurfaceView, android.view.View
    protected final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        dy.a(dx.c, "AMapGLSurfaceView onWindowVisibilityChanged visibility ".concat(String.valueOf(i)));
        try {
            if (i == 8 || i == 4) {
                if (this.c != null) {
                    this.c.renderPause();
                    this.a = false;
                }
            } else if (i != 0 || this.c == null) {
            } else {
                this.c.renderResume();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            dw.a(th);
        }
    }

    public final void setEGLConfigChooser(dg dgVar) {
        super.setEGLConfigChooser((GLSurfaceView.EGLConfigChooser) dgVar);
    }

    public final void setEGLContextFactory(dh dhVar) {
        super.setEGLContextFactory((GLSurfaceView.EGLContextFactory) dhVar);
    }

    @Override // android.opengl.GLSurfaceView
    public final void setRenderer(GLSurfaceView.Renderer renderer) {
        this.c = (GLMapRender) renderer;
        super.setRenderer(renderer);
    }
}
