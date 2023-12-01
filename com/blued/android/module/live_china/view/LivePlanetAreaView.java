package com.blued.android.module.live_china.view;

import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.LivePlanetAreaItemBinding;
import com.blued.android.module.live_china.fragment.LivePlanetDialog;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LivePlanetExtra;
import com.blued.android.module.live_china.model.PlanetBallModel;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LivePlanetAreaView.class */
public final class LivePlanetAreaView extends RelativeLayout {
    private final Context a;
    private IRequestHost b;
    private boolean c;
    private int d;
    private int e;
    private int f;
    private ValueAnimator g;
    private PlanetBallModel h;
    private final LivePlanetAreaItemBinding i;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LivePlanetAreaView(Context mContext) {
        this(mContext, null, 0, 6, null);
        Intrinsics.e(mContext, "mContext");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LivePlanetAreaView(Context mContext, AttributeSet attributeSet) {
        this(mContext, attributeSet, 0, 4, null);
        Intrinsics.e(mContext, "mContext");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LivePlanetAreaView(Context mContext, AttributeSet attributeSet, int i) {
        super(mContext, attributeSet, i);
        Intrinsics.e(mContext, "mContext");
        this.a = mContext;
        this.d = 1;
        this.f = 9999;
        LivePlanetAreaItemBinding a = LivePlanetAreaItemBinding.a(LayoutInflater.from(mContext).inflate(R.layout.live_planet_area_item, this));
        Intrinsics.c(a, "bind(\n        LayoutInfl…et_area_item, this)\n    )");
        this.i = a;
        f();
    }

    public /* synthetic */ LivePlanetAreaView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(int i, LivePlanetAreaView this$0) {
        Intrinsics.e(this$0, "this$0");
        if (i < 4) {
            this$0.b(i + 1);
        }
    }

    private final void a(final TextView textView, int i, int i2) {
        if (Math.abs(i - i2) <= 2) {
            textView.setText(String.valueOf(i2));
            return;
        }
        ValueAnimator valueAnimator = this.g;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.g = valueAnimator2;
            if (valueAnimator2 != null) {
                valueAnimator2.setDuration(300L);
            }
            ValueAnimator valueAnimator3 = this.g;
            if (valueAnimator3 != null) {
                valueAnimator3.setInterpolator(new DecelerateInterpolator(1.5f));
            }
            ValueAnimator valueAnimator4 = this.g;
            if (valueAnimator4 != null) {
                valueAnimator4.setEvaluator(null);
            }
        } else {
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            ValueAnimator valueAnimator5 = this.g;
            if (valueAnimator5 != null) {
                valueAnimator5.removeAllUpdateListeners();
            }
        }
        ValueAnimator valueAnimator6 = this.g;
        if (valueAnimator6 == null) {
            return;
        }
        valueAnimator6.setIntValues(i, i2);
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LivePlanetAreaView$yjxFUXKp8vGFC3f27wLo9Uh_1iE
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator7) {
                LivePlanetAreaView.a(TextView.this, valueAnimator7);
            }
        };
        valueAnimator6.setTarget(null);
        valueAnimator6.addUpdateListener(animatorUpdateListener);
        valueAnimator6.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(TextView tv, ValueAnimator animation) {
        Intrinsics.e(tv, "$tv");
        Intrinsics.e(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        if (animatedValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        tv.setText(String.valueOf(((Integer) animatedValue).intValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LivePlanetAreaView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        int i = this$0.d;
        if (i != 1) {
            if (i == 2) {
                this$0.setState(1);
                LiveEventBusUtil.h();
            }
        } else if (this$0.e <= 0 && LivePlanetDialog.a.a() >= LivePlanetDialog.a.b()) {
            String string = AppInfo.d().getString(R.string.live_planet_toast_max_dispatch_count, Integer.valueOf(LivePlanetDialog.a.b()));
            Intrinsics.c(string, "getAppContext().getStrin…                        )");
            ToastUtils.b(string);
        } else {
            LiveProtos.Event event = LiveProtos.Event.LIVE_STAR_EXPLORE_PAGE_STAR_CLICK;
            String e = LiveRoomManager.a().e();
            String g = LiveRoomManager.a().g();
            PlanetBallModel planetBallModel = this$0.h;
            EventTrackLive.b(event, e, g, String.valueOf(planetBallModel == null ? null : Integer.valueOf(planetBallModel.getId())));
            this$0.setState(2);
            LiveEventBusUtil.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(final int i) {
        int i2 = i % 2;
        ViewPropertyAnimator scaleY = this.i.h.animate().scaleX(i2 == 1 ? 1.05f : 1.0f).scaleY(i2 == 1 ? 1.05f : 1.0f);
        long j = 60;
        if (i != 1) {
            j = 60;
            if (i != 2) {
                j = i != 3 ? i != 4 ? 60L : 240L : 300L;
            }
        }
        scaleY.setDuration(j).withEndAction(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LivePlanetAreaView$5M8kCBkJK8IBo1HwQ3vgEUBwrHw
            @Override // java.lang.Runnable
            public final void run() {
                LivePlanetAreaView.a(i, this);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LivePlanetAreaView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        LiveProtos.Event event = LiveProtos.Event.LIVE_STAR_EXPLORE_PAGE_STAR_CANCEL;
        String e = LiveRoomManager.a().e();
        String g = LiveRoomManager.a().g();
        PlanetBallModel planetBallModel = this$0.h;
        EventTrackLive.b(event, e, g, String.valueOf(planetBallModel == null ? null : Integer.valueOf(planetBallModel.getId())));
        if (this$0.e == 0) {
            if (this$0.d == 1) {
                return;
            }
            this$0.setState(1);
            LiveEventBusUtil.c(-1, -1);
            return;
        }
        PlanetBallModel planetBallModel2 = this$0.h;
        if (planetBallModel2 == null) {
            return;
        }
        this$0.c(planetBallModel2.getId());
    }

    private final void c(int i) {
        LiveEventBusUtil.a(true, true);
        LiveRoomHttpUtils.h(i, new BluedUIHttpResponse<BluedEntityA<LivePlanetExtra>>() { // from class: com.blued.android.module.live_china.view.LivePlanetAreaView$cancelBet$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(null);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LivePlanetExtra> entity) {
                ValueAnimator valueAnimator;
                ValueAnimator valueAnimator2;
                Intrinsics.e(entity, "entity");
                LivePlanetExtra singleData = entity.getSingleData();
                if (singleData == null) {
                    return;
                }
                LivePlanetAreaView livePlanetAreaView = LivePlanetAreaView.this;
                valueAnimator = livePlanetAreaView.g;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                }
                valueAnimator2 = livePlanetAreaView.g;
                if (valueAnimator2 != null) {
                    valueAnimator2.removeAllUpdateListeners();
                }
                livePlanetAreaView.setNum(0);
                if (livePlanetAreaView.getCurrentState() == 1) {
                    livePlanetAreaView.setState(1);
                }
                LiveEventBusUtil.c(singleData.getBet_count(), singleData.getShip_count());
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i2, String str) {
                return super.onUIFailure(i2, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                LiveEventBusUtil.a(true, false);
            }
        }, (IRequestHost) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(LivePlanetAreaView this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.i.h.animate().alpha(0.0f).scaleX(1.0f).scaleY(1.0f).setDuration(350L).start();
    }

    private final void f() {
        LayoutTransition layoutTransition = new LayoutTransition();
        layoutTransition.setAnimator(2, ObjectAnimator.ofFloat((Object) null, "alpha", 0.0f, 1.0f));
        layoutTransition.setAnimator(3, ObjectAnimator.ofFloat((Object) null, "alpha", 1.0f, 0.0f));
        layoutTransition.setInterpolator(2, new DecelerateInterpolator());
        layoutTransition.setInterpolator(3, new DecelerateInterpolator());
        layoutTransition.setDuration(300L);
        this.i.a.setLayoutTransition(layoutTransition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setNum(int i) {
        int i2 = this.f;
        boolean z = false;
        if (1 <= i2) {
            z = false;
            if (i2 < i) {
                z = true;
            }
        }
        if (z) {
            i = this.f;
        }
        int i3 = this.e;
        if (i3 == i) {
            return;
        }
        if (i > 0) {
            TextView textView = this.i.l;
            Intrinsics.c(textView, "vb.tvNum");
            a(textView, this.e, i);
        } else if (i3 > 0 && i <= 0) {
            this.i.l.setText("0");
        }
        this.e = i;
    }

    public final void a() {
        this.i.h.setScaleX(0.0f);
        ImageView imageView = this.i.h;
        Intrinsics.c(imageView, "vb.ivLotteryBorder");
        BluedViewExKt.a(imageView);
        this.i.i.setScaleX(0.0f);
        ImageView imageView2 = this.i.i;
        Intrinsics.c(imageView2, "vb.ivLotteryBorderJack");
        BluedViewExKt.a(imageView2);
        if (this.c) {
            this.i.a.setClickable(false);
            this.i.f.setClickable(false);
            return;
        }
        this.i.a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LivePlanetAreaView$5p8YOv0XvqSu5z2YR-QDeIKLHuY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LivePlanetAreaView.a(LivePlanetAreaView.this, view);
            }
        });
        this.i.f.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LivePlanetAreaView$jKuzUxu_zQiOrb-gqQW3q4aMa7I
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LivePlanetAreaView.b(LivePlanetAreaView.this, view);
            }
        });
    }

    public final void a(int i) {
        setNum(this.e + i);
    }

    public final boolean b() {
        return this.d == 2;
    }

    public final boolean c() {
        return this.e > 0;
    }

    public final void d() {
        ImageView imageView = this.i.i;
        Intrinsics.c(imageView, "vb.ivLotteryBorderJack");
        BluedViewExKt.a(imageView);
        ImageView imageView2 = this.i.h;
        Intrinsics.c(imageView2, "vb.ivLotteryBorder");
        BluedViewExKt.a(imageView2);
        this.i.h.setScaleX(1.0f);
        this.i.h.animate().cancel();
        this.i.h.setAlpha(0.0f);
        this.i.h.setImageResource(R.drawable.live_planet_item_lottery_ing);
        ImageView imageView3 = this.i.h;
        Intrinsics.c(imageView3, "vb.ivLotteryBorder");
        BluedViewExKt.b(imageView3);
        this.i.h.animate().alpha(1.0f).scaleX(1.05f).scaleY(1.05f).setDuration(350L).withEndAction(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LivePlanetAreaView$9f3X1K-uo-jOtJlt1pDI7ocSJqU
            @Override // java.lang.Runnable
            public final void run() {
                LivePlanetAreaView.d(LivePlanetAreaView.this);
            }
        }).start();
    }

    public final void e() {
        ImageView imageView = this.i.i;
        Intrinsics.c(imageView, "vb.ivLotteryBorderJack");
        BluedViewExKt.a(imageView);
        this.i.i.setScaleX(1.0f);
        ImageView imageView2 = this.i.h;
        Intrinsics.c(imageView2, "vb.ivLotteryBorder");
        BluedViewExKt.b(imageView2);
        this.i.h.animate().cancel();
        this.i.h.setAlpha(1.0f);
        this.i.h.setScaleX(1.0f);
        this.i.h.setScaleY(1.0f);
        ImageLoader.c(this.b, "live_planet_winning.png").g().a(new LivePlanetAreaView$blinkWinning$1(this)).a(this.i.h);
    }

    public final int getCurrentNum() {
        return this.e;
    }

    public final int getCurrentState() {
        return this.d;
    }

    public final Context getMContext() {
        return this.a;
    }

    public final int getMaxNum() {
        return this.f;
    }

    public final int getPlanetId() {
        PlanetBallModel planetBallModel = this.h;
        if (planetBallModel == null) {
            return -1;
        }
        Intrinsics.a(planetBallModel);
        return planetBallModel.getId();
    }

    public final void setCurrentNum(int i) {
        this.e = i;
    }

    public final void setCurrentState(int i) {
        this.d = i;
    }

    public final void setData(PlanetBallModel model) {
        Intrinsics.e(model, "model");
        this.h = model;
        ImageLoader.a(this.b, model.getName_image()).a(new LivePlanetAreaView$setData$1(this, this.b)).a(this.i.j);
        ImageView imageView = this.i.j;
        Intrinsics.c(imageView, "vb.ivName");
        BluedViewExKt.b(imageView);
        this.i.m.setText(AppInfo.d().getString(R.string.live_planet_multiplying_power, Integer.valueOf(model.getRate())));
        TextView textView = this.i.m;
        Intrinsics.c(textView, "vb.tvPower");
        BluedViewExKt.b(textView);
        this.f = model.getBet_limit();
        setNum(model.getBet_count());
        setState(1);
    }

    public final void setFragmentActive(IRequestHost iRequestHost) {
        Intrinsics.e(iRequestHost, "iRequestHost");
        this.b = iRequestHost;
        this.c = TextUtils.equals(LiveRoomInfo.a().f(), LiveRoomManager.a().g());
    }

    public final void setMaxNum(int i) {
        this.f = i;
    }

    public final void setNameImg(int i) {
        this.i.j.setImageResource(i);
    }

    public final void setRate(int i) {
        this.i.m.setText(AppInfo.d().getString(R.string.live_planet_multiplying_power, Integer.valueOf(i)));
        TextView textView = this.i.m;
        Intrinsics.c(textView, "vb.tvPower");
        BluedViewExKt.b(textView);
    }

    public final void setState(int i) {
        if (i == 1 || this.d != i) {
            float f = 0.0f;
            if (i == 1) {
                if (this.e <= 0) {
                    ImageView imageView = this.i.d;
                    Intrinsics.c(imageView, "vb.ivBorderDefault");
                    BluedViewExKt.b(imageView);
                    ImageView imageView2 = this.i.e;
                    Intrinsics.c(imageView2, "vb.ivBorderGold");
                    BluedViewExKt.a(imageView2);
                    ImageView imageView3 = this.i.c;
                    Intrinsics.c(imageView3, "vb.ivBorderBlue");
                    BluedViewExKt.a(imageView3);
                    this.i.l.animate().alpha(0.5f).setDuration(250L).start();
                    this.i.f.setImageResource(R.drawable.live_planet_close_blue);
                    this.i.f.setClickable(false);
                } else {
                    ImageView imageView4 = this.i.c;
                    Intrinsics.c(imageView4, "vb.ivBorderBlue");
                    BluedViewExKt.b(imageView4);
                    ImageView imageView5 = this.i.e;
                    Intrinsics.c(imageView5, "vb.ivBorderGold");
                    BluedViewExKt.a(imageView5);
                    ImageView imageView6 = this.i.d;
                    Intrinsics.c(imageView6, "vb.ivBorderDefault");
                    BluedViewExKt.a(imageView6);
                    this.i.l.animate().alpha(1.0f).setDuration(250L).start();
                    this.i.f.setImageResource(R.drawable.live_planet_close_white);
                    this.i.f.setClickable(true);
                }
                this.i.g.animate().alpha(0.0f).setDuration(150L).start();
            } else if (i == 2) {
                ImageView imageView7 = this.i.e;
                Intrinsics.c(imageView7, "vb.ivBorderGold");
                BluedViewExKt.b(imageView7);
                ImageView imageView8 = this.i.c;
                Intrinsics.c(imageView8, "vb.ivBorderBlue");
                BluedViewExKt.a(imageView8);
                ImageView imageView9 = this.i.d;
                Intrinsics.c(imageView9, "vb.ivBorderDefault");
                BluedViewExKt.a(imageView9);
                this.i.f.setImageResource(R.drawable.live_planet_close_white);
                this.i.f.setClickable(true);
                this.i.l.animate().alpha(1.0f).setDuration(250L).start();
                this.i.g.animate().alpha(0.0f).setDuration(150L).start();
            } else if (i != 3) {
                return;
            } else {
                if (this.e > 0) {
                    ImageView imageView10 = this.i.c;
                    Intrinsics.c(imageView10, "vb.ivBorderBlue");
                    BluedViewExKt.b(imageView10);
                    ImageView imageView11 = this.i.d;
                    Intrinsics.c(imageView11, "vb.ivBorderDefault");
                    BluedViewExKt.a(imageView11);
                } else {
                    ImageView imageView12 = this.i.d;
                    Intrinsics.c(imageView12, "vb.ivBorderDefault");
                    BluedViewExKt.b(imageView12);
                    ImageView imageView13 = this.i.c;
                    Intrinsics.c(imageView13, "vb.ivBorderBlue");
                    BluedViewExKt.a(imageView13);
                }
                ImageView imageView14 = this.i.e;
                Intrinsics.c(imageView14, "vb.ivBorderGold");
                BluedViewExKt.a(imageView14);
                this.i.f.setImageResource(R.drawable.live_planet_close_blue);
                this.i.f.setClickable(true);
                this.i.l.animate().alpha(0.5f).setDuration(250L).start();
                ViewPropertyAnimator animate = this.i.g.animate();
                if (this.e > 0) {
                    f = 1.0f;
                }
                animate.alpha(f).setDuration(150L).start();
            }
            this.d = i;
        }
    }
}
