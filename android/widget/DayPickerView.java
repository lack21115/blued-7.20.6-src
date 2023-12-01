package android.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.util.MathUtils;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AbsListView;
import android.widget.SimpleMonthAdapter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-4181928-dex2jar.jar:android/widget/DayPickerView.class */
public class DayPickerView extends ListView implements AbsListView.OnScrollListener {
    private static final int GOTO_SCROLL_DURATION = 250;
    private static final int LIST_TOP_OFFSET = -1;
    private static final int SCROLL_CHANGE_DELAY = 40;
    private static final String TAG = "DayPickerView";
    private final SimpleMonthAdapter mAdapter;
    private int mCurrentMonthDisplayed;
    private int mCurrentScrollState;
    private Calendar mMaxDate;
    private Calendar mMinDate;
    private OnDaySelectedListener mOnDaySelectedListener;
    private boolean mPerformingScroll;
    private int mPreviousScrollState;
    private final SimpleMonthAdapter.OnDaySelectedListener mProxyOnDaySelectedListener;
    private final ScrollStateRunnable mScrollStateChangedRunnable;
    private Calendar mSelectedDay;
    private Calendar mTempCalendar;
    private Calendar mTempDay;
    private SimpleDateFormat mYearFormat;

    /* loaded from: source-4181928-dex2jar.jar:android/widget/DayPickerView$OnDaySelectedListener.class */
    public interface OnDaySelectedListener {
        void onDaySelected(DayPickerView dayPickerView, Calendar calendar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/DayPickerView$ScrollStateRunnable.class */
    public class ScrollStateRunnable implements Runnable {
        private int mNewState;
        private View mParent;

        ScrollStateRunnable(View view) {
            this.mParent = view;
        }

        public void doScrollStateChange(AbsListView absListView, int i) {
            this.mParent.removeCallbacks(this);
            this.mNewState = i;
            this.mParent.postDelayed(this, 40L);
        }

        @Override // java.lang.Runnable
        public void run() {
            View view;
            DayPickerView.this.mCurrentScrollState = this.mNewState;
            if (Log.isLoggable(DayPickerView.TAG, 3)) {
                Log.d(DayPickerView.TAG, "new scroll state: " + this.mNewState + " old state: " + DayPickerView.this.mPreviousScrollState);
            }
            if (this.mNewState != 0 || DayPickerView.this.mPreviousScrollState == 0 || DayPickerView.this.mPreviousScrollState == 1) {
                DayPickerView.this.mPreviousScrollState = this.mNewState;
                return;
            }
            DayPickerView.this.mPreviousScrollState = this.mNewState;
            int i = 0;
            View childAt = DayPickerView.this.getChildAt(0);
            while (true) {
                view = childAt;
                if (view == null || view.getBottom() > 0) {
                    break;
                }
                i++;
                childAt = DayPickerView.this.getChildAt(i);
            }
            if (view == null) {
                return;
            }
            boolean z = (DayPickerView.this.getFirstVisiblePosition() == 0 || DayPickerView.this.getLastVisiblePosition() == DayPickerView.this.getCount() - 1) ? false : true;
            int top = view.getTop();
            int bottom = view.getBottom();
            int height = DayPickerView.this.getHeight() / 2;
            if (!z || top >= -1) {
                return;
            }
            if (bottom > height) {
                DayPickerView.this.smoothScrollBy(top, 250);
            } else {
                DayPickerView.this.smoothScrollBy(bottom, 250);
            }
        }
    }

    public DayPickerView(Context context) {
        super(context);
        this.mAdapter = new SimpleMonthAdapter(getContext());
        this.mScrollStateChangedRunnable = new ScrollStateRunnable(this);
        this.mYearFormat = new SimpleDateFormat("yyyy", Locale.getDefault());
        this.mSelectedDay = Calendar.getInstance();
        this.mTempDay = Calendar.getInstance();
        this.mMinDate = Calendar.getInstance();
        this.mMaxDate = Calendar.getInstance();
        this.mPreviousScrollState = 0;
        this.mCurrentScrollState = 0;
        this.mProxyOnDaySelectedListener = new SimpleMonthAdapter.OnDaySelectedListener() { // from class: android.widget.DayPickerView.2
            @Override // android.widget.SimpleMonthAdapter.OnDaySelectedListener
            public void onDaySelected(SimpleMonthAdapter simpleMonthAdapter, Calendar calendar) {
                if (DayPickerView.this.mOnDaySelectedListener != null) {
                    DayPickerView.this.mOnDaySelectedListener.onDaySelected(DayPickerView.this, calendar);
                }
            }
        };
        setAdapter((ListAdapter) this.mAdapter);
        setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        setDrawSelectorOnTop(false);
        setUpListView();
        goTo(this.mSelectedDay.getTimeInMillis(), false, false, true);
        this.mAdapter.setOnDaySelectedListener(this.mProxyOnDaySelectedListener);
    }

    private Calendar findAccessibilityFocus() {
        Calendar accessibilityFocus;
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                return null;
            }
            View childAt = getChildAt(i2);
            if ((childAt instanceof SimpleMonthView) && (accessibilityFocus = ((SimpleMonthView) childAt).getAccessibilityFocus()) != null) {
                return accessibilityFocus;
            }
            i = i2 + 1;
        }
    }

