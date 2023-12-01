package android.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.CalendarView;
import android.widget.NumberPicker;
import com.android.internal.R;
import com.google.android.material.timepicker.TimeModel;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;
import libcore.icu.ICU;

/* loaded from: source-4181928-dex2jar.jar:android/widget/DatePicker.class */
public class DatePicker extends FrameLayout {
    private static final String LOG_TAG = DatePicker.class.getSimpleName();
    private static final int MODE_CALENDAR = 2;
    private static final int MODE_SPINNER = 1;
    private final DatePickerDelegate mDelegate;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/DatePicker$AbstractDatePickerDelegate.class */
    public static abstract class AbstractDatePickerDelegate implements DatePickerDelegate {
        protected Context mContext;
        protected Locale mCurrentLocale;
        protected DatePicker mDelegator;
        protected OnDateChangedListener mOnDateChangedListener;
        protected ValidationCallback mValidationCallback;

        public AbstractDatePickerDelegate(DatePicker datePicker, Context context) {
            this.mDelegator = datePicker;
            this.mContext = context;
            setCurrentLocale(Locale.getDefault());
        }

        protected void onValidationChanged(boolean z) {
            if (this.mValidationCallback != null) {
                this.mValidationCallback.onValidationChanged(z);
            }
        }

        protected void setCurrentLocale(Locale locale) {
            if (locale.equals(this.mCurrentLocale)) {
                return;
            }
            this.mCurrentLocale = locale;
        }

        @Override // android.widget.DatePicker.DatePickerDelegate
        public void setValidationCallback(ValidationCallback validationCallback) {
            this.mValidationCallback = validationCallback;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/DatePicker$DatePickerDelegate.class */
    public interface DatePickerDelegate {
        boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent);

        CalendarView getCalendarView();

        boolean getCalendarViewShown();

        int getDayOfMonth();

        int getFirstDayOfWeek();

        Calendar getMaxDate();

        Calendar getMinDate();

        int getMonth();

        boolean getSpinnersShown();

        int getYear();

        void init(int i, int i2, int i3, OnDateChangedListener onDateChangedListener);

        boolean isEnabled();

        void onConfigurationChanged(Configuration configuration);

        void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent);

        void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo);

