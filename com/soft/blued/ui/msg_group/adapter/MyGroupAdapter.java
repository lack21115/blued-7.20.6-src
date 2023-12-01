package com.soft.blued.ui.msg_group.adapter;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.group.GroupInfoModel;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
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
    private String f32660a;
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
        List<GroupInfoModel.Label> list = groupInfoModel.label;
        SocialNetWorkProtos.SourceType sourceType = groupInfoModel.group_role == 1 ? SocialNetWorkProtos.SourceType.CREATE : SocialNetWorkProtos.SourceType.JOIN;
        EventTrackGroup.a(event, list, sourceType, groupInfoModel.group_id + "");
        GroupUtil.a((ShapeTextView) baseViewHolder.getView(2131372839), groupInfoModel, true);
        GroupUtil.b(this.b, groupInfoModel.group_cover, (ImageView) baseViewHolder.getView(2131365477));
        GroupUtil.a((TextView) baseViewHolder.getView(R.id.tv_identity), groupInfoModel.group_role, false);
        GroupUtil.a(groupInfoModel, (TextView) baseViewHolder.getView(2131372046));
        GroupUtil.a((TextView) baseViewHolder.getView(R.id.tv_frozen), groupInfoModel.group_role, groupInfoModel.group_status);
        if (TextUtils.isEmpty(this.f32660a)) {
            return;
        }
        UserRelationshipUtils.a(this.mContext, groupInfoModel.group_title, this.f32660a, (TextView) baseViewHolder.getView(2131372046));
    }

    private void d(BaseViewHolder baseViewHolder, GroupInfoModel groupInfoModel) {
    }

    private void e(BaseViewHolder baseViewHolder, GroupInfoModel groupInfoModel) {
        if (groupInfoModel.itemType == 2) {
            BaseViewHolder visible = baseViewHolder.setVisible(2131372451, true).setVisible(2131371781, true).setVisible(R.id.rl_activity, false);
            String string = this.mContext.getResources().getString(R.string.group_max_joined);
            visible.setText(2131372451, String.format(string, groupInfoModel.max_join + "")).setText(2131371781, this.mContext.getString(R.string.my_joined_groups));
        } else if (groupInfoModel.itemType == 1) {
            baseViewHolder.setVisible(2131372451, false).setVisible(2131371781, true).setVisible(R.id.rl_activity, false).setText(2131371781, this.mContext.getString(R.string.my_created_groups));
        } else if (groupInfoModel.itemType == 3) {
            baseViewHolder.setVisible(2131372451, false).setVisible(2131371781, true).setText(2131371781, this.mContext.getString(R.string.group_event_group));
        }
    }

    private void f(BaseViewHolder baseViewHolder, GroupInfoModel groupInfoModel) {
        boolean z = true;
        EventTrackGroup.a(SocialNetWorkProtos.Event.GROUP_DRAW, groupInfoModel.label, groupInfoModel.group_role == 1 ? SocialNetWorkProtos.SourceType.CREATE : SocialNetWorkProtos.SourceType.JOIN, groupInfoModel.group_id + "");
        GroupUtil.a((ShapeTextView) baseViewHolder.getView(2131372839), groupInfoModel, true);
        GroupUtil.b(this.b, groupInfoModel.group_cover, (ImageView) baseViewHolder.getView(2131365477));
        GroupUtil.a((TextView) baseViewHolder.getView(R.id.tv_identity), groupInfoModel.group_role);
        if (TextUtils.isEmpty(groupInfoModel.group_desc)) {
            baseViewHolder.setGone(2131371262, false);
        } else {
            baseViewHolder.setGone(2131371262, true);
            baseViewHolder.setText(2131371262, groupInfoModel.group_desc).setTextColor(R.id.tv_member_cnt, BluedSkinUtils.a(this.mContext, groupInfoModel.group_now_population > groupInfoModel.group_max_population ? 2131102251 : 2131102263));
        }
        if (groupInfoModel.online <= 0) {
            z = false;
        }
        baseViewHolder.setGone(2131365702, z);
        String str = groupInfoModel.group_now_population + BridgeUtil.SPLIT_MARK + groupInfoModel.group_max_population;
        if (groupInfoModel.online > 0) {
            str = groupInfoModel.online + this.mContext.getString(R.string.group_online_number) + " | " + groupInfoModel.group_now_population + BridgeUtil.SPLIT_MARK + groupInfoModel.group_max_population;
        }
        baseViewHolder.setText(R.id.tv_member_cnt, str);
        GroupUtil.a(groupInfoModel, (TextView) baseViewHolder.getView(2131372046));
        GroupUtil.a((TextView) baseViewHolder.getView(R.id.tv_frozen), groupInfoModel.group_role, groupInfoModel.group_status);
        if (TextUtils.isEmpty(this.f32660a)) {
            return;
        }
        UserRelationshipUtils.a(this.mContext, groupInfoModel.group_title, this.f32660a, (TextView) baseViewHolder.getView(2131372046));
        UserRelationshipUtils.a(this.mContext, groupInfoModel.group_desc, this.f32660a, (TextView) baseViewHolder.getView(2131371262));
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
        this.f32660a = str;
    }
}
