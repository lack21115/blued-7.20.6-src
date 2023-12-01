package com.blued.android.module.live_china.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.internal.util.cm.QSConstants;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LivePKResult.class */
public class LivePKResult extends FrameLayout implements View.OnClickListener {
    public ImageView a;
    public ImageView b;
    public ImageView c;
    public ImageView d;
    Runnable e;
    EventCallBack f;
    private View g;
    private View h;
    private TextView i;
    private TextView j;
    private long k;
    private ObjectAnimator l;
    private int m;
    private boolean n;
    private BaseFragment o;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LivePKResult$EventCallBack.class */
    public interface EventCallBack {
        void a();
    }

    public LivePKResult(Context context) {
        this(context, null);
    }

    public LivePKResult(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.n = false;
        this.e = new Runnable() { // from class: com.blued.android.module.live_china.view.LivePKResult.1
            @Override // java.lang.Runnable
            public void run() {
                LivePKResult.this.n = true;
                LivePKResult.this.g.setVisibility(8);
                LivePKResult.this.h.setVisibility(8);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(600L);
                alphaAnimation.setFillAfter(false);
                LivePKResult.this.clearAnimation();
                LivePKResult.this.startAnimation(alphaAnimation);
                LivePKResult.this.h.setVisibility(0);
                LivePKResult.this.c.setAlpha(0.0f);
                LivePKResult.this.d.setAlpha(0.0f);
                LivePKResult.this.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.blued.android.module.live_china.view.LivePKResult.1.1
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        LivePKResult.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                        int width = ((ViewGroup) LivePKResult.this.c.getParent()).getWidth();
                        int height = ((ViewGroup) LivePKResult.this.c.getParent()).getHeight();
                        int width2 = LivePKResult.this.c.getWidth();
                        int height2 = LivePKResult.this.c.getHeight();
                        float f = (width - width2) / 2;
                        LivePKResult.this.c.setX(f);
                        float f2 = (height - height2) / 2;
                        LivePKResult.this.c.setY(f2);
                        LivePKResult.this.d.setX(f);
                        LivePKResult.this.d.setY(f2);
                        LivePKResult.this.c.setAlpha(1.0f);
                        LivePKResult.this.d.setAlpha(1.0f);
                        Log.i("xpm", "getX:" + LivePKResult.this.c.getX() + "  getY:" + LivePKResult.this.c.getY());
                        Log.i("xpm", "parentWidth:" + width + "  parentHeight:" + height);
                        if (LivePKResult.this.k == 0) {
                            LivePKResult.this.c.setImageResource(R.drawable.live_pk_tie);
                            LivePKResult.this.d.setImageResource(R.drawable.live_pk_tie);
                        } else if (LivePKResult.this.k == LiveRoomManager.a().f()) {
                            LivePKResult.this.c.setImageResource(R.drawable.live_pk_winner);
                            LivePKResult.this.d.setImageResource(R.drawable.live_pk_loser);
                        } else {
                            LivePKResult.this.c.setImageResource(R.drawable.live_pk_loser);
                            LivePKResult.this.d.setImageResource(R.drawable.live_pk_winner);
                        }
                        LivePKResult.this.c();
                    }
                });
            }
        };
        b();
    }

    private void a(View view) {
        ObjectAnimator objectAnimator = this.l;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.l = null;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, QSConstants.TILE_ROTATION, 0.0f, 360.0f);
        this.l = ofFloat;
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.blued.android.module.live_china.view.LivePKResult.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LivePKResult.this.e();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        this.l.setDuration(2000L);
        this.l.setInterpolator(new LinearInterpolator());
        this.l.start();
    }

    private void b() {
        LayoutInflater.from(getContext()).inflate(R.layout.live_pk_result, this);
        this.g = findViewById(R.id.ll_pk_score);
        this.h = findViewById(R.id.ll_pk_icon);
        this.i = (TextView) findViewById(R.id.tv_my_num);
        this.j = (TextView) findViewById(R.id.tv_other_num);
        this.a = (ImageView) findViewById(R.id.iv_pk_left_bg);
        this.b = (ImageView) findViewById(R.id.iv_pk_right_bg);
        this.c = (ImageView) findViewById(R.id.live_pk_my_result_icon);
        this.d = (ImageView) findViewById(R.id.live_pk_your_result_icon);
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.c.setScaleX(1.0f);
        this.c.setScaleY(1.0f);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 2.0f, 1.5f);
        ofFloat.setDuration(600L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.view.LivePKResult.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                LivePKResult.this.c.setScaleX(floatValue);
                LivePKResult.this.c.setScaleY(floatValue);
                LivePKResult.this.d.setScaleX(floatValue);
                LivePKResult.this.d.setScaleY(floatValue);
            }
        });
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.blued.android.module.live_china.view.LivePKResult.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LivePKResult.this.d();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        long j = this.k;
        if (j == 0) {
            this.a.setVisibility(8);
            this.b.setVisibility(8);
            ObjectAnimator objectAnimator = this.l;
            if (objectAnimator != null) {
                objectAnimator.cancel();
                this.l = null;
            }
            e();
        } else if (j == LiveRoomManager.a().f()) {
            this.a.setVisibility(0);
            this.a.setImageResource(R.drawable.live_pk_winner_anim_bg);
            this.b.setVisibility(8);
            a(this.a);
        } else {
            this.a.setVisibility(8);
            this.b.setVisibility(0);
            this.b.setImageResource(R.drawable.live_pk_winner_anim_bg);
            a(this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        int i;
        RecordingOnliveFragment recordingOnliveFragment;
        this.a.setVisibility(8);
        this.b.setVisibility(8);
        final int width = ((ViewGroup) this.c.getParent()).getWidth();
        final int height = ((ViewGroup) this.c.getParent()).getHeight();
        final int x = (int) this.c.getX();
        final int y = (int) this.c.getY();
        final int x2 = (int) this.d.getX();
        final int y2 = (int) this.d.getY();
        final int a = DensityUtils.a(getContext(), 55.0f);
        final int a2 = DensityUtils.a(getContext(), 55.0f);
        BaseFragment baseFragment = this.o;
        int i2 = 0;
        if (baseFragment instanceof PlayingOnliveFragment) {
            PlayingOnliveFragment playingOnliveFragment = (PlayingOnliveFragment) baseFragment;
            if (playingOnliveFragment == null || playingOnliveFragment.bl == null) {
                i = 0;
            } else {
                i2 = playingOnliveFragment.bl.getViewHeight();
                i = playingOnliveFragment.bl.getViewHeight();
            }
        } else if (!(baseFragment instanceof RecordingOnliveFragment) || (recordingOnliveFragment = (RecordingOnliveFragment) baseFragment) == null || recordingOnliveFragment.cg == null) {
            i2 = 0;
            i = 0;
        } else {
            i2 = recordingOnliveFragment.cg.getViewHeight();
            i = recordingOnliveFragment.cg.getViewHeight();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.blued.android.module.live_china.view.LivePKResult.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LivePKResult.this.n = false;
                if (LivePKResult.this.f != null) {
                    LivePKResult.this.f.a();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        ofFloat.setDuration(480L);
        final int i3 = i2;
        final int i4 = i;
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.view.LivePKResult.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                LivePKResult.this.c.setX(x + ((DensityUtils.a(LivePKResult.this.getContext(), 10.0f) - x) * floatValue));
                ImageView imageView = LivePKResult.this.c;
                int i5 = y;
                imageView.setY(i5 + ((((height - i3) - a2) - i5) * floatValue));
                LivePKResult.this.d.setX(x2 + ((((width - DensityUtils.a(LivePKResult.this.getContext(), 10.0f)) - a) - x2) * floatValue));
                ImageView imageView2 = LivePKResult.this.d;
                int i6 = y2;
                imageView2.setY(i6 + ((((height - i4) - a2) - i6) * floatValue));
                float f = 1.5f - (floatValue * 0.5f);
                LivePKResult.this.c.setScaleX(f);
                LivePKResult.this.c.setScaleY(f);
                LivePKResult.this.d.setScaleX(f);
                LivePKResult.this.d.setScaleY(f);
            }
        });
        ofFloat.start();
    }

    public void a() {
        this.n = false;
        this.f = null;
        removeCallbacks(this.e);
        setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setVisibility(8);
        removeCallbacks(this.e);
    }

    public void setEventCallback(EventCallBack eventCallBack) {
        this.f = eventCallBack;
    }

    public void setFragment(BaseFragment baseFragment) {
        this.o = baseFragment;
    }

    public void setResult(int i, int i2, long j, int i3) {
        if (this.n) {
            return;
        }
        this.n = true;
        this.k = j;
        this.m = i3;
        setVisibility(0);
        if (i3 != 0) {
            post(this.e);
            return;
        }
        this.h.setVisibility(8);
        this.g.setVisibility(8);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(false);
        clearAnimation();
        startAnimation(alphaAnimation);
        this.g.setVisibility(0);
        this.i.setText(String.valueOf(i));
        this.j.setText(String.valueOf(i2));
        removeCallbacks(this.e);
        postDelayed(this.e, 5000L);
    }
}
