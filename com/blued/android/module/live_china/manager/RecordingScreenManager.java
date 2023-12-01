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

    /* renamed from: a  reason: collision with root package name */
    private RecordingOnliveFragment f13816a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private View f13817c;
    private View d;
    private View e;

    public RecordingScreenManager(RecordingOnliveFragment recordingOnliveFragment) {
        this.f13816a = recordingOnliveFragment;
        this.b = recordingOnliveFragment.getContext();
        this.f13817c = recordingOnliveFragment.b;
        this.f13816a.U();
        if (!LiveRoomManager.a().J()) {
            h();
        } else if (this.f13816a.x) {
            this.f13816a.getActivity().setRequestedOrientation(0);
        } else {
            m();
        }
        this.f13816a.ab();
    }

    private void m() {
        h();
        if (LiveRoomManager.a().J()) {
            if (this.f13816a.aB != null) {
                this.f13816a.aB.setVisibility(8);
            }
            RecordingOnliveFragment recordingOnliveFragment = this.f13816a;
            recordingOnliveFragment.a(recordingOnliveFragment.ag);
            this.f13816a.F_();
        }
        AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.live_china.manager.RecordingScreenManager.1
            @Override // java.lang.Runnable
            public void run() {
                if (RecordingScreenManager.this.f13816a.ac != null) {
                    RecordingScreenManager.this.f13816a.ac.d();
                }
                RecordingScreenManager.this.f13816a.a(AppInfo.l, AppInfo.m, false, 0);
                RecordingScreenManager.this.f13816a.L.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                RecordingScreenManager.this.f13816a.L.setBackgroundResource(R.color.black);
            }
        });
    }

    @Override // com.blued.android.module.live_china.live_interface.IScreenManager
    public void a() {
        if (this.f13816a.bz == 2) {
            return;
        }
        Logger.a("drb", "切换横屏");
        LiveFloatManager.a().d(true);
        j();
        this.f13816a.V();
        this.f13816a.bg();
        this.f13816a.dd.b();
        k();
        if (LiveRoomManager.a().J()) {
            if (this.f13816a.aB != null) {
                this.f13816a.aB.setVisibility(8);
            }
            RecordingOnliveFragment recordingOnliveFragment = this.f13816a;
            recordingOnliveFragment.a(recordingOnliveFragment.ag);
            this.f13816a.F_();
        } else if (this.f13816a.aB != null) {
            this.f13816a.aB.setVisibility(0);
        }
        this.f13816a.dd.h();
        LiveRoomUtils.a(this.f13816a.getFragmentActive(), "1");
        BeansRefreshObserver.a().a(this.f13816a.f13405ar, this.f13816a.as);
        this.f13816a.bz = 2;
        this.f13816a.N_();
        this.f13816a.g_(8);
    }

    @Override // com.blued.android.module.live_china.live_interface.IScreenManager
    public void b() {
        if (this.f13816a.bz == 1) {
            return;
        }
        Logger.a("drb", "切换竖屏");
        LiveFloatManager.a().d(false);
        i();
        this.f13816a.V();
        this.f13816a.bg();
        this.f13816a.dd.b();
        l();
        if (this.f13816a.aB != null) {
            this.f13816a.aB.setVisibility(8);
        }
        if (LiveRoomManager.a().J()) {
            RecordingOnliveFragment recordingOnliveFragment = this.f13816a;
            recordingOnliveFragment.a(recordingOnliveFragment.ag);
            this.f13816a.F_();
        }
        this.f13816a.dd.h();
        LiveRoomUtils.a(this.f13816a.getFragmentActive(), "1");
        BeansRefreshObserver.a().a(this.f13816a.f13405ar, this.f13816a.as);
        this.f13816a.bz = 1;
        this.f13816a.W();
        this.f13816a.N_();
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
        this.f13816a.V();
        this.f13816a.bg();
        if (this.f13816a.aB != null) {
            this.f13816a.aB.setVisibility(0);
        }
        this.f13816a.bz = 0;
    }

    public void i() {
        LogUtils.c("initVerticalRootView");
        this.f13816a.bx.removeAllViews();
        if (this.d == null) {
            this.d = LayoutInflater.from(this.b).inflate(R.layout.fragment_record_onlive_portrait, (ViewGroup) null);
        }
        this.f13816a.bx.addView(this.d);
    }

    public void j() {
        LogUtils.c("initHorizontalRootView");
        this.f13816a.bx.removeAllViews();
        if (this.e == null) {
            this.e = LayoutInflater.from(this.b).inflate(R.layout.fragment_record_onlive_land, (ViewGroup) null);
        }
        this.f13816a.bx.addView(this.e);
    }

    public void k() {
        this.f13816a.a(AppInfo.m, AppInfo.l, true, 1);
        if (this.f13816a.ac != null) {
            this.f13816a.ac.d();
        }
        this.f13816a.L.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    public void l() {
        AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.live_china.manager.RecordingScreenManager.2
            @Override // java.lang.Runnable
            public void run() {
                if (LiveFloatManager.a().C()) {
                    return;
                }
                Logger.a("ddrb", "--- setVerticalPlayer");
                if (RecordingScreenManager.this.f13816a.ac != null) {
                    RecordingScreenManager.this.f13816a.ac.d();
                }
                RecordingScreenManager.this.f13816a.a(AppInfo.l, (AppInfo.l / 16) * 9, false, 1);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                layoutParams.topMargin = DensityUtils.a(RecordingScreenManager.this.b, 120.0f);
                RecordingScreenManager.this.f13816a.L.setLayoutParams(layoutParams);
                RecordingScreenManager.this.f13816a.L.setBackgroundResource(R.color.black);
            }
        });
    }
}
