package com.blued.community.ui.circle.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.ui.mvp.MvpUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.community.R;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.circle.adapter.CircleListAdapter;
import com.blued.community.ui.circle.fragment.CircleListFragment;
import com.blued.community.ui.circle.manager.CircleConstants;
import com.blued.community.ui.circle.model.MyCircleExtra;
import com.blued.community.ui.circle.presenter.CircleListPresenter;
import com.blued.das.client.feed.FeedProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/fragment/CircleListFragment.class */
public class CircleListFragment extends MvpFragment<CircleListPresenter> {

    /* renamed from: a  reason: collision with root package name */
    private Context f19209a;
    private CircleConstants.CIRCLE_FROM_PAGE b = CircleConstants.CIRCLE_FROM_PAGE.JOINED_CIRCLE;

    /* renamed from: c  reason: collision with root package name */
    private boolean f19210c = false;
    private boolean d = true;
    private CommonTopTitleNoTrans e;
    private RecyclerView f;
    private SmartRefreshLayout g;
    private CircleListAdapter k;
    private NoDataAndLoadFailView l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.community.ui.circle.fragment.CircleListFragment$3  reason: invalid class name */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/fragment/CircleListFragment$3.class */
    public class AnonymousClass3 implements MvpUtils.DataHandler<MyCircleExtra> {
        AnonymousClass3() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(View view) {
            AppMethods.d(R.string.no_circle_admin_yet);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(View view) {
            AppMethods.d(R.string.no_circle_admin_yet);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(View view) {
            CircleMyManagementFragment.f19220a.a(CircleListFragment.this.f19209a);
        }

        @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataHandler
        public void a() {
            CircleListFragment.this.e.setRightTextColor(R.color.syc_i);
            CircleListFragment.this.e.setRightClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.circle.fragment.-$$Lambda$CircleListFragment$3$N_j4QoUkj_spPcXMoWTUuP4fpN8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CircleListFragment.AnonymousClass3.a(view);
                }
            });
        }

