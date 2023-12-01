package com.anythink.expressad.shake;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.anythink.expressad.foundation.h.i;
import com.anythink.expressad.foundation.h.t;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/shake/MBShakeView.class */
public class MBShakeView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5336a = "MBSplashShakeView";
    private ImageView b;

    /* renamed from: c  reason: collision with root package name */
    private Animation f5337c;

    public MBShakeView(Context context) {
        super(context);
    }

    public MBShakeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MBShakeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public MBShakeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    private String a(String str) {
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            if (getContext().getResources().getConfiguration().locale.getLanguage().contains("en")) {
                return "Redirect to third party application";
            }
            str2 = "浏览第三方应用";
        }
        return str2;
    }

    private void a() {
        RotateAnimation rotateAnimation = new RotateAnimation(-10.0f, 10.0f, 1, 0.5f, 1, 0.5f);
        this.f5337c = rotateAnimation;
        rotateAnimation.setDuration(100L);
        this.f5337c.setRepeatMode(2);
        this.f5337c.setRepeatCount(-1);
        this.b.startAnimation(this.f5337c);
    }

    private static void a(View view) {
        int parseColor = Color.parseColor("#80000000");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(parseColor);
        gradientDrawable.setCornerRadius(200.0f);
        view.setBackgroundDrawable(gradientDrawable);
    }

    public void initView(String str) {
        initView(str, false);
    }

    public void initView(String str, boolean z) {
        setOrientation(1);
        setGravity(1);
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new LinearLayout.LayoutParams(t.b(getContext(), z ? 60.0f : 80.0f), t.b(getContext(), z ? 60.0f : 80.0f)));
        int parseColor = Color.parseColor("#80000000");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(parseColor);
        gradientDrawable.setCornerRadius(200.0f);
        imageView.setBackgroundDrawable(gradientDrawable);
        this.b = new ImageView(getContext());
        int b = t.b(getContext(), z ? 20.0f : 40.0f);
        Context context = getContext();
        float f = 40.0f;
        if (z) {
            f = 20.0f;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(b, t.b(context, f));
        layoutParams.gravity = 17;
        this.b.setLayoutParams(layoutParams);
        this.b.setImageResource(getResources().getIdentifier("anythink_splash_btn_shake", i.f5112c, com.anythink.expressad.foundation.b.a.b().a()));
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        frameLayout.addView(imageView);
        frameLayout.addView(this.b);
        TextView textView = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = t.b(getContext(), 10.0f);
        textView.setLayoutParams(layoutParams2);
        textView.setGravity(17);
        if (getContext().getResources().getConfiguration().locale.getLanguage().contains("en")) {
            textView.setText("Shake your phone");
        } else {
            textView.setText("摇动手机 或 点击图标");
        }
        float f2 = 20.0f;
        if (z) {
            f2 = 16.0f;
        }
        textView.setTextSize(f2);
        textView.setTextColor(-1);
        textView.setShadowLayer(8.0f, 3.0f, 3.0f, -16777216);
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = getContext().getResources().getConfiguration().locale.getLanguage().contains("en") ? "Redirect to third party application" : "浏览第三方应用";
        }
        TextView textView2 = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = t.b(getContext(), 5.0f);
        textView2.setLayoutParams(layoutParams3);
        textView2.setGravity(17);
        textView2.setText(str2);
        float f3 = 16.0f;
        if (z) {
            f3 = 12.0f;
        }
        textView2.setTextSize(f3);
        textView2.setTextColor(-1);
        textView2.setShadowLayer(8.0f, 3.0f, 3.0f, -16777216);
        addView(frameLayout);
        addView(textView);
        addView(textView2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        RotateAnimation rotateAnimation = new RotateAnimation(-10.0f, 10.0f, 1, 0.5f, 1, 0.5f);
        this.f5337c = rotateAnimation;
        rotateAnimation.setDuration(100L);
        this.f5337c.setRepeatMode(2);
        this.f5337c.setRepeatCount(-1);
        this.b.startAnimation(this.f5337c);
    }
}
