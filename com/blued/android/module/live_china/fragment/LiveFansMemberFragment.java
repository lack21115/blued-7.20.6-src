package com.blued.android.module.live_china.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.adapter.LiveFansMemberAdapter;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.LiveFansInfoModel;
import com.blued.android.module.live_china.model.LiveFansMemberModel;
import com.blued.android.module.live_china.model.LiveRoomUserModel;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.presenter.LiveFansRecordMemberPresent;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveFansMemberFragment.class */
public class LiveFansMemberFragment extends MvpFragment<LiveFansRecordMemberPresent> implements View.OnClickListener {
    View a;
    TextView b;
    TextView c;
    View d;
    View e;
    View f;
    SmartRefreshLayout g;
    RecyclerView k;
    View l;
    View m;
    View n;
    TextView o;
    View p;
    private LoadOptions q;
    private LiveFansMemberAdapter r;
    private long s;
    private boolean t = true;
    private int u = 0;

    private void c() {
        if (getArguments() != null) {
            this.s = getArguments().getLong("lid");
            this.u = getArguments().getInt("from", 0);
        }
        LoadOptions loadOptions = new LoadOptions();
        this.q = loadOptions;
        loadOptions.d = R.drawable.user_bg_round;
        this.q.b = R.drawable.user_bg_round;
    }

    private void d() {
        this.a = this.i.findViewById(R.id.ll_fans_title);
        this.b = (TextView) this.i.findViewById(R.id.tv_fans_title);
        this.c = (TextView) this.i.findViewById(R.id.tv_fans_num);
        if (this.u == 0) {
            this.a.setVisibility(0);
        } else {
            this.a.setVisibility(8);
        }
        this.d = this.i.findViewById(R.id.iv_fans_member);
        this.e = this.i.findViewById(R.id.iv_fans_member_back);
        this.f = this.i.findViewById(R.id.iv_fans_qa);
        this.g = this.i.findViewById(R.id.smart_members);
        this.k = this.i.findViewById(R.id.rv_members);
        this.l = this.i.findViewById(R.id.ll_nodata_blacklist);
        this.m = this.i.findViewById(R.id.tv_live_reload);
        this.n = this.i.findViewById(R.id.ll_nodata);
        this.o = (TextView) this.i.findViewById(R.id.tv_tip);
        this.p = this.i.findViewById(R.id.loading_view);
        this.d.setVisibility(8);
        this.e.setVisibility(0);
        j().a(2);
        this.g.c(false);
        this.g.a(new SimpleMultiPurposeListener() { // from class: com.blued.android.module.live_china.fragment.LiveFansMemberFragment.1
            public void onLoadMore(RefreshLayout refreshLayout) {
                LiveFansMemberFragment.this.j().f();
            }

            public void onRefresh(RefreshLayout refreshLayout) {
            }
        });
        this.m.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.LiveFansMemberFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                LiveFansMemberFragment.this.j().e();
            }
        });
        LiveFansMemberAdapter liveFansMemberAdapter = new LiveFansMemberAdapter(getContext());
        this.r = liveFansMemberAdapter;
        liveFansMemberAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() { // from class: com.blued.android.module.live_china.fragment.LiveFansMemberFragment.3
            public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                if (LiveFansMemberFragment.this.getParentFragment() instanceof LiveFansGuestDialogFragment) {
                    LiveFansMemberFragment.this.getParentFragment().dismiss();
                }
                LiveFansMemberModel a = LiveFansMemberFragment.this.r.a(i);
                if (a != null) {
                    LiveRoomUserModel liveRoomUserModel = new LiveRoomUserModel();
                    liveRoomUserModel.uid = a.uid;
                    liveRoomUserModel.avatar = a.avatar;
                    LiveSetDataObserver.a().a(liveRoomUserModel);
                }
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        this.k.setLayoutManager(linearLayoutManager);
        this.k.setAdapter(this.r);
        this.e.setOnClickListener(this);
        this.f.setOnClickListener(this);
        j().e();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        d();
        this.t = true;
    }

    public void a(LiveFansInfoModel liveFansInfoModel) {
        TextView textView = this.b;
        if (textView != null) {
            textView.setText(liveFansInfoModel.anchor_name);
        }
        TextView textView2 = this.c;
        if (textView2 != null) {
            textView2.setText(String.format(getString(R.string.live_fans_not_add_tip_1), Integer.valueOf(liveFansInfoModel.member_total)));
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void a(String str, boolean z) {
        super.a(str, z);
        this.p.setVisibility(8);
        this.g.h();
        if (this.r.a() != 0) {
            Log.i("xmm", "setData 4");
            this.n.setVisibility(8);
            this.k.setVisibility(0);
            this.l.setVisibility(8);
            return;
        }
        Log.i("xmm", "setData 1");
        if (!z) {
            Log.i("xmm", "setData 3");
            this.n.setVisibility(8);
            this.k.setVisibility(8);
            this.l.setVisibility(0);
            return;
        }
        Log.i("xmm", "setData 2");
        this.o.setText(R.string.live_fans_guest_no_member);
        this.n.setVisibility(0);
        this.k.setVisibility(8);
        this.l.setVisibility(8);
    }

    public void a(List<LiveFansMemberModel> list) {
        Log.i("xmm", "setData");
        this.k.setVisibility(0);
        this.r.a(list);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void af_() {
        super.af_();
        this.t = false;
    }

    public LiveFansGuestDialogFragment b() {
        if (getParentFragment() instanceof LiveFansGuestDialogFragment) {
            return getParentFragment();
        }
        return null;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.live_fans_member_view;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void g_(String str) {
        super.g_(str);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void o() {
        super.o();
        Log.i("xmm", "setData 5");
        this.g.b(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LiveFansGuestDialogFragment parentFragment;
        Tracker.onClick(view);
        int id = view.getId();
        if (id == R.id.iv_fans_member_back) {
            if (!(getParentFragment() instanceof LiveFansGuestDialogFragment) || (parentFragment = getParentFragment()) == null) {
                return;
            }
            parentFragment.a(0);
        } else if (id != R.id.iv_fans_qa || b() == null) {
        } else {
            b().d();
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
        Log.i("xmm", "setData 6");
        this.g.b(false);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (this.t && z) {
            EventTrackLive.a(LiveProtos.Event.FANS_CLUB_PAGE_FANS_LIST_PAGE_SHOW, String.valueOf(this.s), LiveRoomInfo.a().f());
            if (j() != null) {
                j().e();
            }
        }
    }
}
