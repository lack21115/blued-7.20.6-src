package com.blued.android.module.live_china.manager;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.blued.android.core.AppInfo;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment;
import com.blued.android.module.live_china.live_interface.IScreenManager;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.blued.android.module.live_china.view.LiveCueView;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/PlayingModelManager.class */
public class PlayingModelManager implements IScreenManager {

    /* renamed from: a  reason: collision with root package name */
    private PlayingOnliveBaseModeFragment f13683a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private View f13684c;
    private View d;
    private View e;

    public PlayingModelManager(PlayingOnliveBaseModeFragment playingOnliveBaseModeFragment) {
        this.f13683a = playingOnliveBaseModeFragment;
        this.b = playingOnliveBaseModeFragment.getContext();
        this.f13684c = playingOnliveBaseModeFragment.b;
        h();
    }

    private void a(int i) {
        this.f13683a.ai = i;
        LiveRefreshUIObserver.a().c(i);
    }

    private void k() {
        if (LiveRoomPreferences.z()) {
            return;
        }
        LiveRoomPreferences.b(true);
        LiveCueView.a(this.b, "", 21, 0, 16, 10, 0, false, R.drawable.live_switch_clear_tips, 5000);
    }

    @Override // com.blued.android.module.live_china.live_interface.IScreenManager
    public void a() {
        if (this.f13683a.ai != 3 && this.f13683a.ai != 4) {
            j();
            this.f13683a.f();
            this.f13683a.q.b();
        }
        this.f13683a.a(LiveRoomManager.a().p());
        a(2);
        this.f13683a.al.setVisibility(0);
        if (this.f13683a.h != null) {
            this.f13683a.h.setVisibility(0);
        }
        if (this.f13683a.aJ != null) {
            this.f13683a.aJ.setVisibility(0);
        }
        if (this.f13683a.an != null) {
            this.f13683a.an.setVisibility(0);
        }
        this.f13683a.am.setVisibility(0);
        this.f13683a.l.setVisibility(0);
        this.f13683a.f(0);
        this.f13683a.X.setVisibility(0);
        this.f13683a.ae.setVisibility(0);
        this.f13683a.ad.setVisibility(0);
        this.f13683a.I.setVisibility(0);
        this.f13683a.af.setVisibility(8);
        this.f13683a.q.c(true);
        this.f13683a.q.d(0);
        this.f13683a.q.a(0);
        this.f13683a.q.i();
        k();
        AppInfo.n().removeCallbacks(this.f13683a.as);
        AppInfo.n().postDelayed(this.f13683a.as, 5000L);
    }

    @Override // com.blued.android.module.live_china.live_interface.IScreenManager
    public void b() {
        Logger.a("rrb", " %%%%%%%%%%%switchVerticalScreen mCurrentModel = ", Integer.valueOf(this.f13683a.ai));
        if (this.f13683a.ai == 1) {
            return;
        }
        a(1);
        i();
        this.f13683a.f();
        this.f13683a.q.b();
        this.f13683a.ac.setVisibility(0);
        this.f13683a.q.i();
        this.f13683a.n();
        AppInfo.n().removeCallbacks(this.f13683a.as);
    }

    @Override // com.blued.android.module.live_china.live_interface.IScreenManager
    public void c() {
        if (this.f13683a.ai == 3) {
            return;
        }
        this.f13683a.al.setVisibility(4);
        if (this.f13683a.h != null) {
            this.f13683a.h.setVisibility(4);
        }
        if (this.f13683a.aJ != null) {
            this.f13683a.aJ.setVisibility(8);
        }
        if (this.f13683a.an != null) {
            this.f13683a.an.setVisibility(4);
        }
        this.f13683a.am.setVisibility(4);
        this.f13683a.l.setVisibility(4);
        this.f13683a.f(8);
        this.f13683a.q.c(false);
        a(3);
    }

    @Override // com.blued.android.module.live_china.live_interface.IScreenManager
    public void d() {
        this.f13683a.al.setVisibility(4);
        if (this.f13683a.h != null) {
            this.f13683a.h.setVisibility(4);
        }
        if (this.f13683a.aJ != null) {
            this.f13683a.aJ.setVisibility(8);
        }
        if (this.f13683a.an != null) {
            this.f13683a.an.setVisibility(4);
        }
        this.f13683a.am.setVisibility(4);
        this.f13683a.l.setVisibility(4);
        this.f13683a.ae.setVisibility(8);
        this.f13683a.ad.setVisibility(8);
        this.f13683a.I.setVisibility(8);
        this.f13683a.af.setVisibility(0);
        this.f13683a.q.d(8);
        this.f13683a.q.a(8);
        a(4);
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
        this.f13683a.f();
        a(0);
    }

    public void i() {
        Logger.a("drb", "mRootView = ", this.f13684c);
        this.f13683a.aa = (FrameLayout) this.f13684c.findViewById(R.id.switch_orientation_layout);
        if (this.d != null && this.f13683a.aa.getChildCount() > 0 && this.f13683a.aa.getChildAt(0) == this.d) {
            Log.i("drb", "initVerticalRootView return");
            return;
        }
        this.f13683a.aa.removeAllViews();
        if (this.d == null) {
            this.d = LayoutInflater.from(this.b).inflate(R.layout.fragment_play_onlive_portrait, (ViewGroup) null);
        }
        this.f13683a.aa.addView(this.d);
    }

    public void j() {
        this.f13683a.aa = (FrameLayout) this.f13684c.findViewById(R.id.switch_orientation_layout);
        if (this.e != null && this.f13683a.aa.getChildCount() > 0 && this.f13683a.aa.getChildAt(0) == this.e) {
            Log.i("drb", "initHorizontalRootView return");
            return;
        }
        this.f13683a.aa.removeAllViews();
        if (this.e == null) {
            this.e = LayoutInflater.from(this.b).inflate(R.layout.fragment_play_onlive_land, (ViewGroup) null);
        }
        this.f13683a.aa.addView(this.e);
    }
}
