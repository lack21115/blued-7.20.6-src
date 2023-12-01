package com.blued.android.module.yy_china.fragment;

import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.android.ims.ImsConferenceState;
import com.blued.android.module.live.base.constants.LiveEventBusConstant;
import com.blued.android.module.yy_china.adapter.GiftExhibitionAdapter;
import com.blued.android.module.yy_china.model.YYGoodsWallMode;
import com.blued.android.module.yy_china.model.YYUserInfo;
import com.blued.android.module.yy_china.view.YYGiftWallInfoDialog;
import com.jeremyliao.liveeventbus.LiveEventBus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYGiftExhibitionAllFragment$initView$2.class */
public final class YYGiftExhibitionAllFragment$initView$2 implements GiftExhibitionAdapter.ClickGiftListener {
    final /* synthetic */ YYGiftExhibitionAllFragment a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public YYGiftExhibitionAllFragment$initView$2(YYGiftExhibitionAllFragment yYGiftExhibitionAllFragment) {
        this.a = yYGiftExhibitionAllFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYGiftExhibitionAllFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        DialogFragment parentFragment = this$0.getParentFragment();
        if (parentFragment == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.DialogFragment");
        }
        parentFragment.dismissAllowingStateLoss();
        LiveEventBus.get(LiveEventBusConstant.d).post("");
    }

    @Override // com.blued.android.module.yy_china.adapter.GiftExhibitionAdapter.ClickGiftListener
    public void a(boolean z, YYUserInfo yYUserInfo, YYGoodsWallMode yYGoodsWallMode) {
        YYUserInfo yYUserInfo2;
        YYGiftWallInfoDialog yYGiftWallInfoDialog = new YYGiftWallInfoDialog();
        yYGiftWallInfoDialog.a(z);
        yYUserInfo2 = this.a.f;
        YYUserInfo yYUserInfo3 = yYUserInfo2;
        if (yYUserInfo2 == null) {
            Intrinsics.c(ImsConferenceState.USER);
            yYUserInfo3 = null;
        }
        yYGiftWallInfoDialog.a(yYUserInfo3);
        yYGiftWallInfoDialog.a(yYGoodsWallMode);
        final YYGiftExhibitionAllFragment yYGiftExhibitionAllFragment = this.a;
        yYGiftWallInfoDialog.a(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYGiftExhibitionAllFragment$initView$2$-CYdZyWkiNPtAJmonGeBXr06TGI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYGiftExhibitionAllFragment$initView$2.a(YYGiftExhibitionAllFragment.this, view);
            }
        });
        FragmentManager childFragmentManager = this.a.getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        yYGiftWallInfoDialog.show(childFragmentManager, "YYGiftWallInfoDialog");
    }
}
