package com.android.internal.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.media.AudioAttributes;
import android.os.Vibrator;
import android.provider.Settings;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import com.android.internal.R;
import java.util.ArrayList;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/WaveView.class */
public class WaveView extends View implements ValueAnimator.AnimatorUpdateListener {
    private static final boolean DBG = false;
    private static final long DELAY_INCREMENT = 15;
    private static final long DELAY_INCREMENT2 = 12;
    private static final long DURATION = 300;
    private static final long FINAL_DELAY = 200;
    private static final long FINAL_DURATION = 200;
    private static final float GRAB_HANDLE_RADIUS_SCALE_ACCESSIBILITY_DISABLED = 0.5f;
    private static final float GRAB_HANDLE_RADIUS_SCALE_ACCESSIBILITY_ENABLED = 1.0f;
    private static final long RESET_TIMEOUT = 3000;
    private static final long RING_DELAY = 1300;
    private static final long SHORT_DELAY = 100;
    private static final int STATE_ATTEMPTING = 3;
    private static final int STATE_READY = 1;
    private static final int STATE_RESET_LOCK = 0;
    private static final int STATE_START_ATTEMPT = 2;
    private static final int STATE_UNLOCK_ATTEMPT = 4;
    private static final int STATE_UNLOCK_SUCCESS = 5;
    private static final String TAG = "WaveView";
    private static final long VIBRATE_LONG = 20;
    private static final long VIBRATE_SHORT = 20;
    private static final AudioAttributes VIBRATION_ATTRIBUTES = new AudioAttributes.Builder().setContentType(4).setUsage(13).build();
    private static final int WAVE_COUNT = 20;
    private static final long WAVE_DELAY = 100;
    private static final long WAVE_DURATION = 2000;
    private final Runnable mAddWaveAction;
    private int mCurrentWave;
    private ArrayList<DrawableHolder> mDrawables;
    private boolean mFingerDown;
    private boolean mFinishWaves;
    private int mGrabbedState;
    private ArrayList<DrawableHolder> mLightWaves;
    private float mLockCenterX;
    private float mLockCenterY;
    private int mLockState;
    private final Runnable mLockTimerActions;
    private float mMouseX;
    private float mMouseY;
    private OnTriggerListener mOnTriggerListener;
    private float mRingRadius;
    private int mSnapRadius;
    private DrawableHolder mUnlockDefault;
    private DrawableHolder mUnlockHalo;
    private DrawableHolder mUnlockRing;
    private Vibrator mVibrator;
    private int mWaveCount;
    private long mWaveTimerDelay;
    private boolean mWavesRunning;

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/WaveView$OnTriggerListener.class */
    public interface OnTriggerListener {
        public static final int CENTER_HANDLE = 10;
        public static final int NO_HANDLE = 0;

        void onGrabbedStateChange(View view, int i);

        void onTrigger(View view, int i);
    }

    public WaveView(Context context) {
        this(context, null);
    }

