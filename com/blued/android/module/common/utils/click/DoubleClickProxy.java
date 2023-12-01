package com.blued.android.module.common.utils.click;

import android.os.SystemClock;
import android.view.View;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.LogUtils;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/click/DoubleClickProxy.class */
public class DoubleClickProxy implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private View.OnClickListener f10920a;
    private IClickAgain d;
    private long b = 0;

    /* renamed from: c  reason: collision with root package name */
    private long f10921c = 300;
    private Runnable e = new Runnable() { // from class: com.blued.android.module.common.utils.click.DoubleClickProxy.1
        @Override // java.lang.Runnable
        public void run() {
            if (SystemClock.elapsedRealtime() - DoubleClickProxy.this.b > DoubleClickProxy.this.f10921c) {
                if (DoubleClickProxy.this.f10920a != null) {
                    DoubleClickProxy.this.f10920a.onClick(null);
                }
                LogUtils.c("origin.onClick()");
                DoubleClickProxy.this.b = 0L;
            }
        }
    };

    public DoubleClickProxy(View.OnClickListener onClickListener, IClickAgain iClickAgain) {
        this.f10920a = onClickListener;
        this.d = iClickAgain;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        AppInfo.n().removeCallbacks(this.e);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        LogUtils.c("onClick: " + (elapsedRealtime - this.b));
        if (elapsedRealtime - this.b >= this.f10921c) {
            this.b = elapsedRealtime;
            AppInfo.n().postDelayed(this.e, this.f10921c);
            return;
        }
        LogUtils.c("mIAgain.onAgain()");
        this.b = 0L;
        AppInfo.n().removeCallbacks(this.e);
        IClickAgain iClickAgain = this.d;
        if (iClickAgain != null) {
            iClickAgain.onAgain();
        }
    }
}