    private int getDiffMonths(Calendar calendar, Calendar calendar2) {
        return (calendar2.get(2) - calendar.get(2)) + ((calendar2.get(1) - calendar.get(1)) * 12);
    }

    private String getMonthAndYearString(Calendar calendar) {
        return calendar.getDisplayName(2, 2, Locale.getDefault()) + " " + this.mYearFormat.format(calendar.getTime());
    }

    private int getPositionFromDay(long j) {
        return MathUtils.constrain(getDiffMonths(this.mMinDate, getTempCalendarForTime(j)), 0, getDiffMonths(this.mMinDate, this.mMaxDate));
    }

    private Calendar getTempCalendarForTime(long j) {
        if (this.mTempCalendar == null) {
            this.mTempCalendar = Calendar.getInstance();
        }
        this.mTempCalendar.setTimeInMillis(j);
        return this.mTempCalendar;
    }

    private boolean goTo(long j, boolean z, boolean z2, boolean z3) {
        int i;
        View childAt;
        if (z2) {
            this.mSelectedDay.setTimeInMillis(j);
        }
        this.mTempDay.setTimeInMillis(j);
        int positionFromDay = getPositionFromDay(j);
        while (true) {
            int i2 = i;
            childAt = getChildAt(i2);
            i = (childAt != null && childAt.getTop() < 0) ? i2 + 1 : 0;
        }
        int positionForView = childAt != null ? getPositionForView(childAt) : 0;
        if (z2) {
            this.mAdapter.setSelectedDay(this.mSelectedDay);
        }
        if (positionFromDay == positionForView && !z3) {
            if (z2) {
                setMonthDisplayed(this.mSelectedDay);
                return false;
            }
            return false;
        }
        setMonthDisplayed(this.mTempDay);
        this.mPreviousScrollState = 2;
        if (z) {
            smoothScrollToPositionFromTop(positionFromDay, -1, 250);
            return true;
        }
        postSetSelection(positionFromDay);
        return false;
    }

