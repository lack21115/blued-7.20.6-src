package com.android.internal.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.hardware.input.InputManager;
import android.os.SystemProperties;
import android.util.Log;
import android.view.InputDevice;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManagerPolicy;
import java.util.ArrayList;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/PointerLocationView.class */
public class PointerLocationView extends View implements InputManager.InputDeviceListener, WindowManagerPolicy.PointerEventListener {
    private static final String ALT_STRATEGY_PROPERY_KEY = "debug.velocitytracker.alt";
    private static final String TAG = "Pointer";
    private final int ESTIMATE_FUTURE_POINTS;
    private final float ESTIMATE_INTERVAL;
    private final int ESTIMATE_PAST_POINTS;
    private int mActivePointerId;
    private final VelocityTracker mAltVelocity;
    private boolean mCurDown;
    private int mCurNumPointers;
    private final Paint mCurrentPointPaint;
    private int mHeaderBottom;
    private final InputManager mIm;
    private int mMaxNumPointers;
    private final Paint mPaint;
    private final Paint mPathPaint;
    private final ArrayList<PointerState> mPointers;
    private boolean mPrintCoords;
    private RectF mReusableOvalRect;
    private final Paint mTargetPaint;
    private final MotionEvent.PointerCoords mTempCoords;
    private final FasterStringBuilder mText;
    private final Paint mTextBackgroundPaint;
    private final Paint mTextLevelPaint;
    private final Paint.FontMetricsInt mTextMetrics;
    private final Paint mTextPaint;
    private final ViewConfiguration mVC;
    private final VelocityTracker mVelocity;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/PointerLocationView$FasterStringBuilder.class */
    public static final class FasterStringBuilder {
        private char[] mChars = new char[64];
        private int mLength;

        private int reserve(int i) {
            int i2 = this.mLength;
            int i3 = this.mLength;
            char[] cArr = this.mChars;
            int length = cArr.length;
            if (i3 + i > length) {
                char[] cArr2 = new char[length * 2];
                System.arraycopy(cArr, 0, cArr2, 0, i2);
                this.mChars = cArr2;
            }
            return i2;
        }

