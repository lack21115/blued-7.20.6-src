package com.blued.community.ui.send.dialog;

import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.view.SearchEditText;
import com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetBehavior;
import com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialog;
import com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialogFragment;
import com.blued.android.module.common.base.mvvm.LifecycleExtKt;
import com.blued.android.module.common.utils.click.SingleItemClickProxy;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.common.view.SearchView;
import com.blued.android.module.common.widget.refresh.BluedAdapterLoadMoreView;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.databinding.DialogFeedPostTopicBinding;
import com.blued.community.ui.feed.manager.FeedMethods;
import com.blued.community.ui.send.fragment.FeedAddPostFragment;
import com.blued.community.ui.send.vm.SelectTopicViewModel;
import com.blued.community.ui.topic.adapter.SuperTopicAdapter;
import com.blued.community.ui.topic.model.BluedTopic;
import com.blued.community.utils.StringUtils;
import com.blued.community.utils.ViewUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/send/dialog/SelectTopicDialogFragment.class */
public final class SelectTopicDialogFragment extends BottomSheetDialogFragment {
    public static final Companion a = new Companion(null);
    public SuperTopicAdapter b;
    public NoDataAndLoadFailView c;
    private DialogFeedPostTopicBinding d;
    private SelectTopicViewModel e;
    private boolean f;
    private OnTopicListener g;

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/send/dialog/SelectTopicDialogFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SelectTopicDialogFragment a(FragmentManager manager, boolean z, int i) {
            Intrinsics.e(manager, "manager");
            SelectTopicDialogFragment selectTopicDialogFragment = new SelectTopicDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean("is_voting", z);
            bundle.putInt("is_template_qa", i);
            selectTopicDialogFragment.setArguments(bundle);
            selectTopicDialogFragment.show(manager, SelectTopicDialogFragment.class.getSimpleName());
            return selectTopicDialogFragment;
        }
    }

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/send/dialog/SelectTopicDialogFragment$OnTopicListener.class */
    public interface OnTopicListener {
        boolean chooseTopic(BluedTopic bluedTopic);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(SelectTopicDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        DialogFeedPostTopicBinding dialogFeedPostTopicBinding = this$0.d;
        DialogFeedPostTopicBinding dialogFeedPostTopicBinding2 = dialogFeedPostTopicBinding;
        if (dialogFeedPostTopicBinding == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostTopicBinding2 = null;
        }
        dialogFeedPostTopicBinding2.f.getEditView().setText("");
        this$0.k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(SelectTopicDialogFragment this$0, View view, boolean z) {
        Intrinsics.e(this$0, "this$0");
        this$0.a(z);
        if (z) {
            return;
        }
        this$0.f = true;
        DialogFeedPostTopicBinding dialogFeedPostTopicBinding = this$0.d;
        DialogFeedPostTopicBinding dialogFeedPostTopicBinding2 = dialogFeedPostTopicBinding;
        if (dialogFeedPostTopicBinding == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostTopicBinding2 = null;
        }
        this$0.a(String.valueOf(dialogFeedPostTopicBinding2.f.getEditView().getText()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(SelectTopicDialogFragment this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.e(this$0, "this$0");
        if (!(baseQuickAdapter.getItem(i) instanceof BluedTopic)) {
            this$0.k();
            return;
        }
        BluedTopic bluedTopic = (BluedTopic) baseQuickAdapter.getItem(i);
        if (bluedTopic != null && bluedTopic.is_local_2b_created && !StringUtils.d(bluedTopic.topics_msg)) {
            AppMethods.a((CharSequence) bluedTopic.topics_msg);
        } else if (bluedTopic == null) {
        } else {
            boolean z = bluedTopic.is_chosen;
            OnTopicListener j = this$0.j();
            if (j != null && j.chooseTopic(bluedTopic)) {
                bluedTopic.is_chosen = true;
                this$0.dismiss();
            } else {
                bluedTopic.is_chosen = false;
                if (z) {
                    this$0.dismiss();
                }
            }
            baseQuickAdapter.notifyItemChanged(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str) {
        if (str.length() > 15) {
            AppMethods.d(R.string.no_more_than_15_chars);
            DialogFeedPostTopicBinding dialogFeedPostTopicBinding = this.d;
            DialogFeedPostTopicBinding dialogFeedPostTopicBinding2 = dialogFeedPostTopicBinding;
            if (dialogFeedPostTopicBinding == null) {
                Intrinsics.c("viewBinding");
                dialogFeedPostTopicBinding2 = null;
            }
            SearchEditText editView = dialogFeedPostTopicBinding2.f.getEditView();
            String substring = str.substring(0, 15);
            Intrinsics.c(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            editView.setText(substring);
            DialogFeedPostTopicBinding dialogFeedPostTopicBinding3 = this.d;
            if (dialogFeedPostTopicBinding3 == null) {
                Intrinsics.c("viewBinding");
                dialogFeedPostTopicBinding3 = null;
            }
            dialogFeedPostTopicBinding3.f.getEditView().setSelection(15);
            return;
        }
        i().d();
        if (TextUtils.isEmpty(str)) {
            h().setEnableLoadMore(true);
            SelectTopicViewModel selectTopicViewModel = this.e;
            if (selectTopicViewModel == null) {
                Intrinsics.c("mViewModel");
                selectTopicViewModel = null;
            }
            selectTopicViewModel.a(true, h());
            return;
        }
        h().setEnableLoadMore(true);
        SelectTopicViewModel selectTopicViewModel2 = this.e;
        if (selectTopicViewModel2 == null) {
            Intrinsics.c("mViewModel");
            selectTopicViewModel2 = null;
        }
        selectTopicViewModel2.a(true, str, h());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a(SelectTopicDialogFragment this$0, View view, MotionEvent motionEvent) {
        Intrinsics.e(this$0, "this$0");
        Context context = this$0.getContext();
        DialogFeedPostTopicBinding dialogFeedPostTopicBinding = this$0.d;
        DialogFeedPostTopicBinding dialogFeedPostTopicBinding2 = dialogFeedPostTopicBinding;
        if (dialogFeedPostTopicBinding == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostTopicBinding2 = null;
        }
        KeyboardUtils.b(context, (View) dialogFeedPostTopicBinding2.f.getEditView());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(SelectTopicDialogFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        DialogFeedPostTopicBinding dialogFeedPostTopicBinding = this$0.d;
        DialogFeedPostTopicBinding dialogFeedPostTopicBinding2 = dialogFeedPostTopicBinding;
        if (dialogFeedPostTopicBinding == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostTopicBinding2 = null;
        }
        String valueOf = String.valueOf(dialogFeedPostTopicBinding2.f.getEditView().getText());
        if (valueOf.length() == 0) {
            SelectTopicViewModel selectTopicViewModel = this$0.e;
            if (selectTopicViewModel == null) {
                Intrinsics.c("mViewModel");
                selectTopicViewModel = null;
            }
            selectTopicViewModel.a(false, this$0.h());
            return;
        }
        SelectTopicViewModel selectTopicViewModel2 = this$0.e;
        if (selectTopicViewModel2 == null) {
            Intrinsics.c("mViewModel");
            selectTopicViewModel2 = null;
        }
        selectTopicViewModel2.a(false, valueOf, this$0.h());
    }

    private final void l() {
        a(new SuperTopicAdapter(getContext(), a()));
        SuperTopicAdapter h = h();
        SelectTopicViewModel selectTopicViewModel = this.e;
        SelectTopicViewModel selectTopicViewModel2 = selectTopicViewModel;
        if (selectTopicViewModel == null) {
            Intrinsics.c("mViewModel");
            selectTopicViewModel2 = null;
        }
        h.b(selectTopicViewModel2.e());
        SuperTopicAdapter h2 = h();
        SelectTopicViewModel selectTopicViewModel3 = this.e;
        SelectTopicViewModel selectTopicViewModel4 = selectTopicViewModel3;
        if (selectTopicViewModel3 == null) {
            Intrinsics.c("mViewModel");
            selectTopicViewModel4 = null;
        }
        h2.setNewData((List) selectTopicViewModel4.j().getValue());
        h().a(new SuperTopicAdapter.OnShowListener() { // from class: com.blued.community.ui.send.dialog.SelectTopicDialogFragment$initData$1
            @Override // com.blued.community.ui.topic.adapter.SuperTopicAdapter.OnShowListener
            public void a(BluedTopic bluedTopic) {
                Intrinsics.e(bluedTopic, "bluedTopic");
            }

            @Override // com.blued.community.ui.topic.adapter.SuperTopicAdapter.OnShowListener
            public void b(BluedTopic bluedTopic) {
                Intrinsics.e(bluedTopic, "bluedTopic");
                bluedTopic.is_chosen = FeedMethods.a(bluedTopic, FeedAddPostFragment.aU);
            }
        });
        a(new NoDataAndLoadFailView(getContext()));
        i().setNoDataImg(R.drawable.icon_no_data_people);
        if (CommunityServiceManager.a().D() == 1) {
            i().setNoDataStr(R.string.feed_subject_no_search_data);
        } else {
            i().setNoDataStr(R.string.super_topic_search_no_data);
        }
        i().setTopSpace(DensityUtils.a(getContext(), 40.0f));
        i().setImageScale(0.7f);
        i().d();
        h().setEmptyView(i());
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        SelectTopicViewModel selectTopicViewModel5 = this.e;
        SelectTopicViewModel selectTopicViewModel6 = selectTopicViewModel5;
        if (selectTopicViewModel5 == null) {
            Intrinsics.c("mViewModel");
            selectTopicViewModel6 = null;
        }
        LifecycleExtKt.a(lifecycleOwner, selectTopicViewModel6.j(), new Function1<List<BluedTopic>, Unit>() { // from class: com.blued.community.ui.send.dialog.SelectTopicDialogFragment$initData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void a(List<BluedTopic> list) {
                SelectTopicDialogFragment.this.h().setNewData(list);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Unit invoke(List<BluedTopic> list) {
                a(list);
                return Unit.a;
            }
        });
        SelectTopicViewModel selectTopicViewModel7 = this.e;
        SelectTopicViewModel selectTopicViewModel8 = selectTopicViewModel7;
        if (selectTopicViewModel7 == null) {
            Intrinsics.c("mViewModel");
            selectTopicViewModel8 = null;
        }
        LifecycleExtKt.a(lifecycleOwner, selectTopicViewModel8.k(), new Function1<String, Unit>() { // from class: com.blued.community.ui.send.dialog.SelectTopicDialogFragment$initData$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void a(String str) {
                SelectTopicDialogFragment.this.h().a(str);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Unit invoke(String str) {
                a(str);
                return Unit.a;
            }
        });
        SelectTopicViewModel selectTopicViewModel9 = this.e;
        SelectTopicViewModel selectTopicViewModel10 = selectTopicViewModel9;
        if (selectTopicViewModel9 == null) {
            Intrinsics.c("mViewModel");
            selectTopicViewModel10 = null;
        }
        LifecycleExtKt.a(lifecycleOwner, selectTopicViewModel10.l(), new Function1<Boolean, Unit>() { // from class: com.blued.community.ui.send.dialog.SelectTopicDialogFragment$initData$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void a(Boolean it) {
                boolean z;
                Intrinsics.c(it, "it");
                if (!it.booleanValue()) {
                    if (it.booleanValue()) {
                        return;
                    }
                    SelectTopicDialogFragment.this.i().b();
                    return;
                }
                z = SelectTopicDialogFragment.this.f;
                if (z) {
                    SelectTopicDialogFragment.this.i().a();
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Unit invoke(Boolean bool) {
                a(bool);
                return Unit.a;
            }
        });
        SelectTopicViewModel selectTopicViewModel11 = this.e;
        if (selectTopicViewModel11 == null) {
            Intrinsics.c("mViewModel");
            selectTopicViewModel11 = null;
        }
        LifecycleExtKt.a(lifecycleOwner, selectTopicViewModel11.m(), new Function1<Boolean, Unit>() { // from class: com.blued.community.ui.send.dialog.SelectTopicDialogFragment$initData$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void a(Boolean it) {
                SelectTopicViewModel selectTopicViewModel12;
                Intrinsics.c(it, "it");
                if (!it.booleanValue()) {
                    if (it.booleanValue()) {
                        return;
                    }
                    if (SelectTopicDialogFragment.this.h().getData().size() > 0) {
                        SelectTopicDialogFragment.this.h().loadMoreFail();
                        return;
                    } else {
                        SelectTopicDialogFragment.this.h().setEnableLoadMore(false);
                        return;
                    }
                }
                selectTopicViewModel12 = SelectTopicDialogFragment.this.e;
                SelectTopicViewModel selectTopicViewModel13 = selectTopicViewModel12;
                if (selectTopicViewModel12 == null) {
                    Intrinsics.c("mViewModel");
                    selectTopicViewModel13 = null;
                }
                if (selectTopicViewModel13.i()) {
                    SelectTopicDialogFragment.this.h().loadMoreComplete();
                } else {
                    SelectTopicDialogFragment.this.h().loadMoreEnd();
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Unit invoke(Boolean bool) {
                a(bool);
                return Unit.a;
            }
        });
    }

    private final void m() {
        DialogFeedPostTopicBinding dialogFeedPostTopicBinding = this.d;
        DialogFeedPostTopicBinding dialogFeedPostTopicBinding2 = dialogFeedPostTopicBinding;
        if (dialogFeedPostTopicBinding == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostTopicBinding2 = null;
        }
        ViewGroup.LayoutParams layoutParams = dialogFeedPostTopicBinding2.e.getLayoutParams();
        SelectTopicViewModel selectTopicViewModel = this.e;
        SelectTopicViewModel selectTopicViewModel2 = selectTopicViewModel;
        if (selectTopicViewModel == null) {
            Intrinsics.c("mViewModel");
            selectTopicViewModel2 = null;
        }
        layoutParams.height = selectTopicViewModel2.d();
        if (CommunityServiceManager.a().D() == 1) {
            DialogFeedPostTopicBinding dialogFeedPostTopicBinding3 = this.d;
            DialogFeedPostTopicBinding dialogFeedPostTopicBinding4 = dialogFeedPostTopicBinding3;
            if (dialogFeedPostTopicBinding3 == null) {
                Intrinsics.c("viewBinding");
                dialogFeedPostTopicBinding4 = null;
            }
            dialogFeedPostTopicBinding4.a.setText("添加主题");
            DialogFeedPostTopicBinding dialogFeedPostTopicBinding5 = this.d;
            DialogFeedPostTopicBinding dialogFeedPostTopicBinding6 = dialogFeedPostTopicBinding5;
            if (dialogFeedPostTopicBinding5 == null) {
                Intrinsics.c("viewBinding");
                dialogFeedPostTopicBinding6 = null;
            }
            dialogFeedPostTopicBinding6.f.getEditView().setHint(getString(R.string.topic_search));
        } else {
            DialogFeedPostTopicBinding dialogFeedPostTopicBinding7 = this.d;
            DialogFeedPostTopicBinding dialogFeedPostTopicBinding8 = dialogFeedPostTopicBinding7;
            if (dialogFeedPostTopicBinding7 == null) {
                Intrinsics.c("viewBinding");
                dialogFeedPostTopicBinding8 = null;
            }
            dialogFeedPostTopicBinding8.a.setText(getString(R.string.feed_post_super_topic));
            DialogFeedPostTopicBinding dialogFeedPostTopicBinding9 = this.d;
            DialogFeedPostTopicBinding dialogFeedPostTopicBinding10 = dialogFeedPostTopicBinding9;
            if (dialogFeedPostTopicBinding9 == null) {
                Intrinsics.c("viewBinding");
                dialogFeedPostTopicBinding10 = null;
            }
            dialogFeedPostTopicBinding10.f.getEditView().setHint(requireContext().getString(R.string.search_or_create_topic));
        }
        DialogFeedPostTopicBinding dialogFeedPostTopicBinding11 = this.d;
        DialogFeedPostTopicBinding dialogFeedPostTopicBinding12 = dialogFeedPostTopicBinding11;
        if (dialogFeedPostTopicBinding11 == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostTopicBinding12 = null;
        }
        dialogFeedPostTopicBinding12.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.send.dialog.-$$Lambda$SelectTopicDialogFragment$cf-m8_z0VPkP8TscN4zJVikoad0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectTopicDialogFragment.a(SelectTopicDialogFragment.this, view);
            }
        });
        DialogFeedPostTopicBinding dialogFeedPostTopicBinding13 = this.d;
        DialogFeedPostTopicBinding dialogFeedPostTopicBinding14 = dialogFeedPostTopicBinding13;
        if (dialogFeedPostTopicBinding13 == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostTopicBinding14 = null;
        }
        SearchEditText editView = dialogFeedPostTopicBinding14.f.getEditView();
        SelectTopicViewModel selectTopicViewModel3 = this.e;
        SelectTopicViewModel selectTopicViewModel4 = selectTopicViewModel3;
        if (selectTopicViewModel3 == null) {
            Intrinsics.c("mViewModel");
            selectTopicViewModel4 = null;
        }
        editView.setText((CharSequence) selectTopicViewModel4.k().getValue());
        DialogFeedPostTopicBinding dialogFeedPostTopicBinding15 = this.d;
        DialogFeedPostTopicBinding dialogFeedPostTopicBinding16 = dialogFeedPostTopicBinding15;
        if (dialogFeedPostTopicBinding15 == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostTopicBinding16 = null;
        }
        dialogFeedPostTopicBinding16.f.getEditView().a();
        DialogFeedPostTopicBinding dialogFeedPostTopicBinding17 = this.d;
        DialogFeedPostTopicBinding dialogFeedPostTopicBinding18 = dialogFeedPostTopicBinding17;
        if (dialogFeedPostTopicBinding17 == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostTopicBinding18 = null;
        }
        dialogFeedPostTopicBinding18.f.getEditView().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.blued.community.ui.send.dialog.-$$Lambda$SelectTopicDialogFragment$c6OB1EfHCz7SAf3XbISLhm_pnBk
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                SelectTopicDialogFragment.a(SelectTopicDialogFragment.this, view, z);
            }
        });
        DialogFeedPostTopicBinding dialogFeedPostTopicBinding19 = this.d;
        DialogFeedPostTopicBinding dialogFeedPostTopicBinding20 = dialogFeedPostTopicBinding19;
        if (dialogFeedPostTopicBinding19 == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostTopicBinding20 = null;
        }
        dialogFeedPostTopicBinding20.f.setOnSearchInfoListener(new SearchView.OnSearchInfoListener() { // from class: com.blued.community.ui.send.dialog.SelectTopicDialogFragment$initView$3
            @Override // com.blued.android.module.common.view.SearchView.OnSearchInfoListener
            public void a() {
                SelectTopicDialogFragment.this.k();
            }

            @Override // com.blued.android.module.common.view.SearchView.OnSearchInfoListener
            public void a(String msg) {
                Intrinsics.e(msg, "msg");
                SelectTopicDialogFragment.this.a(msg);
                SelectTopicDialogFragment.this.f = false;
            }

            @Override // com.blued.android.module.common.view.SearchView.OnSearchInfoListener
            public void b() {
            }
        });
        DialogFeedPostTopicBinding dialogFeedPostTopicBinding21 = this.d;
        DialogFeedPostTopicBinding dialogFeedPostTopicBinding22 = dialogFeedPostTopicBinding21;
        if (dialogFeedPostTopicBinding21 == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostTopicBinding22 = null;
        }
        dialogFeedPostTopicBinding22.f.getEditView().setFocusable(true);
        DialogFeedPostTopicBinding dialogFeedPostTopicBinding23 = this.d;
        DialogFeedPostTopicBinding dialogFeedPostTopicBinding24 = dialogFeedPostTopicBinding23;
        if (dialogFeedPostTopicBinding23 == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostTopicBinding24 = null;
        }
        dialogFeedPostTopicBinding24.f.getEditView().setFocusableInTouchMode(true);
        DialogFeedPostTopicBinding dialogFeedPostTopicBinding25 = this.d;
        DialogFeedPostTopicBinding dialogFeedPostTopicBinding26 = dialogFeedPostTopicBinding25;
        if (dialogFeedPostTopicBinding25 == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostTopicBinding26 = null;
        }
        dialogFeedPostTopicBinding26.d.setClipToPadding(false);
        DialogFeedPostTopicBinding dialogFeedPostTopicBinding27 = this.d;
        DialogFeedPostTopicBinding dialogFeedPostTopicBinding28 = dialogFeedPostTopicBinding27;
        if (dialogFeedPostTopicBinding27 == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostTopicBinding28 = null;
        }
        dialogFeedPostTopicBinding28.d.setScrollBarStyle(33554432);
        DialogFeedPostTopicBinding dialogFeedPostTopicBinding29 = this.d;
        DialogFeedPostTopicBinding dialogFeedPostTopicBinding30 = dialogFeedPostTopicBinding29;
        if (dialogFeedPostTopicBinding29 == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostTopicBinding30 = null;
        }
        dialogFeedPostTopicBinding30.d.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.blued.community.ui.send.dialog.SelectTopicDialogFragment$initView$4
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                Intrinsics.e(recyclerView, "recyclerView");
                super.onScrolled(recyclerView, i, i2);
                Logger.c("onScrolled", "dx = " + i + ", dy = " + i2);
            }
        });
        DialogFeedPostTopicBinding dialogFeedPostTopicBinding31 = this.d;
        DialogFeedPostTopicBinding dialogFeedPostTopicBinding32 = dialogFeedPostTopicBinding31;
        if (dialogFeedPostTopicBinding31 == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostTopicBinding32 = null;
        }
        dialogFeedPostTopicBinding32.d.setLayoutManager(new LinearLayoutManager(getContext()));
        o();
        DialogFeedPostTopicBinding dialogFeedPostTopicBinding33 = this.d;
        DialogFeedPostTopicBinding dialogFeedPostTopicBinding34 = dialogFeedPostTopicBinding33;
        if (dialogFeedPostTopicBinding33 == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostTopicBinding34 = null;
        }
        dialogFeedPostTopicBinding34.d.setAdapter(h());
        h().setOnItemClickListener(new SingleItemClickProxy(new BaseQuickAdapter.OnItemClickListener() { // from class: com.blued.community.ui.send.dialog.-$$Lambda$SelectTopicDialogFragment$KOCj6ZzasWrgIblS55yDwJLZ5eM
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                SelectTopicDialogFragment.a(SelectTopicDialogFragment.this, baseQuickAdapter, view, i);
            }
        }));
        h().setLoadMoreView(new BluedAdapterLoadMoreView());
        h().setEnableLoadMore(true);
        SuperTopicAdapter h = h();
        BaseQuickAdapter.RequestLoadMoreListener requestLoadMoreListener = new BaseQuickAdapter.RequestLoadMoreListener() { // from class: com.blued.community.ui.send.dialog.-$$Lambda$SelectTopicDialogFragment$K6VnGALNoEJ_CnKz8NRfrTBBBYs
            public final void onLoadMoreRequested() {
                SelectTopicDialogFragment.c(SelectTopicDialogFragment.this);
            }
        };
        DialogFeedPostTopicBinding dialogFeedPostTopicBinding35 = this.d;
        DialogFeedPostTopicBinding dialogFeedPostTopicBinding36 = dialogFeedPostTopicBinding35;
        if (dialogFeedPostTopicBinding35 == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostTopicBinding36 = null;
        }
        h.setOnLoadMoreListener(requestLoadMoreListener, dialogFeedPostTopicBinding36.d);
        DialogFeedPostTopicBinding dialogFeedPostTopicBinding37 = this.d;
        if (dialogFeedPostTopicBinding37 == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostTopicBinding37 = null;
        }
        dialogFeedPostTopicBinding37.d.setOnTouchListener(new View.OnTouchListener() { // from class: com.blued.community.ui.send.dialog.-$$Lambda$SelectTopicDialogFragment$3mb6yacPoVcXqTNED8U6pfTXZ7E
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean a2;
                a2 = SelectTopicDialogFragment.a(SelectTopicDialogFragment.this, view, motionEvent);
                return a2;
            }
        });
    }

    private final void n() {
        DialogFeedPostTopicBinding dialogFeedPostTopicBinding = this.d;
        DialogFeedPostTopicBinding dialogFeedPostTopicBinding2 = dialogFeedPostTopicBinding;
        if (dialogFeedPostTopicBinding == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostTopicBinding2 = null;
        }
        int[] a2 = ViewUtils.a(dialogFeedPostTopicBinding2.d);
        SelectTopicViewModel selectTopicViewModel = this.e;
        SelectTopicViewModel selectTopicViewModel2 = selectTopicViewModel;
        if (selectTopicViewModel == null) {
            Intrinsics.c("mViewModel");
            selectTopicViewModel2 = null;
        }
        selectTopicViewModel2.b(a2[0]);
        SelectTopicViewModel selectTopicViewModel3 = this.e;
        if (selectTopicViewModel3 == null) {
            Intrinsics.c("mViewModel");
            selectTopicViewModel3 = null;
        }
        selectTopicViewModel3.c(a2[1]);
    }

    private final void o() {
        DialogFeedPostTopicBinding dialogFeedPostTopicBinding = this.d;
        DialogFeedPostTopicBinding dialogFeedPostTopicBinding2 = dialogFeedPostTopicBinding;
        if (dialogFeedPostTopicBinding == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostTopicBinding2 = null;
        }
        RecyclerView recyclerView = dialogFeedPostTopicBinding2.d;
        SelectTopicViewModel selectTopicViewModel = this.e;
        SelectTopicViewModel selectTopicViewModel2 = selectTopicViewModel;
        if (selectTopicViewModel == null) {
            Intrinsics.c("mViewModel");
            selectTopicViewModel2 = null;
        }
        int g = selectTopicViewModel2.g();
        SelectTopicViewModel selectTopicViewModel3 = this.e;
        if (selectTopicViewModel3 == null) {
            Intrinsics.c("mViewModel");
            selectTopicViewModel3 = null;
        }
        ViewUtils.a(recyclerView, g, selectTopicViewModel3.h());
    }

    public final void a(NoDataAndLoadFailView noDataAndLoadFailView) {
        Intrinsics.e(noDataAndLoadFailView, "<set-?>");
        this.c = noDataAndLoadFailView;
    }

    public final void a(OnTopicListener onTopicListener) {
        this.g = onTopicListener;
    }

    public final void a(SuperTopicAdapter superTopicAdapter) {
        Intrinsics.e(superTopicAdapter, "<set-?>");
        this.b = superTopicAdapter;
    }

    public final void a(boolean z) {
        DialogFeedPostTopicBinding dialogFeedPostTopicBinding = this.d;
        DialogFeedPostTopicBinding dialogFeedPostTopicBinding2 = dialogFeedPostTopicBinding;
        if (dialogFeedPostTopicBinding == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostTopicBinding2 = null;
        }
        if (dialogFeedPostTopicBinding2.f != null) {
            DialogFeedPostTopicBinding dialogFeedPostTopicBinding3 = this.d;
            DialogFeedPostTopicBinding dialogFeedPostTopicBinding4 = dialogFeedPostTopicBinding3;
            if (dialogFeedPostTopicBinding3 == null) {
                Intrinsics.c("viewBinding");
                dialogFeedPostTopicBinding4 = null;
            }
            dialogFeedPostTopicBinding4.f.a(z);
            DialogFeedPostTopicBinding dialogFeedPostTopicBinding5 = this.d;
            DialogFeedPostTopicBinding dialogFeedPostTopicBinding6 = dialogFeedPostTopicBinding5;
            if (dialogFeedPostTopicBinding5 == null) {
                Intrinsics.c("viewBinding");
                dialogFeedPostTopicBinding6 = null;
            }
            dialogFeedPostTopicBinding6.f.getEditView().setFocusable(true);
            DialogFeedPostTopicBinding dialogFeedPostTopicBinding7 = this.d;
            DialogFeedPostTopicBinding dialogFeedPostTopicBinding8 = dialogFeedPostTopicBinding7;
            if (dialogFeedPostTopicBinding7 == null) {
                Intrinsics.c("viewBinding");
                dialogFeedPostTopicBinding8 = null;
            }
            dialogFeedPostTopicBinding8.f.getEditView().setFocusableInTouchMode(true);
            DialogFeedPostTopicBinding dialogFeedPostTopicBinding9 = this.d;
            if (dialogFeedPostTopicBinding9 == null) {
                Intrinsics.c("viewBinding");
                dialogFeedPostTopicBinding9 = null;
            }
            dialogFeedPostTopicBinding9.f.getEditView().setCursorVisible(z);
        }
    }

    public final SuperTopicAdapter h() {
        SuperTopicAdapter superTopicAdapter = this.b;
        if (superTopicAdapter != null) {
            return superTopicAdapter;
        }
        Intrinsics.c("superTopicAdapter");
        return null;
    }

    public final NoDataAndLoadFailView i() {
        NoDataAndLoadFailView noDataAndLoadFailView = this.c;
        if (noDataAndLoadFailView != null) {
            return noDataAndLoadFailView;
        }
        Intrinsics.c("noDataView");
        return null;
    }

    public final OnTopicListener j() {
        return this.g;
    }

    public final void k() {
        dismiss();
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ViewModelStore viewModelStore = requireActivity().getViewModelStore();
        Intrinsics.c(viewModelStore, "requireActivity().viewModelStore");
        ViewModelProvider.AndroidViewModelFactory.Companion companion = ViewModelProvider.AndroidViewModelFactory.Companion;
        Context d = AppInfo.d();
        if (d == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.app.Application");
        }
        this.e = (SelectTopicViewModel) new ViewModelProvider(viewModelStore, companion.getInstance((Application) d)).get(SelectTopicViewModel.class);
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.e(dialog, "dialog");
        n();
        super.onDismiss(dialog);
    }

    @Override // com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialogFragment
    public void setupDialog(Dialog dialog, int i) {
        Intrinsics.e(dialog, "dialog");
        super.setupDialog(dialog, i);
        DialogFeedPostTopicBinding a2 = DialogFeedPostTopicBinding.a(LayoutInflater.from(getContext()));
        Intrinsics.c(a2, "inflate(LayoutInflater.from(context))");
        this.d = a2;
        DialogFeedPostTopicBinding dialogFeedPostTopicBinding = a2;
        if (a2 == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostTopicBinding = null;
        }
        dialog.setContentView(dialogFeedPostTopicBinding.getRoot());
        BottomSheetBehavior<FrameLayout> a3 = ((BottomSheetDialog) dialog).a();
        SelectTopicViewModel selectTopicViewModel = this.e;
        SelectTopicViewModel selectTopicViewModel2 = selectTopicViewModel;
        if (selectTopicViewModel == null) {
            Intrinsics.c("mViewModel");
            selectTopicViewModel2 = null;
        }
        a3.a(selectTopicViewModel2.d());
        l();
        m();
        if (h().getData().size() <= 0) {
            SelectTopicViewModel selectTopicViewModel3 = this.e;
            if (selectTopicViewModel3 == null) {
                Intrinsics.c("mViewModel");
                selectTopicViewModel3 = null;
            }
            selectTopicViewModel3.a(true, h());
        }
    }
}
