package com.soft.blued.ui.find.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ViewFlipper;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.view.PauseOnScrollListener;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshRecyclerView;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.CommonPreferences;
import com.blued.android.module.common.utils.DistanceUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.soft.blued.R;
import com.soft.blued.http.NearbyHttpUtils;
import com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter;
import com.soft.blued.ui.find.adapter.PeopleListQuickAdapter;
import com.soft.blued.ui.find.model.FilterEntity;
import com.soft.blued.ui.find.model.FindDataExtra;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.find.observer.FloatRedBagViewScrollObserver;
import com.soft.blued.ui.find.observer.HomeADDataObserver;
import com.soft.blued.ui.find.observer.PeopleDataObserver;
import com.soft.blued.ui.find.observer.SetModelObserver;
import com.soft.blued.ui.find.observer.SwipeRefreshObserver;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/NearbyPeopleTabPageFragment.class */
public class NearbyPeopleTabPageFragment extends BaseFragment implements PeopleDataObserver.IFriendsDataRefreshObserver, SetModelObserver.ISetModelObserver {

    /* renamed from: a  reason: collision with root package name */
    public Context f16834a;
    public View b;
    protected PullToRefreshRecyclerView d;
    protected PullToRefreshRecyclerView e;
    protected RecyclerView f;
    protected RecyclerView g;
    public PeopleGridQuickAdapter h;
    public int i;
    public ViewFlipper j;
    public boolean k;
    public NoDataAndLoadFailView l;
    public PauseOnScrollListener m;
    public ShapeTextView n;
    public NestedScrollView o;
    public float p;
    public float q;
    private PeopleListQuickAdapter r;
    private int s;
    private boolean w;

    /* renamed from: c  reason: collision with root package name */
    public String f16835c = UserFindResult.USER_SORT_BY.NEARBY;
    private FilterEntity t = new FilterEntity();
    private int u = 1;
    private int v = 60;

