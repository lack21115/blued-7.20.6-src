package com.tencent.mapsdk.internal;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/x1.class */
public interface x1 {
    void a(float f);

    int getHeight();

    View getView();

    int getWidth();

    void j();

    void onDestroy();

    void onPause();

    void onResume();

    void onSizeChanged(int i, int i2, int i3, int i4);

    void onSurfaceChanged(Object obj, int i, int i2);

    boolean onTouchEvent(MotionEvent motionEvent);

    void setMapOpaque(boolean z);

    void setZOrderMediaOverlay(boolean z);

    boolean z();
}
