package com.soft.blued.ui.msg_group.adapter;

import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.ui.msg_group.model.GroupApplyResp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/adapter/GroupHelpAdapter.class */
public final class GroupHelpAdapter extends BaseQuickAdapter<GroupApplyResp.User, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private final IRequestHost f32630a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupHelpAdapter(IRequestHost requestHost) {
        super((int) R.layout.item_pop_group_help_create);
        Intrinsics.e(requestHost, "requestHost");
        this.f32630a = requestHost;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder helper, GroupApplyResp.User item) {
        Intrinsics.e(helper, "helper");
        Intrinsics.e(item, "item");
        String avatar = item.getAvatar();
        if (avatar == null || avatar.length() == 0) {
            String name = item.getName();
            if (name == null || name.length() == 0) {
                helper.setImageResource(2131365477, R.drawable.icon_group_help_add).setTextColor(R.id.tv_nick, ContextCompat.getColor(this.mContext, 2131102264)).setText(R.id.tv_nick, this.mContext.getString(R.string.group_help_unfinished_invite)).setGone(2131371733, false).setGone(R.id.view_shape, false);
                return;
            }
        }
        ImageLoader.a(this.f32630a, item.getAvatar()).c().a((ImageView) helper.getView(2131365477));
        helper.setText(R.id.tv_nick, item.getName()).setTextColor(R.id.tv_nick, ContextCompat.getColor(this.mContext, 2131102263)).setGone(2131371733, true).setGone(R.id.view_shape, true);
    }
}
