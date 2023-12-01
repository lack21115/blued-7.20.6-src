package com.blued.android.module.live_china.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.CountDownTimer;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.live_china.model.LiveBunchLightViewModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveBunchLightView.class */
public final class LiveBunchLightView extends FrameLayout {
    private int a;
    private int b;
    private int c;
    private final ArrayList<LiveBunchLightViewModel> d;
    private final ArrayList<LiveBunchLightViewModel> e;
    private final ArrayList<LiveBunchLightViewModel> f;
    private final ArrayList<LiveBunchLightViewModel> g;
    private int h;
    private final int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private long o;
    private long p;
    private long q;
    private CountDownTimer r;
    private final LinearInterpolator s;
    private final DecelerateInterpolator t;
    private final AccelerateInterpolator u;
    private ArrayList<String> v;
    private int w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveBunchLightView(Context context) {
        super(context);
        Intrinsics.e(context, "context");
        this.c = DisplayUtil.a(AppInfo.d(), 6.0f);
        this.d = new ArrayList<>();
        this.e = new ArrayList<>();
        this.f = new ArrayList<>();
        this.g = new ArrayList<>();
        this.h = DisplayUtil.a(AppInfo.d(), 32.0f);
        int a = DisplayUtil.a(AppInfo.d(), 10.0f);
        this.i = a;
        this.j = a;
        this.k = a;
        this.l = a;
        this.o = 500L;
        long j = (long) (500 * 0.25d);
        this.p = j;
        this.q = (j * 4) + 500;
        this.s = new LinearInterpolator();
        this.t = new DecelerateInterpolator(0.8f);
        this.u = new AccelerateInterpolator(0.8f);
        this.v = new ArrayList<>();
        this.w = -1;
    }

