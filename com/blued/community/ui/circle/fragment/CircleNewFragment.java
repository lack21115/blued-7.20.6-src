package com.blued.community.ui.circle.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.ui.mvp.MvpUtils;
import com.blued.android.module.common.url.H5Url;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.common.widget.refresh.BluedAdapterLoadMoreView;
import com.blued.android.module.common.widget.refresh.RecommendLoadMoreView;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.circle.adapter.CircleRecommendListAdapter;
import com.blued.community.ui.circle.adapter.CircleTalkAdapter;
import com.blued.community.ui.circle.adapter.MyCircleAdapter;
import com.blued.community.ui.circle.manager.CircleConstants;
import com.blued.community.ui.circle.model.MyCircleModel;
import com.blued.community.ui.circle.presenter.CirclePresenter;
import com.blued.das.client.feed.FeedProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/fragment/CircleNewFragment.class */
public class CircleNewFragment<T extends CirclePresenter> extends MvpFragment<CirclePresenter> {
    protected CommonTopTitleNoTrans a;
    private Context b;
    private RecyclerView c;
    private SmartRefreshLayout d;
    private View e;
    private NoDataAndLoadFailView f;
    private CircleTalkAdapter g;
    private HeaderHolder k;
    private MyCircleAdapter l;
    private CircleRecommendListAdapter m;

    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/fragment/CircleNewFragment$HeaderHolder.class */
    public static class HeaderHolder {
        LinearLayout a;
        ImageView b;
        RecyclerView c;
        View d;
        LinearLayout e;
        RecyclerView f;
        RelativeLayout g;
        RelativeLayout h;
        LinearLayout i;
        TextView j;
        LinearLayout k;
        TextView l;
        ImageView m;
        LinearLayout n;
        TextView o;
        ImageView p;
        LinearLayout q;
        TextView r;
        ImageView s;

        public HeaderHolder(View view) {
            this.a = (LinearLayout) view.findViewById(R.id.my_new_base_all);
            this.b = (ImageView) view.findViewById(R.id.my_new_base_join_image);
            this.c = view.findViewById(R.id.my_new_base_recycler_view);
            this.d = view.findViewById(R.id.new_base_title);
            this.e = (LinearLayout) view.findViewById(R.id.my_new_base_recommend_more);
            this.f = view.findViewById(R.id.my_new_base_recommend_recycler_view);
            this.g = (RelativeLayout) view.findViewById(R.id.my_new_base_layout);
            this.h = (RelativeLayout) view.findViewById(R.id.my_new_base_recommend_layout);
            this.i = (LinearLayout) view.findViewById(R.id.ll_rank_layout);
            this.j = (TextView) view.findViewById(R.id.tv_rank_update_time);
            this.k = (LinearLayout) view.findViewById(R.id.ll_rank_1);
            this.l = (TextView) view.findViewById(R.id.tv_rank_title_1);
            this.m = (ImageView) view.findViewById(R.id.rank_icon_1);
            this.n = (LinearLayout) view.findViewById(R.id.ll_rank_2);
            this.o = (TextView) view.findViewById(R.id.tv_rank_title_2);
            this.p = (ImageView) view.findViewById(R.id.rank_icon_2);
            this.q = (LinearLayout) view.findViewById(R.id.ll_rank_3);
            this.r = (TextView) view.findViewById(R.id.tv_rank_title_3);
            this.s = (ImageView) view.findViewById(R.id.rank_icon_3);
        }
    }

    public static void a(Context context) {
        if (CommunityServiceManager.a().z()) {
            TerminalActivity.d(context, CircleNewFragment.class, null);
        } else {
            AppMethods.d(R.string.common_circle_service_upgraded);
        }
    }

    private void d() {
        this.a = (CommonTopTitleNoTrans) this.i.findViewById(R.id.title);
        this.c = this.i.findViewById(R.id.recycler_view);
        this.d = this.i.findViewById(R.id.refresh_layout);
        this.e = this.i.findViewById(R.id.skeleton);
    }

    private void e() {
        this.e.setVisibility(0);
    }

