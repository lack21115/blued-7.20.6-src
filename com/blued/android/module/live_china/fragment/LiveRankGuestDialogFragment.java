package com.blued.android.module.live_china.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.ReflectionUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.LiveRankGuestDialogFragment;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveCloakingTypeModel;
import com.blued.android.module.live_china.rank.LiveRankDialogFragment;
import com.blued.android.module.live_china.same.tip.CommonAlertDialog;
import com.blued.android.module.live_china.utils.LiveCloakingUtil;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveRankGuestDialogFragment.class */
public class LiveRankGuestDialogFragment extends BaseDialogFragment {

    /* renamed from: a  reason: collision with root package name */
    public static String f13189a = "LID";
    public static String d = "IF_USER_ANCHOR";
    public static int e;
    private String B;
    private String C;
    private String D;
    private String E;
    public Context b;
    ILiveGuestDialog f;
    private View g;
    private View h;
    private View i;
    private View j;
    private View k;
    private TextView l;
    private TextView m;
    private ViewPager n;
    private MyAdapter o;
    private TextView p;
    private View q;
    private View r;
    private View s;
    private View t;
    private View u;
    private int v;
    private long w;
    private String x;
    private boolean y;
    private boolean z;

    /* renamed from: c  reason: collision with root package name */
    public int f13190c = 2;
    private List<Fragment> A = new ArrayList();
    private ViewPager.OnPageChangeListener F = new ViewPager.OnPageChangeListener() { // from class: com.blued.android.module.live_china.fragment.LiveRankGuestDialogFragment.1
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            LiveRankGuestDialogFragment.this.v = i;
            int i2 = LiveRankGuestDialogFragment.this.v;
            if (i2 == 0) {
                LiveRankGuestDialogFragment.this.f();
            } else if (i2 != 1) {
            } else {
                LiveRankGuestDialogFragment.this.g();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.module.live_china.fragment.LiveRankGuestDialogFragment$4  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveRankGuestDialogFragment$4.class */
    public class AnonymousClass4 extends BluedUIHttpResponse<BluedEntityA<LiveCloakingTypeModel>> {
        AnonymousClass4(IRequestHost iRequestHost) {
            super(iRequestHost);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(View view) {
            LiveRankGuestDialogFragment.this.j();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(View view) {
            LiveRankGuestDialogFragment.this.d();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<LiveCloakingTypeModel> bluedEntityA) {
            if (bluedEntityA == null || bluedEntityA.getSingleData() == null) {
                return;
            }
            LiveCloakingTypeModel singleData = bluedEntityA.getSingleData();
            LiveRankGuestDialogFragment.this.D = singleData.notice_text;
            LiveRankGuestDialogFragment.this.E = singleData.notice_title;
            boolean z = false;
            if (singleData.is_qualified != 1) {
                LiveRankGuestDialogFragment.this.g.setVisibility(8);
                if (TextUtils.isEmpty(LiveRankGuestDialogFragment.this.B)) {
                    return;
                }
                LiveRankGuestDialogFragment.this.j.setVisibility(0);
                return;
            }
            LiveRankGuestDialogFragment.this.g.setVisibility(0);
            LiveRankGuestDialogFragment.this.j.setVisibility(8);
            LiveRankGuestDialogFragment.this.h.setAlpha(singleData.privilege_status);
            View view = LiveRankGuestDialogFragment.this.h;
            if (singleData.privilege_status == 1) {
                z = true;
            }
            view.setTag(Boolean.valueOf(z));
            LiveRankGuestDialogFragment.this.h.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveRankGuestDialogFragment$4$ZucQGc35-q18KCNOSLBOXzT_gTM
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LiveRankGuestDialogFragment.AnonymousClass4.this.b(view2);
                }
            });
            LiveRankGuestDialogFragment.this.i.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveRankGuestDialogFragment$4$Aq5DRpQ4BnuSnxfZ5_SNOqjYSSo
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LiveRankGuestDialogFragment.AnonymousClass4.this.a(view2);
                }
            });
            LiveCloakingUtil.f14157a = LiveCloakingUtil.a(singleData);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public boolean onUIFailure(int i, String str) {
            return super.onUIFailure(i, str);
        }
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveRankGuestDialogFragment$ILiveGuestDialog.class */
    public interface ILiveGuestDialog {
        void r_();

        void s_();
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveRankGuestDialogFragment$MyAdapter.class */
    public class MyAdapter extends FragmentPagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        FragmentManager f13196a;

