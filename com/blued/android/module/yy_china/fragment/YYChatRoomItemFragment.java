package com.blued.android.module.yy_china.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.ui.mvp.MvpUtils;
import com.blued.android.framework.utils.ClickUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.ImgURLMap;
import com.blued.android.module.common.utils.YyChatRoomTagShapeUtils;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.svgaplayer.SVGADrawable;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.svgaplayer.SVGAParser;
import com.blued.android.module.svgaplayer.SVGAPlayer;
import com.blued.android.module.svgaplayer.SVGAVideoEntity;
import com.blued.android.module.yy_china.IYYRoomInfoCallback;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.FragmentChatRoomItemBinding;
import com.blued.android.module.yy_china.databinding.ItemYyHomeChatsNewRoomsBinding;
import com.blued.android.module.yy_china.databinding.ItemYyHomeChatsNewRoomsItemBinding;
import com.blued.android.module.yy_china.databinding.ItemYyHomeRoomsAdBinding;
import com.blued.android.module.yy_china.databinding.ItemYyHomeRoomsBannerBinding;
import com.blued.android.module.yy_china.databinding.ItemYyHomeRoomsRoomBinding;
import com.blued.android.module.yy_china.fragment.YYChatRoomItemFragment;
import com.blued.android.module.yy_china.listener.OnCLickRoomItemToGoRoomListener;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYBannerModel;
import com.blued.android.module.yy_china.model.YYHomeChatsRightTopMode;
import com.blued.android.module.yy_china.model.YyHomeChatItemDataInfoMode;
import com.blued.android.module.yy_china.model.YyHomeChatItemDataMode;
import com.blued.android.module.yy_china.model.YyHomeChatItemRoomCradInfo;
import com.blued.android.module.yy_china.presenter.YYChatRoomItemPresenter;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.android.module.yy_china.view.YYSvgaView;
import com.blued.android.module.yy_china.view.ban.BGABanner;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYChatRoomItemFragment.class */
public final class YYChatRoomItemFragment extends MvpFragment<YYChatRoomItemPresenter> {
    private FragmentChatRoomItemBinding a;
    private OnCLickRoomItemToGoRoomListener b;
    private final AdHandler c = new AdHandler(this, this);
    private final Ad d = new Ad(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYChatRoomItemFragment$Ad.class */
    public final class Ad extends BaseMultiItemQuickAdapter<YyHomeChatItemDataMode, BaseViewHolder> implements BGABanner.Adapter<View, Object> {
        final /* synthetic */ YYChatRoomItemFragment a;
        private OnCLickRoomItemToGoRoomListener b;
        private String c;
        private String d;
        private boolean e;
        private int f;
        private final HashMap<YYHomeChatsRightTopMode, TextView> g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Ad(YYChatRoomItemFragment this$0) {
            super(new ArrayList());
            Intrinsics.e(this$0, "this$0");
            this.a = this$0;
            this.e = true;
            this.g = new HashMap<>();
            addItemType(0, R.layout.item_yy_home_rooms_room);
            addItemType(2, R.layout.item_yy_home_rooms_banner);
            addItemType(4, R.layout.item_yy_home_chats_new_rooms);
            addItemType(5, R.layout.item_yy_home_rooms_ad);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(Ad this$0, YyHomeChatItemDataInfoMode item, YYChatRoomItemFragment this$1, View view) {
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(item, "$item");
            Intrinsics.e(this$1, "this$1");
            if (ClickUtils.a(R.id.rl_room_card, 2000L)) {
                return;
            }
            if (YYRoomInfoManager.e().c().l()) {
                AppMethods.a((CharSequence) this$0.mContext.getString(R.string.yy_living_toast));
                return;
            }
            EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_TAB_PAGE_ROOM_CLICK, item.getRoom_id(), item.getUid(), this$0.d, item.getRoom_type_id(), !StringUtils.b(item.getThe_same_city()), "theme_room", this$0.c, item.getLabel_link());
            this$1.j().b(true);
            OnCLickRoomItemToGoRoomListener onCLickRoomItemToGoRoomListener = this$0.b;
            if (onCLickRoomItemToGoRoomListener == null) {
                return;
            }
            onCLickRoomItemToGoRoomListener.a(item.getRoom_id(), this$0.c);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(YYHomeChatsRightTopMode item, View view) {
            Intrinsics.e(item, "$item");
            YYRoomInfoManager.e().c().a(view.getContext(), item.getLink(), 0, true);
            EventTrackYY.b(ChatRoomProtos.Event.CHAT_ROOM_HOT_RESOURCE_CLICK, String.valueOf(item.getPosition()), item.getLink());
        }

        private final void a(String str, final SVGAImageView sVGAImageView) {
            String lowerCase = str.toLowerCase(Locale.ROOT);
            Intrinsics.c(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            if (StringsKt.b(lowerCase, "png", false, 2, (Object) null)) {
                ImageLoader.a(this.a.getFragmentActive(), str).d(R.drawable.bg_yy_home_top_2).f().a(sVGAImageView);
            } else {
                SVGAParser.a(SVGAParser.a.b(), new URL(str), new SVGAParser.ParseCompletion() { // from class: com.blued.android.module.yy_china.fragment.YYChatRoomItemFragment$Ad$playSvgaAnimation$1
                    @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
                    public void onComplete(SVGAVideoEntity videoItem) {
                        Intrinsics.e(videoItem, "videoItem");
                        SVGAImageView.this.setImageDrawable(new SVGADrawable(videoItem));
                        SVGAImageView.this.a();
                    }

                    @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
                    public void onError() {
                        SVGAImageView.this.setImageResource(R.drawable.bg_yy_home_top_2);
                    }
                }, (SVGAParser.PlayCallback) null, 4, (Object) null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(String str, YYBannerModel banner, ImageView imageView, View view) {
            Intrinsics.e(banner, "$banner");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            List<String> list = banner.click_url;
            if (list != null) {
                IYYRoomInfoCallback c = YYRoomInfoManager.e().c();
                Object[] array = list.toArray(new String[0]);
                if (array == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                }
                c.a((String[]) array);
            }
            EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_HOT_BANNER_CLICK, banner.ads_id, banner.target_url);
            YYRoomInfoManager.e().c().a(imageView.getContext(), str, 9);
        }

        private final void b() {
            ArrayList<String> sub_title;
            for (Map.Entry<YYHomeChatsRightTopMode, TextView> entry : this.g.entrySet()) {
                YYHomeChatsRightTopMode key = entry.getKey();
                if (key != null && (sub_title = key.getSub_title()) != null) {
                    if (sub_title.size() > 0) {
                        int i = this.f;
                        int size = sub_title.size();
                        TextView value = entry.getValue();
                        if (value != null) {
                            value.setText(sub_title.get(i % size));
                        }
                    } else {
                        TextView value2 = entry.getValue();
                        if (value2 != null) {
                            value2.setText("");
                        }
                    }
                }
            }
        }

        private final void b(BaseViewHolder baseViewHolder, YyHomeChatItemDataMode yyHomeChatItemDataMode) {
            ItemYyHomeRoomsRoomBinding a = ItemYyHomeRoomsRoomBinding.a(baseViewHolder.itemView);
            Intrinsics.c(a, "bind(helper.itemView)");
            final YyHomeChatItemDataInfoMode data = yyHomeChatItemDataMode.getData();
            if (data == null) {
                return;
            }
            int i = 8;
            if (data.getChat_anchor_level() == null || data.getChat_anchor_level().getLevel() <= 0) {
                a.c.setVisibility(8);
            } else {
                a.c.setImageResource(YYRoomInfoManager.e().b(data.getChat_anchor_level().getLevel()));
                a.c.setVisibility(0);
            }
            if (data.getIn_pk() == 1) {
                a.e.setVisibility(0);
            } else {
                a.e.setVisibility(8);
            }
            a.i.removeAllViews();
            if (StringUtils.b(data.getThe_same_city())) {
                a.d.setVisibility(8);
                a.m.setVisibility(8);
            } else {
                a.m.setVisibility(0);
                a.d.setVisibility(0);
                a.m.setText(data.getThe_same_city());
            }
            if (StringUtils.b(data.getLabel_link())) {
                a.i.setVisibility(8);
            } else {
                a.i.setVisibility(0);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, a.i.getResources().getDimensionPixelOffset(R.dimen.dp_16));
                ImageView imageView = new ImageView(a.i.getContext());
                a.i.addView(imageView, layoutParams);
                if (this.e) {
                    ImageLoader.a(this.a.getFragmentActive(), data.getLabel_link()).g().a(imageView);
                } else {
                    ImageLoader.a(this.a.getFragmentActive(), data.getLabel_link()).a(imageView);
                }
            }
            if (BluedSkinUtils.c()) {
                a.a.setBackgroundResource(R.color.white);
            } else {
                a.a.setBackgroundResource(R.color.ksad_white_alpha_20);
            }
            ImageLoader.a(this.a.getFragmentActive(), data.getUser_avatar()).b(R.drawable.user_bg_round).c().a((ImageView) a.g);
            a.q.setText(data.getUser_name());
            TextView textView = a.p;
            StringCompanionObject stringCompanionObject = StringCompanionObject.a;
            String string = this.mContext.getResources().getString(R.string.yy_home_onlin_count);
            Intrinsics.c(string, "mContext.resources.getSt…ring.yy_home_onlin_count)");
            String format = String.format(string, Arrays.copyOf(new Object[]{data.getRoom_member_count()}, 1));
            Intrinsics.c(format, "format(format, *args)");
            textView.setText(format);
            a.n.setText(data.getRoom_name());
            View findViewById = baseViewHolder.itemView.findViewById(R.id.ll_room_type);
            if (findViewById == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.blued.android.framework.view.shape.ShapeLinearLayout");
            }
            ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) findViewById;
            ShapeLinearLayout shapeLinearLayout2 = shapeLinearLayout;
            ShapeHelper.a(shapeLinearLayout2, shapeLinearLayout.getResources().getDimension(R.dimen.dp_8), shapeLinearLayout.getResources().getDimension(R.dimen.dp_8), shapeLinearLayout.getResources().getDimension(R.dimen.dp_8), shapeLinearLayout.getResources().getDimension(R.dimen.dp_8));
            YyChatRoomTagShapeUtils.a.a(shapeLinearLayout2, data.getRoom_type_id());
            YyChatRoomTagShapeUtils yyChatRoomTagShapeUtils = YyChatRoomTagShapeUtils.a;
            ShapeTextView shapeTextView = a.l;
            Intrinsics.c(shapeTextView, "bind.tvBgTop");
            yyChatRoomTagShapeUtils.b(shapeTextView, data.getRoom_type_id());
            a.o.setText(data.getRoom_type_name());
            a.f.setMIsNeedOnDetachedFromWindow(true);
            SVGAPlayer.Builder builder = new SVGAPlayer.Builder(ImgURLMap.a.a("yy_home_small_white"));
            SVGAImageView sVGAImageView = a.f;
            Intrinsics.c(sVGAImageView, "bind.ivRoomTypeAni");
            builder.a(sVGAImageView);
            YyHomeChatItemRoomCradInfo room_card = data.getProp_info().getRoom_card();
            if (!StringUtils.b(room_card.getImg())) {
                String img = room_card.getImg();
                YYSvgaView yYSvgaView = a.k;
                Intrinsics.c(yYSvgaView, "bind.svga");
                a(img, yYSvgaView);
            }
            if (!data.isDraw()) {
                data.setDraw(true);
                EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_TAB_PAGE_ROOM_DRAW, data.getRoom_id(), data.getUid(), this.d, data.getRoom_type_id(), !StringUtils.b(data.getThe_same_city()), "theme_room", this.c, data.getLabel_link());
                OnCLickRoomItemToGoRoomListener onCLickRoomItemToGoRoomListener = this.b;
                if (onCLickRoomItemToGoRoomListener != null) {
                    onCLickRoomItemToGoRoomListener.p();
                }
            }
            CardView cardView = a.j;
            final YYChatRoomItemFragment yYChatRoomItemFragment = this.a;
            cardView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYChatRoomItemFragment$Ad$6TEMR-yUD2ZMoyW2t61_AevJa60
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYChatRoomItemFragment.Ad.a(YYChatRoomItemFragment.Ad.this, data, yYChatRoomItemFragment, view);
                }
            });
            ShapeableImageView shapeableImageView = a.b;
            if (TextUtils.equals(data.getRoom_type_id(), "11")) {
                i = 0;
            }
            shapeableImageView.setVisibility(i);
        }

