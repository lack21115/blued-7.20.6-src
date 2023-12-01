package com.soft.blued.ui.find.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshBase;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshRecyclerView;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.utils.CommonPreferences;
import com.blued.android.module.common.utils.DistanceUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.soft.blued.R;
import com.soft.blued.http.NearbyHttpUtils;
import com.soft.blued.model.BluedMyExtra;
import com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter;
import com.soft.blued.ui.find.adapter.PeopleListQuickAdapter;
import com.soft.blued.ui.find.model.FilterEntity;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.find.observer.SetModelObserver;
import com.soft.blued.utils.BluedPreferences;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/NearbyModuleUsersFragment.class */
public class NearbyModuleUsersFragment extends BaseFragment implements SetModelObserver.ISetModelObserver {
    public static String b = "module_cid";

    /* renamed from: c  reason: collision with root package name */
    public static String f16751c = "module_tips";
    public int d;
    public String e;
    public NoDataAndLoadFailView f;
    public NoDataAndLoadFailView g;
    public boolean h;
    private Context j;
    private View k;
    private ViewFlipper l;
    private PullToRefreshRecyclerView m;
    private RecyclerView n;
    private PeopleGridQuickAdapter o;
    private int p;
    private PullToRefreshRecyclerView q;
    private RecyclerView r;
    private PeopleListQuickAdapter s;
    private String w;
    private String x;
    private CommonTopTitleNoTrans y;
    private int t = 60;
    private int u = 1;
    private boolean v = false;

