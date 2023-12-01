package com.blued.android.module.live_china.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.manager.LiveMakeLoverManager;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.presenter.LiveMakeLoverApplyGuestPresent;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveMakeLoverApplyGuestFragment.class */
public class LiveMakeLoverApplyGuestFragment extends MvpFragment<LiveMakeLoverApplyGuestPresent> implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    View f13021a;
    TextView b;

    /* renamed from: c  reason: collision with root package name */
    View f13022c;
    View d;
    View e;
    View f;
    ViewPager g;
    View k;
    View l;
    View m;
    TextView n;
    private Dialog o;
    private MyAdapter q;
    private long r;
    private String s;
    private CountDownTimer t;
    private boolean u;
    private int p = 1;
    private boolean v = false;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveMakeLoverApplyGuestFragment$MyAdapter.class */
    public class MyAdapter extends FragmentPagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        FragmentManager f13024a;

        public MyAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.f13024a = fragmentManager;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            super.destroyItem(viewGroup, i, obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return LiveMakeLoverApplyGuestFragment.this.p;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            if (i != 0) {
                return null;
            }
            Bundle bundle = new Bundle();
            LiveMakeLoverApplyMemberFragment liveMakeLoverApplyMemberFragment = new LiveMakeLoverApplyMemberFragment();
            bundle.putString("uid", LiveMakeLoverApplyGuestFragment.this.s);
            bundle.putLong("lid", LiveMakeLoverApplyGuestFragment.this.r);
            bundle.putString("type", "1");
            liveMakeLoverApplyMemberFragment.setArguments(bundle);
            return liveMakeLoverApplyMemberFragment;
        }
    }

    private void A() {
        this.f13021a = this.i.findViewById(R.id.empty_view);
        this.b = (TextView) this.i.findViewById(R.id.tv_title);
        this.f13022c = this.i.findViewById(R.id.ll_apply);
        this.d = this.i.findViewById(R.id.tv_apply_selected);
        this.e = this.i.findViewById(R.id.tv_apply_select);
        this.f = this.i.findViewById(R.id.tv_apply_cancel);
        this.g = (ViewPager) this.i.findViewById(R.id.view_pager);
        this.k = this.i.findViewById(R.id.fl_time);
        this.l = this.i.findViewById(R.id.tv_time_cancel);
        this.m = this.i.findViewById(R.id.tv_time_start);
        this.n = (TextView) this.i.findViewById(R.id.tv_time);
        this.o = DialogUtils.a(getContext());
        this.q = new MyAdapter(getChildFragmentManager());
        if (LiveMakeLoverManager.a() == 1 || LiveMakeLoverManager.a() == 2) {
            this.g.setAdapter(this.q);
            this.g.setCurrentItem(0);
        }
        B();
    }

    private void B() {
        if (LiveMakeLoverManager.a() == 1) {
            this.u = false;
            this.f13022c.setVisibility(0);
            this.k.setVisibility(8);
            this.d.setVisibility(0);
            this.e.setVisibility(0);
            this.f.setVisibility(8);
            this.b.setText(R.string.live_make_friend_apply);
            this.d.setOnClickListener(this);
            this.e.setOnClickListener(this);
            this.f13021a.setOnClickListener(this);
        } else if (LiveMakeLoverManager.a() == 2) {
            this.u = false;
            this.f13022c.setVisibility(0);
            this.k.setVisibility(8);
            this.d.setVisibility(8);
            this.e.setVisibility(8);
            this.f.setVisibility(0);
            this.b.setText(R.string.live_make_lover_apply_wait);
            this.f.setOnClickListener(this);
            this.f13021a.setOnClickListener(this);
        } else if (LiveMakeLoverManager.a() == 3) {
            this.u = false;
            this.v = true;
            LiveMakeLoverDialogFragment y = y();
            if (y != null && y.getDialog() != null) {
                y.getDialog().setCancelable(false);
                y.getDialog().setCanceledOnTouchOutside(false);
            }
            this.f13021a.setOnClickListener(null);
            this.f13022c.setVisibility(8);
            this.k.setVisibility(0);
            this.l.setOnClickListener(this);
            this.m.setOnClickListener(this);
            this.b.setText(R.string.live_make_lover_apply_pass);
            b();
        }
    }

    private void z() {
        if (getArguments() != null) {
            this.s = getArguments().getString("uid");
            this.r = getArguments().getLong("lid");
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        A();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void a(String str, boolean z) {
        super.a(str, z);
        Log.i("==makelover", "dismissDataLoading:" + str);
        DialogUtils.b(this.o);
        if (str == "LIVE_MAKE_LOVER_APPLY") {
            if (z) {
                LiveMakeLoverManager.a(2);
                B();
                LiveMakeLoverApplyMemberFragment x = x();
                if (x != null) {
                    x.b();
                }
            }
        } else if (str == "LIVE_MAKE_LOVER_CANCEL") {
            if (z) {
                LiveMakeLoverManager.a(1);
            }
            w();
        } else if (str == "LIVE_MAKE_LOVER_START") {
            this.v = false;
            LiveMakeLoverManager.a(1);
            w();
        } else if (str == "LIVE_MAKE_LOVER_REFUSE") {
            this.v = false;
            LiveMakeLoverManager.a(1);
            w();
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void af_() {
        super.af_();
    }

    public void b() {
        c();
        this.t = new CountDownTimer(5000L, 500L) { // from class: com.blued.android.module.live_china.fragment.LiveMakeLoverApplyGuestFragment.1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                LiveMakeLoverApplyGuestFragment.this.d();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                TextView textView = LiveMakeLoverApplyGuestFragment.this.n;
                textView.setText(((j / 1000) + 1) + ExifInterface.LATITUDE_SOUTH);
            }
        }.start();
    }

    public void b(boolean z) {
        if (LiveMakeLoverManager.a() == 3) {
            return;
        }
        if (z) {
            if (LiveMakeLoverManager.a() == 1) {
                LiveMakeLoverManager.a(2);
                Log.i("==makelover==", "reset apply LOVER_WAIT_MODEL ");
                B();
            }
        } else if (LiveMakeLoverManager.a() == 2) {
            LiveMakeLoverManager.a(1);
            Log.i("==makelover==", "reset apply LOVER_APPLY_MODEL ");
            B();
        }
    }

    public void c() {
        CountDownTimer countDownTimer = this.t;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public void d() {
        if (this.u) {
            return;
        }
        this.u = true;
        c();
        j().d(String.valueOf(this.r));
    }

    public void e() {
        if (this.u) {
            return;
        }
        this.u = true;
        c();
        j().e(String.valueOf(this.r));
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.fragment_live_make_lover_guest_apply;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void g_(String str) {
        super.g_(str);
        Log.i("==makelover", "showDataLoading:" + str);
        DialogUtils.a(this.o);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void o() {
        super.o();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == R.id.tv_apply_selected) {
            EventTrackLive.a(LiveProtos.Event.USER_CONNECT_APPLY_BE_PICKED_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
            j().a(String.valueOf(this.r), "0");
        } else if (id == R.id.tv_apply_select) {
            EventTrackLive.a(LiveProtos.Event.USER_CONNECT_APPLY_TO_PICK_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
            j().a(String.valueOf(this.r), "1");
        } else if (id == R.id.tv_apply_cancel) {
            e();
        } else if (id == R.id.empty_view) {
            w();
        } else if (id == R.id.tv_time_cancel) {
            EventTrackLive.a(LiveProtos.Event.USER_CANCEL_MIKE_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
            v();
        } else if (id == R.id.tv_time_start) {
            EventTrackLive.a(LiveProtos.Event.USER_START_MIKE_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
            d();
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        z();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        c();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.v) {
            LiveMakeLoverManager.a(1);
            v();
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void p() {
        super.p();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
    }

    public void v() {
        if (this.u) {
            return;
        }
        this.u = true;
        c();
        j().f(String.valueOf(this.r));
    }

    public void w() {
        c();
        LiveMakeLoverDialogFragment y = y();
        if (y != null) {
            y.dismiss();
        }
    }

    public LiveMakeLoverApplyMemberFragment x() {
        if (getChildFragmentManager() == null || getChildFragmentManager().getFragments() == null || getChildFragmentManager().getFragments().size() <= 0 || !(getChildFragmentManager().getFragments().get(0) instanceof LiveMakeLoverApplyMemberFragment)) {
            return null;
        }
        return (LiveMakeLoverApplyMemberFragment) getChildFragmentManager().getFragments().get(0);
    }

    public LiveMakeLoverDialogFragment y() {
        if (getParentFragment() instanceof LiveMakeLoverDialogFragment) {
            return (LiveMakeLoverDialogFragment) getParentFragment();
        }
        return null;
    }
}