        private final void c(BaseViewHolder baseViewHolder, YyHomeChatItemDataMode yyHomeChatItemDataMode) {
            ItemYyHomeChatsNewRoomsBinding a = ItemYyHomeChatsNewRoomsBinding.a(baseViewHolder.itemView);
            Intrinsics.c(a, "bind(helper.itemView)");
            RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(a.getRoot().getContext());
            linearLayoutManager.setOrientation(0);
            a.a.setLayoutManager(linearLayoutManager);
            if (BluedSkinUtils.c()) {
                a.b.setTextColor(a.b.getResources().getColor(R.color.syc_dark_222));
            } else {
                a.b.setTextColor(a.b.getResources().getColor(R.color.white));
            }
            RecyclerView.Adapter newRoomAdapter = new NewRoomAdapter(this.a);
            newRoomAdapter.a(this.b);
            newRoomAdapter.a(this.c);
            a.a.setAdapter(newRoomAdapter);
            if (yyHomeChatItemDataMode.getData().getLists().size() == 0) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (YyHomeChatItemDataInfoMode yyHomeChatItemDataInfoMode : yyHomeChatItemDataMode.getData().getLists()) {
                arrayList.add(new YyHomeChatItemDataMode(1, yyHomeChatItemDataInfoMode));
            }
            newRoomAdapter.setNewData(arrayList);
        }

