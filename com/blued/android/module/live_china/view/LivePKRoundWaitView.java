package com.blued.android.module.live_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LivePKRoundWaitView.class */
public class LivePKRoundWaitView extends FrameLayout {
    Runnable a;
    private ImageView b;
    private BaseFragment c;
    private ActivityFragmentActive d;

    public LivePKRoundWaitView(Context context) {
        this(context, null);
    }

    public LivePKRoundWaitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new Runnable() { // from class: com.blued.android.module.live_china.view.LivePKRoundWaitView.1
            @Override // java.lang.Runnable
            public void run() {
                LivePKRoundWaitView.this.a();
            }
        };
        b();
    }

    private void b() {
        LayoutInflater.from(getContext()).inflate(R.layout.live_pk_round_wait_view, this);
        this.b = (ImageView) findViewById(R.id.iv_anim);
        setVisibility(8);
    }

    public void a() {
        setVisibility(8);
        removeCallbacks(this.a);
    }

    public void a(int i) {
        if (i <= 0) {
            return;
        }
        setVisibility(0);
        ImageLoader.c(this.d, "live_pk_round_wait_anim.png").e(((int) System.currentTimeMillis()) / 1000).g(-1).a(this.b);
        removeCallbacks(this.a);
        postDelayed(this.a, i * 1000);
    }

    public void setFragment(BaseFragment baseFragment) {
        this.c = baseFragment;
        this.d = baseFragment.getFragmentActive();
    }
}
