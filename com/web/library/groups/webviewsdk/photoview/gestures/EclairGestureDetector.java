package com.web.library.groups.webviewsdk.photoview.gestures;

import android.content.Context;
import android.view.MotionEvent;
import com.web.library.groups.webviewsdk.photoview.Compat;

/* loaded from: source-8829756-dex2jar.jar:com/web/library/groups/webviewsdk/photoview/gestures/EclairGestureDetector.class */
public class EclairGestureDetector extends CupcakeGestureDetector {
    private static final int INVALID_POINTER_ID = -1;
    private int mActivePointerId;
    private int mActivePointerIndex;

    public EclairGestureDetector(Context context) {
        super(context);
        this.mActivePointerId = -1;
        this.mActivePointerIndex = 0;
    }

    @Override // com.web.library.groups.webviewsdk.photoview.gestures.CupcakeGestureDetector
    float getActiveX(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.mActivePointerIndex);
        } catch (Exception e) {
            return motionEvent.getX();
        }
    }

    @Override // com.web.library.groups.webviewsdk.photoview.gestures.CupcakeGestureDetector
    float getActiveY(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.mActivePointerIndex);
        } catch (Exception e) {
            return motionEvent.getY();
        }
    }

    @Override // com.web.library.groups.webviewsdk.photoview.gestures.CupcakeGestureDetector, com.web.library.groups.webviewsdk.photoview.gestures.GestureDetector
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            int i = 1;
            if (action == 1 || action == 3) {
                this.mActivePointerId = -1;
            } else if (action == 6) {
                int pointerIndex = Compat.getPointerIndex(motionEvent.getAction());
                if (motionEvent.getPointerId(pointerIndex) == this.mActivePointerId) {
                    if (pointerIndex != 0) {
                        i = 0;
                    }
                    this.mActivePointerId = motionEvent.getPointerId(i);
                    this.mLastTouchX = motionEvent.getX(i);
                    this.mLastTouchY = motionEvent.getY(i);
                }
            }
        } else {
            this.mActivePointerId = motionEvent.getPointerId(0);
        }
        int i2 = this.mActivePointerId;
        int i3 = 0;
        if (i2 != -1) {
            i3 = i2;
        }
        this.mActivePointerIndex = motionEvent.findPointerIndex(i3);
        return super.onTouchEvent(motionEvent);
    }
}
