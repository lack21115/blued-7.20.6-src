package com.blued.android.module.live_china.fragment;

import android.content.Context;
import android.os.BatteryManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.chat.core.pack.ReqAckPackage;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.adapter.LiveFansPrivilegeAdapater;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveFansInfoModel;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.observer.LiveFansObserver;
import com.blued.android.module.live_china.pop.LiveFansGroupPop;
import com.blued.android.module.live_china.presenter.LiveFansGuestPresent;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.module.live_china.view.LiveFansProgressView;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveFansGuestFragment.class */
public class LiveFansGuestFragment extends MvpFragment<LiveFansGuestPresent> implements View.OnClickListener {
    TextView A;
    TextView B;
    TextView C;
    TextView D;
    TextView E;
    LiveFansProgressView F;
    TextView G;
    ViewPager H;
    View I;
    View J;
    View K;
    View L;
    View M;
    View N;
    TextView O;
    TextView P;
    TextView Q;
    ImageView R;
    ProgressBar S;
    private long T;
    private String U;
    private int V;
    private short X;
    private LiveFansInfoModel Y;
    private LiveGiftModel Z;

    /* renamed from: a  reason: collision with root package name */
    View f12851a;
    private Context aa;
    private MyAdapter ac;
    View b;

    /* renamed from: c  reason: collision with root package name */
    View f12852c;
    View d;
    TextView e;
    TextView f;
    View g;
    View k;
    View l;
    View m;
    View n;
    View o;
    ImageView p;
    RecyclerView q;
    View r;
    TextView s;
    View t;
    View u;
    View v;
    View w;
    ImageView x;
    TextView y;
    View z;
    private boolean W = false;
    private List<Fragment> ab = new ArrayList();

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveFansGuestFragment$MyAdapter.class */
    public class MyAdapter extends FragmentPagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        FragmentManager f12854a;

