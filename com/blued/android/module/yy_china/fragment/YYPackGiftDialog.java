package com.blued.android.module.yy_china.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.ArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.ClickUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.utils.ImgURLMap;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.view.ObservableScrollView;
import com.blued.android.module.live.base.constants.LiveEventBusConstant;
import com.blued.android.module.live.base.model.LiveGiftNumberModel;
import com.blued.android.module.live.base.utils.LiveLogUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.YYConstants;
import com.blued.android.module.yy_china.databinding.DialogYyPackGiftBinding;
import com.blued.android.module.yy_china.databinding.ItemYyPackGiftBinding;
import com.blued.android.module.yy_china.databinding.ItemYyPackGiftTitleBinding;
import com.blued.android.module.yy_china.fragment.YYPackGiftDialog;
import com.blued.android.module.yy_china.manager.YYImMsgManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.SendGiftAndUserMode;
import com.blued.android.module.yy_china.model.YYGiftModel;
import com.blued.android.module.yy_china.model.YYItemRainMode;
import com.blued.android.module.yy_china.model.YYMsgJsonGiftExtra;
import com.blued.android.module.yy_china.model.YYPackGiftInfoItemMode;
import com.blued.android.module.yy_china.model.YYPackGiftInfoMode;
import com.blued.android.module.yy_china.model.YYPackGiftMode;
import com.blued.android.module.yy_china.model.YYPackGiftTrueGiftInfoMode;
import com.blued.android.module.yy_china.model.YYPackGiftUserMode;
import com.blued.android.module.yy_china.model.YYPayGoodsModel;
import com.blued.android.module.yy_china.model.YYPayMode;
import com.blued.android.module.yy_china.model.YYPayRequestModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.utils.YYPayUtils;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYPackGiftDialog.class */
public final class YYPackGiftDialog extends BaseFullScreenDialog {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f17355a = new Companion(null);
    private DialogYyPackGiftBinding b;
    private long g;

