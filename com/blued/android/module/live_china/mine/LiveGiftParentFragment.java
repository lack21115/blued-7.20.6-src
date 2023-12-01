package com.blued.android.module.live_china.mine;

import android.os.Bundle;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.common.fragment.BaseGiftParentFragment;
import com.blued.android.module.common.model.CommonGiftPackageModel;
import com.blued.android.module.live_china.model.LiveGiftModel;
import javax.annotation.Nonnull;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/mine/LiveGiftParentFragment.class */
public class LiveGiftParentFragment extends BaseGiftParentFragment<LiveGiftModel> {
    @Override // com.blued.android.module.common.fragment.BaseGiftParentFragment
    public BaseFragment a(int i, @Nonnull Bundle bundle) {
        return new LiveGiftPageFragment();
    }

    @Override // com.blued.android.module.common.fragment.BaseGiftParentFragment
    public void b() {
        super.b();
        CommonGiftPackageModel c2 = c();
        if (c2 != null) {
            if (c2.packageType == 3) {
                this.d.setText("还没有头像框哦");
            } else if (c2.packageType == 4) {
                this.d.setText("还没有公聊气泡哦");
            }
        }
    }
}
