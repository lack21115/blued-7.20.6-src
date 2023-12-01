package com.soft.blued.ui.user.fragment;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshRecyclerView;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.common.widget.pop.BluedPopupWindow;
import com.blued.android.module.common.widget.refresh.BluedAdapterLoadMoreView;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.model.FeedParse;
import com.blued.community.track.EventTrackSuperExpose;
import com.blued.community.ui.circle.manager.CircleMethods;
import com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView;
import com.blued.community.ui.feed.manager.FeedMethods;
import com.blued.community.ui.send.observer.FeedRefreshObserver;
import com.blued.das.superexpose.SuperExposeProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.soft.blued.R;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.ui.user.observer.UserinfoFeedScrollObserver;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.StringUtils;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/UserinfoFragmentFeedTab.class */
public class UserinfoFragmentFeedTab extends BaseFragment implements FeedRefreshObserver.IFeedRefreshObserver {

    /* renamed from: a  reason: collision with root package name */
    public Context f20385a;
    public View b;

    /* renamed from: c  reason: collision with root package name */
    public PullToRefreshRecyclerView f20386c;
    public RecyclerView d;
    public FeedListAdapterForRecyclerView e;
    private View f;
    private NoDataAndLoadFailView g;
    private UserBasicModel k;
    private View l;
    private List<BluedIngSelfFeed> m;
    private boolean o;
    private BluedPopupWindow q;
    private int h = 1;
    private int i = 20;
    private boolean j = true;
    private boolean n = true;
    private BluedUIHttpResponse p = new BluedUIHttpResponse<BluedEntityA<BluedIngSelfFeed>>(getFragmentActive()) { // from class: com.soft.blued.ui.user.fragment.UserinfoFragmentFeedTab.3
        private void a(BluedEntityA<BluedIngSelfFeed> bluedEntityA, boolean z) {
            int i;
            if (bluedEntityA != null && bluedEntityA.data != null && bluedEntityA.data.size() > 0) {
                if (UserinfoFragmentFeedTab.this.h == 1) {
                    UserinfoFragmentFeedTab.this.e.setNewData(bluedEntityA.data);
                } else {
                    UserinfoFragmentFeedTab.this.e.addData(bluedEntityA.data);
                }
                UserinfoFragmentFeedTab.this.e.notifyDataSetChanged();
                UserinfoFragmentFeedTab.this.m = bluedEntityA.data;
                BluedIngSelfFeed bluedIngSelfFeed = (BluedIngSelfFeed) UserinfoFragmentFeedTab.this.m.get(0);
                if (bluedIngSelfFeed.feed_views == 1 && UserinfoFragmentFeedTab.this.m.size() > 1 && bluedIngSelfFeed.recommendation.isEmpty()) {
                    bluedIngSelfFeed = (BluedIngSelfFeed) UserinfoFragmentFeedTab.this.m.get(1);
                    i = 1;
                } else {
                    i = 0;
                }
                if (UserinfoFragmentFeedTab.this.o) {
                    UserinfoFragmentFeedTab.this.n = true;
                    UserinfoFragmentFeedTab.this.a(bluedIngSelfFeed, i);
                }
            }
            if (bluedEntityA == null || !bluedEntityA.hasMore()) {
                UserinfoFragmentFeedTab.this.j = false;
            } else {
                UserinfoFragmentFeedTab.this.j = true;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public BluedEntityA<BluedIngSelfFeed> parseData(String str) {
            BluedEntityA<BluedIngSelfFeed> parseData = super.parseData(str);
            if (UserinfoFragmentFeedTab.this.f20385a != null && parseData != null) {
                if (!parseData.hasData()) {
                    return parseData;
                }
                for (BluedIngSelfFeed bluedIngSelfFeed : parseData.data) {
                    bluedIngSelfFeed.feedParse = new FeedParse(UserinfoFragmentFeedTab.this.f20385a, bluedIngSelfFeed, 1);
                }
            }
            return parseData;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void onUICache(BluedEntityA<BluedIngSelfFeed> bluedEntityA) {
            a(bluedEntityA, true);
        }

        /* renamed from: b */
        public void onUIUpdate(BluedEntityA<BluedIngSelfFeed> bluedEntityA) {
            a(bluedEntityA, false);
        }

        public void onUIFinish(boolean z) {
            if (UserinfoFragmentFeedTab.this.l != null) {
                UserinfoFragmentFeedTab.this.l.setVisibility(8);
            }
            if (UserinfoFragmentFeedTab.this.e.getData().size() > 0) {
                UserinfoFragmentFeedTab.this.g.d();
            } else if (z) {
                UserinfoFragmentFeedTab.this.g.a();
            } else {
                UserinfoFragmentFeedTab.this.g.b();
                if (UserinfoFragmentFeedTab.this.h != 1) {
                    UserinfoFragmentFeedTab.f(UserinfoFragmentFeedTab.this);
                }
            }
            if (UserinfoFragmentFeedTab.this.j) {
                UserinfoFragmentFeedTab.this.e.loadMoreComplete();
            } else {
                UserinfoFragmentFeedTab.this.e.setEnableLoadMore(false);
                if (UserinfoFragmentFeedTab.this.e.getFooterLayoutCount() == 0) {
                    UserinfoFragmentFeedTab.this.e.addFooterView(UserinfoFragmentFeedTab.this.f);
                    ((TextView) UserinfoFragmentFeedTab.this.f.findViewById(R.id.tv_last_feed_desc)).setText(R.string.user_no_more_feed);
                }
            }
            if (UserinfoFragmentFeedTab.this.h == 1) {
                ((UserInfoFragmentNew) UserinfoFragmentFeedTab.this.getParentFragment()).e(UserinfoFragmentFeedTab.this.e.getData().size() > 0);
            }
        }

        public void onUIStart() {
            super.onUIStart();
            if (UserinfoFragmentFeedTab.this.e.getItemCount() != 0 || UserinfoFragmentFeedTab.this.l == null) {
                return;
            }
            UserinfoFragmentFeedTab.this.l.setVisibility(0);
        }
    };

    public static UserinfoFragmentFeedTab a(UserBasicModel userBasicModel) {
        UserinfoFragmentFeedTab userinfoFragmentFeedTab = new UserinfoFragmentFeedTab();
        Bundle bundle = new Bundle();
        bundle.putSerializable("user", userBasicModel);
        userinfoFragmentFeedTab.setArguments(bundle);
        return userinfoFragmentFeedTab;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(View view) {
        Rect rect = new Rect();
        view.getLocalVisibleRect(rect);
        return rect.top == 0;
    }

    static /* synthetic */ int f(UserinfoFragmentFeedTab userinfoFragmentFeedTab) {
        int i = userinfoFragmentFeedTab.h;
        userinfoFragmentFeedTab.h = i - 1;
        return i;
    }

    public void a() {
        this.l = this.b.findViewById(R.id.loading_view);
        NoDataAndLoadFailView noDataAndLoadFailView = new NoDataAndLoadFailView(this.f20385a);
        this.g = noDataAndLoadFailView;
        noDataAndLoadFailView.d();
        this.g.setImageScale(0.7f);
        this.g.setTopSpace(DensityUtils.a(this.f20385a, 58.0f));
        this.f = LayoutInflater.from(this.f20385a).inflate(R.layout.user_feed_no_more_view, (ViewGroup) null);
        PullToRefreshRecyclerView findViewById = this.b.findViewById(R.id.wrapper);
        this.f20386c = findViewById;
        findViewById.setRefreshEnabled(false);
        RecyclerView recyclerView = (RecyclerView) this.f20386c.getRefreshableView();
        this.d = recyclerView;
        RecyclerView.Adapter feedListAdapterForRecyclerView = new FeedListAdapterForRecyclerView(this.f20385a, this, recyclerView, 1);
        this.e = feedListAdapterForRecyclerView;
        this.d.setAdapter(feedListAdapterForRecyclerView);
        this.e.setEmptyView(this.g);
        this.e.setLoadMoreView(new BluedAdapterLoadMoreView());
        this.d.setLayoutManager(new GridLayoutManager(this.f20385a, 1));
        this.d.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.soft.blued.ui.user.fragment.UserinfoFragmentFeedTab.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView2, int i) {
                super.onScrollStateChanged(recyclerView2, i);
                UserinfoFragmentFeedTab.this.e.s.onScrollStateChanged(recyclerView2, i);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView2, int i, int i2) {
                super.onScrolled(recyclerView2, i, i2);
                UserinfoFragmentFeedTab.this.e.s.onScrolled(recyclerView2, i, i2);
                UserinfoFeedScrollObserver.a().a(recyclerView2, i, i2);
            }
        });
        this.e.setEnableLoadMore(true);
        this.e.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() { // from class: com.soft.blued.ui.user.fragment.UserinfoFragmentFeedTab.2
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.RequestLoadMoreListener
            public void onLoadMoreRequested() {
                UserinfoFragmentFeedTab.this.a(false);
            }
        }, this.d);
        a(true);
    }

