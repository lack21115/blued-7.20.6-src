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
    public void convert(BaseViewHolder helper, GroupInfoModel item) {
        Intrinsics.e(helper, "helper");
        Intrinsics.e(item, "item");
        GroupUtil.b((IRequestHost) null, item.group_cover, (ImageView) helper.getView(2131365230));
        ((ImageView) helper.getView(2131365189)).setSelected(item.isSelected);
        BaseViewHolder text = helper.setText(2131372754, item.group_title).setText(2131371262, item.group_desc);
        StringBuilder sb = new StringBuilder();
        sb.append(item.group_now_population);
        sb.append('/');
        sb.append(item.group_max_population);
        text.setText(2131372144, sb.toString());
        ((ImageView) helper.getView(2131365189)).setSelected(item.isSelected);
    }
}
