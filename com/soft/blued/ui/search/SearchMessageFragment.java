package com.soft.blued.ui.search;

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
import com.blued.android.module.common.widget.refresh.BluedAdapterLoadMoreView;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.ui.search.adapter.SearchAllAdapter;
import com.soft.blued.ui.search.model.SearchSessionModel;
import com.soft.blued.ui.search.presenter.SearchAllPresenter;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/search/SearchMessageFragment.class */
public class SearchMessageFragment extends MvpFragment<SearchAllPresenter> {

    /* renamed from: a  reason: collision with root package name */
    private String f33149a;
    private SearchAllAdapter b;
    @BindView
    LinearLayout llSearchEmpty;
    @BindView
    CommonTopTitleNoTrans titleView;
    @BindView
    RecyclerView userList;

    public static void a(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString(UserDictionary.Words.WORD, str);
        TerminalActivity.d(context, SearchMessageFragment.class, bundle);
    }

    private void e() {
        this.titleView.setCenterText(getResources().getString(R.string.chat_history));
        this.titleView.a();
        this.titleView.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.search.SearchMessageFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                SearchMessageFragment.this.getActivity().finish();
            }
        });
    }

    private void v() {
        this.userList.setHasFixedSize(true);
        this.userList.setNestedScrollingEnabled(false);
        this.userList.setLayoutManager(new LinearLayoutManager(getContext()));
        SearchAllAdapter searchAllAdapter = new SearchAllAdapter(this);
        this.b = searchAllAdapter;
        this.userList.setAdapter(searchAllAdapter);
        this.b.setLoadMoreView(new BluedAdapterLoadMoreView());
        this.b.setEnableLoadMore(false);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.f33149a = getArguments().getString(UserDictionary.Words.WORD);
        v();
        e();
    }

    public void a(List<SearchSessionModel> list) {
        this.llSearchEmpty.setVisibility(8);
        this.userList.setVisibility(0);
        this.b.b(list, this.f33149a);
    }

    public void b() {
        c();
        this.llSearchEmpty.setVisibility(0);
        this.userList.setVisibility(8);
    }

    public void c() {
        this.b.loadMoreComplete();
        j().m();
    }

    public void d() {
        this.b.loadMoreComplete();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.fragment_search_list;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public String h() {
        return "SearchMessageFragment";
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        j().a(this.f33149a, 0, -1, true);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        j().m();
    }
}
