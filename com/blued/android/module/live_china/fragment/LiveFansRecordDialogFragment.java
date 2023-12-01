package com.blued.android.module.live_china.fragment;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.ReflectionUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.adapter.LiveFansPrivilegeAdapater;
import com.blued.android.module.live_china.fragment.LiveFansReNameDialogFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveFansInfoModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveFansRecordDialogFragment.class */
public class LiveFansRecordDialogFragment extends BaseDialogFragment implements View.OnClickListener, LiveFansReNameDialogFragment.ILiveFansEditDialog {
    public static int d;
    private TextView A;
    private TextView B;
    private TextView C;
    private View D;
    private View E;
    private View F;
    private View G;
    private ProgressBar H;
    private View I;
    private View J;
    private View K;
    private View L;
    private RecyclerView M;
    private LiveFansPrivilegeAdapater N;
    private boolean O;

    /* renamed from: a  reason: collision with root package name */
    public Context f12867a;

    /* renamed from: c  reason: collision with root package name */
    public View f12868c;
    public LiveFansReNameDialogFragment e;
    public LiveFansWebDialogFragment f;
    private ViewPager g;
    private MyAdapter h;
    private int i;
    private long j;
    private String k;
    private ILiveFansRecordDialog l;
    private View m;
    private View n;
    private ImageView o;
    private TextView p;
    private View q;
    private View r;
    private View s;
    private View t;
    private View u;
    private TextView v;
    private TextView w;
    private TextView x;
    private TextView y;
    private TextView z;
    public int b = 4;
    private ViewPager.OnPageChangeListener P = new ViewPager.OnPageChangeListener() { // from class: com.blued.android.module.live_china.fragment.LiveFansRecordDialogFragment.1
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            LiveFansRecordDialogFragment.this.i = i;
            LiveFansRecordDialogFragment liveFansRecordDialogFragment = LiveFansRecordDialogFragment.this;
            liveFansRecordDialogFragment.a(liveFansRecordDialogFragment.i);
        }
    };

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveFansRecordDialogFragment$ILiveFansRecordDialog.class */
    public interface ILiveFansRecordDialog {
        void A_();

        void z_();
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveFansRecordDialogFragment$MyAdapter.class */
    public class MyAdapter extends FragmentPagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        FragmentManager f12871a;

        public MyAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.f12871a = fragmentManager;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            super.destroyItem(viewGroup, i, obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return LiveFansRecordDialogFragment.this.b;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            if (i == 0) {
                Bundle bundle = new Bundle();
                bundle.putInt("index", 0);
                bundle.putLong("lid", LiveFansRecordDialogFragment.this.j);
                LiveFansRecordMemberFragment liveFansRecordMemberFragment = new LiveFansRecordMemberFragment();
                liveFansRecordMemberFragment.setArguments(bundle);
                return liveFansRecordMemberFragment;
            } else if (i == 1) {
                Bundle bundle2 = new Bundle();
                bundle2.putInt("index", 1);
                bundle2.putLong("lid", LiveFansRecordDialogFragment.this.j);
                LiveFansRecordMemberFragment liveFansRecordMemberFragment2 = new LiveFansRecordMemberFragment();
                liveFansRecordMemberFragment2.setArguments(bundle2);
                return liveFansRecordMemberFragment2;
            } else if (i != 2) {
                if (i != 3) {
                    return null;
                }
                return new LiveFansGroupRecordingFrahment();
            } else {
                Bundle bundle3 = new Bundle();
                bundle3.putInt("index", 2);
                bundle3.putLong("lid", LiveFansRecordDialogFragment.this.j);
                LiveFansRecordMemberFragment liveFansRecordMemberFragment3 = new LiveFansRecordMemberFragment();
                liveFansRecordMemberFragment3.setArguments(bundle3);
                return liveFansRecordMemberFragment3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveFansInfoModel liveFansInfoModel) {
        if (liveFansInfoModel == null) {
            return;
        }
        this.m.setVisibility(0);
        this.z.setText(String.format(getString(R.string.live_fans_info_num), Integer.valueOf(liveFansInfoModel.member_active)));
        this.A.setText(String.format(getString(R.string.live_fans_info_num), Integer.valueOf(liveFansInfoModel.member_today)));
        this.B.setText(String.format(getString(R.string.live_fans_info_num), Integer.valueOf(liveFansInfoModel.member_total)));
        this.C.setText(getString(R.string.live_fans_group_sub));
        if (liveFansInfoModel.show_group) {
            this.u.setVisibility(0);
            this.b = 4;
        } else {
            this.u.setVisibility(8);
            this.b = 3;
        }
        this.g.setAdapter(this.h);
        this.g.setOffscreenPageLimit(3);
        this.g.addOnPageChangeListener(this.P);
        a(0);
    }

    private void f() {
        if (getArguments() != null) {
            this.k = getArguments().getString("uid");
            this.j = getArguments().getLong("lid");
        }
    }

    private void g() {
        ImageView imageView = (ImageView) this.f12868c.findViewById(R.id.iv_fans_member);
        this.o = imageView;
        imageView.setVisibility(8);
        this.p = (TextView) this.f12868c.findViewById(R.id.tv_fans_title);
        View findViewById = this.f12868c.findViewById(R.id.iv_fans_edit);
        this.I = findViewById;
        findViewById.setVisibility(0);
        View findViewById2 = this.f12868c.findViewById(R.id.iv_fans_qa);
        this.q = findViewById2;
        findViewById2.setVisibility(0);
    }

    private void h() {
        View findViewById = this.f12868c.findViewById(R.id.ll_fans_error);
        this.L = findViewById;
        findViewById.setVisibility(8);
        View findViewById2 = this.f12868c.findViewById(R.id.ll_main_view);
        this.m = findViewById2;
        findViewById2.setVisibility(8);
        this.g = (ViewPager) this.f12868c.findViewById(R.id.dialog_rank_viewpager);
        this.h = new MyAdapter(getChildFragmentManager());
        this.r = this.f12868c.findViewById(R.id.ll_active);
        this.s = this.f12868c.findViewById(R.id.ll_today);
        this.t = this.f12868c.findViewById(R.id.ll_all);
        this.u = this.f12868c.findViewById(R.id.ll_fans_group);
        this.v = (TextView) this.f12868c.findViewById(R.id.tv_active_title);
        this.w = (TextView) this.f12868c.findViewById(R.id.tv_today_title);
        this.x = (TextView) this.f12868c.findViewById(R.id.tv_all_title);
        this.y = (TextView) this.f12868c.findViewById(R.id.tv_fans_group_title);
        this.z = (TextView) this.f12868c.findViewById(R.id.tv_active_num);
        this.A = (TextView) this.f12868c.findViewById(R.id.tv_today_num);
        this.B = (TextView) this.f12868c.findViewById(R.id.tv_all_num);
        this.C = (TextView) this.f12868c.findViewById(R.id.tv_fans_group_subtitle);
        this.D = this.f12868c.findViewById(R.id.ll_active_line);
        this.E = this.f12868c.findViewById(R.id.ll_today_line);
        this.F = this.f12868c.findViewById(R.id.ll_all_line);
        this.G = this.f12868c.findViewById(R.id.ll_fans_group_line);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.n.setVisibility(0);
        this.M.setAdapter(this.N);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.L.setVisibility(0);
        this.I.setVisibility(8);
    }

    private void k() {
        View findViewById = this.f12868c.findViewById(R.id.ll_privilege);
        this.n = findViewById;
        findViewById.setVisibility(8);
        View findViewById2 = this.f12868c.findViewById(R.id.view_height_9);
        this.J = findViewById2;
        findViewById2.setVisibility(8);
        View findViewById3 = this.f12868c.findViewById(R.id.view_height_25);
        this.K = findViewById3;
        findViewById3.setVisibility(0);
        this.M = (RecyclerView) this.f12868c.findViewById(R.id.rv_privilege);
        this.M.setLayoutManager(new GridLayoutManager(this.f12867a, 3));
        this.N = new LiveFansPrivilegeAdapater(this.f12867a, 0);
    }

    public void a(int i) {
        this.g.setCurrentItem(i);
        if (i == 0) {
            this.v.setTextColor(getResources().getColor(R.color.syc_dark_h));
            this.w.setTextColor(getResources().getColor(R.color.syc_dark_j));
            this.x.setTextColor(getResources().getColor(R.color.syc_dark_j));
            this.y.setTextColor(getResources().getColor(R.color.syc_dark_j));
            this.z.setTextColor(getResources().getColor(R.color.syc_dark_h));
            this.A.setTextColor(getResources().getColor(R.color.syc_dark_j));
            this.B.setTextColor(getResources().getColor(R.color.syc_dark_j));
            this.C.setTextColor(getResources().getColor(R.color.syc_dark_j));
            this.D.setVisibility(0);
            this.E.setVisibility(4);
            this.F.setVisibility(4);
            this.G.setVisibility(4);
        } else if (i == 1) {
            this.v.setTextColor(getResources().getColor(R.color.syc_dark_j));
            this.w.setTextColor(getResources().getColor(R.color.syc_dark_h));
            this.x.setTextColor(getResources().getColor(R.color.syc_dark_j));
            this.y.setTextColor(getResources().getColor(R.color.syc_dark_j));
            this.z.setTextColor(getResources().getColor(R.color.syc_dark_j));
            this.A.setTextColor(getResources().getColor(R.color.syc_dark_h));
            this.B.setTextColor(getResources().getColor(R.color.syc_dark_j));
            this.C.setTextColor(getResources().getColor(R.color.syc_dark_j));
            this.D.setVisibility(4);
            this.E.setVisibility(0);
            this.F.setVisibility(4);
            this.G.setVisibility(4);
        } else if (i == 2) {
            this.v.setTextColor(getResources().getColor(R.color.syc_dark_j));
            this.w.setTextColor(getResources().getColor(R.color.syc_dark_j));
            this.x.setTextColor(getResources().getColor(R.color.syc_dark_h));
            this.y.setTextColor(getResources().getColor(R.color.syc_dark_j));
            this.z.setTextColor(getResources().getColor(R.color.syc_dark_j));
            this.A.setTextColor(getResources().getColor(R.color.syc_dark_j));
            this.B.setTextColor(getResources().getColor(R.color.syc_dark_h));
            this.C.setTextColor(getResources().getColor(R.color.syc_dark_j));
            this.D.setVisibility(4);
            this.E.setVisibility(4);
            this.F.setVisibility(0);
            this.G.setVisibility(4);
        } else if (i == 3) {
            this.v.setTextColor(getResources().getColor(R.color.syc_dark_j));
            this.w.setTextColor(getResources().getColor(R.color.syc_dark_j));
            this.x.setTextColor(getResources().getColor(R.color.syc_dark_j));
            this.y.setTextColor(getResources().getColor(R.color.syc_dark_h));
            this.z.setTextColor(getResources().getColor(R.color.syc_dark_j));
            this.A.setTextColor(getResources().getColor(R.color.syc_dark_j));
            this.B.setTextColor(getResources().getColor(R.color.syc_dark_j));
            this.C.setTextColor(getResources().getColor(R.color.syc_dark_h));
            this.D.setVisibility(4);
            this.E.setVisibility(4);
            this.F.setVisibility(4);
            this.G.setVisibility(0);
        }
    }

    public void a(ILiveFansRecordDialog iLiveFansRecordDialog) {
        this.l = iLiveFansRecordDialog;
    }

    @Override // com.blued.android.module.live_china.fragment.LiveFansReNameDialogFragment.ILiveFansEditDialog
    public void a(boolean z, String str) {
    }

    public void d() {
        String str = this.k;
        LiveRoomHttpUtils.c(str, this.j + "", new BluedUIHttpResponse<BluedEntityA<LiveFansInfoModel>>(a()) { // from class: com.blued.android.module.live_china.fragment.LiveFansRecordDialogFragment.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveFansInfoModel> bluedEntityA) {
                if (LiveFansRecordDialogFragment.this.O) {
                    LiveFansRecordDialogFragment.this.H.setVisibility(8);
                    if (bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                        return;
                    }
                    LiveFansInfoModel liveFansInfoModel = bluedEntityA.data.get(0);
                    LiveRoomManager.a().a(liveFansInfoModel);
                    LiveFansRecordDialogFragment.this.p.setText(String.format(LiveFansRecordDialogFragment.this.getString(R.string.live_fans_owner), liveFansInfoModel.anchor_name));
                    if (liveFansInfoModel.member_total > 0) {
                        LiveFansRecordDialogFragment.this.a(liveFansInfoModel);
                    } else {
                        LiveFansRecordDialogFragment.this.i();
                    }
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str2) {
                if (LiveFansRecordDialogFragment.this.O) {
                    LiveFansRecordDialogFragment.this.H.setVisibility(8);
                    LiveFansRecordDialogFragment.this.j();
                    AppMethods.a((CharSequence) str2);
                    return true;
                }
                return true;
            }
        }, a());
    }

    public void e() {
        this.f = new LiveFansWebDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString("url", LiveRoomInfo.a().C());
        bundle.putInt("type", 0);
        this.f.setArguments(bundle);
        this.f.show(getFragmentManager(), "webDialog");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == R.id.ll_active) {
            EventTrackLive.b(LiveProtos.Event.FANS_CLUB_PAGE_ACTIVE_CLICK, String.valueOf(this.j));
            a(0);
        } else if (id == R.id.ll_today) {
            EventTrackLive.b(LiveProtos.Event.FANS_CLUB_PAGE_TODAY_CLICK, String.valueOf(this.j));
            a(1);
        } else if (id == R.id.ll_all) {
            EventTrackLive.b(LiveProtos.Event.FANS_CLUB_PAGE_ALL_CLICK, String.valueOf(this.j));
            a(2);
        } else if (id == R.id.ll_fans_group) {
            EventTrackLive.b(LiveProtos.Event.LIVE_ANCHOR_FANS_CLUB_PAGE_SHOW, String.valueOf(this.j));
            a(3);
        } else if (id != R.id.iv_fans_edit) {
            if (id == R.id.iv_fans_qa) {
                EventTrackLive.b(LiveProtos.Event.FANS_CLUB_PAGE_QA_CLICK, String.valueOf(this.j));
                e();
            }
        } else {
            EventTrackLive.b(LiveProtos.Event.FANS_CLUB_PAGE_EDIT_NAME_CLICK, String.valueOf(this.j));
            if (LiveRoomManager.a().q() != null && LiveRoomManager.a().q().apply == 1) {
                AppMethods.d(R.string.live_fans_name_modify_tip);
                return;
            }
            this.e = new LiveFansReNameDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putLong("lid", this.j);
            bundle.putString("name", LiveRoomManager.a().q() != null ? LiveRoomManager.a().q().name : "");
            this.e.setArguments(bundle);
            this.e.a((LiveFansReNameDialogFragment.ILiveFansEditDialog) this);
            this.e.show(getFragmentManager(), "liveFansEditDialog");
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        this.f12867a = getActivity();
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.dialog_live_fans_record, (ViewGroup) null);
        int a2 = DensityUtils.a(getActivity(), 471.0f);
        Dialog dialog = new Dialog(getActivity(), R.style.transparentFrameWindowStyleLive);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(inflate, new ViewGroup.LayoutParams(-1, a2));
        Window window = dialog.getWindow();
        window.setWindowAnimations(R.style.main_menu_animstyle);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = a2;
        attributes.x = 0;
        attributes.y = getActivity().getWindowManager().getDefaultDisplay().getHeight() - a2;
        dialog.onWindowAttributesChanged(attributes);
        f();
        return dialog;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        View inflate = layoutInflater.inflate(R.layout.dialog_live_fans_record, viewGroup);
        this.f12868c = inflate;
        ProgressBar progressBar = (ProgressBar) inflate.findViewById(R.id.loading_view);
        this.H = progressBar;
        progressBar.setVisibility(0);
        g();
        h();
        k();
        d();
        this.r.setOnClickListener(this);
        this.s.setOnClickListener(this);
        this.t.setOnClickListener(this);
        this.u.setOnClickListener(this);
        this.I.setOnClickListener(this);
        this.q.setOnClickListener(this);
        ILiveFansRecordDialog iLiveFansRecordDialog = this.l;
        if (iLiveFansRecordDialog != null) {
            iLiveFansRecordDialog.z_();
        }
        this.O = true;
        return this.f12868c;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ILiveFansRecordDialog iLiveFansRecordDialog = this.l;
        if (iLiveFansRecordDialog != null) {
            iLiveFansRecordDialog.A_();
        }
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.O = false;
        super.onDestroyView();
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Dialog dialog;
        Dialog dialog2;
        super.onPause();
        LiveFansReNameDialogFragment liveFansReNameDialogFragment = this.e;
        if (liveFansReNameDialogFragment != null && (dialog2 = liveFansReNameDialogFragment.getDialog()) != null && dialog2.isShowing()) {
            this.e.dismiss();
        }
        LiveFansWebDialogFragment liveFansWebDialogFragment = this.f;
        if (liveFansWebDialogFragment == null || (dialog = liveFansWebDialogFragment.getDialog()) == null || !dialog.isShowing()) {
            return;
        }
        this.f.dismiss();
    }

    @Override // com.blued.android.module.live_china.fragment.LiveFansReNameDialogFragment.ILiveFansEditDialog
    public void q_() {
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        try {
            ReflectionUtils.a(this, "mDismissed", false);
            ReflectionUtils.a(this, "mShownByMe", true);
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            beginTransaction.add(this, str);
            beginTransaction.commitAllowingStateLoss();
        } catch (Exception e) {
            super.show(fragmentManager, str);
        }
    }
}
