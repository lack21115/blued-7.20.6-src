package com.soft.blued.ui.msg_group.adapter;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.group.GroupMemberModel;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.user.UserInfoHelper;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.ui.msg_group.utils.GroupUtil;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/adapter/SearchMemberAdapter.class */
public class SearchMemberAdapter extends BaseQuickAdapter<GroupMemberModel, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private IRequestHost f18971a;
    private String b;

    public SearchMemberAdapter(IRequestHost iRequestHost) {
        super((int) R.layout.item_search_group_member);
        this.b = "";
        this.f18971a = iRequestHost;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, GroupMemberModel groupMemberModel) {
        UserRelationshipUtils.a((ImageView) baseViewHolder.getView(R.id.iv_vip), (UserBasicModel) groupMemberModel);
        GroupUtil.a((TextView) baseViewHolder.getView(2131372046), (UserBasicModel) groupMemberModel);
        UserRelationshipUtils.a(this.mContext, groupMemberModel.name, this.b, (TextView) baseViewHolder.getView(2131372046));
        UserInfoHelper.a((ImageView) baseViewHolder.getView(R.id.iv_verify), groupMemberModel.vbadge, 3);
        GroupUtil.a(this.f18971a, groupMemberModel.avatar, (ImageView) baseViewHolder.getView(R.id.iv_header));
        GroupUtil.a((TextView) baseViewHolder.getView(R.id.tv_identity), groupMemberModel.group_role);
    }

    public void a(List<GroupMemberModel> list, String str) {
        this.b = str;
        if (TextUtils.isEmpty(str)) {
            this.b = "";
        }
        setNewData(list);
    }
}
