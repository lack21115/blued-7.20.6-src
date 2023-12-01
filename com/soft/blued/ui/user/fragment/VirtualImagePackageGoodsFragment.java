package com.soft.blued.ui.user.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.module.common.base.config.ListConfig;
import com.blued.android.module.common.base.mvi.BaseListAction;
import com.blued.android.module.common.base.mvi.BaseListFragment;
import com.blued.android.module.common.base.mvi.MVIBaseFragment;
import com.blued.android.module.common.extensions.BluedStructureExtKt;
import com.blued.android.module.common.extensions.BluedViewExtKt;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.soft.blued.ui.user.adapter.VirtualImageGoodsAdapter;
import com.soft.blued.ui.user.fragment.VirtualImageFragment;
import com.soft.blued.ui.user.model.VirtualImageModel;
import com.soft.blued.ui.user.vm.VirtualImageGoodsVM;
import com.soft.blued.utils.GridSpaceItemDecoration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/VirtualImagePackageGoodsFragment.class */
public final class VirtualImagePackageGoodsFragment extends BaseListFragment<VirtualImageGoodsVM, VirtualImageModel.ImageGoodsModel> {
    private VirtualImageFragment.ImageCallBack b;

    /* renamed from: c  reason: collision with root package name */
    private VirtualImageModel.CategoryModel f20515c;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(VirtualImagePackageGoodsFragment virtualImagePackageGoodsFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        VirtualImageFragment.ImageCallBack C;
        Intrinsics.e(virtualImagePackageGoodsFragment, "this$0");
        Object obj = baseQuickAdapter.getData().get(i);
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.soft.blued.ui.user.model.VirtualImageModel.ImageGoodsModel");
        }
        VirtualImageModel.ImageGoodsModel imageGoodsModel = (VirtualImageModel.ImageGoodsModel) obj;
        if (imageGoodsModel.getCurrent_use() == 1) {
            return;
        }
        VirtualImageFragment.ImageCallBack imageCallBack = virtualImagePackageGoodsFragment.b;
        if (imageCallBack != null) {
            imageCallBack.a();
        }
        VirtualImageModel.CategoryModel a2 = virtualImagePackageGoodsFragment.y().a();
        if (a2 != null && (C = virtualImagePackageGoodsFragment.C()) != null) {
            C.a(a2.getId(), imageGoodsModel);
        }
        baseQuickAdapter.notifyDataSetChanged();
    }

    public final VirtualImageFragment.ImageCallBack C() {
        return this.b;
    }

    /* renamed from: D */
    public VirtualImageGoodsAdapter i() {
        return new VirtualImageGoodsAdapter(this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: E */
    public GridLayoutManager g() {
        return new GridLayoutManager(getContext(), 5);
    }

    public final Integer F() {
        VirtualImageModel.CategoryModel categoryModel = this.f20515c;
        if (categoryModel == null) {
            return null;
        }
        return Integer.valueOf(categoryModel.getId());
    }

    public final void G() {
        BluedStructureExtKt.a((MVIBaseFragment) this, BaseListAction.RefreshData.a);
    }

    public final void a(VirtualImageFragment.ImageCallBack imageCallBack) {
        this.b = imageCallBack;
    }

    public final void a(VirtualImageModel.CategoryModel categoryModel) {
        Intrinsics.e(categoryModel, "categoryModel");
        this.f20515c = categoryModel;
        y().a(categoryModel);
        BluedStructureExtKt.a((MVIBaseFragment) this, BaseListAction.RefreshData.a);
    }

    public ListConfig h() {
        ListConfig h = super.h();
        h.b(false);
        h.c(false);
        h.d(false);
        return h;
    }

    public void m() {
        super.m();
        RecyclerView a2 = a();
        if (a2 != null) {
            a2.addItemDecoration(new GridSpaceItemDecoration(5, BluedViewExtKt.a(5), false));
            a2.setPadding(BluedViewExtKt.a(0), BluedViewExtKt.a(8), BluedViewExtKt.a(0), BluedViewExtKt.a(8));
            a2.setClipToPadding(false);
        }
        f().setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VirtualImagePackageGoodsFragment$xKLgdzkuBCaf0aGSwN5iO96HA1c
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                VirtualImagePackageGoodsFragment.a(VirtualImagePackageGoodsFragment.this, baseQuickAdapter, view, i);
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        Object obj = arguments == null ? null : arguments.get("data_category");
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.soft.blued.ui.user.model.VirtualImageModel.CategoryModel");
        }
        this.f20515c = (VirtualImageModel.CategoryModel) obj;
    }
}
