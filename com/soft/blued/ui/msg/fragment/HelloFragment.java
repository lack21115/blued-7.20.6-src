package com.soft.blued.ui.msg.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshBase;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshRecyclerView;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.DistanceUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.community.view.FloatFooterView;
import com.blued.das.guy.GuyProtos;
import com.blued.das.message.MessageProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.soft.blued.R;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.log.track.EventTrackGuy;
import com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter;
import com.soft.blued.ui.find.manager.CallHelloManager;
import com.soft.blued.ui.find.model.CallMeStatusData;
import com.soft.blued.ui.find.model.HelloDataExtra;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.find.observer.CallHelloObserver;
import com.soft.blued.ui.msg.adapter.PeopleHelloQuickAdapter;
import com.soft.blued.ui.msg.fragment.HelloFilterDialogFragment;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.BluedPreferences;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/fragment/HelloFragment.class */
public class HelloFragment extends BaseFragment implements View.OnClickListener, CallHelloObserver.ICallHelloObserver {

    /* renamed from: a  reason: collision with root package name */
    public NoDataAndLoadFailView f18676a;

    /* renamed from: c  reason: collision with root package name */
    private Context f18677c;
    private View d;
    private CommonTopTitleNoTrans e;
    private LinearLayout f;
    private ShapeTextView g;
    private ShapeTextView h;
    private LinearLayout i;
    private TextView j;
    private ImageView k;
    private PullToRefreshRecyclerView l;
    private RecyclerView m;
    private PeopleGridQuickAdapter n;
    private FloatFooterView o;
    private boolean r;
    private String s;
    private String t;
    private boolean u;
    private int p = 1;
    private int q = 30;
    public BluedUIHttpResponse b = new BluedUIHttpResponse<BluedEntity<UserFindResult, HelloDataExtra>>(getFragmentActive()) { // from class: com.soft.blued.ui.msg.fragment.HelloFragment.5

        /* renamed from: a  reason: collision with root package name */
        boolean f18683a = false;

        public boolean onUIFailure(int i, String str) {
            this.f18683a = true;
            return super.onUIFailure(i, str);
        }

        public void onUIFinish() {
            if (HelloFragment.this.n == null) {
                HelloFragment.this.a(0);
            }
            if (!this.f18683a) {
                if (HelloFragment.this.r) {
                    HelloFragment.this.n.setEnableLoadMore(true);
                } else {
                    HelloFragment.this.n.loadMoreEnd();
                    HelloFragment.this.n.setEnableLoadMore(false);
                }
                if (HelloFragment.this.n.getItemCount() == 0) {
                    HelloFragment.this.f18676a.a();
                }
            } else if (HelloFragment.this.n.getItemCount() == 0) {
                HelloFragment.this.f18676a.b();
            }
            HelloFragment.this.n.notifyDataSetChanged();
            HelloFragment.this.l.j();
            HelloFragment.this.n.loadMoreComplete();
            this.f18683a = false;
        }

        public void onUIStart() {
            super.onUIStart();
        }

        public void onUIUpdate(BluedEntity<UserFindResult, HelloDataExtra> bluedEntity) {
            if (bluedEntity != null) {
                if (bluedEntity.extra != null) {
                    HelloFragment.this.a(((HelloDataExtra) bluedEntity.extra).table_type);
                }
                HelloFragment.this.r = bluedEntity.hasMore();
                if (!bluedEntity.hasData()) {
                    HelloFragment.this.n.setNewData(null);
                    HelloFragment.this.f18676a.a();
                    return;
                }
                if (HelloFragment.this.p == 1) {
                    HelloFragment.this.n.setNewData(bluedEntity.data);
                } else {
                    HelloFragment.this.n.addData((Collection<? extends UserFindResult>) bluedEntity.data);
                }
                HelloFragment.this.f18676a.d();
                HelloFragment.this.n.notifyDataSetChanged();
            }
        }

        public BluedEntity<UserFindResult, HelloDataExtra> parseData(String str) {
            BluedEntity<UserFindResult, HelloDataExtra> parseData = super.parseData(str);
            if (parseData != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= parseData.data.size()) {
                        break;
                    }
                    ((UserFindResult) parseData.data.get(i2)).distance = DistanceUtils.a(((UserFindResult) parseData.data.get(i2)).distance, BlueAppLocal.c(), false);
                    ((UserFindResult) parseData.data.get(i2)).last_operate = TimeAndDateUtils.a(HelloFragment.this.f18677c, TimeAndDateUtils.c(((UserFindResult) parseData.data.get(i2)).last_operate));
                    i = i2 + 1;
                }
            }
            return parseData;
        }
    };
    private RecyclerView.OnScrollListener v = new RecyclerView.OnScrollListener() { // from class: com.soft.blued.ui.msg.fragment.HelloFragment.6
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (HelloFragment.this.o == null || i != 0) {
                return;
            }
            if (!recyclerView.canScrollVertically(-1)) {
                HelloFragment.this.o.startBtmBtnShow();
            } else if (recyclerView.canScrollVertically(1)) {
            } else {
                HelloFragment.this.o.startBtmBtnHide();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (i2 < 0) {
                HelloFragment.this.o.startBtmBtnShow();
            } else if (i2 > 0) {
                HelloFragment.this.o.startBtmBtnHide();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        Log.v("drb", "initAdapter:" + i);
        if (this.n == null) {
            this.n = new PeopleHelloQuickAdapter(new ArrayList(), getActivity(), getFragmentActive(), "msg_hello_detail", this.m, this);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this.f18677c, 3);
            this.l.getLayoutParams();
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.l.getLayoutParams();
            layoutParams.leftMargin = DensityUtils.a(this.f18677c, 3.0f);
            layoutParams.rightMargin = 0;
            this.l.setLayoutParams(layoutParams);
            this.m.setLayoutManager(gridLayoutManager);
            this.n.setEmptyView((View) this.f18676a);
            this.n.a("intelligent".equals(this.s) ? MessageProtos.SortType.AI_SORT_TYPE : MessageProtos.SortType.DISTANCE_SORT_TYPE);
            this.n.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() { // from class: com.soft.blued.ui.msg.fragment.HelloFragment.3
                @Override // com.chad.library.adapter.base.BaseQuickAdapter.RequestLoadMoreListener
                public void onLoadMoreRequested() {
                    HelloFragment.b(HelloFragment.this);
                    HelloFragment.this.a(false);
                }
            }, this.m);
            this.m.setAdapter(this.n);
        }
    }

    public static void a(Context context, String str) {
        if (BluedConfig.a().X()) {
            HelloCallNewFragment.b.a(context, str);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("hello_title", str);
        TerminalActivity.d(context, HelloFragment.class, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (z) {
            this.p = 1;
        }
        if (this.u) {
            UserHttpUtils.a(this.f18677c, this.b, this.p + "", this.q + "", this.s, this.t, "", getFragmentActive());
            return;
        }
        UserHttpUtils.a(this.f18677c, this.b, this.p + "", this.q + "", "", "", "", getFragmentActive());
    }

    static /* synthetic */ int b(HelloFragment helloFragment) {
        int i = helloFragment.p;
        helloFragment.p = i + 1;
        return i;
    }

    private void b() {
        this.s = BluedPreferences.ds();
        this.t = BluedPreferences.dt();
    }

    private void b(CallMeStatusData callMeStatusData) {
        if (callMeStatusData == null) {
            return;
        }
        CallHelloManager.a().c();
        int i = callMeStatusData.call_status;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    this.o.setBtnText(R.string.call_under_review);
                    return;
                } else if (i != 4) {
                    if (i != 5) {
                        return;
                    }
                    this.o.setBtnText(getResources().getString(R.string.finish_call));
                    return;
                }
            }
            CallHelloManager.a().a(this.f18677c, (IRequestHost) getFragmentActive(), 8);
        } else if (callMeStatusData.free_count != 0) {
            this.o.setBtnText(R.string.free_call);
        } else if (callMeStatusData.pay_count == 0) {
            this.o.setBtnText(R.string.open_call);
        } else {
            FloatFooterView floatFooterView = this.o;
            floatFooterView.setBtnText(this.f18677c.getString(R.string.open_call_x) + " X " + callMeStatusData.pay_count);
        }
    }

    private void c() {
        CommonTopTitleNoTrans findViewById = this.d.findViewById(R.id.top_title);
        this.e = findViewById;
        findViewById.a();
        this.e.setLeftImg(2131233902);
        this.e.setLeftClickListener(this);
        this.e.setCenterText((int) R.string.hello_ing_title);
    }

    private void d() {
        this.f = (LinearLayout) this.d.findViewById(R.id.layout_filter);
        ShapeTextView findViewById = this.d.findViewById(R.id.tv_sort_left);
        this.g = findViewById;
        findViewById.setOnClickListener(this);
        ShapeTextView findViewById2 = this.d.findViewById(R.id.tv_sort_right);
        this.h = findViewById2;
        findViewById2.setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) this.d.findViewById(R.id.btn_filter);
        this.i = linearLayout;
        linearLayout.setOnClickListener(this);
        this.j = (TextView) this.d.findViewById(R.id.tv_filter);
        this.k = (ImageView) this.d.findViewById(R.id.iv_filter);
        f();
        i();
        boolean E = BluedConfig.a().E();
        this.u = E;
        if (E) {
            this.f.setVisibility(0);
        } else {
            this.f.setVisibility(8);
        }
    }

    private void e() {
        FloatFooterView floatFooterView = (FloatFooterView) this.d.findViewById(R.id.ffv_bottom);
        this.o = floatFooterView;
        floatFooterView.setOnBtnClickListener(new FloatFooterView.OnBtnClickListener() { // from class: com.soft.blued.ui.msg.fragment.HelloFragment.1
            @Override // com.blued.community.view.FloatFooterView.OnBtnClickListener
            public void onPostFeedClick() {
                CallHelloManager.a().a(HelloFragment.this.f18677c, (IRequestHost) HelloFragment.this.getFragmentActive(), 8, new CallHelloManager.ToOpenListener() { // from class: com.soft.blued.ui.msg.fragment.HelloFragment.1.1
                    @Override // com.soft.blued.ui.find.manager.CallHelloManager.ToOpenListener
                    public void done(boolean z) {
                        if (z) {
                            CallHelloManager.a().a(HelloFragment.this.getContext(), (IRequestHost) HelloFragment.this.getFragmentActive(), false, 8);
                        }
                    }
                });
                CallMeStatusData b = CallHelloManager.a().b();
                if (b != null) {
                    int i = b.call_status;
                    if (i == 0) {
                        if (b.free_count != 0) {
                            EventTrackGuy.a(GuyProtos.Event.VOCATIVE_SECOND_BTN_CLICK, GuyProtos.BtnType.FREE_VOCATIVE);
                            return;
                        } else if (b.pay_count != 0) {
                            EventTrackGuy.a(GuyProtos.Event.VOCATIVE_SECOND_BTN_CLICK, GuyProtos.BtnType.OPEN_VOCATIVE_NUM);
                            return;
                        } else {
                            EventTrackGuy.a(GuyProtos.Event.VOCATIVE_SECOND_BTN_CLICK, GuyProtos.BtnType.OPEN_VOCATIVE);
                            return;
                        }
                    }
                    if (i != 1) {
                        if (i == 2) {
                            EventTrackGuy.a(GuyProtos.Event.VOCATIVE_SECOND_BTN_CLICK, GuyProtos.BtnType.IN_CHECK);
                            return;
                        } else if (i != 4) {
                            if (i != 5) {
                                return;
                            }
                            EventTrackGuy.a(GuyProtos.Event.VOCATIVE_SECOND_BTN_CLICK, GuyProtos.BtnType.COMPLETE_VOCATIVE);
                            return;
                        }
                    }
                    EventTrackGuy.a(GuyProtos.Event.VOCATIVE_SECOND_BTN_CLICK, GuyProtos.BtnType.IN_VOCATIVE);
                }
            }
        });
    }

    private void f() {
        if ("intelligent".equals(this.s)) {
            g();
        } else {
            h();
        }
    }

    private void g() {
        ShapeHelper.a(this.g, 2131102254);
        ShapeHelper.a(this.h, 2131102263);
        this.s = "intelligent";
        BluedPreferences.Z("intelligent");
    }

    private void h() {
        ShapeHelper.a(this.h, 2131102254);
        ShapeHelper.a(this.g, 2131102263);
        this.s = "distance";
        BluedPreferences.Z("distance");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (TextUtils.isEmpty(this.t)) {
            j();
        } else {
            k();
        }
    }

    private void j() {
        this.j.setTextColor(BluedSkinUtils.a(this.f18677c, 2131102254));
        this.k.setImageDrawable(BluedSkinUtils.b(this.f18677c, (int) R.drawable.icon_nearby_filter_off));
    }

    private void k() {
        this.j.setTextColor(BluedSkinUtils.a(this.f18677c, 2131101766));
        this.k.setImageDrawable(BluedSkinUtils.b(this.f18677c, (int) R.drawable.icon_nearby_filter_on));
    }

    private void l() {
        NoDataAndLoadFailView noDataAndLoadFailView = new NoDataAndLoadFailView(this.f18677c);
        this.f18676a = noDataAndLoadFailView;
        noDataAndLoadFailView.setNoDataStr((int) R.string.people_search_no_data_tip);
        this.f18676a.setNoDataImg(2131233637);
        this.f18676a.d();
        PullToRefreshRecyclerView findViewById = this.d.findViewById(R.id.grid_view);
        this.l = findViewById;
        this.m = (RecyclerView) findViewById.getRefreshableView();
        this.l.setRefreshEnabled(true);
        this.l.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<RecyclerView>() { // from class: com.soft.blued.ui.msg.fragment.HelloFragment.2
            public void onRefresh(PullToRefreshBase<RecyclerView> pullToRefreshBase) {
                HelloFragment.this.a(true);
            }
        });
        this.m.addOnScrollListener(this.v);
        this.l.k();
        CallHelloManager.a().a(this.f18677c, (IRequestHost) getFragmentActive(), 8, (CallHelloManager.ToOpenListener) null);
    }

    public String a() {
        return this.t;
    }

    @Override // com.soft.blued.ui.find.observer.CallHelloObserver.ICallHelloObserver
    public void a(CallMeStatusData callMeStatusData) {
        b(callMeStatusData);
    }

    @Override // com.soft.blued.ui.find.observer.CallHelloObserver.ICallHelloObserver
    public void a(boolean z, String str) {
    }

    @Override // com.soft.blued.ui.find.observer.CallHelloObserver.ICallHelloObserver
    public void b(int i) {
        this.o.setBtnText(TimeAndDateUtils.a(i, false));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        switch (view.getId()) {
            case R.id.btn_filter /* 2131362570 */:
                HelloFilterDialogFragment helloFilterDialogFragment = new HelloFilterDialogFragment();
                helloFilterDialogFragment.a(new HelloFilterDialogFragment.OnHelloFilterChange() { // from class: com.soft.blued.ui.msg.fragment.HelloFragment.4
                    @Override // com.soft.blued.ui.msg.fragment.HelloFilterDialogFragment.OnHelloFilterChange
                    public void change(String str) {
                        HelloFragment.this.t = str;
                        HelloFragment.this.i();
                        HelloFragment.this.m.scrollToPosition(0);
                        HelloFragment.this.l.k();
                    }
                });
                helloFilterDialogFragment.show(getActivity().getSupportFragmentManager(), HelloFilterDialogFragment.class.getSimpleName());
                return;
            case 2131363120:
                getActivity().finish();
                return;
            case R.id.tv_sort_left /* 2131372621 */:
                EventTrackGuy.a(GuyProtos.Event.VOCATIVE_SECOND_AUTO_SORT_CLICK);
                g();
                this.l.k();
                PeopleGridQuickAdapter peopleGridQuickAdapter = this.n;
                if (peopleGridQuickAdapter != null) {
                    peopleGridQuickAdapter.a(MessageProtos.SortType.AI_SORT_TYPE);
                    return;
                }
                return;
            case R.id.tv_sort_right /* 2131372622 */:
                EventTrackGuy.a(GuyProtos.Event.VOCATIVE_SECOND_DISTANCE_SORT_CLICK);
                h();
                this.l.k();
                PeopleGridQuickAdapter peopleGridQuickAdapter2 = this.n;
                if (peopleGridQuickAdapter2 != null) {
                    peopleGridQuickAdapter2.a(MessageProtos.SortType.DISTANCE_SORT_TYPE);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.d;
        if (view == null) {
            this.d = layoutInflater.inflate(R.layout.fragment_hello, viewGroup, false);
            this.f18677c = getActivity();
            b();
            c();
            d();
            e();
            l();
            CallHelloObserver.a().a(this, getLifecycle());
        } else if (view.getParent() != null) {
            ((ViewGroup) this.d.getParent()).removeView(this.d);
        }
        return this.d;
    }
}
