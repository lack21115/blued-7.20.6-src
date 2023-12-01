package com.soft.blued.ui.search;

import android.content.Context;
import android.os.Bundle;
import android.provider.SearchIndexablesContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.utils.TypeUtils;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.common.view.SearchView;
import com.blued.community.ui.circle.model.MyCircleModel;
import com.blued.community.ui.topic.model.BluedTopic;
import com.blued.das.guy.GuyProtos;
import com.blued.das.message.MessageProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.log.track.EventTrackGuy;
import com.soft.blued.log.track.EventTrackMessage;
import com.soft.blued.ui.find.adapter.SearchNewAdapter;
import com.soft.blued.ui.find.fragment.SearchUserFragment;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.search.adapter.SearchAllAdapter;
import com.soft.blued.ui.search.adapter.SearchCircleAdapter;
import com.soft.blued.ui.search.adapter.SearchSubjectAdapter;
import com.soft.blued.ui.search.model.SearchSessionModel;
import com.soft.blued.ui.search.presenter.SearchAllPresenter;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/search/SearchAllFragment.class */
public class SearchAllFragment extends MvpFragment<SearchAllPresenter> {

    /* renamed from: a  reason: collision with root package name */
    private String f19441a;
    private SearchNewAdapter b;

    /* renamed from: c  reason: collision with root package name */
    private SearchAllAdapter f19442c;
    private SearchCircleAdapter d;
    private SearchSubjectAdapter e;
    @BindView
    View layoutCircle;
    @BindView
    View layoutSubject;
    @BindView
    RecyclerView listMessage;
    @BindView
    RecyclerView listPerson;
    @BindView
    NestedScrollView llContentView;
    @BindView
    View llLine;
    @BindView
    RelativeLayout llMsgView;
    @BindView
    RelativeLayout llUserView;
    @BindView
    SearchView msgSearchView;
    @BindView
    NoDataAndLoadFailView noDataView;
    @BindView
    FrameLayout personLoading;
    @BindView
    RecyclerView rvCircle;
    @BindView
    RecyclerView rvSubject;
    @BindView
    View tvCircleMore;
    @BindView
    TextView tvMoreMsg;
    @BindView
    TextView tvMorePerson;
    @BindView
    TextView tvNoResults;
    @BindView
    TextView tvSearchMsg;
    @BindView
    TextView tvSearchPerson;
    @BindView
    View tvSubjectMore;

    public static void a(Context context, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("from", i);
        TerminalActivity.d(context, SearchAllFragment.class, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        Tracker.onClick(view);
        Bundle bundle = new Bundle();
        bundle.putString(SearchIndexablesContract.RawData.COLUMN_KEYWORDS, this.f19441a);
        TerminalActivity.d(getActivity(), SearchMoreSubjectFragment.class, bundle);
        EventTrackGuy.b(GuyProtos.Event.SEARCH_ALL_FIRST_RESULT_TOPIC_MORE_CLICK, this.f19441a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        Tracker.onClick(view);
        Bundle bundle = new Bundle();
        bundle.putString(SearchIndexablesContract.RawData.COLUMN_KEYWORDS, this.f19441a);
        TerminalActivity.d(getActivity(), SearchMoreCircleFragment.class, bundle);
        EventTrackGuy.b(GuyProtos.Event.SEARCH_ALL_FIRST_RESULT_CIRCLE_MORE_CLICK, this.f19441a);
    }

    private void d() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        this.listPerson.setLayoutManager(linearLayoutManager);
        this.listPerson.setNestedScrollingEnabled(false);
        SearchNewAdapter searchNewAdapter = new SearchNewAdapter(null, getActivity(), getFragmentActive(), "", this.listPerson);
        this.b = searchNewAdapter;
        this.listPerson.setAdapter(searchNewAdapter);
    }

    private void e() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        this.listMessage.setLayoutManager(linearLayoutManager);
        this.listMessage.setNestedScrollingEnabled(false);
        SearchAllAdapter searchAllAdapter = new SearchAllAdapter(this);
        this.f19442c = searchAllAdapter;
        this.listMessage.setAdapter(searchAllAdapter);
    }

