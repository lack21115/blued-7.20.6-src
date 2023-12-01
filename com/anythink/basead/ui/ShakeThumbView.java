package com.anythink.basead.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.anythink.core.common.b.n;
import com.anythink.core.common.k.h;
import com.anythink.expressad.foundation.h.i;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/ShakeThumbView.class */
public class ShakeThumbView extends BaseShakeView {

    /* renamed from: c  reason: collision with root package name */
    private ImageView f6189c;

    public ShakeThumbView(Context context) {
        super(context);
    }

    public ShakeThumbView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ShakeThumbView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public ShakeThumbView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    private void a(View view) {
        int a2 = h.a(getContext(), 88.0f);
        int parseColor = Color.parseColor("#99000000");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(parseColor);
        gradientDrawable.setCornerRadius(a2);
        view.setBackgroundDrawable(gradientDrawable);
    }

    @Override // com.anythink.basead.ui.BaseShakeView
    final void a() {
        setOrientation(1);
        setGravity(1);
        this.f6189c = new ImageView(getContext());
        this.f6189c.setLayoutParams(new LinearLayout.LayoutParams(h.a(getContext(), 90.0f), h.a(getContext(), 90.0f)));
        ImageView imageView = this.f6189c;
        int a2 = h.a(getContext(), 88.0f);
        int parseColor = Color.parseColor("#99000000");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(parseColor);
        gradientDrawable.setCornerRadius(a2);
        imageView.setBackgroundDrawable(gradientDrawable);
        this.f6086a = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(h.a(getContext(), 40.0f), h.a(getContext(), 40.0f));
        layoutParams.gravity = 49;
        layoutParams.topMargin = h.a(getContext(), 12.0f);
        this.f6086a.setLayoutParams(layoutParams);
        this.f6086a.setImageResource(h.a(n.a().g(), "myoffer_shake_icon", i.f7952c));
        TextView textView = new TextView(getContext());
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 81;
        layoutParams2.bottomMargin = h.a(getContext(), 13.0f);
        textView.setLayoutParams(layoutParams2);
        textView.setText(h.a(n.a().g(), "myoffer_shake_simple_title", "string"));
        textView.setTextSize(1, 11.0f);
        textView.setTextColor(-1);
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        frameLayout.addView(this.f6189c);
        frameLayout.addView(this.f6086a);
        frameLayout.addView(textView);
        addView(frameLayout);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.anythink.basead.ui.BaseShakeView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.anythink.basead.ui.BaseShakeView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        try {
            this.f6086a.setOnClickListener(onClickListener);
            this.f6189c.setOnClickListener(onClickListener);
        } catch (Throwable th) {
        }
    }
}