        public MyAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.f13196a = fragmentManager;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            super.destroyItem(viewGroup, i, obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return LiveRankGuestDialogFragment.this.A.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            if (i < LiveRankGuestDialogFragment.this.A.size()) {
                return (Fragment) LiveRankGuestDialogFragment.this.A.get(i);
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Boolean bool) {
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        k();
    }

    private void e() {
        if (getArguments() != null) {
            this.x = getArguments().getString("UID");
            this.w = getArguments().getLong(f13189a);
            this.z = getArguments().getBoolean(d);
            boolean z = getArguments().getBoolean("isMakeLover");
            this.y = z;
            if (z) {
                this.f13190c = 1;
            }
        }
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.r.setVisibility(0);
        this.s.setVisibility(8);
        this.l.setTextColor(this.b.getResources().getColor(R.color.syc_dark_0a0a0a));
        if (this.A.size() == 1) {
            e = 0;
        } else {
            e = 1;
        }
        this.m.setTextColor(this.b.getResources().getColor(R.color.syc_dark_767676));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.r.setVisibility(8);
        this.s.setVisibility(0);
        this.l.setTextColor(this.b.getResources().getColor(R.color.syc_dark_767676));
        if (this.A.size() == 1) {
            e = 0;
        } else {
            e = 1;
        }
        this.m.setTextColor(this.b.getResources().getColor(R.color.syc_dark_0a0a0a));
    }

    private void h() {
        if (LiveRoomManager.a().S()) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(LiveRankGuestFragment.f13197a, true);
            bundle.putString("UID", this.x);
            bundle.putLong(LiveRankGuestFragment.b, this.w);
            bundle.putBoolean(LiveRankGuestFragment.f13198c, this.z);
            LiveRankGuestFragment liveRankGuestFragment = new LiveRankGuestFragment();
            liveRankGuestFragment.setArguments(bundle);
            this.A.add(liveRankGuestFragment);
            this.t.setVisibility(0);
        } else {
            this.t.setVisibility(8);
        }
        if (LiveRoomManager.a().T()) {
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean(LiveRankGuestFragment.f13197a, false);
            bundle2.putString("UID", this.x);
            bundle2.putLong(LiveRankGuestFragment.b, this.w);
            bundle2.putBoolean(LiveRankGuestFragment.f13198c, this.z);
            LiveRankGuestFragment liveRankGuestFragment2 = new LiveRankGuestFragment();
            liveRankGuestFragment2.setArguments(bundle2);
            this.A.add(liveRankGuestFragment2);
            this.u.setVisibility(0);
        } else {
            this.u.setVisibility(8);
        }
        this.o.notifyDataSetChanged();
    }