        public MyAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.f12854a = fragmentManager;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            super.destroyItem(viewGroup, i, obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return LiveFansGuestFragment.this.ab.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            if (i < LiveFansGuestFragment.this.ab.size()) {
                return (Fragment) LiveFansGuestFragment.this.ab.get(i);
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (i == 0) {
            this.O.setTextColor(getResources().getColor(R.color.syc_dark_h));
            this.P.setTextColor(getResources().getColor(R.color.syc_dark_k));
            this.Q.setTextColor(getResources().getColor(R.color.syc_dark_k));
            this.O.setTextSize(2, 15.0f);
            this.P.setTextSize(2, 13.0f);
            this.Q.setTextSize(2, 13.0f);
            this.L.setVisibility(0);
            this.M.setVisibility(8);
            this.N.setVisibility(8);
            this.R.setVisibility(8);
        } else if (i == 1) {
            this.O.setTextColor(getResources().getColor(R.color.syc_dark_k));
            this.P.setTextColor(getResources().getColor(R.color.syc_dark_h));
            this.Q.setTextColor(getResources().getColor(R.color.syc_dark_k));
            this.O.setTextSize(2, 13.0f);
            this.P.setTextSize(2, 15.0f);
            this.Q.setTextSize(2, 13.0f);
            this.L.setVisibility(8);
            this.M.setVisibility(0);
            this.N.setVisibility(8);
            this.R.setVisibility(8);
        } else if (i == 2) {
            this.O.setTextColor(getResources().getColor(R.color.syc_dark_k));
            this.P.setTextColor(getResources().getColor(R.color.syc_dark_k));
            this.Q.setTextColor(getResources().getColor(R.color.syc_dark_h));
            this.O.setTextSize(2, 13.0f);
            this.P.setTextSize(2, 13.0f);
            this.Q.setTextSize(2, 15.0f);
            this.L.setVisibility(8);
            this.M.setVisibility(8);
            this.N.setVisibility(0);
            this.R.setVisibility(0);
        }
    }

    private void a(final String str, final int i) {
        this.y.setText(String.format(getString(R.string.live_fans_not_add_tip_1_1), str, Integer.valueOf(i)));
        if (str.length() < 5) {
            return;
        }
        this.y.post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveFansGuestFragment$Vq99PpomooKIGG5LXP2meXFb4_w
            @Override // java.lang.Runnable
            public final void run() {
                LiveFansGuestFragment.this.b(str, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        this.H.setCurrentItem(i);
    }

    private void b(LiveFansInfoModel liveFansInfoModel) {
        EventTrackLive.a(LiveProtos.Event.FANS_CLUB_PAGE_NO_JOIN_PAGE_SHOW, String.valueOf(this.T), LiveRoomInfo.a().f());
        this.f12851a.setVisibility(0);
        this.e.setText(liveFansInfoModel.anchor_name);
        this.f.setText(String.format(getString(R.string.live_fans_not_add_tip_1), Integer.valueOf(liveFansInfoModel.member_total)));
        this.m.setVisibility(8);
        this.o.setVisibility(0);
        this.v.setVisibility(8);
        this.t.setVisibility(8);
        this.l.setVisibility(8);
        this.q.setLayoutManager(new GridLayoutManager(this.aa, 3));
        this.q.setAdapter(new LiveFansPrivilegeAdapater(this.aa, 1));
        this.r.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(String str, int i) {
        int i2 = 1;
        if (this.y.getLineCount() > 1) {
            if (str.endsWith("…")) {
                i2 = 2;
            }
            a(str.substring(0, str.length() - i2) + "…", i);
        }
    }

    private void c(LiveFansInfoModel liveFansInfoModel) {
        this.f12851a.setVisibility(0);
        this.e.setText(liveFansInfoModel.anchor_name);
        this.f.setText(String.format(getString(R.string.live_fans_not_add_tip_1), Integer.valueOf(liveFansInfoModel.member_total)));
        TextView textView = this.C;
        textView.setText(liveFansInfoModel.level + "");
        this.D.setText(liveFansInfoModel.name);
        this.m.setVisibility(8);
        this.o.setVisibility(8);
        this.v.setVisibility(8);
        this.t.setVisibility(0);
        this.l.setVisibility(8);
        this.u.setOnClickListener(this);
    }

    private void d() {
        if (getArguments() != null) {
            this.U = getArguments().getString("uid");
            this.T = getArguments().getLong("lid");
            this.V = getArguments().getInt(BatteryManager.EXTRA_LEVEL);
            this.W = getArguments().getBoolean("DefaultTagFansGroup", false);
            this.X = getArguments().getShort(ReqAckPackage.REQ_RESPONSE_KEY.SESSION_TYPE);
        }
    }

    private void d(LiveFansInfoModel liveFansInfoModel) {
        EventTrackLive.a(LiveProtos.Event.FANS_CLUB_PAGE_JOIN_PAGE_SHOW, String.valueOf(this.T), LiveRoomInfo.a().f());
        this.f12851a.setVisibility(8);
        a(liveFansInfoModel.anchor_name, liveFansInfoModel.member_total);
        this.m.setVisibility(8);
        this.o.setVisibility(8);
        this.v.setVisibility(0);
        this.t.setVisibility(8);
        this.l.setVisibility(8);
        this.A.setText(liveFansInfoModel.level_next + "");
        this.B.setText(liveFansInfoModel.name);
        int i = 1;
        this.B.getPaint().setFakeBoldText(true);
        this.A.getPaint().setFakeBoldText(true);
        this.E.setText(String.format(getString(R.string.live_fans_relation_day_top), Integer.valueOf(liveFansInfoModel.relation_limit)));
        this.F.setLevel(liveFansInfoModel);
        this.G.setText(String.format(getString(R.string.live_fans_relation_all_level_info), Integer.valueOf(liveFansInfoModel.relation), Integer.valueOf(liveFansInfoModel.next_level_relation - liveFansInfoModel.relation)));
        MyAdapter myAdapter = new MyAdapter(getChildFragmentManager());
        this.ac = myAdapter;
        this.H.setAdapter(myAdapter);
        this.H.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.blued.android.module.live_china.fragment.LiveFansGuestFragment.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i3) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                LiveFansGuestFragment.this.a(!LiveRoomManager.a().U() ? i2 + 1 : i2);
                LiveFansGuestFragment.this.b(i2);
            }
        });
        ViewPager viewPager = this.H;
        if (this.W) {
            i = 2;
        }
        viewPager.setCurrentItem(i);
        x();
    }

