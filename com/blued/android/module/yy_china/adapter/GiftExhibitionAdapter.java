package com.blued.android.module.yy_china.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.ItemGiftExhibitionListTitleBinding;
import com.blued.android.module.yy_china.databinding.ItemGiftExhibitionUserInfoBinding;
import com.blued.android.module.yy_china.databinding.ItemGiftwallInfoNoClickBinding;
import com.blued.android.module.yy_china.databinding.ItemGiftwallListInfoClickBinding;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.GiftWallInfoModel;
import com.blued.android.module.yy_china.model.YYGoodsWallListMode;
import com.blued.android.module.yy_china.model.YYGoodsWallMode;
import com.blued.android.module.yy_china.model.YYUserInfo;
import com.blued.android.module.yy_china.model.YYcollectorMode;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/GiftExhibitionAdapter.class */
public final class GiftExhibitionAdapter extends BaseMultiItemQuickAdapter<GiftWallInfoModel, BaseViewHolder> {
    private Context a;
    private int b;
    private ActivityFragmentActive c;
    private ClickGiftListener d;

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/GiftExhibitionAdapter$ClickGiftListener.class */
    public interface ClickGiftListener {
        void a(boolean z, YYUserInfo yYUserInfo, YYGoodsWallMode yYGoodsWallMode);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GiftExhibitionAdapter(Context context, int i, ActivityFragmentActive fragmentActive) {
        super(new ArrayList());
        Intrinsics.e(context, "context");
        Intrinsics.e(fragmentActive, "fragmentActive");
        this.a = context;
        this.b = i;
        this.c = fragmentActive;
        addItemType(0, R.layout.item_gift_exhibition_user_info);
        addItemType(1, R.layout.item_giftwall_list_info_click);
        addItemType(2, R.layout.item_gift_exhibition_list_title);
        addItemType(3, R.layout.item_giftwall_info_no_click);
    }

    private final String a(YYUserInfo yYUserInfo, TextView textView, TextView textView2) {
        if (this.b == 1) {
            textView2.setText("的星座礼物展馆");
            String a = YYRoomInfoManager.e().a(yYUserInfo.getUid(), yYUserInfo.getName());
            Intrinsics.c(a, "getInstance().getMaskedName(item.uid, item.name)");
            return a;
        }
        textView2.setText("的礼物展馆");
        String a2 = YYRoomInfoManager.e().a(yYUserInfo.getUid(), yYUserInfo.getName());
        Intrinsics.c(a2, "getInstance().getMaskedName(item.uid, item.name)");
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(GiftExhibitionAdapter this$0, GiftWallInfoModel item, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(item, "$item");
        ClickGiftListener clickGiftListener = this$0.d;
        if (clickGiftListener == null) {
            return;
        }
        clickGiftListener.a(false, item.getUs(), item.getGoodItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(GiftExhibitionAdapter this$0, GiftWallInfoModel item, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(item, "$item");
        ClickGiftListener clickGiftListener = this$0.d;
        if (clickGiftListener == null) {
            return;
        }
        clickGiftListener.a(true, item.getUs(), item.getGoodItem());
    }

    private final void b(BaseViewHolder baseViewHolder, final GiftWallInfoModel giftWallInfoModel) {
        ItemGiftwallInfoNoClickBinding a = ItemGiftwallInfoNoClickBinding.a(baseViewHolder.itemView);
        Intrinsics.c(a, "bind(helper.itemView)");
        YYGoodsWallMode goodItem = giftWallInfoModel.getGoodItem();
        if (goodItem == null) {
            return;
        }
        ImageLoader.a(a(), goodItem.getImages_static()).a(a.a);
        a.b.setText(goodItem.getName());
        a.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.-$$Lambda$GiftExhibitionAdapter$_6cC0xVAfEx85lp6cz_S7W3UzS0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GiftExhibitionAdapter.a(GiftExhibitionAdapter.this, giftWallInfoModel, view);
            }
        });
    }

    private final void c(BaseViewHolder baseViewHolder, GiftWallInfoModel giftWallInfoModel) {
        ItemGiftExhibitionListTitleBinding a = ItemGiftExhibitionListTitleBinding.a(baseViewHolder.itemView);
        Intrinsics.c(a, "bind(helper.itemView)");
        a.b.setText(giftWallInfoModel.getTitleName());
        if (TextUtils.isEmpty(giftWallInfoModel.getSubTitleName())) {
            a.a.setVisibility(8);
            return;
        }
        a.a.setVisibility(0);
        a.a.setText(giftWallInfoModel.getSubTitleName());
    }