    private void v() {
        this.rvCircle.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        this.rvCircle.setNestedScrollingEnabled(false);
        SearchCircleAdapter searchCircleAdapter = new SearchCircleAdapter();
        this.d = searchCircleAdapter;
        this.rvCircle.setAdapter(searchCircleAdapter);
        this.tvCircleMore.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.search.-$$Lambda$SearchAllFragment$fmm9RBwdH0X1c9_Rx1zTLd0meeo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchAllFragment.this.b(view);
            }
        });
    }

    private void w() {
        this.rvSubject.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        this.rvSubject.setNestedScrollingEnabled(false);
        SearchSubjectAdapter searchSubjectAdapter = new SearchSubjectAdapter();
        this.e = searchSubjectAdapter;
        this.rvSubject.setAdapter(searchSubjectAdapter);
        this.tvSubjectMore.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.search.-$$Lambda$SearchAllFragment$-4v3CpB8GNheU0D245fSQoN7KB0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchAllFragment.this.a(view);
            }
        });
    }

    private void x() {
        this.noDataView.setOnTouchEvent(false);
        this.noDataView.setTopSpace(DensityUtils.a(getContext(), 40.0f));
        this.noDataView.setImageScale(0.7f);
        this.noDataView.setNoDataStr((int) R.string.msg_search_no_data_tip);
        this.noDataView.setNoDataImg(2131233637);
    }

    private void y() {
        if (this.f19442c.getData().size() > 0 && this.b.getData().size() == 0) {
            Log.v("drb", "暂无数据");
            this.llUserView.setVisibility(0);
            this.tvNoResults.setVisibility(0);
            this.tvSearchPerson.setVisibility(0);
            this.llLine.setVisibility(8);
        } else if (this.f19442c.getData().size() == 0 && this.b.getData().size() == 0) {
            this.llContentView.setVisibility(8);
            this.noDataView.setVisibility(0);
        } else if (this.f19442c.getData().size() <= 0 || this.b.getData().size() <= 0) {
        } else {
            this.llLine.setVisibility(0);
        }
    }

    public void a(Bundle bundle) {
        super.a(bundle);
        this.llLine.setVisibility(8);
        this.llMsgView.setVisibility(8);
        this.llUserView.setVisibility(8);
        this.msgSearchView.setOnSearchInfoListener(new SearchView.OnSearchInfoListener() { // from class: com.soft.blued.ui.search.SearchAllFragment.1
            public void a() {
                SearchAllFragment.this.f19441a = "";
                SearchAllFragment.this.personLoading.setVisibility(8);
                SearchAllFragment.this.t();
                Log.v("drb", "onCancel");
            }

            public void a(String str) {
                Log.v("drb", "doSearch:" + str);
                if (!TextUtils.isEmpty(str)) {
                    if (SearchAllFragment.this.llContentView != null) {
                        SearchAllFragment.this.llContentView.setVisibility(0);
                    }
                    if (SearchAllFragment.this.noDataView != null) {
                        SearchAllFragment.this.noDataView.setVisibility(8);
                    }
                    SearchAllFragment.this.f19441a = str;
                    if (((SearchAllPresenter) SearchAllFragment.this.j()).h) {
                        EventTrackMessage.d(MessageProtos.Event.MSG_SCREEN_SEARCH_BOX_SUCCESS, SearchAllFragment.this.f19441a);
                    }
                    ((SearchAllPresenter) SearchAllFragment.this.j()).d(str);
                    if (SearchAllFragment.this.llLine == null) {
                    }
                    return;
                }
                SearchAllFragment.this.f19442c.getData().clear();
                SearchAllFragment.this.b.getData().clear();
                if (SearchAllFragment.this.llContentView != null) {
                    SearchAllFragment.this.llContentView.setVisibility(8);
                }
                SearchAllFragment.this.noDataView.setVisibility(8);
                SearchAllFragment.this.tvSearchPerson.setVisibility(8);
                SearchAllFragment.this.listPerson.setVisibility(8);
                SearchAllFragment.this.tvMorePerson.setVisibility(8);
                SearchAllFragment.this.tvNoResults.setVisibility(8);
                Log.v("drb", "--doSearch showEmpty");
            }

            public void b() {
                SearchAllFragment.this.f19441a = "";
                SearchAllFragment.this.f19442c.getData().clear();
                SearchAllFragment.this.b.getData().clear();
                SearchAllFragment.this.personLoading.setVisibility(8);
                SearchAllFragment.this.llContentView.setVisibility(8);
                SearchAllFragment.this.noDataView.setVisibility(8);
                Log.v("drb", "clearContent");
            }
        });
        this.tvMoreMsg.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.search.SearchAllFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                SearchMessageFragment.a(SearchAllFragment.this.getContext(), SearchAllFragment.this.f19441a);
            }
        });
        this.tvMorePerson.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.search.SearchAllFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                SearchUserFragment.a(SearchAllFragment.this.getContext(), SearchAllFragment.this.f19441a);
            }
        });
        d();
        e();
        x();
        v();
        w();
    }

    public void a(String str, boolean z) {
        boolean z2;
        Log.v("drb", "dismissDataLoading type:" + str);
        Log.v("drb", "dismissDataLoading messageAdapter size :" + this.f19442c.getData().size());
        Log.v("drb", "dismissDataLoading personAdapter size :" + this.b.getData().size());
        int hashCode = str.hashCode();
        if (hashCode != -157516238) {
            if (hashCode == 1060515318 && str.equals("MESSAGE_LIST")) {
                z2 = true;
            }
            z2 = true;
        } else {
            if (str.equals("PERSON_LOADING")) {
                z2 = false;
            }
            z2 = true;
        }
        if (z2) {
            return;
        }
        this.personLoading.setVisibility(8);
        y();
    }

    public void a(List<MyCircleModel> list) {
        this.d.a(this.f19441a);
        if (TypeUtils.a(list)) {
            this.layoutCircle.setVisibility(8);
            return;
        }
        this.layoutCircle.setVisibility(0);
        this.d.setDataAndNotify(list);
        if (((SearchAllPresenter) j()).k) {
            this.tvCircleMore.setVisibility(0);
        } else {
            this.tvCircleMore.setVisibility(8);
        }
    }

    public void b() {
        Log.v("drb", "notifyPersonEmpty");
        if (((SearchAllPresenter) j()).h) {
            this.llLine.setVisibility(8);
        }
    }

    public void b(List<BluedTopic> list) {
        this.e.a(this.f19441a);
        if (TypeUtils.a(list)) {
            this.layoutSubject.setVisibility(8);
            return;
        }
        this.layoutSubject.setVisibility(0);
        this.e.setDataAndNotify(list);
        if (((SearchAllPresenter) j()).l) {
            this.tvSubjectMore.setVisibility(0);
        } else {
            this.tvSubjectMore.setVisibility(8);
        }
    }

    public void c() {
        this.llMsgView.setVisibility(8);
        Log.v("drb", "messageEmpty");
    }

    public void c(List<UserFindResult> list) {
        Log.v("drb", "notifyPersonList");
        this.llUserView.setVisibility(0);
        this.tvSearchPerson.setVisibility(0);
        this.listPerson.setVisibility(0);
        this.tvNoResults.setVisibility(8);
        if (list.size() <= 3) {
            this.b.a(list, this.f19441a);
            this.tvMorePerson.setVisibility(8);
            return;
        }
        this.b.a(list.subList(0, 3), this.f19441a);
        this.tvMorePerson.setVisibility(0);
    }

    public void d(List<SearchSessionModel> list) {
        this.llMsgView.setVisibility(0);
        if (list.size() <= 3) {
            this.f19442c.a(list, this.f19441a);
            this.tvMoreMsg.setVisibility(8);
        } else {
            this.f19442c.a(list.subList(0, 3), this.f19441a);
            this.tvMoreMsg.setVisibility(0);
        }
        Log.v("drb", "notifyMessageList");
    }

    public int g() {
        return R.layout.fragment_search_all_layout;
    }

    public void g_(String str) {
        boolean z;
        super.g_(str);
        Log.v("drb", "showDataLoading type:" + str);
        int hashCode = str.hashCode();
        if (hashCode != -157516238) {
            if (hashCode == 1060515318 && str.equals("MESSAGE_LIST")) {
                z = true;
            }
            z = true;
        } else {
            if (str.equals("PERSON_LOADING")) {
                z = false;
            }
            z = true;
        }
        if (z) {
            if (!z) {
                return;
            }
            this.f19442c.getData().clear();
            return;
        }
        this.b.getData().clear();
        this.personLoading.setVisibility(0);
        this.tvNoResults.setVisibility(8);
        this.tvSearchPerson.setVisibility(8);
        this.listPerson.setVisibility(8);
        this.tvMorePerson.setVisibility(8);
        this.llLine.setVisibility(8);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (((SearchAllPresenter) j()).h) {
            ((RelativeLayout.LayoutParams) this.llLine.getLayoutParams()).addRule(3, R.id.ll_msg_view);
            ((RelativeLayout.LayoutParams) this.llUserView.getLayoutParams()).addRule(3, R.id.ll_line);
        } else {
            ((RelativeLayout.LayoutParams) this.llMsgView.getLayoutParams()).addRule(3, R.id.ll_line);
            ((RelativeLayout.LayoutParams) this.llLine.getLayoutParams()).addRule(3, R.id.ll_user_view);
        }
        a(new Runnable() { // from class: com.soft.blued.ui.search.SearchAllFragment.4
            @Override // java.lang.Runnable
            public void run() {
                SearchAllFragment.this.msgSearchView.a(true);
                KeyboardUtils.c(SearchAllFragment.this.getActivity());
                SearchAllFragment.this.msgSearchView.getEditView().requestFocus();
                SearchAllFragment.this.msgSearchView.getEditView().setCursorVisible(true);
            }
        }, 500L);
    }
}
