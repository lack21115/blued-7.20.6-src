package com.tencent.cloud.huiyansdkface.facelight.common;

import com.anythink.expressad.d.a.b;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/common/WbTimer.class */
public class WbTimer {

    /* renamed from: a  reason: collision with root package name */
    private Timer f35597a = new Timer();
    private boolean b;

    public void cancel() {
        WLogger.d("WbTimer", b.dO);
        this.b = true;
        Timer timer = this.f35597a;
        if (timer != null) {
            timer.cancel();
            this.f35597a = null;
        }
    }

    public boolean isCancel() {
        return this.b;
    }

    public void reset() {
        WLogger.d("WbTimer", "reset");
        this.b = false;
        if (this.f35597a == null) {
            this.f35597a = new Timer();
        }
    }

    public void scheduleAtFixedRate(TimerTask timerTask, long j, long j2) {
        if (this.b) {
            WLogger.d("WbTimer", "timer cancelled,no need go on.");
        } else {
            this.f35597a.scheduleAtFixedRate(timerTask, j, j2);
        }
    }
}
