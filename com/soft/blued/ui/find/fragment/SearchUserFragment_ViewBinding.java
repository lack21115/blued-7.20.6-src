package com.soft.blued.ui.find.fragment;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/SearchUserFragment_ViewBinding.class */
public class SearchUserFragment_ViewBinding implements Unbinder {
    private SearchUserFragment b;

    public SearchUserFragment_ViewBinding(SearchUserFragment searchUserFragment, View view) {
        this.b = searchUserFragment;
        searchUserFragment.titleView = (CommonTopTitleNoTrans) Utils.a(view, R.id.titleView, "field 'titleView'", CommonTopTitleNoTrans.class);
        searchUserFragment.userList = (RecyclerView) Utils.a(view, R.id.userList, "field 'userList'", RecyclerView.class);
        searchUserFragment.llSearchEmpty = (LinearLayout) Utils.a(view, R.id.ll_search_empty, "field 'llSearchEmpty'", LinearLayout.class);
        searchUserFragment.refreshLayout = (SmartRefreshLayout) Utils.a(view, 2131369119, "field 'refreshLayout'", SmartRefreshLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SearchUserFragment searchUserFragment = this.b;
        if (searchUserFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        searchUserFragment.titleView = null;
        searchUserFragment.userList = null;
        searchUserFragment.llSearchEmpty = null;
        searchUserFragment.refreshLayout = null;
    }
}
