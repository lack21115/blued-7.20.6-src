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
    private PlayingOnliveBaseModeFragment a;
    private Context b;
    private View c;
    private View d;
    private View e;

    public PlayingModelManager(PlayingOnliveBaseModeFragment playingOnliveBaseModeFragment) {
        this.a = playingOnliveBaseModeFragment;
        this.b = playingOnliveBaseModeFragment.getContext();
        this.c = playingOnliveBaseModeFragment.b;
        h();
    }

    private void a(int i) {
        this.a.ai = i;
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
        if (this.a.ai != 3 && this.a.ai != 4) {
            j();
            this.a.f();
            this.a.q.b();
        }
        this.a.a(LiveRoomManager.a().p());
        a(2);
        this.a.al.setVisibility(0);
        if (this.a.h != null) {
            this.a.h.setVisibility(0);
        }
        if (this.a.aJ != null) {
            this.a.aJ.setVisibility(0);
        }
        if (this.a.an != null) {
            this.a.an.setVisibility(0);
        }
        this.a.am.setVisibility(0);
        this.a.l.setVisibility(0);
        this.a.f(0);
        this.a.X.setVisibility(0);
        this.a.ae.setVisibility(0);
        this.a.ad.setVisibility(0);
        this.a.I.setVisibility(0);
        this.a.af.setVisibility(8);
        this.a.q.c(true);
        this.a.q.d(0);
        this.a.q.a(0);
        this.a.q.i();
        k();
        AppInfo.n().removeCallbacks(this.a.as);
        AppInfo.n().postDelayed(this.a.as, 5000L);
    }

    @Override // com.blued.android.module.live_china.live_interface.IScreenManager
    public void b() {
        Logger.a("rrb", " %%%%%%%%%%%switchVerticalScreen mCurrentModel = ", Integer.valueOf(this.a.ai));
        if (this.a.ai == 1) {
            return;
        }
        a(1);
        i();
        this.a.f();
        this.a.q.b();
        this.a.ac.setVisibility(0);
        this.a.q.i();
        this.a.n();
        AppInfo.n().removeCallbacks(this.a.as);
    }

    @Override // com.blued.android.module.live_china.live_interface.IScreenManager
    public void c() {
        if (this.a.ai == 3) {
            return;
        }
        this.a.al.setVisibility(4);
        if (this.a.h != null) {
            this.a.h.setVisibility(4);
        }
        if (this.a.aJ != null) {
            this.a.aJ.setVisibility(8);
        }
        if (this.a.an != null) {
            this.a.an.setVisibility(4);
        }
        this.a.am.setVisibility(4);
        this.a.l.setVisibility(4);
        this.a.f(8);
        this.a.q.c(false);
        a(3);
    }

    @Override // com.blued.android.module.live_china.live_interface.IScreenManager
    public void d() {
        this.a.al.setVisibility(4);
        if (this.a.h != null) {
            this.a.h.setVisibility(4);
        }
        if (this.a.aJ != null) {
            this.a.aJ.setVisibility(8);
        }
        if (this.a.an != null) {
            this.a.an.setVisibility(4);
        }
        this.a.am.setVisibility(4);
        this.a.l.setVisibility(4);
        this.a.ae.setVisibility(8);
        this.a.ad.setVisibility(8);
        this.a.I.setVisibility(8);
        this.a.af.setVisibility(0);
        this.a.q.d(8);
        this.a.q.a(8);
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
        this.a.f();
        a(0);
    }

    public void i() {
        Logger.a("drb", "mRootView = ", this.c);
        this.a.aa = (FrameLayout) this.c.findViewById(R.id.switch_orientation_layout);
        if (this.d != null && this.a.aa.getChildCount() > 0 && this.a.aa.getChildAt(0) == this.d) {
            Log.i("drb", "initVerticalRootView return");
            return;
        }
        this.a.aa.removeAllViews();
        if (this.d == null) {
            this.d = LayoutInflater.from(this.b).inflate(R.layout.fragment_play_onlive_portrait, (ViewGroup) null);
        }
        this.a.aa.addView(this.d);
    }

    public void j() {
        this.a.aa = (FrameLayout) this.c.findViewById(R.id.switch_orientation_layout);
        if (this.e != null && this.a.aa.getChildCount() > 0 && this.a.aa.getChildAt(0) == this.e) {
            Log.i("drb", "initHorizontalRootView return");
            return;
        }
        this.a.aa.removeAllViews();
        if (this.e == null) {
            this.e = LayoutInflater.from(this.b).inflate(R.layout.fragment_play_onlive_land, (ViewGroup) null);
        }
        this.a.aa.addView(this.e);
    }
}