    private void e() {
        this.f12851a = this.i.findViewById(R.id.ll_fans_title);
        this.b = this.i.findViewById(R.id.empty_view);
        this.f12852c = this.i.findViewById(R.id.iv_fans_member);
        this.d = this.i.findViewById(R.id.iv_fans_member_back);
        this.e = (TextView) this.i.findViewById(R.id.tv_fans_title);
        this.f = (TextView) this.i.findViewById(R.id.tv_fans_num);
        this.g = this.i.findViewById(R.id.iv_fans_edit);
        this.k = this.i.findViewById(R.id.iv_fans_qa);
        this.l = this.i.findViewById(R.id.ll_fans_error);
        this.m = this.i.findViewById(R.id.ll_fans_disopen);
        this.n = this.i.findViewById(R.id.tv_fans_open);
        this.o = this.i.findViewById(R.id.ll_not_add);
        this.p = (ImageView) this.i.findViewById(R.id.iv_ticket);
        this.q = (RecyclerView) this.i.findViewById(R.id.rv_privilege);
        this.r = this.i.findViewById(R.id.tv_fans_add);
        this.s = (TextView) this.i.findViewById(R.id.tv_ticket_num);
        this.t = this.i.findViewById(R.id.ll_re_open);
        this.u = this.i.findViewById(R.id.tv_fans_re_open);
        this.v = this.i.findViewById(R.id.ll_fans_added);
        this.w = this.i.findViewById(R.id.ll_level);
        this.x = (ImageView) this.i.findViewById(R.id.iv_heart);
        this.y = (TextView) this.i.findViewById(R.id.tv_fans_added_title);
        this.z = this.i.findViewById(R.id.iv_fans_added_qa);
        this.A = (TextView) this.i.findViewById(R.id.tv_level_num);
        this.B = (TextView) this.i.findViewById(R.id.tv_fans_name);
        this.C = (TextView) this.i.findViewById(R.id.tv_disopen_level_num);
        this.D = (TextView) this.i.findViewById(R.id.tv_disopen_fans_name);
        this.E = (TextView) this.i.findViewById(R.id.tv_bar_day_tip);
        this.F = (LiveFansProgressView) this.i.findViewById(R.id.bar_fans);
        this.G = (TextView) this.i.findViewById(R.id.tv_bar_tip);
        this.H = (ViewPager) this.i.findViewById(R.id.view_pager);
        this.I = this.i.findViewById(R.id.ll_tab_rank);
        this.J = this.i.findViewById(R.id.ll_tab_task);
        this.K = this.i.findViewById(R.id.ll_tab_group);
        if (LiveRoomManager.a().U()) {
            this.I.setVisibility(0);
        } else {
            this.I.setVisibility(8);
        }
        this.O = (TextView) this.i.findViewById(R.id.tv_rank);
        this.P = (TextView) this.i.findViewById(R.id.tv_task);
        this.Q = (TextView) this.i.findViewById(R.id.tv_group);
        this.L = this.i.findViewById(R.id.line_rank);
        this.M = this.i.findViewById(R.id.line_task);
        this.N = this.i.findViewById(R.id.line_group);
        this.R = (ImageView) this.i.findViewById(R.id.iv_group_qa);
        this.S = (ProgressBar) this.i.findViewById(R.id.loading_view);
        this.f12852c.setVisibility(0);
        this.f12852c.setOnClickListener(this);
        this.d.setVisibility(8);
        this.m.setVisibility(8);
        this.o.setVisibility(8);
        this.v.setVisibility(8);
        this.t.setVisibility(8);
        this.l.setVisibility(8);
        this.I.setOnClickListener(this);
        this.J.setOnClickListener(this);
        this.K.setOnClickListener(this);
        this.k.setOnClickListener(this);
        this.z.setOnClickListener(this);
        this.b.setOnClickListener(this);
        this.R.setOnClickListener(this);
        b(false);
        if (LiveRoomManager.a().s()) {
            j().a(this.U, this.T);
            j().m();
            return;
        }
        EventTrackLive.a(LiveProtos.Event.FANS_CLUB_PAGE_NO_FIVE_PAGE_SHOW, String.valueOf(this.T), LiveRoomInfo.a().f());
        v();
    }

    private void v() {
        this.f12851a.setVisibility(0);
        this.f12852c.setVisibility(8);
        this.d.setVisibility(8);
        this.e.setVisibility(8);
        this.g.setVisibility(8);
        this.m.setVisibility(0);
        this.o.setVisibility(8);
        this.v.setVisibility(8);
        this.t.setVisibility(8);
        this.l.setVisibility(8);
        this.n.setOnClickListener(this);
    }

    private void w() {
        this.f12851a.setVisibility(0);
        this.f12852c.setVisibility(8);
        this.d.setVisibility(8);
        this.e.setVisibility(8);
        this.g.setVisibility(8);
        this.m.setVisibility(8);
        this.o.setVisibility(8);
        this.v.setVisibility(8);
        this.t.setVisibility(8);
        this.l.setVisibility(0);
    }