    public WaveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDrawables = new ArrayList<>(3);
        this.mLightWaves = new ArrayList<>(20);
        this.mFingerDown = false;
        this.mRingRadius = 182.0f;
        this.mSnapRadius = 136;
        this.mWaveCount = 20;
        this.mWaveTimerDelay = 100L;
        this.mCurrentWave = 0;
        this.mLockState = 0;
        this.mGrabbedState = 0;
        this.mLockTimerActions = new Runnable() { // from class: com.android.internal.widget.WaveView.1
            @Override // java.lang.Runnable
            public void run() {
                if (WaveView.this.mLockState == 3) {
                    WaveView.this.mLockState = 0;
                }
                if (WaveView.this.mLockState == 5) {
                    WaveView.this.mLockState = 0;
                }
                WaveView.this.invalidate();
            }
        };
        this.mAddWaveAction = new Runnable() { // from class: com.android.internal.widget.WaveView.2
            @Override // java.lang.Runnable
            public void run() {
                int ceil = (int) Math.ceil(Math.hypot(WaveView.this.mMouseX - WaveView.this.mLockCenterX, WaveView.this.mMouseY - WaveView.this.mLockCenterY));
                if (WaveView.this.mLockState != 3 || ceil >= WaveView.this.mSnapRadius || WaveView.this.mWaveTimerDelay < 100) {
                    WaveView.access$614(WaveView.this, WaveView.DELAY_INCREMENT2);
                } else {
                    WaveView.this.mWaveTimerDelay = Math.min((long) WaveView.WAVE_DURATION, WaveView.this.mWaveTimerDelay + WaveView.DELAY_INCREMENT);
                    DrawableHolder drawableHolder = (DrawableHolder) WaveView.this.mLightWaves.get(WaveView.this.mCurrentWave);
                    drawableHolder.setAlpha(0.0f);
                    drawableHolder.setScaleX(0.2f);
                    drawableHolder.setScaleY(0.2f);
                    drawableHolder.setX(WaveView.this.mMouseX);
                    drawableHolder.setY(WaveView.this.mMouseY);
                    drawableHolder.addAnimTo(WaveView.WAVE_DURATION, 0L, "x", WaveView.this.mLockCenterX, true);
                    drawableHolder.addAnimTo(WaveView.WAVE_DURATION, 0L, "y", WaveView.this.mLockCenterY, true);
                    drawableHolder.addAnimTo(1333L, 0L, "alpha", 1.0f, true);
                    drawableHolder.addAnimTo(WaveView.WAVE_DURATION, 0L, "scaleX", 1.0f, true);
                    drawableHolder.addAnimTo(WaveView.WAVE_DURATION, 0L, "scaleY", 1.0f, true);
                    drawableHolder.addAnimTo(1000L, WaveView.RING_DELAY, "alpha", 0.0f, false);
                    drawableHolder.startAnimations(WaveView.this);
                    WaveView.this.mCurrentWave = (WaveView.this.mCurrentWave + 1) % WaveView.this.mWaveCount;
                }
                if (WaveView.this.mFinishWaves) {
                    WaveView.this.mWavesRunning = false;
                } else {
                    WaveView.this.postDelayed(WaveView.this.mAddWaveAction, WaveView.this.mWaveTimerDelay);
                }
            }
        };
        initDrawables();
    }

    static /* synthetic */ long access$614(WaveView waveView, long j) {
        long j2 = waveView.mWaveTimerDelay + j;
        waveView.mWaveTimerDelay = j2;
        return j2;
    }

    private void announceUnlockHandle() {
        setContentDescription(this.mContext.getString(R.string.description_target_unlock_tablet));
        sendAccessibilityEvent(8);
        setContentDescription(null);
    }

    private void dispatchTriggerEvent(int i) {
        vibrate(20L);
        if (this.mOnTriggerListener != null) {
            this.mOnTriggerListener.onTrigger(this, i);
        }
    }

    private float getScaledGrabHandleRadius() {
        return AccessibilityManager.getInstance(this.mContext).isEnabled() ? 1.0f * this.mUnlockHalo.getWidth() : GRAB_HANDLE_RADIUS_SCALE_ACCESSIBILITY_DISABLED * this.mUnlockHalo.getWidth();
    }

    private void initDrawables() {
        this.mUnlockRing = new DrawableHolder(createDrawable(R.drawable.unlock_ring));
        this.mUnlockRing.setX(this.mLockCenterX);
        this.mUnlockRing.setY(this.mLockCenterY);
        this.mUnlockRing.setScaleX(0.1f);
        this.mUnlockRing.setScaleY(0.1f);
        this.mUnlockRing.setAlpha(0.0f);
        this.mDrawables.add(this.mUnlockRing);
        this.mUnlockDefault = new DrawableHolder(createDrawable(R.drawable.unlock_default));
        this.mUnlockDefault.setX(this.mLockCenterX);
        this.mUnlockDefault.setY(this.mLockCenterY);
        this.mUnlockDefault.setScaleX(0.1f);
        this.mUnlockDefault.setScaleY(0.1f);
        this.mUnlockDefault.setAlpha(0.0f);
        this.mDrawables.add(this.mUnlockDefault);
        this.mUnlockHalo = new DrawableHolder(createDrawable(R.drawable.unlock_halo));
        this.mUnlockHalo.setX(this.mLockCenterX);
        this.mUnlockHalo.setY(this.mLockCenterY);
        this.mUnlockHalo.setScaleX(0.1f);
        this.mUnlockHalo.setScaleY(0.1f);
        this.mUnlockHalo.setAlpha(0.0f);
        this.mDrawables.add(this.mUnlockHalo);
        BitmapDrawable createDrawable = createDrawable(R.drawable.unlock_wave);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mWaveCount) {
                return;
            }
            DrawableHolder drawableHolder = new DrawableHolder(createDrawable);
            this.mLightWaves.add(drawableHolder);
            drawableHolder.setAlpha(0.0f);
            i = i2 + 1;
        }
    }

    private void setGrabbedState(int i) {
        if (i != this.mGrabbedState) {
            this.mGrabbedState = i;
            if (this.mOnTriggerListener != null) {
                this.mOnTriggerListener.onGrabbedStateChange(this, this.mGrabbedState);
            }
        }
    }

    private void tryTransitionToStartAttemptState(MotionEvent motionEvent) {
        if (((float) Math.hypot(motionEvent.getX() - this.mUnlockHalo.getX(), motionEvent.getY() - this.mUnlockHalo.getY())) <= getScaledGrabHandleRadius()) {
            setGrabbedState(10);
            if (this.mLockState == 1) {
                this.mLockState = 2;
                if (AccessibilityManager.getInstance(this.mContext).isEnabled()) {
                    announceUnlockHandle();
                }
            }
        }
    }

    private void vibrate(long j) {
        boolean z = true;
        synchronized (this) {
            if (Settings.System.getIntForUser(this.mContext.getContentResolver(), "haptic_feedback_enabled", 1, -2) == 0) {
                z = false;
            }
            if (z) {
                if (this.mVibrator == null) {
                    this.mVibrator = (Vibrator) getContext().getSystemService("vibrator");
                }
                this.mVibrator.vibrate(j, VIBRATION_ATTRIBUTES);
            }
        }
    }

    private void waveUpdateFrame(float f, float f2, boolean z) {
        double d = f - this.mLockCenterX;
        double d2 = f2 - this.mLockCenterY;
        int ceil = (int) Math.ceil(Math.hypot(d, d2));
        double atan2 = Math.atan2(d, d2);
        float sin = (float) (this.mLockCenterX + (this.mRingRadius * Math.sin(atan2)));
        float cos = (float) (this.mLockCenterY + (this.mRingRadius * Math.cos(atan2)));
        switch (this.mLockState) {
            case 0:
                this.mWaveTimerDelay = 100L;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.mLightWaves.size()) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= this.mLightWaves.size()) {
                                this.mUnlockRing.addAnimTo(DURATION, 0L, "x", this.mLockCenterX, true);
                                this.mUnlockRing.addAnimTo(DURATION, 0L, "y", this.mLockCenterY, true);
                                this.mUnlockRing.addAnimTo(DURATION, 0L, "scaleX", 0.1f, true);
                                this.mUnlockRing.addAnimTo(DURATION, 0L, "scaleY", 0.1f, true);
                                this.mUnlockRing.addAnimTo(DURATION, 0L, "alpha", 0.0f, true);
                                this.mUnlockDefault.removeAnimationFor("x");
                                this.mUnlockDefault.removeAnimationFor("y");
                                this.mUnlockDefault.removeAnimationFor("scaleX");
                                this.mUnlockDefault.removeAnimationFor("scaleY");
                                this.mUnlockDefault.removeAnimationFor("alpha");
                                this.mUnlockDefault.setX(this.mLockCenterX);
                                this.mUnlockDefault.setY(this.mLockCenterY);
                                this.mUnlockDefault.setScaleX(0.1f);
                                this.mUnlockDefault.setScaleY(0.1f);
                                this.mUnlockDefault.setAlpha(0.0f);
                                this.mUnlockDefault.addAnimTo(DURATION, 100L, "scaleX", 1.0f, true);
                                this.mUnlockDefault.addAnimTo(DURATION, 100L, "scaleY", 1.0f, true);
                                this.mUnlockDefault.addAnimTo(DURATION, 100L, "alpha", 1.0f, true);
                                this.mUnlockHalo.removeAnimationFor("x");
                                this.mUnlockHalo.removeAnimationFor("y");
                                this.mUnlockHalo.removeAnimationFor("scaleX");
                                this.mUnlockHalo.removeAnimationFor("scaleY");
                                this.mUnlockHalo.removeAnimationFor("alpha");
                                this.mUnlockHalo.setX(this.mLockCenterX);
                                this.mUnlockHalo.setY(this.mLockCenterY);
                                this.mUnlockHalo.setScaleX(0.1f);
                                this.mUnlockHalo.setScaleY(0.1f);
                                this.mUnlockHalo.setAlpha(0.0f);
                                this.mUnlockHalo.addAnimTo(DURATION, 100L, "x", this.mLockCenterX, true);
                                this.mUnlockHalo.addAnimTo(DURATION, 100L, "y", this.mLockCenterY, true);
                                this.mUnlockHalo.addAnimTo(DURATION, 100L, "scaleX", 1.0f, true);
                                this.mUnlockHalo.addAnimTo(DURATION, 100L, "scaleY", 1.0f, true);
                                this.mUnlockHalo.addAnimTo(DURATION, 100L, "alpha", 1.0f, true);
                                removeCallbacks(this.mLockTimerActions);
                                this.mLockState = 1;
                                break;
                            } else {
                                this.mLightWaves.get(i4).startAnimations(this);
                                i3 = i4 + 1;
                            }
                        }
                    } else {
                        this.mLightWaves.get(i2).addAnimTo(DURATION, 0L, "alpha", 0.0f, false);
                        i = i2 + 1;
                    }
                }
            case 1:
                this.mWaveTimerDelay = 100L;
                break;
            case 2:
                this.mUnlockDefault.removeAnimationFor("x");
                this.mUnlockDefault.removeAnimationFor("y");
                this.mUnlockDefault.removeAnimationFor("scaleX");
                this.mUnlockDefault.removeAnimationFor("scaleY");
                this.mUnlockDefault.removeAnimationFor("alpha");
                this.mUnlockDefault.setX(this.mLockCenterX + 182.0f);
                this.mUnlockDefault.setY(this.mLockCenterY);
                this.mUnlockDefault.setScaleX(0.1f);
                this.mUnlockDefault.setScaleY(0.1f);
                this.mUnlockDefault.setAlpha(0.0f);
                this.mUnlockDefault.addAnimTo(DURATION, 100L, "scaleX", 1.0f, false);
                this.mUnlockDefault.addAnimTo(DURATION, 100L, "scaleY", 1.0f, false);
                this.mUnlockDefault.addAnimTo(DURATION, 100L, "alpha", 1.0f, false);
                this.mUnlockRing.addAnimTo(DURATION, 0L, "scaleX", 1.0f, true);
                this.mUnlockRing.addAnimTo(DURATION, 0L, "scaleY", 1.0f, true);
                this.mUnlockRing.addAnimTo(DURATION, 0L, "alpha", 1.0f, true);
                this.mLockState = 3;
                break;
            case 3:
                if (ceil <= this.mSnapRadius) {
                    if (!this.mWavesRunning) {
                        this.mWavesRunning = true;
                        this.mFinishWaves = false;
                        postDelayed(this.mAddWaveAction, this.mWaveTimerDelay);
                    }
                    this.mUnlockHalo.addAnimTo(0L, 0L, "x", f, true);
                    this.mUnlockHalo.addAnimTo(0L, 0L, "y", f2, true);
                    this.mUnlockHalo.addAnimTo(0L, 0L, "scaleX", 1.0f, true);
                    this.mUnlockHalo.addAnimTo(0L, 0L, "scaleY", 1.0f, true);
                    this.mUnlockHalo.addAnimTo(0L, 0L, "alpha", 1.0f, true);
                    break;
                } else {
                    this.mFinishWaves = true;
                    if (!z) {
                        this.mLockState = 4;
                        break;
                    } else {
                        this.mUnlockHalo.addAnimTo(0L, 0L, "x", sin, true);
                        this.mUnlockHalo.addAnimTo(0L, 0L, "y", cos, true);
                        this.mUnlockHalo.addAnimTo(0L, 0L, "scaleX", 1.0f, true);
                        this.mUnlockHalo.addAnimTo(0L, 0L, "scaleY", 1.0f, true);
                        this.mUnlockHalo.addAnimTo(0L, 0L, "alpha", 1.0f, true);
                        break;
                    }
                }
            case 4:
                if (ceil <= this.mSnapRadius) {
                    this.mLockState = 0;
                    break;
                } else {
                    int i5 = 0;
                    while (true) {
                        int i6 = i5;
                        if (i6 >= this.mLightWaves.size()) {
                            int i7 = 0;
                            while (true) {
                                int i8 = i7;
                                if (i8 >= this.mLightWaves.size()) {
                                    this.mUnlockRing.addAnimTo(200L, 0L, "x", sin, false);
                                    this.mUnlockRing.addAnimTo(200L, 0L, "y", cos, false);
                                    this.mUnlockRing.addAnimTo(200L, 0L, "scaleX", 0.1f, false);
                                    this.mUnlockRing.addAnimTo(200L, 0L, "scaleY", 0.1f, false);
                                    this.mUnlockRing.addAnimTo(200L, 0L, "alpha", 0.0f, false);
                                    this.mUnlockRing.addAnimTo(200L, 200L, "alpha", 0.0f, false);
                                    this.mUnlockDefault.removeAnimationFor("x");
                                    this.mUnlockDefault.removeAnimationFor("y");
                                    this.mUnlockDefault.removeAnimationFor("scaleX");
                                    this.mUnlockDefault.removeAnimationFor("scaleY");
                                    this.mUnlockDefault.removeAnimationFor("alpha");
                                    this.mUnlockDefault.setX(sin);
                                    this.mUnlockDefault.setY(cos);
                                    this.mUnlockDefault.setScaleX(0.1f);
                                    this.mUnlockDefault.setScaleY(0.1f);
                                    this.mUnlockDefault.setAlpha(0.0f);
                                    this.mUnlockDefault.addAnimTo(200L, 0L, "x", sin, true);
                                    this.mUnlockDefault.addAnimTo(200L, 0L, "y", cos, true);
                                    this.mUnlockDefault.addAnimTo(200L, 0L, "scaleX", 1.0f, true);
                                    this.mUnlockDefault.addAnimTo(200L, 0L, "scaleY", 1.0f, true);
                                    this.mUnlockDefault.addAnimTo(200L, 0L, "alpha", 1.0f, true);
                                    this.mUnlockDefault.addAnimTo(200L, 200L, "scaleX", 3.0f, false);
                                    this.mUnlockDefault.addAnimTo(200L, 200L, "scaleY", 3.0f, false);
                                    this.mUnlockDefault.addAnimTo(200L, 200L, "alpha", 0.0f, false);
                                    this.mUnlockHalo.addAnimTo(200L, 0L, "x", sin, false);
                                    this.mUnlockHalo.addAnimTo(200L, 0L, "y", cos, false);
                                    this.mUnlockHalo.addAnimTo(200L, 200L, "scaleX", 3.0f, false);
                                    this.mUnlockHalo.addAnimTo(200L, 200L, "scaleY", 3.0f, false);
                                    this.mUnlockHalo.addAnimTo(200L, 200L, "alpha", 0.0f, false);
                                    removeCallbacks(this.mLockTimerActions);
                                    postDelayed(this.mLockTimerActions, RESET_TIMEOUT);
                                    dispatchTriggerEvent(10);
                                    this.mLockState = 5;
                                    break;
                                } else {
                                    this.mLightWaves.get(i8).startAnimations(this);
                                    i7 = i8 + 1;
                                }
                            }
                        } else {
                            DrawableHolder drawableHolder = this.mLightWaves.get(i6);
                            long j = (1000 * ((i6 + 6) - this.mCurrentWave)) / 10;
                            drawableHolder.addAnimTo(200L, j, "x", sin, true);
                            drawableHolder.addAnimTo(200L, j, "y", cos, true);
                            drawableHolder.addAnimTo(200L, j, "scaleX", 0.1f, true);
                            drawableHolder.addAnimTo(200L, j, "scaleY", 0.1f, true);
                            drawableHolder.addAnimTo(200L, j, "alpha", 0.0f, true);
                            i5 = i6 + 1;
                        }
                    }
                }
            case 5:
                removeCallbacks(this.mAddWaveAction);
                break;
        }
        this.mUnlockDefault.startAnimations(this);
        this.mUnlockHalo.startAnimations(this);
        this.mUnlockRing.startAnimations(this);
    }

    BitmapDrawable createDrawable(int i) {
        Resources resources = getResources();
        return new BitmapDrawable(resources, BitmapFactory.decodeResource(resources, i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        return this.mUnlockRing.getHeight() + this.mUnlockHalo.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        return this.mUnlockRing.getWidth() + this.mUnlockHalo.getWidth();
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        waveUpdateFrame(this.mMouseX, this.mMouseY, this.mFingerDown);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mDrawables.size()) {
                break;
            }
            this.mDrawables.get(i2).draw(canvas);
            i = i2 + 1;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.mLightWaves.size()) {
                return;
            }
            this.mLightWaves.get(i4).draw(canvas);
            i3 = i4 + 1;
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (AccessibilityManager.getInstance(this.mContext).isTouchExplorationEnabled()) {
            int action = motionEvent.getAction();
            switch (action) {
                case 7:
                    motionEvent.setAction(2);
                    break;
                case 9:
                    motionEvent.setAction(0);
                    break;
                case 10:
                    motionEvent.setAction(1);
                    break;
            }
            onTouchEvent(motionEvent);
            motionEvent.setAction(action);
        }
        return super.onHoverEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE) {
            size = Math.min(size, getSuggestedMinimumWidth());
        } else if (mode != 1073741824) {
            size = getSuggestedMinimumWidth();
        }
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(size2, getSuggestedMinimumWidth());
        } else if (mode2 != 1073741824) {
            size2 = getSuggestedMinimumHeight();
        }
        setMeasuredDimension(size, size2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.mLockCenterX = i * GRAB_HANDLE_RADIUS_SCALE_ACCESSIBILITY_DISABLED;
        this.mLockCenterY = i2 * GRAB_HANDLE_RADIUS_SCALE_ACCESSIBILITY_DISABLED;
        super.onSizeChanged(i, i2, i3, i4);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        this.mMouseX = motionEvent.getX();
        this.mMouseY = motionEvent.getY();
        boolean z = false;
        switch (action) {
            case 0:
                removeCallbacks(this.mLockTimerActions);
                this.mFingerDown = true;
                tryTransitionToStartAttemptState(motionEvent);
                z = true;
                break;
            case 1:
                this.mFingerDown = false;
                postDelayed(this.mLockTimerActions, RESET_TIMEOUT);
                setGrabbedState(0);
                waveUpdateFrame(this.mMouseX, this.mMouseY, this.mFingerDown);
                z = true;
                break;
            case 2:
                tryTransitionToStartAttemptState(motionEvent);
                z = true;
                break;
            case 3:
                this.mFingerDown = false;
                z = true;
                break;
        }
        invalidate();
        if (z) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void reset() {
        this.mLockState = 0;
        invalidate();
    }

    public void setOnTriggerListener(OnTriggerListener onTriggerListener) {
        this.mOnTriggerListener = onTriggerListener;
    }
}
