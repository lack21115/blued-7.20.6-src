package com.blued.community.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.blued.android.framework.utils.Logger;

/* loaded from: source-7206380-dex2jar.jar:com/blued/community/view/HorInterceptFrameLayout.class */
public class HorInterceptFrameLayout extends FrameLayout {
    private static final String TAG = "HorInterceptFrameLayout";
    private float mInitialMotionX;
    private float mInitialMotionY;
    private boolean mIsBeingDragged;
    private float mLastMotionX;
    private float mLastMotionY;
    private int mTouchSlop;
    private OnHorScrollListener onHorScrollListener;

    /* loaded from: source-7206380-dex2jar.jar:com/blued/community/view/HorInterceptFrameLayout$OnHorScrollListener.class */
    public interface OnHorScrollListener {
        void horScrolling(int i, float f);
    }

    public HorInterceptFrameLayout(Context context) {
        super(context);
        init();
    }

    public HorInterceptFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledPagingTouchSlop();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action;
        try {
            action = motionEvent.getAction() & 255;
        } catch (Exception e) {
        }
        if (action == 3 || action == 1) {
            return false;
        }
        if (action == 0) {
            float x = motionEvent.getX();
            this.mInitialMotionX = x;
            this.mLastMotionX = x;
            float y = motionEvent.getY();
            this.mInitialMotionY = y;
            this.mLastMotionY = y;
            this.mIsBeingDragged = false;
            Logger.b(TAG, new Object[]{"onInterceptTouchEvent ACTION_DOWN"});
        } else if (action == 2) {
            float abs = Math.abs(motionEvent.getX() - this.mInitialMotionX);
            float abs2 = Math.abs(motionEvent.getY() - this.mInitialMotionY);
            if (abs > this.mTouchSlop && abs * 0.5f > abs2) {
                this.mIsBeingDragged = true;
            }
            Logger.b(TAG, new Object[]{"onInterceptTouchEvent ACTION_MOVE"});
        } else if (action == 6) {
            Logger.b(TAG, new Object[]{"onInterceptTouchEvent ACTION_POINTER_UP"});
        }
        return this.mIsBeingDragged;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            if (motionEvent.getAction() != 0 || motionEvent.getEdgeFlags() == 0) {
                int action = motionEvent.getAction();
                int i = action & 255;
                if (i == 0) {
                    float x = motionEvent.getX();
                    this.mInitialMotionX = x;
                    this.mLastMotionX = x;
                    float y = motionEvent.getY();
                    this.mInitialMotionY = y;
                    this.mLastMotionY = y;
                    Logger.b(TAG, new Object[]{"ACTION_DOWN"});
                    return true;
                }
                if (i != 1) {
                    if (i == 2) {
                        float x2 = motionEvent.getX();
                        float abs = Math.abs(x2 - this.mLastMotionX);
                        float y2 = motionEvent.getY();
                        if (abs > Math.abs(y2 - this.mLastMotionY) && this.onHorScrollListener != null) {
                            this.onHorScrollListener.horScrolling(action, x2 - this.mLastMotionX);
                        }
                        this.mLastMotionX = x2;
                        this.mLastMotionY = y2;
                        return true;
                    } else if (i == 3) {
                        Logger.b(TAG, new Object[]{"ACTION_CANCEL"});
                        if (this.onHorScrollListener != null) {
                            this.onHorScrollListener.horScrolling(action, 0.0f);
                            return true;
                        }
                        return true;
                    } else if (i == 5) {
                        Logger.b(TAG, new Object[]{"ACTION_POINTER_DOWN"});
                        return true;
                    } else if (i != 6) {
                        return true;
                    }
                }
                Logger.b(TAG, new Object[]{"ACTION_UP"});
                if (this.onHorScrollListener != null) {
                    this.onHorScrollListener.horScrolling(action, 0.0f);
                    return true;
                }
                return true;
            }
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    public void setOnHorScrollListener(OnHorScrollListener onHorScrollListener) {
        this.onHorScrollListener = onHorScrollListener;
    }
}