    private void x() {
        this.ab.clear();
        if (LiveRoomManager.a().U()) {
            Bundle bundle = new Bundle();
            bundle.putLong("lid", this.T);
            bundle.putInt("from", 1);
            LiveFansMemberFragment liveFansMemberFragment = new LiveFansMemberFragment();
            liveFansMemberFragment.setArguments(bundle);
            this.ab.add(liveFansMemberFragment);
        }
        LiveFansTaskFragment liveFansTaskFragment = new LiveFansTaskFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putSerializable("liveFansInfo", this.Y);
        bundle2.putLong("lid", this.T);
        bundle2.putString("uid", this.U);
        liveFansTaskFragment.setArguments(bundle2);
        this.ab.add(liveFansTaskFragment);
        this.K.setVisibility(0);
        this.ab.add(new LiveFansGroupPlayingFrahment());
        this.ac.notifyDataSetChanged();
        if (LiveRoomManager.a().U()) {
            a(0);
        } else {
            a(1);
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        e();
    }

    public void a(LiveFansInfoModel liveFansInfoModel) {
        if (liveFansInfoModel == null) {
            return;
        }
        this.Y = liveFansInfoModel;
        if (liveFansInfoModel.fans_status == 0) {
            b(liveFansInfoModel);
        } else if (liveFansInfoModel.fans_status == 1) {
            d(liveFansInfoModel);
        } else if (liveFansInfoModel.fans_status == 2) {
            c(liveFansInfoModel);
        }
        b(liveFansInfoModel.fans_status == 1);
        if (b() != null) {
            for (Fragment fragment : b().getChildFragmentManager().getFragments()) {
                if (fragment instanceof LiveFansMemberFragment) {
                    ((LiveFansMemberFragment) fragment).a(liveFansInfoModel);
                }
            }
        }
    }

    public void a(LiveGiftModel liveGiftModel) {
        Log.i("ddrb", "setLiveFansAdded");
        LiveEventBus.get("live_fans_added").post("");
        j().a(this.U, this.T);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void a(String str, boolean z) {
        super.a(str, z);
        this.S.setVisibility(8);
        if (str != "LIVE_FANS_INFO" || z) {
            return;
        }
        w();
    }

    public LiveFansGuestDialogFragment b() {
        if (getParentFragment() instanceof LiveFansGuestDialogFragment) {
            return (LiveFansGuestDialogFragment) getParentFragment();
        }
        return null;
    }

    public void b(LiveGiftModel liveGiftModel) {
        this.Z = liveGiftModel;
        if (liveGiftModel == null) {
            return;
        }
        ImageLoader.a(getFragmentActive(), liveGiftModel.images_static).a(this.p);
        this.s.setText(String.format(getString(R.string.live_fans_beans), String.valueOf(this.Z.beans)));
    }

    public void b(boolean z) {
        if (b() != null) {
            b().b(z ? AppInfo.m : DensityUtils.a(getContext(), 380.0f));
        }
    }

    public void c() {
        if (b() != null) {
            b().dismiss();
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.live_fans_view;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void g_(String str) {
        super.g_(str);
        this.S.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LiveFansGuestDialogFragment liveFansGuestDialogFragment;
        Tracker.onClick(view);
        int id = view.getId();
        if (id == R.id.iv_fans_member) {
            if (!(getParentFragment() instanceof LiveFansGuestDialogFragment) || (liveFansGuestDialogFragment = (LiveFansGuestDialogFragment) getParentFragment()) == null) {
                return;
            }
            liveFansGuestDialogFragment.a(1);
        } else if (id == R.id.tv_fans_open) {
            EventTrackLive.a(LiveProtos.Event.FANS_CLUB_PAGE_NO_FIVE_PAGE_GLOW_STICK_CLICK, String.valueOf(this.T), LiveRoomInfo.a().f());
            if (b() != null) {
                b().dismiss();
            }
            LiveFansObserver.a().c();
        } else if (id == R.id.tv_fans_add) {
            EventTrackLive.a(LiveProtos.Event.FANS_CLUB_PAGE_NO_JOIN_PAGE_SEND_JOIN_CLICK, String.valueOf(this.T), LiveRoomInfo.a().f());
            if (this.Z != null) {
                j().a(getFragmentManager(), this.T, this.X, this.U, this.Z);
            }
        } else if (id == R.id.tv_fans_re_open) {
            if (b() != null) {
                b().dismiss();
            }
            LiveFansObserver.a().c();
        } else if (id == R.id.iv_fans_qa || id == R.id.iv_fans_added_qa) {
            if (b() != null) {
                b().d();
            }
        } else if (id == R.id.empty_view) {
            if (b() != null) {
                b().dismiss();
            }
        } else if (id == R.id.ll_tab_rank) {
            EventTrackLive.a(LiveProtos.Event.LIVE_FANS_LIST_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
            a(0);
            b(0);
        } else if (id == R.id.ll_tab_task) {
            EventTrackLive.a(LiveProtos.Event.LIVE_FANS_TASK_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
            a(1);
            if (LiveRoomManager.a().U()) {
                b(1);
            } else {
                b(0);
            }
        } else if (id != R.id.ll_tab_group) {
            if (id == R.id.iv_group_qa) {
                new LiveFansGroupPop(getContext()).b(this.R);
            }
        } else {
            EventTrackLive.a(LiveProtos.Event.LIVE_USER_FANS_CLUB_PAGE_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
            a(2);
            if (LiveRoomManager.a().U()) {
                b(2);
            } else {
                b(1);
            }
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.aa = getContext();
        d();
    }
}
