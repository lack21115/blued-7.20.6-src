package com.soft.blued.ui.search;

import android.content.Context;
import android.net.wifi.WifiEnterpriseConfig;
import android.os.Bundle;
import android.provider.SearchIndexablesContract;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewbinding.ViewBinding;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.view.SearchEditText;
import com.blued.android.module.common.base.mvi.MVIBaseFragment;
import com.blued.android.module.common.base.mvi.UiEvent;
import com.blued.android.module.common.extensions.BluedStructureExtKt;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.view.FlowLayout;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.common.view.SearchView;
import com.blued.das.guy.GuyProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.soft.blued.R;
import com.soft.blued.databinding.FmSearchGlobalBinding;
import com.soft.blued.log.track.EventTrackGuy;
import com.soft.blued.ui.search.adapter.SearchGlobalAdapter;
import com.soft.blued.ui.search.model.SearchGlobalInfo;
import com.soft.blued.ui.search.state.SearchGlobalAction;
import com.soft.blued.ui.search.state.SearchGlobalEvent;
import com.soft.blued.ui.search.state.SearchGlobalState;
import com.soft.blued.ui.search.utils.SearchGlobalUtil;
import com.soft.blued.ui.search.view.SearchGlobalShortcutHeader;
import com.soft.blued.ui.search.vm.SearchGlobalVM;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/search/SearchGlobalFragment.class */
public final class SearchGlobalFragment extends MVIBaseFragment<SearchGlobalVM> {
    static final /* synthetic */ KProperty<Object>[] b = {(KProperty) Reflection.a(new PropertyReference1Impl(SearchGlobalFragment.class, "vb", "getVb()Lcom/soft/blued/databinding/FmSearchGlobalBinding;", 0))};

    /* renamed from: c  reason: collision with root package name */
    private final ViewBindingProperty f19447c;
    private final SearchGlobalAdapter d;
    private boolean e;

