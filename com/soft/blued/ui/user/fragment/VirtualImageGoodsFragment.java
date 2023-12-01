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
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/VirtualImageGoodsFragment.class */
public final class VirtualImageGoodsFragment extends BaseListFragment<VirtualImageGoodsVM, VirtualImageModel.ImageGoodsModel> {
    private VirtualImageFragment.ImageCallBack b;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(VirtualImageGoodsFragment virtualImageGoodsFragment, VirtualImageModel.CategoryModel categoryModel, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.e(virtualImageGoodsFragment, "this$0");
        Intrinsics.e(categoryModel, "$categoryModel");
        Object obj = baseQuickAdapter.getData().get(i);
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.soft.blued.ui.user.model.VirtualImageModel.ImageGoodsModel");
        }
        VirtualImageModel.ImageGoodsModel imageGoodsModel = (VirtualImageModel.ImageGoodsModel) obj;
        if (imageGoodsModel.getCurrent_use() == 1) {
            return;
        }
        VirtualImageFragment.ImageCallBack imageCallBack = virtualImageGoodsFragment.b;
        if (imageCallBack != null) {
            imageCallBack.a();
        }
        VirtualImageFragment.ImageCallBack imageCallBack2 = virtualImageGoodsFragment.b;
        if (imageCallBack2 != null) {
            imageCallBack2.a(categoryModel.getId(), imageGoodsModel);
        }
        baseQuickAdapter.notifyDataSetChanged();
    }

    /* renamed from: C */
    public VirtualImageGoodsAdapter i() {
        return new VirtualImageGoodsAdapter(this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: D */
    public GridLayoutManager g() {
        return new GridLayoutManager(getContext(), 5);
    }

    public final void E() {
        BluedStructureExtKt.a((MVIBaseFragment) this, BaseListAction.RefreshData.a);
    }

    public final void a(VirtualImageFragment.ImageCallBack imageCallBack) {
        this.b = imageCallBack;
    }

    public final void a(VirtualImageModel.CategoryModel categoryModel) {
        Intrinsics.e(categoryModel, "categoryModel");
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
        int i;
        Bundle arguments = getArguments();
        Object obj = arguments == null ? null : arguments.get("data_category");
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.soft.blued.ui.user.model.VirtualImageModel.CategoryModel");
        }
        final VirtualImageModel.CategoryModel categoryModel = (VirtualImageModel.CategoryModel) obj;
        if (categoryModel.getBlock_code() == 3.0f) {
            ((VirtualImageGoodsAdapter) f()).a(4);
        }
        super.m();
        if (categoryModel.getBlock_code() == 3.0f) {
            RecyclerView a2 = a();
            if (a2 == null) {
                i = 4;
            } else {
                a2.setLayoutManager(new GridLayoutManager(getContext(), 4));
                i = 4;
            }
        } else {
            i = 5;
        }
        RecyclerView a3 = a();
        if (a3 != null) {
            a3.addItemDecoration(new GridSpaceItemDecoration(i, BluedViewExtKt.a(5), false));
            a3.setPadding(BluedViewExtKt.a(8), BluedViewExtKt.a(8), BluedViewExtKt.a(8), BluedViewExtKt.a(8));
            a3.setClipToPadding(false);
        }
        f().setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VirtualImageGoodsFragment$ZSFrAgv59b_jqUcCAqaj01gzJA0
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                VirtualImageGoodsFragment.a(VirtualImageGoodsFragment.this, categoryModel, baseQuickAdapter, view, i2);
            }
        });
    }
}
