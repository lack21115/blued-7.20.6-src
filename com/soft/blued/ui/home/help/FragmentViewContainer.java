package com.soft.blued.ui.home.help;

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
import com.soft.blued.R;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/home/help/FragmentViewContainer.class */
public class FragmentViewContainer extends ScrollView {

    /* renamed from: a  reason: collision with root package name */
    private Context f31035a;
    private LinearLayout b;

    /* renamed from: c  reason: collision with root package name */
    private int f31036c;
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
        TextView textView = new TextView(this.f31035a);
        textView.setLayoutParams(new ViewGroup.LayoutParams(-1, this.f31036c));
        if (i == 0) {
            textView.setTextColor(Color.parseColor("#333333"));
            textView.setTextSize(16.0f);
        }
        textView.setGravity(16);
        int i2 = this.d;
        textView.setPadding((int) (i2 + (i * i2 * 1.5d)), 0, i2, 0);
        textView.setCompoundDrawablePadding(this.d / 2);
        TypedArray obtainStyledAttributes = this.f31035a.obtainStyledAttributes(new int[]{16843534});
        textView.setBackgroundDrawable(obtainStyledAttributes.getDrawable(0));
        obtainStyledAttributes.recycle();
        textView.setText(fragmentRecord.f31034a);
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
            if (childAt.getTag(R.id.hierarchy) != null && ((Integer) childAt.getTag(R.id.hierarchy)).intValue() >= i) {
                this.b.removeView(childAt);
            }
            childCount = i2;
        }
    }

    private void a(Context context) {
        this.f31035a = context;
        HorizontalScrollView horizontalScrollView = new HorizontalScrollView(context);
        LinearLayout linearLayout = new LinearLayout(context);
        this.b = linearLayout;
        linearLayout.setOrientation(1);
        horizontalScrollView.addView(this.b);
        addView(horizontalScrollView);
        this.f31036c = DensityUtils.a(context, 50.0f);
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
            a2.setTag(R.id.hierarchy, Integer.valueOf(i));
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
                        if (view.getTag(R.id.isexpand) == null) {
                            a2.setTag(R.id.isexpand, true);
                            FragmentViewContainer.this.b(list2, i4, a2);
                            return;
                        }
                        boolean booleanValue = ((Boolean) view.getTag(R.id.isexpand)).booleanValue();
                        if (booleanValue) {
                            a2.setCompoundDrawablesWithIntrinsicBounds(2131233203, 0, 0, 0);
                            FragmentViewContainer.this.a(i4);
                        } else {
                            FragmentViewContainer.this.b(list2, i4, a2);
                        }
                        view.setTag(R.id.isexpand, Boolean.valueOf(!booleanValue));
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
