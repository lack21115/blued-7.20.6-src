package com.blued.android.module.live_china.mine.backpack;

import android.os.Bundle;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.common.model.CommonGiftPackageModel;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.jeremyliao.liveeventbus.LiveEventBus;
import javax.annotation.Nonnull;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/mine/backpack/LiveGiftBackpackParentFragment.class */
public class LiveGiftBackpackParentFragment extends BaseGiftBagParentFragment<LiveGiftModel> {
    @Override // com.blued.android.module.live_china.mine.backpack.BaseGiftBagParentFragment
    protected BaseFragment a(int i, @Nonnull Bundle bundle) {
        return new LiveGiftBackpackPageFragment();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.module.live_china.mine.backpack.BaseGiftBagParentFragment
    public void b() {
        super.b();
        CommonGiftPackageModel c2 = c();
        if (c2 != null) {
            if (c2.packageType == 10) {
                this.d.setText("可通过参加活动获得头像框哦");
            } else if (c2.packageType == 9) {
                this.d.setText("可通过参加活动获得公聊气泡哦");
            } else if (c2.packageType == 11) {
                this.d.setText("可通过参加活动获得座驾哦");
            } else if (c2.packageType == 7) {
                this.d.setText("暂无生效中道具");
            } else if (c2.packageType == 8) {
                this.d.setText("暂未获得道具");
            } else if (c2.packageType == 12) {
                this.d.setText("可通过参加活动获得公聊角标哦");
            } else if (c2.packageType == 13) {
                this.d.setText("暂未获得碎片");
            }
        }
    }

    public void c(int i) {
        if (i < this.j.size()) {
            this.h.setCurrentItem(i);
        }
    }

    public void g() {
        if (this.j == null) {
            return;
        }
        if (this.j.size() <= 0 || this.j.get(0) == null) {
            LiveEventBus.get("live_gift_backpack_pager_send_status").post(false);
            LiveEventBus.get("gift_backpack_renew_clicked").post(false);
            return;
        }
        LiveGiftBackpackPageFragment liveGiftBackpackPageFragment = (LiveGiftBackpackPageFragment) this.j.get(0);
        if (liveGiftBackpackPageFragment.b == null || liveGiftBackpackPageFragment.b.getDataList() == null || liveGiftBackpackPageFragment.b.getDataList().size() <= 0) {
            return;
        }
        liveGiftBackpackPageFragment.b(liveGiftBackpackPageFragment.b.getDataList().get(0));
    }

    public void h() {
        if (this.j == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.j.size()) {
                return;
            }
            LiveGiftBackpackPageFragment liveGiftBackpackPageFragment = (LiveGiftBackpackPageFragment) this.j.get(i2);
            if (liveGiftBackpackPageFragment.b == null || liveGiftBackpackPageFragment.b.getDataList() == null) {
                return;
            }
            liveGiftBackpackPageFragment.b.notifyDataSetChanged();
            i = i2 + 1;
        }
    }

    @Override // com.blued.android.module.live_china.mine.backpack.BaseGiftBagParentFragment, com.blued.android.module.live_china.mine.backpack.BaseViewBakPagerParentFragment, com.blued.android.framework.ui.SimpleFragment
    public void onInitView() {
        super.onInitView();
    }
}
