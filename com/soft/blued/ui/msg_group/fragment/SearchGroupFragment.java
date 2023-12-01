package com.soft.blued.ui.msg_group.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.view.SearchEditText;
import com.blued.android.module.common.base.config.ListConfig;
import com.blued.android.module.common.base.mvi.BaseListFragment;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.group.GroupInfoModel;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.common.view.SearchView;
import com.blued.das.client.socialnet.SocialNetWorkProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.sobot.chat.widget.kpswitch.util.KeyboardUtil;
import com.soft.blued.R;
import com.soft.blued.databinding.FmSearchGroupBinding;
import com.soft.blued.log.track.EventTrackGroup;
import com.soft.blued.ui.msg_group.adapter.MyGroupAdapter;
import com.soft.blued.ui.msg_group.viewmodel.SearchGroupVM;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/fragment/SearchGroupFragment.class */
public final class SearchGroupFragment extends BaseListFragment<SearchGroupVM, GroupInfoModel> {
    static final /* synthetic */ KProperty<Object>[] b = {Reflection.a(new PropertyReference1Impl(SearchGroupFragment.class, "vb", "getVb()Lcom/soft/blued/databinding/FmSearchGroupBinding;", 0))};

    /* renamed from: c  reason: collision with root package name */
    private final ViewBindingProperty f32775c;
    private String d;
    private Dialog e;
    private final Runnable f;

