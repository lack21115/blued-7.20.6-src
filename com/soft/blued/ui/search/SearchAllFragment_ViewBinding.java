package com.soft.blued.ui.search;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.common.view.SearchView;
import com.soft.blued.R;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/search/SearchAllFragment_ViewBinding.class */
public class SearchAllFragment_ViewBinding implements Unbinder {
    private SearchAllFragment b;

    public SearchAllFragment_ViewBinding(SearchAllFragment searchAllFragment, View view) {
        this.b = searchAllFragment;
        searchAllFragment.msgSearchView = (SearchView) Utils.a(view, R.id.msg_search_view, "field 'msgSearchView'", SearchView.class);
        searchAllFragment.tvSearchPerson = (TextView) Utils.a(view, R.id.tv_search_person, "field 'tvSearchPerson'", TextView.class);
        searchAllFragment.tvNoResults = (TextView) Utils.a(view, R.id.tv_no_results, "field 'tvNoResults'", TextView.class);
        searchAllFragment.tvMorePerson = (TextView) Utils.a(view, R.id.tv_more_person, "field 'tvMorePerson'", TextView.class);
        searchAllFragment.tvSearchMsg = (TextView) Utils.a(view, R.id.tv_search_msg, "field 'tvSearchMsg'", TextView.class);
        searchAllFragment.tvMoreMsg = (TextView) Utils.a(view, R.id.tv_more_msg, "field 'tvMoreMsg'", TextView.class);
        searchAllFragment.listPerson = (RecyclerView) Utils.a(view, R.id.list_person, "field 'listPerson'", RecyclerView.class);
        searchAllFragment.listMessage = (RecyclerView) Utils.a(view, R.id.list_message, "field 'listMessage'", RecyclerView.class);
        searchAllFragment.noDataView = (NoDataAndLoadFailView) Utils.a(view, R.id.no_data_view, "field 'noDataView'", NoDataAndLoadFailView.class);
        searchAllFragment.personLoading = (FrameLayout) Utils.a(view, R.id.person_loading, "field 'personLoading'", FrameLayout.class);
        searchAllFragment.llUserView = (RelativeLayout) Utils.a(view, R.id.ll_user_view, "field 'llUserView'", RelativeLayout.class);
        searchAllFragment.llLine = Utils.a(view, R.id.ll_line, "field 'llLine'");
        searchAllFragment.llMsgView = (RelativeLayout) Utils.a(view, R.id.ll_msg_view, "field 'llMsgView'", RelativeLayout.class);
        searchAllFragment.llContentView = (NestedScrollView) Utils.a(view, R.id.ll_content_view, "field 'llContentView'", NestedScrollView.class);
        searchAllFragment.layoutCircle = Utils.a(view, R.id.circle_parent_layout, "field 'layoutCircle'");
        searchAllFragment.tvCircleMore = Utils.a(view, R.id.circle_more_tv, "field 'tvCircleMore'");
        searchAllFragment.rvCircle = (RecyclerView) Utils.a(view, R.id.circle_rv, "field 'rvCircle'", RecyclerView.class);
        searchAllFragment.layoutSubject = Utils.a(view, R.id.subject_parent_layout, "field 'layoutSubject'");
        searchAllFragment.tvSubjectMore = Utils.a(view, R.id.subject_more_tv, "field 'tvSubjectMore'");
        searchAllFragment.rvSubject = (RecyclerView) Utils.a(view, R.id.subject_rv, "field 'rvSubject'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SearchAllFragment searchAllFragment = this.b;
        if (searchAllFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        searchAllFragment.msgSearchView = null;
        searchAllFragment.tvSearchPerson = null;
        searchAllFragment.tvNoResults = null;
        searchAllFragment.tvMorePerson = null;
        searchAllFragment.tvSearchMsg = null;
        searchAllFragment.tvMoreMsg = null;
        searchAllFragment.listPerson = null;
        searchAllFragment.listMessage = null;
        searchAllFragment.noDataView = null;
        searchAllFragment.personLoading = null;
        searchAllFragment.llUserView = null;
        searchAllFragment.llLine = null;
        searchAllFragment.llMsgView = null;
        searchAllFragment.llContentView = null;
        searchAllFragment.layoutCircle = null;
        searchAllFragment.tvCircleMore = null;
        searchAllFragment.rvCircle = null;
        searchAllFragment.layoutSubject = null;
        searchAllFragment.tvSubjectMore = null;
        searchAllFragment.rvSubject = null;
    }
}
