package com.anythink.expressad.video.dynview.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.core.common.b.n;
import com.anythink.expressad.foundation.g.d.b;
import com.anythink.expressad.foundation.g.d.c;
import com.anythink.expressad.foundation.h.i;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/dynview/widget/AnythinkBaitClickView.class */
public class AnythinkBaitClickView extends RelativeLayout {
    public static final int ANIMATION_TYPE_DOUBLE_CLICK = 4;
    public static final int ANIMATION_TYPE_FAST_SCALE = 1;
    public static final int ANIMATION_TYPE_ROTATE = 5;
    public static final int ANIMATION_TYPE_SLOW_SCALE = 2;
    public static final int ANIMATION_TYPE_SLOW_SCALE_WITH_PAUSE = 3;

    /* renamed from: a  reason: collision with root package name */
    private static final String f5588a = "MBridgeAnimationClickView";
    private AnyThinkImageView b;

    /* renamed from: c  reason: collision with root package name */
    private AnyThinkImageView f5589c;
    private TextView d;
    private String e;
    private String f;
    private String g;
    private int h;
    private int i;
    private Animation j;
    private Animation k;
    private Animation l;
    private Animation m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView$3  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/dynview/widget/AnythinkBaitClickView$3.class */
    public final class AnonymousClass3 implements Animation.AnimationListener {
        AnonymousClass3() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation animation) {
            if (AnythinkBaitClickView.this.f5589c != null) {
                AnythinkBaitClickView.this.f5589c.setVisibility(4);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation animation) {
            if (AnythinkBaitClickView.this.f5589c != null) {
                AnythinkBaitClickView.this.f5589c.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView$4  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/dynview/widget/AnythinkBaitClickView$4.class */
    public final class AnonymousClass4 implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AnimationSet f5593a;

        AnonymousClass4(AnimationSet animationSet) {
            this.f5593a = animationSet;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation animation) {
            AnythinkBaitClickView.this.postDelayed(new Runnable() { // from class: com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView.4.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (AnythinkBaitClickView.this.b != null) {
                        AnythinkBaitClickView.this.b.startAnimation(AnythinkBaitClickView.this.j);
                    }
                }
            }, 1000L);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation animation) {
            AnythinkBaitClickView.this.postDelayed(new Runnable() { // from class: com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView.4.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (AnythinkBaitClickView.this.f5589c != null) {
                        AnythinkBaitClickView.this.f5589c.startAnimation(AnonymousClass4.this.f5593a);
                    }
                }
            }, 550L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView$5  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/dynview/widget/AnythinkBaitClickView$5.class */
    public final class AnonymousClass5 implements Animation.AnimationListener {
        AnonymousClass5() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation animation) {
            AnythinkBaitClickView.this.postDelayed(new Runnable() { // from class: com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView.5.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (AnythinkBaitClickView.this.b != null) {
                        AnythinkBaitClickView.this.b.startAnimation(AnythinkBaitClickView.this.j);
                    }
                }
            }, 1000L);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation animation) {
        }
    }

    public AnythinkBaitClickView(Context context) {
        super(context);
        this.e = "";
        this.f = "";
        this.g = "Click now for details";
        this.h = 1;
        this.i = 1342177280;
    }

    public AnythinkBaitClickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = "";
        this.f = "";
        this.g = "Click now for details";
        this.h = 1;
        this.i = 1342177280;
    }

    public AnythinkBaitClickView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = "";
        this.f = "";
        this.g = "Click now for details";
        this.h = 1;
        this.i = 1342177280;
    }

    public AnythinkBaitClickView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.e = "";
        this.f = "";
        this.g = "Click now for details";
        this.h = 1;
        this.i = 1342177280;
    }

    private void a() {
        try {
            this.g = getContext().getResources().getConfiguration().locale.getLanguage().contains(com.anythink.expressad.video.dynview.a.a.V) ? "点击查看详情" : "Click now for details";
        } catch (Throwable th) {
            o.d(f5588a, th.getMessage());
        }
    }

    private void b() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.7f, 1.0f, 0.7f, 1, 0.5f, 1, 0.5f);
        this.j = scaleAnimation;
        scaleAnimation.setDuration(200L);
        this.j.setRepeatCount(-1);
        this.j.setRepeatMode(2);
        AnyThinkImageView anyThinkImageView = this.b;
        if (anyThinkImageView != null) {
            anyThinkImageView.startAnimation(this.j);
        }
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.2f, 0.0f, 1.2f, 1, 0.5f, 1, 0.5f);
        this.k = scaleAnimation2;
        scaleAnimation2.setDuration(400L);
        this.k.setRepeatCount(-1);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.3f);
        this.l = alphaAnimation;
        alphaAnimation.setDuration(400L);
        this.l.setRepeatCount(-1);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(this.k);
        animationSet.addAnimation(this.l);
        AnyThinkImageView anyThinkImageView2 = this.f5589c;
        if (anyThinkImageView2 != null) {
            anyThinkImageView2.startAnimation(animationSet);
        }
    }

    private void c() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.7f, 1.0f, 0.7f, 1, 0.5f, 1, 0.5f);
        this.j = scaleAnimation;
        scaleAnimation.setDuration(500L);
        this.j.setRepeatCount(-1);
        this.j.setRepeatMode(2);
        AnyThinkImageView anyThinkImageView = this.b;
        if (anyThinkImageView != null) {
            anyThinkImageView.startAnimation(this.j);
        }
    }

    private void d() {
        AnyThinkImageView anyThinkImageView = this.f5589c;
        if (anyThinkImageView != null) {
            anyThinkImageView.setVisibility(4);
        }
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.7f, 1.0f, 0.7f, 1, 0.5f, 1, 0.5f);
        this.j = scaleAnimation;
        scaleAnimation.setDuration(500L);
        this.j.setRepeatCount(1);
        this.j.setRepeatMode(2);
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.5f, 0.0f, 1.5f, 1, 0.5f, 1, 0.5f);
        this.k = scaleAnimation2;
        scaleAnimation2.setDuration(1000L);
        this.k.setRepeatCount(0);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        this.l = alphaAnimation;
        alphaAnimation.setDuration(1000L);
        this.l.setRepeatCount(0);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(this.k);
        animationSet.addAnimation(this.l);
        this.k.setAnimationListener(new AnonymousClass3());
        this.j.setAnimationListener(new AnonymousClass4(animationSet));
        AnyThinkImageView anyThinkImageView2 = this.b;
        if (anyThinkImageView2 != null) {
            anyThinkImageView2.startAnimation(this.j);
        }
    }

    private void e() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 0.8f, 1.0f, 1, 0.5f, 1, 0.5f);
        this.j = scaleAnimation;
        scaleAnimation.setDuration(200L);
        this.j.setRepeatCount(1);
        this.j.setAnimationListener(new AnonymousClass5());
        AnyThinkImageView anyThinkImageView = this.b;
        if (anyThinkImageView != null) {
            anyThinkImageView.startAnimation(this.j);
        }
    }

    private void f() {
        RotateAnimation rotateAnimation = new RotateAnimation(-10.0f, 30.0f, 1, 0.5f, 1, 0.5f);
        this.m = rotateAnimation;
        rotateAnimation.setDuration(300L);
        this.m.setRepeatMode(2);
        this.m.setRepeatCount(-1);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.2f, 0.0f, 1.2f, 1, 0.5f, 1, 0.5f);
        this.k = scaleAnimation;
        scaleAnimation.setDuration(600L);
        this.k.setRepeatCount(-1);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        this.l = alphaAnimation;
        alphaAnimation.setDuration(600L);
        this.l.setRepeatCount(-1);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(this.k);
        animationSet.addAnimation(this.l);
        AnyThinkImageView anyThinkImageView = this.b;
        if (anyThinkImageView != null) {
            anyThinkImageView.startAnimation(this.m);
        }
        AnyThinkImageView anyThinkImageView2 = this.f5589c;
        if (anyThinkImageView2 != null) {
            anyThinkImageView2.startAnimation(animationSet);
        }
    }

    public void init() {
        try {
            setBackgroundColor(this.i);
            this.g = getContext().getResources().getConfiguration().locale.getLanguage().contains(com.anythink.expressad.video.dynview.a.a.V) ? "点击查看详情" : "Click now for details";
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            int b = t.b(getContext(), 55.0f);
            int b2 = t.b(getContext(), 33.0f);
            this.f5589c = new AnyThinkImageView(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(b, b);
            layoutParams.setMargins(b2, b2, 0, 0);
            this.f5589c.setLayoutParams(layoutParams);
            final int a2 = i.a(getContext(), "anythink_icon_click_circle", i.f5112c);
            if (TextUtils.isEmpty(this.f)) {
                this.f5589c.setImageResource(a2);
            } else {
                b.a(n.a().g()).a(this.e, new c() { // from class: com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView.1
                    @Override // com.anythink.expressad.foundation.g.d.c
                    public final void a(Bitmap bitmap, String str) {
                        if (bitmap.isRecycled()) {
                            return;
                        }
                        AnythinkBaitClickView.this.f5589c.setImageBitmap(bitmap);
                    }

                    @Override // com.anythink.expressad.foundation.g.d.c
                    public final void a(String str, String str2) {
                        AnythinkBaitClickView.this.f5589c.setImageResource(a2);
                    }
                });
            }
            int b3 = t.b(getContext(), 108.0f);
            int b4 = t.b(getContext(), 35.0f);
            int b5 = t.b(getContext(), 43.0f);
            this.b = new AnyThinkImageView(getContext());
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(b3, b3);
            layoutParams2.setMargins(b4, b5, 0, 0);
            this.b.setLayoutParams(layoutParams2);
            final int a3 = i.a(getContext(), "anythink_icon_click_hand", i.f5112c);
            if (TextUtils.isEmpty(this.e)) {
                this.b.setImageResource(a3);
            } else {
                b.a(n.a().g()).a(this.e, new c() { // from class: com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView.2
                    @Override // com.anythink.expressad.foundation.g.d.c
                    public final void a(Bitmap bitmap, String str) {
                        if (bitmap.isRecycled()) {
                            return;
                        }
                        AnythinkBaitClickView.this.b.setImageBitmap(bitmap);
                    }

                    @Override // com.anythink.expressad.foundation.g.d.c
                    public final void a(String str, String str2) {
                        AnythinkBaitClickView.this.b.setImageResource(a3);
                    }
                });
            }
            relativeLayout.addView(this.f5589c);
            relativeLayout.addView(this.b);
            LinearLayout linearLayout = new LinearLayout(getContext());
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.addRule(13);
            linearLayout.setLayoutParams(layoutParams3);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(1);
            linearLayout.addView(relativeLayout);
            this.d = new TextView(getContext());
            this.d.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            this.d.setText(this.g);
            this.d.setTextColor(-1);
            this.d.setGravity(14);
            linearLayout.addView(this.d);
            addView(linearLayout);
        } catch (Throwable th) {
            o.d(f5588a, th.getMessage());
        }
    }

    public void init(int i) {
        this.h = i;
        init();
    }

    public void init(int i, int i2) {
        this.i = i;
        this.h = i2;
        init();
    }

    public void init(int i, int i2, String str, String str2, String str3) {
        this.i = i;
        this.h = i2;
        this.e = str;
        this.f = str2;
        this.g = str3;
        init();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        clearAnimation();
        Animation animation = this.j;
        if (animation != null) {
            animation.cancel();
        }
        Animation animation2 = this.k;
        if (animation2 != null) {
            animation2.cancel();
        }
        Animation animation3 = this.l;
        if (animation3 != null) {
            animation3.cancel();
        }
        Animation animation4 = this.m;
        if (animation4 != null) {
            animation4.cancel();
        }
    }

    public void startAnimation() {
        int i = this.h;
        if (i == 2) {
            this.f5589c.setVisibility(4);
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.7f, 1.0f, 0.7f, 1, 0.5f, 1, 0.5f);
            this.j = scaleAnimation;
            scaleAnimation.setDuration(500L);
            this.j.setRepeatCount(-1);
            this.j.setRepeatMode(2);
            AnyThinkImageView anyThinkImageView = this.b;
            if (anyThinkImageView != null) {
                anyThinkImageView.startAnimation(this.j);
            }
        } else if (i == 3) {
            AnyThinkImageView anyThinkImageView2 = this.f5589c;
            if (anyThinkImageView2 != null) {
                anyThinkImageView2.setVisibility(4);
            }
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.0f, 0.7f, 1.0f, 0.7f, 1, 0.5f, 1, 0.5f);
            this.j = scaleAnimation2;
            scaleAnimation2.setDuration(500L);
            this.j.setRepeatCount(1);
            this.j.setRepeatMode(2);
            ScaleAnimation scaleAnimation3 = new ScaleAnimation(0.0f, 1.5f, 0.0f, 1.5f, 1, 0.5f, 1, 0.5f);
            this.k = scaleAnimation3;
            scaleAnimation3.setDuration(1000L);
            this.k.setRepeatCount(0);
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            this.l = alphaAnimation;
            alphaAnimation.setDuration(1000L);
            this.l.setRepeatCount(0);
            AnimationSet animationSet = new AnimationSet(true);
            animationSet.addAnimation(this.k);
            animationSet.addAnimation(this.l);
            this.k.setAnimationListener(new AnonymousClass3());
            this.j.setAnimationListener(new AnonymousClass4(animationSet));
            AnyThinkImageView anyThinkImageView3 = this.b;
            if (anyThinkImageView3 != null) {
                anyThinkImageView3.startAnimation(this.j);
            }
        } else if (i == 4) {
            this.f5589c.setVisibility(4);
            ScaleAnimation scaleAnimation4 = new ScaleAnimation(0.8f, 1.0f, 0.8f, 1.0f, 1, 0.5f, 1, 0.5f);
            this.j = scaleAnimation4;
            scaleAnimation4.setDuration(200L);
            this.j.setRepeatCount(1);
            this.j.setAnimationListener(new AnonymousClass5());
            AnyThinkImageView anyThinkImageView4 = this.b;
            if (anyThinkImageView4 != null) {
                anyThinkImageView4.startAnimation(this.j);
            }
        } else if (i != 5) {
            ScaleAnimation scaleAnimation5 = new ScaleAnimation(1.0f, 0.7f, 1.0f, 0.7f, 1, 0.5f, 1, 0.5f);
            this.j = scaleAnimation5;
            scaleAnimation5.setDuration(200L);
            this.j.setRepeatCount(-1);
            this.j.setRepeatMode(2);
            AnyThinkImageView anyThinkImageView5 = this.b;
            if (anyThinkImageView5 != null) {
                anyThinkImageView5.startAnimation(this.j);
            }
            ScaleAnimation scaleAnimation6 = new ScaleAnimation(0.0f, 1.2f, 0.0f, 1.2f, 1, 0.5f, 1, 0.5f);
            this.k = scaleAnimation6;
            scaleAnimation6.setDuration(400L);
            this.k.setRepeatCount(-1);
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.3f);
            this.l = alphaAnimation2;
            alphaAnimation2.setDuration(400L);
            this.l.setRepeatCount(-1);
            AnimationSet animationSet2 = new AnimationSet(true);
            animationSet2.addAnimation(this.k);
            animationSet2.addAnimation(this.l);
            AnyThinkImageView anyThinkImageView6 = this.f5589c;
            if (anyThinkImageView6 != null) {
                anyThinkImageView6.startAnimation(animationSet2);
            }
        } else {
            RotateAnimation rotateAnimation = new RotateAnimation(-10.0f, 30.0f, 1, 0.5f, 1, 0.5f);
            this.m = rotateAnimation;
            rotateAnimation.setDuration(300L);
            this.m.setRepeatMode(2);
            this.m.setRepeatCount(-1);
            ScaleAnimation scaleAnimation7 = new ScaleAnimation(0.0f, 1.2f, 0.0f, 1.2f, 1, 0.5f, 1, 0.5f);
            this.k = scaleAnimation7;
            scaleAnimation7.setDuration(600L);
            this.k.setRepeatCount(-1);
            AlphaAnimation alphaAnimation3 = new AlphaAnimation(1.0f, 0.0f);
            this.l = alphaAnimation3;
            alphaAnimation3.setDuration(600L);
            this.l.setRepeatCount(-1);
            AnimationSet animationSet3 = new AnimationSet(true);
            animationSet3.addAnimation(this.k);
            animationSet3.addAnimation(this.l);
            AnyThinkImageView anyThinkImageView7 = this.b;
            if (anyThinkImageView7 != null) {
                anyThinkImageView7.startAnimation(this.m);
            }
            AnyThinkImageView anyThinkImageView8 = this.f5589c;
            if (anyThinkImageView8 != null) {
                anyThinkImageView8.startAnimation(animationSet3);
            }
        }
    }
}
