package com.blued.android.module.live_china.manager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.live_interface.IScreenManager;
import com.blued.android.module.live_china.observer.BeansRefreshObserver;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.utils.LiveRoomUtils;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/RecordingScreenManager.class */
public class RecordingScreenManager implements IScreenManager {
    private RecordingOnliveFragment a;
    private Context b;
    private View c;
    private View d;
    private View e;

    public RecordingScreenManager(RecordingOnliveFragment recordingOnliveFragment) {
        this.a = recordingOnliveFragment;
        this.b = recordingOnliveFragment.getContext();
        this.c = recordingOnliveFragment.b;
        this.a.U();
        if (!LiveRoomManager.a().J()) {
            h();
        } else if (this.a.x) {
            this.a.getActivity().setRequestedOrientation(0);
        } else {
            m();
        }
        this.a.ab();
    }

    private void m() {
        h();
        if (LiveRoomManager.a().J()) {
            if (this.a.aB != null) {
                this.a.aB.setVisibility(8);
            }
            RecordingOnliveFragment recordingOnliveFragment = this.a;
            recordingOnliveFragment.a(recordingOnliveFragment.ag);
            this.a.F_();
        }
        AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.live_china.manager.RecordingScreenManager.1
            @Override // java.lang.Runnable
            public void run() {
                if (RecordingScreenManager.this.a.ac != null) {
                    RecordingScreenManager.this.a.ac.d();
                }
                RecordingScreenManager.this.a.a(AppInfo.l, AppInfo.m, false, 0);
                RecordingScreenManager.this.a.L.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                RecordingScreenManager.this.a.L.setBackgroundResource(R.color.black);
            }
        });
    }

    @Override // com.blued.android.module.live_china.live_interface.IScreenManager
    public void a() {
        if (this.a.bz == 2) {
            return;
        }
        Logger.a("drb", "切换横屏");
        LiveFloatManager.a().d(true);
        j();
        this.a.V();
        this.a.bg();
        this.a.dd.b();
        k();
        if (LiveRoomManager.a().J()) {
            if (this.a.aB != null) {
                this.a.aB.setVisibility(8);
            }
            RecordingOnliveFragment recordingOnliveFragment = this.a;
            recordingOnliveFragment.a(recordingOnliveFragment.ag);
            this.a.F_();
        } else if (this.a.aB != null) {
            this.a.aB.setVisibility(0);
        }
        this.a.dd.h();
        LiveRoomUtils.a(this.a.getFragmentActive(), "1");
        BeansRefreshObserver.a().a(this.a.ar, this.a.as);
        this.a.bz = 2;
        this.a.N_();
        this.a.g_(8);
    }

    @Override // com.blued.android.module.live_china.live_interface.IScreenManager
    public void b() {
        if (this.a.bz == 1) {
            return;
        }
        Logger.a("drb", "切换竖屏");
        LiveFloatManager.a().d(false);
        i();
        this.a.V();
        this.a.bg();
        this.a.dd.b();
        l();
        if (this.a.aB != null) {
            this.a.aB.setVisibility(8);
        }
        if (LiveRoomManager.a().J()) {
            RecordingOnliveFragment recordingOnliveFragment = this.a;
            recordingOnliveFragment.a(recordingOnliveFragment.ag);
            this.a.F_();
        }
        this.a.dd.h();
        LiveRoomUtils.a(this.a.getFragmentActive(), "1");
        BeansRefreshObserver.a().a(this.a.ar, this.a.as);
        this.a.bz = 1;
        this.a.W();
        this.a.N_();
    }

    @Override // com.blued.android.module.live_china.live_interface.IScreenManager
    public void c() {
    }

    @Override // com.blued.android.module.live_china.live_interface.IScreenManager
    public void d() {
    }

    @Override // com.blued.android.module.live_china.live_interface.IScreenManager
    public void e() {
    }

    @Override // com.blued.android.module.live_china.live_interface.IScreenManager
    public void f() {
    }

    @Override // com.blued.android.module.live_china.live_interface.IScreenManager
    public void g() {
    }

    public void h() {
        i();
        this.a.V();
        this.a.bg();
        if (this.a.aB != null) {
            this.a.aB.setVisibility(0);
        }
        this.a.bz = 0;
    }

    public void i() {
        LogUtils.c("initVerticalRootView");
        this.a.bx.removeAllViews();
        if (this.d == null) {
            this.d = LayoutInflater.from(this.b).inflate(R.layout.fragment_record_onlive_portrait, (ViewGroup) null);
        }
        this.a.bx.addView(this.d);
    }

    public void j() {
        LogUtils.c("initHorizontalRootView");
        this.a.bx.removeAllViews();
        if (this.e == null) {
            this.e = LayoutInflater.from(this.b).inflate(R.layout.fragment_record_onlive_land, (ViewGroup) null);
        }
        this.a.bx.addView(this.e);
    }

    public void k() {
        this.a.a(AppInfo.m, AppInfo.l, true, 1);
        if (this.a.ac != null) {
            this.a.ac.d();
        }
        this.a.L.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    public void l() {
        AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.live_china.manager.RecordingScreenManager.2
            @Override // java.lang.Runnable
            public void run() {
                if (LiveFloatManager.a().C()) {
                    return;
                }
                Logger.a("ddrb", "--- setVerticalPlayer");
                if (RecordingScreenManager.this.a.ac != null) {
                    RecordingScreenManager.this.a.ac.d();
                }
                RecordingScreenManager.this.a.a(AppInfo.l, (AppInfo.l / 16) * 9, false, 1);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                layoutParams.topMargin = DensityUtils.a(RecordingScreenManager.this.b, 120.0f);
                RecordingScreenManager.this.a.L.setLayoutParams(layoutParams);
                RecordingScreenManager.this.a.L.setBackgroundResource(R.color.black);
            }
        });
    }
}
