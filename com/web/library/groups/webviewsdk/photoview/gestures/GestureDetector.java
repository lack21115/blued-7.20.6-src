package com.web.library.groups.webviewsdk.photoview.gestures;

import android.view.MotionEvent;

/* loaded from: source-8829756-dex2jar.jar:com/web/library/groups/webviewsdk/photoview/gestures/GestureDetector.class */
public interface GestureDetector {
    boolean isScaling();

    boolean onTouchEvent(MotionEvent motionEvent);

    void setOnGestureListener(OnGestureListener onGestureListener);
}
