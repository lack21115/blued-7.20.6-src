package com.blued.android.module.yy_china.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.utils.ClickUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.DialogYyFirstMeetBinding;
import com.blued.android.module.yy_china.databinding.ItemYyFirstMeetAllBinding;
import com.blued.android.module.yy_china.databinding.ItemYyFirstMeetAllItemBinding;
import com.blued.android.module.yy_china.databinding.ItemYyFirstMeetItemBinding;
import com.blued.android.module.yy_china.fragment.BaseFullScreenDialog;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYFirstMeetAdItemMode;
import com.blued.android.module.yy_china.model.YYFirstMeetGiftsListItemMode;
import com.blued.android.module.yy_china.model.YYFirstMeetMode;
import com.blued.android.module.yy_china.model.YYFirstUserInfoMode;
import com.blued.android.module.yy_china.model.YYGiftModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYFirstMeetDialog.class */
public final class YYFirstMeetDialog extends BaseFullScreenDialog {

    /* renamed from: a  reason: collision with root package name */
    private DialogYyFirstMeetBinding f18147a;
    private YYFirstMeetMode b;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYFirstMeetDialog$Ad.class */
    public static final class Ad extends BaseMultiItemQuickAdapter<YYFirstMeetAdItemMode, BaseViewHolder> {

        /* renamed from: a  reason: collision with root package name */
        private final BaseFullScreenDialog f18148a;
        private YYFirstUserInfoMode b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Ad(BaseFullScreenDialog fra) {
            super(new ArrayList());
            Intrinsics.e(fra, "fra");
            this.f18148a = fra;
            addItemType(1, R.layout.item_yy_first_meet_all);
            addItemType(2, R.layout.item_yy_first_meet_item);
        }

        private final void b(BaseViewHolder baseViewHolder, YYFirstMeetAdItemMode yYFirstMeetAdItemMode) {
            String avatar;
            ItemYyFirstMeetItemBinding a2 = ItemYyFirstMeetItemBinding.a(baseViewHolder.itemView);
            Intrinsics.c(a2, "bind(helper.itemView)");
            a2.b.setText("在我的聊天室完成“第一次”遇见，这些惊喜就是你的了~");
            BaseFullScreenDialog baseFullScreenDialog = this.f18148a;
            ActivityFragmentActive a3 = baseFullScreenDialog == null ? null : baseFullScreenDialog.a();
            YYFirstUserInfoMode yYFirstUserInfoMode = this.b;
            String str = "";
            if (yYFirstUserInfoMode != null && (avatar = yYFirstUserInfoMode.getAvatar()) != null) {
                str = avatar;
            }
            ImageLoader.a(a3, str).c().a(a2.f16714a);
        }

        private final void c(BaseViewHolder baseViewHolder, YYFirstMeetAdItemMode yYFirstMeetAdItemMode) {
            String avatar;
            ItemYyFirstMeetAllBinding a2 = ItemYyFirstMeetAllBinding.a(baseViewHolder.itemView);
            Intrinsics.c(a2, "bind(helper.itemView)");
            a2.d.setText("hi，给你准备了超大惊喜~");
            a2.f16710c.setLayoutManager(new GridLayoutManager(this.f18148a.getContext(), 3));
            AdGift adGift = new AdGift(this.f18148a);
            a2.f16710c.setAdapter(adGift);
            adGift.setNewData(yYFirstMeetAdItemMode.getGifts_lists());
            BaseFullScreenDialog baseFullScreenDialog = this.f18148a;
            ActivityFragmentActive a3 = baseFullScreenDialog == null ? null : baseFullScreenDialog.a();
            YYFirstUserInfoMode yYFirstUserInfoMode = this.b;
            String str = "";
            if (yYFirstUserInfoMode != null && (avatar = yYFirstUserInfoMode.getAvatar()) != null) {
                str = avatar;
            }
            ImageLoader.a(a3, str).c().a(a2.b);
        }

