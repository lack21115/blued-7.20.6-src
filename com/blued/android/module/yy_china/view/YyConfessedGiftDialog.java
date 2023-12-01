package com.blued.android.module.yy_china.view;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.ClickUtils;
import com.blued.android.framework.utils.SharedPreferencesUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.utils.ImgURLMap;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.live.base.constants.LiveEventBusConstant;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.DialogConfessedGiftBinding;
import com.blued.android.module.yy_china.databinding.ItemYyConfessedGiftBinding;
import com.blued.android.module.yy_china.databinding.ItemYyConfessedGiftUserBinding;
import com.blued.android.module.yy_china.fragment.BaseFullScreenDialog;
import com.blued.android.module.yy_china.manager.YYImMsgManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.ConfessedUserGiftMode;
import com.blued.android.module.yy_china.model.ConfessedUserMode;
import com.blued.android.module.yy_china.model.SendGiftAndUserMode;
import com.blued.android.module.yy_china.model.YYGiftModel;
import com.blued.android.module.yy_china.model.YYItemRainMode;
import com.blued.android.module.yy_china.model.YYMsgJsonGiftExtra;
import com.blued.android.module.yy_china.model.YYPayGoodsModel;
import com.blued.android.module.yy_china.model.YYPayMode;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.utils.EnglishCharFilter;
import com.blued.android.module.yy_china.utils.YYPayUtils;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.android.module.yy_china.view.YYConfessedUserListDialog;
import com.blued.android.module.yy_china.view.YyConfessedGiftDialog;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YyConfessedGiftDialog.class */
public final class YyConfessedGiftDialog extends BaseFullScreenDialog {
    private DialogConfessedGiftBinding a;
    private final ConfessedUserAdapter b = new ConfessedUserAdapter(this);
    private final ConfessedGiftAdapter c = new ConfessedGiftAdapter(this);
    private final ArrayList<YYGiftModel> d = new ArrayList<>();
    private ConfessedUserMode e;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YyConfessedGiftDialog$BusinessMode.class */
    public static final class BusinessMode {
        private final String a = "confession";
        private String b = "";

