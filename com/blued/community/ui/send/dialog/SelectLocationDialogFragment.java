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
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.view.SearchEditText;
import com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetBehavior;
import com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialog;
import com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialogFragment;
import com.blued.android.module.common.base.mvvm.LifecycleExtKt;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.PermissionUtils;
import com.blued.android.module.common.utils.gaode.PositionPOIModel;
import com.blued.android.module.common.view.SearchView;
import com.blued.android.module.common.widget.refresh.BluedAdapterLoadMoreView;
import com.blued.community.R;
import com.blued.community.databinding.DialogSelectLocationBinding;
import com.blued.community.databinding.ItemFeedPostLocationBinding;
import com.blued.community.databinding.ItemFeedPostLocationLargerAreaBinding;
import com.blued.community.ui.send.adapter.SelectLocationAdapter;
import com.blued.community.ui.send.vm.SelectLocationViewModel;
import com.blued.community.utils.ViewUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/send/dialog/SelectLocationDialogFragment.class */
public final class SelectLocationDialogFragment extends BottomSheetDialogFragment {
    public static final Companion a = new Companion(null);
    private final boolean b;
    private DialogSelectLocationBinding c;
    private ItemFeedPostLocationBinding d;
    private ItemFeedPostLocationBinding e;
    private ItemFeedPostLocationLargerAreaBinding f;
    private Dialog g;
    private SelectLocationAdapter h;
    private SelectLocationViewModel i;

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/send/dialog/SelectLocationDialogFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SelectLocationDialogFragment a(final FragmentManager manager) {
            Intrinsics.e(manager, "manager");
            final SelectLocationDialogFragment selectLocationDialogFragment = new SelectLocationDialogFragment(false, 1, null);
            PermissionUtils.c(new PermissionCallbacks() { // from class: com.blued.community.ui.send.dialog.SelectLocationDialogFragment$Companion$show$1
                @Override // com.blued.android.framework.permission.PermissionCallbacks
                public void U_() {
                    SelectLocationDialogFragment.this.show(manager, SelectLocationDialogFragment.class.getSimpleName());
                }

                @Override // com.blued.android.framework.permission.PermissionCallbacks
                public void a(String[] perms) {
                    Intrinsics.e(perms, "perms");
                }
            });
            return selectLocationDialogFragment;
        }

