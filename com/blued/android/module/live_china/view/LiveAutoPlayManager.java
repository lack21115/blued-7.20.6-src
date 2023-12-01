package com.blued.android.module.live_china.view;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.blued.android.chat.data.EntranceData;
import com.blued.android.chat.data.JoinLiveResult;
import com.blued.android.chat.data.LiveChatInitData;
import com.blued.android.chat.data.LiveChatStatistics;
import com.blued.android.chat.data.LiveCloseReason;
import com.blued.android.chat.data.LiveEnterFailedReason;
import com.blued.android.chat.data.ProfileData;
import com.blued.android.chat.listener.LiveChatInfoListener;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.AesCrypto;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.observer.LiveSysNetworkObserver;
import com.blued.android.module.live_china.view.LiveAutoPlayer;
import com.blued.android.module.player.txplayer.view.BlLiveView;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveAutoPlayManager.class */
public class LiveAutoPlayManager implements LiveChatInfoListener, LiveSysNetworkObserver.ILiveSysNetworkObserver {
    private static volatile LiveAutoPlayManager b;
    public BlLiveView a;
    private LiveAutoPlayer c;
    private String d;
    private LiveRoomData g;
    private String h;
    private LiveChatInitData i;
    private OnMediaPlayerConnectListener j;
    private LiveEnterFailedReason q;
    private int r;
    private int s;
    private int t;
    private int u;
    private Handler v;
    private short e = 4;
    private long f = -1;
    private int k = 1;
    private Reconnect l = new Reconnect();
    private boolean m = false;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;
    private LiveAutoPlayer.LiveAutoPlayerListener w = new LiveAutoPlayer.LiveAutoPlayerListener() { // from class: com.blued.android.module.live_china.view.LiveAutoPlayManager.1
        @Override // com.blued.android.module.live_china.view.LiveAutoPlayer.LiveAutoPlayerListener
        public void a() {
            Logger.b("LiveAutoPlayManager", "onMediaBufferStart");
            LiveAutoPlayManager.this.h();
        }

        @Override // com.blued.android.module.live_china.view.LiveAutoPlayer.LiveAutoPlayerListener
        public void a(int i, int i2) {
            LiveAutoPlayManager.this.r = i;
            LiveAutoPlayManager.this.s = i2;
        }

        @Override // com.blued.android.module.live_china.view.LiveAutoPlayer.LiveAutoPlayerListener
        public void a(Bitmap bitmap) {
            if (LiveAutoPlayManager.this.j != null) {
                LiveAutoPlayManager.this.j.a(bitmap);
            }
        }

        @Override // com.blued.android.module.live_china.view.LiveAutoPlayer.LiveAutoPlayerListener
        public void b() {
            Logger.b("LiveAutoPlayManager", "onMediaBufferEnd");
            LiveAutoPlayManager.this.j();
        }

        @Override // com.blued.android.module.live_china.view.LiveAutoPlayer.LiveAutoPlayerListener
        public void c() {
            Logger.b("LiveAutoPlayManager", "onMediaVideoStart");
            LiveAutoPlayManager.this.j();
            if (LiveAutoPlayManager.this.j != null) {
                LiveAutoPlayManager.this.j.a();
            }
        }

        @Override // com.blued.android.module.live_china.view.LiveAutoPlayer.LiveAutoPlayerListener
        public void d() {
            if (LiveAutoPlayManager.this.n) {
                return;
            }
            LiveAutoPlayManager.this.c();
        }

        @Override // com.blued.android.module.live_china.view.LiveAutoPlayer.LiveAutoPlayerListener
        public void e() {
            if (LiveAutoPlayManager.this.n) {
                return;
            }
            LiveAutoPlayManager.this.c();
        }
    };

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveAutoPlayManager$OnMediaPlayerConnectListener.class */
    public interface OnMediaPlayerConnectListener {
        void a();

        void a(Bitmap bitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveAutoPlayManager$Reconnect.class */
    public class Reconnect implements Runnable {
        private Reconnect() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LiveAutoPlayManager.this.c.e();
        }
    }

    private LiveAutoPlayManager() {
        p();
        this.v = new Handler(Looper.getMainLooper());
        LiveAutoPlayer liveAutoPlayer = new LiveAutoPlayer();
        this.c = liveAutoPlayer;
        liveAutoPlayer.a(this.w);
    }

