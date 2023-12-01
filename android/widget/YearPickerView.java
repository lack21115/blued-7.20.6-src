package android.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import com.android.internal.R;
import java.util.Calendar;

/* loaded from: source-4181928-dex2jar.jar:android/widget/YearPickerView.class */
class YearPickerView extends ListView implements AdapterView.OnItemClickListener, OnDateChangedListener {
    private final YearAdapter mAdapter;
    private final int mChildSize;
    private DatePickerController mController;
    private final Calendar mMaxDate;
    private final Calendar mMinDate;
    private int mSelectedPosition;
    private final int mViewSize;
    private int mYearSelectedCircleColor;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/YearPickerView$YearAdapter.class */
    public class YearAdapter extends ArrayAdapter<Integer> {
        int mItemTextAppearanceResId;

        public YearAdapter(Context context, int i) {
            super(context, i);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            boolean z = true;
            TextViewWithCircularIndicator textViewWithCircularIndicator = (TextViewWithCircularIndicator) super.getView(i, view, viewGroup);
            textViewWithCircularIndicator.setTextAppearance(getContext(), this.mItemTextAppearanceResId);
            textViewWithCircularIndicator.requestLayout();
            if (YearPickerView.this.mController.getSelectedDay().get(1) != getItem(i).intValue()) {
                z = false;
            }
            textViewWithCircularIndicator.setDrawIndicator(z);
            if (z) {
                textViewWithCircularIndicator.setCircleColor(YearPickerView.this.mYearSelectedCircleColor);
            }
            return textViewWithCircularIndicator;
        }

        public void setItemTextAppearance(int i) {
            this.mItemTextAppearanceResId = i;
        }
    }

    public YearPickerView(Context context) {
        this(context, null);
    }

    public YearPickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    public YearPickerView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public YearPickerView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mMinDate = Calendar.getInstance();
        this.mMaxDate = Calendar.getInstance();
        this.mSelectedPosition = -1;
        setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        Resources resources = context.getResources();
        this.mViewSize = resources.getDimensionPixelOffset(R.dimen.datepicker_view_animator_height);
        this.mChildSize = resources.getDimensionPixelOffset(R.dimen.datepicker_year_label_height);
        setVerticalFadingEdgeEnabled(true);
        setFadingEdgeLength(this.mChildSize / 3);
        setPadding(0, resources.getDimensionPixelSize(R.dimen.datepicker_year_picker_padding_top), 0, 0);
        setOnItemClickListener(this);
        setDividerHeight(0);
        this.mAdapter = new YearAdapter(getContext(), R.layout.year_label_text_view);
        setAdapter((ListAdapter) this.mAdapter);
    }

    private void updateAdapterData() {
        this.mAdapter.clear();
        int i = this.mMaxDate.get(1);
        int i2 = this.mMinDate.get(1);
        while (true) {
            int i3 = i2;
            if (i3 > i) {
                return;
            }
            this.mAdapter.add(Integer.valueOf(i3));
            i2 = i3 + 1;
        }
    }

    public int getFirstPositionOffset() {
        View childAt = getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return childAt.getTop();
    }

    public int getYearSelectedCircleColor() {
        return this.mYearSelectedCircleColor;
    }

    public void init(DatePickerController datePickerController) {
        this.mController = datePickerController;
        this.mController.registerOnDateChangedListener(this);
        updateAdapterData();
        onDateChanged();
    }

    @Override // android.widget.OnDateChangedListener
    public void onDateChanged() {
        updateAdapterData();
        this.mAdapter.notifyDataSetChanged();
        postSetSelectionCentered(this.mController.getSelectedDay().get(1) - this.mMinDate.get(1));
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (accessibilityEvent.getEventType() == 4096) {
            accessibilityEvent.setFromIndex(0);
            accessibilityEvent.setToIndex(0);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.mController.tryVibrate();
        if (i != this.mSelectedPosition) {
            this.mSelectedPosition = i;
            this.mAdapter.notifyDataSetChanged();
        }
        this.mController.onYearSelected(this.mAdapter.getItem(i).intValue());
    }

    public void postSetSelectionCentered(int i) {
        postSetSelectionFromTop(i, (this.mViewSize / 2) - (this.mChildSize / 2));
    }

    public void postSetSelectionFromTop(final int i, final int i2) {
        post(new Runnable() { // from class: android.widget.YearPickerView.1
            @Override // java.lang.Runnable
            public void run() {
                YearPickerView.this.setSelectionFromTop(i, i2);
                YearPickerView.this.requestLayout();
            }
        });
    }

    void setItemTextAppearance(int i) {
        this.mAdapter.setItemTextAppearance(i);
    }

    public void setRange(Calendar calendar, Calendar calendar2) {
        this.mMinDate.setTimeInMillis(calendar.getTimeInMillis());
        this.mMaxDate.setTimeInMillis(calendar2.getTimeInMillis());
        updateAdapterData();
    }

    public void setYearSelectedCircleColor(int i) {
        if (i != this.mYearSelectedCircleColor) {
            this.mYearSelectedCircleColor = i;
        }
        requestLayout();
    }
}
