package android.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.SimpleMonthView;
import com.android.internal.R;
import java.util.Calendar;

/* loaded from: source-4181928-dex2jar.jar:android/widget/SimpleMonthAdapter.class */
class SimpleMonthAdapter extends BaseAdapter {
    private final Context mContext;
    private int mFirstDayOfWeek;
    private OnDaySelectedListener mOnDaySelectedListener;
    private final Calendar mMinDate = Calendar.getInstance();
    private final Calendar mMaxDate = Calendar.getInstance();
    private Calendar mSelectedDay = Calendar.getInstance();
    private ColorStateList mCalendarTextColors = ColorStateList.valueOf(View.MEASURED_STATE_MASK);
    private final SimpleMonthView.OnDayClickListener mOnDayClickListener = new SimpleMonthView.OnDayClickListener() { // from class: android.widget.SimpleMonthAdapter.1
        @Override // android.widget.SimpleMonthView.OnDayClickListener
        public void onDayClick(SimpleMonthView simpleMonthView, Calendar calendar) {
            if (calendar == null || !SimpleMonthAdapter.this.isCalendarInRange(calendar)) {
                return;
            }
            SimpleMonthAdapter.this.setSelectedDay(calendar);
            if (SimpleMonthAdapter.this.mOnDaySelectedListener != null) {
                SimpleMonthAdapter.this.mOnDaySelectedListener.onDaySelected(SimpleMonthAdapter.this, calendar);
            }
        }
    };

    /* loaded from: source-4181928-dex2jar.jar:android/widget/SimpleMonthAdapter$OnDaySelectedListener.class */
    public interface OnDaySelectedListener {
        void onDaySelected(SimpleMonthAdapter simpleMonthAdapter, Calendar calendar);
    }

    public SimpleMonthAdapter(Context context) {
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isCalendarInRange(Calendar calendar) {
        return calendar.compareTo(this.mMinDate) >= 0 && calendar.compareTo(this.mMaxDate) <= 0;
    }

    private boolean isSelectedDayInMonth(int i, int i2) {
        return this.mSelectedDay.get(1) == i && this.mSelectedDay.get(2) == i2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ((this.mMaxDate.get(1) - this.mMinDate.get(1)) * 12) + (this.mMaxDate.get(2) - this.mMinDate.get(2)) + 1;
    }

    public int getFirstDayOfWeek() {
        return this.mFirstDayOfWeek;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        SimpleMonthView simpleMonthView;
        if (view != null) {
            simpleMonthView = (SimpleMonthView) view;
        } else {
            SimpleMonthView simpleMonthView2 = new SimpleMonthView(this.mContext);
            simpleMonthView2.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
            simpleMonthView2.setClickable(true);
            simpleMonthView2.setOnDayClickListener(this.mOnDayClickListener);
            simpleMonthView = simpleMonthView2;
            if (this.mCalendarTextColors != null) {
                simpleMonthView2.setTextColor(this.mCalendarTextColors);
                simpleMonthView = simpleMonthView2;
            }
        }
        int i2 = this.mMinDate.get(2);
        int i3 = this.mMinDate.get(1);
        int i4 = i + i2;
        int i5 = i4 % 12;
        int i6 = (i4 / 12) + i3;
        int i7 = isSelectedDayInMonth(i6, i5) ? this.mSelectedDay.get(5) : -1;
        simpleMonthView.reuse();
        simpleMonthView.setMonthParams(i7, i5, i6, this.mFirstDayOfWeek, (i2 == i5 && i3 == i6) ? this.mMinDate.get(5) : 1, (this.mMaxDate.get(2) == i5 && this.mMaxDate.get(1) == i6) ? this.mMaxDate.get(5) : 31);
        simpleMonthView.invalidate();
        return simpleMonthView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCalendarTextAppearance(int i) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(i, R.styleable.TextAppearance);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(3);
        if (colorStateList != null) {
            this.mCalendarTextColors = colorStateList;
        }
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCalendarTextColor(ColorStateList colorStateList) {
        this.mCalendarTextColors = colorStateList;
    }

    public void setFirstDayOfWeek(int i) {
        this.mFirstDayOfWeek = i;
        notifyDataSetInvalidated();
    }

    public void setOnDaySelectedListener(OnDaySelectedListener onDaySelectedListener) {
        this.mOnDaySelectedListener = onDaySelectedListener;
    }

    public void setRange(Calendar calendar, Calendar calendar2) {
        this.mMinDate.setTimeInMillis(calendar.getTimeInMillis());
        this.mMaxDate.setTimeInMillis(calendar2.getTimeInMillis());
        notifyDataSetInvalidated();
    }

    public void setSelectedDay(Calendar calendar) {
        this.mSelectedDay = calendar;
        notifyDataSetChanged();
    }
}
