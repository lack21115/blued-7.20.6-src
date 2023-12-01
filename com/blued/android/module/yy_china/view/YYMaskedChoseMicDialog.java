package com.blued.android.module.yy_china.view;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.utils.SharedPreferencesUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.YYConstants;
import com.blued.android.module.yy_china.databinding.DialogMaskedChoseMicBinding;
import com.blued.android.module.yy_china.databinding.ItemMaskedInfoMicBinding;
import com.blued.android.module.yy_china.fragment.BaseFullScreenDialog;
import com.blued.android.module.yy_china.manager.YYImMsgManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.VeiledRoomInfoMode;
import com.blued.android.module.yy_china.model.YYGiftModel;
import com.blued.android.module.yy_china.model.YYPayGoodsModel;
import com.blued.android.module.yy_china.model.YYPayRequestModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.utils.YYPayUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.android.module.yy_china.view.YYMaskedChoseMicDialog;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYMaskedChoseMicDialog.class */
public final class YYMaskedChoseMicDialog extends BaseFullScreenDialog {
    private DialogMaskedChoseMicBinding a;
    private String b = "";
    private final MaskedChoseMicAdapter c = new MaskedChoseMicAdapter(this);

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYMaskedChoseMicDialog$AdMode.class */
    public static final class AdMode {
        private final String a;
        private final String b;

        public AdMode(String uid, String num) {
            Intrinsics.e(uid, "uid");
            Intrinsics.e(num, "num");
            this.a = uid;
            this.b = num;
        }

