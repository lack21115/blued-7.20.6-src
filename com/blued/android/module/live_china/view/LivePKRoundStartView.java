package com.blued.android.module.live_china.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.blued.android.module.common.view.ScanningImageView;
import com.blued.android.module.live_china.R;
import com.bytedance.applog.tracker.Tracker;
import com.igexin.push.config.c;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LivePKRoundStartView.class */
public class LivePKRoundStartView extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    Runnable f14815a;
    private ImageView b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f14816c;
    private ImageView d;
    private ImageView e;
    private ImageView f;
    private ScanningImageView g;
    private boolean h;

    /* renamed from: com.blued.android.module.live_china.view.LivePKRoundStartView$6  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LivePKRoundStartView$6.class */
    class AnonymousClass6 implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f14824a;
        final /* synthetic */ int b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ LivePKRoundStartView f14825c;

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            ImageView imageView = this.f14825c.f;
            int i = this.f14824a;
            imageView.setX(i + ((this.b - i) * floatValue));
        }
    }

    /* renamed from: com.blued.android.module.live_china.view.LivePKRoundStartView$7  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LivePKRoundStartView$7.class */
    class AnonymousClass7 implements Animator.AnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LivePKRoundStartView f14826a;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f14826a.f.setVisibility(8);
            this.f14826a.a();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f14826a.f.setVisibility(0);
        }
    }

    public LivePKRoundStartView(Context context) {
        this(context, null);
    }

    public LivePKRoundStartView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = false;
        this.f14815a = new Runnable() { // from class: com.blued.android.module.live_china.view.LivePKRoundStartView.8
            @Override // java.lang.Runnable
            public void run() {
                LivePKRoundStartView.this.setVisibility(8);
            }
        };
        b();
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

    private void b() {
        LayoutInflater.from(getContext()).inflate(R.layout.live_pk_round_start_view, this);
        this.b = (ImageView) findViewById(R.id.iv_left);
        this.f14816c = (ImageView) findViewById(R.id.iv_middle);
        this.d = (ImageView) findViewById(R.id.iv_right);
        this.e = (ImageView) findViewById(R.id.iv_bg);
        this.f = (ImageView) findViewById(R.id.iv_light);
        ScanningImageView scanningImageView = (ScanningImageView) findViewById(R.id.scanning_image_view);
        this.g = scanningImageView;
        scanningImageView.setAnimatorListener(new ScanningImageView.OnEventCallBack() { // from class: com.blued.android.module.live_china.view.LivePKRoundStartView.1
            @Override // com.blued.android.module.common.view.ScanningImageView.OnEventCallBack
            public void a() {
                LivePKRoundStartView.this.b.setVisibility(8);
                LivePKRoundStartView.this.d.setVisibility(8);
                LivePKRoundStartView.this.f14816c.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LivePKRoundStartView.this.b.setVisibility(0);
                LivePKRoundStartView.this.d.setVisibility(0);
                LivePKRoundStartView.this.f14816c.setVisibility(0);
                LivePKRoundStartView livePKRoundStartView = LivePKRoundStartView.this;
                livePKRoundStartView.postDelayed(livePKRoundStartView.f14815a, 500L);
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

    public void a() {
        this.h = false;
        removeCallbacks(this.f14815a);
        setVisibility(8);
    }

    public void a(int i) {
        if (this.h) {
            return;
        }
        this.h = true;
        setVisibility(0);
        if (i == 1) {
            this.d.setImageResource(R.drawable.live_pk_round_right_1);
        } else if (i == 2) {
            this.d.setImageResource(R.drawable.live_pk_round_right_2);
        } else if (i == 3) {
            this.d.setImageResource(R.drawable.live_pk_round_right_3);
        }
        this.b.setVisibility(8);
        this.d.setVisibility(8);
        this.f14816c.setVisibility(8);
        this.e.setVisibility(8);
        this.f.setVisibility(8);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        Log.i("==xpm", "viewWidth:" + displayMetrics.widthPixels);
        final int i2 = displayMetrics.widthPixels;
        this.b.measure(makeMeasureSpec, makeMeasureSpec2);
        int measuredWidth = this.b.getMeasuredWidth();
        this.d.measure(makeMeasureSpec, makeMeasureSpec2);
        final int measuredWidth2 = this.d.getMeasuredWidth();
        this.f.measure(makeMeasureSpec, makeMeasureSpec2);
        final int measuredWidth3 = this.f.getMeasuredWidth();
        final int i3 = -measuredWidth;
        int i4 = i2 / 2;
        final int i5 = (i4 - measuredWidth) + 40;
        final int i6 = i4 - 40;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.view.LivePKRoundStartView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int i7;
                int i8;
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                LivePKRoundStartView.this.b.setX(i3 + ((i5 - i7) * floatValue));
                LivePKRoundStartView.this.d.setX(i2 + ((i6 - i8) * floatValue));
                LivePKRoundStartView.this.b.setAlpha(floatValue);
                LivePKRoundStartView.this.d.setAlpha(floatValue);
                ImageView imageView = LivePKRoundStartView.this.f14816c;
                float f = 0.0f;
                int i9 = ((floatValue - 0.5f) > 0.0f ? 1 : ((floatValue - 0.5f) == 0.0f ? 0 : -1));
                if (i9 > 0) {
                    f = floatValue;
                }
                imageView.setAlpha(f);
                LivePKRoundStartView.this.f14816c.setScaleX(i9 > 0 ? (floatValue * (-1.5f)) + 2.5f : 2.5f);
                ImageView imageView2 = LivePKRoundStartView.this.f14816c;
                float f2 = 2.5f;
                if (i9 > 0) {
                    f2 = 2.5f + (floatValue * (-1.5f));
                }
                imageView2.setScaleY(f2);
            }
        });
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.blued.android.module.live_china.view.LivePKRoundStartView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LivePKRoundStartView.this.h = false;
                LivePKRoundStartView.this.a(i5 - measuredWidth3, i6 + measuredWidth2);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                LivePKRoundStartView.this.b.setVisibility(0);
                LivePKRoundStartView.this.d.setVisibility(0);
                LivePKRoundStartView.this.f14816c.setVisibility(0);
                LivePKRoundStartView.this.e.setVisibility(8);
                LivePKRoundStartView.this.f.setVisibility(8);
            }
        });
        ofFloat.setDuration(1000L);
        ofFloat.start();
    }

    public void a(int i, int i2) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.view.LivePKRoundStartView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                LivePKRoundStartView.this.e.setAlpha(1.0f - floatValue);
                float f = (floatValue * 1.0f) + 0.5f;
                LivePKRoundStartView.this.e.setScaleX(f);
                LivePKRoundStartView.this.e.setScaleY(f);
            }
        });
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.blued.android.module.live_china.view.LivePKRoundStartView.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LivePKRoundStartView.this.e.setVisibility(8);
                ScanningImageView scanningImageView = (ScanningImageView) LivePKRoundStartView.this.findViewById(R.id.scanning_image_view);
                scanningImageView.setDuration(c.j);
                scanningImageView.setView(LivePKRoundStartView.this);
                scanningImageView.setSrcBitmap(LivePKRoundStartView.a((View) LivePKRoundStartView.this));
                scanningImageView.a();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                LivePKRoundStartView.this.e.setVisibility(0);
            }
        });
        ofFloat.setDuration(600L);
        ofFloat.start();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }
}
