package com.blued.android.module.live_china.pop;

import android.content.Context;
import android.os.CountDownTimer;
import android.text.TextPaint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.AttachPopupView;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;
import com.blued.android.framework.ui.xpop.enums.PopupPosition;
import com.blued.android.framework.ui.xpop.interfaces.XPopupCallback;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/pop/LivePlanetGiveTipPop.class */
public final class LivePlanetGiveTipPop extends AttachPopupView {
    private final int t;
    private CountDownTimer u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LivePlanetGiveTipPop(Context context, int i) {
        super(context);
        Intrinsics.e(context, "context");
        this.t = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LivePlanetGiveTipPop this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.p();
    }

    public final void a(View view, XPopupCallback xPopupCallback) {
        int a = DensityUtils.a(getContext(), 50.0f);
        new XPopup.Builder(getContext()).a(xPopupCallback).a(PopupAnimation.ScrollAlphaFromBottom).d((Boolean) false).a(PopupPosition.Top).b(true).a(view).b(a).c(DensityUtils.a(getContext(), 10.0f)).a((BasePopupView) this).h();
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.blued.android.module.live_china.pop.LivePlanetGiveTipPop$initPopupContent$2] */
    @Override // com.blued.android.framework.ui.xpop.core.AttachPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public void b() {
        super.b();
        if (this.t <= 0) {
            p();
            return;
        }
        TextView textView = (TextView) findViewById(R.id.tv_title);
        if (textView != null) {
            textView.setText(AppInfo.d().getString(R.string.live_planet_tips_give_succeed, Integer.valueOf(this.t)));
        }
        TextPaint paint = textView == null ? null : textView.getPaint();
        if (paint != null) {
            paint.setFakeBoldText(true);
        }
        View findViewById = findViewById(R.id.rl_root);
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.pop.-$$Lambda$LivePlanetGiveTipPop$pgBmV6SosaxcaZIBW3sEha3ucxI
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LivePlanetGiveTipPop.a(LivePlanetGiveTipPop.this, view);
                }
            });
        }
        this.u = new CountDownTimer() { // from class: com.blued.android.module.live_china.pop.LivePlanetGiveTipPop$initPopupContent$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2000L, 2000L);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (LivePlanetGiveTipPop.this.getContext() == null || LivePlanetGiveTipPop.this.t()) {
                    return;
                }
                LivePlanetGiveTipPop.this.p();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
            }
        }.start();
    }

    public final void b(View view) {
        a(view, (XPopupCallback) null);
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getImplLayoutId() {
        return R.layout.pop_planet_give_tips;
    }

    public final int getNum() {
        return this.t;
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        p();
        return false;
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public void p() {
        CountDownTimer countDownTimer = this.u;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.u = null;
        super.p();
    }
}
