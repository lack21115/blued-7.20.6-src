package com.soft.blued.ui.msg_group.fragment;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.common.view.SearchView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.soft.blued.R;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/fragment/SearchMemberFragment_ViewBinding.class */
public class SearchMemberFragment_ViewBinding implements Unbinder {
    private SearchMemberFragment b;

    public SearchMemberFragment_ViewBinding(SearchMemberFragment searchMemberFragment, View view) {
        this.b = searchMemberFragment;
        searchMemberFragment.refresh_layout = (SmartRefreshLayout) Utils.a(view, R.id.refresh_layout, "field 'refresh_layout'", SmartRefreshLayout.class);
        searchMemberFragment.title = (CommonTopTitleNoTrans) Utils.a(view, 2131370694, "field 'title'", CommonTopTitleNoTrans.class);
        searchMemberFragment.search_view = (SearchView) Utils.a(view, R.id.search_view, "field 'search_view'", SearchView.class);
        searchMemberFragment.search_list = (RecyclerView) Utils.a(view, R.id.search_list, "field 'search_list'", RecyclerView.class);
        searchMemberFragment.user_list = (RecyclerView) Utils.a(view, R.id.user_list, "field 'user_list'", RecyclerView.class);
        searchMemberFragment.noDataView = (NoDataAndLoadFailView) Utils.a(view, 2131368721, "field 'noDataView'", NoDataAndLoadFailView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SearchMemberFragment searchMemberFragment = this.b;
        if (searchMemberFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        searchMemberFragment.refresh_layout = null;
        searchMemberFragment.title = null;
        searchMemberFragment.search_view = null;
        searchMemberFragment.search_list = null;
        searchMemberFragment.user_list = null;
        searchMemberFragment.noDataView = null;
    }
}
