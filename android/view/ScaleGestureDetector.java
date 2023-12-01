package android.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.SystemClock;
import android.util.FloatMath;
import android.view.GestureDetector;
import com.android.internal.R;

/* loaded from: source-9557208-dex2jar.jar:android/view/ScaleGestureDetector.class */
public class ScaleGestureDetector {
    private static final int DOUBLE_TAP_MODE_IN_PROGRESS = 1;
    private static final int DOUBLE_TAP_MODE_NONE = 0;
    private static final float SCALE_FACTOR = 0.5f;
    private static final String TAG = "ScaleGestureDetector";
    private static final long TOUCH_STABILIZE_TIME = 128;
    private final Context mContext;
    private float mCurrSpan;
    private float mCurrSpanX;
    private float mCurrSpanY;
    private long mCurrTime;
    private MotionEvent mDoubleTapEvent;
    private int mDoubleTapMode;
    private boolean mEventBeforeOrAboveStartingGestureEvent;
    private float mFocusX;
    private float mFocusY;
    private GestureDetector mGestureDetector;
    private final Handler mHandler;
    private boolean mInProgress;
    private float mInitialSpan;
    private final InputEventConsistencyVerifier mInputEventConsistencyVerifier;
    private final OnScaleGestureListener mListener;
    private int mMinSpan;
    private float mPrevSpan;
    private float mPrevSpanX;
    private float mPrevSpanY;
    private long mPrevTime;
    private boolean mQuickScaleEnabled;
    private int mSpanSlop;
    private int mTouchHistoryDirection;
    private float mTouchHistoryLastAccepted;
    private long mTouchHistoryLastAcceptedTime;
    private float mTouchLower;
    private int mTouchMinMajor;
    private float mTouchUpper;

    /* loaded from: source-9557208-dex2jar.jar:android/view/ScaleGestureDetector$OnScaleGestureListener.class */
    public interface OnScaleGestureListener {
        boolean onScale(ScaleGestureDetector scaleGestureDetector);

        boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector);