        public final void a(String str) {
            Intrinsics.e(str, "<set-?>");
            this.b = str;
        }
    }

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YyConfessedGiftDialog$ConfessedGiftAdapter.class */
    public final class ConfessedGiftAdapter extends BaseQuickAdapter<YYGiftModel, BaseViewHolder> {
        final /* synthetic */ YyConfessedGiftDialog a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ConfessedGiftAdapter(YyConfessedGiftDialog this$0) {
            super(R.layout.item_yy_confessed_gift);
            Intrinsics.e(this$0, "this$0");
            this.a = this$0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(YyConfessedGiftDialog this$0, YYGiftModel item, ConfessedGiftAdapter this$1, View view) {
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(item, "$item");
            Intrinsics.e(this$1, "this$1");
            if (this$0.j().size() <= 1) {
                ToastUtils.a("必须选择一个礼物");
                return;
            }
            this$0.j().remove(item);
            this$1.notifyDataSetChanged();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(YyConfessedGiftDialog this$0, YYGiftModel item, ConfessedGiftAdapter this$1, View view) {
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(item, "$item");
            Intrinsics.e(this$1, "this$1");
            if (!this$0.j().contains(item)) {
                this$0.j().add(item);
            }
            this$1.notifyDataSetChanged();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void convert(BaseViewHolder helper, final YYGiftModel item) {
            Intrinsics.e(helper, "helper");
            Intrinsics.e(item, "item");
            ItemYyConfessedGiftBinding a = ItemYyConfessedGiftBinding.a(helper.itemView);
            Intrinsics.c(a, "bind(helper.itemView)");
            a.d.setText(item.name);
            a.c.setText(String.valueOf(item.beans));
            ImageLoader.a(this.a.a(), item.images_static).a(a.a);
            boolean z = false;
            for (YYGiftModel yYGiftModel : this.a.j()) {
                if (StringUtils.a(yYGiftModel.goods_id, item.goods_id)) {
                    z = true;
                }
            }
            if (z) {
                a.b.setVisibility(0);
                ConstraintLayout root = a.getRoot();
                final YyConfessedGiftDialog yyConfessedGiftDialog = this.a;
                root.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YyConfessedGiftDialog$ConfessedGiftAdapter$TmAUS61_A_UaU4YkYP6c-SFPMwE
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        YyConfessedGiftDialog.ConfessedGiftAdapter.a(YyConfessedGiftDialog.this, item, this, view);
                    }
                });
                return;
            }
            a.b.setVisibility(8);
            ConstraintLayout root2 = a.getRoot();
            final YyConfessedGiftDialog yyConfessedGiftDialog2 = this.a;
            root2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YyConfessedGiftDialog$ConfessedGiftAdapter$h7gjj1TcoTl4_jHqgvtMSP3bh4E
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YyConfessedGiftDialog.ConfessedGiftAdapter.b(YyConfessedGiftDialog.this, item, this, view);
                }
            });
        }
    }

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YyConfessedGiftDialog$ConfessedUserAdapter.class */
    public final class ConfessedUserAdapter extends BaseQuickAdapter<ConfessedUserMode, BaseViewHolder> {
        final /* synthetic */ YyConfessedGiftDialog a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ConfessedUserAdapter(YyConfessedGiftDialog this$0) {
            super(R.layout.item_yy_confessed_gift_user);
            Intrinsics.e(this$0, "this$0");
            this.a = this$0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(YyConfessedGiftDialog this$0, ConfessedUserMode item, ConfessedUserAdapter this$1, View view) {
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(item, "$item");
            Intrinsics.e(this$1, "this$1");
            this$0.a(item);
            this$1.notifyDataSetChanged();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(YyConfessedGiftDialog this$0, ConfessedUserAdapter this$1, View view) {
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(this$1, "this$1");
            this$0.a((ConfessedUserMode) null);
            this$1.notifyDataSetChanged();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void convert(BaseViewHolder helper, final ConfessedUserMode item) {
            String uid;
            Intrinsics.e(helper, "helper");
            Intrinsics.e(item, "item");
            ItemYyConfessedGiftUserBinding a = ItemYyConfessedGiftUserBinding.a(helper.itemView);
            Intrinsics.c(a, "bind(helper.itemView)");
            YYRoomInfoManager.e().a(this.a.a(), a.a, item.getUid(), item.getAvatar());
            ConfessedUserMode k = this.a.k();
            String str = "";
            if (k != null && (uid = k.getUid()) != null) {
                str = uid;
            }
            if (StringUtils.a(str, item.getUid())) {
                a.b.setVisibility(0);
                ConstraintLayout root = a.getRoot();
                final YyConfessedGiftDialog yyConfessedGiftDialog = this.a;
                root.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YyConfessedGiftDialog$ConfessedUserAdapter$BqSisrGz_g3YYH6vV0mcYKbr_qU
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        YyConfessedGiftDialog.ConfessedUserAdapter.a(YyConfessedGiftDialog.this, this, view);
                    }
                });
                return;
            }
            a.b.setVisibility(8);
            ConstraintLayout root2 = a.getRoot();
            final YyConfessedGiftDialog yyConfessedGiftDialog2 = this.a;
            root2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YyConfessedGiftDialog$ConfessedUserAdapter$kVBqKEP0yVU9K4J9IdVHywmUxIE
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YyConfessedGiftDialog.ConfessedUserAdapter.a(YyConfessedGiftDialog.this, item, this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
        LiveEventBus.get("show_inner_dialog").post(YYRoomInfoManager.e().c().a(19));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final YyConfessedGiftDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        YYConfessedUserListDialog yYConfessedUserListDialog = new YYConfessedUserListDialog();
        yYConfessedUserListDialog.a(new YYConfessedUserListDialog.ConfessedOnClickUserListListener() { // from class: com.blued.android.module.yy_china.view.YyConfessedGiftDialog$initView$3$1
            @Override // com.blued.android.module.yy_china.view.YYConfessedUserListDialog.ConfessedOnClickUserListListener
            public void a(ConfessedUserMode item) {
                Intrinsics.e(item, "item");
                List data = YyConfessedGiftDialog.this.f().getData();
                Intrinsics.c(data, "usAda.data");
                List<ConfessedUserMode> list = data;
                YyConfessedGiftDialog yyConfessedGiftDialog = YyConfessedGiftDialog.this;
                for (ConfessedUserMode confessedUserMode : list) {
                    if (StringUtils.a(confessedUserMode.getUid(), item.getUid())) {
                        yyConfessedGiftDialog.a(confessedUserMode);
                        yyConfessedGiftDialog.f().getData().remove(confessedUserMode);
                        yyConfessedGiftDialog.f().addData(0, confessedUserMode);
                        yyConfessedGiftDialog.f().notifyDataSetChanged();
                        return;
                    }
                }
                YyConfessedGiftDialog.this.a(item);
                YyConfessedGiftDialog.this.f().addData(0, item);
                YyConfessedGiftDialog.this.f().notifyDataSetChanged();
            }
        });
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        yYConfessedUserListDialog.show(childFragmentManager, "YYConfessedUserListDialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YyConfessedGiftDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        YYConfessedRankListDialog yYConfessedRankListDialog = new YYConfessedRankListDialog();
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        yYConfessedRankListDialog.show(childFragmentManager, "YYConfessedRankListDialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(YyConfessedGiftDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        if (ClickUtils.a()) {
            return;
        }
        this$0.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DialogConfessedGiftBinding l() {
        DialogConfessedGiftBinding dialogConfessedGiftBinding = this.a;
        Intrinsics.a(dialogConfessedGiftBinding);
        return dialogConfessedGiftBinding;
    }

    private final void m() {
        ImageLoader.a(a(), ImgURLMap.a.a("yy_confessed_gift_url_bg")).a(l().f);
        ImageLoader.a(a(), ImgURLMap.a.a("yy_confessed_gift_url_bg_star")).a(l().h);
        ImageLoader.a(a(), ImgURLMap.a.a("yy_confessed_gift_url_btn_bg")).a((Target) new SimpleTarget<Drawable>() { // from class: com.blued.android.module.yy_china.view.YyConfessedGiftDialog$initView$1
            /* renamed from: a */
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                DialogConfessedGiftBinding l;
                Intrinsics.e(resource, "resource");
                l = YyConfessedGiftDialog.this.l();
                l.d.setBackground(resource);
            }
        });
        l().e.setFilters(new InputFilter[]{new EnglishCharFilter(50)});
        l().a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YyConfessedGiftDialog$rJ4XHGOv_-iRp1R7Im4YTe6gaOg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YyConfessedGiftDialog.a(view);
            }
        });
        l().b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YyConfessedGiftDialog$FKJMmJNr8sBYBiHkVbpeuoyzvRM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YyConfessedGiftDialog.a(YyConfessedGiftDialog.this, view);
            }
        });
        l().c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YyConfessedGiftDialog$3N5e_pQlYxvdctIfJ57k1I_QC2g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YyConfessedGiftDialog.b(YyConfessedGiftDialog.this, view);
            }
        });
        l().d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YyConfessedGiftDialog$E-a1VJLoylEdnFixPpYxnSPNetw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YyConfessedGiftDialog.c(YyConfessedGiftDialog.this, view);
            }
        });
        l().j.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        l().i.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        l().j.setAdapter(this.b);
        l().i.setAdapter(this.c);
        h();
    }

    public final void a(ConfessedUserGiftMode data) {
        Intrinsics.e(data, "data");
        ArrayList<ConfessedUserMode> confession_user = data.getConfession_user();
        if (confession_user != null) {
            if (confession_user.size() > 0) {
                a(confession_user.get(0));
            }
            f().setNewData(confession_user);
        }
        ArrayList<YYGiftModel> confession_goods = data.getConfession_goods();
        if (confession_goods != null) {
            if (confession_goods.size() > 0) {
                j().add(confession_goods.get(0));
            }
            g().setNewData(confession_goods);
        }
        String string = SharedPreferencesUtils.b().getString("YyConfessedGiftDialog_message", "");
        if (!StringUtils.b(string)) {
            l().e.setText(string);
            l().e.setSelection((string == null ? "" : string).length());
        } else if (StringUtils.b(data.getRandom_confession_declare())) {
        } else {
            String random_confession_declare = data.getRandom_confession_declare();
            l().e.setText(random_confession_declare);
            EditText editText = l().e;
            if (random_confession_declare == null) {
                random_confession_declare = "";
            }
            editText.setSelection(random_confession_declare.length());
        }
    }

    public final void a(ConfessedUserMode confessedUserMode) {
        this.e = confessedUserMode;
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog
    public boolean d() {
        return true;
    }

    public final ConfessedUserAdapter f() {
        return this.b;
    }

    public final ConfessedGiftAdapter g() {
        return this.c;
    }

    public final void h() {
        if (YYRoomInfoManager.e().b() == null) {
            return;
        }
        String str = YYRoomInfoManager.e().b().room_id;
        final ActivityFragmentActive a = a();
        YYRoomHttpUtils.h(str, 1, new BluedUIHttpResponse<BluedEntityA<ConfessedUserGiftMode>>(a) { // from class: com.blued.android.module.yy_china.view.YyConfessedGiftDialog$loadData$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<ConfessedUserGiftMode> bluedEntityA) {
                ConfessedUserGiftMode singleData;
                if (bluedEntityA == null || (singleData = bluedEntityA.getSingleData()) == null) {
                    return;
                }
                YyConfessedGiftDialog.this.a(singleData);
            }
        }, a());
    }

    public final void i() {
        String uid;
        if (this.d.size() <= 0) {
            ToastUtils.a("请选择套系礼物");
        } else if (this.e == null) {
            ToastUtils.a("请选择送礼对象");
        } else {
            final ArrayList arrayList = new ArrayList();
            String str = "";
            String str2 = "";
            for (YYGiftModel yYGiftModel : this.d) {
                str2 = str2 + ((Object) yYGiftModel.goods_id) + ',';
                ConfessedUserMode k = k();
                if (k != null) {
                    arrayList.add(new SendGiftAndUserMode(yYGiftModel, k.getUid(), k.getName(), k.getAvatar(), k.getChat_anchor(), true));
                }
            }
            ConfessedUserMode confessedUserMode = this.e;
            if (confessedUserMode != null && (uid = confessedUserMode.getUid()) != null) {
                str = uid;
            }
            YYRoomModel b = YYRoomInfoManager.e().b();
            if (b == null) {
                return;
            }
            String obj = l().e.getText().toString();
            if (StringUtils.b(obj)) {
                obj = l().e.getHint().toString();
            } else {
                SharedPreferencesUtils.b().edit().putString("YyConfessedGiftDialog_message", obj).apply();
            }
            BusinessMode businessMode = new BusinessMode();
            businessMode.a(obj);
            String json = AppInfo.f().toJson(businessMode);
            final ActivityFragmentActive a = a();
            YYRoomHttpUtils.b(b.room_id, str, str2, json, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<YYPayMode>>(a) { // from class: com.blued.android.module.yy_china.view.YyConfessedGiftDialog$play$2
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<YYPayMode> bluedEntityA) {
                    YYPayMode singleData;
                    if (bluedEntityA == null || (singleData = bluedEntityA.getSingleData()) == null) {
                        return;
                    }
                    for (SendGiftAndUserMode sendGiftAndUserMode : arrayList) {
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
                                        YYMsgJsonGiftExtra yYMsgJsonGiftExtra = (YYMsgJsonGiftExtra) AppInfo.f().fromJson(yYItemRainMode.getRain(), YYMsgJsonGiftExtra.class);
                                        yYMsgJsonGiftExtra.setRain_level_ani_url("");
                                        yYPayGoodsModel.json_contents_im = AppInfo.f().toJson(yYMsgJsonGiftExtra);
                                    }
                                }
                            }
                        }
                        YYImMsgManager.a().a(sendGiftAndUserMode.getSelectedModel(), yYSeatMemberModel, yYPayGoodsModel, false);
                        YYRoomModel b2 = YYRoomInfoManager.e().b();
                        if (b2 != null && singleData != null && singleData.getCurrent_wealth() != null && singleData.getNext_wealth() != null) {
                            b2.wealth_level = singleData.getCurrent_wealth().getWealth_level();
                            b2.enter_effects = singleData.getCurrent_wealth().getEnter_effects();
                            b2.avatar_frame = singleData.getCurrent_wealth().getAvatar_frame();
                        }
                        ToastUtils.a("告白成功");
                        LiveEventBus.get(LiveEventBusConstant.d).post("");
                    }
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public boolean onUIFailure(int i, String str3) {
                    if (i == 4032007) {
                        YYPayUtils.a(this);
                        return true;
                    }
                    return super.onUIFailure(i, str3);
                }
            }, (IRequestHost) a());
            YYRoomModel b2 = YYRoomInfoManager.e().b();
            if (b2 == null) {
                return;
            }
            EventTrackYY.l(ChatRoomProtos.Event.YY_TOP_SHOW_LOVE_PAGE_TO_CLICK, b2.room_id, b2.uid, str);
        }
    }

    public final ArrayList<YYGiftModel> j() {
        return this.d;
    }

    public final ConfessedUserMode k() {
        return this.e;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.dialog_confessed_gift, (ViewGroup) null);
        this.a = DialogConfessedGiftBinding.a(inflate);
        m();
        return inflate;
    }
}