    private boolean restoreAccessibilityFocus(Calendar calendar) {
        if (calendar == null) {
            return false;
        }
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                return false;
            }
            View childAt = getChildAt(i2);
            if ((childAt instanceof SimpleMonthView) && ((SimpleMonthView) childAt).restoreAccessibilityFocus(calendar)) {
                return true;
            }
            i = i2 + 1;
        }
    }

    private void setUpListView() {
        setCacheColorHint(0);
        setDivider(null);
        setItemsCanFocus(true);
        setFastScrollEnabled(false);
        setVerticalScrollBarEnabled(false);
        setOnScrollListener(this);
        setFadingEdgeLength(0);
        setFriction(ViewConfiguration.getScrollFriction());
    }

    public long getDate() {
        return this.mSelectedDay.getTimeInMillis();
    }

    public int getFirstDayOfWeek() {
        return this.mAdapter.getFirstDayOfWeek();
    }

    public long getMaxDate() {
        return this.mMaxDate.getTimeInMillis();
    }

    public long getMinDate() {
        return this.mMinDate.getTimeInMillis();
    }

    public int getMostVisiblePosition() {
        View childAt;
        int firstVisiblePosition = getFirstVisiblePosition();
        int height = getHeight();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i4 < height && (childAt = getChildAt(i3)) != null) {
            i4 = childAt.getBottom();
            int min = Math.min(i4, height) - Math.max(0, childAt.getTop());
            int i5 = i;
            if (min > i) {
                i2 = i3;
                i5 = min;
            }
            i3++;
            i = i5;
        }
        return firstVisiblePosition + i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ListView, android.widget.AbsListView
    public void layoutChildren() {
        Calendar findAccessibilityFocus = findAccessibilityFocus();
        super.layoutChildren();
        if (this.mPerformingScroll) {
            this.mPerformingScroll = false;
        } else {
            restoreAccessibilityFocus(findAccessibilityFocus);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        this.mYearFormat = new SimpleDateFormat("yyyy", Locale.getDefault());
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setItemCount(-1);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
        accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
    }

    public void onRangeChanged() {
        this.mAdapter.setRange(this.mMinDate, this.mMaxDate);
        goTo(this.mSelectedDay.getTimeInMillis(), false, false, true);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (((SimpleMonthView) absListView.getChildAt(0)) == null) {
            return;
        }
        this.mPreviousScrollState = this.mCurrentScrollState;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        this.mScrollStateChangedRunnable.doScrollStateChange(absListView, i);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean performAccessibilityAction(int i, Bundle bundle) {
        View childAt;
        if (i == 4096 || i == 8192) {
            int firstVisiblePosition = getFirstVisiblePosition();
            int i2 = firstVisiblePosition / 12;
            int i3 = this.mMinDate.get(1);
            Calendar calendar = Calendar.getInstance();
            calendar.set(i2 + i3, firstVisiblePosition % 12, 1);
            if (i == 4096) {
                calendar.add(2, 1);
                if (calendar.get(2) == 12) {
                    calendar.set(2, 0);
                    calendar.add(1, 1);
                }
            } else if (i == 8192 && (childAt = getChildAt(0)) != null && childAt.getTop() >= -1) {
                calendar.add(2, -1);
                if (calendar.get(2) == -1) {
                    calendar.set(2, 11);
                    calendar.add(1, -1);
                }
            }
            announceForAccessibility(getMonthAndYearString(calendar));
            goTo(calendar.getTimeInMillis(), true, false, true);
            this.mPerformingScroll = true;
            return true;
        }
        return super.performAccessibilityAction(i, bundle);
    }

    public void postSetSelection(final int i) {
        clearFocus();
        post(new Runnable() { // from class: android.widget.DayPickerView.1
            @Override // java.lang.Runnable
            public void run() {
                DayPickerView.this.setSelection(i);
            }
        });
        onScrollStateChanged(this, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCalendarTextAppearance(int i) {
        this.mAdapter.setCalendarTextAppearance(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCalendarTextColor(ColorStateList colorStateList) {
        this.mAdapter.setCalendarTextColor(colorStateList);
    }

    public void setDate(long j) {
        setDate(j, false, true);
    }

    public void setDate(long j, boolean z, boolean z2) {
        goTo(j, z, true, z2);
    }

    public void setFirstDayOfWeek(int i) {
        this.mAdapter.setFirstDayOfWeek(i);
    }

    public void setMaxDate(long j) {
        this.mMaxDate.setTimeInMillis(j);
        onRangeChanged();
    }

    public void setMinDate(long j) {
        this.mMinDate.setTimeInMillis(j);
        onRangeChanged();
    }

    protected void setMonthDisplayed(Calendar calendar) {
        if (this.mCurrentMonthDisplayed != calendar.get(2)) {
            this.mCurrentMonthDisplayed = calendar.get(2);
            invalidateViews();
        }
    }

    public void setOnDaySelectedListener(OnDaySelectedListener onDaySelectedListener) {
        this.mOnDaySelectedListener = onDaySelectedListener;
    }
}
