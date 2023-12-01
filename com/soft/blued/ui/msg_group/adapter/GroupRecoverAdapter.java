package com.soft.blued.ui.msg_group.adapter;

import android.widget.ImageView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.group.GroupInfoModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.ui.msg_group.utils.GroupUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/adapter/GroupRecoverAdapter.class */
public final class GroupRecoverAdapter extends BaseQuickAdapter<GroupInfoModel, BaseViewHolder> {
    public GroupRecoverAdapter() {
        super((int) R.layout.item_recover_super_group);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, GroupInfoModel groupInfoModel) {
        Intrinsics.e(baseViewHolder, "helper");
        Intrinsics.e(groupInfoModel, "item");
        GroupUtil.b((IRequestHost) null, groupInfoModel.group_cover, (ImageView) baseViewHolder.getView(R.id.iv_cover));
        ((ImageView) baseViewHolder.getView(R.id.iv_check)).setSelected(groupInfoModel.isSelected);
        BaseViewHolder text = baseViewHolder.setText(2131372754, groupInfoModel.group_title).setText(R.id.tv_desc, groupInfoModel.group_desc);
        StringBuilder sb = new StringBuilder();
        sb.append(groupInfoModel.group_now_population);
        sb.append('/');
        sb.append(groupInfoModel.group_max_population);
        text.setText(R.id.tv_num, sb.toString());
        ((ImageView) baseViewHolder.getView(R.id.iv_check)).setSelected(groupInfoModel.isSelected);
    }
}
