package com.blued.android.module.live_china.view;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.blued.android.module.common.view.ScanningImageView;
import com.blued.android.module.live_china.R;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LivePKRoundTimeView.class */
public class LivePKRoundTimeView extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f14828a;
    private ScanningImageView b;

    /* renamed from: c  reason: collision with root package name */
    private int f14829c;
    private boolean d;

    public LivePKRoundTimeView(Context context) {
        this(context, null);
    }

    public LivePKRoundTimeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14829c = 0;
        this.d = false;
        c();
    }

    public static Bitmap a(View view) {
        if (view == null) {
            return null;
        }
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap drawingCache = view.getDrawingCache();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        Bitmap bitmap = null;
        if (measuredWidth > 0) {
            bitmap = null;
            if (measuredHeight > 0) {
                if (drawingCache == null) {
                    return null;
                }
                bitmap = Bitmap.createBitmap(drawingCache, 0, 0, measuredWidth, measuredHeight);
                view.destroyDrawingCache();
            }
        }
        return bitmap;
    }

    private void c() {
        LayoutInflater.from(getContext()).inflate(R.layout.live_pk_round_num_view, this);
        this.f14828a = (ImageView) findViewById(R.id.iv_round_time);
        ScanningImageView scanningImageView = (ScanningImageView) findViewById(R.id.scanning_image_view);
        this.b = scanningImageView;
        scanningImageView.setAnimatorListener(new ScanningImageView.OnEventCallBack() { // from class: com.blued.android.module.live_china.view.LivePKRoundTimeView.1
            @Override // com.blued.android.module.common.view.ScanningImageView.OnEventCallBack
            public void a() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LivePKRoundTimeView.this.d = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        setVisibility(8);
    }

    private void d() {
        setVisibility(0);
        AnimationSet animationSet = new AnimationSet(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.5f, 1.0f, 1.5f, 1.0f, 1, 0.5f, 1, 0.5f);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setDuration(600L);
        animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.LivePKRoundTimeView.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Log.i("xpm", "onAnimationEnd");
                LivePKRoundTimeView.this.b.setView(LivePKRoundTimeView.this);
                LivePKRoundTimeView.this.b.setDuration(800L);
                LivePKRoundTimeView.this.b.setSrcBitmap(LivePKRoundTimeView.a((View) LivePKRoundTimeView.this));
                LivePKRoundTimeView.this.b.a();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                Log.i("xpm", "onAnimationRepeat:");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                LivePKRoundTimeView.this.d = true;
                LivePKRoundTimeView.this.e();
            }
        });
        clearAnimation();
        startAnimation(animationSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        int i = this.f14829c;
        if (i == 1) {
            this.f14828a.setImageResource(R.drawable.live_pk_round_time1);
        } else if (i == 2) {
            this.f14828a.setImageResource(R.drawable.live_pk_round_time2);
        } else if (i == 3) {
            this.f14828a.setImageResource(R.drawable.live_pk_round_time3);
        } else if (i == 4) {
            this.f14828a.setImageResource(R.drawable.live_pk_round_time_end);
        }
    }

    public void a() {
        if (this.d) {
            return;
        }
        this.f14829c = 4;
        d();
    }

    public void a(int i) {
        if (this.d) {
            return;
        }
        if (this.f14829c == i) {
            e();
            return;
        }
        this.f14829c = i;
        d();
    }

    public void b() {
        this.d = false;
        this.f14829c = 0;
        setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
    }
}