    private final void a() {
        int i = this.a;
        if (i < this.b) {
            int i2 = this.c;
            int i3 = this.j;
            int i4 = ((i - (i2 * 2)) - i3) / (this.h + i3);
            this.m = i4;
            if (i4 % 2 == 0) {
                this.m = i4 - 1;
            }
            int i5 = this.a;
            int i6 = this.c;
            int i7 = this.h;
            int i8 = this.m;
            int i9 = ((i5 - (i6 * 2)) - (i7 * i8)) / (i8 - 1);
            this.k = i9;
            int i10 = this.b;
            int i11 = (((i10 - (i6 * 2)) - (i7 * 2)) - i9) / (i9 + i7);
            this.n = i11;
            this.l = (((i10 - (i6 * 2)) - (i7 * 2)) - (i7 * i11)) / (i11 + 1);
            return;
        }
        int i12 = this.c;
        int i13 = this.j;
        int i14 = ((i - (i12 * 2)) - i13) / (this.h + i13);
        this.m = i14;
        if (i14 % 2 == 0) {
            this.m = i14 - 1;
        }
        int i15 = this.a;
        int i16 = this.c;
        int i17 = this.h;
        int i18 = this.m;
        int i19 = ((i15 - (i16 * 2)) - (i17 * i18)) / (i18 - 1);
        this.k = i19;
        int i20 = this.b;
        int i21 = (((i20 - (i16 * 2)) - (i17 * 2)) - i19) / (i19 + i17);
        this.n = i21;
        this.l = (((i20 - (i16 * 2)) - (i17 * 2)) - (i17 * i21)) / (i21 + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final LiveBunchLightViewModel it, final LiveBunchLightView this$0) {
        ViewPropertyAnimator animate;
        ViewPropertyAnimator alpha;
        ViewPropertyAnimator scaleX;
        ViewPropertyAnimator scaleY;
        ViewPropertyAnimator duration;
        ViewPropertyAnimator startDelay;
        ViewPropertyAnimator interpolator;
        ViewPropertyAnimator listener;
        ViewPropertyAnimator animate2;
        Intrinsics.e(it, "$it");
        Intrinsics.e(this$0, "this$0");
        ImageView view = it.getView();
        if (view != null && (animate2 = view.animate()) != null) {
            animate2.cancel();
        }
        ImageView view2 = it.getView();
        if (view2 != null) {
            view2.setAlpha(0.0f);
        }
        ImageView view3 = it.getView();
        if (view3 != null) {
            view3.setScaleX(0.85f);
        }
        ImageView view4 = it.getView();
        if (view4 != null) {
            view4.setScaleY(0.85f);
        }
        ImageView view5 = it.getView();
        if (view5 == null || (animate = view5.animate()) == null || (alpha = animate.alpha(1.0f)) == null || (scaleX = alpha.scaleX(1.0f)) == null || (scaleY = scaleX.scaleY(1.0f)) == null || (duration = scaleY.setDuration(this$0.o)) == null || (startDelay = duration.setStartDelay(this$0.p * it.getDelay())) == null || (interpolator = startDelay.setInterpolator(this$0.t)) == null || (listener = interpolator.setListener(new AnimatorListenerAdapter() { // from class: com.blued.android.module.live_china.view.LiveBunchLightView$startPlayLightList$1$1$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                ViewPropertyAnimator animate3;
                ViewPropertyAnimator alpha2;
                ViewPropertyAnimator scaleX2;
                ViewPropertyAnimator scaleY2;
                long j;
                ViewPropertyAnimator startDelay2;
                DecelerateInterpolator decelerateInterpolator;
                ViewPropertyAnimator listener2;
                Intrinsics.e(animation, "animation");
                super.onAnimationEnd(animation);
                ImageView view6 = LiveBunchLightViewModel.this.getView();
                if (view6 == null || (animate3 = view6.animate()) == null || (alpha2 = animate3.alpha(0.0f)) == null || (scaleX2 = alpha2.scaleX(0.85f)) == null || (scaleY2 = scaleX2.scaleY(0.85f)) == null) {
                    return;
                }
                j = this$0.o;
                ViewPropertyAnimator duration2 = scaleY2.setDuration(j);
                if (duration2 == null || (startDelay2 = duration2.setStartDelay(0L)) == null) {
                    return;
                }
                decelerateInterpolator = this$0.t;
                ViewPropertyAnimator interpolator2 = startDelay2.setInterpolator(decelerateInterpolator);
                if (interpolator2 == null || (listener2 = interpolator2.setListener(null)) == null) {
                    return;
                }
                listener2.start();
            }
        })) == null) {
            return;
        }
        listener.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(List<LiveBunchLightViewModel> list) {
        for (final LiveBunchLightViewModel liveBunchLightViewModel : list) {
            ImageView view = liveBunchLightViewModel.getView();
            if (view != null) {
                view.post(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveBunchLightView$Lbu_jPvkr4uwrJay8I3oD_2cvL8
                    @Override // java.lang.Runnable
                    public final void run() {
                        LiveBunchLightView.a(LiveBunchLightViewModel.this, this);
                    }
                });
            }
        }
    }

