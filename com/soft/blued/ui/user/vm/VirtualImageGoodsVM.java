package com.soft.blued.ui.user.vm;

import android.os.Bundle;
import com.blued.android.module.common.base.mvi.BaseListViewModel;
import com.soft.blued.ui.user.model.VirtualImageModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/vm/VirtualImageGoodsVM.class */
public final class VirtualImageGoodsVM extends BaseListViewModel<VirtualImageModel.ImageGoodsModel> {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f34410a = new Companion(null);
    private VirtualImageModel.CategoryModel b;

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/vm/VirtualImageGoodsVM$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final VirtualImageModel.CategoryModel a() {
        return this.b;
    }

    public final void a(VirtualImageModel.CategoryModel categoryModel) {
        this.b = categoryModel;
    }

    @Override // com.blued.android.module.common.base.mvi.MVIBaseViewModel
    public void init(Bundle bundle) {
        super.init(bundle);
        Object obj = bundle == null ? null : bundle.get("data_category");
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.soft.blued.ui.user.model.VirtualImageModel.CategoryModel");
        }
        this.b = (VirtualImageModel.CategoryModel) obj;
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListViewModel
    public void requestData() {
        VirtualImageModel.CategoryModel categoryModel = this.b;
        if (categoryModel == null) {
            return;
        }
        loadListSucceed(categoryModel.getGoods_list(), false);
    }
}
