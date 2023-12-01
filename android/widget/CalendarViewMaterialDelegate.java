package android.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.MathUtils;
import android.widget.CalendarView;
import android.widget.DayPickerView;
import com.android.internal.R;
import java.util.Calendar;
import java.util.Locale;
import libcore.icu.LocaleData;

/* loaded from: source-4181928-dex2jar.jar:android/widget/CalendarViewMaterialDelegate.class */
class CalendarViewMaterialDelegate extends CalendarView.AbstractCalendarViewDelegate {
    private final DayPickerView mDayPickerView;
    private CalendarView.OnDateChangeListener mOnDateChangeListener;
    private final DayPickerView.OnDaySelectedListener mOnDaySelectedListener;

    public CalendarViewMaterialDelegate(CalendarView calendarView, Context context, AttributeSet attributeSet, int i, int i2) {
        super(calendarView, context);
        this.mOnDaySelectedListener = new DayPickerView.OnDaySelectedListener() { // from class: android.widget.CalendarViewMaterialDelegate.1
            @Override // android.widget.DayPickerView.OnDaySelectedListener
            public void onDaySelected(DayPickerView dayPickerView, Calendar calendar) {
                if (CalendarViewMaterialDelegate.this.mOnDateChangeListener != null) {
                    CalendarViewMaterialDelegate.this.mOnDateChangeListener.onSelectedDayChange(CalendarViewMaterialDelegate.this.mDelegator, calendar.get(1), calendar.get(2), calendar.get(5));
                }
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CalendarView, i, i2);
        int i3 = obtainStyledAttributes.getInt(0, LocaleData.get(Locale.getDefault()).firstDayOfWeek.intValue());
        long parseDateToMillis = parseDateToMillis(obtainStyledAttributes.getString(2), "01/01/1900");
        long parseDateToMillis2 = parseDateToMillis(obtainStyledAttributes.getString(3), "01/01/2100");
        if (parseDateToMillis2 < parseDateToMillis) {
            throw new IllegalArgumentException("max date cannot be before min date");
        }
        long constrain = MathUtils.constrain(System.currentTimeMillis(), parseDateToMillis, parseDateToMillis2);
        int resourceId = obtainStyledAttributes.getResourceId(12, R.style.TextAppearance_DeviceDefault_Small);
        obtainStyledAttributes.recycle();
        this.mDayPickerView = new DayPickerView(context);
        this.mDayPickerView.setFirstDayOfWeek(i3);
        this.mDayPickerView.setCalendarTextAppearance(resourceId);
        this.mDayPickerView.setMinDate(parseDateToMillis);
        this.mDayPickerView.setMaxDate(parseDateToMillis2);
        this.mDayPickerView.setDate(constrain, false, true);
        this.mDayPickerView.setOnDaySelectedListener(this.mOnDaySelectedListener);
        calendarView.addView(this.mDayPickerView);
    }

    private long parseDateToMillis(String str, String str2) {
        Calendar calendar = Calendar.getInstance();
        if (TextUtils.isEmpty(str) || !parseDate(str, calendar)) {
            parseDate(str2, calendar);
        }
        return calendar.getTimeInMillis();
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public long getDate() {
        return this.mDayPickerView.getDate();
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public int getDateTextAppearance() {
        return 0;
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public int getFirstDayOfWeek() {
        return this.mDayPickerView.getFirstDayOfWeek();
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public int getFocusedMonthDateColor() {
        return 0;
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public long getMaxDate() {
        return this.mDayPickerView.getMaxDate();
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public long getMinDate() {
        return this.mDayPickerView.getMinDate();
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public Drawable getSelectedDateVerticalBar() {
        return null;
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public int getSelectedWeekBackgroundColor() {
        return 0;
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public boolean getShowWeekNumber() {
        return false;
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public int getShownWeekCount() {
        return 0;
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public int getUnfocusedMonthDateColor() {
        return 0;
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public int getWeekDayTextAppearance() {
        return 0;
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public int getWeekNumberColor() {
        return 0;
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public int getWeekSeparatorLineColor() {
        return 0;
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public void setDate(long j) {
        this.mDayPickerView.setDate(j, true, false);
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public void setDate(long j, boolean z, boolean z2) {
        this.mDayPickerView.setDate(j, z, z2);
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public void setDateTextAppearance(int i) {
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public void setFirstDayOfWeek(int i) {
        this.mDayPickerView.setFirstDayOfWeek(i);
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public void setFocusedMonthDateColor(int i) {
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public void setMaxDate(long j) {
        this.mDayPickerView.setMaxDate(j);
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public void setMinDate(long j) {
        this.mDayPickerView.setMinDate(j);
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public void setOnDateChangeListener(CalendarView.OnDateChangeListener onDateChangeListener) {
        this.mOnDateChangeListener = onDateChangeListener;
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public void setSelectedDateVerticalBar(int i) {
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public void setSelectedDateVerticalBar(Drawable drawable) {
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public void setSelectedWeekBackgroundColor(int i) {
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public void setShowWeekNumber(boolean z) {
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public void setShownWeekCount(int i) {
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public void setUnfocusedMonthDateColor(int i) {
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public void setWeekDayTextAppearance(int i) {
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public void setWeekNumberColor(int i) {
    }

    @Override // android.widget.CalendarView.CalendarViewDelegate
    public void setWeekSeparatorLineColor(int i) {
    }
}
