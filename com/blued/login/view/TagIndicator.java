package com.blued.login.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
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
/* loaded from: source-7206380-dex2jar.jar:com/blued/login/view/TagIndicator.class */
public class TagIndicator extends ShapeLinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private int f20600a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TagIndicator(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TagIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TagIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        setOrientation(0);
        ShapeModel shapeModel = getShapeModel();
        shapeModel.H = BluedViewExtKt.a(3);
        shapeModel.k = ContextCompat.getColor(context, R.color.syc_c);
        setShapeModel(shapeModel);
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
            if (i2 == this.f20600a) {
                textView.setVisibility(0);
            } else {
                textView.setVisibility(4);
            }
            i = i2 + 1;
        }
    }

    public final void a(int i, final TagViewPager vp) {
        Intrinsics.e(vp, "vp");
        removeAllViews();
        if (i >= 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                ShapeTextView shapeTextView = new ShapeTextView(getContext());
                ShapeModel shapeModel = shapeTextView.getShapeModel();
                shapeModel.H = BluedViewExtKt.a(3);
                shapeModel.k = ContextCompat.getColor(getContext(), R.color.chat_safe_blue);
                shapeTextView.setShapeModel(shapeModel);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.width = BluedViewExtKt.a(50);
                layoutParams.height = BluedViewExtKt.a(6);
                layoutParams.gravity = 16;
                addView(shapeTextView, layoutParams);
                if (i3 == i) {
                    break;
                }
                i2 = i3 + 1;
            }
        }
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.blued.login.view.TagIndicator$setTabList$1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i4) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i4, float f, int i5) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i4) {
                int i5;
                int i6;
                TagIndicator.this.f20600a = i4;
                i5 = TagIndicator.this.f20600a;
                if (i5 > vp.getLastIndex()) {
                    TagViewPager tagViewPager = vp;
                    i6 = TagIndicator.this.f20600a;
                    tagViewPager.setLastIndex(i6);
                }
                TagIndicator.this.a();
            }
        });
        a();
    }
}
