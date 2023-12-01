package com.android.internal.widget;

import android.content.Context;
import android.gesture.Gesture;
import android.gesture.GestureOverlayView;
import android.util.AttributeSet;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/LockGestureView.class */
public class LockGestureView extends GestureOverlayView implements GestureOverlayView.OnGesturingListener, GestureOverlayView.OnGesturePerformedListener {
    private static final int CORRECT_COLOR = -3355444;
    private static final int WRONG_COLOR = -65536;
    private DisplayMode mGestureDisplayMode;
    private boolean mInStealthMode;
    private OnLockGestureListener mOnGestureListener;

    /* renamed from: com.android.internal.widget.LockGestureView$1  reason: invalid class name */
    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/LockGestureView$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$android$internal$widget$LockGestureView$DisplayMode = new int[DisplayMode.values().length];

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x0022 -> B:11:0x0014). Please submit an issue!!! */
        static {
            try {
                $SwitchMap$com$android$internal$widget$LockGestureView$DisplayMode[DisplayMode.Correct.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$android$internal$widget$LockGestureView$DisplayMode[DisplayMode.Wrong.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/LockGestureView$DisplayMode.class */
    public enum DisplayMode {
        Correct,
        Wrong
    }

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/LockGestureView$OnLockGestureListener.class */
    public interface OnLockGestureListener {
        void onGestureCleared();

        void onGestureDetected(Gesture gesture);

        void onGestureStart();
    }

    public LockGestureView(Context context) {
        this(context, null);
    }

    public LockGestureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mGestureDisplayMode = DisplayMode.Correct;
        this.mInStealthMode = false;
        setGestureVisible(true);
        addOnGesturingListener(this);
        addOnGesturePerformedListener(this);
        setGestureColor(CORRECT_COLOR);
        this.mClearPerformedGesture = false;
    }

    private void notifyGestureCleared() {
        if (this.mOnGestureListener != null) {
            this.mOnGestureListener.onGestureCleared();
        }
    }

    private void notifyGestureDetected(Gesture gesture) {
        if (this.mOnGestureListener != null) {
            this.mOnGestureListener.onGestureDetected(gesture);
        }
    }

    private void notifyGestureStart() {
        if (this.mOnGestureListener != null) {
            this.mOnGestureListener.onGestureStart();
        }
    }

    private void resetGesture() {
        this.mGestureDisplayMode = DisplayMode.Correct;
        clear(false);
        invalidate();
    }

    public void clearGesture() {
        resetGesture();
    }

    public void disableInput() {
        this.mInputEnabled = false;
    }

    public void enableInput() {
        this.mInputEnabled = true;
    }

    public boolean isInStealthMode() {
        return this.mInStealthMode;
    }

    @Override // android.gesture.GestureOverlayView.OnGesturePerformedListener
    public void onGesturePerformed(GestureOverlayView gestureOverlayView, Gesture gesture) {
        notifyGestureDetected(gesture);
    }

    @Override // android.gesture.GestureOverlayView.OnGesturingListener
    public void onGesturingEnded(GestureOverlayView gestureOverlayView) {
    }

    @Override // android.gesture.GestureOverlayView.OnGesturingListener
    public void onGesturingStarted(GestureOverlayView gestureOverlayView) {
        notifyGestureStart();
    }

    public void setDisplayMode(DisplayMode displayMode) {
        this.mGestureDisplayMode = displayMode;
        switch (AnonymousClass1.$SwitchMap$com$android$internal$widget$LockGestureView$DisplayMode[displayMode.ordinal()]) {
            case 1:
                setGestureColor(CORRECT_COLOR);
                break;
            case 2:
                setGestureColor(WRONG_COLOR);
                break;
        }
        invalidate();
    }

    public void setInStealthMode(boolean z) {
        this.mInStealthMode = z;
        setGestureVisible(!z);
    }

    public void setOnGestureListener(OnLockGestureListener onLockGestureListener) {
        this.mOnGestureListener = onLockGestureListener;
    }
}