        @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataHandler
        public void a(MyCircleExtra myCircleExtra) {
            if (myCircleExtra.my_admin > 0) {
                CircleListFragment.this.e.setRightTextColor(R.color.syc_h);
                CircleListFragment.this.e.setRightClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.circle.fragment.-$$Lambda$CircleListFragment$3$oHHnPBeI1E-rxiOkKjcFRrAl_20
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        CircleListFragment.AnonymousClass3.this.c(view);
                    }
                });
                return;
            }
            CircleListFragment.this.e.setRightTextColor(R.color.syc_i);
            CircleListFragment.this.e.setRightClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.circle.fragment.-$$Lambda$CircleListFragment$3$ixLbG5aIAl1Hd5evATI8J_UvdIw
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CircleListFragment.AnonymousClass3.b(view);
                }
            });
        }
    }

    /* renamed from: com.blued.community.ui.circle.fragment.CircleListFragment$4  reason: invalid class name */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/fragment/CircleListFragment$4.class */
    static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f19214a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0036 -> B:21:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003a -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003e -> B:25:0x002a). Please submit an issue!!! */
        static {
            int[] iArr = new int[CircleConstants.CIRCLE_FROM_PAGE.values().length];
            f19214a = iArr;
            try {
                iArr[CircleConstants.CIRCLE_FROM_PAGE.JOINED_CIRCLE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f19214a[CircleConstants.CIRCLE_FROM_PAGE.EXPLORE_MORE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f19214a[CircleConstants.CIRCLE_FROM_PAGE.HOT_CIRCLE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f19214a[CircleConstants.CIRCLE_FROM_PAGE.MANAGED_CIRCLE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public static void a(Context context, CircleConstants.CIRCLE_FROM_PAGE circle_from_page) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("circle_list_page", circle_from_page);
        TerminalActivity.d(context, CircleListFragment.class, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        getActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(RefreshLayout refreshLayout) {
        j().e();
    }

    private void c() {
        this.e = (CommonTopTitleNoTrans) this.i.findViewById(R.id.title);
        this.f = (RecyclerView) this.i.findViewById(R.id.list);
        this.g = (SmartRefreshLayout) this.i.findViewById(R.id.refresh_layout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        j().f();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.f19209a = getActivity();
        c();
        if (getArguments() != null) {
            this.b = (CircleConstants.CIRCLE_FROM_PAGE) getArguments().getSerializable("circle_list_page");
        }
        this.k = new CircleListAdapter(this.f19209a, this.b, getFragmentActive(), null);
        NoDataAndLoadFailView noDataAndLoadFailView = new NoDataAndLoadFailView(this.f19209a);
        this.l = noDataAndLoadFailView;
        noDataAndLoadFailView.d();
        this.k.setEmptyView(this.l);
        this.g.l(false);
        this.g.a(new OnRefreshListener() { // from class: com.blued.community.ui.circle.fragment.-$$Lambda$CircleListFragment$Ngo8VYINFCzuLit91OK3b7_eVC8
            @Override // com.scwang.smartrefresh.layout.listener.OnRefreshListener
            public final void onRefresh(RefreshLayout refreshLayout) {
                CircleListFragment.this.a(refreshLayout);
            }
        });
        this.k.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() { // from class: com.blued.community.ui.circle.fragment.-$$Lambda$CircleListFragment$PDA7LgvluVg80_7rSp4WxYPt8k8
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.RequestLoadMoreListener
            public final void onLoadMoreRequested() {
                CircleListFragment.this.d();
            }
        }, this.f);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f19209a);
        linearLayoutManager.setOrientation(1);
        this.f.setAdapter(this.k);
        this.f.setLayoutManager(linearLayoutManager);
        this.e.setLeftClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.circle.fragment.-$$Lambda$CircleListFragment$5EovrdjpoWpmBbLWhFs5LmBDHc8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CircleListFragment.this.a(view);
            }
        });
        if (this.b == CircleConstants.CIRCLE_FROM_PAGE.JOINED_CIRCLE) {
            this.e.setRightText(this.f19209a.getResources().getString(R.string.managed_circle));
            this.e.setRightTextColor(R.color.syc_i);
        } else {
            this.e.a();
        }
        int i = AnonymousClass4.f19214a[this.b.ordinal()];
        if (i == 1) {
            this.e.setRightText(this.f19209a.getResources().getString(R.string.managed_circle));
            this.e.setRightTextColor(R.color.syc_i);
            this.e.setCenterText(this.f19209a.getResources().getString(R.string.my_new_base));
            this.l.setBtnStr(R.string.more_circle_title);
            this.l.setNoDataBtnListener(new View.OnClickListener() { // from class: com.blued.community.ui.circle.fragment.CircleListFragment.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    CircleListFragment.a(CircleListFragment.this.f19209a, CircleConstants.CIRCLE_FROM_PAGE.EXPLORE_MORE);
                }
            });
        } else if (i == 2) {
            this.e.a();
            this.e.setCenterText(this.f19209a.getResources().getString(R.string.more_circle_title));
        } else if (i == 3) {
            this.e.a();
            this.e.setCenterText(this.f19209a.getResources().getString(R.string.my_new_base_hot));
        } else if (i == 4) {
            this.e.a();
            this.e.setCenterText(this.f19209a.getResources().getString(R.string.managed_circle));
        }
        this.l.setNoDataImg(R.drawable.icon_no_circle);
        this.l.setNoDataStr(R.string.no_circle_yet);
        this.f.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.blued.community.ui.circle.fragment.CircleListFragment.2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                CircleListFragment.this.b();
            }
        });
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void a(String str, List list) {
        super.a(str, list);
        if (list == null) {
            return;
        }
        boolean z = true;
        int hashCode = str.hashCode();
        if (hashCode != 300194660) {
            if (hashCode == 391102192 && str.equals("CIRCLE_ADMIN_COUNT")) {
                z = true;
            }
        } else if (str.equals("CIRCLE_DATA_LIST")) {
            z = false;
        }
        if (z) {
            if (!z) {
                return;
            }
            MvpUtils.a(list, MyCircleExtra.class, new AnonymousClass3());
            return;
        }
        this.k.setNewData(list);
        if (list.size() != 0) {
            b();
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void a(String str, boolean z) {
        super.a(str, z);
        if (str == null) {
            return;
        }
        boolean z2 = true;
        int hashCode = str.hashCode();
        if (hashCode != -1290256561) {
            if (hashCode == 623698297 && str.equals("_load_type_loadmore_")) {
                z2 = true;
            }
        } else if (str.equals("_load_type_refresh_")) {
            z2 = false;
        }
        if (!z2 || z2) {
            this.g.j();
            this.k.loadMoreComplete();
            if (this.k.getData().size() > 0) {
                this.l.d();
            } else if (z) {
                this.l.a();
            } else {
                this.l.b();
            }
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void af_() {
        super.af_();
        this.l = null;
    }

    public void b() {
        if (this.f.canScrollVertically(1) || this.f19210c || this.d) {
            return;
        }
        EventTrackFeed.a(FeedProtos.Event.CIRCLE_MORE_BTN_SHOW);
        this.f19210c = true;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.fragment_joined_circle_list;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void g_(String str) {
        super.g_(str);
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.utils.PageTimeUtils.APMInterface
    public String getPageBizName() {
        CircleConstants.CIRCLE_FROM_PAGE circle_from_page = CircleConstants.CIRCLE_FROM_PAGE.JOINED_CIRCLE;
        if (getArguments() != null) {
            circle_from_page = (CircleConstants.CIRCLE_FROM_PAGE) getArguments().getSerializable("circle_list_page");
        }
        return AnonymousClass4.f19214a[circle_from_page.ordinal()] != 1 ? super.getPageBizName() : "A71";
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void l() {
        this.g.i();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void o() {
        super.o();
        this.d = true;
        this.k.setEnableLoadMore(true);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void p() {
        super.p();
        this.d = false;
        this.k.setEnableLoadMore(false);
    }
}
