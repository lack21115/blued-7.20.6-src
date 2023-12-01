package android.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.android.internal.R;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: source-4181928-dex2jar.jar:android/widget/CalendarView.class */
public class CalendarView extends FrameLayout {
    private static final String LOG_TAG = "CalendarView";
    private static final int MODE_HOLO = 0;
    private static final int MODE_MATERIAL = 1;
    private final CalendarViewDelegate mDelegate;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/CalendarView$AbstractCalendarViewDelegate.class */
    public static abstract class AbstractCalendarViewDelegate implements CalendarViewDelegate {
        private static final String DATE_FORMAT = "MM/dd/yyyy";
        protected static final DateFormat DATE_FORMATTER = new SimpleDateFormat(DATE_FORMAT);
        protected static final String DEFAULT_MAX_DATE = "01/01/2100";
        protected static final String DEFAULT_MIN_DATE = "01/01/1900";
        protected Context mContext;
        protected Locale mCurrentLocale;
        protected CalendarView mDelegator;

        /* JADX INFO: Access modifiers changed from: package-private */
        public AbstractCalendarViewDelegate(CalendarView calendarView, Context context) {
            this.mDelegator = calendarView;
            this.mContext = context;
            setCurrentLocale(Locale.getDefault());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public boolean parseDate(String str, Calendar calendar) {
            try {
                calendar.setTime(DATE_FORMATTER.parse(str));
                return true;
            } catch (ParseException e) {
                Log.w(CalendarView.LOG_TAG, "Date: " + str + " not in format: " + DATE_FORMAT);
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void setCurrentLocale(Locale locale) {
            if (locale.equals(this.mCurrentLocale)) {
                return;
            }
            this.mCurrentLocale = locale;
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/CalendarView$CalendarViewDelegate.class */
    private interface CalendarViewDelegate {
        long getDate();

        int getDateTextAppearance();

        int getFirstDayOfWeek();

        int getFocusedMonthDateColor();

        long getMaxDate();

        long getMinDate();

        Drawable getSelectedDateVerticalBar();

        int getSelectedWeekBackgroundColor();

        boolean getShowWeekNumber();

        int getShownWeekCount();

        int getUnfocusedMonthDateColor();

        int getWeekDayTextAppearance();

        int getWeekNumberColor();

        int getWeekSeparatorLineColor();

        void onConfigurationChanged(Configuration configuration);

        void setDate(long j);

        void setDate(long j, boolean z, boolean z2);

        void setDateTextAppearance(int i);

        void setFirstDayOfWeek(int i);

        void setFocusedMonthDateColor(int i);

        void setMaxDate(long j);

        void setMinDate(long j);

        void setOnDateChangeListener(OnDateChangeListener onDateChangeListener);

        void setSelectedDateVerticalBar(int i);

        void setSelectedDateVerticalBar(Drawable drawable);

        void setSelectedWeekBackgroundColor(int i);

        void setShowWeekNumber(boolean z);

        void setShownWeekCount(int i);

        void setUnfocusedMonthDateColor(int i);

        void setWeekDayTextAppearance(int i);

        void setWeekNumberColor(int i);

        void setWeekSeparatorLineColor(int i);
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/CalendarView$OnDateChangeListener.class */
    public interface OnDateChangeListener {
        void onSelectedDayChange(CalendarView calendarView, int i, int i2, int i3);
    }

    public CalendarView(Context context) {
        this(context, null);
    }

    public CalendarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.calendarViewStyle);
    }

    public CalendarView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public CalendarView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CalendarView, i, i2);
        int i3 = obtainStyledAttributes.getInt(13, 0);
        obtainStyledAttributes.recycle();
        switch (i3) {
            case 0:
                this.mDelegate = new CalendarViewLegacyDelegate(this, context, attributeSet, i, i2);
                return;
            case 1:
                this.mDelegate = new CalendarViewMaterialDelegate(this, context, attributeSet, i, i2);
                return;
            default:
                throw new IllegalArgumentException("invalid calendarViewMode attribute");
        }
    }

    public long getDate() {
        return this.mDelegate.getDate();
    }

    public int getDateTextAppearance() {
        return this.mDelegate.getDateTextAppearance();
    }

    public int getFirstDayOfWeek() {
        return this.mDelegate.getFirstDayOfWeek();
    }

    public int getFocusedMonthDateColor() {
        return this.mDelegate.getFocusedMonthDateColor();
    }

    public long getMaxDate() {
        return this.mDelegate.getMaxDate();
    }

    public long getMinDate() {
        return this.mDelegate.getMinDate();
    }

    public Drawable getSelectedDateVerticalBar() {
        return this.mDelegate.getSelectedDateVerticalBar();
    }

    public int getSelectedWeekBackgroundColor() {
        return this.mDelegate.getSelectedWeekBackgroundColor();
    }

    public boolean getShowWeekNumber() {
        return this.mDelegate.getShowWeekNumber();
    }

    public int getShownWeekCount() {
        return this.mDelegate.getShownWeekCount();
    }

    public int getUnfocusedMonthDateColor() {
        return this.mDelegate.getUnfocusedMonthDateColor();
    }

    public int getWeekDayTextAppearance() {
        return this.mDelegate.getWeekDayTextAppearance();
    }

    public int getWeekNumberColor() {
        return this.mDelegate.getWeekNumberColor();
    }

    public int getWeekSeparatorLineColor() {
        return this.mDelegate.getWeekSeparatorLineColor();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mDelegate.onConfigurationChanged(configuration);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        accessibilityEvent.setClassName(CalendarView.class.getName());
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        accessibilityNodeInfo.setClassName(CalendarView.class.getName());
    }

    public void setDate(long j) {
        this.mDelegate.setDate(j);
    }

    public void setDate(long j, boolean z, boolean z2) {
        this.mDelegate.setDate(j, z, z2);
    }

    public void setDateTextAppearance(int i) {
        this.mDelegate.setDateTextAppearance(i);
    }

    public void setFirstDayOfWeek(int i) {
        this.mDelegate.setFirstDayOfWeek(i);
    }

    public void setFocusedMonthDateColor(int i) {
        this.mDelegate.setFocusedMonthDateColor(i);
    }

    public void setMaxDate(long j) {
        this.mDelegate.setMaxDate(j);
    }

    public void setMinDate(long j) {
        this.mDelegate.setMinDate(j);
    }

    public void setOnDateChangeListener(OnDateChangeListener onDateChangeListener) {
        this.mDelegate.setOnDateChangeListener(onDateChangeListener);
    }

    public void setSelectedDateVerticalBar(int i) {
        this.mDelegate.setSelectedDateVerticalBar(i);
    }

    public void setSelectedDateVerticalBar(Drawable drawable) {
        this.mDelegate.setSelectedDateVerticalBar(drawable);
    }

    public void setSelectedWeekBackgroundColor(int i) {
        this.mDelegate.setSelectedWeekBackgroundColor(i);
    }

    public void setShowWeekNumber(boolean z) {
        this.mDelegate.setShowWeekNumber(z);
    }

    public void setShownWeekCount(int i) {
        this.mDelegate.setShownWeekCount(i);
    }

    public void setUnfocusedMonthDateColor(int i) {
        this.mDelegate.setUnfocusedMonthDateColor(i);
    }

    public void setWeekDayTextAppearance(int i) {
        this.mDelegate.setWeekDayTextAppearance(i);
    }

    public void setWeekNumberColor(int i) {
        this.mDelegate.setWeekNumberColor(i);
    }

    public void setWeekSeparatorLineColor(int i) {
        this.mDelegate.setWeekSeparatorLineColor(i);
    }
}
