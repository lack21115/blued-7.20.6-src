package com.soft.blued.ui.live.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.common.url.H5Url;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.live_china.model.LiveFansQuitModel;
import com.blued.android.module.live_china.model.LiveFansRecommendModel;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener;
import com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener;
import com.soft.blued.R;
import com.soft.blued.log.track.EventTrackLive;
import com.soft.blued.ui.live.adapter.LiveFansRecommendAdapater;
import com.soft.blued.ui.live.adapter.LiveJoinFansAdapater;
import com.soft.blued.ui.live.model.LiveJoinFansModel;
import com.soft.blued.ui.live.presenter.LiveJoinFansPresenter;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/fragment/LiveJoinFansFragment.class */
public class LiveJoinFansFragment extends MvpFragment<LiveJoinFansPresenter> implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public Dialog f31181a;
    LiveJoinFansAdapater b = null;

    /* renamed from: c  reason: collision with root package name */
    LiveFansRecommendAdapater f31182c = null;
    private Context d;
    @BindView
    View fl_main;
    @BindView
    View ll_no_fans;
    @BindView
    RecyclerView recycle_recommend;
    @BindView
    RecyclerView recycle_view;
    @BindView
    SmartRefreshLayout refresh_view;
    @BindView
    CommonTopTitleNoTrans top_title;
    @BindView
    TextView tv_fans_qa;
    @BindView
    TextView tv_no_data;
    @BindView
    View tv_re_title;

    public static void a(Context context) {
        a(context, (Bundle) null);
    }

    public static void a(Context context, Bundle bundle) {
        TerminalActivity.d(context, LiveJoinFansFragment.class, bundle);
    }

    private void d() {
        this.f31181a = DialogUtils.a(getActivity());
        this.top_title.a();
        this.top_title.setCenterText(getText(R.string.live_fans));
        this.top_title.setLeftClickListener(this);
        this.top_title.f();
        LiveJoinFansAdapater liveJoinFansAdapater = new LiveJoinFansAdapater(getFragmentActive(), getContext());
        this.b = liveJoinFansAdapater;
        liveJoinFansAdapater.a(new LiveJoinFansAdapater.EventCallBack() { // from class: com.soft.blued.ui.live.fragment.LiveJoinFansFragment.1
            @Override // com.soft.blued.ui.live.adapter.LiveJoinFansAdapater.EventCallBack
            public void a() {
                LiveJoinFansFragment.this.c();
            }

            @Override // com.soft.blued.ui.live.adapter.LiveJoinFansAdapater.EventCallBack
            public void a(String str, int i) {
                DialogUtils.a(LiveJoinFansFragment.this.f31181a);
                LiveJoinFansFragment.this.j().d(str);
            }
        });
        this.recycle_view.setLayoutManager(new LinearLayoutManager(getContext()));
        this.recycle_view.setAdapter(this.b);
        this.refresh_view.b((OnMultiPurposeListener) new SimpleMultiPurposeListener() { // from class: com.soft.blued.ui.live.fragment.LiveJoinFansFragment.2
            @Override // com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener, com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
            public void onLoadMore(RefreshLayout refreshLayout) {
                LiveJoinFansFragment.this.j().f();
            }

            @Override // com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener, com.scwang.smartrefresh.layout.listener.OnRefreshListener
            public void onRefresh(RefreshLayout refreshLayout) {
            }
        });
        this.refresh_view.l(false);
        this.refresh_view.c(false);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.recycle_recommend.setLayoutManager(linearLayoutManager);
        LiveFansRecommendAdapater liveFansRecommendAdapater = new LiveFansRecommendAdapater(getFragmentActive(), this.d);
        this.f31182c = liveFansRecommendAdapater;
        liveFansRecommendAdapater.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() { // from class: com.soft.blued.ui.live.fragment.LiveJoinFansFragment.3
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.RequestLoadMoreListener
            public void onLoadMoreRequested() {
                Log.i("LiveJoinFansFragment", "onLoadMoreRequested");
                LiveJoinFansFragment.this.j().a(false);
            }
        }, this.recycle_recommend);
        this.recycle_recommend.setAdapter(this.f31182c);
        this.tv_fans_qa.setOnClickListener(this);
        j().e();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        d();
    }

    public void a(LiveFansQuitModel liveFansQuitModel) {
        if (liveFansQuitModel == null) {
            return;
        }
        this.b.a(liveFansQuitModel.localUid);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void a(String str, boolean z) {
        super.a(str, z);
        if (str == "LIVE_JOIN_FANS_QUIT") {
            DialogUtils.b(this.f31181a);
        } else if (str == "LIVE_JOIN_FANS") {
            this.refresh_view.j();
            this.refresh_view.h();
            this.refresh_view.l(j().i);
            if (z) {
                this.tv_no_data.setText(getText(R.string.live_fans_no_data));
            } else {
                this.tv_no_data.setText(getText(2131889870));
            }
        }
    }

    public void a(List<LiveJoinFansModel> list) {
        int i;
        if (list == null) {
            return;
        }
        String str = null;
        if (getArguments() != null) {
            str = getArguments().getString("anchor_id");
        }
        if (!TextUtils.isEmpty(str)) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= list.size()) {
                    break;
                } else if (str.equalsIgnoreCase(list.get(i).anchor)) {
                    list.get(i).isOpen = true;
                    break;
                } else {
                    i2 = i + 1;
                }
            }
        }
        i = 0;
        if (list.size() > i) {
            list.get(i).isOpen = true;
        }
        this.b.a(list);
        this.recycle_view.scrollBy(0, (i + 1) * DisplayUtil.a(getContext(), 60.0f));
        c();
    }

    public void b() {
        c();
    }

    public void b(List<LiveFansRecommendModel> list) {
        if (list == null) {
            return;
        }
        Log.i("LiveJoinFansFragment", "pageRecommend:" + j().l);
        this.tv_re_title.setVisibility(0);
        if (j().l == 1) {
            this.f31182c.a(list);
        } else {
            this.f31182c.b(list);
        }
        this.f31182c.setEnableLoadMore(j().j);
    }

    public void c() {
        if (this.b.a() > 1) {
            this.fl_main.setVisibility(0);
            this.recycle_view.setVisibility(0);
            this.ll_no_fans.setVisibility(8);
            EventTrackLive.a(LiveProtos.Event.FANS_CLUB_PAGE_SHOW, true);
            return;
        }
        this.fl_main.setVisibility(0);
        this.recycle_view.setVisibility(8);
        this.ll_no_fans.setVisibility(0);
        j().a(true);
        EventTrackLive.a(LiveProtos.Event.FANS_CLUB_PAGE_SHOW, false);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.fragment_live_join_fans;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == 2131363120) {
            getActivity().finish();
        } else if (id != 2131371413) {
        } else {
            WebViewShowInfoFragment.show(this.d, H5Url.a(50), 0);
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.d = getContext();
    }
}
