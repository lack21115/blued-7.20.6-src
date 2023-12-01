package android.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.text.format.Time;
import android.util.AttributeSet;
import android.util.IntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.android.internal.R;
import com.android.internal.widget.ExploreByTouchHelper;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Formatter;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-4181928-dex2jar.jar:android/widget/SimpleMonthView.class */
public class SimpleMonthView extends View {
    private static final int DAY_SEPARATOR_WIDTH = 1;
    private static final int DEFAULT_HEIGHT = 32;
    private static final int DEFAULT_NUM_DAYS = 7;
    private static final int DEFAULT_NUM_ROWS = 6;
    private static final int DEFAULT_SELECTED_DAY = -1;
    private static final int DEFAULT_WEEK_START = 1;
    private static final int MAX_NUM_ROWS = 6;
    private static final int MIN_HEIGHT = 10;
    private static final int SELECTED_CIRCLE_ALPHA = 60;
    private final Calendar mCalendar;
    private SimpleDateFormat mDayFormatter;
    private final Calendar mDayLabelCalendar;
    private Paint mDayNumberDisabledPaint;
    private Paint mDayNumberPaint;
    private Paint mDayNumberSelectedPaint;
    private int mDayOfWeekStart;
    private String mDayOfWeekTypeface;
    private final int mDaySelectedCircleSize;
    private int mDisabledTextColor;
    private int mEnabledDayEnd;
    private int mEnabledDayStart;
    private final Formatter mFormatter;
    private boolean mHasToday;
    private boolean mLockAccessibilityDelegate;
    private final int mMiniDayNumberTextSize;
    private int mMonth;
    private Paint mMonthDayLabelPaint;
    private final int mMonthDayLabelTextSize;
    private final int mMonthHeaderSize;
    private final int mMonthLabelTextSize;
    private Paint mMonthTitlePaint;
    private String mMonthTitleTypeface;
    private int mNormalTextColor;
    private int mNumCells;
    private int mNumDays;
    private int mNumRows;
    private OnDayClickListener mOnDayClickListener;
    private int mPadding;
    private int mRowHeight;
    private int mSelectedDay;
    private int mSelectedDayColor;
    private final StringBuilder mStringBuilder;
    private int mToday;
    private final MonthViewTouchHelper mTouchHelper;
    private int mWeekStart;
    private int mWidth;
    private int mYear;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/SimpleMonthView$MonthViewTouchHelper.class */
    public class MonthViewTouchHelper extends ExploreByTouchHelper {
        private static final String DATE_FORMAT = "dd MMMM yyyy";
        private final Calendar mTempCalendar;
        private final Rect mTempRect;

        public MonthViewTouchHelper(View view) {
            super(view);
            this.mTempRect = new Rect();
            this.mTempCalendar = Calendar.getInstance();
        }

        private void getItemBounds(int i, Rect rect) {
            int i2 = SimpleMonthView.this.mPadding;
            int i3 = SimpleMonthView.this.mMonthHeaderSize;
            int i4 = SimpleMonthView.this.mRowHeight;
            int i5 = (SimpleMonthView.this.mWidth - (SimpleMonthView.this.mPadding * 2)) / SimpleMonthView.this.mNumDays;
            int findDayOffset = (i - 1) + SimpleMonthView.this.findDayOffset();
            int i6 = findDayOffset / SimpleMonthView.this.mNumDays;
            int i7 = i2 + ((findDayOffset % SimpleMonthView.this.mNumDays) * i5);
            int i8 = i3 + (i6 * i4);
            rect.set(i7, i8, i7 + i5, i8 + i4);
        }

        private CharSequence getItemDescription(int i) {
            this.mTempCalendar.set(SimpleMonthView.this.mYear, SimpleMonthView.this.mMonth, i);
            CharSequence format = DateFormat.format(DATE_FORMAT, this.mTempCalendar.getTimeInMillis());
            String str = format;
            if (i == SimpleMonthView.this.mSelectedDay) {
                str = SimpleMonthView.this.getContext().getString(R.string.item_is_selected, format);
            }
            return str;
        }

