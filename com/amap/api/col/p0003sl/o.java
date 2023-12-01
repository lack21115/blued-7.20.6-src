package com.amap.api.col.p0003sl;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.base.ae.gmap.GLMapRender;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IGLSurfaceView;

/* renamed from: com.amap.api.col.3sl.o  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/o.class */
public final class o extends x implements IGLSurfaceView {
    protected boolean a;
    private IAMapDelegate b;
    private GLMapRender c;

    public o(Context context, boolean z) {
        super(context);
        this.b = null;
        this.c = null;
        this.a = false;
        di.a(this);
        this.b = new l(this, context, z);
    }

    public final IAMapDelegate a() {
        return this.b;
    }

    @Override // com.amap.api.col.p0003sl.x
    public final void b() {
        String str = dx.c;
        dy.a(str, "AMapGLTextureView onPause mMapRender.mSurfacedestoryed " + this.c.mSurfacedestoryed);
        if (!this.c.mSurfacedestoryed) {
            queueEvent(new Runnable() { // from class: com.amap.api.col.3sl.o.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        if (o.this.c != null) {
                            o.this.c.onSurfaceDestory();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                        dw.a(th);
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
        super.b();
    }

    @Override // com.amap.api.col.p0003sl.x
    public final void c() {
        super.c();
        dy.a(dx.c, "AMapGLTextureView onResume");
    }

    public final SurfaceHolder getHolder() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p0003sl.x, android.view.TextureView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        dy.a(dx.c, "AMapGLTextureView onAttachedToWindow");
        try {
            if (this.c != null) {
                this.c.onAttachedToWindow();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p0003sl.x, android.view.View
    public final void onDetachedFromWindow() {
        String str = dx.c;
        dy.a(str, "AMapGLTextureView onDetachedFromWindow MapsInitializer.isSupportRecycleView() " + MapsInitializer.isSupportRecycleView());
        if (MapsInitializer.isSupportRecycleView()) {
            return;
        }
        b();
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
        dy.a(str, "AMapGLTextureView onDetachedGLThread MapsInitializer.isSupportRecycleView() " + MapsInitializer.isSupportRecycleView());
        if (MapsInitializer.isSupportRecycleView()) {
            b();
            try {
                if (this.c != null) {
                    this.c.onDetachedFromWindow();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            super.onDetachedFromWindow();
        }
    }

    @Override // com.amap.api.col.p0003sl.x, android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        dy.a(dx.c, "AMapGLTextureView onSurfaceTextureDestroyed");
        requestRender();
        try {
            if (MapsInitializer.getTextureDestroyRender()) {
                Thread.sleep(100L);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            dw.a(th);
        }
        return super.onSurfaceTextureDestroyed(surfaceTexture);
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
    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        dy.a(dx.c, "AMapGLTextureView onWindowVisibilityChanged visibility ".concat(String.valueOf(i)));
        try {
            if (i == 8 || i == 4) {
                if (this.c != null) {
                    this.c.renderPause();
                    this.a = false;
                }
                requestRender();
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
        super.a(dgVar);
    }

    public final void setEGLContextFactory(dh dhVar) {
        super.a(dhVar);
    }

    @Override // com.amap.api.col.p0003sl.x
    public final void setRenderer(GLSurfaceView.Renderer renderer) {
        this.c = (GLMapRender) renderer;
        super.setRenderer(renderer);
    }

    public final void setZOrderOnTop(boolean z) {
    }
}
