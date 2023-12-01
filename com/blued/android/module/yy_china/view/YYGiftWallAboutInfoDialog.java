package com.blued.android.module.yy_china.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.DialogGiftwallAboutInfoBinding;
import com.blued.android.module.yy_china.fragment.BaseFullScreenDialog;
import com.blued.android.module.yy_china.model.GiftWallInfoAboutModel;
import com.blued.android.module.yy_china.model.YYCollectorConfigMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYGiftWallAboutInfoDialog.class */
public final class YYGiftWallAboutInfoDialog extends BaseFullScreenDialog {
    private DialogGiftwallAboutInfoBinding a;
    private GiftWallInfoAboutModel b;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYGiftWallAboutInfoDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYGiftWallAboutInfoDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    private final DialogGiftwallAboutInfoBinding g() {
        DialogGiftwallAboutInfoBinding dialogGiftwallAboutInfoBinding = this.a;
        Intrinsics.a(dialogGiftwallAboutInfoBinding);
        return dialogGiftwallAboutInfoBinding;
    }

    private final void h() {
        GiftWallInfoAboutModel giftWallInfoAboutModel;
        YYCollectorConfigMode allDa;
        YYCollectorConfigMode.GoodsDTO goods;
        String name;
        YYCollectorConfigMode allDa2;
        YYCollectorConfigMode.SkinDTO skin2;
        String name2;
        YYCollectorConfigMode allDa3;
        YYCollectorConfigMode.BadgeDTO badge;
        String name3;
        g().d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYGiftWallAboutInfoDialog$3w3oWJHKNcrNScvDLZtZoqXlIpA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYGiftWallAboutInfoDialog.a(view);
            }
        });
        g().c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYGiftWallAboutInfoDialog$3Xre7QC0Wzm23s4H5ASpXGoRa8o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYGiftWallAboutInfoDialog.a(YYGiftWallAboutInfoDialog.this, view);
            }
        });
        g().b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYGiftWallAboutInfoDialog$9kdf4-GxN_EnZY6_f2DweXEWWLc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYGiftWallAboutInfoDialog.b(YYGiftWallAboutInfoDialog.this, view);
            }
        });
        GiftWallInfoAboutModel giftWallInfoAboutModel2 = this.b;
        Integer valueOf = giftWallInfoAboutModel2 == null ? null : Integer.valueOf(giftWallInfoAboutModel2.getItem());
        if (valueOf != null && valueOf.intValue() == 0) {
            GiftWallInfoAboutModel giftWallInfoAboutModel3 = this.b;
            if (giftWallInfoAboutModel3 == null || (allDa3 = giftWallInfoAboutModel3.getAllDa()) == null || (badge = allDa3.getBadge()) == null) {
                return;
            }
            ImageLoader.a(a(), badge.getImage()).a(g().a);
            g().f.setText(badge.getName());
            TextView textView = g().g;
            GiftWallInfoAboutModel f = f();
            if (f == null) {
                name3 = null;
            } else {
                YYCollectorConfigMode allDa4 = f.getAllDa();
                name3 = allDa4 == null ? null : allDa4.getName();
            }
            textView.setText(Intrinsics.a(name3, (Object) "专属勋章"));
            g().e.setText("解锁后会出现在该用户个人资料卡的勋章墙");
        } else if (valueOf != null && valueOf.intValue() == 1) {
            GiftWallInfoAboutModel giftWallInfoAboutModel4 = this.b;
            if (giftWallInfoAboutModel4 == null || (allDa2 = giftWallInfoAboutModel4.getAllDa()) == null || (skin2 = allDa2.getSkin()) == null) {
                return;
            }
            ImageLoader.a(a(), skin2.getIntroduce()).a(g().a);
            g().f.setText(skin2.getName());
            TextView textView2 = g().g;
            GiftWallInfoAboutModel f2 = f();
            if (f2 == null) {
                name2 = null;
            } else {
                YYCollectorConfigMode allDa5 = f2.getAllDa();
                name2 = allDa5 == null ? null : allDa5.getName();
            }
            textView2.setText(Intrinsics.a(name2, (Object) "专属皮肤"));
            g().e.setText("解锁后，该用户的礼物墙会佩戴上该皮肤");
        } else if (valueOf == null || valueOf.intValue() != 2 || (giftWallInfoAboutModel = this.b) == null || (allDa = giftWallInfoAboutModel.getAllDa()) == null || (goods = allDa.getGoods()) == null) {
        } else {
            ImageLoader.a(a(), goods.getImage_static()).a(g().a);
            g().f.setText(goods.getName());
            TextView textView3 = g().g;
            GiftWallInfoAboutModel f3 = f();
            if (f3 == null) {
                name = null;
            } else {
                YYCollectorConfigMode allDa6 = f3.getAllDa();
                name = allDa6 == null ? null : allDa6.getName();
            }
            textView3.setText(Intrinsics.a(name, (Object) "专属礼物"));
            g().e.setText("解锁后，该礼物只允许在该用户开播的房间里送出");
        }
    }

    public final void a(GiftWallInfoAboutModel giftWallInfoAboutModel) {
        this.b = giftWallInfoAboutModel;
    }

    public final GiftWallInfoAboutModel f() {
        return this.b;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        this.a = DialogGiftwallAboutInfoBinding.a(inflater.inflate(R.layout.dialog_giftwall_about_info, viewGroup, true));
        h();
        return g().getRoot();
    }
}
