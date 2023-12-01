package com.anythink.basead.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.anythink.core.common.b.n;
import com.anythink.core.common.k.h;
import com.anythink.expressad.foundation.h.i;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/ShakeView.class */
public class ShakeView extends BaseShakeView {

    /* renamed from: c  reason: collision with root package name */
    private ImageView f6190c;
    private View d;

    public ShakeView(Context context) {
        super(context);
    }

    public ShakeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ShakeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public ShakeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    private void a(View view) {
        int a2 = h.a(getContext(), 115.0f);
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
        this.f6190c = new ImageView(getContext());
        this.f6190c.setLayoutParams(new LinearLayout.LayoutParams(h.a(getContext(), 115.0f), h.a(getContext(), 115.0f)));
        ImageView imageView = this.f6190c;
        int a2 = h.a(getContext(), 115.0f);
        int parseColor = Color.parseColor("#99000000");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(parseColor);
        gradientDrawable.setCornerRadius(a2);
        imageView.setBackgroundDrawable(gradientDrawable);
        this.f6086a = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(h.a(getContext(), 76.0f), h.a(getContext(), 76.0f));
        layoutParams.gravity = 17;
        this.f6086a.setLayoutParams(layoutParams);
        this.f6086a.setImageResource(h.a(n.a().g(), "myoffer_shake_icon", i.f7952c));
        FrameLayout frameLayout = new FrameLayout(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        frameLayout.setLayoutParams(layoutParams2);
        frameLayout.addView(this.f6190c);
        frameLayout.addView(this.f6086a);
        View inflate = LayoutInflater.from(getContext()).inflate(h.a(getContext(), "myoffer_splash_shake_hint_text", "layout"), (ViewGroup) null);
        this.d = inflate;
        inflate.setLayoutParams(layoutParams2);
        ((TextView) this.d.findViewById(h.a(n.a().g(), "tv_splash_shake_hint_text", "id"))).setText(h.a(n.a().g(), "myoffer_shake_full_title", "string"));
        addView(frameLayout);
        addView(this.d);
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
            this.f6190c.setOnClickListener(onClickListener);
            this.d.setOnClickListener(onClickListener);
        } catch (Throwable th) {
        }
    }
}
