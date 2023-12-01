package com.blued.android.module.live_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LivePKRoundToastView.class */
public class LivePKRoundToastView extends FrameLayout {
    private TextView a;
    private boolean b;

    public LivePKRoundToastView(Context context) {
        this(context, null);
    }

    public LivePKRoundToastView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = false;
        b();
    }

    private void b() {
        LayoutInflater.from(getContext()).inflate(R.layout.live_pk_round_toast_view, this);
        this.a = (TextView) findViewById(R.id.tv_content);
        setVisibility(8);
    }

    public void a() {
        setVisibility(8);
    }

    public void a(String str) {
        setVisibility(8);
        this.a.setText(str);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 0.8f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(300L);
        clearAnimation();
        startAnimation(scaleAnimation);
        setVisibility(0);
    }
}
