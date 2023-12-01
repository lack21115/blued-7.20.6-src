package com.blued.android.module.live_china.manager;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.live_interface.IScreenManager;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.utils.LiveRoomUtils;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/PlayingScreenManager.class */
public class PlayingScreenManager implements IScreenManager {
    private PlayingOnliveFragment a;
    private Context b;
    private View c;

    public PlayingScreenManager(PlayingOnliveFragment playingOnliveFragment) {
        this.a = playingOnliveFragment;
        this.c = playingOnliveFragment.b;
        this.b = playingOnliveFragment.getContext();
        h();
    }

    private void m() {
        AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.live_china.manager.PlayingScreenManager.4
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr = new int[2];
                PlayingScreenManager.this.a.N.getLocationOnScreen(iArr);
                int i = iArr[0];
                int i2 = iArr[1];
                LiveSetDataObserver.a().a(i, i2, PlayingScreenManager.this.a.N.getMeasuredWidth() + i, PlayingScreenManager.this.a.N.getMeasuredHeight() + i2);
            }
        });
    }

    private void n() {
        int i = AppInfo.l;
        int i2 = (int) (i * PlayingMakeFriendManager.d);
        LiveFloatManager.a().a(i, i2);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i2);
        layoutParams.topMargin = PlayingMakeFriendManager.b;
        Log.v("pk", "layoutParams.topMargin:" + layoutParams.topMargin);
        Log.v("pk", "layoutParams.topMargin:" + PlayingMakeFriendManager.b);
        this.a.N.setLayoutParams(layoutParams);
    }

    private void o() {
        int i = AppInfo.l;
        int i2 = (i * 2) / 3;
        LiveFloatManager.a().a(i, i2);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i2);
        layoutParams.topMargin = PlayingMakeLoverManager.d;
        Log.v("lover", "layoutParams.topMargin:" + layoutParams.topMargin);
        Log.v("lover", "layoutParams.topMargin:" + PlayingMakeLoverManager.d);
        this.a.N.setLayoutParams(layoutParams);
    }

    @Override // com.blued.android.module.live_china.live_interface.IScreenManager
    public void a() {
        Logger.a("rrb", "PlayingScreenManager 切换横屏模式");
        LiveFloatManager.a().d(true);
        i();
        this.a.c.setShakeWidth(DensityUtils.a(this.b, 50.0f));
        this.a.cA = 1;
        this.a.aP.notifyDataSetChanged();
        this.a.A();
        this.a.g_(8);
        LiveRoomUtils.a(this.a.getFragmentActive(), "1");
        m();
        LiveSetDataObserver.a().a(this.a.J);
        LiveSetDataObserver.a().u();
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.manager.PlayingScreenManager.2
            @Override // java.lang.Runnable
            public void run() {
                PlayingScreenManager.this.a.aU.a(false);
            }
        }, 100L);
    }

    @Override // com.blued.android.module.live_china.live_interface.IScreenManager
    public void b() {
        LiveFloatManager.a().d(false);
        j();
        this.a.c.setShakeWidth(DensityUtils.a(this.b, 65.0f));
        this.a.cA = 2;
        this.a.aP.notifyDataSetChanged();
        this.a.A();
        this.a.g_(0);
        LiveRoomUtils.a(this.a.getFragmentActive(), "1");
        LiveSetDataObserver.a().m();
        m();
        LiveSetDataObserver.a().a(this.a.J);
        LiveSetDataObserver.a().u();
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.manager.PlayingScreenManager.3
            @Override // java.lang.Runnable
            public void run() {
                PlayingScreenManager.this.a.aU.a(true);
            }
        }, 500L);
    }

    @Override // com.blued.android.module.live_china.live_interface.IScreenManager
    public void c() {
    }

    @Override // com.blued.android.module.live_china.live_interface.IScreenManager
    public void d() {
    }

    @Override // com.blued.android.module.live_china.live_interface.IScreenManager
    public void e() {
        l();
    }

    @Override // com.blued.android.module.live_china.live_interface.IScreenManager
    public void f() {
        n();
    }

    @Override // com.blued.android.module.live_china.live_interface.IScreenManager
    public void g() {
        o();
    }

    public void h() {
        LiveFloatManager.a().d(false);
        k();
        this.a.c.setShakeWidth(DensityUtils.a(this.b, 65.0f));
        this.a.g_(0);
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.manager.PlayingScreenManager.1
            @Override // java.lang.Runnable
            public void run() {
                PlayingScreenManager.this.a.aU.a(true);
            }
        }, 500L);
    }

    public void i() {
        LiveFloatManager.a().a(AppInfo.m, AppInfo.l);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(AppInfo.m, AppInfo.l);
        layoutParams.gravity = 17;
        this.a.N.setLayoutParams(layoutParams);
    }

    public void j() {
        Logger.a("rrb", "竖屏模式播放器");
        LiveFloatManager.a().a(AppInfo.l, (AppInfo.l / 16) * 9);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = DensityUtils.a(this.b, 120.0f);
        this.a.N.setLayoutParams(layoutParams);
    }

    public void k() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        if (LiveFloatManager.a().P() == null) {
            LiveFloatManager.a().J();
        }
        this.a.N.addView(LiveFloatManager.a().P(), layoutParams);
        LiveFloatManager.a().a(AppInfo.l, this.a.bc());
    }

    public void l() {
        int i = ((AppInfo.l / 2) / 3) * 4;
        LiveFloatManager.a().a(AppInfo.l, i);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(AppInfo.l, i);
        layoutParams.topMargin = PlayingMakeFriendManager.b;
        this.a.N.setLayoutParams(layoutParams);
    }
}
