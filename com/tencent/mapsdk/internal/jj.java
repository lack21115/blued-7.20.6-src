package com.tencent.mapsdk.internal;

import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/jj.class */
public class jj extends TextureView implements TextureView.SurfaceTextureListener, x1 {
    private yi g;
    private xi h;
    private SurfaceTexture i;
    private boolean j;
    private boolean k;

    public jj(e1 e1Var) {
        super(e1Var.getContext());
        this.j = false;
        this.k = false;
        this.g = (yi) e1Var.j();
        setSurfaceTextureListener(this);
        setOpaque(e1Var.isOpaque());
        xi xiVar = new xi(this.g);
        this.h = xiVar;
        xiVar.a(e1Var.k());
        this.h.start();
    }

    @Override // com.tencent.mapsdk.internal.x1
    public void a(float f) {
        xi xiVar = this.h;
        if (xiVar != null) {
            xiVar.a(f);
        }
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        yi yiVar = this.g;
        if (yiVar == null || !yiVar.a(motionEvent)) {
            return super.dispatchHoverEvent(motionEvent);
        }
        return true;
    }

    @Override // com.tencent.mapsdk.internal.x1
    public View getView() {
        return this;
    }

    @Override // com.tencent.mapsdk.internal.x1
    public void j() {
        xi xiVar = this.h;
        if (xiVar != null) {
            synchronized (xiVar) {
                this.h.notify();
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.x1
    public void onDestroy() {
        xi xiVar = this.h;
        if (xiVar != null) {
            xiVar.e();
        }
        SurfaceTexture surfaceTexture = this.i;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.i = null;
        }
    }

    @Override // com.tencent.mapsdk.internal.x1
    public void onPause() {
        this.k = true;
        xi xiVar = this.h;
        if (xiVar != null) {
            xiVar.f();
        }
    }

    @Override // com.tencent.mapsdk.internal.x1
    public void onResume() {
        this.k = false;
        if (this.i != null && this.j && getSurfaceTexture() != this.i && isAvailable()) {
            setSurfaceTexture(this.i);
            this.j = false;
        }
        xi xiVar = this.h;
        if (xiVar != null) {
            xiVar.g();
        }
    }

    @Override // android.view.TextureView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        yi yiVar = this.g;
        if (yiVar != null) {
            yiVar.d(i, i2);
        }
    }

    @Override // com.tencent.mapsdk.internal.x1
    public void onSurfaceChanged(Object obj, int i, int i2) {
        this.h.a(obj);
        yi yiVar = this.g;
        if (yiVar != null) {
            yiVar.a((GL10) null, (EGLConfig) null);
            this.g.a((GL10) null, i, i2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.i = surfaceTexture;
        onSurfaceChanged(surfaceTexture, i, i2);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        boolean z = true;
        this.j = true;
        if (this.k) {
            z = false;
        }
        return z;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        yi yiVar = this.g;
        if (yiVar != null) {
            yiVar.a((GL10) null, i, i2);
            xi xiVar = this.h;
            if (xiVar != null) {
                xiVar.h();
            }
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.tencent.mapsdk.internal.x1
    public void setMapOpaque(boolean z) {
        if (this.g != null) {
            setOpaque(z);
        }
    }

    @Override // com.tencent.mapsdk.internal.x1
    public void setZOrderMediaOverlay(boolean z) {
    }

    @Override // com.tencent.mapsdk.internal.x1
    public boolean z() {
        return isOpaque();
    }
}