        private final void d(BaseViewHolder baseViewHolder, YyHomeChatItemDataMode yyHomeChatItemDataMode) {
            ItemYyHomeRoomsBannerBinding a = ItemYyHomeRoomsBannerBinding.a(baseViewHolder.itemView);
            Intrinsics.c(a, "bind(helper.itemView)");
            ArrayList<YYBannerModel> adv_list = yyHomeChatItemDataMode.getData().getAdv_list();
            a.a.setAdapter(this);
            if (adv_list.size() > 1) {
                a.a.setAutoPlayAble(true);
            } else {
                a.a.setAutoPlayAble(false);
            }
            a.a.setmIsNeedShowIndicator(false);
            a.a.a(R.layout.item_home_more_adpics, adv_list, (List<String>) null);
        }

        private final void e(BaseViewHolder baseViewHolder, YyHomeChatItemDataMode yyHomeChatItemDataMode) {
            ItemYyHomeRoomsAdBinding a = ItemYyHomeRoomsAdBinding.a(baseViewHolder.itemView);
            Intrinsics.c(a, "bind(helper.itemView)");
            if (yyHomeChatItemDataMode.getData().getConfig() == null || yyHomeChatItemDataMode.getData().getConfig().size() == 0) {
                return;
            }
            YyHomeChatItemDataInfoMode data = yyHomeChatItemDataMode.getData();
            YYHomeChatsRightTopMode yYHomeChatsRightTopMode = (data == null ? null : data.getConfig()).get(0);
            Intrinsics.c(yYHomeChatsRightTopMode, "da.data?.config[0]");
            final YYHomeChatsRightTopMode yYHomeChatsRightTopMode2 = yYHomeChatsRightTopMode;
            if (!yYHomeChatsRightTopMode2.isDrwa()) {
                yYHomeChatsRightTopMode2.setDrwa(true);
                EventTrackYY.b(ChatRoomProtos.Event.CHAT_ROOM_HOT_RESOURCE_SHOW, String.valueOf(yYHomeChatsRightTopMode2.getPosition()), yYHomeChatsRightTopMode2.getLink());
            }
            baseViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYChatRoomItemFragment$Ad$O9oTb_NyngmSnTAMgS3DkQiv6do
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYChatRoomItemFragment.Ad.a(YYHomeChatsRightTopMode.this, view);
                }
            });
            a.b.setText(yYHomeChatsRightTopMode2.getTitle());
            this.g.put(yYHomeChatsRightTopMode2, a.c);
            ArrayList<String> sub_title = yYHomeChatsRightTopMode2.getSub_title();
            if (sub_title.size() > 0) {
                a.c.setText(sub_title.get(this.f % sub_title.size()));
            } else {
                a.c.setText("");
            }
            String background_image = yYHomeChatsRightTopMode2.getBackground_image();
            YYSvgaView yYSvgaView = a.a;
            Intrinsics.c(yYSvgaView, "bind.svga");
            a(background_image, yYSvgaView);
        }

        public final int a(int i) {
            int itemViewType = getItemViewType(i);
            return (itemViewType == 0 || itemViewType == 5) ? 1 : 2;
        }

        public final void a() {
            b();
            this.f++;
        }

        public final void a(OnCLickRoomItemToGoRoomListener onCLickRoomItemToGoRoomListener) {
            this.b = onCLickRoomItemToGoRoomListener;
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
            ImageLoader.a(this.a.getFragmentActive(), yYBannerModel.ads_pics).b(R.drawable.defaultpicture).a(imageView);
            if (!yYBannerModel.isShowUrlVisited && list != null) {
                IYYRoomInfoCallback c = YYRoomInfoManager.e().c();
                Object[] array = list.toArray(new String[0]);
                if (array == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                }
                c.a((String[]) array);
                yYBannerModel.isShowUrlVisited = true;
                EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_HOT_BANNER_SHOW, yYBannerModel.ads_id, yYBannerModel.target_url);
            }
            if (imageView == null) {
                return;
            }
            final ImageView imageView3 = imageView;
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYChatRoomItemFragment$Ad$4s-L5mR2la4m5XVXB31p3OhNSJc
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    YYChatRoomItemFragment.Ad.a(String.this, yYBannerModel, imageView3, view2);
                }
            });
        }

        /* renamed from: a */
        public void onViewRecycled(BaseViewHolder holder) {
            Intrinsics.e(holder, "holder");
            super.onViewRecycled((RecyclerView.ViewHolder) holder);
            YYSvgaView yYSvgaView = (YYSvgaView) holder.itemView.findViewById(R.id.svga);
            if (yYSvgaView != null) {
                yYSvgaView.a(true);
                yYSvgaView.b();
            }
            SVGAImageView sVGAImageView = (SVGAImageView) holder.itemView.findViewById(R.id.iv_room_type_ani);
            if (sVGAImageView == null) {
                return;
            }
            sVGAImageView.a(true);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void convert(BaseViewHolder helper, YyHomeChatItemDataMode item) {
            Intrinsics.e(helper, "helper");
            Intrinsics.e(item, "item");
            int itemType = item.getItemType();
            if (itemType == 0) {
                b(helper, item);
            } else if (itemType == 2) {
                d(helper, item);
            } else if (itemType == 4) {
                c(helper, item);
            } else if (itemType != 5) {
            } else {
                e(helper, item);
            }
        }

        public final void a(String str) {
            this.c = str;
        }

        public final void a(boolean z) {
            this.e = z;
            notifyDataSetChanged();
        }

        public final void b(String str) {
            this.d = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYChatRoomItemFragment$AdHandler.class */
    public final class AdHandler extends Handler {
        final /* synthetic */ YYChatRoomItemFragment a;
        private final WeakReference<YYChatRoomItemFragment> b;

        public AdHandler(YYChatRoomItemFragment this$0, YYChatRoomItemFragment yYChatRoomItemFragment) {
            Intrinsics.e(this$0, "this$0");
            this.a = this$0;
            this.b = new WeakReference<>(yYChatRoomItemFragment);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            Ad ad;
            Intrinsics.e(msg, "msg");
            super.handleMessage(msg);
            if (this.b.get() == null) {
                removeMessages(msg.what);
            } else if (msg.what == 1) {
                removeMessages(1);
                YYChatRoomItemFragment yYChatRoomItemFragment = this.b.get();
                if (yYChatRoomItemFragment == null || yYChatRoomItemFragment.getFragmentActive() == null) {
                    return;
                }
                YYChatRoomItemFragment yYChatRoomItemFragment2 = this.b.get();
                if (yYChatRoomItemFragment2 != null && (ad = yYChatRoomItemFragment2.d) != null) {
                    ad.a();
                }
                Message obtain = Message.obtain();
                obtain.what = 1;
                obtain.arg1 = msg.arg1;
                sendMessageDelayed(obtain, msg.arg1 * 1000);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYChatRoomItemFragment$NewRoomAdapter.class */
    public final class NewRoomAdapter extends BaseMultiItemQuickAdapter<YyHomeChatItemDataMode, BaseViewHolder> {
        final /* synthetic */ YYChatRoomItemFragment a;
        private OnCLickRoomItemToGoRoomListener b;
        private String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NewRoomAdapter(YYChatRoomItemFragment this$0) {
            super(new ArrayList());
            Intrinsics.e(this$0, "this$0");
            this.a = this$0;
            addItemType(1, R.layout.item_yy_home_chats_new_rooms_item);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(NewRoomAdapter this$0, YyHomeChatItemDataInfoMode item, YYChatRoomItemFragment this$1, View view) {
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(item, "$item");
            Intrinsics.e(this$1, "this$1");
            if (ClickUtils.a(R.id.iv, 2000L)) {
                return;
            }
            if (YYRoomInfoManager.e().c().l()) {
                AppMethods.a((CharSequence) this$0.mContext.getString(R.string.yy_living_toast));
                return;
            }
            this$1.j().b(true);
            OnCLickRoomItemToGoRoomListener onCLickRoomItemToGoRoomListener = this$0.b;
            if (onCLickRoomItemToGoRoomListener != null) {
                onCLickRoomItemToGoRoomListener.a(item.getRoom_id(), "hall_new_anchor");
            }
            EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_TAB_PAGE_ROOM_CLICK, item.getRoom_id(), item.getUid(), "0", item.getRoom_type_id(), !StringUtils.b(item.getThe_same_city()), "theme_room", "new_anchor", item.getLabel_link());
        }

        private final void b(BaseViewHolder baseViewHolder, YyHomeChatItemDataMode yyHomeChatItemDataMode) {
            ItemYyHomeChatsNewRoomsItemBinding a = ItemYyHomeChatsNewRoomsItemBinding.a(baseViewHolder.itemView);
            Intrinsics.c(a, "bind(helper.itemView)");
            if (yyHomeChatItemDataMode.getData() == null) {
                return;
            }
            final YyHomeChatItemDataInfoMode data = yyHomeChatItemDataMode.getData();
            if (!data.isDraw()) {
                EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_TAB_PAGE_ROOM_DRAW, data.getRoom_id(), data.getUid(), "0", data.getRoom_type_id(), !StringUtils.b(data.getThe_same_city()), "theme_room", "new_anchor", data.getLabel_link());
                data.setDraw(true);
            }
            ImageLoader.a(this.a.getFragmentActive(), data.getUser_avatar()).b(R.drawable.user_bg_round).c().a(a.a);
            ImageView imageView = a.a;
            final YYChatRoomItemFragment yYChatRoomItemFragment = this.a;
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYChatRoomItemFragment$NewRoomAdapter$mMDr0d9IN6cRptN_sbTLstxg1EM
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYChatRoomItemFragment.NewRoomAdapter.a(YYChatRoomItemFragment.NewRoomAdapter.this, data, yYChatRoomItemFragment, view);
                }
            });
        }

        public final void a(OnCLickRoomItemToGoRoomListener onCLickRoomItemToGoRoomListener) {
            this.b = onCLickRoomItemToGoRoomListener;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void convert(BaseViewHolder helper, YyHomeChatItemDataMode item) {
            Intrinsics.e(helper, "helper");
            Intrinsics.e(item, "item");
            if (item.getItemType() == 1) {
                b(helper, item);
            }
        }

        public final void a(String str) {
            this.c = str;
        }
    }

    private final void b(boolean z) {
        NoDataAndLoadFailView noDataAndLoadFailView;
        NoDataAndLoadFailView noDataAndLoadFailView2;
        NoDataAndLoadFailView noDataAndLoadFailView3;
        SmartRefreshLayout smartRefreshLayout;
        SmartRefreshLayout smartRefreshLayout2;
        FragmentChatRoomItemBinding fragmentChatRoomItemBinding = this.a;
        if (fragmentChatRoomItemBinding != null && (smartRefreshLayout2 = fragmentChatRoomItemBinding.c) != null) {
            smartRefreshLayout2.g();
        }
        FragmentChatRoomItemBinding fragmentChatRoomItemBinding2 = this.a;
        if (fragmentChatRoomItemBinding2 != null && (smartRefreshLayout = fragmentChatRoomItemBinding2.c) != null) {
            smartRefreshLayout.h();
        }
        if (this.d.getData().size() > 0) {
            FragmentChatRoomItemBinding fragmentChatRoomItemBinding3 = this.a;
            if (fragmentChatRoomItemBinding3 == null || (noDataAndLoadFailView = fragmentChatRoomItemBinding3.a) == null) {
                return;
            }
            noDataAndLoadFailView.d();
        } else if (z) {
            FragmentChatRoomItemBinding fragmentChatRoomItemBinding4 = this.a;
            if (fragmentChatRoomItemBinding4 == null || (noDataAndLoadFailView3 = fragmentChatRoomItemBinding4.a) == null) {
                return;
            }
            noDataAndLoadFailView3.a();
        } else {
            FragmentChatRoomItemBinding fragmentChatRoomItemBinding5 = this.a;
            if (fragmentChatRoomItemBinding5 == null || (noDataAndLoadFailView2 = fragmentChatRoomItemBinding5.a) == null) {
                return;
            }
            noDataAndLoadFailView2.b();
        }
    }

    private final void c() {
        NoDataAndLoadFailView noDataAndLoadFailView;
        NoDataAndLoadFailView noDataAndLoadFailView2;
        this.d.a(this.b);
        this.d.a(j().o());
        this.d.b(j().p());
        FragmentChatRoomItemBinding a = FragmentChatRoomItemBinding.a(this.i);
        this.a = a;
        if (a != null && (noDataAndLoadFailView2 = a.a) != null) {
            noDataAndLoadFailView2.setNoDataStr(R.string.yy_no_data_room);
        }
        FragmentChatRoomItemBinding fragmentChatRoomItemBinding = this.a;
        if (fragmentChatRoomItemBinding != null && (noDataAndLoadFailView = fragmentChatRoomItemBinding.a) != null) {
            noDataAndLoadFailView.setNoDataImg(R.drawable.icon_no_live_posted);
        }
        d();
    }

    private final void d() {
        SmartRefreshLayout smartRefreshLayout;
        RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2, 1, false);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.blued.android.module.yy_china.fragment.YYChatRoomItemFragment$initRecyclerView$1
            public int getSpanSize(int i) {
                return YYChatRoomItemFragment.this.d.a(i);
            }
        });
        FragmentChatRoomItemBinding fragmentChatRoomItemBinding = this.a;
        RecyclerView recyclerView = fragmentChatRoomItemBinding == null ? null : fragmentChatRoomItemBinding.b;
        if (recyclerView != null) {
            recyclerView.setAdapter(this.d);
        }
        FragmentChatRoomItemBinding fragmentChatRoomItemBinding2 = this.a;
        RecyclerView recyclerView2 = fragmentChatRoomItemBinding2 == null ? null : fragmentChatRoomItemBinding2.b;
        if (recyclerView2 != null) {
            recyclerView2.setLayoutManager(gridLayoutManager);
        }
        FragmentChatRoomItemBinding fragmentChatRoomItemBinding3 = this.a;
        if (fragmentChatRoomItemBinding3 == null || (smartRefreshLayout = fragmentChatRoomItemBinding3.c) == null) {
            return;
        }
        smartRefreshLayout.a(new OnRefreshLoadMoreListener() { // from class: com.blued.android.module.yy_china.fragment.YYChatRoomItemFragment$initRecyclerView$2
            public void onLoadMore(RefreshLayout refreshLayout) {
                Intrinsics.e(refreshLayout, "refreshLayout");
                YYChatRoomItemFragment.this.j().f();
            }

            public void onRefresh(RefreshLayout refreshLayout) {
                Intrinsics.e(refreshLayout, "refreshLayout");
                YYChatRoomItemFragment.this.j().e();
                OnCLickRoomItemToGoRoomListener b = YYChatRoomItemFragment.this.b();
                if (b == null) {
                    return;
                }
                b.r();
            }
        });
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        c();
    }

    public final void a(OnCLickRoomItemToGoRoomListener onCLickRoomItemToGoRoomListener) {
        this.b = onCLickRoomItemToGoRoomListener;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void a(String str, List<?> list) {
        super.a(str, list);
        if (Intrinsics.a((Object) str, (Object) j().m())) {
            MvpUtils.a(list, YyHomeChatItemDataMode.class, new MvpUtils.DataListHandler<YyHomeChatItemDataMode>() { // from class: com.blued.android.module.yy_china.fragment.YYChatRoomItemFragment$showDataToUI$1
                @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataListHandler
                public void a() {
                    YYChatRoomItemFragment.this.d.setNewData(new ArrayList());
                }

                @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataListHandler
                public void a(List<YyHomeChatItemDataMode> list2) {
                    YYChatRoomItemFragment.AdHandler adHandler;
                    Intrinsics.e(list2, "list");
                    YYChatRoomItemFragment.this.d.setNewData(list2);
                    for (YyHomeChatItemDataMode yyHomeChatItemDataMode : list2) {
                        if (yyHomeChatItemDataMode.getItemType() == 5) {
                            YyHomeChatItemDataInfoMode data = yyHomeChatItemDataMode.getData();
                            if ((data == null ? null : data.getConfig()) != null && !yyHomeChatItemDataMode.getData().getConfig().isEmpty()) {
                                Message obtain = Message.obtain();
                                obtain.what = 1;
                                obtain.arg1 = yyHomeChatItemDataMode.getData().getConfig().get(0).getFrequency_seconds();
                                adHandler = YYChatRoomItemFragment.this.c;
                                adHandler.sendMessageDelayed(obtain, yyHomeChatItemDataMode.getData().getConfig().get(0).getFrequency_seconds() * 1000);
                            }
                        }
                    }
                }
            });
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void a(String str, boolean z) {
        super.a(str, z);
        if (str == null) {
            return;
        }
        if (Intrinsics.a((Object) str, (Object) "_load_type_refresh_") ? true : Intrinsics.a((Object) str, (Object) "_load_type_loadmore_")) {
            b(z);
        }
    }

    public final OnCLickRoomItemToGoRoomListener b() {
        return this.b;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.fragment_chat_room_item;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void g_(String str) {
        super.g_(str);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void l() {
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void o() {
        SmartRefreshLayout smartRefreshLayout;
        super.o();
        FragmentChatRoomItemBinding fragmentChatRoomItemBinding = this.a;
        if (fragmentChatRoomItemBinding == null || (smartRefreshLayout = fragmentChatRoomItemBinding.c) == null) {
            return;
        }
        smartRefreshLayout.b(true);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment
    public void onDestroy() {
        super.onDestroy();
        this.c.removeCallbacksAndMessages(null);
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onPause() {
        super.onPause();
        this.d.a(false);
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onResume() {
        SmartRefreshLayout smartRefreshLayout;
        super.onResume();
        this.d.a(true);
        if (j().r()) {
            j().b(false);
            FragmentChatRoomItemBinding fragmentChatRoomItemBinding = this.a;
            if (fragmentChatRoomItemBinding == null || (smartRefreshLayout = fragmentChatRoomItemBinding.c) == null) {
                return;
            }
            smartRefreshLayout.i();
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void p() {
        SmartRefreshLayout smartRefreshLayout;
        super.p();
        FragmentChatRoomItemBinding fragmentChatRoomItemBinding = this.a;
        if (fragmentChatRoomItemBinding == null || (smartRefreshLayout = fragmentChatRoomItemBinding.c) == null) {
            return;
        }
        smartRefreshLayout.b(false);
    }
}
