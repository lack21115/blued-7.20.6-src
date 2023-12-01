package com.amap.api.col.p0003sl;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.SurfaceHolder;
import android.view.ViewParent;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IGLSurfaceView;

/* renamed from: com.amap.api.col.3sl.m  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/m.class */
public final class m implements IGLSurfaceView {
    protected boolean a;
    private IAMapDelegate b;

    public m(Context context) {
        this(context, (byte) 0);
    }

    private m(Context context, byte b) {
        this.b = null;
        this.a = false;
        this.b = new l(this, context);
    }

    public final IAMapDelegate a() {
        return this.b;
    }

    public final int getHeight() {
        return 0;
    }

    public final SurfaceHolder getHolder() {
        return null;
    }

    public final ViewParent getParent() {
        return null;
    }

    public final int getRenderMode() {
        return 0;
    }

    public final int getWidth() {
        return 0;
    }

    public final boolean isEnabled() {
        return this.b != null;
    }

    public final void onDetachedGLThread() {
    }

    public final boolean post(Runnable runnable) {
        return false;
    }

    public final boolean postDelayed(Runnable runnable, long j) {
        return false;
    }

    public final void queueEvent(Runnable runnable) {
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void requestRender() {
    }

    public final void setBackgroundColor(int i) {
    }

    public final void setEGLConfigChooser(dg dgVar) {
    }

    public final void setEGLContextFactory(dh dhVar) {
    }

    public final void setRenderMode(int i) {
    }

    public final void setRenderer(GLSurfaceView.Renderer renderer) {
    }

    public final void setVisibility(int i) {
    }

    public final void setZOrderOnTop(boolean z) {
    }
}
