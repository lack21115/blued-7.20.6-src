package com.soft.blued.ui.tag_show;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshBase;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshRecyclerView;
import com.blued.android.module.common.utils.CommonPreferences;
import com.blued.android.module.common.utils.DistanceUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.soft.blued.R;
import com.soft.blued.http.NearbyHttpUtils;
import com.soft.blued.model.BluedMyExtra;
import com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter;
import com.soft.blued.ui.find.adapter.PeopleListQuickAdapter;
import com.soft.blued.ui.find.model.FilterEntity;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.utils.BluedPreferences;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/tag_show/TagUserFragment.class */
public class TagUserFragment extends BaseFragment {

    /* renamed from: a  reason: collision with root package name */
    public static String f33719a = "TAG_STR";
    public static String b = "TAG_ID";
    private Context d;
    private View e;
    private PullToRefreshRecyclerView f;
    private RecyclerView g;
    private int h;
    private boolean i;
    private boolean j;
    private String k;
    private String l;
    private PeopleGridQuickAdapter p;
    private PeopleListQuickAdapter q;
    private String r;
    private String s;
    private int m = 1;
    private int n = 60;
    private boolean o = true;

    /* renamed from: c  reason: collision with root package name */
    BluedUIHttpResponse f33720c = new BluedUIHttpResponse<BluedEntity<UserFindResult, BluedMyExtra>>(getFragmentActive()) { // from class: com.soft.blued.ui.tag_show.TagUserFragment.5
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIFinish() {
            super.onUIFinish();
            TagUserFragment.this.f.j();
            if (TagUserFragment.this.i) {
                TagUserFragment.this.q.loadMoreComplete();
            } else {
                TagUserFragment.this.p.loadMoreComplete();
            }
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIUpdate(BluedEntity<UserFindResult, BluedMyExtra> bluedEntity) {
            if (bluedEntity.data == null || bluedEntity.data.size() <= 0) {
                if (TagUserFragment.this.m != 1) {
                    TagUserFragment.h(TagUserFragment.this);
                }
                if (BluedPreferences.H()) {
                    AppMethods.a((CharSequence) TagUserFragment.this.d.getResources().getString(R.string.biao_find_sift_nodata));
                } else {
                    AppMethods.a((CharSequence) TagUserFragment.this.d.getResources().getString(2131887275));
                }
                if (TagUserFragment.this.i) {
                    TagUserFragment.this.q.setEnableLoadMore(false);
                    return;
                } else {
                    TagUserFragment.this.p.setEnableLoadMore(false);
                    return;
                }
            }
            if (bluedEntity.extra == null || !bluedEntity.hasMore()) {
                if (TagUserFragment.this.i) {
                    TagUserFragment.this.q.setEnableLoadMore(false);
                } else {
                    TagUserFragment.this.p.setEnableLoadMore(false);
                }
                TagUserFragment.this.o = false;
            } else {
                TagUserFragment.this.o = true;
                if (TagUserFragment.this.i) {
                    TagUserFragment.this.q.setEnableLoadMore(true);
                } else {
                    TagUserFragment.this.p.setEnableLoadMore(true);
                }
            }
            if (TagUserFragment.this.m == 1) {
                if (TagUserFragment.this.i) {
                    TagUserFragment.this.q.setNewData(bluedEntity.data);
                } else {
                    TagUserFragment.this.p.setNewData(bluedEntity.data);
                }
            } else if (TagUserFragment.this.i) {
                TagUserFragment.this.q.addData((Collection<? extends UserFindResult>) bluedEntity.data);
            } else {
                TagUserFragment.this.p.addData((Collection<? extends UserFindResult>) bluedEntity.data);
            }
            if (bluedEntity.extra != null) {
                TagUserFragment.this.k = bluedEntity.extra.getNext_min_dist();
                TagUserFragment.this.l = bluedEntity.extra.getNext_skip_uid();
            }
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public BluedEntity<UserFindResult, BluedMyExtra> parseData(String str) {
            BluedEntity<UserFindResult, BluedMyExtra> parseData = super.parseData(str);
            if (parseData != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= parseData.data.size()) {
                        break;
                    }
                    parseData.data.get(i2).distance = DistanceUtils.a(parseData.data.get(i2).distance, BlueAppLocal.c(), false);
                    parseData.data.get(i2).last_operate = TimeAndDateUtils.a(TagUserFragment.this.d, TimeAndDateUtils.c(parseData.data.get(i2).last_operate));
                    i = i2 + 1;
                }
            }
            return parseData;
        }
    };

    static /* synthetic */ int a(TagUserFragment tagUserFragment) {
        int i = tagUserFragment.m;
        tagUserFragment.m = i + 1;
        return i;
    }

