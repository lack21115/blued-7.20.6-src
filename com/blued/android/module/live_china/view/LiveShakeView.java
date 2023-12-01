package com.blued.android.module.live_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveShakeView.class */
public class LiveShakeView extends FrameLayout {
    private Context a;

    public LiveShakeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LiveShakeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = context;
        LayoutInflater.from(context).inflate(R.layout.live_shake_view, this);
    }
}
