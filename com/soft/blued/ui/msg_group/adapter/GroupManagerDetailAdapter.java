package com.soft.blued.ui.msg_group.adapter;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.group.GroupMemberModel;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.utils.AvatarUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.ui.msg_group.utils.GroupUtil;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/adapter/GroupManagerDetailAdapter.class */
public class GroupManagerDetailAdapter extends BaseQuickAdapter<GroupMemberModel, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private IRequestHost f18941a;

    public GroupManagerDetailAdapter(List<GroupMemberModel> list, IRequestHost iRequestHost) {
        super(R.layout.item_group_manager_detail, list);
        this.f18941a = iRequestHost;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, GroupMemberModel groupMemberModel) {
        baseViewHolder.setVisible(R.id.iv_online, groupMemberModel.online_state == 1);
        TextView textView = (TextView) baseViewHolder.getView(R.id.role_view);
        TextView textView2 = (TextView) baseViewHolder.getView(R.id.name_view);
        TextView textView3 = (TextView) baseViewHolder.getView(R.id.location_view);
        TextView textView4 = (TextView) baseViewHolder.getView(R.id.age_view);
        TextView textView5 = (TextView) baseViewHolder.getView(R.id.height_view);
        TextView textView6 = (TextView) baseViewHolder.getView(R.id.weight_view);
        LinearLayout linearLayout = (LinearLayout) baseViewHolder.getView(R.id.ll_personal_info);
        LinearLayout linearLayout2 = (LinearLayout) baseViewHolder.getView(R.id.ll_distance);
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.img_blued_medal);
        RelativeLayout relativeLayout = (RelativeLayout) baseViewHolder.getView(R.id.cancel_manager);
        UserRelationshipUtils.a(imageView, (UserBasicModel) groupMemberModel);
        if (groupMemberModel.is_official != 1) {
            UserInfoHelper.a(this.mContext, textView, groupMemberModel.role);
        }
        if (!TextUtils.isEmpty(groupMemberModel.note)) {
            textView2.setText(groupMemberModel.note);
        } else if (TextUtils.isEmpty(groupMemberModel.name)) {
            textView2.setText("");
        } else {
            textView2.setText(groupMemberModel.name);
        }
        UserRelationshipUtils.a(this.mContext, textView2, (UserBasicModel) groupMemberModel);
        if (groupMemberModel.vbadge == 3 || groupMemberModel.vbadge == 5) {
            linearLayout.setVisibility(8);
        } else {
            linearLayout.setVisibility(0);
            if (TextUtils.isEmpty(groupMemberModel.age)) {
                textView4.setText("");
            } else {
                textView4.setText(groupMemberModel.age + this.mContext.getResources().getString(2131886374));
            }
            if (TextUtils.isEmpty(groupMemberModel.height)) {
                textView5.setText("");
            } else {
                textView5.setText(groupMemberModel.height);
            }
            if (TextUtils.isEmpty(groupMemberModel.weight)) {
                textView6.setText("");
            } else {
                textView6.setText(groupMemberModel.weight);
            }
        }
        if (groupMemberModel.vbadge == 3) {
            linearLayout2.setVisibility(8);
        } else {
            linearLayout2.setVisibility(0);
        }
        if (TextUtils.isEmpty(groupMemberModel.location) || groupMemberModel.vbadge == 3) {
            textView3.setText("");
        } else {
            textView3.setText(groupMemberModel.location);
        }
        ShapeTextView view = baseViewHolder.getView(R.id.tv_identity);
        if ("0".equals(groupMemberModel.uid)) {
            ImageLoader.a(this.f18941a, (int) R.drawable.icon_group_add_manager).c().a((ImageView) baseViewHolder.getView(2131365504));
            view.setVisibility(4);
            relativeLayout.setVisibility(8);
        } else {
            relativeLayout.setVisibility(0);
            GroupUtil.a((TextView) view, groupMemberModel.group_role);
            ImageLoader.a(this.f18941a, AvatarUtils.a(0, groupMemberModel.avatar)).c().b(2131237310).a((ImageView) baseViewHolder.getView(2131365504));
        }
        baseViewHolder.addOnClickListener(2131365504);
        baseViewHolder.addOnClickListener(R.id.cancel_manager);
    }
}
