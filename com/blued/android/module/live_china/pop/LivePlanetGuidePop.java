package com.blued.android.module.live_china.pop;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.core.CenterPopupView;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.DialogLivePlanetBinding;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.view.BluedViewExKt;
import com.blued.android.module.live_china.view.LivePlanetGuideShadeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/pop/LivePlanetGuidePop.class */
public final class LivePlanetGuidePop extends CenterPopupView {
    private LivePlanetGuideShadeView A;
    private FragmentActivity c;
    private DialogLivePlanetBinding d;
    private FrameLayout e;
    private FrameLayout f;
    private ImageView g;
    private ImageView h;
    private ImageView i;
    private ImageView j;
    private ImageView k;
    private ImageView t;
    private ImageView u;
    private View v;
    private View w;
    private View x;
    private View y;
    private View z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LivePlanetGuidePop(Context context, FragmentActivity activity) {
        super(context);
        Intrinsics.e(context, "context");
        Intrinsics.e(activity, "activity");
        this.c = activity;
    }

    private final void A() {
        int a;
        ImageView imageView = this.k;
        ImageView imageView2 = imageView;
        if (imageView == null) {
            Intrinsics.c("iv_next");
            imageView2 = null;
        }
        imageView2.setClickable(false);
        int[] iArr = new int[2];
        DialogLivePlanetBinding dialogLivePlanetBinding = this.d;
        DialogLivePlanetBinding dialogLivePlanetBinding2 = dialogLivePlanetBinding;
        if (dialogLivePlanetBinding == null) {
            Intrinsics.c("vb");
            dialogLivePlanetBinding2 = null;
        }
        dialogLivePlanetBinding2.b.getLocationOnScreen(iArr);
        int a2 = DensityUtils.a(getContext(), 6.0f);
        iArr[0] = iArr[0] - DensityUtils.a(getContext(), 4.0f);
        iArr[1] = iArr[1] - a2;
        DialogLivePlanetBinding dialogLivePlanetBinding3 = this.d;
        DialogLivePlanetBinding dialogLivePlanetBinding4 = dialogLivePlanetBinding3;
        if (dialogLivePlanetBinding3 == null) {
            Intrinsics.c("vb");
            dialogLivePlanetBinding4 = null;
        }
        int width = dialogLivePlanetBinding4.b.getWidth();
        DialogLivePlanetBinding dialogLivePlanetBinding5 = this.d;
        DialogLivePlanetBinding dialogLivePlanetBinding6 = dialogLivePlanetBinding5;
        if (dialogLivePlanetBinding5 == null) {
            Intrinsics.c("vb");
            dialogLivePlanetBinding6 = null;
        }
        int height = dialogLivePlanetBinding6.b.getHeight();
        int a3 = DensityUtils.a(getContext(), 27.0f);
        int a4 = DensityUtils.a(getContext(), 81.0f);
        int a5 = iArr[0] + DensityUtils.a(getContext(), 72.0f);
        int i = (iArr[1] - a3) - a4;
        ImageView imageView3 = this.i;
        ImageView imageView4 = imageView3;
        if (imageView3 == null) {
            Intrinsics.c("iv_step_3");
            imageView4 = null;
        }
        BluedViewExKt.b(imageView4);
        ImageView imageView5 = this.h;
        ImageView imageView6 = imageView5;
        if (imageView5 == null) {
            Intrinsics.c("iv_step_2");
            imageView6 = null;
        }
        BluedViewExKt.a(imageView6);
        FrameLayout frameLayout = this.f;
        FrameLayout frameLayout2 = frameLayout;
        if (frameLayout == null) {
            Intrinsics.c("fl_step_root");
            frameLayout2 = null;
        }
        frameLayout2.animate().translationX(a5).translationY(i).setDuration(350L).start();
        int a6 = DensityUtils.a(getContext(), 227.0f);
        int a7 = DensityUtils.a(getContext(), 14.0f);
        int a8 = DensityUtils.a(getContext(), 105.0f);
        int a9 = DensityUtils.a(getContext(), 30.0f);
        ImageView imageView7 = this.k;
        ImageView imageView8 = imageView7;
        if (imageView7 == null) {
            Intrinsics.c("iv_next");
            imageView8 = null;
        }
        int i2 = a6 + a5;
        ViewPropertyAnimator translationX = imageView8.animate().translationX(i2 - a8);
        int i3 = a4 + i;
        translationX.translationY(i3 + a7).setDuration(350L).start();
        ImageView imageView9 = this.t;
        ImageView imageView10 = imageView9;
        if (imageView9 == null) {
            Intrinsics.c("iv_close");
            imageView10 = null;
        }
        imageView10.animate().translationX(i2 - a9).translationY((i - a7) - a9).setDuration(350L).start();
        int a10 = DensityUtils.a(getContext(), 3.0f);
        int a11 = DensityUtils.a(getContext(), 16.0f);
        View view = this.x;
        View view2 = view;
        if (view == null) {
            Intrinsics.c("view_line");
            view2 = null;
        }
        view2.setAlpha(0.0f);
        View view3 = this.x;
        View view4 = view3;
        if (view3 == null) {
            Intrinsics.c("view_line");
            view4 = null;
        }
        view4.setTranslationX(a5 + a11);
        View view5 = this.x;
        View view6 = view5;
        if (view5 == null) {
            Intrinsics.c("view_line");
            view6 = null;
        }
        view6.setTranslationY(i3);
        View view7 = this.x;
        View view8 = view7;
        if (view7 == null) {
            Intrinsics.c("view_line");
            view8 = null;
        }
        view8.setLayoutParams(new FrameLayout.LayoutParams(a10, a3));
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        View view9 = this.x;
        View view10 = view9;
        if (view9 == null) {
            Intrinsics.c("view_line");
            view10 = null;
        }
        floatRef.a = view10.getTranslationX();
        final Ref.FloatRef floatRef2 = new Ref.FloatRef();
        View view11 = this.x;
        View view12 = view11;
        if (view11 == null) {
            Intrinsics.c("view_line");
            view12 = null;
        }
        floatRef2.a = view12.getTranslationY() + a3;
        final Ref.FloatRef floatRef3 = new Ref.FloatRef();
        floatRef3.a = 1.0f;
        final Ref.FloatRef floatRef4 = new Ref.FloatRef();
        floatRef4.a = 1.0f;
        final Ref.FloatRef floatRef5 = new Ref.FloatRef();
        floatRef5.a = iArr[0];
        final Ref.FloatRef floatRef6 = new Ref.FloatRef();
        floatRef6.a = iArr[1];
        final Ref.FloatRef floatRef7 = new Ref.FloatRef();
        floatRef7.a = width + (a * 2);
        final Ref.FloatRef floatRef8 = new Ref.FloatRef();
        floatRef8.a = height + (a2 * 2);
        View view13 = this.v;
        View view14 = view13;
        if (view13 == null) {
            Intrinsics.c("view_bordwr_1");
            view14 = null;
        }
        view14.setAlpha(0.0f);
        final ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(500L);
        ofFloat.setStartDelay(200L);
        ofFloat.setInterpolator(new DecelerateInterpolator(1.5f));
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.pop.-$$Lambda$LivePlanetGuidePop$0Ci91So8g1Hr_JkGpF_jDnun_Zs
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                LivePlanetGuidePop.d(LivePlanetGuidePop.this, floatRef, floatRef5, floatRef2, floatRef6, floatRef3, floatRef7, floatRef4, floatRef8, valueAnimator);
            }
        });
        ofFloat.start();
        View view15 = this.x;
        View view16 = view15;
        if (view15 == null) {
            Intrinsics.c("view_line");
            view16 = null;
        }
        view16.animate().alpha(1.0f).setDuration(ofFloat.getDuration()).setStartDelay(ofFloat.getStartDelay()).setInterpolator(ofFloat.getInterpolator()).start();
        View view17 = this.v;
        View view18 = view17;
        if (view17 == null) {
            Intrinsics.c("view_bordwr_1");
            view18 = null;
        }
        view18.animate().alpha(1.0f).setDuration(ofFloat.getDuration()).setStartDelay(ofFloat.getStartDelay()).setInterpolator(ofFloat.getInterpolator()).withEndAction(new Runnable() { // from class: com.blued.android.module.live_china.pop.-$$Lambda$LivePlanetGuidePop$fPWAOUzn7aIpgTRZEvW124xA_to
            @Override // java.lang.Runnable
            public final void run() {
                LivePlanetGuidePop.f(LivePlanetGuidePop.this);
            }
        }).start();
        LivePlanetGuideShadeView livePlanetGuideShadeView = this.A;
        LivePlanetGuideShadeView livePlanetGuideShadeView2 = livePlanetGuideShadeView;
        if (livePlanetGuideShadeView == null) {
            Intrinsics.c("lpgc");
            livePlanetGuideShadeView2 = null;
        }
        livePlanetGuideShadeView2.b(-1, -1, -1, -1);
        LivePlanetGuideShadeView livePlanetGuideShadeView3 = this.A;
        LivePlanetGuideShadeView livePlanetGuideShadeView4 = livePlanetGuideShadeView3;
        if (livePlanetGuideShadeView3 == null) {
            Intrinsics.c("lpgc");
            livePlanetGuideShadeView4 = null;
        }
        livePlanetGuideShadeView4.a((int) floatRef.a, (int) floatRef2.a, (int) floatRef3.a, (int) floatRef4.a);
        LivePlanetGuideShadeView livePlanetGuideShadeView5 = this.A;
        if (livePlanetGuideShadeView5 == null) {
            Intrinsics.c("lpgc");
            livePlanetGuideShadeView5 = null;
        }
        livePlanetGuideShadeView5.post(new Runnable() { // from class: com.blued.android.module.live_china.pop.-$$Lambda$LivePlanetGuidePop$SdYZJKx-T_CVou2nB_mp_VLdEY4
            @Override // java.lang.Runnable
            public final void run() {
                LivePlanetGuidePop.a(LivePlanetGuidePop.this, floatRef5, floatRef6, floatRef7, floatRef8, ofFloat);
            }
        });
    }

    private final void B() {
        ImageView imageView = this.k;
        ImageView imageView2 = imageView;
        if (imageView == null) {
            Intrinsics.c("iv_next");
            imageView2 = null;
        }
        imageView2.setClickable(false);
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        View view = this.v;
        View view2 = view;
        if (view == null) {
            Intrinsics.c("view_bordwr_1");
            view2 = null;
        }
        floatRef.a = view2.getTranslationX();
        final Ref.FloatRef floatRef2 = new Ref.FloatRef();
        View view3 = this.v;
        View view4 = view3;
        if (view3 == null) {
            Intrinsics.c("view_bordwr_1");
            view4 = null;
        }
        floatRef2.a = view4.getTranslationY();
        final Ref.IntRef intRef = new Ref.IntRef();
        View view5 = this.v;
        View view6 = view5;
        if (view5 == null) {
            Intrinsics.c("view_bordwr_1");
            view6 = null;
        }
        intRef.a = view6.getWidth();
        final Ref.IntRef intRef2 = new Ref.IntRef();
        View view7 = this.v;
        View view8 = view7;
        if (view7 == null) {
            Intrinsics.c("view_bordwr_1");
            view8 = null;
        }
        intRef2.a = view8.getHeight();
        int a = DensityUtils.a(getContext(), 27.0f);
        final Ref.FloatRef floatRef3 = new Ref.FloatRef();
        View view9 = this.x;
        View view10 = view9;
        if (view9 == null) {
            Intrinsics.c("view_line");
            view10 = null;
        }
        floatRef3.a = view10.getTranslationX();
        final Ref.FloatRef floatRef4 = new Ref.FloatRef();
        View view11 = this.x;
        View view12 = view11;
        if (view11 == null) {
            Intrinsics.c("view_line");
            view12 = null;
        }
        floatRef4.a = view12.getTranslationY() + a;
        final Ref.FloatRef floatRef5 = new Ref.FloatRef();
        floatRef5.a = 1.0f;
        final Ref.FloatRef floatRef6 = new Ref.FloatRef();
        floatRef6.a = 1.0f;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(300L);
        ofFloat.setStartDelay(0L);
        ofFloat.setInterpolator(new DecelerateInterpolator(1.5f));
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.pop.-$$Lambda$LivePlanetGuidePop$qGp8KI7bvbjFFEX7U-T3VNDkjs4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                LivePlanetGuidePop.d(LivePlanetGuidePop.this, floatRef, floatRef3, floatRef2, floatRef4, intRef, floatRef5, intRef2, floatRef6, valueAnimator);
            }
        });
        ofFloat.start();
        View view13 = this.v;
        View view14 = view13;
        if (view13 == null) {
            Intrinsics.c("view_bordwr_1");
            view14 = null;
        }
        view14.animate().alpha(0.0f).setDuration(ofFloat.getDuration()).setStartDelay(ofFloat.getStartDelay()).setInterpolator(ofFloat.getInterpolator()).start();
        View view15 = this.x;
        View view16 = view15;
        if (view15 == null) {
            Intrinsics.c("view_line");
            view16 = null;
        }
        view16.animate().alpha(0.0f).setDuration(ofFloat.getDuration()).setStartDelay(ofFloat.getStartDelay()).setInterpolator(ofFloat.getInterpolator()).withEndAction(new Runnable() { // from class: com.blued.android.module.live_china.pop.-$$Lambda$LivePlanetGuidePop$5qG4_2FUvo8iNmGme-S4_ix-coI
            @Override // java.lang.Runnable
            public final void run() {
                LivePlanetGuidePop.g(LivePlanetGuidePop.this);
            }
        }).start();
        LivePlanetGuideShadeView livePlanetGuideShadeView = this.A;
        LivePlanetGuideShadeView livePlanetGuideShadeView2 = livePlanetGuideShadeView;
        if (livePlanetGuideShadeView == null) {
            Intrinsics.c("lpgc");
            livePlanetGuideShadeView2 = null;
        }
        livePlanetGuideShadeView2.a((int) floatRef.a, (int) floatRef2.a, intRef.a, intRef2.a);
        LivePlanetGuideShadeView livePlanetGuideShadeView3 = this.A;
        if (livePlanetGuideShadeView3 == null) {
            Intrinsics.c("lpgc");
            livePlanetGuideShadeView3 = null;
        }
        livePlanetGuideShadeView3.a((int) floatRef3.a, (int) floatRef4.a, (int) floatRef5.a, (int) floatRef6.a, ofFloat.getDuration(), ofFloat.getStartDelay());
        ImageView imageView3 = this.t;
        ImageView imageView4 = imageView3;
        if (imageView3 == null) {
            Intrinsics.c("iv_close");
            imageView4 = null;
        }
        imageView4.animate().alpha(0.0f).setDuration(ofFloat.getDuration()).withEndAction(new Runnable() { // from class: com.blued.android.module.live_china.pop.-$$Lambda$LivePlanetGuidePop$8GemU197Oamr2koct5OOj2m-kOg
            @Override // java.lang.Runnable
            public final void run() {
                LivePlanetGuidePop.h(LivePlanetGuidePop.this);
            }
        }).start();
        ImageView imageView5 = this.k;
        if (imageView5 == null) {
            Intrinsics.c("iv_next");
            imageView5 = null;
        }
        imageView5.animate().alpha(0.0f).setDuration(ofFloat.getDuration()).withEndAction(new Runnable() { // from class: com.blued.android.module.live_china.pop.-$$Lambda$LivePlanetGuidePop$OTOLxpGcd2yOdi5c1FIzXm2ecYg
            @Override // java.lang.Runnable
            public final void run() {
                LivePlanetGuidePop.i(LivePlanetGuidePop.this);
            }
        }).start();
    }

    private final void C() {
        ImageView imageView = this.k;
        ImageView imageView2 = imageView;
        if (imageView == null) {
            Intrinsics.c("iv_next");
            imageView2 = null;
        }
        imageView2.setClickable(false);
        int[] iArr = new int[2];
        DialogLivePlanetBinding dialogLivePlanetBinding = this.d;
        DialogLivePlanetBinding dialogLivePlanetBinding2 = dialogLivePlanetBinding;
        if (dialogLivePlanetBinding == null) {
            Intrinsics.c("vb");
            dialogLivePlanetBinding2 = null;
        }
        dialogLivePlanetBinding2.v.getLocationOnScreen(iArr);
        iArr[0] = iArr[0] - DensityUtils.a(getContext(), 10.0f);
        iArr[1] = iArr[1] - DensityUtils.a(getContext(), 5.0f);
        DialogLivePlanetBinding dialogLivePlanetBinding3 = this.d;
        DialogLivePlanetBinding dialogLivePlanetBinding4 = dialogLivePlanetBinding3;
        if (dialogLivePlanetBinding3 == null) {
            Intrinsics.c("vb");
            dialogLivePlanetBinding4 = null;
        }
        int width = dialogLivePlanetBinding4.v.getWidth();
        int a = DensityUtils.a(getContext(), 20.0f);
        DialogLivePlanetBinding dialogLivePlanetBinding5 = this.d;
        DialogLivePlanetBinding dialogLivePlanetBinding6 = dialogLivePlanetBinding5;
        if (dialogLivePlanetBinding5 == null) {
            Intrinsics.c("vb");
            dialogLivePlanetBinding6 = null;
        }
        int height = dialogLivePlanetBinding6.v.getHeight() - DensityUtils.a(getContext(), 10.0f);
        int a2 = DensityUtils.a(getContext(), 54.0f);
        int a3 = DensityUtils.a(getContext(), 37.0f);
        int i = iArr[0] - a2;
        int i2 = iArr[1] + height + a3;
        ImageView imageView3 = this.j;
        ImageView imageView4 = imageView3;
        if (imageView3 == null) {
            Intrinsics.c("iv_step_4");
            imageView4 = null;
        }
        BluedViewExKt.b(imageView4);
        ImageView imageView5 = this.i;
        ImageView imageView6 = imageView5;
        if (imageView5 == null) {
            Intrinsics.c("iv_step_3");
            imageView6 = null;
        }
        BluedViewExKt.a(imageView6);
        FrameLayout frameLayout = this.f;
        FrameLayout frameLayout2 = frameLayout;
        if (frameLayout == null) {
            Intrinsics.c("fl_step_root");
            frameLayout2 = null;
        }
        frameLayout2.animate().translationX(i).translationY(i2).setDuration(350L).start();
        int a4 = DensityUtils.a(getContext(), 81.0f);
        int a5 = DensityUtils.a(getContext(), 60.0f);
        int a6 = DensityUtils.a(getContext(), 20.0f);
        ImageView imageView7 = this.u;
        ImageView imageView8 = imageView7;
        if (imageView7 == null) {
            Intrinsics.c("iv_start_planet");
            imageView8 = null;
        }
        imageView8.setAlpha(0.0f);
        ImageView imageView9 = this.u;
        ImageView imageView10 = imageView9;
        if (imageView9 == null) {
            Intrinsics.c("iv_start_planet");
            imageView10 = null;
        }
        BluedViewExKt.b(imageView10);
        ImageView imageView11 = this.u;
        ImageView imageView12 = imageView11;
        if (imageView11 == null) {
            Intrinsics.c("iv_start_planet");
            imageView12 = null;
        }
        imageView12.setTranslationX(i - a6);
        ImageView imageView13 = this.u;
        ImageView imageView14 = imageView13;
        if (imageView13 == null) {
            Intrinsics.c("iv_start_planet");
            imageView14 = null;
        }
        imageView14.setTranslationY(a4 + i2 + a5);
        ImageView imageView15 = this.u;
        ImageView imageView16 = imageView15;
        if (imageView15 == null) {
            Intrinsics.c("iv_start_planet");
            imageView16 = null;
        }
        imageView16.animate().alpha(1.0f).setDuration(350L).setStartDelay(300L).start();
        ImageView imageView17 = this.u;
        ImageView imageView18 = imageView17;
        if (imageView17 == null) {
            Intrinsics.c("iv_start_planet");
            imageView18 = null;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView18, "scaleX", 1.0f, 0.9f, 1.0f);
        ofFloat.setDuration(1300L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(ofFloat.getRepeatCount());
        ofFloat.start();
        ImageView imageView19 = this.u;
        ImageView imageView20 = imageView19;
        if (imageView19 == null) {
            Intrinsics.c("iv_start_planet");
            imageView20 = null;
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView20, "scaleY", 1.0f, 0.9f, 1.0f);
        ofFloat2.setDuration(1300L);
        ofFloat2.setInterpolator(new LinearInterpolator());
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(ofFloat2.getRepeatCount());
        ofFloat2.start();
        int a7 = DensityUtils.a(getContext(), 3.0f);
        int a8 = DensityUtils.a(getContext(), 124.0f);
        int a9 = DensityUtils.a(getContext(), 38.0f);
        int a10 = DensityUtils.a(getContext(), 44.0f);
        View view = this.x;
        View view2 = view;
        if (view == null) {
            Intrinsics.c("view_line");
            view2 = null;
        }
        view2.setAlpha(0.0f);
        View view3 = this.x;
        View view4 = view3;
        if (view3 == null) {
            Intrinsics.c("view_line");
            view4 = null;
        }
        view4.setTranslationX(i + a8);
        View view5 = this.x;
        View view6 = view5;
        if (view5 == null) {
            Intrinsics.c("view_line");
            view6 = null;
        }
        view6.setTranslationY(i2 - a9);
        View view7 = this.x;
        View view8 = view7;
        if (view7 == null) {
            Intrinsics.c("view_line");
            view8 = null;
        }
        view8.setLayoutParams(new FrameLayout.LayoutParams(a7, a10));
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        View view9 = this.x;
        View view10 = view9;
        if (view9 == null) {
            Intrinsics.c("view_line");
            view10 = null;
        }
        floatRef.a = view10.getTranslationX();
        final Ref.FloatRef floatRef2 = new Ref.FloatRef();
        View view11 = this.x;
        View view12 = view11;
        if (view11 == null) {
            Intrinsics.c("view_line");
            view12 = null;
        }
        floatRef2.a = view12.getTranslationY();
        final Ref.FloatRef floatRef3 = new Ref.FloatRef();
        floatRef3.a = 1.0f;
        final Ref.FloatRef floatRef4 = new Ref.FloatRef();
        floatRef4.a = 1.0f;
        final Ref.FloatRef floatRef5 = new Ref.FloatRef();
        floatRef5.a = iArr[0];
        final Ref.FloatRef floatRef6 = new Ref.FloatRef();
        floatRef6.a = iArr[1];
        final Ref.FloatRef floatRef7 = new Ref.FloatRef();
        floatRef7.a = width + a;
        final Ref.FloatRef floatRef8 = new Ref.FloatRef();
        floatRef8.a = height;
        View view13 = this.v;
        View view14 = view13;
        if (view13 == null) {
            Intrinsics.c("view_bordwr_1");
            view14 = null;
        }
        view14.setAlpha(0.0f);
        final ValueAnimator ofFloat3 = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat3.setDuration(500L);
        ofFloat3.setStartDelay(200L);
        ofFloat3.setInterpolator(new DecelerateInterpolator(1.5f));
        ofFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.pop.-$$Lambda$LivePlanetGuidePop$1OhluZPqzfUqCvRicJa3K60j3qA
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                LivePlanetGuidePop.e(LivePlanetGuidePop.this, floatRef, floatRef5, floatRef2, floatRef6, floatRef3, floatRef7, floatRef4, floatRef8, valueAnimator);
            }
        });
        ofFloat3.start();
        View view15 = this.x;
        View view16 = view15;
        if (view15 == null) {
            Intrinsics.c("view_line");
            view16 = null;
        }
        view16.animate().alpha(1.0f).setDuration(ofFloat3.getDuration()).setStartDelay(ofFloat3.getStartDelay()).setInterpolator(ofFloat3.getInterpolator()).start();
        View view17 = this.v;
        View view18 = view17;
        if (view17 == null) {
            Intrinsics.c("view_bordwr_1");
            view18 = null;
        }
        view18.animate().alpha(1.0f).setDuration(ofFloat3.getDuration()).setStartDelay(ofFloat3.getStartDelay()).setInterpolator(ofFloat3.getInterpolator()).withEndAction(new Runnable() { // from class: com.blued.android.module.live_china.pop.-$$Lambda$LivePlanetGuidePop$QUFJmnqrZjDOzewBgIhLwzQ_jZg
            @Override // java.lang.Runnable
            public final void run() {
                LivePlanetGuidePop.j(LivePlanetGuidePop.this);
            }
        }).start();
        LivePlanetGuideShadeView livePlanetGuideShadeView = this.A;
        LivePlanetGuideShadeView livePlanetGuideShadeView2 = livePlanetGuideShadeView;
        if (livePlanetGuideShadeView == null) {
            Intrinsics.c("lpgc");
            livePlanetGuideShadeView2 = null;
        }
        livePlanetGuideShadeView2.a((int) floatRef.a, (int) floatRef2.a, (int) floatRef3.a, (int) floatRef4.a);
        LivePlanetGuideShadeView livePlanetGuideShadeView3 = this.A;
        if (livePlanetGuideShadeView3 == null) {
            Intrinsics.c("lpgc");
            livePlanetGuideShadeView3 = null;
        }
        livePlanetGuideShadeView3.post(new Runnable() { // from class: com.blued.android.module.live_china.pop.-$$Lambda$LivePlanetGuidePop$eqoqCA2CGpku0PaOSfAozxAM6L0
            @Override // java.lang.Runnable
            public final void run() {
                LivePlanetGuidePop.b(LivePlanetGuidePop.this, floatRef5, floatRef6, floatRef7, floatRef8, ofFloat3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LivePlanetGuidePop this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LivePlanetGuidePop this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LivePlanetGuidePop this$0, Ref.FloatRef border1TargetX, Ref.FloatRef border1TargetY, Ref.FloatRef border1TargetW, Ref.FloatRef border1TargetH, ValueAnimator valueAnimator) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(border1TargetX, "$border1TargetX");
        Intrinsics.e(border1TargetY, "$border1TargetY");
        Intrinsics.e(border1TargetW, "$border1TargetW");
        Intrinsics.e(border1TargetH, "$border1TargetH");
        LivePlanetGuideShadeView livePlanetGuideShadeView = this$0.A;
        LivePlanetGuideShadeView livePlanetGuideShadeView2 = livePlanetGuideShadeView;
        if (livePlanetGuideShadeView == null) {
            Intrinsics.c("lpgc");
            livePlanetGuideShadeView2 = null;
        }
        livePlanetGuideShadeView2.a((int) border1TargetX.a, (int) border1TargetY.a, (int) border1TargetW.a, (int) border1TargetH.a, valueAnimator.getDuration(), valueAnimator.getStartDelay());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LivePlanetGuidePop this$0, Ref.FloatRef border1CurrentX, Ref.FloatRef border1TargetX, Ref.FloatRef border1CurrentY, Ref.FloatRef border1TargetY, Ref.FloatRef border1CurrentW, Ref.FloatRef border1TargetW, Ref.FloatRef border1CurrentH, Ref.FloatRef border1TargetH, ValueAnimator animation) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(border1CurrentX, "$border1CurrentX");
        Intrinsics.e(border1TargetX, "$border1TargetX");
        Intrinsics.e(border1CurrentY, "$border1CurrentY");
        Intrinsics.e(border1TargetY, "$border1TargetY");
        Intrinsics.e(border1CurrentW, "$border1CurrentW");
        Intrinsics.e(border1TargetW, "$border1TargetW");
        Intrinsics.e(border1CurrentH, "$border1CurrentH");
        Intrinsics.e(border1TargetH, "$border1TargetH");
        Intrinsics.e(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        if (animatedValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
        float floatValue = ((Float) animatedValue).floatValue();
        View view = this$0.v;
        View view2 = view;
        if (view == null) {
            Intrinsics.c("view_bordwr_1");
            view2 = null;
        }
        view2.setTranslationX(border1CurrentX.a + ((border1TargetX.a - border1CurrentX.a) * floatValue));
        View view3 = this$0.v;
        View view4 = view3;
        if (view3 == null) {
            Intrinsics.c("view_bordwr_1");
            view4 = null;
        }
        view4.setTranslationY(border1CurrentY.a + ((border1TargetY.a - border1CurrentY.a) * floatValue));
        View view5 = this$0.v;
        View view6 = view5;
        if (view5 == null) {
            Intrinsics.c("view_bordwr_1");
            view6 = null;
        }
        view6.setLayoutParams(new FrameLayout.LayoutParams((int) (border1CurrentW.a + ((border1TargetW.a - border1CurrentW.a) * floatValue)), (int) (border1CurrentH.a + ((border1TargetH.a - border1CurrentH.a) * floatValue))));
        View view7 = this$0.v;
        View view8 = view7;
        if (view7 == null) {
            Intrinsics.c("view_bordwr_1");
            view8 = null;
        }
        View view9 = this$0.v;
        if (view9 == null) {
            Intrinsics.c("view_bordwr_1");
            view9 = null;
        }
        view8.setLayoutParams(view9.getLayoutParams());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LivePlanetGuidePop this$0, Ref.FloatRef border1CurrentX, Ref.FloatRef border1TargetX, Ref.FloatRef border1CurrentY, Ref.FloatRef border1TargetY, Ref.IntRef border1CurrentW, Ref.FloatRef border1TargetW, Ref.IntRef border1CurrentH, Ref.FloatRef border1TargetH, ValueAnimator animation) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(border1CurrentX, "$border1CurrentX");
        Intrinsics.e(border1TargetX, "$border1TargetX");
        Intrinsics.e(border1CurrentY, "$border1CurrentY");
        Intrinsics.e(border1TargetY, "$border1TargetY");
        Intrinsics.e(border1CurrentW, "$border1CurrentW");
        Intrinsics.e(border1TargetW, "$border1TargetW");
        Intrinsics.e(border1CurrentH, "$border1CurrentH");
        Intrinsics.e(border1TargetH, "$border1TargetH");
        Intrinsics.e(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        if (animatedValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
        float floatValue = ((Float) animatedValue).floatValue();
        View view = this$0.v;
        View view2 = view;
        if (view == null) {
            Intrinsics.c("view_bordwr_1");
            view2 = null;
        }
        view2.setTranslationX(border1CurrentX.a + ((border1TargetX.a - border1CurrentX.a) * floatValue));
        View view3 = this$0.v;
        View view4 = view3;
        if (view3 == null) {
            Intrinsics.c("view_bordwr_1");
            view4 = null;
        }
        view4.setTranslationY(border1CurrentY.a + ((border1TargetY.a - border1CurrentY.a) * floatValue));
        View view5 = this$0.v;
        View view6 = view5;
        if (view5 == null) {
            Intrinsics.c("view_bordwr_1");
            view6 = null;
        }
        view6.setLayoutParams(new FrameLayout.LayoutParams((int) (border1CurrentW.a + ((border1TargetW.a - border1CurrentW.a) * floatValue)), (int) (border1CurrentH.a + ((border1TargetH.a - border1CurrentH.a) * floatValue))));
        View view7 = this$0.v;
        View view8 = view7;
        if (view7 == null) {
            Intrinsics.c("view_bordwr_1");
            view8 = null;
        }
        View view9 = this$0.v;
        if (view9 == null) {
            Intrinsics.c("view_bordwr_1");
            view9 = null;
        }
        view8.setLayoutParams(view9.getLayoutParams());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LivePlanetGuidePop this$0, Ref.IntRef border1CurrentX, Ref.FloatRef border1TargetX, Ref.FloatRef border1CurrentY, Ref.FloatRef border1TargetY, Ref.FloatRef border1CurrentW, Ref.FloatRef border1TargetW, Ref.FloatRef border1CurrentH, Ref.FloatRef border1TargetH, ValueAnimator animation) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(border1CurrentX, "$border1CurrentX");
        Intrinsics.e(border1TargetX, "$border1TargetX");
        Intrinsics.e(border1CurrentY, "$border1CurrentY");
        Intrinsics.e(border1TargetY, "$border1TargetY");
        Intrinsics.e(border1CurrentW, "$border1CurrentW");
        Intrinsics.e(border1TargetW, "$border1TargetW");
        Intrinsics.e(border1CurrentH, "$border1CurrentH");
        Intrinsics.e(border1TargetH, "$border1TargetH");
        Intrinsics.e(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        if (animatedValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
        float floatValue = ((Float) animatedValue).floatValue();
        View view = this$0.v;
        View view2 = view;
        if (view == null) {
            Intrinsics.c("view_bordwr_1");
            view2 = null;
        }
        view2.setTranslationX(border1CurrentX.a + ((border1TargetX.a - border1CurrentX.a) * floatValue));
        View view3 = this$0.v;
        View view4 = view3;
        if (view3 == null) {
            Intrinsics.c("view_bordwr_1");
            view4 = null;
        }
        view4.setTranslationY(border1CurrentY.a + ((border1TargetY.a - border1CurrentY.a) * floatValue));
        View view5 = this$0.v;
        View view6 = view5;
        if (view5 == null) {
            Intrinsics.c("view_bordwr_1");
            view6 = null;
        }
        view6.setLayoutParams(new FrameLayout.LayoutParams((int) (border1CurrentW.a + ((border1TargetW.a - border1CurrentW.a) * floatValue)), (int) (border1CurrentH.a + ((border1TargetH.a - border1CurrentH.a) * floatValue))));
        View view7 = this$0.v;
        View view8 = view7;
        if (view7 == null) {
            Intrinsics.c("view_bordwr_1");
            view8 = null;
        }
        View view9 = this$0.v;
        if (view9 == null) {
            Intrinsics.c("view_bordwr_1");
            view9 = null;
        }
        view8.setLayoutParams(view9.getLayoutParams());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LivePlanetGuidePop this$0, Ref.ObjectRef myAirshipPoint, ValueAnimator valueAnimator) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(myAirshipPoint, "$myAirshipPoint");
        LivePlanetGuideShadeView livePlanetGuideShadeView = this$0.A;
        if (livePlanetGuideShadeView == null) {
            Intrinsics.c("lpgc");
            livePlanetGuideShadeView = null;
        }
        int i = ((int[]) myAirshipPoint.a)[0];
        int i2 = ((int[]) myAirshipPoint.a)[1];
        DialogLivePlanetBinding dialogLivePlanetBinding = this$0.d;
        DialogLivePlanetBinding dialogLivePlanetBinding2 = dialogLivePlanetBinding;
        if (dialogLivePlanetBinding == null) {
            Intrinsics.c("vb");
            dialogLivePlanetBinding2 = null;
        }
        int width = dialogLivePlanetBinding2.r.getWidth();
        DialogLivePlanetBinding dialogLivePlanetBinding3 = this$0.d;
        if (dialogLivePlanetBinding3 == null) {
            Intrinsics.c("vb");
            dialogLivePlanetBinding3 = null;
        }
        livePlanetGuideShadeView.a(i, i2, width, dialogLivePlanetBinding3.r.getHeight(), valueAnimator.getDuration(), valueAnimator.getStartDelay());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(final LivePlanetGuidePop this$0) {
        Intrinsics.e(this$0, "this$0");
        ImageView imageView = this$0.k;
        ImageView imageView2 = imageView;
        if (imageView == null) {
            Intrinsics.c("iv_next");
            imageView2 = null;
        }
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.pop.-$$Lambda$LivePlanetGuidePop$-svmCEBLmrs3r6LqJ2OtkklN5fY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LivePlanetGuidePop.c(LivePlanetGuidePop.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LivePlanetGuidePop this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LivePlanetGuidePop this$0, Ref.FloatRef border1TargetX, Ref.FloatRef border1TargetY, Ref.FloatRef border1TargetW, Ref.FloatRef border1TargetH, ValueAnimator valueAnimator) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(border1TargetX, "$border1TargetX");
        Intrinsics.e(border1TargetY, "$border1TargetY");
        Intrinsics.e(border1TargetW, "$border1TargetW");
        Intrinsics.e(border1TargetH, "$border1TargetH");
        LivePlanetGuideShadeView livePlanetGuideShadeView = this$0.A;
        LivePlanetGuideShadeView livePlanetGuideShadeView2 = livePlanetGuideShadeView;
        if (livePlanetGuideShadeView == null) {
            Intrinsics.c("lpgc");
            livePlanetGuideShadeView2 = null;
        }
        livePlanetGuideShadeView2.a((int) border1TargetX.a, (int) border1TargetY.a, (int) border1TargetW.a, (int) border1TargetH.a, valueAnimator.getDuration(), valueAnimator.getStartDelay());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LivePlanetGuidePop this$0, Ref.FloatRef border2CurrentX, Ref.FloatRef border2TargetX, Ref.FloatRef border2CurrentY, Ref.FloatRef border2TargetY, Ref.FloatRef border2CurrentW, Ref.FloatRef border2TargetW, Ref.FloatRef border2CurrentH, Ref.FloatRef border2TargetH, ValueAnimator animation) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(border2CurrentX, "$border2CurrentX");
        Intrinsics.e(border2TargetX, "$border2TargetX");
        Intrinsics.e(border2CurrentY, "$border2CurrentY");
        Intrinsics.e(border2TargetY, "$border2TargetY");
        Intrinsics.e(border2CurrentW, "$border2CurrentW");
        Intrinsics.e(border2TargetW, "$border2TargetW");
        Intrinsics.e(border2CurrentH, "$border2CurrentH");
        Intrinsics.e(border2TargetH, "$border2TargetH");
        Intrinsics.e(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        if (animatedValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
        float floatValue = ((Float) animatedValue).floatValue();
        View view = this$0.w;
        View view2 = view;
        if (view == null) {
            Intrinsics.c("view_bordwr_2");
            view2 = null;
        }
        view2.setTranslationX(border2CurrentX.a + ((border2TargetX.a - border2CurrentX.a) * floatValue));
        View view3 = this$0.w;
        View view4 = view3;
        if (view3 == null) {
            Intrinsics.c("view_bordwr_2");
            view4 = null;
        }
        view4.setTranslationY(border2CurrentY.a + ((border2TargetY.a - border2CurrentY.a) * floatValue));
        View view5 = this$0.w;
        View view6 = view5;
        if (view5 == null) {
            Intrinsics.c("view_bordwr_2");
            view6 = null;
        }
        view6.setLayoutParams(new FrameLayout.LayoutParams((int) (border2CurrentW.a + ((border2TargetW.a - border2CurrentW.a) * floatValue)), (int) (border2CurrentH.a + ((border2TargetH.a - border2CurrentH.a) * floatValue))));
        View view7 = this$0.w;
        View view8 = view7;
        if (view7 == null) {
            Intrinsics.c("view_bordwr_2");
            view8 = null;
        }
        View view9 = this$0.w;
        if (view9 == null) {
            Intrinsics.c("view_bordwr_2");
            view9 = null;
        }
        view8.setLayoutParams(view9.getLayoutParams());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LivePlanetGuidePop this$0, Ref.FloatRef border1CurrentX, Ref.FloatRef border1TargetX, Ref.FloatRef border1CurrentY, Ref.FloatRef border1TargetY, Ref.IntRef border1CurrentW, Ref.FloatRef border1TargetW, Ref.IntRef border1CurrentH, Ref.FloatRef border1TargetH, ValueAnimator animation) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(border1CurrentX, "$border1CurrentX");
        Intrinsics.e(border1TargetX, "$border1TargetX");
        Intrinsics.e(border1CurrentY, "$border1CurrentY");
        Intrinsics.e(border1TargetY, "$border1TargetY");
        Intrinsics.e(border1CurrentW, "$border1CurrentW");
        Intrinsics.e(border1TargetW, "$border1TargetW");
        Intrinsics.e(border1CurrentH, "$border1CurrentH");
        Intrinsics.e(border1TargetH, "$border1TargetH");
        Intrinsics.e(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        if (animatedValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
        float floatValue = ((Float) animatedValue).floatValue();
        View view = this$0.v;
        View view2 = view;
        if (view == null) {
            Intrinsics.c("view_bordwr_1");
            view2 = null;
        }
        view2.setTranslationX(border1CurrentX.a + ((border1TargetX.a - border1CurrentX.a) * floatValue));
        View view3 = this$0.v;
        View view4 = view3;
        if (view3 == null) {
            Intrinsics.c("view_bordwr_1");
            view4 = null;
        }
        view4.setTranslationY(border1CurrentY.a + ((border1TargetY.a - border1CurrentY.a) * floatValue));
        View view5 = this$0.v;
        View view6 = view5;
        if (view5 == null) {
            Intrinsics.c("view_bordwr_1");
            view6 = null;
        }
        view6.setLayoutParams(new FrameLayout.LayoutParams((int) (border1CurrentW.a + ((border1TargetW.a - border1CurrentW.a) * floatValue)), (int) (border1CurrentH.a + ((border1TargetH.a - border1CurrentH.a) * floatValue))));
        View view7 = this$0.v;
        View view8 = view7;
        if (view7 == null) {
            Intrinsics.c("view_bordwr_1");
            view8 = null;
        }
        View view9 = this$0.v;
        if (view9 == null) {
            Intrinsics.c("view_bordwr_1");
            view9 = null;
        }
        view8.setLayoutParams(view9.getLayoutParams());
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [int[], T] */
    private final void c() {
        ImageView imageView = this.k;
        ImageView imageView2 = imageView;
        if (imageView == null) {
            Intrinsics.c("iv_next");
            imageView2 = null;
        }
        imageView2.setClickable(false);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.a = new int[2];
        DialogLivePlanetBinding dialogLivePlanetBinding = this.d;
        DialogLivePlanetBinding dialogLivePlanetBinding2 = dialogLivePlanetBinding;
        if (dialogLivePlanetBinding == null) {
            Intrinsics.c("vb");
            dialogLivePlanetBinding2 = null;
        }
        dialogLivePlanetBinding2.r.getLocationOnScreen((int[]) objectRef.a);
        int a = DensityUtils.a(getContext(), 205.0f);
        int a2 = DensityUtils.a(getContext(), 46.0f);
        int a3 = DensityUtils.a(getContext(), 87.0f);
        int a4 = DensityUtils.a(getContext(), 88.0f);
        FrameLayout frameLayout = this.e;
        FrameLayout frameLayout2 = frameLayout;
        if (frameLayout == null) {
            Intrinsics.c("fl_root");
            frameLayout2 = null;
        }
        int width = frameLayout2.getWidth();
        int i = (((int[]) objectRef.a)[1] - a3) - a4;
        FrameLayout frameLayout3 = this.f;
        FrameLayout frameLayout4 = frameLayout3;
        if (frameLayout3 == null) {
            Intrinsics.c("fl_step_root");
            frameLayout4 = null;
        }
        float f = (width - a) - a2;
        frameLayout4.setTranslationX(f);
        FrameLayout frameLayout5 = this.f;
        FrameLayout frameLayout6 = frameLayout5;
        if (frameLayout5 == null) {
            Intrinsics.c("fl_step_root");
            frameLayout6 = null;
        }
        frameLayout6.setTranslationY(i);
        int a5 = DensityUtils.a(getContext(), 14.0f);
        int a6 = DensityUtils.a(getContext(), 47.0f);
        int a7 = DensityUtils.a(getContext(), 30.0f);
        ImageView imageView3 = this.k;
        ImageView imageView4 = imageView3;
        if (imageView3 == null) {
            Intrinsics.c("iv_next");
            imageView4 = null;
        }
        imageView4.setTranslationX(f);
        ImageView imageView5 = this.k;
        ImageView imageView6 = imageView5;
        if (imageView5 == null) {
            Intrinsics.c("iv_next");
            imageView6 = null;
        }
        imageView6.setTranslationY(a3 + i + a5);
        ImageView imageView7 = this.t;
        ImageView imageView8 = imageView7;
        if (imageView7 == null) {
            Intrinsics.c("iv_close");
            imageView8 = null;
        }
        FrameLayout frameLayout7 = this.e;
        FrameLayout frameLayout8 = frameLayout7;
        if (frameLayout7 == null) {
            Intrinsics.c("fl_root");
            frameLayout8 = null;
        }
        imageView8.setTranslationX((frameLayout8.getWidth() - a6) - a7);
        ImageView imageView9 = this.t;
        ImageView imageView10 = imageView9;
        if (imageView9 == null) {
            Intrinsics.c("iv_close");
            imageView10 = null;
        }
        imageView10.setTranslationY((i - a5) - a7);
        int a8 = DensityUtils.a(getContext(), 3.0f);
        int a9 = DensityUtils.a(getContext(), 69.0f);
        int a10 = DensityUtils.a(getContext(), 92.0f);
        View view = this.x;
        View view2 = view;
        if (view == null) {
            Intrinsics.c("view_line");
            view2 = null;
        }
        view2.setAlpha(0.0f);
        View view3 = this.x;
        View view4 = view3;
        if (view3 == null) {
            Intrinsics.c("view_line");
            view4 = null;
        }
        FrameLayout frameLayout9 = this.e;
        FrameLayout frameLayout10 = frameLayout9;
        if (frameLayout9 == null) {
            Intrinsics.c("fl_root");
            frameLayout10 = null;
        }
        view4.setTranslationX(frameLayout10.getWidth() - a9);
        View view5 = this.x;
        View view6 = view5;
        if (view5 == null) {
            Intrinsics.c("view_line");
            view6 = null;
        }
        FrameLayout frameLayout11 = this.f;
        FrameLayout frameLayout12 = frameLayout11;
        if (frameLayout11 == null) {
            Intrinsics.c("fl_step_root");
            frameLayout12 = null;
        }
        view6.setTranslationY((i + frameLayout12.getHeight()) - a8);
        View view7 = this.x;
        View view8 = view7;
        if (view7 == null) {
            Intrinsics.c("view_line");
            view8 = null;
        }
        view8.setLayoutParams(new FrameLayout.LayoutParams(a8, a10));
        final Ref.IntRef intRef = new Ref.IntRef();
        View view9 = this.x;
        View view10 = view9;
        if (view9 == null) {
            Intrinsics.c("view_line");
            view10 = null;
        }
        intRef.a = (int) view10.getTranslationX();
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        floatRef.a = ((int[]) objectRef.a)[1];
        final Ref.FloatRef floatRef2 = new Ref.FloatRef();
        floatRef2.a = 1.0f;
        final Ref.FloatRef floatRef3 = new Ref.FloatRef();
        floatRef3.a = 1.0f;
        final Ref.FloatRef floatRef4 = new Ref.FloatRef();
        floatRef4.a = ((int[]) objectRef.a)[0];
        final Ref.FloatRef floatRef5 = new Ref.FloatRef();
        floatRef5.a = ((int[]) objectRef.a)[1];
        final Ref.FloatRef floatRef6 = new Ref.FloatRef();
        DialogLivePlanetBinding dialogLivePlanetBinding3 = this.d;
        DialogLivePlanetBinding dialogLivePlanetBinding4 = dialogLivePlanetBinding3;
        if (dialogLivePlanetBinding3 == null) {
            Intrinsics.c("vb");
            dialogLivePlanetBinding4 = null;
        }
        floatRef6.a = dialogLivePlanetBinding4.r.getWidth();
        final Ref.FloatRef floatRef7 = new Ref.FloatRef();
        DialogLivePlanetBinding dialogLivePlanetBinding5 = this.d;
        DialogLivePlanetBinding dialogLivePlanetBinding6 = dialogLivePlanetBinding5;
        if (dialogLivePlanetBinding5 == null) {
            Intrinsics.c("vb");
            dialogLivePlanetBinding6 = null;
        }
        floatRef7.a = dialogLivePlanetBinding6.r.getHeight();
        View view11 = this.v;
        View view12 = view11;
        if (view11 == null) {
            Intrinsics.c("view_bordwr_1");
            view12 = null;
        }
        view12.setAlpha(0.0f);
        final ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(500L);
        ofFloat.setStartDelay(200L);
        ofFloat.setInterpolator(new DecelerateInterpolator(1.5f));
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.pop.-$$Lambda$LivePlanetGuidePop$1ggAiAgomxQdGq4oZUjeAhJuXG4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                LivePlanetGuidePop.a(LivePlanetGuidePop.this, intRef, floatRef4, floatRef, floatRef5, floatRef2, floatRef6, floatRef3, floatRef7, valueAnimator);
            }
        });
        ofFloat.start();
        View view13 = this.x;
        View view14 = view13;
        if (view13 == null) {
            Intrinsics.c("view_line");
            view14 = null;
        }
        view14.animate().alpha(1.0f).setDuration(ofFloat.getDuration()).setStartDelay(ofFloat.getStartDelay()).setInterpolator(ofFloat.getInterpolator()).start();
        View view15 = this.v;
        View view16 = view15;
        if (view15 == null) {
            Intrinsics.c("view_bordwr_1");
            view16 = null;
        }
        view16.animate().alpha(1.0f).setDuration(ofFloat.getDuration()).setStartDelay(ofFloat.getStartDelay()).setInterpolator(ofFloat.getInterpolator()).withEndAction(new Runnable() { // from class: com.blued.android.module.live_china.pop.-$$Lambda$LivePlanetGuidePop$BWKdtDsfnFP4zFm5bnUPxLdn8Lc
            @Override // java.lang.Runnable
            public final void run() {
                LivePlanetGuidePop.b(LivePlanetGuidePop.this);
            }
        }).start();
        LivePlanetGuideShadeView livePlanetGuideShadeView = this.A;
        LivePlanetGuideShadeView livePlanetGuideShadeView2 = livePlanetGuideShadeView;
        if (livePlanetGuideShadeView == null) {
            Intrinsics.c("lpgc");
            livePlanetGuideShadeView2 = null;
        }
        View view17 = this.x;
        View view18 = view17;
        if (view17 == null) {
            Intrinsics.c("view_line");
            view18 = null;
        }
        livePlanetGuideShadeView2.a((int) view18.getTranslationX(), ((int[]) objectRef.a)[1], (int) floatRef2.a, (int) floatRef3.a);
        LivePlanetGuideShadeView livePlanetGuideShadeView3 = this.A;
        if (livePlanetGuideShadeView3 == null) {
            Intrinsics.c("lpgc");
            livePlanetGuideShadeView3 = null;
        }
        livePlanetGuideShadeView3.post(new Runnable() { // from class: com.blued.android.module.live_china.pop.-$$Lambda$LivePlanetGuidePop$iqf3K95utGrYOKyDBHHSxxa0xkU
            @Override // java.lang.Runnable
            public final void run() {
                LivePlanetGuidePop.a(LivePlanetGuidePop.this, objectRef, ofFloat);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(LivePlanetGuidePop this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(LivePlanetGuidePop this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(LivePlanetGuidePop this$0, Ref.FloatRef border1TargetX, Ref.FloatRef border1TargetY, Ref.FloatRef border1TargetW, Ref.FloatRef border1TargetH, Ref.FloatRef border2TargetX, Ref.FloatRef border2TargetY, Ref.FloatRef border2TargetW, Ref.FloatRef border2TargetH, ValueAnimator valueAnimator) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(border1TargetX, "$border1TargetX");
        Intrinsics.e(border1TargetY, "$border1TargetY");
        Intrinsics.e(border1TargetW, "$border1TargetW");
        Intrinsics.e(border1TargetH, "$border1TargetH");
        Intrinsics.e(border2TargetX, "$border2TargetX");
        Intrinsics.e(border2TargetY, "$border2TargetY");
        Intrinsics.e(border2TargetW, "$border2TargetW");
        Intrinsics.e(border2TargetH, "$border2TargetH");
        LivePlanetGuideShadeView livePlanetGuideShadeView = this$0.A;
        LivePlanetGuideShadeView livePlanetGuideShadeView2 = livePlanetGuideShadeView;
        if (livePlanetGuideShadeView == null) {
            Intrinsics.c("lpgc");
            livePlanetGuideShadeView2 = null;
        }
        livePlanetGuideShadeView2.a((int) border1TargetX.a, (int) border1TargetY.a, (int) border1TargetW.a, (int) border1TargetH.a, (int) border2TargetX.a, (int) border2TargetY.a, (int) border2TargetW.a, (int) border2TargetH.a, valueAnimator.getDuration(), valueAnimator.getStartDelay());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(LivePlanetGuidePop this$0, Ref.FloatRef border2CurrentX, Ref.FloatRef border2TargetX, Ref.FloatRef border2CurrentY, Ref.FloatRef border2TargetY, Ref.IntRef border2CurrentW, Ref.FloatRef border2TargetW, Ref.IntRef border2CurrentH, Ref.FloatRef border2TargetH, ValueAnimator animation) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(border2CurrentX, "$border2CurrentX");
        Intrinsics.e(border2TargetX, "$border2TargetX");
        Intrinsics.e(border2CurrentY, "$border2CurrentY");
        Intrinsics.e(border2TargetY, "$border2TargetY");
        Intrinsics.e(border2CurrentW, "$border2CurrentW");
        Intrinsics.e(border2TargetW, "$border2TargetW");
        Intrinsics.e(border2CurrentH, "$border2CurrentH");
        Intrinsics.e(border2TargetH, "$border2TargetH");
        Intrinsics.e(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        if (animatedValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
        float floatValue = ((Float) animatedValue).floatValue();
        View view = this$0.w;
        View view2 = view;
        if (view == null) {
            Intrinsics.c("view_bordwr_2");
            view2 = null;
        }
        view2.setTranslationX(border2CurrentX.a + ((border2TargetX.a - border2CurrentX.a) * floatValue));
        View view3 = this$0.w;
        View view4 = view3;
        if (view3 == null) {
            Intrinsics.c("view_bordwr_2");
            view4 = null;
        }
        view4.setTranslationY(border2CurrentY.a + ((border2TargetY.a - border2CurrentY.a) * floatValue));
        View view5 = this$0.w;
        View view6 = view5;
        if (view5 == null) {
            Intrinsics.c("view_bordwr_2");
            view6 = null;
        }
        view6.setLayoutParams(new FrameLayout.LayoutParams((int) (border2CurrentW.a + ((border2TargetW.a - border2CurrentW.a) * floatValue)), (int) (border2CurrentH.a + ((border2TargetH.a - border2CurrentH.a) * floatValue))));
        View view7 = this$0.w;
        View view8 = view7;
        if (view7 == null) {
            Intrinsics.c("view_bordwr_2");
            view8 = null;
        }
        View view9 = this$0.w;
        if (view9 == null) {
            Intrinsics.c("view_bordwr_2");
            view9 = null;
        }
        view8.setLayoutParams(view9.getLayoutParams());
    }

    private final void d() {
        ImageView imageView = this.k;
        ImageView imageView2 = imageView;
        if (imageView == null) {
            Intrinsics.c("iv_next");
            imageView2 = null;
        }
        imageView2.setClickable(false);
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        View view = this.v;
        View view2 = view;
        if (view == null) {
            Intrinsics.c("view_bordwr_1");
            view2 = null;
        }
        floatRef.a = view2.getTranslationX();
        final Ref.FloatRef floatRef2 = new Ref.FloatRef();
        View view3 = this.v;
        View view4 = view3;
        if (view3 == null) {
            Intrinsics.c("view_bordwr_1");
            view4 = null;
        }
        floatRef2.a = view4.getTranslationY();
        final Ref.IntRef intRef = new Ref.IntRef();
        View view5 = this.v;
        View view6 = view5;
        if (view5 == null) {
            Intrinsics.c("view_bordwr_1");
            view6 = null;
        }
        intRef.a = view6.getWidth();
        final Ref.IntRef intRef2 = new Ref.IntRef();
        View view7 = this.v;
        View view8 = view7;
        if (view7 == null) {
            Intrinsics.c("view_bordwr_1");
            view8 = null;
        }
        intRef2.a = view8.getHeight();
        int a = DensityUtils.a(getContext(), 92.0f);
        final Ref.FloatRef floatRef3 = new Ref.FloatRef();
        View view9 = this.x;
        View view10 = view9;
        if (view9 == null) {
            Intrinsics.c("view_line");
            view10 = null;
        }
        floatRef3.a = view10.getTranslationX();
        final Ref.FloatRef floatRef4 = new Ref.FloatRef();
        View view11 = this.x;
        View view12 = view11;
        if (view11 == null) {
            Intrinsics.c("view_line");
            view12 = null;
        }
        floatRef4.a = view12.getTranslationY() + a;
        final Ref.FloatRef floatRef5 = new Ref.FloatRef();
        floatRef5.a = 1.0f;
        final Ref.FloatRef floatRef6 = new Ref.FloatRef();
        floatRef6.a = 1.0f;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(300L);
        ofFloat.setStartDelay(0L);
        ofFloat.setInterpolator(new DecelerateInterpolator(1.5f));
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.pop.-$$Lambda$LivePlanetGuidePop$dUsio1AVQ_g13uZUIeemhaDB2Do
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                LivePlanetGuidePop.a(LivePlanetGuidePop.this, floatRef, floatRef3, floatRef2, floatRef4, intRef, floatRef5, intRef2, floatRef6, valueAnimator);
            }
        });
        ofFloat.start();
        View view13 = this.v;
        View view14 = view13;
        if (view13 == null) {
            Intrinsics.c("view_bordwr_1");
            view14 = null;
        }
        view14.animate().alpha(0.0f).setDuration(ofFloat.getDuration()).setStartDelay(ofFloat.getStartDelay()).setInterpolator(ofFloat.getInterpolator()).start();
        View view15 = this.x;
        View view16 = view15;
        if (view15 == null) {
            Intrinsics.c("view_line");
            view16 = null;
        }
        view16.animate().alpha(0.0f).setDuration(ofFloat.getDuration()).setStartDelay(ofFloat.getStartDelay()).setInterpolator(ofFloat.getInterpolator()).withEndAction(new Runnable() { // from class: com.blued.android.module.live_china.pop.-$$Lambda$LivePlanetGuidePop$AKy0CbNMXz3zij8HOQfZDIwCaoU
            @Override // java.lang.Runnable
            public final void run() {
                LivePlanetGuidePop.c(LivePlanetGuidePop.this);
            }
        }).start();
        LivePlanetGuideShadeView livePlanetGuideShadeView = this.A;
        if (livePlanetGuideShadeView == null) {
            Intrinsics.c("lpgc");
            livePlanetGuideShadeView = null;
        }
        livePlanetGuideShadeView.a((int) floatRef.a, (int) floatRef2.a, intRef.a, intRef2.a);
        LivePlanetGuideShadeView livePlanetGuideShadeView2 = this.A;
        if (livePlanetGuideShadeView2 == null) {
            Intrinsics.c("lpgc");
            livePlanetGuideShadeView2 = null;
        }
        livePlanetGuideShadeView2.a((int) floatRef3.a, (int) floatRef4.a, (int) floatRef5.a, (int) floatRef6.a, ofFloat.getDuration(), ofFloat.getStartDelay());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(final LivePlanetGuidePop this$0) {
        Intrinsics.e(this$0, "this$0");
        ImageView imageView = this$0.k;
        ImageView imageView2 = imageView;
        if (imageView == null) {
            Intrinsics.c("iv_next");
            imageView2 = null;
        }
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.pop.-$$Lambda$LivePlanetGuidePop$8rdanAgcTwEThoLgrZpjTG3SLSA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LivePlanetGuidePop.d(LivePlanetGuidePop.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(LivePlanetGuidePop this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(LivePlanetGuidePop this$0, Ref.FloatRef border1CurrentX, Ref.FloatRef border1TargetX, Ref.FloatRef border1CurrentY, Ref.FloatRef border1TargetY, Ref.FloatRef border1CurrentW, Ref.FloatRef border1TargetW, Ref.FloatRef border1CurrentH, Ref.FloatRef border1TargetH, ValueAnimator animation) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(border1CurrentX, "$border1CurrentX");
        Intrinsics.e(border1TargetX, "$border1TargetX");
        Intrinsics.e(border1CurrentY, "$border1CurrentY");
        Intrinsics.e(border1TargetY, "$border1TargetY");
        Intrinsics.e(border1CurrentW, "$border1CurrentW");
        Intrinsics.e(border1TargetW, "$border1TargetW");
        Intrinsics.e(border1CurrentH, "$border1CurrentH");
        Intrinsics.e(border1TargetH, "$border1TargetH");
        Intrinsics.e(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        if (animatedValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
        float floatValue = ((Float) animatedValue).floatValue();
        View view = this$0.v;
        View view2 = view;
        if (view == null) {
            Intrinsics.c("view_bordwr_1");
            view2 = null;
        }
        view2.setTranslationX(border1CurrentX.a + ((border1TargetX.a - border1CurrentX.a) * floatValue));
        View view3 = this$0.v;
        View view4 = view3;
        if (view3 == null) {
            Intrinsics.c("view_bordwr_1");
            view4 = null;
        }
        view4.setTranslationY(border1CurrentY.a + ((border1TargetY.a - border1CurrentY.a) * floatValue));
        View view5 = this$0.v;
        View view6 = view5;
        if (view5 == null) {
            Intrinsics.c("view_bordwr_1");
            view6 = null;
        }
        view6.setLayoutParams(new FrameLayout.LayoutParams((int) (border1CurrentW.a + ((border1TargetW.a - border1CurrentW.a) * floatValue)), (int) (border1CurrentH.a + ((border1TargetH.a - border1CurrentH.a) * floatValue))));
        View view7 = this$0.v;
        View view8 = view7;
        if (view7 == null) {
            Intrinsics.c("view_bordwr_1");
            view8 = null;
        }
        View view9 = this$0.v;
        if (view9 == null) {
            Intrinsics.c("view_bordwr_1");
            view9 = null;
        }
        view8.setLayoutParams(view9.getLayoutParams());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(LivePlanetGuidePop this$0, Ref.FloatRef border1CurrentX, Ref.FloatRef border1TargetX, Ref.FloatRef border1CurrentY, Ref.FloatRef border1TargetY, Ref.IntRef border1CurrentW, Ref.FloatRef border1TargetW, Ref.IntRef border1CurrentH, Ref.FloatRef border1TargetH, ValueAnimator animation) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(border1CurrentX, "$border1CurrentX");
        Intrinsics.e(border1TargetX, "$border1TargetX");
        Intrinsics.e(border1CurrentY, "$border1CurrentY");
        Intrinsics.e(border1TargetY, "$border1TargetY");
        Intrinsics.e(border1CurrentW, "$border1CurrentW");
        Intrinsics.e(border1TargetW, "$border1TargetW");
        Intrinsics.e(border1CurrentH, "$border1CurrentH");
        Intrinsics.e(border1TargetH, "$border1TargetH");
        Intrinsics.e(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        if (animatedValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
        float floatValue = ((Float) animatedValue).floatValue();
        View view = this$0.v;
        View view2 = view;
        if (view == null) {
            Intrinsics.c("view_bordwr_1");
            view2 = null;
        }
        view2.setTranslationX(border1CurrentX.a + ((border1TargetX.a - border1CurrentX.a) * floatValue));
        View view3 = this$0.v;
        View view4 = view3;
        if (view3 == null) {
            Intrinsics.c("view_bordwr_1");
            view4 = null;
        }
        view4.setTranslationY(border1CurrentY.a + ((border1TargetY.a - border1CurrentY.a) * floatValue));
        View view5 = this$0.v;
        View view6 = view5;
        if (view5 == null) {
            Intrinsics.c("view_bordwr_1");
            view6 = null;
        }
        view6.setLayoutParams(new FrameLayout.LayoutParams((int) (border1CurrentW.a + ((border1TargetW.a - border1CurrentW.a) * floatValue)), (int) (border1CurrentH.a + ((border1TargetH.a - border1CurrentH.a) * floatValue))));
        View view7 = this$0.v;
        View view8 = view7;
        if (view7 == null) {
            Intrinsics.c("view_bordwr_1");
            view8 = null;
        }
        View view9 = this$0.v;
        if (view9 == null) {
            Intrinsics.c("view_bordwr_1");
            view9 = null;
        }
        view8.setLayoutParams(view9.getLayoutParams());
    }

    private final void e() {
        ImageView imageView = this.k;
        ImageView imageView2 = imageView;
        if (imageView == null) {
            Intrinsics.c("iv_next");
            imageView2 = null;
        }
        imageView2.setClickable(false);
        int[] iArr = new int[2];
        DialogLivePlanetBinding dialogLivePlanetBinding = this.d;
        DialogLivePlanetBinding dialogLivePlanetBinding2 = dialogLivePlanetBinding;
        if (dialogLivePlanetBinding == null) {
            Intrinsics.c("vb");
            dialogLivePlanetBinding2 = null;
        }
        dialogLivePlanetBinding2.u.getLocationOnScreen(iArr);
        iArr[1] = iArr[1] - DensityUtils.a(getContext(), 5.0f);
        DialogLivePlanetBinding dialogLivePlanetBinding3 = this.d;
        DialogLivePlanetBinding dialogLivePlanetBinding4 = dialogLivePlanetBinding3;
        if (dialogLivePlanetBinding3 == null) {
            Intrinsics.c("vb");
            dialogLivePlanetBinding4 = null;
        }
        int width = dialogLivePlanetBinding4.u.getWidth();
        DialogLivePlanetBinding dialogLivePlanetBinding5 = this.d;
        DialogLivePlanetBinding dialogLivePlanetBinding6 = dialogLivePlanetBinding5;
        if (dialogLivePlanetBinding5 == null) {
            Intrinsics.c("vb");
            dialogLivePlanetBinding6 = null;
        }
        int height = dialogLivePlanetBinding6.u.getHeight() - DensityUtils.a(getContext(), 10.0f);
        int[] iArr2 = new int[2];
        DialogLivePlanetBinding dialogLivePlanetBinding7 = this.d;
        DialogLivePlanetBinding dialogLivePlanetBinding8 = dialogLivePlanetBinding7;
        if (dialogLivePlanetBinding7 == null) {
            Intrinsics.c("vb");
            dialogLivePlanetBinding8 = null;
        }
        dialogLivePlanetBinding8.B.getLocationOnScreen(iArr2);
        iArr2[1] = iArr2[1] - DensityUtils.a(getContext(), 5.0f);
        DialogLivePlanetBinding dialogLivePlanetBinding9 = this.d;
        DialogLivePlanetBinding dialogLivePlanetBinding10 = dialogLivePlanetBinding9;
        if (dialogLivePlanetBinding9 == null) {
            Intrinsics.c("vb");
            dialogLivePlanetBinding10 = null;
        }
        int width2 = dialogLivePlanetBinding10.B.getWidth();
        DialogLivePlanetBinding dialogLivePlanetBinding11 = this.d;
        DialogLivePlanetBinding dialogLivePlanetBinding12 = dialogLivePlanetBinding11;
        if (dialogLivePlanetBinding11 == null) {
            Intrinsics.c("vb");
            dialogLivePlanetBinding12 = null;
        }
        int height2 = dialogLivePlanetBinding12.B.getHeight();
        int a = DensityUtils.a(getContext(), 10.0f);
        int a2 = DensityUtils.a(getContext(), 58.0f);
        int a3 = DensityUtils.a(getContext(), 33.0f);
        int i = iArr[0] + a2;
        int i2 = iArr[1] + height + a3;
        ImageView imageView3 = this.h;
        ImageView imageView4 = imageView3;
        if (imageView3 == null) {
            Intrinsics.c("iv_step_2");
            imageView4 = null;
        }
        BluedViewExKt.b(imageView4);
        ImageView imageView5 = this.g;
        ImageView imageView6 = imageView5;
        if (imageView5 == null) {
            Intrinsics.c("iv_step_1");
            imageView6 = null;
        }
        BluedViewExKt.a(imageView6);
        FrameLayout frameLayout = this.f;
        FrameLayout frameLayout2 = frameLayout;
        if (frameLayout == null) {
            Intrinsics.c("fl_step_root");
            frameLayout2 = null;
        }
        frameLayout2.animate().translationX(i).translationY(i2).setDuration(350L).start();
        int a4 = DensityUtils.a(getContext(), 47.0f);
        int a5 = DensityUtils.a(getContext(), 81.0f);
        int a6 = DensityUtils.a(getContext(), 14.0f);
        int a7 = DensityUtils.a(getContext(), 205.0f);
        int a8 = DensityUtils.a(getContext(), 30.0f);
        ImageView imageView7 = this.k;
        ImageView imageView8 = imageView7;
        if (imageView7 == null) {
            Intrinsics.c("iv_next");
            imageView8 = null;
        }
        ViewPropertyAnimator translationX = imageView8.animate().translationX(a4 + i);
        int i3 = a5 + i2;
        translationX.translationY(i3 + a6).setDuration(350L).start();
        ImageView imageView9 = this.t;
        ImageView imageView10 = imageView9;
        if (imageView9 == null) {
            Intrinsics.c("iv_close");
            imageView10 = null;
        }
        imageView10.animate().translationX((a7 + i) - a8).translationY((i2 - a6) - a8).setDuration(350L).start();
        int a9 = DensityUtils.a(getContext(), 3.0f);
        int a10 = DensityUtils.a(getContext(), 18.0f);
        int a11 = DensityUtils.a(getContext(), 36.9999f);
        View view = this.x;
        View view2 = view;
        if (view == null) {
            Intrinsics.c("view_line");
            view2 = null;
        }
        view2.setAlpha(0.0f);
        View view3 = this.x;
        View view4 = view3;
        if (view3 == null) {
            Intrinsics.c("view_line");
            view4 = null;
        }
        view4.setTranslationX(a10 + i);
        View view5 = this.x;
        View view6 = view5;
        if (view5 == null) {
            Intrinsics.c("view_line");
            view6 = null;
        }
        view6.setTranslationY(iArr[1] + height);
        View view7 = this.x;
        View view8 = view7;
        if (view7 == null) {
            Intrinsics.c("view_line");
            view8 = null;
        }
        view8.setLayoutParams(new FrameLayout.LayoutParams(a9, a11));
        int a12 = DensityUtils.a(getContext(), 169.0f);
        int a13 = DensityUtils.a(getContext(), 29.0f);
        int a14 = DensityUtils.a(getContext(), 21.5f);
        View view9 = this.y;
        View view10 = view9;
        if (view9 == null) {
            Intrinsics.c("view_broken_line_vertical");
            view10 = null;
        }
        view10.setAlpha(0.0f);
        View view11 = this.y;
        View view12 = view11;
        if (view11 == null) {
            Intrinsics.c("view_broken_line_vertical");
            view12 = null;
        }
        float f = i + a12;
        view12.setTranslationX(f);
        View view13 = this.y;
        View view14 = view13;
        if (view13 == null) {
            Intrinsics.c("view_broken_line_vertical");
            view14 = null;
        }
        view14.setTranslationY(i3 - a9);
        View view15 = this.y;
        View view16 = view15;
        if (view15 == null) {
            Intrinsics.c("view_broken_line_vertical");
            view16 = null;
        }
        view16.setLayoutParams(new FrameLayout.LayoutParams(a9, a13));
        View view17 = this.z;
        View view18 = view17;
        if (view17 == null) {
            Intrinsics.c("view_broken_line_horizontal");
            view18 = null;
        }
        view18.setAlpha(0.0f);
        View view19 = this.z;
        View view20 = view19;
        if (view19 == null) {
            Intrinsics.c("view_broken_line_horizontal");
            view20 = null;
        }
        view20.setTranslationX(f);
        View view21 = this.z;
        View view22 = view21;
        if (view21 == null) {
            Intrinsics.c("view_broken_line_horizontal");
            view22 = null;
        }
        View view23 = this.y;
        View view24 = view23;
        if (view23 == null) {
            Intrinsics.c("view_broken_line_vertical");
            view24 = null;
        }
        view22.setTranslationY(view24.getTranslationY() + a13);
        View view25 = this.z;
        View view26 = view25;
        if (view25 == null) {
            Intrinsics.c("view_broken_line_horizontal");
            view26 = null;
        }
        view26.setLayoutParams(new FrameLayout.LayoutParams(a14, a9));
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        View view27 = this.x;
        View view28 = view27;
        if (view27 == null) {
            Intrinsics.c("view_line");
            view28 = null;
        }
        floatRef.a = view28.getTranslationX();
        final Ref.FloatRef floatRef2 = new Ref.FloatRef();
        View view29 = this.x;
        View view30 = view29;
        if (view29 == null) {
            Intrinsics.c("view_line");
            view30 = null;
        }
        floatRef2.a = view30.getTranslationY();
        final Ref.FloatRef floatRef3 = new Ref.FloatRef();
        floatRef3.a = 1.0f;
        final Ref.FloatRef floatRef4 = new Ref.FloatRef();
        floatRef4.a = 1.0f;
        final Ref.FloatRef floatRef5 = new Ref.FloatRef();
        floatRef5.a = iArr[0];
        final Ref.FloatRef floatRef6 = new Ref.FloatRef();
        floatRef6.a = iArr[1];
        final Ref.FloatRef floatRef7 = new Ref.FloatRef();
        floatRef7.a = width;
        final Ref.FloatRef floatRef8 = new Ref.FloatRef();
        floatRef8.a = height;
        View view31 = this.v;
        View view32 = view31;
        if (view31 == null) {
            Intrinsics.c("view_bordwr_1");
            view32 = null;
        }
        view32.setAlpha(0.0f);
        final ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(500L);
        ofFloat.setStartDelay(200L);
        ofFloat.setInterpolator(new DecelerateInterpolator(1.5f));
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.pop.-$$Lambda$LivePlanetGuidePop$66DUSKmLJYtXw2M9_ti1U-lGAks
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                LivePlanetGuidePop.a(LivePlanetGuidePop.this, floatRef, floatRef5, floatRef2, floatRef6, floatRef3, floatRef7, floatRef4, floatRef8, valueAnimator);
            }
        });
        ofFloat.start();
        final Ref.FloatRef floatRef9 = new Ref.FloatRef();
        View view33 = this.z;
        View view34 = view33;
        if (view33 == null) {
            Intrinsics.c("view_broken_line_horizontal");
            view34 = null;
        }
        floatRef9.a = view34.getTranslationX() + a14;
        final Ref.FloatRef floatRef10 = new Ref.FloatRef();
        View view35 = this.z;
        View view36 = view35;
        if (view35 == null) {
            Intrinsics.c("view_broken_line_horizontal");
            view36 = null;
        }
        floatRef10.a = view36.getTranslationY();
        final Ref.FloatRef floatRef11 = new Ref.FloatRef();
        floatRef11.a = 1.0f;
        final Ref.FloatRef floatRef12 = new Ref.FloatRef();
        floatRef12.a = 1.0f;
        final Ref.FloatRef floatRef13 = new Ref.FloatRef();
        floatRef13.a = iArr2[0];
        final Ref.FloatRef floatRef14 = new Ref.FloatRef();
        floatRef14.a = iArr2[1];
        final Ref.FloatRef floatRef15 = new Ref.FloatRef();
        floatRef15.a = width2;
        final Ref.FloatRef floatRef16 = new Ref.FloatRef();
        floatRef16.a = height2 - a;
        View view37 = this.w;
        View view38 = view37;
        if (view37 == null) {
            Intrinsics.c("view_bordwr_2");
            view38 = null;
        }
        view38.setAlpha(0.0f);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat2.setDuration(500L);
        ofFloat2.setStartDelay(200L);
        ofFloat2.setInterpolator(new DecelerateInterpolator(1.5f));
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.pop.-$$Lambda$LivePlanetGuidePop$drgqi_1MEts9Fe2Rl7Wc-sYu7Qw
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                LivePlanetGuidePop.b(LivePlanetGuidePop.this, floatRef9, floatRef13, floatRef10, floatRef14, floatRef11, floatRef15, floatRef12, floatRef16, valueAnimator);
            }
        });
        ofFloat2.start();
        View view39 = this.x;
        View view40 = view39;
        if (view39 == null) {
            Intrinsics.c("view_line");
            view40 = null;
        }
        view40.animate().alpha(1.0f).setDuration(ofFloat.getDuration()).setStartDelay(ofFloat.getStartDelay()).setInterpolator(ofFloat.getInterpolator()).start();
        View view41 = this.y;
        View view42 = view41;
        if (view41 == null) {
            Intrinsics.c("view_broken_line_vertical");
            view42 = null;
        }
        view42.animate().alpha(1.0f).setDuration(ofFloat.getDuration()).setStartDelay(ofFloat.getStartDelay()).setInterpolator(ofFloat.getInterpolator()).start();
        View view43 = this.z;
        View view44 = view43;
        if (view43 == null) {
            Intrinsics.c("view_broken_line_horizontal");
            view44 = null;
        }
        view44.animate().alpha(1.0f).setDuration(ofFloat.getDuration()).setStartDelay(ofFloat.getStartDelay()).setInterpolator(ofFloat.getInterpolator()).start();
        View view45 = this.v;
        View view46 = view45;
        if (view45 == null) {
            Intrinsics.c("view_bordwr_1");
            view46 = null;
        }
        view46.animate().alpha(1.0f).setDuration(ofFloat.getDuration()).setStartDelay(ofFloat.getStartDelay()).setInterpolator(ofFloat.getInterpolator()).withEndAction(new Runnable() { // from class: com.blued.android.module.live_china.pop.-$$Lambda$LivePlanetGuidePop$ZumwZ9bGjAJe4eAJiKB3dR_lF6M
            @Override // java.lang.Runnable
            public final void run() {
                LivePlanetGuidePop.d(LivePlanetGuidePop.this);
            }
        }).start();
        View view47 = this.w;
        View view48 = view47;
        if (view47 == null) {
            Intrinsics.c("view_bordwr_2");
            view48 = null;
        }
        view48.animate().alpha(1.0f).setDuration(ofFloat.getDuration()).setStartDelay(ofFloat.getStartDelay()).setInterpolator(ofFloat.getInterpolator()).start();
        LivePlanetGuideShadeView livePlanetGuideShadeView = this.A;
        if (livePlanetGuideShadeView == null) {
            Intrinsics.c("lpgc");
            livePlanetGuideShadeView = null;
        }
        livePlanetGuideShadeView.a((int) floatRef.a, (int) floatRef2.a, (int) floatRef3.a, (int) floatRef4.a);
        LivePlanetGuideShadeView livePlanetGuideShadeView2 = this.A;
        if (livePlanetGuideShadeView2 == null) {
            Intrinsics.c("lpgc");
            livePlanetGuideShadeView2 = null;
        }
        livePlanetGuideShadeView2.b((int) floatRef9.a, (int) floatRef10.a, (int) floatRef11.a, (int) floatRef12.a);
        LivePlanetGuideShadeView livePlanetGuideShadeView3 = this.A;
        if (livePlanetGuideShadeView3 == null) {
            Intrinsics.c("lpgc");
            livePlanetGuideShadeView3 = null;
        }
        livePlanetGuideShadeView3.post(new Runnable() { // from class: com.blued.android.module.live_china.pop.-$$Lambda$LivePlanetGuidePop$OfgqdbCNAwAlvCPeEMAlvMH9VYU
            @Override // java.lang.Runnable
            public final void run() {
                LivePlanetGuidePop.c(LivePlanetGuidePop.this, floatRef5, floatRef6, floatRef7, floatRef8, floatRef13, floatRef14, floatRef15, floatRef16, ofFloat);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(LivePlanetGuidePop this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(LivePlanetGuidePop this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(LivePlanetGuidePop this$0, Ref.FloatRef border1CurrentX, Ref.FloatRef border1TargetX, Ref.FloatRef border1CurrentY, Ref.FloatRef border1TargetY, Ref.FloatRef border1CurrentW, Ref.FloatRef border1TargetW, Ref.FloatRef border1CurrentH, Ref.FloatRef border1TargetH, ValueAnimator animation) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(border1CurrentX, "$border1CurrentX");
        Intrinsics.e(border1TargetX, "$border1TargetX");
        Intrinsics.e(border1CurrentY, "$border1CurrentY");
        Intrinsics.e(border1TargetY, "$border1TargetY");
        Intrinsics.e(border1CurrentW, "$border1CurrentW");
        Intrinsics.e(border1TargetW, "$border1TargetW");
        Intrinsics.e(border1CurrentH, "$border1CurrentH");
        Intrinsics.e(border1TargetH, "$border1TargetH");
        Intrinsics.e(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        if (animatedValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
        float floatValue = ((Float) animatedValue).floatValue();
        View view = this$0.v;
        View view2 = view;
        if (view == null) {
            Intrinsics.c("view_bordwr_1");
            view2 = null;
        }
        view2.setTranslationX(border1CurrentX.a + ((border1TargetX.a - border1CurrentX.a) * floatValue));
        View view3 = this$0.v;
        View view4 = view3;
        if (view3 == null) {
            Intrinsics.c("view_bordwr_1");
            view4 = null;
        }
        view4.setTranslationY(border1CurrentY.a + ((border1TargetY.a - border1CurrentY.a) * floatValue));
        View view5 = this$0.v;
        View view6 = view5;
        if (view5 == null) {
            Intrinsics.c("view_bordwr_1");
            view6 = null;
        }
        view6.setLayoutParams(new FrameLayout.LayoutParams((int) (border1CurrentW.a + ((border1TargetW.a - border1CurrentW.a) * floatValue)), (int) (border1CurrentH.a + ((border1TargetH.a - border1CurrentH.a) * floatValue))));
        View view7 = this$0.v;
        View view8 = view7;
        if (view7 == null) {
            Intrinsics.c("view_bordwr_1");
            view8 = null;
        }
        View view9 = this$0.v;
        if (view9 == null) {
            Intrinsics.c("view_bordwr_1");
            view9 = null;
        }
        view8.setLayoutParams(view9.getLayoutParams());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(final LivePlanetGuidePop this$0) {
        Intrinsics.e(this$0, "this$0");
        ImageView imageView = this$0.k;
        ImageView imageView2 = imageView;
        if (imageView == null) {
            Intrinsics.c("iv_next");
            imageView2 = null;
        }
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.pop.-$$Lambda$LivePlanetGuidePop$04t08S5El3M--xkOAS3vgsUplgU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LivePlanetGuidePop.e(LivePlanetGuidePop.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(LivePlanetGuidePop this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(LivePlanetGuidePop this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(LivePlanetGuidePop this$0) {
        Intrinsics.e(this$0, "this$0");
        ImageView imageView = this$0.t;
        ImageView imageView2 = imageView;
        if (imageView == null) {
            Intrinsics.c("iv_close");
            imageView2 = null;
        }
        BluedViewExKt.a(imageView2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(LivePlanetGuidePop this$0) {
        Intrinsics.e(this$0, "this$0");
        ImageView imageView = this$0.k;
        ImageView imageView2 = imageView;
        if (imageView == null) {
            Intrinsics.c("iv_next");
            imageView2 = null;
        }
        BluedViewExKt.a(imageView2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(final LivePlanetGuidePop this$0) {
        Intrinsics.e(this$0, "this$0");
        ImageView imageView = this$0.k;
        ImageView imageView2 = imageView;
        if (imageView == null) {
            Intrinsics.c("iv_next");
            imageView2 = null;
        }
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.pop.-$$Lambda$LivePlanetGuidePop$HgU3YyfJ0txCRtFNET0XFcV4gmg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LivePlanetGuidePop.f(LivePlanetGuidePop.this, view);
            }
        });
    }

    private final void z() {
        ImageView imageView = this.k;
        ImageView imageView2 = imageView;
        if (imageView == null) {
            Intrinsics.c("iv_next");
            imageView2 = null;
        }
        imageView2.setClickable(false);
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        View view = this.v;
        View view2 = view;
        if (view == null) {
            Intrinsics.c("view_bordwr_1");
            view2 = null;
        }
        floatRef.a = view2.getTranslationX();
        final Ref.FloatRef floatRef2 = new Ref.FloatRef();
        View view3 = this.v;
        View view4 = view3;
        if (view3 == null) {
            Intrinsics.c("view_bordwr_1");
            view4 = null;
        }
        floatRef2.a = view4.getTranslationY();
        final Ref.IntRef intRef = new Ref.IntRef();
        View view5 = this.v;
        View view6 = view5;
        if (view5 == null) {
            Intrinsics.c("view_bordwr_1");
            view6 = null;
        }
        intRef.a = view6.getWidth();
        final Ref.IntRef intRef2 = new Ref.IntRef();
        View view7 = this.v;
        View view8 = view7;
        if (view7 == null) {
            Intrinsics.c("view_bordwr_1");
            view8 = null;
        }
        intRef2.a = view8.getHeight();
        final Ref.FloatRef floatRef3 = new Ref.FloatRef();
        View view9 = this.x;
        View view10 = view9;
        if (view9 == null) {
            Intrinsics.c("view_line");
            view10 = null;
        }
        floatRef3.a = view10.getTranslationX();
        final Ref.FloatRef floatRef4 = new Ref.FloatRef();
        View view11 = this.x;
        View view12 = view11;
        if (view11 == null) {
            Intrinsics.c("view_line");
            view12 = null;
        }
        floatRef4.a = view12.getTranslationY();
        final Ref.FloatRef floatRef5 = new Ref.FloatRef();
        floatRef5.a = 1.0f;
        final Ref.FloatRef floatRef6 = new Ref.FloatRef();
        floatRef6.a = 1.0f;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(300L);
        ofFloat.setStartDelay(0L);
        ofFloat.setInterpolator(new DecelerateInterpolator(1.5f));
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.pop.-$$Lambda$LivePlanetGuidePop$8KpV8KpO44lSJxyS46bzWZji1nM
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                LivePlanetGuidePop.b(LivePlanetGuidePop.this, floatRef, floatRef3, floatRef2, floatRef4, intRef, floatRef5, intRef2, floatRef6, valueAnimator);
            }
        });
        ofFloat.start();
        View view13 = this.v;
        View view14 = view13;
        if (view13 == null) {
            Intrinsics.c("view_bordwr_1");
            view14 = null;
        }
        view14.animate().alpha(0.0f).setDuration(ofFloat.getDuration()).setStartDelay(ofFloat.getStartDelay()).setInterpolator(ofFloat.getInterpolator()).start();
        View view15 = this.x;
        View view16 = view15;
        if (view15 == null) {
            Intrinsics.c("view_line");
            view16 = null;
        }
        view16.animate().alpha(0.0f).setDuration(ofFloat.getDuration()).setStartDelay(ofFloat.getStartDelay()).setInterpolator(ofFloat.getInterpolator()).withEndAction(new Runnable() { // from class: com.blued.android.module.live_china.pop.-$$Lambda$LivePlanetGuidePop$3Uwl6cy0uQD12SqFsNwAn9bHJ4w
            @Override // java.lang.Runnable
            public final void run() {
                LivePlanetGuidePop.e(LivePlanetGuidePop.this);
            }
        }).start();
        final Ref.FloatRef floatRef7 = new Ref.FloatRef();
        View view17 = this.w;
        View view18 = view17;
        if (view17 == null) {
            Intrinsics.c("view_bordwr_2");
            view18 = null;
        }
        floatRef7.a = view18.getTranslationX();
        final Ref.FloatRef floatRef8 = new Ref.FloatRef();
        View view19 = this.w;
        View view20 = view19;
        if (view19 == null) {
            Intrinsics.c("view_bordwr_2");
            view20 = null;
        }
        floatRef8.a = view20.getTranslationY();
        final Ref.IntRef intRef3 = new Ref.IntRef();
        View view21 = this.w;
        View view22 = view21;
        if (view21 == null) {
            Intrinsics.c("view_bordwr_2");
            view22 = null;
        }
        intRef3.a = view22.getWidth();
        final Ref.IntRef intRef4 = new Ref.IntRef();
        View view23 = this.w;
        View view24 = view23;
        if (view23 == null) {
            Intrinsics.c("view_bordwr_2");
            view24 = null;
        }
        intRef4.a = view24.getHeight();
        final Ref.FloatRef floatRef9 = new Ref.FloatRef();
        View view25 = this.z;
        View view26 = view25;
        if (view25 == null) {
            Intrinsics.c("view_broken_line_horizontal");
            view26 = null;
        }
        float translationX = view26.getTranslationX();
        View view27 = this.z;
        View view28 = view27;
        if (view27 == null) {
            Intrinsics.c("view_broken_line_horizontal");
            view28 = null;
        }
        floatRef9.a = translationX + view28.getWidth();
        final Ref.FloatRef floatRef10 = new Ref.FloatRef();
        View view29 = this.z;
        View view30 = view29;
        if (view29 == null) {
            Intrinsics.c("view_broken_line_horizontal");
            view30 = null;
        }
        floatRef10.a = view30.getTranslationY();
        final Ref.FloatRef floatRef11 = new Ref.FloatRef();
        floatRef11.a = 1.0f;
        final Ref.FloatRef floatRef12 = new Ref.FloatRef();
        floatRef12.a = 1.0f;
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat2.setDuration(ofFloat.getDuration());
        ofFloat2.setStartDelay(ofFloat.getStartDelay());
        ofFloat2.setInterpolator(ofFloat.getInterpolator());
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.pop.-$$Lambda$LivePlanetGuidePop$qe6hJhFc8wbgKPlwU7Q1YOEt-Bg
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                LivePlanetGuidePop.c(LivePlanetGuidePop.this, floatRef7, floatRef9, floatRef8, floatRef10, intRef3, floatRef11, intRef4, floatRef12, valueAnimator);
            }
        });
        ofFloat2.start();
        View view31 = this.w;
        View view32 = view31;
        if (view31 == null) {
            Intrinsics.c("view_bordwr_2");
            view32 = null;
        }
        view32.animate().alpha(0.0f).setDuration(ofFloat2.getDuration()).setStartDelay(ofFloat2.getStartDelay()).setInterpolator(ofFloat2.getInterpolator()).start();
        View view33 = this.y;
        View view34 = view33;
        if (view33 == null) {
            Intrinsics.c("view_broken_line_vertical");
            view34 = null;
        }
        view34.animate().alpha(0.0f).setDuration(ofFloat2.getDuration()).setStartDelay(ofFloat2.getStartDelay()).setInterpolator(ofFloat2.getInterpolator()).start();
        View view35 = this.z;
        View view36 = view35;
        if (view35 == null) {
            Intrinsics.c("view_broken_line_horizontal");
            view36 = null;
        }
        view36.animate().alpha(0.0f).setDuration(ofFloat2.getDuration()).setStartDelay(ofFloat2.getStartDelay()).setInterpolator(ofFloat2.getInterpolator()).start();
        LivePlanetGuideShadeView livePlanetGuideShadeView = this.A;
        if (livePlanetGuideShadeView == null) {
            Intrinsics.c("lpgc");
            livePlanetGuideShadeView = null;
        }
        livePlanetGuideShadeView.a((int) floatRef.a, (int) floatRef2.a, intRef.a, intRef2.a);
        LivePlanetGuideShadeView livePlanetGuideShadeView2 = this.A;
        LivePlanetGuideShadeView livePlanetGuideShadeView3 = livePlanetGuideShadeView2;
        if (livePlanetGuideShadeView2 == null) {
            Intrinsics.c("lpgc");
            livePlanetGuideShadeView3 = null;
        }
        livePlanetGuideShadeView3.b((int) floatRef7.a, (int) floatRef8.a, intRef3.a, intRef4.a);
        LivePlanetGuideShadeView livePlanetGuideShadeView4 = this.A;
        if (livePlanetGuideShadeView4 == null) {
            Intrinsics.c("lpgc");
            livePlanetGuideShadeView4 = null;
        }
        livePlanetGuideShadeView4.a((int) floatRef3.a, (int) floatRef4.a, (int) floatRef5.a, (int) floatRef6.a, (int) floatRef9.a, (int) floatRef10.a, (int) floatRef11.a, (int) floatRef12.a, ofFloat.getDuration(), ofFloat.getStartDelay());
    }

    public final void a(DialogLivePlanetBinding viewBinding) {
        Intrinsics.e(viewBinding, "viewBinding");
        this.d = viewBinding;
        new XPopup.Builder(getContext()).a(PopupAnimation.NoAnimation).d((Boolean) false).a((BasePopupView) this).h();
    }

    @Override // com.blued.android.framework.ui.xpop.core.CenterPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public void b() {
        super.b();
        if (this.d == null) {
            Intrinsics.c("vb");
        }
        View findViewById = findViewById(R.id.fl_root);
        Intrinsics.c(findViewById, "findViewById(R.id.fl_root)");
        this.e = (FrameLayout) findViewById;
        View findViewById2 = findViewById(R.id.fl_step_root);
        Intrinsics.c(findViewById2, "findViewById(R.id.fl_step_root)");
        this.f = (FrameLayout) findViewById2;
        View findViewById3 = findViewById(R.id.iv_step_1);
        Intrinsics.c(findViewById3, "findViewById(R.id.iv_step_1)");
        this.g = (ImageView) findViewById3;
        View findViewById4 = findViewById(R.id.iv_step_2);
        Intrinsics.c(findViewById4, "findViewById(R.id.iv_step_2)");
        this.h = (ImageView) findViewById4;
        View findViewById5 = findViewById(R.id.iv_step_3);
        Intrinsics.c(findViewById5, "findViewById(R.id.iv_step_3)");
        this.i = (ImageView) findViewById5;
        View findViewById6 = findViewById(R.id.iv_step_4);
        Intrinsics.c(findViewById6, "findViewById(R.id.iv_step_4)");
        this.j = (ImageView) findViewById6;
        View findViewById7 = findViewById(R.id.iv_next);
        Intrinsics.c(findViewById7, "findViewById(R.id.iv_next)");
        this.k = (ImageView) findViewById7;
        View findViewById8 = findViewById(R.id.iv_close);
        Intrinsics.c(findViewById8, "findViewById(R.id.iv_close)");
        this.t = (ImageView) findViewById8;
        View findViewById9 = findViewById(R.id.iv_start_planet);
        Intrinsics.c(findViewById9, "findViewById(R.id.iv_start_planet)");
        this.u = (ImageView) findViewById9;
        View findViewById10 = findViewById(R.id.view_bordwr_1);
        Intrinsics.c(findViewById10, "findViewById(R.id.view_bordwr_1)");
        this.v = findViewById10;
        View findViewById11 = findViewById(R.id.view_bordwr_2);
        Intrinsics.c(findViewById11, "findViewById(R.id.view_bordwr_2)");
        this.w = findViewById11;
        View findViewById12 = findViewById(R.id.view_line);
        Intrinsics.c(findViewById12, "findViewById(R.id.view_line)");
        this.x = findViewById12;
        View findViewById13 = findViewById(R.id.view_broken_line_vertical);
        Intrinsics.c(findViewById13, "findViewById(R.id.view_broken_line_vertical)");
        this.y = findViewById13;
        View findViewById14 = findViewById(R.id.view_broken_line_horizontal);
        Intrinsics.c(findViewById14, "findViewById(R.id.view_broken_line_horizontal)");
        this.z = findViewById14;
        Context context = getContext();
        Intrinsics.c(context, "context");
        LivePlanetGuideShadeView livePlanetGuideShadeView = new LivePlanetGuideShadeView(context);
        this.A = livePlanetGuideShadeView;
        LivePlanetGuideShadeView livePlanetGuideShadeView2 = livePlanetGuideShadeView;
        if (livePlanetGuideShadeView == null) {
            Intrinsics.c("lpgc");
            livePlanetGuideShadeView2 = null;
        }
        livePlanetGuideShadeView2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout = this.e;
        FrameLayout frameLayout2 = frameLayout;
        if (frameLayout == null) {
            Intrinsics.c("fl_root");
            frameLayout2 = null;
        }
        LivePlanetGuideShadeView livePlanetGuideShadeView3 = this.A;
        LivePlanetGuideShadeView livePlanetGuideShadeView4 = livePlanetGuideShadeView3;
        if (livePlanetGuideShadeView3 == null) {
            Intrinsics.c("lpgc");
            livePlanetGuideShadeView4 = null;
        }
        frameLayout2.addView(livePlanetGuideShadeView4, 0);
        FrameLayout frameLayout3 = this.e;
        FrameLayout frameLayout4 = frameLayout3;
        if (frameLayout3 == null) {
            Intrinsics.c("fl_root");
            frameLayout4 = null;
        }
        frameLayout4.post(new Runnable() { // from class: com.blued.android.module.live_china.pop.-$$Lambda$LivePlanetGuidePop$wkE5aj835LDxtsyLvJ4liTqCHFA
            @Override // java.lang.Runnable
            public final void run() {
                LivePlanetGuidePop.a(LivePlanetGuidePop.this);
            }
        });
        ImageView imageView = this.t;
        ImageView imageView2 = imageView;
        if (imageView == null) {
            Intrinsics.c("iv_close");
            imageView2 = null;
        }
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.pop.-$$Lambda$LivePlanetGuidePop$VY-23NmnhBlvDW16eSx-atpqS5A
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LivePlanetGuidePop.a(LivePlanetGuidePop.this, view);
            }
        });
        ImageView imageView3 = this.u;
        if (imageView3 == null) {
            Intrinsics.c("iv_start_planet");
            imageView3 = null;
        }
        imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.pop.-$$Lambda$LivePlanetGuidePop$Cas0zxQNBx94sdq3ykfo5pZ_kc0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LivePlanetGuidePop.b(LivePlanetGuidePop.this, view);
            }
        });
    }

    public final FragmentActivity getActivity() {
        return this.c;
    }

    @Override // com.blued.android.framework.ui.xpop.core.CenterPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getImplLayoutId() {
        return R.layout.pop_planet_guide;
    }

    @Override // com.blued.android.framework.ui.xpop.core.CenterPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getMaxWidth() {
        return this.c.getWindowManager().getDefaultDisplay().getWidth();
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public void p() {
        LiveEventBusUtil.j();
        super.p();
    }

    public final void setActivity(FragmentActivity fragmentActivity) {
        Intrinsics.e(fragmentActivity, "<set-?>");
        this.c = fragmentActivity;
    }
}
