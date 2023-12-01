package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.DialogGiftWallListAndInfoBinding;
import com.blued.android.module.yy_china.databinding.ItemGiftwallInfoNoClickBinding;
import com.blued.android.module.yy_china.databinding.ItemGiftwallListInfoClickBinding;
import com.blued.android.module.yy_china.databinding.ItemGiftwallListInfoTitleBinding;
import com.blued.android.module.yy_china.fragment.BaseFullScreenDialog;
import com.blued.android.module.yy_china.fragment.YYGiftExhibitionDialog;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.GiftWallInfoModel;
import com.blued.android.module.yy_china.model.YYGoodsWallListMode;
import com.blued.android.module.yy_china.model.YYGoodsWallMode;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYUserInfo;
import com.blued.android.module.yy_china.model.YYcollectorMode;
import com.blued.android.module.yy_china.utils.YYCommonStringUtils;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.android.module.yy_china.view.YYGiftWallListAndInfoDialog;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYGiftWallListAndInfoDialog.class */
public final class YYGiftWallListAndInfoDialog extends BaseFullScreenDialog {

    /* renamed from: a  reason: collision with root package name */
    private DialogGiftWallListAndInfoBinding f18208a;
    private final Ada b = new Ada(this);

    /* renamed from: c  reason: collision with root package name */
    private YYUserInfo f18209c;
    private YYGoodsWallListMode d;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYGiftWallListAndInfoDialog$Ada.class */
    public final class Ada extends BaseMultiItemQuickAdapter<GiftWallInfoModel, BaseViewHolder> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ YYGiftWallListAndInfoDialog f18210a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Ada(YYGiftWallListAndInfoDialog this$0) {
            super(new ArrayList());
            Intrinsics.e(this$0, "this$0");
            this.f18210a = this$0;
            addItemType(0, R.layout.item_giftwall_list_info_title);
            addItemType(1, R.layout.item_giftwall_list_info_click);
            addItemType(2, R.layout.item_giftwall_list_info_small_title);
            addItemType(3, R.layout.item_giftwall_info_no_click);
        }

