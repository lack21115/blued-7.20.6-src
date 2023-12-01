package com.blued.android.module.yy_china.adapter;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
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

    /* renamed from: a  reason: collision with root package name */
    private final ActivityFragmentActive f16229a;
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final String f16230c;
    private final OnCLickRoomItemToGoRoomListener d;
    private boolean e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYRoomListPopularAdapter(ActivityFragmentActive fragmentActive, String tabId, String source, OnCLickRoomItemToGoRoomListener onCLickRoomItemToGoRoomListener) {
        super(R.layout.item_yy_normal_hot_layout, new ArrayList());
        Intrinsics.e(fragmentActive, "fragmentActive");
        Intrinsics.e(tabId, "tabId");
        Intrinsics.e(source, "source");
        this.f16229a = fragmentActive;
        this.b = source;
        this.f16230c = tabId;
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
        EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_TAB_PAGE_ROOM_CLICK, item.room_id, item.uid, this$0.f16230c, item.room_type_id, !StringUtils.b(item.the_same_city), "hot_room", this$0.b, item.label_link);
        OnCLickRoomItemToGoRoomListener onCLickRoomItemToGoRoomListener = this$0.d;
        if (onCLickRoomItemToGoRoomListener == null) {
            return;
        }
        onCLickRoomItemToGoRoomListener.a(item.room_id, this$0.b);
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
    public void convert(BaseViewHolder helper, final YYChatR_NormalModel item) {
        Intrinsics.e(helper, "helper");
        Intrinsics.e(item, "item");
        ItemYyNormalHotLayoutBinding a2 = ItemYyNormalHotLayoutBinding.a(helper.itemView);
        Intrinsics.c(a2, "bind(helper.itemView)");
        int i = 8;
        a2.g.setVisibility(8);
        if (item.chat_anchor_level == null || item.chat_anchor_level.getLevel() <= 0) {
            a2.b.setVisibility(8);
        } else {
            a2.g.setVisibility(0);
            a2.b.setImageResource(YYRoomInfoManager.e().b(item.chat_anchor_level.getLevel()));
            a2.b.setVisibility(0);
        }
        a2.f.setShapeModel(item.getRoomTag(a2.f.getContext(), getData().indexOf(item)));
        ImageLoader.a(this.f16229a, item.user_avatar).b(R.drawable.user_bg_round).c().a(a2.f16770c);
        a2.m.setText(item.room_name);
        TextView textView = a2.l;
        StringCompanionObject stringCompanionObject = StringCompanionObject.f42549a;
        String string = this.mContext.getResources().getString(R.string.yy_home_onlin_count);
        Intrinsics.c(string, "mContext.resources.getSt…ring.yy_home_onlin_count)");
        String format = String.format(string, Arrays.copyOf(new Object[]{item.room_member_count}, 1));
        Intrinsics.c(format, "format(format, *args)");
        textView.setText(format);
        a2.o.setText(item.user_name);
        View findViewById = helper.itemView.findViewById(R.id.ll_type);
        if (findViewById == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.android.framework.view.shape.ShapeLinearLayout");
        }
        ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) findViewById;
        ShapeLinearLayout shapeLinearLayout2 = shapeLinearLayout;
        ShapeHelper.a(shapeLinearLayout2, shapeLinearLayout.getResources().getDimension(R.dimen.dp_8), shapeLinearLayout.getResources().getDimension(R.dimen.dp_8), shapeLinearLayout.getResources().getDimension(R.dimen.dp_8), shapeLinearLayout.getResources().getDimension(R.dimen.dp_8));
        YyChatRoomTagShapeUtils.f10915a.a(shapeLinearLayout2, item.room_type_id);
        a2.n.setText(item.room_type_name);
        a2.e.setMIsNeedOnDetachedFromWindow(true);
        SVGAPlayer.Builder builder = new SVGAPlayer.Builder(ImgURLMap.f10885a.a(BluedSkinUtils.c() ? "yy_home_small_black" : "yy_home_small_white"));
        SVGAImageView sVGAImageView = a2.e;
        Intrinsics.c(sVGAImageView, "bind.ivTypeAni");
        builder.a(sVGAImageView);
        if (item.in_pk == 1) {
            a2.d.setVisibility(0);
        } else {
            a2.d.setVisibility(8);
        }
        a2.h.removeAllViews();
        if (StringUtils.b(item.label_link)) {
            a2.h.setVisibility(8);
        } else {
            a2.g.setVisibility(0);
            a2.h.setVisibility(0);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, a2.h.getResources().getDimensionPixelOffset(R.dimen.dp_16));
            ImageView imageView = new ImageView(a2.h.getContext());
            a2.h.addView(imageView, layoutParams);
            if (this.e) {
                ImageLoader.a(this.f16229a, item.label_link).g().a(imageView);
            } else {
                ImageLoader.a(this.f16229a, item.label_link).a(imageView);
            }
        }
        if (StringUtils.b(item.the_same_city)) {
            a2.k.setVisibility(8);
        } else {
            a2.g.setVisibility(0);
            a2.k.setVisibility(0);
            a2.k.setText(item.the_same_city);
        }
        if (!item.isUpload) {
            item.isUpload = true;
            EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_TAB_PAGE_ROOM_DRAW, item.room_id, item.uid, this.f16230c, item.room_type_id, !StringUtils.b(item.the_same_city), "hot_room", this.b, item.label_link);
            OnCLickRoomItemToGoRoomListener onCLickRoomItemToGoRoomListener = this.d;
            if (onCLickRoomItemToGoRoomListener != null) {
                onCLickRoomItemToGoRoomListener.p();
            }
        }
        a2.j.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.-$$Lambda$YYRoomListPopularAdapter$h8QJszV7Z-UZ7FZUUaUC50-e1Xc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYRoomListPopularAdapter.a(YYRoomListPopularAdapter.this, item, view);
            }
        });
        ShapeableImageView shapeableImageView = a2.f16769a;
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
