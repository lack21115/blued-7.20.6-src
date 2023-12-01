package com.blued.android.module.yy_china.view;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blued.android.framework.utils.SharedPreferencesUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.DialogYyMaskedUseInfoRedisBinding;
import com.blued.android.module.yy_china.fragment.BaseFullScreenDialog;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.VeiledRoomInfoMode;
import com.blued.android.module.yy_china.model.YYGiftModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYMaskedBuyReidesDialog.class */
public final class YYMaskedBuyReidesDialog extends BaseFullScreenDialog {

    /* renamed from: a  reason: collision with root package name */
    private final String f18296a;
    private DialogYyMaskedUseInfoRedisBinding b;

    /* renamed from: c  reason: collision with root package name */
    private View.OnClickListener f18297c;
    private boolean d = true;

    public YYMaskedBuyReidesDialog(String str) {
        this.f18296a = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYMaskedBuyReidesDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYMaskedBuyReidesDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null) {
            EventTrackYY.l(ChatRoomProtos.Event.YY_LIFT_MASK_SECOND_POP_NO_CLICK, b.room_id, b.uid, this$0.f());
        }
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(YYMaskedBuyReidesDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        if (this$0.d) {
            SharedPreferencesUtils.b().edit().putBoolean("YYMaskedBuyReidesDialog", true).apply();
        }
        View.OnClickListener onClickListener = this$0.f18297c;
        if (onClickListener != null) {
            onClickListener.onClick(null);
        }
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(YYMaskedBuyReidesDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.d = !this$0.d;
        this$0.i();
    }

    private final DialogYyMaskedUseInfoRedisBinding g() {
        DialogYyMaskedUseInfoRedisBinding dialogYyMaskedUseInfoRedisBinding = this.b;
        Intrinsics.a(dialogYyMaskedUseInfoRedisBinding);
        return dialogYyMaskedUseInfoRedisBinding;
    }

    private final void h() {
        VeiledRoomInfoMode veiledRoomInfoMode;
        YYGiftModel goods_info;
        g().f16435c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYMaskedBuyReidesDialog$5TDcb1Yau9CHLJA0BvTHkCEirYc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYMaskedBuyReidesDialog.a(YYMaskedBuyReidesDialog.this, view);
            }
        });
        g().d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYMaskedBuyReidesDialog$-cr1-oogUU3HgGYhSApNh6xEelA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYMaskedBuyReidesDialog.a(view);
            }
        });
        g().f16434a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYMaskedBuyReidesDialog$hJyDbSqEFIY3vOxPHM_jvkX1xDE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYMaskedBuyReidesDialog.b(YYMaskedBuyReidesDialog.this, view);
            }
        });
        g().b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYMaskedBuyReidesDialog$4xmnkBFmA6uSnMKbOas66UzYAKE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYMaskedBuyReidesDialog.c(YYMaskedBuyReidesDialog.this, view);
            }
        });
        g().e.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYMaskedBuyReidesDialog$g81CuJIh4TzQ94zTpjwBqoVxwuE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYMaskedBuyReidesDialog.d(YYMaskedBuyReidesDialog.this, view);
            }
        });
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null && b.mMaskedVeiledRoominfo != null) {
            TextView textView = g().f;
            StringCompanionObject stringCompanionObject = StringCompanionObject.f42549a;
            Resources resources = getResources();
            int i = R.string.use_masked_guide;
            YYRoomModel b2 = YYRoomInfoManager.e().b();
            Long l = "";
            if (b2 != null && (veiledRoomInfoMode = b2.mMaskedVeiledRoominfo) != null && (goods_info = veiledRoomInfoMode.getGoods_info()) != null) {
                l = Long.valueOf(goods_info.beans);
            }
            String string = resources.getString(i, l);
            Intrinsics.c(string, "resources.getString(R.st…o?.goods_info?.beans?:\"\")");
            String format = String.format(string, Arrays.copyOf(new Object[0], 0));
            Intrinsics.c(format, "format(format, *args)");
            textView.setText(format);
        }
        i();
    }

    private final void i() {
        if (this.d) {
            g().e.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_yy_masked_userinfo_no_notice, 0, 0, 0);
        } else {
            g().e.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_yy_masked_userinfo_no_notice_no, 0, 0, 0);
        }
    }

    public final void a(View.OnClickListener onClickListener) {
        this.f18297c = onClickListener;
    }

    public final String f() {
        return this.f18296a;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.dialog_yy_masked_use_info_redis, viewGroup, true);
        this.b = DialogYyMaskedUseInfoRedisBinding.a(inflate);
        h();
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return inflate;
        }
        EventTrackYY.l(ChatRoomProtos.Event.YY_LIFT_MASK_SECOND_POP_SHOW, b.room_id, b.uid, f());
        return inflate;
    }
}
