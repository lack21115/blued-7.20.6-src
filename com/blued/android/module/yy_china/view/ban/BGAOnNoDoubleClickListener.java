package com.blued.android.module.yy_china.view.ban;

import android.view.View;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/ban/BGAOnNoDoubleClickListener.class */
public abstract class BGAOnNoDoubleClickListener implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private int f18616a = 1000;
    private long b = 0;

    public abstract void a(View view);

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.b > this.f18616a) {
            this.b = currentTimeMillis;
            a(view);
        }
    }
}