    public SearchGlobalFragment() {
        super((int) R.layout.fm_search_global);
        this.f19447c = ((Fragment) this) instanceof DialogFragment ? (ViewBindingProperty) new DialogFragmentViewBindingProperty(new Function1<SearchGlobalFragment, FmSearchGlobalBinding>() { // from class: com.soft.blued.ui.search.SearchGlobalFragment$special$$inlined$viewBindingFragment$default$1
            /* JADX WARN: Incorrect types in method signature: (Lcom/soft/blued/ui/search/SearchGlobalFragment;)Lcom/soft/blued/databinding/FmSearchGlobalBinding; */
            /* renamed from: a */
            public final ViewBinding invoke(Fragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FmSearchGlobalBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<SearchGlobalFragment, FmSearchGlobalBinding>() { // from class: com.soft.blued.ui.search.SearchGlobalFragment$special$$inlined$viewBindingFragment$default$2
            /* JADX WARN: Incorrect types in method signature: (Lcom/soft/blued/ui/search/SearchGlobalFragment;)Lcom/soft/blued/databinding/FmSearchGlobalBinding; */
            /* renamed from: a */
            public final ViewBinding invoke(Fragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FmSearchGlobalBinding.a(fragment.requireView());
            }
        });
        IRequestHost fragmentActive = getFragmentActive();
        Intrinsics.c(fragmentActive, "fragmentActive");
        this.d = new SearchGlobalAdapter(fragmentActive);
    }

    private final FmSearchGlobalBinding a() {
        return (FmSearchGlobalBinding) this.f19447c.b(this, b[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
        Tracker.onClick(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FmSearchGlobalBinding fmSearchGlobalBinding, SearchGlobalFragment searchGlobalFragment) {
        Intrinsics.e(fmSearchGlobalBinding, "$vb");
        Intrinsics.e(searchGlobalFragment, "this$0");
        fmSearchGlobalBinding.f.a(true);
        searchGlobalFragment.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FmSearchGlobalBinding fmSearchGlobalBinding, SearchGlobalFragment searchGlobalFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(fmSearchGlobalBinding, "$vb");
        Intrinsics.e(searchGlobalFragment, "this$0");
        SearchGlobalUtil.f19484a.c();
        fmSearchGlobalBinding.f15071a.removeAllViews();
        searchGlobalFragment.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(SearchGlobalFragment searchGlobalFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.e(searchGlobalFragment, "this$0");
        if (2131371973 == view.getId()) {
            Object obj = baseQuickAdapter.getData().get(i);
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.soft.blued.ui.search.model.SearchGlobalInfo");
            }
            SearchGlobalInfo searchGlobalInfo = (SearchGlobalInfo) obj;
            if (searchGlobalInfo.b()) {
                int a2 = searchGlobalInfo.a();
                if (a2 == 1) {
                    EventTrackGuy.a(GuyProtos.Event.SEARCH_ALL_FIRST_RESULT_MSG_MORE_CLICK, searchGlobalFragment.d.b());
                } else if (a2 == 2) {
                    EventTrackGuy.a(GuyProtos.Event.SEARCH_ALL_FIRST_RESULT_USER_MORE_CLICK, searchGlobalFragment.d.b());
                } else if (a2 == 3) {
                    EventTrackGuy.a(GuyProtos.Event.SEARCH_ALL_FIRST_RESULT_GROUP_MORE_CLICK, searchGlobalFragment.d.b());
                } else if (a2 == 4) {
                    EventTrackGuy.b(GuyProtos.Event.SEARCH_ALL_FIRST_RESULT_CIRCLE_MORE_CLICK, searchGlobalFragment.d.b());
                } else if (a2 == 5) {
                    EventTrackGuy.b(GuyProtos.Event.SEARCH_ALL_FIRST_RESULT_TOPIC_MORE_CLICK, searchGlobalFragment.d.b());
                }
                int a3 = searchGlobalInfo.a();
                if (a3 == 4) {
                    Bundle bundle = new Bundle();
                    bundle.putString(SearchIndexablesContract.RawData.COLUMN_KEYWORDS, searchGlobalFragment.d.b());
                    TerminalActivity.d(searchGlobalFragment.getActivity(), SearchMoreCircleFragment.class, bundle);
                } else if (a3 == 5) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString(SearchIndexablesContract.RawData.COLUMN_KEYWORDS, searchGlobalFragment.d.b());
                    TerminalActivity.d(searchGlobalFragment.getActivity(), SearchMoreSubjectFragment.class, bundle2);
                } else {
                    Context context = searchGlobalFragment.getContext();
                    Bundle bundle3 = new Bundle();
                    bundle3.putInt(WifiEnterpriseConfig.PRIVATE_KEY_ID_KEY, searchGlobalInfo.a());
                    bundle3.putString("search_keywords", searchGlobalFragment.d.b());
                    Unit unit = Unit.a;
                    TerminalActivity.d(context, SearchGlobalMoreFragment.class, bundle3);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(SearchGlobalFragment searchGlobalFragment, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        searchGlobalFragment.a(str, z);
    }

    private final void a(String str, boolean z) {
        SearchView searchView;
        SearchEditText editView;
        NoDataAndLoadFailView noDataAndLoadFailView;
        if (this.e) {
            return;
        }
        this.e = true;
        AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.search.-$$Lambda$SearchGlobalFragment$jfQWLvW5aGtSa_WDpZgFvceLaFA
            @Override // java.lang.Runnable
            public final void run() {
                SearchGlobalFragment.d(SearchGlobalFragment.this);
            }
        }, 500L);
        String str2 = str;
        boolean z2 = true;
        if (str2 != null) {
            z2 = str2.length() == 0;
        }
        if (z2) {
            return;
        }
        this.d.a(str);
        this.d.setNewData(CollectionsKt.b());
        d();
        FmSearchGlobalBinding a2 = a();
        if (a2 != null && (noDataAndLoadFailView = a2.d) != null) {
            noDataAndLoadFailView.d();
        }
        c();
        this.d.e().clear();
        SearchGlobalFragment searchGlobalFragment = this;
        BluedStructureExtKt.a(searchGlobalFragment, new SearchGlobalAction.GetShortcut(str, getFragmentActive()));
        BluedStructureExtKt.a(searchGlobalFragment, new SearchGlobalAction.DoSearch(str));
        if (z) {
            KeyboardUtils.a(getActivity());
            FmSearchGlobalBinding a3 = a();
            if (a3 == null || (searchView = a3.f) == null || (editView = searchView.getEditView()) == null) {
                return;
            }
            editView.clearFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(final List<String> list) {
        final FmSearchGlobalBinding a2 = a();
        if (a2 == null) {
            return;
        }
        a2.f15071a.removeAllViews();
        for (String str : list) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.item_search_global_recent, (ViewGroup) null);
            Intrinsics.c(inflate, "from(context)\n          …arch_global_recent, null)");
            ((TextView) inflate.findViewById(2131370786)).setText(str);
            a2.f15071a.addView(inflate);
        }
        a2.f15071a.setOnItemClickListener(new FlowLayout.OnItemClickListener() { // from class: com.soft.blued.ui.search.-$$Lambda$SearchGlobalFragment$j8UKLuVCipEUW3xlLPxwDhijaEQ
            public final void onItemClick(View view, int i) {
                SearchGlobalFragment.a(list, a2, this, view, i);
            }
        });
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(List list, FmSearchGlobalBinding fmSearchGlobalBinding, SearchGlobalFragment searchGlobalFragment, View view, int i) {
        Intrinsics.e(list, "$recentList");
        Intrinsics.e(fmSearchGlobalBinding, "$vb");
        Intrinsics.e(searchGlobalFragment, "this$0");
        String str = (String) list.get(i);
        fmSearchGlobalBinding.f.getEditView().setText(str);
        fmSearchGlobalBinding.f.getEditView().setSelection(str.length());
        a(searchGlobalFragment, str, false, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a(SearchGlobalFragment searchGlobalFragment, FmSearchGlobalBinding fmSearchGlobalBinding, TextView textView, int i, KeyEvent keyEvent) {
        Intrinsics.e(searchGlobalFragment, "this$0");
        Intrinsics.e(fmSearchGlobalBinding, "$vb");
        if (i == 3) {
            searchGlobalFragment.a(String.valueOf(fmSearchGlobalBinding.f.getEditView().getText()), true);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b() {
        SearchView searchView;
        SearchView searchView2;
        SearchEditText editView;
        KeyboardUtils.c(getActivity());
        FmSearchGlobalBinding a2 = a();
        if (a2 != null && (searchView2 = a2.f) != null && (editView = searchView2.getEditView()) != null) {
            editView.requestFocus();
        }
        FmSearchGlobalBinding a3 = a();
        SearchEditText searchEditText = null;
        if (a3 != null && (searchView = a3.f) != null) {
            searchEditText = searchView.getEditView();
        }
        if (searchEditText == null) {
            return;
        }
        searchEditText.setCursorVisible(true);
    }

    private final void b(List<SearchGlobalInfo.SearchShortcutModel> list) {
        Context context;
        FmSearchGlobalBinding a2 = a();
        if (a2 == null || (context = getContext()) == null) {
            return;
        }
        List<SearchGlobalInfo.SearchShortcutModel> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            d();
            return;
        }
        if (a2.d.c()) {
            a2.d.d();
        }
        SearchGlobalShortcutHeader searchGlobalShortcutHeader = new SearchGlobalShortcutHeader(context);
        searchGlobalShortcutHeader.setRequestHost((IRequestHost) getFragmentActive());
        searchGlobalShortcutHeader.a(list, this.d.b());
        if (this.d.getHeaderLayoutCount() == 0) {
            this.d.setHeaderView(searchGlobalShortcutHeader);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c() {
        FmSearchGlobalBinding a2 = a();
        if (a2 == null) {
            return;
        }
        if (a2.f15071a.getChildCount() > 0) {
            String valueOf = String.valueOf(a2.f.getEditView().getText());
            if (valueOf == null || valueOf.length() == 0) {
                a2.f15072c.setVisibility(0);
                return;
            }
        }
        a2.f15072c.setVisibility(8);
    }

    private final void d() {
        if (this.d.getHeaderLayoutCount() > 0) {
            this.d.removeAllHeaderView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(SearchGlobalFragment searchGlobalFragment) {
        Intrinsics.e(searchGlobalFragment, "this$0");
        searchGlobalFragment.e = false;
    }

    public void a(boolean z, boolean z2) {
        LinearLayout footerLayout = this.d.getFooterLayout();
        if (footerLayout == null) {
            return;
        }
        footerLayout.setVisibility(8);
    }

    public void m() {
        final FmSearchGlobalBinding a2 = a();
        if (a2 == null) {
            return;
        }
        a2.d.setNoDataImg(2131233637);
        a2.d.setNoDataStr((int) R.string.friend_global_search_none);
        SearchGlobalAdapter searchGlobalAdapter = this.d;
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        ProgressBar progressBar = new ProgressBar(relativeLayout.getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        Unit unit = Unit.a;
        relativeLayout.addView(progressBar, layoutParams);
        searchGlobalAdapter.setFooterView(relativeLayout);
        this.d.getFooterLayout().setVisibility(8);
        this.d.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() { // from class: com.soft.blued.ui.search.-$$Lambda$SearchGlobalFragment$GuIhDqFe2Ld9linXnxM8hyT6fEM
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                SearchGlobalFragment.a(SearchGlobalFragment.this, baseQuickAdapter, view, i);
            }
        });
        a2.e.setLayoutManager(new LinearLayoutManager(getContext()));
        a2.e.setAdapter(this.d);
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.search.-$$Lambda$SearchGlobalFragment$1r7MIRJMDXq8lOneET6G5UkiVo8
            @Override // java.lang.Runnable
            public final void run() {
                SearchGlobalFragment.a(FmSearchGlobalBinding.this, this);
            }
        }, 500L);
        a2.f.getEditView().setHint((int) R.string.friend_global_search_hint);
        TextView editView = a2.f.getEditView();
        Intrinsics.c(editView, "vb.searchView.editView");
        editView.addTextChangedListener(new TextWatcher() { // from class: com.soft.blued.ui.search.SearchGlobalFragment$initView$lambda-9$$inlined$doAfterTextChanged$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                SearchGlobalFragment.this.c();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        a2.f.setOnSearchInfoListener(new SearchView.OnSearchInfoListener() { // from class: com.soft.blued.ui.search.SearchGlobalFragment$initView$1$5
            public void a() {
                FragmentActivity activity = SearchGlobalFragment.this.getActivity();
                if (activity == null) {
                    return;
                }
                activity.finish();
            }

            public void a(String str) {
                SearchGlobalFragment.a(SearchGlobalFragment.this, str, false, 2, (Object) null);
            }

            public void b() {
                SearchGlobalAdapter searchGlobalAdapter2;
                searchGlobalAdapter2 = SearchGlobalFragment.this.d;
                searchGlobalAdapter2.setNewData(CollectionsKt.b());
                SearchGlobalFragment.this.c();
                SearchGlobalFragment.this.b();
            }
        });
        a2.b.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.search.-$$Lambda$SearchGlobalFragment$EJ1YSmqmZ3tM0RmP8r5SBZJM8d4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchGlobalFragment.a(FmSearchGlobalBinding.this, this, view);
            }
        });
        a2.f15072c.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.search.-$$Lambda$SearchGlobalFragment$w8qeHP4hlgmszr23o-b93uAw68Y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchGlobalFragment.a(view);
            }
        });
        a2.f.getEditView().setSingleLine(true);
        a2.f.getEditView().setImeOptions(3);
        a2.f.getEditView().setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.soft.blued.ui.search.-$$Lambda$SearchGlobalFragment$QQsX4ezQxw3AeRtyjh-mDRwg_uA
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                boolean a3;
                a3 = SearchGlobalFragment.a(SearchGlobalFragment.this, a2, textView, i, keyEvent);
                return a3;
            }
        });
    }

    public void o() {
        SearchGlobalFragment searchGlobalFragment = this;
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.c(viewLifecycleOwner, "viewLifecycleOwner");
        BluedStructureExtKt.a(searchGlobalFragment, viewLifecycleOwner, new PropertyReference1Impl() { // from class: com.soft.blued.ui.search.SearchGlobalFragment$liveDataObserver$1
            public Object a(Object obj) {
                return ((SearchGlobalState) obj).getData();
            }
        }, new Function1<List<? extends SearchGlobalInfo>, Unit>() { // from class: com.soft.blued.ui.search.SearchGlobalFragment$liveDataObserver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void a(List<SearchGlobalInfo> list) {
                SearchGlobalAdapter searchGlobalAdapter;
                Intrinsics.e(list, "it");
                searchGlobalAdapter = SearchGlobalFragment.this.d;
                searchGlobalAdapter.setNewData(list);
            }

            public /* synthetic */ Object invoke(Object obj) {
                a((List) obj);
                return Unit.a;
            }
        });
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.c(viewLifecycleOwner2, "viewLifecycleOwner");
        BluedStructureExtKt.a(searchGlobalFragment, viewLifecycleOwner2, new PropertyReference1Impl() { // from class: com.soft.blued.ui.search.SearchGlobalFragment$liveDataObserver$3
            public Object a(Object obj) {
                return ((SearchGlobalState) obj).getRecentList();
            }
        }, new Function1<List<? extends String>, Unit>() { // from class: com.soft.blued.ui.search.SearchGlobalFragment$liveDataObserver$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void a(List<String> list) {
                Intrinsics.e(list, "it");
                SearchGlobalFragment.this.a(list);
            }

            public /* synthetic */ Object invoke(Object obj) {
                a((List) obj);
                return Unit.a;
            }
        });
    }

    public void onEvent(UiEvent uiEvent) {
        Intrinsics.e(uiEvent, "event");
        if (uiEvent instanceof SearchGlobalEvent.ShortcutEvent) {
            b(((SearchGlobalEvent.ShortcutEvent) uiEvent).a());
        }
    }

    public void onResume() {
        super.onResume();
        BluedStructureExtKt.a(this, SearchGlobalAction.GetRecentRecord.f19481a);
    }

    public void r() {
        LinearLayout footerLayout = this.d.getFooterLayout();
        if (footerLayout == null) {
            return;
        }
        footerLayout.setVisibility(0);
    }

    public void z() {
        FmSearchGlobalBinding a2;
        NoDataAndLoadFailView noDataAndLoadFailView;
        if (this.d.getHeaderLayoutCount() != 0 || (a2 = a()) == null || (noDataAndLoadFailView = a2.d) == null) {
            return;
        }
        noDataAndLoadFailView.a();
    }
}
