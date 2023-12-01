package com.blued.android.module.live_china.manager;

import android.os.Handler;
import android.util.Log;
import com.blued.android.core.AppInfo;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.observer.LiveRelationshipObserver;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.utils.log.InstantLog;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/LiveGuideManager.class */
public class LiveGuideManager implements LiveRelationshipObserver.ILiveRelationshipObserver {
    private PlayingOnliveFragment e;
    private boolean i;
    private boolean b = true;
    private boolean c = true;
    private Handler d = new Handler();
    private ChatCardTask f = new ChatCardTask();
    private AttentionCardTask g = new AttentionCardTask();
    private boolean h = true;
    private long j = 3600000;
    Runnable a = new Runnable() { // from class: com.blued.android.module.live_china.manager.LiveGuideManager.1
        @Override // java.lang.Runnable
        public void run() {
            Log.i("xpm", "startTimerForSayHello 2");
            LiveMsgSendManager.a().j();
            LiveGuideManager.this.d.postDelayed(LiveGuideManager.this.a, LiveGuideManager.this.j);
        }
    };

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/LiveGuideManager$AttentionCardTask.class */
    class AttentionCardTask implements Runnable {
        AttentionCardTask() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (LiveGuideManager.this.i) {
                return;
            }
            LiveMsgSendManager.a().h();
            InstantLog.a("live_follow_guide_show");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/LiveGuideManager$ChatCardTask.class */
    public class ChatCardTask implements Runnable {
        ChatCardTask() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (LiveGuideManager.this.b) {
                LiveMsgSendManager.a().i();
                InstantLog.a("live_chat_guide_show");
                if (LiveGuideManager.this.h) {
                    LiveGuideManager.this.h = false;
                    LiveSetDataObserver.a().k();
                }
            }
        }
    }

    public LiveGuideManager(PlayingOnliveFragment playingOnliveFragment) {
        this.e = playingOnliveFragment;
        Logger.a("rrb", "--------开始倒计时-------");
        this.d.postDelayed(this.f, 60000L);
        this.d.postDelayed(this.f, 300000L);
        this.d.postDelayed(this.f, 900000L);
        this.d.postDelayed(this.g, 240000L);
        LiveRelationshipObserver.a().a(this);
        this.d.postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.manager.-$$Lambda$LiveGuideManager$x5D_qglXwpDgwLUm-wL2GnNsDdU
            @Override // java.lang.Runnable
            public final void run() {
                LiveGuideManager.this.c();
            }
        }, 8500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        a(LiveRoomManager.a().p().elapse_time);
    }

    public void a() {
        this.b = false;
        AppInfo.n().removeCallbacks(this.f);
    }

    public void a(long j) {
        Log.i("xpm", "startTimerForSayHello");
        this.d.removeCallbacks(this.a);
        if (j * 1000 > this.j) {
            Log.i("xpm", "startTimerForSayHello 1");
            LiveMsgSendManager.a().j();
            this.d.postDelayed(this.a, this.j);
        }
    }

    public void b() {
        this.d.removeCallbacksAndMessages(null);
        LiveRelationshipObserver.a().b(this);
    }

    @Override // com.blued.android.module.live_china.observer.LiveRelationshipObserver.ILiveRelationshipObserver
    public void b(String str, String str2) {
        if (CommonStringUtils.c(str2) == LiveRoomManager.a().f()) {
            if ("1".equals(str) || "3".equals(str)) {
                this.i = true;
            } else {
                this.i = false;
            }
        }
    }
}
