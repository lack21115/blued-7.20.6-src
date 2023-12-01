package com.soft.blued.ui.msg_group.adapter;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.module.common.group.GroupInfoModel;
import com.blued.das.client.socialnet.SocialNetWorkProtos;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.log.track.EventTrackGroup;
import com.soft.blued.ui.msg_group.utils.GroupUtil;
import com.soft.blued.ui.msg_group.view.VerticalTextView;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/adapter/MyGroupAdapter.class */
public class MyGroupAdapter extends BaseMultiItemQuickAdapter<GroupInfoModel, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private String f18969a;
    private IRequestHost b;

    public MyGroupAdapter(IRequestHost iRequestHost) {
        super(null);
        addItemType(0, R.layout.item_my_group_data);
        addItemType(5, R.layout.item_my_group_data_horizontal);
        addItemType(1, R.layout.item_my_group_header);
        addItemType(2, R.layout.item_my_group_header);
        addItemType(4, R.layout.item_my_group_privilege);
        addItemType(3, R.layout.item_my_group_header);
        addItemType(6, R.layout.item_my_group_header_horizontal);
        this.b = iRequestHost;
    }

    private void b(BaseViewHolder baseViewHolder, GroupInfoModel groupInfoModel) {
        ((VerticalTextView) baseViewHolder.getView(2131370786)).setText(this.mContext.getString(R.string.group_event_group_divide));
    }

    private void c(BaseViewHolder baseViewHolder, GroupInfoModel groupInfoModel) {
        SocialNetWorkProtos.Event event = SocialNetWorkProtos.Event.GROUP_DRAW;
        List list = groupInfoModel.label;
        SocialNetWorkProtos.SourceType sourceType = groupInfoModel.group_role == 1 ? SocialNetWorkProtos.SourceType.CREATE : SocialNetWorkProtos.SourceType.JOIN;
        EventTrackGroup.a(event, list, sourceType, groupInfoModel.group_id + "");
        GroupUtil.a(baseViewHolder.getView(R.id.tv_type), groupInfoModel, true);
        GroupUtil.b(this.b, groupInfoModel.group_cover, (ImageView) baseViewHolder.getView(R.id.iv_header));
        GroupUtil.a((TextView) baseViewHolder.getView(R.id.tv_identity), groupInfoModel.group_role, false);
        GroupUtil.a(groupInfoModel, (TextView) baseViewHolder.getView(2131372046));
        GroupUtil.a((TextView) baseViewHolder.getView(R.id.tv_frozen), groupInfoModel.group_role, groupInfoModel.group_status);
        if (TextUtils.isEmpty(this.f18969a)) {
            return;
        }
        UserRelationshipUtils.a(this.mContext, groupInfoModel.group_title, this.f18969a, (TextView) baseViewHolder.getView(2131372046));
    }

    private void d(BaseViewHolder baseViewHolder, GroupInfoModel groupInfoModel) {
    }

    private void e(BaseViewHolder baseViewHolder, GroupInfoModel groupInfoModel) {
        if (groupInfoModel.itemType == 2) {
            BaseViewHolder visible = baseViewHolder.setVisible(R.id.tv_right, true).setVisible(R.id.tv_left, true).setVisible(R.id.rl_activity, false);
            String string = this.mContext.getResources().getString(R.string.group_max_joined);
            visible.setText(R.id.tv_right, String.format(string, groupInfoModel.max_join + "")).setText(R.id.tv_left, this.mContext.getString(R.string.my_joined_groups));
        } else if (groupInfoModel.itemType == 1) {
            baseViewHolder.setVisible(R.id.tv_right, false).setVisible(R.id.tv_left, true).setVisible(R.id.rl_activity, false).setText(R.id.tv_left, this.mContext.getString(R.string.my_created_groups));
        } else if (groupInfoModel.itemType == 3) {
            baseViewHolder.setVisible(R.id.tv_right, false).setVisible(R.id.tv_left, true).setText(R.id.tv_left, this.mContext.getString(R.string.group_event_group));
        }
    }

    private void f(BaseViewHolder baseViewHolder, GroupInfoModel groupInfoModel) {
        boolean z = true;
        EventTrackGroup.a(SocialNetWorkProtos.Event.GROUP_DRAW, groupInfoModel.label, groupInfoModel.group_role == 1 ? SocialNetWorkProtos.SourceType.CREATE : SocialNetWorkProtos.SourceType.JOIN, groupInfoModel.group_id + "");
        GroupUtil.a(baseViewHolder.getView(R.id.tv_type), groupInfoModel, true);
        GroupUtil.b(this.b, groupInfoModel.group_cover, (ImageView) baseViewHolder.getView(R.id.iv_header));
        GroupUtil.a((TextView) baseViewHolder.getView(R.id.tv_identity), groupInfoModel.group_role);
        if (TextUtils.isEmpty(groupInfoModel.group_desc)) {
            baseViewHolder.setGone(R.id.tv_desc, false);
        } else {
            baseViewHolder.setGone(R.id.tv_desc, true);
            baseViewHolder.setText(R.id.tv_desc, groupInfoModel.group_desc).setTextColor(R.id.tv_member_cnt, BluedSkinUtils.a(this.mContext, groupInfoModel.group_now_population > groupInfoModel.group_max_population ? 2131102251 : 2131102263));
        }
        if (groupInfoModel.online <= 0) {
            z = false;
        }
        baseViewHolder.setGone(R.id.iv_online, z);
        String str = groupInfoModel.group_now_population + "/" + groupInfoModel.group_max_population;
        if (groupInfoModel.online > 0) {
            str = groupInfoModel.online + this.mContext.getString(R.string.group_online_number) + " | " + groupInfoModel.group_now_population + "/" + groupInfoModel.group_max_population;
        }
        baseViewHolder.setText(R.id.tv_member_cnt, str);
        GroupUtil.a(groupInfoModel, (TextView) baseViewHolder.getView(2131372046));
        GroupUtil.a((TextView) baseViewHolder.getView(R.id.tv_frozen), groupInfoModel.group_role, groupInfoModel.group_status);
        if (TextUtils.isEmpty(this.f18969a)) {
            return;
        }
        UserRelationshipUtils.a(this.mContext, groupInfoModel.group_title, this.f18969a, (TextView) baseViewHolder.getView(2131372046));
        UserRelationshipUtils.a(this.mContext, groupInfoModel.group_desc, this.f18969a, (TextView) baseViewHolder.getView(R.id.tv_desc));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, GroupInfoModel groupInfoModel) {
        if (groupInfoModel.getItemType() == 0) {
            f(baseViewHolder, groupInfoModel);
        } else if (groupInfoModel.getItemType() == 5) {
            c(baseViewHolder, groupInfoModel);
        } else if (groupInfoModel.getItemType() == 4) {
            d(baseViewHolder, groupInfoModel);
        } else if (groupInfoModel.getItemType() == 6) {
            b(baseViewHolder, groupInfoModel);
        } else {
            e(baseViewHolder, groupInfoModel);
        }
    }

    public void a(String str) {
        this.f18969a = str;
    }
}
