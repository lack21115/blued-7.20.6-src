package com.blued.community.ui.subject.fragment;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.view.SearchEditText;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.common.view.SearchView;
import com.blued.community.R;
import com.blued.community.http.CommunityHttpUtils;
import com.blued.community.ui.common.CommonRecyclerFragment;
import com.blued.community.ui.feed.manager.FeedMethods;
import com.blued.community.ui.subject.adapter.FeedSubjectListAdapter;
import com.blued.community.ui.topic.model.BluedTopic;
import com.blued.community.view.CommonMultiItemAdapter;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/subject/fragment/FeedSubjectSearchFragment.class */
public final class FeedSubjectSearchFragment extends CommonRecyclerFragment<BluedTopic, BluedEntityBaseExtra> {
    private SearchView a;
    private SearchEditText b;
    private String c = "";
    private boolean d;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FeedSubjectSearchFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        SearchEditText searchEditText = this$0.b;
        if (searchEditText == null) {
            return;
        }
        searchEditText.requestFocus();
        KeyboardUtils.a((View) searchEditText);
        searchEditText.setCursorVisible(true);
        this$0.c(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FeedSubjectSearchFragment this$0, View view, boolean z) {
        SearchEditText editView;
        Intrinsics.e(this$0, "this$0");
        if (z) {
            return;
        }
        this$0.d = true;
        SearchView searchView = this$0.a;
        if (searchView == null || (editView = searchView.getEditView()) == null) {
            return;
        }
        this$0.c = String.valueOf(editView.getText());
        this$0.a(true);
    }

    public final void c(boolean z) {
        SearchView searchView = this.a;
        if (searchView != null) {
            searchView.a(z);
        }
        SearchView searchView2 = this.a;
        SearchEditText editView = searchView2 == null ? null : searchView2.getEditView();
        if (editView != null) {
            editView.setFocusable(true);
        }
        SearchView searchView3 = this.a;
        SearchEditText editView2 = searchView3 == null ? null : searchView3.getEditView();
        if (editView2 != null) {
            editView2.setFocusableInTouchMode(true);
        }
        SearchView searchView4 = this.a;
        SearchEditText editView3 = searchView4 == null ? null : searchView4.getEditView();
        if (editView3 == null) {
            return;
        }
        editView3.setCursorVisible(z);
    }

    @Override // com.blued.community.ui.common.CommonRecyclerFragment
    public boolean d() {
        return false;
    }

    @Override // com.blued.community.ui.common.CommonRecyclerFragment
    public boolean e() {
        return false;
    }

    @Override // com.blued.community.ui.common.CommonRecyclerFragment
    public CommonMultiItemAdapter<BluedTopic> g() {
        return new FeedSubjectListAdapter(2);
    }

    @Override // com.blued.community.ui.common.CommonRecyclerFragment
    public void j() {
        super.j();
        NoDataAndLoadFailView b = b();
        if (b == null) {
            return;
        }
        b.setNoDataStr(R.string.feed_subject_no_search_data);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.blued.community.ui.subject.fragment.FeedSubjectSearchFragment$getHttpResDataType$1] */
    @Override // com.blued.community.ui.common.CommonRecyclerFragment
    public Type k() {
        Type type = new TypeToken<BluedEntity<BluedTopic, BluedEntityBaseExtra>>() { // from class: com.blued.community.ui.subject.fragment.FeedSubjectSearchFragment$getHttpResDataType$1
        }.getType();
        Intrinsics.c(type, "object : TypeToken<Blued…tityBaseExtra>>() {}.type");
        return type;
    }

    @Override // com.blued.community.ui.common.CommonRecyclerFragment
    public String l() {
        return CommunityHttpUtils.a() + "/ticktocks/super_topics/search?q=" + ((Object) URLEncoder.encode(this.c));
    }

    @Override // com.blued.community.ui.common.CommonRecyclerFragment
    public void onInitView() {
        super.onInitView();
        SearchView searchView = (SearchView) this.rootView.findViewById(R.id.search_view);
        this.a = searchView;
        SearchEditText editView = searchView == null ? null : searchView.getEditView();
        this.b = editView;
        FeedMethods.a((EditText) editView);
        SearchView searchView2 = this.a;
        if (searchView2 != null) {
            searchView2.setOnSearchInfoListener(new SearchView.OnSearchInfoListener() { // from class: com.blued.community.ui.subject.fragment.FeedSubjectSearchFragment$onInitView$1
                @Override // com.blued.android.module.common.view.SearchView.OnSearchInfoListener
                public void a() {
                    KeyboardUtils.a(FeedSubjectSearchFragment.this.getActivity());
                    FragmentActivity activity = FeedSubjectSearchFragment.this.getActivity();
                    if (activity == null) {
                        return;
                    }
                    activity.finish();
                }

                @Override // com.blued.android.module.common.view.SearchView.OnSearchInfoListener
                public void a(String msg) {
                    Intrinsics.e(msg, "msg");
                    CommonMultiItemAdapter<BluedTopic> a = FeedSubjectSearchFragment.this.a();
                    if (a != null) {
                        a.setNewData((List) null);
                    }
                    NoDataAndLoadFailView b = FeedSubjectSearchFragment.this.b();
                    if (b != null) {
                        b.d();
                    }
                    String str = msg;
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    FeedSubjectSearchFragment.this.a(1);
                    CommonMultiItemAdapter<BluedTopic> a2 = FeedSubjectSearchFragment.this.a();
                    if (a2 != null) {
                        a2.setEnableLoadMore(true);
                    }
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    FeedSubjectSearchFragment.this.c = msg;
                    FeedSubjectSearchFragment.this.a(true);
                }

                @Override // com.blued.android.module.common.view.SearchView.OnSearchInfoListener
                public void b() {
                }
            });
        }
        SearchView searchView3 = this.a;
        SearchEditText editView2 = searchView3 == null ? null : searchView3.getEditView();
        if (editView2 != null) {
            editView2.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.blued.community.ui.subject.fragment.-$$Lambda$FeedSubjectSearchFragment$XWvFVKcUwRFZaJEWh93_np6hLLA
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z) {
                    FeedSubjectSearchFragment.a(FeedSubjectSearchFragment.this, view, z);
                }
            });
        }
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.community.ui.subject.fragment.-$$Lambda$FeedSubjectSearchFragment$M3vovIMjFZI43Re2S89onJsGZcQ
            @Override // java.lang.Runnable
            public final void run() {
                FeedSubjectSearchFragment.a(FeedSubjectSearchFragment.this);
            }
        }, 500L);
    }

    @Override // com.blued.community.ui.common.CommonRecyclerFragment
    public int onSetRootViewId() {
        return R.layout.fragment_feed_subject_search;
    }
}
