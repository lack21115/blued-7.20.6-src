package com.blued.android.module.live_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.module.live.base.utils.LiveTimeAndDateUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.svgaplayer.SVGACallback;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.svgaplayer.SVGAPlayer;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PKDoubleAnimView.class */
public class PKDoubleAnimView extends FrameLayout {
    public static int a;
    long b;
    long c;
    Runnable d;
    ScaleAnimation e;
    private SVGAImageView f;
    private TextView g;
    private View h;
    private View i;
    private ImageView j;
    private WaveDrawable k;

    public PKDoubleAnimView(Context context) {
        this(context, null);
    }

    public PKDoubleAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 0L;
        this.c = 0L;
        this.d = new Runnable() { // from class: com.blued.android.module.live_china.view.PKDoubleAnimView.2
            @Override // java.lang.Runnable
            public void run() {
                if (PKDoubleAnimView.this.b <= 0) {
                    PKDoubleAnimView.this.a();
                    return;
                }
                int i = (int) (((((float) PKDoubleAnimView.this.b) * 1.0f) / ((float) PKDoubleAnimView.this.c)) * 10000.0f);
                Log.i("xpm====", "value:" + i);
                PKDoubleAnimView.this.k.setLevel(i);
                PKDoubleAnimView.this.g.setText(LiveTimeAndDateUtils.a(PKDoubleAnimView.this.b, false));
                PKDoubleAnimView.this.b--;
                PKDoubleAnimView pKDoubleAnimView = PKDoubleAnimView.this;
                pKDoubleAnimView.postDelayed(pKDoubleAnimView.d, 1000L);
            }
        };
        this.e = null;
        b();
    }

    private void b() {
        LayoutInflater.from(getContext()).inflate(R.layout.live_pk_double_anim_view, this);
        this.h = findViewById(R.id.fl_anim);
        this.f = (SVGAImageView) findViewById(R.id.iv_pk);
        TextView textView = (TextView) findViewById(R.id.tv_time);
        this.g = textView;
        textView.setVisibility(8);
        View findViewById = findViewById(R.id.cardview);
        this.i = findViewById;
        findViewById.setVisibility(8);
        this.j = (ImageView) findViewById(R.id.iv_wave);
        WaveDrawable waveDrawable = new WaveDrawable(getContext(), R.drawable.live_pk_double_anim_bg);
        this.k = waveDrawable;
        this.j.setImageDrawable(waveDrawable);
        this.k.setLevel(10000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.i.setVisibility(8);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(false);
        this.i.clearAnimation();
        this.i.startAnimation(alphaAnimation);
        this.i.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f, 1, 0.5f, 1, 0.5f);
        this.e = scaleAnimation;
        scaleAnimation.setDuration(600L);
        this.e.setFillAfter(false);
        this.e.setRepeatMode(2);
        this.e.setRepeatCount(-1);
        this.h.clearAnimation();
        this.h.startAnimation(this.e);
    }

    public void a() {
        this.g.setVisibility(8);
        this.h.clearAnimation();
        this.b = 0L;
        this.c = 0L;
        ScaleAnimation scaleAnimation = this.e;
        if (scaleAnimation != null) {
            scaleAnimation.cancel();
        }
        removeCallbacks(this.d);
        setVisibility(8);
    }

    public void a(ActivityFragmentActive activityFragmentActive, long j) {
        Log.i("xpm====", "countDown:" + j);
        if (getVisibility() == 0) {
            return;
        }
        setVisibility(0);
        this.f.setCallback(new SVGACallback() { // from class: com.blued.android.module.live_china.view.PKDoubleAnimView.1
            @Override // com.blued.android.module.svgaplayer.SVGACallback
            public void onFinished() {
                PKDoubleAnimView.this.g.setVisibility(0);
                PKDoubleAnimView.this.c();
                PKDoubleAnimView.this.d();
            }

            @Override // com.blued.android.module.svgaplayer.SVGACallback
            public void onPause() {
            }

            @Override // com.blued.android.module.svgaplayer.SVGACallback
            public void onRepeat() {
            }

            @Override // com.blued.android.module.svgaplayer.SVGACallback
            public void onStep(int i, double d) {
            }
        });
        new SVGAPlayer.Builder().a("live_pk_count_down.svga").a((Integer) 1).a(SVGAImageView.FillMode.Forward).a((Boolean) true).a(this.f);
        this.c = j;
        this.b = j;
        post(this.d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }
}