    /* renamed from: com.soft.blued.ui.find.fragment.NearbyPeopleTabPageFragment$7  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/NearbyPeopleTabPageFragment$7.class */
    class AnonymousClass7 extends GridLayoutManager.SpanSizeLookup {
        AnonymousClass7() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i) {
            int i2 = NearbyPeopleTabPageFragment.this.i;
            int i3 = i2;
            if (NearbyPeopleTabPageFragment.this.h != null) {
                i3 = i2;
                if (NearbyPeopleTabPageFragment.this.h.getItem(i) != 0) {
                    int itemViewType = NearbyPeopleTabPageFragment.this.h.getItemViewType(i);
                    if (itemViewType != 10) {
                        return itemViewType != 11 ? NearbyPeopleTabPageFragment.this.i : NearbyPeopleTabPageFragment.this.i;
                    }
                    i3 = 1;
                }
            }
            return i3;
        }
    }

    static /* synthetic */ int a(NearbyPeopleTabPageFragment nearbyPeopleTabPageFragment) {
        int i = nearbyPeopleTabPageFragment.u;
        nearbyPeopleTabPageFragment.u = i + 1;
        return i;
    }

    public void a() {
        if (getArguments() != null) {
            this.f16835c = getArguments().getString("KEY_SORT_BY");
        }
        if (StringUtils.d(this.f16835c)) {
            this.f16835c = UserFindResult.USER_SORT_BY.NEARBY;
        }
        b();
        this.o = (NestedScrollView) this.b.findViewById(R.id.nestedScrollView);
        this.j = (ViewFlipper) this.b.findViewById(R.id.viewFlipper);
        NoDataAndLoadFailView findViewById = this.b.findViewById(R.id.nodataview);
        this.l = findViewById;
        findViewById.setBackgroundColorRes(2131101191);
        ShapeTextView findViewById2 = this.b.findViewById(R.id.tv_refresh_hint);
        this.n = findViewById2;
        findViewById2.setVisibility(8);
        c();
        e();
        int J = BluedPreferences.J();
        this.s = J;
        a(J);
        f().refresh();
    }

    @Override // com.soft.blued.ui.find.observer.SetModelObserver.ISetModelObserver
    public void a(int i) {
        this.s = i;
        if (i == 0) {
            this.j.setDisplayedChild(0);
            this.t.if_grid = true;
            return;
        }
        this.j.setDisplayedChild(1);
        this.t.if_grid = false;
    }

    public void a(RecyclerView recyclerView) {
        if (!c(recyclerView) || this.w) {
            return;
        }
        AppMethods.a(this.f16834a.getResources().getString(2131891089));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public void a(BluedEntity<UserFindResult, FindDataExtra> bluedEntity, boolean z) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:632)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public void a(String str) {
    }

    public void a(boolean z) {
        if (z) {
            this.u = 1;
        }
        int i = this.v;
        int i2 = this.u;
        this.t.sort_by = this.f16835c;
        this.t.longitude = CommonPreferences.u();
        this.t.latitude = CommonPreferences.v();
        this.t.nickName = "";
        FilterEntity filterEntity = this.t;
        filterEntity.limit = this.v + "";
        this.t.column = this.i;
        this.t.scroll_type = BluedPreferences.y();
        this.t.custom = UserInfo.getInstance().getLoginUserInfo() == null ? "" : UserInfo.getInstance().getLoginUserInfo().getCustom();
        FilterEntity filterEntity2 = this.t;
        filterEntity2.start = (i * (i2 - 1)) + "";
        NearbyHttpUtils.a(this.f16834a, f(), this.t, "", getFragmentActive());
    }

    @Override // com.soft.blued.ui.find.observer.PeopleDataObserver.IFriendsDataRefreshObserver
    public void ac_() {
        if (this.k) {
            a(true);
            HomeADDataObserver.a().b();
        }
    }

    @Override // com.soft.blued.ui.find.observer.PeopleDataObserver.IFriendsDataRefreshObserver
    public void ad_() {
    }

    public View.OnTouchListener b(final RecyclerView recyclerView) {
        return new View.OnTouchListener() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleTabPageFragment.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    NearbyPeopleTabPageFragment.this.p = motionEvent.getY();
                    return false;
                } else if (action != 1) {
                    return false;
                } else {
                    NearbyPeopleTabPageFragment.this.q = motionEvent.getY();
                    if (recyclerView == null || NearbyPeopleTabPageFragment.this.q < NearbyPeopleTabPageFragment.this.p || recyclerView.canScrollVertically(-1)) {
                        return false;
                    }
                    recyclerView.stopScroll();
                    return false;
                }
            }
        };
    }

    public void b() {
        this.i = PeopleGridQuickAdapter.a(this.f16834a);
    }

    public void c() {
        PullToRefreshRecyclerView findViewById = this.b.findViewById(R.id.grid_view);
        this.d = findViewById;
        findViewById.setRefreshEnabled(false);
        RecyclerView recyclerView = (RecyclerView) this.d.getRefreshableView();
        this.f = recyclerView;
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleTabPageFragment.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView2, int i) {
                NearbyPeopleTabPageFragment.this.m.onScrollStateChanged((AbsListView) null, i);
                super.onScrollStateChanged(recyclerView2, i);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView2, int i, int i2) {
                super.onScrolled(recyclerView2, i, i2);
                FloatRedBagViewScrollObserver.a().a(recyclerView2, i, i2);
                NearbyPeopleTabPageFragment.this.a(recyclerView2);
            }
        });
        RecyclerView recyclerView2 = this.f;
        recyclerView2.setOnTouchListener(b(recyclerView2));
        d();
        this.h.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleTabPageFragment.2
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.RequestLoadMoreListener
            public void onLoadMoreRequested() {
                NearbyPeopleTabPageFragment.a(NearbyPeopleTabPageFragment.this);
                NearbyPeopleTabPageFragment.this.a(false);
            }
        }, this.f);
        this.f.setAdapter(this.h);
    }

    protected boolean c(RecyclerView recyclerView) {
        boolean z = false;
        if (recyclerView == null) {
            return false;
        }
        if (recyclerView.computeVerticalScrollExtent() + recyclerView.computeVerticalScrollOffset() >= recyclerView.computeVerticalScrollRange()) {
            z = true;
        }
        return z;
    }

    public void d() {
        this.h = new PeopleGridQuickAdapter(new ArrayList(), getActivity(), getFragmentActive(), this.f16835c, this.f);
    }

    public void e() {
        PullToRefreshRecyclerView findViewById = this.b.findViewById(R.id.list_view);
        this.e = findViewById;
        findViewById.setRefreshEnabled(false);
        RecyclerView recyclerView = (RecyclerView) this.e.getRefreshableView();
        this.g = recyclerView;
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleTabPageFragment.4
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView2, int i) {
                NearbyPeopleTabPageFragment.this.m.onScrollStateChanged((AbsListView) null, i);
                super.onScrollStateChanged(recyclerView2, i);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView2, int i, int i2) {
                super.onScrolled(recyclerView2, i, i2);
                FloatRedBagViewScrollObserver.a().a(recyclerView2, i, i2);
                if (!NearbyPeopleTabPageFragment.this.c(recyclerView2) || NearbyPeopleTabPageFragment.this.w) {
                    return;
                }
                AppMethods.a(NearbyPeopleTabPageFragment.this.f16834a.getResources().getString(2131891089));
            }
        });
        RecyclerView recyclerView2 = this.g;
        recyclerView2.setOnTouchListener(b(recyclerView2));
        PeopleListQuickAdapter peopleListQuickAdapter = new PeopleListQuickAdapter(new ArrayList(), getActivity(), getFragmentActive(), this.f16835c, this.g);
        this.r = peopleListQuickAdapter;
        peopleListQuickAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleTabPageFragment.5
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.RequestLoadMoreListener
            public void onLoadMoreRequested() {
                NearbyPeopleTabPageFragment.a(NearbyPeopleTabPageFragment.this);
                NearbyPeopleTabPageFragment.this.a(false);
            }
        }, this.g);
        this.g.setAdapter(this.r);
        this.g.setLayoutManager(new GridLayoutManager(this.f16834a, 1));
    }

    public BluedUIHttpResponse f() {
        return new BluedUIHttpResponse<BluedEntity<UserFindResult, FindDataExtra>>("nearby_user_" + this.f16835c, getFragmentActive()) { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleTabPageFragment.6

            /* renamed from: a  reason: collision with root package name */
            boolean f16841a = false;

            public void onUICache(BluedEntity<UserFindResult, FindDataExtra> bluedEntity) {
                super.onUICache(bluedEntity);
                NearbyPeopleTabPageFragment.this.a(bluedEntity, true);
            }

            public boolean onUIFailure(int i, String str) {
                this.f16841a = true;
                return super.onUIFailure(i, str);
            }

            public void onUIFinish() {
                NearbyPeopleTabPageFragment.this.f.stopScroll();
                NearbyPeopleTabPageFragment.this.g.stopScroll();
                if (!this.f16841a) {
                    if (NearbyPeopleTabPageFragment.this.w) {
                        NearbyPeopleTabPageFragment.this.h.setEnableLoadMore(true);
                        NearbyPeopleTabPageFragment.this.r.setEnableLoadMore(true);
                    } else {
                        NearbyPeopleTabPageFragment.this.h.loadMoreEnd();
                        NearbyPeopleTabPageFragment.this.h.setEnableLoadMore(false);
                        NearbyPeopleTabPageFragment.this.r.loadMoreEnd();
                        NearbyPeopleTabPageFragment.this.r.setEnableLoadMore(false);
                    }
                    if (NearbyPeopleTabPageFragment.this.h.getItemCount() == 0) {
                        NearbyPeopleTabPageFragment.this.j.setVisibility(8);
                        NearbyPeopleTabPageFragment.this.l.a();
                    } else {
                        NearbyPeopleTabPageFragment.this.j.setVisibility(0);
                    }
                } else if (NearbyPeopleTabPageFragment.this.h.getItemCount() == 0) {
                    NearbyPeopleTabPageFragment.this.j.setVisibility(8);
                    NearbyPeopleTabPageFragment.this.l.b();
                } else {
                    NearbyPeopleTabPageFragment.this.j.setVisibility(0);
                }
                SwipeRefreshObserver.a().b();
                NearbyPeopleTabPageFragment.this.h.notifyDataSetChanged();
                NearbyPeopleTabPageFragment.this.d.j();
                NearbyPeopleTabPageFragment.this.h.loadMoreComplete();
                NearbyPeopleTabPageFragment.this.r.notifyDataSetChanged();
                NearbyPeopleTabPageFragment.this.e.j();
                NearbyPeopleTabPageFragment.this.r.loadMoreComplete();
                this.f16841a = false;
            }

            public void onUIStart() {
                super.onUIStart();
            }

            public void onUIUpdate(BluedEntity<UserFindResult, FindDataExtra> bluedEntity) {
                NearbyPeopleTabPageFragment.this.a(bluedEntity, false);
            }

            public BluedEntity<UserFindResult, FindDataExtra> parseData(String str) {
                BluedEntity<UserFindResult, FindDataExtra> parseData = super.parseData(str);
                if (parseData != null && parseData.hasData()) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= parseData.data.size()) {
                            break;
                        }
                        ((UserFindResult) parseData.data.get(i2)).distance = DistanceUtils.a(((UserFindResult) parseData.data.get(i2)).distance, BlueAppLocal.c(), false);
                        ((UserFindResult) parseData.data.get(i2)).last_operate_time_stamp = ((UserFindResult) parseData.data.get(i2)).last_operate;
                        ((UserFindResult) parseData.data.get(i2)).last_operate = TimeAndDateUtils.a(NearbyPeopleTabPageFragment.this.f16834a, TimeAndDateUtils.c(((UserFindResult) parseData.data.get(i2)).last_operate));
                        i = i2 + 1;
                    }
                }
                return parseData;
            }
        };
    }

    public String getPageBizName() {
        boolean z;
        String pageBizName = super.getPageBizName();
        String str = this.f16835c;
        int hashCode = str.hashCode();
        if (hashCode == -1049482625) {
            if (str.equals(UserFindResult.USER_SORT_BY.NEARBY)) {
                z = false;
            }
            z = true;
        } else if (hashCode != -1048842402) {
            if (hashCode == -1012222381 && str.equals(UserFindResult.USER_SORT_BY.ONLINE)) {
                z = true;
            }
            z = true;
        } else {
            if (str.equals(UserFindResult.USER_SORT_BY.NEWBEE)) {
                z = true;
            }
            z = true;
        }
        return z ? !z ? !z ? pageBizName : "A33" : "A32" : "A31";
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f16834a = getActivity();
        View view = this.b;
        if (view == null) {
            this.m = new PauseOnScrollListener(false, true);
            FragmentActivity activity = getActivity();
            this.f16834a = activity;
            this.b = LayoutInflater.from(activity).inflate(R.layout.fragment_nearby_people_tabpage, viewGroup, false);
            a();
            SetModelObserver.a().a(this);
            PeopleDataObserver.a().a(this);
        } else if (view.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        return this.b;
    }

    public void onDestroy() {
        super.onDestroy();
        SetModelObserver.a().b(this);
        PeopleDataObserver.a().b(this);
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.k = z;
    }
}
