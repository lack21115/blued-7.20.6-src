package com.blued.android.module.yy_china.adapter;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.utils.ClickUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.module.common.utils.ImgURLMap;
import com.blued.android.module.common.utils.YyChatRoomTagShapeUtils;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.svgaplayer.SVGAPlayer;
import com.blued.android.module.yy_china.IYYRoomInfoCallback;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.ItemYyAdvertiseLayoutBinding;
import com.blued.android.module.yy_china.databinding.ItemYyPopularLayoutBinding;
import com.blued.android.module.yy_china.databinding.ItemYyRoomListNormalLayoutBinding;
import com.blued.android.module.yy_china.listener.OnCLickRoomItemToGoRoomListener;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYBannerModel;
import com.blued.android.module.yy_china.model.YYChatR_InnerModel;
import com.blued.android.module.yy_china.model.YYChatRoomModel;
import com.blued.android.module.yy_china.model.YYLastRoomModel;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.android.module.yy_china.view.ban.BGABanner;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/YYRoomListsAdapter.class */
public final class YYRoomListsAdapter extends BaseMultiItemQuickAdapter<YYChatRoomModel, BaseViewHolder> implements BGABanner.Adapter<View, Object> {
    private static final int k = 0;
    private YYRoomListPopularAdapter b;

    /* renamed from: c  reason: collision with root package name */
    private final ActivityFragmentActive f16232c;
    private final String d;
    private final String e;
    private final OnCLickRoomItemToGoRoomListener f;
    private boolean g;
    private YYLastRoomModel h;
    private int i;
    private boolean j;

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f16231a = new Companion(null);
    private static final int l = 1;
    private static final int m = 2;
    private static final int n = 3;
    private static final int o = -1;

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/YYRoomListsAdapter$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return YYRoomListsAdapter.k;
        }

        public final int b() {
            return YYRoomListsAdapter.o;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYRoomListsAdapter(ActivityFragmentActive fragmentActive, String tabId, String source, OnCLickRoomItemToGoRoomListener onCLickRoomItemToGoRoomListener) {
        super(new ArrayList());
        Intrinsics.e(fragmentActive, "fragmentActive");
        Intrinsics.e(tabId, "tabId");
        Intrinsics.e(source, "source");
        this.f16232c = fragmentActive;
        this.d = source;
        this.e = tabId;
        this.f = onCLickRoomItemToGoRoomListener;
        this.i = R.drawable.icon_yy_entertainment_create;
        addItemType(k, R.layout.item_yy_room_list_normal_layout);
        addItemType(l, R.layout.item_yy_popular_layout);
        addItemType(m, R.layout.item_yy_advertise_layout);
        addItemType(o, R.layout.item_yy_all_room_title_layout);
        this.j = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYRoomListsAdapter this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        if (ClickUtils.a(R.id.img_entertainment, 2000L)) {
            return;
        }
        if (YYRoomInfoManager.e().c().l()) {
            AppMethods.a((CharSequence) this$0.mContext.getString(R.string.yy_living_toast));
            return;
        }
        YYLastRoomModel yYLastRoomModel = this$0.h;
        if (yYLastRoomModel == null) {
            LiveEventBus.get("create_entertainment_room").post("");
            return;
        }
        OnCLickRoomItemToGoRoomListener onCLickRoomItemToGoRoomListener = this$0.f;
        if (onCLickRoomItemToGoRoomListener == null) {
            return;
        }
        onCLickRoomItemToGoRoomListener.a(yYLastRoomModel == null ? null : yYLastRoomModel.room_id, this$0.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYRoomListsAdapter this$0, YYChatR_InnerModel item, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(item, "$item");
        if (ClickUtils.a(R.id.rl_room_card, 2000L)) {
            return;
        }
        if (YYRoomInfoManager.e().c().l()) {
            AppMethods.a((CharSequence) this$0.mContext.getString(R.string.yy_living_toast));
            return;
        }
        EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_TAB_PAGE_ROOM_CLICK, item.room_id, item.uid, this$0.e, item.room_type_id, !StringUtils.b(item.the_same_city), "theme_room", this$0.d, item.label_link);
        OnCLickRoomItemToGoRoomListener onCLickRoomItemToGoRoomListener = this$0.f;
        if (onCLickRoomItemToGoRoomListener == null) {
            return;
        }
        onCLickRoomItemToGoRoomListener.a(item.room_id, this$0.d);
    }

    private final void a(BaseViewHolder baseViewHolder, YYChatR_InnerModel yYChatR_InnerModel) {
        ItemYyPopularLayoutBinding a2 = ItemYyPopularLayoutBinding.a(baseViewHolder.itemView);
        Intrinsics.c(a2, "bind(helper.itemView)");
        if (this.b == null) {
            a2.f16781c.setLayoutManager(new LinearLayoutManager(a2.f16781c.getContext()));
            this.b = new YYRoomListPopularAdapter(this.f16232c, this.e, this.d, this.f);
            a2.f16781c.setAdapter(this.b);
            a2.f16781c.setNestedScrollingEnabled(false);
        }
        if (this.g) {
            a2.f16780a.setImageResource(this.h == null ? R.drawable.icon_yy_entertainment_create : R.drawable.icon_yy_entertainment_reenter);
            a2.f16780a.setVisibility(0);
        } else {
            a2.f16780a.setVisibility(4);
        }
        a2.d.setText(yYChatR_InnerModel == null ? null : yYChatR_InnerModel.title);
        YYRoomListPopularAdapter yYRoomListPopularAdapter = this.b;
        if (yYRoomListPopularAdapter != null) {
            yYRoomListPopularAdapter.setNewData(yYChatR_InnerModel == null ? null : yYChatR_InnerModel.list);
        }
        a2.f16780a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.-$$Lambda$YYRoomListsAdapter$q0KHfsbGtGObwPdOf4LhjfNwObc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYRoomListsAdapter.a(YYRoomListsAdapter.this, view);
            }
        });
    }

    private final void a(BaseViewHolder baseViewHolder, final YYChatR_InnerModel yYChatR_InnerModel, int i) {
        ItemYyRoomListNormalLayoutBinding a2 = ItemYyRoomListNormalLayoutBinding.a(baseViewHolder.itemView);
        Intrinsics.c(a2, "bind(helper.itemView)");
        if (yYChatR_InnerModel.chat_anchor_level == null || yYChatR_InnerModel.chat_anchor_level.getLevel() <= 0) {
            a2.b.setVisibility(8);
        } else {
            a2.b.setImageResource(YYRoomInfoManager.e().b(yYChatR_InnerModel.chat_anchor_level.getLevel()));
            a2.b.setVisibility(0);
        }
        if (yYChatR_InnerModel.in_pk == 1) {
            a2.e.setVisibility(0);
        } else {
            a2.e.setVisibility(8);
        }
        a2.h.removeAllViews();
        if (StringUtils.b(yYChatR_InnerModel.label_link)) {
            a2.h.setVisibility(8);
            if (StringUtils.b(yYChatR_InnerModel.the_same_city)) {
                a2.k.setVisibility(8);
            } else {
                a2.k.setVisibility(0);
                a2.k.setText(yYChatR_InnerModel.the_same_city);
            }
        } else {
            a2.h.setVisibility(0);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, a2.h.getResources().getDimensionPixelOffset(R.dimen.dp_16));
            ImageView imageView = new ImageView(a2.h.getContext());
            a2.h.addView(imageView, layoutParams);
            if (this.j) {
                ImageLoader.a(this.f16232c, yYChatR_InnerModel.label_link).g().a(imageView);
            } else {
                ImageLoader.a(this.f16232c, yYChatR_InnerModel.label_link).a(imageView);
            }
            a2.k.setVisibility(8);
        }
        a2.g.setShapeModel(yYChatR_InnerModel.getRoomTagBack(a2.g.getContext(), i));
        ImageLoader.a(this.f16232c, yYChatR_InnerModel.user_avatar).b(R.drawable.user_bg_round).c().a(a2.d);
        a2.o.setText(yYChatR_InnerModel.user_name);
        TextView textView = a2.l;
        StringCompanionObject stringCompanionObject = StringCompanionObject.f42549a;
        String string = this.mContext.getResources().getString(R.string.yy_home_onlin_count);
        Intrinsics.c(string, "mContext.resources.getSt…ring.yy_home_onlin_count)");
        String format = String.format(string, Arrays.copyOf(new Object[]{yYChatR_InnerModel.room_member_count}, 1));
        Intrinsics.c(format, "format(format, *args)");
        textView.setText(format);
        a2.m.setText(yYChatR_InnerModel.room_name);
        View findViewById = baseViewHolder.itemView.findViewById(R.id.ll_type);
        if (findViewById == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.android.framework.view.shape.ShapeLinearLayout");
        }
        ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) findViewById;
        ShapeLinearLayout shapeLinearLayout2 = shapeLinearLayout;
        ShapeHelper.a(shapeLinearLayout2, shapeLinearLayout.getResources().getDimension(R.dimen.dp_8), shapeLinearLayout.getResources().getDimension(R.dimen.dp_8), shapeLinearLayout.getResources().getDimension(R.dimen.dp_8), shapeLinearLayout.getResources().getDimension(R.dimen.dp_8));
        YyChatRoomTagShapeUtils.f10915a.a(shapeLinearLayout2, yYChatR_InnerModel.room_type_id);
        a2.n.setText(yYChatR_InnerModel.room_type_name);
        a2.f.setMIsNeedOnDetachedFromWindow(true);
        SVGAPlayer.Builder builder = new SVGAPlayer.Builder(ImgURLMap.f10885a.a("yy_home_small_white"));
        SVGAImageView sVGAImageView = a2.f;
        Intrinsics.c(sVGAImageView, "bind.ivTypeAni");
        builder.a(sVGAImageView);
        if (yYChatR_InnerModel.is_hot == 1) {
            a2.f16811c.setVisibility(0);
        } else {
            a2.f16811c.setVisibility(8);
        }
        if (!yYChatR_InnerModel.isUpload) {
            yYChatR_InnerModel.isUpload = true;
            EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_TAB_PAGE_ROOM_DRAW, yYChatR_InnerModel.room_id, yYChatR_InnerModel.uid, this.e, yYChatR_InnerModel.room_type_id, !StringUtils.b(yYChatR_InnerModel.the_same_city), "theme_room", this.d, yYChatR_InnerModel.label_link);
            OnCLickRoomItemToGoRoomListener onCLickRoomItemToGoRoomListener = this.f;
            if (onCLickRoomItemToGoRoomListener != null) {
                onCLickRoomItemToGoRoomListener.p();
            }
        }
        a2.j.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.-$$Lambda$YYRoomListsAdapter$y9624w-FquYh8-8xwXI9cpo85XI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYRoomListsAdapter.a(YYRoomListsAdapter.this, yYChatR_InnerModel, view);
            }
        });
        a2.f16810a.setVisibility(TextUtils.equals(yYChatR_InnerModel.room_type_id, "11") ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(String str, YYBannerModel banner, ImageView imageView, View view) {
        Intrinsics.e(banner, "$banner");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        List<String> list = banner.click_url;
        if (list != null) {
            IYYRoomInfoCallback c2 = YYRoomInfoManager.e().c();
            Object[] array = list.toArray(new String[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
            c2.a((String[]) array);
        }
        EventTrackYY.b(ChatRoomProtos.Event.CHAT_ROOM_BANNER_CLICK, banner.ads_id);
        YYRoomInfoManager.e().c().a(imageView == null ? null : imageView.getContext(), str, 9);
    }

    private final void b(BaseViewHolder baseViewHolder) {
    }

    private final void b(BaseViewHolder baseViewHolder, YYChatR_InnerModel yYChatR_InnerModel) {
        ItemYyAdvertiseLayoutBinding a2 = ItemYyAdvertiseLayoutBinding.a(baseViewHolder.itemView);
        Intrinsics.c(a2, "bind(helper.itemView)");
        a2.f16675a.setAdapter(this);
        List<YYBannerModel> list = yYChatR_InnerModel.adv_list;
        Integer valueOf = list == null ? null : Integer.valueOf(list.size());
        Intrinsics.a(valueOf);
        if (valueOf.intValue() > 1) {
            a2.f16675a.setAutoPlayAble(true);
        } else {
            a2.f16675a.setAutoPlayAble(false);
        }
        a2.f16675a.setmIsNeedShowIndicator(false);
        a2.f16675a.a(R.layout.item_more_adpics, yYChatR_InnerModel.adv_list, (List<String>) null);
    }

    @Override // com.blued.android.module.yy_china.view.ban.BGABanner.Adapter
    public void a(BGABanner bGABanner, View view, Object obj, int i) {
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.yy_china.model.YYBannerModel");
        }
        final YYBannerModel yYBannerModel = (YYBannerModel) obj;
        final String str = yYBannerModel.target_url;
        List<String> list = yYBannerModel.show_url;
        ImageView imageView = view == null ? null : (ImageView) view.findViewById(R.id.img_ad);
        ImageView imageView2 = view == null ? null : (ImageView) view.findViewById(R.id.img_ad_icon);
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
        ImageLoader.a(this.f16232c, yYBannerModel.ads_pics).b(R.drawable.defaultpicture).a(imageView);
        if (!yYBannerModel.isShowUrlVisited && list != null) {
            IYYRoomInfoCallback c2 = YYRoomInfoManager.e().c();
            Object[] array = list.toArray(new String[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
            c2.a((String[]) array);
            yYBannerModel.isShowUrlVisited = true;
            EventTrackYY.b(ChatRoomProtos.Event.CHAT_ROOM_BANNER_SHOW, yYBannerModel.ads_id);
        }
        if (imageView == null) {
            return;
        }
        final ImageView imageView3 = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.-$$Lambda$YYRoomListsAdapter$rS71DIFflK-hus_p9fZf2815YVg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYRoomListsAdapter.a(String.this, yYBannerModel, imageView3, view2);
            }
        });
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
    public void convert(BaseViewHolder baseViewHolder, YYChatRoomModel yYChatRoomModel) {
        if (yYChatRoomModel == null) {
            return;
        }
        Integer valueOf = baseViewHolder == null ? null : Integer.valueOf(baseViewHolder.getItemViewType());
        int i = k;
        if (valueOf != null && valueOf.intValue() == i) {
            YYChatR_InnerModel yYChatR_InnerModel = yYChatRoomModel.data;
            Intrinsics.c(yYChatR_InnerModel, "it.data");
            a(baseViewHolder, yYChatR_InnerModel, getData().indexOf(yYChatRoomModel));
            return;
        }
        int i2 = l;
        if (valueOf != null && valueOf.intValue() == i2) {
            a(baseViewHolder, yYChatRoomModel.data);
            return;
        }
        int i3 = m;
        if (valueOf != null && valueOf.intValue() == i3) {
            YYChatR_InnerModel yYChatR_InnerModel2 = yYChatRoomModel.data;
            Intrinsics.c(yYChatR_InnerModel2, "it.data");
            b(baseViewHolder, yYChatR_InnerModel2);
            return;
        }
        int i4 = o;
        if (valueOf != null && valueOf.intValue() == i4) {
            b(baseViewHolder);
        }
    }

    public final void a(boolean z) {
        this.j = z;
        LogUtils.d(BaseMultiItemQuickAdapter.TAG, Intrinsics.a("setNeedAni: ", (Object) Boolean.valueOf(this.j)));
        notifyDataSetChanged();
        YYRoomListPopularAdapter yYRoomListPopularAdapter = this.b;
        if (yYRoomListPopularAdapter == null || yYRoomListPopularAdapter == null) {
            return;
        }
        yYRoomListPopularAdapter.a(z);
    }

    public final void a(boolean z, YYLastRoomModel yYLastRoomModel) {
        this.g = z;
        this.h = yYLastRoomModel;
    }
}
