package com.soft.blued.ui.setting.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.sobot.chat.api.model.StDocModel;
import com.soft.blued.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/adapter/ServiceCenterAdapter.class */
public final class ServiceCenterAdapter extends BaseQuickAdapter<StDocModel, BaseViewHolder> {
    public ServiceCenterAdapter() {
        super((int) R.layout.item_service_center);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder helper, StDocModel item) {
        Intrinsics.e(helper, "helper");
        Intrinsics.e(item, "item");
        helper.setText(2131370786, Intrinsics.a("· ", (Object) item.getQuestionTitle()));
    }
}