        public final String a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof AdMode) {
                AdMode adMode = (AdMode) obj;
                return Intrinsics.a((Object) this.a, (Object) adMode.a) && Intrinsics.a((Object) this.b, (Object) adMode.b);
            }
            return false;
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public String toString() {
            return "AdMode(uid=" + this.a + ", num=" + this.b + ')';
        }
    }

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYMaskedChoseMicDialog$MaskedChoseMicAdapter.class */
    public final class MaskedChoseMicAdapter extends BaseQuickAdapter<AdMode, BaseViewHolder> {
        final /* synthetic */ YYMaskedChoseMicDialog a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MaskedChoseMicAdapter(YYMaskedChoseMicDialog this$0) {
            super(R.layout.item_masked_info_mic);
            Intrinsics.e(this$0, "this$0");
            this.a = this$0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(YYMaskedChoseMicDialog this$0, AdMode item, MaskedChoseMicAdapter this$1, View view) {
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(item, "$item");
            Intrinsics.e(this$1, "this$1");
            this$0.b = item.a();
            this$1.notifyDataSetChanged();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(YYMaskedChoseMicDialog this$0, MaskedChoseMicAdapter this$1, View view) {
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(this$1, "this$1");
            this$0.b = "";
            this$1.notifyDataSetChanged();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void convert(BaseViewHolder baseViewHolder, final AdMode item) {
            List<YYSeatMemberModel> list;
            Intrinsics.e(item, "item");
            Intrinsics.a(baseViewHolder);
            ItemMaskedInfoMicBinding a = ItemMaskedInfoMicBinding.a(baseViewHolder.itemView);
            Intrinsics.c(a, "bind(helper!!.itemView)");
            if (StringUtils.a(this.a.b, item.a())) {
                a.b.setVisibility(0);
                ConstraintLayout root = a.getRoot();
                final YYMaskedChoseMicDialog yYMaskedChoseMicDialog = this.a;
                root.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYMaskedChoseMicDialog$MaskedChoseMicAdapter$m6Nhg1DKiXgK24rBM6cbVDCCFHU
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        YYMaskedChoseMicDialog.MaskedChoseMicAdapter.a(YYMaskedChoseMicDialog.this, this, view);
                    }
                });
            } else {
                a.b.setVisibility(4);
                ConstraintLayout root2 = a.getRoot();
                final YYMaskedChoseMicDialog yYMaskedChoseMicDialog2 = this.a;
                root2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYMaskedChoseMicDialog$MaskedChoseMicAdapter$jJoWfTbPfGrTo0t2Hb5ZrYbt4mU
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        YYMaskedChoseMicDialog.MaskedChoseMicAdapter.a(YYMaskedChoseMicDialog.this, item, this, view);
                    }
                });
            }
            YYRoomModel b = YYRoomInfoManager.e().b();
            if (b == null || (list = b.mics) == null) {
                return;
            }
            for (YYSeatMemberModel yYSeatMemberModel : list) {
                if (StringUtils.a(item.a(), yYSeatMemberModel.getUid())) {
                    int indexOf = list.indexOf(yYSeatMemberModel);
                    TextView textView = a.c;
                    textView.setText(indexOf + "号麦位");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYMaskedChoseMicDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    private final void a(String str, boolean z, final YYGiftModel yYGiftModel) {
        YYRoomModel b = YYRoomInfoManager.e().b();
        final YYPayRequestModel yYPayRequestModel = new YYPayRequestModel();
        if (yYGiftModel != null) {
            yYGiftModel.hit_id = System.currentTimeMillis();
        }
        yYPayRequestModel.gift = yYGiftModel;
        yYPayRequestModel.beans = (yYGiftModel == null ? null : Long.valueOf(yYGiftModel.beans)) == null ? 0L : yYGiftModel.beans;
        yYPayRequestModel.giftCount = 1;
        yYPayRequestModel.goods_id = yYGiftModel == null ? null : yYGiftModel.goods_id;
        Integer valueOf = yYGiftModel == null ? null : Integer.valueOf(yYGiftModel.goods_type);
        Intrinsics.a(valueOf);
        yYPayRequestModel.goods_type = valueOf.intValue();
        yYPayRequestModel.hit_id = 0L;
        yYPayRequestModel.payCode = str;
        yYPayRequestModel.remember_me = z;
        yYPayRequestModel.room_id = b == null ? null : b.room_id;
        yYPayRequestModel.target_uid = this.b;
        yYPayRequestModel.pay_from = 1;
        YYPayUtils.a(yYPayRequestModel, YYConstants.PayFromSource.Pay_Gift, (Fragment) this, a(), new YYPayUtils.PayGiftStatusListener() { // from class: com.blued.android.module.yy_china.view.YYMaskedChoseMicDialog$buyGift$1
            @Override // com.blued.android.module.yy_china.utils.YYPayUtils.PayGiftStatusListener
            public void a(int i, String errorMessage) {
                Intrinsics.e(errorMessage, "errorMessage");
            }

            @Override // com.blued.android.module.yy_china.utils.YYPayUtils.PayGiftStatusListener
            public void a(YYPayGoodsModel goodsModel) {
                Intrinsics.e(goodsModel, "goodsModel");
                YYSeatMemberModel yYSeatMemberModel = YYRoomInfoManager.e().o().get(yYPayRequestModel.target_uid);
                if (yYSeatMemberModel == null) {
                    return;
                }
                YYImMsgManager.a().a(yYGiftModel, yYSeatMemberModel, goodsModel, false);
                this.dismissAllowingStateLoss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYMaskedChoseMicDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(YYMaskedChoseMicDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.f().c.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(YYMaskedChoseMicDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.f().c.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(YYMaskedChoseMicDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null) {
            EventTrackYY.l(ChatRoomProtos.Event.YY_LIFT_MASK_SECOND_POP_YES_CLICK, b.room_id, b.uid, this$0.b);
        }
        this$0.i();
    }

    private final DialogMaskedChoseMicBinding f() {
        DialogMaskedChoseMicBinding dialogMaskedChoseMicBinding = this.a;
        Intrinsics.a(dialogMaskedChoseMicBinding);
        return dialogMaskedChoseMicBinding;
    }

    private final void g() {
        VeiledRoomInfoMode veiledRoomInfoMode;
        VeiledRoomInfoMode veiledRoomInfoMode2;
        YYGiftModel goods_info;
        List<YYSeatMemberModel> list;
        f().d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYMaskedChoseMicDialog$R2m9QmlNXcsQfKXAwBZn8LGU-tY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYMaskedChoseMicDialog.a(YYMaskedChoseMicDialog.this, view);
            }
        });
        f().b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYMaskedChoseMicDialog$H46105k2zLZNPiWqHsmQi-FKqlw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYMaskedChoseMicDialog.a(view);
            }
        });
        f().a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYMaskedChoseMicDialog$LaxqEpQ6nEoh0nkjDU5oZ7so7Wk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYMaskedChoseMicDialog.b(YYMaskedChoseMicDialog.this, view);
            }
        });
        f().i.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        f().i.setAdapter(this.c);
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null && (list = b.mics) != null) {
            ArrayList arrayList = new ArrayList();
            for (YYSeatMemberModel yYSeatMemberModel : list) {
                if (!YYRoomInfoManager.e().g(yYSeatMemberModel.getUid())) {
                    String uid = yYSeatMemberModel.getUid();
                    Intrinsics.c(uid, "index.uid");
                    arrayList.add(new AdMode(uid, String.valueOf(list.indexOf(yYSeatMemberModel) + 1)));
                }
            }
            this.c.setNewData(arrayList);
        }
        f().g.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYMaskedChoseMicDialog$DscdxCHAITarTP2aXz7P2jSUXjQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYMaskedChoseMicDialog.c(YYMaskedChoseMicDialog.this, view);
            }
        });
        f().e.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYMaskedChoseMicDialog$2Vf3ehJGZtMMj_g-S85zPVKYHNE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYMaskedChoseMicDialog.d(YYMaskedChoseMicDialog.this, view);
            }
        });
        YYRoomModel b2 = YYRoomInfoManager.e().b();
        if (b2 == null || (veiledRoomInfoMode = b2.mMaskedVeiledRoominfo) == null) {
            return;
        }
        ShapeTextView shapeTextView = f().j;
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        Resources resources = getResources();
        int i = R.string.use_masked_guide;
        YYRoomModel b3 = YYRoomInfoManager.e().b();
        Long l = "";
        if (b3 != null && (veiledRoomInfoMode2 = b3.mMaskedVeiledRoominfo) != null && (goods_info = veiledRoomInfoMode2.getGoods_info()) != null) {
            l = Long.valueOf(goods_info.beans);
        }
        String string = resources.getString(i, l);
        Intrinsics.c(string, "resources.getString(R.st…o?.goods_info?.beans?:\"\")");
        String format = String.format(string, Arrays.copyOf(new Object[0], 0));
        Intrinsics.c(format, "format(format, *args)");
        shapeTextView.setText(format);
        TextView textView = f().k;
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.a;
        StringBuilder sb = new StringBuilder();
        sb.append("价值");
        YYGiftModel goods_info2 = veiledRoomInfoMode.getGoods_info();
        sb.append(goods_info2 == null ? null : Long.valueOf(goods_info2.beans));
        sb.append("弯豆，仅支持揭面麦上用户");
        String format2 = String.format(sb.toString(), Arrays.copyOf(new Object[0], 0));
        Intrinsics.c(format2, "format(format, *args)");
        textView.setText(format2);
    }

    private final void h() {
        if (StringUtils.b(this.b)) {
            return;
        }
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null) {
            EventTrackYY.l(ChatRoomProtos.Event.YY_LIFT_MASK_USER_POP_YES_CLICK, b.room_id, b.uid, this.b);
        }
        if (SharedPreferencesUtils.b().getBoolean("YYMaskedBuyReidesDialog", false)) {
            i();
            return;
        }
        YYMaskedBuyReidesDialog yYMaskedBuyReidesDialog = new YYMaskedBuyReidesDialog(this.b);
        yYMaskedBuyReidesDialog.a(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYMaskedChoseMicDialog$YIa8lTKmzJPQBtxiY2SvXE4Du-U
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYMaskedChoseMicDialog.e(YYMaskedChoseMicDialog.this, view);
            }
        });
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        yYMaskedBuyReidesDialog.show(childFragmentManager, "YYMaskedBuyReidesDialog");
    }

    private final void i() {
        VeiledRoomInfoMode veiledRoomInfoMode;
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null || (veiledRoomInfoMode = b.mMaskedVeiledRoominfo) == null) {
            return;
        }
        a("", false, veiledRoomInfoMode.getGoods_info());
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Logger.a(Intrinsics.a("web dialog onActivityResult: ", (Object) Integer.valueOf(i)), new Object[0]);
        if (i2 == -1) {
            if ((i == 4221005 || i == 4221004) && intent != null) {
                Serializable serializableExtra = intent.getSerializableExtra("selected_model");
                if (serializableExtra == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.yy_china.model.YYGiftModel");
                }
                YYGiftModel yYGiftModel = (YYGiftModel) serializableExtra;
                String stringExtra = intent.getStringExtra("password");
                boolean booleanExtra = intent.getBooleanExtra("remember_me", false);
                intent.getIntExtra("gift_count", 1);
                if (TextUtils.isEmpty(stringExtra) || stringExtra == null) {
                    return;
                }
                a(stringExtra, booleanExtra, yYGiftModel);
            } else if (i != 4221002 || intent == null) {
            } else {
                Serializable serializableExtra2 = intent.getSerializableExtra("selected_model");
                if (serializableExtra2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.yy_china.model.YYGiftModel");
                }
                YYGiftModel yYGiftModel2 = (YYGiftModel) serializableExtra2;
                intent.getIntExtra("gift_count", 1);
                boolean booleanExtra2 = intent.getBooleanExtra("remember_me", false);
                String stringExtra2 = intent.getStringExtra("password");
                if (stringExtra2 == null) {
                    return;
                }
                a(stringExtra2, booleanExtra2, yYGiftModel2);
            }
        }
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.dialog_masked_chose_mic, viewGroup, true);
        this.a = DialogMaskedChoseMicBinding.a(inflate);
        g();
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return inflate;
        }
        EventTrackYY.d(ChatRoomProtos.Event.YY_LIFT_MASK_USER_POP_SHOW, b.room_id, b.uid);
        return inflate;
    }
}
