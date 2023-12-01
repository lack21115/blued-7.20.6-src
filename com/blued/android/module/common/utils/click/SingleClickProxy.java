package com.blued.android.module.common.utils.click;

import android.view.View;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/click/SingleClickProxy.class */
public class SingleClickProxy implements View.OnClickListener {
    private View.OnClickListener a;
    private long b;
    private long c;
    private IClickAgain d;

    public SingleClickProxy(View.OnClickListener onClickListener) {
        this.b = 0L;
        this.c = 500L;
        this.a = onClickListener;
    }

    public SingleClickProxy(View.OnClickListener onClickListener, long j, IClickAgain iClickAgain) {
        this.b = 0L;
        this.c = 500L;
        this.a = onClickListener;
        this.d = iClickAgain;
        this.c = j;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (System.currentTimeMillis() - this.b >= this.c) {
            this.a.onClick(view);
            this.b = System.currentTimeMillis();
            return;
        }
        IClickAgain iClickAgain = this.d;
        if (iClickAgain != null) {
            iClickAgain.onAgain();
        }
    }
}
