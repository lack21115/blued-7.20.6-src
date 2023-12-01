package com.blued.android.module.live_china.click;

import android.view.View;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/click/SingleClickProxy.class */
public class SingleClickProxy implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private View.OnClickListener f11722a;
    private long b;

    /* renamed from: c  reason: collision with root package name */
    private long f11723c;
    private IClickAgain d;

    public SingleClickProxy(View.OnClickListener onClickListener) {
        this.b = 0L;
        this.f11723c = 1000L;
        this.f11722a = onClickListener;
    }

    public SingleClickProxy(View.OnClickListener onClickListener, long j, IClickAgain iClickAgain) {
        this.b = 0L;
        this.f11723c = 1000L;
        this.f11722a = onClickListener;
        this.d = iClickAgain;
        this.f11723c = j;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (System.currentTimeMillis() - this.b >= this.f11723c) {
            this.f11722a.onClick(view);
            this.b = System.currentTimeMillis();
            return;
        }
        IClickAgain iClickAgain = this.d;
        if (iClickAgain != null) {
            iClickAgain.a();
        }
    }
}
