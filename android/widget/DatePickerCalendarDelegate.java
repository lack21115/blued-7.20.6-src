package android.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AlphaAnimation;
import android.widget.DatePicker;
import android.widget.DayPickerView;
import com.android.internal.R;
import com.android.internal.widget.AccessibleDateAnimator;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-4181928-dex2jar.jar:android/widget/DatePickerCalendarDelegate.class */
public class DatePickerCalendarDelegate extends DatePicker.AbstractDatePickerDelegate implements View.OnClickListener, DatePickerController {
    private static final int ANIMATION_DURATION = 300;
    private static final int DAY_INDEX = 1;
    private static final int DEFAULT_END_YEAR = 2100;
    private static final int DEFAULT_START_YEAR = 1900;
    private static final int MONTH_AND_DAY_VIEW = 0;
    private static final int MONTH_INDEX = 0;
    private static final int UNINITIALIZED = -1;
    private static final int USE_LOCALE = 0;
    private static final int YEAR_INDEX = 2;
    private static final int YEAR_VIEW = 1;
    private AccessibleDateAnimator mAnimator;
    private Calendar mCurrentDate;
    private int mCurrentView;
    private DatePicker.OnDateChangedListener mDateChangedListener;
    private SimpleDateFormat mDayFormat;
    private TextView mDayOfWeekView;
    private String mDayPickerDescription;
    private DayPickerView mDayPickerView;
    private int mFirstDayOfWeek;
    private TextView mHeaderDayOfMonthTextView;
    private TextView mHeaderMonthTextView;
    private TextView mHeaderYearTextView;
    private boolean mIsEnabled;
    private HashSet<OnDateChangedListener> mListeners;
    private Calendar mMaxDate;
    private Calendar mMinDate;
    private LinearLayout mMonthAndDayLayout;
    private LinearLayout mMonthDayYearLayout;
    private final DayPickerView.OnDaySelectedListener mOnDaySelectedListener;
    private String mSelectDay;
    private String mSelectYear;
    private Calendar mTempDate;
    private SimpleDateFormat mYearFormat;
    private String mYearPickerDescription;
    private YearPickerView mYearPickerView;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/DatePickerCalendarDelegate$SavedState.class */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: android.widget.DatePickerCalendarDelegate.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        private final int mCurrentView;
        private final int mListPosition;
        private final int mListPositionOffset;
        private final long mMaxDate;
        private final long mMinDate;
        private final int mSelectedDay;
        private final int mSelectedMonth;
        private final int mSelectedYear;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.mSelectedYear = parcel.readInt();
            this.mSelectedMonth = parcel.readInt();
            this.mSelectedDay = parcel.readInt();
            this.mMinDate = parcel.readLong();
            this.mMaxDate = parcel.readLong();
            this.mCurrentView = parcel.readInt();
            this.mListPosition = parcel.readInt();
            this.mListPositionOffset = parcel.readInt();
        }

        private SavedState(Parcelable parcelable, int i, int i2, int i3, long j, long j2, int i4, int i5, int i6) {
            super(parcelable);
            this.mSelectedYear = i;
            this.mSelectedMonth = i2;
            this.mSelectedDay = i3;
            this.mMinDate = j;
            this.mMaxDate = j2;
            this.mCurrentView = i4;
            this.mListPosition = i5;
            this.mListPositionOffset = i6;
        }

        public int getCurrentView() {
            return this.mCurrentView;
        }

        public int getListPosition() {
            return this.mListPosition;
        }

        public int getListPositionOffset() {
            return this.mListPositionOffset;
        }

        public long getMaxDate() {
            return this.mMaxDate;
        }

        public long getMinDate() {
            return this.mMinDate;
        }

        public int getSelectedDay() {
            return this.mSelectedDay;
        }

        public int getSelectedMonth() {
            return this.mSelectedMonth;
        }

        public int getSelectedYear() {
            return this.mSelectedYear;
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.mSelectedYear);
            parcel.writeInt(this.mSelectedMonth);
            parcel.writeInt(this.mSelectedDay);
            parcel.writeLong(this.mMinDate);
            parcel.writeLong(this.mMaxDate);
            parcel.writeInt(this.mCurrentView);
            parcel.writeInt(this.mListPosition);
            parcel.writeInt(this.mListPositionOffset);
        }
    }

    public DatePickerCalendarDelegate(DatePicker datePicker, Context context, AttributeSet attributeSet, int i, int i2) {
        super(datePicker, context);
        this.mYearFormat = new SimpleDateFormat("y", Locale.getDefault());
        this.mDayFormat = new SimpleDateFormat("d", Locale.getDefault());
        this.mIsEnabled = true;
        this.mCurrentView = -1;
        this.mFirstDayOfWeek = 0;
        this.mListeners = new HashSet<>();
        this.mOnDaySelectedListener = new DayPickerView.OnDaySelectedListener() { // from class: android.widget.DatePickerCalendarDelegate.1
            @Override // android.widget.DayPickerView.OnDaySelectedListener
            public void onDaySelected(DayPickerView dayPickerView, Calendar calendar) {
                DatePickerCalendarDelegate.this.mCurrentDate.setTimeInMillis(calendar.getTimeInMillis());
                DatePickerCalendarDelegate.this.onDateChanged(true, true);
            }
        };
        Locale locale = Locale.getDefault();
        this.mMinDate = getCalendarForLocale(this.mMinDate, locale);
        this.mMaxDate = getCalendarForLocale(this.mMaxDate, locale);
        this.mTempDate = getCalendarForLocale(this.mMaxDate, locale);
        this.mCurrentDate = getCalendarForLocale(this.mCurrentDate, locale);
        this.mMinDate.set(1900, 0, 1);
        this.mMaxDate.set(2100, 11, 31);
        Resources resources = this.mDelegator.getResources();
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, R.styleable.DatePicker, i, i2);
        View inflate = ((LayoutInflater) this.mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(obtainStyledAttributes.getResourceId(17, R.layout.date_picker_holo), (ViewGroup) null);
        this.mDelegator.addView(inflate);
        this.mDayOfWeekView = (TextView) inflate.findViewById(R.id.date_picker_header);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.day_picker_selector_layout);
        this.mMonthDayYearLayout = (LinearLayout) inflate.findViewById(R.id.date_picker_month_day_year_layout);
        this.mMonthAndDayLayout = (LinearLayout) inflate.findViewById(R.id.date_picker_month_and_day_layout);
        this.mMonthAndDayLayout.setOnClickListener(this);
        this.mHeaderMonthTextView = (TextView) inflate.findViewById(R.id.date_picker_month);
        this.mHeaderDayOfMonthTextView = (TextView) inflate.findViewById(R.id.date_picker_day);
        this.mHeaderYearTextView = (TextView) inflate.findViewById(R.id.date_picker_year);
        this.mHeaderYearTextView.setOnClickListener(this);
        int highlightColor = this.mHeaderYearTextView.getHighlightColor();
        int resourceId = obtainStyledAttributes.getResourceId(9, -1);
        if (resourceId != -1) {
            this.mDayOfWeekView.setTextAppearance(context, resourceId);
        }
        this.mDayOfWeekView.setBackground(obtainStyledAttributes.getDrawable(8));
        linearLayout.setBackground(obtainStyledAttributes.getDrawable(0));
        int color = obtainStyledAttributes.getColor(20, highlightColor);
        int resourceId2 = obtainStyledAttributes.getResourceId(10, -1);
        if (resourceId2 != -1) {
            this.mHeaderMonthTextView.setTextAppearance(context, resourceId2);
        }
        this.mHeaderMonthTextView.setTextColor(ColorStateList.addFirstIfMissing(this.mHeaderMonthTextView.getTextColors(), 16842913, color));
        int resourceId3 = obtainStyledAttributes.getResourceId(11, -1);
        if (resourceId3 != -1) {
            this.mHeaderDayOfMonthTextView.setTextAppearance(context, resourceId3);
        }
        this.mHeaderDayOfMonthTextView.setTextColor(ColorStateList.addFirstIfMissing(this.mHeaderDayOfMonthTextView.getTextColors(), 16842913, color));
        int resourceId4 = obtainStyledAttributes.getResourceId(12, -1);
        if (resourceId4 != -1) {
            this.mHeaderYearTextView.setTextAppearance(context, resourceId4);
        }
        this.mHeaderYearTextView.setTextColor(ColorStateList.addFirstIfMissing(this.mHeaderYearTextView.getTextColors(), 16842913, color));
        this.mDayPickerView = new DayPickerView(this.mContext);
        this.mDayPickerView.setFirstDayOfWeek(this.mFirstDayOfWeek);
        this.mDayPickerView.setMinDate(this.mMinDate.getTimeInMillis());
        this.mDayPickerView.setMaxDate(this.mMaxDate.getTimeInMillis());
        this.mDayPickerView.setDate(this.mCurrentDate.getTimeInMillis());
        this.mDayPickerView.setOnDaySelectedListener(this.mOnDaySelectedListener);
        this.mYearPickerView = new YearPickerView(this.mContext);
        this.mYearPickerView.init(this);
        this.mYearPickerView.setRange(this.mMinDate, this.mMaxDate);
        this.mYearPickerView.setYearSelectedCircleColor(obtainStyledAttributes.getColor(14, highlightColor));
        this.mDayPickerView.setCalendarTextColor(ColorStateList.addFirstIfMissing(obtainStyledAttributes.getColorStateList(15), 16842913, obtainStyledAttributes.getColor(18, highlightColor)));
        this.mDayPickerDescription = resources.getString(R.string.day_picker_description);
        this.mSelectDay = resources.getString(R.string.select_day);
        this.mYearPickerDescription = resources.getString(R.string.year_picker_description);
        this.mSelectYear = resources.getString(R.string.select_year);
        this.mAnimator = (AccessibleDateAnimator) inflate.findViewById(R.id.animator);
        this.mAnimator.addView(this.mDayPickerView);
        this.mAnimator.addView(this.mYearPickerView);
        this.mAnimator.setDateMillis(this.mCurrentDate.getTimeInMillis());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(300L);
        this.mAnimator.setInAnimation(alphaAnimation);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation2.setDuration(300L);
        this.mAnimator.setOutAnimation(alphaAnimation2);
        updateDisplay(false);
        setCurrentView(0);
    }

    private void adjustDayInMonthIfNeeded(int i, int i2) {
        int i3 = this.mCurrentDate.get(5);
        int daysInMonth = getDaysInMonth(i, i2);
        if (i3 > daysInMonth) {
            this.mCurrentDate.set(5, daysInMonth);
        }
    }

    private Calendar getCalendarForLocale(Calendar calendar, Locale locale) {
        if (calendar == null) {
            return Calendar.getInstance(locale);
        }
        long timeInMillis = calendar.getTimeInMillis();
        Calendar calendar2 = Calendar.getInstance(locale);
        calendar2.setTimeInMillis(timeInMillis);
        return calendar2;
    }

    public static int getDaysInMonth(int i, int i2) {
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

    private int[] getMonthDayYearIndexes(String str) {
        int[] iArr = new int[3];
        String replaceAll = str.replaceAll("'.*?'", "");
        int indexOf = replaceAll.indexOf(100);
        int indexOf2 = replaceAll.indexOf("M");
        if (indexOf2 == -1) {
            indexOf2 = replaceAll.indexOf("L");
        }
        if (replaceAll.indexOf("y") < indexOf2) {
            iArr[2] = 0;
            if (indexOf2 < indexOf) {
                iArr[0] = 1;
                iArr[1] = 2;
                return iArr;
            }
            iArr[0] = 2;
            iArr[1] = 1;
            return iArr;
        }
        iArr[2] = 2;
        if (indexOf2 < indexOf) {
            iArr[0] = 0;
            iArr[1] = 1;
            return iArr;
        }
        iArr[0] = 1;
        iArr[1] = 0;
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDateChanged(boolean z, boolean z2) {
        if (z2 && this.mDateChangedListener != null) {
            this.mDateChangedListener.onDateChanged(this.mDelegator, this.mCurrentDate.get(1), this.mCurrentDate.get(2), this.mCurrentDate.get(5));
        }
        Iterator<OnDateChangedListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onDateChanged();
        }
        this.mDayPickerView.setDate(getSelectedDay().getTimeInMillis());
        updateDisplay(z);
        if (z) {
            tryVibrate();
        }
    }

    private void setCurrentView(int i) {
        long timeInMillis = this.mCurrentDate.getTimeInMillis();
        switch (i) {
            case 0:
                this.mDayPickerView.setDate(getSelectedDay().getTimeInMillis());
                if (this.mCurrentView != i) {
                    this.mMonthAndDayLayout.setSelected(true);
                    this.mHeaderYearTextView.setSelected(false);
                    this.mAnimator.setDisplayedChild(0);
                    this.mCurrentView = i;
                }
                this.mAnimator.setContentDescription(this.mDayPickerDescription + ": " + DateUtils.formatDateTime(this.mContext, timeInMillis, 16));
                this.mAnimator.announceForAccessibility(this.mSelectDay);
                return;
            case 1:
                this.mYearPickerView.onDateChanged();
                if (this.mCurrentView != i) {
                    this.mMonthAndDayLayout.setSelected(false);
                    this.mHeaderYearTextView.setSelected(true);
                    this.mAnimator.setDisplayedChild(1);
                    this.mCurrentView = i;
                }
                this.mAnimator.setContentDescription(this.mYearPickerDescription + ": " + ((Object) this.mYearFormat.format(Long.valueOf(timeInMillis))));
                this.mAnimator.announceForAccessibility(this.mSelectYear);
                return;
            default:
                return;
        }
    }

    private void updateDisplay(boolean z) {
        if (this.mDayOfWeekView != null) {
            this.mDayOfWeekView.setText(this.mCurrentDate.getDisplayName(7, 2, Locale.getDefault()));
        }
        int[] monthDayYearIndexes = getMonthDayYearIndexes(DateFormat.getBestDateTimePattern(this.mCurrentLocale, "yMMMd"));
        this.mMonthDayYearLayout.removeAllViews();
        if (monthDayYearIndexes[2] == 0) {
            this.mMonthDayYearLayout.addView(this.mHeaderYearTextView);
            this.mMonthDayYearLayout.addView(this.mMonthAndDayLayout);
        } else {
            this.mMonthDayYearLayout.addView(this.mMonthAndDayLayout);
            this.mMonthDayYearLayout.addView(this.mHeaderYearTextView);
        }
        this.mMonthAndDayLayout.removeAllViews();
        if (monthDayYearIndexes[0] > monthDayYearIndexes[1]) {
            this.mMonthAndDayLayout.addView(this.mHeaderDayOfMonthTextView);
            this.mMonthAndDayLayout.addView(this.mHeaderMonthTextView);
        } else {
            this.mMonthAndDayLayout.addView(this.mHeaderMonthTextView);
            this.mMonthAndDayLayout.addView(this.mHeaderDayOfMonthTextView);
        }
        this.mHeaderMonthTextView.setText(this.mCurrentDate.getDisplayName(2, 1, Locale.getDefault()).toUpperCase(Locale.getDefault()));
        this.mHeaderDayOfMonthTextView.setText(this.mDayFormat.format(this.mCurrentDate.getTime()));
        this.mHeaderYearTextView.setText(this.mYearFormat.format(this.mCurrentDate.getTime()));
        long timeInMillis = this.mCurrentDate.getTimeInMillis();
        this.mAnimator.setDateMillis(timeInMillis);
        this.mMonthAndDayLayout.setContentDescription(DateUtils.formatDateTime(this.mContext, timeInMillis, 24));
        if (z) {
            this.mAnimator.announceForAccessibility(DateUtils.formatDateTime(this.mContext, timeInMillis, 20));
        }
    }

    @Override // android.widget.DatePicker.DatePickerDelegate
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.widget.DatePicker.DatePickerDelegate
    public CalendarView getCalendarView() {
        throw new UnsupportedOperationException("CalendarView does not exists for the new DatePicker");
    }

    @Override // android.widget.DatePicker.DatePickerDelegate
    public boolean getCalendarViewShown() {
        return false;
    }

    @Override // android.widget.DatePicker.DatePickerDelegate
    public int getDayOfMonth() {
        return this.mCurrentDate.get(5);
    }

    @Override // android.widget.DatePicker.DatePickerDelegate
    public int getFirstDayOfWeek() {
        return this.mFirstDayOfWeek != 0 ? this.mFirstDayOfWeek : this.mCurrentDate.getFirstDayOfWeek();
    }

    @Override // android.widget.DatePicker.DatePickerDelegate
    public Calendar getMaxDate() {
        return this.mMaxDate;
    }

    @Override // android.widget.DatePicker.DatePickerDelegate
    public Calendar getMinDate() {
        return this.mMinDate;
    }

    @Override // android.widget.DatePicker.DatePickerDelegate
    public int getMonth() {
        return this.mCurrentDate.get(2);
    }

    @Override // android.widget.DatePickerController
    public Calendar getSelectedDay() {
        return this.mCurrentDate;
    }

    @Override // android.widget.DatePicker.DatePickerDelegate
    public boolean getSpinnersShown() {
        return false;
    }

    @Override // android.widget.DatePicker.DatePickerDelegate
    public int getYear() {
        return this.mCurrentDate.get(1);
    }

    @Override // android.widget.DatePicker.DatePickerDelegate
    public void init(int i, int i2, int i3, DatePicker.OnDateChangedListener onDateChangedListener) {
        this.mCurrentDate.set(1, i);
        this.mCurrentDate.set(2, i2);
        this.mCurrentDate.set(5, i3);
        this.mDateChangedListener = onDateChangedListener;
        onDateChanged(false, false);
    }

    @Override // android.widget.DatePicker.DatePickerDelegate
    public boolean isEnabled() {
        return this.mIsEnabled;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        tryVibrate();
        if (view.getId() == 16909042) {
            setCurrentView(1);
        } else if (view.getId() == 16909039) {
            setCurrentView(0);
        }
    }

    @Override // android.widget.DatePicker.DatePickerDelegate
    public void onConfigurationChanged(Configuration configuration) {
        this.mYearFormat = new SimpleDateFormat("y", configuration.locale);
        this.mDayFormat = new SimpleDateFormat("d", configuration.locale);
    }

    @Override // android.widget.DatePicker.DatePickerDelegate
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        accessibilityEvent.setClassName(DatePicker.class.getName());
    }

    @Override // android.widget.DatePicker.DatePickerDelegate
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        accessibilityNodeInfo.setClassName(DatePicker.class.getName());
    }

    @Override // android.widget.DatePicker.DatePickerDelegate
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        accessibilityEvent.getText().add(this.mCurrentDate.getTime().toString());
    }

    @Override // android.widget.DatePicker.DatePickerDelegate
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        this.mCurrentDate.set(savedState.getSelectedYear(), savedState.getSelectedMonth(), savedState.getSelectedDay());
        this.mCurrentView = savedState.getCurrentView();
        this.mMinDate.setTimeInMillis(savedState.getMinDate());
        this.mMaxDate.setTimeInMillis(savedState.getMaxDate());
        updateDisplay(false);
        setCurrentView(this.mCurrentView);
        int listPosition = savedState.getListPosition();
        if (listPosition != -1) {
            if (this.mCurrentView == 0) {
                this.mDayPickerView.postSetSelection(listPosition);
            } else if (this.mCurrentView == 1) {
                this.mYearPickerView.postSetSelectionFromTop(listPosition, savedState.getListPositionOffset());
            }
        }
    }

    @Override // android.widget.DatePicker.DatePickerDelegate
    public Parcelable onSaveInstanceState(Parcelable parcelable) {
        int i = this.mCurrentDate.get(1);
        int i2 = this.mCurrentDate.get(2);
        int i3 = this.mCurrentDate.get(5);
        int i4 = -1;
        int i5 = -1;
        if (this.mCurrentView == 0) {
            i4 = this.mDayPickerView.getMostVisiblePosition();
        } else if (this.mCurrentView == 1) {
            i4 = this.mYearPickerView.getFirstVisiblePosition();
            i5 = this.mYearPickerView.getFirstPositionOffset();
        }
        return new SavedState(parcelable, i, i2, i3, this.mMinDate.getTimeInMillis(), this.mMaxDate.getTimeInMillis(), this.mCurrentView, i4, i5);
    }

    @Override // android.widget.DatePickerController
    public void onYearSelected(int i) {
        adjustDayInMonthIfNeeded(this.mCurrentDate.get(2), i);
        this.mCurrentDate.set(1, i);
        onDateChanged(true, true);
        setCurrentView(0);
    }

    @Override // android.widget.DatePickerController
    public void registerOnDateChangedListener(OnDateChangedListener onDateChangedListener) {
        this.mListeners.add(onDateChangedListener);
    }

    @Override // android.widget.DatePicker.DatePickerDelegate
    public void setCalendarViewShown(boolean z) {
    }

    @Override // android.widget.DatePicker.DatePickerDelegate
    public void setEnabled(boolean z) {
        this.mMonthAndDayLayout.setEnabled(z);
        this.mHeaderYearTextView.setEnabled(z);
        this.mAnimator.setEnabled(z);
        this.mIsEnabled = z;
    }

    @Override // android.widget.DatePicker.DatePickerDelegate
    public void setFirstDayOfWeek(int i) {
        this.mFirstDayOfWeek = i;
        this.mDayPickerView.setFirstDayOfWeek(i);
    }

    @Override // android.widget.DatePicker.DatePickerDelegate
    public void setMaxDate(long j) {
        this.mTempDate.setTimeInMillis(j);
        if (this.mTempDate.get(1) != this.mMaxDate.get(1) || this.mTempDate.get(6) == this.mMaxDate.get(6)) {
            if (this.mCurrentDate.after(this.mTempDate)) {
                this.mCurrentDate.setTimeInMillis(j);
                onDateChanged(false, true);
            }
            this.mMaxDate.setTimeInMillis(j);
            this.mDayPickerView.setMaxDate(j);
            this.mYearPickerView.setRange(this.mMinDate, this.mMaxDate);
        }
    }

    @Override // android.widget.DatePicker.DatePickerDelegate
    public void setMinDate(long j) {
        this.mTempDate.setTimeInMillis(j);
        if (this.mTempDate.get(1) != this.mMinDate.get(1) || this.mTempDate.get(6) == this.mMinDate.get(6)) {
            if (this.mCurrentDate.before(this.mTempDate)) {
                this.mCurrentDate.setTimeInMillis(j);
                onDateChanged(false, true);
            }
            this.mMinDate.setTimeInMillis(j);
            this.mDayPickerView.setMinDate(j);
            this.mYearPickerView.setRange(this.mMinDate, this.mMaxDate);
        }
    }

    @Override // android.widget.DatePicker.DatePickerDelegate
    public void setSpinnersShown(boolean z) {
    }

    @Override // android.widget.DatePickerController
    public void tryVibrate() {
        this.mDelegator.performHapticFeedback(5);
    }

    @Override // android.widget.DatePicker.DatePickerDelegate
    public void updateDate(int i, int i2, int i3) {
        this.mCurrentDate.set(1, i);
        this.mCurrentDate.set(2, i2);
        this.mCurrentDate.set(5, i3);
        onDateChanged(false, true);
    }
}
