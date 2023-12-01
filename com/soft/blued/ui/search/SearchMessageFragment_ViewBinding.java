package com.soft.blued.ui.search;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.soft.blued.R;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/search/SearchMessageFragment_ViewBinding.class */
public class SearchMessageFragment_ViewBinding implements Unbinder {
    private SearchMessageFragment b;

    public SearchMessageFragment_ViewBinding(SearchMessageFragment searchMessageFragment, View view) {
        this.b = searchMessageFragment;
        searchMessageFragment.titleView = (CommonTopTitleNoTrans) Utils.a(view, R.id.titleView, "field 'titleView'", CommonTopTitleNoTrans.class);
        searchMessageFragment.userList = (RecyclerView) Utils.a(view, R.id.userList, "field 'userList'", RecyclerView.class);
        searchMessageFragment.llSearchEmpty = (LinearLayout) Utils.a(view, R.id.ll_search_empty, "field 'llSearchEmpty'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SearchMessageFragment searchMessageFragment = this.b;
        if (searchMessageFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        searchMessageFragment.titleView = null;
        searchMessageFragment.userList = null;
        searchMessageFragment.llSearchEmpty = null;
    }
}
