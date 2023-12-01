package com.soft.blued.ui.msg.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import java.util.HashMap;
import java.util.LinkedHashMap;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/customview/AutoHeightViewPager.class */
public class AutoHeightViewPager extends ViewPager {

    /* renamed from: a  reason: collision with root package name */
    private int f18578a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap<Integer, View> f18579c;

    public AutoHeightViewPager(Context context) {
        super(context);
        this.f18579c = new LinkedHashMap();
    }

    public AutoHeightViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18579c = new LinkedHashMap();
    }

    public void a(int i) {
        this.f18578a = i;
    }

    public void a(View view, int i) {
        this.f18579c.put(Integer.valueOf(i), view);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public void onMeasure(int i, int i2) {
        int size = this.f18579c.size();
        int i3 = this.f18578a;
        if (size > i3) {
            View view = this.f18579c.get(Integer.valueOf(i3));
            view.measure(i, View.MeasureSpec.makeMeasureSpec(0, 0));
            this.b = view.getMeasuredHeight();
        }
        if (this.f18579c.size() != 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(this.b, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }
}