        void onScaleEnd(ScaleGestureDetector scaleGestureDetector);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/view/ScaleGestureDetector$SimpleOnScaleGestureListener.class */
    public static class SimpleOnScaleGestureListener implements OnScaleGestureListener {
        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            return false;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        }
    }

    public ScaleGestureDetector(Context context, OnScaleGestureListener onScaleGestureListener) {
        this(context, onScaleGestureListener, null);
    }

    public ScaleGestureDetector(Context context, OnScaleGestureListener onScaleGestureListener, Handler handler) {
        this.mDoubleTapMode = 0;
        this.mInputEventConsistencyVerifier = InputEventConsistencyVerifier.isInstrumentationEnabled() ? new InputEventConsistencyVerifier(this, 0) : null;
        this.mContext = context;
        this.mListener = onScaleGestureListener;
        this.mSpanSlop = ViewConfiguration.get(context).getScaledTouchSlop() * 2;
        Resources resources = context.getResources();
        this.mTouchMinMajor = resources.getDimensionPixelSize(R.dimen.config_minScalingTouchMajor);
        this.mMinSpan = resources.getDimensionPixelSize(R.dimen.config_minScalingSpan);
        this.mHandler = handler;
        if (context.getApplicationInfo().targetSdkVersion > 18) {
            setQuickScaleEnabled(true);
        }
    }

    private void addTouchHistory(MotionEvent motionEvent) {
        long uptimeMillis = SystemClock.uptimeMillis();
        int pointerCount = motionEvent.getPointerCount();
        float f = 0.0f;
        int i = 0;
        boolean z = uptimeMillis - this.mTouchHistoryLastAcceptedTime >= 128;
        for (int i2 = 0; i2 < pointerCount; i2++) {
            boolean z2 = !Float.isNaN(this.mTouchHistoryLastAccepted);
            int historySize = motionEvent.getHistorySize();
            int i3 = historySize + 1;
            int i4 = 0;
            while (i4 < i3) {
                float historicalTouchMajor = i4 < historySize ? motionEvent.getHistoricalTouchMajor(i2, i4) : motionEvent.getTouchMajor(i2);
                float f2 = historicalTouchMajor;
                if (historicalTouchMajor < this.mTouchMinMajor) {
                    f2 = this.mTouchMinMajor;
                }
                f += f2;
                if (Float.isNaN(this.mTouchUpper) || f2 > this.mTouchUpper) {
                    this.mTouchUpper = f2;
                }
                if (Float.isNaN(this.mTouchLower) || f2 < this.mTouchLower) {
                    this.mTouchLower = f2;
                }
                boolean z3 = z;
                if (z2) {
                    int signum = (int) Math.signum(f2 - this.mTouchHistoryLastAccepted);
                    if (signum == this.mTouchHistoryDirection) {
                        z3 = z;
                        if (signum == 0) {
                            z3 = z;
                            if (this.mTouchHistoryDirection != 0) {
                            }
                        }
                    }
                    this.mTouchHistoryDirection = signum;
                    this.mTouchHistoryLastAcceptedTime = i4 < historySize ? motionEvent.getHistoricalEventTime(i4) : motionEvent.getEventTime();
                    z3 = false;
                }
                i4++;
                z = z3;
            }
            i += i3;
        }
        float f3 = f / i;
        if (z) {
            float f4 = ((this.mTouchUpper + this.mTouchLower) + f3) / 3.0f;
            this.mTouchUpper = (this.mTouchUpper + f4) / 2.0f;
            this.mTouchLower = (this.mTouchLower + f4) / 2.0f;
            this.mTouchHistoryLastAccepted = f4;
            this.mTouchHistoryDirection = 0;
            this.mTouchHistoryLastAcceptedTime = motionEvent.getEventTime();
        }
    }

    private void clearTouchHistory() {
        this.mTouchUpper = Float.NaN;
        this.mTouchLower = Float.NaN;
        this.mTouchHistoryLastAccepted = Float.NaN;
        this.mTouchHistoryDirection = 0;
        this.mTouchHistoryLastAcceptedTime = 0L;
    }

    private boolean inDoubleTapMode() {
        return this.mDoubleTapMode == 1;
    }

    public float getCurrentSpan() {
        return this.mCurrSpan;
    }

    public float getCurrentSpanX() {
        return this.mCurrSpanX;
    }

    public float getCurrentSpanY() {
        return this.mCurrSpanY;
    }

    public long getEventTime() {
        return this.mCurrTime;
    }

    public float getFocusX() {
        return this.mFocusX;
    }

    public float getFocusY() {
        return this.mFocusY;
    }

    public float getPreviousSpan() {
        return this.mPrevSpan;
    }

    public float getPreviousSpanX() {
        return this.mPrevSpanX;
    }

    public float getPreviousSpanY() {
        return this.mPrevSpanY;
    }

    public float getScaleFactor() {
        if (!inDoubleTapMode()) {
            if (this.mPrevSpan > 0.0f) {
                return this.mCurrSpan / this.mPrevSpan;
            }
            return 1.0f;
        }
        boolean z = (this.mEventBeforeOrAboveStartingGestureEvent && this.mCurrSpan < this.mPrevSpan) || (!this.mEventBeforeOrAboveStartingGestureEvent && this.mCurrSpan > this.mPrevSpan);
        float abs = Math.abs(1.0f - (this.mCurrSpan / this.mPrevSpan)) * 0.5f;
        if (this.mPrevSpan <= 0.0f) {
            return 1.0f;
        }
        return z ? 1.0f + abs : 1.0f - abs;
    }

    public long getTimeDelta() {
        return this.mCurrTime - this.mPrevTime;
    }

    public boolean isInProgress() {
        return this.mInProgress;
    }

    public boolean isQuickScaleEnabled() {
        return this.mQuickScaleEnabled;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f;
        float f2;
        if (this.mInputEventConsistencyVerifier != null) {
            this.mInputEventConsistencyVerifier.onTouchEvent(motionEvent, 0);
        }
        this.mCurrTime = motionEvent.getEventTime();
        int actionMasked = motionEvent.getActionMasked();
        if (this.mQuickScaleEnabled) {
            this.mGestureDetector.onTouchEvent(motionEvent);
        }
        boolean z = actionMasked == 1 || actionMasked == 3;
        if (actionMasked == 0 || z) {
            if (this.mInProgress) {
                this.mListener.onScaleEnd(this);
                this.mInProgress = false;
                this.mInitialSpan = 0.0f;
                this.mDoubleTapMode = 0;
            } else if (this.mDoubleTapMode == 1 && z) {
                this.mInProgress = false;
                this.mInitialSpan = 0.0f;
                this.mDoubleTapMode = 0;
            }
            if (z) {
                clearTouchHistory();
                return true;
            }
        }
        boolean z2 = actionMasked == 0 || actionMasked == 6 || actionMasked == 5;
        boolean z3 = actionMasked == 6;
        int actionIndex = z3 ? motionEvent.getActionIndex() : -1;
        float f3 = 0.0f;
        float f4 = 0.0f;
        int pointerCount = motionEvent.getPointerCount();
        int i = z3 ? pointerCount - 1 : pointerCount;
        if (this.mDoubleTapMode == 1) {
            f = this.mDoubleTapEvent.getX();
            f2 = this.mDoubleTapEvent.getY();
            if (motionEvent.getY() < f2) {
                this.mEventBeforeOrAboveStartingGestureEvent = true;
            } else {
                this.mEventBeforeOrAboveStartingGestureEvent = false;
            }
        } else {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= pointerCount) {
                    break;
                }
                if (actionIndex != i3) {
                    f3 += motionEvent.getX(i3);
                    f4 += motionEvent.getY(i3);
                }
                i2 = i3 + 1;
            }
            f = f3 / i;
            f2 = f4 / i;
        }
        addTouchHistory(motionEvent);
        float f5 = 0.0f;
        float f6 = 0.0f;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= pointerCount) {
                break;
            }
            if (actionIndex != i5) {
                float f7 = this.mTouchHistoryLastAccepted / 2.0f;
                f5 += Math.abs(motionEvent.getX(i5) - f) + f7;
                f6 += Math.abs(motionEvent.getY(i5) - f2) + f7;
            }
            i4 = i5 + 1;
        }
        float f8 = (f5 / i) * 2.0f;
        float f9 = (f6 / i) * 2.0f;
        float sqrt = inDoubleTapMode() ? f9 : FloatMath.sqrt((f8 * f8) + (f9 * f9));
        boolean z4 = this.mInProgress;
        this.mFocusX = f;
        this.mFocusY = f2;
        if (!inDoubleTapMode() && this.mInProgress && (sqrt < this.mMinSpan || z2)) {
            this.mListener.onScaleEnd(this);
            this.mInProgress = false;
            this.mInitialSpan = sqrt;
            this.mDoubleTapMode = 0;
        }
        if (z2) {
            this.mCurrSpanX = f8;
            this.mPrevSpanX = f8;
            this.mCurrSpanY = f9;
            this.mPrevSpanY = f9;
            this.mCurrSpan = sqrt;
            this.mPrevSpan = sqrt;
            this.mInitialSpan = sqrt;
        }
        int i6 = inDoubleTapMode() ? this.mSpanSlop : this.mMinSpan;
        if (!this.mInProgress && sqrt >= i6 && (z4 || Math.abs(sqrt - this.mInitialSpan) > this.mSpanSlop)) {
            this.mCurrSpanX = f8;
            this.mPrevSpanX = f8;
            this.mCurrSpanY = f9;
            this.mPrevSpanY = f9;
            this.mCurrSpan = sqrt;
            this.mPrevSpan = sqrt;
            this.mPrevTime = this.mCurrTime;
            this.mInProgress = this.mListener.onScaleBegin(this);
        }
        if (actionMasked == 2) {
            this.mCurrSpanX = f8;
            this.mCurrSpanY = f9;
            this.mCurrSpan = sqrt;
            boolean z5 = true;
            if (this.mInProgress) {
                z5 = this.mListener.onScale(this);
            }
            if (z5) {
                this.mPrevSpanX = this.mCurrSpanX;
                this.mPrevSpanY = this.mCurrSpanY;
                this.mPrevSpan = this.mCurrSpan;
                this.mPrevTime = this.mCurrTime;
                return true;
            }
            return true;
        }
        return true;
    }

    public void setQuickScaleEnabled(boolean z) {
        this.mQuickScaleEnabled = z;
        if (this.mQuickScaleEnabled && this.mGestureDetector == null) {
            this.mGestureDetector = new GestureDetector(this.mContext, new GestureDetector.SimpleOnGestureListener() { // from class: android.view.ScaleGestureDetector.1
                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
                public boolean onDoubleTap(MotionEvent motionEvent) {
                    ScaleGestureDetector.this.mDoubleTapEvent = motionEvent;
                    ScaleGestureDetector.this.mDoubleTapMode = 1;
                    return true;
                }
            }, this.mHandler);
        }
    }
}