    public static LiveAutoPlayManager a() {
        if (b == null) {
            synchronized (LiveAutoPlayManager.class) {
                try {
                    if (b == null) {
                        b = new LiveAutoPlayManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    private void a(LiveRoomData liveRoomData, String str) {
        if (liveRoomData == null) {
            Logger.b("LiveAutoPlayManager", "initLiveData discard, liveRoomData is null");
            return;
        }
        this.g = liveRoomData;
        this.h = str;
        String str2 = liveRoomData.live_url;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            String e = AesCrypto.e(str2);
            this.d = e;
            a(e, this.g, this.h);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(String str, LiveRoomData liveRoomData, String str2) {
        synchronized (this) {
            Logger.b("LiveAutoPlayManager", "initMediaPlayer");
            if (this.c.a()) {
                n();
            }
            this.d = str;
            this.k = 1;
            this.f = liveRoomData.lid;
            this.g = liveRoomData;
            this.h = str2;
            this.o = false;
            this.p = false;
            this.n = false;
            this.q = null;
            this.v.removeCallbacks(this.l);
            m();
            h();
            LiveSysNetworkObserver.a().a(this);
        }
    }

    public static LiveAutoPlayManager b() {
        return new LiveAutoPlayManager();
    }

    private void m() {
        synchronized (this) {
            Logger.b("LiveAutoPlayManager", "prepare mVideoPath = ", this.d);
            if (TextUtils.isEmpty(this.d)) {
                Logger.b("LiveAutoPlayManager", "prepare mVideoPath empty");
                return;
            }
            try {
                if (this.c.a()) {
                    o();
                }
                this.c.a(this.d, this.a);
                Logger.a("LiveAutoPlayManager", "prepare prepareAsync");
            } catch (Exception e) {
                n();
                e.printStackTrace();
            }
        }
    }

    private void n() {
        synchronized (this) {
            Logger.b("LiveAutoPlayManager", "release");
            o();
            LiveSysNetworkObserver.a().b(this);
            this.v.removeCallbacks(this.l);
            h();
            this.g = null;
            this.i = null;
            this.f = -1L;
            this.e = (short) 0;
            this.k = 1;
            this.o = false;
            this.p = false;
            this.m = false;
            this.n = false;
            this.q = null;
            this.d = null;
            this.r = 0;
            this.s = 0;
            this.h = "";
        }
    }

    private void o() {
        synchronized (this) {
            Logger.b("LiveAutoPlayManager", "setMediaEmpty");
            this.g = null;
            if (this.c.b()) {
                this.c.f();
            }
        }
    }

    private void p() {
        synchronized (this) {
            this.a = new BlLiveView(AppInfo.d());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public void t() {
        synchronized (this) {
            if (this.r != 0 && this.s != 0 && this.t != 0 && this.u != 0) {
                float min = Math.min(this.r / this.t, this.s / this.u);
                Logger.b("LiveAutoPlayManager", "====ratio:", Float.valueOf(min));
                this.t = (int) Math.ceil(this.r / min);
                this.u = (int) Math.ceil(this.s / min);
            }
            Logger.b("LiveAutoPlayManager", "after data: mVideoWidth:", Integer.valueOf(this.r), "   mVideoHeight:", Integer.valueOf(this.s), " mSurfaceWidth:", Integer.valueOf(this.t), "   mSurfaceHeight:", Integer.valueOf(this.u));
            r();
        }
    }

    private void r() {
        synchronized (this) {
            AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveAutoPlayManager$VctCGirlX_zPtARIpNFQE7ZQwko
                @Override // java.lang.Runnable
                public final void run() {
                    LiveAutoPlayManager.this.u();
                }
            });
        }
    }

    private BlLiveView s() {
        BlLiveView blLiveView;
        synchronized (this) {
            if (this.a != null) {
                ViewParent parent = this.a.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(this.a);
                }
            }
            Logger.a("LiveAutoPlayManager", "getSurfaceView");
            blLiveView = this.a;
        }
        return blLiveView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u() {
        BlLiveView blLiveView = this.a;
        if (blLiveView != null) {
            FrameLayout.LayoutParams layoutParams = blLiveView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(this.t, this.u);
            } else {
                layoutParams.width = this.t;
                layoutParams.height = this.u;
            }
            this.a.setLayoutParams(layoutParams);
            Logger.a("LiveAutoPlayManager", "setSurfaceParams");
        }
    }

    @Override // com.blued.android.module.live_china.observer.LiveSysNetworkObserver.ILiveSysNetworkObserver
    public void O() {
        Logger.b("LiveAutoPlayManager", "wifi disconnect");
        f();
        s();
    }

    public void a(LiveRoomData liveRoomData, String str, FrameLayout frameLayout, int i, int i2) {
        synchronized (this) {
            Logger.b("LiveAutoPlayManager", "autoPlay:" + liveRoomData.lid);
            if (LiveFloatManager.a().H()) {
                Logger.b("LiveAutoPlayManager", "float window is playing, discard!");
            } else if (this.g != null && TextUtils.equals(liveRoomData.live_url, this.g.live_url) && this.c.b()) {
                Logger.b("LiveAutoPlayManager", "already auto play, discard!");
            } else {
                View s = s();
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(1, 1);
                layoutParams.gravity = 17;
                frameLayout.addView(s, layoutParams);
                if (this.a == null) {
                    return;
                }
                Logger.b("LiveAutoPlayManager", "autoPlay prepare:" + liveRoomData.lid);
                this.t = i;
                this.u = i2;
                a(liveRoomData, str);
                e();
            }
        }
    }

    public void a(OnMediaPlayerConnectListener onMediaPlayerConnectListener) {
        this.j = onMediaPlayerConnectListener;
    }

    public void c() {
        h();
        int i = this.k;
        if (i >= 10) {
            i();
            return;
        }
        this.k = i + 1;
        d();
    }

    public void d() {
        this.v.removeCallbacks(this.l);
        this.v.postDelayed(this.l, 3000L);
    }

    public void e() {
        synchronized (this) {
            this.c.c();
        }
    }

    public void f() {
        synchronized (this) {
            Logger.b("LiveAutoPlayManager", "pause");
            this.c.d();
        }
    }

    public long g() {
        return this.f;
    }

    public void h() {
        synchronized (this) {
            Logger.b("LiveAutoPlayManager", "setLiveLoading");
            this.o = false;
            this.p = false;
        }
    }

    public void i() {
        synchronized (this) {
            Logger.b("LiveAutoPlayManager", "setLiveLoadFail");
            this.o = false;
            this.p = true;
            this.v.removeCallbacks(this.l);
        }
    }

    public void j() {
        synchronized (this) {
            Logger.b("LiveAutoPlayManager", "setLiveLoadSuccess");
            this.o = true;
            this.p = false;
            this.k = 1;
            this.v.removeCallbacks(this.l);
            this.v.postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveAutoPlayManager$0i-1jCPfV2L26iE-rr730_puFY8
                @Override // java.lang.Runnable
                public final void run() {
                    LiveAutoPlayManager.this.t();
                }
            }, 300L);
        }
    }

    public void k() {
        synchronized (this) {
            Logger.b("LiveAutoPlayManager", "setLiveLoadOver");
            this.o = false;
            this.p = false;
            o();
            this.v.removeCallbacks(this.l);
        }
    }

    public boolean l() {
        return this.c.b();
    }

    @Override // com.blued.android.chat.listener.LiveChatInfoListener
    public void onClose(LiveCloseReason liveCloseReason, LiveChatStatistics liveChatStatistics) {
        Logger.b("LiveAutoPlayManager", "onClose");
        this.q = LiveEnterFailedReason.LIVEROOM_CLOSE;
        this.n = true;
        k();
    }

    @Override // com.blued.android.chat.listener.LiveChatInfoListener
    public void onJoinLive(JoinLiveResult joinLiveResult, String str, String str2, String str3) {
    }

    @Override // com.blued.android.chat.listener.LiveChatInfoListener
    public void onRecvNewMsg(ChattingModel chattingModel) {
    }

    @Override // com.blued.android.chat.listener.LiveChatInfoListener
    public void onViewerDataChanged(long j, List<ProfileData> list) {
    }

    @Override // com.blued.android.chat.listener.LiveChatInfoListener
    public void onViewerEntrance(EntranceData entranceData, long j) {
    }
}
