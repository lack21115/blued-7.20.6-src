package com.blued.android.module.common.utils.click;

import android.view.View;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/click/SingleClickProxy.class */
public class SingleClickProxy implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private View.OnClickListener f10923a;
    private long b;

    /* renamed from: c  reason: collision with root package name */
    private long f10924c;
    private IClickAgain d;

    public SingleClickProxy(View.OnClickListener onClickListener) {
        this.b = 0L;
        this.f10924c = 500L;
        this.f10923a = onClickListener;
    }

    public SingleClickProxy(View.OnClickListener onClickListener, long j, IClickAgain iClickAgain) {
        this.b = 0L;
        this.f10924c = 500L;
        this.f10923a = onClickListener;
        this.d = iClickAgain;
        this.f10924c = j;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (System.currentTimeMillis() - this.b >= this.f10924c) {
            this.f10923a.onClick(view);
            this.b = System.currentTimeMillis();
            return;
        }
        IClickAgain iClickAgain = this.d;
        if (iClickAgain != null) {
            iClickAgain.onAgain();
        }
    }
}
