package com.soft.blued.ui.home.help;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.blued.android.framework.utils.DensityUtils;
import com.bytedance.applog.tracker.Tracker;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/home/help/FragmentViewContainer.class */
public class FragmentViewContainer extends ScrollView {

    /* renamed from: a  reason: collision with root package name */
    private Context f17345a;
    private LinearLayout b;

    /* renamed from: c  reason: collision with root package name */
    private int f17346c;
    private int d;

    public FragmentViewContainer(Context context) {
        super(context);
        a(context);
    }

    public FragmentViewContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public FragmentViewContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private TextView a(FragmentRecord fragmentRecord, int i) {
        TextView textView = new TextView(this.f17345a);
        textView.setLayoutParams(new ViewGroup.LayoutParams(-1, this.f17346c));
        if (i == 0) {
            textView.setTextColor(Color.parseColor("#333333"));
            textView.setTextSize(16.0f);
        }
        textView.setGravity(16);
        int i2 = this.d;
        textView.setPadding((int) (i2 + (i * i2 * 1.5d)), 0, i2, 0);
        textView.setCompoundDrawablePadding(this.d / 2);
        TypedArray obtainStyledAttributes = this.f17345a.obtainStyledAttributes(new int[]{R.attr.selectableItemBackground});
        textView.setBackgroundDrawable(obtainStyledAttributes.getDrawable(0));
        obtainStyledAttributes.recycle();
        textView.setText(fragmentRecord.f17344a);
        return textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        int childCount = this.b.getChildCount();
        while (true) {
            int i2 = childCount - 1;
            if (i2 < 0) {
                return;
            }
            View childAt = this.b.getChildAt(i2);
            if (childAt.getTag(com.soft.blued.R.id.hierarchy) != null && ((Integer) childAt.getTag(com.soft.blued.R.id.hierarchy)).intValue() >= i) {
                this.b.removeView(childAt);
            }
            childCount = i2;
        }
    }

    private void a(Context context) {
        this.f17345a = context;
        HorizontalScrollView horizontalScrollView = new HorizontalScrollView(context);
        LinearLayout linearLayout = new LinearLayout(context);
        this.b = linearLayout;
        linearLayout.setOrientation(1);
        horizontalScrollView.addView(this.b);
        addView(horizontalScrollView);
        this.f17346c = DensityUtils.a(context, 50.0f);
        this.d = DensityUtils.a(context, 16.0f);
    }

    private void a(List<FragmentRecord> list, int i, TextView textView) {
        int size = list.size();
        while (true) {
            int i2 = size - 1;
            if (i2 < 0) {
                return;
            }
            FragmentRecord fragmentRecord = list.get(i2);
            final TextView a2 = a(fragmentRecord, i);
            a2.setTag(com.soft.blued.R.id.hierarchy, Integer.valueOf(i));
            final List<FragmentRecord> list2 = fragmentRecord.b;
            if (list2 == null || list2.size() <= 0) {
                int paddingLeft = a2.getPaddingLeft();
                int i3 = this.d;
                a2.setPadding(paddingLeft + i3, 0, i3, 0);
            } else {
                a2.setCompoundDrawablesWithIntrinsicBounds(2131233203, 0, 0, 0);
                final int i4 = i + 1;
                a2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.home.help.FragmentViewContainer.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Tracker.onClick(view);
                        if (view.getTag(com.soft.blued.R.id.isexpand) == null) {
                            a2.setTag(com.soft.blued.R.id.isexpand, true);
                            FragmentViewContainer.this.b(list2, i4, a2);
                            return;
                        }
                        boolean booleanValue = ((Boolean) view.getTag(com.soft.blued.R.id.isexpand)).booleanValue();
                        if (booleanValue) {
                            a2.setCompoundDrawablesWithIntrinsicBounds(2131233203, 0, 0, 0);
                            FragmentViewContainer.this.a(i4);
                        } else {
                            FragmentViewContainer.this.b(list2, i4, a2);
                        }
                        view.setTag(com.soft.blued.R.id.isexpand, Boolean.valueOf(!booleanValue));
                    }
                });
            }
            if (textView == null) {
                this.b.addView(a2);
            } else {
                LinearLayout linearLayout = this.b;
                linearLayout.addView(a2, linearLayout.indexOfChild(textView) + 1);
            }
            size = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(List<FragmentRecord> list, int i, TextView textView) {
        a(list, i, textView);
        textView.setCompoundDrawablesWithIntrinsicBounds(2131233441, 0, 0, 0);
    }

    public void a(List<FragmentRecord> list) {
        this.b.removeAllViews();
        if (list == null) {
            return;
        }
        a(list, 0, null);
    }
}
