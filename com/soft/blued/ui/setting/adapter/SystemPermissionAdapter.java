package com.soft.blued.ui.setting.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.ui.setting.model.PermissionModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/adapter/SystemPermissionAdapter.class */
public final class SystemPermissionAdapter extends BaseQuickAdapter<PermissionModel, BaseViewHolder> {
    public SystemPermissionAdapter() {
        super((int) R.layout.item_system_permission);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, PermissionModel permissionModel) {
        Intrinsics.e(baseViewHolder, "helper");
        Intrinsics.e(permissionModel, "item");
        baseViewHolder.setText(2131372754, permissionModel.getTitle()).setText(R.id.tv_desc, permissionModel.getDesc());
    }
}
