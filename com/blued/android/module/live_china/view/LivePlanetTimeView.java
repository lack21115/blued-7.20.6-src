package com.blued.android.module.live_china.view;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.LivePlanetTimeBinding;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LivePlanetTimeView.class */
public final class LivePlanetTimeView extends FrameLayout {
    private final Context a;
    private final LivePlanetTimeBinding b;
    private CountDownTimer c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LivePlanetTimeView(Context mContext) {
        this(mContext, null, 0, 6, null);
        Intrinsics.e(mContext, "mContext");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LivePlanetTimeView(Context mContext, AttributeSet attributeSet) {
        this(mContext, attributeSet, 0, 4, null);
        Intrinsics.e(mContext, "mContext");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LivePlanetTimeView(Context mContext, AttributeSet attributeSet, int i) {
        super(mContext, attributeSet, i);
        Intrinsics.e(mContext, "mContext");
        this.a = mContext;
        LivePlanetTimeBinding a = LivePlanetTimeBinding.a(LayoutInflater.from(mContext).inflate(R.layout.live_planet_time, this));
        Intrinsics.c(a, "bind(\n        LayoutInfl…_planet_time, this)\n    )");
        this.b = a;
        a.g.getPaint().setFakeBoldText(true);
        FrameLayout frameLayout = this.b.a;
        Intrinsics.c(frameLayout, "vb.flTimeRoot");
        BluedViewExKt.a(frameLayout);
        this.b.b.setImageResource(R.drawable.live_planet_num_0);
        this.b.c.setImageResource(R.drawable.live_planet_num_0);
        this.b.d.setImageResource(R.drawable.live_planet_num_0);
        this.b.e.setImageResource(R.drawable.live_planet_num_0);
    }

    public /* synthetic */ LivePlanetTimeView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b() {
        LiveEventBusUtil.j();
    }

    private final void b(int i) {
        a();
        this.c = new LivePlanetTimeView$startTime$1(this, i * 1000).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(int i) {
        int i2 = (int) (i / 60.0f);
        float f = i2;
        this.b.b.setImageResource(d((int) (f / 10.0f)));
        this.b.c.setImageResource(d((int) (f % 10.0f)));
        float f2 = i - (i2 * 60);
        this.b.d.setImageResource(d((int) (f2 / 10.0f)));
        this.b.e.setImageResource(d((int) (f2 % 10.0f)));
    }

    private final int d(int i) {
        switch (i) {
            case 0:
                return R.drawable.live_planet_num_0;
            case 1:
                return R.drawable.live_planet_num_1;
            case 2:
                return R.drawable.live_planet_num_2;
            case 3:
                return R.drawable.live_planet_num_3;
            case 4:
                return R.drawable.live_planet_num_4;
            case 5:
                return R.drawable.live_planet_num_5;
            case 6:
                return R.drawable.live_planet_num_6;
            case 7:
                return R.drawable.live_planet_num_7;
            case 8:
                return R.drawable.live_planet_num_8;
            case 9:
                return R.drawable.live_planet_num_9;
            default:
                return R.drawable.live_planet_num_0;
        }
    }

    public final void a() {
        CountDownTimer countDownTimer = this.c;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.c = null;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.blued.android.module.live_china.view.LivePlanetTimeView$startUpdateDataTime$1] */
    public final void a(int i) {
        a();
        final long j = i * 1000;
        this.c = new CountDownTimer(j) { // from class: com.blued.android.module.live_china.view.LivePlanetTimeView$startUpdateDataTime$1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (LivePlanetTimeView.this.getContext() == null) {
                    return;
                }
                LiveEventBusUtil.j();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                long j3 = j2 / 1000;
            }
        }.start();
    }

    public final Context getMContext() {
        return this.a;
    }

    public final void setData(int i) {
        if (i < 0) {
            a();
            TextView textView = this.b.g;
            Intrinsics.c(textView, "vb.tvProbeIng");
            BluedViewExKt.b(textView);
            FrameLayout frameLayout = this.b.a;
            Intrinsics.c(frameLayout, "vb.flTimeRoot");
            BluedViewExKt.a(frameLayout);
        } else if (i == 0) {
            LiveEventBusUtil.a(true, true);
            AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LivePlanetTimeView$jNDUl-Yh08eeXMa4sriShV54SVc
                @Override // java.lang.Runnable
                public final void run() {
                    LivePlanetTimeView.b();
                }
            }, 1000L);
        } else {
            this.b.b.setImageResource(R.drawable.live_planet_num_0);
            this.b.c.setImageResource(R.drawable.live_planet_num_0);
            this.b.d.setImageResource(R.drawable.live_planet_num_0);
            this.b.e.setImageResource(R.drawable.live_planet_num_0);
            FrameLayout frameLayout2 = this.b.a;
            Intrinsics.c(frameLayout2, "vb.flTimeRoot");
            BluedViewExKt.b(frameLayout2);
            TextView textView2 = this.b.g;
            Intrinsics.c(textView2, "vb.tvProbeIng");
            BluedViewExKt.a(textView2);
            b(i);
        }
    }
}
