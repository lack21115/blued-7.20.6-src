package com.soft.blued.ui.msg_group.adapter;

import android.widget.ImageView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.group.GroupInfoModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.ui.msg_group.utils.GroupUtil;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/adapter/CircleGroupAdapter.class */
public class CircleGroupAdapter extends BaseQuickAdapter<GroupInfoModel, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private IRequestHost f18938a;

    public CircleGroupAdapter(List<GroupInfoModel> list, IRequestHost iRequestHost) {
        super(R.layout.item_circle_groups, list);
        this.f18938a = iRequestHost;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, GroupInfoModel groupInfoModel) {
        GroupUtil.b(this.f18938a, groupInfoModel.group_cover, (ImageView) baseViewHolder.getView(R.id.iv_header));
        baseViewHolder.setGone(R.id.already_add, groupInfoModel.group_role != 0);
        baseViewHolder.setText(R.id.tv_group_name, groupInfoModel.group_title);
        baseViewHolder.setText(R.id.tv_member_num, groupInfoModel.group_now_population + "/" + groupInfoModel.group_max_population).setGone(R.id.tv_full, groupInfoModel.group_now_population == groupInfoModel.group_max_population);
        baseViewHolder.addOnClickListener(R.id.tv_view);
        baseViewHolder.addOnClickListener(R.id.iv_header);
    }
}
