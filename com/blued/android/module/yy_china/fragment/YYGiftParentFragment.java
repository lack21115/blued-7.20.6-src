package com.blued.android.module.yy_china.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.viewpager.widget.ViewPager;
import com.amap.api.fence.GeoFence;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.common.fragment.BaseGiftParentFragment;
import com.blued.android.module.common.model.CommonGiftPackageModel;
import com.blued.android.module.live.base.model.CommonLiveGiftModel;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.model.YYGiftModel;
import com.blued.android.module.yy_china.model.YYGiftPackageModel;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.List;
import javax.annotation.Nonnull;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYGiftParentFragment.class */
public class YYGiftParentFragment extends BaseGiftParentFragment<CommonLiveGiftModel> {
    @Override // com.blued.android.module.common.fragment.BaseGiftParentFragment
    public BaseFragment a(int i, @Nonnull Bundle bundle) {
        return new YYGiftPageFragment();
    }

    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        Logger.e(GeoFence.BUNDLE_KEY_FENCESTATUS, "YYGiftParentFragment onHiddenChanged ... ");
    }

    @Override // com.blued.android.module.common.fragment.BaseGiftParentFragment, com.blued.android.module.common.fragment.BaseViewPagerParentFragment
    public void onInitView() {
        CommonGiftPackageModel c;
        super.onInitView();
        this.a.setSelectedImgRes(R.drawable.icon_gift_page_selected);
        try {
            c = c();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (c == null || !(c instanceof YYGiftPackageModel)) {
            return;
        }
        if (TextUtils.equals(((YYGiftPackageModel) c).type_id, YYGiftPackageModel.YY_GIFT_BAG_TYPE_ID)) {
            this.c.setVisibility(8);
            this.d.setText("背包还是空的哦～");
        }
        this.h.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.blued.android.module.yy_china.fragment.YYGiftParentFragment.1
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f, int i2) {
            }

            public void onPageSelected(int i) {
                LogUtils.d("sendGiftEvent", "onPageSelected packageIndex: " + YYGiftParentFragment.this.e);
                YYGiftParentFragment.this.a.b(i);
                List a = YYGiftParentFragment.this.a(i);
                if (a == null) {
                    return;
                }
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= a.size()) {
                        return;
                    }
                    if (a.get(i3) instanceof YYGiftModel) {
                        LiveEventBus.get("show_gift_item").post((YYGiftModel) a.get(i3));
                    }
                    i2 = i3 + 1;
                }
            }
        });
    }
}
