package com.blued.android.module.live_china.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.databinding.LiveGiftSetComboLayoutBinding;
import com.blued.android.module.live_china.model.LiveGiftSetInfoModel;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveGiftSetComboView.class */
public final class LiveGiftSetComboView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f14486a = new Companion(null);
    private static HashMap<String, MyCountDown> i = new HashMap<>();
    private final Lazy b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f14487c;
    private boolean d;
    private int e;
    private long f;
    private CountDownTimer g;
    private EventCallBack h;

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveGiftSetComboView$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final HashMap<String, MyCountDown> a() {
            return LiveGiftSetComboView.i;
        }

        public final void a(int i, long j) {
            MyCountDown myCountDown = a().get(String.valueOf(i));
            if (myCountDown == null || myCountDown.a() <= 0) {
                MyCountDown myCountDown2 = new MyCountDown(j * 1000, 1000L, i);
                myCountDown2.start();
                a().put(String.valueOf(i), myCountDown2);
            }
        }

        public final boolean a(int i) {
            Log.i("==xppp", Intrinsics.a("isTimeCountDown :", (Object) Integer.valueOf(i)));
            if (!a().containsKey(String.valueOf(i))) {
                Log.i("==xppp", "isTimeCountDown ont");
                return false;
            }
            MyCountDown myCountDown = a().get(String.valueOf(i));
            Intrinsics.a(myCountDown);
            Log.i("==xppp", Intrinsics.a("isTimeCountDown time:", (Object) Long.valueOf(myCountDown.a())));
            if (a().get(String.valueOf(i)) != null) {
                MyCountDown myCountDown2 = a().get(String.valueOf(i));
                Intrinsics.a(myCountDown2);
                return myCountDown2.a() > 0;
            }
            return false;
        }

        public final int b(int i) {
            if (!a().containsKey(String.valueOf(i)) || a().get(String.valueOf(i)) == null) {
                return 0;
            }
            MyCountDown myCountDown = a().get(String.valueOf(i));
            Intrinsics.a(myCountDown);
            return (int) myCountDown.a();
        }

        public final void c(int i) {
            MyCountDown myCountDown = a().get(String.valueOf(i));
            if (myCountDown != null) {
                myCountDown.cancel();
                a().remove(String.valueOf(i));
            }
        }
    }

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveGiftSetComboView$EventCallBack.class */
    public interface EventCallBack {
        void a();

        void b();
    }

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveGiftSetComboView$MyCountDown.class */
    public static final class MyCountDown extends CountDownTimer {

        /* renamed from: a  reason: collision with root package name */
        private int f14488a;
        private long b;

        public MyCountDown(long j, long j2, int i) {
            super(j, j2);
            this.f14488a = i;
            this.b = j / 1000;
        }

        public final long a() {
            return this.b;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            this.b = 0L;
            Log.i("==xppp", Intrinsics.a("onFinish", (Object) Integer.valueOf(this.f14488a)));
            LiveGiftSetComboView.f14486a.a().remove(String.valueOf(this.f14488a));
            LiveEventBus.get("live_gift_set_buy_count_end").post(Integer.valueOf(this.f14488a));
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            this.b = (j / 1000) + 1;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveGiftSetComboView(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveGiftSetComboView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveGiftSetComboView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Intrinsics.e(context, "context");
        this.b = LazyKt.a(new Function0<LiveGiftSetComboLayoutBinding>() { // from class: com.blued.android.module.live_china.view.LiveGiftSetComboView$vb$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final LiveGiftSetComboLayoutBinding invoke() {
                return LiveGiftSetComboLayoutBinding.a(LayoutInflater.from(LiveGiftSetComboView.this.getContext()), LiveGiftSetComboView.this, true);
            }
        });
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveGiftSetComboView this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveGiftSetComboView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        EventCallBack eventCallBack = this$0.h;
        if (eventCallBack != null) {
            eventCallBack.a();
        }
        this$0.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(final LiveGiftSetComboView this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.getVb().b.setScaleX(1.0f);
        this$0.getVb().b.setScaleY(1.0f);
        this$0.getVb().b.animate().scaleX(1.0f).scaleY(1.0f).setDuration(320L).withEndAction(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveGiftSetComboView$Ty1zLRXRQz-iJgY9HGBP_z_BUjk
            @Override // java.lang.Runnable
            public final void run() {
                LiveGiftSetComboView.a(LiveGiftSetComboView.this);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(LiveGiftSetComboView this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(final LiveGiftSetComboView this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.getVb().b.animate().scaleX(1.0f).scaleY(1.0f).setDuration(160L).withEndAction(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveGiftSetComboView$MaYFWT8dZDspUabx_A5GY6APzSM
            @Override // java.lang.Runnable
            public final void run() {
                LiveGiftSetComboView.c(LiveGiftSetComboView.this);
            }
        }).start();
    }

    private final void i() {
        getVb().b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveGiftSetComboView$7uzhMUpy63cRE6hdbm5dvN564qI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveGiftSetComboView.a(LiveGiftSetComboView.this, view);
            }
        });
    }

    private final void j() {
        if (getVb().b.getAnimation() != null) {
            getVb().b.getAnimation().reset();
            getVb().b.getAnimation().cancel();
        }
        getVb().b.clearAnimation();
        if (getVb().f12229c.getAnimation() != null) {
            getVb().f12229c.getAnimation().reset();
            getVb().f12229c.getAnimation().cancel();
        }
        getVb().f12229c.clearAnimation();
        getVb().b.setScaleX(1.0f);
        getVb().b.setScaleY(1.0f);
        getVb().b.animate().scaleX(0.7f).scaleY(0.7f).setDuration(120L).withEndAction(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveGiftSetComboView$SX1x_6QBvGrd1WS__l1WvDzeOq8
            @Override // java.lang.Runnable
            public final void run() {
                LiveGiftSetComboView.d(LiveGiftSetComboView.this);
            }
        }).start();
    }

    public final void a() {
        setVisibility(0);
        setAlpha(1.0f);
        setScaleX(1.0f);
        setScaleY(1.0f);
        getVb().b.setAlpha(0.0f);
        getVb().b.setScaleX(0.0f);
        getVb().b.setScaleY(0.0f);
        getVb().b.animate().alpha(1.0f).scaleX(1.1f).scaleY(1.1f).setDuration(400L).withEndAction(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveGiftSetComboView$JgMkAz0XXk0E8t5byr0ojHWfYz4
            @Override // java.lang.Runnable
            public final void run() {
                LiveGiftSetComboView.b(LiveGiftSetComboView.this);
            }
        }).start();
        this.f = c();
        getVb().d.setMaxValue(100.0f);
        getVb().d.setBarColor(Color.parseColor("#FFD041"), Color.parseColor("#FFFDB3"));
        getVb().d.setBarWidth(DensityUtils.a(AppInfo.d(), 4.0f));
        getVb().d.setRimWidth(DensityUtils.a(AppInfo.d(), 4.0f));
        getVb().d.setRimColor(0);
        getVb().d.setBarStrokeCap(Paint.Cap.ROUND);
        getVb().d.setValue(100.0f);
        getVb().d.a(100.0f, 0.0f, this.f * 1000);
    }

    public final void a(LiveGiftSetInfoModel model) {
        Intrinsics.e(model, "model");
        if (model.getId() == 0) {
            return;
        }
        if (this.e == model.getId() && this.d) {
            return;
        }
        if (this.d) {
            e();
        }
        this.d = true;
        this.e = model.getId();
        this.f = model.getExpire_time();
        a();
    }

    public final void b() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.9f, 1.0f, 0.9f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setRepeatMode(2);
        scaleAnimation.setInterpolator(new LinearInterpolator());
        scaleAnimation.setRepeatCount(-1);
        scaleAnimation.setDuration(320L);
        getVb().getRoot().startAnimation(scaleAnimation);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, -359.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(1200L);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        getVb().f12229c.startAnimation(rotateAnimation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0025, code lost:
        if (r0.a() <= 0) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long c() {
        /*
            r9 = this;
            r0 = r9
            r0.d()
            java.util.HashMap<java.lang.String, com.blued.android.module.live_china.view.LiveGiftSetComboView$MyCountDown> r0 = com.blued.android.module.live_china.view.LiveGiftSetComboView.i
            r1 = r9
            int r1 = r1.e
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.Object r0 = r0.get(r1)
            com.blued.android.module.live_china.view.LiveGiftSetComboView$MyCountDown r0 = (com.blued.android.module.live_china.view.LiveGiftSetComboView.MyCountDown) r0
            r13 = r0
            r0 = r13
            if (r0 == 0) goto L28
            r0 = r13
            r12 = r0
            r0 = r13
            long r0 = r0.a()
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L54
        L28:
            com.blued.android.module.live_china.view.LiveGiftSetComboView$MyCountDown r0 = new com.blued.android.module.live_china.view.LiveGiftSetComboView$MyCountDown
            r1 = r0
            r2 = r9
            long r2 = r2.f
            r3 = 1000(0x3e8, float:1.401E-42)
            long r3 = (long) r3
            long r2 = r2 * r3
            r3 = 1000(0x3e8, double:4.94E-321)
            r4 = r9
            int r4 = r4.e
            r1.<init>(r2, r3, r4)
            r12 = r0
            r0 = r12
            android.os.CountDownTimer r0 = r0.start()
            java.util.HashMap<java.lang.String, com.blued.android.module.live_china.view.LiveGiftSetComboView$MyCountDown> r0 = com.blued.android.module.live_china.view.LiveGiftSetComboView.i
            r1 = r9
            int r1 = r1.e
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r2 = r12
            java.lang.Object r0 = r0.put(r1, r2)
        L54:
            r0 = r12
            long r0 = r0.a()
            r10 = r0
            r0 = r9
            r1 = r10
            r0.f = r1
            r0 = r9
            com.blued.android.module.live_china.view.LiveGiftSetComboView$startPunishTimer$1 r1 = new com.blued.android.module.live_china.view.LiveGiftSetComboView$startPunishTimer$1
            r2 = r1
            r3 = r9
            r4 = r10
            r5 = 1000(0x3e8, float:1.401E-42)
            long r5 = (long) r5
            long r4 = r4 * r5
            r2.<init>(r4)
            android.os.CountDownTimer r1 = r1.start()
            r0.g = r1
            r0 = r9
            long r0 = r0.f
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.view.LiveGiftSetComboView.c():long");
    }

    public final void d() {
        CountDownTimer countDownTimer = this.g;
        if (countDownTimer == null || countDownTimer == null) {
            return;
        }
        countDownTimer.cancel();
    }

    public final void e() {
        this.d = false;
        this.e = 0;
        this.f = 0L;
        setVisibility(8);
        clearAnimation();
        d();
        getVb().f12229c.clearAnimation();
        getVb().b.clearAnimation();
    }

    public final void f() {
        e();
        this.h = null;
    }

    public final boolean g() {
        return this.d && getVisibility() == 0;
    }

    public final boolean getAttatch() {
        return this.f14487c;
    }

    public final EventCallBack getCallBack() {
        return this.h;
    }

    public final int getCurrentSetId() {
        return this.e;
    }

    public final CountDownTimer getStartDownTimer() {
        return this.g;
    }

    public final long getTime() {
        return this.f;
    }

    public final LiveGiftSetComboLayoutBinding getVb() {
        return (LiveGiftSetComboLayoutBinding) this.b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f14487c = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f();
        this.f14487c = false;
    }

    public final void setAttatch(boolean z) {
        this.f14487c = z;
    }

    public final void setCallBack(EventCallBack eventCallBack) {
        this.h = eventCallBack;
    }

    public final void setComboAnimating(boolean z) {
        this.d = z;
    }

    public final void setCurrentSetId(int i2) {
        this.e = i2;
    }

    public final void setEventCallBack(EventCallBack eventCallBack) {
        this.h = eventCallBack;
    }

    public final void setStartDownTimer(CountDownTimer countDownTimer) {
        this.g = countDownTimer;
    }

    public final void setTime(long j) {
        this.f = j;
    }
}
