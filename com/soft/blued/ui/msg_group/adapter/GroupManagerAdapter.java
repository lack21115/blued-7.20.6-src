package com.soft.blued.ui.msg_group.adapter;

import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.group.GroupMemberModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.ui.msg_group.utils.GroupUtil;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/adapter/GroupManagerAdapter.class */
public class GroupManagerAdapter extends BaseQuickAdapter<GroupMemberModel, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private IRequestHost f18940a;

    public GroupManagerAdapter(List<GroupMemberModel> list, IRequestHost iRequestHost) {
        super(R.layout.item_group_admin_list, list);
        this.f18940a = iRequestHost;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, GroupMemberModel groupMemberModel) {
        ShapeTextView view = baseViewHolder.getView(R.id.tv_identity);
        GroupUtil.a(this.f18940a, groupMemberModel.avatar, (ImageView) baseViewHolder.getView(2131365504));
        GroupUtil.a((TextView) view, groupMemberModel.group_role);
    }
}
