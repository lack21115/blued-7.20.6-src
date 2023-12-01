package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.DialogGiftWallAboutBinding;
import com.blued.android.module.yy_china.databinding.ItemGiftwallInfoAboutBinding;
import com.blued.android.module.yy_china.databinding.ItemGiftwallInfoAboutNoBinding;
import com.blued.android.module.yy_china.databinding.ItemGiftwallInfoAboutTitleBinding;
import com.blued.android.module.yy_china.fragment.BaseFullScreenDialog;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.GiftWallInfoAboutModel;
import com.blued.android.module.yy_china.model.YYCollectorConfigMode;
import com.blued.android.module.yy_china.model.YYGoodsWallListMode;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYUserInfo;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.android.module.yy_china.view.YYGiftWallListAndInfoAboutDialog;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYGiftWallListAndInfoAboutDialog.class */
public final class YYGiftWallListAndInfoAboutDialog extends BaseFullScreenDialog {

    /* renamed from: a  reason: collision with root package name */
    private DialogGiftWallAboutBinding f18204a;
    private final Ada b = new Ada(this);

    /* renamed from: c  reason: collision with root package name */
    private YYUserInfo f18205c;
    private YYGoodsWallListMode d;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYGiftWallListAndInfoAboutDialog$Ada.class */
    public final class Ada extends BaseMultiItemQuickAdapter<GiftWallInfoAboutModel, BaseViewHolder> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ YYGiftWallListAndInfoAboutDialog f18206a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Ada(YYGiftWallListAndInfoAboutDialog this$0) {
            super(new ArrayList());
            Intrinsics.e(this$0, "this$0");
            this.f18206a = this$0;
            addItemType(0, R.layout.item_giftwall_info_about_title);
            addItemType(1, R.layout.item_giftwall_info_about);
            addItemType(2, R.layout.item_giftwall_info_about_no);
        }