    private final void d(BaseViewHolder baseViewHolder, final GiftWallInfoModel giftWallInfoModel) {
        ItemGiftwallListInfoClickBinding a = ItemGiftwallListInfoClickBinding.a(baseViewHolder.itemView);
        Intrinsics.c(a, "bind(helper.itemView)");
        YYGoodsWallMode goodItem = giftWallInfoModel.getGoodItem();
        if (goodItem == null) {
            return;
        }
        ImageLoader.a(a(), goodItem.getImages_static()).a(a.a);
        a.f.setText(goodItem.getName());
        if (goodItem.getMax_light() == goodItem.getLight()) {
            a.e.setVisibility(0);
            a.d.setVisibility(8);
            a.g.setVisibility(8);
            a.h.setVisibility(8);
        } else {
            a.e.setVisibility(8);
            a.d.setVisibility(0);
            a.g.setVisibility(0);
            a.h.setVisibility(0);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(String.valueOf(goodItem.getLight()));
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#00E0AB")), 0, spannableString.length(), 0);
            spannableStringBuilder.append((CharSequence) spannableString);
            spannableStringBuilder.append((CharSequence) Intrinsics.a(BridgeUtil.SPLIT_MARK, (Object) Long.valueOf(goodItem.getMax_light())));
            a.g.setText(spannableStringBuilder);
            a.d.setMax((int) goodItem.getMax_light());
            a.d.setProgress((int) goodItem.getLight());
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
            SpannableString spannableString2 = new SpannableString(Intrinsics.a("+", (Object) CommonStringUtils.a(((float) (goodItem.getBeans() * goodItem.getLight())) * 1.0f)));
            spannableString2.setSpan(new ForegroundColorSpan(Color.parseColor("#FFB930")), 0, spannableString2.length(), 0);
            spannableStringBuilder2.append((CharSequence) spannableString2);
            spannableStringBuilder2.append((CharSequence) "钻石");
            a.h.setText(spannableStringBuilder2);
        }
        a.c.setVisibility(8);
        ArrayList<YYGoodsWallMode.SponsorMode> sponsor = goodItem.getSponsor();
        if (sponsor != null && sponsor.size() > 0) {
            a.c.setVisibility(0);
            YYGoodsWallMode.SponsorMode sponsorMode = sponsor.get(0);
            YYRoomInfoManager.e().a(a(), (ImageView) a.c, sponsorMode.getUid(), sponsorMode.getAvatar());
        }
        a.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.-$$Lambda$GiftExhibitionAdapter$545PV4OlYUUI-qGkK-15zofK7II
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GiftExhibitionAdapter.b(GiftExhibitionAdapter.this, giftWallInfoModel, view);
            }
        });
    }

    private final void e(BaseViewHolder baseViewHolder, GiftWallInfoModel giftWallInfoModel) {
        YYcollectorMode collector;
        ItemGiftExhibitionUserInfoBinding a = ItemGiftExhibitionUserInfoBinding.a(baseViewHolder.itemView);
        Intrinsics.c(a, "bind(helper.itemView)");
        YYGoodsWallListMode giftWallModel = giftWallInfoModel.getGiftWallModel();
        if (giftWallModel == null || (collector = giftWallModel.getCollector()) == null) {
            return;
        }
        if (collector.getLevel() == 0) {
            a.b.setVisibility(0);
            a.m.setVisibility(0);
            a.h.setVisibility(8);
            a.a.setVisibility(8);
            ArrayList<Integer> arrayList = new ArrayList<>();
            Resources resources = getContext().getResources();
            Integer valueOf = resources == null ? null : Integer.valueOf(resources.getColor(R.color.white));
            Intrinsics.a(valueOf);
            arrayList.add(valueOf);
            Resources resources2 = getContext().getResources();
            Integer valueOf2 = resources2 == null ? null : Integer.valueOf(resources2.getColor(R.color.white));
            Intrinsics.a(valueOf2);
            arrayList.add(valueOf2);
            a.c.setAlpha(0.7f);
            a.c.setMGradientColor(arrayList);
            a.f.setImageResource(R.color.transparent);
            a.l.setMax(104);
            if (collector.getJewel() == 0) {
                a.l.setProgress(0);
            } else {
                a.l.setProgress(((int) ((((float) collector.getJewel()) / ((float) collector.getNext_jewel())) * 100)) + 4);
            }
            TextView textView = a.s;
            StringBuilder sb = new StringBuilder();
            sb.append(collector.getJewel());
            sb.append('/');
            sb.append(collector.getNext_jewel());
            textView.setText(sb.toString());
            a.u.setText(collector.getDescription());
            if (((int) collector.getNext_jewel()) <= ((int) collector.getJewel())) {
                TextView textView2 = a.s;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(collector.getNext_jewel());
                sb2.append('/');
                sb2.append(collector.getNext_jewel());
                textView2.setText(sb2.toString());
            }
            YYUserInfo us = giftWallInfoModel.getUs();
            if (us != null) {
                YYRoomInfoManager.e().b(a(), a.i, us.getUid(), us.getAvatar());
                TextView textView3 = a.o;
                TextView textView4 = a.o;
                Intrinsics.c(textView4, "bind.tvName");
                TextView textView5 = a.r;
                Intrinsics.c(textView5, "bind.tvNameType");
                textView3.setText(a(us, textView4, textView5));
            }
        }
        if (collector.getLevel() == 1) {
            a.b.setVisibility(0);
            a.m.setVisibility(8);
            a.h.setVisibility(0);
            a.a.setVisibility(8);
            ArrayList<Integer> arrayList2 = new ArrayList<>();
            Resources resources3 = getContext().getResources();
            Integer valueOf3 = resources3 == null ? null : Integer.valueOf(resources3.getColor(R.color.syc_3883FD));
            Intrinsics.a(valueOf3);
            arrayList2.add(valueOf3);
            Resources resources4 = getContext().getResources();
            Integer valueOf4 = resources4 == null ? null : Integer.valueOf(resources4.getColor(R.color.syc_00E0AB));
            Intrinsics.a(valueOf4);
            arrayList2.add(valueOf4);
            a.c.setAlpha(1.0f);
            a.c.setMGradientColor(arrayList2);
            YYcollectorMode.SkinDTO skin2 = collector.getSkin();
            if (skin2 != null) {
                ImageLoader.a(a(), skin2.getWall_head()).a(a.f);
                ImageLoader.a(a(), skin2.getBadge()).a(a.h);
            }
            a.l.setMax(104);
            if (collector.getJewel() == 0) {
                a.l.setProgress(0);
            } else {
                a.l.setProgress(((int) ((((float) collector.getJewel()) / ((float) collector.getNext_jewel())) * 100)) + 4);
            }
            TextView textView6 = a.s;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(collector.getJewel());
            sb3.append('/');
            sb3.append(collector.getNext_jewel());
            textView6.setText(sb3.toString());
            a.u.setText(collector.getDescription());
            if (((int) collector.getNext_jewel()) <= ((int) collector.getJewel())) {
                TextView textView7 = a.s;
                StringBuilder sb4 = new StringBuilder();
                sb4.append(collector.getNext_jewel());
                sb4.append('/');
                sb4.append(collector.getNext_jewel());
                textView7.setText(sb4.toString());
            }
            YYUserInfo us2 = giftWallInfoModel.getUs();
            if (us2 != null) {
                YYRoomInfoManager.e().b(a(), a.i, us2.getUid(), us2.getAvatar());
                TextView textView8 = a.o;
                TextView textView9 = a.o;
                Intrinsics.c(textView9, "bind.tvName");
                TextView textView10 = a.r;
                Intrinsics.c(textView10, "bind.tvNameType");
                textView8.setText(a(us2, textView9, textView10));
            }
        }
        if (collector.getLevel() > 1) {
            a.b.setVisibility(8);
            a.a.setVisibility(0);
            a.g.setVisibility(0);
            ArrayList<Integer> arrayList3 = new ArrayList<>();
            Resources resources5 = getContext().getResources();
            Integer valueOf5 = resources5 == null ? null : Integer.valueOf(resources5.getColor(R.color.syc_52B0FF));
            Intrinsics.a(valueOf5);
            arrayList3.add(valueOf5);
            Resources resources6 = getContext().getResources();
            Integer valueOf6 = resources6 == null ? null : Integer.valueOf(resources6.getColor(R.color.syc_FF56F0));
            Intrinsics.a(valueOf6);
            arrayList3.add(valueOf6);
            a.c.setAlpha(1.0f);
            a.c.setMGradientColor(arrayList3);
            YYcollectorMode.SkinDTO skin3 = collector.getSkin();
            if (skin3 != null) {
                ImageLoader.a(a(), skin3.getWall_head()).a(a.e);
                ImageLoader.a(a(), skin3.getBadge()).a(a.g);
            }
            a.k.setMax(104);
            if (collector.getJewel() == 0) {
                a.k.setProgress(0);
            } else {
                a.k.setProgress(((int) ((((float) collector.getJewel()) / ((float) collector.getNext_jewel())) * 100)) + 4);
            }
            TextView textView11 = a.n;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(collector.getJewel());
            sb5.append('/');
            sb5.append(collector.getNext_jewel());
            textView11.setText(sb5.toString());
            a.t.setText(collector.getDescription());
            if (((int) collector.getNext_jewel()) <= ((int) collector.getJewel())) {
                TextView textView12 = a.n;
                StringBuilder sb6 = new StringBuilder();
                sb6.append(collector.getNext_jewel());
                sb6.append('/');
                sb6.append(collector.getNext_jewel());
                textView12.setText(sb6.toString());
            }
            YYUserInfo us3 = giftWallInfoModel.getUs();
            if (us3 == null) {
                return;
            }
            YYRoomInfoManager.e().b(a(), a.j, us3.getUid(), us3.getAvatar());
            TextView textView13 = a.p;
            TextView textView14 = a.p;
            Intrinsics.c(textView14, "bind.tvNameElite");
            TextView textView15 = a.q;
            Intrinsics.c(textView15, "bind.tvNameEliteType");
            textView13.setText(a(us3, textView14, textView15));
        }
    }

    public final ActivityFragmentActive a() {
        return this.c;
    }

    public final void a(ClickGiftListener clickGiftListener) {
        this.d = clickGiftListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
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

    public final Context getContext() {
        return this.a;
    }

    public final int getType() {
        return this.b;
    }
}
