package com.blued.android.module.yy_china.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.viewpager.widget.ViewPager;
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

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        Logger.e("event", "YYGiftParentFragment onHiddenChanged ... ");
    }

    @Override // com.blued.android.module.common.fragment.BaseGiftParentFragment, com.blued.android.module.common.fragment.BaseViewPagerParentFragment, com.blued.android.framework.ui.SimpleFragment
    public void onInitView() {
        CommonGiftPackageModel c2;
        super.onInitView();
        this.f10808a.setSelectedImgRes(R.drawable.icon_gift_page_selected);
        try {
            c2 = c();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (c2 == null || !(c2 instanceof YYGiftPackageModel)) {
            return;
        }
        if (TextUtils.equals(((YYGiftPackageModel) c2).type_id, "-1")) {
            this.f10809c.setVisibility(8);
            this.d.setText("背包还是空的哦～");
        }
        this.h.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.blued.android.module.yy_china.fragment.YYGiftParentFragment.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                LogUtils.d("sendGiftEvent", "onPageSelected packageIndex: " + YYGiftParentFragment.this.e);
                YYGiftParentFragment.this.f10808a.b(i);
                List a2 = YYGiftParentFragment.this.a(i);
                if (a2 == null) {
                    return;
                }
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= a2.size()) {
                        return;
                    }
                    if (a2.get(i3) instanceof YYGiftModel) {
                        LiveEventBus.get("show_gift_item").post((YYGiftModel) a2.get(i3));
                    }
                    i2 = i3 + 1;
                }
            }
        });
    }
}