        private final void a(GiftWallInfoAboutModel giftWallInfoAboutModel) {
            YYGiftWallAboutInfoDialog yYGiftWallAboutInfoDialog = new YYGiftWallAboutInfoDialog();
            yYGiftWallAboutInfoDialog.a(giftWallInfoAboutModel);
            FragmentManager childFragmentManager = this.f18206a.getChildFragmentManager();
            Intrinsics.c(childFragmentManager, "childFragmentManager");
            yYGiftWallAboutInfoDialog.show(childFragmentManager, "YYGiftWallAboutInfoDialog");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(Ada this$0, GiftWallInfoAboutModel item, View view) {
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(item, "$item");
            this$0.a(item);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(Ada this$0, GiftWallInfoAboutModel item, View view) {
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(item, "$item");
            this$0.a(item);
        }

        private final void b(BaseViewHolder baseViewHolder, final GiftWallInfoAboutModel giftWallInfoAboutModel) {
            YYCollectorConfigMode.BadgeDTO badge;
            YYCollectorConfigMode.SkinDTO skin2;
            YYCollectorConfigMode allDa;
            YYCollectorConfigMode.GoodsDTO goods;
            ItemGiftwallInfoAboutNoBinding a2 = ItemGiftwallInfoAboutNoBinding.a(baseViewHolder.itemView);
            Intrinsics.c(a2, "bind(helper.itemView)");
            int item = giftWallInfoAboutModel.getItem();
            if (item == 0) {
                YYCollectorConfigMode allDa2 = giftWallInfoAboutModel.getAllDa();
                if (allDa2 != null && (badge = allDa2.getBadge()) != null) {
                    ImageLoader.a(this.f18206a.a(), badge.getImage()).a(a2.f16607a);
                    a2.f16608c.setText(badge.getName());
                    a2.d.setText("专属勋章");
                }
            } else if (item == 1) {
                YYCollectorConfigMode allDa3 = giftWallInfoAboutModel.getAllDa();
                if (allDa3 != null && (skin2 = allDa3.getSkin()) != null) {
                    ImageLoader.a(this.f18206a.a(), skin2.getIntroduce()).a(a2.f16607a);
                    a2.f16608c.setText(skin2.getName());
                    a2.d.setText("专属皮肤");
                }
            } else if (item == 2 && (allDa = giftWallInfoAboutModel.getAllDa()) != null && (goods = allDa.getGoods()) != null) {
                ImageLoader.a(this.f18206a.a(), goods.getImage_static()).a(a2.f16607a);
                a2.f16608c.setText(goods.getName());
                a2.d.setText("专属礼物");
            }
            a2.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYGiftWallListAndInfoAboutDialog$Ada$IQUQ75GbabYMyK5zOqlTGEQc_bY
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYGiftWallListAndInfoAboutDialog.Ada.a(YYGiftWallListAndInfoAboutDialog.Ada.this, giftWallInfoAboutModel, view);
                }
            });
        }

        private final void c(BaseViewHolder baseViewHolder, final GiftWallInfoAboutModel giftWallInfoAboutModel) {
            YYCollectorConfigMode.BadgeDTO badge;
            YYCollectorConfigMode.SkinDTO skin2;
            YYCollectorConfigMode allDa;
            YYCollectorConfigMode.GoodsDTO goods;
            ItemGiftwallInfoAboutBinding a2 = ItemGiftwallInfoAboutBinding.a(baseViewHolder.itemView);
            Intrinsics.c(a2, "bind(helper.itemView)");
            int item = giftWallInfoAboutModel.getItem();
            if (item == 0) {
                YYCollectorConfigMode allDa2 = giftWallInfoAboutModel.getAllDa();
                if (allDa2 != null && (badge = allDa2.getBadge()) != null) {
                    ImageLoader.a(this.f18206a.a(), badge.getImage()).a(a2.f16605a);
                    a2.f16606c.setText(badge.getName());
                    a2.d.setText("专属勋章");
                }
            } else if (item == 1) {
                YYCollectorConfigMode allDa3 = giftWallInfoAboutModel.getAllDa();
                if (allDa3 != null && (skin2 = allDa3.getSkin()) != null) {
                    ImageLoader.a(this.f18206a.a(), skin2.getIntroduce()).a(a2.f16605a);
                    a2.f16606c.setText(skin2.getName());
                    a2.d.setText("专属皮肤");
                }
            } else if (item == 2 && (allDa = giftWallInfoAboutModel.getAllDa()) != null && (goods = allDa.getGoods()) != null) {
                ImageLoader.a(this.f18206a.a(), goods.getImage_static()).a(a2.f16605a);
                a2.f16606c.setText(goods.getName());
                a2.d.setText("专属礼物");
            }
            a2.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYGiftWallListAndInfoAboutDialog$Ada$RUvWZVsDgv-gd_2eauN5W72wV1s
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYGiftWallListAndInfoAboutDialog.Ada.b(YYGiftWallListAndInfoAboutDialog.Ada.this, giftWallInfoAboutModel, view);
                }
            });
        }

        private final void d(BaseViewHolder baseViewHolder, GiftWallInfoAboutModel giftWallInfoAboutModel) {
            ItemGiftwallInfoAboutTitleBinding a2 = ItemGiftwallInfoAboutTitleBinding.a(baseViewHolder.itemView);
            Intrinsics.c(a2, "bind(helper.itemView)");
            if (giftWallInfoAboutModel.isTop()) {
                a2.f16609a.setVisibility(0);
            } else {
                a2.f16609a.setVisibility(8);
            }
            YYCollectorConfigMode allDa = giftWallInfoAboutModel.getAllDa();
            if (allDa == null) {
                return;
            }
            YYGiftWallListAndInfoAboutDialog yYGiftWallListAndInfoAboutDialog = this.f18206a;
            if (allDa.getIs_achieve() == 1) {
                a2.b.setText("已解锁");
                TextView textView = a2.b;
                Context context = yYGiftWallListAndInfoAboutDialog.getContext();
                Intrinsics.a(context);
                textView.setTextColor(context.getResources().getColor(R.color.white));
                a2.b.setAlpha(1.0f);
                a2.f16610c.setText(allDa.getName());
                TextView textView2 = a2.d;
                textView2.setText("需要收集" + allDa.getJewel() + "钻石");
                return;
            }
            a2.b.setText("待解锁");
            TextView textView3 = a2.b;
            Context context2 = yYGiftWallListAndInfoAboutDialog.getContext();
            Intrinsics.a(context2);
            textView3.setTextColor(context2.getResources().getColor(R.color.syc_D0D0D0));
            a2.b.setAlpha(0.3f);
            a2.f16610c.setText(allDa.getName());
            TextView textView4 = a2.d;
            textView4.setText("需要收集" + allDa.getJewel() + "钻石");
        }

        public final int a(int i) {
            int itemViewType = getItemViewType(i);
            return (itemViewType == 1 || itemViewType == 2) ? 1 : 3;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: a */
        public void convert(BaseViewHolder helper, GiftWallInfoAboutModel item) {
            Intrinsics.e(helper, "helper");
            Intrinsics.e(item, "item");
            int itemType = item.getItemType();
            if (itemType == 0) {
                d(helper, item);
            } else if (itemType == 1) {
                c(helper, item);
            } else if (itemType == 2) {
                b(helper, item);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYGiftWallListAndInfoAboutDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYGiftWallListAndInfoAboutDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    private final DialogGiftWallAboutBinding f() {
        DialogGiftWallAboutBinding dialogGiftWallAboutBinding = this.f18204a;
        Intrinsics.a(dialogGiftWallAboutBinding);
        return dialogGiftWallAboutBinding;
    }

    private final void g() {
        ArrayList<YYCollectorConfigMode> collector_config;
        f().f16342a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYGiftWallListAndInfoAboutDialog$XSXEH27ZO5_b92SX_NBK7vMxQwk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYGiftWallListAndInfoAboutDialog.a(YYGiftWallListAndInfoAboutDialog.this, view);
            }
        });
        f().b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYGiftWallListAndInfoAboutDialog$FG89MA8TKc5OYnf1Y9Wvn5UVd50
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYGiftWallListAndInfoAboutDialog.b(YYGiftWallListAndInfoAboutDialog.this, view);
            }
        });
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3, 1, false);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.blued.android.module.yy_china.view.YYGiftWallListAndInfoAboutDialog$initView$3
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i) {
                YYGiftWallListAndInfoAboutDialog.Ada ada;
                ada = YYGiftWallListAndInfoAboutDialog.this.b;
                return ada.a(i);
            }
        });
        f().f16343c.setAdapter(this.b);
        f().f16343c.setLayoutManager(gridLayoutManager);
        ArrayList arrayList = new ArrayList();
        YYGoodsWallListMode yYGoodsWallListMode = this.d;
        if (yYGoodsWallListMode != null && (collector_config = yYGoodsWallListMode.getCollector_config()) != null) {
            int size = collector_config.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                YYCollectorConfigMode yYCollectorConfigMode = collector_config.get(i2);
                GiftWallInfoAboutModel giftWallInfoAboutModel = new GiftWallInfoAboutModel();
                giftWallInfoAboutModel.setType(0);
                giftWallInfoAboutModel.setAllDa(yYCollectorConfigMode);
                giftWallInfoAboutModel.setTop(i2 == 0);
                arrayList.add(giftWallInfoAboutModel);
                boolean z = yYCollectorConfigMode.getIs_achieve() == 1;
                GiftWallInfoAboutModel giftWallInfoAboutModel2 = new GiftWallInfoAboutModel();
                giftWallInfoAboutModel2.setType(z ? 1 : 2);
                giftWallInfoAboutModel2.setAllDa(yYCollectorConfigMode);
                giftWallInfoAboutModel2.setItem(0);
                arrayList.add(giftWallInfoAboutModel2);
                GiftWallInfoAboutModel giftWallInfoAboutModel3 = new GiftWallInfoAboutModel();
                giftWallInfoAboutModel3.setType(z ? 1 : 2);
                giftWallInfoAboutModel3.setAllDa(yYCollectorConfigMode);
                giftWallInfoAboutModel3.setItem(2);
                arrayList.add(giftWallInfoAboutModel3);
                GiftWallInfoAboutModel giftWallInfoAboutModel4 = new GiftWallInfoAboutModel();
                int i3 = 2;
                if (z) {
                    i3 = 1;
                }
                giftWallInfoAboutModel4.setType(i3);
                giftWallInfoAboutModel4.setAllDa(yYCollectorConfigMode);
                giftWallInfoAboutModel4.setItem(1);
                arrayList.add(giftWallInfoAboutModel4);
                i = i2 + 1;
            }
        }
        this.b.setNewData(arrayList);
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        EventTrackYY.d(ChatRoomProtos.Event.YY_GIFT_WALL_PAGE_REWARD_POP_SHOW, b.room_id, b.uid);
    }

    public final void a(YYGoodsWallListMode yYGoodsWallListMode) {
        this.d = yYGoodsWallListMode;
    }

    public final void a(YYUserInfo yYUserInfo) {
        this.f18205c = yYUserInfo;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        this.f18204a = DialogGiftWallAboutBinding.a(inflater.inflate(R.layout.dialog_gift_wall_about, viewGroup, true));
        g();
        return f().getRoot();
    }
}