        public void clearFocusedVirtualView() {
            int focusedVirtualView = getFocusedVirtualView();
            if (focusedVirtualView != Integer.MIN_VALUE) {
                getAccessibilityNodeProvider(SimpleMonthView.this).performAction(focusedVirtualView, 128, null);
            }
        }

        @Override // com.android.internal.widget.ExploreByTouchHelper
        protected int getVirtualViewAt(float f, float f2) {
            int dayFromLocation = SimpleMonthView.this.getDayFromLocation(f, f2);
            if (dayFromLocation >= 0) {
                return dayFromLocation;
            }
            return Integer.MIN_VALUE;
        }

        @Override // com.android.internal.widget.ExploreByTouchHelper
        protected void getVisibleVirtualViews(IntArray intArray) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 > SimpleMonthView.this.mNumCells) {
                    return;
                }
                intArray.add(i2);
                i = i2 + 1;
            }
        }

        @Override // com.android.internal.widget.ExploreByTouchHelper
        protected boolean onPerformActionForVirtualView(int i, int i2, Bundle bundle) {
            switch (i2) {
                case 16:
                    SimpleMonthView.this.onDayClick(i);
                    return true;
                default:
                    return false;
            }
        }

        @Override // com.android.internal.widget.ExploreByTouchHelper
        protected void onPopulateEventForVirtualView(int i, AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.setContentDescription(getItemDescription(i));
        }

        @Override // com.android.internal.widget.ExploreByTouchHelper
        protected void onPopulateNodeForVirtualView(int i, AccessibilityNodeInfo accessibilityNodeInfo) {
            getItemBounds(i, this.mTempRect);
            accessibilityNodeInfo.setContentDescription(getItemDescription(i));
            accessibilityNodeInfo.setBoundsInParent(this.mTempRect);
            accessibilityNodeInfo.addAction(16);
            if (i == SimpleMonthView.this.mSelectedDay) {
                accessibilityNodeInfo.setSelected(true);
            }
        }

        public void setFocusedVirtualView(int i) {
            getAccessibilityNodeProvider(SimpleMonthView.this).performAction(i, 64, null);
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/SimpleMonthView$OnDayClickListener.class */
    public interface OnDayClickListener {
        void onDayClick(SimpleMonthView simpleMonthView, Calendar calendar);
    }

    public SimpleMonthView(Context context) {
        this(context, null);
    }

    public SimpleMonthView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.datePickerStyle);
    }

    public SimpleMonthView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public SimpleMonthView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mDayFormatter = new SimpleDateFormat("EEEEE", Locale.getDefault());
        this.mPadding = 0;
        this.mRowHeight = 32;
        this.mHasToday = false;
        this.mSelectedDay = -1;
        this.mToday = -1;
        this.mWeekStart = 1;
        this.mNumDays = 7;
        this.mNumCells = this.mNumDays;
        this.mDayOfWeekStart = 0;
        this.mEnabledDayStart = 1;
        this.mEnabledDayEnd = 31;
        this.mCalendar = Calendar.getInstance();
        this.mDayLabelCalendar = Calendar.getInstance();
        this.mNumRows = 6;
        Resources resources = context.getResources();
        this.mDayOfWeekTypeface = resources.getString(R.string.day_of_week_label_typeface);
        this.mMonthTitleTypeface = resources.getString(R.string.sans_serif);
        this.mStringBuilder = new StringBuilder(50);
        this.mFormatter = new Formatter(this.mStringBuilder, Locale.getDefault());
        this.mMiniDayNumberTextSize = resources.getDimensionPixelSize(R.dimen.datepicker_day_number_size);
        this.mMonthLabelTextSize = resources.getDimensionPixelSize(R.dimen.datepicker_month_label_size);
        this.mMonthDayLabelTextSize = resources.getDimensionPixelSize(R.dimen.datepicker_month_day_label_text_size);
        this.mMonthHeaderSize = resources.getDimensionPixelOffset(R.dimen.datepicker_month_list_item_header_height);
        this.mDaySelectedCircleSize = resources.getDimensionPixelSize(R.dimen.datepicker_day_number_select_circle_radius);
        this.mRowHeight = (resources.getDimensionPixelOffset(R.dimen.datepicker_view_animator_height) - this.mMonthHeaderSize) / 6;
        this.mTouchHelper = new MonthViewTouchHelper(this);
        setAccessibilityDelegate(this.mTouchHelper);
        setImportantForAccessibility(1);
        this.mLockAccessibilityDelegate = true;
        initView();
    }

    private int calculateNumRows() {
        int findDayOffset = findDayOffset();
        return ((this.mNumCells + findDayOffset) % this.mNumDays > 0 ? 1 : 0) + ((this.mNumCells + findDayOffset) / this.mNumDays);
    }

    private void drawDays(Canvas canvas) {
        int i = (((this.mRowHeight + this.mMiniDayNumberTextSize) / 2) - 1) + this.mMonthHeaderSize;
        int i2 = (this.mWidth - (this.mPadding * 2)) / (this.mNumDays * 2);
        int findDayOffset = findDayOffset();
        int i3 = 1;
        while (i3 <= this.mNumCells) {
            int i4 = (((findDayOffset * 2) + 1) * i2) + this.mPadding;
            if (this.mSelectedDay == i3) {
                canvas.drawCircle(i4, i - (this.mMiniDayNumberTextSize / 3), this.mDaySelectedCircleSize, this.mDayNumberSelectedPaint);
            }
            if (this.mHasToday && this.mToday == i3) {
                this.mDayNumberPaint.setColor(this.mSelectedDayColor);
            } else {
                this.mDayNumberPaint.setColor(this.mNormalTextColor);
            }
            canvas.drawText(String.format("%d", Integer.valueOf(i3)), i4, i, (i3 < this.mEnabledDayStart || i3 > this.mEnabledDayEnd) ? this.mDayNumberDisabledPaint : this.mDayNumberPaint);
            int i5 = findDayOffset + 1;
            findDayOffset = i5;
            int i6 = i;
            if (i5 == this.mNumDays) {
                findDayOffset = 0;
                i6 = i + this.mRowHeight;
            }
            i3++;
            i = i6;
        }
    }

    private void drawMonthTitle(Canvas canvas) {
        canvas.drawText(getMonthAndYearString(), (this.mWidth + (this.mPadding * 2)) / 2.0f, (this.mMonthHeaderSize - this.mMonthDayLabelTextSize) / 2.0f, this.mMonthTitlePaint);
    }

    private void drawWeekDayLabels(Canvas canvas) {
        int i = this.mMonthHeaderSize;
        int i2 = this.mMonthDayLabelTextSize / 2;
        int i3 = (this.mWidth - (this.mPadding * 2)) / (this.mNumDays * 2);
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= this.mNumDays) {
                return;
            }
            int i6 = this.mWeekStart;
            this.mDayLabelCalendar.set(7, (i6 + i5) % this.mNumDays);
            canvas.drawText(this.mDayFormatter.format(this.mDayLabelCalendar.getTime()), (((i5 * 2) + 1) * i3) + this.mPadding, i - i2, this.mMonthDayLabelPaint);
            i4 = i5 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int findDayOffset() {
        return (this.mDayOfWeekStart < this.mWeekStart ? this.mDayOfWeekStart + this.mNumDays : this.mDayOfWeekStart) - this.mWeekStart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getDayFromLocation(float f, float f2) {
        int i;
        int i2 = this.mPadding;
        if (f < i2 || f > this.mWidth - this.mPadding) {
            i = -1;
        } else {
            int findDayOffset = (((int) (((f - i2) * this.mNumDays) / ((this.mWidth - i2) - this.mPadding))) - findDayOffset()) + 1 + (this.mNumDays * (((int) (f2 - this.mMonthHeaderSize)) / this.mRowHeight));
            if (findDayOffset < 1) {
                return -1;
            }
            i = findDayOffset;
            if (findDayOffset > this.mNumCells) {
                return -1;
            }
        }
        return i;
    }

    private static int getDaysInMonth(int i, int i2) {
        switch (i) {
            case 0:
            case 2:
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:
                return 31;
            case 1:
                return i2 % 4 == 0 ? 29 : 28;
            case 3:
            case 5:
            case 8:
            case 10:
                return 30;
            default:
                throw new IllegalArgumentException("Invalid Month");
        }
    }

    private String getMonthAndYearString() {
        this.mStringBuilder.setLength(0);
        long timeInMillis = this.mCalendar.getTimeInMillis();
        return DateUtils.formatDateRange(getContext(), this.mFormatter, timeInMillis, timeInMillis, 52, Time.getCurrentTimezone()).toString();
    }

    private void initView() {
        this.mMonthTitlePaint = new Paint();
        this.mMonthTitlePaint.setAntiAlias(true);
        this.mMonthTitlePaint.setColor(this.mNormalTextColor);
        this.mMonthTitlePaint.setTextSize(this.mMonthLabelTextSize);
        this.mMonthTitlePaint.setTypeface(Typeface.create(this.mMonthTitleTypeface, 1));
        this.mMonthTitlePaint.setTextAlign(Paint.Align.CENTER);
        this.mMonthTitlePaint.setStyle(Paint.Style.FILL);
        this.mMonthTitlePaint.setFakeBoldText(true);
        this.mMonthDayLabelPaint = new Paint();
        this.mMonthDayLabelPaint.setAntiAlias(true);
        this.mMonthDayLabelPaint.setColor(this.mNormalTextColor);
        this.mMonthDayLabelPaint.setTextSize(this.mMonthDayLabelTextSize);
        this.mMonthDayLabelPaint.setTypeface(Typeface.create(this.mDayOfWeekTypeface, 0));
        this.mMonthDayLabelPaint.setTextAlign(Paint.Align.CENTER);
        this.mMonthDayLabelPaint.setStyle(Paint.Style.FILL);
        this.mMonthDayLabelPaint.setFakeBoldText(true);
        this.mDayNumberSelectedPaint = new Paint();
        this.mDayNumberSelectedPaint.setAntiAlias(true);
        this.mDayNumberSelectedPaint.setColor(this.mSelectedDayColor);
        this.mDayNumberSelectedPaint.setAlpha(60);
        this.mDayNumberSelectedPaint.setTextAlign(Paint.Align.CENTER);
        this.mDayNumberSelectedPaint.setStyle(Paint.Style.FILL);
        this.mDayNumberSelectedPaint.setFakeBoldText(true);
        this.mDayNumberPaint = new Paint();
        this.mDayNumberPaint.setAntiAlias(true);
        this.mDayNumberPaint.setTextSize(this.mMiniDayNumberTextSize);
        this.mDayNumberPaint.setTextAlign(Paint.Align.CENTER);
        this.mDayNumberPaint.setStyle(Paint.Style.FILL);
        this.mDayNumberPaint.setFakeBoldText(false);
        this.mDayNumberDisabledPaint = new Paint();
        this.mDayNumberDisabledPaint.setAntiAlias(true);
        this.mDayNumberDisabledPaint.setColor(this.mDisabledTextColor);
        this.mDayNumberDisabledPaint.setTextSize(this.mMiniDayNumberTextSize);
        this.mDayNumberDisabledPaint.setTextAlign(Paint.Align.CENTER);
        this.mDayNumberDisabledPaint.setStyle(Paint.Style.FILL);
        this.mDayNumberDisabledPaint.setFakeBoldText(false);
    }

    private static boolean isValidDayOfWeek(int i) {
        return i >= 1 && i <= 7;
    }

    private static boolean isValidMonth(int i) {
        return i >= 0 && i <= 11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDayClick(int i) {
        if (this.mOnDayClickListener != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(this.mYear, this.mMonth, i);
            this.mOnDayClickListener.onDayClick(this, calendar);
        }
        this.mTouchHelper.sendEventForVirtualView(i, 1);
    }

    private boolean sameDay(int i, Time time) {
        return this.mYear == time.year && this.mMonth == time.month && i == time.monthDay;
    }

    @Override // android.view.View
    public void clearAccessibilityFocus() {
        this.mTouchHelper.clearFocusedVirtualView();
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (this.mTouchHelper.dispatchHoverEvent(motionEvent)) {
            return true;
        }
        return super.dispatchHoverEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Calendar getAccessibilityFocus() {
        int focusedVirtualView = this.mTouchHelper.getFocusedVirtualView();
        Calendar calendar = null;
        if (focusedVirtualView >= 0) {
            calendar = Calendar.getInstance();
            calendar.set(this.mYear, this.mMonth, focusedVirtualView);
        }
        return calendar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mDayFormatter = new SimpleDateFormat("EEEEE", configuration.locale);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        drawMonthTitle(canvas);
        drawWeekDayLabels(canvas);
        drawDays(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(View.MeasureSpec.getSize(i), (this.mRowHeight * this.mNumRows) + this.mMonthHeaderSize);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.mWidth = i;
        this.mTouchHelper.invalidateRoot();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                int dayFromLocation = getDayFromLocation(motionEvent.getX(), motionEvent.getY());
                if (dayFromLocation >= 0) {
                    onDayClick(dayFromLocation);
                    return true;
                }
                return true;
            default:
                return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean restoreAccessibilityFocus(Calendar calendar) {
        if (calendar.get(1) == this.mYear && calendar.get(2) == this.mMonth && calendar.get(5) <= this.mNumCells) {
            this.mTouchHelper.setFocusedVirtualView(calendar.get(5));
            return true;
        }
        return false;
    }

    public void reuse() {
        this.mNumRows = 6;
        requestLayout();
    }

    @Override // android.view.View
    public void setAccessibilityDelegate(View.AccessibilityDelegate accessibilityDelegate) {
        if (this.mLockAccessibilityDelegate) {
            return;
        }
        super.setAccessibilityDelegate(accessibilityDelegate);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMonthParams(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.mRowHeight < 10) {
            this.mRowHeight = 10;
        }
        this.mSelectedDay = i;
        if (isValidMonth(i2)) {
            this.mMonth = i2;
        }
        this.mYear = i3;
        Time time = new Time(Time.getCurrentTimezone());
        time.setToNow();
        this.mHasToday = false;
        this.mToday = -1;
        this.mCalendar.set(2, this.mMonth);
        this.mCalendar.set(1, this.mYear);
        this.mCalendar.set(5, 1);
        this.mDayOfWeekStart = this.mCalendar.get(7);
        if (isValidDayOfWeek(i4)) {
            this.mWeekStart = i4;
        } else {
            this.mWeekStart = this.mCalendar.getFirstDayOfWeek();
        }
        if (i5 > 0 && i6 < 32) {
            this.mEnabledDayStart = i5;
        }
        if (i6 > 0 && i6 < 32 && i6 >= i5) {
            this.mEnabledDayEnd = i6;
        }
        this.mNumCells = getDaysInMonth(this.mMonth, this.mYear);
        int i7 = 0;
        while (true) {
            int i8 = i7;
            if (i8 >= this.mNumCells) {
                this.mNumRows = calculateNumRows();
                this.mTouchHelper.invalidateRoot();
                return;
            }
            int i9 = i8 + 1;
            if (sameDay(i9, time)) {
                this.mHasToday = true;
                this.mToday = i9;
            }
            i7 = i8 + 1;
        }
    }

    public void setOnDayClickListener(OnDayClickListener onDayClickListener) {
        this.mOnDayClickListener = onDayClickListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTextColor(ColorStateList colorStateList) {
        Resources resources = getContext().getResources();
        this.mNormalTextColor = colorStateList.getColorForState(ENABLED_STATE_SET, resources.getColor(R.color.datepicker_default_normal_text_color_holo_light));
        this.mMonthTitlePaint.setColor(this.mNormalTextColor);
        this.mMonthDayLabelPaint.setColor(this.mNormalTextColor);
        this.mDisabledTextColor = colorStateList.getColorForState(EMPTY_STATE_SET, resources.getColor(R.color.datepicker_default_disabled_text_color_holo_light));
        this.mDayNumberDisabledPaint.setColor(this.mDisabledTextColor);
        this.mSelectedDayColor = colorStateList.getColorForState(ENABLED_SELECTED_STATE_SET, resources.getColor(R.color.holo_blue_light));
        this.mDayNumberSelectedPaint.setColor(this.mSelectedDayColor);
        this.mDayNumberSelectedPaint.setAlpha(60);
    }
}
