package com.blued.login.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.extensions.BluedViewExtKt;
import com.blued.login.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-7206380-dex2jar.jar:com/blued/login/view/LoginIndicator.class */
public class LoginIndicator extends ShapeLinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private int f20598a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LoginIndicator(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LoginIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginIndicator(Context context, AttributeSet attributeSet, int i) {
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
                throw new NullPointerException("null cannot be cast to non-null type com.blued.android.framework.view.shape.ShapeTextView");
            }
            ShapeTextView shapeTextView = (ShapeTextView) childAt;
            ShapeModel shapeModel = shapeTextView.getShapeModel();
            if (i2 == this.f20598a) {
                shapeModel.k = ContextCompat.getColor(getContext(), R.color.syc_dark_b);
            } else {
                shapeModel.k = ContextCompat.getColor(getContext(), R.color.login_lpi_unselected);
            }
            shapeTextView.setShapeModel(shapeModel);
            i = i2 + 1;
        }
    }

    public final void a(int i, ViewPager vp) {
        Intrinsics.e(vp, "vp");
        removeAllViews();
        int i2 = 0;
        while (i2 < i) {
            i2++;
            ShapeTextView shapeTextView = new ShapeTextView(getContext());
            ShapeModel shapeModel = shapeTextView.getShapeModel();
            shapeModel.H = BluedViewExtKt.a(3);
            shapeModel.k = ContextCompat.getColor(getContext(), R.color.login_lpi_unselected);
            shapeTextView.setShapeModel(shapeModel);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
            marginLayoutParams.width = BluedViewExtKt.a(20);
            marginLayoutParams.height = BluedViewExtKt.a(6);
            marginLayoutParams.leftMargin = BluedViewExtKt.a(6);
            addView(shapeTextView, marginLayoutParams);
        }
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.blued.login.view.LoginIndicator$setTabList$1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i3) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i3, float f, int i4) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i3) {
                LoginIndicator.this.f20598a = i3;
                LoginIndicator.this.a();
            }
        });
        a();
    }
}
