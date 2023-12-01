package com.blued.android.module.live_china.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.adapter.LiveMakeLoverApplyMemberAdapter;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.LiveMakeLoverApplyMemberModel;
import com.blued.android.module.live_china.model.LiveRoomUserModel;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.presenter.LiveMakeLoverApplyMemberPresent;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveMakeLoverApplyMemberFragment.class */
public class LiveMakeLoverApplyMemberFragment extends MvpFragment<LiveMakeLoverApplyMemberPresent> implements View.OnClickListener {
    View a;
    SmartRefreshLayout b;
    RecyclerView c;
    View d;
    private LiveMakeLoverApplyMemberAdapter e;
    private long f;
    private String g;
    private String k;

    private void e() {
        if (getArguments() != null) {
            this.f = getArguments().getLong("lid");
            this.g = getArguments().getString("type");
            this.k = getArguments().getString("uid");
        }
        j().a(String.valueOf(this.f), this.g);
    }

    private void v() {
        this.a = this.i.findViewById(R.id.ll_nodata);
        this.b = this.i.findViewById(R.id.smart_members);
        this.c = this.i.findViewById(R.id.rv_members);
        this.d = this.i.findViewById(R.id.loading_view);
        this.b.c(false);
        this.b.a(new SimpleMultiPurposeListener() { // from class: com.blued.android.module.live_china.fragment.LiveMakeLoverApplyMemberFragment.1
            public void onLoadMore(RefreshLayout refreshLayout) {
                LiveMakeLoverApplyMemberFragment.this.j().f();
            }

            public void onRefresh(RefreshLayout refreshLayout) {
            }
        });
        LiveMakeLoverApplyMemberAdapter liveMakeLoverApplyMemberAdapter = new LiveMakeLoverApplyMemberAdapter(getContext(), TextUtils.equals(this.g, "1"));
        this.e = liveMakeLoverApplyMemberAdapter;
        liveMakeLoverApplyMemberAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() { // from class: com.blued.android.module.live_china.fragment.LiveMakeLoverApplyMemberFragment.2
            public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                LiveMakeLoverApplyMemberModel a = LiveMakeLoverApplyMemberFragment.this.e.a(i);
                if (a == null) {
                    return;
                }
                if (view.getId() != R.id.ll_items_view) {
                    if (view.getId() == R.id.tv_done) {
                        EventTrackLive.a(LiveProtos.Event.ANCHOR_MIKE_MANAGE_CONFIRM_CLICK, String.valueOf(LiveMakeLoverApplyMemberFragment.this.f), a.uid);
                        LiveMakeLoverApplyMemberFragment.this.j().a(a);
                        return;
                    } else if (view.getId() == R.id.tv_ignore) {
                        EventTrackLive.a(LiveProtos.Event.ANCHOR_MIKE_MANAGE_IGNORE_CLICK, String.valueOf(LiveMakeLoverApplyMemberFragment.this.f), a.uid);
                        LiveMakeLoverApplyMemberFragment.this.j().b(a);
                        return;
                    } else {
                        return;
                    }
                }
                if (LiveMakeLoverApplyMemberFragment.this.d() != null && LiveMakeLoverApplyMemberFragment.this.d().y() != null) {
                    LiveMakeLoverApplyMemberFragment.this.d().y().dismiss();
                } else if (LiveMakeLoverApplyMemberFragment.this.c() != null && LiveMakeLoverApplyMemberFragment.this.c().b() != null) {
                    LiveMakeLoverApplyMemberFragment.this.c().b().dismiss();
                }
                LiveRoomUserModel liveRoomUserModel = new LiveRoomUserModel();
                liveRoomUserModel.uid = a.uid;
                liveRoomUserModel.avatar = a.avatar;
                LiveSetDataObserver.a().a(liveRoomUserModel);
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        this.c.setLayoutManager(linearLayoutManager);
        this.c.setAdapter(this.e);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        v();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void a(String str, List list) {
        boolean z;
        super.a(str, list);
        if (str == "LIVE_MAKE_LOVER_APPLY_LIST") {
            this.e.a(list);
            if (!TextUtils.equals(this.g, "1") || this.e.getData() == null) {
                return;
            }
            Iterator it = this.e.getData().iterator();
            while (true) {
                z = false;
                if (!it.hasNext()) {
                    break;
                } else if (TextUtils.equals(((LiveMakeLoverApplyMemberModel) it.next()).uid, LiveRoomInfo.a().f())) {
                    z = true;
                    break;
                }
            }
            LiveMakeLoverApplyGuestFragment d = d();
            if (d != null) {
                d.b(z);
            }
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void a(String str, boolean z) {
        LiveMakeLoverApplyRecordFragment c;
        super.a(str, z);
        this.d.setVisibility(8);
        if (str != "LIVE_MAKE_LOVER_APPLY_LIST") {
            if (str != "LIVE_MAKE_LOVER_AGREE") {
                if (str == "LIVE_MAKE_LOVER_IGNORE") {
                    int i = j().h;
                    b();
                    return;
                }
                return;
            }
            if (!z && j().h != 403002 && j().h != 403003) {
                int i2 = j().h;
            }
            b();
            return;
        }
        if (TextUtils.equals(this.g, "2")) {
            LiveMakeLoverApplyRecordFragment c2 = c();
            if (c2 != null) {
                c2.b(this.e.a());
            }
        } else if (TextUtils.equals(this.g, "3") && (c = c()) != null) {
            c.c(this.e.a());
        }
        this.b.h();
        if (this.e.a() == 0) {
            this.a.setVisibility(0);
            this.c.setVisibility(8);
            return;
        }
        this.a.setVisibility(8);
        this.c.setVisibility(0);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void af_() {
        super.af_();
    }

    public void b() {
        j().e();
    }

    public LiveMakeLoverApplyRecordFragment c() {
        if (getParentFragment() instanceof LiveMakeLoverApplyRecordFragment) {
            return (LiveMakeLoverApplyRecordFragment) getParentFragment();
        }
        return null;
    }

    public LiveMakeLoverApplyGuestFragment d() {
        if (getParentFragment() instanceof LiveMakeLoverApplyGuestFragment) {
            return (LiveMakeLoverApplyGuestFragment) getParentFragment();
        }
        return null;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.fragment_live_make_lover_apply_member;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void g_(String str) {
        super.g_(str);
        this.d.setVisibility(0);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void o() {
        super.o();
        this.b.b(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        e();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void p() {
        super.p();
        this.b.b(false);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
    }
}
