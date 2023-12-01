package com.soft.blued.ui.find.fragment;

import android.content.Context;
import android.os.Bundle;
import android.provider.UserDictionary;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.bytedance.applog.tracker.Tracker;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.soft.blued.R;
import com.soft.blued.ui.find.adapter.SearchNewAdapter;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.search.presenter.SearchAllPresenter;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/SearchUserFragment.class */
public class SearchUserFragment extends MvpFragment<SearchAllPresenter> {

    /* renamed from: a  reason: collision with root package name */
    private int f16856a = 1;
    private int b = 10;

    /* renamed from: c  reason: collision with root package name */
    private boolean f16857c = true;
    private String d;
    private SearchNewAdapter e;
    @BindView
    LinearLayout llSearchEmpty;
    @BindView
    SmartRefreshLayout refreshLayout;
    @BindView
    CommonTopTitleNoTrans titleView;
    @BindView
    RecyclerView userList;

    public static void a(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString(UserDictionary.Words.WORD, str);
        TerminalActivity.d(context, SearchUserFragment.class, bundle);
    }

    private void c() {
        this.titleView.setCenterText(getResources().getString(R.string.more_users));
        this.titleView.a();
        this.titleView.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.SearchUserFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                SearchUserFragment.this.getActivity().finish();
            }
        });
    }

    private void d() {
        this.userList.setHasFixedSize(true);
        this.userList.setNestedScrollingEnabled(false);
        this.userList.setLayoutManager(new LinearLayoutManager(getContext()));
        SearchNewAdapter searchNewAdapter = new SearchNewAdapter(null, getActivity(), getFragmentActive(), "", this.userList);
        this.e = searchNewAdapter;
        this.userList.setAdapter(searchNewAdapter);
        this.refreshLayout.a(new OnRefreshLoadMoreListener() { // from class: com.soft.blued.ui.find.fragment.SearchUserFragment.2
            @Override // com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
            public void onLoadMore(RefreshLayout refreshLayout) {
                SearchAllPresenter searchAllPresenter = (SearchAllPresenter) SearchUserFragment.this.j();
                String str = SearchUserFragment.this.d;
                searchAllPresenter.a(str, SearchUserFragment.this.f16856a + "");
            }

            @Override // com.scwang.smartrefresh.layout.listener.OnRefreshListener
            public void onRefresh(RefreshLayout refreshLayout) {
                SearchUserFragment.this.f16856a = 1;
                SearchAllPresenter searchAllPresenter = (SearchAllPresenter) SearchUserFragment.this.j();
                String str = SearchUserFragment.this.d;
                searchAllPresenter.a(str, SearchUserFragment.this.f16856a + "");
            }
        });
        this.refreshLayout.i();
    }

    public void a(Bundle bundle) {
        super.a(bundle);
        this.d = getArguments().getString(UserDictionary.Words.WORD);
        d();
        c();
    }

    public void a(String str, List list) {
        super.a(str, list);
    }

    public void a(String str, boolean z) {
        super.a(str, z);
        this.refreshLayout.h();
        this.refreshLayout.j();
        if (!z) {
            this.refreshLayout.l(false);
            return;
        }
        this.f16856a++;
        this.refreshLayout.l(true);
    }

    public void a(List<UserFindResult> list) {
        this.llSearchEmpty.setVisibility(8);
        this.userList.setVisibility(0);
        if (this.f16856a == 1) {
            this.e.a(list, this.d);
        } else {
            this.e.b(list, this.d);
        }
    }

    public void b() {
        if (this.e.getData().size() == 0) {
            this.llSearchEmpty.setVisibility(0);
            this.userList.setVisibility(8);
        }
    }

    public int g() {
        return R.layout.fragment_search_list;
    }

    public void g_(String str) {
        super.g_(str);
    }

    public String h() {
        return "SearchUserFragment";
    }

    public void l() {
    }
}