        public final void a(YYFirstUserInfoMode yYFirstUserInfoMode) {
            this.b = yYFirstUserInfoMode;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: a */
        public void convert(BaseViewHolder helper, YYFirstMeetAdItemMode item) {
            Intrinsics.e(helper, "helper");
            Intrinsics.e(item, "item");
            int itemType = item.getItemType();
            if (itemType == 1) {
                c(helper, item);
            } else if (itemType == 2) {
                b(helper, item);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYFirstMeetDialog$AdGift.class */
    public static final class AdGift extends BaseMultiItemQuickAdapter<YYFirstMeetGiftsListItemMode, BaseViewHolder> {

        /* renamed from: a  reason: collision with root package name */
        private final BaseFullScreenDialog f18149a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AdGift(BaseFullScreenDialog fra) {
            super(new ArrayList());
            Intrinsics.e(fra, "fra");
            this.f18149a = fra;
            addItemType(0, R.layout.item_yy_first_meet_all_item);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: a */
        public void convert(BaseViewHolder helper, YYFirstMeetGiftsListItemMode item) {
            Intrinsics.e(helper, "helper");
            Intrinsics.e(item, "item");
            ItemYyFirstMeetAllItemBinding a2 = ItemYyFirstMeetAllItemBinding.a(helper.itemView);
            Intrinsics.c(a2, "bind(helper.itemView)");
            ImageLoader.a(this.f18149a.a(), item.getPic()).g(-1).f().a(a2.f16711a);
            a2.b.setText(item.getName());
            if (StringUtils.a("goods_coupon", item.getType())) {
                a2.f16712c.setVisibility(0);
                a2.d.setVisibility(8);
                a2.f16712c.setText(item.getBeans());
                return;
            }
            a2.f16712c.setVisibility(8);
            a2.d.setVisibility(0);
            a2.d.setText(Intrinsics.a(item.getDuration(), (Object) "天"));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x00a6, code lost:
        if (r0 == null) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void a(final com.blued.android.module.yy_china.model.YYGiftModel r11, java.lang.String r12, boolean r13) {
        /*
            Method dump skipped, instructions count: 266
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.yy_china.view.YYFirstMeetDialog.a(com.blued.android.module.yy_china.model.YYGiftModel, java.lang.String, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYFirstMeetDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYFirstMeetDialog this$0, View view) {
        YYGiftModel goods_info;
        Intrinsics.e(this$0, "this$0");
        if (ClickUtils.a()) {
            return;
        }
        YYFirstMeetMode yYFirstMeetMode = this$0.b;
        if (yYFirstMeetMode != null && (goods_info = yYFirstMeetMode.getGoods_info()) != null) {
            this$0.a(goods_info, "", false);
        }
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        EventTrackYY.d(ChatRoomProtos.Event.YY_FIRST_MEET_POP_CLICK, b.room_id, b.uid);
    }

    private final DialogYyFirstMeetBinding g() {
        DialogYyFirstMeetBinding dialogYyFirstMeetBinding = this.f18147a;
        Intrinsics.a(dialogYyFirstMeetBinding);
        return dialogYyFirstMeetBinding;
    }

    private final void h() {
        g().f.setLayoutManager(new LinearLayoutManager(getContext()));
        Ad ad = new Ad(this);
        g().f.setAdapter(ad);
        g().g.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYFirstMeetDialog$zH1pV2wlaHZlNGmCb3ooNJezVGQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYFirstMeetDialog.a(YYFirstMeetDialog.this, view);
            }
        });
        YYFirstMeetMode yYFirstMeetMode = this.b;
        if (yYFirstMeetMode != null) {
            ad.a(yYFirstMeetMode.getInfo());
            ArrayList arrayList = new ArrayList();
            arrayList.add(new YYFirstMeetAdItemMode(1, yYFirstMeetMode.getGoods_info(), yYFirstMeetMode.getGifts_list()));
            arrayList.add(new YYFirstMeetAdItemMode(2, yYFirstMeetMode.getGoods_info(), yYFirstMeetMode.getGifts_list()));
            ad.setNewData(arrayList);
            ImageLoader.a(a(), yYFirstMeetMode.getGoods_info().images_static).a(g().f16428c);
            TextView textView = g().h;
            textView.setText((char) 65288 + yYFirstMeetMode.getGoods_info().beans + "弯豆）");
            TextView textView2 = g().i;
            textView2.setText("赠送价值" + yYFirstMeetMode.getGoods_info().beans + "弯豆的" + ((Object) yYFirstMeetMode.getGoods_info().name) + "即可完成和房主的第一次遇见");
            g().f16427a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYFirstMeetDialog$ja1iWq-dfX4tU311L_Xp_9Mhr-Q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYFirstMeetDialog.b(YYFirstMeetDialog.this, view);
                }
            });
        }
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        EventTrackYY.d(ChatRoomProtos.Event.YY_FIRST_MEET_POP_SHOW, b.room_id, b.uid);
    }

    public final void a(YYFirstMeetMode yYFirstMeetMode) {
        this.b = yYFirstMeetMode;
    }

    public final YYFirstMeetMode f() {
        return this.b;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.dialog_yy_first_meet, viewGroup, true);
        this.f18147a = DialogYyFirstMeetBinding.a(inflate);
        h();
        return inflate;
    }
}
