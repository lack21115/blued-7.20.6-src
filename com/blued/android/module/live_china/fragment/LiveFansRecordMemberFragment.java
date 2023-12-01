package com.blued.android.module.live_china.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.adapter.LiveFansRecordMemberAdapter;
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
import com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener;
import com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveFansRecordMemberFragment.class */
public class LiveFansRecordMemberFragment extends MvpFragment<LiveFansRecordMemberPresent> implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    View f12872a;
    SmartRefreshLayout b;

    /* renamed from: c  reason: collision with root package name */
    RecyclerView f12873c;
    View d;
    View e;
    View f;
    View g;
    TextView k;
    private LiveFansRecordMemberAdapter m;
    private Context n;
    private long p;
    private String l = LiveFansRecordMemberFragment.class.getSimpleName();
    private int o = 0;

    private void b() {
        this.n = getContext();
        if (getArguments() != null) {
            this.o = getArguments().getInt("index", 0);
            this.p = getArguments().getLong("lid");
        }
    }

    private void c() {
        this.f12872a = this.i.findViewById(R.id.rl_list_title);
        this.b = (SmartRefreshLayout) this.i.findViewById(R.id.smart_members);
        this.f12873c = (RecyclerView) this.i.findViewById(R.id.rv_members);
        this.d = this.i.findViewById(R.id.ll_nodata_error);
        this.e = this.i.findViewById(R.id.tv_live_reload);
        this.f = this.i.findViewById(R.id.ll_nodata);
        this.g = this.i.findViewById(R.id.loading_view);
        TextView textView = (TextView) this.i.findViewById(R.id.tv_tip);
        this.k = textView;
        int i = this.o;
        if (i == 0) {
            textView.setText(R.string.live_fans_no_member_active);
        } else if (i == 1) {
            textView.setText(R.string.live_fans_no_member);
        }
        j().a(this.o);
        this.b.c(false);
        this.b.b((OnMultiPurposeListener) new SimpleMultiPurposeListener() { // from class: com.blued.android.module.live_china.fragment.LiveFansRecordMemberFragment.1
            @Override // com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener, com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
            public void onLoadMore(RefreshLayout refreshLayout) {
                LiveFansRecordMemberFragment.this.j().f();
            }

            @Override // com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener, com.scwang.smartrefresh.layout.listener.OnRefreshListener
            public void onRefresh(RefreshLayout refreshLayout) {
            }
        });
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.LiveFansRecordMemberFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                LiveFansRecordMemberFragment.this.j().e();
            }
        });
        LiveFansRecordMemberAdapter liveFansRecordMemberAdapter = new LiveFansRecordMemberAdapter(getContext());
        this.m = liveFansRecordMemberAdapter;
        liveFansRecordMemberAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() { // from class: com.blued.android.module.live_china.fragment.LiveFansRecordMemberFragment.3
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemChildClickListener
            public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                if (LiveFansRecordMemberFragment.this.getParentFragment() instanceof LiveFansRecordDialogFragment) {
                    ((LiveFansRecordDialogFragment) LiveFansRecordMemberFragment.this.getParentFragment()).dismiss();
                }
                LiveFansMemberModel a2 = LiveFansRecordMemberFragment.this.m.a(i2);
                if (a2 != null) {
                    if (LiveFansRecordMemberFragment.this.o == 0) {
                        EventTrackLive.a(LiveProtos.Event.FANS_CLUB_PAGE_ACTIVE_LIST_USER_CLICK, String.valueOf(LiveFansRecordMemberFragment.this.p), a2.uid);
                    } else if (LiveFansRecordMemberFragment.this.o == 1) {
                        EventTrackLive.a(LiveProtos.Event.FANS_CLUB_PAGE_TODAY_LIST_USER_CLICK, String.valueOf(LiveFansRecordMemberFragment.this.p), a2.uid);
                    } else if (LiveFansRecordMemberFragment.this.o == 2) {
                        EventTrackLive.a(LiveProtos.Event.FANS_CLUB_PAGE_ALL_LIST_USER_CLICK, String.valueOf(LiveFansRecordMemberFragment.this.p), a2.uid);
                    }
                    LiveRoomUserModel liveRoomUserModel = new LiveRoomUserModel();
                    liveRoomUserModel.uid = a2.uid;
                    liveRoomUserModel.avatar = a2.avatar;
                    LiveSetDataObserver.a().a(liveRoomUserModel);
                }
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        this.f12873c.setLayoutManager(linearLayoutManager);
        this.f12873c.setAdapter(this.m);
        j().e();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        c();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void a(String str, boolean z) {
        super.a(str, z);
        this.g.setVisibility(8);
        this.b.h();
        if (this.m.a() != 0) {
            Log.i("xmm", "setData 4");
            this.f.setVisibility(8);
            this.f12873c.setVisibility(0);
            this.d.setVisibility(8);
            this.f12872a.setVisibility(0);
            return;
        }
        Log.i("xmm", "setData 1");
        if (z) {
            Log.i("xmm", "setData 2");
            this.f.setVisibility(0);
            this.f12873c.setVisibility(8);
            this.d.setVisibility(8);
            return;
        }
        Log.i("xmm", "setData 3");
        this.f.setVisibility(8);
        this.f12873c.setVisibility(8);
        this.d.setVisibility(0);
    }

    public void a(List<LiveFansMemberModel> list) {
        Log.i("xmm", "setData");
        this.m.a(list);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.live_fans_record_member_view;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void g_(String str) {
        super.g_(str);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void o() {
        super.o();
        Log.i("xmm", "setData 5");
        this.b.l(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() == R.id.tv_live_reload) {
            j().e();
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void p() {
        super.p();
        Log.i("xmm", "setData 6");
        this.b.l(false);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
    }
}
