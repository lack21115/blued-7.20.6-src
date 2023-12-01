package com.blued.android.module.live_china.fragment;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.presenter.LiveMakeLoverApplyRecordPresent;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveMakeLoverApplyRecordFragment.class */
public class LiveMakeLoverApplyRecordFragment extends MvpFragment<LiveMakeLoverApplyRecordPresent> implements View.OnClickListener {
    TextView a;
    ViewPager b;
    View c;
    TextView d;
    View e;
    View f;
    TextView g;
    View k;
    private MyAdapter m;
    private long n;
    private String o;
    private int l = 2;
    private int p = -1;
    private int q = -1;
    private ViewPager.OnPageChangeListener r = new ViewPager.OnPageChangeListener() { // from class: com.blued.android.module.live_china.fragment.LiveMakeLoverApplyRecordFragment.1
        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
            LiveMakeLoverApplyRecordFragment.this.a(i);
        }
    };

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveMakeLoverApplyRecordFragment$MyAdapter.class */
    public class MyAdapter extends FragmentPagerAdapter {
        FragmentManager a;

        public MyAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.a = fragmentManager;
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            super.destroyItem(viewGroup, i, obj);
        }

        public int getCount() {
            return LiveMakeLoverApplyRecordFragment.this.l;
        }

        public Fragment getItem(int i) {
            if (i == 0) {
                Bundle bundle = new Bundle();
                LiveMakeLoverApplyMemberFragment liveMakeLoverApplyMemberFragment = new LiveMakeLoverApplyMemberFragment();
                bundle.putString("uid", LiveMakeLoverApplyRecordFragment.this.o);
                bundle.putLong("lid", LiveMakeLoverApplyRecordFragment.this.n);
                bundle.putString("type", "2");
                liveMakeLoverApplyMemberFragment.setArguments(bundle);
                return liveMakeLoverApplyMemberFragment;
            } else if (i != 1) {
                return null;
            } else {
                Bundle bundle2 = new Bundle();
                LiveMakeLoverApplyMemberFragment liveMakeLoverApplyMemberFragment2 = new LiveMakeLoverApplyMemberFragment();
                bundle2.putString("uid", LiveMakeLoverApplyRecordFragment.this.o);
                bundle2.putLong("lid", LiveMakeLoverApplyRecordFragment.this.n);
                bundle2.putString("type", "3");
                liveMakeLoverApplyMemberFragment2.setArguments(bundle2);
                return liveMakeLoverApplyMemberFragment2;
            }
        }
    }

    private void c() {
        if (getArguments() != null) {
            this.o = getArguments().getString("uid");
            this.n = getArguments().getLong("lid");
        }
    }

    private void d() {
        this.a = (TextView) this.i.findViewById(R.id.tv_title);
        this.b = this.i.findViewById(R.id.view_pager);
        this.c = this.i.findViewById(R.id.ll_selected);
        this.d = (TextView) this.i.findViewById(R.id.tv_selected_title);
        this.e = this.i.findViewById(R.id.ll_selected_line);
        this.f = this.i.findViewById(R.id.ll_select);
        this.g = (TextView) this.i.findViewById(R.id.tv_selected_title);
        this.k = this.i.findViewById(R.id.ll_select_line);
        MyAdapter myAdapter = new MyAdapter(getChildFragmentManager());
        this.m = myAdapter;
        this.b.setAdapter(myAdapter);
        this.b.setOnPageChangeListener(this.r);
        this.c.setOnClickListener(this);
        this.f.setOnClickListener(this);
        a(0);
    }

    private void e() {
        int i;
        int i2 = this.p;
        if (i2 < 0 || (i = this.q) < 0) {
            return;
        }
        if (i2 > 0) {
            a(0);
        } else if (i > 0) {
            a(1);
        }
    }

    public void a(int i) {
        this.b.setCurrentItem(i);
        if (i == 0) {
            this.d.setTextColor(getResources().getColor(R.color.syc_dark_h));
            this.g.setTextColor(getResources().getColor(R.color.syc_dark_j));
            this.e.setVisibility(0);
            this.k.setVisibility(4);
        } else if (i == 1) {
            this.d.setTextColor(getResources().getColor(R.color.syc_dark_j));
            this.g.setTextColor(getResources().getColor(R.color.syc_dark_h));
            this.e.setVisibility(4);
            this.k.setVisibility(0);
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        d();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void a(String str, boolean z) {
        super.a(str, z);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void af_() {
        super.af_();
    }

    public LiveMakeLoverDialogFragment b() {
        if (getParentFragment() instanceof LiveMakeLoverDialogFragment) {
            return getParentFragment();
        }
        return null;
    }

    public void b(int i) {
        this.p = i;
        e();
    }

    public void c(int i) {
        this.q = i;
        e();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.fragment_live_make_lover_record_apply;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void g_(String str) {
        super.g_(str);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void o() {
        super.o();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == R.id.ll_selected) {
            EventTrackLive.b(LiveProtos.Event.ANCHOR_MIKE_MANAGE_BE_PICKED_CLICK, String.valueOf(this.n));
            a(0);
        } else if (id == R.id.ll_select) {
            EventTrackLive.b(LiveProtos.Event.ANCHOR_MIKE_MANAGE_TO_PICK_CLICK, String.valueOf(this.n));
            a(1);
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        c();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void p() {
        super.p();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
    }
}
