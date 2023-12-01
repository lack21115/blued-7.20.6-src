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
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.soft.blued.R;
import com.soft.blued.ui.search.adapter.SearchAllAdapter;
import com.soft.blued.ui.search.model.SearchSessionModel;
import com.soft.blued.ui.search.presenter.SearchLikeChatPresenter;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/search/SearchLikeChatFragment.class */
public class SearchLikeChatFragment extends MvpFragment<SearchLikeChatPresenter> {

    /* renamed from: a  reason: collision with root package name */
    private SearchAllAdapter f19455a;
    @BindView
    LinearLayout llSearchEmpty;
    @BindView
    CommonTopTitleNoTrans titleView;
    @BindView
    RecyclerView userList;

    public static void a(Context context, String str, String str2, long j, short s, String str3, int i, int i2, int i3, int i4, int i5) {
        Bundle bundle = new Bundle();
        bundle.putString(UserDictionary.Words.WORD, str);
        bundle.putLong("passby_session_id", j);
        bundle.putShort("passby_session_type", s);
        bundle.putString("passby_nick_name", str2);
        bundle.putString("passby_avatar", str3);
        bundle.putInt("passby_vbadge", i);
        bundle.putInt("passby_vip_grade", i2);
        bundle.putInt("passby_is_vip_annual", i3);
        bundle.putInt("passby_is_hide_vip_look", i5);
        bundle.putInt("passby_vip_exp_lvl", i4);
        TerminalActivity.d(context, SearchLikeChatFragment.class, bundle);
    }

    private void e() {
        this.titleView.setCenterText(String.format(getResources().getString(R.string.search_chat_to), ((SearchLikeChatPresenter) j()).p()));
        this.titleView.a();
        this.titleView.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.search.SearchLikeChatFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                SearchLikeChatFragment.this.getActivity().finish();
            }
        });
    }

    private void v() {
        this.userList.setHasFixedSize(true);
        this.userList.setNestedScrollingEnabled(false);
        this.userList.setLayoutManager(new LinearLayoutManager(getContext()));
        SearchAllAdapter searchAllAdapter = new SearchAllAdapter(this);
        this.f19455a = searchAllAdapter;
        this.userList.setAdapter(searchAllAdapter);
        this.f19455a.setLoadMoreView(new BluedAdapterLoadMoreView());
        this.f19455a.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() { // from class: com.soft.blued.ui.search.SearchLikeChatFragment.2
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.RequestLoadMoreListener
            public void onLoadMoreRequested() {
                ((SearchLikeChatPresenter) SearchLikeChatFragment.this.j()).n();
            }
        }, this.userList);
        this.f19455a.setEnableLoadMore(false);
    }

    public void a(Bundle bundle) {
        super.a(bundle);
        e();
        v();
    }

    public void a(List<SearchSessionModel> list) {
        this.llSearchEmpty.setVisibility(8);
        this.userList.setVisibility(0);
        this.f19455a.b(list, ((SearchLikeChatPresenter) j()).q());
    }

    public void b() {
        c();
        this.llSearchEmpty.setVisibility(0);
        this.userList.setVisibility(8);
    }

    public void c() {
        this.f19455a.loadMoreComplete();
        this.f19455a.setEnableLoadMore(false);
    }

    public void d() {
        this.f19455a.loadMoreComplete();
        this.f19455a.setEnableLoadMore(true);
    }

    public int g() {
        return R.layout.fragment_search_list;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        ((SearchLikeChatPresenter) j()).m();
    }

    public void onDestroy() {
        super.onDestroy();
        ((SearchLikeChatPresenter) j()).o();
    }
}
