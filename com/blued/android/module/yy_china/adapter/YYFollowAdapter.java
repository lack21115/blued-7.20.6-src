package com.blued.android.module.yy_china.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.module.common.utils.ImgURLMap;
import com.blued.android.module.common.utils.YyChatRoomTagShapeUtils;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.svgaplayer.SVGAPlayer;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.ItemYyFollowedsLayoutBinding;
import com.blued.android.module.yy_china.model.YYChatRoomFollowedModel;
import com.blued.android.module.yy_china.model.YYClubLevelInfoModel;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/YYFollowAdapter.class */
public final class YYFollowAdapter extends BaseQuickAdapter<YYChatRoomFollowedModel, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private Context f16174a;
    private ActivityFragmentActive b;

    /* renamed from: c  reason: collision with root package name */
    private String f16175c;
    private String d;
    private boolean e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYFollowAdapter(Context context, ActivityFragmentActive fragmentActive, String source, String adapterType) {
        super(R.layout.item_yy_followeds_layout, new ArrayList());
        Intrinsics.e(fragmentActive, "fragmentActive");
        Intrinsics.e(source, "source");
        Intrinsics.e(adapterType, "adapterType");
        this.f16174a = context;
        this.b = fragmentActive;
        this.f16175c = source;
        this.d = adapterType;
        this.e = true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onViewRecycled(BaseViewHolder holder) {
        Intrinsics.e(holder, "holder");
        super.onViewRecycled(holder);
        SVGAImageView sVGAImageView = (SVGAImageView) holder.itemView.findViewById(R.id.iv_type_ani);
        if (sVGAImageView == null) {
            return;
        }
        sVGAImageView.a(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, YYChatRoomFollowedModel yYChatRoomFollowedModel) {
        View view = baseViewHolder == null ? null : baseViewHolder.itemView;
        Intrinsics.a(view);
        ItemYyFollowedsLayoutBinding a2 = ItemYyFollowedsLayoutBinding.a(view);
        Intrinsics.c(a2, "bind(helper?.itemView!!)");
        ActivityFragmentActive activityFragmentActive = this.b;
        String str = yYChatRoomFollowedModel == null ? null : yYChatRoomFollowedModel.avatar;
        Intrinsics.a((Object) str);
        ImageLoader.a(activityFragmentActive, str).a(a2.f16719c);
        a2.j.setText(yYChatRoomFollowedModel.room_type);
        a2.i.setText(yYChatRoomFollowedModel.name);
        a2.k.setText(yYChatRoomFollowedModel.room_name);
        a2.g.setText(Intrinsics.a(yYChatRoomFollowedModel.room_member_count, (Object) "  人"));
        a2.h.setText(yYChatRoomFollowedModel.last_on_time);
        ShapeHelper.a(a2.f, a2.f.getResources().getDimension(R.dimen.dp_8), a2.f.getResources().getDimension(R.dimen.dp_8), a2.f.getResources().getDimension(R.dimen.dp_8), a2.f.getResources().getDimension(R.dimen.dp_8));
        YyChatRoomTagShapeUtils yyChatRoomTagShapeUtils = YyChatRoomTagShapeUtils.f10915a;
        ShapeLinearLayout shapeLinearLayout = a2.f;
        Intrinsics.c(shapeLinearLayout, "bind.llType");
        yyChatRoomTagShapeUtils.a(shapeLinearLayout, yYChatRoomFollowedModel.type_id);
        if (TextUtils.isEmpty(yYChatRoomFollowedModel.room_type)) {
            a2.f.setVisibility(8);
        } else {
            a2.f.setVisibility(0);
        }
        if (yYChatRoomFollowedModel.fans_group_info == null || StringUtils.b(yYChatRoomFollowedModel.fans_group_info.name)) {
            a2.l.setVisibility(8);
        } else {
            a2.l.setVisibility(0);
            YYClubLevelInfoModel yYClubLevelInfoModel = yYChatRoomFollowedModel.fans_group_info;
            if (yYClubLevelInfoModel != null) {
                a2.l.a(yYClubLevelInfoModel.level, yYClubLevelInfoModel.name, yYClubLevelInfoModel.status == 1);
            }
        }
        a2.d.setMIsNeedOnDetachedFromWindow(true);
        SVGAPlayer.Builder builder = new SVGAPlayer.Builder(ImgURLMap.f10885a.a(BluedSkinUtils.c() ? "yy_home_small_black" : "yy_home_small_white"));
        SVGAImageView sVGAImageView = a2.d;
        Intrinsics.c(sVGAImageView, "bind.ivTypeAni");
        builder.a(sVGAImageView);
        if (yYChatRoomFollowedModel.isOnLive() || TextUtils.equals(this.d, "history_room")) {
            a2.k.setVisibility(0);
            a2.g.setVisibility(0);
            a2.h.setVisibility(8);
            a2.f16718a.setVisibility(8);
            EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_FOLLOW_ROOM_SHOW, yYChatRoomFollowedModel.room_id, yYChatRoomFollowedModel.uid, yYChatRoomFollowedModel.type_id, ChatRoomProtos.From.FOLLOW_ROOM_LIST_SECOND_PAGE);
        } else {
            a2.k.setVisibility(8);
            a2.g.setVisibility(8);
            a2.h.setVisibility(0);
            a2.f16718a.setVisibility(0);
            EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_FOLLOW_ROOM_SHOW, (String) null, yYChatRoomFollowedModel.uid, yYChatRoomFollowedModel.type_id, ChatRoomProtos.From.FOLLOW_ROOM_LIST_SECOND_PAGE);
        }
        if (yYChatRoomFollowedModel.isUpload) {
            return;
        }
        yYChatRoomFollowedModel.isUpload = true;
        EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_TAB_PAGE_ROOM_DRAW, yYChatRoomFollowedModel.room_id, yYChatRoomFollowedModel.uid, "-1", yYChatRoomFollowedModel.type_id, false, this.d, this.f16175c, yYChatRoomFollowedModel.label_link);
    }

    public final void a(boolean z) {
        this.e = z;
        notifyDataSetChanged();
    }

    public final Context getContext() {
        return this.f16174a;
    }

    public final String getType() {
        return this.d;
    }
}