        private final void a(YYGoodsWallListMode yYGoodsWallListMode, YYUserInfo yYUserInfo) {
            YYGiftWallListAndInfoAboutDialog yYGiftWallListAndInfoAboutDialog = new YYGiftWallListAndInfoAboutDialog();
            yYGiftWallListAndInfoAboutDialog.a(yYGoodsWallListMode);
            yYGiftWallListAndInfoAboutDialog.a(yYUserInfo);
            FragmentManager childFragmentManager = this.f18210a.getChildFragmentManager();
            Intrinsics.c(childFragmentManager, "childFragmentManager");
            yYGiftWallListAndInfoAboutDialog.show(childFragmentManager, "YYGiftWallListAndInfoAboutDialog");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(Ada this$0, GiftWallInfoModel item, Ref.BooleanRef isClick, View view) {
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(item, "$item");
            Intrinsics.e(isClick, "$isClick");
            YYGoodsWallListMode giftWallModel = item.getGiftWallModel();
            Intrinsics.a(giftWallModel);
            YYUserInfo us = item.getUs();
            Intrinsics.a(us);
            this$0.a(giftWallModel, us);
            YYRoomModel b = YYRoomInfoManager.e().b();
            if (b == null) {
                return;
            }
            if (isClick.f42538a) {
                EventTrackYY.d(ChatRoomProtos.Event.YY_GIFT_WALL_PAGE_UNLOCK_CLICK, b.room_id, b.uid);
            } else {
                EventTrackYY.d(ChatRoomProtos.Event.YY_GIFT_WALL_PAGE_REWARD_CLICK, b.room_id, b.uid);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(Ada this$0, YYGiftWallListAndInfoDialog this$1, GiftWallInfoModel item, View view) {
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(this$1, "this$1");
            Intrinsics.e(item, "$item");
            YYUserInfo f = this$1.f();
            Intrinsics.a(f);
            YYGoodsWallMode goodItem = item.getGoodItem();
            Intrinsics.a(goodItem);
            this$0.a(false, f, goodItem);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(YYGiftWallListAndInfoDialog this$0, View view) {
            Intrinsics.e(this$0, "this$0");
            this$0.dismissAllowingStateLoss();
        }

        private final void a(boolean z, YYUserInfo yYUserInfo, YYGoodsWallMode yYGoodsWallMode) {
            YYGiftWallInfoDialog yYGiftWallInfoDialog = new YYGiftWallInfoDialog();
            yYGiftWallInfoDialog.a(z);
            yYGiftWallInfoDialog.a(yYUserInfo);
            yYGiftWallInfoDialog.a(yYGoodsWallMode);
            final YYGiftWallListAndInfoDialog yYGiftWallListAndInfoDialog = this.f18210a;
            yYGiftWallInfoDialog.a(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYGiftWallListAndInfoDialog$Ada$k_4YCN53tsmAAk35ViS8nayfEUE
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYGiftWallListAndInfoDialog.Ada.a(YYGiftWallListAndInfoDialog.this, view);
                }
            });
            FragmentManager childFragmentManager = this.f18210a.getChildFragmentManager();
            Intrinsics.c(childFragmentManager, "childFragmentManager");
            yYGiftWallInfoDialog.show(childFragmentManager, "YYGiftWallInfoDialog");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(Ada this$0, GiftWallInfoModel item, Ref.BooleanRef isClick, View view) {
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(item, "$item");
            Intrinsics.e(isClick, "$isClick");
            YYGoodsWallListMode giftWallModel = item.getGiftWallModel();
            Intrinsics.a(giftWallModel);
            YYUserInfo us = item.getUs();
            Intrinsics.a(us);
            this$0.a(giftWallModel, us);
            YYRoomModel b = YYRoomInfoManager.e().b();
            if (b == null) {
                return;
            }
            if (isClick.f42538a) {
                EventTrackYY.d(ChatRoomProtos.Event.YY_GIFT_WALL_PAGE_UNLOCK_CLICK, b.room_id, b.uid);
            } else {
                EventTrackYY.d(ChatRoomProtos.Event.YY_GIFT_WALL_PAGE_REWARD_CLICK, b.room_id, b.uid);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(Ada this$0, YYGiftWallListAndInfoDialog this$1, GiftWallInfoModel item, View view) {
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(this$1, "this$1");
            Intrinsics.e(item, "$item");
            YYUserInfo f = this$1.f();
            Intrinsics.a(f);
            YYGoodsWallMode goodItem = item.getGoodItem();
            Intrinsics.a(goodItem);
            this$0.a(true, f, goodItem);
        }

        private final void b(BaseViewHolder baseViewHolder, final GiftWallInfoModel giftWallInfoModel) {
            ItemGiftwallInfoNoClickBinding a2 = ItemGiftwallInfoNoClickBinding.a(baseViewHolder.itemView);
            Intrinsics.c(a2, "bind(helper.itemView)");
            YYGoodsWallMode goodItem = giftWallInfoModel.getGoodItem();
            if (goodItem == null) {
                return;
            }
            final YYGiftWallListAndInfoDialog yYGiftWallListAndInfoDialog = this.f18210a;
            ImageLoader.a(yYGiftWallListAndInfoDialog.a(), goodItem.getImages_static()).a(a2.f16611a);
            a2.b.setText(goodItem.getName());
            a2.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYGiftWallListAndInfoDialog$Ada$mpM0PRnZLeeCulH7J7Zq1DJYscA
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYGiftWallListAndInfoDialog.Ada.a(YYGiftWallListAndInfoDialog.Ada.this, yYGiftWallListAndInfoDialog, giftWallInfoModel, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(Ada this$0, GiftWallInfoModel item, Ref.BooleanRef isClick, View view) {
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(item, "$item");
            Intrinsics.e(isClick, "$isClick");
            YYGoodsWallListMode giftWallModel = item.getGiftWallModel();
            Intrinsics.a(giftWallModel);
            YYUserInfo us = item.getUs();
            Intrinsics.a(us);
            this$0.a(giftWallModel, us);
            YYRoomModel b = YYRoomInfoManager.e().b();
            if (b == null) {
                return;
            }
            if (isClick.f42538a) {
                EventTrackYY.d(ChatRoomProtos.Event.YY_GIFT_WALL_PAGE_UNLOCK_CLICK, b.room_id, b.uid);
            } else {
                EventTrackYY.d(ChatRoomProtos.Event.YY_GIFT_WALL_PAGE_REWARD_CLICK, b.room_id, b.uid);
            }
        }

        private final void c(BaseViewHolder baseViewHolder, GiftWallInfoModel giftWallInfoModel) {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(Ada this$0, GiftWallInfoModel item, Ref.BooleanRef isClick, View view) {
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(item, "$item");
            Intrinsics.e(isClick, "$isClick");
            YYGoodsWallListMode giftWallModel = item.getGiftWallModel();
            Intrinsics.a(giftWallModel);
            YYUserInfo us = item.getUs();
            Intrinsics.a(us);
            this$0.a(giftWallModel, us);
            YYRoomModel b = YYRoomInfoManager.e().b();
            if (b == null) {
                return;
            }
            if (isClick.f42538a) {
                EventTrackYY.d(ChatRoomProtos.Event.YY_GIFT_WALL_PAGE_UNLOCK_CLICK, b.room_id, b.uid);
            } else {
                EventTrackYY.d(ChatRoomProtos.Event.YY_GIFT_WALL_PAGE_REWARD_CLICK, b.room_id, b.uid);
            }
        }

        private final void d(BaseViewHolder baseViewHolder, final GiftWallInfoModel giftWallInfoModel) {
            ItemGiftwallListInfoClickBinding a2 = ItemGiftwallListInfoClickBinding.a(baseViewHolder.itemView);
            Intrinsics.c(a2, "bind(helper.itemView)");
            YYGoodsWallMode goodItem = giftWallInfoModel.getGoodItem();
            if (goodItem == null) {
                return;
            }
            final YYGiftWallListAndInfoDialog yYGiftWallListAndInfoDialog = this.f18210a;
            ImageLoader.a(yYGiftWallListAndInfoDialog.a(), goodItem.getImages_static()).a(a2.f16613a);
            a2.f.setText(goodItem.getName());
            if (goodItem.getMax_light() == goodItem.getLight()) {
                a2.e.setVisibility(0);
                a2.d.setVisibility(8);
                a2.g.setVisibility(8);
                a2.h.setVisibility(8);
            } else {
                a2.e.setVisibility(8);
                a2.d.setVisibility(0);
                a2.g.setVisibility(0);
                a2.h.setVisibility(0);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                SpannableString spannableString = new SpannableString(String.valueOf(goodItem.getLight()));
                spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#00E0AB")), 0, spannableString.length(), 0);
                spannableStringBuilder.append((CharSequence) spannableString);
                spannableStringBuilder.append((CharSequence) Intrinsics.a(BridgeUtil.SPLIT_MARK, (Object) Long.valueOf(goodItem.getMax_light())));
                a2.g.setText(spannableStringBuilder);
                a2.d.setMax((int) goodItem.getMax_light());
                a2.d.setProgress((int) goodItem.getLight());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
                SpannableString spannableString2 = new SpannableString(Intrinsics.a("+", (Object) CommonStringUtils.a(((float) (goodItem.getBeans() * goodItem.getLight())) * 1.0f)));
                spannableString2.setSpan(new ForegroundColorSpan(Color.parseColor("#FFB930")), 0, spannableString2.length(), 0);
                spannableStringBuilder2.append((CharSequence) spannableString2);
                spannableStringBuilder2.append((CharSequence) "钻石");
                a2.h.setText(spannableStringBuilder2);
            }
            a2.f16614c.setVisibility(8);
            ArrayList<YYGoodsWallMode.SponsorMode> sponsor = goodItem.getSponsor();
            if (sponsor != null && sponsor.size() > 0) {
                a2.f16614c.setVisibility(0);
                YYGoodsWallMode.SponsorMode sponsorMode = sponsor.get(0);
                YYRoomInfoManager.e().a(yYGiftWallListAndInfoDialog.a(), a2.f16614c, sponsorMode.getUid(), sponsorMode.getAvatar());
            }
            a2.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYGiftWallListAndInfoDialog$Ada$ODr2MZI3V27w0LQJWkYmHTpoa80
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYGiftWallListAndInfoDialog.Ada.b(YYGiftWallListAndInfoDialog.Ada.this, yYGiftWallListAndInfoDialog, giftWallInfoModel, view);
                }
            });
        }

        private final void e(BaseViewHolder baseViewHolder, final GiftWallInfoModel giftWallInfoModel) {
            YYGoodsWallListMode.Goods_wallMode goods_wall;
            ArrayList<YYGoodsWallMode> lights;
            YYcollectorMode collector;
            Resources resources;
            Integer valueOf;
            Resources resources2;
            Resources resources3;
            ItemGiftwallListInfoTitleBinding a2 = ItemGiftwallListInfoTitleBinding.a(baseViewHolder.itemView);
            Intrinsics.c(a2, "bind(helper.itemView)");
            final Ada ada = new Ada(this.f18210a);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this.f18210a.getContext(), 4, 1, false);
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.blued.android.module.yy_china.view.YYGiftWallListAndInfoDialog$Ada$initListInfoTitle$1
                @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
                public int getSpanSize(int i) {
                    return YYGiftWallListAndInfoDialog.Ada.this.a(i);
                }
            });
            a2.m.setAdapter(ada);
            a2.m.setLayoutManager(gridLayoutManager);
            a2.m.setNestedScrollingEnabled(false);
            ada.setNewData(giftWallInfoModel.getDas());
            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            YYGoodsWallListMode giftWallModel = giftWallInfoModel.getGiftWallModel();
            if (giftWallModel != null && (collector = giftWallModel.getCollector()) != null) {
                YYGiftWallListAndInfoDialog yYGiftWallListAndInfoDialog = this.f18210a;
                if (collector.getLevel() == 0) {
                    a2.b.setVisibility(0);
                    a2.n.setVisibility(0);
                    a2.w.setVisibility(0);
                    a2.x.setVisibility(8);
                    a2.h.setVisibility(8);
                    a2.f16616a.setVisibility(8);
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    Context context = yYGiftWallListAndInfoDialog.getContext();
                    Integer valueOf2 = (context == null || (resources2 = context.getResources()) == null) ? null : Integer.valueOf(resources2.getColor(R.color.white));
                    Intrinsics.a(valueOf2);
                    arrayList.add(valueOf2);
                    Context context2 = yYGiftWallListAndInfoDialog.getContext();
                    Integer valueOf3 = (context2 == null || (resources3 = context2.getResources()) == null) ? null : Integer.valueOf(resources3.getColor(R.color.white));
                    Intrinsics.a(valueOf3);
                    arrayList.add(valueOf3);
                    a2.f16617c.setAlpha(0.7f);
                    a2.f16617c.setMGradientColor(arrayList);
                    a2.f.setImageResource(R.color.transparent);
                    a2.l.setMax(104);
                    if (collector.getJewel() == 0) {
                        a2.l.setProgress(0);
                    } else {
                        a2.l.setProgress(((int) ((((float) collector.getJewel()) / ((float) collector.getNext_jewel())) * 100)) + 4);
                    }
                    TextView textView = a2.r;
                    StringBuilder sb = new StringBuilder();
                    sb.append(collector.getJewel());
                    sb.append('/');
                    sb.append(collector.getNext_jewel());
                    textView.setText(sb.toString());
                    a2.t.setText(collector.getDescription());
                    if (((int) collector.getNext_jewel()) <= ((int) collector.getJewel())) {
                        TextView textView2 = a2.r;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(collector.getNext_jewel());
                        sb2.append('/');
                        sb2.append(collector.getNext_jewel());
                        textView2.setText(sb2.toString());
                    }
                    if (Intrinsics.a((Object) collector.getStatus(), (Object) "2")) {
                        a2.w.setText("查看奖励");
                        a2.x.setText("查看奖励");
                        booleanRef.f42538a = true;
                    }
                    YYUserInfo us = giftWallInfoModel.getUs();
                    if (us != null) {
                        YYRoomInfoManager.e().b(yYGiftWallListAndInfoDialog.a(), a2.i, us.getUid(), us.getAvatar());
                        a2.p.setText(Intrinsics.a(YYCommonStringUtils.a(YYRoomInfoManager.e().a(us.getUid(), us.getName()), a2.p.getPaint(), yYGiftWallListAndInfoDialog.getResources().getDimensionPixelOffset(R.dimen.dp_70)), (Object) "的礼物墙"));
                    }
                }
                if (collector.getLevel() == 1) {
                    a2.b.setVisibility(0);
                    a2.n.setVisibility(8);
                    a2.w.setVisibility(8);
                    a2.x.setVisibility(0);
                    a2.h.setVisibility(0);
                    a2.f16616a.setVisibility(8);
                    ArrayList<Integer> arrayList2 = new ArrayList<>();
                    Context context3 = yYGiftWallListAndInfoDialog.getContext();
                    Integer valueOf4 = (context3 == null || (resources = context3.getResources()) == null) ? null : Integer.valueOf(resources.getColor(R.color.syc_3883FD));
                    Intrinsics.a(valueOf4);
                    arrayList2.add(valueOf4);
                    Context context4 = yYGiftWallListAndInfoDialog.getContext();
                    if (context4 == null) {
                        valueOf = null;
                    } else {
                        Resources resources4 = context4.getResources();
                        valueOf = resources4 == null ? null : Integer.valueOf(resources4.getColor(R.color.syc_00E0AB));
                    }
                    Intrinsics.a(valueOf);
                    arrayList2.add(valueOf);
                    a2.f16617c.setAlpha(1.0f);
                    a2.f16617c.setMGradientColor(arrayList2);
                    YYcollectorMode.SkinDTO skin2 = collector.getSkin();
                    if (skin2 != null) {
                        ImageLoader.a(yYGiftWallListAndInfoDialog.a(), skin2.getWall_head()).a(a2.f);
                        ImageLoader.a(yYGiftWallListAndInfoDialog.a(), skin2.getBadge()).a(a2.h);
                    }
                    a2.l.setMax(104);
                    if (collector.getJewel() == 0) {
                        a2.l.setProgress(0);
                    } else {
                        a2.l.setProgress(((int) ((((float) collector.getJewel()) / ((float) collector.getNext_jewel())) * 100)) + 4);
                    }
                    TextView textView3 = a2.r;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(collector.getJewel());
                    sb3.append('/');
                    sb3.append(collector.getNext_jewel());
                    textView3.setText(sb3.toString());
                    a2.t.setText(collector.getDescription());
                    if (((int) collector.getNext_jewel()) <= ((int) collector.getJewel())) {
                        TextView textView4 = a2.r;
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(collector.getNext_jewel());
                        sb4.append('/');
                        sb4.append(collector.getNext_jewel());
                        textView4.setText(sb4.toString());
                    }
                    if (Intrinsics.a((Object) collector.getStatus(), (Object) "2")) {
                        a2.w.setText("查看奖励");
                        a2.x.setText("查看奖励");
                        booleanRef.f42538a = true;
                    }
                    YYUserInfo us2 = giftWallInfoModel.getUs();
                    if (us2 != null) {
                        YYRoomInfoManager.e().b(yYGiftWallListAndInfoDialog.a(), a2.i, us2.getUid(), us2.getAvatar());
                        a2.p.setText(Intrinsics.a(YYCommonStringUtils.a(YYRoomInfoManager.e().a(us2.getUid(), us2.getName()), a2.p.getPaint(), yYGiftWallListAndInfoDialog.getResources().getDimensionPixelOffset(R.dimen.dp_70)), (Object) "的礼物墙"));
                    }
                }
                if (collector.getLevel() > 1) {
                    a2.b.setVisibility(8);
                    a2.f16616a.setVisibility(0);
                    a2.u.setVisibility(8);
                    a2.v.setVisibility(0);
                    a2.g.setVisibility(0);
                    YYcollectorMode.SkinDTO skin3 = collector.getSkin();
                    if (skin3 != null) {
                        ImageLoader.a(yYGiftWallListAndInfoDialog.a(), skin3.getWall_head()).a(a2.e);
                        ImageLoader.a(yYGiftWallListAndInfoDialog.a(), skin3.getBadge()).a(a2.g);
                    }
                    a2.k.setMax(104);
                    if (collector.getJewel() == 0) {
                        a2.k.setProgress(0);
                    } else {
                        a2.k.setProgress(((int) ((((float) collector.getJewel()) / ((float) collector.getNext_jewel())) * 100)) + 4);
                    }
                    TextView textView5 = a2.o;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(collector.getJewel());
                    sb5.append('/');
                    sb5.append(collector.getNext_jewel());
                    textView5.setText(sb5.toString());
                    a2.s.setText(collector.getDescription());
                    if (((int) collector.getNext_jewel()) <= ((int) collector.getJewel())) {
                        a2.u.setText("查看奖励");
                        a2.v.setText("查看奖励");
                        booleanRef.f42538a = true;
                        TextView textView6 = a2.o;
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append(collector.getNext_jewel());
                        sb6.append('/');
                        sb6.append(collector.getNext_jewel());
                        textView6.setText(sb6.toString());
                    }
                    YYUserInfo us3 = giftWallInfoModel.getUs();
                    if (us3 != null) {
                        YYRoomInfoManager.e().b(yYGiftWallListAndInfoDialog.a(), a2.j, us3.getUid(), us3.getAvatar());
                        a2.q.setText(Intrinsics.a(YYCommonStringUtils.a(YYRoomInfoManager.e().a(us3.getUid(), us3.getName()), a2.p.getPaint(), yYGiftWallListAndInfoDialog.getResources().getDimensionPixelOffset(R.dimen.dp_70)), (Object) "的礼物墙"));
                    }
                }
            }
            a2.y.setVisibility(8);
            a2.z.setVisibility(8);
            YYGoodsWallListMode giftWallModel2 = giftWallInfoModel.getGiftWallModel();
            if (giftWallModel2 != null && (goods_wall = giftWallModel2.getGoods_wall()) != null && (lights = goods_wall.getLights()) != null && lights.size() > 0) {
                a2.y.setVisibility(0);
                a2.z.setVisibility(0);
                a2.z.setText("已点亮" + lights.size() + "个礼物");
            }
            a2.w.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYGiftWallListAndInfoDialog$Ada$DcVhOz6Ye-e0AsHW6ZNFOxK31z0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYGiftWallListAndInfoDialog.Ada.a(YYGiftWallListAndInfoDialog.Ada.this, giftWallInfoModel, booleanRef, view);
                }
            });
            a2.x.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYGiftWallListAndInfoDialog$Ada$-p9cudR5tPh3fwQ6-5nvejiq16g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYGiftWallListAndInfoDialog.Ada.b(YYGiftWallListAndInfoDialog.Ada.this, giftWallInfoModel, booleanRef, view);
                }
            });
            a2.u.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYGiftWallListAndInfoDialog$Ada$IkDfJBaDcOdyMc8jUYXJoA3CQuI
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYGiftWallListAndInfoDialog.Ada.c(YYGiftWallListAndInfoDialog.Ada.this, giftWallInfoModel, booleanRef, view);
                }
            });
            a2.v.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYGiftWallListAndInfoDialog$Ada$6YgvsZY-dYrPvwzUJP8bChri8Bc
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYGiftWallListAndInfoDialog.Ada.d(YYGiftWallListAndInfoDialog.Ada.this, giftWallInfoModel, booleanRef, view);
                }
            });
        }

        public final int a(int i) {
            int itemViewType = getItemViewType(i);
            int i2 = 4;
            if (itemViewType != 0) {
                if (itemViewType != 1) {
                    i2 = 4;
                    if (itemViewType != 2) {
                        if (itemViewType != 3) {
                            return 4;
                        }
                    }
                }
                i2 = 1;
            }
            return i2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: a */
        public void convert(BaseViewHolder helper, GiftWallInfoModel giftWallInfoModel) {
            Intrinsics.e(helper, "helper");
            Integer valueOf = giftWallInfoModel == null ? null : Integer.valueOf(giftWallInfoModel.getItemType());
            if (valueOf != null && valueOf.intValue() == 0) {
                e(helper, giftWallInfoModel);
            } else if (valueOf != null && valueOf.intValue() == 1) {
                d(helper, giftWallInfoModel);
            } else if (valueOf != null && valueOf.intValue() == 2) {
                c(helper, giftWallInfoModel);
            } else if (valueOf != null && valueOf.intValue() == 3) {
                b(helper, giftWallInfoModel);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
        LiveEventBus.get("event_yy_game").post(YYRoomInfoManager.e().c(11));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYGiftWallListAndInfoDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYGiftWallListAndInfoDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(YYGiftWallListAndInfoDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        YYUserInfo yYUserInfo = this$0.f18209c;
        String str = null;
        String uid = yYUserInfo == null ? null : yYUserInfo.getUid();
        YYUserInfo yYUserInfo2 = this$0.f18209c;
        String name = yYUserInfo2 == null ? null : yYUserInfo2.getName();
        YYUserInfo yYUserInfo3 = this$0.f18209c;
        if (yYUserInfo3 != null) {
            str = yYUserInfo3.getAvatar();
        }
        YYGiftExhibitionDialog yYGiftExhibitionDialog = new YYGiftExhibitionDialog(uid, name, str);
        FragmentManager parentFragmentManager = this$0.getParentFragmentManager();
        Intrinsics.c(parentFragmentManager, "parentFragmentManager");
        yYGiftExhibitionDialog.show(parentFragmentManager, "dialog_gift_exhibition");
    }

    private final DialogGiftWallListAndInfoBinding g() {
        DialogGiftWallListAndInfoBinding dialogGiftWallListAndInfoBinding = this.f18208a;
        Intrinsics.a(dialogGiftWallListAndInfoBinding);
        return dialogGiftWallListAndInfoBinding;
    }

    private final void h() {
        g().b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYGiftWallListAndInfoDialog$IewSHZtn6VwKlBUoXoM7FZZUwJU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYGiftWallListAndInfoDialog.a(view);
            }
        });
        g().f16345c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYGiftWallListAndInfoDialog$g0CbYGawwXL1Rzvg6DJsE50lVMA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYGiftWallListAndInfoDialog.a(YYGiftWallListAndInfoDialog.this, view);
            }
        });
        g().d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYGiftWallListAndInfoDialog$cctphUxnMD106oAN943NiNrNjM0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYGiftWallListAndInfoDialog.b(YYGiftWallListAndInfoDialog.this, view);
            }
        });
        g().f16344a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYGiftWallListAndInfoDialog$egn1Uru3r-LCnxCHFM2GRLK5JHg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYGiftWallListAndInfoDialog.c(YYGiftWallListAndInfoDialog.this, view);
            }
        });
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 4, 1, false);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.blued.android.module.yy_china.view.YYGiftWallListAndInfoDialog$initView$5
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i) {
                YYGiftWallListAndInfoDialog.Ada ada;
                ada = YYGiftWallListAndInfoDialog.this.b;
                return ada.a(i);
            }
        });
        g().e.setAdapter(this.b);
        g().e.setLayoutManager(gridLayoutManager);
        YYUserInfo yYUserInfo = this.f18209c;
        String uid = yYUserInfo == null ? null : yYUserInfo.getUid();
        final ActivityFragmentActive a2 = a();
        YYRoomHttpUtils.v(uid, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<YYGoodsWallListMode>>(a2) { // from class: com.blued.android.module.yy_china.view.YYGiftWallListAndInfoDialog$initView$6
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYGoodsWallListMode> p0) {
                YYGiftWallListAndInfoDialog.Ada ada;
                ArrayList<YYGoodsWallMode> no_lights;
                ArrayList<YYGoodsWallMode> lights;
                Intrinsics.e(p0, "p0");
                YYGoodsWallListMode singleData = p0.getSingleData();
                if (singleData == null) {
                    return;
                }
                YYGiftWallListAndInfoDialog yYGiftWallListAndInfoDialog = YYGiftWallListAndInfoDialog.this;
                yYGiftWallListAndInfoDialog.d = singleData;
                ArrayList arrayList = new ArrayList();
                GiftWallInfoModel giftWallInfoModel = new GiftWallInfoModel();
                giftWallInfoModel.setType(0);
                giftWallInfoModel.setUs(yYGiftWallListAndInfoDialog.f());
                giftWallInfoModel.setGiftWallModel(singleData);
                ArrayList<GiftWallInfoModel> arrayList2 = new ArrayList<>();
                new GiftWallInfoModel();
                YYGoodsWallListMode.Goods_wallMode goods_wall = singleData.getGoods_wall();
                if (goods_wall != null && (lights = goods_wall.getLights()) != null) {
                    for (YYGoodsWallMode yYGoodsWallMode : lights) {
                        GiftWallInfoModel giftWallInfoModel2 = new GiftWallInfoModel();
                        giftWallInfoModel2.setType(1);
                        giftWallInfoModel2.setGoodItem(yYGoodsWallMode);
                        arrayList2.add(giftWallInfoModel2);
                    }
                }
                giftWallInfoModel.setDas(arrayList2);
                arrayList.add(giftWallInfoModel);
                YYGoodsWallListMode.Goods_wallMode goods_wall2 = singleData.getGoods_wall();
                if (goods_wall2 != null && (no_lights = goods_wall2.getNo_lights()) != null) {
                    if (no_lights.size() > 0) {
                        GiftWallInfoModel giftWallInfoModel3 = new GiftWallInfoModel();
                        giftWallInfoModel3.setType(2);
                        arrayList.add(giftWallInfoModel3);
                    }
                    for (YYGoodsWallMode yYGoodsWallMode2 : no_lights) {
                        GiftWallInfoModel giftWallInfoModel4 = new GiftWallInfoModel();
                        giftWallInfoModel4.setType(3);
                        giftWallInfoModel4.setGoodItem(yYGoodsWallMode2);
                        arrayList.add(giftWallInfoModel4);
                    }
                }
                ada = yYGiftWallListAndInfoDialog.b;
                ada.setNewData(arrayList);
            }
        }, (IRequestHost) a());
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        EventTrackYY.d(ChatRoomProtos.Event.YY_GIFT_WALL_PAGE_SHOW, b.room_id, b.uid);
    }

    public final void a(YYUserInfo yYUserInfo) {
        this.f18209c = yYUserInfo;
    }

    public final YYUserInfo f() {
        return this.f18209c;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        this.f18208a = DialogGiftWallListAndInfoBinding.a(inflater.inflate(R.layout.dialog_gift_wall_list_and_info, viewGroup, true));
        h();
        return g().getRoot();
    }
}
