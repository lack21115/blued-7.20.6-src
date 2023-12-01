package com.blued.android.module.common.widget.pop;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.module.common.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/pop/GestureAnimTipView.class */
public final class GestureAnimTipView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public TextView f11224a;
    public View b;

    /* renamed from: c  reason: collision with root package name */
    public ShapeLinearLayout f11225c;
    public ImageView d;
    public ImageView e;
    private final long f;
    private final long g;
    private final long h;

    public GestureAnimTipView(Context context) {
        this(context, null, 0, 6, null);
    }

    public GestureAnimTipView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public GestureAnimTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = 300L;
        this.g = 160L;
        this.h = 100L;
        LayoutInflater.from(context).inflate(R.layout.view_gesture_anim_tip, this);
        c();
    }

    public /* synthetic */ GestureAnimTipView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(PopupWindow popupWindow) {
        if (popupWindow == null) {
            return;
        }
        popupWindow.dismiss();
    }

    private final void c() {
        View findViewById = findViewById(R.id.txt);
        Intrinsics.c(findViewById, "findViewById(R.id.txt)");
        setTxt((TextView) findViewById);
        View findViewById2 = findViewById(R.id.space);
        Intrinsics.c(findViewById2, "findViewById(R.id.space)");
        setSpace(findViewById2);
        View findViewById3 = findViewById(R.id.bubble);
        Intrinsics.c(findViewById3, "findViewById(R.id.bubble)");
        setBubble((ShapeLinearLayout) findViewById3);
        View findViewById4 = findViewById(R.id.img);
        Intrinsics.c(findViewById4, "findViewById(R.id.img)");
        setImg((ImageView) findViewById4);
        View findViewById5 = findViewById(R.id.arrow);
        Intrinsics.c(findViewById5, "findViewById(R.id.arrow)");
        setArrow((ImageView) findViewById5);
    }

    public final void a() {
        getBubble().setPivotX(0.0f);
        getBubble().setPivotY(getBubble().getMeasuredHeight());
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(getBubble(), "scaleX", 0.0f, 1.0f);
        ofFloat.setDuration(this.f);
        ofFloat.setInterpolator(new OvershootInterpolator());
        ofFloat.start();
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(getBubble(), "scaleY", 0.25f, 1.0f);
        ofFloat2.setDuration(this.f);
        ofFloat2.setInterpolator(new OvershootInterpolator());
        ofFloat2.start();
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(getBubble(), "alpha", 0.0f, 1.0f);
        ofFloat3.setDuration(this.g);
        ofFloat3.setInterpolator(new DecelerateInterpolator(2.0f));
        ofFloat3.start();
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(getArrow(), "alpha", 0.0f, 1.0f);
        ofFloat4.setDuration(this.g);
        ofFloat4.setInterpolator(new DecelerateInterpolator(2.0f));
        ofFloat4.start();
    }

    public final void a(final PopupWindow popupWindow) {
        b();
        postDelayed(new Runnable() { // from class: com.blued.android.module.common.widget.pop.-$$Lambda$GestureAnimTipView$VaYvxbcEmf6G6s73LQiHJGkL5sQ
            @Override // java.lang.Runnable
            public final void run() {
                GestureAnimTipView.b(PopupWindow.this);
            }
        }, this.h);
    }

    public final void a(String text) {
        Intrinsics.e(text, "text");
        getSpace().getLayoutParams().width = (int) ((getTxt().getPaint().measureText(text) + DensityUtils.a(getContext(), 49.0f)) * 1.2d);
    }

    public final void a(String apng, IRequestHost fragmentActive) {
        Intrinsics.e(apng, "apng");
        Intrinsics.e(fragmentActive, "fragmentActive");
        ImageLoader.c(fragmentActive, apng).g().g(-1).a(getImg());
        a();
    }

    public final void b() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(getBubble(), "alpha", 1.0f, 0.0f);
        ofFloat.setDuration(this.h);
        ofFloat.start();
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(getArrow(), "alpha", 1.0f, 0.0f);
        ofFloat2.setDuration(this.h);
        ofFloat2.start();
    }

    public final ImageView getArrow() {
        ImageView imageView = this.e;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.c("arrow");
        return null;
    }

    public final ShapeLinearLayout getBubble() {
        ShapeLinearLayout shapeLinearLayout = this.f11225c;
        if (shapeLinearLayout != null) {
            return shapeLinearLayout;
        }
        Intrinsics.c("bubble");
        return null;
    }

    public final ImageView getImg() {
        ImageView imageView = this.d;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.c("img");
        return null;
    }

    public final View getSpace() {
        View view = this.b;
        if (view != null) {
            return view;
        }
        Intrinsics.c("space");
        return null;
    }

    public final TextView getTxt() {
        TextView textView = this.f11224a;
        if (textView != null) {
            return textView;
        }
        Intrinsics.c("txt");
        return null;
    }

    public final void setArrow(ImageView imageView) {
        Intrinsics.e(imageView, "<set-?>");
        this.e = imageView;
    }

    public final void setBubble(ShapeLinearLayout shapeLinearLayout) {
        Intrinsics.e(shapeLinearLayout, "<set-?>");
        this.f11225c = shapeLinearLayout;
    }

    public final void setImg(ImageView imageView) {
        Intrinsics.e(imageView, "<set-?>");
        this.d = imageView;
    }

    public final void setSpace(View view) {
        Intrinsics.e(view, "<set-?>");
        this.b = view;
    }

    public final void setText(int i) {
        getTxt().setText(i);
        a(getTxt().getText().toString());
    }

    public final void setText(CharSequence text) {
        Intrinsics.e(text, "text");
        getTxt().setText(text);
        a(getTxt().getText().toString());
    }

    public final void setTxt(TextView textView) {
        Intrinsics.e(textView, "<set-?>");
        this.f11224a = textView;
    }
}