        void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent);

        void onRestoreInstanceState(Parcelable parcelable);

        Parcelable onSaveInstanceState(Parcelable parcelable);

        void setCalendarViewShown(boolean z);

        void setEnabled(boolean z);

        void setFirstDayOfWeek(int i);

        void setMaxDate(long j);

        void setMinDate(long j);

        void setSpinnersShown(boolean z);

        void setValidationCallback(ValidationCallback validationCallback);

        void updateDate(int i, int i2, int i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/DatePicker$DatePickerSpinnerDelegate.class */
    public static class DatePickerSpinnerDelegate extends AbstractDatePickerDelegate {
        private static final String DATE_FORMAT = "MM/dd/yyyy";
        private static final boolean DEFAULT_CALENDAR_VIEW_SHOWN = true;
        private static final boolean DEFAULT_ENABLED_STATE = true;
        private static final int DEFAULT_END_YEAR = 2100;
        private static final boolean DEFAULT_SPINNERS_SHOWN = true;
        private static final int DEFAULT_START_YEAR = 1900;
        private final CalendarView mCalendarView;
        private Calendar mCurrentDate;
        private final DateFormat mDateFormat;
        private final NumberPicker mDaySpinner;
        private final EditText mDaySpinnerInput;
        private boolean mIsEnabled;
        private Calendar mMaxDate;
        private Calendar mMinDate;
        private final NumberPicker mMonthSpinner;
        private final EditText mMonthSpinnerInput;
        private int mNumberOfMonths;
        private String[] mShortMonths;
        private final LinearLayout mSpinners;
        private Calendar mTempDate;
        private final NumberPicker mYearSpinner;
        private final EditText mYearSpinnerInput;

        DatePickerSpinnerDelegate(DatePicker datePicker, Context context, AttributeSet attributeSet, int i, int i2) {
            super(datePicker, context);
            this.mDateFormat = new SimpleDateFormat(DATE_FORMAT);
            this.mIsEnabled = true;
            this.mDelegator = datePicker;
            this.mContext = context;
            setCurrentLocale(Locale.getDefault());
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DatePicker, i, i2);
            boolean z = obtainStyledAttributes.getBoolean(6, true);
            boolean z2 = obtainStyledAttributes.getBoolean(7, true);
            int i3 = obtainStyledAttributes.getInt(1, 1900);
            int i4 = obtainStyledAttributes.getInt(2, 2100);
            String string = obtainStyledAttributes.getString(4);
            String string2 = obtainStyledAttributes.getString(5);
            int resourceId = obtainStyledAttributes.getResourceId(19, R.layout.date_picker_legacy);
            obtainStyledAttributes.recycle();
            ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(resourceId, (ViewGroup) this.mDelegator, true);
            NumberPicker.OnValueChangeListener onValueChangeListener = new NumberPicker.OnValueChangeListener() { // from class: android.widget.DatePicker.DatePickerSpinnerDelegate.1
                @Override // android.widget.NumberPicker.OnValueChangeListener
                public void onValueChange(NumberPicker numberPicker, int i5, int i6) {
                    DatePickerSpinnerDelegate.this.updateInputState();
                    DatePickerSpinnerDelegate.this.mTempDate.setTimeInMillis(DatePickerSpinnerDelegate.this.mCurrentDate.getTimeInMillis());
                    if (numberPicker == DatePickerSpinnerDelegate.this.mDaySpinner) {
                        int actualMaximum = DatePickerSpinnerDelegate.this.mTempDate.getActualMaximum(5);
                        if (i5 == actualMaximum && i6 == 1) {
                            DatePickerSpinnerDelegate.this.mTempDate.add(5, 1);
                        } else if (i5 == 1 && i6 == actualMaximum) {
                            DatePickerSpinnerDelegate.this.mTempDate.add(5, -1);
                        } else {
                            DatePickerSpinnerDelegate.this.mTempDate.add(5, i6 - i5);
                        }
                    } else if (numberPicker == DatePickerSpinnerDelegate.this.mMonthSpinner) {
                        if (i5 == 11 && i6 == 0) {
                            DatePickerSpinnerDelegate.this.mTempDate.add(2, 1);
                        } else if (i5 == 0 && i6 == 11) {
                            DatePickerSpinnerDelegate.this.mTempDate.add(2, -1);
                        } else {
                            DatePickerSpinnerDelegate.this.mTempDate.add(2, i6 - i5);
                        }
                    } else if (numberPicker != DatePickerSpinnerDelegate.this.mYearSpinner) {
                        throw new IllegalArgumentException();
                    } else {
                        DatePickerSpinnerDelegate.this.mTempDate.set(1, i6);
                    }
                    DatePickerSpinnerDelegate.this.setDate(DatePickerSpinnerDelegate.this.mTempDate.get(1), DatePickerSpinnerDelegate.this.mTempDate.get(2), DatePickerSpinnerDelegate.this.mTempDate.get(5));
                    DatePickerSpinnerDelegate.this.updateSpinners();
                    DatePickerSpinnerDelegate.this.updateCalendarView();
                    DatePickerSpinnerDelegate.this.notifyDateChanged();
                }
            };
            this.mSpinners = (LinearLayout) this.mDelegator.findViewById(R.id.pickers);
            this.mCalendarView = (CalendarView) this.mDelegator.findViewById(R.id.calendar_view);
            this.mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() { // from class: android.widget.DatePicker.DatePickerSpinnerDelegate.2
                @Override // android.widget.CalendarView.OnDateChangeListener
                public void onSelectedDayChange(CalendarView calendarView, int i5, int i6, int i7) {
                    DatePickerSpinnerDelegate.this.setDate(i5, i6, i7);
                    DatePickerSpinnerDelegate.this.updateSpinners();
                    DatePickerSpinnerDelegate.this.notifyDateChanged();
                }
            });
            this.mDaySpinner = (NumberPicker) this.mDelegator.findViewById(R.id.day);
            this.mDaySpinner.setFormatter(NumberPicker.getTwoDigitFormatter());
            this.mDaySpinner.setOnLongPressUpdateInterval(100L);
            this.mDaySpinner.setOnValueChangedListener(onValueChangeListener);
            this.mDaySpinnerInput = (EditText) this.mDaySpinner.findViewById(R.id.numberpicker_input);
            this.mMonthSpinner = (NumberPicker) this.mDelegator.findViewById(R.id.month);
            this.mMonthSpinner.setMinValue(0);
            this.mMonthSpinner.setMaxValue(this.mNumberOfMonths - 1);
            this.mMonthSpinner.setDisplayedValues(this.mShortMonths);
            this.mMonthSpinner.setOnLongPressUpdateInterval(200L);
            this.mMonthSpinner.setOnValueChangedListener(onValueChangeListener);
            this.mMonthSpinnerInput = (EditText) this.mMonthSpinner.findViewById(R.id.numberpicker_input);
            this.mYearSpinner = (NumberPicker) this.mDelegator.findViewById(R.id.year);
            this.mYearSpinner.setOnLongPressUpdateInterval(100L);
            this.mYearSpinner.setOnValueChangedListener(onValueChangeListener);
            this.mYearSpinnerInput = (EditText) this.mYearSpinner.findViewById(R.id.numberpicker_input);
            if (z || z2) {
                setSpinnersShown(z);
                setCalendarViewShown(z2);
            } else {
                setSpinnersShown(true);
            }
            this.mTempDate.clear();
            if (TextUtils.isEmpty(string)) {
                this.mTempDate.set(i3, 0, 1);
            } else if (!parseDate(string, this.mTempDate)) {
                this.mTempDate.set(i3, 0, 1);
            }
            setMinDate(this.mTempDate.getTimeInMillis());
            this.mTempDate.clear();
            if (TextUtils.isEmpty(string2)) {
                this.mTempDate.set(i4, 11, 31);
            } else if (!parseDate(string2, this.mTempDate)) {
                this.mTempDate.set(i4, 11, 31);
            }
            setMaxDate(this.mTempDate.getTimeInMillis());
            this.mCurrentDate.setTimeInMillis(System.currentTimeMillis());
            init(this.mCurrentDate.get(1), this.mCurrentDate.get(2), this.mCurrentDate.get(5), null);
            reorderSpinners();
            setContentDescriptions();
            if (this.mDelegator.getImportantForAccessibility() == 0) {
                this.mDelegator.setImportantForAccessibility(1);
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

        private boolean isNewDate(int i, int i2, int i3) {
            return (this.mCurrentDate.get(1) == i && this.mCurrentDate.get(2) == i3 && this.mCurrentDate.get(5) == i2) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void notifyDateChanged() {
            this.mDelegator.sendAccessibilityEvent(4);
            if (this.mOnDateChangedListener != null) {
                this.mOnDateChangedListener.onDateChanged(this.mDelegator, getYear(), getMonth(), getDayOfMonth());
            }
        }

        private boolean parseDate(String str, Calendar calendar) {
            try {
                calendar.setTime(this.mDateFormat.parse(str));
                return true;
            } catch (ParseException e) {
                Log.w(DatePicker.LOG_TAG, "Date: " + str + " not in format: " + DATE_FORMAT);
                return false;
            }
        }

        private void reorderSpinners() {
            this.mSpinners.removeAllViews();
            char[] dateFormatOrder = ICU.getDateFormatOrder(android.text.format.DateFormat.getBestDateTimePattern(Locale.getDefault(), "yyyyMMMdd"));
            int length = dateFormatOrder.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return;
                }
                switch (dateFormatOrder[i2]) {
                    case 'M':
                        this.mSpinners.addView(this.mMonthSpinner);
                        setImeOptions(this.mMonthSpinner, length, i2);
                        break;
                    case 'd':
                        this.mSpinners.addView(this.mDaySpinner);
                        setImeOptions(this.mDaySpinner, length, i2);
                        break;
                    case 'y':
                        this.mSpinners.addView(this.mYearSpinner);
                        setImeOptions(this.mYearSpinner, length, i2);
                        break;
                    default:
                        throw new IllegalArgumentException(Arrays.toString(dateFormatOrder));
                }
                i = i2 + 1;
            }
        }

        private void setContentDescriptions() {
            trySetContentDescription(this.mDaySpinner, R.id.increment, R.string.date_picker_increment_day_button);
            trySetContentDescription(this.mDaySpinner, R.id.decrement, R.string.date_picker_decrement_day_button);
            trySetContentDescription(this.mMonthSpinner, R.id.increment, R.string.date_picker_increment_month_button);
            trySetContentDescription(this.mMonthSpinner, R.id.decrement, R.string.date_picker_decrement_month_button);
            trySetContentDescription(this.mYearSpinner, R.id.increment, R.string.date_picker_increment_year_button);
            trySetContentDescription(this.mYearSpinner, R.id.decrement, R.string.date_picker_decrement_year_button);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDate(int i, int i2, int i3) {
            this.mCurrentDate.set(i, i2, i3);
            if (this.mCurrentDate.before(this.mMinDate)) {
                this.mCurrentDate.setTimeInMillis(this.mMinDate.getTimeInMillis());
            } else if (this.mCurrentDate.after(this.mMaxDate)) {
                this.mCurrentDate.setTimeInMillis(this.mMaxDate.getTimeInMillis());
            }
        }

        private void setImeOptions(NumberPicker numberPicker, int i, int i2) {
            ((TextView) numberPicker.findViewById(R.id.numberpicker_input)).setImeOptions(i2 < i - 1 ? 5 : 6);
        }

        private void trySetContentDescription(View view, int i, int i2) {
            View findViewById = view.findViewById(i);
            if (findViewById != null) {
                findViewById.setContentDescription(this.mContext.getString(i2));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateCalendarView() {
            this.mCalendarView.setDate(this.mCurrentDate.getTimeInMillis(), false, false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateInputState() {
            InputMethodManager peekInstance = InputMethodManager.peekInstance();
            if (peekInstance != null) {
                if (peekInstance.isActive(this.mYearSpinnerInput)) {
                    this.mYearSpinnerInput.clearFocus();
                    peekInstance.hideSoftInputFromWindow(this.mDelegator.getWindowToken(), 0);
                } else if (peekInstance.isActive(this.mMonthSpinnerInput)) {
                    this.mMonthSpinnerInput.clearFocus();
                    peekInstance.hideSoftInputFromWindow(this.mDelegator.getWindowToken(), 0);
                } else if (peekInstance.isActive(this.mDaySpinnerInput)) {
                    this.mDaySpinnerInput.clearFocus();
                    peekInstance.hideSoftInputFromWindow(this.mDelegator.getWindowToken(), 0);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateSpinners() {
            if (this.mCurrentDate.equals(this.mMinDate)) {
                this.mDaySpinner.setMinValue(this.mCurrentDate.get(5));
                this.mDaySpinner.setMaxValue(this.mCurrentDate.getActualMaximum(5));
                this.mDaySpinner.setWrapSelectorWheel(false);
                this.mMonthSpinner.setDisplayedValues(null);
                this.mMonthSpinner.setMinValue(this.mCurrentDate.get(2));
                this.mMonthSpinner.setMaxValue(this.mCurrentDate.getActualMaximum(2));
                this.mMonthSpinner.setWrapSelectorWheel(false);
            } else if (this.mCurrentDate.equals(this.mMaxDate)) {
                this.mDaySpinner.setMinValue(this.mCurrentDate.getActualMinimum(5));
                this.mDaySpinner.setMaxValue(this.mCurrentDate.get(5));
                this.mDaySpinner.setWrapSelectorWheel(false);
                this.mMonthSpinner.setDisplayedValues(null);
                this.mMonthSpinner.setMinValue(this.mCurrentDate.getActualMinimum(2));
                this.mMonthSpinner.setMaxValue(this.mCurrentDate.get(2));
                this.mMonthSpinner.setWrapSelectorWheel(false);
            } else {
                this.mDaySpinner.setMinValue(1);
                this.mDaySpinner.setMaxValue(this.mCurrentDate.getActualMaximum(5));
                this.mDaySpinner.setWrapSelectorWheel(true);
                this.mMonthSpinner.setDisplayedValues(null);
                this.mMonthSpinner.setMinValue(0);
                this.mMonthSpinner.setMaxValue(11);
                this.mMonthSpinner.setWrapSelectorWheel(true);
            }
            this.mMonthSpinner.setDisplayedValues((String[]) Arrays.copyOfRange(this.mShortMonths, this.mMonthSpinner.getMinValue(), this.mMonthSpinner.getMaxValue() + 1));
            this.mYearSpinner.setMinValue(this.mMinDate.get(1));
            this.mYearSpinner.setMaxValue(this.mMaxDate.get(1));
            this.mYearSpinner.setWrapSelectorWheel(false);
            this.mYearSpinner.setValue(this.mCurrentDate.get(1));
            this.mMonthSpinner.setValue(this.mCurrentDate.get(2));
            this.mDaySpinner.setValue(this.mCurrentDate.get(5));
            if (usingNumericMonths()) {
                this.mMonthSpinnerInput.setRawInputType(2);
            }
        }

        private boolean usingNumericMonths() {
            return Character.isDigit(this.mShortMonths[0].charAt(0));
        }

        @Override // android.widget.DatePicker.DatePickerDelegate
        public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            onPopulateAccessibilityEvent(accessibilityEvent);
            return true;
        }

        @Override // android.widget.DatePicker.DatePickerDelegate
        public CalendarView getCalendarView() {
            return this.mCalendarView;
        }

        @Override // android.widget.DatePicker.DatePickerDelegate
        public boolean getCalendarViewShown() {
            return this.mCalendarView.getVisibility() == 0;
        }

        @Override // android.widget.DatePicker.DatePickerDelegate
        public int getDayOfMonth() {
            return this.mCurrentDate.get(5);
        }

        @Override // android.widget.DatePicker.DatePickerDelegate
        public int getFirstDayOfWeek() {
            return this.mCalendarView.getFirstDayOfWeek();
        }

        @Override // android.widget.DatePicker.DatePickerDelegate
        public Calendar getMaxDate() {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(this.mCalendarView.getMaxDate());
            return calendar;
        }

        @Override // android.widget.DatePicker.DatePickerDelegate
        public Calendar getMinDate() {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(this.mCalendarView.getMinDate());
            return calendar;
        }

        @Override // android.widget.DatePicker.DatePickerDelegate
        public int getMonth() {
            return this.mCurrentDate.get(2);
        }

        @Override // android.widget.DatePicker.DatePickerDelegate
        public boolean getSpinnersShown() {
            return this.mSpinners.isShown();
        }

        @Override // android.widget.DatePicker.DatePickerDelegate
        public int getYear() {
            return this.mCurrentDate.get(1);
        }

        @Override // android.widget.DatePicker.DatePickerDelegate
        public void init(int i, int i2, int i3, OnDateChangedListener onDateChangedListener) {
            setDate(i, i2, i3);
            updateSpinners();
            updateCalendarView();
            this.mOnDateChangedListener = onDateChangedListener;
        }

        @Override // android.widget.DatePicker.DatePickerDelegate
        public boolean isEnabled() {
            return this.mIsEnabled;
        }

        @Override // android.widget.DatePicker.DatePickerDelegate
        public void onConfigurationChanged(Configuration configuration) {
            setCurrentLocale(configuration.locale);
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
            accessibilityEvent.getText().add(DateUtils.formatDateTime(this.mContext, this.mCurrentDate.getTimeInMillis(), 20));
        }

        @Override // android.widget.DatePicker.DatePickerDelegate
        public void onRestoreInstanceState(Parcelable parcelable) {
            SavedState savedState = (SavedState) parcelable;
            setDate(savedState.mYear, savedState.mMonth, savedState.mDay);
            updateSpinners();
            updateCalendarView();
        }

        @Override // android.widget.DatePicker.DatePickerDelegate
        public Parcelable onSaveInstanceState(Parcelable parcelable) {
            return new SavedState(parcelable, getYear(), getMonth(), getDayOfMonth());
        }

        @Override // android.widget.DatePicker.DatePickerDelegate
        public void setCalendarViewShown(boolean z) {
            this.mCalendarView.setVisibility(z ? 0 : 8);
        }

        @Override // android.widget.DatePicker.AbstractDatePickerDelegate
        protected void setCurrentLocale(Locale locale) {
            super.setCurrentLocale(locale);
            this.mTempDate = getCalendarForLocale(this.mTempDate, locale);
            this.mMinDate = getCalendarForLocale(this.mMinDate, locale);
            this.mMaxDate = getCalendarForLocale(this.mMaxDate, locale);
            this.mCurrentDate = getCalendarForLocale(this.mCurrentDate, locale);
            this.mNumberOfMonths = this.mTempDate.getActualMaximum(2) + 1;
            this.mShortMonths = new DateFormatSymbols().getShortMonths();
            if (!usingNumericMonths()) {
                return;
            }
            this.mShortMonths = new String[this.mNumberOfMonths];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mNumberOfMonths) {
                    return;
                }
                this.mShortMonths[i2] = String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(i2 + 1));
                i = i2 + 1;
            }
        }

        @Override // android.widget.DatePicker.DatePickerDelegate
        public void setEnabled(boolean z) {
            this.mDaySpinner.setEnabled(z);
            this.mMonthSpinner.setEnabled(z);
            this.mYearSpinner.setEnabled(z);
            this.mCalendarView.setEnabled(z);
            this.mIsEnabled = z;
        }

        @Override // android.widget.DatePicker.DatePickerDelegate
        public void setFirstDayOfWeek(int i) {
            this.mCalendarView.setFirstDayOfWeek(i);
        }

        @Override // android.widget.DatePicker.DatePickerDelegate
        public void setMaxDate(long j) {
            this.mTempDate.setTimeInMillis(j);
            if (this.mTempDate.get(1) != this.mMaxDate.get(1) || this.mTempDate.get(6) == this.mMaxDate.get(6)) {
                this.mMaxDate.setTimeInMillis(j);
                this.mCalendarView.setMaxDate(j);
                if (this.mCurrentDate.after(this.mMaxDate)) {
                    this.mCurrentDate.setTimeInMillis(this.mMaxDate.getTimeInMillis());
                    updateCalendarView();
                }
                updateSpinners();
            }
        }

        @Override // android.widget.DatePicker.DatePickerDelegate
        public void setMinDate(long j) {
            this.mTempDate.setTimeInMillis(j);
            if (this.mTempDate.get(1) != this.mMinDate.get(1) || this.mTempDate.get(6) == this.mMinDate.get(6)) {
                this.mMinDate.setTimeInMillis(j);
                this.mCalendarView.setMinDate(j);
                if (this.mCurrentDate.before(this.mMinDate)) {
                    this.mCurrentDate.setTimeInMillis(this.mMinDate.getTimeInMillis());
                    updateCalendarView();
                }
                updateSpinners();
            }
        }

        @Override // android.widget.DatePicker.DatePickerDelegate
        public void setSpinnersShown(boolean z) {
            this.mSpinners.setVisibility(z ? 0 : 8);
        }

        @Override // android.widget.DatePicker.DatePickerDelegate
        public void updateDate(int i, int i2, int i3) {
            if (isNewDate(i, i2, i3)) {
                setDate(i, i2, i3);
                updateSpinners();
                updateCalendarView();
                notifyDateChanged();
            }
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/DatePicker$OnDateChangedListener.class */
    public interface OnDateChangedListener {
        void onDateChanged(DatePicker datePicker, int i, int i2, int i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/DatePicker$SavedState.class */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: android.widget.DatePicker.SavedState.1
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
        private final int mDay;
        private final int mMonth;
        private final int mYear;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.mYear = parcel.readInt();
            this.mMonth = parcel.readInt();
            this.mDay = parcel.readInt();
        }

        private SavedState(Parcelable parcelable, int i, int i2, int i3) {
            super(parcelable);
            this.mYear = i;
            this.mMonth = i2;
            this.mDay = i3;
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.mYear);
            parcel.writeInt(this.mMonth);
            parcel.writeInt(this.mDay);
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/DatePicker$ValidationCallback.class */
    public interface ValidationCallback {
        void onValidationChanged(boolean z);
    }

    public DatePicker(Context context) {
        this(context, null);
    }

    public DatePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16843612);
    }

    public DatePicker(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public DatePicker(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DatePicker, i, i2);
        int i3 = obtainStyledAttributes.getInt(16, 1);
        int i4 = obtainStyledAttributes.getInt(3, 0);
        obtainStyledAttributes.recycle();
        switch (i3) {
            case 2:
                this.mDelegate = createCalendarUIDelegate(context, attributeSet, i, i2);
                break;
            default:
                this.mDelegate = createSpinnerUIDelegate(context, attributeSet, i, i2);
                break;
        }
        if (i4 != 0) {
            setFirstDayOfWeek(i4);
        }
    }

    private DatePickerDelegate createCalendarUIDelegate(Context context, AttributeSet attributeSet, int i, int i2) {
        return new DatePickerCalendarDelegate(this, context, attributeSet, i, i2);
    }

    private DatePickerDelegate createSpinnerUIDelegate(Context context, AttributeSet attributeSet, int i, int i2) {
        return new DatePickerSpinnerDelegate(this, context, attributeSet, i, i2);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.mDelegate.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    public CalendarView getCalendarView() {
        return this.mDelegate.getCalendarView();
    }

    public boolean getCalendarViewShown() {
        return this.mDelegate.getCalendarViewShown();
    }

    public int getDayOfMonth() {
        return this.mDelegate.getDayOfMonth();
    }

    public int getFirstDayOfWeek() {
        return this.mDelegate.getFirstDayOfWeek();
    }

    public long getMaxDate() {
        return this.mDelegate.getMaxDate().getTimeInMillis();
    }

    public long getMinDate() {
        return this.mDelegate.getMinDate().getTimeInMillis();
    }

    public int getMonth() {
        return this.mDelegate.getMonth();
    }

    public boolean getSpinnersShown() {
        return this.mDelegate.getSpinnersShown();
    }

    public int getYear() {
        return this.mDelegate.getYear();
    }

    public void init(int i, int i2, int i3, OnDateChangedListener onDateChangedListener) {
        this.mDelegate.init(i, i2, i3, onDateChangedListener);
    }

    @Override // android.view.View
    public boolean isEnabled() {
        return this.mDelegate.isEnabled();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mDelegate.onConfigurationChanged(configuration);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        this.mDelegate.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        this.mDelegate.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        this.mDelegate.onPopulateAccessibilityEvent(accessibilityEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        View.BaseSavedState baseSavedState = (View.BaseSavedState) parcelable;
        super.onRestoreInstanceState(baseSavedState.getSuperState());
        this.mDelegate.onRestoreInstanceState(baseSavedState);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        return this.mDelegate.onSaveInstanceState(super.onSaveInstanceState());
    }

    public void setCalendarViewShown(boolean z) {
        this.mDelegate.setCalendarViewShown(z);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        if (this.mDelegate.isEnabled() == z) {
            return;
        }
        super.setEnabled(z);
        this.mDelegate.setEnabled(z);
    }

    public void setFirstDayOfWeek(int i) {
        if (i < 1 || i > 7) {
            throw new IllegalArgumentException("firstDayOfWeek must be between 1 and 7");
        }
        this.mDelegate.setFirstDayOfWeek(i);
    }

    public void setMaxDate(long j) {
        this.mDelegate.setMaxDate(j);
    }

    public void setMinDate(long j) {
        this.mDelegate.setMinDate(j);
    }

    public void setSpinnersShown(boolean z) {
        this.mDelegate.setSpinnersShown(z);
    }

    public void setValidationCallback(ValidationCallback validationCallback) {
        this.mDelegate.setValidationCallback(validationCallback);
    }

    public void updateDate(int i, int i2, int i3) {
        this.mDelegate.updateDate(i, i2, i3);
    }
}