        public FasterStringBuilder append(float f, int i) {
            int i2 = 1;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= i) {
                    break;
                }
                i2 *= 10;
                i3 = i4 + 1;
            }
            float rint = (float) (Math.rint(i2 * f) / i2);
            append((int) rint);
            if (i != 0) {
                append(".");
                float abs = Math.abs(rint);
                append((int) (i2 * ((float) (abs - Math.floor(abs)))), i);
            }
            return this;
        }

        public FasterStringBuilder append(int i) {
            return append(i, 0);
        }

        public FasterStringBuilder append(int i, int i2) {
            int i3;
            int i4;
            int i5;
            int i6;
            int i7;
            boolean z = i < 0;
            int i8 = i;
            if (z) {
                int i9 = -i;
                i8 = i9;
                if (i9 < 0) {
                    append("-2147483648");
                    return this;
                }
            }
            int reserve = reserve(11);
            char[] cArr = this.mChars;
            if (i8 == 0) {
                cArr[reserve] = '0';
                this.mLength++;
                return this;
            }
            int i10 = reserve;
            if (z) {
                cArr[reserve] = '-';
                i10 = reserve + 1;
            }
            int i11 = 10;
            int i12 = i10;
            int i13 = 1000000000;
            while (true) {
                i3 = i13;
                i4 = i12;
                i5 = i8;
                if (i8 >= i13) {
                    break;
                }
                int i14 = i13 / 10;
                int i15 = i11 - 1;
                i13 = i14;
                i11 = i15;
                if (i15 < i2) {
                    cArr[i12] = '0';
                    i12++;
                    i13 = i14;
                    i11 = i15;
                }
            }
            do {
                int i16 = i5 / i3;
                i5 -= i16 * i3;
                i6 = i3 / 10;
                i7 = i4 + 1;
                cArr[i4] = (char) (i16 + 48);
                i3 = i6;
                i4 = i7;
            } while (i6 != 0);
            this.mLength = i7;
            return this;
        }

        public FasterStringBuilder append(String str) {
            int length = str.length();
            str.getChars(0, length, this.mChars, reserve(length));
            this.mLength += length;
            return this;
        }

        public FasterStringBuilder clear() {
            this.mLength = 0;
            return this;
        }

        public String toString() {
            return new String(this.mChars, 0, this.mLength);
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/PointerLocationView$PointerState.class */
    public static class PointerState {
        private float mAltXVelocity;
        private float mAltYVelocity;
        private float mBoundingBottom;
        private float mBoundingLeft;
        private float mBoundingRight;
        private float mBoundingTop;
        private boolean mCurDown;
        private boolean mHasBoundingBox;
        private int mToolType;
        private int mTraceCount;
        private float mXVelocity;
        private float mYVelocity;
        private float[] mTraceX = new float[32];
        private float[] mTraceY = new float[32];
        private boolean[] mTraceCurrent = new boolean[32];
        private MotionEvent.PointerCoords mCoords = new MotionEvent.PointerCoords();
        private VelocityTracker.Estimator mEstimator = new VelocityTracker.Estimator();
        private VelocityTracker.Estimator mAltEstimator = new VelocityTracker.Estimator();

        public void addTrace(float f, float f2, boolean z) {
            int length = this.mTraceX.length;
            if (this.mTraceCount == length) {
                int i = length * 2;
                float[] fArr = new float[i];
                System.arraycopy(this.mTraceX, 0, fArr, 0, this.mTraceCount);
                this.mTraceX = fArr;
                float[] fArr2 = new float[i];
                System.arraycopy(this.mTraceY, 0, fArr2, 0, this.mTraceCount);
                this.mTraceY = fArr2;
                boolean[] zArr = new boolean[i];
                System.arraycopy(this.mTraceCurrent, 0, zArr, 0, this.mTraceCount);
                this.mTraceCurrent = zArr;
            }
            this.mTraceX[this.mTraceCount] = f;
            this.mTraceY[this.mTraceCount] = f2;
            this.mTraceCurrent[this.mTraceCount] = z;
            this.mTraceCount++;
        }

        public void clearTrace() {
            this.mTraceCount = 0;
        }
    }

    public PointerLocationView(Context context) {
        super(context);
        this.ESTIMATE_PAST_POINTS = 4;
        this.ESTIMATE_FUTURE_POINTS = 2;
        this.ESTIMATE_INTERVAL = 0.02f;
        this.mTextMetrics = new Paint.FontMetricsInt();
        this.mPointers = new ArrayList<>();
        this.mTempCoords = new MotionEvent.PointerCoords();
        this.mText = new FasterStringBuilder();
        this.mPrintCoords = true;
        this.mReusableOvalRect = new RectF();
        setFocusableInTouchMode(true);
        this.mIm = (InputManager) context.getSystemService("input");
        this.mVC = ViewConfiguration.get(context);
        this.mTextPaint = new Paint();
        this.mTextPaint.setAntiAlias(true);
        this.mTextPaint.setTextSize(10.0f * getResources().getDisplayMetrics().density);
        this.mTextPaint.setARGB(255, 0, 0, 0);
        this.mTextBackgroundPaint = new Paint();
        this.mTextBackgroundPaint.setAntiAlias(false);
        this.mTextBackgroundPaint.setARGB(128, 255, 255, 255);
        this.mTextLevelPaint = new Paint();
        this.mTextLevelPaint.setAntiAlias(false);
        this.mTextLevelPaint.setARGB(192, 255, 0, 0);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setARGB(255, 255, 255, 255);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(2.0f);
        this.mCurrentPointPaint = new Paint();
        this.mCurrentPointPaint.setAntiAlias(true);
        this.mCurrentPointPaint.setARGB(255, 255, 0, 0);
        this.mCurrentPointPaint.setStyle(Paint.Style.STROKE);
        this.mCurrentPointPaint.setStrokeWidth(2.0f);
        this.mTargetPaint = new Paint();
        this.mTargetPaint.setAntiAlias(false);
        this.mTargetPaint.setARGB(255, 0, 0, 192);
        this.mPathPaint = new Paint();
        this.mPathPaint.setAntiAlias(false);
        this.mPathPaint.setARGB(255, 0, 96, 255);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(1.0f);
        this.mPointers.add(new PointerState());
        this.mActivePointerId = 0;
        this.mVelocity = VelocityTracker.obtain();
        String str = SystemProperties.get(ALT_STRATEGY_PROPERY_KEY);
        if (str.length() == 0) {
            this.mAltVelocity = null;
            return;
        }
        Log.d(TAG, "Comparing default velocity tracker strategy with " + str);
        this.mAltVelocity = VelocityTracker.obtain(str);
    }

    private void drawOval(Canvas canvas, float f, float f2, float f3, float f4, float f5, Paint paint) {
        canvas.save(1);
        canvas.rotate((float) ((180.0f * f5) / 3.141592653589793d), f, f2);
        this.mReusableOvalRect.left = f - (f4 / 2.0f);
        this.mReusableOvalRect.right = (f4 / 2.0f) + f;
        this.mReusableOvalRect.top = f2 - (f3 / 2.0f);
        this.mReusableOvalRect.bottom = (f3 / 2.0f) + f2;
        canvas.drawOval(this.mReusableOvalRect, paint);
        canvas.restore();
    }

    private void logCoords(String str, int i, int i2, MotionEvent.PointerCoords pointerCoords, int i3, MotionEvent motionEvent) {
        String str2;
        int toolType = motionEvent.getToolType(i2);
        int buttonState = motionEvent.getButtonState();
        switch (i & 255) {
            case 0:
                str2 = "DOWN";
                break;
            case 1:
                str2 = "UP";
                break;
            case 2:
                str2 = "MOVE";
                break;
            case 3:
                str2 = "CANCEL";
                break;
            case 4:
                str2 = "OUTSIDE";
                break;
            case 5:
                if (i2 != ((65280 & i) >> 8)) {
                    str2 = "MOVE";
                    break;
                } else {
                    str2 = "DOWN";
                    break;
                }
            case 6:
                if (i2 != ((65280 & i) >> 8)) {
                    str2 = "MOVE";
                    break;
                } else {
                    str2 = "UP";
                    break;
                }
            case 7:
                str2 = "HOVER MOVE";
                break;
            case 8:
                str2 = "SCROLL";
                break;
            case 9:
                str2 = "HOVER ENTER";
                break;
            case 10:
                str2 = "HOVER EXIT";
                break;
            default:
                str2 = Integer.toString(i);
                break;
        }
        Log.i(TAG, this.mText.clear().append(str).append(" id ").append(i3 + 1).append(": ").append(str2).append(" (").append(pointerCoords.x, 3).append(", ").append(pointerCoords.y, 3).append(") Pressure=").append(pointerCoords.pressure, 3).append(" Size=").append(pointerCoords.size, 3).append(" TouchMajor=").append(pointerCoords.touchMajor, 3).append(" TouchMinor=").append(pointerCoords.touchMinor, 3).append(" ToolMajor=").append(pointerCoords.toolMajor, 3).append(" ToolMinor=").append(pointerCoords.toolMinor, 3).append(" Orientation=").append((float) ((pointerCoords.orientation * 180.0f) / 3.141592653589793d), 1).append("deg").append(" Tilt=").append((float) ((pointerCoords.getAxisValue(25) * 180.0f) / 3.141592653589793d), 1).append("deg").append(" Distance=").append(pointerCoords.getAxisValue(24), 1).append(" VScroll=").append(pointerCoords.getAxisValue(9), 1).append(" HScroll=").append(pointerCoords.getAxisValue(10), 1).append(" BoundingBox=[(").append(motionEvent.getAxisValue(32), 3).append(", ").append(motionEvent.getAxisValue(33), 3).append(")").append(", (").append(motionEvent.getAxisValue(34), 3).append(", ").append(motionEvent.getAxisValue(35), 3).append(")]").append(" ToolType=").append(MotionEvent.toolTypeToString(toolType)).append(" ButtonState=").append(MotionEvent.buttonStateToString(buttonState)).toString());
    }

    private void logInputDeviceState(int i, String str) {
        InputDevice inputDevice = this.mIm.getInputDevice(i);
        if (inputDevice != null) {
            Log.i(TAG, str + ": " + inputDevice);
        } else {
            Log.i(TAG, str + ": " + i);
        }
    }

    private void logInputDevices() {
        int[] deviceIds = InputDevice.getDeviceIds();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= deviceIds.length) {
                return;
            }
            logInputDeviceState(deviceIds[i2], "Device Enumerated");
            i = i2 + 1;
        }
    }

    private void logMotionEvent(String str, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int historySize = motionEvent.getHistorySize();
        int pointerCount = motionEvent.getPointerCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= historySize) {
                break;
            }
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < pointerCount) {
                    int pointerId = motionEvent.getPointerId(i4);
                    motionEvent.getHistoricalPointerCoords(i4, i2, this.mTempCoords);
                    logCoords(str, action, i4, this.mTempCoords, pointerId, motionEvent);
                    i3 = i4 + 1;
                }
            }
            i = i2 + 1;
        }
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= pointerCount) {
                return;
            }
            int pointerId2 = motionEvent.getPointerId(i6);
            motionEvent.getPointerCoords(i6, this.mTempCoords);
            logCoords(str, action, i6, this.mTempCoords, pointerId2, motionEvent);
            i5 = i6 + 1;
        }
    }

    private static boolean shouldLogKey(int i) {
        switch (i) {
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                return true;
            default:
                return KeyEvent.isGamepadButton(i) || KeyEvent.isModifierKey(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mIm.registerInputDeviceListener(this, getHandler());
        logInputDevices();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mIm.unregisterInputDeviceListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        boolean z;
        int width = getWidth();
        int i = width / 7;
        int i2 = (-this.mTextMetrics.ascent) + 1;
        int i3 = this.mHeaderBottom;
        int size = this.mPointers.size();
        if (this.mActivePointerId >= 0) {
            PointerState pointerState = this.mPointers.get(this.mActivePointerId);
            canvas.drawRect(0.0f, 0.0f, i - 1, i3, this.mTextBackgroundPaint);
            canvas.drawText(this.mText.clear().append("P: ").append(this.mCurNumPointers).append(" / ").append(this.mMaxNumPointers).toString(), 1.0f, i2, this.mTextPaint);
            int i4 = pointerState.mTraceCount;
            if ((this.mCurDown && pointerState.mCurDown) || i4 == 0) {
                canvas.drawRect(i, 0.0f, (i * 2) - 1, i3, this.mTextBackgroundPaint);
                canvas.drawText(this.mText.clear().append("X: ").append(pointerState.mCoords.x, 1).toString(), i + 1, i2, this.mTextPaint);
                canvas.drawRect(i * 2, 0.0f, (i * 3) - 1, i3, this.mTextBackgroundPaint);
                canvas.drawText(this.mText.clear().append("Y: ").append(pointerState.mCoords.y, 1).toString(), (i * 2) + 1, i2, this.mTextPaint);
            } else {
                float f = pointerState.mTraceX[i4 - 1] - pointerState.mTraceX[0];
                float f2 = pointerState.mTraceY[i4 - 1] - pointerState.mTraceY[0];
                canvas.drawRect(i, 0.0f, (i * 2) - 1, i3, Math.abs(f) < ((float) this.mVC.getScaledTouchSlop()) ? this.mTextBackgroundPaint : this.mTextLevelPaint);
                canvas.drawText(this.mText.clear().append("dX: ").append(f, 1).toString(), i + 1, i2, this.mTextPaint);
                canvas.drawRect(i * 2, 0.0f, (i * 3) - 1, i3, Math.abs(f2) < ((float) this.mVC.getScaledTouchSlop()) ? this.mTextBackgroundPaint : this.mTextLevelPaint);
                canvas.drawText(this.mText.clear().append("dY: ").append(f2, 1).toString(), (i * 2) + 1, i2, this.mTextPaint);
            }
            canvas.drawRect(i * 3, 0.0f, (i * 4) - 1, i3, this.mTextBackgroundPaint);
            canvas.drawText(this.mText.clear().append("Xv: ").append(pointerState.mXVelocity, 3).toString(), (i * 3) + 1, i2, this.mTextPaint);
            canvas.drawRect(i * 4, 0.0f, (i * 5) - 1, i3, this.mTextBackgroundPaint);
            canvas.drawText(this.mText.clear().append("Yv: ").append(pointerState.mYVelocity, 3).toString(), (i * 4) + 1, i2, this.mTextPaint);
            canvas.drawRect(i * 5, 0.0f, (i * 6) - 1, i3, this.mTextBackgroundPaint);
            canvas.drawRect(i * 5, 0.0f, ((i * 5) + (pointerState.mCoords.pressure * i)) - 1.0f, i3, this.mTextLevelPaint);
            canvas.drawText(this.mText.clear().append("Prs: ").append(pointerState.mCoords.pressure, 2).toString(), (i * 5) + 1, i2, this.mTextPaint);
            canvas.drawRect(i * 6, 0.0f, width, i3, this.mTextBackgroundPaint);
            canvas.drawRect(i * 6, 0.0f, ((i * 6) + (pointerState.mCoords.size * i)) - 1.0f, i3, this.mTextLevelPaint);
            canvas.drawText(this.mText.clear().append("Size: ").append(pointerState.mCoords.size, 2).toString(), (i * 6) + 1, i2, this.mTextPaint);
        }
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= size) {
                return;
            }
            PointerState pointerState2 = this.mPointers.get(i6);
            int i7 = pointerState2.mTraceCount;
            float f3 = 0.0f;
            float f4 = 0.0f;
            boolean z2 = false;
            boolean z3 = false;
            this.mPaint.setARGB(255, 128, 255, 255);
            int i8 = 0;
            while (true) {
                int i9 = i8;
                if (i9 >= i7) {
                    break;
                }
                float f5 = pointerState2.mTraceX[i9];
                float f6 = pointerState2.mTraceY[i9];
                if (Float.isNaN(f5)) {
                    z = false;
                } else {
                    if (z2) {
                        canvas.drawLine(f3, f4, f5, f6, this.mPathPaint);
                        canvas.drawPoint(f3, f4, pointerState2.mTraceCurrent[i9] ? this.mCurrentPointPaint : this.mPaint);
                        z3 = true;
                    }
                    f3 = f5;
                    f4 = f6;
                    z = true;
                }
                z2 = z;
                i8 = i9 + 1;
            }
            if (z3) {
                this.mPaint.setARGB(128, 128, 0, 128);
                float estimateX = pointerState2.mEstimator.estimateX(-0.08f);
                float estimateY = pointerState2.mEstimator.estimateY(-0.08f);
                int i10 = -3;
                while (true) {
                    int i11 = i10;
                    if (i11 > 2) {
                        break;
                    }
                    float estimateX2 = pointerState2.mEstimator.estimateX(i11 * 0.02f);
                    float estimateY2 = pointerState2.mEstimator.estimateY(i11 * 0.02f);
                    canvas.drawLine(estimateX, estimateY, estimateX2, estimateY2, this.mPaint);
                    estimateX = estimateX2;
                    estimateY = estimateY2;
                    i10 = i11 + 1;
                }
                this.mPaint.setARGB(255, 255, 64, 128);
                canvas.drawLine(f3, f4, f3 + (pointerState2.mXVelocity * 16.0f), f4 + (pointerState2.mYVelocity * 16.0f), this.mPaint);
                if (this.mAltVelocity != null) {
                    this.mPaint.setARGB(128, 0, 128, 128);
                    float estimateX3 = pointerState2.mAltEstimator.estimateX(-0.08f);
                    float estimateY3 = pointerState2.mAltEstimator.estimateY(-0.08f);
                    int i12 = -3;
                    while (true) {
                        int i13 = i12;
                        if (i13 > 2) {
                            break;
                        }
                        float estimateX4 = pointerState2.mAltEstimator.estimateX(i13 * 0.02f);
                        float estimateY4 = pointerState2.mAltEstimator.estimateY(i13 * 0.02f);
                        canvas.drawLine(estimateX3, estimateY3, estimateX4, estimateY4, this.mPaint);
                        estimateX3 = estimateX4;
                        estimateY3 = estimateY4;
                        i12 = i13 + 1;
                    }
                    this.mPaint.setARGB(255, 64, 255, 128);
                    canvas.drawLine(f3, f4, f3 + (pointerState2.mAltXVelocity * 16.0f), f4 + (pointerState2.mAltYVelocity * 16.0f), this.mPaint);
                }
            }
            if (this.mCurDown && pointerState2.mCurDown) {
                canvas.drawLine(0.0f, pointerState2.mCoords.y, getWidth(), pointerState2.mCoords.y, this.mTargetPaint);
                canvas.drawLine(pointerState2.mCoords.x, 0.0f, pointerState2.mCoords.x, getHeight(), this.mTargetPaint);
                int i14 = (int) (pointerState2.mCoords.pressure * 255.0f);
                this.mPaint.setARGB(255, i14, 255, 255 - i14);
                canvas.drawPoint(pointerState2.mCoords.x, pointerState2.mCoords.y, this.mPaint);
                this.mPaint.setARGB(255, i14, 255 - i14, 128);
                drawOval(canvas, pointerState2.mCoords.x, pointerState2.mCoords.y, pointerState2.mCoords.touchMajor, pointerState2.mCoords.touchMinor, pointerState2.mCoords.orientation, this.mPaint);
                this.mPaint.setARGB(255, i14, 128, 255 - i14);
                drawOval(canvas, pointerState2.mCoords.x, pointerState2.mCoords.y, pointerState2.mCoords.toolMajor, pointerState2.mCoords.toolMinor, pointerState2.mCoords.orientation, this.mPaint);
                float f7 = pointerState2.mCoords.toolMajor * 0.7f;
                float f8 = f7;
                if (f7 < 20.0f) {
                    f8 = 20.0f;
                }
                this.mPaint.setARGB(255, i14, 255, 0);
                float sin = (float) (Math.sin(pointerState2.mCoords.orientation) * f8);
                float f9 = (float) ((-Math.cos(pointerState2.mCoords.orientation)) * f8);
                if (pointerState2.mToolType == 2 || pointerState2.mToolType == 4) {
                    canvas.drawLine(pointerState2.mCoords.x, pointerState2.mCoords.y, pointerState2.mCoords.x + sin, pointerState2.mCoords.y + f9, this.mPaint);
                } else {
                    canvas.drawLine(pointerState2.mCoords.x - sin, pointerState2.mCoords.y - f9, pointerState2.mCoords.x + sin, pointerState2.mCoords.y + f9, this.mPaint);
                }
                float sin2 = (float) Math.sin(pointerState2.mCoords.getAxisValue(25));
                canvas.drawCircle(pointerState2.mCoords.x + (sin * sin2), pointerState2.mCoords.y + (f9 * sin2), 3.0f, this.mPaint);
                if (pointerState2.mHasBoundingBox) {
                    canvas.drawRect(pointerState2.mBoundingLeft, pointerState2.mBoundingTop, pointerState2.mBoundingRight, pointerState2.mBoundingBottom, this.mPaint);
                }
            }
            i5 = i6 + 1;
        }
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        int source = motionEvent.getSource();
        if ((source & 2) != 0) {
            onPointerEvent(motionEvent);
            return true;
        } else if ((source & 16) != 0) {
            logMotionEvent("Joystick", motionEvent);
            return true;
        } else if ((source & 8) != 0) {
            logMotionEvent("Position", motionEvent);
            return true;
        } else {
            logMotionEvent("Generic", motionEvent);
            return true;
        }
    }

    @Override // android.hardware.input.InputManager.InputDeviceListener
    public void onInputDeviceAdded(int i) {
        logInputDeviceState(i, "Device Added");
    }

    @Override // android.hardware.input.InputManager.InputDeviceListener
    public void onInputDeviceChanged(int i) {
        logInputDeviceState(i, "Device Changed");
    }

    @Override // android.hardware.input.InputManager.InputDeviceListener
    public void onInputDeviceRemoved(int i) {
        logInputDeviceState(i, "Device Removed");
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (shouldLogKey(i)) {
            int repeatCount = keyEvent.getRepeatCount();
            if (repeatCount == 0) {
                Log.i(TAG, "Key Down: " + keyEvent);
                return true;
            }
            Log.i(TAG, "Key Repeat #" + repeatCount + ": " + keyEvent);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (shouldLogKey(i)) {
            Log.i(TAG, "Key Up: " + keyEvent);
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mTextPaint.getFontMetricsInt(this.mTextMetrics);
        this.mHeaderBottom = (-this.mTextMetrics.ascent) + this.mTextMetrics.descent + 2;
    }

    @Override // android.view.WindowManagerPolicy.PointerEventListener
    public void onPointerEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.mPointers.size();
        if (action == 0 || (action & 255) == 5) {
            if (action == 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= size) {
                        break;
                    }
                    PointerState pointerState = this.mPointers.get(i2);
                    pointerState.clearTrace();
                    pointerState.mCurDown = false;
                    i = i2 + 1;
                }
                this.mCurDown = true;
                this.mCurNumPointers = 0;
                this.mMaxNumPointers = 0;
                this.mVelocity.clear();
                if (this.mAltVelocity != null) {
                    this.mAltVelocity.clear();
                }
            }
            this.mCurNumPointers++;
            if (this.mMaxNumPointers < this.mCurNumPointers) {
                this.mMaxNumPointers = this.mCurNumPointers;
            }
            int pointerId = motionEvent.getPointerId((65280 & action) >> 8);
            int i3 = size;
            while (true) {
                int i4 = i3;
                if (i4 > pointerId) {
                    break;
                }
                this.mPointers.add(new PointerState());
                i3 = i4 + 1;
            }
            if (this.mActivePointerId < 0 || !this.mPointers.get(this.mActivePointerId).mCurDown) {
                this.mActivePointerId = pointerId;
            }
            PointerState pointerState2 = this.mPointers.get(pointerId);
            pointerState2.mCurDown = true;
            InputDevice device = InputDevice.getDevice(motionEvent.getDeviceId());
            pointerState2.mHasBoundingBox = (device == null || device.getMotionRange(32) == null) ? false : true;
        }
        int pointerCount = motionEvent.getPointerCount();
        this.mVelocity.addMovement(motionEvent);
        this.mVelocity.computeCurrentVelocity(1);
        if (this.mAltVelocity != null) {
            this.mAltVelocity.addMovement(motionEvent);
            this.mAltVelocity.computeCurrentVelocity(1);
        }
        int historySize = motionEvent.getHistorySize();
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= historySize) {
                break;
            }
            int i7 = 0;
            while (true) {
                int i8 = i7;
                if (i8 < pointerCount) {
                    int pointerId2 = motionEvent.getPointerId(i8);
                    PointerState pointerState3 = this.mCurDown ? this.mPointers.get(pointerId2) : null;
                    MotionEvent.PointerCoords pointerCoords = pointerState3 != null ? pointerState3.mCoords : this.mTempCoords;
                    motionEvent.getHistoricalPointerCoords(i8, i6, pointerCoords);
                    if (this.mPrintCoords) {
                        logCoords(TAG, action, i8, pointerCoords, pointerId2, motionEvent);
                    }
                    if (pointerState3 != null) {
                        pointerState3.addTrace(pointerCoords.x, pointerCoords.y, false);
                    }
                    i7 = i8 + 1;
                }
            }
            i5 = i6 + 1;
        }
        int i9 = 0;
        while (true) {
            int i10 = i9;
            if (i10 >= pointerCount) {
                break;
            }
            int pointerId3 = motionEvent.getPointerId(i10);
            PointerState pointerState4 = this.mCurDown ? this.mPointers.get(pointerId3) : null;
            MotionEvent.PointerCoords pointerCoords2 = pointerState4 != null ? pointerState4.mCoords : this.mTempCoords;
            motionEvent.getPointerCoords(i10, pointerCoords2);
            if (this.mPrintCoords) {
                logCoords(TAG, action, i10, pointerCoords2, pointerId3, motionEvent);
            }
            if (pointerState4 != null) {
                pointerState4.addTrace(pointerCoords2.x, pointerCoords2.y, true);
                pointerState4.mXVelocity = this.mVelocity.getXVelocity(pointerId3);
                pointerState4.mYVelocity = this.mVelocity.getYVelocity(pointerId3);
                this.mVelocity.getEstimator(pointerId3, pointerState4.mEstimator);
                if (this.mAltVelocity != null) {
                    pointerState4.mAltXVelocity = this.mAltVelocity.getXVelocity(pointerId3);
                    pointerState4.mAltYVelocity = this.mAltVelocity.getYVelocity(pointerId3);
                    this.mAltVelocity.getEstimator(pointerId3, pointerState4.mAltEstimator);
                }
                pointerState4.mToolType = motionEvent.getToolType(i10);
                if (pointerState4.mHasBoundingBox) {
                    pointerState4.mBoundingLeft = motionEvent.getAxisValue(32, i10);
                    pointerState4.mBoundingTop = motionEvent.getAxisValue(33, i10);
                    pointerState4.mBoundingRight = motionEvent.getAxisValue(34, i10);
                    pointerState4.mBoundingBottom = motionEvent.getAxisValue(35, i10);
                }
            }
            i9 = i10 + 1;
        }
        if (action == 1 || action == 3 || (action & 255) == 6) {
            int i11 = (65280 & action) >> 8;
            int pointerId4 = motionEvent.getPointerId(i11);
            PointerState pointerState5 = this.mPointers.get(pointerId4);
            pointerState5.mCurDown = false;
            if (action == 1 || action == 3) {
                this.mCurDown = false;
                this.mCurNumPointers = 0;
            } else {
                this.mCurNumPointers--;
                if (this.mActivePointerId == pointerId4) {
                    this.mActivePointerId = motionEvent.getPointerId(i11 == 0 ? 1 : 0);
                }
                pointerState5.addTrace(Float.NaN, Float.NaN, false);
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        onPointerEvent(motionEvent);
        if (motionEvent.getAction() != 0 || isFocused()) {
            return true;
        }
        requestFocus();
        return true;
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        logMotionEvent("Trackball", motionEvent);
        return true;
    }

    public void setPrintCoords(boolean z) {
        this.mPrintCoords = z;
    }
}
