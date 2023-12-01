package com.blued.android.module.live_china.fitem.randomgift;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.RandomGiftItemModel;
import com.blued.android.module.live_china.view.UserCardDialogFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/randomgift/FitemRandomGiftHostPowerItem.class */
public final class FitemRandomGiftHostPowerItem extends FreedomItem {
    private RandomGiftItemModel b;

    public FitemRandomGiftHostPowerItem(RandomGiftItemModel model) {
        Intrinsics.e(model, "model");
        this.b = model;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FitemRandomGiftHostPowerItem this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        BaseFragment baseFragment = (BaseFragment) this$0.a.a.a("BaseFragment", (String) null);
        if (baseFragment == null) {
            return;
        }
        UserCardDialogFragment userCardDialogFragment = new UserCardDialogFragment(baseFragment);
        userCardDialogFragment.e(this$0.e().getUid());
        FragmentManager fragmentManager = baseFragment.getFragmentManager();
        if (fragmentManager == null) {
            return;
        }
        userCardDialogFragment.show(fragmentManager, "userCardDialog");
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_random_gift_host_power_item;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, BaseViewHolder vh, List<FreedomItem> list, int i) {
        Intrinsics.e(vh, "vh");
        vh.a(R.id.iv_avatar, this.b.getAvatar(), R.drawable.user_bg_round, true).a(R.id.tv_name, (CharSequence) this.b.getName()).a(R.id.tv_name, true).a(R.id.tv_count, true).a(R.id.tv_count, (CharSequence) AppInfo.d().getString(R.string.live_random_gift_host_tab_chance_count_num, Integer.valueOf(this.b.getRemain_count()))).a(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fitem.randomgift.-$$Lambda$FitemRandomGiftHostPowerItem$OeCTqUQP0xOKz48KrpQYFntbKK4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FitemRandomGiftHostPowerItem.a(FitemRandomGiftHostPowerItem.this, view);
            }
        });
    }

    public final RandomGiftItemModel e() {
        return this.b;
    }
}