    private void c() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.r = arguments.getString(b);
            this.s = arguments.getString(f33719a);
        }
        int aF = BluedPreferences.aF();
        if (aF == 1) {
            this.j = false;
        } else if (aF != 2) {
        } else {
            this.j = true;
        }
    }

    private void d() {
        this.h = PeopleGridQuickAdapter.a(this.d);
        PullToRefreshRecyclerView pullToRefreshRecyclerView = (PullToRefreshRecyclerView) this.e.findViewById(2131366898);
        this.f = pullToRefreshRecyclerView;
        boolean z = true;
        pullToRefreshRecyclerView.setRefreshEnabled(true);
        RecyclerView refreshableView = this.f.getRefreshableView();
        this.g = refreshableView;
        refreshableView.setClipToPadding(false);
        this.g.setScrollBarStyle(33554432);
        if (BluedPreferences.J() != 1) {
            z = false;
        }
        this.i = z;
        this.f.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<RecyclerView>() { // from class: com.soft.blued.ui.tag_show.TagUserFragment.1
            @Override // com.blued.android.framework.view.pulltorefresh.PullToRefreshBase.OnRefreshListener
            public void onRefresh(PullToRefreshBase<RecyclerView> pullToRefreshBase) {
                TagUserFragment.this.a(true);
            }
        });
        if (this.i) {
            a();
        } else {
            b();
        }
        this.f.k();
    }

    static /* synthetic */ int h(TagUserFragment tagUserFragment) {
        int i = tagUserFragment.m;
        tagUserFragment.m = i - 1;
        return i;
    }

    public void a() {
        PeopleListQuickAdapter peopleListQuickAdapter = new PeopleListQuickAdapter(new ArrayList(), getActivity(), getFragmentActive(), "tag_user", this.g);
        this.q = peopleListQuickAdapter;
        peopleListQuickAdapter.a(this.s);
        this.q.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() { // from class: com.soft.blued.ui.tag_show.TagUserFragment.2
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.RequestLoadMoreListener
            public void onLoadMoreRequested() {
                TagUserFragment.a(TagUserFragment.this);
                TagUserFragment.this.a(false);
            }
        }, this.g);
        this.g.setAdapter(this.q);
        this.g.setLayoutManager(new GridLayoutManager(this.d, 1));
    }

    public void a(boolean z) {
        if (z) {
            this.m = 1;
        }
        if (this.m == 1) {
            this.o = true;
        }
        if (!this.o) {
            AppMethods.a((CharSequence) this.d.getResources().getString(2131887275));
            this.f.j();
            return;
        }
        int i = this.n;
        int i2 = this.m;
        FilterEntity filterEntity = new FilterEntity();
        filterEntity.tagsid = this.r;
        filterEntity.sort_by = "index";
        filterEntity.longitude = CommonPreferences.u();
        filterEntity.latitude = CommonPreferences.v();
        filterEntity.limit = this.n + "";
        filterEntity.start = (i * (i2 - 1)) + "";
        filterEntity.source = "tag";
        filterEntity.column = PeopleGridQuickAdapter.a(this.d);
        if (this.m == 1) {
            NearbyHttpUtils.b(getActivity(), this.f33720c, filterEntity, "", getFragmentActive());
            return;
        }
        filterEntity.next_min_dist = this.k;
        filterEntity.next_skip_uid = this.l;
        NearbyHttpUtils.b(getActivity(), this.f33720c, filterEntity, "", getFragmentActive());
    }

    public void b() {
        PeopleGridQuickAdapter peopleGridQuickAdapter = new PeopleGridQuickAdapter(new ArrayList(), getActivity(), getFragmentActive(), "tag_user", this.g);
        this.p = peopleGridQuickAdapter;
        peopleGridQuickAdapter.a(this.s);
        this.p.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() { // from class: com.soft.blued.ui.tag_show.TagUserFragment.3
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.RequestLoadMoreListener
            public void onLoadMoreRequested() {
                TagUserFragment.a(TagUserFragment.this);
                TagUserFragment.this.a(false);
            }
        }, this.g);
        this.g.setAdapter(this.p);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.d, this.h);
        this.g.setLayoutManager(gridLayoutManager);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.soft.blued.ui.tag_show.TagUserFragment.4
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i) {
                int i2 = TagUserFragment.this.h;
                if (TagUserFragment.this.p.getItem(i) != 0) {
                    int itemViewType = TagUserFragment.this.p.getItemViewType(i);
                    if (itemViewType != 10) {
                        return itemViewType != 11 ? TagUserFragment.this.h : TagUserFragment.this.h;
                    }
                    i2 = 1;
                }
                return i2;
            }
        });
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.d = getActivity();
        View view = this.e;
        if (view == null) {
            this.e = layoutInflater.inflate(R.layout.fragment_tag_users, viewGroup, false);
            c();
            d();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.e.getParent()).removeView(this.e);
        }
        return this.e;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }
}
