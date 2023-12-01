package android.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.IntArray;
import android.util.Log;
import android.util.MathUtils;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.amap.api.maps.utils.SpatialRelationUtil;
import com.android.ims.ImsReasonInfo;
import com.android.internal.R;
import com.android.internal.widget.ExploreByTouchHelper;
import com.anythink.core.common.c.d;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: source-4181928-dex2jar.jar:android/widget/RadialTimePickerView.class */
public class RadialTimePickerView extends View implements View.OnTouchListener {
    private static final int ALPHA_OPAQUE = 255;
    private static final int ALPHA_SELECTOR = 60;
    private static final int ALPHA_TRANSPARENT = 0;
    private static final int AM = 0;
    private static final int CENTER_RADIUS = 2;
    private static final boolean DEBUG = false;
    private static final int DEBUG_COLOR = 553582592;
    private static final int DEBUG_STROKE_WIDTH = 2;
    private static final int DEBUG_TEXT_COLOR = 1627324416;
    private static final int DEGREES_FOR_ONE_HOUR = 30;
    private static final int DEGREES_FOR_ONE_MINUTE = 6;
    private static final int HOURS = 0;
    private static final int HOURS_INNER = 2;
    private static final int MINUTES = 1;
    private static final int PM = 1;
    private static final int SELECTOR_CIRCLE = 0;
    private static final int SELECTOR_DOT = 1;
    private static final int SELECTOR_LINE = 2;
    private static final String TAG = "ClockView";
    private final IntHolder[] mAlpha;
    private final IntHolder[][] mAlphaSelector;
    private int mAmOrPm;
    private final float[] mAnimationRadiusMultiplier;
    boolean mChangedDuringTouch;
    private final float[] mCircleRadius;
    private final float[] mCircleRadiusMultiplier;
    private final int[] mColor;
    private final int[][] mColorSelector;
    private int mDisabledAlpha;
    private int mHalfwayHypotenusePoint;
    private final String[] mHours12Texts;
    private final ArrayList<Animator> mHoursToMinutesAnims;
    private final String[] mInnerHours24Texts;
    private final float[] mInnerTextGridHeights;
    private final float[] mInnerTextGridWidths;
    private String[] mInnerTextHours;
    private float mInnerTextSize;
    private boolean mInputEnabled;
    private final InvalidateUpdateListener mInvalidateUpdateListener;
    private boolean mIs24HourMode;
    private boolean mIsOnInnerCircle;
    private final int[] mLineLength;
    private OnValueSelectedListener mListener;
    private int mMaxHypotenuseForOuterNumber;
    private int mMinHypotenuseForInnerNumber;
    private final ArrayList<Animator> mMinuteToHoursAnims;
    private final String[] mMinutesTexts;
    private final float[] mNumbersRadiusMultiplier;
    private final String[] mOuterHours24Texts;
    private String[] mOuterTextHours;
    private String[] mOuterTextMinutes;
    private final Paint[] mPaint;
    private final Paint mPaintBackground;
    private final Paint mPaintCenter;
    private final Paint mPaintDebug;
    private final Paint[][] mPaintSelector;
    private final int[] mSelectionDegrees;
    private final int[] mSelectionRadius;
    private final float mSelectionRadiusMultiplier;
    private boolean mShowHours;
    private final float[][] mTextGridHeights;
    private final float[][] mTextGridWidths;
    private final float[] mTextSize;
    private final float[] mTextSizeMultiplier;
    private final RadialPickerTouchHelper mTouchHelper;
    private AnimatorSet mTransition;
    private final float mTransitionEndRadiusMultiplier;
    private final float mTransitionMidRadiusMultiplier;
    private final Typeface mTypeface;
    private int mXCenter;
    private int mYCenter;
    private static final float SINE_30_DEGREES = 0.5f;
    private static final float COSINE_30_DEGREES = ((float) Math.sqrt(3.0d)) * SINE_30_DEGREES;
    private static final int[] HOURS_NUMBERS = {12, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
    private static final int[] HOURS_NUMBERS_24 = {0, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23};
    private static final int[] MINUTES_NUMBERS = {0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55};
    private static int[] sSnapPrefer30sMap = new int[ImsReasonInfo.CODE_SIP_USER_REJECTED];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/RadialTimePickerView$IntHolder.class */
    public static class IntHolder {
        private int mValue;

        public IntHolder(int i) {
            this.mValue = i;
        }

        public int getValue() {
            return this.mValue;
        }

        public void setValue(int i) {
            this.mValue = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/RadialTimePickerView$InvalidateUpdateListener.class */
    public class InvalidateUpdateListener implements ValueAnimator.AnimatorUpdateListener {
        private InvalidateUpdateListener() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            RadialTimePickerView.this.invalidate();
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/RadialTimePickerView$OnValueSelectedListener.class */
    public interface OnValueSelectedListener {
        void onValueSelected(int i, int i2, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/RadialTimePickerView$RadialPickerTouchHelper.class */
    public class RadialPickerTouchHelper extends ExploreByTouchHelper {
        private final int MASK_TYPE;
        private final int MASK_VALUE;
        private final int MINUTE_INCREMENT;
        private final int SHIFT_TYPE;
        private final int SHIFT_VALUE;
        private final int TYPE_HOUR;
        private final int TYPE_MINUTE;
        private final Rect mTempRect;

        public RadialPickerTouchHelper() {
            super(RadialTimePickerView.this);
            this.mTempRect = new Rect();
            this.TYPE_HOUR = 1;
            this.TYPE_MINUTE = 2;
            this.SHIFT_TYPE = 0;
            this.MASK_TYPE = 15;
            this.SHIFT_VALUE = 8;
            this.MASK_VALUE = 255;
            this.MINUTE_INCREMENT = 5;
        }

        private void adjustPicker(int i) {
            int i2;
            int currentMinute;
            int i3;
            int i4;
            if (RadialTimePickerView.this.mShowHours) {
                i2 = 30;
                currentMinute = RadialTimePickerView.this.getCurrentHour() % 12;
                if (RadialTimePickerView.this.mIs24HourMode) {
                    i3 = 23;
                    i4 = 0;
                } else {
                    i3 = 12;
                    i4 = 1;
                }
            } else {
                i2 = 6;
                currentMinute = RadialTimePickerView.this.getCurrentMinute();
                i3 = 55;
                i4 = 0;
            }
            int constrain = MathUtils.constrain(RadialTimePickerView.snapOnly30s(currentMinute * i2, i) / i2, i4, i3);
            if (RadialTimePickerView.this.mShowHours) {
                RadialTimePickerView.this.setCurrentHour(constrain);
            } else {
                RadialTimePickerView.this.setCurrentMinute(constrain);
            }
        }

        private void getBoundsForVirtualView(int i, Rect rect) {
            float f;
            float f2;
            float f3;
            int typeFromId = getTypeFromId(i);
            int valueFromId = getValueFromId(i);
            if (typeFromId == 1) {
                if (RadialTimePickerView.this.mIs24HourMode && valueFromId > 0 && valueFromId <= 12) {
                    f = RadialTimePickerView.this.mCircleRadius[2] * RadialTimePickerView.this.mNumbersRadiusMultiplier[2];
                    f3 = RadialTimePickerView.this.mSelectionRadius[2];
                } else {
                    f = RadialTimePickerView.this.mCircleRadius[0] * RadialTimePickerView.this.mNumbersRadiusMultiplier[0];
                    f3 = RadialTimePickerView.this.mSelectionRadius[0];
                }
                f2 = RadialTimePickerView.this.getDegreesForHour(valueFromId);
            } else if (typeFromId == 2) {
                f = RadialTimePickerView.this.mCircleRadius[1] * RadialTimePickerView.this.mNumbersRadiusMultiplier[1];
                f2 = RadialTimePickerView.this.getDegreesForMinute(valueFromId);
                f3 = RadialTimePickerView.this.mSelectionRadius[1];
            } else {
                f = 0.0f;
                f2 = 0.0f;
                f3 = 0.0f;
            }
            double radians = Math.toRadians(f2);
            float sin = RadialTimePickerView.this.mXCenter + (((float) Math.sin(radians)) * f);
            float cos = RadialTimePickerView.this.mYCenter - (((float) Math.cos(radians)) * f);
            rect.set((int) (sin - f3), (int) (cos - f3), (int) (sin + f3), (int) (cos + f3));
        }

        private int getTypeFromId(int i) {
            return (i >>> 0) & 15;
        }

        private int getValueFromId(int i) {
            return (i >>> 8) & 255;
        }

        private CharSequence getVirtualViewDescription(int i, int i2) {
            if (i == 1 || i == 2) {
                return Integer.toString(i2);
            }
            return null;
        }

        private int getVirtualViewIdAfter(int i, int i2) {
            if (i == 1) {
                int i3 = i2 + 1;
                if (i3 <= (RadialTimePickerView.this.mIs24HourMode ? 23 : 12)) {
                    return makeId(i, i3);
                }
                return Integer.MIN_VALUE;
            } else if (i == 2) {
                int currentMinute = RadialTimePickerView.this.getCurrentMinute();
                int i4 = (i2 - (i2 % 5)) + 5;
                if (i2 >= currentMinute || i4 <= currentMinute) {
                    if (i4 < 60) {
                        return makeId(i, i4);
                    }
                    return Integer.MIN_VALUE;
                }
                return makeId(i, currentMinute);
            } else {
                return Integer.MIN_VALUE;
            }
        }

        private int hour12To24(int i, int i2) {
            int i3;
            if (i == 12) {
                i3 = i;
                if (i2 == 0) {
                    i3 = 0;
                }
            } else {
                i3 = i;
                if (i2 == 1) {
                    return i + 12;
                }
            }
            return i3;
        }

        private int hour24To12(int i) {
            int i2;
            if (i == 0) {
                i2 = 12;
            } else {
                i2 = i;
                if (i > 12) {
                    return i - 12;
                }
            }
            return i2;
        }

        private boolean isVirtualViewSelected(int i, int i2) {
            return i == 1 ? RadialTimePickerView.this.getCurrentHour() == i2 : i == 2 && RadialTimePickerView.this.getCurrentMinute() == i2;
        }

        private int makeId(int i, int i2) {
            return (i << 0) | (i2 << 8);
        }

        @Override // com.android.internal.widget.ExploreByTouchHelper
        protected int getVirtualViewAt(float f, float f2) {
            boolean z = RadialTimePickerView.this.mIsOnInnerCircle;
            int degreesFromXY = RadialTimePickerView.this.getDegreesFromXY(f, f2);
            boolean z2 = RadialTimePickerView.this.mIsOnInnerCircle;
            RadialTimePickerView.this.mIsOnInnerCircle = z;
            if (degreesFromXY != -1) {
                int snapOnly30s = RadialTimePickerView.snapOnly30s(degreesFromXY, 0) % SpatialRelationUtil.A_CIRCLE_DEGREE;
                if (RadialTimePickerView.this.mShowHours) {
                    int hourForDegrees = RadialTimePickerView.this.getHourForDegrees(snapOnly30s, z2);
                    if (!RadialTimePickerView.this.mIs24HourMode) {
                        hourForDegrees = hour24To12(hourForDegrees);
                    }
                    return makeId(1, hourForDegrees);
                }
                int currentMinute = RadialTimePickerView.this.getCurrentMinute();
                int minuteForDegrees = RadialTimePickerView.this.getMinuteForDegrees(degreesFromXY);
                int minuteForDegrees2 = RadialTimePickerView.this.getMinuteForDegrees(snapOnly30s);
                if (Math.abs(currentMinute - minuteForDegrees) >= Math.abs(minuteForDegrees2 - minuteForDegrees)) {
                    currentMinute = minuteForDegrees2;
                }
                return makeId(2, currentMinute);
            }
            return Integer.MIN_VALUE;
        }

        @Override // com.android.internal.widget.ExploreByTouchHelper
        protected void getVisibleVirtualViews(IntArray intArray) {
            if (RadialTimePickerView.this.mShowHours) {
                int i = RadialTimePickerView.this.mIs24HourMode ? 23 : 12;
                for (int i2 = RadialTimePickerView.this.mIs24HourMode ? 0 : 1; i2 <= i; i2++) {
                    intArray.add(makeId(1, i2));
                }
                return;
            }
            int currentMinute = RadialTimePickerView.this.getCurrentMinute();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= 60) {
                    return;
                }
                intArray.add(makeId(2, i4));
                if (currentMinute > i4 && currentMinute < i4 + 5) {
                    intArray.add(makeId(2, currentMinute));
                }
                i3 = i4 + 5;
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
            accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
        }

        @Override // com.android.internal.widget.ExploreByTouchHelper
        protected boolean onPerformActionForVirtualView(int i, int i2, Bundle bundle) {
            if (i2 == 16) {
                int typeFromId = getTypeFromId(i);
                int valueFromId = getValueFromId(i);
                if (typeFromId == 1) {
                    if (!RadialTimePickerView.this.mIs24HourMode) {
                        valueFromId = hour12To24(valueFromId, RadialTimePickerView.this.mAmOrPm);
                    }
                    RadialTimePickerView.this.setCurrentHour(valueFromId);
                    return true;
                } else if (typeFromId == 2) {
                    RadialTimePickerView.this.setCurrentMinute(valueFromId);
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }

        @Override // com.android.internal.widget.ExploreByTouchHelper
        protected void onPopulateEventForVirtualView(int i, AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.setClassName(getClass().getName());
            accessibilityEvent.setContentDescription(getVirtualViewDescription(getTypeFromId(i), getValueFromId(i)));
        }

        @Override // com.android.internal.widget.ExploreByTouchHelper
        protected void onPopulateNodeForVirtualView(int i, AccessibilityNodeInfo accessibilityNodeInfo) {
            accessibilityNodeInfo.setClassName(getClass().getName());
            accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_CLICK);
            int typeFromId = getTypeFromId(i);
            int valueFromId = getValueFromId(i);
            accessibilityNodeInfo.setContentDescription(getVirtualViewDescription(typeFromId, valueFromId));
            getBoundsForVirtualView(i, this.mTempRect);
            accessibilityNodeInfo.setBoundsInParent(this.mTempRect);
            accessibilityNodeInfo.setSelected(isVirtualViewSelected(typeFromId, valueFromId));
            int virtualViewIdAfter = getVirtualViewIdAfter(typeFromId, valueFromId);
            if (virtualViewIdAfter != Integer.MIN_VALUE) {
                accessibilityNodeInfo.setTraversalBefore(RadialTimePickerView.this, virtualViewIdAfter);
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            switch (i) {
                case 4096:
                    adjustPicker(1);
                    return true;
                case 8192:
                    adjustPicker(-1);
                    return true;
                default:
                    return false;
            }
        }
    }

    static {
        preparePrefer30sMap();
    }

    public RadialTimePickerView(Context context) {
        this(context, null);
    }

    public RadialTimePickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.timePickerStyle);
    }

    public RadialTimePickerView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public RadialTimePickerView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet);
        this.mInvalidateUpdateListener = new InvalidateUpdateListener();
        this.mHours12Texts = new String[12];
        this.mOuterHours24Texts = new String[12];
        this.mInnerHours24Texts = new String[12];
        this.mMinutesTexts = new String[12];
        this.mPaint = new Paint[2];
        this.mColor = new int[2];
        this.mAlpha = new IntHolder[2];
        this.mPaintCenter = new Paint();
        this.mPaintSelector = (Paint[][]) Array.newInstance(Paint.class, 2, 3);
        this.mColorSelector = (int[][]) Array.newInstance(Integer.TYPE, 2, 3);
        this.mAlphaSelector = (IntHolder[][]) Array.newInstance(IntHolder.class, 2, 3);
        this.mPaintBackground = new Paint();
        this.mPaintDebug = new Paint();
        this.mCircleRadius = new float[3];
        this.mTextSize = new float[2];
        this.mTextGridHeights = (float[][]) Array.newInstance(Float.TYPE, 2, 7);
        this.mTextGridWidths = (float[][]) Array.newInstance(Float.TYPE, 2, 7);
        this.mInnerTextGridHeights = new float[7];
        this.mInnerTextGridWidths = new float[7];
        this.mCircleRadiusMultiplier = new float[2];
        this.mNumbersRadiusMultiplier = new float[3];
        this.mTextSizeMultiplier = new float[3];
        this.mAnimationRadiusMultiplier = new float[3];
        this.mLineLength = new int[3];
        this.mSelectionRadius = new int[3];
        this.mSelectionDegrees = new int[3];
        this.mHoursToMinutesAnims = new ArrayList<>();
        this.mMinuteToHoursAnims = new ArrayList<>();
        this.mInputEnabled = true;
        this.mChangedDuringTouch = false;
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, typedValue, true);
        this.mDisabledAlpha = (int) ((typedValue.getFloat() * 255.0f) + SINE_30_DEGREES);
        Resources resources = getResources();
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, R.styleable.TimePicker, i, i2);
        this.mTypeface = Typeface.create("sans-serif", 0);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.mAlpha.length) {
                break;
            }
            this.mAlpha[i4] = new IntHolder(255);
            i3 = i4 + 1;
        }
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= this.mAlphaSelector.length) {
                break;
            }
            int i7 = 0;
            while (true) {
                int i8 = i7;
                if (i8 < this.mAlphaSelector[i6].length) {
                    this.mAlphaSelector[i6][i8] = new IntHolder(255);
                    i7 = i8 + 1;
                }
            }
            i5 = i6 + 1;
        }
        int color = obtainStyledAttributes.getColor(3, resources.getColor(R.color.timepicker_default_text_color_material));
        this.mPaint[0] = new Paint();
        this.mPaint[0].setAntiAlias(true);
        this.mPaint[0].setTextAlign(Paint.Align.CENTER);
        this.mColor[0] = color;
        this.mPaint[1] = new Paint();
        this.mPaint[1].setAntiAlias(true);
        this.mPaint[1].setTextAlign(Paint.Align.CENTER);
        this.mColor[1] = color;
        this.mPaintCenter.setColor(color);
        this.mPaintCenter.setAntiAlias(true);
        this.mPaintCenter.setTextAlign(Paint.Align.CENTER);
        this.mPaintSelector[0][0] = new Paint();
        this.mPaintSelector[0][0].setAntiAlias(true);
        this.mColorSelector[0][0] = obtainStyledAttributes.getColor(5, R.color.timepicker_default_selector_color_material);
        this.mPaintSelector[0][1] = new Paint();
        this.mPaintSelector[0][1].setAntiAlias(true);
        this.mColorSelector[0][1] = obtainStyledAttributes.getColor(5, R.color.timepicker_default_selector_color_material);
        this.mPaintSelector[0][2] = new Paint();
        this.mPaintSelector[0][2].setAntiAlias(true);
        this.mPaintSelector[0][2].setStrokeWidth(2.0f);
        this.mColorSelector[0][2] = obtainStyledAttributes.getColor(5, R.color.timepicker_default_selector_color_material);
        this.mPaintSelector[1][0] = new Paint();
        this.mPaintSelector[1][0].setAntiAlias(true);
        this.mColorSelector[1][0] = obtainStyledAttributes.getColor(5, R.color.timepicker_default_selector_color_material);
        this.mPaintSelector[1][1] = new Paint();
        this.mPaintSelector[1][1].setAntiAlias(true);
        this.mColorSelector[1][1] = obtainStyledAttributes.getColor(5, R.color.timepicker_default_selector_color_material);
        this.mPaintSelector[1][2] = new Paint();
        this.mPaintSelector[1][2].setAntiAlias(true);
        this.mPaintSelector[1][2].setStrokeWidth(2.0f);
        this.mColorSelector[1][2] = obtainStyledAttributes.getColor(5, R.color.timepicker_default_selector_color_material);
        this.mPaintBackground.setColor(obtainStyledAttributes.getColor(4, resources.getColor(R.color.timepicker_default_numbers_background_color_material)));
        this.mPaintBackground.setAntiAlias(true);
        this.mShowHours = true;
        this.mIs24HourMode = false;
        this.mAmOrPm = 0;
        this.mTouchHelper = new RadialPickerTouchHelper();
        setAccessibilityDelegate(this.mTouchHelper);
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        initHoursAndMinutesText();
        initData();
        this.mTransitionMidRadiusMultiplier = Float.parseFloat(resources.getString(R.string.timepicker_transition_mid_radius_multiplier));
        this.mTransitionEndRadiusMultiplier = Float.parseFloat(resources.getString(R.string.timepicker_transition_end_radius_multiplier));
        this.mTextGridHeights[0] = new float[7];
        this.mTextGridHeights[1] = new float[7];
        this.mSelectionRadiusMultiplier = Float.parseFloat(resources.getString(R.string.timepicker_selection_radius_multiplier));
        obtainStyledAttributes.recycle();
        setOnTouchListener(this);
        setClickable(true);
        Calendar calendar = Calendar.getInstance(Locale.getDefault());
        int i9 = calendar.get(11);
        int i10 = calendar.get(12);
        setCurrentHourInternal(i9, false, false);
        setCurrentMinuteInternal(i10, false);
        setHapticFeedbackEnabled(true);
    }

    private static void calculateGridSizes(Paint paint, float f, float f2, float f3, float f4, float[] fArr, float[] fArr2) {
        float f5 = f * COSINE_30_DEGREES;
        float f6 = f * SINE_30_DEGREES;
        paint.setTextSize(f4);
        float descent = f3 - ((paint.descent() + paint.ascent()) / 2.0f);
        fArr[0] = descent - f;
        fArr2[0] = f2 - f;
        fArr[1] = descent - f5;
        fArr2[1] = f2 - f5;
        fArr[2] = descent - f6;
        fArr2[2] = f2 - f6;
        fArr[3] = descent;
        fArr2[3] = f2;
        fArr[4] = descent + f6;
        fArr2[4] = f2 + f6;
        fArr[5] = descent + f5;
        fArr2[5] = f2 + f5;
        fArr[6] = descent + f;
        fArr2[6] = f2 + f;
    }

    private void calculateGridSizesHours() {
        float f = this.mCircleRadius[0];
        float f2 = this.mNumbersRadiusMultiplier[0];
        calculateGridSizes(this.mPaint[0], f * f2 * this.mAnimationRadiusMultiplier[0], this.mXCenter, this.mYCenter, this.mTextSize[0], this.mTextGridHeights[0], this.mTextGridWidths[0]);
        if (this.mIs24HourMode) {
            float f3 = this.mCircleRadius[2];
            float f4 = this.mNumbersRadiusMultiplier[2];
            calculateGridSizes(this.mPaint[0], f3 * f4 * this.mAnimationRadiusMultiplier[2], this.mXCenter, this.mYCenter, this.mInnerTextSize, this.mInnerTextGridHeights, this.mInnerTextGridWidths);
        }
    }

    private void calculateGridSizesMinutes() {
        float f = this.mCircleRadius[1];
        float f2 = this.mNumbersRadiusMultiplier[1];
        calculateGridSizes(this.mPaint[1], f * f2 * this.mAnimationRadiusMultiplier[1], this.mXCenter, this.mYCenter, this.mTextSize[1], this.mTextGridHeights[1], this.mTextGridWidths[1]);
    }

    private void drawCenter(Canvas canvas) {
        canvas.drawCircle(this.mXCenter, this.mYCenter, 2.0f, this.mPaintCenter);
    }

    private void drawCircleBackground(Canvas canvas) {
        canvas.drawCircle(this.mXCenter, this.mYCenter, this.mCircleRadius[0], this.mPaintBackground);
    }

    private void drawDebug(Canvas canvas) {
        float f = this.mCircleRadius[0] * this.mNumbersRadiusMultiplier[0];
        canvas.drawCircle(this.mXCenter, this.mYCenter, f, this.mPaintDebug);
        canvas.drawCircle(this.mXCenter, this.mYCenter, this.mCircleRadius[0] * this.mNumbersRadiusMultiplier[2], this.mPaintDebug);
        canvas.drawCircle(this.mXCenter, this.mYCenter, this.mCircleRadius[0], this.mPaintDebug);
        canvas.drawRect(this.mXCenter - f, this.mYCenter - f, this.mXCenter + f, this.mYCenter + f, this.mPaintDebug);
        canvas.drawRect(this.mXCenter - this.mCircleRadius[0], this.mYCenter - this.mCircleRadius[0], this.mXCenter + this.mCircleRadius[0], this.mYCenter + this.mCircleRadius[0], this.mPaintDebug);
        canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.mPaintDebug);
        String format = String.format("%02d:%02d", Integer.valueOf(getCurrentHour()), Integer.valueOf(getCurrentMinute()));
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -2);
        TextView textView = new TextView(getContext());
        textView.setLayoutParams(layoutParams);
        textView.setText(format);
        textView.measure(0, 0);
        TextPaint paint = textView.getPaint();
        paint.setColor(DEBUG_TEXT_COLOR);
        canvas.drawText(format, this.mXCenter - (textView.getMeasuredWidth() / 2), this.mYCenter + (1.5f * (paint.descent() - paint.ascent())), paint);
    }

    private void drawSelector(Canvas canvas) {
        drawSelector(canvas, this.mIsOnInnerCircle ? 2 : 0);
        drawSelector(canvas, 1);
    }

    private void drawSelector(Canvas canvas, int i) {
        this.mLineLength[i] = (int) (this.mCircleRadius[i] * this.mNumbersRadiusMultiplier[i] * this.mAnimationRadiusMultiplier[i]);
        double radians = Math.toRadians(this.mSelectionDegrees[i]);
        int sin = this.mXCenter + ((int) (this.mLineLength[i] * Math.sin(radians)));
        int cos = this.mYCenter - ((int) (this.mLineLength[i] * Math.cos(radians)));
        int i2 = this.mColorSelector[i % 2][0];
        int value = this.mAlphaSelector[i % 2][0].getValue();
        Paint paint = this.mPaintSelector[i % 2][0];
        paint.setColor(i2);
        paint.setAlpha(getMultipliedAlpha(i2, value));
        canvas.drawCircle(sin, cos, this.mSelectionRadius[i], paint);
        if (this.mSelectionDegrees[i] % 30 != 0) {
            int i3 = this.mColorSelector[i % 2][1];
            int value2 = this.mAlphaSelector[i % 2][1].getValue();
            Paint paint2 = this.mPaintSelector[i % 2][1];
            paint2.setColor(i3);
            paint2.setAlpha(getMultipliedAlpha(i3, value2));
            canvas.drawCircle(sin, cos, (this.mSelectionRadius[i] * 2) / 7, paint2);
        } else {
            int i4 = this.mLineLength[i] - this.mSelectionRadius[i];
            sin = this.mXCenter + ((int) (i4 * Math.sin(radians)));
            cos = this.mYCenter - ((int) (i4 * Math.cos(radians)));
        }
        int i5 = this.mColorSelector[i % 2][2];
        int value3 = this.mAlphaSelector[i % 2][2].getValue();
        Paint paint3 = this.mPaintSelector[i % 2][2];
        paint3.setColor(i5);
        paint3.setAlpha(getMultipliedAlpha(i5, value3));
        canvas.drawLine(this.mXCenter, this.mYCenter, sin, cos, paint3);
    }

    private void drawTextElements(Canvas canvas, float f, Typeface typeface, String[] strArr, float[] fArr, float[] fArr2, Paint paint, int i, int i2) {
        paint.setTextSize(f);
        paint.setTypeface(typeface);
        paint.setColor(i);
        paint.setAlpha(getMultipliedAlpha(i, i2));
        canvas.drawText(strArr[0], fArr[3], fArr2[0], paint);
        canvas.drawText(strArr[1], fArr[4], fArr2[1], paint);
        canvas.drawText(strArr[2], fArr[5], fArr2[2], paint);
        canvas.drawText(strArr[3], fArr[6], fArr2[3], paint);
        canvas.drawText(strArr[4], fArr[5], fArr2[4], paint);
        canvas.drawText(strArr[5], fArr[4], fArr2[5], paint);
        canvas.drawText(strArr[6], fArr[3], fArr2[6], paint);
        canvas.drawText(strArr[7], fArr[2], fArr2[5], paint);
        canvas.drawText(strArr[8], fArr[1], fArr2[4], paint);
        canvas.drawText(strArr[9], fArr[0], fArr2[3], paint);
        canvas.drawText(strArr[10], fArr[1], fArr2[2], paint);
        canvas.drawText(strArr[11], fArr[2], fArr2[1], paint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getDegreesForHour(int i) {
        int i2;
        if (this.mIs24HourMode) {
            i2 = i;
            if (i >= 12) {
                i2 = i - 12;
            }
        } else {
            i2 = i;
            if (i == 12) {
                i2 = 0;
            }
        }
        return i2 * 30;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getDegreesForMinute(int i) {
        return i * 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getDegreesFromXY(float f, float f2) {
        double sqrt = Math.sqrt(((f2 - this.mYCenter) * (f2 - this.mYCenter)) + ((f - this.mXCenter) * (f - this.mXCenter)));
        if (sqrt > this.mCircleRadius[0]) {
            return -1;
        }
        if (!this.mIs24HourMode || !this.mShowHours) {
            char c = this.mShowHours ? (char) 0 : (char) 1;
            if (((int) Math.abs(sqrt - (this.mCircleRadius[c] * this.mNumbersRadiusMultiplier[c]))) > ((int) (this.mCircleRadius[c] * (1.0f - this.mNumbersRadiusMultiplier[c])))) {
                return -1;
            }
        } else if (sqrt >= this.mMinHypotenuseForInnerNumber && sqrt <= this.mHalfwayHypotenusePoint) {
            this.mIsOnInnerCircle = true;
        } else if (sqrt > this.mMaxHypotenuseForOuterNumber || sqrt < this.mHalfwayHypotenusePoint) {
            return -1;
        } else {
            this.mIsOnInnerCircle = false;
        }
        int degrees = (int) (Math.toDegrees(Math.asin(Math.abs(f2 - this.mYCenter) / sqrt)) + 0.5d);
        boolean z = f > ((float) this.mXCenter);
        boolean z2 = f2 < ((float) this.mYCenter);
        return z ? z2 ? 90 - degrees : degrees + 90 : z2 ? degrees + 270 : 270 - degrees;
    }

    private static ObjectAnimator getFadeInAnimator(IntHolder intHolder, int i, int i2, InvalidateUpdateListener invalidateUpdateListener) {
        int i3 = (int) (500 * (1.0f + 0.25f));
        ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(intHolder, PropertyValuesHolder.ofKeyframe(d.a.d, Keyframe.ofInt(0.0f, i), Keyframe.ofInt((500 * 0.25f) / i3, i), Keyframe.ofInt(1.0f, i2))).setDuration(i3);
        duration.addUpdateListener(invalidateUpdateListener);
        return duration;
    }

    private static ObjectAnimator getFadeOutAnimator(IntHolder intHolder, int i, int i2, InvalidateUpdateListener invalidateUpdateListener) {
        ObjectAnimator ofInt = ObjectAnimator.ofInt(intHolder, d.a.d, i, i2);
        ofInt.setDuration(500);
        ofInt.addUpdateListener(invalidateUpdateListener);
        return ofInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getHourForDegrees(int i, boolean z) {
        int i2;
        int i3 = (i / 30) % 12;
        if (!this.mIs24HourMode) {
            i2 = i3;
            if (this.mAmOrPm == 1) {
                return i3 + 12;
            }
        } else if (z && i3 == 0) {
            i2 = 12;
        } else {
            i2 = i3;
            if (!z) {
                i2 = i3;
                if (i3 != 0) {
                    return i3 + 12;
                }
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getMinuteForDegrees(int i) {
        return i / 6;
    }

    private int getMultipliedAlpha(int i, int i2) {
        return (int) ((Color.alpha(i) * (i2 / 255.0d)) + 0.5d);
    }

    private static ObjectAnimator getRadiusDisappearAnimator(Object obj, String str, InvalidateUpdateListener invalidateUpdateListener, float f, float f2) {
        ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(obj, PropertyValuesHolder.ofKeyframe(str, Keyframe.ofFloat(0.0f, 1.0f), Keyframe.ofFloat(0.2f, f), Keyframe.ofFloat(1.0f, f2))).setDuration(500);
        duration.addUpdateListener(invalidateUpdateListener);
        return duration;
    }

    private static ObjectAnimator getRadiusReappearAnimator(Object obj, String str, InvalidateUpdateListener invalidateUpdateListener, float f, float f2) {
        int i = (int) (500 * (1.0f + 0.25f));
        float f3 = (500 * 0.25f) / i;
        ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(obj, PropertyValuesHolder.ofKeyframe(str, Keyframe.ofFloat(0.0f, f2), Keyframe.ofFloat(f3, f2), Keyframe.ofFloat(1.0f - ((1.0f - f3) * 0.2f), f), Keyframe.ofFloat(1.0f, 1.0f))).setDuration(i);
        duration.addUpdateListener(invalidateUpdateListener);
        return duration;
    }

    private boolean handleTouchInput(float f, float f2, boolean z, boolean z2) {
        boolean z3;
        int i;
        int currentMinute;
        boolean z4 = this.mIsOnInnerCircle;
        int degreesFromXY = getDegreesFromXY(f, f2);
        if (degreesFromXY == -1) {
            return false;
        }
        int[] iArr = this.mSelectionDegrees;
        if (this.mShowHours) {
            int snapOnly30s = snapOnly30s(degreesFromXY, 0) % SpatialRelationUtil.A_CIRCLE_DEGREE;
            z3 = (iArr[0] == snapOnly30s && iArr[2] == snapOnly30s && z4 == this.mIsOnInnerCircle) ? false : true;
            iArr[0] = snapOnly30s;
            iArr[2] = snapOnly30s;
            i = 0;
            currentMinute = getCurrentHour();
        } else {
            int snapPrefer30s = snapPrefer30s(degreesFromXY) % SpatialRelationUtil.A_CIRCLE_DEGREE;
            z3 = iArr[1] != snapPrefer30s;
            iArr[1] = snapPrefer30s;
            i = 1;
            currentMinute = getCurrentMinute();
        }
        if (z3 || z || z2) {
            if (this.mListener != null) {
                this.mListener.onValueSelected(i, currentMinute, z2);
            }
            if (z3 || z) {
                performHapticFeedback(4);
                invalidate();
                return true;
            }
            return true;
        }
        return false;
    }

    private void initData() {
        if (this.mIs24HourMode) {
            this.mOuterTextHours = this.mOuterHours24Texts;
            this.mInnerTextHours = this.mInnerHours24Texts;
        } else {
            this.mOuterTextHours = this.mHours12Texts;
            this.mInnerTextHours = null;
        }
        this.mOuterTextMinutes = this.mMinutesTexts;
        Resources resources = getResources();
        if (!this.mShowHours) {
            this.mCircleRadiusMultiplier[1] = Float.parseFloat(resources.getString(R.string.timepicker_circle_radius_multiplier));
            this.mNumbersRadiusMultiplier[1] = Float.parseFloat(resources.getString(R.string.timepicker_numbers_radius_multiplier_normal));
            this.mTextSizeMultiplier[1] = Float.parseFloat(resources.getString(R.string.timepicker_text_size_multiplier_normal));
        } else if (this.mIs24HourMode) {
            this.mCircleRadiusMultiplier[0] = Float.parseFloat(resources.getString(R.string.timepicker_circle_radius_multiplier_24HourMode));
            this.mNumbersRadiusMultiplier[0] = Float.parseFloat(resources.getString(R.string.timepicker_numbers_radius_multiplier_outer));
            this.mTextSizeMultiplier[0] = Float.parseFloat(resources.getString(R.string.timepicker_text_size_multiplier_outer));
            this.mNumbersRadiusMultiplier[2] = Float.parseFloat(resources.getString(R.string.timepicker_numbers_radius_multiplier_inner));
            this.mTextSizeMultiplier[2] = Float.parseFloat(resources.getString(R.string.timepicker_text_size_multiplier_inner));
        } else {
            this.mCircleRadiusMultiplier[0] = Float.parseFloat(resources.getString(R.string.timepicker_circle_radius_multiplier));
            this.mNumbersRadiusMultiplier[0] = Float.parseFloat(resources.getString(R.string.timepicker_numbers_radius_multiplier_normal));
            this.mTextSizeMultiplier[0] = Float.parseFloat(resources.getString(R.string.timepicker_text_size_multiplier_normal));
        }
        this.mAnimationRadiusMultiplier[0] = 1.0f;
        this.mAnimationRadiusMultiplier[2] = 1.0f;
        this.mAnimationRadiusMultiplier[1] = 1.0f;
        this.mAlpha[0].setValue(this.mShowHours ? 255 : 0);
        this.mAlpha[1].setValue(this.mShowHours ? 0 : 255);
        this.mAlphaSelector[0][0].setValue(this.mShowHours ? 60 : 0);
        this.mAlphaSelector[0][1].setValue(this.mShowHours ? 255 : 0);
        this.mAlphaSelector[0][2].setValue(this.mShowHours ? 60 : 0);
        this.mAlphaSelector[1][0].setValue(this.mShowHours ? 0 : 60);
        IntHolder intHolder = this.mAlphaSelector[1][1];
        int i = 255;
        if (this.mShowHours) {
            i = 0;
        }
        intHolder.setValue(i);
        this.mAlphaSelector[1][2].setValue(this.mShowHours ? 0 : 60);
    }

    private void initHoursAndMinutesText() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 12) {
                return;
            }
            this.mHours12Texts[i2] = String.format("%d", Integer.valueOf(HOURS_NUMBERS[i2]));
            this.mOuterHours24Texts[i2] = String.format("%02d", Integer.valueOf(HOURS_NUMBERS_24[i2]));
            this.mInnerHours24Texts[i2] = String.format("%d", Integer.valueOf(HOURS_NUMBERS[i2]));
            this.mMinutesTexts[i2] = String.format("%02d", Integer.valueOf(MINUTES_NUMBERS[i2]));
            i = i2 + 1;
        }
    }

    private static void preparePrefer30sMap() {
        int i;
        int i2 = 0;
        int i3 = 1;
        int i4 = 8;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= 361) {
                return;
            }
            sSnapPrefer30sMap[i6] = i2;
            if (i3 == i4) {
                i2 += 6;
                i4 = i2 == 360 ? 7 : i2 % 30 == 0 ? 14 : 4;
                i = 1;
            } else {
                i = i3 + 1;
            }
            i3 = i;
            i5 = i6 + 1;
        }
    }

    private void setAnimationRadiusMultiplierHours(float f) {
        this.mAnimationRadiusMultiplier[0] = f;
        this.mAnimationRadiusMultiplier[2] = f;
    }

    private void setAnimationRadiusMultiplierMinutes(float f) {
        this.mAnimationRadiusMultiplier[1] = f;
    }

    private void setCurrentHourInternal(int i, boolean z, boolean z2) {
        int i2 = (i % 12) * 30;
        this.mSelectionDegrees[0] = i2;
        this.mSelectionDegrees[2] = i2;
        int i3 = (i == 0 || i % 24 < 12) ? 0 : 1;
        boolean z3 = this.mIs24HourMode && i >= 1 && i <= 12;
        if (this.mAmOrPm != i3 || this.mIsOnInnerCircle != z3) {
            this.mAmOrPm = i3;
            this.mIsOnInnerCircle = z3;
            initData();
            updateLayoutData();
            this.mTouchHelper.invalidateRoot();
        }
        invalidate();
        if (!z || this.mListener == null) {
            return;
        }
        this.mListener.onValueSelected(0, i, z2);
    }

    private void setCurrentMinuteInternal(int i, boolean z) {
        this.mSelectionDegrees[1] = (i % 60) * 6;
        invalidate();
        if (!z || this.mListener == null) {
            return;
        }
        this.mListener.onValueSelected(1, i, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int snapOnly30s(int i, int i2) {
        int i3 = (i / 30) * 30;
        int i4 = i3 + 30;
        if (i2 == 1) {
            return i4;
        }
        if (i2 != -1) {
            return i - i3 < i4 - i ? i3 : i4;
        }
        int i5 = i3;
        if (i == i3) {
            i5 = i3 - 30;
        }
        return i5;
    }

    private static int snapPrefer30s(int i) {
        if (sSnapPrefer30sMap == null) {
            return -1;
        }
        return sSnapPrefer30sMap[i];
    }

    private void startHoursToMinutesAnimation() {
        if (this.mHoursToMinutesAnims.size() == 0) {
            this.mHoursToMinutesAnims.add(getRadiusDisappearAnimator(this, "animationRadiusMultiplierHours", this.mInvalidateUpdateListener, this.mTransitionMidRadiusMultiplier, this.mTransitionEndRadiusMultiplier));
            this.mHoursToMinutesAnims.add(getFadeOutAnimator(this.mAlpha[0], 255, 0, this.mInvalidateUpdateListener));
            this.mHoursToMinutesAnims.add(getFadeOutAnimator(this.mAlphaSelector[0][0], 60, 0, this.mInvalidateUpdateListener));
            this.mHoursToMinutesAnims.add(getFadeOutAnimator(this.mAlphaSelector[0][1], 255, 0, this.mInvalidateUpdateListener));
            this.mHoursToMinutesAnims.add(getFadeOutAnimator(this.mAlphaSelector[0][2], 60, 0, this.mInvalidateUpdateListener));
            this.mHoursToMinutesAnims.add(getRadiusReappearAnimator(this, "animationRadiusMultiplierMinutes", this.mInvalidateUpdateListener, this.mTransitionMidRadiusMultiplier, this.mTransitionEndRadiusMultiplier));
            this.mHoursToMinutesAnims.add(getFadeInAnimator(this.mAlpha[1], 0, 255, this.mInvalidateUpdateListener));
            this.mHoursToMinutesAnims.add(getFadeInAnimator(this.mAlphaSelector[1][0], 0, 60, this.mInvalidateUpdateListener));
            this.mHoursToMinutesAnims.add(getFadeInAnimator(this.mAlphaSelector[1][1], 0, 255, this.mInvalidateUpdateListener));
            this.mHoursToMinutesAnims.add(getFadeInAnimator(this.mAlphaSelector[1][2], 0, 60, this.mInvalidateUpdateListener));
        }
        if (this.mTransition != null && this.mTransition.isRunning()) {
            this.mTransition.end();
        }
        this.mTransition = new AnimatorSet();
        this.mTransition.playTogether(this.mHoursToMinutesAnims);
        this.mTransition.start();
    }

    private void startMinutesToHoursAnimation() {
        if (this.mMinuteToHoursAnims.size() == 0) {
            this.mMinuteToHoursAnims.add(getRadiusDisappearAnimator(this, "animationRadiusMultiplierMinutes", this.mInvalidateUpdateListener, this.mTransitionMidRadiusMultiplier, this.mTransitionEndRadiusMultiplier));
            this.mMinuteToHoursAnims.add(getFadeOutAnimator(this.mAlpha[1], 255, 0, this.mInvalidateUpdateListener));
            this.mMinuteToHoursAnims.add(getFadeOutAnimator(this.mAlphaSelector[1][0], 60, 0, this.mInvalidateUpdateListener));
            this.mMinuteToHoursAnims.add(getFadeOutAnimator(this.mAlphaSelector[1][1], 255, 0, this.mInvalidateUpdateListener));
            this.mMinuteToHoursAnims.add(getFadeOutAnimator(this.mAlphaSelector[1][2], 60, 0, this.mInvalidateUpdateListener));
            this.mMinuteToHoursAnims.add(getRadiusReappearAnimator(this, "animationRadiusMultiplierHours", this.mInvalidateUpdateListener, this.mTransitionMidRadiusMultiplier, this.mTransitionEndRadiusMultiplier));
            this.mMinuteToHoursAnims.add(getFadeInAnimator(this.mAlpha[0], 0, 255, this.mInvalidateUpdateListener));
            this.mMinuteToHoursAnims.add(getFadeInAnimator(this.mAlphaSelector[0][0], 0, 60, this.mInvalidateUpdateListener));
            this.mMinuteToHoursAnims.add(getFadeInAnimator(this.mAlphaSelector[0][1], 0, 255, this.mInvalidateUpdateListener));
            this.mMinuteToHoursAnims.add(getFadeInAnimator(this.mAlphaSelector[0][2], 0, 60, this.mInvalidateUpdateListener));
        }
        if (this.mTransition != null && this.mTransition.isRunning()) {
            this.mTransition.end();
        }
        this.mTransition = new AnimatorSet();
        this.mTransition.playTogether(this.mMinuteToHoursAnims);
        this.mTransition.start();
    }

    private void updateLayoutData() {
        this.mXCenter = getWidth() / 2;
        this.mYCenter = getHeight() / 2;
        int min = Math.min(this.mXCenter, this.mYCenter);
        this.mCircleRadius[0] = min * this.mCircleRadiusMultiplier[0];
        this.mCircleRadius[2] = min * this.mCircleRadiusMultiplier[0];
        this.mCircleRadius[1] = min * this.mCircleRadiusMultiplier[1];
        this.mMinHypotenuseForInnerNumber = ((int) (this.mCircleRadius[0] * this.mNumbersRadiusMultiplier[2])) - this.mSelectionRadius[0];
        this.mMaxHypotenuseForOuterNumber = ((int) (this.mCircleRadius[0] * this.mNumbersRadiusMultiplier[0])) + this.mSelectionRadius[0];
        this.mHalfwayHypotenusePoint = (int) (this.mCircleRadius[0] * ((this.mNumbersRadiusMultiplier[0] + this.mNumbersRadiusMultiplier[2]) / 2.0f));
        this.mTextSize[0] = this.mCircleRadius[0] * this.mTextSizeMultiplier[0];
        this.mTextSize[1] = this.mCircleRadius[1] * this.mTextSizeMultiplier[1];
        if (this.mIs24HourMode) {
            this.mInnerTextSize = this.mCircleRadius[0] * this.mTextSizeMultiplier[2];
        }
        calculateGridSizesHours();
        calculateGridSizesMinutes();
        this.mSelectionRadius[0] = (int) (this.mCircleRadius[0] * this.mSelectionRadiusMultiplier);
        this.mSelectionRadius[2] = this.mSelectionRadius[0];
        this.mSelectionRadius[1] = (int) (this.mCircleRadius[1] * this.mSelectionRadiusMultiplier);
        this.mTouchHelper.invalidateRoot();
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (this.mTouchHelper.dispatchHoverEvent(motionEvent)) {
            return true;
        }
        return super.dispatchHoverEvent(motionEvent);
    }

    public int getAmOrPm() {
        return this.mAmOrPm;
    }

    public int getCurrentHour() {
        return getHourForDegrees(this.mSelectionDegrees[(this.mIsOnInnerCircle ? (byte) 2 : (byte) 0) == 1 ? 1 : 0], this.mIsOnInnerCircle);
    }

    public int getCurrentItemShowing() {
        return this.mShowHours ? 0 : 1;
    }

    public int getCurrentMinute() {
        return getMinuteForDegrees(this.mSelectionDegrees[1]);
    }

    public void initialize(int i, int i2, boolean z) {
        if (this.mIs24HourMode != z) {
            this.mIs24HourMode = z;
            initData();
        }
        setCurrentHourInternal(i, false, false);
        setCurrentMinuteInternal(i2, false);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.mInputEnabled) {
            canvas.save();
        } else {
            canvas.saveLayerAlpha(0.0f, 0.0f, getWidth(), getHeight(), this.mDisabledAlpha);
        }
        calculateGridSizesHours();
        calculateGridSizesMinutes();
        drawCircleBackground(canvas);
        drawSelector(canvas);
        drawTextElements(canvas, this.mTextSize[0], this.mTypeface, this.mOuterTextHours, this.mTextGridWidths[0], this.mTextGridHeights[0], this.mPaint[0], this.mColor[0], this.mAlpha[0].getValue());
        if (this.mIs24HourMode && this.mInnerTextHours != null) {
            drawTextElements(canvas, this.mInnerTextSize, this.mTypeface, this.mInnerTextHours, this.mInnerTextGridWidths, this.mInnerTextGridHeights, this.mPaint[0], this.mColor[0], this.mAlpha[0].getValue());
        }
        drawTextElements(canvas, this.mTextSize[1], this.mTypeface, this.mOuterTextMinutes, this.mTextGridWidths[1], this.mTextGridHeights[1], this.mPaint[1], this.mColor[1], this.mAlpha[1].getValue());
        drawCenter(canvas);
        canvas.restore();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        updateLayoutData();
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        int min = Math.min(size, size2);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(min, mode), View.MeasureSpec.makeMeasureSpec(min, mode2));
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        if (this.mInputEnabled) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 2 || actionMasked == 1 || actionMasked == 0) {
                boolean z2 = false;
                if (actionMasked == 0) {
                    this.mChangedDuringTouch = false;
                    z = false;
                } else {
                    z = false;
                    if (actionMasked == 1) {
                        z2 = true;
                        z = false;
                        if (!this.mChangedDuringTouch) {
                            z = true;
                            z2 = true;
                        }
                    }
                }
                this.mChangedDuringTouch |= handleTouchInput(motionEvent.getX(), motionEvent.getY(), z, z2);
                return true;
            }
            return true;
        }
        return true;
    }

    public void setAmOrPm(int i) {
        this.mAmOrPm = i % 2;
        invalidate();
        this.mTouchHelper.invalidateRoot();
    }

    public void setCurrentHour(int i) {
        setCurrentHourInternal(i, true, false);
    }

    public void setCurrentItemShowing(int i, boolean z) {
        switch (i) {
            case 0:
                showHours(z);
                return;
            case 1:
                showMinutes(z);
                return;
            default:
                Log.e(TAG, "ClockView does not support showing item " + i);
                return;
        }
    }

    public void setCurrentMinute(int i) {
        setCurrentMinuteInternal(i, true);
    }

    public void setInputEnabled(boolean z) {
        this.mInputEnabled = z;
        invalidate();
    }

    public void setOnValueSelectedListener(OnValueSelectedListener onValueSelectedListener) {
        this.mListener = onValueSelectedListener;
    }

    public void showHours(boolean z) {
        if (this.mShowHours) {
            return;
        }
        this.mShowHours = true;
        if (z) {
            startMinutesToHoursAnimation();
        }
        initData();
        updateLayoutData();
        invalidate();
    }

    public void showMinutes(boolean z) {
        if (this.mShowHours) {
            this.mShowHours = false;
            if (z) {
                startHoursToMinutesAnimation();
            }
            initData();
            updateLayoutData();
            invalidate();
        }
    }
}