    /* renamed from: c  reason: collision with root package name */
    private final PackInfoAdapter f17356c = new PackInfoAdapter(this);
    private final PackGiftAdapter d = new PackGiftAdapter(this);
    private final PackUserAdapter e = new PackUserAdapter(this);
    private final PackHandler f = new PackHandler(this);
    private String h = "";
    private final ArrayList<YYPackGiftTrueGiftInfoMode> i = new ArrayList<>();
    private final HashSet<YYPackGiftUserMode> j = new HashSet<>();
    private final ArrayMap<String, Long> k = new ArrayMap<>();
    private final ArrayMap<String, Integer> l = new ArrayMap<>();
    private final ArrayList<String> m = new ArrayList<>();

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYPackGiftDialog$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYPackGiftDialog$PackGiftAdapter.class */
    public final class PackGiftAdapter extends BaseQuickAdapter<YYPackGiftTrueGiftInfoMode, BaseViewHolder> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ YYPackGiftDialog f17357a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PackGiftAdapter(YYPackGiftDialog this$0) {
            super(R.layout.item_yy_pack_gift);
            Intrinsics.e(this$0, "this$0");
            this.f17357a = this$0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(YYPackGiftDialog this$0, YYPackGiftTrueGiftInfoMode item, PackGiftAdapter this$1, View view) {
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(item, "$item");
            Intrinsics.e(this$1, "this$1");
            if (this$0.f().size() <= 1) {
                ToastUtils.a("必须选择一个礼物");
                return;
            }
            this$0.f().remove(item);
            this$1.notifyDataSetChanged();
            this$0.h();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(YYPackGiftDialog this$0, YYPackGiftTrueGiftInfoMode item, PackGiftAdapter this$1, View view) {
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(item, "$item");
            Intrinsics.e(this$1, "this$1");
            if (!this$0.f().contains(item)) {
                this$0.f().add(item);
            }
            this$1.notifyDataSetChanged();
            this$0.h();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: a */
        public void convert(BaseViewHolder helper, final YYPackGiftTrueGiftInfoMode item) {
            Intrinsics.e(helper, "helper");
            Intrinsics.e(item, "item");
            ItemYyPackGiftBinding a2 = ItemYyPackGiftBinding.a(helper.itemView);
            Intrinsics.c(a2, "bind(helper.itemView)");
            a2.d.setText(item.getInfo().name);
            if (item.getSent_num() > 0) {
                a2.e.setVisibility(0);
            } else {
                a2.e.setVisibility(8);
            }
            a2.e.setText(Intrinsics.a("已送x", (Object) Integer.valueOf(item.getSent_num())));
            a2.f16772c.setText(String.valueOf(item.getInfo().beans));
            ImageLoader.a(this.f17357a.a(), item.getInfo().images_static).a(a2.f16771a);
            boolean z = false;
            for (YYPackGiftTrueGiftInfoMode yYPackGiftTrueGiftInfoMode : this.f17357a.f()) {
                if (StringUtils.a(yYPackGiftTrueGiftInfoMode.getInfo().goods_id, item.getInfo().goods_id)) {
                    z = true;
                }
            }
            if (z) {
                a2.b.setVisibility(0);
                ConstraintLayout root = a2.getRoot();
                final YYPackGiftDialog yYPackGiftDialog = this.f17357a;
                root.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYPackGiftDialog$PackGiftAdapter$qnUKmp85pf7Zh-gT6m5-ghV_ikU
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        YYPackGiftDialog.PackGiftAdapter.a(YYPackGiftDialog.this, item, this, view);
                    }
                });
                return;
            }
            a2.b.setVisibility(8);
            ConstraintLayout root2 = a2.getRoot();
            final YYPackGiftDialog yYPackGiftDialog2 = this.f17357a;
            root2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYPackGiftDialog$PackGiftAdapter$BdPLuFOtJIfj5tcrGJL64rWQ1UM
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYPackGiftDialog.PackGiftAdapter.b(YYPackGiftDialog.this, item, this, view);
                }
            });
        }
    }

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYPackGiftDialog$PackHandler.class */
    public static final class PackHandler extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<YYPackGiftDialog> f17358a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PackHandler(YYPackGiftDialog yyPackGiftDialog) {
            super(Looper.getMainLooper());
            Intrinsics.e(yyPackGiftDialog, "yyPackGiftDialog");
            this.f17358a = new WeakReference<>(yyPackGiftDialog);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            WeakReference<YYPackGiftDialog> weakReference;
            YYPackGiftDialog yYPackGiftDialog;
            Intrinsics.e(msg, "msg");
            super.handleMessage(msg);
            if (msg.what != 1 || (weakReference = this.f17358a) == null || (yYPackGiftDialog = weakReference.get()) == null) {
                return;
            }
            yYPackGiftDialog.b(true);
        }
    }

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYPackGiftDialog$PackInfoAdapter.class */
    public final class PackInfoAdapter extends BaseQuickAdapter<YYPackGiftInfoItemMode, BaseViewHolder> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ YYPackGiftDialog f17359a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PackInfoAdapter(YYPackGiftDialog this$0) {
            super(R.layout.item_yy_pack_gift_title);
            Intrinsics.e(this$0, "this$0");
            this.f17359a = this$0;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: a */
        public void convert(BaseViewHolder helper, YYPackGiftInfoItemMode item) {
            Intrinsics.e(helper, "helper");
            Intrinsics.e(item, "item");
            ItemYyPackGiftTitleBinding a2 = ItemYyPackGiftTitleBinding.a(helper.itemView);
            Intrinsics.c(a2, "bind(helper.itemView)");
            a2.b.setText(item.getName());
            ImageLoader.a(this.f17359a.a(), item.getIcon()).a(a2.f16773a);
        }
    }

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYPackGiftDialog$PackUserAdapter.class */
    public final class PackUserAdapter extends BaseQuickAdapter<YYPackGiftUserMode, BaseViewHolder> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ YYPackGiftDialog f17360a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PackUserAdapter(YYPackGiftDialog this$0) {
            super(R.layout.item_yy_pack_gift_user);
            Intrinsics.e(this$0, "this$0");
            this.f17360a = this$0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(YYPackGiftDialog this$0, YYPackGiftUserMode item, PackUserAdapter this$1, View view) {
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(item, "$item");
            Intrinsics.e(this$1, "this$1");
            this$0.g().remove(item);
            this$1.notifyDataSetChanged();
            this$0.h();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(YYPackGiftDialog this$0, YYPackGiftUserMode item, PackUserAdapter this$1, View view) {
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(item, "$item");
            Intrinsics.e(this$1, "this$1");
            this$0.g().add(item);
            this$1.notifyDataSetChanged();
            this$0.h();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:14:0x009a  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x00b7  */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void convert(com.chad.library.adapter.base.BaseViewHolder r8, final com.blued.android.module.yy_china.model.YYPackGiftUserMode r9) {
            /*
                r7 = this;
                r0 = r8
                java.lang.String r1 = "helper"
                kotlin.jvm.internal.Intrinsics.e(r0, r1)
                r0 = r9
                java.lang.String r1 = "item"
                kotlin.jvm.internal.Intrinsics.e(r0, r1)
                r0 = r8
                android.view.View r0 = r0.itemView
                com.blued.android.module.yy_china.databinding.ItemYyPackGiftUserBinding r0 = com.blued.android.module.yy_china.databinding.ItemYyPackGiftUserBinding.a(r0)
                r8 = r0
                r0 = r8
                java.lang.String r1 = "bind(helper.itemView)"
                kotlin.jvm.internal.Intrinsics.c(r0, r1)
                com.blued.android.module.yy_china.manager.YYRoomInfoManager r0 = com.blued.android.module.yy_china.manager.YYRoomInfoManager.e()
                r1 = r7
                com.blued.android.module.yy_china.fragment.YYPackGiftDialog r1 = r1.f17360a
                com.blued.android.core.ui.ActivityFragmentActive r1 = r1.a()
                com.blued.android.core.net.IRequestHost r1 = (com.blued.android.core.net.IRequestHost) r1
                r2 = r8
                com.blued.android.module.common.view.SquareImageView r2 = r2.f16775a
                android.widget.ImageView r2 = (android.widget.ImageView) r2
                r3 = r9
                java.lang.String r3 = r3.getUid()
                r4 = r9
                java.lang.String r4 = r4.getAvatar()
                r0.a(r1, r2, r3, r4)
                r0 = r7
                java.util.List r0 = r0.getData()
                r1 = 0
                java.lang.Object r0 = r0.get(r1)
                com.blued.android.module.yy_china.model.YYPackGiftUserMode r0 = (com.blued.android.module.yy_china.model.YYPackGiftUserMode) r0
                java.lang.String r0 = r0.getUid()
                r1 = r9
                java.lang.String r1 = r1.getUid()
                boolean r0 = com.blued.android.framework.utils.StringUtils.a(r0, r1)
                if (r0 == 0) goto L7e
                com.blued.android.module.yy_china.manager.YYRoomInfoManager r0 = com.blued.android.module.yy_china.manager.YYRoomInfoManager.e()
                com.blued.android.module.yy_china.model.YYRoomModel r0 = r0.b()
                r11 = r0
                r0 = r11
                if (r0 != 0) goto L65
                r0 = 0
                r10 = r0
                goto L6b
            L65:
                r0 = r11
                boolean r0 = r0.isEntertainmentChannel()
                r10 = r0
            L6b:
                r0 = r10
                if (r0 == 0) goto L7e
                r0 = r8
                android.widget.TextView r0 = r0.f16776c
                java.lang.String r1 = "主持人"
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                r0.setText(r1)
                goto L8c
            L7e:
                r0 = r8
                android.widget.TextView r0 = r0.f16776c
                r1 = r9
                java.lang.String r1 = r1.getChatAnchorName()
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                r0.setText(r1)
            L8c:
                r0 = r7
                com.blued.android.module.yy_china.fragment.YYPackGiftDialog r0 = r0.f17360a
                java.util.HashSet r0 = r0.g()
                r1 = r9
                boolean r0 = r0.contains(r1)
                if (r0 == 0) goto Lb7
                r0 = r8
                android.widget.ImageView r0 = r0.b
                r1 = 0
                r0.setVisibility(r1)
                r0 = r8
                androidx.constraintlayout.widget.ConstraintLayout r0 = r0.getRoot()
                com.blued.android.module.yy_china.fragment.-$$Lambda$YYPackGiftDialog$PackUserAdapter$q1-sgXybYqPRGlP27gkVmFzzKNA r1 = new com.blued.android.module.yy_china.fragment.-$$Lambda$YYPackGiftDialog$PackUserAdapter$q1-sgXybYqPRGlP27gkVmFzzKNA
                r2 = r1
                r3 = r7
                com.blued.android.module.yy_china.fragment.YYPackGiftDialog r3 = r3.f17360a
                r4 = r9
                r5 = r7
                r2.<init>()
                r0.setOnClickListener(r1)
                return
            Lb7:
                r0 = r8
                android.widget.ImageView r0 = r0.b
                r1 = 8
                r0.setVisibility(r1)
                r0 = r8
                androidx.constraintlayout.widget.ConstraintLayout r0 = r0.getRoot()
                com.blued.android.module.yy_china.fragment.-$$Lambda$YYPackGiftDialog$PackUserAdapter$0mZfJPanDcgLs_iltskBYtpKplg r1 = new com.blued.android.module.yy_china.fragment.-$$Lambda$YYPackGiftDialog$PackUserAdapter$0mZfJPanDcgLs_iltskBYtpKplg
                r2 = r1
                r3 = r7
                com.blued.android.module.yy_china.fragment.YYPackGiftDialog r3 = r3.f17360a
                r4 = r9
                r5 = r7
                r2.<init>()
                r0.setOnClickListener(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.yy_china.fragment.YYPackGiftDialog.PackUserAdapter.convert(com.chad.library.adapter.base.BaseViewHolder, com.blued.android.module.yy_china.model.YYPackGiftUserMode):void");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYPackGiftDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYPackGiftDialog this$0, ObservableScrollView observableScrollView, int i, int i2, int i3, int i4) {
        Intrinsics.e(this$0, "this$0");
        if (i2 >= 10) {
            this$0.k().j.setVisibility(8);
            this$0.k().i.setVisibility(8);
            return;
        }
        this$0.k().j.setVisibility(0);
        this$0.k().i.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v17, types: [T, java.lang.Long] */
    /* JADX WARN: Type inference failed for: r1v46, types: [T, java.lang.Long] */
    /* JADX WARN: Type inference failed for: r1v52, types: [T, java.lang.Long] */
    /* JADX WARN: Type inference failed for: r1v54, types: [T, java.lang.Long] */
    /* JADX WARN: Type inference failed for: r1v6, types: [T, java.lang.Object] */
    public final void a(final ArrayList<SendGiftAndUserMode> arrayList, final int i, final String str, final boolean z, final boolean z2) {
        LiveGiftNumberModel liveGiftNumberModel;
        if (arrayList.size() <= 0) {
            return;
        }
        final YYGiftModel selectedModel = arrayList.get(0).getSelectedModel();
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        SendGiftAndUserMode sendGiftAndUserMode = arrayList.get(0);
        Intrinsics.c(sendGiftAndUserMode, "wantSel[0]");
        SendGiftAndUserMode sendGiftAndUserMode2 = sendGiftAndUserMode;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.f42545a = this.k.get(Intrinsics.a(sendGiftAndUserMode2.getUid(), (Object) sendGiftAndUserMode2.getSelectedModel().goods_id));
        final Ref.IntRef intRef = new Ref.IntRef();
        Integer num = this.l.get(Intrinsics.a(sendGiftAndUserMode2.getUid(), (Object) sendGiftAndUserMode2.getSelectedModel().goods_id));
        Integer num2 = num;
        if (num == null) {
            num2 = 0;
        }
        intRef.f42543a = num2.intValue();
        if (objectRef.f42545a == 0) {
            objectRef.f42545a = -1L;
        }
        if (selectedModel.double_hit == 1) {
            YYGiftModel selectedModel2 = sendGiftAndUserMode2.getSelectedModel();
            if (((selectedModel2 == null || (liveGiftNumberModel = selectedModel2.selectedGiftNumModel) == null) ? 0 : liveGiftNumberModel.count) > 1) {
                objectRef.f42545a = 0L;
            } else if (!this.m.contains(selectedModel.goods_id) || ((Number) objectRef.f42545a).longValue() <= 0 || selectedModel.comboWaitTime <= 0) {
                objectRef.f42545a = Long.valueOf(System.currentTimeMillis());
                intRef.f42543a = 0;
            } else {
                objectRef.f42545a = objectRef.f42545a;
            }
        } else {
            this.k.clear();
            intRef.f42543a = 0;
            objectRef.f42545a = 0L;
        }
        YYPayRequestModel yYPayRequestModel = new YYPayRequestModel();
        yYPayRequestModel.gift = selectedModel;
        yYPayRequestModel.beans = selectedModel.beans;
        yYPayRequestModel.giftCount = i;
        yYPayRequestModel.goods_id = selectedModel.goods_id;
        yYPayRequestModel.goods_type = selectedModel.goods_type;
        yYPayRequestModel.hit_id = ((Number) objectRef.f42545a).longValue();
        yYPayRequestModel.payCode = str;
        yYPayRequestModel.remember_me = z;
        yYPayRequestModel.room_id = b.room_id;
        yYPayRequestModel.target_uid = arrayList.get(0).getUid();
        yYPayRequestModel.isFirstToMicsInTeam = sendGiftAndUserMode2.isFirstToMicsInTeam();
        YYPayUtils.a(yYPayRequestModel, YYConstants.PayFromSource.Pay_Gift, this, a(), new YYPayUtils.PayGiftStatusListener() { // from class: com.blued.android.module.yy_china.fragment.YYPackGiftDialog$buyGift$1
            @Override // com.blued.android.module.yy_china.utils.YYPayUtils.PayGiftStatusListener
            public void a(int i2, String errorMessage) {
                Intrinsics.e(errorMessage, "errorMessage");
                if (i2 == 4032007) {
                    YYPayUtils.a(this);
                }
                LiveLogUtils.a("套系礼物--->buy--->" + ((Object) YYGiftModel.this.goods_id) + "--->erro  " + i2 + "    " + errorMessage);
            }

            @Override // com.blued.android.module.yy_china.utils.YYPayUtils.PayGiftStatusListener
            public void a(YYPayGoodsModel model) {
                ArrayMap arrayMap;
                ArrayMap arrayMap2;
                ArrayMap arrayMap3;
                ArrayMap arrayMap4;
                ArrayMap arrayMap5;
                Intrinsics.e(model, "model");
                model.beans = model.users_sums_left;
                YYGiftModel.this.extra = model.extra;
                ArrayList<SendGiftAndUserMode> arrayList2 = arrayList;
                if (arrayList2 == null || arrayList2.size() <= 0) {
                    return;
                }
                SendGiftAndUserMode remove = arrayList.remove(0);
                Intrinsics.c(remove, "wantSel.removeAt(0)");
                SendGiftAndUserMode sendGiftAndUserMode3 = remove;
                YYSeatMemberModel yYSeatMemberModel = new YYSeatMemberModel();
                yYSeatMemberModel.setUid(sendGiftAndUserMode3.getUid());
                yYSeatMemberModel.setName(sendGiftAndUserMode3.getName());
                yYSeatMemberModel.setAvatar(sendGiftAndUserMode3.getAvatar());
                yYSeatMemberModel.chat_anchor = String.valueOf(sendGiftAndUserMode3.getRoom_role());
                if (i > 1) {
                    sendGiftAndUserMode3.getSelectedModel().hit_batch = 1;
                    arrayMap5 = this.l;
                    arrayMap5.put(Intrinsics.a(sendGiftAndUserMode3.getUid(), (Object) sendGiftAndUserMode3.getSelectedModel().goods_id), Integer.valueOf(i));
                } else {
                    sendGiftAndUserMode3.getSelectedModel().hit_batch = 0;
                    if (sendGiftAndUserMode3.getSelectedModel().double_hit == 1) {
                        arrayMap = this.l;
                        arrayMap.put(Intrinsics.a(sendGiftAndUserMode3.getUid(), (Object) sendGiftAndUserMode3.getSelectedModel().goods_id), Integer.valueOf(intRef.f42543a + 1));
                    }
                }
                arrayMap2 = this.k;
                arrayMap2.put(Intrinsics.a(sendGiftAndUserMode3.getUid(), (Object) sendGiftAndUserMode3.getSelectedModel().goods_id), objectRef.f42545a);
                YYGiftModel selectedModel3 = sendGiftAndUserMode3.getSelectedModel();
                arrayMap3 = this.k;
                Long l = (Long) arrayMap3.get(Intrinsics.a(sendGiftAndUserMode3.getUid(), (Object) sendGiftAndUserMode3.getSelectedModel().goods_id));
                selectedModel3.hit_id = l == null ? 0L : l.longValue();
                YYGiftModel selectedModel4 = sendGiftAndUserMode3.getSelectedModel();
                arrayMap4 = this.l;
                Integer num3 = (Integer) arrayMap4.get(Intrinsics.a(sendGiftAndUserMode3.getUid(), (Object) sendGiftAndUserMode3.getSelectedModel().goods_id));
                selectedModel4.hit_count = num3 == null ? 0 : num3.intValue();
                YYImMsgManager.a().a(sendGiftAndUserMode3.getSelectedModel(), yYSeatMemberModel, model, false);
                if (arrayList.size() > 0) {
                    this.a(arrayList, i, str, z, z2);
                    return;
                }
                ToastUtils.a("赠送成功");
                if (z2) {
                    this.dismissAllowingStateLoss();
                } else {
                    this.a(false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(View view) {
        LiveEventBus.get("show_inner_dialog").post(YYRoomInfoManager.e().c().a(18));
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        EventTrackYY.d(ChatRoomProtos.Event.YY_LOVE_GIFT_PAGE_QA_CLICK, b.room_id, b.uid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYPackGiftDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        if (this$0.k().m.getVisibility() == 8) {
            ToastUtils.a("当前聊天室无可送礼对象，请稍后重试");
        } else if (ClickUtils.a()) {
        } else {
            YYRoomModel b = YYRoomInfoManager.e().b();
            if ((b == null ? 0 : b.open_batch_gifts) == 1) {
                this$0.i();
            } else {
                this$0.j();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DialogYyPackGiftBinding k() {
        DialogYyPackGiftBinding dialogYyPackGiftBinding = this.b;
        Intrinsics.a(dialogYyPackGiftBinding);
        return dialogYyPackGiftBinding;
    }

    private final void l() {
        k().k.setLayoutManager(new GridLayoutManager(getContext(), 3));
        k().k.setAdapter(this.f17356c);
        k().l.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        k().l.setAdapter(this.d);
        k().m.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        k().m.setAdapter(this.e);
        ImageLoader.a(a(), ImgURLMap.f10885a.a("yy_pack_gift_bg_title")).a(k().h);
        ImageLoader.a(a(), ImgURLMap.f10885a.a("yy_pack_gift_bg_big")).a(k().g);
        ImageLoader.a(a(), ImgURLMap.f10885a.a("yy_pack_gift_url_card_top")).a(k().b);
        ImageLoader.a(a(), ImgURLMap.f10885a.a("yy_pack_gift_url_btn_send_gift")).a(new SimpleTarget<Drawable>() { // from class: com.blued.android.module.yy_china.fragment.YYPackGiftDialog$initView$1
            @Override // com.bumptech.glide.request.target.Target
            /* renamed from: a */
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                DialogYyPackGiftBinding k;
                Intrinsics.e(resource, "resource");
                k = YYPackGiftDialog.this.k();
                k.f16447c.setBackground(resource);
            }
        });
        ImageLoader.a(a(), ImgURLMap.f10885a.a("yy_pack_gift_url_start")).a(k().j);
        ImageLoader.a(a(), ImgURLMap.f10885a.a("yy_pack_gift_url_heart")).a(k().i);
        k().n.setScrollViewListener(new ObservableScrollView.ScrollViewListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYPackGiftDialog$M_fbhxGmmF-z0g841eGshH-9z08
            @Override // com.blued.android.module.common.view.ObservableScrollView.ScrollViewListener
            public final void onScrollChanged(ObservableScrollView observableScrollView, int i, int i2, int i3, int i4) {
                YYPackGiftDialog.a(YYPackGiftDialog.this, observableScrollView, i, i2, i3, i4);
            }
        });
        k().f.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYPackGiftDialog$-IiQSzGRWI8pwzB2plW7GXXXKBo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYPackGiftDialog.a(YYPackGiftDialog.this, view);
            }
        });
        k().d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYPackGiftDialog$PaplZh8cvyiY7XBvhmJbkHQ_mXI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYPackGiftDialog.a(view);
            }
        });
        k().e.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYPackGiftDialog$yjUPbPungCC_vclQ1MQqw2XZvV0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYPackGiftDialog.b(view);
            }
        });
        a(true);
        LiveLogUtils.a("open--->套系礼物弹窗");
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        EventTrackYY.d(ChatRoomProtos.Event.YY_LOVE_GIFT_PAGE_SHOW, b.room_id, b.uid);
    }

    public final void a(long j) {
        this.g = j;
    }

    /* JADX WARN: Type inference failed for: r1v21, types: [java.lang.Object] */
    public final void a(YYPackGiftMode yYPackGiftMode, boolean z) {
        Iterator<YYSeatMemberModel> it;
        ArrayList<YYPackGiftInfoItemMode> item;
        if (yYPackGiftMode != null) {
            k().f16447c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYPackGiftDialog$yPzLACaCwLRnaPsx03kR2_pv-lc
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYPackGiftDialog.b(YYPackGiftDialog.this, view);
                }
            });
            long round_end_time = yYPackGiftMode.getRound_end_time();
            long j = 1000;
            long currentTimeMillis = System.currentTimeMillis();
            a(yYPackGiftMode.getRound_end_time() * j);
            a(yYPackGiftMode.getUnlock_privileges().getRemark1());
            if ((round_end_time * j) - currentTimeMillis <= 0 || yYPackGiftMode.getRound_end_time() == 0) {
                k().r.setTextSize(15.0f);
                TextView textView = k().r;
                YYPackGiftInfoMode unlock_privileges = yYPackGiftMode.getUnlock_privileges();
                textView.setText(unlock_privileges == null ? null : unlock_privileges.getRemark1());
                TextView textView2 = k().q;
                YYPackGiftInfoMode unlock_privileges2 = yYPackGiftMode.getUnlock_privileges();
                textView2.setText(unlock_privileges2 == null ? null : unlock_privileges2.getRemark2());
            } else {
                b(false);
                k().q.setText("内送出全部套系礼物可解锁以下全部特权");
            }
            YYPackGiftInfoMode unlock_privileges3 = yYPackGiftMode.getUnlock_privileges();
            if (unlock_privileges3 != null && (item = unlock_privileges3.getItem()) != null) {
                this.f17356c.setNewData(item);
            }
            ArrayList<YYPackGiftTrueGiftInfoMode> true_love_gift_info = yYPackGiftMode.getTrue_love_gift_info();
            if (true_love_gift_info != null) {
                if (this.d.getData().size() > 0) {
                    List<YYPackGiftTrueGiftInfoMode> data = this.d.getData();
                    Intrinsics.c(data, "giftAdapter.data");
                    for (YYPackGiftTrueGiftInfoMode yYPackGiftTrueGiftInfoMode : data) {
                        for (YYPackGiftTrueGiftInfoMode yYPackGiftTrueGiftInfoMode2 : true_love_gift_info) {
                            if (StringUtils.a(yYPackGiftTrueGiftInfoMode.getInfo().goods_id, yYPackGiftTrueGiftInfoMode2.getInfo().goods_id)) {
                                yYPackGiftTrueGiftInfoMode.setSent_num(yYPackGiftTrueGiftInfoMode2.getSent_num());
                            }
                        }
                    }
                    this.d.notifyDataSetChanged();
                } else {
                    f().add(true_love_gift_info.get(0));
                    this.d.setNewData(true_love_gift_info);
                }
            }
            ArrayList arrayList = new ArrayList();
            YYRoomModel b = YYRoomInfoManager.e().b();
            if (b == null) {
                it = null;
            } else {
                List<YYSeatMemberModel> list = b.mics;
                it = list == null ? null : list.iterator();
            }
            if (it != null) {
                while (it.hasNext()) {
                    YYSeatMemberModel next = it.next();
                    if (next.position_status == 1 && !StringUtils.a(next.getUid(), YYRoomInfoManager.e().k())) {
                        String name = next.getName();
                        Intrinsics.c(name, "it.name");
                        String uid = next.getUid();
                        Intrinsics.c(uid, "it.uid");
                        String avatar = next.getAvatar();
                        String str = next.chat_anchor;
                        Intrinsics.c(str, "it.chat_anchor");
                        arrayList.add(new YYPackGiftUserMode(name, uid, avatar, str));
                    }
                }
            }
            if (z) {
                if (arrayList.size() > 0) {
                    k().m.setVisibility(0);
                    k().p.setVisibility(0);
                    g().clear();
                    g().add(arrayList.get(0));
                    this.e.setNewData(arrayList);
                } else {
                    k().m.setVisibility(8);
                    k().p.setVisibility(4);
                }
            }
        }
        h();
    }

    public final void a(String str) {
        Intrinsics.e(str, "<set-?>");
        this.h = str;
    }

    public final void a(final boolean z) {
        final ActivityFragmentActive a2 = a();
        YYRoomHttpUtils.p(new BluedUIHttpResponse<BluedEntityA<YYPackGiftMode>>(a2) { // from class: com.blued.android.module.yy_china.fragment.YYPackGiftDialog$loadData$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYPackGiftMode> bluedEntityA) {
                YYPackGiftMode singleData;
                if (bluedEntityA == null || (singleData = bluedEntityA.getSingleData()) == null) {
                    return;
                }
                YYPackGiftDialog.this.a(singleData, z);
            }
        }, a());
    }

    public final void b(boolean z) {
        long j = 1000;
        long currentTimeMillis = (this.g - System.currentTimeMillis()) - j;
        this.f.removeMessages(1);
        if (currentTimeMillis <= 0) {
            k().r.setText(this.h);
            if (z) {
                a(false);
                return;
            }
            return;
        }
        k().r.setTextSize(20.0f);
        TextView textView = k().r;
        StringBuilder sb = new StringBuilder();
        sb.append(currentTimeMillis / j);
        sb.append('s');
        textView.setText(sb.toString());
        this.f.sendEmptyMessageDelayed(1, 1000L);
    }

    public final ArrayList<YYPackGiftTrueGiftInfoMode> f() {
        return this.i;
    }

    public final HashSet<YYPackGiftUserMode> g() {
        return this.j;
    }

    public final void h() {
        k().f16447c.setText("0弯豆 送礼");
        if (this.j.size() <= 0 || this.i.size() <= 0) {
            return;
        }
        long j = 0;
        for (YYPackGiftTrueGiftInfoMode yYPackGiftTrueGiftInfoMode : this.i) {
            j += g().size() * yYPackGiftTrueGiftInfoMode.getInfo().beans;
        }
        k().f16447c.setText(j + "弯豆 送礼");
    }

    /* JADX WARN: Type inference failed for: r1v21, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v31, types: [T, java.lang.String] */
    public final void i() {
        if (this.i.size() <= 0) {
            ToastUtils.a("请选择套系礼物");
        } else if (this.j.size() <= 0) {
            ToastUtils.a("请选择送礼对象");
        } else {
            final ArrayList arrayList = new ArrayList();
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            String str = "";
            objectRef.f42545a = "";
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.f42545a = "";
            for (YYPackGiftTrueGiftInfoMode yYPackGiftTrueGiftInfoMode : this.i) {
                objectRef2.f42545a = ((String) objectRef2.f42545a) + ((Object) yYPackGiftTrueGiftInfoMode.getInfo().goods_id) + ',';
                Iterator<YYPackGiftUserMode> it = g().iterator();
                boolean z = true;
                String str2 = str;
                while (true) {
                    str = str2;
                    if (it.hasNext()) {
                        YYPackGiftUserMode next = it.next();
                        YYGiftModel info = yYPackGiftTrueGiftInfoMode.getInfo();
                        String uid = next.getUid();
                        String name = next.getName();
                        String avatar = next.getAvatar();
                        if (avatar == null) {
                            avatar = str2;
                        }
                        arrayList.add(new SendGiftAndUserMode(info, uid, name, avatar, Integer.parseInt(next.getChat_anchor()), z));
                        z = false;
                    }
                }
            }
            for (YYPackGiftUserMode yYPackGiftUserMode : this.j) {
                objectRef.f42545a = ((String) objectRef.f42545a) + yYPackGiftUserMode.getUid() + ',';
            }
            YYRoomModel b = YYRoomInfoManager.e().b();
            if (b == null) {
                return;
            }
            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            Iterator<YYPackGiftTrueGiftInfoMode> it2 = this.i.iterator();
            while (it2.hasNext()) {
                if (it2.next().getInfo().beans > 500) {
                    booleanRef.f42538a = true;
                }
            }
            YYRoomModel b2 = YYRoomInfoManager.e().b();
            if (b2 != null) {
                EventTrackYY.k(ChatRoomProtos.Event.YY_LOVE_GIFT_PAGE_ONE_SEND_CLICK, b2.room_id, b2.uid, (String) objectRef2.f42545a);
            }
            final ActivityFragmentActive a2 = a();
            YYRoomHttpUtils.c(b.room_id, (String) objectRef.f42545a, (String) objectRef2.f42545a, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<YYPayMode>>(a2) { // from class: com.blued.android.module.yy_china.fragment.YYPackGiftDialog$play2$5
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<YYPayMode> bluedEntityA) {
                    YYPayMode singleData;
                    if (bluedEntityA == null || (singleData = bluedEntityA.getSingleData()) == null) {
                        return;
                    }
                    ArrayList<SendGiftAndUserMode> arrayList2 = arrayList;
                    Ref.ObjectRef<String> objectRef3 = objectRef;
                    Ref.ObjectRef<String> objectRef4 = objectRef2;
                    Ref.BooleanRef booleanRef2 = booleanRef;
                    YYPackGiftDialog yYPackGiftDialog = this;
                    for (SendGiftAndUserMode sendGiftAndUserMode : arrayList2) {
                        ToastUtils.a("赠送成功");
                        YYSeatMemberModel yYSeatMemberModel = new YYSeatMemberModel();
                        yYSeatMemberModel.setUid(sendGiftAndUserMode.getUid());
                        yYSeatMemberModel.setName(sendGiftAndUserMode.getName());
                        yYSeatMemberModel.setAvatar(sendGiftAndUserMode.getAvatar());
                        yYSeatMemberModel.chat_anchor = String.valueOf(sendGiftAndUserMode.getRoom_role());
                        YYPayGoodsModel yYPayGoodsModel = new YYPayGoodsModel();
                        yYPayGoodsModel.current_wealth = singleData.getCurrent_wealth();
                        yYPayGoodsModel.next_wealth = singleData.getNext_wealth();
                        yYPayGoodsModel.users_sums_left = singleData.getUsers_sums_left();
                        yYPayGoodsModel.beans_current = singleData.getBeans_current();
                        ArrayList<YYItemRainMode> goods_rain_list = singleData.getGoods_rain_list();
                        if (goods_rain_list != null) {
                            for (YYItemRainMode yYItemRainMode : goods_rain_list) {
                                if (StringUtils.a(yYItemRainMode.getGoods_id(), sendGiftAndUserMode.getSelectedModel().goods_id) && !StringUtils.b(yYItemRainMode.getRain())) {
                                    if (sendGiftAndUserMode.isFirstToMicsInTeam()) {
                                        yYPayGoodsModel.json_contents_im = yYItemRainMode.getRain();
                                    } else {
                                        YYMsgJsonGiftExtra yYMsgJsonGiftExtra = (YYMsgJsonGiftExtra) AppInfo.f().fromJson(yYItemRainMode.getRain(), (Class<Object>) YYMsgJsonGiftExtra.class);
                                        yYMsgJsonGiftExtra.setRain_level_ani_url("");
                                        yYPayGoodsModel.json_contents_im = AppInfo.f().toJson(yYMsgJsonGiftExtra);
                                    }
                                }
                            }
                        }
                        YYImMsgManager.a().a(sendGiftAndUserMode.getSelectedModel(), yYSeatMemberModel, yYPayGoodsModel, false);
                        YYRoomModel b3 = YYRoomInfoManager.e().b();
                        if (b3 != null && singleData != null && singleData.getCurrent_wealth() != null && singleData.getNext_wealth() != null) {
                            b3.wealth_level = singleData.getCurrent_wealth().getWealth_level();
                            b3.enter_effects = singleData.getCurrent_wealth().getEnter_effects();
                            b3.avatar_frame = singleData.getCurrent_wealth().getAvatar_frame();
                        }
                        LiveLogUtils.a("套系礼物--->buy_all--->" + objectRef3.f42545a + "    " + objectRef4.f42545a);
                        if (booleanRef2.f42538a) {
                            LiveEventBus.get(LiveEventBusConstant.e).post("");
                        } else {
                            yYPackGiftDialog.a(false);
                        }
                    }
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public boolean onUIFailure(int i, String str3) {
                    LiveLogUtils.a("套系礼物--->buy_all--->erro  " + i + "    " + ((Object) str3));
                    if (i == 4032007) {
                        YYPayUtils.a(this);
                        return true;
                    }
                    return super.onUIFailure(i, str3);
                }
            }, (IRequestHost) a());
        }
    }

    public final void j() {
        if (this.i.size() <= 0) {
            ToastUtils.a("请选择套系礼物");
        } else if (this.j.size() <= 0) {
            ToastUtils.a("请选择送礼对象");
        } else {
            ArrayList<SendGiftAndUserMode> arrayList = new ArrayList<>();
            for (YYPackGiftTrueGiftInfoMode yYPackGiftTrueGiftInfoMode : this.i) {
                Iterator<YYPackGiftUserMode> it = g().iterator();
                boolean z = true;
                while (true) {
                    boolean z2 = z;
                    if (it.hasNext()) {
                        YYPackGiftUserMode next = it.next();
                        YYGiftModel info = yYPackGiftTrueGiftInfoMode.getInfo();
                        String uid = next.getUid();
                        String name = next.getName();
                        String avatar = next.getAvatar();
                        String str = avatar;
                        if (avatar == null) {
                            str = "";
                        }
                        arrayList.add(new SendGiftAndUserMode(info, uid, name, str, Integer.parseInt(next.getChat_anchor()), z2));
                        z = false;
                    }
                }
            }
            Iterator<YYPackGiftTrueGiftInfoMode> it2 = this.i.iterator();
            boolean z3 = false;
            while (it2.hasNext()) {
                if (it2.next().getInfo().beans > 500) {
                    z3 = true;
                }
            }
            a(arrayList, 1, "", false, z3);
        }
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.dialog_yy_pack_gift, (ViewGroup) null);
        this.b = DialogYyPackGiftBinding.a(inflate);
        l();
        return inflate;
    }
}
