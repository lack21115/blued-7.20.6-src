package com.soft.blued.ui.msg.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.module.common.extensions.BluedViewExtKt;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/view/SafeTabLayout.class */
public final class SafeTabLayout extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private int f32606a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SafeTabLayout(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SafeTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SafeTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        setOrientation(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a() {
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                return;
            }
            View childAt = getChildAt(i2);
            if (childAt == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
            }
            TextView textView = (TextView) childAt;
            if (i2 == this.f32606a) {
                textView.setTextColor(BluedSkinUtils.a(getContext(), 2131102254));
            } else {
                textView.setTextColor(BluedSkinUtils.a(getContext(), (int) R.color.chat_safe_tab_unselected));
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ViewPager vp, int i, View view) {
        Tracker.onClick(view);
        Intrinsics.e(vp, "$vp");
        vp.setCurrentItem(i);
    }

    public final void a(List<String> data, final ViewPager vp) {
        Intrinsics.e(data, "data");
        Intrinsics.e(vp, "vp");
        removeAllViews();
        int size = data.size();
        int i = 0;
        while (true) {
            final int i2 = i;
            if (i2 >= size) {
                vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.soft.blued.ui.msg.view.SafeTabLayout$setTabList$2
                    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                    public void onPageScrollStateChanged(int i3) {
                    }

                    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                    public void onPageScrolled(int i3, float f, int i4) {
                    }

                    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                    public void onPageSelected(int i3) {
                        SafeTabLayout.this.f32606a = i3;
                        SafeTabLayout.this.a();
                    }
                });
                a();
                return;
            }
            TextView textView = new TextView(getContext());
            textView.setText(data.get(i2));
            textView.setTextColor(BluedSkinUtils.a(getContext(), (int) R.color.chat_safe_tab_unselected));
            textView.setTextSize(13.0f);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            textView.setPadding((int) BluedViewExtKt.a(7.5f), 0, (int) BluedViewExtKt.a(7.5f), 0);
            addView(textView, layoutParams);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.view.-$$Lambda$SafeTabLayout$qzSObKrFKY9CwY3QWkk2DKNKSQk
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SafeTabLayout.a(ViewPager.this, i2, view);
                }
            });
            i = i2 + 1;
        }
    }
}
