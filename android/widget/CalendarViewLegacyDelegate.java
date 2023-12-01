package android.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CalendarView;
import com.android.internal.R;
import com.google.android.material.timepicker.TimeModel;
import java.util.Calendar;
import java.util.Locale;
import libcore.icu.LocaleData;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-4181928-dex2jar.jar:android/widget/CalendarViewLegacyDelegate.class */
public class CalendarViewLegacyDelegate extends CalendarView.AbstractCalendarViewDelegate {
    private static final int ADJUSTMENT_SCROLL_DURATION = 500;
    private static final int DAYS_PER_WEEK = 7;
    private static final int DEFAULT_DATE_TEXT_SIZE = 14;
    private static final int DEFAULT_SHOWN_WEEK_COUNT = 6;
    private static final boolean DEFAULT_SHOW_WEEK_NUMBER = true;
    private static final int DEFAULT_WEEK_DAY_TEXT_APPEARANCE_RES_ID = -1;
    private static final int GOTO_SCROLL_DURATION = 1000;
    private static final long MILLIS_IN_DAY = 86400000;
    private static final long MILLIS_IN_WEEK = 604800000;
    private static final int SCROLL_CHANGE_DELAY = 40;
    private static final int SCROLL_HYST_WEEKS = 2;
    private static final int UNSCALED_BOTTOM_BUFFER = 20;
    private static final int UNSCALED_LIST_SCROLL_TOP_OFFSET = 2;
    private static final int UNSCALED_SELECTED_DATE_VERTICAL_BAR_WIDTH = 6;
    private static final int UNSCALED_WEEK_MIN_VISIBLE_HEIGHT = 12;
    private static final int UNSCALED_WEEK_SEPARATOR_LINE_WIDTH = 1;
    private WeeksAdapter mAdapter;
    private int mBottomBuffer;
    private int mCurrentMonthDisplayed;
    private int mCurrentScrollState;
    private int mDateTextAppearanceResId;
    private int mDateTextSize;
    private ViewGroup mDayNamesHeader;
    private String[] mDayNamesLong;
    private String[] mDayNamesShort;
    private int mDaysPerWeek;
    private Calendar mFirstDayOfMonth;
    private int mFirstDayOfWeek;
    private int mFocusedMonthDateColor;
    private float mFriction;
    private boolean mIsScrollingUp;
    private int mListScrollTopOffset;
    private ListView mListView;
    private Calendar mMaxDate;
    private Calendar mMinDate;
    private TextView mMonthName;
    private CalendarView.OnDateChangeListener mOnDateChangeListener;
    private long mPreviousScrollPosition;
    private int mPreviousScrollState;
    private ScrollStateRunnable mScrollStateChangedRunnable;
    private Drawable mSelectedDateVerticalBar;
    private final int mSelectedDateVerticalBarWidth;
    private int mSelectedWeekBackgroundColor;
    private boolean mShowWeekNumber;
    private int mShownWeekCount;
    private Calendar mTempDate;
    private int mUnfocusedMonthDateColor;
    private float mVelocityScale;
    private int mWeekDayTextAppearanceResId;
    private int mWeekMinVisibleHeight;
    private int mWeekNumberColor;
    private int mWeekSeparatorLineColor;
    private final int mWeekSeperatorLineWidth;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/CalendarViewLegacyDelegate$ScrollStateRunnable.class */
    public class ScrollStateRunnable implements Runnable {
        private int mNewState;
        private AbsListView mView;

        private ScrollStateRunnable() {
        }

        public void doScrollStateChange(AbsListView absListView, int i) {
            this.mView = absListView;
            this.mNewState = i;
            CalendarViewLegacyDelegate.this.mDelegator.removeCallbacks(this);
            CalendarViewLegacyDelegate.this.mDelegator.postDelayed(this, 40L);
        }