        public final SelectLocationDialogFragment a(final FragmentManager manager, boolean z) {
            Intrinsics.e(manager, "manager");
            final SelectLocationDialogFragment selectLocationDialogFragment = new SelectLocationDialogFragment(z);
            PermissionUtils.c(new PermissionCallbacks() { // from class: com.blued.community.ui.send.dialog.SelectLocationDialogFragment$Companion$show$2
                @Override // com.blued.android.framework.permission.PermissionCallbacks
                public void U_() {
                    SelectLocationDialogFragment.this.show(manager, SelectLocationDialogFragment.class.getSimpleName());
                }

                @Override // com.blued.android.framework.permission.PermissionCallbacks
                public void a(String[] perms) {
                    Intrinsics.e(perms, "perms");
                }
            });
            return selectLocationDialogFragment;
        }
    }

    public SelectLocationDialogFragment() {
        this(false, 1, null);
    }

    public SelectLocationDialogFragment(boolean z) {
        this.b = z;
    }

    public /* synthetic */ SelectLocationDialogFragment(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(SelectLocationDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(SelectLocationDialogFragment this$0, View view, boolean z) {
        Intrinsics.e(this$0, "this$0");
        this$0.a(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(SelectLocationDialogFragment this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.e(this$0, "this$0");
        ItemFeedPostLocationBinding itemFeedPostLocationBinding = this$0.e;
        ItemFeedPostLocationBinding itemFeedPostLocationBinding2 = itemFeedPostLocationBinding;
        if (itemFeedPostLocationBinding == null) {
            Intrinsics.c("headerViewBinding");
            itemFeedPostLocationBinding2 = null;
        }
        itemFeedPostLocationBinding2.c.setTextColor(this$0.requireContext().getResources().getColor(R.color.nafio_h));
        ItemFeedPostLocationBinding itemFeedPostLocationBinding3 = this$0.e;
        ItemFeedPostLocationBinding itemFeedPostLocationBinding4 = itemFeedPostLocationBinding3;
        if (itemFeedPostLocationBinding3 == null) {
            Intrinsics.c("headerViewBinding");
            itemFeedPostLocationBinding4 = null;
        }
        itemFeedPostLocationBinding4.a.setVisibility(8);
        SelectLocationAdapter selectLocationAdapter = this$0.h;
        SelectLocationAdapter selectLocationAdapter2 = selectLocationAdapter;
        if (selectLocationAdapter == null) {
            Intrinsics.c("locationAdapter");
            selectLocationAdapter2 = null;
        }
        for (PositionPOIModel positionPOIModel : selectLocationAdapter2.getData()) {
            positionPOIModel.mark_visible = false;
        }
        SelectLocationAdapter selectLocationAdapter3 = this$0.h;
        SelectLocationAdapter selectLocationAdapter4 = selectLocationAdapter3;
        if (selectLocationAdapter3 == null) {
            Intrinsics.c("locationAdapter");
            selectLocationAdapter4 = null;
        }
        ((PositionPOIModel) selectLocationAdapter4.getData().get(i)).mark_visible = true;
        SelectLocationAdapter selectLocationAdapter5 = this$0.h;
        SelectLocationAdapter selectLocationAdapter6 = selectLocationAdapter5;
        if (selectLocationAdapter5 == null) {
            Intrinsics.c("locationAdapter");
            selectLocationAdapter6 = null;
        }
        selectLocationAdapter6.notifyDataSetChanged();
        SelectLocationViewModel selectLocationViewModel = this$0.i;
        SelectLocationViewModel selectLocationViewModel2 = selectLocationViewModel;
        if (selectLocationViewModel == null) {
            Intrinsics.c("mViewModel");
            selectLocationViewModel2 = null;
        }
        MutableLiveData<String> e = selectLocationViewModel2.e();
        SelectLocationAdapter selectLocationAdapter7 = this$0.h;
        SelectLocationAdapter selectLocationAdapter8 = selectLocationAdapter7;
        if (selectLocationAdapter7 == null) {
            Intrinsics.c("locationAdapter");
            selectLocationAdapter8 = null;
        }
        e.setValue(((PositionPOIModel) selectLocationAdapter8.getData().get(i)).city);
        SelectLocationViewModel selectLocationViewModel3 = this$0.i;
        SelectLocationViewModel selectLocationViewModel4 = selectLocationViewModel3;
        if (selectLocationViewModel3 == null) {
            Intrinsics.c("mViewModel");
            selectLocationViewModel4 = null;
        }
        MutableLiveData<String> f = selectLocationViewModel4.f();
        SelectLocationAdapter selectLocationAdapter9 = this$0.h;
        SelectLocationAdapter selectLocationAdapter10 = selectLocationAdapter9;
        if (selectLocationAdapter9 == null) {
            Intrinsics.c("locationAdapter");
            selectLocationAdapter10 = null;
        }
        f.setValue(((PositionPOIModel) selectLocationAdapter10.getData().get(i)).name);
        SelectLocationViewModel selectLocationViewModel5 = this$0.i;
        SelectLocationViewModel selectLocationViewModel6 = selectLocationViewModel5;
        if (selectLocationViewModel5 == null) {
            Intrinsics.c("mViewModel");
            selectLocationViewModel6 = null;
        }
        SelectLocationAdapter selectLocationAdapter11 = this$0.h;
        SelectLocationAdapter selectLocationAdapter12 = selectLocationAdapter11;
        if (selectLocationAdapter11 == null) {
            Intrinsics.c("locationAdapter");
            selectLocationAdapter12 = null;
        }
        selectLocationViewModel6.a(((PositionPOIModel) selectLocationAdapter12.getData().get(i)).address);
        SelectLocationViewModel selectLocationViewModel7 = this$0.i;
        SelectLocationViewModel selectLocationViewModel8 = selectLocationViewModel7;
        if (selectLocationViewModel7 == null) {
            Intrinsics.c("mViewModel");
            selectLocationViewModel8 = null;
        }
        SelectLocationAdapter selectLocationAdapter13 = this$0.h;
        SelectLocationAdapter selectLocationAdapter14 = selectLocationAdapter13;
        if (selectLocationAdapter13 == null) {
            Intrinsics.c("locationAdapter");
            selectLocationAdapter14 = null;
        }
        selectLocationViewModel8.c(((PositionPOIModel) selectLocationAdapter14.getData().get(i)).latitude.toString());
        SelectLocationViewModel selectLocationViewModel9 = this$0.i;
        SelectLocationViewModel selectLocationViewModel10 = selectLocationViewModel9;
        if (selectLocationViewModel9 == null) {
            Intrinsics.c("mViewModel");
            selectLocationViewModel10 = null;
        }
        SelectLocationAdapter selectLocationAdapter15 = this$0.h;
        if (selectLocationAdapter15 == null) {
            Intrinsics.c("locationAdapter");
            selectLocationAdapter15 = null;
        }
        selectLocationViewModel10.b(((PositionPOIModel) selectLocationAdapter15.getData().get(i)).longitude.toString());
        this$0.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a(SelectLocationDialogFragment this$0, View view, MotionEvent motionEvent) {
        Intrinsics.e(this$0, "this$0");
        Context context = this$0.getContext();
        DialogSelectLocationBinding dialogSelectLocationBinding = this$0.c;
        DialogSelectLocationBinding dialogSelectLocationBinding2 = dialogSelectLocationBinding;
        if (dialogSelectLocationBinding == null) {
            Intrinsics.c("viewBinding");
            dialogSelectLocationBinding2 = null;
        }
        KeyboardUtils.b(context, (View) dialogSelectLocationBinding2.e.getEditView());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(SelectLocationDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.o();
        this$0.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(SelectLocationDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        SelectLocationViewModel selectLocationViewModel = this$0.i;
        SelectLocationViewModel selectLocationViewModel2 = selectLocationViewModel;
        if (selectLocationViewModel == null) {
            Intrinsics.c("mViewModel");
            selectLocationViewModel2 = null;
        }
        if (selectLocationViewModel2.r()) {
            ItemFeedPostLocationLargerAreaBinding itemFeedPostLocationLargerAreaBinding = this$0.f;
            ItemFeedPostLocationLargerAreaBinding itemFeedPostLocationLargerAreaBinding2 = itemFeedPostLocationLargerAreaBinding;
            if (itemFeedPostLocationLargerAreaBinding == null) {
                Intrinsics.c("footerViewBinding");
                itemFeedPostLocationLargerAreaBinding2 = null;
            }
            itemFeedPostLocationLargerAreaBinding2.getRoot().setVisibility(8);
        }
        SelectLocationViewModel selectLocationViewModel3 = this$0.i;
        if (selectLocationViewModel3 == null) {
            Intrinsics.c("mViewModel");
            selectLocationViewModel3 = null;
        }
        selectLocationViewModel3.a((LifecycleOwner) this$0, true, this$0.j());
        DialogUtils.a(this$0.g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(SelectLocationDialogFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        SelectLocationViewModel selectLocationViewModel = this$0.i;
        SelectLocationViewModel selectLocationViewModel2 = selectLocationViewModel;
        if (selectLocationViewModel == null) {
            Intrinsics.c("mViewModel");
            selectLocationViewModel2 = null;
        }
        selectLocationViewModel2.a((LifecycleOwner) this$0, false, this$0.j());
    }

    private final String j() {
        DialogSelectLocationBinding dialogSelectLocationBinding = this.c;
        DialogSelectLocationBinding dialogSelectLocationBinding2 = dialogSelectLocationBinding;
        if (dialogSelectLocationBinding == null) {
            Intrinsics.c("viewBinding");
            dialogSelectLocationBinding2 = null;
        }
        return String.valueOf(dialogSelectLocationBinding2.e.getEditView().getText());
    }

    private final void k() {
        SelectLocationAdapter selectLocationAdapter = new SelectLocationAdapter(getContext());
        this.h = selectLocationAdapter;
        SelectLocationAdapter selectLocationAdapter2 = selectLocationAdapter;
        if (selectLocationAdapter == null) {
            Intrinsics.c("locationAdapter");
            selectLocationAdapter2 = null;
        }
        selectLocationAdapter2.setLoadMoreView(new BluedAdapterLoadMoreView());
        SelectLocationAdapter selectLocationAdapter3 = this.h;
        SelectLocationAdapter selectLocationAdapter4 = selectLocationAdapter3;
        if (selectLocationAdapter3 == null) {
            Intrinsics.c("locationAdapter");
            selectLocationAdapter4 = null;
        }
        SelectLocationViewModel selectLocationViewModel = this.i;
        SelectLocationViewModel selectLocationViewModel2 = selectLocationViewModel;
        if (selectLocationViewModel == null) {
            Intrinsics.c("mViewModel");
            selectLocationViewModel2 = null;
        }
        selectLocationAdapter4.setNewData((List) selectLocationViewModel2.o().getValue());
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        SelectLocationViewModel selectLocationViewModel3 = this.i;
        SelectLocationViewModel selectLocationViewModel4 = selectLocationViewModel3;
        if (selectLocationViewModel3 == null) {
            Intrinsics.c("mViewModel");
            selectLocationViewModel4 = null;
        }
        LifecycleExtKt.a(lifecycleOwner, selectLocationViewModel4.n(), new Function1<Boolean, Unit>() { // from class: com.blued.community.ui.send.dialog.SelectLocationDialogFragment$initData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void a(Boolean it) {
                ItemFeedPostLocationLargerAreaBinding itemFeedPostLocationLargerAreaBinding;
                ItemFeedPostLocationLargerAreaBinding itemFeedPostLocationLargerAreaBinding2;
                SelectLocationViewModel selectLocationViewModel5;
                itemFeedPostLocationLargerAreaBinding = SelectLocationDialogFragment.this.f;
                ItemFeedPostLocationLargerAreaBinding itemFeedPostLocationLargerAreaBinding3 = itemFeedPostLocationLargerAreaBinding;
                if (itemFeedPostLocationLargerAreaBinding == null) {
                    Intrinsics.c("footerViewBinding");
                    itemFeedPostLocationLargerAreaBinding3 = null;
                }
                TextView textView = itemFeedPostLocationLargerAreaBinding3.a;
                Intrinsics.c(it, "it");
                textView.setVisibility(it.booleanValue() ? 0 : 8);
                itemFeedPostLocationLargerAreaBinding2 = SelectLocationDialogFragment.this.f;
                ItemFeedPostLocationLargerAreaBinding itemFeedPostLocationLargerAreaBinding4 = itemFeedPostLocationLargerAreaBinding2;
                if (itemFeedPostLocationLargerAreaBinding2 == null) {
                    Intrinsics.c("footerViewBinding");
                    itemFeedPostLocationLargerAreaBinding4 = null;
                }
                TextView textView2 = itemFeedPostLocationLargerAreaBinding4.a;
                selectLocationViewModel5 = SelectLocationDialogFragment.this.i;
                SelectLocationViewModel selectLocationViewModel6 = selectLocationViewModel5;
                if (selectLocationViewModel6 == null) {
                    Intrinsics.c("mViewModel");
                    selectLocationViewModel6 = null;
                }
                textView2.setText(selectLocationViewModel6.s());
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Unit invoke(Boolean bool) {
                a(bool);
                return Unit.a;
            }
        });
        SelectLocationViewModel selectLocationViewModel5 = this.i;
        SelectLocationViewModel selectLocationViewModel6 = selectLocationViewModel5;
        if (selectLocationViewModel5 == null) {
            Intrinsics.c("mViewModel");
            selectLocationViewModel6 = null;
        }
        LifecycleExtKt.a(lifecycleOwner, selectLocationViewModel6.o(), new Function1<List<PositionPOIModel>, Unit>() { // from class: com.blued.community.ui.send.dialog.SelectLocationDialogFragment$initData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void a(List<PositionPOIModel> list) {
                Dialog dialog;
                SelectLocationAdapter selectLocationAdapter5;
                dialog = SelectLocationDialogFragment.this.g;
                DialogUtils.b(dialog);
                selectLocationAdapter5 = SelectLocationDialogFragment.this.h;
                SelectLocationAdapter selectLocationAdapter6 = selectLocationAdapter5;
                if (selectLocationAdapter5 == null) {
                    Intrinsics.c("locationAdapter");
                    selectLocationAdapter6 = null;
                }
                selectLocationAdapter6.setNewData(list);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Unit invoke(List<PositionPOIModel> list) {
                a(list);
                return Unit.a;
            }
        });
        SelectLocationViewModel selectLocationViewModel7 = this.i;
        if (selectLocationViewModel7 == null) {
            Intrinsics.c("mViewModel");
            selectLocationViewModel7 = null;
        }
        LifecycleExtKt.a(lifecycleOwner, selectLocationViewModel7.p(), new Function1<Boolean, Unit>() { // from class: com.blued.community.ui.send.dialog.SelectLocationDialogFragment$initData$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void a(Boolean it) {
                SelectLocationAdapter selectLocationAdapter5;
                SelectLocationAdapter selectLocationAdapter6;
                Intrinsics.c(it, "it");
                if (it.booleanValue()) {
                    selectLocationAdapter6 = SelectLocationDialogFragment.this.h;
                    SelectLocationAdapter selectLocationAdapter7 = selectLocationAdapter6;
                    if (selectLocationAdapter7 == null) {
                        Intrinsics.c("locationAdapter");
                        selectLocationAdapter7 = null;
                    }
                    selectLocationAdapter7.loadMoreComplete();
                } else if (it.booleanValue()) {
                } else {
                    selectLocationAdapter5 = SelectLocationDialogFragment.this.h;
                    SelectLocationAdapter selectLocationAdapter8 = selectLocationAdapter5;
                    if (selectLocationAdapter8 == null) {
                        Intrinsics.c("locationAdapter");
                        selectLocationAdapter8 = null;
                    }
                    selectLocationAdapter8.loadMoreEnd();
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Unit invoke(Boolean bool) {
                a(bool);
                return Unit.a;
            }
        });
    }

    private final void l() {
        DialogSelectLocationBinding dialogSelectLocationBinding = this.c;
        DialogSelectLocationBinding dialogSelectLocationBinding2 = dialogSelectLocationBinding;
        if (dialogSelectLocationBinding == null) {
            Intrinsics.c("viewBinding");
            dialogSelectLocationBinding2 = null;
        }
        ViewGroup.LayoutParams layoutParams = dialogSelectLocationBinding2.d.getLayoutParams();
        SelectLocationViewModel selectLocationViewModel = this.i;
        SelectLocationViewModel selectLocationViewModel2 = selectLocationViewModel;
        if (selectLocationViewModel == null) {
            Intrinsics.c("mViewModel");
            selectLocationViewModel2 = null;
        }
        layoutParams.height = selectLocationViewModel2.d();
        this.g = DialogUtils.a(getContext());
        DialogSelectLocationBinding dialogSelectLocationBinding3 = this.c;
        DialogSelectLocationBinding dialogSelectLocationBinding4 = dialogSelectLocationBinding3;
        if (dialogSelectLocationBinding3 == null) {
            Intrinsics.c("viewBinding");
            dialogSelectLocationBinding4 = null;
        }
        dialogSelectLocationBinding4.a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.send.dialog.-$$Lambda$SelectLocationDialogFragment$FT990-fjGYEdk8Bj_DknPbsT_cI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectLocationDialogFragment.a(SelectLocationDialogFragment.this, view);
            }
        });
        DialogSelectLocationBinding dialogSelectLocationBinding5 = this.c;
        DialogSelectLocationBinding dialogSelectLocationBinding6 = dialogSelectLocationBinding5;
        if (dialogSelectLocationBinding5 == null) {
            Intrinsics.c("viewBinding");
            dialogSelectLocationBinding6 = null;
        }
        dialogSelectLocationBinding6.e.getEditView().setHint(R.string.position_search);
        DialogSelectLocationBinding dialogSelectLocationBinding7 = this.c;
        DialogSelectLocationBinding dialogSelectLocationBinding8 = dialogSelectLocationBinding7;
        if (dialogSelectLocationBinding7 == null) {
            Intrinsics.c("viewBinding");
            dialogSelectLocationBinding8 = null;
        }
        SearchEditText editView = dialogSelectLocationBinding8.e.getEditView();
        SelectLocationViewModel selectLocationViewModel3 = this.i;
        SelectLocationViewModel selectLocationViewModel4 = selectLocationViewModel3;
        if (selectLocationViewModel3 == null) {
            Intrinsics.c("mViewModel");
            selectLocationViewModel4 = null;
        }
        editView.setText(selectLocationViewModel4.l());
        DialogSelectLocationBinding dialogSelectLocationBinding9 = this.c;
        DialogSelectLocationBinding dialogSelectLocationBinding10 = dialogSelectLocationBinding9;
        if (dialogSelectLocationBinding9 == null) {
            Intrinsics.c("viewBinding");
            dialogSelectLocationBinding10 = null;
        }
        dialogSelectLocationBinding10.e.getEditView().a();
        DialogSelectLocationBinding dialogSelectLocationBinding11 = this.c;
        DialogSelectLocationBinding dialogSelectLocationBinding12 = dialogSelectLocationBinding11;
        if (dialogSelectLocationBinding11 == null) {
            Intrinsics.c("viewBinding");
            dialogSelectLocationBinding12 = null;
        }
        dialogSelectLocationBinding12.e.getEditView().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.blued.community.ui.send.dialog.-$$Lambda$SelectLocationDialogFragment$krnIHgmpQriR7kP3mTaqxxvDsm8
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                SelectLocationDialogFragment.a(SelectLocationDialogFragment.this, view, z);
            }
        });
        DialogSelectLocationBinding dialogSelectLocationBinding13 = this.c;
        DialogSelectLocationBinding dialogSelectLocationBinding14 = dialogSelectLocationBinding13;
        if (dialogSelectLocationBinding13 == null) {
            Intrinsics.c("viewBinding");
            dialogSelectLocationBinding14 = null;
        }
        dialogSelectLocationBinding14.e.setOnSearchInfoListener(new SearchView.OnSearchInfoListener() { // from class: com.blued.community.ui.send.dialog.SelectLocationDialogFragment$initView$3
            @Override // com.blued.android.module.common.view.SearchView.OnSearchInfoListener
            public void a() {
                SelectLocationDialogFragment.this.i();
            }

            @Override // com.blued.android.module.common.view.SearchView.OnSearchInfoListener
            public void a(String msg) {
                SelectLocationViewModel selectLocationViewModel5;
                SelectLocationViewModel selectLocationViewModel6;
                Intrinsics.e(msg, "msg");
                selectLocationViewModel5 = SelectLocationDialogFragment.this.i;
                SelectLocationViewModel selectLocationViewModel7 = selectLocationViewModel5;
                if (selectLocationViewModel5 == null) {
                    Intrinsics.c("mViewModel");
                    selectLocationViewModel7 = null;
                }
                selectLocationViewModel7.q();
                selectLocationViewModel6 = SelectLocationDialogFragment.this.i;
                SelectLocationViewModel selectLocationViewModel8 = selectLocationViewModel6;
                if (selectLocationViewModel8 == null) {
                    Intrinsics.c("mViewModel");
                    selectLocationViewModel8 = null;
                }
                selectLocationViewModel8.a((LifecycleOwner) SelectLocationDialogFragment.this, true, msg);
            }

            @Override // com.blued.android.module.common.view.SearchView.OnSearchInfoListener
            public void b() {
            }
        });
        SelectLocationAdapter selectLocationAdapter = this.h;
        SelectLocationAdapter selectLocationAdapter2 = selectLocationAdapter;
        if (selectLocationAdapter == null) {
            Intrinsics.c("locationAdapter");
            selectLocationAdapter2 = null;
        }
        BaseQuickAdapter.RequestLoadMoreListener requestLoadMoreListener = new BaseQuickAdapter.RequestLoadMoreListener() { // from class: com.blued.community.ui.send.dialog.-$$Lambda$SelectLocationDialogFragment$gwe2Xw4tbyBO7-kl8z2-RVfetss
            public final void onLoadMoreRequested() {
                SelectLocationDialogFragment.e(SelectLocationDialogFragment.this);
            }
        };
        DialogSelectLocationBinding dialogSelectLocationBinding15 = this.c;
        DialogSelectLocationBinding dialogSelectLocationBinding16 = dialogSelectLocationBinding15;
        if (dialogSelectLocationBinding15 == null) {
            Intrinsics.c("viewBinding");
            dialogSelectLocationBinding16 = null;
        }
        selectLocationAdapter2.setOnLoadMoreListener(requestLoadMoreListener, dialogSelectLocationBinding16.c);
        DialogSelectLocationBinding dialogSelectLocationBinding17 = this.c;
        DialogSelectLocationBinding dialogSelectLocationBinding18 = dialogSelectLocationBinding17;
        if (dialogSelectLocationBinding17 == null) {
            Intrinsics.c("viewBinding");
            dialogSelectLocationBinding18 = null;
        }
        dialogSelectLocationBinding18.c.setOnTouchListener(new View.OnTouchListener() { // from class: com.blued.community.ui.send.dialog.-$$Lambda$SelectLocationDialogFragment$dhjiThHF_k_7D-w_aSrJ07cmj14
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean a2;
                a2 = SelectLocationDialogFragment.a(SelectLocationDialogFragment.this, view, motionEvent);
                return a2;
            }
        });
        ItemFeedPostLocationBinding a2 = ItemFeedPostLocationBinding.a(LayoutInflater.from(getContext()));
        Intrinsics.c(a2, "inflate(LayoutInflater.from(context))");
        this.e = a2;
        ItemFeedPostLocationBinding itemFeedPostLocationBinding = a2;
        if (a2 == null) {
            Intrinsics.c("headerViewBinding");
            itemFeedPostLocationBinding = null;
        }
        itemFeedPostLocationBinding.c.setText(requireContext().getString(R.string.position_not_show));
        ItemFeedPostLocationBinding itemFeedPostLocationBinding2 = this.e;
        ItemFeedPostLocationBinding itemFeedPostLocationBinding3 = itemFeedPostLocationBinding2;
        if (itemFeedPostLocationBinding2 == null) {
            Intrinsics.c("headerViewBinding");
            itemFeedPostLocationBinding3 = null;
        }
        itemFeedPostLocationBinding3.b.setVisibility(8);
        ItemFeedPostLocationBinding itemFeedPostLocationBinding4 = this.e;
        ItemFeedPostLocationBinding itemFeedPostLocationBinding5 = itemFeedPostLocationBinding4;
        if (itemFeedPostLocationBinding4 == null) {
            Intrinsics.c("headerViewBinding");
            itemFeedPostLocationBinding5 = null;
        }
        itemFeedPostLocationBinding5.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.send.dialog.-$$Lambda$SelectLocationDialogFragment$S5mh5PK50maHMvDAvEGOPMkPBFM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectLocationDialogFragment.b(SelectLocationDialogFragment.this, view);
            }
        });
        if (!this.b) {
            SelectLocationAdapter selectLocationAdapter3 = this.h;
            SelectLocationAdapter selectLocationAdapter4 = selectLocationAdapter3;
            if (selectLocationAdapter3 == null) {
                Intrinsics.c("locationAdapter");
                selectLocationAdapter4 = null;
            }
            ItemFeedPostLocationBinding itemFeedPostLocationBinding6 = this.e;
            ItemFeedPostLocationBinding itemFeedPostLocationBinding7 = itemFeedPostLocationBinding6;
            if (itemFeedPostLocationBinding6 == null) {
                Intrinsics.c("headerViewBinding");
                itemFeedPostLocationBinding7 = null;
            }
            selectLocationAdapter4.addHeaderView(itemFeedPostLocationBinding7.getRoot());
        }
        SelectLocationAdapter selectLocationAdapter5 = this.h;
        SelectLocationAdapter selectLocationAdapter6 = selectLocationAdapter5;
        if (selectLocationAdapter5 == null) {
            Intrinsics.c("locationAdapter");
            selectLocationAdapter6 = null;
        }
        if (!selectLocationAdapter6.a()) {
            SelectLocationViewModel selectLocationViewModel5 = this.i;
            SelectLocationViewModel selectLocationViewModel6 = selectLocationViewModel5;
            if (selectLocationViewModel5 == null) {
                Intrinsics.c("mViewModel");
                selectLocationViewModel6 = null;
            }
            if (!TextUtils.isEmpty((CharSequence) selectLocationViewModel6.f().getValue())) {
                SelectLocationViewModel selectLocationViewModel7 = this.i;
                SelectLocationViewModel selectLocationViewModel8 = selectLocationViewModel7;
                if (selectLocationViewModel7 == null) {
                    Intrinsics.c("mViewModel");
                    selectLocationViewModel8 = null;
                }
                if (!TextUtils.isEmpty(selectLocationViewModel8.i())) {
                    SelectLocationViewModel selectLocationViewModel9 = this.i;
                    SelectLocationViewModel selectLocationViewModel10 = selectLocationViewModel9;
                    if (selectLocationViewModel9 == null) {
                        Intrinsics.c("mViewModel");
                        selectLocationViewModel10 = null;
                    }
                    if (!TextUtils.isEmpty(selectLocationViewModel10.h())) {
                        ItemFeedPostLocationBinding a3 = ItemFeedPostLocationBinding.a(LayoutInflater.from(getContext()));
                        Intrinsics.c(a3, "inflate(LayoutInflater.from(context))");
                        this.d = a3;
                        ItemFeedPostLocationBinding itemFeedPostLocationBinding8 = a3;
                        if (a3 == null) {
                            Intrinsics.c("selectHeaderViewBinding");
                            itemFeedPostLocationBinding8 = null;
                        }
                        TextView textView = itemFeedPostLocationBinding8.c;
                        SelectLocationViewModel selectLocationViewModel11 = this.i;
                        SelectLocationViewModel selectLocationViewModel12 = selectLocationViewModel11;
                        if (selectLocationViewModel11 == null) {
                            Intrinsics.c("mViewModel");
                            selectLocationViewModel12 = null;
                        }
                        textView.setText((CharSequence) selectLocationViewModel12.f().getValue());
                        ItemFeedPostLocationBinding itemFeedPostLocationBinding9 = this.d;
                        ItemFeedPostLocationBinding itemFeedPostLocationBinding10 = itemFeedPostLocationBinding9;
                        if (itemFeedPostLocationBinding9 == null) {
                            Intrinsics.c("selectHeaderViewBinding");
                            itemFeedPostLocationBinding10 = null;
                        }
                        itemFeedPostLocationBinding10.b.setVisibility(8);
                        ItemFeedPostLocationBinding itemFeedPostLocationBinding11 = this.d;
                        ItemFeedPostLocationBinding itemFeedPostLocationBinding12 = itemFeedPostLocationBinding11;
                        if (itemFeedPostLocationBinding11 == null) {
                            Intrinsics.c("selectHeaderViewBinding");
                            itemFeedPostLocationBinding12 = null;
                        }
                        itemFeedPostLocationBinding12.c.setTextColor(BluedSkinUtils.a(getContext(), R.color.syc_a));
                        ItemFeedPostLocationBinding itemFeedPostLocationBinding13 = this.d;
                        ItemFeedPostLocationBinding itemFeedPostLocationBinding14 = itemFeedPostLocationBinding13;
                        if (itemFeedPostLocationBinding13 == null) {
                            Intrinsics.c("selectHeaderViewBinding");
                            itemFeedPostLocationBinding14 = null;
                        }
                        itemFeedPostLocationBinding14.a.setVisibility(0);
                        SelectLocationAdapter selectLocationAdapter7 = this.h;
                        SelectLocationAdapter selectLocationAdapter8 = selectLocationAdapter7;
                        if (selectLocationAdapter7 == null) {
                            Intrinsics.c("locationAdapter");
                            selectLocationAdapter8 = null;
                        }
                        ItemFeedPostLocationBinding itemFeedPostLocationBinding15 = this.d;
                        ItemFeedPostLocationBinding itemFeedPostLocationBinding16 = itemFeedPostLocationBinding15;
                        if (itemFeedPostLocationBinding15 == null) {
                            Intrinsics.c("selectHeaderViewBinding");
                            itemFeedPostLocationBinding16 = null;
                        }
                        selectLocationAdapter8.addHeaderView(itemFeedPostLocationBinding16.getRoot());
                    }
                }
            }
            ItemFeedPostLocationBinding itemFeedPostLocationBinding17 = this.e;
            ItemFeedPostLocationBinding itemFeedPostLocationBinding18 = itemFeedPostLocationBinding17;
            if (itemFeedPostLocationBinding17 == null) {
                Intrinsics.c("headerViewBinding");
                itemFeedPostLocationBinding18 = null;
            }
            itemFeedPostLocationBinding18.c.setTextColor(BluedSkinUtils.a(getContext(), R.color.syc_a));
            ItemFeedPostLocationBinding itemFeedPostLocationBinding19 = this.e;
            ItemFeedPostLocationBinding itemFeedPostLocationBinding20 = itemFeedPostLocationBinding19;
            if (itemFeedPostLocationBinding19 == null) {
                Intrinsics.c("headerViewBinding");
                itemFeedPostLocationBinding20 = null;
            }
            itemFeedPostLocationBinding20.a.setVisibility(0);
        }
        ItemFeedPostLocationLargerAreaBinding a4 = ItemFeedPostLocationLargerAreaBinding.a(LayoutInflater.from(getContext()));
        Intrinsics.c(a4, "inflate(LayoutInflater.from(context))");
        this.f = a4;
        ItemFeedPostLocationLargerAreaBinding itemFeedPostLocationLargerAreaBinding = a4;
        if (a4 == null) {
            Intrinsics.c("footerViewBinding");
            itemFeedPostLocationLargerAreaBinding = null;
        }
        itemFeedPostLocationLargerAreaBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.send.dialog.-$$Lambda$SelectLocationDialogFragment$UZvDBrAHtFyuIc9M162HOznCTiY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectLocationDialogFragment.c(SelectLocationDialogFragment.this, view);
            }
        });
        SelectLocationAdapter selectLocationAdapter9 = this.h;
        SelectLocationAdapter selectLocationAdapter10 = selectLocationAdapter9;
        if (selectLocationAdapter9 == null) {
            Intrinsics.c("locationAdapter");
            selectLocationAdapter10 = null;
        }
        ItemFeedPostLocationLargerAreaBinding itemFeedPostLocationLargerAreaBinding2 = this.f;
        ItemFeedPostLocationLargerAreaBinding itemFeedPostLocationLargerAreaBinding3 = itemFeedPostLocationLargerAreaBinding2;
        if (itemFeedPostLocationLargerAreaBinding2 == null) {
            Intrinsics.c("footerViewBinding");
            itemFeedPostLocationLargerAreaBinding3 = null;
        }
        selectLocationAdapter10.addFooterView(itemFeedPostLocationLargerAreaBinding3.getRoot());
        DialogSelectLocationBinding dialogSelectLocationBinding19 = this.c;
        DialogSelectLocationBinding dialogSelectLocationBinding20 = dialogSelectLocationBinding19;
        if (dialogSelectLocationBinding19 == null) {
            Intrinsics.c("viewBinding");
            dialogSelectLocationBinding20 = null;
        }
        dialogSelectLocationBinding20.c.setLayoutManager(new LinearLayoutManager(getContext()));
        DialogSelectLocationBinding dialogSelectLocationBinding21 = this.c;
        DialogSelectLocationBinding dialogSelectLocationBinding22 = dialogSelectLocationBinding21;
        if (dialogSelectLocationBinding21 == null) {
            Intrinsics.c("viewBinding");
            dialogSelectLocationBinding22 = null;
        }
        RecyclerView recyclerView = dialogSelectLocationBinding22.c;
        RecyclerView.Adapter adapter = this.h;
        SelectLocationAdapter selectLocationAdapter11 = adapter;
        if (adapter == null) {
            Intrinsics.c("locationAdapter");
            selectLocationAdapter11 = null;
        }
        recyclerView.setAdapter(selectLocationAdapter11);
        n();
        SelectLocationAdapter selectLocationAdapter12 = this.h;
        if (selectLocationAdapter12 == null) {
            Intrinsics.c("locationAdapter");
            selectLocationAdapter12 = null;
        }
        selectLocationAdapter12.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.blued.community.ui.send.dialog.-$$Lambda$SelectLocationDialogFragment$rNEC4Ntz2bL62HqO4TKrgQmmfgQ
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                SelectLocationDialogFragment.a(SelectLocationDialogFragment.this, baseQuickAdapter, view, i);
            }
        });
    }

    private final void m() {
        DialogSelectLocationBinding dialogSelectLocationBinding = this.c;
        DialogSelectLocationBinding dialogSelectLocationBinding2 = dialogSelectLocationBinding;
        if (dialogSelectLocationBinding == null) {
            Intrinsics.c("viewBinding");
            dialogSelectLocationBinding2 = null;
        }
        int[] a2 = ViewUtils.a(dialogSelectLocationBinding2.c);
        SelectLocationViewModel selectLocationViewModel = this.i;
        SelectLocationViewModel selectLocationViewModel2 = selectLocationViewModel;
        if (selectLocationViewModel == null) {
            Intrinsics.c("mViewModel");
            selectLocationViewModel2 = null;
        }
        selectLocationViewModel2.c(a2[0]);
        SelectLocationViewModel selectLocationViewModel3 = this.i;
        if (selectLocationViewModel3 == null) {
            Intrinsics.c("mViewModel");
            selectLocationViewModel3 = null;
        }
        selectLocationViewModel3.b(a2[1]);
    }

    private final void n() {
        DialogSelectLocationBinding dialogSelectLocationBinding = this.c;
        DialogSelectLocationBinding dialogSelectLocationBinding2 = dialogSelectLocationBinding;
        if (dialogSelectLocationBinding == null) {
            Intrinsics.c("viewBinding");
            dialogSelectLocationBinding2 = null;
        }
        RecyclerView recyclerView = dialogSelectLocationBinding2.c;
        SelectLocationViewModel selectLocationViewModel = this.i;
        SelectLocationViewModel selectLocationViewModel2 = selectLocationViewModel;
        if (selectLocationViewModel == null) {
            Intrinsics.c("mViewModel");
            selectLocationViewModel2 = null;
        }
        int k = selectLocationViewModel2.k();
        SelectLocationViewModel selectLocationViewModel3 = this.i;
        if (selectLocationViewModel3 == null) {
            Intrinsics.c("mViewModel");
            selectLocationViewModel3 = null;
        }
        ViewUtils.a(recyclerView, k, selectLocationViewModel3.j());
    }

    private final void o() {
        SelectLocationAdapter selectLocationAdapter = this.h;
        SelectLocationAdapter selectLocationAdapter2 = selectLocationAdapter;
        if (selectLocationAdapter == null) {
            Intrinsics.c("locationAdapter");
            selectLocationAdapter2 = null;
        }
        for (PositionPOIModel positionPOIModel : selectLocationAdapter2.getData()) {
            positionPOIModel.mark_visible = false;
        }
        SelectLocationAdapter selectLocationAdapter3 = this.h;
        SelectLocationAdapter selectLocationAdapter4 = selectLocationAdapter3;
        if (selectLocationAdapter3 == null) {
            Intrinsics.c("locationAdapter");
            selectLocationAdapter4 = null;
        }
        selectLocationAdapter4.notifyDataSetChanged();
        ItemFeedPostLocationBinding itemFeedPostLocationBinding = this.e;
        ItemFeedPostLocationBinding itemFeedPostLocationBinding2 = itemFeedPostLocationBinding;
        if (itemFeedPostLocationBinding == null) {
            Intrinsics.c("headerViewBinding");
            itemFeedPostLocationBinding2 = null;
        }
        itemFeedPostLocationBinding2.c.setTextColor(requireContext().getResources().getColor(R.color.syc_a));
        ItemFeedPostLocationBinding itemFeedPostLocationBinding3 = this.e;
        ItemFeedPostLocationBinding itemFeedPostLocationBinding4 = itemFeedPostLocationBinding3;
        if (itemFeedPostLocationBinding3 == null) {
            Intrinsics.c("headerViewBinding");
            itemFeedPostLocationBinding4 = null;
        }
        itemFeedPostLocationBinding4.a.setVisibility(0);
        SelectLocationViewModel selectLocationViewModel = this.i;
        SelectLocationViewModel selectLocationViewModel2 = selectLocationViewModel;
        if (selectLocationViewModel == null) {
            Intrinsics.c("mViewModel");
            selectLocationViewModel2 = null;
        }
        selectLocationViewModel2.f().setValue("");
        SelectLocationViewModel selectLocationViewModel3 = this.i;
        SelectLocationViewModel selectLocationViewModel4 = selectLocationViewModel3;
        if (selectLocationViewModel3 == null) {
            Intrinsics.c("mViewModel");
            selectLocationViewModel4 = null;
        }
        selectLocationViewModel4.c((String) null);
        SelectLocationViewModel selectLocationViewModel5 = this.i;
        SelectLocationViewModel selectLocationViewModel6 = selectLocationViewModel5;
        if (selectLocationViewModel5 == null) {
            Intrinsics.c("mViewModel");
            selectLocationViewModel6 = null;
        }
        selectLocationViewModel6.b((String) null);
    }

    public final void a(boolean z) {
        DialogSelectLocationBinding dialogSelectLocationBinding = this.c;
        DialogSelectLocationBinding dialogSelectLocationBinding2 = dialogSelectLocationBinding;
        if (dialogSelectLocationBinding == null) {
            Intrinsics.c("viewBinding");
            dialogSelectLocationBinding2 = null;
        }
        if (dialogSelectLocationBinding2.e != null) {
            DialogSelectLocationBinding dialogSelectLocationBinding3 = this.c;
            DialogSelectLocationBinding dialogSelectLocationBinding4 = dialogSelectLocationBinding3;
            if (dialogSelectLocationBinding3 == null) {
                Intrinsics.c("viewBinding");
                dialogSelectLocationBinding4 = null;
            }
            dialogSelectLocationBinding4.e.a(z);
            DialogSelectLocationBinding dialogSelectLocationBinding5 = this.c;
            DialogSelectLocationBinding dialogSelectLocationBinding6 = dialogSelectLocationBinding5;
            if (dialogSelectLocationBinding5 == null) {
                Intrinsics.c("viewBinding");
                dialogSelectLocationBinding6 = null;
            }
            dialogSelectLocationBinding6.e.getEditView().setFocusable(true);
            DialogSelectLocationBinding dialogSelectLocationBinding7 = this.c;
            DialogSelectLocationBinding dialogSelectLocationBinding8 = dialogSelectLocationBinding7;
            if (dialogSelectLocationBinding7 == null) {
                Intrinsics.c("viewBinding");
                dialogSelectLocationBinding8 = null;
            }
            dialogSelectLocationBinding8.e.getEditView().setFocusableInTouchMode(true);
            DialogSelectLocationBinding dialogSelectLocationBinding9 = this.c;
            if (dialogSelectLocationBinding9 == null) {
                Intrinsics.c("viewBinding");
                dialogSelectLocationBinding9 = null;
            }
            dialogSelectLocationBinding9.e.getEditView().setCursorVisible(z);
        }
    }

    public final void h() {
        dismiss();
    }

    public final void i() {
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
        this.i = (SelectLocationViewModel) new ViewModelProvider(viewModelStore, companion.getInstance((Application) d)).get(SelectLocationViewModel.class);
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.e(dialog, "dialog");
        m();
        super.onDismiss(dialog);
    }

    @Override // com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialogFragment
    public void setupDialog(Dialog dialog, int i) {
        Intrinsics.e(dialog, "dialog");
        super.setupDialog(dialog, i);
        DialogSelectLocationBinding a2 = DialogSelectLocationBinding.a(LayoutInflater.from(getContext()));
        Intrinsics.c(a2, "inflate(LayoutInflater.from(context))");
        this.c = a2;
        DialogSelectLocationBinding dialogSelectLocationBinding = a2;
        if (a2 == null) {
            Intrinsics.c("viewBinding");
            dialogSelectLocationBinding = null;
        }
        dialog.setContentView(dialogSelectLocationBinding.getRoot());
        BottomSheetBehavior<FrameLayout> a3 = ((BottomSheetDialog) dialog).a();
        SelectLocationViewModel selectLocationViewModel = this.i;
        SelectLocationViewModel selectLocationViewModel2 = selectLocationViewModel;
        if (selectLocationViewModel == null) {
            Intrinsics.c("mViewModel");
            selectLocationViewModel2 = null;
        }
        a3.a(selectLocationViewModel2.d());
        k();
        l();
        SelectLocationAdapter selectLocationAdapter = this.h;
        SelectLocationAdapter selectLocationAdapter2 = selectLocationAdapter;
        if (selectLocationAdapter == null) {
            Intrinsics.c("locationAdapter");
            selectLocationAdapter2 = null;
        }
        if (selectLocationAdapter2.getData().size() <= 0) {
            SelectLocationViewModel selectLocationViewModel3 = this.i;
            SelectLocationViewModel selectLocationViewModel4 = selectLocationViewModel3;
            if (selectLocationViewModel3 == null) {
                Intrinsics.c("mViewModel");
                selectLocationViewModel4 = null;
            }
            selectLocationViewModel4.q();
            SelectLocationViewModel selectLocationViewModel5 = this.i;
            if (selectLocationViewModel5 == null) {
                Intrinsics.c("mViewModel");
                selectLocationViewModel5 = null;
            }
            selectLocationViewModel5.a((LifecycleOwner) this, true, j());
        }
    }
}
