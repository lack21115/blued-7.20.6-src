package com.blued.android.module.yy_china.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.click.SingleClickProxy;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.YYConstants;
import com.blued.android.module.yy_china.databinding.ViewYyCpBossDialogBinding;
import com.blued.android.module.yy_china.manager.YYImMsgManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYGiftModel;
import com.blued.android.module.yy_china.model.YYPayGoodsModel;
import com.blued.android.module.yy_china.model.YYPayRequestModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.utils.YYPayUtils;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYApplyVipDialog.class */
public final class YYApplyVipDialog extends BaseFullScreenDialog {
    private ViewYyCpBossDialogBinding a;
    private YYRoomModel b;
    private YYGiftModel c;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYApplyVipDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    private final void a(String str, boolean z) {
        final YYPayRequestModel yYPayRequestModel = new YYPayRequestModel();
        YYGiftModel yYGiftModel = this.c;
        if (yYGiftModel != null) {
            yYGiftModel.hit_id = System.currentTimeMillis();
        }
        yYPayRequestModel.gift = this.c;
        yYPayRequestModel.giftCount = 1;
        YYGiftModel yYGiftModel2 = this.c;
        if (yYGiftModel2 != null) {
            yYPayRequestModel.beans = yYGiftModel2.beans;
            yYPayRequestModel.goods_id = yYGiftModel2.goods_id;
            yYPayRequestModel.goods_type = yYGiftModel2.goods_type;
        }
        yYPayRequestModel.hit_id = 0L;
        yYPayRequestModel.payCode = str;
        yYPayRequestModel.remember_me = z;
        YYRoomModel yYRoomModel = this.b;
        yYPayRequestModel.room_id = yYRoomModel == null ? null : yYRoomModel.room_id;
        YYRoomModel yYRoomModel2 = this.b;
        yYPayRequestModel.target_uid = yYRoomModel2 == null ? null : yYRoomModel2.uid;
        yYPayRequestModel.pay_from = 1;
        YYPayUtils.a(yYPayRequestModel, YYConstants.PayFromSource.Pay_Gift, (Fragment) this, a(), new YYPayUtils.PayGiftStatusListener() { // from class: com.blued.android.module.yy_china.fragment.YYApplyVipDialog$buyGift$2
            @Override // com.blued.android.module.yy_china.utils.YYPayUtils.PayGiftStatusListener
            public void a(int i, String errorMessage) {
                Intrinsics.e(errorMessage, "errorMessage");
                this.dismissAllowingStateLoss();
            }

            @Override // com.blued.android.module.yy_china.utils.YYPayUtils.PayGiftStatusListener
            public void a(YYPayGoodsModel goodsModel) {
                YYGiftModel yYGiftModel3;
                Intrinsics.e(goodsModel, "goodsModel");
                YYSeatMemberModel yYSeatMemberModel = YYRoomInfoManager.e().o().get(yYPayRequestModel.target_uid);
                if (yYSeatMemberModel == null) {
                    return;
                }
                YYImMsgManager a = YYImMsgManager.a();
                yYGiftModel3 = this.c;
                a.a(yYGiftModel3, yYSeatMemberModel, goodsModel, false);
                this.dismissAllowingStateLoss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYApplyVipDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        ChatRoomProtos.Event event = ChatRoomProtos.Event.CHAT_ROOM_BOSS_SEAT_POP_GIFT_SEND_CLICK;
        YYRoomModel yYRoomModel = this$0.b;
        String str = null;
        String str2 = yYRoomModel == null ? null : yYRoomModel.room_id;
        YYRoomModel yYRoomModel2 = this$0.b;
        if (yYRoomModel2 != null) {
            str = yYRoomModel2.uid;
        }
        EventTrackYY.d(event, str2, str);
        this$0.a("", false);
    }

    private final void f() {
        ShapeTextView shapeTextView;
        FrameLayout frameLayout;
        View view;
        ViewYyCpBossDialogBinding viewYyCpBossDialogBinding = this.a;
        TextView textView = viewYyCpBossDialogBinding == null ? null : viewYyCpBossDialogBinding.n;
        if (textView != null) {
            textView.setText(Html.fromHtml(getResources().getString(R.string.yy_vip_requirement)));
        }
        ViewYyCpBossDialogBinding viewYyCpBossDialogBinding2 = this.a;
        TextView textView2 = viewYyCpBossDialogBinding2 == null ? null : viewYyCpBossDialogBinding2.m;
        if (textView2 != null) {
            textView2.setText(Html.fromHtml(getResources().getString(R.string.yy_vip_benefits)));
        }
        ViewYyCpBossDialogBinding viewYyCpBossDialogBinding3 = this.a;
        if (viewYyCpBossDialogBinding3 != null && (view = viewYyCpBossDialogBinding3.c) != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYApplyVipDialog$-i4PWjgn0QtHwefmnVPdsyGDdRU
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    YYApplyVipDialog.a(YYApplyVipDialog.this, view2);
                }
            });
        }
        ViewYyCpBossDialogBinding viewYyCpBossDialogBinding4 = this.a;
        if (viewYyCpBossDialogBinding4 != null && (frameLayout = viewYyCpBossDialogBinding4.f) != null) {
            frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYApplyVipDialog$3J_D_OfF44plPyWmKELmJoxVBZY
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    YYApplyVipDialog.a(view2);
                }
            });
        }
        ViewYyCpBossDialogBinding viewYyCpBossDialogBinding5 = this.a;
        if (viewYyCpBossDialogBinding5 == null || (shapeTextView = viewYyCpBossDialogBinding5.a) == null) {
            return;
        }
        shapeTextView.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYApplyVipDialog$D7xm5f0CPfv7JrlPAr6Rqv-b9Ik
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYApplyVipDialog.b(YYApplyVipDialog.this, view2);
            }
        }));
    }

    private final void g() {
        final ActivityFragmentActive a = a();
        YYRoomHttpUtils.c((BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<YYGiftModel>>(a) { // from class: com.blued.android.module.yy_china.fragment.YYApplyVipDialog$getVipRequirement$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYGiftModel> bluedEntityA) {
                ViewYyCpBossDialogBinding viewYyCpBossDialogBinding;
                ViewYyCpBossDialogBinding viewYyCpBossDialogBinding2;
                ViewYyCpBossDialogBinding viewYyCpBossDialogBinding3;
                if (bluedEntityA == null) {
                    return;
                }
                YYApplyVipDialog yYApplyVipDialog = YYApplyVipDialog.this;
                YYGiftModel singleData = bluedEntityA.getSingleData();
                if (singleData == null) {
                    return;
                }
                yYApplyVipDialog.c = singleData;
                ImageWrapper a2 = ImageLoader.a(yYApplyVipDialog.a(), singleData.images_static);
                viewYyCpBossDialogBinding = yYApplyVipDialog.a;
                a2.a(viewYyCpBossDialogBinding == null ? null : viewYyCpBossDialogBinding.i);
                viewYyCpBossDialogBinding2 = yYApplyVipDialog.a;
                TextView textView = viewYyCpBossDialogBinding2 == null ? null : viewYyCpBossDialogBinding2.k;
                if (textView != null) {
                    textView.setText(singleData.name);
                }
                viewYyCpBossDialogBinding3 = yYApplyVipDialog.a;
                TextView textView2 = viewYyCpBossDialogBinding3 == null ? null : viewYyCpBossDialogBinding3.l;
                if (textView2 == null) {
                    return;
                }
                textView2.setText(String.valueOf(singleData.beans));
            }
        }, a());
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        ChatRoomProtos.Event event = ChatRoomProtos.Event.CHAT_ROOM_BOSS_SEAT_POP_SHOW;
        YYRoomModel yYRoomModel = this.b;
        String str = null;
        String str2 = yYRoomModel == null ? null : yYRoomModel.room_id;
        YYRoomModel yYRoomModel2 = this.b;
        if (yYRoomModel2 != null) {
            str = yYRoomModel2.uid;
        }
        EventTrackYY.d(event, str2, str);
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
                a(stringExtra, booleanExtra);
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
                a(stringExtra2, booleanExtra2);
            }
        }
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.view_yy_cp_boss_dialog, viewGroup, true);
        Intrinsics.c(inflate, "inflater.inflate(R.layou…_dialog, container, true)");
        this.a = ViewYyCpBossDialogBinding.a(inflate);
        f();
        return inflate;
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog, com.blued.android.core.ui.BaseDialogFragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.e(view, "view");
        super.onViewCreated(view, bundle);
        this.b = YYRoomInfoManager.e().b();
        g();
    }
}