        @Override // java.lang.Runnable
        public void run() {
            CalendarViewLegacyDelegate.this.mCurrentScrollState = this.mNewState;
            if (this.mNewState == 0 && CalendarViewLegacyDelegate.this.mPreviousScrollState != 0) {
                View childAt = this.mView.getChildAt(0);
                if (childAt == null) {
                    return;
                }
                int bottom = childAt.getBottom() - CalendarViewLegacyDelegate.this.mListScrollTopOffset;
                if (bottom > CalendarViewLegacyDelegate.this.mListScrollTopOffset) {
                    if (CalendarViewLegacyDelegate.this.mIsScrollingUp) {
                        this.mView.smoothScrollBy(bottom - childAt.getHeight(), 500);
                    } else {
                        this.mView.smoothScrollBy(bottom, 500);
                    }
                }
            }
            CalendarViewLegacyDelegate.this.mPreviousScrollState = this.mNewState;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/CalendarViewLegacyDelegate$WeekView.class */
    public class WeekView extends View {
        private String[] mDayNumbers;
        private final Paint mDrawPaint;
        private Calendar mFirstDay;
        private boolean[] mFocusDay;
        private boolean mHasFocusedDay;
        private boolean mHasSelectedDay;
        private boolean mHasUnfocusedDay;
        private int mHeight;
        private int mLastWeekDayMonth;
        private final Paint mMonthNumDrawPaint;
        private int mMonthOfFirstWeekDay;
        private int mNumCells;
        private int mSelectedDay;
        private int mSelectedLeft;
        private int mSelectedRight;
        private final Rect mTempRect;
        private int mWeek;
        private int mWidth;

        public WeekView(Context context) {
            super(context);
            this.mTempRect = new Rect();
            this.mDrawPaint = new Paint();
            this.mMonthNumDrawPaint = new Paint();
            this.mMonthOfFirstWeekDay = -1;
            this.mLastWeekDayMonth = -1;
            this.mWeek = -1;
            this.mHasSelectedDay = false;
            this.mSelectedDay = -1;
            this.mSelectedLeft = -1;
            this.mSelectedRight = -1;
            initilaizePaints();
        }

        private void drawBackground(Canvas canvas) {
            int i = 0;
            if (this.mHasSelectedDay) {
                this.mDrawPaint.setColor(CalendarViewLegacyDelegate.this.mSelectedWeekBackgroundColor);
                this.mTempRect.top = CalendarViewLegacyDelegate.this.mWeekSeperatorLineWidth;
                this.mTempRect.bottom = this.mHeight;
                boolean isLayoutRtl = isLayoutRtl();
                if (isLayoutRtl) {
                    this.mTempRect.left = 0;
                    this.mTempRect.right = this.mSelectedLeft - 2;
                } else {
                    Rect rect = this.mTempRect;
                    if (CalendarViewLegacyDelegate.this.mShowWeekNumber) {
                        i = this.mWidth / this.mNumCells;
                    }
                    rect.left = i;
                    this.mTempRect.right = this.mSelectedLeft - 2;
                }
                canvas.drawRect(this.mTempRect, this.mDrawPaint);
                if (isLayoutRtl) {
                    this.mTempRect.left = this.mSelectedRight + 3;
                    this.mTempRect.right = CalendarViewLegacyDelegate.this.mShowWeekNumber ? this.mWidth - (this.mWidth / this.mNumCells) : this.mWidth;
                } else {
                    this.mTempRect.left = this.mSelectedRight + 3;
                    this.mTempRect.right = this.mWidth;
                }
                canvas.drawRect(this.mTempRect, this.mDrawPaint);
            }
        }

        private void drawSelectedDateVerticalBars(Canvas canvas) {
            if (this.mHasSelectedDay) {
                CalendarViewLegacyDelegate.this.mSelectedDateVerticalBar.setBounds(this.mSelectedLeft - (CalendarViewLegacyDelegate.this.mSelectedDateVerticalBarWidth / 2), CalendarViewLegacyDelegate.this.mWeekSeperatorLineWidth, this.mSelectedLeft + (CalendarViewLegacyDelegate.this.mSelectedDateVerticalBarWidth / 2), this.mHeight);
                CalendarViewLegacyDelegate.this.mSelectedDateVerticalBar.draw(canvas);
                CalendarViewLegacyDelegate.this.mSelectedDateVerticalBar.setBounds(this.mSelectedRight - (CalendarViewLegacyDelegate.this.mSelectedDateVerticalBarWidth / 2), CalendarViewLegacyDelegate.this.mWeekSeperatorLineWidth, this.mSelectedRight + (CalendarViewLegacyDelegate.this.mSelectedDateVerticalBarWidth / 2), this.mHeight);
                CalendarViewLegacyDelegate.this.mSelectedDateVerticalBar.draw(canvas);
            }
        }

        private void drawWeekNumbersAndDates(Canvas canvas) {
            int textSize = ((int) ((this.mHeight + this.mDrawPaint.getTextSize()) / 2.0f)) - CalendarViewLegacyDelegate.this.mWeekSeperatorLineWidth;
            int i = this.mNumCells;
            int i2 = i * 2;
            this.mDrawPaint.setTextAlign(Paint.Align.CENTER);
            this.mDrawPaint.setTextSize(CalendarViewLegacyDelegate.this.mDateTextSize);
            if (isLayoutRtl()) {
                for (int i3 = 0; i3 < i - 1; i3++) {
                    this.mMonthNumDrawPaint.setColor(this.mFocusDay[i3] ? CalendarViewLegacyDelegate.this.mFocusedMonthDateColor : CalendarViewLegacyDelegate.this.mUnfocusedMonthDateColor);
                    canvas.drawText(this.mDayNumbers[(i - 1) - i3], (((i3 * 2) + 1) * this.mWidth) / i2, textSize, this.mMonthNumDrawPaint);
                }
                if (CalendarViewLegacyDelegate.this.mShowWeekNumber) {
                    this.mDrawPaint.setColor(CalendarViewLegacyDelegate.this.mWeekNumberColor);
                    canvas.drawText(this.mDayNumbers[0], this.mWidth - (this.mWidth / i2), textSize, this.mDrawPaint);
                    return;
                }
                return;
            }
            int i4 = 0;
            if (CalendarViewLegacyDelegate.this.mShowWeekNumber) {
                this.mDrawPaint.setColor(CalendarViewLegacyDelegate.this.mWeekNumberColor);
                canvas.drawText(this.mDayNumbers[0], this.mWidth / i2, textSize, this.mDrawPaint);
                i4 = 0 + 1;
            }
            while (i4 < i) {
                this.mMonthNumDrawPaint.setColor(this.mFocusDay[i4] ? CalendarViewLegacyDelegate.this.mFocusedMonthDateColor : CalendarViewLegacyDelegate.this.mUnfocusedMonthDateColor);
                canvas.drawText(this.mDayNumbers[i4], (((i4 * 2) + 1) * this.mWidth) / i2, textSize, this.mMonthNumDrawPaint);
                i4++;
            }
        }

        private void drawWeekSeparators(Canvas canvas) {
            float f;
            float f2;
            int firstVisiblePosition = CalendarViewLegacyDelegate.this.mListView.getFirstVisiblePosition();
            int i = firstVisiblePosition;
            if (CalendarViewLegacyDelegate.this.mListView.getChildAt(0).getTop() < 0) {
                i = firstVisiblePosition + 1;
            }
            if (i == this.mWeek) {
                return;
            }
            this.mDrawPaint.setColor(CalendarViewLegacyDelegate.this.mWeekSeparatorLineColor);
            this.mDrawPaint.setStrokeWidth(CalendarViewLegacyDelegate.this.mWeekSeperatorLineWidth);
            if (isLayoutRtl()) {
                f = 0.0f;
                f2 = CalendarViewLegacyDelegate.this.mShowWeekNumber ? this.mWidth - (this.mWidth / this.mNumCells) : this.mWidth;
            } else {
                f = CalendarViewLegacyDelegate.this.mShowWeekNumber ? this.mWidth / this.mNumCells : 0.0f;
                f2 = this.mWidth;
            }
            canvas.drawLine(f, 0.0f, f2, 0.0f, this.mDrawPaint);
        }

        private void initilaizePaints() {
            this.mDrawPaint.setFakeBoldText(false);
            this.mDrawPaint.setAntiAlias(true);
            this.mDrawPaint.setStyle(Paint.Style.FILL);
            this.mMonthNumDrawPaint.setFakeBoldText(true);
            this.mMonthNumDrawPaint.setAntiAlias(true);
            this.mMonthNumDrawPaint.setStyle(Paint.Style.FILL);
            this.mMonthNumDrawPaint.setTextAlign(Paint.Align.CENTER);
            this.mMonthNumDrawPaint.setTextSize(CalendarViewLegacyDelegate.this.mDateTextSize);
        }

        private void updateSelectionPositions() {
            if (this.mHasSelectedDay) {
                boolean isLayoutRtl = isLayoutRtl();
                int i = this.mSelectedDay - CalendarViewLegacyDelegate.this.mFirstDayOfWeek;
                int i2 = i;
                if (i < 0) {
                    i2 = i + 7;
                }
                int i3 = i2;
                if (CalendarViewLegacyDelegate.this.mShowWeekNumber) {
                    i3 = i2;
                    if (!isLayoutRtl) {
                        i3 = i2 + 1;
                    }
                }
                if (isLayoutRtl) {
                    this.mSelectedLeft = (((CalendarViewLegacyDelegate.this.mDaysPerWeek - 1) - i3) * this.mWidth) / this.mNumCells;
                } else {
                    this.mSelectedLeft = (this.mWidth * i3) / this.mNumCells;
                }
                this.mSelectedRight = this.mSelectedLeft + (this.mWidth / this.mNumCells);
            }
        }

        public boolean getDayFromLocation(float f, Calendar calendar) {
            int i;
            int i2;
            boolean isLayoutRtl = isLayoutRtl();
            if (isLayoutRtl) {
                i = 0;
                i2 = CalendarViewLegacyDelegate.this.mShowWeekNumber ? this.mWidth - (this.mWidth / this.mNumCells) : this.mWidth;
            } else {
                i = CalendarViewLegacyDelegate.this.mShowWeekNumber ? this.mWidth / this.mNumCells : 0;
                i2 = this.mWidth;
            }
            if (f < i || f > i2) {
                calendar.clear();
                return false;
            }
            int i3 = (int) (((f - i) * CalendarViewLegacyDelegate.this.mDaysPerWeek) / (i2 - i));
            int i4 = i3;
            if (isLayoutRtl) {
                i4 = (CalendarViewLegacyDelegate.this.mDaysPerWeek - 1) - i3;
            }
            calendar.setTimeInMillis(this.mFirstDay.getTimeInMillis());
            calendar.add(5, i4);
            return true;
        }

        public Calendar getFirstDay() {
            return this.mFirstDay;
        }

        public int getMonthOfFirstWeekDay() {
            return this.mMonthOfFirstWeekDay;
        }

        public int getMonthOfLastWeekDay() {
            return this.mLastWeekDayMonth;
        }

        public void init(int i, int i2, int i3) {
            this.mSelectedDay = i2;
            this.mHasSelectedDay = this.mSelectedDay != -1;
            this.mNumCells = CalendarViewLegacyDelegate.this.mShowWeekNumber ? CalendarViewLegacyDelegate.this.mDaysPerWeek + 1 : CalendarViewLegacyDelegate.this.mDaysPerWeek;
            this.mWeek = i;
            CalendarViewLegacyDelegate.this.mTempDate.setTimeInMillis(CalendarViewLegacyDelegate.this.mMinDate.getTimeInMillis());
            CalendarViewLegacyDelegate.this.mTempDate.add(3, this.mWeek);
            CalendarViewLegacyDelegate.this.mTempDate.setFirstDayOfWeek(CalendarViewLegacyDelegate.this.mFirstDayOfWeek);
            this.mDayNumbers = new String[this.mNumCells];
            this.mFocusDay = new boolean[this.mNumCells];
            int i4 = 0;
            if (CalendarViewLegacyDelegate.this.mShowWeekNumber) {
                this.mDayNumbers[0] = String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, Integer.valueOf(CalendarViewLegacyDelegate.this.mTempDate.get(3)));
                i4 = 0 + 1;
            }
            CalendarViewLegacyDelegate.this.mTempDate.add(5, CalendarViewLegacyDelegate.this.mFirstDayOfWeek - CalendarViewLegacyDelegate.this.mTempDate.get(7));
            this.mFirstDay = (Calendar) CalendarViewLegacyDelegate.this.mTempDate.clone();
            this.mMonthOfFirstWeekDay = CalendarViewLegacyDelegate.this.mTempDate.get(2);
            this.mHasUnfocusedDay = true;
            while (i4 < this.mNumCells) {
                boolean z = CalendarViewLegacyDelegate.this.mTempDate.get(2) == i3;
                this.mFocusDay[i4] = z;
                this.mHasFocusedDay |= z;
                this.mHasUnfocusedDay = (!z) & this.mHasUnfocusedDay;
                if (CalendarViewLegacyDelegate.this.mTempDate.before(CalendarViewLegacyDelegate.this.mMinDate) || CalendarViewLegacyDelegate.this.mTempDate.after(CalendarViewLegacyDelegate.this.mMaxDate)) {
                    this.mDayNumbers[i4] = "";
                } else {
                    this.mDayNumbers[i4] = String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, Integer.valueOf(CalendarViewLegacyDelegate.this.mTempDate.get(5)));
                }
                CalendarViewLegacyDelegate.this.mTempDate.add(5, 1);
                i4++;
            }
            if (CalendarViewLegacyDelegate.this.mTempDate.get(5) == 1) {
                CalendarViewLegacyDelegate.this.mTempDate.add(5, -1);
            }
            this.mLastWeekDayMonth = CalendarViewLegacyDelegate.this.mTempDate.get(2);
            updateSelectionPositions();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.view.View
        public void onDraw(Canvas canvas) {
            drawBackground(canvas);
            drawWeekNumbersAndDates(canvas);
            drawWeekSeparators(canvas);
            drawSelectedDateVerticalBars(canvas);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.view.View
        public void onMeasure(int i, int i2) {
            this.mHeight = ((CalendarViewLegacyDelegate.this.mListView.getHeight() - CalendarViewLegacyDelegate.this.mListView.getPaddingTop()) - CalendarViewLegacyDelegate.this.mListView.getPaddingBottom()) / CalendarViewLegacyDelegate.this.mShownWeekCount;
            setMeasuredDimension(View.MeasureSpec.getSize(i), this.mHeight);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.view.View
        public void onSizeChanged(int i, int i2, int i3, int i4) {
            this.mWidth = i;
            updateSelectionPositions();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/CalendarViewLegacyDelegate$WeeksAdapter.class */
    public class WeeksAdapter extends BaseAdapter implements View.OnTouchListener {
        private int mFocusedMonth;
        private GestureDetector mGestureDetector;
        private final Calendar mSelectedDate = Calendar.getInstance();
        private int mSelectedWeek;
        private int mTotalWeekCount;

        /* loaded from: source-4181928-dex2jar.jar:android/widget/CalendarViewLegacyDelegate$WeeksAdapter$CalendarGestureListener.class */
        class CalendarGestureListener extends GestureDetector.SimpleOnGestureListener {
            CalendarGestureListener() {
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                return true;
            }
        }

        public WeeksAdapter(Context context) {
            CalendarViewLegacyDelegate.this.mContext = context;
            this.mGestureDetector = new GestureDetector(CalendarViewLegacyDelegate.this.mContext, new CalendarGestureListener());
            init();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void init() {
            this.mSelectedWeek = CalendarViewLegacyDelegate.this.getWeeksSinceMinDate(this.mSelectedDate);
            this.mTotalWeekCount = CalendarViewLegacyDelegate.this.getWeeksSinceMinDate(CalendarViewLegacyDelegate.this.mMaxDate);
            if (CalendarViewLegacyDelegate.this.mMinDate.get(7) != CalendarViewLegacyDelegate.this.mFirstDayOfWeek || CalendarViewLegacyDelegate.this.mMaxDate.get(7) != CalendarViewLegacyDelegate.this.mFirstDayOfWeek) {
                this.mTotalWeekCount++;
            }
            notifyDataSetChanged();
        }

        private void onDateTapped(Calendar calendar) {
            setSelectedDay(calendar);
            CalendarViewLegacyDelegate.this.setMonthDisplayed(calendar);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.mTotalWeekCount;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        public Calendar getSelectedDay() {
            return this.mSelectedDate;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            WeekView weekView;
            if (view != null) {
                weekView = (WeekView) view;
            } else {
                weekView = new WeekView(CalendarViewLegacyDelegate.this.mContext);
                weekView.setLayoutParams(new AbsListView.LayoutParams(-2, -2));
                weekView.setClickable(true);
                weekView.setOnTouchListener(this);
            }
            weekView.init(i, this.mSelectedWeek == i ? this.mSelectedDate.get(7) : -1, this.mFocusedMonth);
            return weekView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (CalendarViewLegacyDelegate.this.mListView.isEnabled() && this.mGestureDetector.onTouchEvent(motionEvent)) {
                if (!((WeekView) view).getDayFromLocation(motionEvent.getX(), CalendarViewLegacyDelegate.this.mTempDate) || CalendarViewLegacyDelegate.this.mTempDate.before(CalendarViewLegacyDelegate.this.mMinDate) || CalendarViewLegacyDelegate.this.mTempDate.after(CalendarViewLegacyDelegate.this.mMaxDate)) {
                    return true;
                }
                onDateTapped(CalendarViewLegacyDelegate.this.mTempDate);
                return true;
            }
            return false;
        }

        public void setFocusMonth(int i) {
            if (this.mFocusedMonth == i) {
                return;
            }
            this.mFocusedMonth = i;
            notifyDataSetChanged();
        }

        public void setSelectedDay(Calendar calendar) {
            if (calendar.get(6) == this.mSelectedDate.get(6) && calendar.get(1) == this.mSelectedDate.get(1)) {
                return;
            }
            this.mSelectedDate.setTimeInMillis(calendar.getTimeInMillis());
            this.mSelectedWeek = CalendarViewLegacyDelegate.this.getWeeksSinceMinDate(this.mSelectedDate);
            this.mFocusedMonth = this.mSelectedDate.get(2);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CalendarViewLegacyDelegate(CalendarView calendarView, Context context, AttributeSet attributeSet, int i, int i2) {
        super(calendarView, context);
        this.mListScrollTopOffset = 2;
        this.mWeekMinVisibleHeight = 12;
        this.mBottomBuffer = 20;
        this.mDaysPerWeek = 7;
        this.mFriction = 0.05f;
        this.mVelocityScale = 0.333f;
        this.mCurrentMonthDisplayed = -1;
        this.mIsScrollingUp = false;
        this.mPreviousScrollState = 0;
        this.mCurrentScrollState = 0;
        this.mScrollStateChangedRunnable = new ScrollStateRunnable();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CalendarView, i, i2);
        this.mShowWeekNumber = obtainStyledAttributes.getBoolean(1, true);
        this.mFirstDayOfWeek = obtainStyledAttributes.getInt(0, LocaleData.get(Locale.getDefault()).firstDayOfWeek.intValue());
        String string = obtainStyledAttributes.getString(2);
        if (TextUtils.isEmpty(string) || !parseDate(string, this.mMinDate)) {
            parseDate("01/01/1900", this.mMinDate);
        }
        String string2 = obtainStyledAttributes.getString(3);
        if (TextUtils.isEmpty(string2) || !parseDate(string2, this.mMaxDate)) {
            parseDate("01/01/2100", this.mMaxDate);
        }
        if (this.mMaxDate.before(this.mMinDate)) {
            throw new IllegalArgumentException("Max date cannot be before min date.");
        }
        this.mShownWeekCount = obtainStyledAttributes.getInt(4, 6);
        this.mSelectedWeekBackgroundColor = obtainStyledAttributes.getColor(5, 0);
        this.mFocusedMonthDateColor = obtainStyledAttributes.getColor(6, 0);
        this.mUnfocusedMonthDateColor = obtainStyledAttributes.getColor(7, 0);
        this.mWeekSeparatorLineColor = obtainStyledAttributes.getColor(9, 0);
        this.mWeekNumberColor = obtainStyledAttributes.getColor(8, 0);
        this.mSelectedDateVerticalBar = obtainStyledAttributes.getDrawable(10);
        this.mDateTextAppearanceResId = obtainStyledAttributes.getResourceId(12, 16973894);
        updateDateTextSize();
        this.mWeekDayTextAppearanceResId = obtainStyledAttributes.getResourceId(11, -1);
        obtainStyledAttributes.recycle();
        DisplayMetrics displayMetrics = this.mDelegator.getResources().getDisplayMetrics();
        this.mWeekMinVisibleHeight = (int) TypedValue.applyDimension(1, 12.0f, displayMetrics);
        this.mListScrollTopOffset = (int) TypedValue.applyDimension(1, 2.0f, displayMetrics);
        this.mBottomBuffer = (int) TypedValue.applyDimension(1, 20.0f, displayMetrics);
        this.mSelectedDateVerticalBarWidth = (int) TypedValue.applyDimension(1, 6.0f, displayMetrics);
        this.mWeekSeperatorLineWidth = (int) TypedValue.applyDimension(1, 1.0f, displayMetrics);
        View inflate = ((LayoutInflater) this.mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.calendar_view, (ViewGroup) null, false);
        this.mDelegator.addView(inflate);
        this.mListView = (ListView) this.mDelegator.findViewById(16908298);
        this.mDayNamesHeader = (ViewGroup) inflate.findViewById(R.id.day_names);
        this.mMonthName = (TextView) inflate.findViewById(R.id.month_name);
        setUpHeader();
        setUpListView();
        setUpAdapter();
        this.mTempDate.setTimeInMillis(System.currentTimeMillis());
        if (this.mTempDate.before(this.mMinDate)) {
            goTo(this.mMinDate, false, true, true);
        } else if (this.mMaxDate.before(this.mTempDate)) {
            goTo(this.mMaxDate, false, true, true);
        } else {
            goTo(this.mTempDate, false, true, true);
        }
        this.mDelegator.invalidate();
    }

    private static Calendar getCalendarForLocale(Calendar calendar, Locale locale) {
        if (calendar == null) {
            return Calendar.getInstance(locale);
        }
        long timeInMillis = calendar.getTimeInMillis();
        Calendar calendar2 = Calendar.getInstance(locale);
        calendar2.setTimeInMillis(timeInMillis);
        return calendar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getWeeksSinceMinDate(Calendar calendar) {
        if (calendar.before(this.mMinDate)) {
            throw new IllegalArgumentException("fromDate: " + this.mMinDate.getTime() + " does not precede toDate: " + calendar.getTime());
        }
        return (int) ((((calendar.getTimeInMillis() + calendar.getTimeZone().getOffset(calendar.getTimeInMillis())) - (this.mMinDate.getTimeInMillis() + this.mMinDate.getTimeZone().getOffset(this.mMinDate.getTimeInMillis()))) + ((this.mMinDate.get(7) - this.mFirstDayOfWeek) * 86400000)) / 604800000);
    }

    private void goTo(Calendar calendar, boolean z, boolean z2, boolean z3) {
        if (calendar.before(this.mMinDate) || calendar.after(this.mMaxDate)) {
            throw new IllegalArgumentException("Time not between " + this.mMinDate.getTime() + " and " + this.mMaxDate.getTime());
        }
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        View childAt = this.mListView.getChildAt(0);
        int i = firstVisiblePosition;
        if (childAt != null) {
            i = firstVisiblePosition;
            if (childAt.getTop() < 0) {
                i = firstVisiblePosition + 1;
            }
        }
        int i2 = (this.mShownWeekCount + i) - 1;
        int i3 = i2;
        if (childAt != null) {
            i3 = i2;
            if (childAt.getTop() > this.mBottomBuffer) {
                i3 = i2 - 1;
            }
        }
        if (z2) {
            this.mAdapter.setSelectedDay(calendar);
        }
        int weeksSinceMinDate = getWeeksSinceMinDate(calendar);
        if (weeksSinceMinDate >= i && weeksSinceMinDate <= i3 && !z3) {
            if (z2) {
                setMonthDisplayed(calendar);
                return;
            }
            return;
        }
        this.mFirstDayOfMonth.setTimeInMillis(calendar.getTimeInMillis());
        this.mFirstDayOfMonth.set(5, 1);
        setMonthDisplayed(this.mFirstDayOfMonth);
        int weeksSinceMinDate2 = this.mFirstDayOfMonth.before(this.mMinDate) ? 0 : getWeeksSinceMinDate(this.mFirstDayOfMonth);
        this.mPreviousScrollState = 2;
        if (z) {
            this.mListView.smoothScrollToPositionFromTop(weeksSinceMinDate2, this.mListScrollTopOffset, 1000);
            return;
        }
        this.mListView.setSelectionFromTop(weeksSinceMinDate2, this.mListScrollTopOffset);
        onScrollStateChanged(this.mListView, 0);
    }

    private void invalidateAllWeekViews() {
        int childCount = this.mListView.getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                return;
            }
            this.mListView.getChildAt(i2).invalidate();
            i = i2 + 1;
        }
    }

    private static boolean isSameDate(Calendar calendar, Calendar calendar2) {
        return calendar.get(6) == calendar2.get(6) && calendar.get(1) == calendar2.get(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        WeekView weekView = (WeekView) absListView.getChildAt(0);
        if (weekView == null) {
            return;
        }
        long firstVisiblePosition = (absListView.getFirstVisiblePosition() * weekView.getHeight()) - weekView.getBottom();
        if (firstVisiblePosition < this.mPreviousScrollPosition) {
            this.mIsScrollingUp = true;
        } else if (firstVisiblePosition <= this.mPreviousScrollPosition) {
            return;
        } else {
            this.mIsScrollingUp = false;
        }
        int i4 = weekView.getBottom() < this.mWeekMinVisibleHeight ? 1 : 0;
        if (this.mIsScrollingUp) {
            weekView = (WeekView) absListView.getChildAt(i4 + 2);
        } else if (i4 != 0) {
            weekView = (WeekView) absListView.getChildAt(i4);
        }
        if (weekView != null) {
            int monthOfFirstWeekDay = this.mIsScrollingUp ? weekView.getMonthOfFirstWeekDay() : weekView.getMonthOfLastWeekDay();
            int i5 = (this.mCurrentMonthDisplayed == 11 && monthOfFirstWeekDay == 0) ? 1 : (this.mCurrentMonthDisplayed == 0 && monthOfFirstWeekDay == 11) ? -1 : monthOfFirstWeekDay - this.mCurrentMonthDisplayed;
            if ((!this.mIsScrollingUp && i5 > 0) || (this.mIsScrollingUp && i5 < 0)) {
                Calendar firstDay = weekView.getFirstDay();
                if (this.mIsScrollingUp) {
                    firstDay.add(5, -7);
                } else {
                    firstDay.add(5, 7);
                }
                setMonthDisplayed(firstDay);
            }
        }
        this.mPreviousScrollPosition = firstVisiblePosition;
        this.mPreviousScrollState = this.mCurrentScrollState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onScrollStateChanged(AbsListView absListView, int i) {
        this.mScrollStateChangedRunnable.doScrollStateChange(absListView, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMonthDisplayed(Calendar calendar) {
        this.mCurrentMonthDisplayed = calendar.get(2);
        this.mAdapter.setFocusMonth(this.mCurrentMonthDisplayed);
        long timeInMillis = calendar.getTimeInMillis();
        this.mMonthName.setText(DateUtils.formatDateRange(this.mContext, timeInMillis, timeInMillis, 52));
        this.mMonthName.invalidate();
    }

    private void setUpAdapter() {
        if (this.mAdapter == null) {
            this.mAdapter = new WeeksAdapter(this.mContext);
            this.mAdapter.registerDataSetObserver(new DataSetObserver() { // from class: android.widget.CalendarViewLegacyDelegate.1
                @Override // android.database.DataSetObserver
                public void onChanged() {
                    if (CalendarViewLegacyDelegate.this.mOnDateChangeListener != null) {
                        Calendar selectedDay = CalendarViewLegacyDelegate.this.mAdapter.getSelectedDay();
                        CalendarViewLegacyDelegate.this.mOnDateChangeListener.onSelectedDayChange(CalendarViewLegacyDelegate.this.mDelegator, selectedDay.get(1), selectedDay.get(2), selectedDay.get(5));
                    }
                }
            });
            this.mListView.setAdapter((ListAdapter) this.mAdapter);
        }
        this.mAdapter.notifyDataSetChanged();
    }

    private void setUpHeader() {
        this.mDayNamesShort = new String[this.mDaysPerWeek];
        this.mDayNamesLong = new String[this.mDaysPerWeek];
        int i = this.mFirstDayOfWeek;
        int i2 = this.mFirstDayOfWeek;
        int i3 = this.mDaysPerWeek;
        while (i < i2 + i3) {
            int i4 = i > 7 ? i - 7 : i;
            this.mDayNamesShort[i - this.mFirstDayOfWeek] = DateUtils.getDayOfWeekString(i4, 50);
            this.mDayNamesLong[i - this.mFirstDayOfWeek] = DateUtils.getDayOfWeekString(i4, 10);
            i++;
        }
        TextView textView = (TextView) this.mDayNamesHeader.getChildAt(0);
        if (this.mShowWeekNumber) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
        int childCount = this.mDayNamesHeader.getChildCount();
        for (int i5 = 1; i5 < childCount; i5++) {
            TextView textView2 = (TextView) this.mDayNamesHeader.getChildAt(i5);
            if (this.mWeekDayTextAppearanceResId > -1) {
                textView2.setTextAppearance(this.mContext, this.mWeekDayTextAppearanceResId);
            }
            if (i5 < this.mDaysPerWeek + 1) {
                textView2.setText(this.mDayNamesShort[i5 - 1]);
                textView2.setContentDescription(this.mDayNamesLong[i5 - 1]);
                textView2.setVisibility(0);
            } else {
                textView2.setVisibility(8);
            }
        }
        this.mDayNamesHeader.invalidate();
    }

    private void setUpListView() {
        this.mListView.setDivider(null);
        this.mListView.setItemsCanFocus(true);
        this.mListView.setVerticalScrollBarEnabled(false);
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: android.widget.CalendarViewLegacyDelegate.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                CalendarViewLegacyDelegate.this.onScroll(absListView, i, i2, i3);
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                CalendarViewLegacyDelegate.this.onScrollStateChanged(absListView, i);
            }
        });
        this.mListView.setFriction(this.mFriction);
        this.mListView.setVelocityScale(this.mVelocityScale);
    }

    private void updateDateTextSize() {
        TypedArray obtainStyledAttributes = this.mDelegator.getContext().obtainStyledAttributes(this.mDateTextAppearanceResId, R.styleable.TextAppearance);
        this.mDateTextSize = obtainStyledAttributes.getDimensionPixelSize(0, 14);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public long getDate() {
        return this.mAdapter.mSelectedDate.getTimeInMillis();
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public int getDateTextAppearance() {
        return this.mDateTextAppearanceResId;
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public int getFirstDayOfWeek() {
        return this.mFirstDayOfWeek;
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public int getFocusedMonthDateColor() {
        return this.mFocusedMonthDateColor;
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public long getMaxDate() {
        return this.mMaxDate.getTimeInMillis();
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public long getMinDate() {
        return this.mMinDate.getTimeInMillis();
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public Drawable getSelectedDateVerticalBar() {
        return this.mSelectedDateVerticalBar;
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public int getSelectedWeekBackgroundColor() {
        return this.mSelectedWeekBackgroundColor;
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public boolean getShowWeekNumber() {
        return this.mShowWeekNumber;
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public int getShownWeekCount() {
        return this.mShownWeekCount;
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public int getUnfocusedMonthDateColor() {
        return this.mFocusedMonthDateColor;
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public int getWeekDayTextAppearance() {
        return this.mWeekDayTextAppearanceResId;
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public int getWeekNumberColor() {
        return this.mWeekNumberColor;
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public int getWeekSeparatorLineColor() {
        return this.mWeekSeparatorLineColor;
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public void onConfigurationChanged(Configuration configuration) {
        setCurrentLocale(configuration.locale);
    }

    @Override // android.widget.CalendarView.AbstractCalendarViewDelegate
    protected void setCurrentLocale(Locale locale) {
        super.setCurrentLocale(locale);
        this.mTempDate = getCalendarForLocale(this.mTempDate, locale);
        this.mFirstDayOfMonth = getCalendarForLocale(this.mFirstDayOfMonth, locale);
        this.mMinDate = getCalendarForLocale(this.mMinDate, locale);
        this.mMaxDate = getCalendarForLocale(this.mMaxDate, locale);
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public void setDate(long j) {
        setDate(j, false, false);
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public void setDate(long j, boolean z, boolean z2) {
        this.mTempDate.setTimeInMillis(j);
        if (isSameDate(this.mTempDate, this.mAdapter.mSelectedDate)) {
            return;
        }
        goTo(this.mTempDate, z, true, z2);
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public void setDateTextAppearance(int i) {
        if (this.mDateTextAppearanceResId != i) {
            this.mDateTextAppearanceResId = i;
            updateDateTextSize();
            invalidateAllWeekViews();
        }
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public void setFirstDayOfWeek(int i) {
        if (this.mFirstDayOfWeek == i) {
            return;
        }
        this.mFirstDayOfWeek = i;
        this.mAdapter.init();
        this.mAdapter.notifyDataSetChanged();
        setUpHeader();
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public void setFocusedMonthDateColor(int i) {
        if (this.mFocusedMonthDateColor == i) {
            return;
        }
        this.mFocusedMonthDateColor = i;
        int childCount = this.mListView.getChildCount();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= childCount) {
                return;
            }
            WeekView weekView = (WeekView) this.mListView.getChildAt(i3);
            if (weekView.mHasFocusedDay) {
                weekView.invalidate();
            }
            i2 = i3 + 1;
        }
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public void setMaxDate(long j) {
        this.mTempDate.setTimeInMillis(j);
        if (isSameDate(this.mTempDate, this.mMaxDate)) {
            return;
        }
        this.mMaxDate.setTimeInMillis(j);
        this.mAdapter.init();
        Calendar calendar = this.mAdapter.mSelectedDate;
        if (calendar.after(this.mMaxDate)) {
            setDate(this.mMaxDate.getTimeInMillis());
        } else {
            goTo(calendar, false, true, false);
        }
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public void setMinDate(long j) {
        this.mTempDate.setTimeInMillis(j);
        if (isSameDate(this.mTempDate, this.mMinDate)) {
            return;
        }
        this.mMinDate.setTimeInMillis(j);
        Calendar calendar = this.mAdapter.mSelectedDate;
        if (calendar.before(this.mMinDate)) {
            this.mAdapter.setSelectedDay(this.mMinDate);
        }
        this.mAdapter.init();
        if (calendar.before(this.mMinDate)) {
            setDate(this.mTempDate.getTimeInMillis());
        } else {
            goTo(calendar, false, true, false);
        }
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public void setOnDateChangeListener(CalendarView.OnDateChangeListener onDateChangeListener) {
        this.mOnDateChangeListener = onDateChangeListener;
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public void setSelectedDateVerticalBar(int i) {
        setSelectedDateVerticalBar(this.mDelegator.getContext().getDrawable(i));
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public void setSelectedDateVerticalBar(Drawable drawable) {
        if (this.mSelectedDateVerticalBar == drawable) {
            return;
        }
        this.mSelectedDateVerticalBar = drawable;
        int childCount = this.mListView.getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                return;
            }
            WeekView weekView = (WeekView) this.mListView.getChildAt(i2);
            if (weekView.mHasSelectedDay) {
                weekView.invalidate();
            }
            i = i2 + 1;
        }
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public void setSelectedWeekBackgroundColor(int i) {
        if (this.mSelectedWeekBackgroundColor == i) {
            return;
        }
        this.mSelectedWeekBackgroundColor = i;
        int childCount = this.mListView.getChildCount();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= childCount) {
                return;
            }
            WeekView weekView = (WeekView) this.mListView.getChildAt(i3);
            if (weekView.mHasSelectedDay) {
                weekView.invalidate();
            }
            i2 = i3 + 1;
        }
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public void setShowWeekNumber(boolean z) {
        if (this.mShowWeekNumber == z) {
            return;
        }
        this.mShowWeekNumber = z;
        this.mAdapter.notifyDataSetChanged();
        setUpHeader();
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public void setShownWeekCount(int i) {
        if (this.mShownWeekCount != i) {
            this.mShownWeekCount = i;
            this.mDelegator.invalidate();
        }
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public void setUnfocusedMonthDateColor(int i) {
        if (this.mUnfocusedMonthDateColor == i) {
            return;
        }
        this.mUnfocusedMonthDateColor = i;
        int childCount = this.mListView.getChildCount();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= childCount) {
                return;
            }
            WeekView weekView = (WeekView) this.mListView.getChildAt(i3);
            if (weekView.mHasUnfocusedDay) {
                weekView.invalidate();
            }
            i2 = i3 + 1;
        }
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public void setWeekDayTextAppearance(int i) {
        if (this.mWeekDayTextAppearanceResId != i) {
            this.mWeekDayTextAppearanceResId = i;
            setUpHeader();
        }
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public void setWeekNumberColor(int i) {
        if (this.mWeekNumberColor != i) {
            this.mWeekNumberColor = i;
            if (this.mShowWeekNumber) {
                invalidateAllWeekViews();
            }
        }
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public void setWeekSeparatorLineColor(int i) {
        if (this.mWeekSeparatorLineColor != i) {
            this.mWeekSeparatorLineColor = i;
            invalidateAllWeekViews();
        }
    }
}
