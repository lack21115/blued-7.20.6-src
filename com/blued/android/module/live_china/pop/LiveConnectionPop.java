package com.blued.android.module.live_china.pop;

import android.view.MotionEvent;
import android.view.View;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.ui.xpop.core.AttachPopupView;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/pop/LiveConnectionPop.class */
public class LiveConnectionPop extends AttachPopupView {
    private int t;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A() {
        if (t()) {
            return;
        }
        p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        p();
        EventTrackLive.b(LiveProtos.Event.LIVE_MANY_CONNECT_TIPS_CLICK, LiveRoomManager.a().e());
        LiveEventBus.get("live_center").post(true);
    }

    @Override // com.blued.android.framework.ui.xpop.core.AttachPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public void b() {
        super.b();
        View findViewById = findViewById(R.id.rl_root);
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.pop.LiveConnectionPop.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    LiveConnectionPop.this.z();
                }
            });
        }
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.pop.-$$Lambda$LiveConnectionPop$PXXy8PvRMGJWItWTzz-SUzlI9mo
            @Override // java.lang.Runnable
            public final void run() {
                LiveConnectionPop.this.A();
            }
        }, this.t);
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getImplLayoutId() {
        return R.layout.pop_live_connection;
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        z();
        return false;
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public void u() {
        super.u();
    }
}
