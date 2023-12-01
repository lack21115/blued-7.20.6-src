package com.autonavi.base.amap.api.mapcore;

import android.opengl.GLSurfaceView;
import android.view.SurfaceHolder;
import android.view.ViewParent;
import com.amap.api.col.3sl.dg;
import com.amap.api.col.3sl.dh;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/base/amap/api/mapcore/IGLSurfaceView.class */
public interface IGLSurfaceView {
    int getHeight();

    SurfaceHolder getHolder();

    ViewParent getParent();

    int getRenderMode();

    int getWidth();

    boolean isEnabled();

    void onDetachedGLThread();

    boolean post(Runnable runnable);

    boolean postDelayed(Runnable runnable, long j);

    void queueEvent(Runnable runnable);

    void requestRender();

    void setBackgroundColor(int i);

    void setEGLConfigChooser(dg dgVar);

    void setEGLContextFactory(dh dhVar);

    void setRenderMode(int i);

    void setRenderer(GLSurfaceView.Renderer renderer);

    void setVisibility(int i);

    void setZOrderOnTop(boolean z);
}