    public SearchGroupFragment() {
        super(R.layout.fm_search_group);
        this.f32775c = this instanceof DialogFragment ? new DialogFragmentViewBindingProperty(new Function1<SearchGroupFragment, FmSearchGroupBinding>() { // from class: com.soft.blued.ui.msg_group.fragment.SearchGroupFragment$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FmSearchGroupBinding invoke(SearchGroupFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FmSearchGroupBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<SearchGroupFragment, FmSearchGroupBinding>() { // from class: com.soft.blued.ui.msg_group.fragment.SearchGroupFragment$special$$inlined$viewBindingFragment$default$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FmSearchGroupBinding invoke(SearchGroupFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FmSearchGroupBinding.a(fragment.requireView());
            }
        });
        this.d = "";
        this.f = new Runnable() { // from class: com.soft.blued.ui.msg_group.fragment.-$$Lambda$SearchGroupFragment$JvoKeItmQauKPCzzRjAOh2SGJRw
            @Override // java.lang.Runnable
            public final void run() {
                SearchGroupFragment.d(SearchGroupFragment.this);
            }
        };
    }

    private final FmSearchGroupBinding D() {
        return (FmSearchGroupBinding) this.f32775c.b(this, b[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(SearchGroupFragment this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.e(this$0, "this$0");
        Object obj = baseQuickAdapter.getData().get(i);
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.common.group.GroupInfoModel");
        }
        GroupInfoModel groupInfoModel = (GroupInfoModel) obj;
        GroupInfoFragment.a(this$0.getContext(), String.valueOf(groupInfoModel.group_id), groupInfoModel, SocialNetWorkProtos.SourceType.UNKNOWN_SOURCE_TYPE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a(SearchGroupFragment this$0, TextView textView, int i, KeyEvent keyEvent) {
        SearchView searchView;
        SearchView searchView2;
        SearchEditText editView;
        Intrinsics.e(this$0, "this$0");
        if (i == 4 || i == 6 || (keyEvent != null && 66 == keyEvent.getKeyCode() && keyEvent.getAction() == 0)) {
            FmSearchGroupBinding D = this$0.D();
            if (D != null && (searchView2 = D.f28764c) != null && (editView = searchView2.getEditView()) != null) {
                editView.clearFocus();
            }
            FmSearchGroupBinding D2 = this$0.D();
            SearchEditText searchEditText = null;
            if (D2 != null && (searchView = D2.f28764c) != null) {
                searchEditText = searchView.getEditView();
            }
            KeyboardUtil.hideKeyboard(searchEditText);
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(SearchGroupFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        ((MyGroupAdapter) this$0.f()).a(this$0.d);
        ((SearchGroupVM) this$0.y()).a(this$0.d);
        EventTrackGroup.a(SocialNetWorkProtos.Event.GROUP_SEARCH, this$0.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(SearchGroupFragment this$0) {
        SearchView searchView;
        SearchView searchView2;
        SearchEditText editView;
        SearchView searchView3;
        Intrinsics.e(this$0, "this$0");
        FmSearchGroupBinding D = this$0.D();
        if (D != null && (searchView3 = D.f28764c) != null) {
            searchView3.a(true);
        }
        KeyboardUtils.c(this$0.getActivity());
        FmSearchGroupBinding D2 = this$0.D();
        if (D2 != null && (searchView2 = D2.f28764c) != null && (editView = searchView2.getEditView()) != null) {
            editView.requestFocus();
        }
        FmSearchGroupBinding D3 = this$0.D();
        SearchEditText searchEditText = null;
        if (D3 != null && (searchView = D3.f28764c) != null) {
            searchEditText = searchView.getEditView();
        }
        if (searchEditText == null) {
            return;
        }
        searchEditText.setCursorVisible(true);
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment
    /* renamed from: C */
    public MyGroupAdapter i() {
        return new MyGroupAdapter(getFragmentActive());
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment, com.blued.android.module.common.base.mvi.MVIBaseFragment
    public void a(boolean z, boolean z2) {
        super.a(z, z2);
        RecyclerView a2 = a();
        if (a2 == null) {
            return;
        }
        a2.setVisibility(0);
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment
    public ListConfig h() {
        ListConfig h = super.h();
        h.a(false);
        h.b(false);
        return h;
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment
    public void j() {
        super.j();
        FmSearchGroupBinding D = D();
        a(D == null ? null : D.b);
        FmSearchGroupBinding D2 = D();
        a(D2 == null ? null : D2.f28763a);
        NoDataAndLoadFailView c2 = c();
        if (c2 != null) {
            c2.setNoDataImg(2131233637);
        }
        NoDataAndLoadFailView c3 = c();
        if (c3 == null) {
            return;
        }
        c3.setNoDataStr(R.string.msg_search_no_data_tip);
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment, com.blued.android.module.common.base.mvi.MVIBaseFragment
    public void m() {
        SearchView searchView;
        SearchEditText editView;
        SearchView searchView2;
        SearchEditText editView2;
        SearchView searchView3;
        super.m();
        this.e = DialogUtils.a(getContext());
        FmSearchGroupBinding D = D();
        if (D != null && (searchView3 = D.f28764c) != null) {
            searchView3.setOnSearchInfoListener(new SearchView.OnSearchInfoListener() { // from class: com.soft.blued.ui.msg_group.fragment.SearchGroupFragment$initView$1
                @Override // com.blued.android.module.common.view.SearchView.OnSearchInfoListener
                public void a() {
                    Dialog dialog;
                    SearchGroupFragment.this.d = "";
                    dialog = SearchGroupFragment.this.e;
                    DialogUtils.b(dialog);
                    FragmentActivity activity = SearchGroupFragment.this.getActivity();
                    if (activity == null) {
                        return;
                    }
                    activity.finish();
                }

                @Override // com.blued.android.module.common.view.SearchView.OnSearchInfoListener
                public void a(String msg) {
                    Runnable runnable;
                    Runnable runnable2;
                    RecyclerView a2;
                    Intrinsics.e(msg, "msg");
                    Log.v("drb", Intrinsics.a("doSearch:", (Object) msg));
                    if (TextUtils.isEmpty(msg)) {
                        a2 = SearchGroupFragment.this.a();
                        if (a2 == null) {
                            return;
                        }
                        a2.setVisibility(4);
                        return;
                    }
                    SearchGroupFragment.this.d = msg;
                    Handler n = AppInfo.n();
                    runnable = SearchGroupFragment.this.f;
                    n.removeCallbacks(runnable);
                    SearchGroupFragment searchGroupFragment = SearchGroupFragment.this;
                    runnable2 = searchGroupFragment.f;
                    searchGroupFragment.postDelaySafeRunOnUiThread(runnable2, 500L);
                }

                @Override // com.blued.android.module.common.view.SearchView.OnSearchInfoListener
                public void b() {
                    Dialog dialog;
                    SearchGroupFragment.this.d = "";
                    dialog = SearchGroupFragment.this.e;
                    DialogUtils.b(dialog);
                }
            });
        }
        FmSearchGroupBinding D2 = D();
        if (D2 != null && (searchView2 = D2.f28764c) != null && (editView2 = searchView2.getEditView()) != null) {
            editView2.setImeOptions(6);
        }
        FmSearchGroupBinding D3 = D();
        if (D3 != null && (searchView = D3.f28764c) != null && (editView = searchView.getEditView()) != null) {
            editView.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.soft.blued.ui.msg_group.fragment.-$$Lambda$SearchGroupFragment$SdKMvxHzsLPqIYdP3g-AkE1sY9s
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    boolean a2;
                    a2 = SearchGroupFragment.a(SearchGroupFragment.this, textView, i, keyEvent);
                    return a2;
                }
            });
        }
        f().setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.-$$Lambda$SearchGroupFragment$MxvjQPrZpWeIJgz2fF8ccrIl0V8
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                SearchGroupFragment.a(SearchGroupFragment.this, baseQuickAdapter, view, i);
            }
        });
    }

    @Override // com.blued.android.module.common.base.mvi.MVIBaseFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.e(view, "view");
        super.onViewCreated(view, bundle);
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.msg_group.fragment.-$$Lambda$SearchGroupFragment$N3UzTRJTUoXVCzCZ09J6e7ceAIs
            @Override // java.lang.Runnable
            public final void run() {
                SearchGroupFragment.e(SearchGroupFragment.this);
            }
        }, 500L);
    }
}