    /* renamed from: a  reason: collision with root package name */
    public int f16752a = 0;
    BluedUIHttpResponse i = new BluedUIHttpResponse<BluedEntity<UserFindResult, BluedMyExtra>>(getFragmentActive()) { // from class: com.soft.blued.ui.find.fragment.NearbyModuleUsersFragment.10
        public boolean onUIFailure(int i, String str) {
            NearbyModuleUsersFragment.this.h = true;
            return super.onUIFailure(i, str);
        }

        public void onUIFinish() {
            NearbyModuleUsersFragment.this.s.setEmptyView((View) NearbyModuleUsersFragment.this.g);
            NearbyModuleUsersFragment.this.o.setEmptyView((View) NearbyModuleUsersFragment.this.f);
            NearbyModuleUsersFragment.this.m.j();
            NearbyModuleUsersFragment.this.s.loadMoreComplete();
            NearbyModuleUsersFragment.this.o.loadMoreComplete();
            NearbyModuleUsersFragment.this.q.j();
            if (NearbyModuleUsersFragment.this.h) {
                NearbyModuleUsersFragment.this.g.b();
                NearbyModuleUsersFragment.this.f.b();
            } else if (NearbyModuleUsersFragment.this.o.getItemCount() == 0 || NearbyModuleUsersFragment.this.s.getItemCount() == 0) {
                NearbyModuleUsersFragment.this.g.a();
                NearbyModuleUsersFragment.this.f.a();
            }
            NearbyModuleUsersFragment.this.o.notifyDataSetChanged();
            NearbyModuleUsersFragment.this.s.notifyDataSetChanged();
            NearbyModuleUsersFragment.this.h = false;
        }

        public void onUIUpdate(BluedEntity<UserFindResult, BluedMyExtra> bluedEntity) {
            if (bluedEntity.hasMore()) {
                NearbyModuleUsersFragment.this.v = true;
                NearbyModuleUsersFragment.this.o.setEnableLoadMore(true);
                NearbyModuleUsersFragment.this.s.setEnableLoadMore(true);
            } else {
                NearbyModuleUsersFragment.this.o.setEnableLoadMore(false);
                NearbyModuleUsersFragment.this.s.setEnableLoadMore(false);
                NearbyModuleUsersFragment.this.v = false;
            }
            if (bluedEntity.data == null || bluedEntity.data.size() <= 0) {
                if (NearbyModuleUsersFragment.this.u != 1) {
                    NearbyModuleUsersFragment.h(NearbyModuleUsersFragment.this);
                    AppMethods.a(NearbyModuleUsersFragment.this.j.getResources().getString(2131887275));
                    return;
                }
                return;
            }
            if (NearbyModuleUsersFragment.this.u == 1) {
                NearbyModuleUsersFragment.this.o.setNewData(bluedEntity.data);
                NearbyModuleUsersFragment.this.s.setNewData(bluedEntity.data);
            } else {
                NearbyModuleUsersFragment.this.o.addData((Collection<? extends UserFindResult>) bluedEntity.data);
                NearbyModuleUsersFragment.this.s.addData((Collection<? extends UserFindResult>) bluedEntity.data);
            }
            if (bluedEntity.extra != null) {
                NearbyModuleUsersFragment.this.w = ((BluedMyExtra) bluedEntity.extra).getNext_min_dist();
                NearbyModuleUsersFragment.this.x = ((BluedMyExtra) bluedEntity.extra).getNext_skip_uid();
            }
        }

        public BluedEntity<UserFindResult, BluedMyExtra> parseData(String str) {
            BluedEntity<UserFindResult, BluedMyExtra> parseData = super.parseData(str);
            if (parseData != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= parseData.data.size()) {
                        break;
                    }
                    UserBasicModel userBasicModel = (UserBasicModel) parseData.data.get(i2);
                    userBasicModel.last_operate = TimeAndDateUtils.a(NearbyModuleUsersFragment.this.j, TimeAndDateUtils.c(userBasicModel.last_operate));
                    userBasicModel.distance = DistanceUtils.a(userBasicModel.distance, BlueAppLocal.c(), false);
                    i = i2 + 1;
                }
            }
            return parseData;
        }
    };

    private void a() {
        this.p = PeopleGridQuickAdapter.a(this.j);
        this.f = new NoDataAndLoadFailView(this.j);
        this.g = new NoDataAndLoadFailView(this.j);
        ViewFlipper viewFlipper = (ViewFlipper) this.k.findViewById(R.id.viewFlipper);
        this.l = viewFlipper;
        viewFlipper.setInAnimation(AnimationUtils.loadAnimation(this.j, 2130772118));
        this.l.setOutAnimation(AnimationUtils.loadAnimation(this.j, 2130772119));
        if (BluedPreferences.J() == 0) {
            this.l.setDisplayedChild(0);
            this.f16752a = 0;
            this.y.setRightImg((int) R.drawable.icon_module_list_mode);
            return;
        }
        this.l.setDisplayedChild(1);
        this.f16752a = 1;
        this.y.setRightImg((int) R.drawable.icon_module_grid_mode);
    }

    public static void a(Context context, int i, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt(b, i);
        bundle.putString(f16751c, str);
        TerminalActivity.d(context, NearbyModuleUsersFragment.class, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        FilterEntity filterEntity = new FilterEntity();
        filterEntity.longitude = CommonPreferences.u();
        filterEntity.sort_by = "detail";
        filterEntity.latitude = CommonPreferences.v();
        filterEntity.nickName = "";
        filterEntity.limit = this.t + "";
        filterEntity.source = UserFindResult.USER_SORT_BY.NEARBY;
        filterEntity.cid = this.d;
        filterEntity.column = PeopleGridQuickAdapter.a(this.j);
        if (z) {
            this.u = 1;
        } else if (!this.v) {
            return;
        } else {
            this.u++;
            filterEntity.next_min_dist = this.w;
            filterEntity.next_skip_uid = this.x;
        }
        int i = this.t;
        int i2 = this.u;
        filterEntity.start = (i * (i2 - 1)) + "";
        NearbyHttpUtils.b(getActivity(), this.i, filterEntity, "", getFragmentActive());
    }

    private void b() {
        PullToRefreshRecyclerView findViewById = this.k.findViewById(R.id.gird_view);
        this.m = findViewById;
        this.n = (RecyclerView) findViewById.getRefreshableView();
        this.m.setRefreshEnabled(true);
        this.n.setClipToPadding(false);
        this.n.setScrollBarStyle(33554432);
        if (this.f16752a == 0) {
            this.m.postDelayed(new Runnable() { // from class: com.soft.blued.ui.find.fragment.NearbyModuleUsersFragment.1
                @Override // java.lang.Runnable
                public void run() {
                    NearbyModuleUsersFragment.this.m.k();
                }
            }, 100L);
        }
        this.m.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<RecyclerView>() { // from class: com.soft.blued.ui.find.fragment.NearbyModuleUsersFragment.2
            public void onRefresh(PullToRefreshBase<RecyclerView> pullToRefreshBase) {
                NearbyModuleUsersFragment.this.a(true);
            }
        });
        ArrayList arrayList = new ArrayList();
        FragmentActivity activity = getActivity();
        ActivityFragmentActive fragmentActive = getFragmentActive();
        PeopleGridQuickAdapter peopleGridQuickAdapter = new PeopleGridQuickAdapter(arrayList, activity, fragmentActive, "module_detail" + this.d, this.n);
        this.o = peopleGridQuickAdapter;
        this.n.setAdapter(peopleGridQuickAdapter);
        this.o.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() { // from class: com.soft.blued.ui.find.fragment.NearbyModuleUsersFragment.3
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.RequestLoadMoreListener
            public void onLoadMoreRequested() {
                NearbyModuleUsersFragment.this.a(false);
            }
        }, this.n);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.j, this.p);
        this.n.setLayoutManager(gridLayoutManager);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.soft.blued.ui.find.fragment.NearbyModuleUsersFragment.4
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i) {
                int i2 = NearbyModuleUsersFragment.this.p;
                if (NearbyModuleUsersFragment.this.o.getItem(i) != 0) {
                    int itemViewType = NearbyModuleUsersFragment.this.o.getItemViewType(i);
                    if (itemViewType != 10) {
                        return itemViewType != 11 ? NearbyModuleUsersFragment.this.p : NearbyModuleUsersFragment.this.p;
                    }
                    i2 = 1;
                }
                return i2;
            }
        });
    }

    private void c() {
        PullToRefreshRecyclerView findViewById = this.k.findViewById(R.id.list_view);
        this.q = findViewById;
        this.r = (RecyclerView) findViewById.getRefreshableView();
        this.q.setRefreshEnabled(true);
        this.r.setClipToPadding(false);
        this.r.setScrollBarStyle(33554432);
        if (this.f16752a == 1) {
            this.q.postDelayed(new Runnable() { // from class: com.soft.blued.ui.find.fragment.NearbyModuleUsersFragment.5
                @Override // java.lang.Runnable
                public void run() {
                    NearbyModuleUsersFragment.this.q.k();
                }
            }, 100L);
        }
        this.q.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<RecyclerView>() { // from class: com.soft.blued.ui.find.fragment.NearbyModuleUsersFragment.6
            public void onRefresh(PullToRefreshBase<RecyclerView> pullToRefreshBase) {
                NearbyModuleUsersFragment.this.a(true);
            }
        });
        ArrayList arrayList = new ArrayList();
        FragmentActivity activity = getActivity();
        ActivityFragmentActive fragmentActive = getFragmentActive();
        PeopleListQuickAdapter peopleListQuickAdapter = new PeopleListQuickAdapter(arrayList, activity, fragmentActive, "module_detail" + this.d, this.r);
        this.s = peopleListQuickAdapter;
        peopleListQuickAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() { // from class: com.soft.blued.ui.find.fragment.NearbyModuleUsersFragment.7
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.RequestLoadMoreListener
            public void onLoadMoreRequested() {
                NearbyModuleUsersFragment.this.a(false);
            }
        }, this.r);
        this.r.setAdapter(this.s);
        this.r.setLayoutManager(new GridLayoutManager(this.j, 1));
    }

    private void d() {
        CommonTopTitleNoTrans findViewById = this.k.findViewById(2131370694);
        this.y = findViewById;
        findViewById.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.NearbyModuleUsersFragment.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                NearbyModuleUsersFragment.this.getActivity().finish();
            }
        });
        this.y.setCenterText(this.e);
        this.y.setRightClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.NearbyModuleUsersFragment.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                int i = 1;
                if (NearbyModuleUsersFragment.this.f16752a == 0) {
                    BluedPreferences.b(1);
                    NearbyModuleUsersFragment.this.y.setRightImg((int) R.drawable.icon_module_grid_mode);
                } else {
                    BluedPreferences.b(0);
                    NearbyModuleUsersFragment.this.y.setRightImg((int) R.drawable.icon_module_list_mode);
                    i = 0;
                }
                SetModelObserver.a().a(i);
            }
        });
    }

    static /* synthetic */ int h(NearbyModuleUsersFragment nearbyModuleUsersFragment) {
        int i = nearbyModuleUsersFragment.u;
        nearbyModuleUsersFragment.u = i - 1;
        return i;
    }

    @Override // com.soft.blued.ui.find.observer.SetModelObserver.ISetModelObserver
    public void a(int i) {
        ViewFlipper viewFlipper;
        if (i != this.f16752a && (viewFlipper = this.l) != null) {
            viewFlipper.showNext();
        }
        this.f16752a = i;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragmentActivity activity = getActivity();
        this.j = activity;
        View view = this.k;
        if (view == null) {
            this.d = 3;
            this.e = activity.getResources().getString(R.string.man_god);
            this.k = layoutInflater.inflate(R.layout.fragment_hot_man, viewGroup, false);
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.d = arguments.getInt(b);
                this.e = arguments.getString(f16751c);
            }
            d();
            a();
            b();
            c();
            SetModelObserver.a().a(this);
        } else if (view.getParent() != null) {
            ((ViewGroup) this.k.getParent()).removeView(this.k);
        }
        return this.k;
    }

    public void onDestroy() {
        super.onDestroy();
        SetModelObserver.a().b(this);
    }
}