    private void v() {
        this.d.b(false);
        this.d.a(new OnRefreshListener() { // from class: com.blued.community.ui.circle.fragment.CircleNewFragment.2
            public void onRefresh(RefreshLayout refreshLayout) {
                CircleNewFragment.this.j().e();
            }
        });
        this.c.setLayoutManager(new LinearLayoutManager(this.b));
        CircleTalkAdapter circleTalkAdapter = new CircleTalkAdapter(this.b, getFragmentActive());
        this.g = circleTalkAdapter;
        circleTalkAdapter.a(false);
        this.c.setAdapter(this.g);
        NoDataAndLoadFailView noDataAndLoadFailView = new NoDataAndLoadFailView(this.b);
        this.f = noDataAndLoadFailView;
        noDataAndLoadFailView.setNoDataImg(R.drawable.icon_no_circle);
        this.f.setNoDataStr(R.string.circle_details_no_data);
        this.g.setEmptyView(this.f);
        this.g.setHeaderAndEmpty(true);
        this.g.setLoadMoreView(new BluedAdapterLoadMoreView());
        this.g.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() { // from class: com.blued.community.ui.circle.fragment.CircleNewFragment.3
            public void onLoadMoreRequested() {
                CircleNewFragment.this.j().f();
            }
        }, this.c);
        this.g.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() { // from class: com.blued.community.ui.circle.fragment.CircleNewFragment.4
            public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                int id = view.getId();
                if (id == R.id.new_base_header || id == R.id.new_base_name) {
                    BluedIngSelfFeed bluedIngSelfFeed = (BluedIngSelfFeed) CircleNewFragment.this.g.getData().get(i);
                    CircleDetailsFragment.a(CircleNewFragment.this.b, bluedIngSelfFeed.circle_id, bluedIngSelfFeed.feed_id, CircleConstants.CIRCLE_FROM_PAGE.FIND_CIRCLE_DISCUSS_LIST);
                }
            }
        });
        this.g.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.blued.community.ui.circle.fragment.CircleNewFragment.5
            public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                ((TextView) view.findViewById(R.id.new_base_content)).setTextColor(BluedSkinUtils.a(CircleNewFragment.this.b, R.color.syc_j));
                BluedIngSelfFeed bluedIngSelfFeed = (BluedIngSelfFeed) CircleNewFragment.this.g.getData().get(i);
                CircleNewFragment.this.g.a(bluedIngSelfFeed.feed_id);
                CirclePostDetailsFragment.a(CircleNewFragment.this.b, bluedIngSelfFeed, FeedProtos.NoteSource.NOTE_LIST);
            }
        });
    }

    private void w() {
        View inflate = View.inflate(this.b, R.layout.layout_circle_page_header, null);
        this.k = new HeaderHolder(inflate);
        this.g.addHeaderView(inflate);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.b);
        linearLayoutManager.setOrientation(0);
        this.k.c.setLayoutManager(linearLayoutManager);
        this.l = new MyCircleAdapter(getFragmentActive());
        this.k.c.setAdapter(this.l);
        this.l.setLoadMoreView(new RecommendLoadMoreView());
        this.l.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.blued.community.ui.circle.fragment.CircleNewFragment.6
            public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                List data = CircleNewFragment.this.l.getData();
                if (data != null) {
                    MyCircleModel myCircleModel = (MyCircleModel) data.get(i);
                    if (!myCircleModel.isHotBase) {
                        CircleDetailsFragment.a(CircleNewFragment.this.b, myCircleModel, CircleConstants.CIRCLE_FROM_PAGE.FIND_CIRCLE_MINE);
                        return;
                    }
                    EventTrackFeed.a(FeedProtos.Event.CIRCLE_FIND_PAGE_SHOW, FeedProtos.CircleSource.FIND_CIRCLE_HOT);
                    CircleListFragment.a(CircleNewFragment.this.b, CircleConstants.CIRCLE_FROM_PAGE.HOT_CIRCLE);
                }
            }
        });
        this.k.a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.circle.fragment.CircleNewFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                EventTrackFeed.b(FeedProtos.Event.FIND_CIRCLE_MINE_ALL_CLICK);
                CircleListFragment.a(CircleNewFragment.this.b, CircleConstants.CIRCLE_FROM_PAGE.JOINED_CIRCLE);
            }
        });
        this.k.d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.circle.fragment.CircleNewFragment.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                EventTrackFeed.b(FeedProtos.Event.FIND_CIRCLE_NOTE_MINE_CLICK);
                CircleTalkFragment.a(CircleNewFragment.this.b);
            }
        });
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this.b);
        linearLayoutManager2.setOrientation(0);
        this.k.f.setLayoutManager(linearLayoutManager2);
        this.m = new CircleRecommendListAdapter(this.b, getFragmentActive());
        this.k.f.setAdapter(this.m);
        this.k.e.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.circle.fragment.CircleNewFragment.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                EventTrackFeed.b(FeedProtos.Event.FIND_CIRCLE_RECOMMEND_MORE_CLICK);
                EventTrackFeed.a(FeedProtos.Event.CIRCLE_FIND_PAGE_SHOW, FeedProtos.CircleSource.FIND_CIRCLE_RECOMMEND);
                CircleTypeListFragment.a.a(CircleNewFragment.this.b, FeedProtos.SourcePage.CIRCLE_HOME_RECOMMEND);
            }
        });
        this.k.i.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.circle.fragment.CircleNewFragment.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                EventTrackFeed.a(FeedProtos.Event.CIRCLE_HOT_POST_BANNER_CLICK);
                CommunityServiceManager.b().a(CircleNewFragment.this.getContext(), H5Url.a(58, "1"));
            }
        });
    }

    public Map<Integer, List<MyCircleModel>> a(List<MyCircleModel> list, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(1, new ArrayList());
        for (MyCircleModel myCircleModel : list) {
            List list2 = (List) hashMap.get(Integer.valueOf(hashMap.size()));
            ArrayList arrayList = list2;
            if (list2.size() == i) {
                arrayList = new ArrayList();
                hashMap.put(Integer.valueOf(hashMap.size() + 1), arrayList);
            }
            arrayList.add(myCircleModel);
        }
        return hashMap;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.b = getContext();
        d();
        c();
        v();
        w();
        e();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void a(String str, List list) {
        boolean z;
        super.a(str, list);
        this.e.setVisibility(8);
        switch (str.hashCode()) {
            case -1755310065:
                if (str.equals("data_my_new_base_list")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1597817974:
                if (str.equals("data_hot_rank_list")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1597579847:
                if (str.equals("data_hot_rank_time")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -431176232:
                if (str.equals("data_my_new_base_list_error")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -233872522:
                if (str.equals("data_recommend_list")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1607616673:
                if (str.equals("data_base_talk_list_error")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1995579013:
                if (str.equals("data_rank_list_error")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 2026743192:
                if (str.equals("data_base_talk_list")) {
                    z = false;
                    break;
                }
                z = true;
                break;
            case 2034961053:
                if (str.equals("data_delete_feed")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            default:
                z = true;
                break;
        }
        if (!z) {
            MvpUtils.a(list, BluedIngSelfFeed.class, new MvpUtils.DataListHandler<BluedIngSelfFeed>() { // from class: com.blued.community.ui.circle.fragment.CircleNewFragment.11
                @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataListHandler
                public void a() {
                }

                @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataListHandler
                public void a(List<BluedIngSelfFeed> list2) {
                    CircleNewFragment.this.g.setNewData(list2);
                }
            });
            return;
        }
        switch (z) {
            case true:
                MvpUtils.a(list, MyCircleModel.class, new MvpUtils.DataListHandler<MyCircleModel>() { // from class: com.blued.community.ui.circle.fragment.CircleNewFragment.12
                    private void b(List<MyCircleModel> list2) {
                        CircleNewFragment.this.l.setNewData(list2);
                        if (CircleNewFragment.this.l.getData().size() > 0) {
                            CircleNewFragment.this.k.g.setVisibility(0);
                        } else {
                            CircleNewFragment.this.k.g.setVisibility(8);
                        }
                    }

                    @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataListHandler
                    public void a() {
                        b(null);
                        CircleNewFragment.this.k.g.setVisibility(8);
                    }

                    @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataListHandler
                    public void a(List<MyCircleModel> list2) {
                        b(list2);
                    }
                });
                return;
            case true:
                this.k.g.setVisibility(8);
                return;
            case true:
                MvpUtils.a(list, MyCircleModel.class, new MvpUtils.DataListHandler<MyCircleModel>() { // from class: com.blued.community.ui.circle.fragment.CircleNewFragment.13
                    @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataListHandler
                    public void a() {
                        CircleNewFragment.this.k.h.setVisibility(8);
                    }

                    @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataListHandler
                    public void a(List<MyCircleModel> list2) {
                        if (list2.size() <= 0) {
                            CircleNewFragment.this.k.h.setVisibility(8);
                            return;
                        }
                        CircleNewFragment.this.k.h.setVisibility(0);
                        ArrayList arrayList = new ArrayList();
                        for (List<MyCircleModel> list3 : CircleNewFragment.this.a(list2, 2).values()) {
                            MyCircleModel myCircleModel = new MyCircleModel();
                            myCircleModel.circleModelList = new ArrayList();
                            myCircleModel.circleModelList.addAll(list3);
                            arrayList.add(myCircleModel);
                        }
                        CircleNewFragment.this.m.setNewData(arrayList);
                    }
                });
                return;
            case true:
                MvpUtils.a(list, BluedIngSelfFeed.class, new MvpUtils.DataListHandler<BluedIngSelfFeed>() { // from class: com.blued.community.ui.circle.fragment.CircleNewFragment.14
                    private void a(BluedIngSelfFeed bluedIngSelfFeed, LinearLayout linearLayout, TextView textView, View view) {
                        int i = 0;
                        linearLayout.setVisibility(0);
                        String str2 = !TextUtils.isEmpty(bluedIngSelfFeed.head) ? bluedIngSelfFeed.head : bluedIngSelfFeed.feed_content;
                        textView.setText(!TextUtils.isEmpty(str2) ? str2.trim() : "");
                        if (bluedIngSelfFeed.is_recommend != 1) {
                            i = 8;
                        }
                        view.setVisibility(i);
                    }

                    @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataListHandler
                    public void a() {
                        CircleNewFragment.this.k.i.setVisibility(8);
                    }

                    @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataListHandler
                    public void a(List<BluedIngSelfFeed> list2) {
                        CircleNewFragment.this.k.k.setVisibility(8);
                        CircleNewFragment.this.k.n.setVisibility(8);
                        CircleNewFragment.this.k.q.setVisibility(8);
                        if (list2.size() > 0) {
                            CircleNewFragment.this.k.i.setVisibility(0);
                            a(list2.get(0), CircleNewFragment.this.k.k, CircleNewFragment.this.k.l, CircleNewFragment.this.k.m);
                        } else {
                            CircleNewFragment.this.k.i.setVisibility(8);
                        }
                        if (list2.size() > 1) {
                            a(list2.get(1), CircleNewFragment.this.k.n, CircleNewFragment.this.k.o, CircleNewFragment.this.k.p);
                        }
                        if (list2.size() > 2) {
                            a(list2.get(2), CircleNewFragment.this.k.q, CircleNewFragment.this.k.r, CircleNewFragment.this.k.s);
                        }
                    }
                });
                return;
            case true:
                MvpUtils.a(list, Long.class, new MvpUtils.DataHandler<Long>() { // from class: com.blued.community.ui.circle.fragment.CircleNewFragment.15
                    @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataHandler
                    public void a() {
                        CircleNewFragment.this.k.j.setVisibility(8);
                    }

                    @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataHandler
                    public void a(Long l) {
                        String d = TimeAndDateUtils.d(CircleNewFragment.this.b, l.longValue() * 1000);
                        if (d == null || d.length() <= 2) {
                            CircleNewFragment.this.k.j.setVisibility(8);
                            return;
                        }
                        CircleNewFragment.this.k.j.setText((d.substring(0, d.length() - 2) + "00") + CircleNewFragment.this.b.getString(R.string.circle_update));
                    }
                });
                return;
            case true:
                this.k.i.setVisibility(8);
                return;
            case true:
                MvpUtils.a(list, String.class, new MvpUtils.DataHandler<String>() { // from class: com.blued.community.ui.circle.fragment.CircleNewFragment.16
                    @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataHandler
                    public void a() {
                    }

                    @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataHandler
                    public void a(String str2) {
                        CircleNewFragment.this.g.b(str2);
                    }
                });
                return;
            default:
                return;
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void a(String str, boolean z) {
        boolean z2;
        super.a(str, z);
        int hashCode = str.hashCode();
        if (hashCode != -1290256561) {
            if (hashCode == 623698297 && str.equals("_load_type_loadmore_")) {
                z2 = true;
            }
            z2 = true;
        } else {
            if (str.equals("_load_type_refresh_")) {
                z2 = false;
            }
            z2 = true;
        }
        if (!z2 || z2) {
            this.d.g();
            this.g.loadMoreComplete();
            if (this.g.getItemCount() == 2) {
                if (z) {
                    this.f.a();
                } else {
                    this.f.b();
                }
            }
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void af_() {
        super.af_();
    }

    protected void b() {
        this.d.i();
    }

    public void c() {
        this.a.setLeftClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.circle.fragment.CircleNewFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                CircleNewFragment.this.t();
            }
        });
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.fragment_new_base;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void l() {
        j().e();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void o() {
        super.o();
        this.g.setEnableLoadMore(true);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void p() {
        super.p();
        this.g.setEnableLoadMore(false);
    }
}
