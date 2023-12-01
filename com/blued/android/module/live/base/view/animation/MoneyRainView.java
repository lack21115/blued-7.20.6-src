package com.blued.android.module.live.base.view.animation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.live.base.R;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/view/animation/MoneyRainView.class */
public class MoneyRainView extends BaseLiveAnimationView {
    private View b;
    private FlakeView c;

    public MoneyRainView(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_money_rain, (ViewGroup) null);
        this.b = inflate;
        this.c = (FlakeView) inflate.findViewById(R.id.fv_money);
    }

    @Override // com.blued.android.module.live.base.view.animation.BaseLiveAnimationView
    public View a() {
        return this.b;
    }

    @Override // com.blued.android.module.live.base.view.animation.BaseLiveAnimationView
    public void a(IRequestHost iRequestHost) {
        FlakeView flakeView = this.c;
        if (flakeView != null) {
            flakeView.b();
        }
    }

    @Override // com.blued.android.module.live.base.view.animation.BaseLiveAnimationView
    public void a(LiveAnimationListener liveAnimationListener) {
        super.a(liveAnimationListener);
        this.c.setAnimationListener(this.a);
    }
}
