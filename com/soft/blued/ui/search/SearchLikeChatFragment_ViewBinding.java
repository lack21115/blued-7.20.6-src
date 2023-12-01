package com.soft.blued.ui.search;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.soft.blued.R;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/search/SearchLikeChatFragment_ViewBinding.class */
public class SearchLikeChatFragment_ViewBinding implements Unbinder {
    private SearchLikeChatFragment b;

    public SearchLikeChatFragment_ViewBinding(SearchLikeChatFragment searchLikeChatFragment, View view) {
        this.b = searchLikeChatFragment;
        searchLikeChatFragment.titleView = (CommonTopTitleNoTrans) Utils.a(view, R.id.titleView, "field 'titleView'", CommonTopTitleNoTrans.class);
        searchLikeChatFragment.userList = (RecyclerView) Utils.a(view, R.id.userList, "field 'userList'", RecyclerView.class);
        searchLikeChatFragment.llSearchEmpty = (LinearLayout) Utils.a(view, R.id.ll_search_empty, "field 'llSearchEmpty'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SearchLikeChatFragment searchLikeChatFragment = this.b;
        if (searchLikeChatFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        searchLikeChatFragment.titleView = null;
        searchLikeChatFragment.userList = null;
        searchLikeChatFragment.llSearchEmpty = null;
    }
}
