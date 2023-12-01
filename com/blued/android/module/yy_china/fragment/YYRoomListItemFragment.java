package com.blued.android.module.yy_china.fragment;

import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.common.base.mvvm.LifecycleExtKt;
import com.blued.android.module.common.base.mvvm.MVVMBaseFragment;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.common.widget.refresh.BluedAdapterLoadMoreView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.adapter.YYRoomListsAdapter;
import com.blued.android.module.yy_china.databinding.FragmentYyRoomListItemBinding;
import com.blued.android.module.yy_china.listener.OnCLickRoomItemToGoRoomListener;
import com.blued.android.module.yy_china.model.YYChatRoomModel;
import com.blued.android.module.yy_china.model.YYLastRoomModel;
import com.blued.android.module.yy_china.model.YYRoomExtraModel;
import com.blued.android.module.yy_china.presenter.YYChatRoomsListItemViewModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYRoomListItemFragment.class */
public final class YYRoomListItemFragment extends MVVMBaseFragment<YYChatRoomsListItemViewModel> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f17437a = {Reflection.a(new PropertyReference1Impl(YYRoomListItemFragment.class, "vb", "getVb()Lcom/blued/android/module/yy_china/databinding/FragmentYyRoomListItemBinding;", 0))};
    private final ViewBindingProperty b;

    /* renamed from: c  reason: collision with root package name */
    private OnCLickRoomItemToGoRoomListener f17438c;
    private YYRoomListsAdapter d;
    private YYRoomExtraModel e;

    public YYRoomListItemFragment() {
        super(R.layout.fragment_yy_room_list_item);
        this.b = this instanceof DialogFragment ? new DialogFragmentViewBindingProperty(new Function1<YYRoomListItemFragment, FragmentYyRoomListItemBinding>() { // from class: com.blued.android.module.yy_china.fragment.YYRoomListItemFragment$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentYyRoomListItemBinding invoke(YYRoomListItemFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentYyRoomListItemBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<YYRoomListItemFragment, FragmentYyRoomListItemBinding>() { // from class: com.blued.android.module.yy_china.fragment.YYRoomListItemFragment$special$$inlined$viewBindingFragment$default$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentYyRoomListItemBinding invoke(YYRoomListItemFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentYyRoomListItemBinding.a(fragment.requireView());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYRoomListItemFragment this$0, String str) {
        Intrinsics.e(this$0, "this$0");
        if (TextUtils.equals(str, this$0.j().e())) {
            YYChatRoomsListItemViewModel j = this$0.j();
            ActivityFragmentActive fragmentActive = this$0.getFragmentActive();
            Intrinsics.c(fragmentActive, "fragmentActive");
            j.a(fragmentActive, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(List<? extends YYChatRoomModel> list) {
        YYRoomListsAdapter yYRoomListsAdapter = this.d;
        if (yYRoomListsAdapter != null) {
            Intrinsics.a(list);
            yYRoomListsAdapter.addData((Collection) list);
        }
        LiveEventBus.get("refresh_or_loadmore_finish").post("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYRoomListItemFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        YYChatRoomsListItemViewModel j = this$0.j();
        ActivityFragmentActive fragmentActive = this$0.getFragmentActive();
        Intrinsics.c(fragmentActive, "fragmentActive");
        j.a(fragmentActive, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(List<? extends YYChatRoomModel> list) {
        NoDataAndLoadFailView noDataAndLoadFailView;
        YYRoomExtraModel yYRoomExtraModel = this.e;
        if (yYRoomExtraModel != null) {
            if (yYRoomExtraModel.is_hall_anchor == 1) {
                YYRoomListsAdapter yYRoomListsAdapter = this.d;
                if (yYRoomListsAdapter != null) {
                    yYRoomListsAdapter.a(true, yYRoomExtraModel.last_room);
                }
            } else {
                YYRoomListsAdapter yYRoomListsAdapter2 = this.d;
                if (yYRoomListsAdapter2 != null) {
                    yYRoomListsAdapter2.a(false, (YYLastRoomModel) null);
                }
            }
        }
        FragmentYyRoomListItemBinding p = p();
        if (p != null && (noDataAndLoadFailView = p.f16546a) != null) {
            noDataAndLoadFailView.d();
        }
        FragmentYyRoomListItemBinding p2 = p();
        RecyclerView recyclerView = p2 == null ? null : p2.b;
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
        }
        YYRoomListsAdapter yYRoomListsAdapter3 = this.d;
        if (yYRoomListsAdapter3 != null) {
            yYRoomListsAdapter3.setNewData(null);
        }
        YYRoomListsAdapter yYRoomListsAdapter4 = this.d;
        if (yYRoomListsAdapter4 != null) {
            yYRoomListsAdapter4.a(true);
        }
        YYRoomListsAdapter yYRoomListsAdapter5 = this.d;
        if (yYRoomListsAdapter5 != null) {
            yYRoomListsAdapter5.setNewData(list);
        }
        Logger.e("EVENT_REFRESH_OR_LOADMORE_FINISH", "showNewRoomDatas isUserVisibleHint: " + this.isUserVisibleHint + " ; room type: " + ((Object) j().e()));
        LiveEventBus.get("refresh_or_loadmore_finish").post("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(boolean z) {
        NoDataAndLoadFailView noDataAndLoadFailView;
        FragmentYyRoomListItemBinding p = p();
        if (p != null && (noDataAndLoadFailView = p.f16546a) != null) {
            noDataAndLoadFailView.a();
        }
        FragmentYyRoomListItemBinding p2 = p();
        RecyclerView recyclerView = p2 == null ? null : p2.b;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
        LiveEventBus.get("refresh_or_loadmore_finish").post("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(boolean z) {
        YYRoomListsAdapter yYRoomListsAdapter = this.d;
        if (yYRoomListsAdapter != null) {
            yYRoomListsAdapter.setEnableLoadMore(false);
        }
        YYRoomListsAdapter yYRoomListsAdapter2 = this.d;
        if (yYRoomListsAdapter2 == null) {
            return;
        }
        yYRoomListsAdapter2.loadMoreComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(boolean z) {
        YYRoomListsAdapter yYRoomListsAdapter = this.d;
        if (yYRoomListsAdapter != null) {
            yYRoomListsAdapter.setEnableLoadMore(true);
        }
        YYRoomListsAdapter yYRoomListsAdapter2 = this.d;
        if (yYRoomListsAdapter2 == null) {
            return;
        }
        yYRoomListsAdapter2.loadMoreComplete();
    }

    private final FragmentYyRoomListItemBinding p() {
        return (FragmentYyRoomListItemBinding) this.b.b(this, f17437a[0]);
    }

    public final void a(OnCLickRoomItemToGoRoomListener onCLickRoomItemToGoRoomListener) {
        this.f17438c = onCLickRoomItemToGoRoomListener;
    }

    public final void a(YYRoomExtraModel yYRoomExtraModel) {
        this.e = yYRoomExtraModel;
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public boolean d() {
        return false;
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void f() {
        RecyclerView recyclerView;
        NoDataAndLoadFailView noDataAndLoadFailView;
        NoDataAndLoadFailView noDataAndLoadFailView2;
        FragmentYyRoomListItemBinding p = p();
        if (p != null && (noDataAndLoadFailView2 = p.f16546a) != null) {
            noDataAndLoadFailView2.setNoDataStr(R.string.yy_no_rooms);
        }
        FragmentYyRoomListItemBinding p2 = p();
        if (p2 != null && (noDataAndLoadFailView = p2.f16546a) != null) {
            noDataAndLoadFailView.setBackgroundColorRes(R.color.transparent);
        }
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        FragmentYyRoomListItemBinding p3 = p();
        RecyclerView recyclerView2 = p3 == null ? null : p3.b;
        if (recyclerView2 != null) {
            recyclerView2.setLayoutManager(gridLayoutManager);
        }
        ActivityFragmentActive fragmentActive = getFragmentActive();
        Intrinsics.c(fragmentActive, "fragmentActive");
        String e = j().e();
        Intrinsics.a((Object) e);
        String f = j().f();
        Intrinsics.a((Object) f);
        YYRoomListsAdapter yYRoomListsAdapter = new YYRoomListsAdapter(fragmentActive, e, f, this.f17438c);
        this.d = yYRoomListsAdapter;
        if (yYRoomListsAdapter != null) {
            yYRoomListsAdapter.setEnableLoadMore(false);
        }
        YYRoomListsAdapter yYRoomListsAdapter2 = this.d;
        if (yYRoomListsAdapter2 != null) {
            yYRoomListsAdapter2.setLoadMoreView(new BluedAdapterLoadMoreView());
        }
        FragmentYyRoomListItemBinding p4 = p();
        RecyclerView recyclerView3 = p4 == null ? null : p4.b;
        if (recyclerView3 != null) {
            recyclerView3.setAdapter(this.d);
        }
        YYRoomListsAdapter yYRoomListsAdapter3 = this.d;
        if (yYRoomListsAdapter3 != null) {
            FragmentYyRoomListItemBinding p5 = p();
            yYRoomListsAdapter3.bindToRecyclerView(p5 == null ? null : p5.b);
        }
        YYRoomListsAdapter yYRoomListsAdapter4 = this.d;
        if (yYRoomListsAdapter4 != null) {
            yYRoomListsAdapter4.disableLoadMoreIfNotFullPage();
        }
        FragmentYyRoomListItemBinding p6 = p();
        if (p6 != null && (recyclerView = p6.b) != null) {
            recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.blued.android.module.yy_china.fragment.YYRoomListItemFragment$initView$1
                private int b;

                /* renamed from: c  reason: collision with root package name */
                private int f17440c;
                private boolean d;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.b = DensityUtils.a(YYRoomListItemFragment.this.getContext(), 6.0f);
                }

                /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
                @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
                public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView4, RecyclerView.State state) {
                    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:322)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
                }
            });
        }
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.blued.android.module.yy_china.fragment.YYRoomListItemFragment$initView$2
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i) {
                YYRoomListsAdapter yYRoomListsAdapter5;
                yYRoomListsAdapter5 = YYRoomListItemFragment.this.d;
                boolean z = false;
                if (yYRoomListsAdapter5 != null && yYRoomListsAdapter5.getItemViewType(i) == 0) {
                    z = true;
                }
                if (z) {
                    return 1;
                }
                return gridLayoutManager.getSpanCount();
            }
        });
        YYRoomListsAdapter yYRoomListsAdapter5 = this.d;
        if (yYRoomListsAdapter5 == null) {
            return;
        }
        BaseQuickAdapter.RequestLoadMoreListener requestLoadMoreListener = new BaseQuickAdapter.RequestLoadMoreListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYRoomListItemFragment$z6xPiGb6c_56i8torraLNPxfusM
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.RequestLoadMoreListener
            public final void onLoadMoreRequested() {
                YYRoomListItemFragment.b(YYRoomListItemFragment.this);
            }
        };
        FragmentYyRoomListItemBinding p7 = p();
        yYRoomListsAdapter5.setOnLoadMoreListener(requestLoadMoreListener, p7 == null ? null : p7.b);
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void k() {
        super.k();
        LiveEventBus.get("refresh_or_loadmore", String.class).observe(this, new Observer() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYRoomListItemFragment$xCP20vn5lK4UI4kFmRKOR_jCByw
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                YYRoomListItemFragment.a(YYRoomListItemFragment.this, (String) obj);
            }
        });
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void l() {
        YYRoomListItemFragment yYRoomListItemFragment = this;
        YYChatRoomsListItemViewModel j = j();
        LifecycleExtKt.a(yYRoomListItemFragment, j == null ? null : j.g(), new YYRoomListItemFragment$liveDataObserver$1(this));
        YYChatRoomsListItemViewModel j2 = j();
        LifecycleExtKt.a(yYRoomListItemFragment, j2 == null ? null : j2.h(), new YYRoomListItemFragment$liveDataObserver$2(this));
        YYChatRoomsListItemViewModel j3 = j();
        LifecycleExtKt.a(yYRoomListItemFragment, j3 == null ? null : j3.j(), new YYRoomListItemFragment$liveDataObserver$3(this));
        YYChatRoomsListItemViewModel j4 = j();
        LifecycleExtKt.a(yYRoomListItemFragment, j4 == null ? null : j4.k(), new YYRoomListItemFragment$liveDataObserver$4(this));
        YYChatRoomsListItemViewModel j5 = j();
        LifecycleExtKt.a(yYRoomListItemFragment, j5 == null ? null : j5.i(), new YYRoomListItemFragment$liveDataObserver$5(this));
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        YYRoomListsAdapter yYRoomListsAdapter = this.d;
        if (yYRoomListsAdapter != null) {
            Intrinsics.a(yYRoomListsAdapter);
            yYRoomListsAdapter.a(false);
        }
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        YYChatRoomsListItemViewModel j = j();
        ActivityFragmentActive fragmentActive = getFragmentActive();
        Intrinsics.c(fragmentActive, "fragmentActive");
        j.a(fragmentActive, true);
    }
}
