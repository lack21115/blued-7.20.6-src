package com.blued.android.module.live_china.fitem.randomgift;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentManager;
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
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/randomgift/FitemRandomGiftHostRecordItem.class */
public final class FitemRandomGiftHostRecordItem extends FreedomItem {
    private RandomGiftItemModel b;

    public FitemRandomGiftHostRecordItem(RandomGiftItemModel model) {
        Intrinsics.e(model, "model");
        this.b = model;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FitemRandomGiftHostRecordItem this$0, View view) {
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
        return R.layout.fitem_random_gift_host_record_item;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, BaseViewHolder vh, List<FreedomItem> list, int i) {
        Intrinsics.e(vh, "vh");
        vh.a(R.id.tv_time, (CharSequence) this.b.getTime()).a(R.id.iv_avatar, this.b.getAvatar(), R.drawable.user_bg_round, true).a(R.id.tv_name, (CharSequence) this.b.getName()).a(R.id.tv_name, true).a(R.id.tv_desc, true).a(R.id.tv_desc, (CharSequence) this.b.getReward_type()).a(R.id.ll_user, new View.OnClickListener() { // from class: com.blued.android.module.live_china.fitem.randomgift.-$$Lambda$FitemRandomGiftHostRecordItem$xqQoeFPTQ2VvVE96gjvHrTPOaHo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FitemRandomGiftHostRecordItem.a(FitemRandomGiftHostRecordItem.this, view);
            }
        });
    }

    public final RandomGiftItemModel e() {
        return this.b;
    }
}