    private void i() {
        if (this.z) {
            return;
        }
        LiveRoomHttpUtils.D(new AnonymousClass4(a()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (TextUtils.isEmpty(this.D)) {
            return;
        }
        CommonAlertDialog.a((Context) getActivity(), this.E, this.D, getString(R.string.common_ok), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null, 0, true);
    }

    private void k() {
        if (TextUtils.isEmpty(this.B)) {
            return;
        }
        CommonAlertDialog.a((Context) getActivity(), this.C, this.B, getString(R.string.live_window_indicate_know), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null, 0, true);
    }

    private void l() {
        LiveRankDialogFragment.f14067a.a(getChildFragmentManager(), 2);
    }

    public void a(ILiveGuestDialog iLiveGuestDialog) {
        this.f = iLiveGuestDialog;
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.B = str;
        this.C = str2;
        if (this.g.getVisibility() == 0) {
            this.j.setVisibility(8);
        } else {
            this.j.setVisibility(0);
        }
    }

    public void d() {
        boolean z = false;
        this.h.setClickable(false);
        int i = (this.h.getTag() != null && (this.h.getTag() instanceof Boolean) && ((Boolean) this.h.getTag()).booleanValue()) ? 0 : 1;
        LiveProtos.Event event = LiveProtos.Event.LIVE_HIDE_BTN_CLICK;
        String g = LiveRoomManager.a().g();
        String e2 = LiveRoomManager.a().e();
        if (i == 1) {
            z = true;
        }
        EventTrackLive.c(event, g, e2, z);
        final int i2 = i;
        LiveRoomHttpUtils.i(String.valueOf(i), new BluedUIHttpResponse<BluedEntityA<Object>>(a()) { // from class: com.blued.android.module.live_china.fragment.LiveRankGuestDialogFragment.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                int count;
                if (bluedEntityA.code == 200) {
                    LiveRankGuestDialogFragment.this.h.setTag(Boolean.valueOf(i2 == 1));
                    LiveCloakingUtil.f14157a = i2 == 1;
                    LiveRankGuestDialogFragment.this.h.animate().alpha(i2).setDuration(200L);
                    if (LiveRankGuestDialogFragment.this.o == null || (count = LiveRankGuestDialogFragment.this.o.getCount()) == 0) {
                        return;
                    }
                    for (int i3 = 0; i3 < count; i3++) {
                        Fragment item = LiveRankGuestDialogFragment.this.o.getItem(i3);
                        if (item != null && (item instanceof LiveRankGuestFragment)) {
                            ((LiveRankGuestFragment) item).b();
                        }
                    }
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                LiveRankGuestDialogFragment.this.h.setClickable(true);
            }
        });
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        this.b = getActivity();
        boolean C = LiveFloatManager.a().C();
        View inflate = getActivity().getLayoutInflater().inflate(C ? R.layout.dialog_live_rank_land : R.layout.dialog_live_rank, (ViewGroup) null);
        int a2 = DensityUtils.a(getActivity(), 360.0f);
        Dialog dialog = new Dialog(getActivity(), R.style.transparentFrameWindowStyleLive);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        if (C) {
            dialog.setContentView(inflate, new ViewGroup.LayoutParams(DensityUtils.a(getActivity(), 360.0f), -1));
        } else {
            dialog.setContentView(inflate, new ViewGroup.LayoutParams(-1, DensityUtils.a(getActivity(), 360.0f)));
        }
        Window window = dialog.getWindow();
        int height = getActivity().getWindowManager().getDefaultDisplay().getHeight();
        window.setWindowAnimations(C ? R.style.rank_menu_animstyle : R.style.main_menu_animstyle);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = 0;
        attributes.y = height - a2;
        attributes.width = C ? DensityUtils.a(getActivity(), 360.0f) : -1;
        attributes.height = C ? -1 : DensityUtils.a(getActivity(), 360.0f);
        attributes.gravity = 5;
        dialog.onWindowAttributesChanged(attributes);
        e();
        return dialog;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        View inflate = layoutInflater.inflate(R.layout.dialog_live_rank, viewGroup);
        this.g = inflate.findViewById(R.id.rl_cloaking_root);
        this.h = inflate.findViewById(R.id.iv_cloaking_open);
        this.i = inflate.findViewById(R.id.iv_cloaking_help);
        View findViewById = inflate.findViewById(R.id.iv_common_help);
        this.j = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveRankGuestDialogFragment$9L5hVe2NS9J3eCromDMuSE-fCXI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveRankGuestDialogFragment.this.b(view);
            }
        });
        View findViewById2 = inflate.findViewById(R.id.iv_station_all_rank);
        this.k = findViewById2;
        findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveRankGuestDialogFragment$O7E0Uu0fzdcEqPOfVPXk-fdSTYY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveRankGuestDialogFragment.this.a(view);
            }
        });
        this.p = (TextView) inflate.findViewById(R.id.tv_title);
        this.l = (TextView) inflate.findViewById(R.id.rank_popular);
        this.m = (TextView) inflate.findViewById(R.id.rank_money);
        this.t = inflate.findViewById(R.id.rank_popular_layout_id);
        this.u = inflate.findViewById(R.id.rank_money_layout_id);
        this.n = (ViewPager) inflate.findViewById(R.id.dialog_rank_viewpager);
        MyAdapter myAdapter = new MyAdapter(getChildFragmentManager());
        this.o = myAdapter;
        this.n.setAdapter(myAdapter);
        this.n.setOffscreenPageLimit(this.y ? 1 : 2);
        this.n.setOnPageChangeListener(this.F);
        this.q = inflate.findViewById(R.id.ll_rank);
        this.r = inflate.findViewById(R.id.rank_left_line);
        this.s = inflate.findViewById(R.id.rank_right_line);
        this.l.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.LiveRankGuestDialogFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                LiveRankGuestDialogFragment.this.n.setCurrentItem(0);
            }
        });
        this.m.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.LiveRankGuestDialogFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                LiveRankGuestDialogFragment.this.n.setCurrentItem(1);
            }
        });
        ILiveGuestDialog iLiveGuestDialog = this.f;
        if (iLiveGuestDialog != null) {
            iLiveGuestDialog.r_();
        }
        if (!LiveRoomManager.a().S() || !LiveRoomManager.a().T()) {
            e = 0;
        }
        h();
        int i = e;
        if (i == 0 || i == 1) {
            this.n.setCurrentItem(e);
            if (e == 0) {
                f();
            } else {
                g();
            }
        }
        if (this.y) {
            this.q.setVisibility(8);
            this.p.setText(R.string.live_rank_consumption_this_short);
        }
        LiveEventBus.get("live_rank_behalf_tips_show", Boolean.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveRankGuestDialogFragment$B6yNJ0YgBIOTFLDL1xs8bYxH4Hs
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveRankGuestDialogFragment.this.a((Boolean) obj);
            }
        });
        return inflate;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ILiveGuestDialog iLiveGuestDialog = this.f;
        if (iLiveGuestDialog != null) {
            iLiveGuestDialog.s_();
        }
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        if (LiveRoomManager.a().R()) {
            if (LiveRoomManager.a().S() || LiveRoomManager.a().T()) {
                EventTrackLive.a(LiveProtos.Event.LIVE_FANS_LIST_PAGE_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
                try {
                    ReflectionUtils.a(this, "mDismissed", false);
                    ReflectionUtils.a(this, "mShownByMe", true);
                    FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
                    beginTransaction.add(this, str);
                    beginTransaction.commitAllowingStateLoss();
                } catch (Exception e2) {
                    super.show(fragmentManager, str);
                }
            }
        }
    }
}
