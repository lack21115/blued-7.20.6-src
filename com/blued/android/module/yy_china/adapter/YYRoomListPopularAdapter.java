package com.blued.android.module.yy_china.adapter;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.ClickUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.module.common.utils.ImgURLMap;
import com.blued.android.module.common.utils.YyChatRoomTagShapeUtils;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.svgaplayer.SVGAPlayer;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.ItemYyNormalHotLayoutBinding;
import com.blued.android.module.yy_china.listener.OnCLickRoomItemToGoRoomListener;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYChatR_NormalModel;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/YYRoomListPopularAdapter.class */
public final class YYRoomListPopularAdapter extends BaseQuickAdapter<YYChatR_NormalModel, BaseViewHolder> {
    private final ActivityFragmentActive a;
    private final String b;
    private final String c;
    private final OnCLickRoomItemToGoRoomListener d;
    private boolean e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYRoomListPopularAdapter(ActivityFragmentActive fragmentActive, String tabId, String source, OnCLickRoomItemToGoRoomListener onCLickRoomItemToGoRoomListener) {
        super(R.layout.item_yy_normal_hot_layout, new ArrayList());
        Intrinsics.e(fragmentActive, "fragmentActive");
        Intrinsics.e(tabId, "tabId");
        Intrinsics.e(source, "source");
        this.a = fragmentActive;
        this.b = source;
        this.c = tabId;
        this.d = onCLickRoomItemToGoRoomListener;
        this.e = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYRoomListPopularAdapter this$0, YYChatR_NormalModel item, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(item, "$item");
        if (ClickUtils.a(R.id.rl_room_card, 2000L)) {
            return;
        }
        if (YYRoomInfoManager.e().c().l()) {
            AppMethods.a((CharSequence) this$0.mContext.getString(R.string.yy_living_toast));
            return;
        }
        EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_TAB_PAGE_ROOM_CLICK, item.room_id, item.uid, this$0.c, item.room_type_id, !StringUtils.b(item.the_same_city), "hot_room", this$0.b, item.label_link);
        OnCLickRoomItemToGoRoomListener onCLickRoomItemToGoRoomListener = this$0.d;
        if (onCLickRoomItemToGoRoomListener == null) {
            return;
        }
        onCLickRoomItemToGoRoomListener.a(item.room_id, this$0.b);
    }

    /* renamed from: a */
    public void onViewRecycled(BaseViewHolder holder) {
        Intrinsics.e(holder, "holder");
        super.onViewRecycled((RecyclerView.ViewHolder) holder);
        SVGAImageView sVGAImageView = (SVGAImageView) holder.itemView.findViewById(R.id.iv_type_ani);
        if (sVGAImageView == null) {
            return;
        }
        sVGAImageView.a(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(BaseViewHolder helper, final YYChatR_NormalModel item) {
        Intrinsics.e(helper, "helper");
        Intrinsics.e(item, "item");
        ItemYyNormalHotLayoutBinding a = ItemYyNormalHotLayoutBinding.a(helper.itemView);
        Intrinsics.c(a, "bind(helper.itemView)");
        int i = 8;
        a.g.setVisibility(8);
        if (item.chat_anchor_level == null || item.chat_anchor_level.getLevel() <= 0) {
            a.b.setVisibility(8);
        } else {
            a.g.setVisibility(0);
            a.b.setImageResource(YYRoomInfoManager.e().b(item.chat_anchor_level.getLevel()));
            a.b.setVisibility(0);
        }
        a.f.setShapeModel(item.getRoomTag(a.f.getContext(), getData().indexOf(item)));
        ImageLoader.a(this.a, item.user_avatar).b(R.drawable.user_bg_round).c().a(a.c);
        a.m.setText(item.room_name);
        TextView textView = a.l;
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        String string = this.mContext.getResources().getString(R.string.yy_home_onlin_count);
        Intrinsics.c(string, "mContext.resources.getSt…ring.yy_home_onlin_count)");
        String format = String.format(string, Arrays.copyOf(new Object[]{item.room_member_count}, 1));
        Intrinsics.c(format, "format(format, *args)");
        textView.setText(format);
        a.o.setText(item.user_name);
        View findViewById = helper.itemView.findViewById(R.id.ll_type);
        if (findViewById == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.android.framework.view.shape.ShapeLinearLayout");
        }
        ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) findViewById;
        ShapeLinearLayout shapeLinearLayout2 = shapeLinearLayout;
        ShapeHelper.a(shapeLinearLayout2, shapeLinearLayout.getResources().getDimension(R.dimen.dp_8), shapeLinearLayout.getResources().getDimension(R.dimen.dp_8), shapeLinearLayout.getResources().getDimension(R.dimen.dp_8), shapeLinearLayout.getResources().getDimension(R.dimen.dp_8));
        YyChatRoomTagShapeUtils.a.a(shapeLinearLayout2, item.room_type_id);
        a.n.setText(item.room_type_name);
        a.e.setMIsNeedOnDetachedFromWindow(true);
        SVGAPlayer.Builder builder = new SVGAPlayer.Builder(ImgURLMap.a.a(BluedSkinUtils.c() ? "yy_home_small_black" : "yy_home_small_white"));
        SVGAImageView sVGAImageView = a.e;
        Intrinsics.c(sVGAImageView, "bind.ivTypeAni");
        builder.a(sVGAImageView);
        if (item.in_pk == 1) {
            a.d.setVisibility(0);
        } else {
            a.d.setVisibility(8);
        }
        a.h.removeAllViews();
        if (StringUtils.b(item.label_link)) {
            a.h.setVisibility(8);
        } else {
            a.g.setVisibility(0);
            a.h.setVisibility(0);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, a.h.getResources().getDimensionPixelOffset(R.dimen.dp_16));
            ImageView imageView = new ImageView(a.h.getContext());
            a.h.addView(imageView, layoutParams);
            if (this.e) {
                ImageLoader.a(this.a, item.label_link).g().a(imageView);
            } else {
                ImageLoader.a(this.a, item.label_link).a(imageView);
            }
        }
        if (StringUtils.b(item.the_same_city)) {
            a.k.setVisibility(8);
        } else {
            a.g.setVisibility(0);
            a.k.setVisibility(0);
            a.k.setText(item.the_same_city);
        }
        if (!item.isUpload) {
            item.isUpload = true;
            EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_TAB_PAGE_ROOM_DRAW, item.room_id, item.uid, this.c, item.room_type_id, !StringUtils.b(item.the_same_city), "hot_room", this.b, item.label_link);
            OnCLickRoomItemToGoRoomListener onCLickRoomItemToGoRoomListener = this.d;
            if (onCLickRoomItemToGoRoomListener != null) {
                onCLickRoomItemToGoRoomListener.p();
            }
        }
        a.j.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.-$$Lambda$YYRoomListPopularAdapter$h8QJszV7Z-UZ7FZUUaUC50-e1Xc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYRoomListPopularAdapter.a(YYRoomListPopularAdapter.this, item, view);
            }
        });
        ShapeableImageView shapeableImageView = a.a;
        if (TextUtils.equals(item.room_type_id, "11")) {
            i = 0;
        }
        shapeableImageView.setVisibility(i);
    }

    public final void a(boolean z) {
        this.e = z;
        notifyDataSetChanged();
    }
}