    public void a(final BluedIngSelfFeed bluedIngSelfFeed, final int i) {
        if (TextUtils.isEmpty(bluedIngSelfFeed.recommendation) || !this.n) {
            return;
        }
        if (this.q == null) {
            View inflate = View.inflate(getContext(), R.layout.pop_super_exposure_guide, null);
            ((TextView) inflate.findViewById(R.id.tv_super_exposure_tips)).setText(bluedIngSelfFeed.recommendation);
            BluedPopupWindow a2 = BluedPopupWindow.Builder.a(getActivity(), inflate).a(true).a();
            this.q = a2;
            a2.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.soft.blued.ui.user.fragment.UserinfoFragmentFeedTab.4
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    UserinfoFragmentFeedTab.this.q = null;
                }
            });
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.UserinfoFragmentFeedTab.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    EventTrackSuperExpose.a(SuperExposeProtos.Event.EXPOSE_FEED_PERSONAL_POP_CLICK, bluedIngSelfFeed.feed_id);
                    WebViewShowInfoFragment.show(UserinfoFragmentFeedTab.this.f20385a, bluedIngSelfFeed.promotion_url, 0);
                    UserinfoFragmentFeedTab.this.q.dismiss();
                }
            });
            postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.user.fragment.UserinfoFragmentFeedTab.6
                @Override // java.lang.Runnable
                public void run() {
                    View viewByPosition = UserinfoFragmentFeedTab.this.e.getViewByPosition(UserinfoFragmentFeedTab.this.d, i, (int) R.id.ll_read_num);
                    if (viewByPosition == null || !UserinfoFragmentFeedTab.this.a(viewByPosition)) {
                        return;
                    }
                    EventTrackSuperExpose.a(SuperExposeProtos.Event.EXPOSE_FEED_PERSONAL_POP_SHOW, bluedIngSelfFeed.feed_id);
                    UserinfoFragmentFeedTab.this.q.a(viewByPosition, 1, 4, 0, -DensityUtils.a(UserinfoFragmentFeedTab.this.f20385a, 9.0f));
                }
            }, 300L);
            inflate.postDelayed(new Runnable() { // from class: com.soft.blued.ui.user.fragment.UserinfoFragmentFeedTab.7
                @Override // java.lang.Runnable
                public void run() {
                    if (UserinfoFragmentFeedTab.this.q == null || !UserinfoFragmentFeedTab.this.q.isShowing()) {
                        return;
                    }
                    UserinfoFragmentFeedTab.this.q.dismiss();
                }
            }, 5300L);
        } else {
            this.q = null;
        }
        this.n = false;
    }

    public void a(Object obj, int i) {
        if (i == 2) {
            NoDataAndLoadFailView noDataAndLoadFailView = this.g;
            if (noDataAndLoadFailView != null) {
                noDataAndLoadFailView.d();
            }
            if (obj instanceof BluedIngSelfFeed) {
                BluedIngSelfFeed bluedIngSelfFeed = (BluedIngSelfFeed) obj;
                if (this.e == null || CircleMethods.a(bluedIngSelfFeed)) {
                    return;
                }
                a(true);
            }
        }
    }

    public void a(boolean z) {
        int i;
        UserBasicModel userBasicModel = this.k;
        if (userBasicModel == null || StringUtils.d(userBasicModel.uid)) {
            return;
        }
        if (z) {
            this.h = 1;
        } else {
            this.h++;
        }
        if (!this.j && (i = this.h) != 1) {
            this.h = i - 1;
            return;
        }
        MineHttpUtils.b(this.f20385a, this.p, this.k.uid, this.h + "", this.i + "", getFragmentActive());
    }

    public void b(UserBasicModel userBasicModel) {
        if (userBasicModel == null) {
            return;
        }
        this.k = userBasicModel;
        FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = this.e;
        if (feedListAdapterForRecyclerView != null) {
            feedListAdapterForRecyclerView.removeAllFooterView();
            this.e.setEnableLoadMore(true);
        }
        a(true);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f20385a = getActivity();
        View view = this.b;
        if (view == null) {
            this.b = layoutInflater.inflate(R.layout.fragment_circle_pubish_respond, viewGroup, false);
            UserBasicModel serializable = getArguments().getSerializable("user");
            this.k = serializable;
            if (serializable == null) {
                UserBasicModel userBasicModel = new UserBasicModel();
                this.k = userBasicModel;
                userBasicModel.uid = UserInfo.getInstance().getLoginUserInfo().uid;
            }
            a();
            FeedMethods.a(getActivity(), this.e);
            FeedRefreshObserver.a().a(this);
        } else if (view.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        return this.b;
    }

    public void onDestroy() {
        super.onDestroy();
        FeedRefreshObserver.a().b(this);
    }

    public void onPause() {
        super.onPause();
        FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = this.e;
        if (feedListAdapterForRecyclerView != null) {
            feedListAdapterForRecyclerView.e();
        }
    }

    public void onResume() {
        super.onResume();
        FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = this.e;
        if (feedListAdapterForRecyclerView != null) {
            feedListAdapterForRecyclerView.d();
        }
    }

    public void setUserVisibleHint(boolean z) {
        List<BluedIngSelfFeed> list;
        super.setUserVisibleHint(z);
        this.o = z;
        if (!z || (list = this.m) == null) {
            return;
        }
        BluedIngSelfFeed bluedIngSelfFeed = list.get(0);
        int i = 0;
        BluedIngSelfFeed bluedIngSelfFeed2 = bluedIngSelfFeed;
        if (bluedIngSelfFeed.feed_views == 1) {
            i = 0;
            bluedIngSelfFeed2 = bluedIngSelfFeed;
            if (this.m.size() > 1) {
                i = 0;
                bluedIngSelfFeed2 = bluedIngSelfFeed;
                if (bluedIngSelfFeed.recommendation.isEmpty()) {
                    bluedIngSelfFeed2 = this.m.get(1);
                    i = 1;
                }
            }
        }
        a(bluedIngSelfFeed2, i);
    }
}