    private final void b() {
        removeAllViews();
        this.d.clear();
        this.e.clear();
        this.f.clear();
        this.g.clear();
        int i = this.m;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                break;
            }
            LiveBunchLightViewModel liveBunchLightViewModel = new LiveBunchLightViewModel();
            int i4 = this.h;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i4, i4);
            int i5 = this.c;
            layoutParams.setMargins((i3 * (this.h + this.k)) + i5, i5, 0, 0);
            liveBunchLightViewModel.setView(new ImageView(getContext()));
            ImageView view = liveBunchLightViewModel.getView();
            if (view != null) {
                view.setAlpha(0.0f);
            }
            addView(liveBunchLightViewModel.getView(), layoutParams);
            this.d.add(liveBunchLightViewModel);
            i2 = i3 + 1;
        }
        int i6 = this.m;
        int i7 = 0;
        while (true) {
            int i8 = i7;
            if (i8 >= i6) {
                break;
            }
            LiveBunchLightViewModel liveBunchLightViewModel2 = new LiveBunchLightViewModel();
            int i9 = this.h;
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i9, i9);
            layoutParams2.gravity = 80;
            int i10 = this.c;
            layoutParams2.setMargins((i8 * (this.h + this.k)) + i10, 0, 0, i10);
            liveBunchLightViewModel2.setView(new ImageView(getContext()));
            ImageView view2 = liveBunchLightViewModel2.getView();
            if (view2 != null) {
                view2.setAlpha(0.0f);
            }
            addView(liveBunchLightViewModel2.getView(), layoutParams2);
            this.e.add(liveBunchLightViewModel2);
            i7 = i8 + 1;
        }
        int i11 = this.n;
        int i12 = 0;
        while (i12 < i11) {
            i12++;
            LiveBunchLightViewModel liveBunchLightViewModel3 = new LiveBunchLightViewModel();
            int i13 = this.h;
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(i13, i13);
            int i14 = this.c;
            layoutParams3.setMargins(i14, ((this.h + this.l) * i12) + i14, 0, 0);
            liveBunchLightViewModel3.setView(new ImageView(getContext()));
            ImageView view3 = liveBunchLightViewModel3.getView();
            if (view3 != null) {
                view3.setAlpha(0.0f);
            }
            addView(liveBunchLightViewModel3.getView(), layoutParams3);
            this.f.add(liveBunchLightViewModel3);
        }
        int i15 = this.n;
        int i16 = 0;
        while (i16 < i15) {
            i16++;
            LiveBunchLightViewModel liveBunchLightViewModel4 = new LiveBunchLightViewModel();
            int i17 = this.h;
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(i17, i17);
            layoutParams4.gravity = 5;
            int i18 = this.c;
            layoutParams4.setMargins(0, ((this.h + this.l) * i16) + i18, i18, 0);
            liveBunchLightViewModel4.setView(new ImageView(getContext()));
            ImageView view4 = liveBunchLightViewModel4.getView();
            if (view4 != null) {
                view4.setAlpha(0.0f);
            }
            addView(liveBunchLightViewModel4.getView(), layoutParams4);
            this.g.add(liveBunchLightViewModel4);
        }
    }

    private final void c() {
        int min = Math.min(this.d.size(), this.f.size()) / 2;
        if (min >= 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                int i3 = min - i2;
                int i4 = this.d.size() > this.f.size() ? i3 + 1 : i3;
                int i5 = i4;
                if (i4 < 0) {
                    i5 = 0;
                }
                this.d.get(i2).setDelay(i5);
                ArrayList<LiveBunchLightViewModel> arrayList = this.d;
                arrayList.get((arrayList.size() - 1) - i2).setDelay(i5);
                this.e.get(i2).setDelay(i5);
                ArrayList<LiveBunchLightViewModel> arrayList2 = this.e;
                arrayList2.get((arrayList2.size() - 1) - i2).setDelay(i5);
                int i6 = i3;
                if (this.d.size() < this.f.size()) {
                    i6 = i3 - 1;
                }
                int i7 = i6;
                if (i6 < 0) {
                    i7 = 0;
                }
                this.f.get(i2).setDelay(i7);
                ArrayList<LiveBunchLightViewModel> arrayList3 = this.f;
                arrayList3.get((arrayList3.size() - 1) - i2).setDelay(i7);
                this.g.get(i2).setDelay(i7);
                ArrayList<LiveBunchLightViewModel> arrayList4 = this.g;
                arrayList4.get((arrayList4.size() - 1) - i2).setDelay(i7);
                if (i2 == min) {
                    break;
                }
                i = i2 + 1;
            }
        }
        this.q = (this.o * 2) + (this.p * min);
        if (this.d.size() > this.f.size()) {
            this.q += this.p;
        }
    }

    private final String getNextLightRes() {
        if (this.w + 1 >= this.v.size()) {
            this.w = 0;
        } else {
            this.w++;
        }
        String str = this.v.get(this.w);
        Intrinsics.c(str, "lightResList[currentIndex]");
        return str;
    }

    private final void setRes(ArrayList<String> arrayList) {
        this.v = arrayList;
        this.w = -1;
        int size = this.d.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                break;
            }
            this.d.get(i2).setUrl(getNextLightRes());
            String url = this.d.get(i2).getUrl();
            boolean z = true;
            if (url != null) {
                z = url.length() == 0;
            }
            if (!z && this.d.get(i2).getView() != null) {
                ImageLoader.a((IRequestHost) null, this.d.get(i2).getUrl()).a(this.d.get(i2).getView());
            }
            i = i2 + 1;
        }
        int size2 = this.g.size();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= size2) {
                break;
            }
            this.g.get(i4).setUrl(getNextLightRes());
            String url2 = this.g.get(i4).getUrl();
            if (!(url2 == null || url2.length() == 0) && this.g.get(i4).getView() != null) {
                ImageLoader.a((IRequestHost) null, this.g.get(i4).getUrl()).a(this.g.get(i4).getView());
            }
            i3 = i4 + 1;
        }
        int size3 = this.e.size() - 1;
        if (size3 >= 0) {
            while (true) {
                int i5 = size3 - 1;
                this.e.get(size3).setUrl(getNextLightRes());
                String url3 = this.e.get(size3).getUrl();
                if (!(url3 == null || url3.length() == 0) && this.e.get(size3).getView() != null) {
                    ImageLoader.a((IRequestHost) null, this.e.get(size3).getUrl()).a(this.e.get(size3).getView());
                }
                if (i5 < 0) {
                    break;
                }
                size3 = i5;
            }
        }
        int size4 = this.f.size() - 1;
        if (size4 < 0) {
            return;
        }
        while (true) {
            int i6 = size4 - 1;
            this.f.get(size4).setUrl(getNextLightRes());
            String url4 = this.f.get(size4).getUrl();
            if (!(url4 == null || url4.length() == 0) && this.f.get(size4).getView() != null) {
                ImageLoader.a((IRequestHost) null, this.f.get(size4).getUrl()).a(this.f.get(size4).getView());
            }
            if (i6 < 0) {
                return;
            }
            size4 = i6;
        }
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.blued.android.module.live_china.view.LiveBunchLightView$startPlay$1] */
    public final void a(ArrayList<String> list, int i) {
        Intrinsics.e(list, "list");
        CountDownTimer countDownTimer = this.r;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        setRes(list);
        final long j = this.q;
        final long j2 = i * j;
        this.r = new CountDownTimer(j2, j) { // from class: com.blued.android.module.live_china.view.LiveBunchLightView$startPlay$1
            @Override // android.os.CountDownTimer
            public void onFinish() {
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j3) {
                ArrayList arrayList;
                ArrayList arrayList2;
                ArrayList arrayList3;
                ArrayList arrayList4;
                LiveBunchLightView liveBunchLightView = LiveBunchLightView.this;
                arrayList = liveBunchLightView.d;
                liveBunchLightView.a(arrayList);
                LiveBunchLightView liveBunchLightView2 = LiveBunchLightView.this;
                arrayList2 = liveBunchLightView2.e;
                liveBunchLightView2.a(arrayList2);
                LiveBunchLightView liveBunchLightView3 = LiveBunchLightView.this;
                arrayList3 = liveBunchLightView3.f;
                liveBunchLightView3.a(arrayList3);
                LiveBunchLightView liveBunchLightView4 = LiveBunchLightView.this;
                arrayList4 = liveBunchLightView4.g;
                liveBunchLightView4.a(arrayList4);
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (size != 0 && size2 != 0 && (this.a != size || this.b != size2)) {
            this.a = size;
            this.b = size2;
            this.h = (int) (Math.min(size, size2) / 14.5d);
            a();
            b();
            c();
        }
        super.onMeasure(i, i2);
    }
}
